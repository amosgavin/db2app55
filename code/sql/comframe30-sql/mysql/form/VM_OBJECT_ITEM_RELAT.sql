/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:47:12                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_OBJECT_ITEM_RELAT                                  */
/*==============================================================*/
create table VM_OBJECT_ITEM_RELAT
(
   ITEM_RELAT_ID        numeric(15,0) not null comment '��ϵ���',
   OBJECT_ITEM_ID       numeric(15,0) not null comment '����Ԫ���',
   RELAT_OBJECT_ITEM_ID numeric(15,0) not null comment '��������Ԫ���',
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
   SORT_NO              numeric(3,0) comment '������˳���',
   STATE                char(1) comment '״̬',
   REMARKS              varchar(255) comment '��ע',
   RELAT_TYPE           varchar(255) comment '��ϵ����'
);

alter table VM_OBJECT_ITEM_RELAT comment '������Ʒ����ϲ�Ʒ����Ʒ��֮��Ĺ�ϵ�����������֮��Ĺ�ϵ��
��Ʒ����/����,��Ʒ����/����
ҵ';

alter table VM_OBJECT_ITEM_RELAT
   add primary key (ITEM_RELAT_ID);

