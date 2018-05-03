/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:47:58                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_WORKFLOW_OBJECT                                    */
/*==============================================================*/
create table VM_WORKFLOW_OBJECT
(
   CODE                 varchar(255) not null comment '工作流处理对象编码',
   NAME                 varchar(255) not null comment '工作流处理对象名称',
   STATE                char(1) not null comment '状态',
   CREATE_DATE          datetime comment '创建时间',
   REMARK               varchar(255) comment '备注'
);

alter table VM_WORKFLOW_OBJECT comment '工作流处理对象';

alter table VM_WORKFLOW_OBJECT
   add primary key (CODE);

