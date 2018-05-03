<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<html>
<%
	String funcId = HttpUtil.getParameter(request, "funcId");
	String bceFrameId = HttpUtil.getParameter(request, "bceFrameId");
	
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
<%=LocaleResourceFactory.getResource("BES0000604")%>
</title>
</head>
<body onload="init()">
<ai:contentframe id="" title="BES0000347" contenttype="table" width="98%" i18nRes="CRM">
	<ai:dbform formid="sfuncDetail" setname="com.ai.bce.web.BceSimpleFunc" editable="true"
		datamodel="com.ai.appframe2.web.datamodel.MethodModelForService" initial="false" onvalchange="" 
		implservice_name = "com.ai.bce.configtool.service.interfaces.IConfSimpleFuncSV"
		implservice_querymethod = "getSimpleFuncValues(String cond, int $STARTROWINDEX, int $ENDROWINDEX)" 
	>		   					
		<ai:dbformfield fieldname="FUNC_ID" formid="sfuncDetail" width="200" editable="false" visible="false"/>
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
		   		<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000276")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   		<td>
		   			<ai:dbformfield fieldname="BCE_FRAME_ID" formid="sfuncDetail" width="200"/>
		   		</td>
		   		<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000284")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   		<td>
		   			<ai:dbformfield fieldname="ROWSET_NAME" formid="sfuncDetail" width="200"/>
		   		</td>
			</tr>
		 	<tr>
		   		<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000283")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   		<td>
		   			<ai:dbformfield fieldname="ORD_DATASOURCE" formid="sfuncDetail" width="200"/>
		   		</td>
		   		<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000282")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   		<td>
		   			<ai:dbformfield fieldname="ORD_BO" formid="sfuncDetail" width="200"/>
		   		</td>
		 	</tr>
			<tr>
		   		<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000281")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   		<td>
		   			<ai:dbformfield fieldname="INS_DATASOURCE" formid="sfuncDetail" width="200"/>
		   		</td>
		   		<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000280")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   		<td>
		   			<ai:dbformfield fieldname="INS_BO" formid="sfuncDetail" width="200"/>
		   		</td>
			</tr>		
		 	<tr>
		   		<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000277")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   		<td>
		   			<ai:dbformfield fieldname="DEAL_SERVICE" formid="sfuncDetail" width="200"/>
		   		</td>
		   		<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000278")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   		<td>
		   			<ai:dbformfield fieldname="DEAL_WORKFLOW" formid="sfuncDetail" width="200"/>
		   		</td>
		  	</tr>	
		   	<tr>
		  	 	<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000201")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
				<td>
		   			<ai:dbformfield fieldname="MODULE_ID" formid="sfuncDetail" width="200"/>
		   		</td>		   	
		   		<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000204")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   		<td>
		   			<ai:dbformfield fieldname="STATE" formid="sfuncDetail" width="200"/>
		   		</td>
				<td>&nbsp;</td>
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
	var bceFrameId = "<%=bceFrameId%>";	//受理框架编号
	
	function init(){
		if(isEditable == "1"){	//修改
			var condition = "FUNC_ID=" + funcId;
			getSFuncForm().refresh("cond=" + condition);
			getSFuncForm().setEditSts(true);			
			edit();			
		}else if(isEditable == "-1"){	//新增
			edit();
			getSFuncForm().setValue("BCE_FRAME_ID", bceFrameId);
			getSFuncForm().setValue("MODULE_ID", window.dialogArguments);
			getSFuncForm().setValue("STATE", "1");
		}else if(isEditable == "0"){	//查看
			var condition = "FUNC_ID=" + funcId;
			getSFuncForm().refresh("cond=" + condition);
			getSFuncForm().setEditSts(false);
		}
	}

	function getSFuncForm(){
		return g_FormRowSetManager.get("sfuncDetail");
	}
   		
	function edit(){
    	getSFuncForm().setEditSts(true);
    	if(isEditable == "1"){	//修改
    	}else if(isEditable == "-1"){	//新增
    		getSFuncForm().setValue("STATE", "1");
    	}	
    	getSFuncForm().setColEditSts("BCE_FRAME_ID",false);
    	getSFuncForm().setFocus("STATE");
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
		var simpleFuncForm = getSFuncForm();
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