<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>�����޸�</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body >
<ai:contractframe id="saleWeaponMainframe" contenttype="table" title="������Ϣ" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem/>
	<ai:dbform formid="saleWeaponMainframe" 
			setname="com.asiainfo.sale.weapon.web.SETSaleWeaponMain"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="true" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponMainSV"
			implservice_querymethod="getSaleWeaponMainById(String id)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr><td class="td_font">�������ƣ�	</td>
	           	<td><ai:dbformfield formid="saleWeaponMainframe" fieldname="APPLY_NAME" width="150" editable=""/>  
	           	<span class="font_red">*</span>
	            </td>
	           	<ai:dbformfield formid="saleWeaponMainframe" fieldname="ID" visible="false"/>   
	           	<ai:dbformfield formid="saleWeaponMainframe" fieldname="WID" visible="false"/>
	           	<td class="td_font">�����ˣ�</td>
	           	<td><ai:dbformfield formid="saleWeaponMainframe" fieldname="APPLICANT" width="150" editable="false"/>
	           	<ai:dbformfield formid="saleWeaponMainframe" fieldname="PRINCIPAL" width="150" visible="false"/>
	           	<td class="td_font">���뵥λ��</td>
	           	<td><ai:dbformfield formid="saleWeaponMainframe" fieldname="ORG" width="150" editable="false"/>
	           	<ai:dbformfield formid="saleWeaponMainframe" fieldname="PROMOTE_DEPART" width="150" visible="false"/>
			</tr>
			<tr>
	           	<td class="td_font">����˵����
	           	<td colspan="5"><ai:dbformfield formid="saleWeaponMainframe" fieldname="REMARK" width="70%" height="70"/>
			</td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>

<ai:contractframe id="chargeApplyMain" contenttype="table" title="�ѱ��������ģ����Ϣ" width="100%" allowcontract="true" frameclosed="fale">
	    <ai:contractitem><%--<ai:button id="newSaleDetail" text="�½��" onclick="newSaleDetail()"/>--%>
	    <ai:button id="bt_addCharge" text="��������ģ��"  onclick="addNewModle()"/> <ai:button id="bt_addChargeDetail" text="ɾ������ģ��"  onclick="delNewModle()"/></ai:contractitem>
	    <ai:table
	        tableid="table00"
	        setname="com.asiainfo.sale.weapon.web.SETSaleWeapon"
	        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	        implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
	        implservice_querymethod="getSaleWeaponByMainId(String mainId, int $STARTROWINDEX,int $ENDROWINDEX)"
	        initial="false"   multiselect="true"  onrowchange="showApplyMain"
	        pagesize="15" editable="false" width="100%" 
	        height="100" needrefresh="true">
	        	<ai:col title="�������" fieldname="ID" visible="" width="10%"/>
	        	<ai:col title="�������" fieldname="MID" visible="" width="10%"/>
	            <ai:col title="�������" fieldname="SALE_FLAG" width="20%" />
	            <ai:col title="ϸ���г�" fieldname="MARKET_TYPE" width="20%" />
	        	<ai:col title="����" fieldname="NET_AGE" width="20%"/>
	            <ai:col title="��������" fieldname="WEAPON_NAME" width="30%" />
	    </ai:table>
		</ai:contractframe>

 <ai:contractframe id="weaponSelectForm" contenttype="table" title="�����������" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	<ai:dbform formid="weaponSelectForm" 
		setname="com.asiainfo.sale.weapon.web.SETSaleWeapon"
		     datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
					implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
					implservice_querymethod="getSaleWeaponOnlyByID(String id)" 
		onvalchange="onSaleTypeChange"  editable="true" initial="false">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
				<td class="td_font" style="display: none">��ţ�</td>
				<td style="display: none">
					<ai:dbformfield formid="weaponSelectForm" fieldname="MID" width="150" />
				</td>
				<td class="td_font">�������</td>
				<td>
					<ai:dbformfield formid="weaponSelectForm" fieldname="SALE_FLAG" width="150" />
						<span class="font_red">*</span>
				</td>
				<td class="td_font">ϸ���г���</td>
				<td>
					<ai:dbformfield formid="weaponSelectForm" fieldname="MARKET_TYPE" width="150" />
						<span class="font_red">*</span>
				</td>
				<td class="td_font">���䣺</td>
				<td>
					<ai:dbformfield formid="weaponSelectForm" fieldname="NET_AGE" width="70" visible="false" />
					<ai:dbformfield formid="weaponSelectForm" fieldname="MINNET_AGE" width="70" />��
					<ai:dbformfield formid="weaponSelectForm" fieldname="MAXNET_AGE" width="70" />(��)
						<span class="font_red">*</span>
				</td>
			</tr>
			<tr>
				<td class="td_font"><span class="font_red">��������������</span></td>
        		<td colspan=5 ><ai:dbformfield formid="weaponSelectForm" fieldname="STANDBY_NUM3" width="150"/></td>
			</tr>
			<tr>
				<td class="td_font">�������ƣ�</td>
				<td colspan="5">
					<ai:dbformfield formid="weaponSelectForm" fieldname="WEAPON_NAME" width="750" height="40" />
						<span class="font_red">*</span>
				</td>
			</tr>
	     </table>
	</ai:dbform>
</ai:contractframe>
	           	
<ai:contractframe id="weaponMainSelectframe1" contenttype="table" title="��ϸ����" width="100%" allowcontract="true" frameclosed="fale">
<ai:contractitem><ai:button text="����һ���Ե���" id="query1" onclick="showReach()" />	
	</ai:contractitem>															
	<ai:dbform formid="weaponSelectForm1" 
		setname="com.asiainfo.sale.weapon.web.SETSaleWeapon"
	 datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
					implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
					implservice_querymethod="getSaleWeaponOnlyByID(String id)"  onvalchange="onReturnTypeChange" initial="false" >
			
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2"  style="display:none">
		
			<tr>
	           	<td class="td_font">��ţ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="WID" width="150"/>
	           		<ai:dbformfield formid="weaponSelectForm1" fieldname="MID" width="150"/>
	           		<ai:dbformfield formid="weaponSelectForm1" fieldname="STATE" width="150"/>
	           		<ai:dbformfield formid="weaponSelectForm1" fieldname="STANDBY_NUM3" width="10" visible="false"/>
	           	</td>
	           	<td class="td_font">���ƣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="WEAPON_NAME" width="150"/></td>

			</tr>
			<tr>
	           	<td class="td_font">ϸ���г���</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="MARKET_TYPE" width="150"	/></td>
	           	<td class="td_font">���䣺</td>
	          	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="NET_AGE" width="70" visible="false"/>
	           	<ai:dbformfield formid="weaponSelectForm1" fieldname="MINNET_AGE" width="70"/>��<ai:dbformfield formid="weaponSelectForm1" fieldname="MAXNET_AGE" width="70"/>(��)<span class="font_red">*</span></td>
	         </tr>
	        <tr>
		    <td class="td_font">����</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="SALE_FLAG" width="150"/></td>
	           	</tr>
	           		</table>
		<table  width="98%" align="center" border="0" cellpadding="1" cellspacing="2" id="tab">
		      
		      <tr id="tr1">
	           	<td class="td_font"><b>Ԥ��:</b></td>
	           	 <td>(Ԥ���ʶ��ѯ)
	           	<img id="selectOrgType" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif"  alt="" onClick="prepCondition()" align="absmiddle" style="cursor:hand;"/>
	       	     <ai:button text="���" id="clearFee" onclick="clearPrep()" />
	       </td>
			</tr>
			<tr  id="tryc">
					<td class="td_font">
							Ԥ��ר�Χ��
						</td>
						<td >
						<ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_3"
								width="350" />
								<img id="selectOrgTypeYCZK" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="zkfwCondition()" align="absmiddle"
								style="cursor: hand;" />
								</td>
								<td class="td_font">Ԥ��ר�Χ�����飺</td>
								<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="DYNAMIC_SCORE" width="150" />
							</td>
								<!-- <td>Ԥ��ר�Χ��Ŀ�<img id="selectOrgTypeYCZK" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="ycTagItem()" align="absmiddle"
								style="cursor: hand;" /></td> -->
					</tr>
		    <tr id="tr2">
	           	<td class="td_font" >Ԥ�滰�ѽ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESTORE_FEE" width="150"/>(Ԫ)</td>
	           	<td class="td_font">Ԥ��һ���Ե��ʣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESTRORE_REACH_ACCOUNT" width="150"/>(Ԫ)</td>
			</tr>
			  <tr id="tr3">
	           	<td class="td_font">ÿ�·�����ȣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="B_LIMIT" width="150"/>(Ԫ)</td>
	           	<td class="td_font">�����·ݣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="BACK_MONTH" width="150"/></td>
			</tr>
			
			<tr id="trFeeLevel">
				<td class="td_font">���ѿɷ�ֿۣ�</td>
				<td colspan="3">
					<ai:dbformfield formid="weaponSelectForm1" fieldname="COST_TYPE_ONE" width="10" visible="false"/>
					<div style="float:left;width:20%">
						<span>һ������</span><br/>
						<input type="checkbox" id="check_one_input0" name="costOne" value="0"/>�ײͼ��̶���&nbsp;<br/>
						<input type="checkbox" id="check_one_input1" name="costOne" value="1" />����ͨ�ŷ�&nbsp;<br/>
						<input type="checkbox" id="check_one_input2" name="costOne" value="2"/>������&nbsp;<br/>
						<input type="checkbox" id="check_one_input3" name="costOne" value="3"/>�̲��ŷ�&nbsp;<br/>
						<input type="checkbox" id="check_one_input4" name="costOne" value="4"/>������ֵҵ�����&nbsp;<br/>
						<input type="checkbox" id="check_one_input5" name="costOne" value="5"/>���շ�ҵ�����&nbsp;<br/>
						<input type="checkbox" id="check_one_input6" name="costOne" value="6"/>���׷���&nbsp;<br/>
						<input type="checkbox" id="check_one_input7" name="costOne" value="7"/>�������&nbsp;<br/>
						<input type="checkbox" id="check_one_input8" name="costOne" value="8"/>�������&nbsp;<br/>
						<input type="checkbox" id="check_one_input9" name="costOne" value="9"/>ר�����
					</div>
					<div style="float:left;width:80%">
						<ai:dbformfield formid="weaponSelectForm1" fieldname="COST_TYPE_TWO" width="10" visible="false"/>
						<span>��������</span><br/>
						<div id="check_two_input0">
							<input type="checkbox" id="check_two0" name="costTwo" value="0" />���ײ������&nbsp;
							<input type="checkbox" id="check_two1" name="costTwo" value="1" />���������ײ������&nbsp;
							<input type="checkbox" id="check_two2" name="costTwo" value="2" />���������ײ������&nbsp;
							<input type="checkbox" id="check_two3" name="costTwo" value="3" />�����ײ͡������ײ�����������&nbsp;<br/>
						</div>
						<div id="check_two_input1">
							<input type="checkbox" id="check_two4" name="costTwo" value="4" />��������ͨ�ŷ�&nbsp;
							<input type="checkbox" id="check_two5" name="costTwo" value="5" />���ʼ��۰�̨����ͨ�ŷ�&nbsp;<br/>
						</div>
						<div id="check_two_input2">
							<input type="checkbox" id="check_two6" name="costTwo" value="6" />��������ͨ�ŷ�&nbsp;
							<input type="checkbox" id="check_two7" name="costTwo" value="7" />���ʼ��۰�̨����ͨ�ŷ�&nbsp;<br/>
						</div>
						<div id="check_two_input3">
							<input type="checkbox" id="check_two8" name="costTwo" value="8" />���ڶ̲���ͨ�ŷ�&nbsp;
							<input type="checkbox" id="check_two9" name="costTwo" value="9" />���ڶ̲���ͨ�ŷ�&nbsp;<br/>
						</div>
						<div id="check_two_input4">
							<input type="checkbox" id="check_two10" name="costTwo" value="10" />������ֵҵ�����&nbsp;<br/>
						</div>
						<div id="check_two_input5">
							<input type="checkbox" id="check_two11" name="costTwo" value="11" />���շ�ҵ�����&nbsp;<br/>
						</div>
						<div id="check_two_input6">
							<input type="checkbox" id="check_two12" name="costTwo" value="12" />���׷���&nbsp;<br/>
						</div>
						<div id="check_two_input7">
							<input type="checkbox" id="check_two13" name="costTwo" value="13" />�������&nbsp;<br/>
						</div>
						<div id="check_two_input8">
							<input type="checkbox" id="check_two14" name="costTwo" value="14" />�������&nbsp;<br/>
						</div>
						<div id="check_two_input9">
							<textarea class="dbform_textarea_style" id="check_two15" onfocus="hideText()" onblur="showText()"
							style="OVERFLOW-X: auto; OVERFLOW-Y: auto;height:40px;width:240px"></textarea>
						</div>
					</div>
				</td>
			</tr>
	        <tr id="trFee">
				<td class="td_font">���ѵֿ۵�ʱ�䷶Χ��</td>
				<td>
					<ai:dbformfield formid="weaponSelectForm1" fieldname="TEL_FEE_DEDUCTION_TIME" width="150" />
				</td>
			</tr>
			
			   <tr id="tr4">
	           	<td class="td_font"><b>����:</b></td>
	           	 <td id="tdzs">(���ͱ�ʶ��ѯ1)<img id="selectOrgType" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif"  alt="" onClick="feeCondition()" align="absmiddle" style="cursor:hand;"/>
	           	 <ai:button text="���1" id="clearPre" onclick="clearFee()"/></td>
	           	 <td id="tdzsdz" style="display:none">(���ͱ�ʶ��ѯ2)<img id="selectDZ" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif"  alt="" onClick="feedzCondition()" align="absmiddle" style="cursor:hand;"/>
	           	 <ai:button text="���2" id="clearPre" onclick="clearFee()"/></td>
	           	 <td id="tdzshp" style="display:none">(���ͱ�ʶ��ѯ3)<img id="selectDZ" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif"  alt="" onClick="feehpCondition()" align="absmiddle" style="cursor:hand;"/>
	           	 <ai:button text="���3" id="clearPre" onclick="clearFee()"/></td>
	           	 <td id="clearBusi"> <ai:button text="���" id="clearPre" onclick="clearFee()"/></td>
			</tr>
			
			<!-- ������ -->
			<tr id='jfl_tr' style="display: none">
				<td class="td_font">���ͻ��֣�</td>
				<td><ai:dbformfield formid="weaponSelectForm1" fieldname="STANDBY_NUM2" width="150" editable="false"/>
					<img id="selectJfType" border="0"
						src="<%=request.getContextPath()%>/webframe/images/query.gif"
						alt="" onClick="jfCondition()" align="absmiddle" style="cursor: hand;" />
						<ai:button text="���" id="clearJf" onclick="clearjfl()" /> </td>
			</tr>
					
				<tr  id="trzs">
						<td class="td_font">
							����ר�Χ��
						</td>
						<td > 
					
						<ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_2"
								width="350" />
								<img id="selectOrgTypeZSZK" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="zkfwConditionz()" align="absmiddle"
								style="cursor: hand;" />
						</TD>
						<td class="td_font">����ר�Χ������:</td>
								<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="HOME_SCORE" width="150" />
							</td>
							<!-- 
							<td>����ר�Χ��Ŀ�<img id="selectOrgTypeYCZK" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="zsTagItem()" align="absmiddle"
								style="cursor: hand;" /></td>
								 -->
					</tr>
			<tr id="tr5">
	           	<td class="td_font">���ͻ��ѽ�</td>
	           	<td><table>
	           <tr>	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI_AMOUNT" width="150"/>(Ԫ)</td>
	           		<td><img  id="sjyw1"  border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif"  alt="" onClick="feeCondition()" align="absmiddle" style="cursor:hand;"/></td>
	           </tr>
	           	</table>
	           	</td>
	           	<td class="td_font">����һ���Ե��ʣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_REACH_AMOUNT" width="150"/>(Ԫ)</td>
			</tr>
			<tr id="tr18">
	           	<td class="td_font">ÿ�����Ͷ�ȣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_VALUE_PERMON" width="150"/>(Ԫ)</td>
				<td class="td_font">��������:</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI_MONTH" width="150"/></td>
			</tr>
			<tr id="tr24">
					<td class="td_font">
							����ȯ�ܽ�
						</td>
						<td>
						<table>
						<tr><td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="ADD_MONTHCHARGE"
								width="150" />(Ԫ)
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
							�������ԣ�
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="RETURN_TYPE"
								width="150" />
							<span id="showzfq" class="font_red">*</span>
						</td>
					</tr>
					<tr id="tr25">
					<td class="td_font">
							�״η�����
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="FIRSTCHARGE"
								width="150" />
							<span id="" class="font_red">*</span>
						</td>
						<td class="td_font">
							ĩ�η�����
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="LASTCHARGE"
								width="150" />
							<span id="" class="font_red">*</span>
						</td>
					</tr>
					<tr id="tr6">
						<td id="td6" class="td_font">
							ÿ������ֵ��
						</td>
						<td id="td7">
							<ai:dbformfield formid="weaponSelectForm1"
											fieldname="PRESENT_BUSI2_AMOUNT" width="150" />
										(Ԫ)
						</td>
						<td class="td_font">
							�������ڣ�
						</td>
						<td>
							<ai:dbformfield formid="weaponSelectForm1" fieldname="STANDBY_NUM1"
								width="150" />
							<span id="" class="font_red">*</span>
						</td>
					</tr>
			<tr id="tr7">
	           	<td class="td_font">֧������������</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_1" width="150"/></td>
	           	</tr>
			<tr id="tr8">
			    <td class="td_font">��Ʒҵ���ܼ�ֵ��</td>
	           	<td><table>
	           <tr>	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI3_AMOUNT" width="150"/>(Ԫ)</td>
	           		<td><img id="sjyw3" style="display:none" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif"  alt="" onClick="feehpCondition()" align="absmiddle" style="cursor:hand;"/></td>
	           </tr>
	           	</table>
	           	</td>
	           	<td class="td_font">��Ʒ�ɹ�Ŀ¼��</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="GOOD_ADOPT_DIRECTORY" width="150"/></td>
			</tr>
			<tr id="tr9"> 	
			    <td class="td_font">��Ʒ����ָ���ۣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="REFERENCE_PRICE" width="150"/>(Ԫ)</td>         
	           	<td class="td_font" style="display:none;">��Ʒ������</td>
	           	</tr>
			<tr id="tr10">
	           	<td class="td_font">�ն�ʵ�ʹ���</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="TERM_REAL_FEE" width="150"/>(Ԫ)</td>
	           	<td class="td_font">�ն����ͣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="TERM_TYPE" width="150"/></td>
			</tr>
			<tr id="tr11">
	           	<td class="td_font">�ն�����ָ���ۣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="TERM_GUIDE_FEE" width="150"/>(Ԫ)</td>
	           	<td class="td_font">�ն˳ɱ�����ۣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="TERM_COST_FEE" width="150"/></td>
			</tr>
			<tr id="tr12">
	           	<td class="td_font" style="display:none;">�ն�������</td>
	           	<td style="display:none;"><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_4" width="150"/>(Ԫ)</td>
	            <td class="td_font">�����ʺ����ԣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="FEE_ACCOUNT_PROPERTY" width="150"/></td>
	           	</tr>
			<tr id="tr13">
	           	<td class="td_font">���ֲ�Ʒ�ܼ۸�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI5_AMOUNT" width="150"/>(Ԫ)</td>
	 		</tr>
	 		<tr id="tr14">
	           	<td class="td_font">���ֲ�Ʒ������</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_5" width="150"/>(Ԫ)</td>
	 		</tr>
	 		<tr id="tr15">	
		 	   <td class="td_font"><b>��������ҵ��</b></td>
		 	  <td>(ҵ���ʶ��ѯ) <img id="selectOrgType" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif"  alt="" onClick="busitypeCondition()" align="absmiddle" style="cursor:hand;"/>
	          <ai:button text="���" id="clearFee" onclick="clearFee1()" /></td>
	       </tr>
	 		<tr id="tr16">
	           <td class="td_font">����ҵ���ܼ�ֵ��</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI4_AMOUNT" width="150"/>(Ԫ)</td>
	           	<td class="td_font">ҵ�����ͣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="BUSI_TYPE" width="200"/></td>
			</tr>
			<tr id="tr17">
	           	<td class="td_font">����ҵ��������</td>
	           	</tr>
			
			<tr id="tr19">
	           	<td class="td_font"><b>����:</b></td>
	           	 <td>(���ױ�ʶ��ѯ)
	           	  	<img id="selectOrgType" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif"  alt="" onClick="baseCondition()" align="absmiddle" style="cursor:hand;"/>
	          <ai:button text="���" id="clearFee" onclick="clearBase()" />  </td>
			</tr>
			<tr id="tr20">
		        <td class="td_font">ÿ�±��׶�ȣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="L_LIMIT" width="150"/>(Ԫ)</td>
	           	<td class="td_font">��������:</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="BASE_MONTH" width="150"/></td>
			</tr>
			 <tr id="tr21">
	           	<td class="td_font"><b>���ݰ���</b></td>
	           	 <td>(���ݰ���ʶ��ѯ)
	           	 	<img id="selectOrgType" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif"  alt="" onClick="busiCondition()" align="absmiddle" style="cursor:hand;"/>
	           <ai:button text="���" id="clearFee" onclick="clearBusi()" /></td>
			</tr>
			<tr id="tr22">
			 	<td class="td_font">���ݰ��ܼ�ֵ:</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="DATA_FEE" width="150"/></td>	
			
	           	<td class="td_font">����ҵ������:</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="DATA_BUSI_TYPE" width="200"/></td>	
	          </tr>
			<tr id="tr23">
	           	<td class="td_font">ÿ�¼�ֵ:</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="VALUE_PERMONTH" width="150"/></td>	
	           	<td class="td_font">��ͨ����:</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="OPEN_MONTH" width="150"/></td>	
			</tr>
			<tr id="">
	           	<td class="td_font"><b>�ۼ�����:</b></td>
	           		<td>
							<ai:button text="��������" id="clearsc" onclick="clearScore()" />
							<ai:button text="���" id="clearscore" onclick="clearScoreButton()" />
							</td>
			</tr>
			<tr id="">
			 	<td class="td_font">����:</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="GLOBAL_SCORE" width="150"/>
	           	<span class="font_red">(����Ϊ-1,��ʾ��������!)</span></td>	
	          </tr>
			<tr id="" style="display:none">
	           	<td class="td_font">�����л���:</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="SZX_SCORE" width="150"/></td>	
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<div id="div1" class="area_button" style="display:none"><span class="font_red"><b>��ѡ���˱��ñ�ǩ��</b></span></div>

  <div class="area_button">
  <ai:button text="����" id="query2" onclick="doWork('addWeaponInfo()')" />&nbsp;&nbsp;
  <!--����<a href>�򿪵Ĵ��ڱ���ʹ�á�#nogo��; -->
</div>
<div class="area_button" style="display: none;">
			��һ���������ˣ�<select name="opTypeId_a" id="opTypeId_a" style="width:150px" onchange="onSelectchg();">
                    <option value="20005341">
                         �ǳ���
                    </option>
					<option value="20005232">
					��˼
                    </option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;
  <ai:button text="�ύ" id="query3" onclick="doWork('commitWeaponInfo()')"  />&nbsp;&nbsp;
</div>
</body>
</html>

<ai:loginuser/>
<script type="text/javascript">
  
var weaponSelectForm = g_FormRowSetManager.get("weaponSelectForm");
var weaponSelectForm1 = g_FormRowSetManager.get("weaponSelectForm1");
var saleWeaponMainframe = g_FormRowSetManager.get("saleWeaponMainframe");
var table00 = g_TableRowSetManager.get("table00");
var typeCode="<%=request.getParameter("type")%>";
var rwid="<%=request.getParameter("wid")%>";
var pid="<%=request.getParameter("pid")%>";
var isarea1=false;
var isarea2=false;
var isarea3=false;
var isarea4=false;
var isarea5=false;
var isarea6=false;
var isarea7=false;
var isarea8=false;
var isarea9=false;
var issp1=false;
var issp2=false;
var issp3=false;
var issp4=false;
var issp5=false;
var issp6=false;
var issp7=false;
var issp8=false;
var issp9=false;

initpage();
function showApplyMain(oldIndex,newIndex){
	if(-1 != oldIndex) {
     	 table00.setRowBgColor(oldIndex,"");
   	}
   	table00.setRowBgColor(newIndex,"yellow");
   	var applyid = table00.getValue(newIndex,"ID");
	if(applyid != null && applyid != ""){
		weaponSelectForm.refresh("&id="+applyid);
		onSaleTypeChange("SALE_FLAG","","","","");
		weaponSelectForm1.refresh("&id="+applyid);
	}
	showCheckBox();
}
	
function addNewModle(){
	if(saleWeaponMainframe.getValue("APPLY_NAME")==""){
		return alert("�����빤������!");
	}
	weaponSelectForm.newRow();
	weaponSelectForm1.newRow();
	g_AIButtonManager.get("query2").setDisabled(false);
	weaponSelectForm.setColEditSts("SALE_FLAG",true);
	weaponSelectForm.setColEditSts("WEAPON_NAME",false);
	weaponSelectForm.setValue("SALE_FLAG",11);
	clearAttachCfgOpt();
	weaponSelectForm.refreshListBox("MARKET_TYPE","codeType=markets",true);
	weaponSelectForm.refreshListBox("SALE_FLAG","codeType=hdlxs",true);
	if(AIContractFrame_closeMe()){
	}else{
	  //AIContractFrame_OpenClose("weaponSelectForm");
	  //AIContractFrame_OpenClose("weaponMainSelectframe1");
	}
	var costOne = document.getElementsByName("costOne");
	var costTwo = document.getElementsByName("costTwo");
	for(var i=0;i<costOne.length;i++){
		costOne[i].checked = true;
	}
	for(var i=0;i<costTwo.length;i++){
		costTwo[i].checked = true;
	}
	var newMainid = saleWeaponMainframe.getValue("ID");
	if(saleWeaponMainframe.getValue("ID")==""){
		if ("O" != saleWeaponMainframe.getSts()){
		//����������������
			addWeaponMail();
			var id = weaponSelectForm1.getValue("MID");
			saleWeaponMainframe.setValue("ID",id);
			saleWeaponMainframe.refresh("&id="+ id);
			saleWeaponMainframe.setValue("APPLICANT",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
	   		saleWeaponMainframe.setValue("PRINCIPAL",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
	   		saleWeaponMainframe.setValue("PROMOTE_DEPART",g_GetUserInfo().ORG_ID,g_GetUserInfo().ORG_NAME);
			saleWeaponMainframe.setValue("ORG",g_GetUserInfo().ORG_ID,g_GetUserInfo().ORG_NAME);
		}
	}else{
		saleWeaponMainframe.setValue("ID",newMainid);
		weaponSelectForm1.setValue("MID",newMainid);
   		weaponSelectForm.setValue("MID",newMainid);
	}
}
	
function delNewModle(){
	var ss = new Array();
	ss = table00.getSelectedRows();
	if (ss.length < 1) {
   		alert("�빴ѡҪɾ�������ݣ�");
   		return;
	}
    for ( var i = ss.length; i > 0; i--) {
        table00.deleteRow(ss[i - 1]);
    }
    var list = new Array();
    list.push(table00);
    //ɾ��������ϸ��Ϣ��ļ�¼
    //ɾ�������������ǩ������Ϣ��
    var strUrl = _gModuleName + '/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=delWeaponTageRela';
    var recode = saveRowSet(strUrl, list);
    if (recode.getValueByName("FLAG") == "Y") {
    	alert("�����ɹ���");
    }
    weaponSelectForm.newRow();
	weaponSelectForm1.newRow();
	g_AIButtonManager.get("query2").setDisabled(false);
	weaponSelectForm.setColEditSts("SALE_FLAG",true);
	weaponSelectForm.setColEditSts("WEAPON_NAME",false);
	weaponSelectForm.setValue("SALE_FLAG",11);
	weaponSelectForm.refreshListBox("MARKET_TYPE","codeType=markets",true);
	weaponSelectForm.refreshListBox("SALE_FLAG","codeType=hdlxs",true);
}

function showText(){
	var testareaText = document.getElementById("check_two15");
	if(document.getElementById("check_one_input9").checked){
		if(testareaText.value.replace(/^\s+|\s+$/gm,'') ==""){
			testareaText.innerHTML = "��������ר�����";
		}
	}else{
		testareaText.innerHTML = "";
	}
}

function hideText(){
	var testareaText = document.getElementById("check_two15");
	if(document.getElementById("check_one_input9").checked){
		if(testareaText.value =="��������ר�����"){
			testareaText.innerHTML = "";
		}
	}else{
		testareaText.innerHTML = "";
	}
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
   	var textArea = document.getElementById("check_two15");
   	textArea.onfocus = null;
   	textArea.onblur = null;
}
	
function initpage(){

	if(typeCode=="aduit"){
		document.getElementById("query3").style.display="none";
	}
	//updateInfo();
	table00.refresh("&mainId="+rwid);
	saleWeaponMainframe.refresh("&id="+rwid);
	weaponSelectForm.refresh("&id="+pid);
    var staffId = g_GetUserInfo().STAFF_ID;
    saleWeaponMainframe.setValue("APPLICANT",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
    saleWeaponMainframe.setValue("PRINCIPAL",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
    saleWeaponMainframe.setValue("PROMOTE_DEPART",g_GetUserInfo().ORG_ID,g_GetUserInfo().ORG_NAME);
	saleWeaponMainframe.setValue("ORG",g_GetUserInfo().ORG_ID,g_GetUserInfo().ORG_NAME);
    initDate();
    weaponSelectForm.refreshListBox("MARKET_TYPE","codeType=markets",true);
    weaponSelectForm.refreshListBox("SALE_FLAG","codeType=hdlxs",true);
	onSaleTypeChange("SALE_FLAG","","","","");
	//weaponSelectForm1.refresh("&wid="+rwid+"&weaponName="+"&busiType=");
	weaponSelectForm1.refresh("&id="+pid);
	weaponSelectForm.setColEditSts("SALE_FLAG",false);
	weaponSelectForm.setColEditSts("WID",false);
	var wid=weaponSelectForm1.getValue("WID");
	var strUrl = _gModuleName + '/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=selectAreaAndSp&wtid='+wid;
	var recode = PostInfo(strUrl);
	if(recode.getValueByName("AREA1")=="true"){
		isarea1=true;
	}else if(recode.getValueByName("AREA2")=="true"){
		isarea2=true;
	}else if(recode.getValueByName("AREA3")=="true"){
		isarea3=true;
	}else if(recode.getValueByName("AREA4")=="true"){
		isarea4=true;
	}else if(recode.getValueByName("AREA5")=="true"){
		isarea5=true;
	}else if(recode.getValueByName("AREA6")=="true"){
		isarea6=true;
	}else if(recode.getValueByName("AREA7")=="true"){
		isarea7=true;
	}
	 weaponSelectForm.setColEditSts("WEAPON_NAME",false);//0920
	 weaponSelectForm1.setColEditSts("REMARK_2",false);
	 weaponSelectForm1.setColEditSts("REMARK_3",false);
	 weaponSelectForm1.setColEditSts("DYNAMIC_SCORE",false);
	 weaponSelectForm1.setColEditSts("HOME_SCORE",false);
	 weaponSelectForm1.setColEditSts("ADD_MONTHCHARGE",false);
	 showCheckBox();
}

function commitWeaponInfo(){
	var approver = document.getElementById("opTypeId_a").value;//��һ���������˹���
	if(approver==""){
		return	alert("��ѡ����һ���������ˣ�");
	}
    var weaponName=weaponSelectForm.getValue("WEAPON_NAME");
	var marketType=weaponSelectForm.getValue("MARKET_TYPE");
	var netAge=weaponSelectForm.getValue("NET_AGE");
	var saleFlag=weaponSelectForm.getValue("SALE_FLAG");
	var createTime=saleWeaponMainframe.getValue("CREATE_TIME");
	var wmid=weaponSelectForm1.getValue("MID");
	var wid= "";//weaponSelectForm1.getValue("WID");
	var vstate=weaponSelectForm1.getValue("STATE");
	var addorapp=<%=request.getParameter("addorapp")%>;
	var list = new Array();
    if(weaponName==""||createTime==""){
    	alert("���ȱ��棡");
    }else{
	    var wtid=wtid1+","+wtid2+","+wtid3+","+wtid4+","+wtid5+","+wtid6+","+wtid7;
	    var count = table00.count();
	    if(count > 0){
			for(var i = 0; i < count; i++){
				wid = wid + table00.getValue(i,"ID")+";";
			}
		}
		var strUrl = _gModuleName + '/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=commitSaleWeapon&wtid='+wtid+'&wid='+wid+"&mid="+wmid+"&weaponName="+weaponName+"&approver="+approver;
		var recode = PostInfo(strUrl);
		if ("Y" == recode.getValueByName("FLAG")){
			alert("�ύ�ɹ���");
			location.reload();
		}
		if("C" == recode.getValueByName("FLAG")){
			return alert("������ͬ���������У����ѯ����״̬��");
		}else if("W" == recode.getValueByName("FLAG")){
			return alert("������ͬ���������У����ѯ������ֱ��ʹ�ã�");
		}else if("U" == recode.getValueByName("FLAG")){
			return alert("������ͬ�������ã����ѯ������ֱ��ʹ�ã�");
		}
	}
  	window.opener.queryWeaponMain();
  	window.self.close();
}

var orgid=g_GetUserInfo().ORG_ID;
var wtid4="";
function prepCondition(){
	var tagType="4";
	var returnP=window.showModalDialog("<%=request.getContextPath()%>/sale/promationTag/promationTag.jsp?tagType="+tagType+"&orgid="+orgid,"","dialogWidth=800px"); 
	if(returnP!=null){
		weaponSelectForm1.setValue("B_LIMIT",returnP.split(",")[1]);
		weaponSelectForm1.setValue("BACK_MONTH",returnP.split(",")[0]);
		weaponSelectForm1.setValue("REMARK_3",returnP.split(",")[7]);
		weaponSelectForm1.setValue("DYNAMIC_SCORE",returnP.split(",")[7]);
		var state=returnP.split(",")[2];
		wtid4=returnP.split(",")[3];
		if(returnP.split(",")[6]!="10"){
			isarea4=true;
		}
		if(state==99){
			document.getElementById("div1").style.display="block";
		}else{
			document.getElementById("div1").style.display="none";
		}
	}
}
var wtid1="";
function baseCondition(){
	var tagType="1";
	var returnBd=window.showModalDialog("<%=request.getContextPath()%>/sale/promationTag/promationTag.jsp?tagType="+tagType+"&orgid="+orgid,"","dialogWidth=800px"); 
	if(returnBd!=null){
		weaponSelectForm1.setValue("L_LIMIT",returnBd.split(",")[1]);
		weaponSelectForm1.setValue("BASE_MONTH",returnBd.split(",")[0]);
		var state=returnBd.split(",")[2];
		wtid1=returnBd.split(",")[3];
		if(returnBd.split(",")[6]!="10"){
			isarea1=true;
		}
		if(state==99){
			document.getElementById("div1").style.display="block";
		}
	}
}
var wtid3="";
function busiCondition(){
var tagType="3";
    var returnFee=window.showModalDialog("<%=request.getContextPath()%>/sale/promationTag/promationTag.jsp?tagType="+tagType+"&orgid="+orgid,"","dialogWidth=800px"); 
	if(returnFee!=null){
		weaponSelectForm1.setValue("VALUE_PERMONTH",returnFee.split(",")[1]);
		weaponSelectForm1.setValue("OPEN_MONTH",returnFee.split(",")[0]);
		var state=returnFee.split(",")[2];
		wtid3=returnFee.split(",")[3];
		var name=returnFee.split(",")[4];
		weaponSelectForm1.setValue("DATA_BUSI_TYPE",name);
		
		weaponSelectForm1.setValue("DATA_FEE",returnFee.split(",")[1]*returnFee.split(",")[0]);
		if(returnFee.split(",")[6]!="10"){
			isarea3=true;
		}
		if(state==99){
			document.getElementById("div1").style.display="block";
		}
	}
}
var wtid2="";
function feeCondition(){
	var tagType="2";
	var returnFee= window.showModalDialog("<%=request.getContextPath()%>/sale/promationTag/promationTag.jsp?tagType="+tagType+"&orgid="+orgid,"","dialogWidth=800px"); 
	if(returnFee!=null){
		weaponSelectForm1.setValue("PRESENT_VALUE_PERMON",returnFee.split(",")[1]);
		weaponSelectForm1.setValue("PRESENT_BUSI_MONTH",returnFee.split(",")[0]);
		weaponSelectForm1.setValue("REMARK_2",returnP.split(",")[7]);
		weaponSelectForm1.setValue("HOME_SCORE",returnP.split(",")[7]);
		var state=returnFee.split(",")[2];
		wtid2=returnFee.split(",")[3];
		if(returnFee.split(",")[6]!="10"){
			isarea2=true;
		}
		if(state==99){
			document.getElementById("div1").style.display="block";
		}else{
			document.getElementById("div1").style.display="none";
		}
	}
}

var wtid5="";
function busitypeCondition(){
	var tagType="5";
	var returnFee= window.showModalDialog("<%=request.getContextPath()%>/sale/promationTag/promationTag.jsp?tagType="+tagType+"&orgid="+orgid,"","dialogWidth=800px"); 
	if(returnFee!=null){
		//weaponSelectForm1.setValue("PRESENT_VALUE_PERMON",returnFee.split(",")[1]);
		//weaponSelectForm1.setValue("PRESENT_BUSI_MONTH",returnFee.split(",")[0]);
	
		var state=returnFee.split(",")[2];
		wtid5=returnFee.split(",")[3];
		var name=returnFee.split(",")[4];
		weaponSelectForm1.setValue("BUSI_TYPE",name);
		weaponSelectForm1.setValue("PRESENT_BUSI4_AMOUNT",returnFee.split(",")[1]*returnFee.split(",")[0]);
		if(returnFee.split(",")[6]!="10"){
			isarea5=true;
		}
		if(state==99){
			document.getElementById("div1").style.display="block";
		}else{
			document.getElementById("div1").style.display="none";
		}
	}
}
var wtid6="";
function feedzCondition(){
var tagType="6";
	//var returnFee= window.showModalDialog("<%=request.getContextPath()%>/sale/promationTag/zfqpromationTag.jsp?tagType="+tagType+"&orgid="+orgid,"","dialogWidth=800px"); 
	var returnFee= window.showModalDialog("<%=request.getContextPath()%>/sale/promationTag/promationTag.jsp?tagType="+tagType+"&orgid="+orgid,"","dialogWidth=800px"); 
	if(returnFee!=null){
		weaponSelectForm1.setValue("ADD_MONTHCHARGE",returnFee.split(",")[1]);
		var state=returnFee.split(",")[2];
		wtid6=returnFee.split(",")[3];
		var name=returnFee.split(",")[4];
		//weaponSelectForm1.setValue("RETURN_TYPE",returnFee.split(",")[8]);
		//weaponSelectForm1.setValue("ADD_MONTHCHARGE",returnFee.split(",")[9]);
		//weaponSelectForm1.setValue("FIRSTCHARGE",returnFee.split(",")[10]);
		//weaponSelectForm1.setValue("LASTCHARGE",returnFee.split(",")[11]);
		weaponSelectForm1.setValue("STANDBY_NUM1",returnFee.split(",")[0]);
		if(returnFee.split(",")[6]!="10"){
			isarea6=true;
		}
		if(state==99){
			document.getElementById("div1").style.display="block";
		}else{
			document.getElementById("div1").style.display="none";
		}
	}
}

var wtid7="";
var wtid8="";
function feehpCondition(){
var tagType="7";
	var returnHp= window.showModalDialog("<%=request.getContextPath()%>/sale/promationTag/promationTag.jsp?tagType="+tagType+"&orgid="+orgid,"","dialogWidth=800px"); 
	if(returnHp!=null){
		weaponSelectForm1.setColEditSts("PRESENT_BUSI3_AMOUNT",false);
		weaponSelectForm1.setColEditSts("REFERENCE_PRICE",false);
		weaponSelectForm1.setColEditSts("GOOD_ADOPT_DIRECTORY",false);
		weaponSelectForm1.setValue("PRESENT_BUSI3_AMOUNT",returnHp.split(",")[1]);
		weaponSelectForm1.setValue("REFERENCE_PRICE",returnHp.split(",")[0]);
		weaponSelectForm1.setValue("GOOD_ADOPT_DIRECTORY",returnHp.split(",")[4]);
		var state=returnHp.split(",")[2];
		wtid7=returnHp.split(",")[3];
		var name=returnHp.split(",")[4];
		if(returnHp.split(",")[6]!="10"){
			isarea7=true;
		}
		if(state==99){
			document.getElementById("div1").style.display="block";
		}else{
			document.getElementById("div1").style.display="none";
		}
	}
}

var wtid9="";
function jfCondition(){
	var tagType="11";
	var saleFlag=weaponSelectForm.getValue("SALE_FLAG");
	var returnFee= window.showModalDialog("<%=request.getContextPath()%>/sale/promationTag/promationTag.jsp?tagType="+tagType+"&orgid="+orgid,"","dialogWidth=800px"); 
	if(returnFee!=null){
		weaponSelectForm1.setValue("STANDBY_NUM2",returnFee.split(",")[1]);
		
		var state=returnFee.split(",")[2];
		wtid9=returnFee.split(",")[3];
		if(returnFee.split(",")[6]!="10"){
			isarea9=true;
		}
		if(saleFlag!=31){
			wtid6="";
			wtid7="";
			isarea6=false;
			isarea7=false;
		}
		if(state==99){
			flagdiv9=true;
		}else{
			flagdiv9=false;
		}
		if(state==99){
			document.getElementById("div1").style.display="block";
		}else{
			document.getElementById("div1").style.display="none";
		}
	}
}

function addWeaponInfo(){
	var netage1=weaponSelectForm.getValue("MINNET_AGE");
	var netage2=weaponSelectForm.getValue("MAXNET_AGE");
	if(netage2-netage1<0){
		alert("�����ʽ����");
		return false;
	}

	weaponSelectForm.setValue("NET_AGE",netage1+"-"+netage2);
	var marketType=weaponSelectForm.getValue("MARKET_TYPE");
	var netAge=weaponSelectForm.getValue("NET_AGE");
	var minNetAge=weaponSelectForm.getValue("MINNET_AGE");
	var maxNetAge=weaponSelectForm.getValue("MAXNET_AGE");
	var saleFlag=weaponSelectForm.getValue("SALE_FLAG");
	var prAmount=weaponSelectForm1.getValue("PRESENT_REACH_AMOUNT");
	var prAccount=weaponSelectForm1.getValue("PRESTRORE_REACH_ACCOUNT");
	var wmName=saleWeaponMainframe.getValue("APPLY_NAME");
	var busi3=weaponSelectForm1.getValue("PRESENT_BUSI3_AMOUNT");
    var adopt=weaponSelectForm1.getValue("GOOD_ADOPT_DIRECTORY");
    var rprice=weaponSelectForm1.getValue("REFERENCE_PRICE");
    var busi2=weaponSelectForm1.getValue("ADD_MONTHCHARGE");
    var wstate=weaponSelectForm1.getValue("STATE");
    var zfqtype=weaponSelectForm1.getValue("RETURN_TYPE");
    var score=weaponSelectForm1.getValue("GLOBAL_SCORE");
    //var attachCfgOpt = getAttachCfgOpt();
	weaponSelectForm1.setValue("STANDBY_NUM3", weaponSelectForm.getValue("STANDBY_NUM3"));
    if(-1>score){
		return alert("����������������������!");
	}
	if("-1"==score){
		if (confirm("�����Ļ���ȷ��ִ���������?")){
    	} else {
    		return;
    	}
	}
	if(wmName==""){
		alert("�����������Ϣ��");
		return false;
	}
	   
	//if(saleFlag==11){
	var err=showReachPre();
	var err1=showReachfee();
	if(err==false||err1==false) {return;}
	//}
	//if(saleFlag!=11){
	//	var err=showReachfee();
	//	if(err==false){return;}
	//}
	if(saleFlag==12){
		if(busi2==""||zfqtype==""){
			alert("��ѡ����Ӿ��ʶ!");
			return;
		}
	}
	if(saleFlag==13){
		//if(busi3==""||adopt==""||rprice==""){
		//alert("��ѡ��/�������Ʒ��ʶ!");
		//return;}
	}    
	if(saleFlag==31&&datatype==""){
		return alert("��ѡ�����ݰ���ʶ!");
	}	 
	if (saleFlag==17 || saleFlag==23) {
 		if (weaponSelectForm1.getValue("STANDBY_NUM2") == "") return alert("��ѡ�����ͻ��֣�");
 	}
	addWeaponMail();
	if(weaponName==""||wmName==""){
		alert("�����������Ϣ��");
    }else{
	    var xmlbody = weaponSelectForm.toXmlString();
	    var xmlbody1 = weaponSelectForm1.toXmlString();
		var xml = "<RootInfo>" + xmlbody +xmlbody1+ "</RootInfo>";
		var list = new Array();
		showTag(saleFlag);
		var weaponName=weaponSelectForm.getValue("WEAPON_NAME");
		weaponSelectForm1.setValue("WEAPON_NAME",weaponName);
		weaponSelectForm1.setValue("MARKET_TYPE",marketType);
		weaponSelectForm1.setValue("NET_AGE",netAge);
		weaponSelectForm1.setValue("MINNET_AGE",minNetAge);
		weaponSelectForm1.setValue("MAXNET_AGE",maxNetAge);
		weaponSelectForm1.setValue("SALE_FLAG",saleFlag);
		list.push(weaponSelectForm1);
		
	    // if(saleFlag==16&&""==wtid7&&busi3!=""&&adopt!=""&&rprice!=""){
		//var strUrlhp = _gModuleName + '/business/com.asiainfo.sale.tag.web.DetailTagAction?action=saveDetailTagOnWeaponAdd&pid=0&busi2='+busi2;
		//var recodehp = PostInfo(strUrlhp,null);
		//wtid6=recodehp.getValueByName("wid");
		//}
		if ("O" != weaponSelectForm1.getSts()){
			if(saleFlag==16&&""==wtid7&&busi3!=""&&adopt!=""&&rprice!=""){
				var strUrlhp = _gModuleName + '/business/com.asiainfo.sale.tag.web.DetailTagAction?action=saveDetailTagOnWeaponAdd&pid=0&busi3='+busi3+"&adopt="+adopt+"&rprice="+rprice+"&saleFlag="+saleFlag;
				var recodehp = PostInfo(strUrlhp,null);
				wtid8=recodehp.getValueByName("wid");
			}
			
		    if(saleFlag==13&&""==wtid7&&busi3!=""){
				var strUrlhp = _gModuleName + '/business/com.asiainfo.sale.tag.web.DetailTagAction?action=saveDetailTagOnWeaponAdd&pid=0&busi3='+busi3+"&adopt="+adopt+"&rprice="+rprice+"&saleFlag="+saleFlag;
				var recodehp = PostInfo(strUrlhp,null);
				wtid7=recodehp.getValueByName("wid");
			}
			var type="update";
			var wtid=wtid1+","+wtid2+","+wtid3+","+wtid4+","+wtid5+","+wtid6+","+wtid7+","+wtid8+","+wtid9;
			//if(saleFlag==16){
			//weaponSelectForm1.setStsToNew();
			//type="new";
			//}
			var strUrl = _gModuleName + '/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=saveSaleWeaponMain&wtid='+wtid+'&saleFlag='+saleFlag+'&type='+type+'&typeCode='+typeCode;
			var recode = saveRowSet(strUrl, list);
			var wmid=recode.getValueByName("WID");
		    weaponSelectForm1.setValue("WID",wmid);
		    weaponSelectForm.setValue("WID",wmid);
		    weaponSelectForm.setColEditSts("SALE_FLAG",false);
		  	if ("Y" == recode.getValueByName("FLAG")){
			 	//g_AIButtonManager.get("query2").setDisabled(true);
				g_AIButtonManager.get("query3").setDisabled(false);
				alert("�����ɹ�!");
			}
			weaponSelectForm.refresh("&id="+wmid);
			weaponSelectForm1.refresh("&id="+wmid);
			table00.refresh("&mainId="+rwid);
			wtid1="";
			wtid2="";
			wtid3="";
			wtid4="";
			wtid5="";
			wtid6="";
			wtid7="";
			wtid8="";
			wtid9="";
		    window.opener.location.reload();
	    }else{
			//alert("����û�иı䣬����Ҫ����!");
		}
	}
}

function initDate(){
    for(var i=1;i<21;i++){
	    var num="tr"+i;
	    document.getElementById(num).style.display="none";
	    document.getElementById("tdzs").style.display="none";
	    document.getElementById("tdzsdz").style.display="none";
	    document.getElementById("tdzshp").style.display="none";
	    document.getElementById("tryc").style.display="none";
	    document.getElementById("trzs").style.display="none";
	    document.getElementById("tr24").style.display="none";
	    document.getElementById("tr25").style.display="none";
	    document.getElementById("trFee").style.display="none";
	   	document.getElementById("trFeeLevel").style.display="none";
    }
  
}
//function movebusi(){
	//   table1.moveRow(22,0);
     //  table1.moveRow(22,0);
	 //  table1.moveRow(22,0);
	 //  }
var mflag;  
function onSaleTypeChange(pFieldName,pOldVal,pOldText,pNewVal,pNewText){ 
    if(pFieldName=="SALE_FLAG"){
	    weaponSelectForm1.setColEditSts("B_LIMIT",false);
		weaponSelectForm1.setColEditSts("BACK_MONTH",false);
		weaponSelectForm1.setColEditSts("PRESENT_VALUE_PERMON",false);
		weaponSelectForm1.setColEditSts("PRESENT_BUSI_MONTH",false);
		weaponSelectForm1.setColEditSts("L_LIMIT",false);
		weaponSelectForm1.setColEditSts("BASE_MONTH",false);
		weaponSelectForm1.setColEditSts("PRESENT_REACH_AMOUNT",false);
		weaponSelectForm1.setColEditSts("PRESTRORE_REACH_ACCOUNT",false);
		weaponSelectForm1.setColEditSts("VALUE_PERMONTH",false);
		weaponSelectForm1.setColEditSts("OPEN_MONTH",false);
		weaponSelectForm1.setColEditSts("DATA_BUSI_TYPE",false);
		weaponSelectForm1.setColEditSts("DATA_FEE",false);
		weaponSelectForm1.setColEditSts("BUSI_TYPE",false);
		weaponSelectForm1.setColEditSts("PRESENT_BUSI4_AMOUNT",false);
		//weaponSelectForm1.setColEditSts("PRESENT_BUSI2_AMOUNT",false);
		weaponSelectForm.setColEditSts("WEAPON_NAME",false);//0920
	    document.getElementById("clearBusi").style.display="none";
	    document.getElementById("sjyw1").style.display="none";
		document.getElementById("sjyw2").style.display="none";
	    document.getElementById("sjyw3").style.display="none";
	    document.getElementById("jfl_tr").style.display="none";
	    var saleType = weaponSelectForm.getValue("SALE_FLAG");
	    weaponSelectForm1.newRow();
	    initDate();
	    if(saleType==31){
	      mflag=true;
	   	  if(mflag){
	   		moveY(mflag);
	   	  } 
	   	} else {
		   if(mflag){
		   moveY(mflag);
		   mflag=false;
		  }
	    }
	    if(saleType==12){
		   weaponSelectForm1.setValue("RETURN_TYPE","1");
		   document.getElementById("tdzsdz").style.display="block";
		   document.getElementById("tryc").style.display="block";
		   document.getElementById("tr1").style.display="block";
		   document.getElementById("tr2").style.display="block";
		   document.getElementById("tr3").style.display="block";
		   document.getElementById("tr4").style.display="block";
		   document.getElementById("tr19").style.display="block";
		   document.getElementById("tr20").style.display="block";
		   document.getElementById("tr24").style.display="block";
		   document.getElementById("trFee").style.display = "block";
		   document.getElementById("trFeeLevel").style.display = "block";
	    } else if(saleType==13||saleType==16){
		   if(saleType==16){
		        document.getElementById("tdzshp").style.display="none";
		   }else{
	     		document.getElementById("tdzshp").style.display="block";
	       }
	       document.getElementById("tdzshp").style.display="block";
		   document.getElementById("tr1").style.display="block";
		   document.getElementById("tryc").style.display="block";
		   document.getElementById("tr2").style.display="block";
		   document.getElementById("tr3").style.display="block";
		   //document.getElementById("tr4").style.display="block";
		   //document.getElementById("tr8").style.display="block";
		   //document.getElementById("tr9").style.display="block";
		   document.getElementById("tr19").style.display="block";
		   document.getElementById("tr20").style.display="block";
		   document.getElementById("trFee").style.display = "block";
		   document.getElementById("trFeeLevel").style.display = "block";
	   } else if(saleType==14){ 
		   document.getElementById("tr1").style.display="block";
		   document.getElementById("tryc").style.display="block";
		   document.getElementById("tr2").style.display="block";
		   document.getElementById("tr3").style.display="block";
		   document.getElementById("tr15").style.display="block";
		   document.getElementById("tr16").style.display="block";
		   document.getElementById("tr19").style.display="block";
		   document.getElementById("tr20").style.display="block";
		   document.getElementById("trFee").style.display = "block";
		   document.getElementById("trFeeLevel").style.display = "block";
	   } else if(saleType==15){
	  	   weaponSelectForm.setColEditSts("WEAPON_NAME",true); //0920
	   	   document.getElementById("clearBusi").style.display="block";
		   document.getElementById("sjyw1").style.display="block";
		   document.getElementById("sjyw2").style.display="block";
		   document.getElementById("sjyw3").style.display="block";
		   document.getElementById("tr18").style.display="block";
		   weaponSelectForm1.setColEditSts("ADD_MONTHCHARGE",true);
		   document.getElementById("showzfq").style.display="none";
		   document.getElementById("tr1").style.display="block";
		   document.getElementById("tryc").style.display="block";
		   document.getElementById("tr2").style.display="block";
		   document.getElementById("tr3").style.display="block";
		   document.getElementById("tr4").style.display="block";
		   document.getElementById("tr5").style.display="block";
		   document.getElementById("trzs").style.display="block";
		   document.getElementById("tr6").style.display="block";
		   //document.getElementById("tr8").style.display="block";
		   //document.getElementById("tr9").style.display="block";
		   document.getElementById("tr15").style.display="block";
		   document.getElementById("tr16").style.display="block";
		   document.getElementById("tr18").style.display="block";
		   document.getElementById("tr19").style.display="block";
		   document.getElementById("tr20").style.display="block";
		   document.getElementById("tr24").style.display="block";
	       document.getElementById("tr25").style.display="block";
	       document.getElementById("trFee").style.display = "block";
		   document.getElementById("trFeeLevel").style.display = "block";
	   } else if(saleType==21){
		   weaponSelectForm.setColEditSts("WEAPON_NAME",true);//0920
		   document.getElementById("tr1").style.display="block";
		   document.getElementById("tryc").style.display="block";
		   document.getElementById("tr2").style.display="block";
		   document.getElementById("tr3").style.display="block";
		   document.getElementById("tr4").style.display="block";
		   document.getElementById("tr10").style.display="block";
		   document.getElementById("tr11").style.display="block";
		   document.getElementById("tr12").style.display="block";
		   document.getElementById("tr19").style.display="block";
		   document.getElementById("tr20").style.display="block";
		   document.getElementById("trFee").style.display = "block";
		   document.getElementById("trFeeLevel").style.display = "block";
	   } else if(saleType==22 || saleType==23){
		   weaponSelectForm.setColEditSts("WEAPON_NAME",true);//0920
		   document.getElementById("tr4").style.display="block";
		   document.getElementById("tr5").style.display="block";
		   document.getElementById("trzs").style.display="block";
		   document.getElementById("tr18").style.display="block";
		   document.getElementById("tr10").style.display="block";
		   document.getElementById("tr11").style.display="block";
		   document.getElementById("tr12").style.display="block";
		   document.getElementById("tr19").style.display="block";
		   document.getElementById("tr20").style.display="block";
		   if (saleType==23) {
			   document.getElementById("jfl_tr").style.display="block";
			   document.getElementById("tr5").style.display="none";
		   	   document.getElementById("trzs").style.display="none";
		   	   document.getElementById("tr18").style.display="none";
		   	document.getElementById("trFee").style.display = "none";
			   document.getElementById("trFeeLevel").style.display = "none";
		   } else {
			   document.getElementById("tdzs").style.display = "block";
			   document.getElementById("trFee").style.display = "block";
			   document.getElementById("trFeeLevel").style.display = "block";
		   }

	   } else if(saleType==31){
		   document.getElementById("clearBusi").style.display="block";
		   document.getElementById("sjyw1").style.display="block";
		   document.getElementById("sjyw2").style.display="block";
		   document.getElementById("sjyw3").style.display="block";
		   document.getElementById("tr18").style.display="block";
		   weaponSelectForm1.setColEditSts("ADD_MONTHCHARGE",false);
		   document.getElementById("tr4").style.display="block";
		   document.getElementById("tr5").style.display="block";
		   document.getElementById("trzs").style.display="block";
		   document.getElementById("tr6").style.display="block";
		   //document.getElementById("tr8").style.display="block";
		   //document.getElementById("tr9").style.display="block";
		   document.getElementById("tr15").style.display="block";
		   document.getElementById("tr16").style.display="block";
		   document.getElementById("showzfq").style.display="none";
		   document.getElementById("tr24").style.display="block";
	       document.getElementById("tr25").style.display="block";
	       document.getElementById("trFee").style.display = "block";
		   document.getElementById("trFeeLevel").style.display = "block";
	   
	   } else if(saleType==41){
		   document.getElementById("clearBusi").style.display="block";
		   document.getElementById("sjyw1").style.display="block";
		   document.getElementById("sjyw2").style.display="block";
		   document.getElementById("sjyw3").style.display="block";
		   document.getElementById("tr18").style.display="block";
		   weaponSelectForm.setColEditSts("WEAPON_NAME",true);//0920
	  	   document.getElementById("tr4").style.display="block";
		   document.getElementById("tr5").style.display="block";
		   document.getElementById("trzs").style.display="block";
		   //document.getElementById("tr8").style.display="block";
		   //document.getElementById("tr9").style.display="block";
		   document.getElementById("tr13").style.display="block";
		   document.getElementById("tr14").style.display="block";
		   document.getElementById("tr15").style.display="block";
		   document.getElementById("tr16").style.display="block";
		   document.getElementById("tr24").style.display="block";
	       document.getElementById("tr25").style.display="block";
	       document.getElementById("jfl_tr").style.display="block";
	       document.getElementById("trFee").style.display = "block";
		   document.getElementById("trFeeLevel").style.display = "block";
	   } else if(saleType==17) {
		   document.getElementById("tdzs").style.display="block";
		   document.getElementById("tr1").style.display="block";
		   document.getElementById("tryc").style.display="block";
		   document.getElementById("tr2").style.display="block";
		   document.getElementById("tr3").style.display="block";
		   document.getElementById("tr4").style.display="block";
		   //document.getElementById("tr5").style.display="block";
		   //document.getElementById("trzs").style.display="block";
		   document.getElementById("tr19").style.display="block";
		   document.getElementById("tr20").style.display="block";
		   document.getElementById("jfl_tr").style.display="block";
		   //document.getElementById("tr18").style.display="block";
		   document.getElementById("tr25").style.display="none";
		   document.getElementById("tdzs").style.display="none";
		   document.getElementById("trFee").style.display = "block";
		   document.getElementById("trFeeLevel").style.display = "block";
	   } else{
		   weaponSelectForm.setValue("SALE_FLAG",11);
		   document.getElementById("tdzs").style.display="block";
		   document.getElementById("tr1").style.display="block";
		   document.getElementById("tryc").style.display="block";
		   document.getElementById("tr2").style.display="block";
		   document.getElementById("tr3").style.display="block";
		   document.getElementById("tr4").style.display="block";
		   document.getElementById("tr5").style.display="block";
		   document.getElementById("trzs").style.display="block";
		   document.getElementById("tr19").style.display="block";
		   document.getElementById("tr20").style.display="block";
		   document.getElementById("tr18").style.display="block";
		   document.getElementById("trFee").style.display = "block";
		   document.getElementById("trFeeLevel").style.display = "block";
	   }
	}
	var newMainid = saleWeaponMainframe.getValue("ID");
	weaponSelectForm1.setValue("MID",newMainid);
	weaponSelectForm.setValue("MID",newMainid);
}


function onReturnTypeChange(pFieldName,pOldVal,pOldText,pNewVal,pNewText){
	if(pFieldName=="RETURN_TYPE"){
		var rtype =weaponSelectForm1.getValue("RETURN_TYPE");
		document.getElementById("td6").style.display="block";
		document.getElementById("td7").style.display="block";
		weaponSelectForm1.setValue("FIRSTCHARGE","");
		weaponSelectForm1.setValue("LASTCHARGE","");
		weaponSelectForm1.setValue("STANDBY_NUM1","");
		weaponSelectForm1.setValue("PRESENT_BUSI2_AMOUNT","0");
		if(rtype=="1"){
			document.getElementById("tr25").style.display="none";
			document.getElementById("tr6").style.display="none";
		}if(rtype=="2"){
			document.getElementById("tr25").style.display="none";
			document.getElementById("tr6").style.display="block";
			document.getElementById("td6").innerHTML="ÿ�·�����";
		}if(rtype=="3"){
			document.getElementById("tr25").style.display="none";
			document.getElementById("tr6").style.display="block";
			document.getElementById("td6").innerHTML="ÿ������ֵ��";
		}if(rtype=="4"){
			document.getElementById("tr25").style.display="block";
			document.getElementById("tr6").style.display="block";
			document.getElementById("td6").style.display="none";
			document.getElementById("td7").style.display="none";
		}
	}
}

function showTag(tag){
	var yname="";
	var zname="";
	var bname="";
	var cname="";
	var jname="";
	var pfee=weaponSelectForm1.getValue("PRESTORE_FEE");
	var paccount=weaponSelectForm1.getValue("PRESTRORE_REACH_ACCOUNT");
	var blimt=weaponSelectForm1.getValue("B_LIMIT");
	var bmonth=weaponSelectForm1.getValue("BACK_MONTH");
	var bamonth=weaponSelectForm1.getValue("PRESENT_BUSI_AMOUNT");
	var pamonth=weaponSelectForm1.getValue("PRESENT_REACH_AMOUNT");
	var permon=weaponSelectForm1.getValue("PRESENT_VALUE_PERMON");
	var prmonth=weaponSelectForm1.getValue("PRESENT_BUSI_MONTH");
	var basemonth=weaponSelectForm1.getValue("BASE_MONTH");
	var dtype=weaponSelectForm1.getValue("DATA_BUSI_TYPE");
	var score=weaponSelectForm1.getValue("GLOBAL_SCORE");
	var dzmount=weaponSelectForm1.getValue("ADD_MONTHCHARGE");
	var hpmount=weaponSelectForm1.getValue("PRESENT_BUSI3_AMOUNT");
	var ywtype=weaponSelectForm1.getValue("BUSI_TYPE");
	var limit=weaponSelectForm1.getValue("L_LIMIT");
	var rtype=weaponSelectForm1.getValue("RETURN_TYPE");

	if(tag==11||tag==12||tag==13||tag==14||tag==16||tag==17||tag==31){
		if(pfee!=""){
			if(blimt==""||blimt==0){
				if(isarea1||isarea2||isarea3||isarea4||isarea5||isarea6||isarea7==true){
				//findTown(g_GetUserInfo().ORG_ID.substr(0,2));
					weaponSelectForm1.setValue("REMARK_4",g_GetUserInfo().ORG_ID.substr(0,2));
					yname="("+weaponSelectForm1.getDisplayText("REMARK_4")+")Ԥ��"+pfee+"(һ���Ե���,"+weaponSelectForm1.getDisplayText("REMARK_3")+");";
				}else{
					weaponSelectForm1.setValue("REMARK_4","10");
					yname="Ԥ��"+pfee+"(һ���Ե���"+","+weaponSelectForm1.getDisplayText("REMARK_3")+");";
				}
			//yname="Ԥ��"+pfee+"(һ���Ե���)";
			}else{
				if(isarea1||isarea2||isarea3||isarea4||isarea5||isarea6||isarea7==true){
					//findTown(g_GetUserInfo().ORG_ID.substr(0,2));
					weaponSelectForm1.setValue("REMARK_4",g_GetUserInfo().ORG_ID.substr(0,2));
					yname="("+weaponSelectForm1.getDisplayText("REMARK_4")+")Ԥ��"+pfee+"("+paccount+"+"+blimt+"*"+bmonth+"����,"+weaponSelectForm1.getDisplayText("REMARK_3")+");";
				}else{
					weaponSelectForm1.setValue("REMARK_4","10");
					yname="Ԥ��"+pfee+"("+paccount+"+"+blimt+"*"+bmonth+"����,"+weaponSelectForm1.getDisplayText("REMARK_3")+");";
				}
			//yname="Ԥ��"+pfee+"("+paccount+"+"+blimt+"*"+bmonth+"����)";
			}
		}else{
			yname="Ԥ��0("+weaponSelectForm1.getDisplayText("REMARK_3")+");";
		}
			if(tag==11||tag==31){
				if(bamonth!=""){
					if(permon==0){
						zname=zname+"��"+bamonth+"(һ���Ե���,"+weaponSelectForm1.getDisplayText("REMARK_2")+");";
					}else{
						if(pamonth==0||pamonth==""){
							zname=zname+"��"+bamonth+"("+permon+"*"+prmonth+"����,"+weaponSelectForm1.getDisplayText("REMARK_2")+");";
						}else{
							zname=zname+"��"+bamonth+"("+pamonth+"+"+permon+"*"+prmonth+"����,"+weaponSelectForm1.getDisplayText("REMARK_2")+");";
						}
					}
				}
			}
			if(tag == 17) {
				zname=zname+"��" + weaponSelectForm1.getDisplayText("STANDBY_NUM2") + "����;";
			}
			if(tag==12||tag==31){
				if(dzmount!=""&&dzmount!=0){
					if(rtype=="1"){
						zname=zname+"��"+dzmount+"����ȯ;";
					}else if(rtype=="2"){
						 var rnum=weaponSelectForm1.getValue("STANDBY_NUM1");
						 var rmoney=weaponSelectForm1.getValue("PRESENT_BUSI2_AMOUNT");
						 zname=zname+"��"+rnum+"*"+rmoney+"����ȯ;";
					}else if(rtype=="3"){
						 var rnum=weaponSelectForm1.getValue("STANDBY_NUM1");
						 var rmoney=weaponSelectForm1.getValue("PRESENT_BUSI2_AMOUNT");
						 zname=zname+"��"+rmoney+"+"+rmoney*2+"+"+"..."+"+"+rmoney*rnum+"����ȯ;";
					}else if(rtype=="4"){
						 var rnum=weaponSelectForm1.getValue("STANDBY_NUM1");
						 var rmoney=weaponSelectForm1.getValue("PRESENT_BUSI2_AMOUNT");
						 var fmonry=weaponSelectForm1.getValue("FIRSTCHARGE");
						 var lmoney=weaponSelectForm1.getValue("LASTCHARGE");
						 zname=zname+"��"+fmonry+"+"+(dzmount-fmonry-lmoney)/rnum+"*"+rnum+"+"+lmoney+"����ȯ;";
					}
				}
			}
			if(tag==13){
				zname=zname+"�ͻ�Ʒ;";
			}
			if(tag==14||tag==31){
			if(ywtype!=""&&ywtype!=0){
				zname=zname+"��"+ywtype+";";
				}
			}
			if(tag==16){
				if(hpmount!=""&&hpmount!=0){
					zname="�ͼ�ֵ"+hpmount+"�����;";
				}
			}
		if(limit!=""&&limit!=0){
			bname="����"+limit+"Ԫ("+basemonth+"����);";
		}
		if(dtype!=""){
			cname=dtype+";";
		}
		if(score!=""){
			if(score!="-1"){
				jname="�ۼ�"+score+"����;";
			}else{
				jname="��������;";
			}
		}
	var allname="";
	if(tag==31){
		allname=cname+zname+bname+jname;
	}else if(tag==16){
		allname="("+g_GetUserInfo().STAFF_NAME+")"+yname+zname+bname+cname+jname;
	}else if(tag==13){
		allname=yname+bname+cname+jname+zname;
	}else{
		allname=yname+zname+bname+cname+jname;
	}
	weaponSelectForm.setValue("WEAPON_NAME",allname);
	weaponSelectForm1.setValue("WEAPON_NAME",allname);	 
	}
	
}

function findTown(stateTown){
	if(stateTown=="11"){
		weaponSelectForm1.setValue("REMARK_4","�人");
	}else if(stateTown=="12"){
		weaponSelectForm1.setValue("REMARK_4","��ʯ");
	}
	else if(stateTown=="13"){
		weaponSelectForm1.setValue("REMARK_4","����");
	}
	else if(stateTown=="14"){
		weaponSelectForm1.setValue("REMARK_4","�˲�");
	}
	else if(stateTown=="15"){
		weaponSelectForm1.setValue("REMARK_4","��ʩ");
	}
	else if(stateTown=="16"){
		weaponSelectForm1.setValue("REMARK_4","ʮ��");
	}
	else if(stateTown=="17"){
		weaponSelectForm1.setValue("REMARK_4","����");
	}
	else if(stateTown=="18"){
		weaponSelectForm1.setValue("REMARK_4","����");
	}
	else if(stateTown=="19"){
		weaponSelectForm1.setValue("REMARK_4","����");
	}
	else if(stateTown=="20"){
		weaponSelectForm1.setValue("REMARK_4","����");
	}
	else if(stateTown=="23"){
		weaponSelectForm1.setValue("REMARK_4","����");
	}
	else if(stateTown=="24"){
		weaponSelectForm1.setValue("REMARK_4","����");
	}
	else if(stateTown=="25"){
		weaponSelectForm1.setValue("REMARK_4","�Ƹ�");
	}
	else if(stateTown=="26"){
		weaponSelectForm1.setValue("REMARK_4","Т��");
	}
}


function addWeaponMail(){
	var rwid=<%=request.getParameter("wid")%>;
	var saleFlag=weaponSelectForm.getValue("SALE_FLAG");
	var wstate=weaponSelectForm1.getValue("STATE");
	//if(saleFlag!="12"){
	//saleWeaponMainframe.setValue("ID",rwid);
	if(wstate!="P"){
		weaponSelectForm1.setValue("MID",rwid);
	}
	//}
    var staffId = g_GetUserInfo().STAFF_ID;
    saleWeaponMainframe.setValue("APPLICANT",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
	saleWeaponMainframe.setValue("ORG",g_GetUserInfo().ORG_ID,g_GetUserInfo().ORG_NAME);
	var xmlbody = saleWeaponMainframe.toXmlString();
	var xml = "<RootInfo>" + xmlbody + "</RootInfo>";
	var list = new Array();
	list.push(saleWeaponMainframe);
	if(wstate=="P"&&saleFlag==12){
		saleWeaponMainframe.setStsToNew();
	}
	var strUrl = _gModuleName + '/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=saveSaleWeaponMainA&delid=0';
	var recode = saveRowSet(strUrl, list);
	
	if(wstate=="P"){
		weaponSelectForm1.setValue("MID",recode.getValueByName("MID"));
		alert( recode.getValueByName("FLAG"));
	}
	if ("Y" == recode.getValueByName("FLAG"))
	{
	}
}


function moveY(mflag){
	if(mflag){
	   setSiteUp(1);
	   setSiteUp(2);
	   setSiteUp(3);
	}
}

function setSiteUp(id)
{
    var _trObj = document.getElementById('tr2'+id) ;
    var _trObj1 = document.getElementById('tr'+id) ;
    var _trRow = _trObj1.rowIndex ;
	_trObj.swapNode(tab.rows[_trRow]);
}

function showReachfee(){
	var presentFee=weaponSelectForm1.getValue("PRESTORE_FEE");
	var bLimit=weaponSelectForm1.getValue("B_LIMIT");
	var backMonth=weaponSelectForm1.getValue("BACK_MONTH");
	if(presentFee!=""){
		if(bLimit!=""){
			if(presentFee<bLimit*backMonth){
			alert("Ԥ�滰�Ѳ���С�ڷ��·����ܽ��!");
			return false;
			}else{
				weaponSelectForm1.setValue("PRESTRORE_REACH_ACCOUNT",presentFee-(bLimit*backMonth));
			}
		}else{
			 weaponSelectForm1.setValue("PRESTRORE_REACH_ACCOUNT",presentFee);
		}
	}else{
		if(bLimit!=""){
			alert("������Ԥ�滰�ѽ��!");
			return false;
		}
	}
}

function showReachPre(){
	var presentBusiAmount=weaponSelectForm1.getValue("PRESENT_BUSI_AMOUNT");
	var presentValuePermon=weaponSelectForm1.getValue("PRESENT_VALUE_PERMON");
	var presentBusiMonth=weaponSelectForm1.getValue("PRESENT_BUSI_MONTH");
	if(presentBusiAmount!=""){
		if(presentValuePermon!=""){
			if(presentBusiAmount<presentValuePermon*presentBusiMonth){
				alert("���ͻ��Ѳ���С�ڷ��·����ܽ��!");
				return false;
			}else{
				weaponSelectForm1.setValue("PRESENT_REACH_AMOUNT",presentBusiAmount-(presentValuePermon*presentBusiMonth));
			}
		}else{
			 weaponSelectForm1.setValue("PRESENT_REACH_AMOUNT",presentBusiAmount);
		}
	}else{
		if(presentValuePermon!=""){
			alert("���������ͻ��ѽ��!");
			return false;
		}
	}
}
	
function showReach(){
	showReachfee();
	showReachPre();
}

function addWeaponInfoNew(){
	location.reload();
	g_AIButtonManager.get("query2").setDisabled(false);
	g_AIButtonManager.get("query3").setDisabled(true);
}

function clearPrep(){
	wtid4="0";
	weaponSelectForm1.setValue("PRESTRORE_REACH_ACCOUNT","0");
	weaponSelectForm1.setValue("B_LIMIT","0");
	weaponSelectForm1.setValue("BACK_MONTH","0");
	weaponSelectForm1.setValue("PRESTORE_FEE","0");
}

function clearFee(){
	weaponSelectForm1.setValue("PRESENT_REACH_AMOUNT","0");
	weaponSelectForm1.setValue("PRESENT_VALUE_PERMON","0");
	weaponSelectForm1.setValue("PRESENT_BUSI_MONTH","0");
	weaponSelectForm1.setValue("PRESENT_BUSI_AMOUNT","0");
	weaponSelectForm1.setValue("ADD_MONTHCHARGE","0");
	weaponSelectForm1.setValue("RETURN_TYPE","");
	weaponSelectForm1.setValue("FIRSTCHARGE","");
	weaponSelectForm1.setValue("LASTCHARGE","");
	weaponSelectForm1.setValue("STANDBY_NUM1","");
	weaponSelectForm1.setValue("PRESENT_BUSI2_AMOUNT","0");
	weaponSelectForm1.setValue("PRESENT_BUSI3_AMOUNT","0");
	weaponSelectForm1.setValue("REFERENCE_PRICE","0");
	weaponSelectForm1.setValue("GOOD_ADOPT_DIRECTORY","");
	weaponSelectForm1.setColEditSts("PRESENT_BUSI3_AMOUNT",true);
	weaponSelectForm1.setColEditSts("REFERENCE_PRICE",true);
	weaponSelectForm1.setColEditSts("GOOD_ADOPT_DIRECTORY",true);
	wtid2="0";
	wtid6="0";
	wtid7="0";
	document.getElementById("div1").style.display="none";
}
function clearFee1(){
	weaponSelectForm1.setValue("PRESENT_BUSI4_AMOUNT","0");
	weaponSelectForm1.setValue("BUSI_TYPE","");
	wtid5="0";
 }

function clearBusi(){
	weaponSelectForm1.setValue("DATA_FEE","0");
	weaponSelectForm1.setValue("DATA_BUSI_TYPE","");
	weaponSelectForm1.setValue("VALUE_PERMONTH","0");
	weaponSelectForm1.setValue("OPEN_MONTH","0");
	wtid3="0";
}

function clearBase(){
	weaponSelectForm1.setValue("L_LIMIT","0");
	weaponSelectForm1.setValue("BASE_MONTH","0");
	wtid3="1";
}

function clearjfl() {
	wtid9="";
 	area9=false;
 	flagdiv9=false;
	weaponSelectForm1.setValue("STANDBY_NUM2","");
	document.getElementById("div1").style.display="none";
}

function updateInfo(){
	table00.refresh("&mainId="+rwid);
	saleWeaponMainframe.refresh("&id="+rwid);
	weaponSelectForm.refresh("&id="+pid);
	//weaponSelectForm1.refresh("&id="+pid);
}

function clearScore(){
	weaponSelectForm1.setColEditSts("GLOBAL_SCORE",false);
	weaponSelectForm1.setValue("GLOBAL_SCORE","-1");
}

function clearScoreButton(){
	weaponSelectForm1.setValue("GLOBAL_SCORE","");
	weaponSelectForm1.setColEditSts("GLOBAL_SCORE",true);
}

function zkfwCondition(){
	var returnzk= window.showModalDialog("<%=request.getContextPath()%>/sale/promationTag/SalestaticDate.jsp?codeType='acctypez'","","dialogWidth=500px");
	if(returnzk!=undefined){
	weaponSelectForm1.setValue("REMARK_3",returnzk);
	weaponSelectForm1.setValue("DYNAMIC_SCORE",returnzk);
	}
}

function zkfwConditionz(){
	var returnzk= window.showModalDialog("<%=request.getContextPath()%>/sale/promationTag/SalestaticDate.jsp?codeType='acctypey'","","dialogWidth=500px");
	if(returnzk!=undefined){
		weaponSelectForm1.setValue("REMARK_2",returnzk);
		weaponSelectForm1.setValue("HOME_SCORE",returnzk);	
	}
}

function ycTagItem(){
	var item_type=weaponSelectForm1.getValue("REMARK_3");
	window.showModalDialog("<%=request.getContextPath()%>/sale/promationTag/tagitem.jsp?item_type="+item_type,"","dialogWidth=500px");
}

function zsTagItem(){
	var item_type=weaponSelectForm1.getValue("REMARK_2");
	window.showModalDialog("<%=request.getContextPath()%>/sale/promationTag/tagitem.jsp?item_type="+item_type,"","dialogWidth=500px");
}

function getAttachCfgOpt() {
	var busiTypeVal = "";  //�Ƿ���Ҫ����
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
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"���ڴ������Ժ�...");
}
</script>


