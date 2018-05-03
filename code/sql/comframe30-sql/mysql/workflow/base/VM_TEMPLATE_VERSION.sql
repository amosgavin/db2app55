/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:47:58                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_TEMPLATE_VERSION                                   */
/*==============================================================*/
create table VM_TEMPLATE_VERSION
(
   TEMPLATE_VERSION_ID  numeric(15,0) not null comment '流程模板ID',
   ORDER_NUM            numeric(1,0) not null comment '顺序.模板内容太长分两行存储时使用',
   TEMPLATE_TAG         varchar(255) comment '流程模板编号',
   CREATE_STAFF_ID      varchar(30) comment '创建人员',
   CREATE_DATE          datetime comment '创建时间',
   MODIFY_DESC          varchar(255) comment '状态变化原因',
   VALID_DATE           datetime comment '生效时间',
   EXPIRE_DATE          datetime comment '失效时间',
   CONTENT              varchar(1500) comment '模板内容',
   CONTENT1             varchar(1500) comment '模板内容',
   CONTENT2             varchar(1500) comment '模板内容',
   CONTENT3             varchar(1500) comment '模板内容',
   CONTENT4             varchar(1500) comment '模板内容',
   CONTENT5             varchar(1500) comment '模板内容',
   CONTENT6             varchar(1500) comment '模板内容',
   CONTENT7             varchar(1500) comment '模板内容',
   CONTENT8             varchar(1500) comment '模板内容',
   CONTENT9             varchar(1500) comment '模板内容',
   CONTENT10            varchar(1500) comment '模板内容',
   CONTENT11            varchar(1500) comment '模板内容',
   CONTENT12            varchar(1500) comment '模板内容',
   CONTENT13            varchar(1500) comment '模板内容',
   CONTENT14            varchar(1500) comment '模板内容',
   CONTENT15            varchar(1500) comment '模板内容'
);

alter table VM_TEMPLATE_VERSION comment '流程模板';

alter table VM_TEMPLATE_VERSION
   add primary key (TEMPLATE_VERSION_ID, ORDER_NUM);

