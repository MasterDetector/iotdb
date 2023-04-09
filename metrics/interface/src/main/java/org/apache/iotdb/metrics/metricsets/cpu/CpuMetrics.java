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

import org.apache.iotdb.metrics.AbstractMetricService;
import org.apache.iotdb.metrics.metricsets.IMetricSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CpuMetrics implements IMetricSet {
  private final ICpuMetricsManager cpuMetricsManager = ICpuMetricsManager.getCpuMetricsManager();
  private static final Logger log = LoggerFactory.getLogger(CpuMetrics.class);
  private final String processName;
  private static final String MODULE = "module";
  private static final String CPU_USAGE = "cpu_usage";
  private final String dataNode = "datanode";
  private final String configNode = "confignode";
  private final String[] dataNodeModules =
      new String[] {"query", "write", "flush", "compaction", "consensus", "metadata", "sync"};
  private final String[] configNodeModules = new String[] {"consensus", "rpc"};
  private final String[] modules;

  public CpuMetrics(String processName) {
    this.processName = processName;
    if (this.processName.equals(dataNode)) {
      this.modules = dataNodeModules;
    } else if (this.processName.equals(configNode)) {
      this.modules = configNodeModules;
    } else {
      log.error("Invalid process name: {}", processName);
      modules = new String[0];
    }
  }

  @Override
  public void bindTo(AbstractMetricService metricService) {}

  @Override
  public void unbindFrom(AbstractMetricService metricService) {}
}
