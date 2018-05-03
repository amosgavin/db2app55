/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/19 11:00:35                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_SCHEDULE                                           */
/*==============================================================*/
create table VM_SCHEDULE  (
   WORKFLOW_ID          VARCHAR2(25)                    not null,
   QUEUE_ID             VARCHAR2(5),
   ENGINE_WORKFLOW_ID   VARCHAR2(255),
   ENGINE_TYPE          VARCHAR2(255),
   CREATE_DATE          DATE,
   STATE_DATE           DATE,
   START_DATE           DATE,
   STATE                VARCHAR2(10),
   SCHEDULE_DATE        DATE,
   DEV_ID               VARCHAR2(5),
   REGION_ID            VARCHAR2(6)
);

comment on column VM_SCHEDULE.WORKFLOW_ID is
'工作流编号';

comment on column VM_SCHEDULE.QUEUE_ID is
'队列编号';

comment on column VM_SCHEDULE.ENGINE_WORKFLOW_ID is
'流程引擎的流程实例编号';

comment on column VM_SCHEDULE.ENGINE_TYPE is
'引擎类型';

comment on column VM_SCHEDULE.CREATE_DATE is
'创建时间';

comment on column VM_SCHEDULE.STATE_DATE is
'加入调度时间';

comment on column VM_SCHEDULE.START_DATE is
'流程定时的启动时间';

comment on column VM_SCHEDULE.STATE is
'调度状态：W-等待调度,S-进入调度机,F-调度结束,A-进入异常调度';

comment on column VM_SCHEDULE.SCHEDULE_DATE is
'开始调度时间';

comment on column VM_SCHEDULE.DEV_ID is
'开发者标识(开发模式时有意义)';

comment on column VM_SCHEDULE.REGION_ID is
'地域信息';

alter table VM_SCHEDULE
   add constraint PK_VM_SCHE primary key (WORKFLOW_ID);

