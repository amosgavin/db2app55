/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:46:19                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_EXCEPTION_CODE                                     */
/*==============================================================*/
create table VM_EXCEPTION_CODE
(
   EXCEPTION_CODE       varchar(255) not null comment '异常原因编码',
   EXCEPTION_NAME       varchar(255) comment '异常原因名称',
   WORKFLOW_OBJECT_TYPE varchar(255) comment '工作流处理对象类型',
   TASK_TAG             varchar(255),
   EXCEPTION_TYPE       varchar(255),
   CREATE_DATE          datetime comment '创建时间',
   STATE                char(1) comment '状态 U 当前在用 E 废弃不用'
);

alter table VM_EXCEPTION_CODE
   add primary key (EXCEPTION_CODE);

