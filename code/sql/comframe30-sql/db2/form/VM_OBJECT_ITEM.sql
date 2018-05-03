/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:09:07                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_OBJECT_ITEM                                        */
/*==============================================================*/
create table VM_OBJECT_ITEM  (
   OBJECT_ITEM_ID       BIGINT                      not null,
   CODE                 VARCHAR(255),
   NAME                 VARCHAR(255),
   DESCRIPTION          VARCHAR(4000),
   ITEM_TYPE            VARCHAR(255),
   SORT_BY              INTEGER,
   BUSINESS_DOMAIN_ID   BIGINT,
   BUSINESS_TYPE_ID     BIGINT,
   CREATER              BIGINT,
   CHECKER              BIGINT,
   ISLOCK               CHAR(1),
   STATE                CHAR(1),
   REMARKS              VARCHAR(255),
   CREATE_DATE          TIMESTAMP,
   MODIFY_DATE          TIMESTAMP,
   URL                  VARCHAR(255),
   DATA_COMMIT_SV       VARCHAR(255),
   DATA_COMMIT_SV_FUNCTION VARCHAR(255),
   FINISHCODE_SV        VARCHAR(255),
   FINISHCODE_SV_FUNCTION VARCHAR(255),
   FINISHCODE_DS        VARCHAR(255),
   FINISHCODE_DS_PARAM  VARCHAR(255)
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

