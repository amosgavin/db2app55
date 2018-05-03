/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:46:19                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_EXCEPTION_RULE                                     */
/*==============================================================*/
create table VM_EXCEPTION_RULE
(
   EXCEPTION_RULE_ID    numeric(15,0) not null comment '异常处理规则表标识(主键)',
   EXCEPTION_DESC_CODE  varchar(255) comment '异常情形编码',
   CURRENT_TEMPLATE_TAG varchar(255) comment '当前工作流实例的模板编码',
   NEXT_TEMPLATE_TAG    varchar(255) comment '异常处理流程模板编码',
   EXCEPTION_RULE_REMARKS varchar(255) comment '异常规则描述信息',
   CREATE_DATE          datetime comment '创建时间',
   STATE                char(1) comment '状态 U 当前在用 E 废弃不用'
);

alter table VM_EXCEPTION_RULE
   add primary key (EXCEPTION_RULE_ID);

