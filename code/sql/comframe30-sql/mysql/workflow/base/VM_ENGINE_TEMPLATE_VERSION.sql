/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:47:58                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_ENGINE_TEMPLATE_VERSION                            */
/*==============================================================*/
create table VM_ENGINE_TEMPLATE_VERSION
(
   TEMPLATE_VERSION_ID  numeric(15,0) not null comment 'VM引擎的模板ID',
   ENGINE_TEMPLATE_ID   varchar(255) comment '引擎模板ID',
   ENGINE_VERION        varchar(255) comment '流程在引擎上的版本',
   CREATE_DATE          datetime comment '创建时间'
);

alter table VM_ENGINE_TEMPLATE_VERSION
   add primary key (TEMPLATE_VERSION_ID);

