/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/19 11:00:35                           */
/*==============================================================*/


/*==============================================================*/
/* Table: H_VM_WF_ATTR                                          */
/*==============================================================*/
create table H_VM_WF_ATTR  (
   ATTR_ID              NUMBER(15,0)                    not null,
   WORKFLOW_ID          VARCHAR2(25),
   QUEUE_ID             VARCHAR2(5),
   ATTR_CODE            VARCHAR2(255),
   ATTR_NAME            VARCHAR2(255),
   ATTR_VALUE           VARCHAR2(255),
   REGION_ID            VARCHAR2(6),
   CREATE_DATE          DATE,
   TRANSFER_DATE        DATE
);

comment on column H_VM_WF_ATTR.ATTR_ID is
'����ʵ�����Ա�ʶ��ʷ��';

comment on column H_VM_WF_ATTR.WORKFLOW_ID is
'���̱�ʶ';

comment on column H_VM_WF_ATTR.QUEUE_ID is
'���̶���';

comment on column H_VM_WF_ATTR.ATTR_CODE is
'���Ա���';

comment on column H_VM_WF_ATTR.ATTR_NAME is
'��������';

comment on column H_VM_WF_ATTR.ATTR_VALUE is
'����ֵ';

comment on column H_VM_WF_ATTR.REGION_ID is
'������Ϣ';

comment on column H_VM_WF_ATTR.CREATE_DATE is
'����ʱ��';

comment on column H_VM_WF_ATTR.TRANSFER_DATE is
'����ʷ�¼�';

alter table H_VM_WF_ATTR
   add constraint PK_H_VM_WF_A primary key (ATTR_ID);

/*==============================================================*/
/* Index: IDX_H_W_A_CV                                          */
/*==============================================================*/
create index IDX_H_W_A_CV on H_VM_WF_ATTR (
   ATTR_CODE ASC,
   ATTR_VALUE ASC
);

/*==============================================================*/
/* Index: IDX_H_A_WFID                                          */
/*==============================================================*/
create index IDX_H_A_WFID on H_VM_WF_ATTR (
   WORKFLOW_ID ASC
);

