/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:06:00                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_EXCEPTION_CODE_DESC_RELAT                          */
/*==============================================================*/
create table VM_EXCEPTION_CODE_DESC_RELAT  (
   EXCEPTION_CODE       VARCHAR(255)                   not null,
   EXCEPTION_DESC_CODE  VARCHAR(255)                   not null,
   CREATE_DATE          TIMESTAMP,
   STATE                CHAR(1)
);

comment on column VM_EXCEPTION_CODE_DESC_RELAT.EXCEPTION_CODE is
'�쳣ԭ�����';

comment on column VM_EXCEPTION_CODE_DESC_RELAT.EXCEPTION_DESC_CODE is
'�쳣���α���';

comment on column VM_EXCEPTION_CODE_DESC_RELAT.CREATE_DATE is
'����ʱ��';

comment on column VM_EXCEPTION_CODE_DESC_RELAT.STATE is
'״̬ U ��ǰ���� E ��������';

alter table VM_EXCEPTION_CODE_DESC_RELAT
   add constraint PK_VM_EXCEPTION_CODE_DESC_RELA primary key (EXCEPTION_CODE, EXCEPTION_DESC_CODE);

