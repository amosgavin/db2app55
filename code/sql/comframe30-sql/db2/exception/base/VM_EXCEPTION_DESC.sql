/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:06:00                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_EXCEPTION_DESC                                     */
/*==============================================================*/
create table VM_EXCEPTION_DESC  (
   EXCEPTION_DESC_CODE  VARCHAR(255)                   not null,
   EXCEPTION_DESC_NAME  VARCHAR(255),
   EXCEPTION_DESC_TYPE  CHAR(1),
   CREATE_DATE          TIMESTAMP,
   STATE                CHAR(1)
);

comment on column VM_EXCEPTION_DESC.EXCEPTION_DESC_CODE is
'异常情形编码';

comment on column VM_EXCEPTION_DESC.EXCEPTION_DESC_NAME is
'异常情形名称';

comment on column VM_EXCEPTION_DESC.EXCEPTION_DESC_TYPE is
'异常情形类型(A:满足全部异常原因组合,B:只需满足一个异常原因)';

comment on column VM_EXCEPTION_DESC.CREATE_DATE is
'创建时间';

comment on column VM_EXCEPTION_DESC.STATE is
'状态 U 当前在用 E 废弃不用';

alter table VM_EXCEPTION_DESC
   add constraint PK_VM_EXCEPTION_DESC primary key (EXCEPTION_DESC_CODE);

