/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/19 11:00:35                           */
/*==============================================================*/


/*==============================================================*/
/* Table: H_VM_TASK_TS                                          */
/*==============================================================*/
create table H_VM_TASK_TS  (
   TASK_ID              VARCHAR(25)                    not null,
   PARENT_TASK_ID       VARCHAR(25),
   WORKFLOW_ID          VARCHAR(25),
   QUEUE_ID             VARCHAR(5),
   TASK_TEMPLATE_ID     BIGINT,
   DEST_TASK_TEMPLATE_ID BIGINT,
   DEST_TYPE            CHAR(1),
   TASK_TYPE            VARCHAR(255),
   TASK_BASE_TYPE       VARCHAR(255),
   TASK_TAG             VARCHAR(255),
   LABEL                VARCHAR(255),
   DURATION             BIGINT,
   DECISION_RESULT      VARCHAR(255),
   IS_CURRENT_TASK      CHAR(1),
   STATE                INTEGER,
   STATE_DATE           TIMESTAMP,
   CREATE_DATE          TIMESTAMP,
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
   REGION_ID            VARCHAR(6),
   TRANSFER_DATE        TIMESTAMP
);

comment on column H_VM_TASK_TS.TASK_ID is
'任务编号';

comment on column H_VM_TASK_TS.PARENT_TASK_ID is
'上级任务编号';

comment on column H_VM_TASK_TS.WORKFLOW_ID is
'流程编号';

comment on column H_VM_TASK_TS.QUEUE_ID is
'流程队列';

comment on column H_VM_TASK_TS.TASK_TEMPLATE_ID is
'任务模版编号';

comment on column H_VM_TASK_TS.DEST_TASK_TEMPLATE_ID is
'跳转或者回退时，目的任务标识';

comment on column H_VM_TASK_TS.DEST_TYPE is
'操作类型：J-跳转;G-回退';

comment on column H_VM_TASK_TS.TASK_TYPE is
'任务类型';

comment on column H_VM_TASK_TS.TASK_TAG is
'任务标志';

comment on column H_VM_TASK_TS.LABEL is
'任务主题';

comment on column H_VM_TASK_TS.DURATION is
'任务时限';

comment on column H_VM_TASK_TS.DECISION_RESULT is
'判断结果';

comment on column H_VM_TASK_TS.IS_CURRENT_TASK is
'是否当前任务';

comment on column H_VM_TASK_TS.STATE is
'任务状态 1-不能调度 2-可以调度 3-已经完成 4-终止 9-等待打单 5-人工处理 6-处理失败 7-等待外部事件触发 8-过期作废 99-系统异常 21-已经回复流程引擎任务单';

comment on column H_VM_TASK_TS.STATE_DATE is
'状态时间';

comment on column H_VM_TASK_TS.CREATE_DATE is
'创建时间';

comment on column H_VM_TASK_TS.STATION_ID is
'任务岗位';

comment on column H_VM_TASK_TS.TASK_STAFF_ID is
'任务人员';

comment on column H_VM_TASK_TS.LOCK_STAFF_ID is
'锁定员工';

comment on column H_VM_TASK_TS.LOCK_DATE is
'锁定时间';

comment on column H_VM_TASK_TS.FINISH_STAFF_ID is
'完成人员';

comment on column H_VM_TASK_TS.FINISH_DATE is
'完成时间';

comment on column H_VM_TASK_TS.ERROR_MESSAGE is
'错误信息';

comment on column H_VM_TASK_TS.DESCRIPTION is
'任务描述';

comment on column H_VM_TASK_TS.REGION_ID is
'地域信息';

comment on column H_VM_TASK_TS.TRANSFER_DATE is
'移历史时间';

alter table H_VM_TASK_TS
   add constraint PK_H_VM_T_T primary key (TASK_ID);

/*==============================================================*/
/* Index: IDX_H_T_T_WID                                         */
/*==============================================================*/
create index IDX_H_T_T_WID on H_VM_TASK_TS (
   WORKFLOW_ID ASC
);

