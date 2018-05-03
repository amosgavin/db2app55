/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:06:00                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_EXCEPTION_DESC                                     */
/*==============================================================*/
create table VM_EXCEPTION_DESC  (
   EXCEPTION_DESC_CODE  VARCHAR(255)                   not null,
   EXCEPTION_DESC_NAME  VARCHAR(255),
   EXCEPTION_DESC_TYPE  CHAR(1),
   CREATE_DATE          TIMESTAMP,
   STATE                CHAR(1)
);

comment on column VM_EXCEPTION_DESC.EXCEPTION_DESC_CODE is
'�쳣���α���';

comment on column VM_EXCEPTION_DESC.EXCEPTION_DESC_NAME is
'�쳣��������';

comment on column VM_EXCEPTION_DESC.EXCEPTION_DESC_TYPE is
'�쳣��������(A:����ȫ���쳣ԭ�����,B:ֻ������һ���쳣ԭ��)';

comment on column VM_EXCEPTION_DESC.CREATE_DATE is
'����ʱ��';

comment on column VM_EXCEPTION_DESC.STATE is
'״̬ U ��ǰ���� E ��������';

alter table VM_EXCEPTION_DESC
   add constraint PK_VM_EXCEPTION_DESC primary key (EXCEPTION_DESC_CODE);

