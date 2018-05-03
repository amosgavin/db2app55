/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:11:40                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_TEMPLATE_VERSION                                   */
/*==============================================================*/
create table VM_TEMPLATE_VERSION  (
   TEMPLATE_VERSION_ID  BIGINT                    not null,
   ORDER_NUM            INTEGER                     not null,
   TEMPLATE_TAG         VARCHAR(255),
   CREATE_STAFF_ID      VARCHAR(30),
   CREATE_DATE          TIMESTAMP,
   MODIFY_DESC          VARCHAR(252),
   VALID_DATE           TIMESTAMP,
   EXPIRE_DATE          TIMESTAMP,
   CONTENT              VARCHAR(2000),
   CONTENT1             VARCHAR(2000),
   CONTENT2             VARCHAR(2000),
   CONTENT3             VARCHAR(2000),
   CONTENT4             VARCHAR(2000),
   CONTENT5             VARCHAR(2000),
   CONTENT6             VARCHAR(2000),
   CONTENT7             VARCHAR(2000),
   CONTENT8             VARCHAR(2000),
   CONTENT9             VARCHAR(2000),
   CONTENT10            VARCHAR(2000),
   CONTENT11            VARCHAR(2000),
   CONTENT12            VARCHAR(2000),
   CONTENT13            VARCHAR(2000),
   CONTENT14            VARCHAR(2000),
   CONTENT15            VARCHAR(2000)
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

