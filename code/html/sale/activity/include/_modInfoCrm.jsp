<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title>CRM������Ϣ���</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/jquery/jquery-1.8.3.js" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
  
<body onload="initPage()">
<ai:contractframe id="ModDetailframe" contenttype="table" title="CRM-�����ϸ" width="100%" allowcontract="true" frameclosed="false">
<ai:contractitem/>
    <div id="privmod_div" style="display: block">
	<ai:contractframe id="PrivDetailframe" contenttype="table" title="����-������Ϣ" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="PrivDetailTab" footdisplay="none"
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.common.web.SETDoAnyThing" 
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="60" pagesize="4">
		        <ai:col title="" fieldname="COL0" width="50" />
		        <ai:col title="Ӫ����������" fieldname="COL1" width="180" />
		        <ai:col title="Ӫ����������" fieldname="COL2" width="170" />
		        <ai:col title="��ʼʱ��" fieldname="COL3" width="170" />
		        <ai:col title="ͣ��ʱ��" fieldname="COL4" width="200" />
		        <ai:col title="Ӫ����������" fieldname="COL5" width="170" />
		        <ai:col title="������λ" fieldname="COL6" width="100" />
		        <ai:col title="�Żݶ�������" fieldname="COL7" width="130" />
		        <ai:col title="�Żݼ�ֵ" fieldname="COL8" width="100" />
		 </ai:table>
	</ai:contractframe>
	
	<ai:contractframe id="Privorgframe" contenttype="table" title="����-ʹ�õ�λ" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="PrivorgTab" footdisplay="rowcount"
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.common.web.SETDoAnyThing"
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="150" pagesize="4">
		        <ai:col title="" fieldname="COL0" width="50" />
		        <ai:col title="Ӫ����������" fieldname="COL1" width="180" />
		        <ai:col title="��λ����" fieldname="COL2" width="170" />
		        <ai:col title="����ʱ��" fieldname="COL3" width="170" />
		        <ai:col title="״̬" fieldname="COL4" width="170" />
		        <ai:col title="״̬ʱ��" fieldname="COL5" width="170" />
		</ai:table>
	</ai:contractframe>  
		
	<ai:contractframe id="Privrewardframe" contenttype="table" title="����-��ѡ��Ʒ" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="PrivrewardTab" footdisplay="none"
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.common.web.SETDoAnyThing"
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="150" pagesize="4">
		        <ai:col title="" fieldname="COL0" width="50" />
		        <ai:col title="Ӫ����������" fieldname="COL1" width="180" />
		        <ai:col title="���㷽ʽ" fieldname="COL2" width="170" />
		        <ai:col title="�Ż�ֵ" fieldname="COL3" width="170" />
		        <ai:col title="��Ʒ����" fieldname="COL4" width="170" />
		        <ai:col title="��Ʒ��ID(����)" fieldname="COL5" width="170" />
		        <ai:col title="ѡ��ʽ" fieldname="COL6" width="170" />
		        <ai:col title="״̬ʱ��" fieldname="COL7" width="170" />
		</ai:table>
	</ai:contractframe>
	
	<ai:contractframe id="Privoperframe" contenttype="table" title="����-ָ������" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="PrivoperTab" footdisplay="none"
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.common.web.SETDoAnyThing"
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="150" pagesize="4">
		        <ai:col title="" fieldname="COL0" width="50" />
		        <ai:col title="Ӫ����������" fieldname="COL1" width="180" />
		        <ai:col title="����" fieldname="COL2" width="170" />
		        <ai:col title="�������" fieldname="COL3" width="170" />
		        <ai:col title="������ʽ" fieldname="COL4" width="170" />
		        <ai:col title="����Ա/������" fieldname="COL5" width="170" />
		        <ai:col title="����ʱ��" fieldname="COL6" width="170" />
		        <ai:col title="״̬" fieldname="COL7" width="70" />
		        <ai:col title="״̬ʱ��" fieldname="COL8" width="130" />
		</ai:table>
	</ai:contractframe>
	
	<ai:contractframe id="otherInfoframe" contenttype="table" title="����-�������" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="otherInfoTab" footdisplay="rowcount"
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.common.web.SETDoAnyThing"
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="200" pagesize="4">
		        <ai:col title="" fieldname="COL0" width="100" />
		        <ai:col title="" fieldname="COL1" width="180" />
		        <ai:col title="" fieldname="COL2" width="170" />
		        <ai:col title="" fieldname="COL3" width="170" />
		        <ai:col title="" fieldname="COL4" width="170" />
		        <ai:col title="" fieldname="COL5" width="170" />
		        <ai:col title="" fieldname="COL6" width="170" />
		        <ai:col title="" fieldname="COL7" width="70" />
		        <ai:col title="" fieldname="COL8" width="130" />
		        <ai:col title="" fieldname="COL9" width="130" />
		        <ai:col title="" fieldname="COL10" width="130" />
		        <ai:col title="" fieldname="COL11" width="130" />
		        <ai:col title="" fieldname="COL12" width="130" />
		        <ai:col title="" fieldname="COL13" width="130" />
		        <ai:col title="" fieldname="COL14" width="130" />
		        <ai:col title="" fieldname="COL15" width="130" />
		        <ai:col title="" fieldname="COL16" width="130" />
		        <ai:col title="" fieldname="COL17" width="130" />
		        <ai:col title="" fieldname="COL18" width="130" />
		        <ai:col title="" fieldname="COL19" width="130" />
		        <ai:col title="" fieldname="COL20" width="130" />
		</ai:table>
	</ai:contractframe>
	</div>
	
	<div id="prodmod_div" style="display: block">
	<ai:contractframe id="prodInfoframe" contenttype="table" title="����-�����Ϣ" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	    <ai:table tableid="prodInfoTab" footdisplay="rowcount"
	           tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	           setname="com.asiainfo.common.web.SETDoAnyThing"
	           conditionname="condition" parametersname="parameters"
	           editable="false" initial="false" width="100%" height="200" pagesize="4">
		        <ai:col title="" fieldname="COL0" width="100" />
		        <ai:col title="" fieldname="COL1" width="180" />
		        <ai:col title="" fieldname="COL2" width="170" />
		        <ai:col title="" fieldname="COL3" width="170" />
		        <ai:col title="" fieldname="COL4" width="170" />
		        <ai:col title="" fieldname="COL5" width="170" />
		        <ai:col title="" fieldname="COL6" width="170" />
		        <ai:col title="" fieldname="COL7" width="70" />
		        <ai:col title="" fieldname="COL8" width="130" />
		        <ai:col title="" fieldname="COL9" width="130" />
		        <ai:col title="" fieldname="COL10" width="130" />
		        <ai:col title="" fieldname="COL11" width="130" />
		        <ai:col title="" fieldname="COL12" width="130" />
		        <ai:col title="" fieldname="COL13" width="130" />
		        <ai:col title="" fieldname="COL14" width="130" />
		        <ai:col title="" fieldname="COL15" width="130" />
		        <ai:col title="" fieldname="COL16" width="130" />
		        <ai:col title="" fieldname="COL17" width="130" />
		        <ai:col title="" fieldname="COL18" width="130" />
		        <ai:col title="" fieldname="COL19" width="130" />
		        <ai:col title="" fieldname="COL20" width="130" />
		</ai:table>
	</ai:contractframe>
	</div>
	<ai:contractframe id="crmAuditframe" contenttype="table" title="���" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
		<ai:dbform formid="crmAuditForm" initial="false" editable="true"
				setname="com.asiainfo.common.web.SETCrmAuditLog">
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
				<tr><td class="td_font">��������</td>
		           	<td><ai:dbformfield formid="crmAuditForm" fieldname="CONTENT" width="600" height="50"/>
		           	    <ai:dbformfield formid="crmAuditForm" fieldname="INTERFACE_ID" width="170" visible="false"/>
		           	    <ai:dbformfield formid="crmAuditForm" fieldname="MODE_ID" width="170" visible="false"/>
		           	    <ai:dbformfield formid="crmAuditForm" fieldname="BOSS_CODE" width="170" visible="false"/>
		           	    <ai:dbformfield formid="crmAuditForm" fieldname="AUDIT_FLAG" width="170" visible="false"/>
		           	    <ai:button id="bt_yes" text="���ͨ��"  onclick="auditPrivMod(1)"/>
				        <ai:button id="bt_no" text="��    ��"  onclick="auditPrivMod(0)"/></td>
			</table>
	    </ai:dbform>
	</ai:contractframe>
</ai:contractframe>
<ai:loginuser/>
</body>
<script language="javascript" src="<%=request.getContextPath()%>/sale/activity/js/requestToCrm.js"></script>
<script type="text/javascript">
var modoID = "";
var privID = "<%=request.getParameter("privID")%>";
var prodID = "<%=request.getParameter("prodID")%>";
function initPage() {
	showPrivModDetail(privID, prodID);
	showProdModDetail(privID, prodID);
}

function showPrivModDetail(privID, prodID) {
	
	var PrivDetailTab = g_TableRowSetManager.get("PrivDetailTab");
	var PrivorgTab = g_TableRowSetManager.get("PrivorgTab");
	var PrivrewardTab = g_TableRowSetManager.get("PrivrewardTab");
	var PrivoperTab = g_TableRowSetManager.get("PrivoperTab");
	var otherInfoTab = g_TableRowSetManager.get("otherInfoTab");
	var privModDetail = query_CRM("Privmoddetailqry",privID, prodID);
	if (privModDetail == "" || privModDetail.body.array.$list == "") {
		return document.getElementById("privmod_div").style.display="none";
	}
	document.all("contractFrame_ModDetailframe").style.display='block';
	modoID = privModDetail.body.array.$list[0].MODOID;
	var objname = "";
	var attr = "";
	var otherAttrNum = 0;
	var detAttr = ["Ӫ����������","Ӫ����������","��ʼʱ��","ͣ��ʱ��","Ӫ����������","������λ","�Żݶ�������","�Żݼ�ֵ"];
	var orgAttr = ["Ӫ����������","��λ����","����ʱ��","״̬","״̬ʱ��"];
	var operAttr = ["Ӫ����������","����","�������","������ʽ","����Ա/������","����ʱ��","״̬","״̬����"];
	var rewardAttr = ["Ӫ����������","���㷽ʽ","�Ż�ֵ","��Ʒ����","��Ʒ��ID(����)","ѡ��ʽ","״̬ʱ��"];
	for (var i=0; i< privModDetail.body.array.$list.length; ++i) {
		if (privModDetail.body.array.$list[i].OBJNAME == "���λ�����Ϣ") {
			if (PrivDetailTab.count() ==  0 || objname != privModDetail.body.array.$list[i].OBJNAME 
					|| (attr.indexOf(privModDetail.body.array.$list[i].OBJATTRNAME) != -1)) {
				PrivDetailTab.newRow(false);
				attr = "";
			}
			PrivDetailTab.setValue(PrivDetailTab.count()-1,"COL0", privModDetail.body.array.$list[i].MODTYPE);
			for (var j = 1; j < 9; ++j) {
				if (privModDetail.body.array.$list[i].OBJATTRNAME == detAttr[j-1]) {
					if (privModDetail.body.array.$list[i].OLDVALUE == "") {
						PrivDetailTab.setValue(PrivDetailTab.count()-1,"COL"+j, privModDetail.body.array.$list[i].NEWVALUE);
					} else {
						PrivDetailTab.setValue(PrivDetailTab.count()-1,"COL"+j, privModDetail.body.array.$list[i].OLDVALUE + "-->" + privModDetail.body.array.$list[i].NEWVALUE);
					}
					attr +=privModDetail.body.array.$list[i].OBJATTRNAME;
					break;
				}
			}
		} else if (privModDetail.body.array.$list[i].OBJNAME == "ʹ�õ�λ") {
			if (PrivorgTab.count() ==  0 || objname != privModDetail.body.array.$list[i].OBJNAME
					|| (attr.indexOf(privModDetail.body.array.$list[i].OBJATTRNAME) != -1)){
				PrivorgTab.newRow(false);
				attr = "";
			}
			PrivorgTab.setValue(PrivorgTab.count()-1,"COL0", privModDetail.body.array.$list[i].MODTYPE);
			for (var j = 1; j < 6; ++j) {
				if (privModDetail.body.array.$list[i].OBJATTRNAME == orgAttr[j-1]) {
					PrivorgTab.setValue(PrivorgTab.count()-1,"COL"+j, privModDetail.body.array.$list[i].NEWVALUE);
					attr +=privModDetail.body.array.$list[i].OBJATTRNAME;
					break;
				}
			}
		} else if (privModDetail.body.array.$list[i].OBJNAME == "ָ������") {
			if (PrivoperTab.count() ==  0 || objname != privModDetail.body.array.$list[i].OBJNAME
					|| (attr.indexOf(privModDetail.body.array.$list[i].OBJATTRNAME) != -1)){
				PrivoperTab.newRow(false);
				attr = "";
			}
			PrivoperTab.setValue(PrivoperTab.count()-1,"COL0", privModDetail.body.array.$list[i].MODTYPE);
			for (var j = 1; j < 9; ++j) {
				if (privModDetail.body.array.$list[i].OBJATTRNAME == operAttr[j-1]) {
					PrivoperTab.setValue(PrivoperTab.count()-1,"COL"+j, privModDetail.body.array.$list[i].NEWVALUE);
					attr +=privModDetail.body.array.$list[i].OBJATTRNAME;
					break;
				}
			}
		} else if (privModDetail.body.array.$list[i].OBJNAME == "��ѡ��Ʒ") {
			if (PrivrewardTab.count() ==  0 || objname != privModDetail.body.array.$list[i].OBJNAME
					|| (attr.indexOf(privModDetail.body.array.$list[i].OBJATTRNAME) != -1)){
				PrivrewardTab.newRow(false);
				attr = "";
			}
			PrivrewardTab.setValue(PrivrewardTab.count()-1,"COL0", privModDetail.body.array.$list[i].MODTYPE);
			for (var j = 1; j < 8; ++j) {
				if (privModDetail.body.array.$list[i].OBJATTRNAME == rewardAttr[j-1]) {
					PrivrewardTab.setValue(PrivrewardTab.count()-1,"COL"+j, privModDetail.body.array.$list[i].NEWVALUE);
					attr +=privModDetail.body.array.$list[i].OBJATTRNAME;
					break;
				}
			}
		} else {
			if (otherInfoTab.count() == 0 || objname != privModDetail.body.array.$list[i].OBJNAME
					|| (attr.indexOf(privModDetail.body.array.$list[i].OBJATTRNAME) != -1)) {
				otherInfoTab.newRow(false);
				otherInfoTab.setRowBgColor(otherInfoTab.count()-1,'A1A1A1');
				otherInfoTab.newRow(false);
				otherInfoTab.setRowBgColor(otherInfoTab.count()-1,'FFFFFF');
				//otherInfoTab.newRow(false);
				attr = "";
				otherAttrNum = 0;
			}
			++otherAttrNum;
			otherInfoTab.setValue(otherInfoTab.count()-2,"COL0", privModDetail.body.array.$list[i].OBJNAME);
			otherInfoTab.setValue(otherInfoTab.count()-1,"COL0", privModDetail.body.array.$list[i].MODTYPE);
			otherInfoTab.setValue(otherInfoTab.count()-2,"COL"+otherAttrNum, privModDetail.body.array.$list[i].OBJATTRNAME);
			otherInfoTab.setValue(otherInfoTab.count()-1,"COL"+otherAttrNum, privModDetail.body.array.$list[i].NEWVALUE);
			attr +=privModDetail.body.array.$list[i].OBJATTRNAME;
		}
		objname = privModDetail.body.array.$list[i].OBJNAME;
	}
}

function showProdModDetail(privID, prodID) {
	
	var prodInfoTab = g_TableRowSetManager.get("prodInfoTab");
	var prodModDetail = query_CRM("Prodmoddetailqry",privID, prodID);
	if (prodModDetail == "" ||��prodModDetail.body.array.$list == "") {
		return document.getElementById("prodmod_div").style.display="none";
	}
	document.all("contractFrame_ModDetailframe").style.display='block';
	modoID = prodModDetail.body.array.$list[0].MODOID;
	for (var i=0; i< prodModDetail.body.array.$list.length; ++i) {
		if (prodInfoTab.count() == 0 || objname != prodModDetail.body.array.$list[i].OBJNAME
						|| (attr.indexOf(prodModDetail.body.array.$list[i].OBJATTRNAME) != -1)) {
			prodInfoTab.newRow(false);
			prodInfoTab.setRowBgColor(prodInfoTab.count()-1,'A1A1A1');
			prodInfoTab.newRow(false);
			prodInfoTab.setRowBgColor(prodInfoTab.count()-1,'FFFFFF');
			//prodInfoTab.newRow(false);
			attr = "";
			otherAttrNum = 0;
		}
		++otherAttrNum;
		prodInfoTab.setValue(prodInfoTab.count()-2,"COL0", prodModDetail.body.array.$list[i].OBJNAME);
		prodInfoTab.setValue(prodInfoTab.count()-1,"COL0", prodModDetail.body.array.$list[i].MODTYPE);
		prodInfoTab.setValue(prodInfoTab.count()-2,"COL"+otherAttrNum, prodModDetail.body.array.$list[i].OBJATTRNAME);
		prodInfoTab.setValue(prodInfoTab.count()-1,"COL"+otherAttrNum, prodModDetail.body.array.$list[i].NEWVALUE);
		attr +=prodModDetail.body.array.$list[i].OBJATTRNAME;
		objname = prodModDetail.body.array.$list[i].OBJNAME;
	}
}

function auditPrivMod(flag) {
	alert(1);
	var crmAuditForm = g_FormRowSetManager.get("crmAuditForm");
	var retState;
	//var modeID = privModDetailTab.getValue(privModDetailTab.getRow(),"MODOID");
	if (modoID == "") return alert("��ѡ����Ҫ��˵ı�����ţ�");
   	retState = audit_CRM("Privmodaudit", privID, prodID, modoID, flag);
	if (retState.head.retCode == 0) {
		alert("��˳ɹ���");
	} else {
		crmAuditForm.setValue("CONTENT","���ʧ��");
		alert("���ʧ�ܣ�");
	}
	crmAuditForm.setValue("INTERFACE_ID","Privmodaudit");
	crmAuditForm.setValue("BOSS_CODE",privID);
	crmAuditForm.setValue("MODE_ID",modoID);
	crmAuditForm.setValue("AUDIT_FLAG",flag);
	var list = new Array();
	list.push(crmAuditForm);
	var strUrl = _gModuleName + '/business/com.asiainfo.common.web.CrmAuditLogAction?action=saveAuditLog';
	var recode = saveRowSet(strUrl, list);
}
</script>
