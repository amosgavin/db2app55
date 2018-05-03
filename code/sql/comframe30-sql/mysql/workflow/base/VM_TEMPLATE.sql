/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:47:58                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_TEMPLATE                                           */
/*==============================================================*/
create table VM_TEMPLATE
(
   TEMPLATE_TAG         varchar(255) not null comment '流程模板编号',
   TEMPLATE_TYPE        varchar(255) comment '流程模板类型：workflow,process',
   LABEL		varchar(255) comment '流程模板名称',
   QUEUE_ID             varchar(5) not null comment '流程队列',
   ENGINE_TYPE          varchar(255) comment '引擎类型',
   PUBLISH              char(1) comment '发布模式(Y:非文件方式,N:文件方式)',
   CREATE_STAFF         varchar(255) comment '创建人',
   CREATE_DATE          datetime comment '创建时间',
   STATE_DATE           datetime comment '状态变化时间',
   STATE                char(1) comment '状态:U:有效,E:无效',
   REMARK               varchar(255) comment '备注'
);

alter table VM_TEMPLATE comment '流程模板';

alter table VM_TEMPLATE
   add primary key (TEMPLATE_TAG);

