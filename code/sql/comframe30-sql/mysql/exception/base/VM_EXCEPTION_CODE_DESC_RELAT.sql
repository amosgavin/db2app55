/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:46:19                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_EXCEPTION_CODE_DESC_RELAT                          */
/*==============================================================*/
create table VM_EXCEPTION_CODE_DESC_RELAT
(
   EXCEPTION_CODE       varchar(255) not null comment '异常原因编码',
   EXCEPTION_DESC_CODE  varchar(255) not null comment '异常情形编码',
   CREATE_DATE          datetime comment '创建时间',
   STATE                char(1) comment '状态 U 当前在用 E 废弃不用'
);

alter table VM_EXCEPTION_CODE_DESC_RELAT
   add primary key (EXCEPTION_CODE, EXCEPTION_DESC_CODE);

