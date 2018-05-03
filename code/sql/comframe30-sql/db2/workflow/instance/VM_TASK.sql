/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/19 11:00:35                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_TASK                                               */
/*==============================================================*/
create table VM_TASK  (
   TASK_ID              VARCHAR(25)                    not null,
   LAST_TASK_ID         VARCHAR(500),
   WORKFLOW_ID          VARCHAR(25),
   QUEUE_ID             VARCHAR(5),
   TASK_TEMPLATE_ID     BIGINT,
   DEST_TASK_TEMPLATE_ID BIGINT,
   DEST_TYPE            CHAR(1),
   ENGINE_WORKFLOW_ID   VARCHAR(255),
   ENGINE_TASK_ID       VARCHAR(255),
   TASK_TYPE            VARCHAR(255),
   TASK_BASE_TYPE       VARCHAR(255),
   TASK_TAG             VARCHAR(255),
   CHILD_WORKFLOW_COUNT BIGINT,
   REMANENT_WORKFLOW_COUNT BIGINT,
   LABEL                VARCHAR(255),
   DURATION             BIGINT,
   DECISION_RESULT      VARCHAR(255),
   IS_CURRENT_TASK      CHAR(1),
   STATE                INTEGER,
   STATE_DATE           TIMESTAMP,
   CREATE_DATE          TIMESTAMP,
   EXE_FINISH_DATE      TIMESTAMP,
   STATION_ID           VARCHAR(30),
   TASK_STAFF_ID        VARCHAR(30),
   LOCK_STAFF_ID        VARCHAR(30),
   LOCK_DATE            TIMESTAMP,
   FINISH_STAFF_ID      VARCHAR(30),
   FINISH_DATE          TIMESTAMP,
   ERROR_MESSAGE        VARCHAR(4000),
   DESCRIPTION          VARCHAR(512),
   WARNING_DATE         TIMESTAMP,
   WARNING_TIMES        INTEGER,
   REGION_ID            VARCHAR(6)
);

comment on column VM_TASK.TASK_ID is
'任务编号';

comment on column VM_TASK.LAST_TASK_ID is
'派发当前任务的上一级任务';

comment on column VM_TASK.WORKFLOW_ID is
'工作流编号';

comment on column VM_TASK.QUEUE_ID is
'流程队列';

comment on column VM_TASK.TASK_TEMPLATE_ID is
'任务模版编号';

comment on column VM_TASK.DEST_TASK_TEMPLATE_ID is
'跳转或者回退时，目的任务标识';

comment on column VM_TASK.DEST_TYPE is
'操作类型：J-跳转;G-回退';

comment on column VM_TASK.ENGINE_TASK_ID is
'流程引擎的任务实例编号';

comment on column VM_TASK.TASK_TYPE is
'任务类型';

comment on column VM_TASK.TASK_BASE_TYPE is
'基础任务类型';

comment on column VM_TASK.TASK_TAG is
'任务标志';

comment on column VM_TASK.CHILD_WORKFLOW_COUNT is
'子流程数量';

comment on column VM_TASK.REMANENT_WORKFLOW_COUNT is
'未完成子流程数量';

comment on column VM_TASK.LABEL is
'任务主题';

comment on column VM_TASK.DURATION is
'任务时限';

comment on column VM_TASK.DECISION_RESULT is
'判断结果';

comment on column VM_TASK.IS_CURRENT_TASK is
'是否当前任务';

comment on column VM_TASK.STATE is
'任务状态 1-不能调度 2-可以调度 3-已经完成 4-终止 9-等待打单 5-人工处理 6-回退 7-等待外部事件触发 8-过期作废 99-系统异常 21-已经回复流程引擎任务单';

comment on column VM_TASK.STATE_DATE is
'状态时间';

comment on column VM_TASK.CREATE_DATE is
'创建时间';

comment on column VM_TASK.EXE_FINISH_DATE is
'人工任务前置任务执行完成时间';

comment on column VM_TASK.STATION_ID is
'任务岗位';

comment on column VM_TASK.TASK_STAFF_ID is
'任务人员';

comment on column VM_TASK.LOCK_STAFF_ID is
'锁定员工';

comment on column VM_TASK.LOCK_DATE is
'锁定时间';

comment on column VM_TASK.FINISH_STAFF_ID is
'完成人员';

comment on column VM_TASK.FINISH_DATE is
'完成时间';

comment on column VM_TASK.ERROR_MESSAGE is
'错误信息';

comment on column VM_TASK.DESCRIPTION is
'任务描述';

comment on column VM_TASK.WARNING_DATE is
'告警时间';

comment on column VM_TASK.WARNING_TIMES is
'告警次数';

comment on column VM_TASK.REGION_ID is
'地域信息';

alter table VM_TASK
   add constraint PK_VM_TASK primary key (TASK_ID);

/*==============================================================*/
/* Index: IDX_TA_WID                                            */
/*==============================================================*/
create index IDX_TA_WID on VM_TASK (
   WORKFLOW_ID ASC
);

