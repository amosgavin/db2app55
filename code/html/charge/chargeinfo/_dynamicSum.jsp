<%@ page contentType="text/html; charset=GBK"%>
<%--<%@ include file="/secframe/common/common.jsp"%>--%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
	<head>
		<title>��̬�������</title>
		<script language="javascript"
			src="<%=request.getContextPath()%>/jsv2/Calendar.jsp"
			type="text/javascript"></script>
	</head>
<body onload="_dynamic_init()">
    <ai:contractframe id="_dynamicSum1" contenttype="table" title="��̬�������" width="98%" height="" allowcontract="true" frameclosed="false">
        <ai:contractitem >
        <ai:button text="���㲢����" id="query3" onclick="_Dynamic_addDynamic()" />
    </ai:contractitem>
    <ai:dbform formid="_dynamicSum" 
            setname="com.asiainfo.charge.web.SETDynamicSum"
            conditionname="condition" parametersname="parameters"
            onvalchange="" editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.charge.service.interfaces.IDynamicSumSV"
            implservice_querymethod="getDynamicSumById(String id)">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
        һ�������û�ת�ʷѺ���ҵ������������µ��������
        <tr>
        <td class="td_font">ת�ʷ�ǰARPU:</td>
        <td colspan=""><ai:dbformfield formid="_dynamicSum" fieldname="BARPU" width="150" editable="" visible=""/>
        <ai:dbformfield formid="_dynamicSum" fieldname="MID" width="150" editable="" visible="false"/><span class="font_red">*</span>
        </td>
        </tr>
        <tr>
        <td class="td_font">ת�ʷѺ�ARPU:</td>
        <td><ai:dbformfield formid="_dynamicSum" fieldname="AARPU" width="150" editable="" visible=""/><span class="font_red">*</span></td>
        </tr>
         <tr>
        <td class="td_font">ARPU�仯:</td>
        <td><ai:dbformfield formid="_dynamicSum" fieldname="CARPU" width="150" editable="false" visible=""/></td>
        </tr>
         <tr>
        <td class="td_font">����仯:</td>
        <td><ai:dbformfield formid="_dynamicSum" fieldname="CEARNING" width="150" editable="false" visible=""/></td>
        </tr>
        <tr>
        <td class="td_font">�������:</td>
        <td><ai:dbformfield formid="_dynamicSum" fieldname="ACCOUNT_COURSE" height="100" width="300" editable="" visible=""/></td>
        </tr>
        <tr>
        <td   colspan="2">���������û��������
       </td>
        </tr>
        <tr>
        <td class="td_font">�����û���:</td>
        <td><ai:dbformfield formid="_dynamicSum" fieldname="ADD_USER_COUNT" width="150" editable="" visible=""/><span class="font_red">*</span></td>
        </tr>
        <tr>
        <td class="td_font">�����û�ARPU:</td>
        <td><ai:dbformfield formid="_dynamicSum" fieldname="ADD_USER_ARPU" width="150" editable="" visible=""/><span class="font_red">*</span></td>
        </tr>
        <tr>
        <td class="td_font">��������:</td>
        <td><ai:dbformfield formid="_dynamicSum" fieldname="EARNING_INFO" width="150" editable="false" visible=""/></td>
        </tr>
        <tr>
        <td  colspan="2">������̬��������ϼ�
        </td>
        </tr>
        <tr>
        <td class="td_font">����ϼ�</td>
        <td><ai:dbformfield formid="_dynamicSum" fieldname="INFO_TOTAL" width="150" editable="false" visible=""/></td>
        </tr>
        </table>
        </ai:dbform>
        </ai:contractframe>
  </body>
</html>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/ModaDialog.js" type="text/javascript"></script>
<script type="text/javascript">
var _Dunamic_fromDynamicFormRowSet= g_FormRowSetManager.get("_dynamicSum");

function _dynamic_init(){
if("null"!=mid){
_Dunamic_fromDynamicFormRowSet.refresh("id="+mid);
}
}

function _Dynamic_addDynamic(){
var chargeid=_fromChargeMainDeFormRowSet.getValue("MID");
if(chargeid==""||chargeid=="null"){
alert("���ȱ��浵����Ϣ");
return;
}
var str = document.getElementById('_staticSum_user').value;
		if(!str||str=='') {
		  alert('����д��̬��������еĴ���ת�ʷ��û���');
		  return;
	  	}else{
	  	_staticSumSava();
	  	}
var barpu=_Dunamic_fromDynamicFormRowSet.getValue("BARPU");
var aarpu=_Dunamic_fromDynamicFormRowSet.getValue("AARPU");
var addusercount=_Dunamic_fromDynamicFormRowSet.getValue("ADD_USER_COUNT");
var adduserarpu=_Dunamic_fromDynamicFormRowSet.getValue("ADD_USER_ARPU");
var strNum = document.getElementById('_staticSum_user').value;
if(strNum==""){
return alert("������д��̬��������еĴ���ת�ʷ��û�����");
}
if(barpu==""||aarpu==""||addusercount==""||adduserarpu==""){
return alert("������д������Ϣ��");
}
_Dunamic_fromDynamicFormRowSet.setValue("MID",chargeid);
_Dunamic_fromDynamicFormRowSet.setValue("CARPU",aarpu-barpu);
_Dunamic_fromDynamicFormRowSet.setValue("CEARNING",(aarpu-barpu)*strNum);
_Dunamic_fromDynamicFormRowSet.setValue("EARNING_INFO",addusercount*adduserarpu);
_Dunamic_fromDynamicFormRowSet.setValue("INFO_TOTAL",addusercount*adduserarpu+(aarpu-barpu)*strNum);
 if ("O" != _Dunamic_fromDynamicFormRowSet.getSts())
    {
     var list = new Array();
	    list.push(_Dunamic_fromDynamicFormRowSet);
	    var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.DynamicAction?action=saveDynamicSum';
	    var recode = saveRowSet(strUrl, list);
	     var rFlag = recode.getValueByName("FLAG");
	     var mid = recode.getValueByName("MID");
	     _Dunamic_fromDynamicFormRowSet.refresh("id="+mid);
	     _fromChargeMainDeFormRowSet.setValue("EARNING_DAMNIFY",addusercount*adduserarpu+(aarpu-barpu)*strNum);
	     saveChargeMainInclude();
        return rFlag;
    }
}
</script>
