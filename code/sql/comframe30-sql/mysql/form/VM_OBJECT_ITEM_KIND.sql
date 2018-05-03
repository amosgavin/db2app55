/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:47:12                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_OBJECT_ITEM_KIND                                   */
/*==============================================================*/
create table VM_OBJECT_ITEM_KIND
(
   KIND_ID              numeric(15,0) not null comment '������',
   ITEM_KIND_NAME       varchar(255) comment '��������',
   ITEM_KIND_CODE       varchar(255) comment '�������',
   OBJECT_ITEM_TYPE     varchar(255) comment '������Ԫ����',
   PARENT_KIND_ID       numeric(15,0) comment '�ϼ�����',
   SORTBY               numeric(3,0) comment '�����'
);

alter table VM_OBJECT_ITEM_KIND comment '����Ԫ����';

alter table VM_OBJECT_ITEM_KIND
   add primary key (KIND_ID);

