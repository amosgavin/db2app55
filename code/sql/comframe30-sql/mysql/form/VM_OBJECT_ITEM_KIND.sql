/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:47:12                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_OBJECT_ITEM_KIND                                   */
/*==============================================================*/
create table VM_OBJECT_ITEM_KIND
(
   KIND_ID              numeric(15,0) not null comment '分类编号',
   ITEM_KIND_NAME       varchar(255) comment '分类名称',
   ITEM_KIND_CODE       varchar(255) comment '分类编码',
   OBJECT_ITEM_TYPE     varchar(255) comment '所属单元类型',
   PARENT_KIND_ID       numeric(15,0) comment '上级分类',
   SORTBY               numeric(3,0) comment '排序号'
);

alter table VM_OBJECT_ITEM_KIND comment '对象单元分类';

alter table VM_OBJECT_ITEM_KIND
   add primary key (KIND_ID);

