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
'��ʱ����';

comment on column VM_DEAL_TASK.TASK_ID is
'������';

comment on column VM_DEAL_TASK.QUEUE_ID is
'���б��';

comment on column VM_DEAL_TASK.DEAL_TYPE is
'�������ͣ�TIMER-��ʱ��,PRINT-�Զ�ִ���˹������ӡ����';

comment on column VM_DEAL_TASK.RUNTIME is
'����ִ��ʱ��';

comment on column VM_DEAL_TASK.STATE is
'����״̬ 2-����ִ��,99-ϵͳ����';

comment on column VM_DEAL_TASK.CREATE_DATE is
'����ʱ��';

comment on column VM_DEAL_TASK.DEV_ID is
'�����߱�ʶ(����ģʽʱ������)';

comment on column VM_DEAL_TASK.ERROR_MESSAGE is
'����ԭ��';

comment on column VM_DEAL_TASK.REGION_ID is
'������Ϣ';

alter table VM_DEAL_TASK
   add constraint PK_VM_DEAL_TASK primary key (DEAL_TASK_ID);

/*==============================================================*/
/* Index: IDX_D_T_WID                                           */
/*==============================================================*/
create index IDX_D_T_WID on VM_DEAL_TASK (
   WORKFLOW_ID ASC
);
