/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:09:07                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_OBJECT_ITEM_RELAT                                  */
/*==============================================================*/
create table VM_OBJECT_ITEM_RELAT  (
   ITEM_RELAT_ID        NUMBER(15)                      not null,
   OBJECT_ITEM_ID       NUMBER(15)                      not null,
   RELAT_OBJECT_ITEM_ID NUMBER(15)                      not null,
   EXTEND_ATTR_A        VARCHAR2(255),
   EXTEND_ATTR_B        VARCHAR2(255),
   EXTEND_ATTR_C        INTEGER,
   EXTEND_ATTR_D        INTEGER,
   EXTEND_ATTR_E        NUMBER(10,2),
   EXTEND_ATTR_F        NUMBER(10,2),
   EXTEND_ATTR_G        CHAR(1),
   EXTEND_ATTR_H        CHAR(1),
   EXTEND_ATTR_I        DATE,
   EXTEND_ATTR_J        DATE,
   EXTEND_ATTR_K        VARCHAR2(4000),
   SORT_NO              NUMBER(3),
   STATE                CHAR(1),
   REMARKS              VARCHAR2(255),
   RELAT_TYPE           VARCHAR2(255)
);

comment on table VM_OBJECT_ITEM_RELAT is
'基本产品、组合产品、产品包之间的关系、服务与服务之间的关系等
产品互斥/依赖,产品引用/包含
业务包含子业务';

comment on column VM_OBJECT_ITEM_RELAT.ITEM_RELAT_ID is
'关系编号';

comment on column VM_OBJECT_ITEM_RELAT.OBJECT_ITEM_ID is
'对象单元编号';

comment on column VM_OBJECT_ITEM_RELAT.RELAT_OBJECT_ITEM_ID is
'关联对象单元编号';

comment on column VM_OBJECT_ITEM_RELAT.SORT_NO is
'关联的顺序号';

comment on column VM_OBJECT_ITEM_RELAT.STATE is
'状态';

comment on column VM_OBJECT_ITEM_RELAT.REMARKS is
'备注';

comment on column VM_OBJECT_ITEM_RELAT.RELAT_TYPE is
'关系类型';

alter table VM_OBJECT_ITEM_RELAT
   add constraint PK_OBJECT_ITEM_RELAT primary key (ITEM_RELAT_ID);

