/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:48:22                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_SCHEDULE                                           */
/*==============================================================*/
create table VM_SCHEDULE
(
   WORKFLOW_ID          varchar(25) not null comment '工作流编号',
   QUEUE_ID             varchar(5) comment '队列编号',
   ENGINE_WORKFLOW_ID   varchar(255) comment '流程引擎的流程实例编号',
   ENGINE_TYPE          varchar(255) comment '引擎类型',
   CREATE_DATE          datetime comment '创建时间',
   STATE_DATE           datetime comment '加入调度时间',
   START_DATE           datetime comment '流程定时的启动时间',
   STATE                varchar(10) comment '调度状态：W-等待调度,S-进入调度机,F-调度结束,A-进入异常调度',
   SCHEDULE_DATE        datetime comment '开始调度时间',
   DEV_ID               varchar(5) comment '开发者标识(开发模式时有意义)',
   REGION_ID            varchar(6) comment '地域信息'
);

alter table VM_SCHEDULE
   add primary key (WORKFLOW_ID);

