/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:48:22                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_WF                                                 */
/*==============================================================*/
create table VM_WF
(
   WORKFLOW_ID          varchar(25) not null comment '工作流编号',
   TEMPLATE_VERSION_ID  numeric(15,0) comment '工作流模版编号',
   QUEUE_ID             varchar(5) comment '流程队列',
   ENGINE_WORKFLOW_ID   varchar(255) comment '流程引擎的流程实例编号',
   ENGINE_TYPE          varchar(255) comment '引擎类型',
   WORKFLOW_TYPE        varchar(255) comment '''流程模板类型:PROCESS/WORKFLOW',
   TEMPLATE_TAG         varchar(255) comment '任务标志',
   PARENT_TASK_ID       varchar(25) comment '父工作流任务，用于子工作流',
   WORKFLOW_KIND        numeric(2,0) comment '''流程类型:-1=主流程，1=子流程,2=异常子流程',
   STATE                numeric(2,0) comment '状态 1-不能调度 2-可以调度 3-已经完成 4-终止 5-人工处理 7-等待外部事件触发 8-过期作废 99-系统异常',
   SUSPEND_STATE        numeric(2,0) comment '状态 1-挂起 2-可以调度',
   STATE_DATE           datetime comment '状态时间',
   WORKFLOW_OBJECT_ID   varchar(50) comment '工作流处理对象编号',
   WORKFLOW_OBJECT_TYPE varchar(255) comment '工作流处理对象类型',
   USER_TASK_COUNT      numeric(15,0) comment '人工任务数量',
   CURRENT_TASK_ID      varchar(255) comment '当前任务',
   DURATION             numeric(15,0) comment '任务时限',
   CREATE_STAFF_ID      varchar(30) comment '创建人',
   CREATE_DATE          datetime comment '创建时间',
   START_DATE           datetime comment '流程定时的启动时间',
   FINISH_DATE          datetime comment '完成时间',
   LABEL		varchar(255) comment '工作流主题',
   DESCRIPTION          varchar(512) comment '工作流描述',
   VARS                 varchar(4000) comment '实例变量',
   OP_STAFF_ID          varchar(30),
   ERROR_COUNT          numeric(3,0),
   ERROR_MESSAGE        varchar(4000) comment '错误信息',
   WARNING_DATE         datetime comment '告警时间',
   WARNING_TIMES        numeric(2,0) comment '告警次数',
   REGION_ID            varchar(6) comment '地域信息'
);

alter table VM_WF
   add primary key (WORKFLOW_ID);

/*==============================================================*/
/* Index: IDX_WF_OID                                            */
/*==============================================================*/
create index IDX_WF_OID on VM_WF
(
   WORKFLOW_OBJECT_ID,
   WORKFLOW_OBJECT_TYPE
);

/*==============================================================*/
/* Index: IDX_WF_P_TID                                          */
/*==============================================================*/
create index IDX_WF_P_TID on VM_WF (
   PARENT_TASK_ID
);
