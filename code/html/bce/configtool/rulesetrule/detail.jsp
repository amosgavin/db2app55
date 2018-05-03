<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<html>
<%	
	String rulesetId = HttpUtil.getParameter(request, "rulesetId");
	String ruleId = HttpUtil.getParameter(request, "ruleId");
	String relateId = HttpUtil.getParameter(request, "relateId");
	String rulesetType = HttpUtil.getParameter(request, "rulesetType");
	String isEditable = request.getParameter("isEditable");
	if(null == isEditable || "".equals(isEditable)){
		isEditable = "1";
		if (null == rulesetId || "".equals(rulesetId)) {
			rulesetId = "-1";
			isEditable = "false";
		}
		if (null == relateId || "".equals(relateId)) {
			relateId = "-1";
		}
		if (null == ruleId || "".equals(ruleId)) {
			ruleId = "-1";
		}
	}
%>
<head>
	<title><%=LocaleResourceFactory.getResource("BES0000609")%></title>
	<script language="javascript" src="../common/js/configtool.js"></script>
</head>
<body onLoad="init()">
	<ai:contractframe id="" title="" contenttype="table"
			allowcontract="false" frameclosed="false" width="100%">
			<ai:contractitem>
			</ai:contractitem>
		
		<ai:dbform formid="rulesetruleDetail" setname="com.ai.bce.web.BceRulesetRule" editable="true"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.bce.service.interfaces.IBceStudioSV"
				implservice_querymethod="getBceRulesetRuleValues(String cond)"
				initial="false" onvalchange="">
				<ai:dbformfield fieldname="RELATE_ID" formid="rulesetruleDetail" editable="false" visible="false"/>
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
				<tr>
					<%
						if(rulesetId == null){
					%>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000290")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="RULESET_ID" formid="rulesetruleDetail" editable="false" width="180"/><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif" id="selectRulesetButton"
								alt='<%=LocaleResourceFactory.getResource("BES0000611")%>' onClick="getRuleset()" align="absmiddle"
								style="cursor: hand;" />
					</td>					
					<%		
						}else{
					%>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000290")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="RULESET_ID" formid="rulesetruleDetail" editable="false" width="200"/>
					</td>					
					<%		
						}
					%>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000291")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="RULE_ID" formid="rulesetruleDetail" editable="false" width="180"/><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								 id="selectRuleButton"
								alt='<%=LocaleResourceFactory.getResource("BES0000611")%>' onClick="getRule()" align="absmiddle"
								style="cursor: hand;" />
					</td>
				</tr>
				<tr>
				<% if(rulesetType == null || "1".equals(rulesetType)){ %>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000292")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
					  <ai:dbformfield fieldname="RULE_TRIGGER_TYPE" formid="rulesetruleDetail" editable="false" width="200"/>
					</td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000287")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="EVENT_OBJ_TYPE" formid="rulesetruleDetail" editable="false" width="200"/>
					</td>
				</tr>
				<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000288")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="OBJ_NAME" formid="rulesetruleDetail" editable="false" width="200"/>
					</td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000285")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="CHILD_OBJ_NAME" formid="rulesetruleDetail" editable="false" width="200"/>
					</td>
				</tr>
				<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000286")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="EVENT_NAME" formid="rulesetruleDetail" editable="false" width="200"/>
					</td>
				</tr>
				<%} %>
				<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000294")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="VERIFY_TYPE" formid="rulesetruleDetail" editable="false" width="200"/>
					</td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000289")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="PARAM_VALUE_LIST" formid="rulesetruleDetail" editable="false" width="200"/>
					</td>
				</tr>			
				<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000204")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="STATE" formid="rulesetruleDetail" editable="false" width="200"/>
					</td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000293")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="SEQ_NO" formid="rulesetruleDetail" editable="false" width="200"/>
					</td>
				</tr>				   														   														   								
				<tr>
				 <td class="td_font"><%=LocaleResourceFactory.getResource("BES0000111")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="MODULE_ID" formid="rulesetruleDetail" width="200"/>
					</td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000202")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="REMARKS" formid="rulesetruleDetail" editable="false" width="200"/>
					</td>
				</tr>	   										
			</table>
		</ai:dbform>
		<ai:dbform formid="rulesetDetail" setname="com.ai.bce.web.BceRuleset" editable="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.ai.bce.service.interfaces.IBceStudioSV"
			implservice_querymethod="getBceRulesetValues(String cond)"
			initial="false" onvalchange="">
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
				<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000345")%><%=LocaleResourceFactory.getResource("BES0000204")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="STATE" formid="rulesetDetail" editable="false" width="200"/>
					</td>				
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000345")%><%=LocaleResourceFactory.getResource("BES0000202")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="REMARKS" formid="rulesetDetail" editable="false" width="200"/>
					</td>
				</tr>	
			</table>
		</ai:dbform>
		<ai:dbform formid="ruleDetial" setname="com.ai.bce.web.BceRule" editable="true"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.ai.bce.configtool.service.interfaces.IConfRuleSV"
			implservice_querymethod="getBceRuleValues(String cond)"
			initial="false" onvalchange="">
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
				<tr>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000511")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="RULE_NAME" formid="ruleDetial" editable="false" width="200"/>
					</td>
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000204")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="STATE" formid="ruleDetial" editable="false" width="200"/>
					</td>
				</tr>		
				<tr>
				<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000217")%><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="PARAM_LIST" formid="ruleDetial" editable="false" width="200"/>
					</td>
				<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000111")%></td>
					<td>
						<ai:dbformfield fieldname="MODULE_ID" formid="ruleDetial" editable="false"  width="200"/>
					</td>
				</tr>		
			</table>
		</ai:dbform>
		<div class="area_button">
			<div id="show">
				<ai:button text="BES0000318" id="edit" onclick="edit()" i18nRes="CRM"></ai:button>&nbsp;&nbsp;
			</div>
			<div id="ifShow" style="display: none">
				<ai:button text="BES0000319" id="save" onclick="save()" i18nRes="CRM"/>&nbsp;&nbsp;
				<ai:button text="BES0000320" id="cancel" onclick="cancel()" i18nRes="CRM"/>&nbsp;&nbsp;
			</div>
		</div>	
		
			</ai:contractframe>
		
</body>
<script type="text/javascript">
	var isEditable ="<%=isEditable%>";
	var rulesetId = <%=rulesetId%>;
	var relateId = <%=relateId%>;
	var ruleId = <%=ruleId%>;
	
	function init(){	
		if(isEditable == "1" || isEditable == "2"){	//修改
			var condition = "RULESET_ID=" + rulesetId + " and RELATE_ID=" + relateId;
			getBceRulesetRuleDetailForm().refresh("cond=" + condition);

			var cond2 = "RULESET_ID=" + rulesetId;			
			getRulesetDetailForm().refresh("cond=" + cond2);

			var cond3 = "RULE_ID=" + ruleId;
			getRuleDetailForm().refresh("cond=" + cond3);
			if(getBceRulesetRuleDetailForm().getValue("MODULE_ID") == ""
			   && window.dialogArguments != null
			   && window.dialogArguments != ""
			   && window.dialogArguments != "null")
			  getBceRulesetRuleDetailForm().setValue("MODULE_ID",window.dialogArguments);
			edit();
		}else if(isEditable == "-1"){	//新增
			edit();
			if(rulesetId == null){	//规则Id未知，给予选择
				//getBceRulesetRuleDetailForm().setValue("RULESET_ID", rulesetId);
			}else{
				getBceRulesetRuleDetailForm().setValue("RULESET_ID", rulesetId);
			}			
			getBceRulesetRuleDetailForm().setValue("STATE", "1");	//状态默认为正常
			var cond2 = "RULESET_ID=" + rulesetId;
		//	getRuleDetailForm().setValue("MODULE_ID",window.dialogArguments);
		  getBceRulesetRuleDetailForm().setValue("MODULE_ID",window.dialogArguments);
			getRulesetDetailForm().refresh("cond=" + cond2);
		} else if(isEditable == "0"){	//只读
			var condition = "RULESET_ID=" + rulesetId + " and RELATE_ID=" + relateId;
			getBceRulesetRuleDetailForm().refresh("cond=" + condition);

			var cond2 = "RULESET_ID=" + rulesetId;			
			getRulesetDetailForm().refresh("cond=" + cond2);

			var cond3 = "RULE_ID=" + ruleId;
			getRuleDetailForm().refresh("cond=" + cond3);
			
			cancel();
			g_AIButtonManager.get("edit").setDisabled(true);
			
		}
	}
					
	function getBceRulesetRuleDetailForm(){
		return g_FormRowSetManager.get("rulesetruleDetail");
	}

	function getRulesetDetailForm(){
		return g_FormRowSetManager.get("rulesetDetail");
	}

	function getRuleDetailForm(){
		return g_FormRowSetManager.get("ruleDetial");
	}

	//新增按钮触发事件
	function addNew(){
 		document.all.savedata.disabled = false;
   		document.all.deldata.disabled = true;
    	getBceRulesetRuleDetailForm().newRow();
    	getBceRulesetRuleDetailForm().setEditSts(true);
    	getBceRulesetRuleDetailForm().setColEditSts("PAGE_FRAME_ID",false);
	}
   		
	function edit(){
    	document.getElementById("show").style.display="none";
  		document.getElementById("ifShow").style.display="";
    	getBceRulesetRuleDetailForm().setEditSts(true);    	
    	getBceRulesetRuleDetailForm().setColEditSts("RULE_ID",false);
		if(isEditable == "1" || isEditable == "2"){	//修改
    		getBceRulesetRuleDetailForm().setColEditSts("RULESET_ID",false);    		
    		document.getElementById("selectRuleButton").disabled = true;
    	}else if(isEditable == "-1"){	//新增
    		getBceRulesetRuleDetailForm().setColEditSts("RULESET_ID",false);
    		document.getElementById("selectRuleButton").disabled = false;
    	}
	}
   		
	function cancel(){
		if(isEditable == "-1" || isEditable == "2"){
			window.returnValue = -1;
			window.close();
		}else{
			document.getElementById("show").style.display="";
	 		document.getElementById("ifShow").style.display="none";
			getBceRulesetRuleDetailForm().setEditSts(false);
			document.getElementById("selectRuleButton").disabled = true;
		}
	}
   		
	function save(){
		var checkField = getBceRulesetRuleDetailForm().isFieldNull("RULESET_ID,RULE_ID",true);
		if(checkField){
	   		return;
		}
		var list = new Array();
		list.push(getBceRulesetRuleDetailForm());
		var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
		if (ud.getValueByName("FLAG") == "ERROR") {
			  if(!ud.getValueByName("MESSAGE"))
			    alert(crm_i18n_msg("BEC0000013"));
				return;
			}	
		if(isEditable == '-1'){	//新增，弹出窗口
			alert(crm_i18n_msg("BEC0000302"));
			window.returnValue = 1;
			window.close();
		}else if(isEditable == "2"){	//弹出窗口修改
			alert(crm_i18n_msg("BEC0000303"));
			window.returnValue = 2;
			window.close();
		}else{			//修改
			alert(crm_i18n_msg("BEC0000303"));
			cancel();  
			refreshTopByDetailChange();
		}
	}

	function getRule(){		
		var retObj = window.showModalDialog("../rule/selectRule.jsp?module_id="+window.dialogArguments+"&rulesetType=<%=rulesetType%>","",
				"scroll:no;resizable:no;help:no;status:no;dialogHeight:480px;dialogWidth:700px");
		if(retObj != null){			
			var ruleId = retObj;
			getBceRulesetRuleDetailForm().setValue("RULE_ID", ruleId);
			var cond3 = "RULE_ID=" + ruleId;
			getRuleDetailForm().refresh("cond=" + cond3);
		}				
	}

	function getRuleset(){
		var rtnVal = window.showModalDialog("../ruleset/selectRuleset.jsp","",
			"scroll:no;resizable:no;help:no;status:no;dialogHeight:480px;dialogWidth:700px");
		if(rtnVal != null){
		    			if(rtnVal == -1){
		    				getBceRulesetRuleDetailForm().setValue("RULESET_ID",'');
		    			}else{
		    				getBceRulesetRuleDetailForm().setValue("RULESET_ID",rtnVal,rtnVal);
		    				var cond3 = "RULESET_ID=" + rtnVal;
			                getRulesetDetailForm().refresh("cond=" + cond3);
		    			}
		    		}
		
	}
</script>
</html>