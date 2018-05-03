/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:47:58                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_TEMPLATE_VERSION                                   */
/*==============================================================*/
create table VM_TEMPLATE_VERSION
(
   TEMPLATE_VERSION_ID  numeric(15,0) not null comment '����ģ��ID',
   ORDER_NUM            numeric(1,0) not null comment '˳��.ģ������̫�������д洢ʱʹ��',
   TEMPLATE_TAG         varchar(255) comment '����ģ����',
   CREATE_STAFF_ID      varchar(30) comment '������Ա',
   CREATE_DATE          datetime comment '����ʱ��',
   MODIFY_DESC          varchar(255) comment '״̬�仯ԭ��',
   VALID_DATE           datetime comment '��Чʱ��',
   EXPIRE_DATE          datetime comment 'ʧЧʱ��',
   CONTENT              varchar(1500) comment 'ģ������',
   CONTENT1             varchar(1500) comment 'ģ������',
   CONTENT2             varchar(1500) comment 'ģ������',
   CONTENT3             varchar(1500) comment 'ģ������',
   CONTENT4             varchar(1500) comment 'ģ������',
   CONTENT5             varchar(1500) comment 'ģ������',
   CONTENT6             varchar(1500) comment 'ģ������',
   CONTENT7             varchar(1500) comment 'ģ������',
   CONTENT8             varchar(1500) comment 'ģ������',
   CONTENT9             varchar(1500) comment 'ģ������',
   CONTENT10            varchar(1500) comment 'ģ������',
   CONTENT11            varchar(1500) comment 'ģ������',
   CONTENT12            varchar(1500) comment 'ģ������',
   CONTENT13            varchar(1500) comment 'ģ������',
   CONTENT14            varchar(1500) comment 'ģ������',
   CONTENT15            varchar(1500) comment 'ģ������'
);

alter table VM_TEMPLATE_VERSION comment '����ģ��';

alter table VM_TEMPLATE_VERSION
   add primary key (TEMPLATE_VERSION_ID, ORDER_NUM);

