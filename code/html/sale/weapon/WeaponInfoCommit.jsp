<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>武器申请</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body>
<ai:contractframe id="saleWeaponMainframe" contenttype="table" title="申请信息" width="100%" allowcontract="true" frameclosed="true">
	<ai:contractitem/>
	<ai:dbform formid="saleWeaponMainframe" 
			setname="com.asiainfo.sale.weapon.web.SETSaleWeaponMainDe"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="true" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponMainSV"
			implservice_querymethod="getSaleWeaponMainDeById(String id)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr><td class="td_font">申请名称：</td>
	           	<TD><ai:dbformfield formid="saleWeaponMainframe" fieldname="APPLY_NAME" width="150" editable="false"/> </td> 
	           	<ai:dbformfield formid="saleWeaponMainframe" fieldname="ID" visible="false"/>   
	           	<ai:dbformfield formid="saleWeaponMainframe" fieldname="WID" visible="false"/>
	           	<td class="td_font">申请人：</td>
	           	<TD><ai:dbformfield formid="saleWeaponMainframe" fieldname="STAFF_NAME" width="150" editable="false"/>
	           	<ai:dbformfield formid="saleWeaponMainframe" fieldname="PRINCIPAL" width="150" visible="false"/></TD>
	           	<td class="td_font">申请单位：</td>
	           	<TD><ai:dbformfield formid="saleWeaponMainframe" fieldname="ORGANIZE_NAME" width="130" editable="false"/>
	           	<ai:dbformfield formid="saleWeaponMainframe" fieldname="PROMOTE_DEPART" width="130" visible="false"/></TD>
			</tr>
			<tr>
	           	<td class="td_font" >申请说明：</td>
	           	<td colspan="5"><ai:dbformfield formid="saleWeaponMainframe" fieldname="REMARK" width="70%" height="70" editable="false"/>
			</td>
			</tr>
		</table>
		 <div  class="area_button" style="display:none;"><ai:button text="保存申请信息" id="" onclick="" /></div>
	</ai:dbform>
</ai:contractframe>

		<ai:contractframe id="chargeApplyMain" contenttype="table" title="已保存的武器模板信息" width="100%" allowcontract="true" frameclosed="fale">
	    <ai:contractitem><%--<ai:button id="newSaleDetail" text="新建活动" onclick="newSaleDetail()"/>--%>
	    </ai:contractitem>
	    <ai:table
	        tableid="table00"
	        setname="com.asiainfo.sale.weapon.web.SETSaleWeapon"
	        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	        implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
	        implservice_querymethod="getSaleWeaponByMainId(String mainId, int $STARTROWINDEX,int $ENDROWINDEX)"
	        initial="false"  multiselect="" ondbclick="" onrowchange="showApplyMain"
	        pagesize="15" editable="false" width="100%" rowheight=""
	        height="100" needrefresh="true">
	        	<ai:col title="武器编号" fieldname="ID" visible="" width="10%"/>
	        	<ai:col title="工单编号" fieldname="MID" visible="" width="10%"/>
	            <ai:col title="档次类别" fieldname="SALE_FLAG" width="20%" />
	            <ai:col title="细分市场" fieldname="MARKET_TYPE" width="20%" />
	        	<ai:col title="网龄" fieldname="NET_AGE" width="20%"/>
	            <ai:col title="武器名称" fieldname="WEAPON_NAME" width="30%" />
	    </ai:table>
		</ai:contractframe>

 <ai:contractframe id="weaponMainSelectframe" contenttype="table" title="武器详细信息" width="100%" allowcontract="false" frameclosed="fale">
	<ai:contractitem/>
	<ai:dbform formid="weaponSelectForm1" 
		setname="com.asiainfo.sale.weapon.web.SETSaleWeaponS" initial="false"
        datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
					implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
					implservice_querymethod="getSaleWeaponOnlyByID(String id)" 
					initial="false" editable="false">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2" id="tab">
		        <tr>
	           	<td class="td_font">武器编号：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="WID" width="150"/>
		           	<ai:dbformfield formid="weaponSelectForm1" fieldname="MID" visible="false" width="150"/>
	           	</td>
	           	<td class="td_font">网龄：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="NET_AGE" width="150"/></td>
			</tr>
			<tr>
	           	<td class="td_font">细分市场：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="MARKET_TYPE" width="150"/></td>
		    	<td class="td_font">活动类别：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="SALE_FLAG" width="150"/></td>
	        </tr>
	        <tr>
				<td class="td_font">发布电子渠道：</td>
        		<td colspan="3"><ai:dbformfield formid="weaponSelectForm1" fieldname="STANDBY_NUM3" width="150"/></td>
			</tr>
	        <tr>
	        	<td class="td_font">武器名称：</td>
	           	<td colspan="3"><ai:dbformfield formid="weaponSelectForm1" fieldname="WEAPON_NAME" width="550" height="50"/>
	          </td>
	        </tr>
	        <tr id="trFeeLevel">
				<td class="td_font">话费可否抵扣：</td>
				<td colspan="3">
					<ai:dbformfield formid="weaponSelectForm1" fieldname="COST_TYPE_ONE" width="10" visible="false"/>
					<div style="float:left;width:20%">
						<span>一级分类</span><br/>
						<input type="checkbox" id="check_one_input0" disabled="ture" value="0"/>套餐及固定费&nbsp;<br/>
						<input type="checkbox" id="check_one_input1" disabled="ture" value="1" />语音通信费&nbsp;<br/>
						<input type="checkbox" id="check_one_input2" disabled="ture" value="2"/>上网费&nbsp;<br/>
						<input type="checkbox" id="check_one_input3" disabled="ture" value="3"/>短彩信费&nbsp;<br/>
						<input type="checkbox" id="check_one_input4" disabled="ture" value="4"/>自有增值业务费用&nbsp;<br/>
						<input type="checkbox" id="check_one_input5" disabled="ture" value="5"/>代收费业务费用&nbsp;<br/>
						<input type="checkbox" id="check_one_input6" disabled="ture" value="6"/>保底费用&nbsp;<br/>
						<input type="checkbox" id="check_one_input7" disabled="ture" value="7"/>政企费用&nbsp;<br/>
						<input type="checkbox" id="check_one_input8" disabled="ture" value="8"/>宽带费用&nbsp;<br/>
						<input type="checkbox" id="check_one_input9" disabled="ture" value="9"/>专项费用
					</div>
					<div style="float:left;width:80%">
						<ai:dbformfield formid="weaponSelectForm1" fieldname="COST_TYPE_TWO" width="10" visible="false"/>
						<span>二级分类</span><br/>
						<div id="check_two_input0">
							<input type="checkbox" id="check_two0" disabled="ture" value="0" />主套餐月租费&nbsp;
							<input type="checkbox" id="check_two1" disabled="ture" value="1" />国内流量套餐月租费&nbsp;
							<input type="checkbox" id="check_two2" disabled="ture" value="2" />国际流量套餐月租费&nbsp;
							<input type="checkbox" id="check_two3" disabled="ture" value="3" />除主套餐、流量套餐以外的月租费&nbsp;<br/>
						</div>
						<div id="check_two_input1">
							<input type="checkbox" id="check_two4" disabled="ture" value="4" />国内语音通信费&nbsp;
							<input type="checkbox" id="check_two5" disabled="ture" value="5" />国际及港澳台语音通信费&nbsp;<br/>
						</div>
						<div id="check_two_input2">
							<input type="checkbox" id="check_two6" disabled="ture" value="6" />国内上网通信费&nbsp;
							<input type="checkbox" id="check_two7" disabled="ture" value="7" />国际及港澳台上网通信费&nbsp;<br/>
						</div>
						<div id="check_two_input3">
							<input type="checkbox" id="check_two8" disabled="ture" value="8" />国内短彩信通信费&nbsp;
							<input type="checkbox" id="check_two9" disabled="ture" value="9" />国内短彩信通信费&nbsp;<br/>
						</div>
						<div id="check_two_input4">
							<input type="checkbox" id="check_two10" disabled="ture" value="10" />自有增值业务费用&nbsp;<br/>
						</div>
						<div id="check_two_input5">
							<input type="checkbox" id="check_two11" disabled="ture" value="11" />代收费业务费用&nbsp;<br/>
						</div>
						<div id="check_two_input6">
							<input type="checkbox" id="check_two12" disabled="ture" value="12" />保底费用&nbsp;<br/>
						</div>
						<div id="check_two_input7">
							<input type="checkbox" id="check_two13" disabled="ture" value="13" />政企费用&nbsp;<br/>
						</div>
						<div id="check_two_input8">
							<input type="checkbox" id="check_two14" disabled="ture" value="14" />宽带费用&nbsp;<br/>
						</div>
						<div id="check_two_input9">
							<textarea class="dbform_disable_style" id="check_two15" disabled="disabled"
							style="OVERFLOW-X: auto; OVERFLOW-Y: auto;height:40px;width:240px"></textarea>
						</div>
					</div>
				</td>
			</tr>
	        <tr id="trFee">
				<td class="td_font">话费抵扣的时间范围：</td>
				<td>
					<ai:dbformfield formid="weaponSelectForm1" fieldname="TEL_FEE_DEDUCTION_TIME" width="150" />
				</td>
			</tr>
		    <tr id="tr1">
	           	<td  colspan="2"><b>预存：</b></td>
	           	<td class="td_font">预存专款范围费用组：</td>
								<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="DYNAMIC_SCORE" width="150" />
	           	<!-- <td>预存专款范围账目项：<img id="selectOrgTypeYCZK" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="ycTagItem()" align=""
								style="cursor: hand;" /></td> -->
			</tr>
		    <tr id="tr2">
	           	<td class="td_font" >预存话费金额：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESTORE_FEE" width="150"/>(元)</td>
	           	<td class="td_font">预存一次性到帐：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESTRORE_REACH_ACCOUNT" width="150"/>(元)</td>
			</tr>
			  <tr id="tr3">
	           	<td class="td_font">每月返还：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="B_LIMIT" width="150"/>(元)</td>
	           	<td class="td_font">返还月份：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="BACK_MONTH" width="150"/></td>
			</tr>
					
			   <tr id="tr4">
	           	<td colspan="2"><b>赠送：</b></td> 
	           		<td class="td_font">赠送专款范围费用组:</td>
								<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="HOME_SCORE" width="150" />
							</td>
	           	<!--  	 <td>赠送专款范围账目项：<img id="selectOrgTypeYCZK" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="zsTagItem()" align="absmiddle"
								style="cursor: hand;" /></td>-->
	           	 
			</tr>
			<tr id='jfl_tr' style="display: none">
				<td class="td_font">赠送积分：</td>
				<td><ai:dbformfield formid="weaponSelectForm1" fieldname="STANDBY_NUM2" width="150" editable="false"/>
				</td>
			</tr>
			<tr id="tr5">
	           	<td class="td_font">赠送话费金额：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI_AMOUNT" width="150"/>(元)</td>
	           	<td class="td_font">赠送一次性到帐：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_REACH_AMOUNT" width="150"/>(元)</td>
			</tr>
			<tr id="tr18">
	           	<td class="td_font">每月赠送：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_VALUE_PERMON" width="150"/>(元)</td>
	           	<td class="td_font">赠送月份：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI_MONTH" width="150"/></td>
			</tr>
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
							<span id="showzfq" class="font_red">*</span>
						</td>
						<td class="td_font">
							末次返还：
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="LASTCHARGE"
								width="150" />
							<span id="showzfq" class="font_red">*</span>
						</td>
					</tr>
					<tr id="tr6">
						<td class="td_font">
							每月增加值：
						</td>
						<td>
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
							<span id="showzfq" class="font_red">*</span>
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
			<tr id="tr7"  style="display:none">
	           	<td class="td_font">支付类型描述：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_1" width="150"/>(元)</td>
	           	</tr>
			<tr id="tr8">
			    <td class="td_font">货品业务总价值：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI3_AMOUNT" width="150"/>(元)</td>
	           	<td class="td_font">货品采购目录：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="GOOD_ADOPT_DIRECTORY" width="150"/></td>
			</tr>
			<tr id="tr9"> 	
			    <td class="td_font">货品销售指导价：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="REFERENCE_PRICE" width="150"/>(元)</td>         
	           	<td class="td_font" style="display:none">货品描述：</td>
	           	<td style="display:none"><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_2" width="150"/></td>
	           	</tr>
			<tr id="tr10">
	           	<td class="td_font">终端实际购买款：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="TERM_REAL_FEE" width="150"/>(元)</td>
	           	<td class="td_font">终端类型：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="TERM_TYPE" width="150"/></td>
			</tr>
			<tr id="tr11">
	           	<td class="td_font">终端销售指导价：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="TERM_GUIDE_FEE" width="150"/>(元)</td>
	           	<td class="td_font">终端成本结算价：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="TERM_COST_FEE" width="150"/>(元)</td>
			</tr>
			<tr id="tr12">
	           	<td class="td_font">终端描述：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_4" width="150"/></td>
	            <td class="td_font">话费帐号属性：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="FEE_ACCOUNT_PROPERTY" width="150"/>(元)</td>
	           	</tr>
			<tr id="tr13">
	           	<td class="td_font">数字产品总价格：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI5_AMOUNT" width="150"/>(元)</td>
	 		</tr>
	 		<tr id="tr14">
	           	<td class="td_font">数字产品描述：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_5" width="150"/>(元)</td>
	 		</tr>
	 		<tr id="tr15">	
		 	   <td class="td_font"><b>赠送自有业务：</b></td>
	       </tr>
	 		<tr id="tr16">
	           <td class="td_font">自有业务总价值：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI4_AMOUNT" width="150"/>(元)</td>
	           	<td class="td_font">业务类型：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="BUSI_TYPE" width="150"/></td>
			</tr>
			<tr id="tr17">
	           	<td class="td_font">自有业务描述：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_3" width="150"/>(元)</td>
	           	</tr>
			
			
			<tr id="tr19">
	           	<td class="td_font"><b>保底：</b></td>
	           	
			</tr>
			<tr id="tr20">
	           	<td class="td_font">保底额度：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="L_LIMIT" width="150"/>(元)</td>
	           	<td class="td_font">保底月数：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="BASE_MONTH" width="150"/></td>
			</tr>
			<tr id="tr201">
				<td class="td_font"> 保底类型：</td>
				<td> <ai:dbformfield formid="weaponSelectForm1" fieldname="LIM_TYPE" width="150" /><span class="font_red">(套餐内:保底包含套餐费用;套餐外:保底在套餐费之外另算)</span> </td>
				<td class="td_font"> </td> <td> </td>
			</tr>
			 <tr id="tr21">
	           	<td class="td_font"><b>数据包：</b></td>
			</tr>
			<tr id="tr22">
			 	<td class="td_font">数据包总价值：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="DATA_FEE" width="150"/>(元)</td>	
			
	           	<td class="td_font">数据业务类型：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="DATA_BUSI_TYPE" width="150"/></td>	
	          </tr>
			<tr id="tr23">
	           	<td class="td_font">每月价值：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="VALUE_PERMONTH" width="150"/>(元)</td>	
	           	<td class="td_font">开通月数：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="OPEN_MONTH" width="150"/></td>	
			</tr>
			<tr id="tr21">
	           	<td class="td_font"><b>扣减积分：</b></td>
			</tr>
			<tr id="tr22">
			 	<td class="td_font">积分：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="GLOBAL_SCORE" width="150"/>
	           	<span class="font_red">(积分为-1,表示积分清零!)</span></td>	
			<tr id="tr23" style="display:none">
	           	<td class="td_font">神州行积分：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="SZX_SCORE" width="150"/></td>	
			</tr>
	</table>
	</ai:dbform>
</ai:contractframe>

<ai:contractframe id="tagDetailframe" contenttype="table" title="需要开发备用标签" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem/>
	<ai:table setname="com.asiainfo.sale.tag.web.SETPromationTag"
			  tableid="detailTagTab" width="100%" multiselect="false"
			  needrefresh="true" initial="false" height = "200"
			  tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			  implservice_name="com.asiainfo.sale.tag.service.interfaces.ITagDetailSV"
			  implservice_querymethod="getSpareTagDetailByWeaponId(int weaponId)"			  
			  operator="query">
	       		<ai:col fieldname="WPID" width="6%" editable="false" visible="" />
	        	<ai:col fieldname="TAG_TYPE" width="10%" editable="false" visible="true" />
				<ai:col fieldname="NAME" width="10%" editable="false" visible="true" /> 
				<ai:col fieldname="ADD_MONTHCHARGE" title="总金额" width="8%" editable="false" visible="true" />
				<ai:col fieldname="FIRSTCHARGE" title="首次到账"  width="7%" editable="false" visible="true"/> 
				<ai:col fieldname="LASTCHARGE"  title="末次到账" width="7%" editable="false" visible="true"/> 
				<ai:col  fieldname="CHARGE" title="每月金额" width="7%" visible="true"/>
				<ai:col title="每月增加值" fieldname="SUMCHARGE" width="8%" editable="false" />
				<ai:col fieldname="CYCLE"  width="7%" editable="false" visible="true"/> 
				<ai:col title="返还策略" fieldname="RETURN_TYPE" width="10%" editable="false" visible="true"/>
				<ai:col title="专款范围" fieldname="IS_SP" width="10%" editable="false" visible="true"/>
				<ai:col fieldname="AREA" width="7%" editable="false" visible="true"/>
				<ai:col title="标签备注" fieldname="REMARK_TAG" width="15%" editable="false" visible="true"/>

	</ai:table>
	
</ai:contractframe>	
<div class="area_button" id="divCommit">
	<ai:button text="修改" id="query1" onclick="update()" />
</div>
<script type="text/javascript">

var saleWeaponMainframe = g_FormRowSetManager.get("saleWeaponMainframe");
var weaponSelectForm1 = g_FormRowSetManager.get("weaponSelectForm1");
var _tableTagDetailRowSet = g_TableRowSetManager.get("detailTagTab");
var table00 = g_TableRowSetManager.get("table00");
var state="<%=request.getParameter("state")%>";
var type="<%=request.getParameter("type")%>";
var wid="<%=request.getParameter("WID")%>";
var saleType="<%=request.getParameter("saleFale")%>";
var ID="<%=request.getParameter("ID")%>";

initPage();

function showApplyMain(oldIndex,newIndex){
	 if(-1 != oldIndex) {
     	 table00.setRowBgColor(oldIndex,"");
   	 }
   	 table00.setRowBgColor(newIndex,"yellow");
   	 var applyid = table00.getValue(newIndex,"ID");
	 var SALE_FLAG=table00.getValue(newIndex,"SALE_FLAG");
	 onSaleTypeChange(SALE_FLAG);
	 weaponSelectForm1.refresh("&id="+applyid);
	 _tableTagDetailRowSet.refresh("&weaponId=" + applyid);
	 showCheckBox();
}
	
function initPage(){
    if(state=="P"){
    	if(saleType=="12"){
	    	document.getElementById('divApprover').style.display='none';
	    	document.getElementById("query2").style.display="none";
	    	document.getElementById("query1_btnText").innerHTML="申请电子劵武器";
    	}else{
    	 	document.getElementById("query1").style.display="none";
    	}
    }
   	if(type=="aduit"){
	   	document.getElementById('divApprover').style.display='none';
	   	document.getElementById("query2").style.display="none";
   	}	
   var saleType=<%=request.getParameter("saleFale")%>;
   onSaleTypeChange(saleType);
   saleWeaponMainframe.refresh("&id="+wid);
   weaponSelectForm1.refresh("&id="+ID);
   _tableTagDetailRowSet.refresh("&weaponId=" + weaponSelectForm1.getValue("WID"));
   table00.refresh("&mainId="+wid);
   showCheckBox();
}

function showCheckBox(){
   	var costTypeOne = weaponSelectForm1.getValue("COST_TYPE_ONE");
   	var costOne = costTypeOne.split(",");
   	for(var i=0 ;i<costOne.length; i++){
		if(costOne[i] != ''){
			document.getElementById("check_one_input"+costOne[i]).checked=true;
	   	}
   	}
   	var costTypeTwo = weaponSelectForm1.getValue("COST_TYPE_TWO");
   	var costTwo = costTypeTwo.split(",");
   	for(var i=0 ;i<costTwo.length; i++){
	   	if(costTwo[i] != ''){
		   	if(i+1 == costTwo.length && costTwo[i].indexOf("___")){
			   	var textTwo = costTwo[i].split("___");
			   	document.getElementById("check_two"+textTwo[0]).checked=true;
			   	document.getElementById("check_two15").innerHTML = textTwo[1];
		   	}else{
			   	document.getElementById("check_two"+costTwo[i]).checked=true;
			   	document.getElementById("check_two15").innerHTML = "";
		   	}
	   	}
   	}
}

function initDate(){
    for(var i=1;i<21;i++){
    var num="tr"+i;
    document.getElementById(num).style.display="none";
    document.getElementById("trFee").style.display="none";
   	document.getElementById("trFeeLevel").style.display="none";
    }
}


function onSaleTypeChange(saleType)
{           
    //var saleType=<%=request.getParameter("saleFale")%>;
	   initDate();
	   if(saleType==12){
	   document.getElementById("tr1").style.display="block";
	   document.getElementById("tr2").style.display="block";
	   document.getElementById("tr3").style.display="block";
	   document.getElementById("tr4").style.display="block";
	   document.getElementById("tr6").style.display="block";
	   document.getElementById("tr19").style.display="block";
	   document.getElementById("tr20").style.display="block";
	   document.getElementById("tr201").style.display="block";
	   document.getElementById("trFee").style.display = "block";
	   document.getElementById("trFeeLevel").style.display = "block";
	   }else  if(saleType==13||saleType==16){
	   document.getElementById("tr1").style.display="block";
	   document.getElementById("tr2").style.display="block";
	   document.getElementById("tr3").style.display="block";
	   //document.getElementById("tr4").style.display="block";
	   //document.getElementById("tr8").style.display="block";
	   //document.getElementById("tr9").style.display="block";
	   document.getElementById("tr19").style.display="block";
	   document.getElementById("tr20").style.display="block";
	   document.getElementById("tr201").style.display="block";
	   document.getElementById("trFee").style.display = "block";
		document.getElementById("trFeeLevel").style.display = "block";
	   }else  if(saleType==14){
	   document.getElementById("tr1").style.display="block";
	   document.getElementById("tr2").style.display="block";
	   document.getElementById("tr3").style.display="block";
	   document.getElementById("tr15").style.display="block";
	   document.getElementById("tr16").style.display="block";
	   document.getElementById("tr17").style.display="block";
	   document.getElementById("tr19").style.display="block";
	   document.getElementById("tr20").style.display="block";
	   document.getElementById("tr201").style.display="block";
	   document.getElementById("trFee").style.display = "block";
		document.getElementById("trFeeLevel").style.display = "block";
	   }else  if(saleType==15){
	   document.getElementById("tr1").style.display="block";
	   document.getElementById("tr2").style.display="block";
	   document.getElementById("tr3").style.display="block";
	   document.getElementById("tr4").style.display="block";
	   document.getElementById("tr5").style.display="block";
	   document.getElementById("tr6").style.display="block";
	   //document.getElementById("tr8").style.display="block";
	   //document.getElementById("tr9").style.display="block";
	   document.getElementById("tr15").style.display="block";
	   document.getElementById("tr16").style.display="block";
	   document.getElementById("tr17").style.display="block";
	     document.getElementById("tr18").style.display="block";
	   document.getElementById("tr19").style.display="block";
	   document.getElementById("tr20").style.display="block";
	   document.getElementById("tr201").style.display="block";
	   document.getElementById("trFee").style.display = "block";
		document.getElementById("trFeeLevel").style.display = "block";
	   }else  if(saleType==21){
	   document.getElementById("tr1").style.display="block";
	   document.getElementById("tr2").style.display="block";
	   document.getElementById("tr3").style.display="block";
	   document.getElementById("tr4").style.display="block";
	   document.getElementById("tr10").style.display="block";
	    document.getElementById("tr11").style.display="block";
	    document.getElementById("tr12").style.display="block";
	   document.getElementById("tr19").style.display="block";
	   document.getElementById("tr20").style.display="block";
	   document.getElementById("tr201").style.display="block";
	   document.getElementById("trFee").style.display = "block";
		document.getElementById("trFeeLevel").style.display = "block";
	   }
	   else  if(saleType==22){
	   document.getElementById("tr4").style.display="block";
	   document.getElementById("tr5").style.display="block";
	    document.getElementById("tr18").style.display="block";
	    document.getElementById("tr10").style.display="block";
	    document.getElementById("tr11").style.display="block";
	    document.getElementById("tr12").style.display="block";
	   document.getElementById("tr19").style.display="block";
	   document.getElementById("tr20").style.display="block";
	   document.getElementById("tr201").style.display="block";
	   document.getElementById("trFee").style.display = "block";
		document.getElementById("trFeeLevel").style.display = "block";
	   } else  if(saleType==31){
	   document.getElementById("tr4").style.display="block";
	   document.getElementById("tr5").style.display="block";
	   document.getElementById("tr6").style.display="block";
	   //document.getElementById("tr8").style.display="block";
	   //document.getElementById("tr9").style.display="block";
	   document.getElementById("tr15").style.display="block";
	   document.getElementById("tr16").style.display="block";
	   document.getElementById("tr17").style.display="block";
	   document.getElementById("tr18").style.display="block";
	   document.getElementById("trFee").style.display = "block";
		document.getElementById("trFeeLevel").style.display = "block";
	   }else if(saleType==41){
	     document.getElementById("tr18").style.display="block";
	   document.getElementById("tr4").style.display="block";
	   document.getElementById("tr5").style.display="block";
	   //document.getElementById("tr8").style.display="block";
	   //document.getElementById("tr9").style.display="block";
	   document.getElementById("tr13").style.display="block";
	   document.getElementById("tr14").style.display="block";
	   document.getElementById("tr15").style.display="block";
	   document.getElementById("tr16").style.display="block";
	   document.getElementById("tr17").style.display="block";
	   document.getElementById("trFee").style.display = "block";
		document.getElementById("trFeeLevel").style.display = "block";
	   } else {
	   document.getElementById("tr1").style.display="block";
	   document.getElementById("tr2").style.display="block";
	   document.getElementById("tr3").style.display="block";
	   document.getElementById("tr4").style.display="block";
	   document.getElementById("tr5").style.display="block";
	   document.getElementById("tr19").style.display="block";
	   document.getElementById("tr20").style.display="block";
	   document.getElementById("tr201").style.display="block";
	   document.getElementById("tr18").style.display="block";
	   document.getElementById("trFee").style.display = "block";
		document.getElementById("trFeeLevel").style.display = "block";
	   }
	   if (saleType==17 || saleType==23 || saleType==41) {
		   document.getElementById("jfl_tr").style.display="block";
	   }
	}
	
	
function commitWeaponInfo(){
	var approver = document.getElementById("opTypeId_a").value;//下一环节审批人工号
	if(approver==""){
		return	alert("请选择下一环节审批人！");
	}
    var weaponName=weaponSelectForm1.getValue("WEAPON_NAME");
	var marketType=weaponSelectForm1.getValue("MARKET_TYPE");
	var netAge=weaponSelectForm1.getValue("NET_AGE");
	var saleFlag=weaponSelectForm1.getValue("SALE_FLAG");
	var wmid=weaponSelectForm1.getValue("MID");
	var wid="";//weaponSelectForm1.getValue("WID");
	    if(weaponName==""&&state!="P"){
	    alert("请先保存！");
	    }else{
	    	var count = table00.count();
		    if(count > 0){
				for(var i = 0; i < count; i++){
					wid = wid + table00.getValue(i,"ID")+";";
				}
			}
		    if(state=="P"){
		    var strUrl = _gModuleName + '/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=AduitSaleWeapon&&showTime=add&result=approve&wid='+wid+"&mid="+wmid+"&weaponName="+weaponName;
			var recode = PostInfo(strUrl);
		    }
		    else{
		   var strUrl = _gModuleName + '/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=commitSaleWeapon&wid='+wid+"&mid="+wmid+"&weaponName="+weaponName+"&approver="+approver;
			var recode = PostInfo(strUrl);
			}
		if ("Y" == recode.getValueByName("FLAG") )
		{
		 alert("提交成功！");
		  window.opener.queryWeaponMain();
		   window.self.close();
		}
			if("C" == recode.getValueByName("FLAG")){
			return  alert("已有相同武器申请中，请查询武器状态！");
			}else if("W" == recode.getValueByName("FLAG")){
			return alert("已有相同武器配置中，请查询武器后直接使用！");
			}else if("U" == recode.getValueByName("FLAG")){
			return alert("已有相同武器可用，请查询武器后直接使用！");
			}
		}
    }
    
    
function update(){
	var wmid=weaponSelectForm1.getValue("MID");
	var pid = weaponSelectForm1.getValue("WID");
   	//var url= window.open("<%=request.getContextPath()%>/sale/weapon/WeaponUpdateInfo.jsp?wid="+wmid+"&type="+type,"","dialogWidth=800px")
 	// window.self.close();
 	window.location.href="<%=request.getContextPath()%>/sale/weapon/WeaponUpdateInfo.jsp?wid="+wmid+"&type="+type+"&pid="+pid;
}

	
function ycTagItem(){
    var weaponSelectForm1 = g_FormRowSetManager.get("weaponSelectForm1");
	var item_type=weaponSelectForm1.getValue("REMARK_3");
	window.showModalDialog("<%=request.getContextPath()%>/sale/promationTag/tagitem.jsp?item_type="+item_type,"","dialogWidth=500px");
}

function zsTagItem(){
 	var weaponSelectForm1 = g_FormRowSetManager.get("weaponSelectForm1");
	var item_type=weaponSelectForm1.getValue("REMARK_2");
	window.showModalDialog("<%=request.getContextPath()%>/sale/promationTag/tagitem.jsp?item_type="+item_type,"","dialogWidth=500px");
}	

function initAttachCfgOpt(attachCfgOpt){
	if(attachCfgOpt != null && attachCfgOpt != ""){
    	var opts = attachCfgOpt.split(";");
    	for(var i = 0; i < opts.length; i++){
    		document.getElementById("opt"+opts[i]).checked = true;
    	}
    }
}
</script>
</body>
</html>
