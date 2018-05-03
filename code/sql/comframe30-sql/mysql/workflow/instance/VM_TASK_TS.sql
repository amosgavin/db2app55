/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:48:22                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_TASK_TS                                            */
/*==============================================================*/
create table VM_TASK_TS
(
   TASK_ID              varchar(25) not null comment '������',
   PARENT_TASK_ID       varchar(25) comment '�ϼ�������',
   WORKFLOW_ID          varchar(25) comment '���̱��',
   QUEUE_ID             varchar(5) comment '���̶���',
   TASK_TEMPLATE_ID     numeric(12,0) comment '����ģ����',
   DEST_TASK_TEMPLATE_ID numeric(12,0) comment '��ת���߻���ʱ��Ŀ�������ʶ',
   DEST_TYPE            char(1) comment '�������ͣ�J-��ת;G-����',
   TASK_TYPE            varchar(255) comment '��������',
   TASK_BASE_TYPE       varchar(255) comment '�Զ����������Ͷ�Ӧ�Ļ�������',
   TASK_TAG             varchar(255) comment '�����־',
   LABEL              varchar(255) comment '��������',
   DURATION             numeric(15,0) comment '����ʱ��',
   DECISION_RESULT      varchar(255) comment '�жϽ��',
   IS_CURRENT_TASK      char(1) comment '�Ƿ�ǰ����',
   STATE                numeric(2,0) comment '����״̬ 1-���ܵ��� 2-���Ե��� 3-�Ѿ���� 4-��ֹ 9-�ȴ��� 5-�˹����� 6-����ʧ�� 7-�ȴ��ⲿ�¼����� 8-�������� 99-ϵͳ�쳣 21-�Ѿ��ظ�������������',
   STATE_DATE           datetime comment '״̬ʱ��',
   CREATE_DATE          datetime comment '����ʱ��',
   STATION_ID           varchar(30) comment '�����λ',
   TASK_STAFF_ID        varchar(30) comment '������Ա',
   LOCK_STAFF_ID        varchar(30) comment '����Ա��',
   LOCK_DATE            datetime comment '����ʱ��',
   FINISH_STAFF_ID      varchar(30) comment '�����Ա',
   FINISH_DATE          datetime comment '���ʱ��',
   ERROR_MESSAGE        varchar(4000) comment '������Ϣ',
   DESCRIPTION          varchar(512) comment '��������',
   WARNING_DATE         datetime,
   WARNING_TIMES        numeric(2,0),
   REGION_ID            varchar(25) comment '������Ϣ'
);

alter table VM_TASK_TS
   add primary key (TASK_ID);

/*==============================================================*/
/* Index: IDX_T_T_WID                                           */
/*==============================================================*/
create index IDX_T_T_WID on VM_TASK_TS
(
   WORKFLOW_ID
);

