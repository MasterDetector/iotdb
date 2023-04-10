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
      new String[] {
        "query", "write", "flush", "compaction", "consensus", "metadata", "client", "compile", "gc"
      };
  public static final String[] CONFIG_NODE_MODULES =
      new String[] {"consensus", "rpc", "compile", "gc"};

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
  public static final String MPP_COORDINATOR_THREAD_NAME = "MPPCoordinator";
  public static final String MPP_COORDINATOR_SCHEDULE_THREAD_NAME = "MPPCoordinatorScheduled";
  public static final String FRAGMENT_INSTANCE_MANAGEMENT_THREAD_NAME = "instance-management";
  public static final String FRAGMENT_INSTANCE_NOTIFICATION_THREAD_NAME = "instance-notification";
  public static final String TIMED_QUERY_COUNT_THREAD_NAME = "timedQuerySqlCount";

  // --------------------------  RatisConsensusThreads  --------------------------
  public static final String RAFT_SERVER_PROXY_EXECUTOR_THREAD_NAME_PATTERN = "\\d+-impl";
  public static final String JVM_PAUSE_MONITOR_THREAD_NAME = "JvmPauseMonitor";
  public static final String RAFT_SERVER_EXECUTOR_THREAD_NAME_PATTERN = "\\d+-server";
  public static final String RAFT_SERVER_CLIENT_EXECUTOR_THREAD_NAME_PATTERN = "\\d+-client";
  public static final String SEGMENT_RAFT_WORKER_THREAD_NAME_PATTERN =
      "\\d+-SegmentedRaftLogWorker";
  public static final String STATE_MACHINE_UPDATER_THREAD_NAME_PATTERN = "\\d+-StateMachineUpdater";
  public static final String FOLLOWER_STATE_THREAD_NAME_PATTERN = "\\d+-FollowerState";
  public static final String LEADER_STATE_IMPL_PROCESSOR_THREAD_NAME = "LeaderStateImpl";
  public static final String LEADER_ELECTION_THREAD_NAME_PATTERN = "\\d+-LeaderElection";
  public static final String LOG_APPENDER_THREAD_NAME_PATTERN = "\\d+-GrpcLogAppender";
  public static final String LEADER_STATE_IMPL_PROCESSOR_THREAD_NAME_PATTERN =
      "\\d+-EventProcessor";
  public static final String RATIS_BG_DISK_GUARDIAN_THREAD_NAME_PATTERN = "ratis-bg-disk-guardian";
  public static final String GRPC_DEFAULT_BOSS_ELG = "grpc-default-boss-ELG";

  // TODO: Add IoTConsensus Threads

  // --------------------------  CompactionThreads  --------------------------
  public static final String COMPACTION_EXECUTOR_THREAD_NAME = "IoTDB-Compaction";
  public static final String COMPACTION_SUB_TASK_THREAD_NAME = "IoTDB-Sub-Compaction";
  public static final String COMPACTION_SCHEDULER_THREAD_NAME = "IoTDB-Compaction_Scheduler";

  // --------------------------  FlushThreads  --------------------------
  public static final String FLUSH_THREAD_NAME_PATTERN = "Flush";
  public static final String FLUSH_SUB_TASK_THREAD_NAME_PATTERN = "Flush-SubTask";
  public static final String TIMED_FLUSH_THREAD_NAME_PATTERN = "Timed-Flush";
  public static final String TTL_CHECKED_THREAD_NAME_PATTERN = "TTL-Check";

  // --------------------------  WalThreads  --------------------------
  public static final String WAL_SERIALIZED_THREAD_NAME = "WAL-Serialize";
  public static final String WAL_SYNC_THREAD_NAME = "WAL-Sync";
  public static final String WAL_DELETE_THREAD_NAME = "WAL-Delete";
  public static final String WAL_RECOVER_THREAD_NAME = "WAL-Recover";

  // --------------------------  MetadataThreads  --------------------------
  public static final String SCHEMA_ENGINE_RECOVER_THREAD_PATTERN = "SchemaRegion-Recover-Task";
  public static final String MTREE_FLUSH_TASK_THREAD_PATTERN = "MTree-Flush-Task";
  public static final String MTREE_RELEASE_TASK_THREAD_PATTERN = "MTree-Release-Task";

  // --------------------------  ClientThreads  --------------------------
  public static final String CLIENT_RCP_THREAD_NAME = "ClientRPC-Processor";

  // --------------------------  LogBackThreads  --------------------------
  public static final String LOGBACK_THREAD_NAME = "logback";

  // --------------------------  CompileThreads  --------------------------
  public static final String COMPILE_THREAD_NAME = "CompilerThread";
  // --------------------------  GcThreads  --------------------------
  public static final String GC_THREAD_NAME = "GC task thread";
}
