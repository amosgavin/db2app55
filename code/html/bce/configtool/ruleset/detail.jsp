<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<html>
<%
	String rulesetId = request.getParameter("rulesetId");
	
	String isEditable = request.getParameter("isEditable");
	if(null == isEditable || "".equals(isEditable)){
	    isEditable = "1";	//修改
		if (null == rulesetId || "".equals(rulesetId)) {
			rulesetId = "-1";
			isEditable = "0";	//查看
		}
	}

%>
<head>
<title><%=LocaleResourceFactory.getResource("BES0000345")%></title>
<script language="javascript" src="../common/js/configtool.js"></script>
</head>
<body onload="init()">
	<ai:contractframe id="" title="" contenttype="table"
			allowcontract="false" frameclosed="false" width="100%">
			<ai:contractitem>
			</ai:contractitem>
		
		<ai:dbform formid="rulesetDetail" setname="com.ai.bce.web.BceRuleset" editable="true"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.bce.service.interfaces.IBceStudioSV"
				implservice_querymethod="getBceRulesetValues(String cond)"
				initial="false" onvalchange="">
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
				<tr>				
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000204") %><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="STATE" formid="rulesetDetail" width="200" />
					</td>	
					<td class="td_font">
						<%=LocaleResourceFactory.getResource("BES0000201") %><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="MODULE_ID" formid="rulesetDetail" editable="false" width="200" />
					</td>				
				</tr>
				<tr>				
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000202") %><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="REMARKS" formid="rulesetDetail" width="200" />
					</td>
					<td class="td_font">
						<%=LocaleResourceFactory.getResource("BES0000598") %><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>
						<ai:dbformfield fieldname="RULESET_TYPE" formid="rulesetDetail" width="200" />
					</td>		
				</tr>
				<tr>
					<%
						if("1".equals(isEditable)){
					%>						
					<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000295") %><%=LocaleResourceFactory.getResource("BES0000000")%></td>
					<td>				
						<ai:dbformfield fieldname="RULESET_ID" formid="rulesetDetail" width="200" />
					<%
						}else{
					%>
						&nbsp;
					<%							
						}
					%>
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
	
	function init(){		
		if(isEditable == '1'){	//修改
			var condition = "RULESET_ID="+<%=rulesetId%>;
			getRulesetDetailForm().refresh("cond="+condition);
			getRulesetDetailForm().setEditSts(true);			
			edit();			
		}else if(isEditable == "-1"){	//新增
			edit();
			getRulesetDetailForm().setValue("MODULE_ID", window.dialogArguments);
		}
	}

	function getRulesetDetailForm(){
		return g_FormRowSetManager.get("rulesetDetail");
	}

	//新增按钮触发事件
	function addNew(){
   		document.all.savedata.disabled = false;
    	document.all.deldata.disabled = true;
   		getRulesetDetailForm().newRow();
   		getRulesetDetailForm().setEditSts(true);
	}
   		
	function edit(){
  		document.getElementById("show").style.display="none";
    	document.getElementById("ifShow").style.display="";
    	getRulesetDetailForm().setEditSts(true);
    	if(isEditable == "1"){	//修改
    		getRulesetDetailForm().setColEditSts("RULESET_ID",false);
    	}else if(isEditable == "-1"){	//新增
    		getRulesetDetailForm().setColEditSts("RULESET_ID",true);
    		getRulesetDetailForm().setValue("STATE", "1");
    		getRulesetDetailForm().setValue("RULESET_TYPE", "1");
    	}	
	}
   		
	function cancel(){
		if(isEditable == "-1"){	//新增
			window.returnValue = -1;
			window.close();
		}else{
			document.getElementById("show").style.display="";
			document.getElementById("ifShow").style.display="none";
			getRulesetDetailForm().setEditSts(false);
		}
	}

	function save(){
		if(isEditable == "1"){
			var checkField = getRulesetDetailForm().isFieldNull("RULESET_ID",true);
			if(checkField){
		   		return;
			}
		}
		var rulesetDetialForm = g_FormRowSetManager.get("rulesetDetail");
		var xmlBody = rulesetDetialForm.toXmlString(true);
		if(xmlBody == "") {
			alert(crm_i18n_msg("BEC0000301"));
			return;
		}
		var list = new Array();
    list.push(rulesetDetialForm);
    var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
			if (ud.getValueByName("FLAG") == "ERROR") {
			  if(!ud.getValueByName("MESSAGE"))
			    alert(crm_i18n_msg("BEC0000013"));
				return;
			}
		window.returnValue = 1;
		window.self.close();
	}
</script>
</html>