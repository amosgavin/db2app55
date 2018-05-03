<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="Ԥ����ֵ����" res="i18n.secframe_resource"/></title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initPage()">

<ai:contractframe id="queryframe" contenttype="table" title="��ѯ����" width="100%" allowcontract="false" frameclosed="false">
<ai:contractitem/>
<ai:dbform formid="queryForm" 
			setname="com.asiainfo.costWarn.web.CostWarn" 
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.costWarn.service.interfaces.ICostWarnSV"
			implservice_querymethod="getCostWarnValue(String cfId, String cityId, String target)"
			editable="true" initial="false">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			  <tr>
	           		<td class="td_font">Ԥ�����У�</td>
	           		<td><ai:dbformfield formid="queryForm" fieldname="CITY_ID" width="150"/>
	           		</td>
	           		<td class="td_font">Ԥ����Դ���ͣ�</td>
	           		<td><ai:dbformfield formid="queryForm" fieldname="TARGET" width="180"/>
	           			<ai:button id="bt_query" text="��ѯ" onclick="queryCostWarn()"/>
	           		</td>
	           	</tr>
		</table>
	</ai:dbform>
</ai:contractframe>

<ai:contractframe id="costWarnTframe" contenttype="table" title="�ɱ�Ԥ������" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem>
	<ai:button id="add-id" text="����" onclick="addCostWarn()"/>
	<ai:button id="delete-id" text="ɾ ��" onclick="deleteCostWarn()"/>
	</ai:contractitem>
	<ai:table setname="com.asiainfo.costWarn.web.CostWarn"
			  tableid="costWarnTab" editable="false" width="100%" height = "250"
			  needrefresh="true" initial="false" multiselect="true" pagesize="7"
			  tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			  implservice_name="com.asiainfo.costWarn.service.interfaces.ICostWarnSV"
			  implservice_querymethod="getCostWarnValues(String cfId, String cityId, String target, String levelId, String grade, int $STARTROWINDEX, int $ENDROWINDEX)"
			  implservice_countmethod="getCountCostWarnValues(String cfId, String cityId, String target, String levelId, String grade)"			  
			  onrowchange="showToForm" ondbclick="showReceiverInfo">
			    <ai:col fieldname="CF_ID" width="20%" editable="false" visible="false" />
			    <ai:col fieldname="CITY_ID" width="20%" editable="false" visible="true" />
	        	<ai:col fieldname="TARGET" width="20%" editable="false" visible="true" />
	        	<ai:col fieldname="LEVEL_ID" width="10%" editable="false" visible="false" />
	        	<ai:col fieldname="GRADE" width="10%" editable="false" visible="true" />
				<ai:col fieldname="WARN_LINE1" width="10%" editable="false" visible="true" /> 
				<ai:col fieldname="WARN_LINE2" width="10%" editable="false" visible="true"/>
				<ai:col fieldname="WARN_LINE3" width="10%" editable="false" visible="true"/>
	</ai:table>
</ai:contractframe>

<ai:contractframe id="costWarnFframe" contenttype="table" title="Ԥ������" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem/>
	<ai:dbform formid="costWarnForm" initial="false"
			setname="com.asiainfo.costWarn.web.CostWarn" 
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.costWarn.service.interfaces.ICostWarnSV"
			implservice_querymethod="getCostWarnValue(String cfId, String cityId, String target, String levelId, String grade)"
		    editable="true" onvalchange="onTargetValChange">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
	    
	            <tr>
	           		<td class="td_font">Ԥ�����У�</td>
	           		<td><ai:dbformfield formid="costWarnForm" fieldname="CITY_ID" width="150"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font">Ԥ����Դ���ͣ�</td>
	           		<td><ai:dbformfield formid="costWarnForm" fieldname="TARGET" width="180"/><span class="font_red">*</span>
	           		</td>
	           	</tr>
	           	<tr id="level_tr" style="display: none">
	           		<td class="td_font">Ӫ��������ID��</td>
	           		<td><ai:dbformfield formid="costWarnForm" fieldname="LEVEL_ID" width="150"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font">Ԥ������</td>
	           		<td><ai:dbformfield formid="costWarnForm" fieldname="GRADE" width="180"/><span class="font_red">*</span>
	           		</td>
	           	</tr>
	           	<tr>
	           		<td class="td_font">Ԥ����ֵ1��</td>
	           		<td><ai:dbformfield formid="costWarnForm" fieldname="WARN_LINE1" width="150"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font">Ԥ����ֵ2��</td>
	           		<td><ai:dbformfield formid="costWarnForm" fieldname="WARN_LINE2" width="180"/><span class="font_red">*</span>
	           		</td>
	           	</tr>
	           	 <tr>
	           		<td class="td_font">Ԥ����ֵ3��</td>
	           		<td><ai:dbformfield formid="costWarnForm" fieldname="WARN_LINE3" width="150"/><span class="font_red">*</span>
	           		</td>
	           	</tr>
		</table>
	</ai:dbform>
	<ai:button id="bt_saveCostWarn" text="����" onclick="saveCostWarn()"/>
</ai:contractframe>



<ai:loginuser />
<script type="text/javascript">
var costWarnForm = g_FormRowSetManager.get("costWarnForm");	
var costWarnTab = g_TableRowSetManager.get("costWarnTab");

function initPage(){

	costWarnTab.refresh(null);
	costWarnForm.setValue("GRADE","1");
}

function addCostWarn()
{
	costWarnForm.newRow();
	costWarnForm.setEditSts(true);
	costWarnForm.setValue("GRADE","1");
}

function saveCostWarn()
{
	if ("" == costWarnForm.getValue("CITY_ID"))
    {
        alert("�ڱ���֮ǰ����ѡ��Ԥ�����С���");
        costWarnForm.setFocus("CITY_ID");
        return;
    }
	if ("" == costWarnForm.getValue("TARGET"))
    {
        alert("�ڱ���֮ǰ����ѡ��Ԥ����Դ���͡���");
        costWarnForm.setFocus("TARGET");
        return;
    }
	if ("L1" == costWarnForm.getValue("TARGET") && "" == costWarnForm.getValue("LEVEL_ID"))
	{
		alert("�ڱ���֮ǰ�������롰Ӫ��������ID����");
		costWarnForm.setFocus("LEVEL_ID");
		return;
	}
	if ("" == costWarnForm.getValue("WARN_LINE1"))
    {
        alert("�ڱ���֮ǰ�������롰Ԥ����ֵ1����");
        costWarnForm.setFocus("WARN_LINE1");
        return;
    }
	if ("" == costWarnForm.getValue("WARN_LINE2"))
    {
        alert("�ڱ���֮ǰ�������롰Ԥ����ֵ2����");
        costWarnForm.setFocus("WARN_LINE2");
        return;
    }
	if ("" == costWarnForm.getValue("WARN_LINE3"))
    {
        alert("�ڱ���֮ǰ�������롰Ԥ����ֵ3����");
        costWarnForm.setFocus("WARN_LINE3");
        return;
    }
	if ("O" != costWarnForm.getSts())
    {
        var list = new Array();
        list.push(costWarnForm);
        var strUrl = _gModuleName + '/business/com.asiainfo.costWarn.web.CostWarnAction?action=saveCostWarn';
        var recode = saveRowSet(strUrl, list);
        var rFlag = recode.getValueByName("FLAG");
        if ("Y" == rFlag)
        {
        	//alert("����ɹ���");
        	costWarnTab.refresh(null);
        	//ˢ��
        	addCostWarn();
        } 
        return rFlag;
    } else {
        return;
    }
}

function deleteCostWarn()
{
	if(confirm("��ȷ��Ҫɾ����")){
		
		var delRows = costWarnTab.getSelectedRows();
		var delRowCount = delRows.length;
		if (delRowCount == 0) {
			alert("����ѡ��Ҫɾ������");
			return;
		}
		while (delRowCount > 0) {
			delRowCount--;
			costWarnTab.deleteRow(delRows[delRowCount]);
		}
		var list = new Array();
		list.push(costWarnTab);
		var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.costWarn.web.CostWarnAction?action=saveCostWarn';
		var ud = saveRowSet(strUrl, list);
		if (ud.getValueByName("FLAG") == "Y") {
			costWarnTab.refresh(null);
	        costWarnForm.newRow();
		} else {
			alert(ud.getValueByName("MESSAGE"));
			return;
		}
	}
}

function showToForm(oldIndex,newIndex)
{
   if(-1 != oldIndex) {
     costWarnTab.setRowBgColor(oldIndex,"");
   }
   costWarnTab.setRowBgColor(newIndex,"yellow");
   var rowIndex = costWarnTab.getCurRowIndex();
   var cfId = costWarnTab.getValue(rowIndex,"CF_ID");
   costWarnForm.refresh("&cfId="+cfId);
}

function queryCostWarn()
{
	var cityId = g_FormRowSetManager.get("queryForm").getValue("CITY_ID");
	var target = g_FormRowSetManager.get("queryForm").getValue("TARGET");
	costWarnTab.refresh("&cityId=" + cityId + "&target=" + target);
}

function onTargetValChange(pFieldName,pOldVal,pOldText,pNewVal,pNewText)
{
	if (pFieldName == 'TARGET') {
		//alert(pOldText);
		if ("L1" == pOldText) {
			document.getElementById("level_tr").style.display="block";
		} else {
			document.getElementById("level_tr").style.display="none";
		}
	}
}

function showReceiverInfo()
{
	var rowIndex = costWarnTab.getRow();
   	var cityId = costWarnTab.getValue(rowIndex,"CITY_ID");
   	var target = costWarnTab.getValue(rowIndex,"TARGET");
   	var levelId = costWarnTab.getValue(rowIndex,"LEVEL_ID");
   	var grade = costWarnTab.getValue(rowIndex,"GRADE");
	var url = "<%=request.getContextPath()%>/costWarn/receiverSet.jsp?cityId="
	                                                                 +cityId+"&target="+target+"&levelId="+levelId+"&grade="+grade;
	window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:s;dialogHeight:600px;dialogWidth:680px");
}
</script>
</body>
</html>