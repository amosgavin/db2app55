/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/19 11:00:35                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_DEAL_TASK                                          */
/*==============================================================*/
create table VM_DEAL_TASK  (
   DEAL_TASK_ID         VARCHAR2(25)                    not null,
   TASK_ID              VARCHAR2(25)                    not null,
   WORKFLOW_ID          VARCHAR2(25)                    not null,
   QUEUE_ID             VARCHAR2(5),
   DEAL_TYPE            VARCHAR2(10),
   RUNTIME              DATE,
   STATE                NUMBER(2,0),
   CREATE_DATE          DATE,
   DEV_ID               VARCHAR2(5),
   ERROR_MESSAGE        VARCHAR2(4000),
   REGION_ID            VARCHAR2(6)
);

comment on table VM_DEAL_TASK is
'定时任务';

comment on column VM_DEAL_TASK.TASK_ID is
'任务编号';

comment on column VM_DEAL_TASK.QUEUE_ID is
'队列编号';

comment on column VM_DEAL_TASK.DEAL_TYPE is
'处理类型：TIMER-定时器,PRINT-自动执行人工任务打印操作';

comment on column VM_DEAL_TASK.RUNTIME is
'任务执行时间';

comment on column VM_DEAL_TASK.STATE is
'处理状态 2-可以执行,99-系统错误';

comment on column VM_DEAL_TASK.CREATE_DATE is
'创建时间';

comment on column VM_DEAL_TASK.DEV_ID is
'开发者标识(开发模式时有意义)';

comment on column VM_DEAL_TASK.ERROR_MESSAGE is
'错误原因';

comment on column VM_DEAL_TASK.REGION_ID is
'地域信息';

alter table VM_DEAL_TASK
   add constraint PK_VM_DEAL_TASK primary key (DEAL_TASK_ID);

/*==============================================================*/
/* Index: IDX_D_T_WID                                           */
/*==============================================================*/
create index IDX_D_T_WID on VM_DEAL_TASK (
   WORKFLOW_ID ASC
);
