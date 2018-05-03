/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:09:07                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_OBJECT_ITEM_URL                                    */
/*==============================================================*/
create table VM_OBJECT_ITEM_URL  (
   URL_BUSI_TYPE        INTEGER                       not null,
   URL                  VARCHAR(255),
   OBJECT_ITEM_ID       BIGINT                      not null
);

comment on table VM_OBJECT_ITEM_URL is
'对象URL';

comment on column VM_OBJECT_ITEM_URL.URL_BUSI_TYPE is
'URL类型';

comment on column VM_OBJECT_ITEM_URL.URL is
'URL';

comment on column VM_OBJECT_ITEM_URL.OBJECT_ITEM_ID is
'对象单元编号';

alter table VM_OBJECT_ITEM_URL
   add constraint PK_OBJECT_ITEM_URL primary key (URL_BUSI_TYPE, OBJECT_ITEM_ID);

