/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:11:40                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_TEMPLATE_VERSION                                   */
/*==============================================================*/
create table VM_TEMPLATE_VERSION  (
   TEMPLATE_VERSION_ID  BIGINT                    not null,
   ORDER_NUM            INTEGER                     not null,
   TEMPLATE_TAG         VARCHAR(255),
   CREATE_STAFF_ID      VARCHAR(30),
   CREATE_DATE          TIMESTAMP,
   MODIFY_DESC          VARCHAR(252),
   VALID_DATE           TIMESTAMP,
   EXPIRE_DATE          TIMESTAMP,
   CONTENT              VARCHAR(2000),
   CONTENT1             VARCHAR(2000),
   CONTENT2             VARCHAR(2000),
   CONTENT3             VARCHAR(2000),
   CONTENT4             VARCHAR(2000),
   CONTENT5             VARCHAR(2000),
   CONTENT6             VARCHAR(2000),
   CONTENT7             VARCHAR(2000),
   CONTENT8             VARCHAR(2000),
   CONTENT9             VARCHAR(2000),
   CONTENT10            VARCHAR(2000),
   CONTENT11            VARCHAR(2000),
   CONTENT12            VARCHAR(2000),
   CONTENT13            VARCHAR(2000),
   CONTENT14            VARCHAR(2000),
   CONTENT15            VARCHAR(2000)
);

comment on table VM_TEMPLATE_VERSION is
'流程模板';

comment on column VM_TEMPLATE_VERSION.TEMPLATE_VERSION_ID is
'流程模板ID';

comment on column VM_TEMPLATE_VERSION.ORDER_NUM is
'顺序.模板内容太长分两行存储时使用';

comment on column VM_TEMPLATE_VERSION.TEMPLATE_TAG is
'流程模板编号';

comment on column VM_TEMPLATE_VERSION.CREATE_STAFF_ID is
'创建人员';

comment on column VM_TEMPLATE_VERSION.CREATE_DATE is
'创建时间';

comment on column VM_TEMPLATE_VERSION.MODIFY_DESC is
'状态变化原因';

comment on column VM_TEMPLATE_VERSION.VALID_DATE is
'生效时间';

comment on column VM_TEMPLATE_VERSION.EXPIRE_DATE is
'失效时间';

comment on column VM_TEMPLATE_VERSION.CONTENT is
'模板内容';

comment on column VM_TEMPLATE_VERSION.CONTENT1 is
'模板内容';

comment on column VM_TEMPLATE_VERSION.CONTENT2 is
'模板内容';

comment on column VM_TEMPLATE_VERSION.CONTENT3 is
'模板内容';

comment on column VM_TEMPLATE_VERSION.CONTENT4 is
'模板内容';

comment on column VM_TEMPLATE_VERSION.CONTENT5 is
'模板内容';

comment on column VM_TEMPLATE_VERSION.CONTENT6 is
'模板内容';

comment on column VM_TEMPLATE_VERSION.CONTENT7 is
'模板内容';

comment on column VM_TEMPLATE_VERSION.CONTENT8 is
'模板内容';

comment on column VM_TEMPLATE_VERSION.CONTENT9 is
'模板内容';

comment on column VM_TEMPLATE_VERSION.CONTENT10 is
'模板内容';

comment on column VM_TEMPLATE_VERSION.CONTENT11 is
'模板内容';

comment on column VM_TEMPLATE_VERSION.CONTENT12 is
'模板内容';

comment on column VM_TEMPLATE_VERSION.CONTENT13 is
'模板内容';

comment on column VM_TEMPLATE_VERSION.CONTENT14 is
'模板内容';

comment on column VM_TEMPLATE_VERSION.CONTENT15 is
'模板内容';

alter table VM_TEMPLATE_VERSION
   add constraint PK_VM_TEMPLATE_VERSION primary key (TEMPLATE_VERSION_ID, ORDER_NUM);

