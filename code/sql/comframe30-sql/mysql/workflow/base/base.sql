/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:47:58                           */
/*==============================================================*/


alter table H_VM_TEMPLATE
   drop primary key;

drop table if exists H_VM_TEMPLATE;

alter table VM_ALARM_CONFIG
   drop primary key;

drop table if exists VM_ALARM_CONFIG;

alter table VM_ENGINE_TEMPLATE_VERSION
   drop primary key;

drop table if exists VM_ENGINE_TEMPLATE_VERSION;

drop table if exists VM_HOLIDAY;

alter table VM_QUEUE_CONFIG
   drop primary key;

drop table if exists VM_QUEUE_CONFIG;

alter table VM_TEMPLATE
   drop primary key;

drop table if exists VM_TEMPLATE;

alter table VM_TEMPLATE_VERSION
   drop primary key;

drop table if exists VM_TEMPLATE_VERSION;

alter table VM_WORKFLOW_OBJECT
   drop primary key;

drop table if exists VM_WORKFLOW_OBJECT;

alter table VM_QUEUE_SERVER_REGIST
   drop primary key;

drop table if exists VM_QUEUE_SERVER_REGIST;

mysql> source <file_name>;

mysql> source <file_name>;

mysql> source <file_name>;

mysql> source <file_name>;

mysql> source <file_name>;

mysql> source <file_name>;

mysql> source <file_name>;

mysql> source <file_name>;

