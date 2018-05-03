/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/19 11:00:35                           */
/*==============================================================*/


/*==============================================================*/
/* Table: H_VM_TASK                                             */
/*==============================================================*/
create table H_VM_TASK  (
   TASK_ID              VARCHAR2(25)                    not null,
   LAST_TASK_ID         VARCHAR2(500),
   WORKFLOW_ID          VARCHAR2(25),
   QUEUE_ID             VARCHAR2(5),
   TASK_TEMPLATE_ID     NUMBER(15,0),
   DEST_TASK_TEMPLATE_ID NUMBER(15,0),
   DEST_TYPE            CHAR(1),
   ENGINE_WORKFLOW_ID   VARCHAR2(255),
   ENGINE_TASK_ID       VARCHAR2(255),
   TASK_TYPE            VARCHAR2(255),
   TASK_BASE_TYPE       VARCHAR2(255),
   TASK_TAG             VARCHAR2(255),
   CHILD_WORKFLOW_COUNT NUMBER(10,0),
   REMANENT_WORKFLOW_COUNT NUMBER(10,0),
   LABEL                VARCHAR2(255),
   DURATION             NUMBER(15,0),
   DECISION_RESULT      VARCHAR2(255),
   IS_CURRENT_TASK      CHAR(1),
   STATE                NUMBER(2,0),
   STATE_DATE           DATE,
   CREATE_DATE          DATE,
   EXE_FINISH_DATE      DATE,
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
   REGION_ID            VARCHAR2(6),
   TRANSFER_DATE        DATE
);

comment on column H_VM_TASK.TASK_ID is
'������';

comment on column H_VM_TASK.LAST_TASK_ID is
'�ɷ���ǰ�������һ������';

comment on column H_VM_TASK.WORKFLOW_ID is
'���������';

comment on column H_VM_TASK.QUEUE_ID is
'���̶���';

comment on column H_VM_TASK.TASK_TEMPLATE_ID is
'����ģ����';

comment on column H_VM_TASK.DEST_TASK_TEMPLATE_ID is
'��ת���߻���ʱ��Ŀ�������ʶ';

comment on column H_VM_TASK.DEST_TYPE is
'�������ͣ�J-��ת;G-����';

comment on column H_VM_TASK.ENGINE_TASK_ID is
'�������������ʵ�����';

comment on column H_VM_TASK.TASK_TYPE is
'��������';

comment on column H_VM_TASK.TASK_TAG is
'�����־';

comment on column H_VM_TASK.CHILD_WORKFLOW_COUNT is
'����������';

comment on column H_VM_TASK.REMANENT_WORKFLOW_COUNT is
'δ�������������';

comment on column H_VM_TASK.LABEL is
'��������';

comment on column H_VM_TASK.DURATION is
'����ʱ��';

comment on column H_VM_TASK.DECISION_RESULT is
'�жϽ��';

comment on column H_VM_TASK.IS_CURRENT_TASK is
'�Ƿ�ǰ����';

comment on column H_VM_TASK.STATE is
'����״̬ 1-���ܵ��� 2-���Ե��� 3-�Ѿ���� 4-��ֹ 9-�ȴ��� 5-�˹����� 6-���� 7-�ȴ��ⲿ�¼����� 8-�������� 99-ϵͳ�쳣 21-�Ѿ��ظ�������������';

comment on column H_VM_TASK.STATE_DATE is
'״̬ʱ��';

comment on column H_VM_TASK.CREATE_DATE is
'����ʱ��';

comment on column H_VM_TASK.EXE_FINISH_DATE is
'�˹�����ǰ������ִ�����ʱ��';

comment on column H_VM_TASK.STATION_ID is
'�����λ';

comment on column H_VM_TASK.TASK_STAFF_ID is
'������Ա';

comment on column H_VM_TASK.LOCK_STAFF_ID is
'����Ա��';

comment on column H_VM_TASK.LOCK_DATE is
'����ʱ��';

comment on column H_VM_TASK.FINISH_STAFF_ID is
'�����Ա';

comment on column H_VM_TASK.FINISH_DATE is
'���ʱ��';

comment on column H_VM_TASK.ERROR_MESSAGE is
'������Ϣ';

comment on column H_VM_TASK.DESCRIPTION is
'��������';

comment on column H_VM_TASK.WARNING_DATE is
'�澯ʱ��';

comment on column H_VM_TASK.WARNING_TIMES is
'�澯����';

comment on column H_VM_TASK.REGION_ID is
'������Ϣ';

comment on column H_VM_TASK.TRANSFER_DATE is
'����ʷʱ��';

alter table H_VM_TASK
   add constraint PK_H_VM_TA primary key (TASK_ID);

/*==============================================================*/
/* Index: IDX_H_T_WID                                           */
/*==============================================================*/
create index IDX_H_T_WID on H_VM_TASK (
   WORKFLOW_ID ASC
);

