/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:07:28                           */
/*==============================================================*/


alter table VM_EXCEPTION_RECORD
   drop primary key cascade;

drop table VM_EXCEPTION_RECORD cascade constraints;

start VM_EXCEPTION_RECORD.sql;

