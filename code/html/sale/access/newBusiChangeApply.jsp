<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<html>
<head>
<title>ҵ��������</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
  
  <body onload="init()">
    <ai:contractframe id="busiChangeMainframe" contenttype="table" title="ҵ������Ҫ��Ϣ" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
    <ai:dbform formid="busiChangeMainForm" 
            setname="com.asiainfo.sale.access.web.SETBusiChange"
            conditionname="condition" parametersname="parameters"
            editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.access.service.interfaces.IBusiChangeSV"
            implservice_querymethod="getBusiChargeById(String busiId)">
        <table width="100%" align="center" border="0" cellpadding="1" cellspacing="1">
        <tr>
           <td class="td_font">��������:</td>
           <td><ai:dbformfield formid="busiChangeMainForm" fieldname="APPLY_NAME" width="200"/><span class="font_red">*</span>
           <ai:dbformfield formid="busiChangeMainForm" fieldname="BUSI_ID" width="60" editable="" visible="false"/>
           <ai:dbformfield formid="busiChangeMainForm" fieldname="STATE" width="150" editable="" visible="false"/></td>
           <td class="td_font">������:</td>
           <td><ai:dbformfield formid="busiChangeMainForm" fieldname="PRINCIPLE" width="150" editable="false" visible="false"/>
               <ai:dbformfield formid="busiChangeMainForm" fieldname="PROP_STAFF" width="150" editable="false" /><span class="font_red">*</span>
           </td>
         </tr> 
         <tr>
           <td class="td_font">���뵥λ:</td>
           <td><ai:dbformfield formid="busiChangeMainForm" fieldname="ORG" width="130" editable="false" visible="false"/>
               <ai:dbformfield formid="busiChangeMainForm" fieldname="ORG_NAME" width="200" editable="false"/><span class="font_red">*</span></td>
           <td class="td_font">��ϵ�绰:</td>
           <td><ai:dbformfield formid="busiChangeMainForm" fieldname="TEL" width="150"/><span class="font_red">*</span></td>
         
         </tr>
         <tr>
            <td class="td_font">����˵��������:</td>
            <td colspan="5"><ai:dbformfield formid="busiChangeMainForm" fieldname="DESCRIPTION" height="60" width="700"/><span class="font_red">*</span><span style="font-family:��������; color:red; ">(��ע����ƽ̨��OAƽ̨��Ӧ������)</span></td>
         </tr>
         <tr><td colspan="4" align="center"><ai:button text="��������Ϣ" id="query2" onclick="doWork('savebusiChangeMainInfo()')" /></td></tr>
       </table>

    </ai:dbform>
</ai:contractframe>
<ai:loginuser/>
<%@include file="/sale/access/include/_busiChangeDetail.jsp"%>
<script type="text/javascript">
var _mainId = "";
var _orgId = g_GetUserInfo().ORG_ID;
var busiId = '';
</script>
<!--  <%@include file="/sale/common/include/_createWF.jsp"%>-->
<%@include file="/sale/access/include/_busiChangeAttach.jsp"%>
<%@include file="/sale/access/include/_busiChangeCreateWF.jsp"%>
</body>
</html>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script language="javascript" type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"���ڴ��������Ժ�...");
}
</script>
<script language="javascript" type="text/javascript">
var _busiChangeFormRowSet= g_FormRowSetManager.get("busiChangeMainForm");
//var busiId="<%=request.getParameter("applyid")%>";
function init(){ 
	//var busiId =_busiChangeFormRowSet.getValue("BUSI_ID");
	var state =_busiChangeFormRowSet.getValue("STATE");
	document.getElementById("TableRowSet_userScaleListTable").onclick= scaleCalendarDlg;
	//�����ѯʱ��״̬Ϊ�ѱ��棩����ҳ��
	if ('' != busiId ) {
	  _busiChangeFormRowSet.refresh("&busiId="+busiId);
	  //showName();
	  include_attach_setButtonDisabled(false);
	  include_reflashAttachTable();
	  initBusiChangeDetailInfo();
	} else {
		//ҳ��ˢ�£������޸ģ�idΪ��ʱ��������
		//var staffId = g_GetUserInfo().STAFF_ID;
		_busiChangeFormRowSet.setValue("PRINCIPLE",g_GetUserInfo().STAFF_ID);
		_busiChangeFormRowSet.setValue("PROP_STAFF",g_GetUserInfo().STAFF_NAME);
		_busiChangeFormRowSet.setValue("ORG",g_GetUserInfo().ORG_ID);
		_busiChangeFormRowSet.setValue("ORG_NAME",g_GetUserInfo().ORG_NAME);
		_busiChangeFormRowSet.setValue("TEL",g_GetUserInfo().STAFF_ID);
		showName();
		busiChangeDetailForm.setFocus("CHANGE_OBJECT");
		busiChangeDetailForm.setFocus("REMARK6");
		tableShowControl();
		//include_attach_setButtonDisabled(true);
   }
}

function showName(){
	
	_busiChangeFormRowSet.setFocus("TEL");
	//_busiChangeFormRowSet.setColEditSts("ORG_NAME",false);
	//_busiChangeFormRowSet.setColEditSts("PROP_STAFF",false);
	_busiChangeFormRowSet.setColEditSts("TEL",false);
}

function savebusiChangeMainInfo(){
	 var applyName=_busiChangeFormRowSet.getValue("APPLY_NAME");
	 var mark=_busiChangeFormRowSet.getValue("DESCRIPTION"); 
	 if(""==applyName){return  alert("������ҵ�����������ƣ�");}
	 if(""==mark){return  alert("����д����˵����");}
	
	 if ("O" != _busiChangeFormRowSet.getSts()||_busiChangeFormRowSet.getSts()=="U")
	 {
        var list = new Array();
	    list.push(_busiChangeFormRowSet);
	    var strUrl = _gModuleName + '/business/com.asiainfo.sale.access.web.BusiChangeAction?action=saveBusiChangeMainInfo';
	    var recode = saveRowSet(strUrl, list);
	    busiId = recode.getValueByName("busiId");
	    if(busiId == null || busiId == '' || busiId == 'undefined'){
	    	return alert("�������ʧ�ܣ�");
	    }
  	    _busiChangeFormRowSet.refresh("&busiId="+busiId);
  	    //showName();
	 }
}

</script>