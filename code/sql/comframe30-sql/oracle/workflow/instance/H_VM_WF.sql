/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/19 11:00:35                           */
/*==============================================================*/


/*==============================================================*/
/* Table: H_VM_WF                                               */
/*==============================================================*/
create table H_VM_WF  (
   WORKFLOW_ID          VARCHAR2(25)                    not null,
   TEMPLATE_VERSION_ID  NUMBER(15,0),
   QUEUE_ID             VARCHAR2(5),
   ENGINE_WORKFLOW_ID   VARCHAR2(255),
   ENGINE_TYPE          VARCHAR2(255),
   WORKFLOW_TYPE        VARCHAR2(255),
   TEMPLATE_TAG         VARCHAR2(255),
   PARENT_TASK_ID       VARCHAR2(25),
   WORKFLOW_KIND        NUMBER(2,0),
   STATE                NUMBER(2,0),
   SUSPEND_STATE        NUMBER(2,0),
   STATE_DATE           DATE,
   WORKFLOW_OBJECT_ID   VARCHAR2(255),
   WORKFLOW_OBJECT_TYPE VARCHAR2(255),
   USER_TASK_COUNT      NUMBER(15,0),
   CURRENT_TASK_ID      VARCHAR2(255),
   DURATION             NUMBER(15,0),
   CREATE_STAFF_ID      VARCHAR2(30),
   CREATE_DATE          DATE,
   START_DATE           DATE,
   FINISH_DATE          DATE,
   LABEL                VARCHAR2(255),
   DESCRIPTION          VARCHAR2(512),
   VARS                 VARCHAR2(4000),
   OP_STAFF_ID          VARCHAR2(30),
   ERROR_COUNT          NUMBER(3,0),
   ERROR_MESSAGE        VARCHAR2(4000),
   WARNING_DATE         DATE,
   WARNING_TIMES        NUMBER(2,0),
   REGION_ID            VARCHAR2(6),
   TRANSFER_DATE        DATE
);

comment on column H_VM_WF.WORKFLOW_ID is
'工作流编号';

comment on column H_VM_WF.TEMPLATE_VERSION_ID is
'工作流模版编号';

comment on column H_VM_WF.QUEUE_ID is
'流程队列';

comment on column H_VM_WF.ENGINE_WORKFLOW_ID is
'流程引擎的流程实例编号';

comment on column H_VM_WF.ENGINE_TYPE is
'引擎类型';

comment on column H_VM_WF.WORKFLOW_TYPE is
'''流程模板类型:PROCESS/WORKFLOW';

comment on column H_VM_WF.TEMPLATE_TAG is
'任务标志';

comment on column H_VM_WF.PARENT_TASK_ID is
'父工作流任务，用于子工作流';

comment on column H_VM_WF.WORKFLOW_KIND is
'流程类型:-1=主流程，1=子流程,2=异常子流程';

comment on column H_VM_WF.STATE is
'状态 1-不能调度 2-可以调度 3-已经完成 4-终止 5-人工处理 7-等待外部事件触发 8-过期作废 99-系统异常';

comment on column H_VM_WF.SUSPEND_STATE is
'状态 1-挂起 2-可以调度';

comment on column H_VM_WF.STATE_DATE is
'状态时间';

comment on column H_VM_WF.WORKFLOW_OBJECT_ID is
'工作流处理对象编号';

comment on column H_VM_WF.WORKFLOW_OBJECT_TYPE is
'工作流处理对象类型';

comment on column H_VM_WF.USER_TASK_COUNT is
'人工任务数量';

comment on column H_VM_WF.CURRENT_TASK_ID is
'当前任务';

comment on column H_VM_WF.DURATION is
'任务时限';

comment on column H_VM_WF.CREATE_STAFF_ID is
'创建人';

comment on column H_VM_WF.CREATE_DATE is
'创建时间';

comment on column H_VM_WF.START_DATE is
'流程定时的启动时间';

comment on column H_VM_WF.FINISH_DATE is
'完成时间';

comment on column H_VM_WF.LABEL is
'工作流主题';

comment on column H_VM_WF.DESCRIPTION is
'工作流描述';

comment on column H_VM_WF.VARS is
'实例变量';

comment on column H_VM_WF.ERROR_MESSAGE is
'错误信息';

comment on column H_VM_WF.WARNING_DATE is
'告警时间';

comment on column H_VM_WF.WARNING_TIMES is
'告警次数';

comment on column H_VM_WF.REGION_ID is
'地域信息';

comment on column H_VM_WF.TRANSFER_DATE is
'移历史时间';

alter table H_VM_WF
   add constraint PK_H_VM_WF primary key (WORKFLOW_ID);

/*==============================================================*/
/* Index: IDX_H_W_OID                                           */
/*==============================================================*/
create index IDX_H_W_OID on H_VM_WF (
   WORKFLOW_OBJECT_ID ASC
);

