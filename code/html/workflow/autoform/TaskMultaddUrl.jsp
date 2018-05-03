<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<HTML>
	<HEAD>
		<TITLE>
		 <i18n:message res="i18n.comframe_resource" key="comframe.html.workflow.autoform.objectInfoMain16"></i18n:message>
		</TITLE>
	</HEAD>
	<BODY >
				<ai:contractframe width="100%" i18nRes="i18n.comframe_resource" title="comframe.html.jsv2.udfpage.UserDefineFieldQuery34" id="qryTask"  allowcontract="false"  >
					<ai:contractitem>
					</ai:contractitem>
						<table width="98%" cellspacing="2" cellpadding="1" border="0">
						
							<tr>
								<td class="td_font"><i18n:message res="i18n.comframe_resource" key="comframe.html.workflow.autoform.objectItemDetail45"></i18n:message>£º</td>
								<td><input type="text" id="code" width="150"></td>
								<td><ai:button i18nRes="i18n.comframe_resource" text="comframe.html.jsv2.udfpage.UserDefineFieldQuery53" id="btnQry"  enable="true" onclick="qry()"/></td>
								
							</tr>
						</table>
				</ai:contractframe> 
				
				<ai:contractframe width="100%"  i18nRes="i18n.comframe_resource"  title="comframe.html.workflow.exception.exceptionCodeDescRelation76" id="qryResult" allowcontract="false" >
					<ai:contractitem></ai:contractitem>				
						<ai:table  setname="com.ai.comframe.autoform.web.SETVMObjectItem" 
						tableid="taskQryRe"
						editable="false" 
						multiselect="true"
						tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
						implservice_name="com.ai.comframe.autoform.service.interfaces.IAutoFormSV"
						implservice_querymethod="getObjectItemDetailByCode(String aObjectItemCode,int $STARTROWINDEX, int $ENDROWINDEX)"
						implservice_countmethod="getObjectItemDetailCountByCode(String aObjectItemCode)"	
				        needrefresh="true"
				        rowsequence="true"
				        height="150" width="100%"
				        initial="false"
				        footdisplay="block"
				        rowheight="-1"
		                pagesize="20"
				        >
						<ai:col fieldname="OBJECT_ITEM_ID" visible="false" />
						<ai:col fieldname="CODE"   visible="true" width="40%"/>
						<ai:col fieldname="NAME"   visible="true" width="60%"/>
						</ai:table>
					</ai:contractframe>

					<ai:contractframe width="100%"   i18nRes="i18n.comframe_resource" title="comframe.html.workflow.autoform.objectItemDetail148" id="cd" allowcontract="false">
							<ai:contractitem>
							<div class="t-bot-mc-button">
							<ai:button text="comframe.html.jsv2.udfpage.UserDefineFieldQuery91" i18nRes="i18n.comframe_resource" onclick="addUrl()"/>
							<ai:button text="comframe.html.jsv2.udfpage.UserDefineFieldQuery97" i18nRes="i18n.comframe_resource" onclick="deleteTable('TblUrl')"/>
							</div>
							</ai:contractitem>	
									<ai:table
											setname="com.ai.comframe.autoform.web.SETVMObjectItemUrl"
											tableid="TblUrl"
											implservice_name="com.ai.comframe.autoform.service.interfaces.IAutoFormSV"
											implservice_querymethod="getObjectItemUrl(String aObjectItemId,int $STARTROWINDEX,int $ENDROWINDEX)"
											
											tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
											pagesize="20" editable="true" footdisplay="none"
											height="100" width="100%" initial="false"
											multiselect="true" needrefresh="true">
				
											<ai:col fieldname="URL_BUSI_TYPE" editable="true"
												visible="true" width="35%" />
											<ai:col fieldname="URL" editable="true" visible="true"
												width="65%" />
											<ai:col fieldname="OBJECT_ITEM_ID" editable="true"
												visible="false"  width="0"/>
										</ai:table>
						</ai:contractframe>

					<div class="area_button">									
						<ai:button text="comframe.html.jsv2.udfpage.PageDesign116" i18nRes="i18n.comframe_resource" onclick="saveTaskUrl()"/>
					</div>
	</BODY>
</HTML>
<script language="javascript">
function getObjectItemGird(){
	return g_TableRowSetManager.get("taskQryRe");
}


function gObjectItemUrlSetRowSet(){
  return g_TableRowSetManager.get("TblUrl");
}

function qry(){ 
	var aObjectItemCode=document.getElementById("code").value;
	getObjectItemGird().refresh("aObjectItemCode="+aObjectItemCode);
}


function addUrl(){
	gObjectItemUrlSetRowSet().newRow(false);
}


function deleteTable(object){
	var selArray=g_TableRowSetManager.get(object).getSelectedRows();
    if(selArray.length>0){
        if(window.confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_objectItemDetail465"))){            
            for(var i=selArray.length-1;i>=0;i--){
              g_TableRowSetManager.get(object).deleteRow(selArray[i]);
            }
            return true;
        }
    }else{
    	var aRowNo=g_TableRowSetManager.get(object).getRow();
        if (aRowNo>=0){
          if(window.confirm(g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_objectItemDetail474"))){            
              g_TableRowSetManager.get(object).deleteRow(aRowNo);
          }else{
            return;
          }
        }else{
          alert(g_I18NMessage("comframe_resources","comframe_html_workflow_autoform_objectItemDetail480"));        }
     }
}

function saveTaskUrl(){

	var rowset=g_TableRowSetManager.get("taskQryRe");
	var selArray=rowset.getSelectedRows();

	var list="";
	var dcList=new Array();
	if(selArray.length>0){
	
		for(var i=0;i<selArray.length;i++){
			if(i>0){
				list+=",";
			}			
		
			list+=rowset.getValue(selArray[i],"OBJECT_ITEM_ID");
		}
	}
	else{
	   alert(g_I18NMessage("comframe_resources","comframe_html_workflow_TemplateQuery239"));
	   return;
	}
	
	
	if (gObjectItemUrlSetRowSet().toXmlString()!=""){
      	dcList.push(gObjectItemUrlSetRowSet());
  }

    if (dcList.length==0){
    	alert(g_I18NMessage("comframe_resources","comframe_html_jsv2_udfpage_FieldPropSetUp77"));    
    	return;
  }
  
   // var urlRowset=g_TableRowSetManager.get("TblUrl")
    //var existList= new Array();
  	
  	//if(dcList.length>1){
  	//	for(var i=0;i<dcList.length;i++){
  	//	  alert(dcList
  			
  	//	}
  		
  	//}
	var msg = saveRowSet("<%=request.getContextPath()%>/business/com.ai.comframe.autoform.web.AutoFormAction?action=saveTaskUrl&objectItemIds="+list,dcList,false,true);
   
    var ret = msg.getValueByName("retVal");
    
    alert(ret);
    
   
    

}

</script>  
		