insert into bce_attr(attr_id,attr_code,attr_name,field_type,state)
  values(1,'GROUP_ID','集团编号','NUMBER(12)',1);
insert into bce_attr(attr_id,attr_code,attr_name,field_type,state)
  values(2,'GROUP_NAME','集团名称','VARCHAR2(40)',1);
insert into bce_attr(attr_id,attr_code,attr_name,field_type,state,validation)
  values(3,'REGION_ID','所属区域','VARCHAR2(6)',1,'2');
insert into bce_attr(attr_id,attr_code,attr_name,field_type,state)
  values(4,'GROUP_LEVEL','集团级别','NUMBER(2)',1);
insert into bce_attr(attr_id,attr_code,attr_name,field_type,state)
  values(5,'GROUP_TYPE','集团类型','NUMBER(2)',1);
  
insert into bce_frame_attr(bce_frame_id,attr_id,form_id,is_editable,is_nullable,edit_type,seq_no,state,is_visible)
  values(50174,2,'frmQry',1,1,2,1,1,1);
insert into bce_frame_attr(bce_frame_id,attr_id,form_id,is_editable,is_nullable,edit_type,seq_no,state,is_visible)
  values(50174,3,'frmQry',1,1,2,2,1,1);
  
insert into bce_frame_attr(bce_frame_id,attr_id,form_id,is_editable,is_nullable,edit_type,seq_no,state,is_visible)
  values(50174,1,'frmInfo',0,1,2,1,1,1);
insert into bce_frame_attr(bce_frame_id,attr_id,form_id,is_editable,is_nullable,edit_type,seq_no,state,is_visible,field_width,col_span)
  values(50174,2,'frmInfo',1,1,2,2,1,1,'200',2);
insert into bce_frame_attr(bce_frame_id,attr_id,form_id,is_editable,is_nullable,edit_type,seq_no,state,is_visible,is_validate)
  values(50174,3,'frmInfo',1,0,2,5,1,1,1);
insert into bce_frame_attr(bce_frame_id,attr_id,form_id,is_editable,is_nullable,edit_type,seq_no,state,is_visible)
  values(50174,4,'frmInfo',1,1,2,3,1,1);
insert into bce_frame_attr(bce_frame_id,attr_id,form_id,is_editable,is_nullable,edit_type,seq_no,state,is_visible)
  values(50174,5,'frmInfo',1,1,2,4,1,1);
  
insert into bce_frame_attr(bce_frame_id,attr_id,form_id,is_editable,is_nullable,edit_type,seq_no,state,is_visible)
  values(50174,1,'tblInfo',1,1,2,1,1,0);
insert into bce_frame_attr(bce_frame_id,attr_id,form_id,is_editable,is_nullable,edit_type,seq_no,state,is_visible,field_width)
  values(50174,2,'tblInfo',1,1,2,2,1,1,'300');
insert into bce_frame_attr(bce_frame_id,attr_id,form_id,is_editable,is_nullable,edit_type,seq_no,state,is_visible)
  values(50174,3,'tblInfo',1,1,2,5,1,1);
insert into bce_frame_attr(bce_frame_id,attr_id,form_id,is_editable,is_nullable,edit_type,seq_no,state,is_visible)
  values(50174,4,'tblInfo',1,1,2,3,1,1);
insert into bce_frame_attr(bce_frame_id,attr_id,form_id,is_editable,is_nullable,edit_type,seq_no,state,is_visible)
  values(50174,5,'tblInfo',1,1,2,4,1,1);

insert into bce_frame_area_form(bce_frame_id,form_id,cols,state,form_type)
  values(50174,'frmQry',2,1,1);
  
insert into bce_frame_area_form(bce_frame_id,form_id,cols,state,form_type)
  values(50174,'frmInfo',3,1,1);

insert into bce_frame_area_form(bce_frame_id,form_id,state,form_type)
  values(50174,'tblInfo',1,2);
  
insert into bce_button(button_id,button_code,button_name,text,width,event_click,state)
  values(1,'btnQry','查询','查 询','','',1);

insert into bce_button(button_id,button_code,button_name,text,width,event_click,state)
  values(2,'btnNew','新增','新 增','','',1);
  
insert into bce_button(button_id,button_code,button_name,text,width,event_click,state)
  values(3,'btnRuleTest','规则测试','规则测试','','',1);

insert into bce_button(button_id,button_code,button_name,text,width,event_click,state)
  values(4,'btnCommitA','提交A','提 交A','','commit(''A\'')',1);
  
insert into bce_button(button_id,button_code,button_name,text,width,event_click,state)
  values(5,'btnCommitB','提交B','提 交B','','commit(''B\'')',1);
   
insert into bce_frame_button(bce_frame_id,area_id,button_id,event_click,enable,mo,operator,state)
  values(50174,'btnAreaQry',1,'alert(1);',1,'','',1); 

insert into bce_frame_button(bce_frame_id,area_id,button_id,event_click,enable,mo,operator,state)
  values(50174,'btnAreaQry',2,'addNew()',1,'','',1); 
    
insert into bce_frame_button(bce_frame_id,area_id,button_id,event_click,enable,mo,operator,state)
  values(50174,'btnAreaQry',3,'test()',1,'','',1);    
  
insert into bce_frame_button(bce_frame_id,area_id,button_id,event_click,enable,mo,operator,state)
  values(50174,'btnAreaDeal',4,'',1,'','',1);    

insert into bce_frame_button(bce_frame_id,area_id,button_id,event_click,enable,mo,operator,state)
  values(50174,'btnAreaDeal',5,'',1,'','',1);  
  
  
SELECT 'insert into bce_attr(attr_id,module_id,obj_name,attr_code,attr_name,field_type,state) values( bce_common$seq.nextval,?,''?'','''||
  a.COLUMN_NAME||''','''||b.comments||''','''||decode(a.DATA_TYPE,'DATE',a.DATA_TYPE,a.DATA_TYPE||'('||a.DATA_LENGTH||')')||''',1'||');' 
  FROM USER_TAB_COLUMNS A, USER_COL_COMMENTS B 
WHERE A.TABLE_NAME = B.TABLE_NAME AND A.COLUMN_NAME = B.COLUMN_NAME AND 
A.table_name = ?;