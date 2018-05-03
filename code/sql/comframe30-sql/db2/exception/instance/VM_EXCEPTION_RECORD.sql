/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:07:28                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_EXCEPTION_RECORD                                   */
/*==============================================================*/
create table VM_EXCEPTION_RECORD  (
   EXCEPTION_RECORD_ID  BIGINT                    not null,
   WORKFLOW_ID          VARCHAR(25),
   QUEUE_ID             VARCHAR(5),
   TASK_ID              VARCHAR(25),
   EXCEPTION_CODE       VARCHAR(255)                   not null,
   EXCEPTION_REMARKS    VARCHAR(255),
   NEXT_TEMPLATE_TAG    VARCHAR(255),
   RULE_OWNER           VARCHAR(2),
   CREATE_DATE          TIMESTAMP,
   STATE                CHAR(1),
   REGION_ID            VARCHAR(6)
);

comment on column VM_EXCEPTION_RECORD.EXCEPTION_RECORD_ID is
'异常记录标识(主键)';

comment on column VM_EXCEPTION_RECORD.WORKFLOW_ID is
'工作流实例编号';

comment on column VM_EXCEPTION_RECORD.QUEUE_ID is
'流程队列';

comment on column VM_EXCEPTION_RECORD.TASK_ID is
'工作流任务实例ID';

comment on column VM_EXCEPTION_RECORD.EXCEPTION_CODE is
'异常原因';

comment on column VM_EXCEPTION_RECORD.EXCEPTION_REMARKS is
'异常描述信息';

comment on column VM_EXCEPTION_RECORD.NEXT_TEMPLATE_TAG is
'异常流程编码(支持由业务系统实现选择异常流程的规则)';

comment on column VM_EXCEPTION_RECORD.RULE_OWNER is
'异常规则所有者(01:COMFRAME 02:业务系统)';

comment on column VM_EXCEPTION_RECORD.CREATE_DATE is
'创建时间';

comment on column VM_EXCEPTION_RECORD.STATE is
'状态 U 当前在用 E 废弃不用';

comment on column VM_EXCEPTION_RECORD.REGION_ID is
'地域信息';

alter table VM_EXCEPTION_RECORD
   add constraint PK_VM_EX_R primary key (EXCEPTION_RECORD_ID);

