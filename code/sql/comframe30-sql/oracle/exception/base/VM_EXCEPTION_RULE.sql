/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:06:00                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_EXCEPTION_RULE                                     */
/*==============================================================*/
create table VM_EXCEPTION_RULE  (
   EXCEPTION_RULE_ID    NUMBER(15,0)                    not null,
   EXCEPTION_DESC_CODE  VARCHAR2(255),
   CURRENT_TEMPLATE_TAG VARCHAR2(255),
   NEXT_TEMPLATE_TAG    VARCHAR2(255),
   EXCEPTION_RULE_REMARKS VARCHAR2(255),
   CREATE_DATE          DATE,
   STATE                CHAR(1)
);

comment on column VM_EXCEPTION_RULE.EXCEPTION_RULE_ID is
'异常处理规则表标识(主键)';

comment on column VM_EXCEPTION_RULE.EXCEPTION_DESC_CODE is
'异常情形编码';

comment on column VM_EXCEPTION_RULE.CURRENT_TEMPLATE_TAG is
'当前工作流实例的模板编码';

comment on column VM_EXCEPTION_RULE.NEXT_TEMPLATE_TAG is
'异常处理流程模板编码';

comment on column VM_EXCEPTION_RULE.EXCEPTION_RULE_REMARKS is
'异常规则描述信息';

comment on column VM_EXCEPTION_RULE.CREATE_DATE is
'创建时间';

comment on column VM_EXCEPTION_RULE.STATE is
'状态 U 当前在用 E 废弃不用';

alter table VM_EXCEPTION_RULE
   add constraint PK_VM_EXCEPTION_RULE primary key (EXCEPTION_RULE_ID);

