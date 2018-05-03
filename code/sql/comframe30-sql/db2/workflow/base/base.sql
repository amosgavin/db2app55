/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:11:40                           */
/*==============================================================*/


alter table H_VM_TEMPLATE
   drop primary key cascade;

drop table H_VM_TEMPLATE cascade constraints;

alter table VM_ALARM_CONFIG
   drop primary key cascade;

drop table VM_ALARM_CONFIG cascade constraints;

alter table VM_ENGINE_TEMPLATE_VERSION
   drop primary key cascade;

drop table VM_ENGINE_TEMPLATE_VERSION cascade constraints;

drop table VM_HOLIDAY cascade constraints;

alter table VM_QUEUE_CONFIG
   drop primary key cascade;

drop table VM_QUEUE_CONFIG cascade constraints;

alter table VM_TEMPLATE
   drop primary key cascade;

drop table VM_TEMPLATE cascade constraints;

alter table VM_TEMPLATE_VERSION
   drop primary key cascade;

drop table VM_TEMPLATE_VERSION cascade constraints;

alter table VM_WORKFLOW_OBJECT
   drop primary key cascade;

drop table VM_WORKFLOW_OBJECT cascade constraints;

alter table VM_QUEUE_SERVER_REGIST
   drop primary key cascade;

drop table VM_QUEUE_SERVER_REGIST cascade constraints;

start H_VM_TEMPLATE.sql;

start VM_ALARM_CONFIG.sql;

start VM_ENGINE_TEMPLATE_VERSION.sql;

start VM_HOLIDAY.sql;

start VM_QUEUE_CONFIG.sql;

start VM_TEMPLATE.sql;

start VM_TEMPLATE_VERSION.sql;

start VM_WORKFLOW_OBJECT.sql;

start VM_QUEUE_SERVER_REGIST.sql;
