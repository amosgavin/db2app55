/*==============================================================*/
/* DBMS name:      ORACLE Version 10gR2                         */
/* Created on:     2011/7/15 12:47:41                           */
/*==============================================================*/


drop sequence VM_DEAL_TASK$SEQ;

drop sequence VM_EXCEPTION_RECORD$SEQ;

drop sequence VM_TASK$SEQ;

drop sequence VM_TASK_TS$SEQ;

drop sequence VM_WF$SEQ;

drop sequence VM_WF_ATTR$SEQ;

create sequence VM_DEAL_TASK$SEQ
as bigint
increment by 1
start with 1
 maxvalue 999999999999999999
 minvalue 1
 cache 20;

create sequence VM_EXCEPTION_RECORD$SEQ
as bigint
increment by 1
start with 1
 maxvalue 999999999999999999
 minvalue 1
 cache 20;

create sequence VM_TASK$SEQ
as bigint
increment by 1
start with 1
 maxvalue 999999999999999999
 minvalue 1
 cache 20;

create sequence VM_TASK_TS$SEQ
as bigint
increment by 1
start with 1
 maxvalue 999999999999999999
 minvalue 1
 cache 20;

create sequence VM_WF$SEQ
as bigint
increment by 1
start with 1
 maxvalue 999999999999999999
 minvalue 1
 cache 20;

create sequence VM_WF_ATTR$SEQ
as bigint
increment by 1
start with 1
 maxvalue 999999999999999999
 minvalue 1
 cache 20;

