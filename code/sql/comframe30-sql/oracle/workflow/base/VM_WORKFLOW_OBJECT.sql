/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:11:40                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_WORKFLOW_OBJECT                                    */
/*==============================================================*/
create table VM_WORKFLOW_OBJECT  (
   CODE                 VARCHAR2(255)                   not null,
   NAME                 VARCHAR2(255)                   not null,
   STATE                CHAR(1)                         not null,
   CREATE_DATE          DATE,
   REMARK               VARCHAR2(255)
);

comment on table VM_WORKFLOW_OBJECT is
'工作流处理对象';

comment on column VM_WORKFLOW_OBJECT.CODE is
'工作流处理对象编码';

comment on column VM_WORKFLOW_OBJECT.NAME is
'工作流处理对象名称';

comment on column VM_WORKFLOW_OBJECT.STATE is
'状态';

comment on column VM_WORKFLOW_OBJECT.CREATE_DATE is
'创建时间';

comment on column VM_WORKFLOW_OBJECT.REMARK is
'备注';

alter table VM_WORKFLOW_OBJECT
   add constraint PK_VM_WF_OBJ_CODE primary key (CODE);

