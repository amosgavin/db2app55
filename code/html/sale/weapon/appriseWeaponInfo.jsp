<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>������Ϣ</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body>

 <ai:contractframe id="saleWeaponMainframe" contenttype="table" title="������Ϣ" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
	<ai:dbform formid="saleWeaponMainframe" 
			setname="com.asiainfo.sale.weapon.web.SETSaleWeaponMainDe"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="true" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponMainSV"
			implservice_querymethod="getSaleWeaponMainDeById(String id)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr><td class="td_font">�������ƣ�	</td>
	           	<TD><ai:dbformfield formid="saleWeaponMainframe" fieldname="APPLY_NAME" width="150" editable="false"/> </td> 
	           </tr>
			<tr>
	           	<ai:dbformfield formid="saleWeaponMainframe" fieldname="ID" visible="false"/>   
	           	<ai:dbformfield formid="saleWeaponMainframe" fieldname="WID" visible="false"/>
	           	<td class="td_font">�����ˣ�</td>
	           	<TD><ai:dbformfield formid="saleWeaponMainframe" fieldname="STAFF_NAME" width="150" editable="false"/>
	           	<ai:dbformfield formid="saleWeaponMainframe" fieldname="PRINCIPAL" width="150" visible="false"/></TD>
	           	<td class="td_font">���뵥λ��</td>
	           	<TD><ai:dbformfield formid="saleWeaponMainframe" fieldname="ORGANIZE_NAME" width="150" editable="false"/>
	           	<ai:dbformfield formid="saleWeaponMainframe" fieldname="PROMOTE_DEPART" width="150" visible="false"/></TD>
			</tr>
			<tr>
	           	<td class="td_font" >����˵����
	           	<td colspan="2"><ai:dbformfield formid="saleWeaponMainframe" fieldname="REMARK" width="100%	" height="100" editable="false"/>
			</td>
			</tr>
		</table>
		 <div  class="area_button" style="display:none;"><ai:button text="����������Ϣ" id="" onclick="" /></div>
	</ai:dbform>
</ai:contractframe>

<ai:contractframe id="chargeApplyMain" contenttype="table" title="�ѱ��������ģ����Ϣ" width="100%" allowcontract="true" frameclosed="fale">
	    <ai:contractitem><%--<ai:button id="newSaleDetail" text="�½��" onclick="newSaleDetail()"/>--%>
	    </ai:contractitem>
	    <ai:table
	        tableid="table00"
	        setname="com.asiainfo.sale.weapon.web.SETSaleWeapon"
	        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
	        implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
	        implservice_querymethod="getSaleWeaponByMainId(String mainId, int $STARTROWINDEX,int $ENDROWINDEX)"
	        initial="false"  multiselect="true" onrowchange="showApplyMain"
	        pagesize="15" editable="false" width="100%" 
	        height="100" needrefresh="true">
	        	<ai:col title="�������ID" fieldname="ID" visible="" width="10%"/>
	        	<ai:col title="�������" fieldname="MID" visible="" width="10%"/>
	            <ai:col title="�������" fieldname="SALE_FLAG" width="20%" />
	            <ai:col title="ϸ���г�" fieldname="MARKET_TYPE" width="20%" />
	        	<ai:col title="����" fieldname="NET_AGE" width="20%"/>
	            <ai:col title="��������" fieldname="WEAPON_NAME" width="30%" />
	    </ai:table>
		</ai:contractframe>

 <ai:contractframe id="weaponMainSelectframe" contenttype="table" title="������ϸ��Ϣ" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	<ai:dbform formid="weaponSelectForm1" 
		setname="com.asiainfo.sale.weapon.web.SETSaleWeaponS" initial="false"
        datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
					implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
					implservice_querymethod="getSaleWeaponOnlyByID(String id)" 
					initial="false" editable="false">
			<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2" id="tab">
		        <tr>
		          	<td class="td_font"  >������ţ�</td>
	           	<td ><ai:dbformfield formid="weaponSelectForm1" fieldname="WID" width="150"/>
	           </td>

			</tr>
			<tr>
	           	<td class="td_font">ϸ���г���</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="MARKET_TYPE" width="150" /></td>
	           	<td class="td_font">���䣺</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="NET_AGE" width="150"/>(��)</td>
	        </tr>
	        <tr>
		    <td class="td_font">����</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="SALE_FLAG" width="150"/></td>
	           	</tr>
	           	 <tr>
	        	<td class="td_font">�������ƣ�</td>
	           	<td colspan="3"><ai:dbformfield formid="weaponSelectForm1" fieldname="WEAPON_NAME" width="500" height="40"/>
	          </td>
	        </tr>
	        
	        <tr id="trFeeLevel">
				<td class="td_font">���ѿɷ�ֿۣ�</td>
				<td colspan="3">
					<ai:dbformfield formid="weaponSelectForm1" fieldname="COST_TYPE_ONE" width="10" visible="false"/>
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
						<ai:dbformfield formid="weaponSelectForm1" fieldname="COST_TYPE_TWO" width="10" visible="false"/>
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
					<ai:dbformfield formid="weaponSelectForm1" fieldname="TEL_FEE_DEDUCTION_TIME" width="150" />
				</td>
			</tr>
	        
		    <tr id="tr1">
	            	<td  colspan="2"><b>Ԥ�棺</b></td>
	           	<td class="td_font">Ԥ��ר�Χ�����飺</td>
								<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="DYNAMIC_SCORE" width="150" />
	           	<!-- <td>Ԥ��ר�Χ��Ŀ�<img id="selectOrgTypeYCZK" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="ycTagItem()" align=""
								style="cursor: hand;" /></td> -->
			</tr>
		    <tr id="tr2">
	           	<td class="td_font" >Ԥ�滰�ѽ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESTORE_FEE" width="150"/>(Ԫ)</td>
	           	<td class="td_font">Ԥ��һ���Ե��ʣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESTRORE_REACH_ACCOUNT" width="150"/>(Ԫ)</td>
			</tr>
			  <tr id="tr3">
	           	<td class="td_font">ÿ�·�����</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="B_LIMIT" width="150"/>(Ԫ)</td>
	           	<td class="td_font">�����·ݣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="BACK_MONTH" width="150"/></td>
			</tr>
			   <tr id="tr4">
	           <td colspan="2"><b>���ͣ�</b></td> 
	           		<td class="td_font">����ר�Χ������:</td>
								<td>
							<ai:dbformfield formid="weaponSelectForm1"
								fieldname="HOME_SCORE" width="150" />
							</td>
	           	<!--  	 <td>����ר�Χ��Ŀ�<img id="selectOrgTypeYCZK" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="zsTagItem()" align="absmiddle"
								style="cursor: hand;" /></td>-->
	           	 
			</tr>
			<tr id="tr5">
	           	<td class="td_font">���ͻ��ѽ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI_AMOUNT" width="150"/>(Ԫ)</td>
	           	<td class="td_font">����һ���Ե��ʣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_REACH_AMOUNT" width="150"/>(Ԫ)</td>
			</tr>
			<tr id="tr18">
	           	<td class="td_font">ÿ�����ͣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_VALUE_PERMON" width="150"/>(Ԫ)</td>
	           	<td class="td_font">�����·ݣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI_MONTH" width="150"/></td>
			</tr>
			<tr id="tr6">
	           	<td class="td_font">����֧������</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI2_AMOUNT" width="150"/>(Ԫ)</td>
	           	<td class="td_font">����֧�����ͣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="ZFQ_TYPE" width="150"/></td>
			    </tr>
			<tr id="tr7" style="display:none">
	           	<td class="td_font" >֧������������</td>
	           	<td ><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_1" width="150"/>(Ԫ)</td>
	           	</tr>
			<tr id="tr8">
			    <td class="td_font">��Ʒҵ���ܼ�ֵ��</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI3_AMOUNT" width="150"/>(Ԫ)</td>
	           	<td class="td_font">��Ʒ�ɹ�Ŀ¼��</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="GOOD_ADOPT_DIRECTORY" width="150"/></td>
			</tr>
			<tr id="tr9"> 	
			    <td class="td_font">��Ʒ����ָ���ۣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="REFERENCE_PRICE" width="150"/>(Ԫ)</td>         
	           	<td class="td_font">��Ʒ������</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_2" width="150"/></td>
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
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="TERM_COST_FEE" width="150"/>(Ԫ)</td>
			</tr>
			<tr id="tr12">
	           	<td class="td_font">�ն�������</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_4" width="150"/>(Ԫ)</td>
	            <td class="td_font">�����ʺ����ԣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="FEE_ACCOUNT_PROPERTY" width="150"/>(Ԫ)</td>
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
	       </tr>
	 		<tr id="tr16">
	           <td class="td_font">����ҵ���ܼ�ֵ��</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI4_AMOUNT" width="150"/>(Ԫ)</td>
	           	<td class="td_font">ҵ�����ͣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="BUSI_TYPE" width="150"/></td>
			</tr>
			<tr id="tr17">
	           	<td class="td_font">����ҵ��������</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_3" width="150"/>(Ԫ)</td>
	           	</tr>
			<tr id="tr19">
	           	<td class="td_font"><b>���ף�</b></td>
	           	
			</tr>
			<tr id="tr20">
	           	<td class="td_font">���׶�ȣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="L_LIMIT" width="150"/>(Ԫ)</td>
	           	<td class="td_font">����������</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="BASE_MONTH" width="150"/></td>
			</tr>
			 <tr id="tr21">
	           	<td class="td_font"><b>���ݰ���</b></td>
			</tr>
			<tr id="tr22">
			 	<td class="td_font">���ݰ��ܼ�ֵ��</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="DATA_FEE" width="150"/>(Ԫ)</td>	
			
	           	<td class="td_font">����ҵ�����ͣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="DATA_BUSI_TYPE" width="150"/></td>	
	          </tr>
			<tr id="tr23">
	           	<td class="td_font">ÿ�¼�ֵ��</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="VALUE_PERMONTH" width="150"/>(Ԫ)</td>	
	           	<td class="td_font">��ͨ������</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="OPEN_MONTH" width="150"/></td>	
			</tr>
			<tr id="tr21">
	           	<td class="td_font"><b>�ۼ����֣�</b></td>
			</tr>
			<tr id="tr22">
			 	<td class="td_font">���֣�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="GLOBAL_SCORE" width="150"/>
	           	<span class="font_red">(����Ϊ-1,��ʾ��������!)</span>
	           	</td>	
	          </tr>
			<tr id="tr23" style="display:none">
	           	<td class="td_font">�����л��֣�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="SZX_SCORE" width="150"/></td>	
			</tr>
	</table>
	</ai:dbform>
</ai:contractframe>

<ai:contractframe id="tagDetailframe" contenttype="table" title="��Ҫ�������ñ�ǩ" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem/>
	<ai:table setname="com.asiainfo.sale.tag.web.SETPromationTag"
			  tableid="detailTagTab" width="100%" multiselect="false"
			  needrefresh="true" initial="false" height = "200"
			  tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			  implservice_name="com.asiainfo.sale.tag.service.interfaces.ITagDetailSV"
			  implservice_querymethod="getSpareTagDetailByWeaponId(int weaponId)"			  
			  operator="query">
	       		<ai:col fieldname="WPID" width="15%" editable="false" visible="true" /> 
	       		<ai:col title="BOSS��ʶ" fieldname="TAG_CODE"  width="15%" editable="false" visible="true" /> 
	        	<ai:col fieldname="TAG_TYPE" width="15%" editable="false" visible="true" /> 
				<ai:col fieldname="NAME" width="20%" editable="false" visible="true" /> 
				<ai:col fieldname="CHARGE" width="15%" editable="false" visible="true"/> 
				<ai:col fieldname="CYCLE" width="15%" editable="false" visible="true"/>
	</ai:table>
	
</ai:contractframe>	
<%@include file="/sale/promationTag/attach.jsp"%>
<script type="text/javascript">

var rid = <%=request.getParameter("WID")%>;
var vmTaskId = "<%=request.getParameter("taskId")%>";
function showApplyMain(oldIndex,newIndex){
	var weaponSelectForm1 = g_FormRowSetManager.get("weaponSelectForm1");
	var _tableTagDetailRowSet = g_TableRowSetManager.get("detailTagTab");
	var table00 = g_TableRowSetManager.get("table00");
		 if(-1 != oldIndex) {
      	 table00.setRowBgColor(oldIndex,"");
    	}
    	 table00.setRowBgColor(newIndex,"yellow");
    	 var applyid = table00.getValue(newIndex,"ID");
		 var SALE_FLAG=table00.getValue(newIndex,"SALE_FLAG");
		 onSaleTypeChange(SALE_FLAG);
		 weaponSelectForm1.refresh("&id="+applyid);
		 _tableTagDetailRowSet.refresh("&weaponId=" + applyid);
	}
	
initPage();
function initPage(){
//var paraObj = window.dialogArguments;
//var wid=paraObj.wid;  
   var saleWeaponMainframe = g_FormRowSetManager.get("saleWeaponMainframe");
   var weaponSelectForm2 = g_FormRowSetManager.get("weaponSelectForm1");
   var _tableTagDetailRowSet = g_TableRowSetManager.get("detailTagTab");
   var table00 = g_TableRowSetManager.get("table00");
   var wid=<%=request.getParameter("WID")%>;
   onSaleTypeChange();
   saleWeaponMainframe.refresh("&id="+wid);
  	 table00.refresh("&mainId="+wid);
  	//weaponSelectForm2.refresh("&id="+wid);
   //weaponSelectForm2.refresh("&wid="+wid+"&weaponName="+"&busiType=");
   //_tableTagDetailRowSet.refresh("&weaponId=" + weaponSelectForm2.getValue("WID"));
  	
   include_reflashAttachTable();
   document.getElementById("submitButton").disabled=true;	
   document.getElementById("deleteButton").disabled=true;
   document.getElementById("importFile").disabled=true;
   showCheckBox();
}

function showCheckBox(){
	var weaponSelectForm1 = g_FormRowSetManager.get("weaponSelectForm1");
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


function onSaleTypeChange()
{           
    var saleType=<%=request.getParameter("saleFale")%>;
	   initDate();
	   if(saleType==12){
	   document.getElementById("tr1").style.display="block";
	   document.getElementById("tr2").style.display="block";
	   document.getElementById("tr3").style.display="block";
	   document.getElementById("tr4").style.display="block";
	   document.getElementById("tr6").style.display="block";
	   document.getElementById("tr19").style.display="block";
	   document.getElementById("tr20").style.display="block";
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
	   document.getElementById("tr17").style.display="block";
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
	   //document.getElementById("tr8").style.display="block";
	   //document.getElementById("tr9").style.display="block";
	   document.getElementById("tr15").style.display="block";
	   document.getElementById("tr16").style.display="block";
	   document.getElementById("tr17").style.display="block";
	   document.getElementById("tr18").style.display="block";
	   document.getElementById("tr19").style.display="block";
	   document.getElementById("tr20").style.display="block";
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
	   //document.getElementById("tr8").style.display="block";
	   //document.getElementById("tr9").style.display="block";
	   document.getElementById("tr15").style.display="block";
	   document.getElementById("tr16").style.display="block";
	   document.getElementById("tr17").style.display="block";
	    document.getElementById("tr18").style.display="block";
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
	   document.getElementById("tr17").style.display="block";
	   document.getElementById("tr18").style.display="block";
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
</script>

  </body>
</html>
