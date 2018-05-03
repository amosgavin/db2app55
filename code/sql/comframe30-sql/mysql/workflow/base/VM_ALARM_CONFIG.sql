/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:47:58                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_ALARM_CONFIG                                       */
/*==============================================================*/
create table VM_ALARM_CONFIG
(
   ALARM_CONFIG_ID      numeric(15,0) not null comment '�澯����ID',
   TEMPLATE_VERSION_ID  numeric(15,0) comment 'ģ��ID',
   TEMPLATE_TAG         varchar(255) not null comment 'ģ�����',
   TASK_TAG             varchar(255) comment '�������: ��ֵ��ʾΪ�������ã�����Ϊ��������',
   DURATION_TIME_METHOD varchar(300) comment '��������ʱ���ķ��� ��ֵȡĬ��ʵ��',
   ALARM_TIME_METHOD    varchar(300) comment '���㳬ʱʱ��ķ��� ��ֵȡĬ��ʵ��',
   ALARM_DEAL_METHOD    varchar(300) comment '��ʱ�澯������',
   STATE                char(1) comment '״̬',
   IS_HOLIDAY           numeric(1,0) comment '�Ƿ��ǽڼ��ձ�־'
);

alter table VM_ALARM_CONFIG comment '��ʱ�澯�������ñ�';

alter table VM_ALARM_CONFIG
   add primary key (ALARM_CONFIG_ID);

