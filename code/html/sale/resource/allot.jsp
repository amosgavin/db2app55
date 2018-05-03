<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Ӫ����Դ����</title>
		<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
		<script language="javascript" src="<%=request.getContextPath()%>/jsv2/DBListBox.js" type="text/javascript"></script>
	</head>
  	<body onload="initPage();">
	    <ai:contractframe id="saleResAllotTFrame" contenttype="table" title="Ӫ����Դ�أ���Դ��λΪ��Ԫ����ֵ��λ%��" width="100%" allowcontract="true" frameclosed="false">
		    <ai:contractitem/>
		    <ai:table
		        tableid="saleResAllotTable" 
		        setname="com.asiainfo.sale.activity.web.SETSaleResourceAllot"
		        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		        implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleResourceSV"
		        implservice_querymethod="getResourceAllot(String cityId)"
		        initial="false"  multiselect="false" onrowchange="resAllotInfo"
		        pagesize="17" editable="false" width="100%" 
		        height="345" needrefresh="true" footdisplay="none">
				<ai:col fieldname="CITY_ID" width="60" visible="false"/>
		        <ai:col fieldname="CITY_CODE" width="300" visible="false"/>
		        <ai:col fieldname="CITY_NAME" width="70" />
		        <ai:col fieldname="P_TERM" width="105" />
		        <ai:col fieldname="P_DISC" width="105" />
		        <ai:col fieldname="P_POINTS" width="105" />
		        <ai:col fieldname="P_PROMT" width="100" />
		        <ai:col fieldname="L_TERM" width="110" />
		        <ai:col fieldname="L_DISC" width="110" />
		        <ai:col fieldname="L_POINTS" width="110" />
		        <ai:col fieldname="L_PROMT" width="105" />
		        <ai:col fieldname="THRESHOLD_V1" width="100"/>
		        <ai:col fieldname="THRESHOLD_V2" width="100"/>
		        <ai:col fieldname="THRESHOLD_V3" width="100"/>
		        <ai:col fieldname="THRESHOLD_V4" width="100"/>
		    </ai:table>
		</ai:contractframe>
		
	<div id="saleResAllotForm_div">	
		<ai:contractframe id="saleResAllotFFrame" contenttype="table" title="��Դ��Ϣ" width="100%" allowcontract="true" frameclosed="false">
    		<ai:contractitem/>
    		<ai:dbform formid="saleResAllotForm" 
	            setname="com.asiainfo.sale.activity.web.SETSaleResourceAllot"
	            conditionname="condition" parametersname="parameters"
	            editable="true" initial="false"
	            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	            implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleResourceSV"
	            implservice_querymethod="getResourceAllot(String cityId)">
        		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
        		    <tr><td align="left" class="font_red" colspan="6"><b>ʡ����Դ��</b></td></tr>
		            <tr>
		            	<td class="td_font">�ն˲�����</td>
		            	<td><ai:dbformfield formid="saleResAllotForm" fieldname="P_TERM" width="100"/>(��Ԫ)
		            	    <ai:dbformfield formid="saleResAllotForm" fieldname="CITY_ID" width="100" visible="false"/></td>
		            	<td class="td_font">�ۿ����ã�</td>
		            	<td><ai:dbformfield formid="saleResAllotForm" fieldname="P_DISC" width="100"/>(��Ԫ)</td>
		            	<td class="td_font">�������֣�</td>
		            	<td><ai:dbformfield formid="saleResAllotForm" fieldname="P_POINTS" width="100"/>(��Ԫ)</td>
		            	<td class="td_font">�����ѣ�</td>
		            	<td><ai:dbformfield formid="saleResAllotForm" fieldname="P_PROMT" width="100"/>(��Ԫ)</td>
		            </tr>
		           <tr><td align="left" class="font_red" colspan="6"><b>������Դ��</b></td></tr>
		           <tr>
		           		<td class="td_font">�ն˲�����</td>
		            	<td><ai:dbformfield formid="saleResAllotForm" fieldname="L_TERM" width="100"/>(��Ԫ)</td>
		            	<td class="td_font">�ۿ����ã�</td>
		            	<td><ai:dbformfield formid="saleResAllotForm" fieldname="L_DISC" width="100"/>(��Ԫ)</td>
		            	<td class="td_font">�������֣�</td>
		            	<td><ai:dbformfield formid="saleResAllotForm" fieldname="L_POINTS" width="100"/>(��Ԫ)</td>
		            	<td class="td_font">�����ѣ�</td>
		            	<td><ai:dbformfield formid="saleResAllotForm" fieldname="L_PROMT" width="100"/>(��Ԫ)</td>
		            </tr>
		            <tr><td align="left" class="font_red" colspan="6"><b>��ֵ</b></td></tr>
		            <tr>
		           		<td class="td_font">�ն˲�����</td>
		            	<td><ai:dbformfield formid="saleResAllotForm" fieldname="THRESHOLD_V1" width="100"/>(%)</td>
		            	<td class="td_font">�ۿ����ã�</td>
		            	<td><ai:dbformfield formid="saleResAllotForm" fieldname="THRESHOLD_V2" width="100"/>(%)</td>
		            	<td class="td_font">�������֣�</td>
		            	<td><ai:dbformfield formid="saleResAllotForm" fieldname="THRESHOLD_V3" width="100"/>(%)</td>
		            	<td class="td_font">�����ѣ�</td>
		            	<td><ai:dbformfield formid="saleResAllotForm" fieldname="THRESHOLD_V4" width="100"/>(%)</td>
		            </tr>
		            <tr align="center">
		            	<td colspan="6"><ai:button id="bt_save" text="�����޸���Ϣ" onclick="save()"/></td>
		            </tr>
  				</table>
    		</ai:dbform>
		</ai:contractframe>
		</div>
  	</body>
  	<ai:loginuser/>
  	<script type="text/javascript">
	  	var saleResAllotTable = g_TableRowSetManager.get("saleResAllotTable");
	  	var saleResAllotForm = g_FormRowSetManager.get("saleResAllotForm");
	  	var staff_name=g_GetUserInfo().STAFF_NAME;
	  	var org = g_GetUserInfo().ORG_ID.substr(0,2);
  		
	  	function initPage() {  	
	  		if(!(staff_name=='ë�Ŀ�' || staff_name=='����Ա' || staff_name=='�Ž�')){
	  			document.getElementById("saleResAllotForm_div").style.display="none";
	  		}
            if(org=='10'){org='';}
	  		saleResAllotTable.refresh("cityId="+org);
	  	}
  		function resAllotInfo(oldIndex, newIndex) {
  			if(-1 != oldIndex) {
       			saleResAllotTable.setRowBgColor(oldIndex,"");
    		}
  			saleResAllotTable.setRowBgColor(newIndex,"yellow");
  			saleResAllotForm.refresh("cityId=" + saleResAllotTable.getValue(newIndex,"CITY_ID"));
  		}
  		function save() {
  			var list = new Array();
		    list.push(saleResAllotForm);
		    var strUrl = _gModuleName + '/business/com.asiainfo.sale.activity.web.SaleResourceAction?action=sava';
		    var recode = saveRowSet(strUrl, list);
		    if(recode.getValueByName("FLAG") == 'Y'){
		    	if(org=='10'){org='';}
		    	saleResAllotTable.refresh("cityId="+org);
		    }
  		}
  	</script>
</html>
