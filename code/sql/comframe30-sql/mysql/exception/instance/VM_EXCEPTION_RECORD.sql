/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/7/28 10:46:36                           */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_EXCEPTION_RECORD                                   */
/*==============================================================*/
create table VM_EXCEPTION_RECORD
(
   EXCEPTION_RECORD_ID  numeric(15,0) not null comment '异常记录标识(主键)',
   WORKFLOW_ID          varchar(25) comment '工作流实例编号',
   QUEUE_ID             varchar(5) comment '流程队列',
   TASK_ID              varchar(25) comment '工作流任务实例ID',
   EXCEPTION_CODE       varchar(255) not null comment '异常原因',
   EXCEPTION_REMARKS    varchar(255) comment '异常描述信息',
   NEXT_TEMPLATE_TAG    varchar(255) comment '异常流程编码(支持由业务系统实现选择异常流程的规则)',
   RULE_OWNER           varchar(2) comment '异常规则所有者(01:COMFRAME 02:业务系统)',
   CREATE_DATE          datetime comment '创建时间',
   STATE                char(1) comment '状态 U 当前在用 E 废弃不用',
   REGION_ID            varchar(6) comment '地域信息'
);

alter table VM_EXCEPTION_RECORD
   add primary key (EXCEPTION_RECORD_ID);

