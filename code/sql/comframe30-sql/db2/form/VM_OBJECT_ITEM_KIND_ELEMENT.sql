/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:09:07                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_OBJECT_ITEM_KIND_ELEMENT                           */
/*==============================================================*/
create table VM_OBJECT_ITEM_KIND_ELEMENT  (
   ITEM_KIND_RELAT_ID   BIGINT                      not null,
   OBJECT_ITEM_ID       BIGINT,
   ITEM_KIND_ID         BIGINT
);

comment on table VM_OBJECT_ITEM_KIND_ELEMENT is
'产品单元分类关系';

comment on column VM_OBJECT_ITEM_KIND_ELEMENT.ITEM_KIND_RELAT_ID is
'单元分类编号';

comment on column VM_OBJECT_ITEM_KIND_ELEMENT.OBJECT_ITEM_ID is
'对象单元编号';

comment on column VM_OBJECT_ITEM_KIND_ELEMENT.ITEM_KIND_ID is
'对象单元分类编号';

alter table VM_OBJECT_ITEM_KIND_ELEMENT
   add constraint PK_OBJECT_ITEM_KIND_ELEMENT primary key (ITEM_KIND_RELAT_ID);

