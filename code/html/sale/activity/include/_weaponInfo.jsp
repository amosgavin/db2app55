<%@ page contentType="text/html; charset=GBK"%>
<ai:contractframe id="weaponInfoframe" contenttype="table" title="��������" width="100%" allowcontract="true" frameclosed="false">
    <ai:contractitem><ai:button id="bt_applyWeapon" text="����ѯ��������Ҫ�������������˴���������" onclick="applyWeapon()"/></ai:contractitem>
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
                <td class="td_font">������ţ�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="WID" width="150"/></td>
                <td class="td_font">����</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="SALE_FLAG" width="150"/></td>
            </tr>
            <tr>
                <td class="td_font">ϸ���г���</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="MARKET_TYPE" width="150"/></td>
                <td class="td_font">���䣺</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="NET_AGE" width="150"/></td>
            </tr>
            <tr>
            	<td class="td_font">��������������</td>
        		<td colspan=3 ><ai:dbformfield formid="weaponInfoForm" fieldname="STANDBY_NUM3" width="150"/></td>
            </tr>
            <tr>
	            <td class="td_font">�������ƣ�</td>
	            <td colspan="3"> <ai:dbformfield formid="weaponInfoForm" fieldname="WEAPON_NAME" width="550" height="40"/>
            </tr>
            
            <tr id="trFeeLevel">
				<td class="td_font">���ѿɷ�ֿۣ�</td>
				<td colspan="3">
					<ai:dbformfield formid="weaponInfoForm" fieldname="COST_TYPE_ONE" width="10" visible="false"/>
					<div style="float:left;width:20%">
						<span>һ������</span><br/>
						<input type="checkbox" id="check_one_input0" disabled="ture" value="0"/>�ײͼ��̶���&nbsp;<br/>
						<input type="checkbox" id="check_one_input1" disabled="ture" value="1" />����ͨ�ŷ�&nbsp;<br/>
						<input type="checkbox" id="check_one_input2" disabled="ture" value="2"/>������&nbsp;<br/>
						<input type="checkbox" id="check_one_input3" disabled="ture" value="3"/>�̲��ŷ�&nbsp;<br/>
						<input type="checkbox" id="check_one_input4" disabled="ture" value="4"/>������ֵҵ�����&nbsp;<br/>
						<input type="checkbox" id="check_one_input5" disabled="ture" value="5"/>���շ�ҵ�����&nbsp;<br/>
						<input type="checkbox" id="check_one_input6" disabled="ture" value="6"/>���׷���&nbsp;<br/>
						<input type="checkbox" id="check_one_input7" disabled="ture" value="7"/>�������&nbsp;<br/>
						<input type="checkbox" id="check_one_input8" disabled="ture" value="8"/>�������&nbsp;<br/>
						<input type="checkbox" id="check_one_input9" disabled="ture" value="9"/>ר�����
					</div>
					<div style="float:left;width:80%">
						<ai:dbformfield formid="weaponInfoForm" fieldname="COST_TYPE_TWO" width="10" visible="false"/>
						<span>��������</span><br/>
						<div id="check_two_input0">
							<input type="checkbox" id="check_two0" disabled="ture" value="0" />���ײ������&nbsp;
							<input type="checkbox" id="check_two1" disabled="ture" value="1" />���������ײ������&nbsp;
							<input type="checkbox" id="check_two2" disabled="ture" value="2" />���������ײ������&nbsp;
							<input type="checkbox" id="check_two3" disabled="ture" value="3" />�����ײ͡������ײ�����������&nbsp;<br/>
						</div>
						<div id="check_two_input1">
							<input type="checkbox" id="check_two4" disabled="ture" value="4" />��������ͨ�ŷ�&nbsp;
							<input type="checkbox" id="check_two5" disabled="ture" value="5" />���ʼ��۰�̨����ͨ�ŷ�&nbsp;<br/>
						</div>
						<div id="check_two_input2">
							<input type="checkbox" id="check_two6" disabled="ture" value="6" />��������ͨ�ŷ�&nbsp;
							<input type="checkbox" id="check_two7" disabled="ture" value="7" />���ʼ��۰�̨����ͨ�ŷ�&nbsp;<br/>
						</div>
						<div id="check_two_input3">
							<input type="checkbox" id="check_two8" disabled="ture" value="8" />���ڶ̲���ͨ�ŷ�&nbsp;
							<input type="checkbox" id="check_two9" disabled="ture" value="9" />���ڶ̲���ͨ�ŷ�&nbsp;<br/>
						</div>
						<div id="check_two_input4">
							<input type="checkbox" id="check_two10" disabled="ture" value="10" />������ֵҵ�����&nbsp;<br/>
						</div>
						<div id="check_two_input5">
							<input type="checkbox" id="check_two11" disabled="ture" value="11" />���շ�ҵ�����&nbsp;<br/>
						</div>
						<div id="check_two_input6">
							<input type="checkbox" id="check_two12" disabled="ture" value="12" />���׷���&nbsp;<br/>
						</div>
						<div id="check_two_input7">
							<input type="checkbox" id="check_two13" disabled="ture" value="13" />�������&nbsp;<br/>
						</div>
						<div id="check_two_input8">
							<input type="checkbox" id="check_two14" disabled="ture" value="14" />�������&nbsp;<br/>
						</div>
						<div id="check_two_input9">
							<textarea class="dbform_disable_style" id="check_two15" disabled="disabled"
							style="OVERFLOW-X: auto; OVERFLOW-Y: auto;height:40px;width:240px"></textarea>
						</div>
					</div>
				</td>
			</tr>
	        <tr id="trFee">
				<td class="td_font">���ѵֿ۵�ʱ�䷶Χ��</td>
				<td>
					<ai:dbformfield formid="weaponInfoForm" fieldname="TEL_FEE_DEDUCTION_TIME" width="150" />
				</td>
			</tr>
            
            <tr id="tr1">
              	<td  colspan="2"><b>Ԥ�棺</b></td>
	           	<td class="td_font">Ԥ��ר�Χ�����飺</td>
								<td>
							<ai:dbformfield formid="weaponInfoForm"
								fieldname="DYNAMIC_SCORE" width="150" />
	           	<!-- <td>Ԥ��ר�Χ��Ŀ�<img id="selectOrgTypeYCZK" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="ycTagItem()" align=""
								style="cursor: hand;" /></td> -->
            </tr>
            <tr id="tr2">
                <td class="td_font" >Ԥ�滰�ѽ�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESTORE_FEE" width="150"/>(Ԫ)</td>
                <td class="td_font">Ԥ��һ���Ե��ʣ�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESTRORE_REACH_ACCOUNT" width="150"/>(Ԫ)</td>
            </tr>
              <tr id="tr3">
                <td class="td_font">������ȣ�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="B_LIMIT" width="150"/></td>
                <td class="td_font">�����·ݣ�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="BACK_MONTH" width="150"/></td>
            </tr>
               <tr id="tr4">
                 	<td colspan="2"><b>���ͣ�</b></td> 
	           		<td class="td_font">����ר�Χ������:</td>
								<td>
							<ai:dbformfield formid="weaponInfoForm"
								fieldname="HOME_SCORE" width="150" />
							</td>
	           	<!--  	 <td>����ר�Χ��Ŀ�<img id="selectOrgTypeYCZK" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="zsTagItem()" align="absmiddle"
								style="cursor: hand;" /></td>-->
            </tr>
            
           <tr id='jfl_tr' style="display: none">
						<td class="td_font">���ͻ��֣�</td>
						<td><ai:dbformfield formid="weaponInfoForm" fieldname="STANDBY_NUM2" width="150" editable="false"/>
						</td>
			</tr>
			
            <tr id="tr5">
                <td class="td_font">���ͻ��ѽ�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_BUSI_AMOUNT" width="150"/>(Ԫ��</td>
                <td class="td_font">����һ���Ե��ʣ�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_REACH_AMOUNT" width="150"/>(Ԫ��</td>
            </tr>
          	<tr id="tr25">
                <td class="td_font">����ȯ�ܽ�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="ADD_MONTHCHARGE" width="150"/>(Ԫ��</td>
                <td class="td_font">�������ԣ�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="RETURN_TYPE" width="150"/>(Ԫ��</td>
            </tr>
             <tr id="tr24">
                <td class="td_font">�״η�����</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="FIRSTCHARGE" width="150"/>(Ԫ��</td>
                <td class="td_font">ĩ�η�����</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="LASTCHARGE" width="150"/></td>
                </tr>
            <tr id="tr6">
                <td class="td_font">ÿ������ֵ��</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_BUSI2_AMOUNT" width="150"/>(Ԫ��</td>
                <td class="td_font">�������ڣ�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="STANDBY_NUM1" width="150"/></td>
            </tr>
            <tr id="tr25_hb">
                <td class="td_font">�Ͱ�����ܽ�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="ADD_MONTHCHARGE_HB" width="150"/>(Ԫ��</td>
                <td class="td_font">�������ԣ�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="RETURN_TYPE_HB" width="150"/>(Ԫ��</td>
            </tr>
             <tr id="tr24_hb">
                <td class="td_font">�״η�����</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="FIRSTCHARGE_HB" width="150"/>(Ԫ��</td>
                <td class="td_font">ĩ�η�����</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="LASTCHARGE_HB" width="150"/></td>
                </tr>
            <tr id="tr6_hb">
                <td class="td_font">ÿ������ֵ��</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_BUSI2_AMOUNT_HB" width="150"/>(Ԫ��</td>
                <td class="td_font">�������ڣ�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="STANDBY_NUM1_HB" width="150"/></td>
            </tr>
            <tr id="tr7" style="display:none">
                <td class="td_font">֧������������</td>
                <!--  <td><ai:dbformfield formid="weaponInfoForm" fieldname="REMARK_1" width="150"/>(Ԫ��</td> -->
                </tr>
            <tr id="tr8">
                <td class="td_font">��Ʒҵ���ܼ�ֵ��</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_BUSI3_AMOUNT" width="150"/>(Ԫ��</td>
                <td class="td_font">��Ʒ�ɹ�Ŀ¼��</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="GOOD_ADOPT_DIRECTORY" width="150"/></td>
            </tr>
            <tr id="tr9">   
                <td class="td_font">��Ʒ����ָ���ۣ�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="REFERENCE_PRICE" width="150"/>(Ԫ��</td>         
                <td class="td_font">��Ʒ������</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="REMARK_2" width="150"/>(Ԫ��</td>
                </tr>
            <tr id="tr10">
                <td class="td_font">�ն�ʵ�ʹ���</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="TERM_REAL_FEE" width="150"/>(Ԫ��</td>
                <td class="td_font">�ն����ͣ�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="TERM_TYPE" width="150"/></td>
            </tr>
            <tr id="tr11">
                <td class="td_font">�ն�����ָ���ۣ�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="TERM_GUIDE_FEE" width="150"/>(Ԫ��</td>
                <td class="td_font">�ն˳ɱ�����ۣ�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="TERM_COST_FEE" width="150"/></td>
            </tr>
            <tr id="tr12">
                <td class="td_font">�ն�������</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="REMARK_4" width="150"/>(Ԫ��</td>
                <td class="td_font">�����ʺ����ԣ�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="FEE_ACCOUNT_PROPERTY" width="150"/>(Ԫ��</td>
                </tr>
            <tr id="tr13">
                <td class="td_font">���ֲ�Ʒ�ܼ۸�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_BUSI5_AMOUNT" width="150"/>(Ԫ��</td>
            </tr>
            <tr id="tr14">
                <td class="td_font">���ֲ�Ʒ������</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="REMARK_5" width="150"/>(Ԫ��</td>
            </tr>
            <tr id="tr15">  
               <td class="td_font"><b>��������ҵ��</b></td>
           </tr>
            <tr id="tr16">
               <td class="td_font">����ҵ���ܼ�ֵ��</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_BUSI4_AMOUNT" width="150"/>(Ԫ��</td>
                <td class="td_font">ҵ�����ͣ�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="BUSI_TYPE" width="150"/></td>
            </tr>
            <tr id="tr17" style="display:none">
                <td class="td_font">����ҵ��������</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="REMARK_3" width="150"/>(Ԫ��</td>
                </tr>
            
            <tr id="tr18">
                <td class="td_font">ÿ�����ͣ�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_VALUE_PERMON" width="150"/>(Ԫ��</td>
                <td class="td_font">�����·ݣ�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="PRESENT_BUSI_MONTH" width="150"/></td>
            </tr>
            <tr id="tr19">
                <td class="td_font"><b>���ף�</b></td>
                
            </tr>
            
            <tr id="tr20">
                <td class="td_font">���׶�ȣ�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="L_LIMIT" width="150"/></td>
                <td class="td_font">����������</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="BASE_MONTH" width="150"/></td>
            </tr>
            <tr id="tr20_0">
                <td class="td_font">�������ͣ�</td> 
               	<td>
               		<ai:dbformfield formid="weaponInfoForm" fieldname="LIM_TYPE" width="150"/><span class="font_red">(�ײ���:���װ����ײͷ���;�ײ���:�������ײͷ�֮������)</span>
               	</td>
               	<td class="td_font"></td>
                <td></td>
            </tr>
             <tr id="tr21">
                <td class="td_font"><b>���ݰ���</b></td>
            </tr>
            <tr id="tr22">
                <td class="td_font">���ݰ��ܼ�ֵ��</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="DATA_FEE" width="150"/></td>  
            
                <td class="td_font">����ҵ�����ͣ�</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="DATA_BUSI_TYPE" width="150"/></td>    
              </tr>
            <tr id="tr23">
                <td class="td_font">ÿ�¼�ֵ��</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="VALUE_PERMONTH" width="150"/></td>    
                <td class="td_font">��ͨ������</td>
                <td><ai:dbformfield formid="weaponInfoForm" fieldname="OPEN_MONTH" width="150"/></td>    
            </tr>
            <tr id="tr21">
                <td class="td_font"><b>�ۼ����֣�</b></td>
            </tr>
            <tr id="tr22">
			 	<td class="td_font">���֣�</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="GLOBAL_SCORE" width="150"/>
	           	<span class="font_red">(����Ϊ-1,��ʾ��������!)</span>
	           	</td>	
	          </tr>
			<tr id="tr23" style="display:none">
	           	<td class="td_font">�����л��֣�</td>
	           	<td><ai:dbformfield formid="weaponInfoForm" fieldname="SZX_SCORE" width="150"/></td>	
			</tr>
            <tr>
             <td class="td_font"><b>����˵����</b></td>
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
             	    <ai:col title="Ӫҵ�ʷ�ID" fieldname="TAG_CODE" width="100" editable="false" visible="true"/>
		        	<ai:col fieldname="TAG_TYPE" width="10%" editable="false" visible="true" />
		        	<ai:col title="������" fieldname="STANDBY_NUM1" width="6%" editable="false" visible="true" />
					<ai:col fieldname="NAME" width="10%" editable="false" visible="true" /> 
					<ai:col title="˰��(%)" fieldname="STANDBY_NUM2" width="6%" editable="true" visible="true" />
				    <ai:col title="ʵ������˰��(%)" fieldname="STANDBY_NUM3" width="8%" visible="true" editable="false" />
					<ai:col title="״̬" fieldname="STATE" width="6%" editable="false" visible="true" />
					<ai:col fieldname="ADD_MONTHCHARGE" title="�ܽ��" width="6%" editable="false" visible="true" />
					<ai:col fieldname="FIRSTCHARGE" title="�״ε���"  width="7%" editable="false" visible="true"/> 
					<ai:col fieldname="LASTCHARGE"  title="ĩ�ε���" width="7%" editable="false" visible="true"/> 
					<ai:col  fieldname="CHARGE" title="ÿ�½��" width="7%" visible="true"/>
					<ai:col title="ÿ������ֵ" fieldname="SUMCHARGE" width="8%" editable="false" />
					<ai:col fieldname="CYCLE"  width="7%" editable="false" visible="true"/> 
					<ai:col title="��������" fieldname="RETURN_TYPE" width="10%" editable="false" visible="true"/>
					<ai:col title="ר�Χ" fieldname="IS_SP" width="10%" editable="false" visible="true"/>
					<ai:col fieldname="AREA" width="7%" editable="false" visible="true"/>
					<ai:col title="��ǩ��ע" fieldname="REMARK_TAG" width="15%" editable="false" visible="true"/>
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

function applyWeapon(){ //��ȡ������ˢ�¼�¼
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
		//alert("����û�ı�!");
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