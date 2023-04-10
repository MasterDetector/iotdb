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

public class CpuMetricsConstant {
  public static final String DATA_NODE = "datanode";
  public static final String CONFIG_NODE = "confignode";
  public static final String[] DATA_NODE_MODULES =
      new String[] {"query", "write", "flush", "compaction", "consensus", "metadata", "sync"};
  public static final String[] CONFIG_NODE_MODULES = new String[] {"consensus", "rpc"};

  // thread name
  // --------------------------  QueryThreads  --------------------------
  public static final String QUERY_WORKER_THREAD_PREFIX = "Query-Worker-Thread";
  public static final String QUERY_SENTINEL_THREAD_PREFIX = "Query-Sentinel-Thread";
  public static final String DATA_NODE_INTERNAL_RPC_SERVICE_THREAD_NAME =
      "DataNodeInternalRPC-Service";
  public static final String DATA_NODE_INTERNAL_RPC_PROCESSOR_THREAD_NAME =
      "DataNodeInternalRPC-Processor";
  public static final String MPP_DATA_EXCHANGE_RPC_SERVICE_THREAD_NAME =
      "MPPDataExchangeRPC-Service";
  public static final String MPP_DATA_EXCHANGE_RPC_PROCESSOR_THREAD_NAME =
      "MPPDataExchangeRPC-Processor";
  public static final String MPP_DATA_EXCHANGE_EXECUTOR_THREAD_NAME =
      "mpp-data-exchange-task-executors";
  public static final String FRAGMENT_INSTANCE_MANAGEMENT_THREAD_NAME = "instance-management";
  public static final String FRAGMENT_INSTANCE_NOTIFICATION_THREAD_NAME = "instance-notification";

  // --------------------------  ConsensusThreads  --------------------------

}
