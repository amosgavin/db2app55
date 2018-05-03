<%@ page contentType="text/html; charset=GBK"%>
<%@ page
	import="com.asiainfo.common.service.interfaces.IAbstractProductExtSV"%>
<%@ page import="com.ai.appframe2.service.ServiceFactory"%>

<%@ page import="com.asiainfo.charge.ivalues.IBOProductExtDescValue"%>
<%
	IAbstractProductExtSV abSv = (IAbstractProductExtSV) ServiceFactory
			.getService(IAbstractProductExtSV.class);

	IBOProductExtDescValue[] descValues = abSv.getColsName("", "SALE", "1",
			"", -1, -1);
	int length = descValues.length;
	int trNums = length % 3 == 0 ? length / 3 : length / 3 + 1;
%>

<ai:contractframe id="saleExtFrame" contenttype="table" title="档次扩展信息"
	width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem>
	</ai:contractitem>
	<ai:dbform setname="com.asiainfo.sale.product.web.SETSaleDetailExt"
		formid="saleExtInfo"
		datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.product.services.interfaces.ISaleDetailExtSV"
		implservice_querymethod="getSaleDetailExt(String detail_id,String status)"
		initial="false">
		<table>
			<ai:dbformfield fieldname="F_DETAIL_ID" formid="saleExtInfo"
				visible="false" />
			<ai:dbformfield fieldname="E_ID" formid="saleExtInfo" visible="false" />
			<%
				for (int i = 0; i < trNums; i++) {
			%><tr>
				<%
					for (int j = 0; j <= 2; j++) {
							if ((3 * i + j) >= length) {
								break;
							}
							String edit = ("0".equals(descValues[3 * i + j]
									.getIsCanModify())) ? "false" : "true";
				%>
				<td class="td_font"><%=descValues[3 * i + j].getExtName()%></td>
				<td>
					<ai:dbformfield fieldname="<%=descValues[3 * i + j].getExtCode()%>"
						formid="saleExtInfo" editable="<%=edit%>" />

				</td>
				<%
					}
				%>

			</tr>
			<%
				}
			%>

		</table>

	</ai:dbform>
</ai:contractframe>

<script language="javascript" type="text/javascript">
var _saleExtInfo={};
_saleExtInfo.extForm = g_FormRowSetManager.get("saleExtInfo");

_saleExtInfo.refreshForm=function(cond){
	_saleExtInfo.extForm.refresh(cond);
}

</script>