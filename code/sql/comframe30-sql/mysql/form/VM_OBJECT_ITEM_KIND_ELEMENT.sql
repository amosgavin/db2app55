/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:47:12                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_OBJECT_ITEM_KIND_ELEMENT                           */
/*==============================================================*/
create table VM_OBJECT_ITEM_KIND_ELEMENT
(
   ITEM_KIND_RELAT_ID   numeric(15,0) not null comment '��Ԫ������',
   OBJECT_ITEM_ID       numeric(15,0) comment '����Ԫ���',
   ITEM_KIND_ID         numeric(15,0) comment '����Ԫ������'
);

alter table VM_OBJECT_ITEM_KIND_ELEMENT comment '��Ʒ��Ԫ�����ϵ';

alter table VM_OBJECT_ITEM_KIND_ELEMENT
   add primary key (ITEM_KIND_RELAT_ID);

