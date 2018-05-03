/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 11:09:07                           */
/*==============================================================*/


alter table VM_OBJECT_ITEM
   drop primary key cascade;

drop table VM_OBJECT_ITEM cascade constraints;

alter table VM_OBJECT_ITEM_KIND
   drop primary key cascade;

drop table VM_OBJECT_ITEM_KIND cascade constraints;

alter table VM_OBJECT_ITEM_KIND_ELEMENT
   drop primary key cascade;

drop table VM_OBJECT_ITEM_KIND_ELEMENT cascade constraints;

alter table VM_OBJECT_ITEM_RELAT
   drop primary key cascade;

drop table VM_OBJECT_ITEM_RELAT cascade constraints;

alter table VM_OBJECT_ITEM_URL
   drop primary key cascade;

drop table VM_OBJECT_ITEM_URL cascade constraints;

start VM_OBJECT_ITEM.sql;

start VM_OBJECT_ITEM_KIND.sql;

start VM_OBJECT_ITEM_KIND_ELEMENT.sql;

start VM_OBJECT_ITEM_RELAT.sql;

start VM_OBJECT_ITEM_URL.sql;

