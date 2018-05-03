<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
	<head>
		<title>武器申请</title>
		<script language="javascript"
			src="<%=request.getContextPath()%>/jsv2/Calendar.jsp"
			type="text/javascript"></script>
	</head>
	<body>
		<ai:contractframe id="saleWeaponMainframe" contenttype="table"
			title="申请信息（武器保存后，营销活动就可以选择使用，不需要走流程）" width="100%" allowcontract="true" frameclosed="fale">
			<ai:contractitem />
			<ai:dbform formid="saleWeaponMainframe"
				setname="com.asiainfo.sale.weapon.web.SETSaleWeaponMain"
				conditionname="condition" parametersname="parameters" onvalchange=""
				editable="true" initial="false"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponMainSV"
				implservice_querymethod="getSaleWeaponMainById(String id)">
				<table width="98%" align="center" border="0" cellpadding="1"
					cellspacing="2">
					<tr>
						<td class="td_font">申请名称：</td>
						<td>
							<ai:dbformfield formid="saleWeaponMainframe" fieldname="APPLY_NAME" width="150" editable="" />
							<span class="font_red">*</span>
						</td>
							<ai:dbformfield formid="saleWeaponMainframe" fieldname="ID" visible="false" />
							<ai:dbformfield formid="saleWeaponMainframe" fieldname="WID" visible="false" />
						<td class="td_font">申请人：</td>
						<td>
							<ai:dbformfield formid="saleWeaponMainframe" fieldname="APPLICANT" width="150" editable="false" />
							<ai:dbformfield formid="saleWeaponMainframe" fieldname="PRINCIPAL" width="150" visible="false" />
						<td class="td_font">申请单位：</td>
						<td>
							<ai:dbformfield formid="saleWeaponMainframe" fieldname="ORG" width="130" editable="false" />
							<ai:dbformfield formid="saleWeaponMainframe" fieldname="PROMOTE_DEPART" width="130" visible="false" />
						</td>
					</tr>
					<tr>
						<td class="td_font">申请说明：</td>
						<td colspan="5">
							<ai:dbformfield formid="saleWeaponMainframe" fieldname="REMARK" width="80%" height="80" />
						</td>
					</tr>
				</table>
				<div class="area_button" style="display: none;">
					<ai:button text="保存申请信息" id="" onclick="" />
				</div>
			</ai:dbform>
		</ai:contractframe>

		<ai:contractframe id="chargeApplyMain" contenttype="table" title="已保存的武器模板信息" width="100%" allowcontract="true" frameclosed="fale">
	    <ai:contractitem><%--<ai:button id="newSaleDetail" text="新建活动" onclick="newSaleDetail()"/>--%>
	    <ai:button id="bt_addCharge" text="新增武器模板"  onclick="addNewModle()"/> <ai:button id="bt_addChargeDetail" text="删除武器模板"  onclick="delNewModle()"/></ai:contractitem>
	    <ai:table
	        tableid="table00"
	        setname="com.asiainfo.sale.weapon.web.SETSaleWeapon"
	        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	        implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
	        implservice_querymethod="getSaleWeaponByMainId(String mainId, int $STARTROWINDEX,int $ENDROWINDEX)"
	        initial="false"  multiselect="true" onrowchange="showApplyMain"
	        pagesize="15" editable="false" width="100%" 
	        height="100" needrefresh="true">
	        	<ai:col title="武器编号ID" fieldname="ID" visible="" width="10%"/>
	        	<ai:col title="工单编号" fieldname="MID" visible="" width="10%"/>
	            <ai:col title="档次类别" fieldname="SALE_FLAG" width="20%" />
	            <ai:col title="细分市场" fieldname="MARKET_TYPE" width="20%" />
	        	<ai:col title="网龄" fieldname="NET_AGE" width="20%"/>
	            <ai:col title="武器名称" fieldname="WEAPON_NAME" width="30%" />
	    </ai:table>
		</ai:contractframe>

		<ai:contractframe id="weaponSelectForm" contenttype="table"
			title="武器类别申请" width="100%" allowcontract="false" frameclosed="false">
			<ai:contractitem />
			<ai:dbform formid="weaponSelectForm"
				setname="com.asiainfo.sale.weapon.web.SETSaleWeapon"
				onvalchange="onSaleTypeChange" editable="true" initial="false"
				conditionname="condition" parametersname="parameters"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
            implservice_querymethod="getSaleWeaponOnlyByID(String id)">
				<table width="98%" align="center" border="0" cellpadding="1"
					cellspacing="2">
					<tr>
						<td class="td_font" style="display: none">编号：</td>
						<td style="display: none">
							<ai:dbformfield formid="weaponSelectForm" fieldname="MID" width="150" />
						</td>
						<td class="td_font">档次类别：</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm" fieldname="SALE_FLAG" width="150" />
								<span class="font_red">*</span>
						</td>
						<td class="td_font">细分市场：</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm" fieldname="MARKET_TYPE" width="150" />
								<span class="font_red">*</span>
						</td>
						<td class="td_font">网龄：</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm" fieldname="NET_AGE" width="70" visible="false" />
							<ai:dbformfield formid="weaponSelectForm" fieldname="MINNET_AGE" width="70" />至
							<ai:dbformfield formid="weaponSelectForm" fieldname="MAXNET_AGE" width="70" />(月)
								<span class="font_red">*</span>
						</td>
					</tr>
					<tr>
						<td class="td_font"><span class="font_red">发布电子渠道：</span></td>
		        		<td colspan=5 ><ai:dbformfield formid="weaponSelectForm" fieldname="STANDBY_NUM3" width="150"/>
			               	<span class="font_red">（如果需要，请务必选择）</span></td>
					</tr>
					<tr>
						<td class="td_font">武器名称：</td>
						<td colspan="5">
							<ai:dbformfield formid="weaponSelectForm" fieldname="WEAPON_NAME" width="750" height="40" />
								<span class="font_red">*</span>
						</td>
					</tr>
				</table>
			</ai:dbform>
		</ai:contractframe>

		<ai:contractframe id="weaponMainSelectframe1" contenttype="table"
			title="详细申请" width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem>
					<table><tr>
			<td><ai:button text="计算一次性到账" id="query1" onclick="showReach()" />
			    <ai:button text="添加武器标识" id="add_tag_bt" onclick="addTag()" /></td>
			</tr></table>
			</ai:contractitem>
			<ai:dbform formid="weaponSelectForm1"
				setname="com.asiainfo.sale.weapon.web.SETSaleWeapon" onvalchange="onReturnTypeChange" initial="false"
				conditionname="condition" parametersname="parameters"
             datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
            implservice_querymethod="getSaleWeaponOnlyByID(String id)">
	
				<table width="98%" align="center" border="0" cellpadding="1"
					cellspacing="2" style="display: none">

					<tr>
						<td class="td_font">编号：</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="WID" width="150" />
							<ai:dbformfield formid="weaponSelectForm1" fieldname="STANDBY_NUM3" width="10" visible="false"/>
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="MID" width="150" />
						</td>
						<td class="td_font">名称：</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="WEAPON_NAME" width="150" />
						</td>
					</tr>
					<tr>
						<td class="td_font">
							细分市场：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="MARKET_TYPE" width="150" />
						</td>
						<td class="td_font">
							网龄：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="NET_AGE"
								width="70" visible="false" />
							<ai:dbformfield formid="weaponSelectForm1" fieldname="MINNET_AGE"
								width="70" />
							至
							<ai:dbformfield formid="weaponSelectForm1" fieldname="MAXNET_AGE"
								width="70" />
							(月)
							<span class="font_red">*</span>
						</td>
					</tr>
					<tr>
						<td class="td_font">
							活动类别：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="SALE_FLAG"
								width="150" />
						</td>
					</tr>
				</table>
				<table width="98%" align="center" border="0" cellpadding="1"
					cellspacing="2" id="tab">
					<tr id="tr1">
					
						<td class="td_font">
							<b>预存:</b>
						</td>
						<td>
							(预存标识查询)
							<img id="selectOrgType" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="prepCondition()" align="absmiddle"
								style="cursor: hand;" />
							<ai:button text="清空" id="clearFee" onclick="clearPrep()" />
						</td>
					</tr>
					<tr  id="tryc" >
						<td class="td_font">
							预存专款范围：
						</td>
						<td>
						<table>
							<td>
						<ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_3"
								width="350" /></td><td>
								<img id="selectOrgTypeYCZK" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="zkfwCondition()" align="absmiddle"
								style="cursor: hand;" />
								</td>
								</table>
								</td>
								<td class="td_font">预存专款范围费用组：</td>
								<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="DYNAMIC_SCORE" width="150" />
							</td>
								<!-- <td>预存专款范围账目项：<img id="selectOrgTypeYCZK" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="ycTagItem()" align="absmiddle"
								style="cursor: hand;" /></td> -->
					</tr>
					<tr id="tr2">
						<td class="td_font">
							预存话费金额：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="PRESTORE_FEE" width="150" />
							(元)
						</td>
						<td class="td_font">
							预存一次性到帐：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="PRESTRORE_REACH_ACCOUNT" width="150" />
							(元)
						</td>
					</tr>
					<tr id="tr3">
						<td class="td_font">
							每月返还额度：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="B_LIMIT"
								width="150" />
							(元)
						</td>
						<td class="td_font">
							返还月份：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="BACK_MONTH"
								width="150" />
						</td>
					</tr>
					<tr id="tr4">
						<td class="td_font">
							<b>赠送:</b>
						</td>
						<td id="tdzs">
							(赠送标识查询)
							<img id="selectOrgType" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="feeCondition()" align="absmiddle"
								style="cursor: hand;" />
							<ai:button text="清空" id="clearPre" onclick="clearFee()" />
						</td>
						<td id="tdzsdz" style="display: none">
							(赠送标识查询)
							<img id="selectDZ" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="feedzCondition()" align="absmiddle"
								style="cursor: hand;" />
							<ai:button text="清空" id="clearPre" onclick="clearFee()" />
						</td>
						<td id="tdzshb" style="display: none">
							(赠送标识查询)
							<img id="selectHB" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="feehbCondition()" align="absmiddle"
								style="cursor: hand;" />
							<ai:button text="清空" id="clearPre" onclick="clearFee()" />
						</td>
						<td id="tdzshp" style="display: none">
							(赠送标识查询)
							<img id="selectDZ" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="feehpCondition()" align="absmiddle"
								style="cursor: hand;" />
							<ai:button text="清空" id="clearPre" onclick="clearFee()" />
						</td>
						<td id="clearBusi">
							<ai:button text="清空" id="clearPre" onclick="clearFee()" />
						</td>
					</tr>
					
					<!-- 积分类 -->
					<tr id='jfl_tr' style="display: none">
						<td class="td_font">赠送积分：</td>
						<td><ai:dbformfield formid="weaponSelectForm1" fieldname="STANDBY_NUM2" width="150" editable="false"/>
							<img id="selectJfType" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="jfCondition()" align="absmiddle" style="cursor: hand;" />
								<ai:button text="清空" id="clearJf" onclick="clearjfl()" /> </td>
					</tr>
					
						<tr  id="trzs">
						<td class="td_font">
							赠送专款范围：
						</td>
						<td > 
						<table>
							<td>
						<ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_2"
								width="350" />
								</td><td>
								<img id="selectOrgTypeZSZK" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="zkfwConditionz()" align="absmiddle"
								style="cursor: hand;" />
								</td>
								</table>
						</TD>
						<td class="td_font">赠送专款范围费用组:</td>
								<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="HOME_SCORE" width="150" />
							</td>
							<!-- 
							<td>赠送专款范围账目项：<img id="selectOrgTypeYCZK" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="zsTagItem()" align="absmiddle"
								style="cursor: hand;" /></td>
								 -->
						
					</tr>
					<tr id="tr5">
						<td class="td_font">
							赠送话费金额：
						</td>
						<td>
							<table>
								<tr>
									<td>
										<ai:dbformfield formid="weaponSelectForm1"
											fieldname="PRESENT_BUSI_AMOUNT" width="150" />
										(元)
									</td>
									<td>
										<img id="sjyw1" border="0"
											src="<%=request.getContextPath()%>/webframe/images/query.gif"
											alt="" onClick="feeCondition()" align="absmiddle"
											style="cursor: hand;" />
									</td>
								</tr>
							</table>
						</td>
						<td class="td_font">
							赠送一次性到帐：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="PRESENT_REACH_AMOUNT" width="150" />
							(元)
						</td>
					</tr>
					<tr id="tr18">
						<td class="td_font">
							每月赠送额度：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="PRESENT_VALUE_PERMON" width="150" />
							(元)
						</td>
						<td class="td_font">
							赠送月数：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="PRESENT_BUSI_MONTH" width="150" />
						</td>
					</tr>
					<!-- 分月改造 -->
					<tr id="tr24">
					<td class="td_font">
							电子券总金额：
						</td>
						<td>
						<table>
						<tr><td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="ADD_MONTHCHARGE"
								width="150" />(元)
							</td>
							<td>	
								<img id="sjyw2" style="display: none" border="0"
											src="<%=request.getContextPath()%>/webframe/images/query.gif"
											alt="" onClick="feedzCondition()" style="cursor:hand;" />
							</td>
						</tr>					
						</table>
						</td>
						<td class="td_font">
							返还策略：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="RETURN_TYPE"
								width="150" />
							<span id="showzfq" class="font_red">*</span>
						</td>
					</tr>
					
					<tr id="tr25">
					<td class="td_font">
							首次返还：
						</td>
						<td>
						  <ai:dbformfield formid="weaponSelectForm1" fieldname="FIRSTCHARGE"
								width="150" />
							<span id="" class="font_red">*</span> 
						</td>
						<td class="td_font">
							末次返还：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="LASTCHARGE"
								width="150" />
							<span id="" class="font_red">*</span>
						</td>
					</tr>
					
					<tr id="tr6">
						<td id="td6" class="td_font">
							每月金额：
						</td>
						<td id="td7">
							<ai:dbformfield formid="weaponSelectForm1"
											fieldname="PRESENT_BUSI2_AMOUNT" width="150" />
										(元)
						</td>
						<td class="td_font">
							返还周期：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="STANDBY_NUM1"
								width="150" />
							<span id="" class="font_red">*</span>
						</td>
					</tr>
					<tr id="tr24_hb">
					<td class="td_font">
							和包红包总金额：
						</td>
						<td>
						<table>
						<tr><td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="ADD_MONTHCHARGE_HB"
								width="150" />(元)
							</td>
							<td>	
								<img id="sjyw2_hb" style="display: none" border="0"
											src="<%=request.getContextPath()%>/webframe/images/query.gif"
											alt="" onClick="feehbCondition()" style="cursor:hand;" />
							</td>
						</tr>					
						</table>
						</td>
						<td class="td_font">
							返还策略：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="RETURN_TYPE_HB"
								width="150" />
							<span id="showzfq_hb" class="font_red">*</span>
						</td>
					</tr>
					<tr id="tr25_hb">
					<td class="td_font">
							首次返还：
						</td>
						<td>
						  <ai:dbformfield formid="weaponSelectForm1" fieldname="FIRSTCHARGE_HB"
								width="150" />
							<span id="" class="font_red">*</span> 
						</td>
						<td class="td_font">
							末次返还：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="LASTCHARGE_HB"
								width="150" />
							<span id="" class="font_red">*</span>
						</td>
					</tr>
					<tr id="tr6_hb">
						<td id="td6_hb" class="td_font">
							每月金额：
						</td>
						<td id="td7_hb">
							<ai:dbformfield formid="weaponSelectForm1"
											fieldname="PRESENT_BUSI2_AMOUNT_HB" width="150" />
										(元)
						</td>
						<td class="td_font">
							返还周期：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="STANDBY_NUM1_HB"
								width="150" />
							<span id="" class="font_red">*</span>
						</td>
					</tr>
					<tr id="tr7">
						<td class="td_font">
							支付类型描述：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_1"
								width="150" />
						</td>
					</tr>
					<tr id="tr8">
						<td class="td_font">
							货品业务总价值：
						</td>
						<td>
							<table>
								<tr>
									<td>
										<ai:dbformfield formid="weaponSelectForm1"
											fieldname="PRESENT_BUSI3_AMOUNT" width="150" />
										(元)
									</td>
									<td>
										<img id="sjyw3" style="display: none" border="0"
											src="<%=request.getContextPath()%>/webframe/images/query.gif"
											alt="" onClick="feehpCondition()" align="absmiddle"
											style="cursor:hand;" />
									</td>
								</tr>
							</table>
						</td>
						<td class="td_font">
							货品采购目录：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="GOOD_ADOPT_DIRECTORY" width="200" />
						</td>
					</tr>
					<tr id="tr9">
						<td class="td_font">
							货品销售指导价：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="REFERENCE_PRICE" width="150" />
							(元)
						</td>
						<td class="td_font" style="display: none;">
							货品描述：
						</td>
						<td style="display: none;">
						</td>
					</tr>
					<tr id="tr10">
						<td class="td_font">
							终端实际购买款：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="TERM_REAL_FEE" width="150" />
							(元)
						</td>
						<td class="td_font">
							终端类型：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="TERM_TYPE"
								width="150" />
						</td>
					</tr>
					<tr id="tr11">
						<td class="td_font">
							终端销售指导价：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="TERM_GUIDE_FEE" width="150" />
							(元)
						</td>
						<td class="td_font">
							终端成本结算价：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="TERM_COST_FEE" width="150" />
						</td>
					</tr>
					<tr id="tr12" >
						<td class="td_font" style="display: none;">
							终端描述：
						</td>
						<td style="display: none;">
							<ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_4"
								width="150" />
							(元)
						</td>
					</tr>
					<tr id="tr13">
						<td class="td_font">
							数字产品总价格：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="PRESENT_BUSI5_AMOUNT" width="150" />
							(元)
						</td>
					</tr>
					<tr id="tr14">
						<td class="td_font">
							数字产品描述：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_5"
								width="150" />
						</td>
					</tr>
					<tr id="tr15">
						<td class="td_font">
							<b>赠送自有业务：</b>
						</td>
						<td>
							(业务标识查询)
							<img id="selectOrgType" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="busitypeCondition()" align="absmiddle"
								style="cursor: hand;" />
							<ai:button text="清空" id="clearFee" onclick="clearFee()" />
						</td>
					</tr>
					<tr id="tr16">
						<td class="td_font">
							自有业务总价值：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="PRESENT_BUSI4_AMOUNT" width="150" />
							(元)
						</td>
						<td class="td_font">
							业务类型：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="BUSI_TYPE"
								width="200" />
						</td>
					</tr>
					<tr id="tr17">
						<td class="td_font">
							自有业务描述：
						</td>
						<td>
						</td>
					</tr>
					<!-- 
			<tr id="tr18">
	           	<td class="td_font">每月赠送额度：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_VALUE_PERMON" width="150"/>(元)</td>
				<td class="td_font">赠送月数：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI_MONTH" width="150"/></td>
			</tr>
			 -->
					<tr id="tr19">
						<td class="td_font">
							<b>保底：</b>
						</td>
						<td>
							(保底标识查询)
							<img id="selectOrgType" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="baseCondition()" align="absmiddle"
								style="cursor: hand;" />
							<ai:button text="清空" id="clearFee" onclick="clearBase()" />
						</td>
					</tr>
					<tr id="tr20">
						<td class="td_font">
							每月保底额度：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="L_LIMIT"
								width="150" />
							(元)
						</td>
						<td class="td_font">
							保底月数：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="BASE_MONTH"
								width="150" />
						</td>
					</tr>
					<tr id="tr201">
						<td class="td_font">
							保底类型：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="LIM_TYPE" width="150" /><span class="font_red">(套餐内:保底包含套餐费用;套餐外:保底在套餐费之外另算)</span>
						</td>
						<td class="td_font">
						</td>
						<td>
						</td>
					</tr>
					<tr id="tr21">
						<td class="td_font">
							<b>数据包：</b>
						</td>
						<td>
							(数据包标识查询)
							<img id="selectOrgType" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="busiCondition()" align="absmiddle"
								style="cursor: hand;" />
							<ai:button text="清空" id="clearFee" onclick="clearBusi()" />
						</td>
					</tr>
					<tr id="tr22">
						<td class="td_font">
							数据包总价值：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="DATA_FEE"
								width="150" />
						</td>

						<td class="td_font">
							数据包名称：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="DATA_BUSI_TYPE" width="200" />
						</td>
					</tr>
					<tr id="tr23">
						<td class="td_font">
							每月价值：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="VALUE_PERMONTH" width="150" />
						</td>
						<td class="td_font">
							开通月数：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="OPEN_MONTH"
								width="150" />
						</td>
					</tr>
					<tr id="">
						<td class="td_font">
							<b>扣减积分：</b>
						</td>
						<td>
							<ai:button text="积分清零" id="clearsc" onclick="clearScore()" />
							<ai:button text="清空" id="clearscore" onclick="clearScoreButton()" />
							</td>
					</tr>
					<tr id="">
						<td class="td_font">
							积分：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="GLOBAL_SCORE" width="150"/>
						
							<span class="font_red">(积分为-1,表示积分清零!)</span>
						</td>
					</tr>
					<tr id="" style="display: none">
						<td class="td_font">
							神州行积分：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="SZX_SCORE"
								width="150" />
						</td>
					</tr>
				</table>
			</ai:dbform>
		</ai:contractframe>
		<div id="div1" class="area_button" style="display: none">
			<span class="font_red"><b>您选择了备用标签！</b>
			</span>
		</div>

		<div class="area_button">
			<ai:button text="新增" id="query4" onclick="addWeaponInfoNew()"  style="display: none"/>
			&nbsp;&nbsp;
			<ai:button text="保存" id="query2" onclick="doWork('addWeaponInfo()')" />
			&nbsp;&nbsp;
			<!--对于<a href>打开的窗口必须使用“#nogo”; -->
		</div>
		<div class="area_button" style="display: none;">
			下一环节审批人：<select name="opTypeId_a" id="opTypeId_a" style="width:150px" onchange="onSelectchg();">
		                    <option value="20005341">乔长亮</option>
							<option value="20005232">孙思</option>
						   </select>&nbsp;&nbsp;&nbsp;&nbsp;
			<ai:button text="提交" id="query3"
				onclick="doWork('commitWeaponInfo()')" />
			&nbsp;&nbsp;
		</div>
	</body>
</html>

<ai:loginuser />
<script type="text/javascript">
  
var weaponSelectForm = g_FormRowSetManager.get("weaponSelectForm");
var weaponSelectForm1 = g_FormRowSetManager.get("weaponSelectForm1");
var saleWeaponMainframe = g_FormRowSetManager.get("saleWeaponMainframe");
var table00 = g_TableRowSetManager.get("table00");

function initpage() {
	g_AIButtonManager.get("query3").setDisabled(true);
	var staffId = g_GetUserInfo().STAFF_ID;
	saleWeaponMainframe.setValue("APPLICANT", g_GetUserInfo().STAFF_ID,
			g_GetUserInfo().STAFF_NAME);
	saleWeaponMainframe.setValue("PRINCIPAL", g_GetUserInfo().STAFF_ID,
			g_GetUserInfo().STAFF_NAME);
	saleWeaponMainframe.setValue("PROMOTE_DEPART", g_GetUserInfo().ORG_ID,
			g_GetUserInfo().ORG_NAME);
	saleWeaponMainframe.setValue("ORG", g_GetUserInfo().ORG_ID,
			g_GetUserInfo().ORG_NAME);
	initDate();
	weaponSelectForm.setValue("SALE_FLAG", 11);
	document.getElementById("tr1").style.display = "block";
	document.getElementById("tr2").style.display = "block";
	document.getElementById("tr3").style.display = "block";
	document.getElementById("tr4").style.display = "block";
	document.getElementById("tr5").style.display = "block";
	document.getElementById("tr19").style.display = "block";
	document.getElementById("tr20").style.display = "block";
	document.getElementById("tr18").style.display = "block";
	weaponSelectForm.refreshListBox("MARKET_TYPE", "codeType=markets", true);
	weaponSelectForm.refreshListBox("SALE_FLAG", "codeType=hdlxs", true);
	weaponSelectForm.setColEditSts("WEAPON_NAME", false);//0920
	weaponSelectForm1.setColEditSts("REMARK_2", false);
	weaponSelectForm1.setColEditSts("REMARK_3", false);
	weaponSelectForm1.setColEditSts("DYNAMIC_SCORE", false);
	weaponSelectForm1.setColEditSts("HOME_SCORE", false);
	weaponSelectForm1.setColEditSts("ADD_MONTHCHARGE", false);
	weaponSelectForm1.setColEditSts("ADD_MONTHCHARGE_HB", false);
	// weaponSelectForm1.setColEditSts("RETURN_TYPE",false);
	// weaponSelectForm1.setColEditSts("FIRSTCHARGE",false);
	// weaponSelectForm1.setColEditSts("LASTCHARGE",false);
	// weaponSelectForm1.setColEditSts("STANDBY_NUM1",false);
}

initpage();

var orgid = g_GetUserInfo().ORG_ID;
var flagdiv1 = false;
var flagdiv2 = false;
var flagdiv3 = false;
var flagdiv4 = false;
var flagdiv5 = false;
var flagdiv6 = false;
var flagdiv6_hb = false;
var flagdiv7 = false;
var flagdiv9 = false;
var wtid1 = "";
var wtid2 = "";
var wtid3 = "";
var wtid4 = "";
var wtid5 = "";
var wtid6 = "";
var wtid6_hb = "";
var wtid7 = "";
var wtid8 = "";
var wtid9 = "";
var isarea1 = false;
var isarea2 = false;
var isarea3 = false;
var isarea4 = false;
var isarea5 = false;
var isarea6 = false;
var isarea6_hb = false;
var isarea7 = false;
var isarea8 = false;
var isarea9 = false;
function prepCondition() {
	var tagType = "4";
	var returnP = window.showModalDialog(
			"<%=request.getContextPath()%>/sale/promationTag/promationTag.jsp?tagType="
					+ tagType + "&orgid=" + orgid, "", "dialogWidth=800px");
	if (returnP != null) {
		weaponSelectForm1.setValue("B_LIMIT", returnP.split(",")[1]);
		weaponSelectForm1.setValue("BACK_MONTH", returnP.split(",")[0]);
		weaponSelectForm1.setValue("REMARK_3", returnP.split(",")[7]);
		weaponSelectForm1.setValue("DYNAMIC_SCORE", returnP.split(",")[7]);
		weaponSelectForm1.setColEditSts("REMARK_3", false);
		var state = returnP.split(",")[2];
		wtid4 = returnP.split(",")[3];
		if (returnP.split(",")[6] != "10") {
			isarea4 = true;
		}
		if (state == 99) {
			flagdiv4 = true;
		} else {
			flagdiv4 = false;
		}
		if (flagdiv6 || flagdiv6_hb || flagdiv1 || flagdiv2 || flagdiv3 || flagdiv4
				|| flagdiv5 || flagdiv7) {
			document.getElementById("div1").style.display = "block";
		} else {
			document.getElementById("div1").style.display = "none";
		}
		//document.getElementById("selectOrgTypeYCZK").style.display="none";
	}

}

function baseCondition() {
	var tagType = "1";
	var returnBd = window.showModalDialog(
			"<%=request.getContextPath()%>/sale/promationTag/promationTag.jsp?tagType="
					+ tagType + "&orgid=" + orgid, "", "dialogWidth=800px");
		//alert(returnBd);
	if (returnBd != null) {
		weaponSelectForm1.setValue("L_LIMIT", returnBd.split(",")[1]);
		weaponSelectForm1.setValue("BASE_MONTH", returnBd.split(",")[0]);
		weaponSelectForm1.setValue("LIM_TYPE", returnBd.split(",")[8]);
		var state = returnBd.split(",")[2];
		wtid1 = returnBd.split(",")[3];
		if (returnBd.split(",")[6] != "10") {
			isarea1 = true;
		}
		if (state == 99) {
			flagdiv1 = true;
		} else {
			flagdiv1 = false;
		}
		if (flagdiv6 || flagdiv6_hb || flagdiv1 || flagdiv2 || flagdiv3 || flagdiv4
				|| flagdiv5 || flagdiv7) {
			document.getElementById("div1").style.display = "block";
		} else {
			document.getElementById("div1").style.display = "none";
		}
	}
}

function busiCondition() {
	var tagType = "3";
	var returnFee = window.showModalDialog(
			"<%=request.getContextPath()%>/sale/promationTag/promationTag.jsp?tagType="
					+ tagType + "&orgid=" + orgid, "", "dialogWidth=800px");
	if (returnFee != null) {
		weaponSelectForm1.setValue("VALUE_PERMONTH", returnFee.split(",")[1]);
		weaponSelectForm1.setValue("OPEN_MONTH", returnFee.split(",")[0]);
		var state = returnFee.split(",")[2];
		wtid3 = returnFee.split(",")[3];
		var name = returnFee.split(",")[4];
		weaponSelectForm1.setValue("DATA_BUSI_TYPE", name);

		weaponSelectForm1.setValue("DATA_FEE", returnFee.split(",")[1]
				* returnFee.split(",")[0]);
		if (returnFee.split(",")[6] != "10") {
			isarea3 = true;
		}
		if (state == 99) {
			flagdiv3 = true;
		} else {
			flagdiv3 = false;
		}
		if (flagdiv6 || flagdiv6_hb || flagdiv1 || flagdiv2 || flagdiv3 || flagdiv4
				|| flagdiv5 || flagdiv7) {
			document.getElementById("div1").style.display = "block";
		} else {
			document.getElementById("div1").style.display = "none";
		}
	}
}

function jfCondition() {
	var tagType = "11";
	var saleFlag = weaponSelectForm.getValue("SALE_FLAG");
	var returnFee = window.showModalDialog(
			"<%=request.getContextPath()%>/sale/promationTag/promationTag.jsp?tagType="
					+ tagType + "&orgid=" + orgid, "", "dialogWidth=800px");
	if (returnFee != null) {
		weaponSelectForm1.setValue("STANDBY_NUM2", returnFee.split(",")[1]);

		var state = returnFee.split(",")[2];
		wtid9 = returnFee.split(",")[3];
		if (returnFee.split(",")[6] != "10") {
			isarea9 = true;
		}
		if (saleFlag != 31) {
			wtid6 = "";
			wtid6_hb = "";
			wtid7 = "";
			isarea6 = false;
			isarea6_hb = false;
			isarea7 = false;
		}
		if (state == 99) {
			flagdiv9 = true;
		} else {
			flagdiv9 = false;
		}
		if (flagdiv6 || flagdiv6_hb || flagdiv1 || flagdiv2 || flagdiv3 || flagdiv4
				|| flagdiv5 || flagdiv7 || flagdiv9) {
			document.getElementById("div1").style.display = "block";
		} else {
			document.getElementById("div1").style.display = "none";
		}
	}
}

function feeCondition() {
	var tagType = "2";
	var saleFlag = weaponSelectForm.getValue("SALE_FLAG");
	var returnFee = window.showModalDialog(
			"<%=request.getContextPath()%>/sale/promationTag/promationTag.jsp?tagType="
					+ tagType + "&orgid=" + orgid, "", "dialogWidth=800px");
	if (returnFee != null) {
		weaponSelectForm1.setValue("PRESENT_VALUE_PERMON",
				returnFee.split(",")[1]);
		weaponSelectForm1.setValue("PRESENT_BUSI_MONTH",
				returnFee.split(",")[0]);
		weaponSelectForm1.setValue("REMARK_2", returnFee.split(",")[7]);
		weaponSelectForm1.setValue("HOME_SCORE", returnFee.split(",")[7]);
		var state = returnFee.split(",")[2];
		wtid2 = returnFee.split(",")[3];
		if (returnFee.split(",")[6] != "10") {
			isarea2 = true;
		}
		if (saleFlag != 31) {
			wtid6 = "";
			wtid6_hb = "";
			wtid7 = "";
			isarea6 = false;
			isarea6_hb = false;
			isarea7 = false;
		}
		if (state == 99) {
			flagdiv2 = true;
		} else {
			flagdiv2 = false;
		}
		if (flagdiv6 || flagdiv6_hb || flagdiv1 || flagdiv2 || flagdiv3 || flagdiv4
				|| flagdiv5 || flagdiv7) {
			document.getElementById("div1").style.display = "block";
		} else {
			document.getElementById("div1").style.display = "none";
		}
		//document.getElementById("selectOrgTypeZSZK").style.display="none";
	}
}

function busitypeCondition() {
	var tagType = "5";
	var returnFee = window.showModalDialog(
			"<%=request.getContextPath()%>/sale/promationTag/promationTag.jsp?tagType="
					+ tagType + "&orgid=" + orgid, "", "dialogWidth=800px");
	if (returnFee != null) {
		//weaponSelectForm1.setValue("PRESENT_VALUE_PERMON",returnFee.split(",")[1]);
		//weaponSelectForm1.setValue("PRESENT_BUSI_MONTH",returnFee.split(",")[0]);

		var state = returnFee.split(",")[2];
		wtid5 = returnFee.split(",")[3];
		var name = returnFee.split(",")[4];
		weaponSelectForm1.setValue("BUSI_TYPE", name);
		weaponSelectForm1.setValue("PRESENT_BUSI4_AMOUNT",
				returnFee.split(",")[1] * returnFee.split(",")[0]);
		if (returnFee.split(",")[6] != "10") {
			isarea5 = true;
		}
		if (state == 99) {
			flagdiv5 = true;
		} else {
			flagdiv5 = false;
		}
		if (flagdiv6 || flagdiv6_hb || flagdiv1 || flagdiv2 || flagdiv3 || flagdiv4
				|| flagdiv5 || flagdiv7) {
			document.getElementById("div1").style.display = "block";
		} else {
			document.getElementById("div1").style.display = "none";
		}
	}
}

function feedzCondition() {
	var tagType = "6";
	var saleFlag = weaponSelectForm.getValue("SALE_FLAG");
	//var returnFee= window.showModalDialog("<%=request.getContextPath()%>/sale/promationTag/zfqpromationTag.jsp?tagType="+tagType+"&orgid="+orgid,"","dialogWidth=800px"); 
	var returnFee = window.showModalDialog(
			"<%=request.getContextPath()%>/sale/promationTag/dzpromationTag.jsp?tagType="
					+ tagType + "&orgid=" + orgid, "", "dialogWidth=800px");
	if (returnFee != null) {
		//weaponSelectForm1.setValue("CHARGE",returnFee.split(",")[1]);
		//weaponSelectForm1.setValue("SUMCHARGE",returnFee.split(",")[7]);
		var state = returnFee.split(",")[2];
		wtid6 = returnFee.split(",")[3];
		var name = returnFee.split(",")[4];
		weaponSelectForm1.setValue("RETURN_TYPE", returnFee.split(",")[8]);
		if (returnFee.split(",")[8] == "3") {
			weaponSelectForm1.setValue("PRESENT_BUSI2_AMOUNT", returnFee
					.split(",")[7]);
		} else {
			weaponSelectForm1.setValue("PRESENT_BUSI2_AMOUNT", returnFee
					.split(",")[1]);
		}
		weaponSelectForm1.setValue("ADD_MONTHCHARGE", returnFee.split(",")[9]);
		weaponSelectForm1.setValue("FIRSTCHARGE", returnFee.split(",")[10]);
		weaponSelectForm1.setValue("LASTCHARGE", returnFee.split(",")[11]);
		weaponSelectForm1.setValue("STANDBY_NUM1", returnFee.split(",")[0]);
		if (returnFee.split(",")[6] != "10") {
			isarea6 = true;
		}
		if (saleFlag != 31) {
			wtid2 = "";
			wtid7 = "";
			isarea2 = false;
			isarea7 = false;
			isarea6_hb = false;
			wtid6_hb="";
		}
		if (state == 99) {
			flagdiv6 = true;
		} else {
			flagdiv6 = false;
		}
		if (flagdiv6 || flagdiv6_hb || flagdiv1 || flagdiv2 || flagdiv3 || flagdiv4
				|| flagdiv5 || flagdiv7) {
			document.getElementById("div1").style.display = "block";
		} else {
			document.getElementById("div1").style.display = "none";
		}
	}
}

function feehbCondition() {
	var tagType = "9";
	var saleFlag = weaponSelectForm.getValue("SALE_FLAG");
	//var returnFee= window.showModalDialog("<%=request.getContextPath()%>/sale/promationTag/zfqpromationTag.jsp?tagType="+tagType+"&orgid="+orgid,"","dialogWidth=800px"); 
	var returnFee = window.showModalDialog(
			"<%=request.getContextPath()%>/sale/promationTag/dzpromationTag.jsp?tagType="
					+ tagType + "&orgid=" + orgid, "", "dialogWidth=800px");
	if (returnFee != null) {
		//weaponSelectForm1.setValue("CHARGE",returnFee.split(",")[1]);
		//weaponSelectForm1.setValue("SUMCHARGE",returnFee.split(",")[7]);
		var state = returnFee.split(",")[2];
		wtid6_hb = returnFee.split(",")[3];
		var name = returnFee.split(",")[4];
		weaponSelectForm1.setValue("RETURN_TYPE_HB", returnFee.split(",")[8]);
		if (returnFee.split(",")[8] == "3") {
			weaponSelectForm1.setValue("PRESENT_BUSI2_AMOUNT_HB", returnFee
					.split(",")[7]);
		} else {
			weaponSelectForm1.setValue("PRESENT_BUSI2_AMOUNT_HB", returnFee
					.split(",")[1]);
		}
		weaponSelectForm1.setValue("ADD_MONTHCHARGE_HB", returnFee.split(",")[9]);
		weaponSelectForm1.setValue("FIRSTCHARGE_HB", returnFee.split(",")[10]);
		weaponSelectForm1.setValue("LASTCHARGE_HB", returnFee.split(",")[11]);
		weaponSelectForm1.setValue("STANDBY_NUM1_HB", returnFee.split(",")[0]);
		if (returnFee.split(",")[6] != "10") {
			isarea6_hb = true;
		}
		if (saleFlag != 31) {
			wtid2 = "";
			wtid7 = "";
			wtid6 = "";
			isarea6 = false;
			isarea2 = false;
			isarea7 = false;
		}
		if (state == 99) {
			flagdiv6_hb = true;
		} else {
			flagdiv6_hb = false;
		}
		if (flagdiv6 || flagdiv6_hb || flagdiv1 || flagdiv2 || flagdiv3 || flagdiv4
				|| flagdiv5 || flagdiv7) {
			document.getElementById("div1").style.display = "block";
		} else {
			document.getElementById("div1").style.display = "none";
		}
	}
}

function feehpCondition() {
	var tagType = "7";
	var saleFlag = weaponSelectForm.getValue("SALE_FLAG");
	var returnHp = window.showModalDialog(
			"<%=request.getContextPath()%>/sale/promationTag/promationTag.jsp?tagType="
					+ tagType + "&orgid=" + orgid, "", "dialogWidth=800px");
	if (returnHp != null) {
		weaponSelectForm1.setColEditSts("PRESENT_BUSI3_AMOUNT", false);
		weaponSelectForm1.setColEditSts("REFERENCE_PRICE", false);
		weaponSelectForm1.setColEditSts("GOOD_ADOPT_DIRECTORY", false);
		weaponSelectForm1.setValue("PRESENT_BUSI3_AMOUNT",
				returnHp.split(",")[1]);
		weaponSelectForm1.setValue("REFERENCE_PRICE", returnHp.split(",")[5]);
		weaponSelectForm1.setValue("GOOD_ADOPT_DIRECTORY",
				returnHp.split(",")[4]);
		var state = returnHp.split(",")[2];
		wtid7 = returnHp.split(",")[3];
		var name = returnHp.split(",")[4];
		if (returnHp.split(",")[6] != "10") {
			isarea7 = true;
		}
		if (saleFlag != 31) {
			wtid2 = "";
			wtid6 = "";
			wtid6_hb="";
			isarea2 = false;
			isarea6 = false;
			isarea6_hb = false;
		}
		if (state == 99) {
			flagdiv7 = true;
		} else {
			flagdiv7 = false;
		}
		if (flagdiv6 || flagdiv6_hb || flagdiv1 || flagdiv2 || flagdiv3 || flagdiv4
				|| flagdiv5 || flagdiv7) {
			document.getElementById("div1").style.display = "block";
		} else {
			document.getElementById("div1").style.display = "none";
		}
	}
}

function addWeaponInfo() {
	var saleFlag = weaponSelectForm.getValue("SALE_FLAG");
	var netage1 = weaponSelectForm.getValue("MINNET_AGE");
	var netage2 = weaponSelectForm.getValue("MAXNET_AGE");
	var marketType = weaponSelectForm.getValue("MARKET_TYPE");
	var minNetAge = weaponSelectForm.getValue("MINNET_AGE");
	var maxNetAge = weaponSelectForm.getValue("MAXNET_AGE");
	var prAmount = weaponSelectForm1.getValue("PRESENT_REACH_AMOUNT");
	var prAccount = weaponSelectForm1.getValue("PRESTRORE_REACH_ACCOUNT");
	var wmName = saleWeaponMainframe.getValue("APPLY_NAME");
	var busi3 = weaponSelectForm1.getValue("PRESENT_BUSI3_AMOUNT");
	var adopt = weaponSelectForm1.getValue("GOOD_ADOPT_DIRECTORY");
	var rprice = weaponSelectForm1.getValue("REFERENCE_PRICE");
	var busi2 = weaponSelectForm1.getValue("ADD_MONTHCHARGE");
	var busi2_hb = weaponSelectForm1.getValue("ADD_MONTHCHARGE_HB");
	var zfqtype = weaponSelectForm1.getValue("RETURN_TYPE");
	var zfqtype_hb = weaponSelectForm1.getValue("RETURN_TYPE_HB");
	var datatype = weaponSelectForm1.getValue("DATA_BUSI_TYPE");
	var score = weaponSelectForm1.getValue("GLOBAL_SCORE");
	var remark2 = weaponSelectForm1.getValue("REMARK_2");
	var remark3 = weaponSelectForm1.getValue("REMARK_3");
	var lim_type = weaponSelectForm1.getValue("LIM_TYPE");
	//var attachCfgOpt = getAttachCfgOpt();
	weaponSelectForm1.setValue("STANDBY_NUM3", weaponSelectForm.getValue("STANDBY_NUM3"));
	if (saleFlag == "11" || saleFlag == "15") {
		if (remark2 == "" || remark3 == "") {
			return alert("请选择预存或者赠送的专款范围！");
		}
	}
	if (saleFlag == "13" || saleFlag == "12" || saleFlag == "14"
			|| saleFlag == "21" || saleFlag == "17" || saleFlag == "18") {
		if (remark3 == "") {
			return alert("请选择预存的专款范围！");
		}
	}

	if (saleFlag == "22" || saleFlag == "31" || saleFlag == "41") {
		if (remark2 == "") {
			return alert("请选择赠送的专款范围！");
		}
	}
	if (-1 > score) {
		return alert("积分输入有误！请重新输入!");
	}
	if ("-1" == score) {
		if (confirm("武器的积分确定执行清零操作?")) {
		} else {
			return;
		}
	}

	if (netage2 - netage1 < 0 || (netage1 == "" && netage2 == "")
			|| minNetAge < 0) {
		alert("网龄格式错误！");
		return false;
	}
	weaponSelectForm.setValue("NET_AGE", netage1 + "-" + netage2);
	var netAge = weaponSelectForm.getValue("NET_AGE");

	if (wmName == "") {
		alert("请输入必填信息！");
		return false;
	}
	if (saleFlag == 31 && datatype == "") {
		return alert("请选择数据包标识!");
	}
	//if(saleFlag==11){
	var err = showReachPre();
	var err1 = showReachfee();
	if (err == false || err1 == false) {
		return;
	}
	//}//else{
	//var err=showReachfee();
	//if(err==false){return;}
	//}
	showTag(saleFlag);//0920
	var weaponName = weaponSelectForm.getValue("WEAPON_NAME");

	if (weaponName == "") {
		return alert("请输入武器名称!");
	}

	if (saleFlag == 12) {
		if (busi2 == "" || zfqtype == "") {
			alert("请选择电子卷标识!");
			return;
		}
	}
	if (saleFlag == 18) {
		if (busi2_hb == "" || zfqtype_hb == "") {
			alert("请选择和包红包标识!");
			return;
		}
	}
	if (saleFlag == 17 || saleFlag == 23) {
		if (weaponSelectForm1.getValue("STANDBY_NUM2") == "")
			return alert("请选择赠送积分！");
	}
	//addWeaponMail();
	if (saleWeaponMainframe.getValue("APPLY_NAME") == "") {
		return alert("请输入工单名称!");
	}
	if ("O" != saleWeaponMainframe.getSts()) {
		//保存武器申请主表
		addWeaponMail();
		var id = weaponSelectForm1.getValue("MID");
		saleWeaponMainframe.setValue("ID", id);
		saleWeaponMainframe.refresh("&id=" + id);
		saleWeaponMainframe.setValue("APPLICANT", g_GetUserInfo().STAFF_ID,
				g_GetUserInfo().STAFF_NAME);
		saleWeaponMainframe.setValue("PRINCIPAL", g_GetUserInfo().STAFF_ID,
				g_GetUserInfo().STAFF_NAME);
		saleWeaponMainframe.setValue("PROMOTE_DEPART", g_GetUserInfo().ORG_ID,
				g_GetUserInfo().ORG_NAME);
		saleWeaponMainframe.setValue("ORG", g_GetUserInfo().ORG_ID,
				g_GetUserInfo().ORG_NAME);
	} else {

	}

	if (wmName == "") {
		alert("请输入必填信息！");
		return;
	} else {
		var xmlbody = weaponSelectForm.toXmlString();
		var xmlbody1 = weaponSelectForm1.toXmlString();
		var xml = "<RootInfo>" + xmlbody + xmlbody1 + "</RootInfo>";

		var list = new Array();
		var list1 = new Array();
		weaponSelectForm1.setValue("WEAPON_NAME", weaponName);
		weaponSelectForm1.setValue("MARKET_TYPE", marketType);
		weaponSelectForm1.setValue("NET_AGE", netAge);
		weaponSelectForm1.setValue("MINNET_AGE", minNetAge);
		weaponSelectForm1.setValue("MAXNET_AGE", maxNetAge);
		weaponSelectForm1.setValue("SALE_FLAG", saleFlag);
		list.push(weaponSelectForm1);
		if ("O" != weaponSelectForm1.getSts()) {
			if (saleFlag == 16 && "" == wtid7 && busi3 != "" && adopt != ""
					&& rprice != "") {
				var strUrlhp = _gModuleName
						+ '/business/com.asiainfo.sale.tag.web.DetailTagAction?action=saveDetailTagOnWeaponAdd&pid=0&busi3='
						+ busi3 + "&adopt=" + adopt + "&rprice=" + rprice
						+ "&saleFlag=" + saleFlag;
				var recodehp = PostInfo(strUrlhp, null);
				wtid8 = recodehp.getValueByName("wid");
			}
			if (saleFlag == 13 && "" == wtid7 && busi3 != "" && adopt != ""
					&& rprice != "") {
				var strUrlhp = _gModuleName
						+ '/business/com.asiainfo.sale.tag.web.DetailTagAction?action=saveDetailTagOnWeaponAdd&pid=0&busi3='
						+ busi3 + "&adopt=" + adopt + "&rprice=" + rprice
						+ "&saleFlag=" + saleFlag;
				var recodehp = PostInfo(strUrlhp, null);
				wtid7 = recodehp.getValueByName("wid");
			}
			var wtid = wtid1 + "," + wtid2 + "," + wtid3 + "," + wtid4 + ","
					+ wtid5 + "," + wtid6 +"," + wtid6_hb + "," + wtid7 + "," + wtid8 + ","
					+ wtid9;
			var strUrl = _gModuleName
					+ '/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=saveSaleWeaponMain&wtid='
					+ wtid + "&saleFlag=" + saleFlag + "&type=";
			var recode = saveRowSet(strUrl, list);
			var wmid = recode.getValueByName("WID");
			weaponSelectForm1.setValue("WID", wmid);
			weaponSelectForm.setValue("WID", wmid);
			if ("Y" == recode.getValueByName("FLAG")) {
				// g_AIButtonManager.get("query2").setDisabled(true);
				weaponSelectForm.setColEditSts("SALE_FLAG", false);
				g_AIButtonManager.get("query3").setDisabled(false);
				alert("操作成功!");
			}
			weaponSelectForm.refresh("&id=" + wmid);
			weaponSelectForm1.refresh("&id=" + wmid);
			table00.refresh("&mainId=" + saleWeaponMainframe.getValue("ID"));
			wtid1 = "";
			wtid2 = "";
			wtid3 = "";
			wtid4 = "";
			wtid5 = "";
			wtid6 = "";
			wtid6_hb = "";
			wtid7 = "";
			wtid8 = "";
			wtid9 = "";
		} else {
			//alert("数据没有改变，不需要保存!");
		}
	}
}

function commitWeaponInfo() {
	var approver = document.getElementById("opTypeId_a").value;//下一环节审批人工号
	if (approver == "") {
		return alert("请选择下一环节审批人！");
	}
	var wname = weaponSelectForm.getValue("WEAPON_NAME");
	weaponName = wname.replace("+", "%2B");
	var marketType = weaponSelectForm.getValue("MARKET_TYPE");
	var netAge = weaponSelectForm.getValue("NET_AGE");
	var saleFlag = weaponSelectForm.getValue("SALE_FLAG");
	var createTime = saleWeaponMainframe.getValue("CREATE_TIME");
	var wmid = weaponSelectForm1.getValue("MID");
	var wid = "";//weaponSelectForm1.getValue("WID");
	var list = new Array();
	if (weaponName == "" || createTime == "") {
		alert("请先保存！");
	} else {
		var wtid = wtid1 + "," + wtid2 + "," + wtid3 + "," + wtid4 + ","
				+ wtid5 + "," + wtid6 + "," + wtid6_hb + "," + wtid7;
		var count = table00.count();
		if (count > 0) {
			for ( var i = 0; i < count; i++) {
				wid = wid + table00.getValue(i, "ID") + ";";
			}
		}
		var strUrl = _gModuleName
				+ '/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=commitSaleWeapon&wtid='
				+ wtid + '&wid=' + wid + "&mid=" + wmid + "&weaponName="
				+ weaponName + "&approver=" + approver;
		var recode = PostInfo(strUrl);
		if ("C" == recode.getValueByName("FLAG")) { //0920
			return alert("已有相同武器申请中，请查询武器状态！");
		} else if ("W" == recode.getValueByName("FLAG")) {
			return alert("已有相同武器配置中，请查询武器后直接使用！");
		} else if ("U" == recode.getValueByName("FLAG")) {
			return alert("已有相同武器可用，请查询武器后直接使用！");
		} else if ("Y" == recode.getValueByName("FLAG")) {
			alert("提交成功！");
			location.reload();
		}
	}
}
function initDate() {
	for ( var i = 1; i < 21; i++) {
		var num = "tr" + i;
		document.getElementById(num).style.display = "none";
		
		document.getElementById("tdzs").style.display = "none";
		document.getElementById("tdzsdz").style.display = "none";
		document.getElementById("tdzshb").style.display = "none";
		document.getElementById("tdzshp").style.display = "none";
		document.getElementById("tryc").style.display = "none";
		document.getElementById("trzs").style.display = "none";
		document.getElementById("tr24").style.display = "none";
		document.getElementById("tr25").style.display = "none";
		document.getElementById("tr6_hb").style.display = "none";
		document.getElementById("tr24_hb").style.display = "none";
		document.getElementById("tr25_hb").style.display = "none";
	}
}
function movebusi() {
	table1.moveRow(22, 0);
	table1.moveRow(22, 0);
	table1.moveRow(22, 0);
}

var mflag;
function onSaleTypeChange(pFieldName, pOldVal, pOldText, pNewVal, pNewText) {
	if (pFieldName == "SALE_FLAG") {
		weaponSelectForm1.setColEditSts("B_LIMIT", false);
		weaponSelectForm1.setColEditSts("BACK_MONTH", false);
		weaponSelectForm1.setColEditSts("PRESENT_VALUE_PERMON", false);
		weaponSelectForm1.setColEditSts("PRESENT_BUSI_MONTH", false);
		weaponSelectForm1.setColEditSts("L_LIMIT", false);
		weaponSelectForm1.setColEditSts("BASE_MONTH", false);
		weaponSelectForm1.setColEditSts("LIM_TYPE", false);
		weaponSelectForm1.setColEditSts("PRESENT_REACH_AMOUNT", false);
		weaponSelectForm1.setColEditSts("PRESTRORE_REACH_ACCOUNT", false);
		weaponSelectForm1.setColEditSts("VALUE_PERMONTH", false);
		weaponSelectForm1.setColEditSts("OPEN_MONTH", false);
		weaponSelectForm1.setColEditSts("DATA_BUSI_TYPE", false);
		weaponSelectForm1.setColEditSts("DATA_FEE", false);
		weaponSelectForm1.setColEditSts("BUSI_TYPE", false);
		weaponSelectForm1.setColEditSts("PRESENT_BUSI4_AMOUNT", false);
		//weaponSelectForm1.setColEditSts("PRESENT_BUSI2_AMOUNT",false);
		weaponSelectForm.setColEditSts("WEAPON_NAME", false);//0920
		document.getElementById("clearBusi").style.display = "none";
		document.getElementById("sjyw1").style.display = "none";
		document.getElementById("sjyw2").style.display = "none";
		document.getElementById("sjyw2_hb").style.display = "none";
		document.getElementById("sjyw3").style.display = "none";
		document.getElementById("jfl_tr").style.display = "none";
		var saleType = weaponSelectForm.getValue("SALE_FLAG");
		weaponSelectForm1.newRow();
		initDate();
		if (saleType == 31) {
			mflag = true;
			if (mflag) {
				moveY(mflag);
			}
		} else {
			if (mflag) {
				moveY(mflag);
				mflag = false;
			}
		}
		if (saleType == 12) {
			weaponSelectForm1.setValue("RETURN_TYPE", "1");
			document.getElementById("tdzsdz").style.display = "block";
			document.getElementById("tryc").style.display = "block";
			document.getElementById("tr1").style.display = "block";
			document.getElementById("tr2").style.display = "block";
			document.getElementById("tr3").style.display = "block";
			document.getElementById("tr4").style.display = "block";
			document.getElementById("tr19").style.display = "block";
			document.getElementById("tr20").style.display = "block";
			document.getElementById("tr24").style.display = "block";
		}else if (saleType == 18) {
			weaponSelectForm1.setValue("RETURN_TYPE_HB", "1");
			document.getElementById("tdzshb").style.display = "block";
			document.getElementById("tryc").style.display = "block";
			document.getElementById("tr1").style.display = "block";
			document.getElementById("tr2").style.display = "block";
			document.getElementById("tr3").style.display = "block";
			document.getElementById("tr4").style.display = "block";
			document.getElementById("tr19").style.display = "block";
			document.getElementById("tr20").style.display = "block";
			document.getElementById("tr24_hb").style.display = "block";
		} else if (saleType == 13 || saleType == 16) {
			if (saleType == 16) {
				document.getElementById("tdzshp").style.display = "none";
			} else {
				document.getElementById("tdzshp").style.display = "block";
			}
			document.getElementById("tdzshp").style.display = "block";
			document.getElementById("tr1").style.display = "block";
			document.getElementById("tryc").style.display = "block";
			document.getElementById("tr2").style.display = "block";
			document.getElementById("tr3").style.display = "block";
			//document.getElementById("tr4").style.display="block";
			//document.getElementById("tr8").style.display="block";
			//document.getElementById("tr9").style.display="block";
			document.getElementById("tr19").style.display = "block";
			document.getElementById("tr20").style.display = "block";
		} else if (saleType == 14) {
			document.getElementById("tr1").style.display = "block";
			document.getElementById("tryc").style.display = "block";
			document.getElementById("tr2").style.display = "block";
			document.getElementById("tr3").style.display = "block";
			document.getElementById("tr15").style.display = "block";
			document.getElementById("tr16").style.display = "block";
			document.getElementById("tr19").style.display = "block";
			document.getElementById("tr20").style.display = "block";
		} else if (saleType == 15) {
			weaponSelectForm.setColEditSts("WEAPON_NAME", true); //0920
			document.getElementById("clearBusi").style.display = "block";
			document.getElementById("sjyw1").style.display = "block";
			document.getElementById("sjyw2").style.display = "block";
			document.getElementById("sjyw2_hb").style.display = "block";
			document.getElementById("sjyw3").style.display = "block";
			document.getElementById("tr18").style.display = "block";
			weaponSelectForm1.setColEditSts("ADD_MONTHCHARGE", true);
			weaponSelectForm1.setColEditSts("ADD_MONTHCHARGE_HB", true);
			document.getElementById("showzfq").style.display = "none";
			document.getElementById("showzfq_hb").style.display = "none";
			document.getElementById("tr1").style.display = "block";
			document.getElementById("tryc").style.display = "block";
			document.getElementById("tr2").style.display = "block";
			document.getElementById("tr3").style.display = "block";
			document.getElementById("tr4").style.display = "block";
			document.getElementById("tr5").style.display = "block";
			document.getElementById("trzs").style.display = "block";
			document.getElementById("tr6").style.display = "block";
			document.getElementById("tr6_hb").style.display = "block";
			//document.getElementById("tr8").style.display="block";
			//document.getElementById("tr9").style.display="block";
			document.getElementById("tr15").style.display = "block";
			document.getElementById("tr16").style.display = "block";
			document.getElementById("tr18").style.display = "block";
			document.getElementById("tr19").style.display = "block";
			document.getElementById("tr20").style.display = "block";
			document.getElementById("tr24").style.display = "block";
			document.getElementById("tr24_hb").style.display = "block";
			document.getElementById("tr25").style.display = "block";
			document.getElementById("tr25_hb").style.display = "block";
		} else if (saleType == 21) {
			weaponSelectForm.setColEditSts("WEAPON_NAME", true);//0920
			document.getElementById("tr1").style.display = "block";
			document.getElementById("tryc").style.display = "block";
			document.getElementById("tr2").style.display = "block";
			document.getElementById("tr3").style.display = "block";
			document.getElementById("tr4").style.display = "block";
			document.getElementById("tr10").style.display = "block";
			document.getElementById("tr11").style.display = "block";
			document.getElementById("tr12").style.display = "block";
			document.getElementById("tr19").style.display = "block";
			document.getElementById("tr20").style.display = "block";
		} else if (saleType == 22 || saleType == 23) {
			weaponSelectForm.setColEditSts("WEAPON_NAME", true);//0920
			document.getElementById("tr4").style.display = "block";
			document.getElementById("tr5").style.display = "block";
			document.getElementById("trzs").style.display = "block";
			document.getElementById("tr18").style.display = "block";
			document.getElementById("tr10").style.display = "block";
			document.getElementById("tr11").style.display = "block";
			document.getElementById("tr12").style.display = "block";
			document.getElementById("tr19").style.display = "block";
			document.getElementById("tr20").style.display = "block";
			if (saleType == 23) {
				document.getElementById("jfl_tr").style.display = "block";
				document.getElementById("tr5").style.display = "none";
				document.getElementById("trzs").style.display = "none";
				document.getElementById("tr18").style.display = "none"
			} else {
				document.getElementById("tdzs").style.display = "block";
			}

		} else if (saleType == 31) {
			document.getElementById("clearBusi").style.display = "block";
			document.getElementById("sjyw1").style.display = "block";
			document.getElementById("sjyw2").style.display = "block";
			document.getElementById("sjyw2_hb").style.display = "block";
			document.getElementById("sjyw3").style.display = "block";
			document.getElementById("tr18").style.display = "block";
			weaponSelectForm1.setColEditSts("ADD_MONTHCHARGE", false);
			weaponSelectForm1.setColEditSts("ADD_MONTHCHARGE_HB", false);
			document.getElementById("tr4").style.display = "block";
			document.getElementById("tr5").style.display = "block";
			document.getElementById("trzs").style.display = "block";
			document.getElementById("tr6").style.display = "block";
			document.getElementById("tr6_hb").style.display = "block";
			//document.getElementById("tr8").style.display="block";
			//document.getElementById("tr9").style.display="block";
			document.getElementById("tr15").style.display = "block";
			document.getElementById("tr16").style.display = "block";
			document.getElementById("showzfq").style.display = "none";
			document.getElementById("showzfq_hb").style.display = "none";
			document.getElementById("tr24").style.display = "block";
			document.getElementById("tr24_hb").style.display = "block";
			document.getElementById("tr25").style.display = "block";
			document.getElementById("tr25_hb").style.display = "block";

		} else if (saleType == 41) {
			document.getElementById("clearBusi").style.display = "block";
			document.getElementById("sjyw1").style.display = "block";
			document.getElementById("sjyw2").style.display = "block";
			document.getElementById("sjyw2_hb").style.display = "block";
			document.getElementById("sjyw3").style.display = "block";
			document.getElementById("tr18").style.display = "block";
			weaponSelectForm.setColEditSts("WEAPON_NAME", true);//0920
			document.getElementById("tr4").style.display = "block";
			document.getElementById("tr5").style.display = "block";
			document.getElementById("trzs").style.display = "block";
			//document.getElementById("tr8").style.display="block";
			//document.getElementById("tr9").style.display="block";
			document.getElementById("tr13").style.display = "block";
			document.getElementById("tr14").style.display = "block";
			document.getElementById("tr15").style.display = "block";
			document.getElementById("tr16").style.display = "block";
			document.getElementById("tr24").style.display = "block";
			document.getElementById("tr24_hb").style.display = "block";
			document.getElementById("tr25").style.display = "block";
			document.getElementById("tr25_hb").style.display = "block";
			document.getElementById("jfl_tr").style.display = "block";
		} else if (saleType == 17) {
			//document.getElementById("tdzs").style.display = "block";
			document.getElementById("tr1").style.display = "block";
			document.getElementById("tryc").style.display = "block";
			document.getElementById("tr2").style.display = "block";
			document.getElementById("tr3").style.display = "block";
			document.getElementById("tr4").style.display = "block";
			//document.getElementById("tr5").style.display="block";
			//document.getElementById("trzs").style.display="block";
			document.getElementById("tr19").style.display = "block";
			document.getElementById("tr20").style.display = "block";
			document.getElementById("jfl_tr").style.display = "block";
			//document.getElementById("tr18").style.display="block";
			document.getElementById("tdzs").style.display = "none";
		} else {
			weaponSelectForm.setValue("SALE_FLAG", 11);
			document.getElementById("tdzs").style.display = "block";
			document.getElementById("tr1").style.display = "block";
			document.getElementById("tryc").style.display = "block";
			document.getElementById("tr2").style.display = "block";
			document.getElementById("tr3").style.display = "block";
			document.getElementById("tr4").style.display = "block";
			document.getElementById("tr5").style.display = "block";
			document.getElementById("trzs").style.display = "block";
			document.getElementById("tr19").style.display = "block";
			document.getElementById("tr20").style.display = "block";
			document.getElementById("tr18").style.display = "block";
		}
	}
	var newMainid = saleWeaponMainframe.getValue("ID");
	weaponSelectForm1.setValue("MID", newMainid);
	weaponSelectForm.setValue("MID", newMainid);
}

function onReturnTypeChange(pFieldName, pOldVal, pOldText, pNewVal, pNewText) {
	if (pFieldName == "RETURN_TYPE") {
		var rtype = weaponSelectForm1.getValue("RETURN_TYPE");
		document.getElementById("td6").style.display = "block";
		document.getElementById("td7").style.display = "block";
		weaponSelectForm1.setValue("FIRSTCHARGE", "");
		weaponSelectForm1.setValue("LASTCHARGE", "");
		weaponSelectForm1.setValue("STANDBY_NUM1", "");
		weaponSelectForm1.setValue("PRESENT_BUSI2_AMOUNT", "0");
		document.getElementById("td6").innerHTML = "每月金额：";
		if (rtype == "1") {
			document.getElementById("tr25").style.display = "none";
			document.getElementById("tr6").style.display = "none";
		}
		if (rtype == "2") {
			document.getElementById("tr25").style.display = "none";
			document.getElementById("tr6").style.display = "block";
			document.getElementById("td6").innerHTML = "每月返还：";
		}
		if (rtype == "3") {
			document.getElementById("tr25").style.display = "none";
			document.getElementById("tr6").style.display = "block";
			document.getElementById("td6").innerHTML = "每月增加值：";
		}
		if (rtype == "4") {
			document.getElementById("tr25").style.display = "block";
			document.getElementById("tr6").style.display = "block";
			// document.getElementById("td6").style.display="none";
			// document.getElementById("td7").style.display="none";
		}
		var newMainid = saleWeaponMainframe.getValue("ID");
		weaponSelectForm1.setValue("MID", newMainid);
		weaponSelectForm.setValue("MID", newMainid);
	}else if(pFieldName == "RETURN_TYPE_HB"){
		var rtype = weaponSelectForm1.getValue("RETURN_TYPE_HB");
		document.getElementById("td6_hb").style.display = "block";
		document.getElementById("td7_hb").style.display = "block";
		weaponSelectForm1.setValue("FIRSTCHARGE_HB", "");
		weaponSelectForm1.setValue("LASTCHARGE_HB", "");
		weaponSelectForm1.setValue("STANDBY_NUM1_HB", "");
		weaponSelectForm1.setValue("PRESENT_BUSI2_AMOUNT_HB", "0");
		document.getElementById("td6_hb").innerHTML = "每月金额：";
		if (rtype == "1") {
			document.getElementById("tr25_hb").style.display = "none";
			document.getElementById("tr6_hb").style.display = "none";
		}
		if (rtype == "2") {
			document.getElementById("tr25_hb").style.display = "none";
			document.getElementById("tr6_hb").style.display = "block";
			document.getElementById("td6_hb").innerHTML = "每月返还：";
		}
		if (rtype == "3") {
			document.getElementById("tr25_hb").style.display = "none";
			document.getElementById("tr6_hb").style.display = "block";
			document.getElementById("td6_hb").innerHTML = "每月增加值：";
		}
		if (rtype == "4") {
			document.getElementById("tr25_hb").style.display = "block";
			document.getElementById("tr6_hb").style.display = "block";
			// document.getElementById("td6").style.display="none";
			// document.getElementById("td7").style.display="none";
		}
		var newMainid = saleWeaponMainframe.getValue("ID");
		weaponSelectForm1.setValue("MID", newMainid);
		weaponSelectForm.setValue("MID", newMainid);
	}
}

function showTag(tag) {
	var yname = "";
	var zname = "";
	var bname = "";
	var cname = "";
	var jname = "";
	var pfee = weaponSelectForm1.getValue("PRESTORE_FEE");
	var paccount = weaponSelectForm1.getValue("PRESTRORE_REACH_ACCOUNT");
	var blimt = weaponSelectForm1.getValue("B_LIMIT");
	var bmonth = weaponSelectForm1.getValue("BACK_MONTH");
	var bamonth = weaponSelectForm1.getValue("PRESENT_BUSI_AMOUNT");
	var pamonth = weaponSelectForm1.getValue("PRESENT_REACH_AMOUNT");
	var permon = weaponSelectForm1.getValue("PRESENT_VALUE_PERMON");
	var prmonth = weaponSelectForm1.getValue("PRESENT_BUSI_MONTH");
	var basemonth = weaponSelectForm1.getValue("BASE_MONTH");
	var dtype = weaponSelectForm1.getValue("DATA_BUSI_TYPE");
	var score = weaponSelectForm1.getValue("GLOBAL_SCORE");
	var dzmount = weaponSelectForm1.getValue("ADD_MONTHCHARGE");
	var dzmount_hb = weaponSelectForm1.getValue("ADD_MONTHCHARGE_HB");
	var hpmount = weaponSelectForm1.getValue("PRESENT_BUSI3_AMOUNT");
	var ywtype = weaponSelectForm1.getValue("BUSI_TYPE");
	var limit = weaponSelectForm1.getValue("L_LIMIT");
	var limitType = weaponSelectForm1.getValue("LIM_TYPE");
	var rtype = weaponSelectForm1.getValue("RETURN_TYPE");
	var rtype_hb = weaponSelectForm1.getValue("RETURN_TYPE_HB");

	if (tag == 11 || tag == 12 || tag == 18 || tag == 13 || tag == 14 || tag == 16
			|| tag == 17 || tag == 31) {
		if (pfee != "") {
			if (wtid4 == "" || blimt == 0) {
				if (isarea1 || isarea2 || isarea3 || isarea4 || isarea5
						|| isarea6 || isarea6_hb || isarea7 == true) {
					//findTown(g_GetUserInfo().ORG_ID.substr(0,2));
					weaponSelectForm1.setValue("REMARK_4",
							g_GetUserInfo().ORG_ID.substr(0, 2));
					yname = "(" + weaponSelectForm1.getDisplayText("REMARK_4")
							+ ")预存" + pfee + "(一次性到账,"
							+ weaponSelectForm1.getDisplayText("REMARK_3")
							+ ");";
				} else {
					weaponSelectForm1.setValue("REMARK_4", "10");
					yname = "预存" + pfee + "(一次性到账" + ","
							+ weaponSelectForm1.getDisplayText("REMARK_3")
							+ ");";
				}
				//yname="预存"+pfee+"(一次性到账)";isarea2
			} else {
				if (isarea1 || isarea2 || isarea3 || isarea4 || isarea5
						|| isarea6 || isarea6_hb || isarea7 == true) {
					//findTown(g_GetUserInfo().ORG_ID.substr(0,2));
					weaponSelectForm1.setValue("REMARK_4",
							g_GetUserInfo().ORG_ID.substr(0, 2));
					yname = "(" + weaponSelectForm1.getDisplayText("REMARK_4")
							+ ")预存" + pfee + "(" + paccount + "+" + blimt + "*"
							+ bmonth + "个月,"
							+ weaponSelectForm1.getDisplayText("REMARK_3")
							+ ");";
				} else {
					weaponSelectForm1.setValue("REMARK_4", "10");
					yname = "预存" + pfee + "(" + paccount + "+" + blimt + "*"
							+ bmonth + "个月,"
							+ weaponSelectForm1.getDisplayText("REMARK_3")
							+ ");";
				}
				//yname="预存"+pfee+"("+paccount+"+"+blimt+"*"+bmonth+"个月)";
			}
		} else {
			if (isarea1 || isarea2 || isarea3 || isarea4 || isarea5 || isarea6
					|| isarea7 == true) {
				//findTown(g_GetUserInfo().ORG_ID.substr(0,2));
				weaponSelectForm1.setValue("REMARK_4", g_GetUserInfo().ORG_ID
						.substr(0, 2));
			} else {
				weaponSelectForm1.setValue("REMARK_4", "10");
			}
			yname = "预存0(一次性到帐," + weaponSelectForm1.getDisplayText("REMARK_3")
					+ ");";
		}
		if (tag == 11 || tag == 31) {
			if (bamonth != "") {
				if (wtid2 == "" || permon == 0) {
					zname = zname + "送" + bamonth + "(一次性到账,"
							+ weaponSelectForm1.getDisplayText("REMARK_2")
							+ ");";
				} else {
					if (pamonth == 0 || pamonth == "") {
						zname = zname + "送" + bamonth + "(" + permon + "*"
								+ prmonth + "个月,"
								+ weaponSelectForm1.getDisplayText("REMARK_2")
								+ ");";
					} else {
						zname = zname + "送" + bamonth + "(" + pamonth + "+"
								+ permon + "*" + prmonth + "个月,"
								+ weaponSelectForm1.getDisplayText("REMARK_2")
								+ ");";
					}
				}
			}
		}
		if (tag == 17) {
			zname = zname + "送"
					+ weaponSelectForm1.getDisplayText("STANDBY_NUM2") + "积分;";
		}
		if (tag == 12 || tag == 31 || tag == 18 ) {
			if (wtid6 != "" && dzmount != "" && dzmount != 0) {
				if (rtype == "1") {
					zname = zname + "送" + dzmount + "电子券;";
				} else if (rtype == "2") {
					var rnum = weaponSelectForm1.getValue("STANDBY_NUM1");
					var rmoney = weaponSelectForm1
							.getValue("PRESENT_BUSI2_AMOUNT");
					zname = zname + "送" + rnum + "*" + rmoney + "电子券;";
				} else if (rtype == "3") {
					var rnum = weaponSelectForm1.getValue("STANDBY_NUM1");
					var rmoney = weaponSelectForm1
							.getValue("PRESENT_BUSI2_AMOUNT");
					if (rnum > 3) {
						zname = zname + "送" + rmoney + "+" + rmoney * 2 + "+"
								+ "..." + "+" + rmoney * rnum + "电子券;";
					} else if (rnum = 3) {
						zname = zname + "送" + rmoney + "+" + rmoney * 2 + "+"
								+ rmoney * rnum + "电子券;";
					} else if (rnum = 2) {
						zname = zname + "送" + rmoney + "+" + rmoney * 2
								+ "电子券;";
					} else {
						zname = zname + "送" + rmoney + "电子券;";
					}
				} else if (rtype == "4") {
					var rnum = weaponSelectForm1.getValue("STANDBY_NUM1");
					var rmoney = weaponSelectForm1
							.getValue("PRESENT_BUSI2_AMOUNT");
					var fmonry = weaponSelectForm1.getValue("FIRSTCHARGE");
					var lmoney = weaponSelectForm1.getValue("LASTCHARGE");
					zname = zname + "送" + fmonry + "+"
							+ (dzmount - fmonry - lmoney) / rnum + "*" + rnum
							+ "+" + lmoney + "电子券;";
				}
			}
			
			if (wtid6_hb != "" && dzmount_hb != "" && dzmount_hb != 0) {
				if (rtype_hb == "1") {
					zname = zname + "送" + dzmount + "和包红包;";
				} else if (rtype_hb == "2") {
					var rnum = weaponSelectForm1.getValue("STANDBY_NUM1_HB");
					var rmoney = weaponSelectForm1
							.getValue("PRESENT_BUSI2_AMOUNT_HB");
					zname = zname + "送" + rnum + "*" + rmoney + "和包红包;";
				} else if (rtype_hb == "3") {
					var rnum = weaponSelectForm1.getValue("STANDBY_NUM1_HB");
					var rmoney = weaponSelectForm1
							.getValue("PRESENT_BUSI2_AMOUNT_HB");
					if (rnum > 3) {
						zname = zname + "送" + rmoney + "+" + rmoney * 2 + "+"
								+ "..." + "+" + rmoney * rnum + "和包红包;";
					} else if (rnum = 3) {
						zname = zname + "送" + rmoney + "+" + rmoney * 2 + "+"
								+ rmoney * rnum + "和包红包;";
					} else if (rnum = 2) {
						zname = zname + "送" + rmoney + "+" + rmoney * 2
								+ "和包红包;";
					} else {
						zname = zname + "送" + rmoney + "和包红包;";
					}
				} else if (rtype_hb == "4") {
					var rnum = weaponSelectForm1.getValue("STANDBY_NUM1_HB");
					var rmoney = weaponSelectForm1
							.getValue("PRESENT_BUSI2_AMOUNT_HB");
					var fmonry = weaponSelectForm1.getValue("FIRSTCHARGE_HB");
					var lmoney = weaponSelectForm1.getValue("LASTCHARGE_HB");
					zname = zname + "送" + fmonry + "+"
							+ (dzmount_hb - fmonry - lmoney) / rnum + "*" + rnum
							+ "+" + lmoney + "和包红包;";
				}
			}
			
			if (dzmount == 0 && dzmount != "") {
				zname = zname + "送电子提货券;";
			}
		}
		if (tag == 13) {
			zname = zname + "送货品;";
		}
		if (tag == 14 || tag == 31) {
			if (wtid5 != "" && ywtype != "") {
				zname = zname + "送" + ywtype + ";";
			}
		}
		if (tag == 16) {
			if (hpmount != "" && hpmount != 0) {
				zname = "送价值" + hpmount + "提货卷;";
			}
		}
		if (wtid1 != "" && limit != 0) {
			if(limitType!=""){
				bname = "保底" + limit + "元(" + basemonth + "个月,"+limitType+"保底);";
			}else{
				bname = "保底" + limit + "元(" + basemonth + "个月);";
			}
		}
		if (wtid3 != "") {
			cname = dtype + ";";
		}
		if (score != "") {
			if (score != "-1") {
				jname = "扣减" + score + "积分;";
			} else {
				jname = "积分清零;";
			}
		}
		var allname = "";
		if (tag == 31) {
			allname = cname + zname + bname + jname;
		} else if (tag == 16) {
			allname = "(" + g_GetUserInfo().STAFF_NAME + ")" + yname + zname
					+ bname + cname + jname;
		} else if (tag == 13) {
			allname = yname + bname + cname + jname + zname;
		} else {
			allname = yname + zname + bname + cname + jname;
		}
		weaponSelectForm.setValue("WEAPON_NAME", allname);
	} else {
		if (isarea1 || isarea2 || isarea3 || isarea4 || isarea5 || isarea6 || isarea6_hb
				|| isarea7 == true) {
			//findTown(g_GetUserInfo().ORG_ID.substr(0,2));
			weaponSelectForm1.setValue("REMARK_4", g_GetUserInfo().ORG_ID
					.substr(0, 2));
		} else {
			weaponSelectForm1.setValue("REMARK_4", "10");
		}
	}

}

function findTown(stateTown) {
	if (stateTown == "11") {
		weaponSelectForm1.setValue("REMARK_4", "武汉");
	} else if (stateTown == "12") {
		weaponSelectForm1.setValue("REMARK_4", "黄石");
	} else if (stateTown == "13") {
		weaponSelectForm1.setValue("REMARK_4", "鄂州");
	} else if (stateTown == "14") {
		weaponSelectForm1.setValue("REMARK_4", "宜昌");
	} else if (stateTown == "15") {
		weaponSelectForm1.setValue("REMARK_4", "恩施");
	} else if (stateTown == "16") {
		weaponSelectForm1.setValue("REMARK_4", "十堰");
	} else if (stateTown == "17") {
		weaponSelectForm1.setValue("REMARK_4", "襄阳");
	} else if (stateTown == "18") {
		weaponSelectForm1.setValue("REMARK_4", "江汉");
	} else if (stateTown == "19") {
		weaponSelectForm1.setValue("REMARK_4", "咸宁");
	} else if (stateTown == "20") {
		weaponSelectForm1.setValue("REMARK_4", "荆州");
	} else if (stateTown == "23") {
		weaponSelectForm1.setValue("REMARK_4", "荆门");
	} else if (stateTown == "24") {
		weaponSelectForm1.setValue("REMARK_4", "随州");
	} else if (stateTown == "25") {
		weaponSelectForm1.setValue("REMARK_4", "黄冈");
	} else if (stateTown == "26") {
		weaponSelectForm1.setValue("REMARK_4", "孝感");
	}
}

function moveY(mflag) {
	if (mflag) {
		setSiteUp(1);
		setSiteUp(2);
		setSiteUp(3);
	}
}

function setSiteUp(id) {
	var _trObj = document.getElementById('tr2' + id);
	var _trObj1 = document.getElementById('tr' + id);
	var _trRow = _trObj1.rowIndex;
	_trObj.swapNode(tab.rows[_trRow]);
}

function addWeaponMail() {
	//var wmid=weaponSelectForm1.getValue("WID");
	var staffId = g_GetUserInfo().STAFF_ID;
	// saleWeaponMainframe.setValue("ID",wmid);
	//  saleWeaponMainframe.setValue("WID",wmid);
	saleWeaponMainframe.setValue("APPLICANT", g_GetUserInfo().STAFF_ID,
			g_GetUserInfo().STAFF_NAME);
	saleWeaponMainframe.setValue("ORG", g_GetUserInfo().ORG_ID,
			g_GetUserInfo().ORG_NAME);
	var xmlbody = saleWeaponMainframe.toXmlString();
	var xml = "<RootInfo>" + xmlbody + "</RootInfo>";
	var list = new Array();
	list.push(saleWeaponMainframe);
	var strUrl = _gModuleName + '/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=saveSaleWeaponMainA&delid=0';
	var recode = saveRowSet(strUrl, list);
	var mid = recode.getValueByName("MID");
	weaponSelectForm1.setValue("MID", mid);
	if ("Y" == recode.getValueByName("FLAG")) {
	}
}

function showReachfee() {
	var presentFee = weaponSelectForm1.getValue("PRESTORE_FEE");
	var bLimit = weaponSelectForm1.getValue("B_LIMIT");
	var backMonth = weaponSelectForm1.getValue("BACK_MONTH");
	if (presentFee != "") {
		if (bLimit != "") {
			if (presentFee < bLimit * backMonth) {
				alert("预存话费不能小于分月返还总金额!");
				return false;
			} else {
				weaponSelectForm1.setValue("PRESTRORE_REACH_ACCOUNT",
						presentFee - (bLimit * backMonth));
			}
		} else {
			weaponSelectForm1.setValue("PRESTRORE_REACH_ACCOUNT", presentFee);
		}
	} else {
		if (bLimit != "") {
			alert("请输入预存话费金额!");
			return false;
		}
	}
}

function showReachPre() {
	var presentBusiAmount = weaponSelectForm1.getValue("PRESENT_BUSI_AMOUNT");
	var presentValuePermon = weaponSelectForm1.getValue("PRESENT_VALUE_PERMON");
	var presentBusiMonth = weaponSelectForm1.getValue("PRESENT_BUSI_MONTH");
	if (presentBusiAmount != "") {
		if (presentValuePermon != "") {
			if (presentBusiAmount < parseFloat((presentValuePermon * presentBusiMonth).toFixed(2))) {
				alert("增送话费不能小于分月返还总金额!");
				return false;
			} else {
				weaponSelectForm1.setValue("PRESENT_REACH_AMOUNT",
						presentBusiAmount
								- parseFloat((presentValuePermon * presentBusiMonth).toFixed(2)));
			}
		} else {
			weaponSelectForm1.setValue("PRESENT_REACH_AMOUNT",
					presentBusiAmount);
		}
	} else {
		if (presentValuePermon != "") {
			alert("请输入赠送话费金额!");
			return false;
		}
	}
}

function showReach() {
	showReachfee();
	showReachPre();
}
function addWeaponInfoNew() {
	if (window.confirm("新建武器信息会清空未保存的武器信息，确定要新建吗？")) {
		location.reload();
		g_AIButtonManager.get("query2").setDisabled(false);
		g_AIButtonManager.get("query3").setDisabled(true);
	}
}

function clearPrep() {
	wtid4 = "";
	area4 = false;
	flagdiv4 = false;
	weaponSelectForm1.setValue("PRESTRORE_REACH_ACCOUNT", "");
	weaponSelectForm1.setValue("B_LIMIT", "");
	weaponSelectForm1.setValue("BACK_MONTH", "");
	weaponSelectForm1.setValue("PRESTORE_FEE", "");
	weaponSelectForm1.setValue("REMARK_3", "");
	document.getElementById("selectOrgTypeYCZK").style.display = "block";
	document.getElementById("div1").style.display = "none";
}

function clearFee() {
	weaponSelectForm1.setValue("PRESENT_REACH_AMOUNT", "");
	weaponSelectForm1.setValue("PRESENT_VALUE_PERMON", "");
	weaponSelectForm1.setValue("PRESENT_BUSI_MONTH", "");
	weaponSelectForm1.setValue("PRESENT_BUSI_AMOUNT", "");
	weaponSelectForm1.setValue("PRESENT_BUSI4_AMOUNT", "");
	weaponSelectForm1.setValue("PRESENT_BUSI2_AMOUNT", "0");
	weaponSelectForm1.setValue("PRESENT_BUSI2_AMOUNT_HB", "0");
	weaponSelectForm1.setValue("BUSI_TYPE", "");
	weaponSelectForm1.setValue("ADD_MONTHCHARGE", "");
	weaponSelectForm1.setValue("ADD_MONTHCHARGE_HB", "");
	weaponSelectForm1.setValue("RETURN_TYPE", "");
	weaponSelectForm1.setValue("RETURN_TYPE_HB", "");
	weaponSelectForm1.setValue("FIRSTCHARGE", "");
	weaponSelectForm1.setValue("FIRSTCHARGE_HB", "");
	weaponSelectForm1.setValue("LASTCHARGE", "");
	weaponSelectForm1.setValue("LASTCHARGE_HB", "");
	weaponSelectForm1.setValue("STANDBY_NUM1", "");
	weaponSelectForm1.setValue("STANDBY_NUM1_HB", "");
	weaponSelectForm1.setValue("PRESENT_BUSI3_AMOUNT", "");
	weaponSelectForm1.setValue("REFERENCE_PRICE", "");
	weaponSelectForm1.setValue("GOOD_ADOPT_DIRECTORY", "");
	weaponSelectForm1.setColEditSts("PRESENT_BUSI3_AMOUNT", true);
	weaponSelectForm1.setColEditSts("REFERENCE_PRICE", true);
	weaponSelectForm1.setColEditSts("GOOD_ADOPT_DIRECTORY", true);
	wtid2 = "";
	area2 = false;
	flagdiv2 = false;
	wtid6 = "";
	wtid6_hb = "";
	area6 = false;
	flagdiv6 = false;
	flagdiv6_hb = false;
	wtid7 = "";
	area7 = false;
	flagdiv7 = false;
	wtid5 = "";
	area5 = false;
	flagdiv5 = false;
	weaponSelectForm1.setValue("REMARK_2", "");
	document.getElementById("selectOrgTypeZSZK").style.display = "block";
	document.getElementById("div1").style.display = "none";

}

function clearjfl() {
	wtid9 = "";
	area9 = false;
	flagdiv9 = false;
	weaponSelectForm1.setValue("STANDBY_NUM2", "");
	document.getElementById("div1").style.display = "none";
}

function clearBusi() {
	weaponSelectForm1.setValue("DATA_FEE", "");
	weaponSelectForm1.setValue("DATA_BUSI_TYPE", "");
	weaponSelectForm1.setValue("VALUE_PERMONTH", "");
	weaponSelectForm1.setValue("OPEN_MONTH", "");
	wtid3 = "";
	area3 = false;
	flagdiv3 = false;
	document.getElementById("div1").style.display = "none";
}

function clearBase() {
	weaponSelectForm1.setValue("L_LIMIT", "");
	weaponSelectForm1.setValue("BASE_MONTH", "");
	weaponSelectForm1.setValue("LIM_TYPE", "");
	wtid1 = "";
	area1 = false;
	flagdiv1 = false;
	document.getElementById("div1").style.display = "none";
}

function clearScore() {
	weaponSelectForm1.setColEditSts("GLOBAL_SCORE", false);
	weaponSelectForm1.setValue("GLOBAL_SCORE", "-1");
}

function clearScoreButton() {
	weaponSelectForm1.setValue("GLOBAL_SCORE", "");
	weaponSelectForm1.setColEditSts("GLOBAL_SCORE", true);
}

function zkfwCondition() {
	var returnzk = window
			.showModalDialog(
					"<%=request.getContextPath()%>/sale/promationTag/SalestaticDate.jsp?codeType='acctypey'",
					"", "dialogWidth=500px");
	if (returnzk != undefined) {
		weaponSelectForm1.setValue("REMARK_3", returnzk);
		weaponSelectForm1.setValue("DYNAMIC_SCORE", returnzk);
	}
}

function zkfwConditionz() {
	var returnzk = window
			.showModalDialog(
					"<%=request.getContextPath()%>/sale/promationTag/SalestaticDate.jsp?codeType='acctypez'",
					"", "dialogWidth=500px");
	if (returnzk != undefined) {
		weaponSelectForm1.setValue("REMARK_2", returnzk);
		weaponSelectForm1.setValue("HOME_SCORE", returnzk);
	}
}

function ycTagItem() {
	var item_type = weaponSelectForm1.getValue("REMARK_3");
	if (item_type != "") {
		window.showModalDialog(
				"<%=request.getContextPath()%>/sale/promationTag/tagitem.jsp?item_type="
						+ item_type, "", "dialogWidth=500px");
	}
}

function zsTagItem() {
	var item_type = weaponSelectForm1.getValue("REMARK_2");
	if (item_type != "") {
		window.showModalDialog(
				"<%=request.getContextPath()%>/sale/promationTag/tagitem.jsp?item_type="
						+ item_type, "", "dialogWidth=500px");
	}
}

function showApplyMain(oldIndex, newIndex) {
	if (-1 != oldIndex) {
		table00.setRowBgColor(oldIndex, "");
	}
	table00.setRowBgColor(newIndex, "yellow");
	var applyid = table00.getValue(newIndex, "ID");
	if (applyid != null && applyid != "") {
		weaponSelectForm.refresh("&id=" + applyid);
		onSaleTypeChange("SALE_FLAG", "", "", "", "");
		weaponSelectForm.setColEditSts("SALE_FLAG", false);
		weaponSelectForm1.refresh("&id=" + applyid);
	}
}

function addNewModle() {
	if (saleWeaponMainframe.getValue("APPLY_NAME") == "") {
		return alert("请输入工单名称!");
	}
	weaponSelectForm.newRow();
	weaponSelectForm1.newRow();
	weaponSelectForm.setValue("SALE_FLAG", 11);
	weaponSelectForm.setColEditSts("SALE_FLAG", true);
	weaponSelectForm.refreshListBox("MARKET_TYPE", "codeType=markets", true);
	weaponSelectForm.refreshListBox("SALE_FLAG", "codeType=hdlxs", true);
	clearAttachCfgOpt();
	var newMainid = saleWeaponMainframe.getValue("ID");
	if (saleWeaponMainframe.getValue("ID") == "") {
		if ("O" != saleWeaponMainframe.getSts()) {
			//保存武器申请主表
			addWeaponMail();
			var id = weaponSelectForm1.getValue("MID");
			saleWeaponMainframe.setValue("ID", id);
			saleWeaponMainframe.refresh("&id=" + id);
			saleWeaponMainframe.setValue("APPLICANT", g_GetUserInfo().STAFF_ID,
					g_GetUserInfo().STAFF_NAME);
			saleWeaponMainframe.setValue("PRINCIPAL", g_GetUserInfo().STAFF_ID,
					g_GetUserInfo().STAFF_NAME);
			saleWeaponMainframe.setValue("PROMOTE_DEPART",
					g_GetUserInfo().ORG_ID, g_GetUserInfo().ORG_NAME);
			saleWeaponMainframe.setValue("ORG", g_GetUserInfo().ORG_ID,
					g_GetUserInfo().ORG_NAME);
		}
	} else {
		saleWeaponMainframe.setValue("ID", newMainid);
		weaponSelectForm1.setValue("MID", newMainid);
		weaponSelectForm.setValue("MID", newMainid);
	}
	document.getElementById("jfl_tr").style.display = "none";
}

function delNewModle() {
	var ss = new Array();
	ss = table00.getSelectedRows();
	if (ss.length < 1) {
		alert("请选择要删除的数据！");
		return;
	}
	for ( var i = ss.length; i > 0; i--) {
		table00.deleteRow(ss[i - 1]);
	}
	var list = new Array();
	list.push(table00);
	var strUrl = _gModuleName + '/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=delWeaponTageRela';
	var recode = saveRowSet(strUrl, list);
	if (recode.getValueByName("FLAG") == "Y") {
		alert("操作成功！");
	}
	weaponSelectForm.newRow();
	weaponSelectForm1.newRow();
	g_AIButtonManager.get("query2").setDisabled(false);
	weaponSelectForm.setColEditSts("SALE_FLAG", true);
	weaponSelectForm.setColEditSts("WEAPON_NAME", false);
	weaponSelectForm.setValue("SALE_FLAG", 11);
	weaponSelectForm.refreshListBox("MARKET_TYPE", "codeType=markets", true);
	weaponSelectForm.refreshListBox("SALE_FLAG", "codeType=hdlxs", true);

}

function addTag() {
	window.open("<%=request.getContextPath()%>/sale/promationTag/ApplyTag.jsp","",
					"height=450,width=900,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
}

function getAttachCfgOpt() {
	var busiTypeVal = "";  //是否需要配置
	var opts = new Array("opt0", "opt1", "opt2"); 
    var pos = 0;
   	for(pos = 0; pos < opts.length; pos++){
	//for ( var pos in aSelBusiType ) {
    	if (document.getElementById(opts[pos]).checked) {
      		if (busiTypeVal != ""){
            	busiTypeVal += ";";
          	}
      		busiTypeVal += document.getElementById(opts[pos]).value;
        }
    }
    return busiTypeVal;
}

//初始化产品协助配置项
function initAttachCfgOpt(attachCfgOpt){
	if(attachCfgOpt != null && attachCfgOpt != ""){
    	var opts = attachCfgOpt.split(";");
    	for(var i = 0; i < opts.length; i++){
    		document.getElementById("opt"+opts[i]).checked = true;
    	}
    }
}

function clearAttachCfgOpt() {
	document.getElementById("opt0").checked = false;
	document.getElementById("opt1").checked = false;
	document.getElementById("opt2").checked = false;
}
</script>
<script language="javascript"
	src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>


