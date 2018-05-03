/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:11:40                           */
/*==============================================================*/


/*==============================================================*/
/* Table: H_VM_TEMPLATE                                         */
/*==============================================================*/
create table H_VM_TEMPLATE  (
   HIS_ID               BIGINT                    not null,
   TEMPLATE_TAG         VARCHAR(255),
   TEMPLATE_TYPE        VARCHAR(255),
   LABEL                VARCHAR(255),
   QUEUE_ID             VARCHAR(5)                     not null,
   ENGINE_TYPE          VARCHAR(255),
   PUBLISH              CHAR(1),
   CREATE_STAFF         VARCHAR(255),
   CREATE_DATE          TIMESTAMP,
   STATE_DATE           TIMESTAMP,
   STATE                CHAR(1),
   REMARK               VARCHAR(255)
);

comment on table H_VM_TEMPLATE is
'����ģ��';

comment on column H_VM_TEMPLATE.HIS_ID is
'����';

comment on column H_VM_TEMPLATE.TEMPLATE_TAG is
'����ģ����';

comment on column H_VM_TEMPLATE.TEMPLATE_TYPE is
'����ģ�����ͣ�workflow,process';

comment on column H_VM_TEMPLATE.LABEL is
'����ģ������';

comment on column H_VM_TEMPLATE.QUEUE_ID is
'���̶���';

comment on column H_VM_TEMPLATE.ENGINE_TYPE is
'��������';

comment on column H_VM_TEMPLATE.PUBLISH is
'����ģʽ(Y:���ļ���ʽ,N:�ļ���ʽ)';

comment on column H_VM_TEMPLATE.CREATE_DATE is
'����ʱ��';

comment on column H_VM_TEMPLATE.STATE_DATE is
'״̬�仯ʱ��';

comment on column H_VM_TEMPLATE.STATE is
'״̬:U,��Ч;E:ʧЧ';

comment on column H_VM_TEMPLATE.REMARK is
'��ע';

alter table H_VM_TEMPLATE
   add constraint PK_H_VM_TEMPLATE primary key (HIS_ID);

