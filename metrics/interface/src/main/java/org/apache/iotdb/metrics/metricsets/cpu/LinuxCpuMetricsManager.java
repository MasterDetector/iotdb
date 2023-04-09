/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.iotdb.metrics.metricsets.cpu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LinuxCpuMetricsManager implements ICpuMetricsManager {
  private static final Logger log = LoggerFactory.getLogger(LinuxCpuMetricsManager.class);
  private final String processName;
  private final String pid;
  private final String[] modules;

  @SuppressWarnings("squid:S1075")
  private static final String SYSTEM_STAT_FILE = "/proc/stat";

  @SuppressWarnings("squid:S1075")
  private static final String THREAD_STAT_FILE = "/proc/%s/stat";

  @SuppressWarnings("squid:S1075")
  private String collectThreadIdsPath = "/proc/%s/task";

  public LinuxCpuMetricsManager(String processName, String[] modules) {
    this.processName = processName;
    this.modules = modules;
    this.pid = String.valueOf(Thread.currentThread().getId());
    this.collectThreadIdsPath = String.format(collectThreadIdsPath, pid);
  }

  @Override
  public Map<String, Double> getCpuUsage() {
    return null;
  }

  /**
   * Get the total CPU time of system.
   *
   * @return the total CPU time of system
   */
  private long getCpuTimeForSystem() {
    try {
      String statLine = Files.readAllLines(Paths.get(SYSTEM_STAT_FILE)).get(0);
      String[] cpuInfo = statLine.split("\\s+");
      long totalCpuTime = 0;
      for (int i = 1; i < cpuInfo.length; i++) {
        totalCpuTime += Long.parseLong(cpuInfo[i]);
      }
      return totalCpuTime;
    } catch (IOException e) {
      log.error("Cannot read file {}", SYSTEM_STAT_FILE, e);
      // do not return 0 to avoid divide by 0
      return 1;
    }
  }

  /**
   * Collect all threads of this process, and map them to their thread name.
   *
   * @return a map from thread id to thread name
   */
  private Map<String, String> collectAllThreads() {
    File threadsDirectory = new File(collectThreadIdsPath);
    if (!threadsDirectory.exists()) {
      log.error("Cannot find directory {}", collectThreadIdsPath);
      return Collections.emptyMap();
    }

    File[] threadFiles = threadsDirectory.listFiles();
    if (threadFiles == null || threadFiles.length == 0) {
      return Collections.emptyMap();
    }

    // Leaving one free space to avoid rehashing
    Map<String, String> resultMap = new HashMap<>(threadFiles.length + 1, 1);
    ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
    for (File threadFile : threadFiles) {
      String threadId = threadFile.getName();
      String threadName = threadMXBean.getThreadInfo(Long.parseLong(threadId)).getThreadName();
      resultMap.put(threadId, threadName);
    }
    return resultMap;
  }

  /**
   * Collect the cpu time for all thread in this process.
   *
   * @return a map from thread id to cpu time
   */
  private Map<String, Long> collectCpuTimeForPerThread(Set<String> threadIds) {
    return null;
  }
}
