/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/19 11:00:35                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_WF                                                 */
/*==============================================================*/
create table VM_WF  (
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
   WORKFLOW_OBJECT_ID   VARCHAR2(50),
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
   REGION_ID            VARCHAR2(6)
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

