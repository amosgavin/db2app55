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
'��Ʒ��Ԫ�����ϵ';

comment on column VM_OBJECT_ITEM_KIND_ELEMENT.ITEM_KIND_RELAT_ID is
'��Ԫ������';

comment on column VM_OBJECT_ITEM_KIND_ELEMENT.OBJECT_ITEM_ID is
'����Ԫ���';

comment on column VM_OBJECT_ITEM_KIND_ELEMENT.ITEM_KIND_ID is
'����Ԫ������';

alter table VM_OBJECT_ITEM_KIND_ELEMENT
   add constraint PK_OBJECT_ITEM_KIND_ELEMENT primary key (ITEM_KIND_RELAT_ID);

