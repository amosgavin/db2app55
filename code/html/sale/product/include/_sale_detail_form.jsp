<%--
	作者：江晓莉
	日期：2013-12-09
	功能：档次主要信息
	说明:内嵌页面
 --%>
<%@ page contentType="text/html; charset=GBK"%>
<ai:dbform formid="saleDetailForm" initial="false"
	setname="com.asiainfo.sale.activity.web.SETSaleDetail"
	conditionname="condition" parametersname="parameters"
	editable="true"
	datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	implservice_name="com.asiainfo.sale.activity.service.interfaces.ISaleDetailSV"
	implservice_querymethod="getSaleDetailById(String id)">
	<ai:contractframe id="saleDetailFrame" contenttype="table"
		title="档次主要信息" width="100%" allowcontract="true" frameclosed="false">
		<ai:contractitem />
		<table width="98%" align="center" border="0" cellpadding="1"
			cellspacing="2">
			<tr>
				<td class="td_font">
					编码：
				</td>
				<td>
					<ai:dbformfield formid="saleDetailForm"
						fieldname="SALE_ACTIVE_CODE" width="180" editable="false" />
					<ai:dbformfield formid="saleDetailForm" fieldname="DETAIL_ID"
						visible="false" />
					<ai:dbformfield formid="saleDetailForm" fieldname="SALE_ID"
						visible="false" />
					<ai:dbformfield formid="saleDetailForm" fieldname="WEAPON_ID"
						visible="false" />
				</td>
				<td class="td_font">
					类型：
				</td>
				<td>
					<ai:dbformfield formid="saleDetailForm" fieldname="SALE_FLAG"
						width="150" />
				</td>
			</tr>
			<tr>
				<td class="td_font">
					档次名称：
				</td>
				<td colspan="1">
					<ai:dbformfield formid="saleDetailForm"
						fieldname="SALE_ACTIVE_NAME" width="180" />
					<span class="font_red">*</span>
				</td>
				<td class="td_font">
					是否单位担保：
				</td>
				<td colspan="1">
					<ai:dbformfield formid="saleDetailForm" fieldname="RESERVE3"
						width="150" />
				</td>
			</tr>
			<%--<tr id="jthdxs">
             <td class="td_font">活动形式：</td>
                <td colspan="1"><ai:dbformfield formid="saleDetailForm" fieldname="RESERVE1" width="150" visible="false"/></td>
            </tr> --%>
			<tr>
				<td class="td_font">
					档次说明：
				</td>
				<td colspan="3">
					<ai:dbformfield formid="saleDetailForm" fieldname="LEVEL_DESC"
						height="36" width="450" />
				</td>
			</tr>
			<tr>
				<td class="td_font">
					细分市场：
				</td>
				<td>
					<ai:dbformfield formid="saleDetailForm" fieldname="MARKET"
						width="150" />
					<%--<img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="marketSimpleSelected();" align="absmiddle" style="cursor:hand;"/>--%>
					<span class="font_red">*</span>
				</td>
			</tr>
			<%-- <tr>
        		<td class="td_font">是否需要短信提醒：</td>
        		<td colspan=3 ><ai:dbformfield formid="saleDetailForm" fieldname="IS_SEND_SMS" width="10" visible="false"/>
        			<input type="checkbox" id="selSendType0" value="0" onclick="checkboxSts(0);" />不需要短信提醒&nbsp;
        			<input type="checkbox" id="selSendType1" value="1" onclick="checkboxSts(1);" />业务受理短信</td>
        	</tr> --%>
			<tr id="channel_tr" style="display: none">
				<td class="td_font">
					办理渠道：
				</td>
				<td colspan="3">
					<ai:dbformfield formid="saleDetailForm" fieldname="OPEN_CHANNEL"
						width="450" />
				</td>
			</tr>
			<tr>
				<td align="left" colspan="4">
					<b>个性化业务提示信息：</b>
				</td>
			</tr>
			<tr>
				<td class="td_font">
					提示类型：
				</td>
				<td colspan=3>
					<ai:dbformfield formid="saleDetailForm" fieldname="EXT1" width="10"
						visible="false" />
					<input type="checkbox" id="hint0_input" value="0"
						onclick="checkboxSts(0);" />
					前台界面信息提示&nbsp;
					<input type="checkbox" id="hint1_input" value="1"
						onclick="checkboxSts(1);" />
					事后短信提示&nbsp;
					<input type="checkbox" id="hint2_input" value="2"
						onclick="checkboxSts(2);" />
					发票打印信息提示&nbsp;
					<input type="checkbox" id="hint3_input" value="3"
						onclick="checkboxSts(3);" />
					免填单打印信息提示
				</td>
			</tr>
			<tr id="hint0_tr" style="display: none;">
				<td class="td_font">
					前台界面信息提示：
				</td>
				<td colspan="5">
					<ai:dbformfield formid="saleDetailForm" fieldname="EXT2"
						height="60" width="70%" />
					<span class="font_red">*</span>
				</td>
			</tr>
			<tr id="hint1_tr" style="display: none;">
				<td class="td_font">
					事后短信提示(最多300字)：
				</td>
				<td colspan="5">
					<ai:dbformfield formid="saleDetailForm" fieldname="EXT3"
						height="50" width="70%" />
					<span class="font_red">*</span>
				</td>
			</tr>
			<tr id="hint2_tr" style="display: none;">
				<td class="td_font">
					发票打印信息提示(最多40字)：
				</td>
				<td colspan="5">
					<ai:dbformfield formid="saleDetailForm" fieldname="EXT4"
						height="60" width="70%" />
					<span class="font_red">*</span>
				</td>
			</tr>
			<tr id="hint3_tr" style="display: none;">
				<td class="td_font">
					免填单打印信息提示：
				</td>
				<td colspan="5">
					<ai:dbformfield formid="saleDetailForm" fieldname="EXT5"
						height="50" width="70%" />
					<span class="font_red">*</span>
				</td>
			</tr>
			<tr>
				<td id="SALETYPE_OTHERSALE_td_1" class="td_font">
					营销类型：
				</td>
				<td id="SALETYPE_OTHERSALE_td_2" colspan="3">
					<ai:dbformfield formid="saleDetailForm"
						fieldname="SALETYPE_OTHERSALE" width="450" />
				</td>
			</tr>
			<tr>
				<td id="SALETYPE_DES_OTHERSALE_td_1" class="td_font">
					营销类型描述：
				</td>
				<td id="SALETYPE_DES_OTHERSALE_td_2" colspan="3">
					<ai:dbformfield formid="saleDetailForm"
						fieldname="SALETYPE_DES_OTHERSALE" width="450" />
				</td>
			</tr>
			<tr id="dis1">
				<td align="left" colspan="4">
					<b>客户特征及参与资格描述：</b>
				</td>
			</tr>
			<tr id="dis2">
				<td class="td_font">
					品牌及资费：
				</td>
				<td colspan="3">
					<ai:dbformfield formid="saleDetailForm" fieldname="BRAND_DESC"
						width="450" />
				</td>
			</tr>
			<tr id="dis3">
				<td class="td_font">
					其他条件：
				</td>
				<td colspan="3">
					<ai:dbformfield formid="saleDetailForm" fieldname="OTHER_USERINFO"
						width="450" />
				</td>
			</tr>
			<tr id="dis4">
				<td align="left" colspan="4">
					<b>其他信息：</b>
				</td>
			</tr>
			<tr id="dis5">
				<td class="td_font">
					互斥要求：
				</td>
				<td colspan="3">
					<ai:dbformfield formid="saleDetailForm" fieldname="EXCLUDE_DEMAND"
						height="36" width="450" />
				</td>
			</tr>
			<tr id="dis6">
				<td class="td_font">
					渠道酬金政策：
				</td>
				<td colspan="3">
					<ai:dbformfield formid="saleDetailForm"
						fieldname="CHANNEL_PAY_POLICY" height="36" width="450" />
				</td>
			</tr>
			<%--<tr>
                <td class="td_font">宣传语：</td>
                <td colspan="3"><ai:dbformfield formid="saleDetailForm" fieldname="PUBLICITY_WORD" height="66" width="450"/></td>
            </tr>
            --%>
			<tr>
				<td align="left" colspan="4">
					<b>用户规模：</b>
				</td>
			</tr>
			<tr>
				<td class="td_font">
					允许最大用户数：
				</td>
				<td>
					<ai:dbformfield formid="saleDetailForm" fieldname="MAX_PERSON"
						width="150" />
					(户)
					<span class="font_red">*</span>
				</td>
				<td class="td_font">
					预计用户规模：
				</td>
				<td>
					<ai:dbformfield formid="saleDetailForm" fieldname="PRE_PERSON"
						width="150" />
					(户)
					<span class="font_red">*</span>
				</td>
			</tr>
		</table>
	</ai:contractframe>
	<%@ include file="/sale/product/include/_saleExtInfo.jsp" %>
	<ai:contractframe id="saleDetailframe2" contenttype="table"
		title="成本收益" width="100%" allowcontract="true" frameclosed="false">
		<ai:contractitem>
			<ai:button text="选择武器" id="bt_weaponSelect1" onclick="weaponSelect()" />&nbsp;&nbsp;<ai:button
				id="bt_refreshCompute4weapon" text="刷新"
				onclick="doWork('refreshCompute4weapon()')" />
		</ai:contractitem>
		<table width="98%" align="center" border="0" cellpadding="1"
			cellspacing="2">
			<tr>
				<td id="BACK_PROPORTION_td_1" class="td_font">
					客户回报率：
				</td>
				<td id="BACK_PROPORTION_td_2">
					<ai:dbformfield formid="saleDetailForm" fieldname="BACK_PROPORTION"
						width="100" editable="false" />
					%
				</td>
				<td id="PRE_STORE_TO_PRESENT_td_1" class="td_font">
					预存与赠送比例：
				</td>
				<td id="PRE_STORE_TO_PRESENT_td_2">
					<ai:dbformfield formid="saleDetailForm"
						fieldname="PRE_STORE_TO_PRESENT" width="100" editable="false" />
				</td>
			</tr>
			<tr>
				<td id="PRE_INCOME_td_1" class="td_font">
					吸纳预存款：
				</td>
				<td id="PRE_INCOME_td_2">
					<ai:dbformfield formid="saleDetailForm" fieldname="PRE_INCOME"
						width="150" editable="false" />
					(元)
				</td>
				<td id="FEE_DISCOUNT_td_1" class="td_font">
					预计话费折扣：
				</td>
				<td id="FEE_DISCOUNT_td_2">
					<ai:dbformfield formid="saleDetailForm" fieldname="FEE_DISCOUNT"
						width="150" editable="false" />
					(元)
				</td>
			</tr>
			<tr>
				<td id="PRE_INCOME2_td_1" class="td_font">
					预计收入：
				</td>
				<td id="PRE_INCOME2_td_2" colspan="3">
					<ai:dbformfield formid="saleDetailForm" fieldname="PRE_INCOME2"
						width="150" editable="false" />
					(元)
				</td>
			</tr>
			<tr>
				<td id="BUSINESS_DISCOUNT_td_1" class="td_font">
					预计业务折扣：
				</td>
				<td id="BUSINESS_DISCOUNT_td_2">
					<ai:dbformfield formid="saleDetailForm"
						fieldname="BUSINESS_DISCOUNT" width="100" editable="false" />
					(元)
				</td>
				<td id="MOBILE_COST_td_1" class="td_font">
					终端成本：
				</td>
				<td id="MOBILE_COST_td_2">
					<ai:dbformfield formid="saleDetailForm" fieldname="MOBILE_COST"
						width="100" editable="false" />
					(元)
				</td>
			</tr>
			<tr>
				<td id="ELECPAY_COST_td_1" class="td_font">
					电子购物券成本：
				</td>
				<td id="ELECPAY_COST_td_2">
					<ai:dbformfield formid="saleDetailForm" fieldname="ELECPAY_COST"
						width="100" editable="false" />
					(元)
				</td>
				<td id="MOBILEPAY_COST_td_1" class="td_font">
					手机红包成本：
				</td>
				<td id="MOBILEPAY_COST_td_2">
					<ai:dbformfield formid="saleDetailForm" fieldname="MOBILEPAY_COST"
						width="100" editable="false" />
					(元)
				</td>
			</tr>
			<tr>
				<td id="ELECGOODS_COST_td_1" class="td_font">
					电子提货券成本：
				</td>
				<td id="ELECGOODS_COST_td_2">
					<ai:dbformfield formid="saleDetailForm" fieldname="ELECGOODS_COST"
						width="100" editable="false" />
					(元)
				</td>
				<td id="GOODS_COST_td_1" class="td_font">
					货品成本：
				</td>
				<td id="GOODS_COST_td_2">
					<ai:dbformfield formid="saleDetailForm" fieldname="GOODS_COST"
						width="100" editable="false" />
					(元)
				</td>
			</tr>
			<tr>
				<td id="CHANNEL_PAY_td_1" class="td_font">
					渠道酬金：
				</td>
				<td id="CHANNEL_PAY_td_2">
					<ai:dbformfield formid="saleDetailForm" fieldname="CHANNEL_PAY"
						width="100" />
					(元)
				</td>
				<td id="ESTIMATE_AD_FEE_td_1" class="td_font">
					广告宣传费：
				</td>
				<td id="ESTIMATE_AD_FEE_td_2">
					<ai:dbformfield formid="saleDetailForm" fieldname="ESTIMATE_AD_FEE"
						width="100" />
					(元)
				</td>
			</tr>
			<tr>
				<td id="ESTIMATE_OTHER_FEE_td_1" class="td_font">
					其他：
				</td>
				<td id="ESTIMATE_OTHER_FEE_td_2">
					<ai:dbformfield formid="saleDetailForm"
						fieldname="ESTIMATE_OTHER_FEE" width="100" />
					(元)
					<ai:dbformfield formid="saleDetailForm" fieldname="COST_TOTAL"
						width="100" visible="false" />
				</td>
			</tr>
		</table>
	</ai:contractframe>
</ai:dbform>
<script language="javascript" type="text/javascript">
var _sale_detail_form = {};
_sale_detail_form.detailForm = g_FormRowSetManager.get("saleDetailForm");

 _sale_detail_form.doRefresh=function(cond){
 	_sale_detail_form.detailForm.refresh(cond);
 }






</script>


