--通用单点
insert into bce_frame(bce_frame_id,business_id,page_frame_id,data_parser,deal_service,workflow_code,state,remarks)
 values(1002,10002,-1,'','com.ai.bce.BceDealService','',1,'Demo_1' );

insert into bce_simple_func(func_id,bce_frame_id,rowset_name,ord_datasource,ord_bo,ins_datasource,ins_bo,state)
  values(2,1002,'detailForm','','','so{center}','com.asiainfo.crm.bcedemo.group.bo.GroupAccount',1);

insert into bce_simple_func(func_id,bce_frame_id,rowset_name,ord_datasource,ord_bo,ins_datasource,ins_bo,state)
  values(3,1002,'mainTable','','','so{center}','com.asiainfo.crm.bcedemo.group.bo.GroupContractInfo',1);
  
insert into bce_simple_func(func_id,bce_frame_id,rowset_name,ord_datasource,ord_bo,ins_datasource,ins_bo,state)
  values(4,1002,'testForm','','','so{center}','com.asiainfo.crm.bcedemo.group.bo.GroupInfo',1); 
  
insert into cfg_id_generator (TABLE_NAME, DOMAIN_ID, GENERATOR_TYPE, SEQUENCE_NAME, MAX_ID, START_VALUE, MIN_VALUE, MAX_VALUE, INCREMENT_VALUE, CYCLE_FLAG, CACHE_SIZE, SEQUENCE_CREATE_SCRIPT, HIS_TABLE_NAME, HIS_SEQUENCE_NAME, HIS_DATA_FLAG, HIS_MAX_ID, HIS_DONECODE_FLAG)
values ('GROUP_ACCOUNT', 11, 'S', 'DONE_CODE$SEQ', 1, 1, 1, 999999999999, 1, 'N', 20, '', '', '', 'N', null, 'N');
insert into cfg_id_generator (TABLE_NAME, DOMAIN_ID, GENERATOR_TYPE, SEQUENCE_NAME, MAX_ID, START_VALUE, MIN_VALUE, MAX_VALUE, INCREMENT_VALUE, CYCLE_FLAG, CACHE_SIZE, SEQUENCE_CREATE_SCRIPT, HIS_TABLE_NAME, HIS_SEQUENCE_NAME, HIS_DATA_FLAG, HIS_MAX_ID, HIS_DONECODE_FLAG)
values ('GROUP_INFO', 11, 'S', 'DONE_CODE$SEQ', 1, 1, 1, 999999999999, 1, 'N', 20, '', '', '', 'N', null, 'N');
insert into cfg_id_generator (TABLE_NAME, DOMAIN_ID, GENERATOR_TYPE, SEQUENCE_NAME, MAX_ID, START_VALUE, MIN_VALUE, MAX_VALUE, INCREMENT_VALUE, CYCLE_FLAG, CACHE_SIZE, SEQUENCE_CREATE_SCRIPT, HIS_TABLE_NAME, HIS_SEQUENCE_NAME, HIS_DATA_FLAG, HIS_MAX_ID, HIS_DONECODE_FLAG)
values ('GROUP_CONTRACT_INFO', 11, 'S', 'DONE_CODE$SEQ', 1, 1, 1, 999999999999, 1, 'N', 20, '', '', '', 'N', null, 'N');

update bce_simple_func set state = 0 where bce_frame_id = 1002;

insert into bce_simple_func(func_id,bce_frame_id,rowset_name,ord_datasource,ord_bo,ins_datasource,ins_bo,state)
  values(5,1002,'','','','so{center}','com.asiainfo.crm.bcedemo.group.bo.GroupInfo',1); 