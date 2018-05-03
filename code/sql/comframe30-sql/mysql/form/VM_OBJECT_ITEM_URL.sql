/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:47:12                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_OBJECT_ITEM_URL                                    */
/*==============================================================*/
create table VM_OBJECT_ITEM_URL
(
   URL_BUSI_TYPE        numeric(2,0) not null comment 'URL类型',
   URL                  varchar(255) comment 'URL',
   OBJECT_ITEM_ID       numeric(15,0) not null comment '对象单元编号'
);

alter table VM_OBJECT_ITEM_URL comment '对象URL';

alter table VM_OBJECT_ITEM_URL
   add primary key (URL_BUSI_TYPE, OBJECT_ITEM_ID);

