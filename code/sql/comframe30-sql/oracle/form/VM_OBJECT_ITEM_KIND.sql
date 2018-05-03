/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:09:07                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_OBJECT_ITEM_KIND                                   */
/*==============================================================*/
create table VM_OBJECT_ITEM_KIND  (
   KIND_ID              NUMBER(15)                      not null,
   ITEM_KIND_NAME       VARCHAR2(255),
   ITEM_KIND_CODE       VARCHAR2(255),
   OBJECT_ITEM_TYPE     VARCHAR2(255),
   PARENT_KIND_ID       NUMBER(15),
   SORTBY               NUMBER(3)
);

comment on table VM_OBJECT_ITEM_KIND is
'����Ԫ����';

comment on column VM_OBJECT_ITEM_KIND.KIND_ID is
'������';

comment on column VM_OBJECT_ITEM_KIND.ITEM_KIND_NAME is
'��������';

comment on column VM_OBJECT_ITEM_KIND.ITEM_KIND_CODE is
'�������';

comment on column VM_OBJECT_ITEM_KIND.OBJECT_ITEM_TYPE is
'������Ԫ����';

comment on column VM_OBJECT_ITEM_KIND.PARENT_KIND_ID is
'�ϼ�����';

comment on column VM_OBJECT_ITEM_KIND.SORTBY is
'�����';

alter table VM_OBJECT_ITEM_KIND
   add constraint PK_OBJECT_ITEM_KIND primary key (KIND_ID);
