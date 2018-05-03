<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>�ʷѰ�</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
  
  <body onload="">
  <div id="chargeOrder_div" style="display: none">
  <ai:contractframe id="chargeAMainframe" contenttype="table" title="��������Ϣ" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem>
    </ai:contractitem>
    <ai:dbform formid="chargeAMainframe" 
            setname="com.asiainfo.charge.web.SETChargeMain"
            conditionname="condition" parametersname="parameters"
            editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.charge.service.interfaces.IChargeNewMainSV"
            implservice_querymethod="IChargeMainshow(String id)">
        <table width="98%" align="center" border="0" >
          <tr>
            <td><ai:dbformfield formid="chargeAMainframe" fieldname="REAMRK_1" width="200" editable="" visible="false"/>
            <ai:dbformfield formid="chargeAMainframe" fieldname="MAIN_ID" width="200" editable="" visible="false"/>
            <ai:dbformfield formid="chargeAMainframe" fieldname="STATE" width="200" editable="" visible="false"/>
                </td>
          <td class="td_font">�����ˣ�</td>
                <td><ai:dbformfield formid="chargeAMainframe" fieldname="PRINCIPLE" width="150" editable="false" visible="false"/></td>
                <td><ai:dbformfield formid="chargeAMainframe" fieldname="REAMRK_2" width="150" editable="false" /></td>
                  <td class="td_font">���뵥λ��</td>
                <td><ai:dbformfield formid="chargeAMainframe" fieldname="ORG" width="130" editable="false" visible="false" /></td>
                <td><ai:dbformfield formid="chargeAMainframe" fieldname="REAMRK_3" width="130" editable="false" /></td>
           </tr> 
        </table>
        </ai:dbform>
        </ai:contractframe>
   </div>
   
 <div id="chargeApplyM_div" style="display: none">  
 <ai:contractframe id="chargeApplyMain" contenttype="table" title="�ѱ������������Ϣ" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
    <ai:table
        tableid="chargeApplyMainTable"
        setname="com.asiainfo.charge.web.SETChargeApplyMain"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.charge.service.interfaces.IChargeNewMainSV"
        implservice_querymethod="getApplyMainsByMainId(String mainid)"
        initial="false"  multiselect="" ondbclick="" onrowchange="showApplyMain"
        pagesize="15" editable="false" width="100%" rowheight=""
        height="100" needrefresh="true">
        	<ai:col title="����ID" fieldname="APPLY_ID" visible=""/>
            <ai:col title="����" fieldname="APPLY_NAME" width="20%" />
            <ai:col title="�ʷ�����" fieldname="FEE_TYPE" width="20%" />
        	<ai:col title="ϸ���г�" fieldname="MARKET_TYPE" width="10%"/>
            <ai:col title="��ʼʱ��" fieldname="APPLY_TIME" width="20%" />
            <ai:col title="����ʱ��" fieldname="APPLY_END_TIME" width="20%" />
    </ai:table>
 </ai:contractframe>
 </div>

 <ai:contractframe id="chargeMainframe" contenttype="table" title="�ʷѰ�����Ϣ" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
    <ai:dbform formid="chargeMainframe" 
            setname="com.asiainfo.charge.web.SETChargeApplyMain"
            conditionname="condition" parametersname="parameters"
            onvalchange="showEndTime" editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.charge.service.interfaces.IChargeMainSV"
            implservice_querymethod="IChargeMainshow(String id)">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
        <tr>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="PRINCIPLE" width="150" editable="false" visible="false"/>
                <ai:dbformfield formid="chargeMainframe" fieldname="STAFFNAME" width="150" editable="" visible="false"/>
                </td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="ORG" width="130" editable="false" visible="false"/>
                <ai:dbformfield formid="chargeMainframe" fieldname="ORGNAME" width="130" editable="" visible="false"/></td>
           </tr> 
               <tr>
                </td>
                 <td class="td_font">�ʷ����ͣ�</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="FEE_TYPE" width="150"/><span class="font_red">*</span></td>
                <td class="td_font">ϸ���г���</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="MARKET_TYPE" width="150"/><span class="font_red">*</span></td>
                <td class="td_font">Ʒ�ƣ�</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="SALE_FASHION" width="150"/><span class="font_red">*</span></td>
            </tr>
            <tr>
                <td class="td_font">��ʼʱ�䣺</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_TIME" width="150"/><span class="font_red">*</span></td>
                <td class="td_font">����ʱ�䣺</td>
                <td><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_END_TIME" width="150"/><span class="font_red">*</span></td>
            </tr>
             <tr >
	        	<td class="td_font">�����������أ�</td>
	        	<td colspan="5" ><ai:dbformfield formid="chargeMainframe" fieldname="E_CHANNEL_BEAR" width="10" visible="false"/>
	        		<input type="checkbox" id="hint0_input" value="0" onclick="checkboxSts(0);"  />����&nbsp;
	        		<input type="checkbox" id="hint1_input" value="1" onclick="checkboxSts(1);"  />����&nbsp;
	               	<input type="checkbox" id="hint2_input" value="2" onclick="checkboxSts(2);" />WAP��&nbsp;
	               	<input type="checkbox" id="hint3_input" value="3" onclick="checkboxSts(3);" />΢��&nbsp;
	               	<input type="checkbox" id="hint4_input" value="4" onclick="checkboxSts(4);" />���û�&nbsp;
	               	<input type="checkbox" id="hint5_input" value="5" onclick="checkboxSts(5);" />�ֻ�Ӫҵ��APP&nbsp;
	               	<input type="checkbox" id="hint6_input" value="6" onclick="checkboxSts(6);" />�ƶ��̳�PC��&nbsp;
	               	<input type="checkbox" id="hint7_input" value="7" onclick="checkboxSts(7);" />������&nbsp;
	               	<input type="checkbox" id="hint8_input" value="8"  readonly="readonly"  onclick="checkboxSts(8);"  />�ⲿ����</td>
        	</tr>
            <tr>
                <td class="td_font">�ʷѰ����ƣ�</td>
                <td colspan="5"><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_NAME" width="600"/><span class="font_red">*</span>
                <ai:dbformfield formid="chargeMainframe" fieldname="APPLY_ID" width="50" visible="false"/>
                  <ai:dbformfield formid="chargeMainframe" fieldname="MAIN_ID" width="50" visible="false"/>
                <ai:dbformfield formid="chargeMainframe" fieldname="IS_SUBMIT" width="150"  visible="false"/>
            </tr>
          <tr>
                <td class="td_font">�ƹ�������</td>
                <td colspan="5"><ai:dbformfield formid="chargeMainframe" fieldname="EXTEND_CHANNEL" editable="false"  width="600"/>
                <img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="channelMultiplySelected();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span>
                </td>
            </tr>
            <tr>
                <td class="td_font">�����ںţ�</td>
                <td colspan="5"><ai:dbformfield formid="chargeMainframe" fieldname="FLACK" height="" width="800"/><span class="font_red">*</span><br></td>
            </tr>
               <tr>
                  <td class="td_font">������</td>
                <td colspan="5"><ai:dbformfield formid="chargeMainframe" fieldname="BACK_GROUND" height="80" width="800"/><span class="font_red">*</span></td>
            </tr>
             <tr>
                <td class="td_font">Ŀ�ģ�</td>
                <td colspan="5"><ai:dbformfield formid="chargeMainframe" fieldname="APPLY_MARK" height="80" width="800"/><span class="font_red">*</span><br></td>
            </tr>
            <tr>
              <td class="td_font">�û����������</td>
                <td colspan="5"><ai:dbformfield formid="chargeMainframe" fieldname="USER_CIRCS" height="80" width="800"/><span class="font_red">*</span></td>
            </tr>
                <tr>
                <td class="td_font">Ŀ���û������ص㣺</td>
                <td colspan="5"><ai:dbformfield formid="chargeMainframe" fieldname="CONSUME_ANALYSE" height="80" width="800"/><span class="font_red">*</span></td>
            </tr>
            
          </table>
    </ai:dbform>
</ai:contractframe>
<div id='eChnlCommand_div1' style="display: none;">
<ai:contractframe id="EChannelNcodeCommand" contenttype="table" title="����ָ����NCODE�б�" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem>
    	<ai:button id="bt_addEChannelNcodeCommand" text="����" onclick="addEChannelNcodeCommand()"/>
    	<ai:button id="bt_delUEChannelNcodeCommand" text="ɾ������ѡ�" onclick="doWork('delEchannelNcodeCommand()')"/>
    	<span class="font_red">��"����,��ָͨ��,ȡ��ָ��"���ɷ�������д��"NCODE"��ҵ֧����NCODE��Ա��д��"�����ʷ�,��Ʒ��,��ֵ��Ʒ,��Ʒ��,������Ʒ,��������,ҵ�����"����������Ա��д��</span>
    </ai:contractitem>
    <ai:table
        tableid="EChannelNcodeCommandListTable"
        setname="com.asiainfo.charge.web.SETEchannelNcodeCommand"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.charge.service.interfaces.IEchannelNcodeCommandSV"
        implservice_querymethod="getEchannelNcodeCommandByRelaId(String relaId,String infoType, int $STARTROWINDEX, int $ENDROWINDEX)"
        implservice_countmethod="getCnEchannelNcodeCommandListByRelaId(String relaId,String infoType)"
        initial="false"  multiselect="true"
        pagesize="15" editable="true" width="100%"
        height="120" needrefresh="true">
        <ai:col fieldname="NAME" width="20%" />
        <ai:col fieldname="OPEN_COMMAND" width="20%" />
        <ai:col fieldname="CANCEL_COMMAND" width="20%" />
        <ai:col fieldname="NCODE" width="15%" visible="false"/>
        <ai:col fieldname="PRI_TARIFF" width="10%" visible="false"/>
        <ai:col fieldname="PROD_PACKAGE" width="15%" visible="false"/>
        <ai:col fieldname="G_PRODUCT" width="15%" visible="false"/>
        <ai:col fieldname="PROD_PACKAGE2" width="15%" visible="false"/>
		<ai:col fieldname="BASE_PRODUCT" width="15%" visible="false"/>
        <ai:col fieldname="ADD_ATTR" width="15%" visible="false"/>
		<ai:col fieldname="BUSI_RULE" width="15%" visible="false"/>
		<ai:col fieldname="INFO_TYPE" width="15%" visible="false"/>
		<ai:col fieldname="REL_ID" width="15%" visible="false"/>
    </ai:table>
</ai:contractframe>
</div>
  <div class="area_button">
  <ai:button text="�޸��ʷ�����Ϣ" id="query3" onclick="doWork('updateChargeMain()')" />&nbsp;&nbsp;
  <ai:button text="�����ʷ�����Ϣ" id="query2" onclick="doWork('addChargeMain()')" />&nbsp;&nbsp;
  </div>
<ai:contractframe id="chargeDetailListframe" contenttype="table" title="�ѱ�����ʷ���ϸ��Ϣ" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem>
    <ai:button id="bt_addChargeDetail" text="�����ʷ�"  onclick="addChargeDetail()"/> 
    <ai:button id="bt_delChargeDetail" text="ɾ���ʷ�"  onclick="delChargeDetail()"/>
    </ai:contractitem>
    <ai:table
        tableid="chargeDetailListTable"
        setname="com.asiainfo.charge.web.SETChargeInfo"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.charge.service.interfaces.IChargeMainSV"
        implservice_querymethod="getChargeDetailByFeeType(String mainId, String feetype, int $STARTROWINDEX, int $ENDROWINDEX)"
        implservice_countmethod="getCountByFeeType(String mainId, String feetype)"
        initial="false"  multiselect="" ondbclick="showChargeDetail" onrowchange="onrowchange1"
        pagesize="15" editable="false" width="100%" rowheight="50"
        height="180" needrefresh="true">
        	<ai:col title="�ʷ���ϸID" fieldname="MID" visible="false"/>
        	<ai:col title="ҵ�����ͣ�" fieldname="NINNER_TOCHARGE_COUNT" visible="false"/>
            <ai:col title="����" fieldname="CHARGE_TYPE" width="8%"/>
            <ai:col title="����" fieldname="FEE_NAME" width="12%" />
            <ai:col title="�ʷ�ϵͳ����" fieldname="CASE" width="140" />
        	<ai:col title="BOSSϵͳ����" fieldname="INADD_USER_COUNT" width="140"/>
        	<ai:col fieldname="DOOR_DAMNIFY" width="80"/>
            <ai:col title="�ײ���Ϣ" fieldname="EXT5" width="30%"/>
            <ai:col fieldname="FEE_MARK" width="50%"/>
            <ai:col title="�ײ���" fieldname="ADD_USER_MARKET" width="20%" />
            <ai:col title="�ײ���" fieldname="SPLICE_MUTEX_RULE" width="20%" />
            <ai:col title="�ײ�" fieldname="EARNING_TOTAL" width="20%" />
            <ai:col title="�Ƿ���Ҫ��������" fieldname="IS_SEND_SMS" visible="false" />
            <ai:col title="������������" fieldname="EXT4" visible="false" />
            <ai:col title="���ʷѵ��α�ʶ" fieldname="EXT6" visible="false" />

    </ai:table>
</ai:contractframe>
<div id='e_channel_exp' style="display: none;">
	<%@include file="/charge/include/_explan.jsp"%>
</div>
<%@include file="/charge/include/_attach.jsp"%>
<ai:loginuser/>
<div id="wf_div" style="">
<%@include file="/charge/workflow/_createWF.jsp"%>
</div>
</body>
</html>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script type="text/javascript">
var _mainId = "";
var _fromChargeMainFormRowSet= g_FormRowSetManager.get("chargeMainframe");
var _fromChargeAMainFormRowSet= g_FormRowSetManager.get("chargeAMainframe");
var chargeDetailListTable=g_TableRowSetManager.get("chargeDetailListTable");
var chargeApplyMainTable=g_TableRowSetManager.get("chargeApplyMainTable");
var _EChannelNcodeCommandListTab = g_TableRowSetManager.get("EChannelNcodeCommandListTable");
var applyid="<%=request.getParameter("applyid")%>";
var iscopy="<%=request.getParameter("iscopy")%>";
var editable = "<%=request.getParameter("editable")%>";
function init(){ 
	if("null"!=applyid && ""!=applyid ) {
		//document.getElementById("chargeOrder_div").style.display="block";
		_mainId = applyid;
		_fromChargeAMainFormRowSet.refresh("&id="+applyid);
		chargeApplyMainTable.refresh("&mainid="+applyid);
		if (chargeApplyMainTable.getTotalRowCount() > 1) {
			document.getElementById("chargeApplyM_div").style.display="block";
		} else if (chargeApplyMainTable.getTotalRowCount() == 1) {
			chargeApplyMainTable.setFocus(0,0);
		} 
		showTableOn();
		include_reflashAttachTable();
		if (editable == "false") {
			_fromChargeMainFormRowSet.setEditSts(false);
			g_AIButtonManager.get("query2").setDisabled(true);
			g_AIButtonManager.get("query3").setDisabled(true);
			g_AIButtonManager.get("bt_addChargeDetail").setDisabled(true);
			g_AIButtonManager.get("bt_delChargeDetail").setDisabled(true);
			g_AIButtonManager.get("deleteAttachFile").setDisabled(true);
			setEChannelNcodeCommandEditSts(false);
			document.getElementById("wf_div").style.display="none";
		}
	} else {
		var staffId = g_GetUserInfo().STAFF_ID;
		_fromChargeAMainFormRowSet.setValue("PRINCIPLE",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
		_fromChargeAMainFormRowSet.setValue("REAMRK_2",g_GetUserInfo().STAFF_NAME);
		_fromChargeAMainFormRowSet.setValue("ORG",g_GetUserInfo().ORG_ID,g_GetUserInfo().ORG_NAME);
		_fromChargeAMainFormRowSet.setValue("REAMRK_3",g_GetUserInfo().ORG_NAME);
		_fromChargeMainFormRowSet.setValue("PRINCIPLE",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
		_fromChargeMainFormRowSet.setValue("ORG",g_GetUserInfo().ORG_ID,g_GetUserInfo().ORG_NAME);
		_fromChargeMainFormRowSet.setValue("MARKET_TYPE","1");
		_fromChargeMainFormRowSet.setValue("FEE_TYPE","11");
		_fromChargeMainFormRowSet.setValue("SALE_FASHION","3");
		_fromChargeMainFormRowSet.setColEditSts("SALE_FASHION",false);
		showName();
		g_AIButtonManager.get("query3").setDisabled(true);
	}
}

function updateinit(){
		_fromChargeMainFormRowSet.setEditSts(true);
		var id =_fromChargeMainFormRowSet.getValue("APPLY_ID");
		if(id!=""){	
			_fromChargeMainFormRowSet.refresh("&id="+id);
			_EChannelNcodeCommandListTab.refresh("&relaId="+id+"&infoType=cha");
		}
		var staffId = g_GetUserInfo().STAFF_ID;
		showName();
		_fromChargeMainFormRowSet.setEditSts(true);
		_fromChargeMainFormRowSet.setColEditSts("ORGNAME",false);
		_fromChargeMainFormRowSet.setColEditSts("STAFFNAME",false);
		var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
		var staffId = g_GetUserInfo().STAFF_ID;
		g_AIButtonManager.get("query2").setDisabled(true);
		showTableOn();
}

function showName(){
	_fromChargeMainFormRowSet.setFocus("STAFFNAME");
    _fromChargeMainFormRowSet.setFocus("ORGNAME");
	_fromChargeMainFormRowSet.setColEditSts("ORGNAME",false);
	_fromChargeMainFormRowSet.setColEditSts("STAFFNAME",false);

}

function addChargeMain(){
	var applyName=_fromChargeMainFormRowSet.getValue("APPLY_NAME");
	var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
	var applyTime=_fromChargeMainFormRowSet.getValue("APPLY_TIME");
	var applyEndTime=_fromChargeMainFormRowSet.getValue("APPLY_END_TIME");
	var extchannel=_fromChargeMainFormRowSet.getValue("EXTEND_CHANNEL");
	var flack=_fromChargeMainFormRowSet.getValue("FLACK");
	var background=_fromChargeMainFormRowSet.getValue("BACK_GROUND");
	var amark=_fromChargeMainFormRowSet.getValue("APPLY_MARK");
	var usercircs=_fromChargeMainFormRowSet.getValue("USER_CIRCS");
	var analyse=_fromChargeMainFormRowSet.getValue("CONSUME_ANALYSE");
	var eChnlBearChBox = getHintCheckBoxVal();
	_fromChargeMainFormRowSet.setValue("E_CHANNEL_BEAR",eChnlBearChBox);
	if(eChnlBearChBox.indexOf("0")==0){
		if(_EChannelNcodeCommandListTab.count()==0){
			return  alert("���ڶ���ָ����NCODE�б����ö���ָ�");
		}
	}
	//��������
	if(""==applyName) {return  alert("�������ʷѻ���ƣ�");}
	if(""==feeType) {return  alert("�������ʷ����ͣ�");}
	if(""==applyTime) {return  alert("�������ʷѻ��ʼʱ�䣡");}
	if(""==extchannel) {return  alert("�������ƹ�������");}
	if(""==flack) {return  alert("�����������ںţ�");}
	if(""==background) {return  alert("�����뱳����");}
	if(""==amark) {return  alert("������Ŀ�ģ�");}
	if(""==usercircs) {return  alert("�������û����������");}
	if(""==analyse) {return  alert("������Ŀ���û������ص㣡");}
	if(""==applyEndTime) {applyEndTime=addDate(6,1,applyTime);}
	if(1 == g_CompareDate(applyTime,applyEndTime)) { return alert("�������ʱ�䲻��С�ڿ�ʼʱ�䣡");}
	if ("O" != _fromChargeMainFormRowSet.getSts())
	{
		_fromChargeAMainFormRowSet.setValue("REAMRK_1", _fromChargeMainFormRowSet.getValue("APPLY_NAME"));
		if ("N" == _fromChargeAMainFormRowSet.getSts())
	    {
	    	var chargeOrderList = new Array();
		    chargeOrderList.push(_fromChargeAMainFormRowSet);
		    var actionUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeMainAction?action=saveChargeNewMain&applyid=0';
		    var ret = saveRowSet(actionUrl, chargeOrderList);
		    var orderId = ret.getValueByName("NewMainID");
		    _fromChargeAMainFormRowSet.refresh("&id="+orderId);
		    if (orderId == "" || orderId == null) {
		    	return alert("����ʧ��!");
		    }
	    }
		_mainId = _fromChargeAMainFormRowSet.getValue("MAIN_ID");
		_fromChargeMainFormRowSet.setValue("MAIN_ID", _mainId);
	    var list = new Array();
	    list.push(_fromChargeMainFormRowSet);
	    var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeMainAction?action=saveChargeMain&applyid=0';
	    var recode = saveRowSet(strUrl, list);
	    var mainId = recode.getValueByName("MAINID");
	    _fromChargeMainFormRowSet.setValue("APPLY_ID",mainId);
	    var rFlag = recode.getValueByName("FLAG");
	    if (rFlag == "Y") {
	    	saveEChannelNcodeCommand(mainId,'n');
	    	chargeApplyMainTable.refresh("&mainid="+_mainId);
	    }
	 }else{
	 	saveEChannelNcodeCommand(_fromChargeMainFormRowSet.getValue("APPLY_ID"),'y');
	 }
    chargeDetailListTable.refresh("&mainId="+_fromChargeMainFormRowSet.getValue("APPLY_ID")+"&feetype="+feeType);
	setEChannelNcodeCommandEditSts(false);
    g_AIButtonManager.get("query2").setDisabled(true);
	g_AIButtonManager.get("query3").setDisabled(false);
	_fromChargeMainFormRowSet.setEditSts(false);
	showTableOn();
}


function zdyxdMultiplySelected(){
	var url = "<%=request.getContextPath()%>/sale/common/modaldialog/SaleZDYXDMultiplySelected.jsp";
	var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
	var iniVal = _fromChargeMainFormRowSet.getValue("SALE_FASHION");
	_fromChargeMainFormRowSet.setValue("SALE_FASHION",onItemMultiplySelected(url, iniVal, style));
}

function addChargeDetail(){
	var applyId=_fromChargeMainFormRowSet.getValue("APPLY_ID");
	var feeName=_fromChargeMainFormRowSet.getValue("APPLY_NAME");
	var taskId="<%=request.getParameter("taskId")%>";
	if(""==applyId){
		return alert("���ȱ����ʷ�������Ϣ��");
	}
	var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
	//0918
	var zfbmmark=_fromChargeMainFormRowSet.getValue("MARKET_TYPE");
	var typecards=_fromChargeMainFormRowSet.getValue("SALE_FASHION");
	var isNewFee = "1"; //�����ʷѵ���Ĭ�� �µ��ʷѽṹҳ��
	var returnP=window.open("<%=request.getContextPath()%>/charge/chargeinfo/chargeDetail.jsp?applyId="+applyId+"&feeType="+feeType+"&feeName="+feeName+"&taskId="+taskId+"&zfbmmark="+zfbmmark+"&typecards="+typecards+"&isNewFee="+isNewFee,"","height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no"); 
}


function showChargeDetail(){
	var feeName=_fromChargeMainFormRowSet.getValue("APPLY_NAME");
	var state=_fromChargeMainFormRowSet.getValue("IS_SUBMIT");
	var curRow = chargeDetailListTable.getRow();
	var mid = chargeDetailListTable.getValue(curRow,"MID");
	var applyId=_fromChargeMainFormRowSet.getValue("APPLY_ID");
	var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
	var taskId="<%=request.getParameter("taskId")%>";

	var zfbmmark=_fromChargeMainFormRowSet.getValue("MARKET_TYPE");
	var typecards=_fromChargeMainFormRowSet.getValue("SALE_FASHION");
	var isSendSmsVal=chargeDetailListTable.getValue(curRow,"IS_SEND_SMS");  
	var userSms=chargeDetailListTable.getValue(curRow,"EXT4");  

	var isNewFee = chargeDetailListTable.getValue(curRow,"EXT6"); //��ʾ�ʷѵ�����ϸʱ ����charge_info_t.EXT6�ֶ����ж��Ƿ����µ��ʷѽṹҳ��

	window.open("<%=request.getContextPath()%>/charge/chargeinfo/chargeDetail.jsp?applyId="+applyId+"&feeType="+feeType+"&mid="+mid+"&feeName="+feeName+"&state="+state+"&taskId="+taskId+"&zfbmmark="+zfbmmark+"&typecards="+typecards+"&isSendSmsVal="+isSendSmsVal+"&userSms="+userSms+"&isNewFee="+isNewFee,"","height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no"); 
}

function addChargeMainNew(){
	if(window.confirm("�½��ʷѰ������δ������ʷѰ���Ϣ��ȷ��Ҫ�½���"))
    {
        location.reload();
    }
}

function delChargeDetail(){
 	var ss = new Array();
    ss = chargeDetailListTable.getSelectedRows();
    if (ss.length < 1) {
        alert("��ѡ��Ҫɾ�������ݣ�");
        return;
    }
    for ( var i = ss.length; i > 0; i--) {
        chargeDetailListTable.deleteRow(ss[i - 1]);
    }
    var list = new Array();
    list.push(chargeDetailListTable);
    var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeMainDeAction?action=saveChargeMainDe';
    var recode = saveRowSet(strUrl, list);
}

function  updateChargeMain(){
	updateinit();
	//document.getElementById("include").style.display="none";
    g_AIButtonManager.get("query3").setDisabled(true);
	g_AIButtonManager.get("query2").setDisabled(false);
	_fromChargeMainFormRowSet.setColEditSts("FEE_TYPE",false);
	setEChannelNcodeCommandEditSts(true);
}

function addYOrN(){
	var curRow = chargeApplyMainTable.getRow();
	if(0==chargeApplyMainTable.count()){
		alert("����д�ʷ�����Ϣ��");
	    return false;
	}
	return true;
}

function checkChargeInfo () {
	if (chargeDetailListTable.getTotalRowCount() == 0) {
    	 alert("������������ʷ���ϸ������д��");
    	 return false;
    }
	var feeType = _fromChargeMainFormRowSet.getValue("FEE_TYPE");
	var busiType = "";
	var chargeInfo = "";
	if (feeType == '31' || feeType == '41') return true;
	for (var i=0; i<chargeDetailListTable.getTotalRowCount(); ++i) {
		busiType = chargeDetailListTable.getValue(i,"NINNER_TOCHARGE_COUNT");
		chargeInfo = chargeDetailListTable.getValue(i,"EXT5");
		
		if ((busiType == 1 || busiType == 4) && chargeInfo.indexOf("����")==-1) {
			alert("�ʷѣ�"+chargeDetailListTable.getValue(i,"FEE_NAME") + "û��д������Ŀ�������ʷ���Ŀ��ӣ�");
			return false;
		} else if ((busiType == 2 || busiType == 4) && chargeInfo.indexOf("����")==-1) {
			alert("�ʷѣ�"+chargeDetailListTable.getValue(i,"FEE_NAME") + "û��д������Ŀ�������ʷ���Ŀ��ӣ�");
			return false;
		}
	}
	var checkFinalShareUrl = _gModuleName + '/business/com.asiainfo.charge.web.FinaAllocShareAction?action=checkEmptyFinalShareInCharge&orderId=' + _mainId;
	var checkRet = PostInfo(checkFinalShareUrl);
	if ("Y" == checkRet.getValueByName("FLAG")) {
		if (checkRet.getValueByName("haveEmpty") == "no") {
			return true;
		} else {
			alert("�����ʷ���ϸ����Ҫ��ѡ�����̯��빴ѡ�����棡");
			return false;
		}
	} else {
		alert("�ύ�쳣��");
		return false;
	}
	return true;
}

function addDate(type,NumDay,dtDate) 
{ 
	var date = new Date(StringToDate(dtDate)); 
	type = parseInt(type) //���� 
	var lIntval = parseInt(NumDay)//��� 
	switch(type) 
	{ 
		case 6 ://�� 
		date.setYear(date.getFullYear() + lIntval) 
		break; 
		case 7 ://���� 
		date.setMonth(date.getMonth() + (lIntval * 3) ) 
		break; 
		case 5 ://�� 
		date.setMonth(date.getMonth() + lIntval) 
		break; 
		case 4 ://�� 
		date.setDate(date.getDate() + lIntval) 
		break 
		case 3 ://ʱ 
		date.setHours(date.getHours() + lIntval) 
		break 
		case 2 ://�� 
		date.setMinutes(date.getMinutes() + lIntval) 
		break 
		case 1 ://�� 
		date.setSeconds(date.getSeconds() + lIntval) 
		break; 
		default: 
	} 
	var month= date.getMonth()+1;
	var second=date.getDate();
	
	return date.getFullYear() + '-' + month + '-' +second +dtDate.substr(10); 
} 

StringToDate=function(DateStr){
	if(typeof DateStr=="undefined") return new Date();
	if(typeof DateStr=="date") return DateStr;
	var converted = Date.parse(DateStr);
	var myDate = new Date(converted);
	if(isNaN(myDate)){
		DateStr=DateStr.replace(/:/g,"-");
		DateStr=DateStr.replace(" ","-");
		DateStr=DateStr.replace(".","-");
		var arys= DateStr.split('-');
		switch(arys.length){
		case 7 : myDate = new Date(arys[0],--arys[1],arys[2],arys[3],arys[4],arys[5],arys[6]);break;
		case 6 : myDate = new Date(arys[0],--arys[1],arys[2],arys[3],arys[4],arys[5]);break;
		default: myDate = new Date(arys[0],--arys[1],arys[2]);break;
	  };
	};
	return myDate;
}

function showEndTime(pFieldName,pOldVal,pOldText,pNewVal,pNewText){
	if(pFieldName=="APPLY_TIME"){
		if(""!=pFieldName){
		_fromChargeMainFormRowSet.setValue("APPLY_END_TIME",addDate(6,1,_fromChargeMainFormRowSet.getValue("APPLY_TIME")));
		}
	}
	if(pFieldName=="FEE_TYPE"){
		showTableOn();
	}
}


function showTableOn(){
	if("41"==_fromChargeMainFormRowSet.getValue("FEE_TYPE")||"31"==_fromChargeMainFormRowSet.getValue("FEE_TYPE")) {
		chargeDetailListTable.setColVisible("ADD_USER_MARKET",false);
		chargeDetailListTable.setColVisible("SPLICE_MUTEX_RULE",false);
		chargeDetailListTable.setColVisible("EARNING_TOTAL",true);
		_fromChargeMainFormRowSet.setColEditSts("SALE_FASHION",true);
	} else {
		 if(_fromChargeMainFormRowSet.getValue("FEE_TYPE").substr(0,1)=="2"){
			 _fromChargeMainFormRowSet.setValue("SALE_FASHION","4");
			 _fromChargeMainFormRowSet.setColEditSts("SALE_FASHION",false);
		 } else {
			chargeDetailListTable.setColVisible("ADD_USER_MARKET",true);
			chargeDetailListTable.setColVisible("SPLICE_MUTEX_RULE",true);
			chargeDetailListTable.setColVisible("EARNING_TOTAL",false);
			_fromChargeMainFormRowSet.setValue("SALE_FASHION","3");
			_fromChargeMainFormRowSet.setColEditSts("SALE_FASHION",false);
		 }
	}
}

function channelMultiplySelected(){
    var url = "<%=request.getContextPath()%>/sale/common/modaldialog/SaleChannelMultiplySelected.jsp";
    var style = "scroll:no;resizable:no;status:no;help:no;dialogHeight:280px;dialogWidth:440px";
    var iniVal = _fromChargeMainFormRowSet.getValue("EXTEND_CHANNEL");
    _fromChargeMainFormRowSet.setValue("EXTEND_CHANNEL",onItemMultiplySelected(url, iniVal, style));
}
function closePage(){
   window.opener.location.reload();
   window.self.close();
}

function copyCharge(){
	var mainid=_fromChargeMainFormRowSet.getValue("MAIN_ID");
	if(mainid==""){
		return alert("���ȵ�������ʷ�����!");
	}	
	var returnCopy= window.showModalDialog("<%=request.getContextPath()%>/charge/chargeinfo/chargeCopySelect.jsp?iscopy=yes&mid="+mainid,"","dialogWidth=900px"); 
	applyid=returnCopy;
	if(undefined==applyid||applyid==""){
		return;
	}
 	var staffId = g_GetUserInfo().STAFF_ID;
	_fromChargeMainFormRowSet.setValue("PRINCIPLE",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
	_fromChargeMainFormRowSet.setValue("ORG",g_GetUserInfo().ORG_ID,g_GetUserInfo().ORG_NAME);
	showName();
	g_AIButtonManager.get("query3").setDisabled(true);
	//chargeApplyMainTable.refresh("&mainid="+_fromChargeMainFormRowSet.getValue("MAIN_ID"));
	//window.location.href="<%=request.getContextPath()%>/charge/chargeinfo/chargeAddInfo.jsp?applyid="+applyid+"&iscopy=yes","","height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no";
}


function onrowchange1(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	chargeDetailListTable.setRowBgColor(oldIndex,"");
    }
    chargeDetailListTable.setRowBgColor(newIndex,"yellow");
}

function showApplyMain(){
	 var curRow = chargeApplyMainTable.getRow();
	 var applyid=chargeApplyMainTable.getValue(curRow,"APPLY_ID");
	 _fromChargeMainFormRowSet.refresh("&id="+applyid);
	 var eChnlBear = _fromChargeMainFormRowSet.getValue("E_CHANNEL_BEAR");
   	 if(eChnlBear==null){
    	setCheckBox(null);
     }else{
    	setCheckBox(eChnlBear.toString());
   	 }
	 _EChannelNcodeCommandListTab.refresh("&relaId="+applyid+"&infoType=cha");
	 var feeType=_fromChargeMainFormRowSet.getValue("FEE_TYPE");
	 chargeDetailListTable.refresh("&mainId="+applyid+"&feetype="+feeType);
}

function delCharge(){
	 var curRow = chargeApplyMainTable.getRow();
	 var applyid=chargeApplyMainTable.getValue(curRow,"APPLY_ID");
	         chargeApplyMainTable.deleteRow(curRow);
		    var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeMainAction?action=saveChargeMain&applyid='+applyid;
		    var recode = PostInfo(strUrl, null);
		    alert("�����ɹ���"); 
		    _fromChargeMainFormRowSet.newRow();
            chargeDetailListTable.clear();
}
function haveAttch(){
	var e_chlbear = getHintCheckBoxVal();
	
	if(e_chlbear!=null&&e_chlbear!=""){
		
		if(e_chlbear.indexOf('1')>=0||e_chlbear.indexOf('2')>=0||e_chlbear.indexOf('3')>=0||e_chlbear.indexOf('4')>=0||
		e_chlbear.indexOf('6')>=0||e_chlbear.indexOf('7')>=0||e_chlbear.indexOf('8')>=0){
			if(_include_fromAttachFileFormRowSet().count()==0){
				return alert('�����ʷѷ�������δ�ϴ���������ģ�岢��д�ϴ�');
				return false;
			}
		}
	}
    return true;
}

// ����ָ����NCODE�б�
function addEChannelNcodeCommand() {
	_EChannelNcodeCommandListTab.newRow(false);
	var curRow = _EChannelNcodeCommandListTab.getCurRowIndex();
	_EChannelNcodeCommandListTab.setValue(curRow,"INFO_TYPE", 'cha');
}

function delEChannelNcodeCommand() {
	var delEChannelNcodeCommandList = new Array();
	delEChannelNcodeCommandList = _EChannelNcodeCommandListTab.getSelectedRows();
	var delEChannelNcodeCommandRc = delEChannelNcodeCommandList.length;
    if (delEChannelNcodeCommandRc < 1) {
        return alert("�빴ѡҪɾ���ļ�¼��");
    }
    var relId = _EChannelNcodeCommandListTab.getValue(0,"REL_ID");
    while (delEChannelNcodeCommandRc > 0) {
	    delEChannelNcodeCommandRc--;
	    _EChannelNcodeCommandListTab.deleteRow(delEChannelNcodeCommandList[delEChannelNcodeCommandRc]);
    }
    if (relId == null || relId==""){
    	return;
    }
    saveEChannelNcodeCommand("", "y");
}

function saveEChannelNcodeCommand(levId, alertFlag) {
	if (levId != null && levId != "") {
		for (var i=0; i< _EChannelNcodeCommandListTab.getTotalRowCount(); ++i) {
			_EChannelNcodeCommandListTab.setValue(i, "REL_ID", levId);
		}
	} else {
		levId = _fromChargeMainFormRowSet.getValue("APPLY_ID");
	}
	var list = new Array();
	if(_EChannelNcodeCommandListTab.count()==0) return;
	list.push(_EChannelNcodeCommandListTab);
  	var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.EchannelNcodeCommandAction?action=save';
	var recode = saveRowSet(strUrl, list);
  	var rFlag = recode.getValueByName("FLAG");
  	if (alertFlag == 'y' && rFlag == 'Y') {
  		alert("�����ɹ���");
  	} else if (alertFlag == 'y' && rFlag == 'N') {
  		alert("����ʧ�ܣ�");
  	}
	_EChannelNcodeCommandListTab.refresh("&relaId="+levId+"&infoType=cha");
}

function setEChannelNcodeCommandEditSts(flag){
	_EChannelNcodeCommandListTab.setEditSts(flag);
	g_AIButtonManager.get("bt_addEChannelNcodeCommand").setDisabled(!flag);
	g_AIButtonManager.get("bt_delUEChannelNcodeCommand").setDisabled(!flag);
}

function checkboxSts(pos) {
	if(pos == 0){
		if(true == document.getElementById('hint0_input').checked){
			document.getElementById("eChnlCommand_div1").style.display="block";
		} else {
			document.getElementById("eChnlCommand_div1").style.display="none";
		}
	}
	if(pos>0&&pos<9){
		var checkflag = false;
		for(var i=1;i<9;i++){
			checkflag = document.getElementById('hint'+i+'_input').checked;
			if(checkflag) break;
		}
		if(checkflag){
			document.getElementById("e_channel_exp").style.display="block";
			document.all("contractFrame_attachFrame").style.display='block';
		} else {
			document.getElementById("e_channel_exp").style.display="none";
		}
	}	
}

function getHintCheckBoxVal(){
	var hintVal = ""; 
   	for(var pos = 0; pos < 9; ++pos){
    	if (document.getElementById("hint" + pos + "_input").checked) {
      		if (hintVal != ""){
            	hintVal += ";";
          	}
      		hintVal += document.getElementById("hint" + pos + "_input").value;
        }
    }
    return hintVal;
}

function setCheckBox(hintVal) {
	document.getElementById("hint0_input").checked = false;
    document.getElementById("hint1_input").checked = false;
    document.getElementById("hint2_input").checked = false;
    document.getElementById("hint3_input").checked = false;
	document.getElementById("hint4_input").checked = false;
    document.getElementById("hint5_input").checked = false;
    document.getElementById("hint6_input").checked = false;
    document.getElementById("hint7_input").checked = false;
	document.getElementById("hint8_input").checked = false;
	document.getElementById("e_channel_exp").style.display="none";
	document.getElementById("eChnlCommand_div1").style.display="none";
	
	if(hintVal != null && hintVal != ""){
    	var hintVec = hintVal.split(";");
    	for(var i = 0; i < hintVec.length; i++){
    		document.getElementById("hint"+hintVec[i] + "_input").checked = true;
    		if(hintVec[i]==0){
				document.getElementById("eChnlCommand_div1").style.display="block";
			}
			if(hintVec[i]>0){
				document.getElementById("e_channel_exp").style.display="block";
			}
    	}
    } 
}

</script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"���ڴ������Ժ�...");
}
</script>
<script type="text/javascript">
function addLoadEvent(func) {  
    var oldonload = window.onload;  
    if(typeof window.onload != "function"){  
        window.onload = func;  
    }else{  
        window.onload = function(){  
            oldonload();  
            func();  
        }  
    }  
}  
addLoadEvent(init);
addLoadEvent(initCheckPage);
</script>
