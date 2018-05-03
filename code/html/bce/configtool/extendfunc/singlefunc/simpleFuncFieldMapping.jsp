<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<html>
<%
	String funcId = HttpUtil.getParameter(request, "funcId");
	String fieldId = HttpUtil.getParameter(request, "fieldId");
	
	System.out.println("funcId=" + funcId);
	System.out.println("fieldId=" + fieldId);
	
	String isEditable = request.getParameter("isEditable");
	if(null == isEditable || "".equals(isEditable)){
	    isEditable = "1";		//修改
		if (null == funcId || "".equals(funcId)) {
			funcId = "-1";
			isEditable = "0";	//查看
		}
	}
%>
<head>
<title>
<%=LocaleResourceFactory.getResource("BES0000605")%>
</title>
</head>
<body onload="init()">
<ai:contentframe id="" title="BES0000348" contenttype="table" width="98%" i18nRes="CRM">
	<ai:dbform formid="sfuncMappingDetail" setname="com.ai.bce.web.BceSimpleFuncFieldMapping" editable="true"
		datamodel="com.ai.appframe2.web.datamodel.MethodModelForService" initial="false" onvalchange="" 
		implservice_name = "com.ai.bce.configtool.service.interfaces.IConfSimpleFuncSV"
		implservice_querymethod = "getSimpleFuncFieldMappingValues(String cond, int $STARTROWINDEX, int $ENDROWINDEX)" 
	>		
		<ai:dbformfield fieldname="FIELD_ID" formid="sfuncMappingDetail" width="200" visible="false"/>   					
		<ai:dbformfield fieldname="FUNC_ID" formid="sfuncMappingDetail" width="200" visible="false"/>
		<table align="center">
			<tr>
		   		<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000271")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   		<td>
		   			<ai:dbformfield fieldname="FIELD_CODE" formid="sfuncMappingDetail" width="200"/>
		   		</td>
		   		<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000275")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   		<td>
		   			<ai:dbformfield fieldname="ORD_FIELD" formid="sfuncMappingDetail" width="200"/>
		   		</td>
			</tr>
		  	<tr>
		   		<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000274")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   		<td>
		   			<ai:dbformfield fieldname="INS_FIELD" formid="sfuncMappingDetail" width="200"/>
		   		</td>
		  	 	<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000201")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
				<td>
		   			<ai:dbformfield fieldname="MODULE_ID" formid="sfuncMappingDetail" width="200"/>
		   		</td>			   		
		   	</tr>
		   	<tr>	
		   		<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000204")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   		<td>
		   			<ai:dbformfield fieldname="STATE" formid="sfuncMappingDetail" width="200"/>
		   		</td>
			</tr>		
		</table>
	</ai:dbform>			
</ai:contentframe>
<div class="area_button">
	<%
		if(!isEditable.equals("0")){
	%>
		<ai:button id="saveButton" text="BES0000319" onclick="save()" style="cursor:hand" i18nRes="CRM"/>
	<%			
		}
	%>	
	<ai:button text="BES0000320" onclick="cancel()" style="cursor:hand" i18nRes="CRM"/>
</div>
</body>
<script type="text/javascript">
	var isEditable = "<%=isEditable%>";	//编辑模式
	var funcId = "<%=funcId%>";			//单点功能ID
	var fieldId = "<%=fieldId%>";	//受理框架编号
	
	function init(){
		if(isEditable == "1"){	//修改
			var condition = "FIELD_ID=" + fieldId;
			getSFuncMappingForm().refresh("cond=" + condition);
			getSFuncMappingForm().setEditSts(true);			
			edit();			
		}else if(isEditable == "-1"){	//新增
			edit();
			getSFuncMappingForm().setValue("FUNC_ID", funcId);
			getSFuncMappingForm().setValue("MODULE_ID", window.dialogArguments);
			getSFuncMappingForm().setValue("STATE", "1");
		}else if(isEditable == "0"){	//查看
			var condition = "FIELD_ID=" + fieldId;
			getSFuncMappingForm().refresh("cond=" + condition);
			getSFuncMappingForm().setEditSts(false);
		}
	}

	function getSFuncMappingForm(){
		return g_FormRowSetManager.get("sfuncMappingDetail");
	}
   		
	function edit(){
		getSFuncMappingForm().setEditSts(true);
    	if(isEditable == "1"){	//修改
    	}else if(isEditable == "-1"){	//新增
    		getSFuncMappingForm().setValue("STATE", "1");
    	}	
    	getSFuncMappingForm().setColEditSts("BCE_FRAME_ID",false);
    	getSFuncMappingForm().setFocus("STATE");
	}
   		
	function cancel(){
		if(isEditable == "-1"){	//新增
			window.returnValue = "cancel";
			window.close();
		}else if(isEditable == "1"){	//修改
			window.returnValue = "cancel";
			window.close();
		}else{
			window.returnValue = "cancel";
			window.close();
		}
	}

	function save(){
		var simpleFuncForm = getSFuncMappingForm();
		var xmlBody = simpleFuncForm.toXmlString(true);
		if(xmlBody == "") {
			alert(crm_i18n_msg("BEC0000301"));
			return;
		}
		var list = new Array();
        list.push(simpleFuncForm);
        var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",
                	list,false);
		if (ud.getValueByName("FLAG") == "ERROR") {
			  if(!ud.getValueByName("MESSAGE"))
			    alert(crm_i18n_msg("BEC0000013"));
				return;
			}	
		window.returnValue = 1;
		window.close();
	}
</script>
</html>