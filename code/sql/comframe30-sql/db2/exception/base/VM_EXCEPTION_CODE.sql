/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:06:00                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_EXCEPTION_CODE                                     */
/*==============================================================*/
create table VM_EXCEPTION_CODE  (
   EXCEPTION_CODE       VARCHAR(255)                   not null,
   EXCEPTION_NAME       VARCHAR(255),
   WORKFLOW_OBJECT_TYPE VARCHAR(255),
   TASK_TAG             VARCHAR(255),
   EXCEPTION_TYPE       VARCHAR(255),
   CREATE_DATE          TIMESTAMP,
   STATE                CHAR(1)
);

comment on column VM_EXCEPTION_CODE.EXCEPTION_CODE is
'异常原因编码';

comment on column VM_EXCEPTION_CODE.EXCEPTION_NAME is
'异常原因名称';

comment on column VM_EXCEPTION_CODE.WORKFLOW_OBJECT_TYPE is
'工作流处理对象类型';

comment on column VM_EXCEPTION_CODE.CREATE_DATE is
'创建时间';

comment on column VM_EXCEPTION_CODE.STATE is
'状态 U 当前在用 E 废弃不用';

alter table VM_EXCEPTION_CODE
   add constraint PK_VM_EXCEPTION_CODE primary key (EXCEPTION_CODE);

