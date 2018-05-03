/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:09:07                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_OBJECT_ITEM_KIND                                   */
/*==============================================================*/
create table VM_OBJECT_ITEM_KIND  (
   KIND_ID              BIGINT                      not null,
   ITEM_KIND_NAME       VARCHAR(255),
   ITEM_KIND_CODE       VARCHAR(255),
   OBJECT_ITEM_TYPE     VARCHAR(255),
   PARENT_KIND_ID       BIGINT,
   SORTBY               INTEGER
);

comment on table VM_OBJECT_ITEM_KIND is
'对象单元分类';

comment on column VM_OBJECT_ITEM_KIND.KIND_ID is
'分类编号';

comment on column VM_OBJECT_ITEM_KIND.ITEM_KIND_NAME is
'分类名称';

comment on column VM_OBJECT_ITEM_KIND.ITEM_KIND_CODE is
'分类编码';

comment on column VM_OBJECT_ITEM_KIND.OBJECT_ITEM_TYPE is
'所属单元类型';

comment on column VM_OBJECT_ITEM_KIND.PARENT_KIND_ID is
'上级分类';

comment on column VM_OBJECT_ITEM_KIND.SORTBY is
'排序号';

alter table VM_OBJECT_ITEM_KIND
   add constraint PK_OBJECT_ITEM_KIND primary key (KIND_ID);

