/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:11:40                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_TEMPLATE_VERSION                                   */
/*==============================================================*/
create table VM_TEMPLATE_VERSION  (
   TEMPLATE_VERSION_ID  NUMBER(15,0)                    not null,
   ORDER_NUM            NUMBER(1,0)                     not null,
   TEMPLATE_TAG         VARCHAR2(255),
   CREATE_STAFF_ID      VARCHAR2(30),
   CREATE_DATE          DATE,
   MODIFY_DESC          VARCHAR2(255),
   VALID_DATE           DATE,
   EXPIRE_DATE          DATE,
   CONTENT              VARCHAR2(4000),
   CONTENT1             VARCHAR2(4000),
   CONTENT2             VARCHAR2(4000),
   CONTENT3             VARCHAR2(4000),
   CONTENT4             VARCHAR2(4000),
   CONTENT5             VARCHAR2(4000),
   CONTENT6             VARCHAR2(4000),
   CONTENT7             VARCHAR2(4000),
   CONTENT8             VARCHAR2(4000),
   CONTENT9             VARCHAR2(4000),
   CONTENT10            VARCHAR2(4000),
   CONTENT11            VARCHAR2(4000),
   CONTENT12            VARCHAR2(4000),
   CONTENT13            VARCHAR2(4000),
   CONTENT14            VARCHAR2(4000),
   CONTENT15            VARCHAR2(4000)
);

comment on table VM_TEMPLATE_VERSION is
'����ģ��';

comment on column VM_TEMPLATE_VERSION.TEMPLATE_VERSION_ID is
'����ģ��ID';

comment on column VM_TEMPLATE_VERSION.ORDER_NUM is
'˳��.ģ������̫�������д洢ʱʹ��';

comment on column VM_TEMPLATE_VERSION.TEMPLATE_TAG is
'����ģ����';

comment on column VM_TEMPLATE_VERSION.CREATE_STAFF_ID is
'������Ա';

comment on column VM_TEMPLATE_VERSION.CREATE_DATE is
'����ʱ��';

comment on column VM_TEMPLATE_VERSION.MODIFY_DESC is
'״̬�仯ԭ��';

comment on column VM_TEMPLATE_VERSION.VALID_DATE is
'��Чʱ��';

comment on column VM_TEMPLATE_VERSION.EXPIRE_DATE is
'ʧЧʱ��';

comment on column VM_TEMPLATE_VERSION.CONTENT is
'ģ������';

comment on column VM_TEMPLATE_VERSION.CONTENT1 is
'ģ������';

comment on column VM_TEMPLATE_VERSION.CONTENT2 is
'ģ������';

comment on column VM_TEMPLATE_VERSION.CONTENT3 is
'ģ������';

comment on column VM_TEMPLATE_VERSION.CONTENT4 is
'ģ������';

comment on column VM_TEMPLATE_VERSION.CONTENT5 is
'ģ������';

comment on column VM_TEMPLATE_VERSION.CONTENT6 is
'ģ������';

comment on column VM_TEMPLATE_VERSION.CONTENT7 is
'ģ������';

comment on column VM_TEMPLATE_VERSION.CONTENT8 is
'ģ������';

comment on column VM_TEMPLATE_VERSION.CONTENT9 is
'ģ������';

comment on column VM_TEMPLATE_VERSION.CONTENT10 is
'ģ������';

comment on column VM_TEMPLATE_VERSION.CONTENT11 is
'ģ������';

comment on column VM_TEMPLATE_VERSION.CONTENT12 is
'ģ������';

comment on column VM_TEMPLATE_VERSION.CONTENT13 is
'ģ������';

comment on column VM_TEMPLATE_VERSION.CONTENT14 is
'ģ������';

comment on column VM_TEMPLATE_VERSION.CONTENT15 is
'ģ������';

alter table VM_TEMPLATE_VERSION
   add constraint PK_VM_TEMPLATE_VERSION primary key (TEMPLATE_VERSION_ID, ORDER_NUM);

