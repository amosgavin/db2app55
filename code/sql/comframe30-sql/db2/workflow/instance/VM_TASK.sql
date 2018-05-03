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
'������';

comment on column VM_TASK.LAST_TASK_ID is
'�ɷ���ǰ�������һ������';

comment on column VM_TASK.WORKFLOW_ID is
'���������';

comment on column VM_TASK.QUEUE_ID is
'���̶���';

comment on column VM_TASK.TASK_TEMPLATE_ID is
'����ģ����';

comment on column VM_TASK.DEST_TASK_TEMPLATE_ID is
'��ת���߻���ʱ��Ŀ�������ʶ';

comment on column VM_TASK.DEST_TYPE is
'�������ͣ�J-��ת;G-����';

comment on column VM_TASK.ENGINE_TASK_ID is
'�������������ʵ�����';

comment on column VM_TASK.TASK_TYPE is
'��������';

comment on column VM_TASK.TASK_BASE_TYPE is
'������������';

comment on column VM_TASK.TASK_TAG is
'�����־';

comment on column VM_TASK.CHILD_WORKFLOW_COUNT is
'����������';

comment on column VM_TASK.REMANENT_WORKFLOW_COUNT is
'δ�������������';

comment on column VM_TASK.LABEL is
'��������';

comment on column VM_TASK.DURATION is
'����ʱ��';

comment on column VM_TASK.DECISION_RESULT is
'�жϽ��';

comment on column VM_TASK.IS_CURRENT_TASK is
'�Ƿ�ǰ����';

comment on column VM_TASK.STATE is
'����״̬ 1-���ܵ��� 2-���Ե��� 3-�Ѿ���� 4-��ֹ 9-�ȴ��� 5-�˹����� 6-���� 7-�ȴ��ⲿ�¼����� 8-�������� 99-ϵͳ�쳣 21-�Ѿ��ظ�������������';

comment on column VM_TASK.STATE_DATE is
'״̬ʱ��';

comment on column VM_TASK.CREATE_DATE is
'����ʱ��';

comment on column VM_TASK.EXE_FINISH_DATE is
'�˹�����ǰ������ִ�����ʱ��';

comment on column VM_TASK.STATION_ID is
'�����λ';

comment on column VM_TASK.TASK_STAFF_ID is
'������Ա';

comment on column VM_TASK.LOCK_STAFF_ID is
'����Ա��';

comment on column VM_TASK.LOCK_DATE is
'����ʱ��';

comment on column VM_TASK.FINISH_STAFF_ID is
'�����Ա';

comment on column VM_TASK.FINISH_DATE is
'���ʱ��';

comment on column VM_TASK.ERROR_MESSAGE is
'������Ϣ';

comment on column VM_TASK.DESCRIPTION is
'��������';

comment on column VM_TASK.WARNING_DATE is
'�澯ʱ��';

comment on column VM_TASK.WARNING_TIMES is
'�澯����';

comment on column VM_TASK.REGION_ID is
'������Ϣ';

alter table VM_TASK
   add constraint PK_VM_TASK primary key (TASK_ID);

/*==============================================================*/
/* Index: IDX_TA_WID                                            */
/*==============================================================*/
create index IDX_TA_WID on VM_TASK (
   WORKFLOW_ID ASC
);

