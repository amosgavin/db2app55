/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:48:22                           */
/*==============================================================*/


/*==============================================================*/
/* Table: H_VM_TASK_TS                                          */
/*==============================================================*/
create table H_VM_TASK_TS
(
   TASK_ID              varchar(25) not null comment '任务编号',
   PARENT_TASK_ID       varchar(25) comment '上级任务编号',
   WORKFLOW_ID          varchar(25) comment '流程编号',
   QUEUE_ID             varchar(5) comment '流程队列',
   TASK_TEMPLATE_ID     numeric(12,0) comment '任务模版编号',
   DEST_TASK_TEMPLATE_ID numeric(12,0) comment '跳转或者回退时，目的任务标识',
   DEST_TYPE            char(1) comment '操作类型：J-跳转;G-回退',
   TASK_TYPE            varchar(255) comment '任务类型',
   TASK_BASE_TYPE       varchar(255),
   TASK_TAG             varchar(255) comment '任务标志',
   LABEL              varchar(255) comment '任务主题',
   DURATION             numeric(15,0) comment '任务时限',
   DECISION_RESULT      varchar(255) comment '判断结果',
   IS_CURRENT_TASK      char(1) comment '是否当前任务',
   STATE                numeric(2,0) comment '任务状态 1-不能调度 2-可以调度 3-已经完成 4-终止 9-等待打单 5-人工处理 6-处理失败 7-等待外部事件触发 8-过期作废 99-系统异常 21-已经回复流程引擎任务单',
   STATE_DATE           datetime comment '状态时间',
   CREATE_DATE          datetime comment '创建时间',
   STATION_ID           varchar(30) comment '任务岗位',
   TASK_STAFF_ID        varchar(30) comment '任务人员',
   LOCK_STAFF_ID        varchar(30) comment '锁定员工',
   LOCK_DATE            datetime comment '锁定时间',
   FINISH_STAFF_ID      varchar(30) comment '完成人员',
   FINISH_DATE          datetime comment '完成时间',
   ERROR_MESSAGE        varchar(4000) comment '错误信息',
   DESCRIPTION          varchar(512) comment '任务描述',
   WARNING_DATE         datetime,
   WARNING_TIMES        numeric(2,0),
   REGION_ID            varchar(6) comment '地域信息',
   TRANSFER_DATE        datetime comment '移历史时间'
);

alter table H_VM_TASK_TS
   add primary key (TASK_ID);

/*==============================================================*/
/* Index: IDX_H_T_T_WID                                         */
/*==============================================================*/
create index IDX_H_T_T_WID on H_VM_TASK_TS
(
   WORKFLOW_ID
);

