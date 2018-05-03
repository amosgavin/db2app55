<%@page import="com.ai.bce.util.LocaleResourceFactory"%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/configtool/common/bcetoolhead.jsp"%>
<html>
	<%
		String relateId = request.getParameter("relateId");
		if (null == relateId || "".equals(relateId)) {
			relateId = "-1";
		}
		String frameId = request.getParameter("bceFrameId");
		if (null == frameId || "".equals(frameId)) {
			frameId = "-1";
		}
		request.setAttribute("cond", "RELATE_ID=" + relateId);
	%>
	<head>
		<title><%=LocaleResourceFactory.getResource("BES0000607")%></title>
		<script language="javascript" src="../common/js/configtool.js"></script>
	</head>
	<body onLoad="init()">
		<ai:contentframe id="" title="BES0000601" contenttype="table"
			width="98%" i18nRes="CRM">
			<ai:dbform formid="javarulesetrelDetail"
				setname="com.ai.bce.web.BceFrameJavaRulesetRel" editable="true"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.ai.bce.service.interfaces.IBceStudioSV"
				implservice_querymethod="getFrameJavaRulesetRelValues(String cond)"
				initial="true" onvalchange="">
				<table width="98%" align="center" border="0" cellpadding="1"
					cellspacing="2">
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000363")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="BCE_FRAME_ID"
								formid="javarulesetrelDetail" editable="false" width="200" />
						</td>

						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000367")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="RULESET_ID"
								formid="javarulesetrelDetail" width="180" editable="false" /><img border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt='<%=LocaleResourceFactory.getResource("BES0000610")%>'
								onClick=" getJavaruleSetId()" align="absmiddle"
								style="cursor: hand;" />
						</td>

					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000368")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="RULESET_TYPE"
								formid="javarulesetrelDetail" width="200" />
						</td>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000364")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="CHECK_TYPE"
								formid="javarulesetrelDetail" width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000170")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="STATE" formid="javarulesetrelDetail"
								width="200" />
						</td>

						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000142")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="RELATE_ID"
								formid="javarulesetrelDetail" visible="false" width="200" />
							<ai:dbformfield fieldname="REMARKS" formid="javarulesetrelDetail"
								width="200" />
						</td>
					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000365")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td colspan='3'>
							<ai:dbformfield fieldname="PARAM_DATA"
								formid="javarulesetrelDetail" height="50" width="500" />
						</td>

					</tr>
					<tr>
						<td class="td_font"><%=LocaleResourceFactory.getResource("BES0000111")%><%=LocaleResourceFactory.getResource("BES0000000")%>
						</td>
						<td>
							<ai:dbformfield fieldname="MODULE_ID"
								formid="javarulesetrelDetail"  width="200" />
						</td>
					</tr>
				</table>
			</ai:dbform>
		</ai:contentframe>
		<div id='ErrorOrInfo' style="color: red"></div>
		<div class="area_button">
			<ai:button text="BES0000319" id="save" onclick="save()" i18nRes="CRM" />
			&nbsp;&nbsp;
			<ai:button text="BES0000320" id="cancel" onclick="cancel()"
				i18nRes="CRM"></ai:button>
		</div>
	</body>
	<script type="text/javascript">
	function init(){
		if("<%=relateId%>"=='-1'){
			getJavaRulesetRelDetailForm().setValue("State",1);
			getJavaRulesetRelDetailForm().setValue("CHECK_TYPE",1);
			getJavaRulesetRelDetailForm().setValue("RULESET_TYPE",1);
			getJavaRulesetRelDetailForm().setValue("MODULE_ID",window.dialogArguments);
			}
		getJavaRulesetRelDetailForm().setValue("BCE_FRAME_ID","<%=frameId%>","<%=frameId%>");
	}

	function getJavaRulesetRelDetailForm(){
		return g_FormRowSetManager.get("javarulesetrelDetail");
	}
    
	function save(){
		if(getJavaRulesetRelDetailForm().isFieldNull("RULESET_ID,RULESET_TYPE",true)){
			return false;
			}
		var list = new Array();
		list.push(getJavaRulesetRelDetailForm());
		var ud = saveRowSet("<%=request.getContextPath()%>/business/com.ai.bce.web.BceStudioAction?action=commonSaveRowset",list,false);
		 
		if (ud.getValueByName("FLAG") == "ERROR" && ud.getValueByName("MESSAGE")!='' 
			&& ud.getValueByName("MESSAGE")!=null) {
			return;
		} 
			window.returnValue = 1;
			window.close();
	}
	
	function cancel(){
		window.close();
	}

	function getJavaruleSetId(){
		var rulesetType = "2";
		if(getJavaRulesetRelDetailForm().getValue("RULESET_TYPE") == "99"){
			rulesetType = "1";
		}
		var rtnVal = window.showModalDialog("../ruleset/selectRuleset.jsp?RULESET_TYPE="+rulesetType+"&form=javarulesetrelDetail&col=RULESET_ID",getJavaRulesetRelDetailForm().getValue("MODULE_ID") ,
				"scroll:no;resizable:no;help:no;status:no;dialogHeight:480px;dialogWidth:700px");
		if(rtnVal != null){
		    			if(rtnVal == -1){
		    				getJavaRulesetRelDetailForm().setValue("RULESET_ID", '');
		    			}else{
		    				getJavaRulesetRelDetailForm().setValue("RULESET_ID", rtnVal,rtnVal);
		    			}
		    		}	
	}
</script>
</html>