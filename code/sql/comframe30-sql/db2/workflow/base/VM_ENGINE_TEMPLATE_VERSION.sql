/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:11:40                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_ENGINE_TEMPLATE_VERSION                            */
/*==============================================================*/
create table VM_ENGINE_TEMPLATE_VERSION  (
   TEMPLATE_VERSION_ID  BIGINT                    not null,
   ENGINE_TEMPLATE_ID   VARCHAR(255),
   ENGINE_VERION        VARCHAR(255),
   CREATE_DATE          TIMESTAMP
);

comment on column VM_ENGINE_TEMPLATE_VERSION.TEMPLATE_VERSION_ID is
'VM引擎的模板ID';

comment on column VM_ENGINE_TEMPLATE_VERSION.ENGINE_TEMPLATE_ID is
'引擎模板ID';

comment on column VM_ENGINE_TEMPLATE_VERSION.ENGINE_VERION is
'流程在引擎上的版本';

comment on column VM_ENGINE_TEMPLATE_VERSION.CREATE_DATE is
'创建时间';

alter table VM_ENGINE_TEMPLATE_VERSION
   add constraint PK_VM_ENGINE_TEMPLATE_VERSION primary key (TEMPLATE_VERSION_ID);

