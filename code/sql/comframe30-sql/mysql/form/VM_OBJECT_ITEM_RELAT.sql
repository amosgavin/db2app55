/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:47:12                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_OBJECT_ITEM_RELAT                                  */
/*==============================================================*/
create table VM_OBJECT_ITEM_RELAT
(
   ITEM_RELAT_ID        numeric(15,0) not null comment '关系编号',
   OBJECT_ITEM_ID       numeric(15,0) not null comment '对象单元编号',
   RELAT_OBJECT_ITEM_ID numeric(15,0) not null comment '关联对象单元编号',
   EXTEND_ATTR_A        varchar(255),
   EXTEND_ATTR_B        varchar(255),
   EXTEND_ATTR_C        int,
   EXTEND_ATTR_D        int,
   EXTEND_ATTR_E        numeric(10,2),
   EXTEND_ATTR_F        numeric(10,2),
   EXTEND_ATTR_G        char(1),
   EXTEND_ATTR_H        char(1),
   EXTEND_ATTR_I        datetime,
   EXTEND_ATTR_J        datetime,
   EXTEND_ATTR_K        varchar(4000),
   SORT_NO              numeric(3,0) comment '关联的顺序号',
   STATE                char(1) comment '状态',
   REMARKS              varchar(255) comment '备注',
   RELAT_TYPE           varchar(255) comment '关系类型'
);

alter table VM_OBJECT_ITEM_RELAT comment '基本产品、组合产品、产品包之间的关系、服务与服务之间的关系等
产品互斥/依赖,产品引用/包含
业';

alter table VM_OBJECT_ITEM_RELAT
   add primary key (ITEM_RELAT_ID);

