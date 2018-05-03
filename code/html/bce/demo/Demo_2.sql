insert into bce_page(page_id,module_id,page_type,page_url,is_get_page_data,is_data_must,page_load_type,state,remarks)
  values(100003,1,1,'/bce/demo/Demo_2_1.jsp',1,0,1,1,'通用测试-form');

insert into bce_page(page_id,module_id,page_type,page_url,is_get_page_data,is_data_must,page_load_type,state,remarks)
  values(100004,1,1,'/bce/demo/Demo_2_2.jsp',1,0,1,1,'通用测试-table');
    
insert into bce_page_frame(page_frame_id,page_frame_name,frame_type,state)
  values(10002,'通用测试',3,1);
  
insert into bce_page_frame_page(page_frame_page_id,page_frame_id,page_id,page_title,seq_no,state,remarks)
  values(10013,10002,100003,'form',1,1,'通用测试');
  
insert into bce_page_frame_page(page_frame_page_id,page_frame_id,page_id,page_title,seq_no,state,remarks)
  values(10014,10002,100004,'table',2,1,'通用测试');
  
insert into bce_frame(bce_frame_id,business_id,page_frame_id,data_parser,deal_service,workflow_code,state,remarks)
 values(1003,10003,10002,'com.ai.bce.service.impl.BceDataParserImpl','com.ai.bce.BceDealService','',1,'Demo_2' );
 
insert into bce_rowset(rowset_id,rowset_type,rowset_key,rowset_method,state,remarks)
  values(13,2,'detailForm','toXmlString(false)',1,'通用测试');
  
insert into bce_rowset(rowset_id,rowset_type,rowset_key,rowset_method,state,remarks)
  values(14,1,'mainTable','toXmlString(false)',1,'通用测试');
  
insert into bce_page_rowset_rel(page_frame_page_id,rowset_id,state)
  values(10013,13,1);
  
insert into bce_page_rowset_rel(page_frame_page_id,rowset_id,state)
  values(10014,14,1);

insert into bce_simple_func(func_id,bce_frame_id,rowset_name,ord_datasource,ord_bo,ins_datasource,ins_bo,state)
  values(6,1003,'detailForm','','','so{center}','com.asiainfo.crm.bcedemo.group.bo.GroupAccount',1);
  
insert into bce_simple_func(func_id,bce_frame_id,rowset_name,ord_datasource,ord_bo,ins_datasource,ins_bo,state)
  values(7,1003,'mainTable','','','so{center}','com.asiainfo.crm.bcedemo.group.bo.GroupContractInfo',1);
  