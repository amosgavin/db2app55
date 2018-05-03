/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:48:22                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_WF                                                 */
/*==============================================================*/
create table VM_WF
(
   WORKFLOW_ID          varchar(25) not null comment '���������',
   TEMPLATE_VERSION_ID  numeric(15,0) comment '������ģ����',
   QUEUE_ID             varchar(5) comment '���̶���',
   ENGINE_WORKFLOW_ID   varchar(255) comment '�������������ʵ�����',
   ENGINE_TYPE          varchar(255) comment '��������',
   WORKFLOW_TYPE        varchar(255) comment '''����ģ������:PROCESS/WORKFLOW',
   TEMPLATE_TAG         varchar(255) comment '�����־',
   PARENT_TASK_ID       varchar(25) comment '�����������������ӹ�����',
   WORKFLOW_KIND        numeric(2,0) comment '''��������:-1=�����̣�1=������,2=�쳣������',
   STATE                numeric(2,0) comment '״̬ 1-���ܵ��� 2-���Ե��� 3-�Ѿ���� 4-��ֹ 5-�˹����� 7-�ȴ��ⲿ�¼����� 8-�������� 99-ϵͳ�쳣',
   SUSPEND_STATE        numeric(2,0) comment '״̬ 1-���� 2-���Ե���',
   STATE_DATE           datetime comment '״̬ʱ��',
   WORKFLOW_OBJECT_ID   varchar(50) comment '���������������',
   WORKFLOW_OBJECT_TYPE varchar(255) comment '�����������������',
   USER_TASK_COUNT      numeric(15,0) comment '�˹���������',
   CURRENT_TASK_ID      varchar(255) comment '��ǰ����',
   DURATION             numeric(15,0) comment '����ʱ��',
   CREATE_STAFF_ID      varchar(30) comment '������',
   CREATE_DATE          datetime comment '����ʱ��',
   START_DATE           datetime comment '���̶�ʱ������ʱ��',
   FINISH_DATE          datetime comment '���ʱ��',
   LABEL		varchar(255) comment '����������',
   DESCRIPTION          varchar(512) comment '����������',
   VARS                 varchar(4000) comment 'ʵ������',
   OP_STAFF_ID          varchar(30),
   ERROR_COUNT          numeric(3,0),
   ERROR_MESSAGE        varchar(4000) comment '������Ϣ',
   WARNING_DATE         datetime comment '�澯ʱ��',
   WARNING_TIMES        numeric(2,0) comment '�澯����',
   REGION_ID            varchar(6) comment '������Ϣ'
);

alter table VM_WF
   add primary key (WORKFLOW_ID);

/*==============================================================*/
/* Index: IDX_WF_OID                                            */
/*==============================================================*/
create index IDX_WF_OID on VM_WF
(
   WORKFLOW_OBJECT_ID,
   WORKFLOW_OBJECT_TYPE
);

/*==============================================================*/
/* Index: IDX_WF_P_TID                                          */
/*==============================================================*/
create index IDX_WF_P_TID on VM_WF (
   PARENT_TASK_ID
);
