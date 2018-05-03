/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:48:22                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_SCHEDULE                                           */
/*==============================================================*/
create table VM_SCHEDULE
(
   WORKFLOW_ID          varchar(25) not null comment '���������',
   QUEUE_ID             varchar(5) comment '���б��',
   ENGINE_WORKFLOW_ID   varchar(255) comment '�������������ʵ�����',
   ENGINE_TYPE          varchar(255) comment '��������',
   CREATE_DATE          datetime comment '����ʱ��',
   STATE_DATE           datetime comment '�������ʱ��',
   START_DATE           datetime comment '���̶�ʱ������ʱ��',
   STATE                varchar(10) comment '����״̬��W-�ȴ�����,S-������Ȼ�,F-���Ƚ���,A-�����쳣����',
   SCHEDULE_DATE        datetime comment '��ʼ����ʱ��',
   DEV_ID               varchar(5) comment '�����߱�ʶ(����ģʽʱ������)',
   REGION_ID            varchar(6) comment '������Ϣ'
);

alter table VM_SCHEDULE
   add primary key (WORKFLOW_ID);

