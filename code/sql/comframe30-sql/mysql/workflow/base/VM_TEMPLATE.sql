/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:47:58                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_TEMPLATE                                           */
/*==============================================================*/
create table VM_TEMPLATE
(
   TEMPLATE_TAG         varchar(255) not null comment '����ģ����',
   TEMPLATE_TYPE        varchar(255) comment '����ģ�����ͣ�workflow,process',
   LABEL		varchar(255) comment '����ģ������',
   QUEUE_ID             varchar(5) not null comment '���̶���',
   ENGINE_TYPE          varchar(255) comment '��������',
   PUBLISH              char(1) comment '����ģʽ(Y:���ļ���ʽ,N:�ļ���ʽ)',
   CREATE_STAFF         varchar(255) comment '������',
   CREATE_DATE          datetime comment '����ʱ��',
   STATE_DATE           datetime comment '״̬�仯ʱ��',
   STATE                char(1) comment '״̬:U:��Ч,E:��Ч',
   REMARK               varchar(255) comment '��ע'
);

alter table VM_TEMPLATE comment '����ģ��';

alter table VM_TEMPLATE
   add primary key (TEMPLATE_TAG);

