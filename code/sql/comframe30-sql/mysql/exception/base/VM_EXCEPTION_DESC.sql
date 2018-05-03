/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:46:19                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_EXCEPTION_DESC                                     */
/*==============================================================*/
create table VM_EXCEPTION_DESC
(
   EXCEPTION_DESC_CODE  varchar(255) not null comment '异常情形编码',
   EXCEPTION_DESC_NAME  varchar(255) comment '异常情形名称',
   EXCEPTION_DESC_TYPE  char(1) comment '异常情形类型(A:满足全部异常原因组合,B:只需满足一个异常原因)',
   CREATE_DATE          datetime comment '创建时间',
   STATE                char(1) comment '状态 U 当前在用 E 废弃不用'
);

alter table VM_EXCEPTION_DESC
   add primary key (EXCEPTION_DESC_CODE);

