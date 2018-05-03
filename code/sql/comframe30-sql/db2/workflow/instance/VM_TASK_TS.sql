/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/19 11:00:35                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_TASK_TS                                            */
/*==============================================================*/
create table VM_TASK_TS  (
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
   REGION_ID            VARCHAR(25)
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

