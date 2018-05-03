/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/19 11:00:35                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_SCHEDULE                                           */
/*==============================================================*/
create table VM_SCHEDULE  (
   WORKFLOW_ID          VARCHAR2(25)                    not null,
   QUEUE_ID             VARCHAR2(5),
   ENGINE_WORKFLOW_ID   VARCHAR2(255),
   ENGINE_TYPE          VARCHAR2(255),
   CREATE_DATE          DATE,
   STATE_DATE           DATE,
   START_DATE           DATE,
   STATE                VARCHAR2(10),
   SCHEDULE_DATE        DATE,
   DEV_ID               VARCHAR2(5),
   REGION_ID            VARCHAR2(6)
);

comment on column VM_SCHEDULE.WORKFLOW_ID is
'���������';

comment on column VM_SCHEDULE.QUEUE_ID is
'���б��';

comment on column VM_SCHEDULE.ENGINE_WORKFLOW_ID is
'�������������ʵ�����';

comment on column VM_SCHEDULE.ENGINE_TYPE is
'��������';

comment on column VM_SCHEDULE.CREATE_DATE is
'����ʱ��';

comment on column VM_SCHEDULE.STATE_DATE is
'�������ʱ��';

comment on column VM_SCHEDULE.START_DATE is
'���̶�ʱ������ʱ��';

comment on column VM_SCHEDULE.STATE is
'����״̬��W-�ȴ�����,S-������Ȼ�,F-���Ƚ���,A-�����쳣����';

comment on column VM_SCHEDULE.SCHEDULE_DATE is
'��ʼ����ʱ��';

comment on column VM_SCHEDULE.DEV_ID is
'�����߱�ʶ(����ģʽʱ������)';

comment on column VM_SCHEDULE.REGION_ID is
'������Ϣ';

alter table VM_SCHEDULE
   add constraint PK_VM_SCHE primary key (WORKFLOW_ID);

