<%@ page contentType="text/html; charset=GBK"%>
<ai:contractframe id="weaponInfoframe" contenttype="table" title="武器详情" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem><ai:button id="bt_applyWeapon" text="若查询不到您想要的武器，请点击此处申请武器" onclick="applyWeapon()"/></ai:contractitem>
    <ai:dbform formid="weaponInfoForm" editable="false" initial="false"
        setname="com.asiainfo.sale.weapon.web.SETSaleWeaponS"
        datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
        implservice_querymethod="getSaleWeapon(String mid,String wwid,String wid,String name, String marketType,
            String backMonth, String baseMonth, String lLimit, String bLimit,
            String saleFlag, String presentBusiMonth, String busiType,
            String netAge, String couponsValue, String selfBusi,
            String goodAdoptDirectory,String state,String presentBusiAmount,
            String presentReachAmount,String presentValuePermon,String presentBusi2Amount,
            String zfqType,String presentBusi4Amount,String openMonth,String minNet_age,String maxNet_age,
            int $STARTROWINDEX, int $ENDROWINDEX)" 
                    initial="false" editable="false">
        <table width="100%" align="center" border="0" cellpadding="1" cellspacing="2" id="tab">
            <tr>
                <td class="td_font">武器编号：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="WID" width="150"/></td>
                <td class="td_font">活动类别：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="SALE_FLAG" width="150"/></td>
            </tr>
            <tr>
                <td class="td_font">细分市场：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="MARKET_TYPE" width="150"/></td>
                <td class="td_font">网龄：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="NET_AGE" width="150"/></td>
            </tr>
            <tr>
            	<td class="td_font">发布电子渠道：</td>
        		<td colspan=3 ><ai:dbformfield formid="weaponInfoForm" fieldname="STANDBY_NUM3" width="150"/></td>
            </tr>
            <tr>
	            <td class="td_font">武器名称：</td>
	            <td colspan="3"> <ai:dbformfield formid="weaponInfoForm" fieldname="WEAPON_NAME" width="550" height="40"/>
            </tr>
            
            <tr id="trFeeLevel">
				<td class="td_font">话费可否抵扣：</td>
				<td colspan="3">
					<ai:dbformfield formid="weaponInfoForm" fieldname="COST_TYPE_ONE" width="10" visible="false"/>
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
						<ai:dbformfield formid="weaponInfoForm" fieldname="COST_TYPE_TWO" width="10" visible="false"/>
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
					<ai:dbformfield formid="weaponInfoForm" fieldname="TEL_FEE_DEDUCTION_TIME" width="150" />
				</td>
			</tr>
            
            <tr id="tr1">
              	<td  colspan="2"><b>预存：</b></td>
	           	<td class="td_font">预存专款范围费用组：</td>
								<td>
							<ai:dbformfield formid="weaponInfoForm"
								fieldname="DYNAMIC_SCORE" width="150" />
	           	<!-- <td>预存专款范围账目项：<img id="selectOrgTypeYCZK" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="ycTagItem()" align=""
								style="cursor: hand;" /></td> -->
            </tr>
            <tr id="tr2">
                <td class="td_font" >预存话费金额：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESTORE_FEE" width="150"/>(元)</td>
                <td class="td_font">预存一次性到帐：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESTRORE_REACH_ACCOUNT" width="150"/>(元)</td>
            </tr>
              <tr id="tr3">
                <td class="td_font">返还额度：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="B_LIMIT" width="150"/></td>
                <td class="td_font">返还月份：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="BACK_MONTH" width="150"/></td>
            </tr>
               <tr id="tr4">
                 	<td colspan="2"><b>赠送：</b></td> 
	           		<td class="td_font">赠送专款范围费用组:</td>
								<td>
							<ai:dbformfield formid="weaponInfoForm"
								fieldname="HOME_SCORE" width="150" />
							</td>
	           	<!--  	 <td>赠送专款范围账目项：<img id="selectOrgTypeYCZK" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="zsTagItem()" align="absmiddle"
								style="cursor: hand;" /></td>-->
            </tr>
            
           <tr id='jfl_tr' style="display: none">
						<td class="td_font">赠送积分：</td>
						<td><ai:dbformfield formid="weaponInfoForm" fieldname="STANDBY_NUM2" width="150" editable="false"/>
						</td>
			</tr>
			
            <tr id="tr5">
                <td class="td_font">赠送话费金额：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_BUSI_AMOUNT" width="150"/>(元）</td>
                <td class="td_font">赠送一次性到帐：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_REACH_AMOUNT" width="150"/>(元）</td>
            </tr>
          	<tr id="tr25">
                <td class="td_font">电子券总金额：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="ADD_MONTHCHARGE" width="150"/>(元）</td>
                <td class="td_font">返还策略：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="RETURN_TYPE" width="150"/>(元）</td>
            </tr>
             <tr id="tr24">
                <td class="td_font">首次返还：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="FIRSTCHARGE" width="150"/>(元）</td>
                <td class="td_font">末次返还：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="LASTCHARGE" width="150"/></td>
                </tr>
            <tr id="tr6">
                <td class="td_font">每月增加值：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_BUSI2_AMOUNT" width="150"/>(元）</td>
                <td class="td_font">返还周期：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="STANDBY_NUM1" width="150"/></td>
            </tr>
            <tr id="tr25_hb">
                <td class="td_font">和包红包总金额：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="ADD_MONTHCHARGE_HB" width="150"/>(元）</td>
                <td class="td_font">返还策略：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="RETURN_TYPE_HB" width="150"/>(元）</td>
            </tr>
             <tr id="tr24_hb">
                <td class="td_font">首次返还：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="FIRSTCHARGE_HB" width="150"/>(元）</td>
                <td class="td_font">末次返还：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="LASTCHARGE_HB" width="150"/></td>
                </tr>
            <tr id="tr6_hb">
                <td class="td_font">每月增加值：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_BUSI2_AMOUNT_HB" width="150"/>(元）</td>
                <td class="td_font">返还周期：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="STANDBY_NUM1_HB" width="150"/></td>
            </tr>
            <tr id="tr7" style="display:none">
                <td class="td_font">支付类型描述：</td>
                <!--  <td><ai:dbformfield formid="weaponInfoForm" fieldname="REMARK_1" width="150"/>(元）</td> -->
                </tr>
            <tr id="tr8">
                <td class="td_font">货品业务总价值：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_BUSI3_AMOUNT" width="150"/>(元）</td>
                <td class="td_font">货品采购目录：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="GOOD_ADOPT_DIRECTORY" width="150"/></td>
            </tr>
            <tr id="tr9">   
                <td class="td_font">货品销售指导价：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="REFERENCE_PRICE" width="150"/>(元）</td>         
                <td class="td_font">货品描述：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="REMARK_2" width="150"/>(元）</td>
                </tr>
            <tr id="tr10">
                <td class="td_font">终端实际购买款：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="TERM_REAL_FEE" width="150"/>(元）</td>
                <td class="td_font">终端类型：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="TERM_TYPE" width="150"/></td>
            </tr>
            <tr id="tr11">
                <td class="td_font">终端销售指导价：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="TERM_GUIDE_FEE" width="150"/>(元）</td>
                <td class="td_font">终端成本结算价：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="TERM_COST_FEE" width="150"/></td>
            </tr>
            <tr id="tr12">
                <td class="td_font">终端描述：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="REMARK_4" width="150"/>(元）</td>
                <td class="td_font">话费帐号属性：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="FEE_ACCOUNT_PROPERTY" width="150"/>(元）</td>
                </tr>
            <tr id="tr13">
                <td class="td_font">数字产品总价格：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_BUSI5_AMOUNT" width="150"/>(元）</td>
            </tr>
            <tr id="tr14">
                <td class="td_font">数字产品描述：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="REMARK_5" width="150"/>(元）</td>
            </tr>
            <tr id="tr15">  
               <td class="td_font"><b>赠送自有业务：</b></td>
           </tr>
            <tr id="tr16">
               <td class="td_font">自有业务总价值：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_BUSI4_AMOUNT" width="150"/>(元）</td>
                <td class="td_font">业务类型：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="BUSI_TYPE" width="150"/></td>
            </tr>
            <tr id="tr17" style="display:none">
                <td class="td_font">自有业务描述：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="REMARK_3" width="150"/>(元）</td>
                </tr>
            
            <tr id="tr18">
                <td class="td_font">每月赠送：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_VALUE_PERMON" width="150"/>(元）</td>
                <td class="td_font">赠送月份：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_BUSI_MONTH" width="150"/></td>
            </tr>
            <tr id="tr19">
                <td class="td_font"><b>保底：</b></td>
                
            </tr>
            
            <tr id="tr20">
                <td class="td_font">保底额度：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="L_LIMIT" width="150"/></td>
                <td class="td_font">保底月数：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="BASE_MONTH" width="150"/></td>
            </tr>
            <tr id="tr20_0">
                <td class="td_font">保底类型：</td> 
               	<td>
               		<ai:dbformfield formid="weaponInfoForm" fieldname="LIM_TYPE" width="150"/><span class="font_red">(套餐内:保底包含套餐费用;套餐外:保底在套餐费之外另算)</span>
               	</td>
               	<td class="td_font"></td>
                <td></td>
            </tr>
             <tr id="tr21">
                <td class="td_font"><b>数据包：</b></td>
            </tr>
            <tr id="tr22">
                <td class="td_font">数据包总价值：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="DATA_FEE" width="150"/></td>  
            
                <td class="td_font">数据业务类型：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="DATA_BUSI_TYPE" width="150"/></td>    
              </tr>
            <tr id="tr23">
                <td class="td_font">每月价值：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="VALUE_PERMONTH" width="150"/></td>    
                <td class="td_font">开通月数：</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="OPEN_MONTH" width="150"/></td>    
            </tr>
            <tr id="tr21">
                <td class="td_font"><b>扣减积分：</b></td>
            </tr>
            <tr id="tr22">
			 	<td class="td_font">积分：</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="GLOBAL_SCORE" width="150"/>
	           	<span class="font_red">(积分为-1,表示积分清零!)</span>
	           	</td>	
	          </tr>
			<tr id="tr23" style="display:none">
	           	<td class="td_font">神州行积分：</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="SZX_SCORE" width="150"/></td>	
			</tr>
            <tr>
             <td class="td_font"><b>申请说明：</b></td>
             <td colspan="3">  <ai:dbformfield formid="weaponInfoForm" fieldname="MREMARK" width="80%" height="100"/></td>
            </tr>
    </table>
    </ai:dbform>
    <table width="100%" align="center" border="0" cellpadding="1" cellspacing="2">
       <tr><td>
        <ai:table setname="com.asiainfo.sale.tag.web.SETPromationTag"
                  tableid="detailTagTab" width="100%" multiselect="false"
                  needrefresh="true" initial="false" height = "100" editable="true"
                  tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
                  implservice_name="com.asiainfo.sale.tag.service.interfaces.ITagDetailSV"
                  implservice_querymethod="getAllTagByWeaponId(int weaponId, int $STARTROWINDEX, int $ENDROWINDEX)"
                  implservice_countmethod="getAllTagByWeaponIdCount(int weaponId)"        
                  operator="query">
             	    <ai:col title="营业资费ID" fieldname="TAG_CODE" width="100" editable="false" visible="true"/>
		        	<ai:col fieldname="TAG_TYPE" width="10%" editable="false" visible="true" />
		        	<ai:col title="配置人" fieldname="STANDBY_NUM1" width="6%" editable="false" visible="true" />
					<ai:col fieldname="NAME" width="10%" editable="false" visible="true" /> 
					<ai:col title="税率(%)" fieldname="STANDBY_NUM2" width="6%" editable="true" visible="true" />
				    <ai:col title="实际配置税率(%)" fieldname="STANDBY_NUM3" width="8%" visible="true" editable="false" />
					<ai:col title="状态" fieldname="STATE" width="6%" editable="false" visible="true" />
					<ai:col fieldname="ADD_MONTHCHARGE" title="总金额" width="6%" editable="false" visible="true" />
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
      </td></tr>
    </table>
</ai:contractframe>
<script type="text/javascript">
function _include_formWeaponSelectFormRowSet(){
    return g_FormRowSetManager.get("weaponInfoForm");
}

function _include_formDetailTagTabTableRowSet(){
	return g_TableRowSetManager.get("detailTagTab");
}

function initWeaponFrom(){
    for(var i=1;i<21;i++){
    var num="tr"+i;
    document.getElementById(num).style.display="none";
	document.getElementById("tr24").style.display = "none";
	document.getElementById("tr25").style.display = "none";
    document.getElementById("tr6_hb").style.display = "none";
	document.getElementById("tr24_hb").style.display = "none";
	document.getElementById("tr25_hb").style.display = "none";
	document.getElementById("trFee").style.display="none";
   	document.getElementById("trFeeLevel").style.display="none";
    }
}

function include_setWeaponFrom(saleType)
{
	if("" == saleType || undefined == saleType || null == saleType) {
		saleType = _include_formWeaponSelectFormRowSet().getValue("SALE_FLAG");
	}
    initWeaponFrom();
      
       if(saleType==12){
	       document.getElementById("tr1").style.display="block";
	       document.getElementById("tr2").style.display="block";
	       document.getElementById("tr3").style.display="block";
	       document.getElementById("tr4").style.display="block";
	       document.getElementById("tr6").style.display="block";
	       //document.getElementById("tr7").style.display="block";
	       document.getElementById("tr19").style.display="block";
	       document.getElementById("tr20").style.display="block";
	   	   document.getElementById("tr24").style.display = "block";
		   document.getElementById("tr25").style.display = "block";
		   document.getElementById("trFee").style.display="block";
		   document.getElementById("trFeeLevel").style.display="block";
       }else if(saleType==18){
	       document.getElementById("tr1").style.display="block";
	       document.getElementById("tr2").style.display="block";
	       document.getElementById("tr3").style.display="block";
	       document.getElementById("tr4").style.display="block";
	       document.getElementById("tr6_hb").style.display="block";
	       //document.getElementById("tr7").style.display="block";
	       document.getElementById("tr19").style.display="block";
	       document.getElementById("tr20").style.display="block";
	   	   document.getElementById("tr24_hb").style.display = "block";
		   document.getElementById("tr25_hb").style.display = "block";
		   document.getElementById("trFee").style.display="block";
		   document.getElementById("trFeeLevel").style.display="block";
       }else  if(saleType==13||saleType==16){
	       document.getElementById("tr1").style.display="block";
	       document.getElementById("tr2").style.display="block";
	       document.getElementById("tr3").style.display="block";
	       //document.getElementById("tr4").style.display="block";
	       //document.getElementById("tr8").style.display="block";
	       //document.getElementById("tr9").style.display="block";
	       document.getElementById("tr19").style.display="block";
	       document.getElementById("tr20").style.display="block";
	       document.getElementById("trFee").style.display="block";
		   document.getElementById("trFeeLevel").style.display="block";
       }else  if(saleType==14){
	       document.getElementById("tr1").style.display="block";
	       document.getElementById("tr2").style.display="block";
	       document.getElementById("tr3").style.display="block";
	       document.getElementById("tr15").style.display="block";
	       document.getElementById("tr16").style.display="block";
	       document.getElementById("tr17").style.display="none";
	       document.getElementById("tr18").style.display="block";
	       document.getElementById("tr19").style.display="block";
	       document.getElementById("tr20").style.display="block";
	       document.getElementById("trFee").style.display="block";
		   document.getElementById("trFeeLevel").style.display="block";
       }else  if(saleType==15){
	      document.getElementById("tr1").style.display="block";
	      document.getElementById("tr2").style.display="block";
	      document.getElementById("tr3").style.display="block";
	      document.getElementById("tr4").style.display="block";
	      document.getElementById("tr5").style.display="block";
	      document.getElementById("tr6").style.display="block";
	      //document.getElementById("tr7").style.display="block";
	      //document.getElementById("tr8").style.display="block";
	      //document.getElementById("tr9").style.display="block";
	      document.getElementById("tr15").style.display="block";
	      document.getElementById("tr16").style.display="block";
	      document.getElementById("tr17").style.display="none";
	      document.getElementById("tr19").style.display="block";
	      document.getElementById("tr20").style.display="block";
		  document.getElementById("tr6_hb").style.display = "block";
		  document.getElementById("tr24").style.display = "block";
		  document.getElementById("tr24_hb").style.display = "block";
		  document.getElementById("tr25").style.display = "block";
		  document.getElementById("tr25_hb").style.display = "block";
		  document.getElementById("trFee").style.display="block";
		   document.getElementById("trFeeLevel").style.display="block";
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
	       document.getElementById("trFee").style.display="block";
		   document.getElementById("trFeeLevel").style.display="block";
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
	       document.getElementById("trFee").style.display="block";
		   document.getElementById("trFeeLevel").style.display="block";
       } else  if(saleType==31){
	       document.getElementById("tr4").style.display="block";
	       document.getElementById("tr5").style.display="block";
	       document.getElementById("tr6").style.display="block";
	       //document.getElementById("tr7").style.display="block";
	       //document.getElementById("tr8").style.display="block";
	       //document.getElementById("tr9").style.display="block";
	       document.getElementById("tr15").style.display="block";
	       document.getElementById("tr16").style.display="block";
	       document.getElementById("tr17").style.display="none";
	       document.getElementById("tr6_hb").style.display = "block";
		   document.getElementById("tr24").style.display = "block";
		   document.getElementById("tr24_hb").style.display = "block";
		   document.getElementById("tr25").style.display = "block";
		   document.getElementById("tr25_hb").style.display = "block";	
		   document.getElementById("trFee").style.display="block";
		   document.getElementById("trFeeLevel").style.display="block";
		   document.getElementById("trFee").style.display="block";
		   document.getElementById("trFeeLevel").style.display="block";
       }else if(saleType==41){
	       document.getElementById("tr4").style.display="block";
	       document.getElementById("tr5").style.display="block";
	       //document.getElementById("tr8").style.display="block";
	       //document.getElementById("tr9").style.display="block";
	       document.getElementById("tr13").style.display="block";
	       document.getElementById("tr14").style.display="block";
	       document.getElementById("tr15").style.display="block";
	       document.getElementById("tr16").style.display="block";
	       document.getElementById("tr17").style.display="none";
	       document.getElementById("trFee").style.display="block";
		   document.getElementById("trFeeLevel").style.display="block";
	       } else{
	       document.getElementById("tr1").style.display="block";
	       document.getElementById("tr2").style.display="block";
	       document.getElementById("tr3").style.display="block";
	       document.getElementById("tr4").style.display="block";
	       document.getElementById("tr5").style.display="block";
	       document.getElementById("tr19").style.display="block";
	       document.getElementById("tr20").style.display="block";
	       document.getElementById("tr18").style.display="block";
	       document.getElementById("trFee").style.display="block";
		   document.getElementById("trFeeLevel").style.display="block";
       }
       if (saleType==17 || saleType==23 || saleType==41) {
		   document.getElementById("jfl_tr").style.display="block";
	   }
 }

function applyWeapon(){ //获取条件后刷新记录
     window.open("<%=request.getContextPath()%>/sale/weapon/WeaponAddInfo.jsp", 
                        null, 'height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
  }
  
function ycTagItem(){
	var item_type=_include_formWeaponSelectFormRowSet().getValue("REMARK_3");
	window.showModalDialog("<%=request.getContextPath()%>/sale/promationTag/tagitem.jsp?item_type="+item_type,"","dialogWidth=500px");
}

function zsTagItem(){
	var item_type=_include_formWeaponSelectFormRowSet().getValue("REMARK_2");
	window.showModalDialog("<%=request.getContextPath()%>/sale/promationTag/tagitem.jsp?item_type="+item_type,"","dialogWidth=500px");
}  

function savaTag() {
	var _tableTagDetailRowSet = g_TableRowSetManager.get("detailTagTab");
	var xmlbody = _tableTagDetailRowSet.toXmlString(true);
	if (xmlbody == null || xmlbody == "") {
		//alert("内容没改变!");
		return;
	}
	var xml = "<RootInfo>" + xmlbody + "</RootInfo>";
	var ud = PostInfo(
			"<%=request.getContextPath()%>/business/com.asiainfo.sale.tag.web.DetailTagAction?action=saveDetailTag&pid=0",
			xml);
}

function initAttachCfgOpt(attachCfgOpt){
	clearAttachCfgOpt();
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