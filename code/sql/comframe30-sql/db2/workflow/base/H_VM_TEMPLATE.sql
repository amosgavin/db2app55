/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:11:40                           */
/*==============================================================*/


/*==============================================================*/
/* Table: H_VM_TEMPLATE                                         */
/*==============================================================*/
create table H_VM_TEMPLATE  (
   HIS_ID               BIGINT                    not null,
   TEMPLATE_TAG         VARCHAR(255),
   TEMPLATE_TYPE        VARCHAR(255),
   LABEL                VARCHAR(255),
   QUEUE_ID             VARCHAR(5)                     not null,
   ENGINE_TYPE          VARCHAR(255),
   PUBLISH              CHAR(1),
   CREATE_STAFF         VARCHAR(255),
   CREATE_DATE          TIMESTAMP,
   STATE_DATE           TIMESTAMP,
   STATE                CHAR(1),
   REMARK               VARCHAR(255)
);

comment on table H_VM_TEMPLATE is
'流程模板';

comment on column H_VM_TEMPLATE.HIS_ID is
'主键';

comment on column H_VM_TEMPLATE.TEMPLATE_TAG is
'流程模板编号';

comment on column H_VM_TEMPLATE.TEMPLATE_TYPE is
'流程模板类型：workflow,process';

comment on column H_VM_TEMPLATE.LABEL is
'流程模板名称';

comment on column H_VM_TEMPLATE.QUEUE_ID is
'流程队列';

comment on column H_VM_TEMPLATE.ENGINE_TYPE is
'引擎类型';

comment on column H_VM_TEMPLATE.PUBLISH is
'发布模式(Y:非文件方式,N:文件方式)';

comment on column H_VM_TEMPLATE.CREATE_DATE is
'创建时间';

comment on column H_VM_TEMPLATE.STATE_DATE is
'状态变化时间';

comment on column H_VM_TEMPLATE.STATE is
'状态:U,有效;E:失效';

comment on column H_VM_TEMPLATE.REMARK is
'备注';

alter table H_VM_TEMPLATE
   add constraint PK_H_VM_TEMPLATE primary key (HIS_ID);

