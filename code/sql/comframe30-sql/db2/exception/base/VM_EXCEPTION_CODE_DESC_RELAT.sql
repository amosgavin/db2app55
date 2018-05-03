/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:06:00                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_EXCEPTION_CODE_DESC_RELAT                          */
/*==============================================================*/
create table VM_EXCEPTION_CODE_DESC_RELAT  (
   EXCEPTION_CODE       VARCHAR(255)                   not null,
   EXCEPTION_DESC_CODE  VARCHAR(255)                   not null,
   CREATE_DATE          TIMESTAMP,
   STATE                CHAR(1)
);

comment on column VM_EXCEPTION_CODE_DESC_RELAT.EXCEPTION_CODE is
'异常原因编码';

comment on column VM_EXCEPTION_CODE_DESC_RELAT.EXCEPTION_DESC_CODE is
'异常情形编码';

comment on column VM_EXCEPTION_CODE_DESC_RELAT.CREATE_DATE is
'创建时间';

comment on column VM_EXCEPTION_CODE_DESC_RELAT.STATE is
'状态 U 当前在用 E 废弃不用';

alter table VM_EXCEPTION_CODE_DESC_RELAT
   add constraint PK_VM_EXCEPTION_CODE_DESC_RELA primary key (EXCEPTION_CODE, EXCEPTION_DESC_CODE);

