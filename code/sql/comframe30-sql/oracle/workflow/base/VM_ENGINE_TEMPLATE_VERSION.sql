/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:11:40                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_ENGINE_TEMPLATE_VERSION                            */
/*==============================================================*/
create table VM_ENGINE_TEMPLATE_VERSION  (
   TEMPLATE_VERSION_ID  NUMBER(15,0)                    not null,
   ENGINE_TEMPLATE_ID   VARCHAR2(255),
   ENGINE_VERION        VARCHAR2(255),
   CREATE_DATE          DATE
);

comment on column VM_ENGINE_TEMPLATE_VERSION.TEMPLATE_VERSION_ID is
'VM�����ģ��ID';

comment on column VM_ENGINE_TEMPLATE_VERSION.ENGINE_TEMPLATE_ID is
'����ģ��ID';

comment on column VM_ENGINE_TEMPLATE_VERSION.ENGINE_VERION is
'�����������ϵİ汾';

comment on column VM_ENGINE_TEMPLATE_VERSION.CREATE_DATE is
'����ʱ��';

alter table VM_ENGINE_TEMPLATE_VERSION
   add constraint PK_VM_ENGINE_TEMPLATE_VERSION primary key (TEMPLATE_VERSION_ID);

