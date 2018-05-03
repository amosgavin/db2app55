<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<html>
<%
	String ruleRelateId = request.getParameter("ruleRelateId");
	String bceFrameId = request.getParameter("bceFrameId");
	String isEditable = request.getParameter("isEditable");
	
	if(null == isEditable || "".equals(isEditable)){
		isEditable = "1";
		if (null == ruleRelateId || "".equals(ruleRelateId)) {
			ruleRelateId = "-1";
			isEditable = "-1";
		}
		
		if (null == bceFrameId || "".equals(bceFrameId)) {
			bceFrameId = "-1";
			isEditable = "-1";
		}
	}
%>
<head>
	<title><%=LocaleResourceFactory.getResource("BES0000607")%></title>
	<script language="javascript" src="../common/js/configtool.js"></script>
</head>
<body onLoad="init()">
	<ai:contractframe id="" title="" contenttype="table"
			allowcontract="false" frameclosed="false" width="100%">
			<ai:contractitem>
			</ai:contractitem>
		
		<ai:dbform formid="javarulesetrelDetail" setname="com.ai.bce.web.BceFrameJavaRulesetRel" editable="true"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.bce.service.interfaces.IBceStudioSV"
				implservice_querymethod="getFrameJavaRulesetRelValues(String cond)"
				initial="false" onvalchange="">
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
		  		<tr>
		  			<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000366")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   			<td>
		   				<ai:dbformfield fieldname="RELATE_ID" formid="javarulesetrelDetail" editable="false" width="200"/>
		   			</td>	
		   			<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000363")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   			<td>
		   				<ai:dbformfield fieldname="BCE_FRAME_ID" formid="javarulesetrelDetail" editable="false" width="200"/>
		   			</td>	   			
		   		</tr>
		   		<tr>
		   			<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000367")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   			<td>
		   				<ai:dbformfield fieldname="RULESET_ID" formid="javarulesetrelDetail" width="200" editable="false"/>	
		   			</td>
		   			<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000368")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   			<td>
		   				<ai:dbformfield fieldname="RULESET_TYPE" formid="javarulesetrelDetail" editable="false" width="200"/>
		   			</td>
		   		</tr>
		  		<tr>
		   			<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000364")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   			<td>
		   				<ai:dbformfield fieldname="CHECK_TYPE" formid="javarulesetrelDetail" width="200" editable="false"/>
		   			</td>
		   			<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   			<td>
		   				<ai:dbformfield fieldname="STATE" formid="javarulesetrelDetail" editable="false" width="200"/>
		   			</td>
		   		</tr>
		   		<tr>	   
		   			<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000365")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   			<td>
		   				<ai:dbformfield fieldname="PARAM_DATA" formid="javarulesetrelDetail" editable="false" width="200"/>		   				
		   			</td>										
		   			<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000142")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   			<td>
		   				<ai:dbformfield fieldname="REMARKS" formid="javarulesetrelDetail" editable="false" width="200"/>
		   			</td>
		   		</tr>		
			</table>
		</ai:dbform>
		<ai:dbform formid="bceFrameDetail" setname="com.ai.bce.web.BceFrame" editable="false"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.bce.configtool.service.interfaces.IConfFrameSV"
				implservice_querymethod="getBceFrameValueByBceFrameId(String bceFrameId)"
				initial="false" onvalchange="">
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
		   		<tr>	
		   			<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000326")%><%=LocaleResourceFactory.getResource("BES0000106")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   			<td>
		   				<ai:dbformfield fieldname="BUSINESS_ID" formid="bceFrameDetail" editable="false" width="200"/>
		   			</td>	   									
		   			<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000107")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   			<td>
		   				<ai:dbformfield fieldname="DATA_PARSER" formid="bceFrameDetail" editable="false" width="200"/>
		   			</td>
		   		</tr>		
		   		<tr>	
		   			<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000108")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   			<td>
		   				<ai:dbformfield fieldname="DEAL_SERVICE" formid="bceFrameDetail" editable="false" width="200"/>
		   			</td>	   									
		   			<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000326")%><%=LocaleResourceFactory.getResource("BES0000109")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   			<td>
		   				<ai:dbformfield fieldname="ENTRY_PAGE_URL" formid="bceFrameDetail" editable="false" width="200"/>
		   			</td>
		   		</tr>			   
		   		<tr>	
		   			<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000326")%><%=LocaleResourceFactory.getResource("BES0000114")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   			<td>
		   				<ai:dbformfield fieldname="STATE" formid="bceFrameDetail" editable="false" width="200"/>
		   			</td>	   									
		   			<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000326")%><%=LocaleResourceFactory.getResource("BES0000113")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
		   			<td>
		   				<ai:dbformfield fieldname="REMARKS" formid="bceFrameDetail" editable="false" width="200"/>
		   			</td>
		   		</tr>			   							
			</table>
		</ai:dbform>		
	<div class="area_button">
			<div id="show">
				<ai:button text="BES0000318" id="edit" onclick="edit()" i18nRes="CRM"></ai:button>&nbsp;&nbsp;
			</div>
			<div id="ifShow" style="display: none">
				<ai:button text="BES0000319" id="save" onclick="save()" i18nRes="CRM"></ai:button>&nbsp;&nbsp;
				<ai:button text="BES0000320" id="cancel" onclick="cancel()" i18nRes="CRM"></ai:button>&nbsp;&nbsp;
			</div>	
	</div>
		</ai:contractframe>
		
</body>
<script type="text/javascript">
	var isEditable ="<%=isEditable%>";
	var bceFrameId = "<%=bceFrameId%>";
	
	function init(){		
		if(isEditable == "1" || isEditable == "2"){	//修改
			var condition = "RELATE_ID="+<%=ruleRelateId%>;
			getJavaRulesetRelDetailForm().refresh("cond="+condition);

			getBceFrameForm().refresh("bceFrameId=" + bceFrameId);
			edit();
		}else if(isEditable == "-1"){	//新增
			edit();
		}
	}

	function getJavaRulesetRelDetailForm(){
		return g_FormRowSetManager.get("javarulesetrelDetail");
	}

	function getBceFrameForm(){
		return g_FormRowSetManager.get("bceFrameDetail");
	}	

	//新增按钮触发事件
	function addNew(){
   		document.all.savedata.disabled = false;
    	document.all.deldata.disabled = true;
   		getJavaRulesetRelDetailForm().newRow();
   		getJavaRulesetRelDetailForm().setEditSts(true);
	}
   		
	function edit(){
  		document.getElementById("show").style.display="none";
    	document.getElementById("ifShow").style.display="";
    	getJavaRulesetRelDetailForm().setEditSts(true);
    	//g_AIButtonManager.get("selectRuleSetId").setDisabled(false);
    	//g_AIButtonManager.get("selectFrameId").setDisabled(false);
    	getJavaRulesetRelDetailForm().setColEditSts("RULESET_ID",false);
    	getJavaRulesetRelDetailForm().setColEditSts("BCE_FRAME_ID",false);
    	if(isEditable == "1" || isEditable == "2"){	//修改
    		getJavaRulesetRelDetailForm().setColEditSts("RELATE_ID",false);
    	}else if(isEditable == "-1"){	//新增
    		getJavaRulesetRelDetailForm().setColEditSts("RELATE_ID",true);
    	}
	}
   		
	function cancel(){
		document.getElementById("show").style.display="";
		document.getElementById("ifShow").style.display="none";
		getJavaRulesetRelDetailForm().setEditSts(false);
		//g_AIButtonManager.get("selectRuleSetId").setDisabled(true);
		//g_AIButtonManager.get("selectFrameId").setDisabled(true);
	}
   		
	function save(){
		var checkField = getJavaRulesetRelDetailForm().isFieldNull("RELATE_ID,BCE_FRAME_ID,RULESET_TYPE",true);
		if(checkField){
	   		return;
		}
		var list = new Array();
		list.push(getJavaRulesetRelDetailForm());
		var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
		if (ud.getValueByName("FLAG") == "ERROR" ) {
    	  if(!ud.getValueByName("MESSAGE"))
			alert(crm_i18n_msg("BEC0000305"));
			return;
		} 
		if(isEditable == "-1"){	//新增，弹出窗口			
			alert(crm_i18n_msg("BEC0000302"));
			window.returnValue = 1;
			window.close();
		}else if(isEditable == "2"){	//弹出窗口修改
			alert(crm_i18n_msg("BEC0000303"));
			window.returnValue = 2;
			window.close();
		}else{	//修改
			alert(crm_i18n_msg("BEC0000303"));
			cancel();
			refreshTopByDetailChange();
		}
	}

	/** 选择获取规则集编号*/
	function getJavaruleSetId(){
		var rulesetId = getJavaRulesetRelDetailForm().getValue("RULESET_ID");
		var rtnVal = window.showModalDialog("../ruleset/selectRuleset.jsp?rulesetId=" + rulesetId, "",
				"scroll:no;resizable:no;help:no;status:no;dialogHeight:480px;dialogWidth:700px");	
		if(rtnVal != null){
		    			if(rtnVal == -1){
		    				getJavaRulesetRelDetailForm().setValue("RULESET_ID", '');
		    			}else{
		    				getJavaRulesetRelDetailForm().setValue("RULESET_ID", rtnVal,rtnVal);
		    			}
		    		}
	}

	/** 选择获取规则集编号 (目前不给修改)*/
	function getBceFrameId(){
		var bceFrameId = getJavaRulesetRelDetailForm().getValue("BCE_FRAME_ID");
		var retObj = window.showModalDialog("../bceframe/selectDialog.jsp?bceFrameId=" + bceFrameId, "",
		"scroll:no;resizable:no;help:no;status:no;dialogHeight:480px;dialogWidth:700px");
		if(retObj != null){
			getJavaRulesetRelDetailForm().setValue("BCE_FRAME_ID", retObj.rulesetId);
		}	
	}
</script>
</html>