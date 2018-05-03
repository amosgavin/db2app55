/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:11:40                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_TEMPLATE_VERSION                                   */
/*==============================================================*/
create table VM_TEMPLATE_VERSION  (
   TEMPLATE_VERSION_ID  NUMBER(15,0)                    not null,
   ORDER_NUM            NUMBER(1,0)                     not null,
   TEMPLATE_TAG         VARCHAR2(255),
   CREATE_STAFF_ID      VARCHAR2(30),
   CREATE_DATE          DATE,
   MODIFY_DESC          VARCHAR2(255),
   VALID_DATE           DATE,
   EXPIRE_DATE          DATE,
   CONTENT              VARCHAR2(4000),
   CONTENT1             VARCHAR2(4000),
   CONTENT2             VARCHAR2(4000),
   CONTENT3             VARCHAR2(4000),
   CONTENT4             VARCHAR2(4000),
   CONTENT5             VARCHAR2(4000),
   CONTENT6             VARCHAR2(4000),
   CONTENT7             VARCHAR2(4000),
   CONTENT8             VARCHAR2(4000),
   CONTENT9             VARCHAR2(4000),
   CONTENT10            VARCHAR2(4000),
   CONTENT11            VARCHAR2(4000),
   CONTENT12            VARCHAR2(4000),
   CONTENT13            VARCHAR2(4000),
   CONTENT14            VARCHAR2(4000),
   CONTENT15            VARCHAR2(4000)
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

