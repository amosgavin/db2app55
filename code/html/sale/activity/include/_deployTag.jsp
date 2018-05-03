<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>

<body onload="initWPTag()">
<ai:contractframe id="weaponListframe" contenttype="table" title="������Ϣ" width="100%" allowcontract="true" frameclosed="true" >
	<ai:contractitem>
		<ai:button id="show" text="�鿴��������" onclick="showWeaponDetail()"/>
	</ai:contractitem>
 	<ai:table
		tableid="weaponMainListTable"
		setname="com.asiainfo.sale.weapon.web.SETSaleWeapon"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
		implservice_querymethod="getSaleWeaponByActivityId(String activityId)"
		initial="false" pagesize="200" editable="false" width="100%"
		height="200" needrefresh="true" footdisplay ="rowcount" >
		<ai:col title="���" fieldname="WID" width="10%"  visible="false"/>
		<ai:col title="�������" fieldname="MID" width="10%"/>
		<ai:col title="��������" fieldname="WEAPON_NAME" width="20%" />
		<ai:col title="����" fieldname="SALE_FLAG" width="15%" />
		<ai:col title="ϸ���г�" fieldname="MARKET_TYPE" width="15%" />
		<ai:col title="����" fieldname="NET_AGE" width="15%" />
		<ai:col title="����ʱ��" fieldname="CREATE_TIME" width="17%" />
	</ai:table>
</ai:contractframe>

<ai:contractframe id="tagDetailframe" contenttype="table" title="�迪����ǩ(��дӪҵ�ʷ�ID)" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem>
		<ai:button id="tag_save_bt" text="����" onclick="saveTag('tip')"/>
	</ai:contractitem>
	<ai:table setname="com.asiainfo.sale.tag.web.SETPromationTag"
			  tableid="detailTagTab" editable="true" width="100%" pagesize="200"
			  needrefresh="true" initial="false" height = "250" multiselect="false"
			  tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			  implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
			  implservice_querymethod="getSpareTagByActivityId(String activityId)"
			  operator="query" footdisplay ="rowcount">
	       		<ai:col fieldname="WPID" width="6%" editable="false" visible="" />
	       		<ai:col title="Ӫҵ�ʷ�ID" fieldname="TAG_CODE" width="10%" visible="true"/>
	       		<ai:col title="������" fieldname="STANDBY_NUM1" width="6%" editable="false" visible="true" />
	        	<ai:col fieldname="TAG_TYPE" width="10%" editable="false" visible="true" />
				<ai:col fieldname="NAME" width="10%" editable="false" visible="true" /> 
				<ai:col title="Ԥ��˰��(%)" fieldname="STANDBY_NUM2" width="6%" editable="false" visible="true" />
				<ai:col title="ʵ������˰��(%)" fieldname="STANDBY_NUM3" width="6%" visible="true" />
				<ai:col fieldname="ADD_MONTHCHARGE" title="�ܽ��" width="5%" editable="false" visible="true" />
				<ai:col fieldname="FIRSTCHARGE" title="�״ε���"  width="6%" editable="false" visible="true"/> 
				<ai:col fieldname="LASTCHARGE"  title="ĩ�ε���" width="7%" editable="false" visible="true"/> 
				<ai:col fieldname="CHARGE" title="ÿ�½��" width="7%" editable="false" visible="true"/>
				<ai:col title="ÿ������ֵ" fieldname="SUMCHARGE" width="8%" editable="false" />
				<ai:col fieldname="CYCLE"  width="7%" editable="false" visible="true"/> 
				<ai:col title="��������" fieldname="RETURN_TYPE" width="10%" editable="false" visible="true"/>
				<ai:col fieldname="AREA" width="7%" editable="false" visible="true"/>
				<ai:col title="��ǩ��ע" fieldname="REMARK_TAG" width="10%" editable="false" visible="true"/>
				<ai:col title="ר�Χ" fieldname="IS_SP" width="10%" editable="false" visible="true"/>
				<ai:col title="��������" fieldname="ACCOUNT_TYPE" width="10%" editable="false" visible="true"/>
				<ai:col fieldname="STATE" width="10%" editable="false" visible="true"/>
	</ai:table>
</ai:contractframe>	
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js"></script>
<script type="text/javascript">

var _tableTagDetailRowSet = g_TableRowSetManager.get("detailTagTab");
var weaponRs = g_TableRowSetManager.get("weaponMainListTable");
var rid = "<%=request.getParameter("orderId")%>";
function initWPTag()
{
	if (rid == null || rid == "" || 
			(taskTag != 'wp02' && taskTag != 'su105' && taskTag != 'su106')){
		return;
	} else {
		if (taskTag == 'su105') {
			_tableTagDetailRowSet.setColEditSts("TAG_CODE",false);
			_tableTagDetailRowSet.setColEditSts("STANDBY_NUM2",true);
			_tableTagDetailRowSet.setColEditSts("STANDBY_NUM3",false);
		} else if (taskTag == 'su106') {
			_tableTagDetailRowSet.setColEditSts("TAG_CODE",false);
			_tableTagDetailRowSet.setColEditSts("STANDBY_NUM3",false);
			document.getElementById("tag_save_bt").style.display = "none";
		}
		weaponRs.refresh("&activityId="+rid);
		_tableTagDetailRowSet.refresh("&activityId="+rid);
	}
}

function showWeaponDetail(){
	
	var curRowIndex = weaponRs.getCurRowIndex();
	var weaponId = weaponRs.getValue(curRowIndex, "MID");
	var saleFale=weaponRs.getValue(curRowIndex, "SALE_FLAG");
	if ( weaponId != null && weaponId != ""){
		window.open("<%=request.getContextPath()%>/sale/weapon/WeaponInfo.jsp?WID="+weaponId + "&saleFale="+saleFale,"","height=650,width=600,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
    } else {
        alert("��ѡ�����У�");
    }
}

function changeTagToUse() {
	var length = _tableTagDetailRowSet.getTotalRowCount();
	for (var i=0; i<length; ++i){
		if (_tableTagDetailRowSet.getValue(i, "STATE") == "99") {
			var tmp = _tableTagDetailRowSet.getValue(i, "TAG_CODE");
			if (null != tmp && "" != tmp){
				_tableTagDetailRowSet.setValue(i, "STATE", "1");
			}
		}
	}
	saveTag();
}

function checkHasEmptyTagBossId()
{
	var length = _tableTagDetailRowSet.getTotalRowCount();
	for (var i=0; i<length; ++i){
		if (_tableTagDetailRowSet.getValue(i, "STATE") == "99") {
			var tmp1 = _tableTagDetailRowSet.getValue(i, "TAG_CODE");
			if (null != tmp1 && "" != tmp1){
				_tableTagDetailRowSet.setValue(i, "STANDBY_NUM1", g_GetUserInfo().STAFF_NAME);
			}
		}
	}
	saveTag();
	for (var i=0; i<length; ++i){
		var tmp2 = _tableTagDetailRowSet.getValue(i, "TAG_CODE");
		if (null == tmp2 || "" == tmp2){
			return true;
		}
	}
	for (var i=0; i<length; ++i){
		var tmp3 = _tableTagDetailRowSet.getValue(i, "STANDBY_NUM3");
		if (null == tmp3 || "" == tmp3){
			return true;
		}
	}
	return false;
}

function checkHasEmptyTagTax()
{
	saveTag();
	var length = _tableTagDetailRowSet.getTotalRowCount();
	
	for (var i=0; i<length; ++i){
		var tmp = _tableTagDetailRowSet.getValue(i, "STANDBY_NUM2");
		if (null == tmp || "" == tmp){
			return true;
		}
	}
	return false;
}

function saveTag(flag)
{
	var xmlbody = _tableTagDetailRowSet.toXmlString(true);
	if (xmlbody == null || xmlbody == "") {
		//alert("����û�ı�!");
		return;
	}
	var xml = "<RootInfo>" + xmlbody + "</RootInfo>";
	var ud = PostInfo(
			"<%=request.getContextPath()%>/business/com.asiainfo.sale.tag.web.DetailTagAction?action=saveDetailTag&pid=0",
			xml);
	if (ud.getValueByName("FLAG") == "Y" && flag == "tip") {
		alert("����Ӫҵ�ʷ�ID�ɹ���");
	} else if (ud.getValueByName("FLAG") == "N") {
		alert(ud.getValueByName("MESSAGE"));
	}
}

function reasonGo(wid, taskType){
  reason(wid,taskType);
}

function showTagInfo()
{
	if(weaponRs.getTotalRowCount() == 0){
		return;
	}
	var count = weaponRs.count();
	var mids = "";
	for(var i=0;i<count;i++){
		mids = mids + weaponRs.getValue(i, "WID")+",";
	}
	_tableTagDetailRowSet.refresh("&mids=" + mids);
	var curRowIndex = weaponRs.getCurRowIndex();
	var weaponId = weaponRs.getValue(curRowIndex, "WID");
	//_tableTagDetailRowSet.refresh("&weaponId=" + weaponId);
	//reasonGo(weaponId,"weaponCase");
	weap.refresh("&wid=" + weaponId);
	include_reflashAttachTable();
}

function beforeCommit()
{
	var xmlbody = _tableTagDetailRowSet.toXmlString(true);
	if (xmlbody == null || xmlbody == "") {
		//alert("����û�ı�!");
		return;
	}
	var xml = "<RootInfo>" + xmlbody + "</RootInfo>";
	var ud = PostInfo(
			"<%=request.getContextPath()%>/business/com.asiainfo.sale.tag.web.DetailTagAction?action=saveDetailTag&pid=0",
			xml);
	if (ud.getValueByName("FLAG") == "Y") {
	
	} else {
		alert(ud.getValueByName("MESSAGE"));
		return 'no';
	}
}

function trim(str)
{
     return str.replace(/(^\s*)(\s*$)/g, '');
}

</script>
