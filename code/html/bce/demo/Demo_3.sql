--单点功能测试
--form
insert into bce_page(page_id,module_id,page_type,page_url,is_get_page_data,is_data_must,page_load_type,state,remarks)
  values(100001,1,1,'/crm/so/sfunc/test/PasswordChange.jsp',1,0,1,1,'单点测试-改密码');

insert into bce_page(page_id,module_id,page_type,page_url,is_get_page_data,is_data_must,page_load_type,state,remarks)
  values(100002,1,1,'/crm/so/sfunc/test/AgentInfo.jsp',1,0,1,1,'单点测试-代办人');
    
insert into bce_page_frame(page_frame_id,page_frame_name,frame_type,state)
  values(10001,'单点测试-form',3,1);
  
insert into bce_page_frame_page(page_frame_page_id,page_frame_id,page_id,page_title,seq_no,state,remarks)
  values(10011,10001,100001,'改密码',1,1,'单点测试-改密码');
  
insert into bce_page_frame_page(page_frame_page_id,page_frame_id,page_id,page_title,seq_no,state,remarks)
  values(10012,10001,100002,'代办人',2,1,'单点测试-代办人');

insert into bce_frame(bce_frame_id,business_id,page_frame_id,data_parser,deal_service,workflow_code,state,remarks)
 values(1001,10001,10001,'com.ai.omframe.order.service.impl.SoOrderDataParserImpl','com.ai.omframe.OrderSaveService','com.ai.omframe.order.vm.sfunc.SingleFunc',1,'Demo_3' );
  
insert into bce_rowset(rowset_id,rowset_type,rowset_key,rowset_method,state,remarks)
  values(11,2,'frmNormal_common','toXmlString(false)',1,'单点测试');
  
insert into bce_rowset(rowset_id,rowset_type,rowset_key,rowset_method,state,remarks)
  values(12,2,'frmNormal_agent','toXmlString(false)',1,'代办人信息');
  
insert into bce_page_rowset_rel(page_frame_page_id,rowset_id,state)
  values(10011,11,1);
  
insert into bce_page_rowset_rel(page_frame_page_id,rowset_id,state)
  values(10012,12,1);

insert into bce_simple_func(func_id,bce_frame_id,rowset_name,ord_datasource,ord_bo,ins_datasource,ins_bo,state)
  values(1,1001,'frmNormal_common','so{center}','com.ai.omframe.order.bo.OrdUser','so{center}','com.ai.omframe.instance.bo.InsUser',1);
  
insert into bce_simple_func_field_mapping(field_id,func_id,field_code,ord_field,ins_field,state)
  values(1,1,'ACCT_ID','USER_ID','USER_ID',1);
  
insert into bce_simple_func_field_mapping(field_id,func_id,field_code,ord_field,ins_field,state)
  values(2,1,'ACCT_NAME','PASSWORD','PASSWORD',1);
/**
insert into up_business(business_id,operate_type,business_kind,del_flag)
    values(10001,'SINGLE_FUNC','BUSINESS_OPERATION','1');

insert into up_product_item(product_item_id,code,name,item_type,description,state,del_flag)
    values(10001,'BUSI0001','改密码','BUSINESS_OPERATION','改密码','U','1');
**/    
