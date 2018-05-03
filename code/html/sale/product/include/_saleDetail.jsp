<%--
	作者：江晓莉
	日期：2013-12-09
	功能：营销案档次列表
	说明:内嵌页面

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
			"", -1, -1); //全部选出
	//String visible="false";
%>
<ai:contractframe id="saleDetailListframe" contenttype="table"
	title="档次信息" width="100%" allowcontract="true" frameclosed="false"
	frameclosed="false">
	<ai:contractitem>
		<ai:button id="bt_newSaleDetail" text="新增" onclick="newSaleDetail()" />
		<ai:button id="bt_delSaleDetail" text="删除"
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
		<ai:col title="扩展属性编码" fieldname="E_ID" visible="false" />
		<ai:col title="批次ID" fieldname="SALE_ID" width="70" />
		<ai:col title="档次ID" fieldname="DETAIL_ID" width="70" visible="true" />
		<ai:col title="类型" fieldname="SALE_FLAG" width="110" />
		<ai:col title="名称" fieldname="SALE_ACTIVE_NAME" width="200" />
		<ai:col title="细分市场" fieldname="MARKET" width="100" />
		<ai:col title="平台编码" fieldname="SALE_ACTIVE_CODE" width="180" />
		<ai:col title="BOSS系统档次编码" fieldname="LEVEL_CODE" width="180" />
		<ai:col title="创建时间" fieldname="CREATE_TIME" width="140" />
		<ai:col title="最后修改时间" fieldname="MODIFY_TIME" visible="false" />
		<ai:col title="是否需要短信提醒" fieldname="IS_SEND_SMS" visible="false" />
		<%
			for (int i = 0; i < values.length; i++) {
				String fieldname = values[i].getExtCode();
				String title = values[i].getExtName();
		%>
		<ai:col fieldname="<%=fieldname%>" title="<%=title%>" visible="true" />
		<%
			}
		%>
		<ai:col fieldname="MODIFY_DATE" title="修改时间" visible="<%=visible %>" />
		<ai:col fieldname="STAFF_ID" title="修改人" visible="<%=visible %>" />

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