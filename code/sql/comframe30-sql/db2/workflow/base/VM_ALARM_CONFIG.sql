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
'超时告警机制配置表';

comment on column VM_ALARM_CONFIG.ALARM_CONFIG_ID is
'告警配置ID';

comment on column VM_ALARM_CONFIG.TEMPLATE_VERSION_ID is
'模版ID';

comment on column VM_ALARM_CONFIG.TEMPLATE_TAG is
'模版编码';

comment on column VM_ALARM_CONFIG.TASK_TAG is
'任务编码: 空值表示为流程配置，否则为任务配置';

comment on column VM_ALARM_CONFIG.DURATION_TIME_METHOD is
'计算正常时常的方法 空值取默认实现';

comment on column VM_ALARM_CONFIG.ALARM_TIME_METHOD is
'计算超时时间的方法 空值取默认实现';

comment on column VM_ALARM_CONFIG.ALARM_DEAL_METHOD is
'超时告警处理方法';

comment on column VM_ALARM_CONFIG.STATE is
'状态';

comment on column VM_ALARM_CONFIG.IS_HOLIDAY is
'是否考虑节假日标志';

alter table VM_ALARM_CONFIG
   add constraint PK_VM_ALARM_CONFIG primary key (ALARM_CONFIG_ID);

