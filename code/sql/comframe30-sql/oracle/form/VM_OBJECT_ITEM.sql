/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:09:07                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_OBJECT_ITEM                                        */
/*==============================================================*/
create table VM_OBJECT_ITEM  (
   OBJECT_ITEM_ID       NUMBER(15)                      not null,
   CODE                 VARCHAR2(255),
   NAME                 VARCHAR2(255),
   DESCRIPTION          VARCHAR2(4000),
   ITEM_TYPE            VARCHAR2(255),
   SORT_BY              NUMBER(3),
   BUSINESS_DOMAIN_ID   NUMBER(15),
   BUSINESS_TYPE_ID     NUMBER(15),
   CREATER              NUMBER(15),
   CHECKER              NUMBER(15),
   ISLOCK               CHAR(1),
   STATE                CHAR(1),
   REMARKS              VARCHAR2(255),
   CREATE_DATE          DATE,
   MODIFY_DATE          DATE,
   URL                  VARCHAR2(255),
   DATA_COMMIT_SV       VARCHAR2(255),
   DATA_COMMIT_SV_FUNCTION VARCHAR2(255),
   FINISHCODE_SV        VARCHAR2(255),
   FINISHCODE_SV_FUNCTION VARCHAR2(255),
   FINISHCODE_DS        VARCHAR2(255),
   FINISHCODE_DS_PARAM  VARCHAR2(255)
);

comment on column VM_OBJECT_ITEM.OBJECT_ITEM_ID is
'����Ԫ���';

comment on column VM_OBJECT_ITEM.CODE is
'����';

comment on column VM_OBJECT_ITEM.NAME is
'����';

comment on column VM_OBJECT_ITEM.DESCRIPTION is
'����';

comment on column VM_OBJECT_ITEM.ITEM_TYPE is
'��Ԫ����';

comment on column VM_OBJECT_ITEM.SORT_BY is
'����ʽ';

comment on column VM_OBJECT_ITEM.BUSINESS_DOMAIN_ID is
'����ҵ������';

comment on column VM_OBJECT_ITEM.BUSINESS_TYPE_ID is
'ҵ������';

comment on column VM_OBJECT_ITEM.CREATER is
'�����û�';

comment on column VM_OBJECT_ITEM.CHECKER is
'�����û�';

comment on column VM_OBJECT_ITEM.ISLOCK is
'����״̬';

comment on column VM_OBJECT_ITEM.STATE is
'״̬';

comment on column VM_OBJECT_ITEM.REMARKS is
'��ע';

comment on column VM_OBJECT_ITEM.CREATE_DATE is
'����ʱ��';

comment on column VM_OBJECT_ITEM.MODIFY_DATE is
'�޸�ʱ��';

comment on column VM_OBJECT_ITEM.URL is
'ҳ���ָ��ҵ��ҳ���URL';

comment on column VM_OBJECT_ITEM.DATA_COMMIT_SV is
'�ص������ύ����';

comment on column VM_OBJECT_ITEM.DATA_COMMIT_SV_FUNCTION is
'�ص������ύ����֮����';

comment on column VM_OBJECT_ITEM.FINISHCODE_SV is
'�ص��������';

comment on column VM_OBJECT_ITEM.FINISHCODE_SV_FUNCTION is
'�ص��������֮����';

comment on column VM_OBJECT_ITEM.FINISHCODE_DS is
'�ص����DS';

comment on column VM_OBJECT_ITEM.FINISHCODE_DS_PARAM is
'�ص����DS����';

alter table VM_OBJECT_ITEM
   add constraint PK_OBJECT_ITEM primary key (OBJECT_ITEM_ID);

