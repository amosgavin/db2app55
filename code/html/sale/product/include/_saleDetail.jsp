<%--
	���ߣ�������
	���ڣ�2013-12-09
	���ܣ�Ӫ���������б�
	˵��:��Ƕҳ��

 --%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ page
	import="com.asiainfo.common.service.interfaces.IAbstractProductExtSV"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ai.appframe2.service.ServiceFactory"%>
<%@ page import="com.asiainfo.charge.ivalues.IBOProductExtDescValue"%>
<%
	IAbstractProductExtSV sv = (IAbstractProductExtSV) ServiceFactory
			.getService(IAbstractProductExtSV.class);
	IBOProductExtDescValue[] values = sv.getColsName("", "SALE", "1",
			"", -1, -1); //ȫ��ѡ��
	//String visible="false";
%>
<ai:contractframe id="saleDetailListframe" contenttype="table"
	title="������Ϣ" width="100%" allowcontract="true" frameclosed="false"
	frameclosed="false">
	<ai:contractitem>
		<ai:button id="bt_newSaleDetail" text="����" onclick="newSaleDetail()" />
		<ai:button id="bt_delSaleDetail" text="ɾ��"
			onclick="doWork('include_delSaleDetail()')" />
	</ai:contractitem>
	<ai:table tableid="basicProd"
		setname="com.asiainfo.sale.product.web.SETSaleDetailExtQ"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.product.services.interfaces.ISaleDetailExtSV"
		implservice_querymethod="qrySaleDetailExt(String mainId,String detail_id,
			String saleFlag, String active_name, String market,
			String start_date, String end_date, String status,String condStr,int $STARTROWINDEX,int $ENDROWINDEX)"
		implservice_countmethod="qrySaleDetailExtCount(String mainId,String detail_id,
			String saleFlag, String active_name, String market,
			String start_date, String end_date,String status,String condStr)"
		ondbclick="showDetailInfo" initial="false" onrowchange="rowChange" pagesize="20"
		editable="" width="100%" height="180" needrefresh="true"
		multiselect="true">
		<ai:col title="��չ���Ա���" fieldname="E_ID" visible="false" />
		<ai:col title="����ID" fieldname="SALE_ID" width="70" />
		<ai:col title="����ID" fieldname="DETAIL_ID" width="70" visible="true" />
		<ai:col title="����" fieldname="SALE_FLAG" width="110" />
		<ai:col title="����" fieldname="SALE_ACTIVE_NAME" width="200" />
		<ai:col title="ϸ���г�" fieldname="MARKET" width="100" />
		<ai:col title="ƽ̨����" fieldname="SALE_ACTIVE_CODE" width="180" />
		<ai:col title="BOSSϵͳ���α���" fieldname="LEVEL_CODE" width="180" />
		<ai:col title="����ʱ��" fieldname="CREATE_TIME" width="140" />
		<ai:col title="����޸�ʱ��" fieldname="MODIFY_TIME" visible="false" />
		<ai:col title="�Ƿ���Ҫ��������" fieldname="IS_SEND_SMS" visible="false" />
		<%
			for (int i = 0; i < values.length; i++) {
				String fieldname = values[i].getExtCode();
				String title = values[i].getExtName();
		%>
		<ai:col fieldname="<%=fieldname%>" title="<%=title%>" visible="true" />
		<%
			}
		%>
		<ai:col fieldname="MODIFY_DATE" title="�޸�ʱ��" visible="<%=visible %>" />
		<ai:col fieldname="STAFF_ID" title="�޸���" visible="<%=visible %>" />

	</ai:table>
</ai:contractframe>
<%--  <%@ include file="/sale/product/include/_sale_detail_form.jsp" %>--%>

<script type="text/javascript">
	var _saleDetail = {};
	_saleDetail.grid = function(){
		return g_TableRowSetManager.get("basicProd");
	}
	
	_saleDetail.qrySaleDetail= function(cond){
		if(null!=cond || ""!=cond){
			_saleDetail.grid().refresh(cond);
		}
	}

	function rowChange(oldIndex,newIndex){
	    if(-1 != oldIndex) {
	    	_saleDetail.grid().setRowBgColor(oldIndex,"");
	    }
    	_saleDetail.grid().setRowBgColor(newIndex,"yellow");
    	showDetailInfo();
	}
	
	


</script>