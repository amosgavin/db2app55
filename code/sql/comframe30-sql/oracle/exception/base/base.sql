/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:06:00                           */
/*==============================================================*/


alter table VM_EXCEPTION_CODE
   drop primary key cascade;

drop table VM_EXCEPTION_CODE cascade constraints;

alter table VM_EXCEPTION_CODE_DESC_RELAT
   drop primary key cascade;

drop table VM_EXCEPTION_CODE_DESC_RELAT cascade constraints;

alter table VM_EXCEPTION_DESC
   drop primary key cascade;

drop table VM_EXCEPTION_DESC cascade constraints;

alter table VM_EXCEPTION_RULE
   drop primary key cascade;

drop table VM_EXCEPTION_RULE cascade constraints;

start VM_EXCEPTION_CODE.sql;

start VM_EXCEPTION_CODE_DESC_RELAT.sql;

start VM_EXCEPTION_DESC.sql;

start VM_EXCEPTION_RULE.sql;

