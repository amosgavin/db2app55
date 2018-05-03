/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:48:22                           */
/*==============================================================*/


drop index IDX_H_T_WID on H_VM_TASK;

alter table H_VM_TASK
   drop primary key;

drop table if exists H_VM_TASK;

drop index IDX_H_T_T_WID on H_VM_TASK_TS;

alter table H_VM_TASK_TS
   drop primary key;

drop table if exists H_VM_TASK_TS;

drop index IDX_H_W_OID on H_VM_WF;

alter table H_VM_WF
   drop primary key;

drop table if exists H_VM_WF;

drop index IDX_H_A_WFID on H_VM_WF_ATTR;

drop index IDX_H_W_A_CV on H_VM_WF_ATTR;

alter table H_VM_WF_ATTR
   drop primary key;

drop table if exists H_VM_WF_ATTR;

drop index IDX_D_T_WID on VM_DEAL_TASK;

alter table VM_DEAL_TASK
   drop primary key;

drop table if exists VM_DEAL_TASK;

alter table VM_SCHEDULE
   drop primary key;

drop table if exists VM_SCHEDULE;

drop index IDX_TA_WID on VM_TASK;

alter table VM_TASK
   drop primary key;

drop table if exists VM_TASK;

drop index IDX_T_T_WID on VM_TASK_TS;

alter table VM_TASK_TS
   drop primary key;

drop table if exists VM_TASK_TS;

drop index IDX_WF_OID on VM_WF;

drop index IDX_WF_P_TID on VM_WF;

alter table VM_WF
   drop primary key;

drop table if exists VM_WF;

drop index IDX_W_A_WID on VM_WF_ATTR;

drop index IDX_A_C_V on VM_WF_ATTR;

alter table VM_WF_ATTR
   drop primary key;

drop table if exists VM_WF_ATTR;

mysql> source <file_name>;

mysql> source <file_name>;

mysql> source <file_name>;

mysql> source <file_name>;

mysql> source <file_name>;

mysql> source <file_name>;

mysql> source <file_name>;

mysql> source <file_name>;

mysql> source <file_name>;

mysql> source <file_name>;

