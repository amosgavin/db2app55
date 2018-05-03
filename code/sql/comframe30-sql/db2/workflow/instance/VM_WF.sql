/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/19 11:00:35                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_WF                                                 */
/*==============================================================*/
create table VM_WF  (
   WORKFLOW_ID          VARCHAR(25)                    not null,
   TEMPLATE_VERSION_ID  BIGINT,
   QUEUE_ID             VARCHAR(5),
   ENGINE_WORKFLOW_ID   VARCHAR(255),
   ENGINE_TYPE          VARCHAR(255),
   WORKFLOW_TYPE        VARCHAR(255),
   TEMPLATE_TAG         VARCHAR(255),
   PARENT_TASK_ID       VARCHAR(25),
   WORKFLOW_KIND        INTEGER,
   STATE                INTEGER,
   SUSPEND_STATE        INTEGER,
   STATE_DATE           TIMESTAMP,
   WORKFLOW_OBJECT_ID   VARCHAR(50),
   WORKFLOW_OBJECT_TYPE VARCHAR(255),
   USER_TASK_COUNT      BIGINT,
   CURRENT_TASK_ID      VARCHAR(255),
   DURATION             BIGINT,
   CREATE_STAFF_ID      VARCHAR(30),
   CREATE_DATE          TIMESTAMP,
   START_DATE           TIMESTAMP,
   FINISH_DATE          TIMESTAMP,
   LABEL                VARCHAR(255),
   DESCRIPTION          VARCHAR(512),
   VARS                 VARCHAR(4000),
   OP_STAFF_ID          VARCHAR(30),
   ERROR_COUNT          INTEGER,
   ERROR_MESSAGE        VARCHAR(4000),
   WARNING_DATE         TIMESTAMP,
   WARNING_TIMES        INTEGER,
   REGION_ID            VARCHAR(6)
);

comment on column VM_WF.WORKFLOW_ID is
'���������';

comment on column VM_WF.TEMPLATE_VERSION_ID is
'������ģ����';

comment on column VM_WF.QUEUE_ID is
'���̶���';

comment on column VM_WF.ENGINE_WORKFLOW_ID is
'�������������ʵ�����';

comment on column VM_WF.ENGINE_TYPE is
'��������';

comment on column VM_WF.WORKFLOW_TYPE is
'''����ģ������:PROCESS/WORKFLOW';

comment on column VM_WF.TEMPLATE_TAG is
'�����־';

comment on column VM_WF.PARENT_TASK_ID is
'�����������������ӹ�����';

comment on column VM_WF.WORKFLOW_KIND is
'''��������:-1=�����̣�1=������,2=�쳣������';

comment on column VM_WF.STATE is
'״̬ 1-���ܵ��� 2-���Ե��� 3-�Ѿ���� 4-��ֹ 5-�˹����� 7-�ȴ��ⲿ�¼����� 8-�������� 99-ϵͳ�쳣';

comment on column VM_WF.SUSPEND_STATE is
'״̬ 1-���� 2-���Ե���';

comment on column VM_WF.STATE_DATE is
'״̬ʱ��';

comment on column VM_WF.WORKFLOW_OBJECT_ID is
'���������������';

comment on column VM_WF.WORKFLOW_OBJECT_TYPE is
'�����������������';

comment on column VM_WF.USER_TASK_COUNT is
'�˹���������';

comment on column VM_WF.CURRENT_TASK_ID is
'��ǰ����';

comment on column VM_WF.DURATION is
'����ʱ��';

comment on column VM_WF.CREATE_STAFF_ID is
'������';

comment on column VM_WF.CREATE_DATE is
'����ʱ��';

comment on column VM_WF.START_DATE is
'���̶�ʱ������ʱ��';

comment on column VM_WF.FINISH_DATE is
'���ʱ��';

comment on column VM_WF.LABEL is
'����������';

comment on column VM_WF.DESCRIPTION is
'����������';

comment on column VM_WF.VARS is
'ʵ������';

comment on column VM_WF.ERROR_MESSAGE is
'������Ϣ';

comment on column VM_WF.WARNING_DATE is
'�澯ʱ��';

comment on column VM_WF.WARNING_TIMES is
'�澯����';

comment on column VM_WF.REGION_ID is
'������Ϣ';

alter table VM_WF
   add constraint PK_VM_WF primary key (WORKFLOW_ID);

/*==============================================================*/
/* Index: IDX_WF_OID                                            */
/*==============================================================*/
create index IDX_WF_OID on VM_WF (
   WORKFLOW_OBJECT_ID ASC,
   WORKFLOW_OBJECT_TYPE ASC
);

/*==============================================================*/
/* Index: IDX_WF_P_TID                                          */
/*==============================================================*/
create index IDX_WF_P_TID on VM_WF (
   PARENT_TASK_ID ASC
);

