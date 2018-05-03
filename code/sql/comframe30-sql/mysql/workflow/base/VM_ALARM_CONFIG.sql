/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:47:58                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_ALARM_CONFIG                                       */
/*==============================================================*/
create table VM_ALARM_CONFIG
(
   ALARM_CONFIG_ID      numeric(15,0) not null comment '告警配置ID',
   TEMPLATE_VERSION_ID  numeric(15,0) comment '模版ID',
   TEMPLATE_TAG         varchar(255) not null comment '模版编码',
   TASK_TAG             varchar(255) comment '任务编码: 空值表示为流程配置，否则为任务配置',
   DURATION_TIME_METHOD varchar(300) comment '计算正常时常的方法 空值取默认实现',
   ALARM_TIME_METHOD    varchar(300) comment '计算超时时间的方法 空值取默认实现',
   ALARM_DEAL_METHOD    varchar(300) comment '超时告警处理方法',
   STATE                char(1) comment '状态',
   IS_HOLIDAY           numeric(1,0) comment '是否考虑节假日标志'
);

alter table VM_ALARM_CONFIG comment '超时告警机制配置表';

alter table VM_ALARM_CONFIG
   add primary key (ALARM_CONFIG_ID);

