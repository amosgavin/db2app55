/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:48:22                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_DEAL_TASK                                          */
/*==============================================================*/
create table VM_DEAL_TASK
(
   DEAL_TASK_ID         varchar(25) not null,
   TASK_ID              varchar(25) not null comment '任务编号',
   WORKFLOW_ID          varchar(25) not null,
   QUEUE_ID             varchar(5) comment '队列编号',
   DEAL_TYPE            varchar(10) comment '处理类型：TIMER-定时器,PRINT-自动执行人工任务打印操作',
   RUNTIME              datetime comment '任务执行时间',
   STATE                numeric(2,0) comment '处理状态 2-可以执行,99-系统错误',
   CREATE_DATE          datetime comment '创建时间',
   DEV_ID               varchar(5) comment '开发者标识(开发模式时有意义)',
   ERROR_MESSAGE        varchar(4000) comment '错误原因',
   REGION_ID            varchar(6) comment '地域信息'
);

alter table VM_DEAL_TASK comment '定时任务';

alter table VM_DEAL_TASK
   add primary key (DEAL_TASK_ID);

/*==============================================================*/
/* Index: IDX_D_T_WID                                           */
/*==============================================================*/
create index IDX_D_T_WID on VM_DEAL_TASK
(
   WORKFLOW_ID
);

