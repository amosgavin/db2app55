<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/workflow/common/WorkflowHead.jsp"%>

<html>
  <head>
  <script type="text/javascript">
  var rtn= new Array();
  
  function getExcepCodeGird(){
	return g_TableRowSetManager.get("exceptionCode");
}
  function query(){
	  var Codeb=document.getElementById("Codeb").value;
	  var CodeName=document.getElementById("CodeName").value;
	  getExcepCodeGird().refresh("&Code="+Codeb+"&CodeName="+CodeName);
  
  }
  function confirm(){
	  var gridCode=getExcepCodeGird();
	  var selectedRows=gridCode.getSelectedRows();
	 for (var i=0;i<selectedRows.length;i++){
	 	rtn.push(gridCode.getValue(selectedRows[i],"EXCEPTION_CODE"));
	 }
	
  	window.returnValue=rtn;
  	
  	window.close();
  	
  }
  
  function cancel(){
  
	window.close();
}
  </script>

  </head>
  
  <body>
   <ai:contractframe width="100%" title="comframe.html.workflow.exception.exceptionCodeDescRelation79" id="comframe.html.workflow.exception.exceptionCodeDescRelation79" i18nRes="i18n.comframe_resource">
   <ai:contractitem>
   	<div class="t-bot-mc-button">
   	   <ai:button text="comframe.html.jsv2.udfpage.UserDefineFieldQuery53" i18nRes="i18n.comframe_resource"   enable="true" onclick="query()"/>
   	</div>
   </ai:contractitem>
   <table width="98%" cellspacing="2" cellpadding="1" border="0">
    <tr>
     <td class="td_font"><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.exception.exceptionCodeDescRelation47"></i18n:message></td>
     <td><input type="text"  id="Codeb" width="150px"  ></td>
     <td class="td_font"><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.exception.exceptionCodeDescRelation48"></i18n:message></td>
     <td><input type="text"  id="CodeName" width="150px" ></td>
    </tr>
   </table>	  			
</ai:contractframe>
<ai:contractframe width="100%" i18nRes="i18n.comframe_resource" title="comframe.html.workflow.exception.queryExcepCode75" id="comframe.html.workflow.exception.exceptionCodeDescRelation79" >
	<ai:contractitem></ai:contractitem>
	<ai:table setname="com.ai.comframe.config.set.SETVmExceptionCode" 
			tableid="exceptionCode"
			editable="false" 
			multiselect="true"
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.ai.comframe.config.service.interfaces.IExceptionConfigSV"
			implservice_querymethod="queryExcepCodeAndName(String Code,String CodeName)"	
	        needrefresh="true"
	        rowsequence="true"
	        height="200" width="100%"
	        initial="false"
	        footdisplay="none"
	        rowheight="-1"            
	        >
	
	<ai:col fieldname="EXCEPTION_CODE"  visible="true" width="50%"/>
	<ai:col fieldname="EXCEPTION_NAME"  visible="true" width="50%"/>
	</ai:table>
	
  </ai:contractframe>
	<div class="area_button">
		 <ai:button text="comframe.html.jsv2.udfpage.FieldPropSetUp35" i18nRes="i18n.comframe_resource" enable="true" onclick="confirm()"/>
		 <ai:button text="comframe.html.workflow.exception.queryExcepCode74" i18nRes="i18n.comframe_resource" enable="true" onclick="cancel()"/>
    </div>
  </body>
</html>
