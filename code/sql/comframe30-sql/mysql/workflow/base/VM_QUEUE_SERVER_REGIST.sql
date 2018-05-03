/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011/9/8 21:25:49                            */
/*==============================================================*/


/*==============================================================*/
/* Table: VM_QUEUE_SERVER_REGIST                                */
/*==============================================================*/
create table VM_QUEUE_SERVER_REGIST
(
   REGIST_ID            numeric(15,0) not null,
   PROCESS_ID           varchar(255) comment '进程标识',
   HOST_IP              varchar(255) comment '主机IP',
   HOST_NAME            varchar(255) comment '主机名称',
   QUEUE_ID             varchar(5) comment '队列标识',
   QUEUE_TYPE           varchar(255) comment '队列类型，-t参数值',
   MOD_PARAM		numeric(3,0) comment '模，-m参数值',
   MOD_VALUE            varchar(255) comment '模值，-v参数值',
   REGION_ID            varchar(6) comment '地市标识，-r参数值',
   STATE                char(1) comment '状态',
   REGIST_DATE          datetime comment '注册时间',
   REMARKS              varchar(255) comment '备注'
);

alter table VM_QUEUE_SERVER_REGIST comment '队列服务器注册表';

alter table VM_QUEUE_SERVER_REGIST
   add primary key (REGIST_ID);

