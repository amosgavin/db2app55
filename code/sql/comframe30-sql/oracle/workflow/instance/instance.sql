/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/19 11:00:35                           */
/*==============================================================*/


drop index IDX_H_T_WID;

alter table H_VM_TASK
   drop primary key cascade;

drop table H_VM_TASK cascade constraints;

drop index IDX_H_T_T_WID;

alter table H_VM_TASK_TS
   drop primary key cascade;

drop table H_VM_TASK_TS cascade constraints;

drop index IDX_H_W_OID;

alter table H_VM_WF
   drop primary key cascade;

drop table H_VM_WF cascade constraints;

drop index IDX_H_A_WFID;

drop index IDX_H_W_A_CV;

alter table H_VM_WF_ATTR
   drop primary key cascade;

drop table H_VM_WF_ATTR cascade constraints;

drop index IDX_D_T_WID;

alter table VM_DEAL_TASK
   drop primary key cascade;

drop table VM_DEAL_TASK cascade constraints;

alter table VM_EXCEPTION_RECORD
   drop primary key cascade;

drop table VM_EXCEPTION_RECORD cascade constraints;

alter table VM_SCHEDULE
   drop primary key cascade;

drop table VM_SCHEDULE cascade constraints;

drop index IDX_TA_WID;

alter table VM_TASK
   drop primary key cascade;

drop table VM_TASK cascade constraints;

drop index IDX_T_T_WID;

alter table VM_TASK_TS
   drop primary key cascade;

drop table VM_TASK_TS cascade constraints;

drop index IDX_WF_OID;

drop index IDX_WF_P_TID;

alter table VM_WF
   drop primary key cascade;

drop table VM_WF cascade constraints;

drop index IDX_W_A_WID;

drop index IDX_A_C_V;

alter table VM_WF_ATTR
   drop primary key cascade;

drop table VM_WF_ATTR cascade constraints;

start H_VM_TASK.sql;

start H_VM_TASK_TS.sql;

start H_VM_WF.sql;

start H_VM_WF_ATTR.sql;

start VM_DEAL_TASK.sql;

start VM_EXCEPTION_RECORD.sql;

start VM_SCHEDULE.sql;

start VM_TASK.sql;

start VM_TASK_TS.sql;

start VM_WF.sql;

start VM_WF_ATTR.sql;

