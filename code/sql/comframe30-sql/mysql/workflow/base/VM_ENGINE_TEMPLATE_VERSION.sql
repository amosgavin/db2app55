/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:47:58                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_ENGINE_TEMPLATE_VERSION                            */
/*==============================================================*/
create table VM_ENGINE_TEMPLATE_VERSION
(
   TEMPLATE_VERSION_ID  numeric(15,0) not null comment 'VM�����ģ��ID',
   ENGINE_TEMPLATE_ID   varchar(255) comment '����ģ��ID',
   ENGINE_VERION        varchar(255) comment '�����������ϵİ汾',
   CREATE_DATE          datetime comment '����ʱ��'
);

alter table VM_ENGINE_TEMPLATE_VERSION
   add primary key (TEMPLATE_VERSION_ID);

