/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:06:00                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_EXCEPTION_RULE                                     */
/*==============================================================*/
create table VM_EXCEPTION_RULE  (
   EXCEPTION_RULE_ID    BIGINT                    not null,
   EXCEPTION_DESC_CODE  VARCHAR(255),
   CURRENT_TEMPLATE_TAG VARCHAR(255),
   NEXT_TEMPLATE_TAG    VARCHAR(255),
   EXCEPTION_RULE_REMARKS VARCHAR(255),
   CREATE_DATE          TIMESTAMP,
   STATE                CHAR(1)
);

comment on column VM_EXCEPTION_RULE.EXCEPTION_RULE_ID is
'�쳣���������ʶ(����)';

comment on column VM_EXCEPTION_RULE.EXCEPTION_DESC_CODE is
'�쳣���α���';

comment on column VM_EXCEPTION_RULE.CURRENT_TEMPLATE_TAG is
'��ǰ������ʵ����ģ�����';

comment on column VM_EXCEPTION_RULE.NEXT_TEMPLATE_TAG is
'�쳣��������ģ�����';

comment on column VM_EXCEPTION_RULE.EXCEPTION_RULE_REMARKS is
'�쳣����������Ϣ';

comment on column VM_EXCEPTION_RULE.CREATE_DATE is
'����ʱ��';

comment on column VM_EXCEPTION_RULE.STATE is
'״̬ U ��ǰ���� E ��������';

alter table VM_EXCEPTION_RULE
   add constraint PK_VM_EXCEPTION_RULE primary key (EXCEPTION_RULE_ID);

