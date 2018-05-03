/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:11:40                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_ALARM_CONFIG                                       */
/*==============================================================*/
create table VM_ALARM_CONFIG  (
   ALARM_CONFIG_ID      BIGINT                    not null,
   TEMPLATE_VERSION_ID  BIGINT,
   TEMPLATE_TAG         VARCHAR(255)              not null,
   TASK_TAG             VARCHAR(255),
   DURATION_TIME_METHOD VARCHAR(300),
   ALARM_TIME_METHOD    VARCHAR(300),
   ALARM_DEAL_METHOD    VARCHAR(300),
   STATE                CHAR(1),
   IS_HOLIDAY           INTEGER
);

comment on table VM_ALARM_CONFIG is
'��ʱ�澯�������ñ�';

comment on column VM_ALARM_CONFIG.ALARM_CONFIG_ID is
'�澯����ID';

comment on column VM_ALARM_CONFIG.TEMPLATE_VERSION_ID is
'ģ��ID';

comment on column VM_ALARM_CONFIG.TEMPLATE_TAG is
'ģ�����';

comment on column VM_ALARM_CONFIG.TASK_TAG is
'�������: ��ֵ��ʾΪ�������ã�����Ϊ��������';

comment on column VM_ALARM_CONFIG.DURATION_TIME_METHOD is
'��������ʱ���ķ��� ��ֵȡĬ��ʵ��';

comment on column VM_ALARM_CONFIG.ALARM_TIME_METHOD is
'���㳬ʱʱ��ķ��� ��ֵȡĬ��ʵ��';

comment on column VM_ALARM_CONFIG.ALARM_DEAL_METHOD is
'��ʱ�澯������';

comment on column VM_ALARM_CONFIG.STATE is
'״̬';

comment on column VM_ALARM_CONFIG.IS_HOLIDAY is
'�Ƿ��ǽڼ��ձ�־';

alter table VM_ALARM_CONFIG
   add constraint PK_VM_ALARM_CONFIG primary key (ALARM_CONFIG_ID);

