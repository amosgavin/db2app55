/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:48:22                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_DEAL_TASK                                          */
/*==============================================================*/
create table VM_DEAL_TASK
(
   DEAL_TASK_ID         varchar(25) not null,
   TASK_ID              varchar(25) not null comment '������',
   WORKFLOW_ID          varchar(25) not null,
   QUEUE_ID             varchar(5) comment '���б��',
   DEAL_TYPE            varchar(10) comment '�������ͣ�TIMER-��ʱ��,PRINT-�Զ�ִ���˹������ӡ����',
   RUNTIME              datetime comment '����ִ��ʱ��',
   STATE                numeric(2,0) comment '����״̬ 2-����ִ��,99-ϵͳ����',
   CREATE_DATE          datetime comment '����ʱ��',
   DEV_ID               varchar(5) comment '�����߱�ʶ(����ģʽʱ������)',
   ERROR_MESSAGE        varchar(4000) comment '����ԭ��',
   REGION_ID            varchar(6) comment '������Ϣ'
);

alter table VM_DEAL_TASK comment '��ʱ����';

alter table VM_DEAL_TASK
   add primary key (DEAL_TASK_ID);

/*==============================================================*/
/* Index: IDX_D_T_WID                                           */
/*==============================================================*/
create index IDX_D_T_WID on VM_DEAL_TASK
(
   WORKFLOW_ID
);

