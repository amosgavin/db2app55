/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:46:19                           */
/*==============================================================*/


alter table VM_EXCEPTION_CODE
   drop primary key;

drop table if exists VM_EXCEPTION_CODE;

alter table VM_EXCEPTION_CODE_DESC_RELAT
   drop primary key;

drop table if exists VM_EXCEPTION_CODE_DESC_RELAT;

alter table VM_EXCEPTION_DESC
   drop primary key;

drop table if exists VM_EXCEPTION_DESC;

alter table VM_EXCEPTION_RULE
   drop primary key;

drop table if exists VM_EXCEPTION_RULE;

mysql> source <file_name>;

mysql> source <file_name>;

mysql> source <file_name>;

mysql> source <file_name>;

