/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/19 11:00:35                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_TASK_TS                                            */
/*==============================================================*/
create table VM_TASK_TS  (
   TASK_ID              VARCHAR2(25)                    not null,
   PARENT_TASK_ID       VARCHAR2(25),
   WORKFLOW_ID          VARCHAR2(25),
   QUEUE_ID             VARCHAR2(5),
   TASK_TEMPLATE_ID     NUMBER(12,0),
   DEST_TASK_TEMPLATE_ID NUMBER(12,0),
   DEST_TYPE            CHAR(1),
   TASK_TYPE            VARCHAR2(255),
   TASK_BASE_TYPE       VARCHAR2(255),
   TASK_TAG             VARCHAR2(255),
   LABEL                VARCHAR2(255),
   DURATION             NUMBER(15,0),
   DECISION_RESULT      VARCHAR2(255),
   IS_CURRENT_TASK      CHAR(1),
   STATE                NUMBER(2,0),
   STATE_DATE           DATE,
   CREATE_DATE          DATE,
   STATION_ID           VARCHAR2(30),
   TASK_STAFF_ID        VARCHAR2(30),
   LOCK_STAFF_ID        VARCHAR2(30),
   LOCK_DATE            DATE,
   FINISH_STAFF_ID      VARCHAR2(30),
   FINISH_DATE          DATE,
   ERROR_MESSAGE        VARCHAR2(4000),
   DESCRIPTION          VARCHAR2(512),
   WARNING_DATE         DATE,
   WARNING_TIMES        NUMBER(2,0),
   REGION_ID            VARCHAR2(25)
);

comment on column VM_TASK_TS.TASK_ID is
'������';

comment on column VM_TASK_TS.PARENT_TASK_ID is
'�ϼ�������';

comment on column VM_TASK_TS.WORKFLOW_ID is
'���̱��';

comment on column VM_TASK_TS.QUEUE_ID is
'���̶���';

comment on column VM_TASK_TS.TASK_TEMPLATE_ID is
'����ģ����';

comment on column VM_TASK_TS.DEST_TASK_TEMPLATE_ID is
'��ת���߻���ʱ��Ŀ�������ʶ';

comment on column VM_TASK_TS.DEST_TYPE is
'�������ͣ�J-��ת;G-����';

comment on column VM_TASK_TS.TASK_TYPE is
'��������';

comment on column VM_TASK_TS.TASK_BASE_TYPE is
'�Զ����������Ͷ�Ӧ�Ļ�������';

comment on column VM_TASK_TS.TASK_TAG is
'�����־';

comment on column VM_TASK_TS.LABEL is
'��������';

comment on column VM_TASK_TS.DURATION is
'����ʱ��';

comment on column VM_TASK_TS.DECISION_RESULT is
'�жϽ��';

comment on column VM_TASK_TS.IS_CURRENT_TASK is
'�Ƿ�ǰ����';

comment on column VM_TASK_TS.STATE is
'����״̬ 1-���ܵ��� 2-���Ե��� 3-�Ѿ���� 4-��ֹ 9-�ȴ��� 5-�˹����� 6-����ʧ�� 7-�ȴ��ⲿ�¼����� 8-�������� 99-ϵͳ�쳣 21-�Ѿ��ظ�������������';

comment on column VM_TASK_TS.STATE_DATE is
'״̬ʱ��';

comment on column VM_TASK_TS.CREATE_DATE is
'����ʱ��';

comment on column VM_TASK_TS.STATION_ID is
'�����λ';

comment on column VM_TASK_TS.TASK_STAFF_ID is
'������Ա';

comment on column VM_TASK_TS.LOCK_STAFF_ID is
'����Ա��';

comment on column VM_TASK_TS.LOCK_DATE is
'����ʱ��';

comment on column VM_TASK_TS.FINISH_STAFF_ID is
'�����Ա';

comment on column VM_TASK_TS.FINISH_DATE is
'���ʱ��';

comment on column VM_TASK_TS.ERROR_MESSAGE is
'������Ϣ';

comment on column VM_TASK_TS.DESCRIPTION is
'��������';

comment on column VM_TASK_TS.REGION_ID is
'������Ϣ';

alter table VM_TASK_TS
   add constraint PK_VM_TA_TS primary key (TASK_ID);

/*==============================================================*/
/* Index: IDX_T_T_WID                                           */
/*==============================================================*/
create index IDX_T_T_WID on VM_TASK_TS (
   WORKFLOW_ID ASC
);

