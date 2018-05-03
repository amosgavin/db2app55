/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:09:07                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_OBJECT_ITEM_RELAT                                  */
/*==============================================================*/
create table VM_OBJECT_ITEM_RELAT  (
   ITEM_RELAT_ID        BIGINT                      not null,
   OBJECT_ITEM_ID       BIGINT                      not null,
   RELAT_OBJECT_ITEM_ID BIGINT                      not null,
   EXTEND_ATTR_A        VARCHAR(255),
   EXTEND_ATTR_B        VARCHAR(255),
   EXTEND_ATTR_C        INTEGER,
   EXTEND_ATTR_D        INTEGER,
   EXTEND_ATTR_E        BIGINT,
   EXTEND_ATTR_F        BIGINT,
   EXTEND_ATTR_G        CHAR(1),
   EXTEND_ATTR_H        CHAR(1),
   EXTEND_ATTR_I        TIMESTAMP,
   EXTEND_ATTR_J        TIMESTAMP,
   EXTEND_ATTR_K        VARCHAR(4000),
   SORT_NO              INTEGER,
   STATE                CHAR(1),
   REMARKS              VARCHAR(255),
   RELAT_TYPE           VARCHAR(255)
);

comment on table VM_OBJECT_ITEM_RELAT is
'������Ʒ����ϲ�Ʒ����Ʒ��֮��Ĺ�ϵ�����������֮��Ĺ�ϵ��
��Ʒ����/����,��Ʒ����/����
ҵ�������ҵ��';

comment on column VM_OBJECT_ITEM_RELAT.ITEM_RELAT_ID is
'��ϵ���';

comment on column VM_OBJECT_ITEM_RELAT.OBJECT_ITEM_ID is
'����Ԫ���';

comment on column VM_OBJECT_ITEM_RELAT.RELAT_OBJECT_ITEM_ID is
'��������Ԫ���';

comment on column VM_OBJECT_ITEM_RELAT.SORT_NO is
'������˳���';

comment on column VM_OBJECT_ITEM_RELAT.STATE is
'״̬';

comment on column VM_OBJECT_ITEM_RELAT.REMARKS is
'��ע';

comment on column VM_OBJECT_ITEM_RELAT.RELAT_TYPE is
'��ϵ����';

alter table VM_OBJECT_ITEM_RELAT
   add constraint PK_OBJECT_ITEM_RELAT primary key (ITEM_RELAT_ID);

