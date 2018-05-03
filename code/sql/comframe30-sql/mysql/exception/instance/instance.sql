/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:46:36                           */
/*==============================================================*/


alter table VM_EXCEPTION_RECORD
   drop primary key;

drop table if exists VM_EXCEPTION_RECORD;

mysql> source <file_name>;

