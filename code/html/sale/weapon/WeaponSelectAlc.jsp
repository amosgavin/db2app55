<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>������ѯ</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js" type="text/javascript"></script>	
</head>
<body onload="onSaleTypeChange()">
<ai:contractframe id="weaponMainSelectframe" contenttype="table" title="��������ѯ" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	<ai:dbform formid="weaponSelectForm" 
		setname="com.asiainfo.sale.weapon.web.SETSaleWeapon"
		onvalchange="onSaleTypeChange"  editable="true" initial="false">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<!--<tr>
		    <td class="td_font">�����ˣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm" fieldname="STAFFID" width="150" editable="false"/><img id="selectStaffid" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaffid()" align="absmiddle" style="cursor:hand;"/></td>
	           	</tr>
	         -->
		
			<tr>
	           	<td class="td_font">������ţ�</td>
	           	<td>
	           	<ai:dbformfield formid="weaponSelectForm" fieldname="MID" width="150"/></td>
	           	<td class="td_font">������ţ�</td>
	           	<td>
	           	<ai:dbformfield formid="weaponSelectForm" fieldname="WID"  width="150"/>
	          </td>

			</tr>
			<tr>
			<td class="td_font">�������ƣ�</td>
			<td><ai:dbformfield formid="weaponSelectForm" fieldname="WEAPON_NAME" width="150"/></td>
			</tr>
			<tr>
	           	<td class="td_font">ϸ���г���</td>
	           	<td ><ai:dbformfield formid="weaponSelectForm" fieldname="MARKET_TYPE" width="150"/></td>
	           	<td class="td_font">���䣺</td>
			    <td><ai:dbformfield formid="weaponSelectForm" fieldname="NET_AGE" width="70" visible="false"/>
	           	<ai:dbformfield formid="weaponSelectForm" fieldname="MINNET_AGE" width="70"/>��<ai:dbformfield formid="weaponSelectForm" fieldname="MAXNET_AGE" width="70"/>(��)</td>
	          </tr>
	        <tr>
		    <td class="td_font">����</td>
	           	<td><ai:dbformfield formid="weaponSelectForm" fieldname="SALE_FLAG" width="150"/></td>
	           	<td class="td_font">״̬��</td>
	           	<td><ai:dbformfield formid="weaponSelectForm" fieldname="STATE" width="150"/></td>
	           	</tr>
		</table>
	</ai:dbform>
</ai:contractframe>

<ai:contractframe id="weaponMainSelectframe1" contenttype="table" title="�߼���ѯ" width="100%" allowcontract="true" frameclosed="true">
	<ai:contractitem/>
	<ai:dbform formid="weaponSelectForm1" 
		setname="com.asiainfo.sale.weapon.web.SETSaleWeapon" initial="false">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2" id="tab">
		 <tr id="tr21" style="display:none">
	           	<td class="td_font"><b>���ݰ���</b></td>
			</tr>
			<tr id="tr22" style="display:none">
			 	<td class="td_font">���ݰ��ܼ�ֵ��</td>
	           	<td> <ai:dbformfield formid="weaponSelectForm1" fieldname="DATA_FEE" width="150"/></td>	
	           	<td class="td_font">����ҵ�����ͣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="DATA_BUSI_TYPE" width="150"/></td>	
	          </tr>
			<tr id="tr23" style="display:none">
	           	<td class="td_font">ÿ�¼�ֵ��</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="GOOD_ADOPT_DIRECTORY" width="150"/></td>
	           	<!-- <ai:dbformfield formid="weaponSelectForm1" fieldname="VALUE_PERMONTH" width="150"/> -->	
	           	<td class="td_font">��ͨ������</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="OPEN_MONTH" width="150"/></td>	
			</tr>
		        <tr id="tr1">
	           	<td class="td_font"><b>Ԥ�棺</b></td>
			</tr>
		    <tr id="tr2">
	           	<td class="td_font" >Ԥ�滰�ѽ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESTORE_FEE" width="70"/>��<ai:dbformfield formid="weaponSelectForm1" fieldname="PRESTRORE_REACH_ACCOUNT" width="70"/>(Ԫ)</td>
			</tr>
			  <tr id="tr3">
	           	<td class="td_font">������ȣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="B_LIMIT" width="150"/></td>
	           	<td class="td_font">�����·ݣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="BACK_MONTH" width="150"/></td>
			</tr>
			   <tr id="tr4">
	           	<td class="td_font"><b>���ͣ�</b></td>
	           	 
			</tr>
			<tr id="tr5">
	           	<td class="td_font">���ͻ��ѽ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI_AMOUNT" width="70"/>��<ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_REACH_AMOUNT" width="70"/>(Ԫ��</td>
			</tr>
			
			<tr id="tr6">
	           	<td class="td_font">����֧������</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI2_AMOUNT" width="70"/>(Ԫ��</td>
	           	<td class="td_font">����֧�����ͣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="ZFQ_TYPE" width="150"/></td>
			    </tr>
			<tr id="tr7" style="display:none">
	           	<td class="td_font">֧������������</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_1" width="150"/>(Ԫ��</td>
	           	</tr>
			<tr id="tr8">
			    <td class="td_font">��Ʒҵ���ܼ�ֵ��</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI3_AMOUNT" width="150"/>(Ԫ��</td>
	           	<td class="td_font">��Ʒ�ɹ�Ŀ¼��</td>
	           	<td></td>
			</tr>
			<tr id="tr9"> 	
			    <td class="td_font">��Ʒ����ָ���ۣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="REFERENCE_PRICE" width="150"/>(Ԫ��</td>         
	           	<td class="td_font" style="display:none">��Ʒ������</td>
	           	<td style="display:none"><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_2" width="150"/>(Ԫ��</td>
	           	</tr>
			<tr id="tr10">
	           	<td class="td_font">�ն�ʵ�ʹ���</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="TERM_REAL_FEE" width="150"/>(Ԫ��</td>
	           	<td class="td_font">�ն����ͣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="TERM_TYPE" width="150"/></td>
			</tr>
			<tr id="tr11">
	           	<td class="td_font">�ն�����ָ���ۣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="TERM_GUIDE_FEE" width="150"/>(Ԫ��</td>
	           	<td class="td_font">�ն˳ɱ�����ۣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="TERM_COST_FEE" width="150"/></td>
			</tr>
			<tr id="tr12">
	           	<td class="td_font" style="display:none">�ն�������</td>
	           	<td style="display:none"><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_4" width="150"/>(Ԫ��</td>
	           	</tr>
			<tr id="tr13">
	           	<td class="td_font">���ֲ�Ʒ�ܼ۸�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI5_AMOUNT" width="150"/>(Ԫ��</td>
	 		</tr>
	 		<tr id="tr14">
	           	<td class="td_font">���ֲ�Ʒ������</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_5" width="150"/>(Ԫ��</td>
	 		</tr>
	 		<tr id="tr15">	
		 	   <td class="td_font"><b>��������ҵ��</b></td>
	       </tr>
	 		<tr id="tr16">
	           <td class="td_font">����ҵ���ܼ�ֵ��</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI4_AMOUNT" width="150"/>(Ԫ��</td>
	           	<td class="td_font">ҵ�����ͣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="BUSI_TYPE" width="150"/></td>
			</tr>
			<tr id="tr17">
	           	<td class="td_font">����ҵ��������</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_3" width="150"/>(Ԫ��</td>
	           	</tr>
			
			<tr id="tr18">
	           	<td class="td_font">ÿ�����ͣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_VALUE_PERMON" width="150"/>(Ԫ��</td>
	           	<td class="td_font">�����·ݣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI_MONTH" width="150"/></td>
			</tr>
			<tr id="tr19">
	           	<td class="td_font"><b>���ף�</b></td>
	           	
			</tr>
			<tr id="tr20">
	           	<td class="td_font">���׶�ȣ�</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="L_LIMIT" width="150"/></td>
	           	<td class="td_font">����������</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="BASE_MONTH" width="150"/></td>
			</tr>
			
	</table>
	</ai:dbform>
</ai:contractframe>

<div class="area_button">
	           		<ai:button id="queryWeapon" text="��ѯ" onclick="queryWeaponMain()"/>
</div>

<ai:contractframe id="weaponListframe" contenttype="table" title="��������" width="100%" allowcontract="false" frameclosed="fale" >
	<ai:contractitem/>
 	<ai:table
		tableid="weaponMainListTable"
		setname="com.asiainfo.sale.weapon.web.SETSaleWeaponS"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
		implservice_querymethod="getSaleWeapon(String mid,String wwid,String wid,String weaponName,
			String marketType, String backMonth, String baseMonth, String lLimit,
			String bLimit, String saleFlag, String presentBusiMonth, String busiType,
			String netAge, String couponsValue, String selfBusi, String goodAdoptDirectory,
			String state,String presentBusiAmount,String presentReachAmount,
			String presentValuePermon,String presentBusi2Amount,
			String zfqType,String presentBusi4Amount,String openMonth,String minNetAge,String maxNetAge,
			int $STARTROWINDEX, int $ENDROWINDEX)"
		implservice_countmethod="getCount(String mid,String wwid,String wid,String weaponName,
			String marketType, String backMonth, String baseMonth, String lLimit,
			String bLimit, String saleFlag, String presentBusiMonth, String busiType,
			String netAge, String couponsValue, String selfBusi, String goodAdoptDirectory,
			String state,String presentBusiAmount,String presentReachAmount,
			String presentValuePermon,String presentBusi2Amount,
			String zfqType,String presentBusi4Amount,String openMonth,String minNetAge,String maxNetAge)"
		  ondbclick="showWeaponInfo"  onrowchange="onrowchange1" oncellchange="showcell" 
		initial="false" pagesize="9" editable="false" width="100%"
		height="200" needrefresh="true">
		<ai:col title="�������" fieldname="MID" width="10%" />
		<ai:col title="�������" fieldname="WID" width="10%"/>
		<ai:col title="��������" fieldname="WEAPON_NAME" width="20%" />
		<ai:col title="����" fieldname="SALE_FLAG" width="15%" />
		<ai:col title="ϸ���г�" fieldname="MARKET_TYPE" width="15%" />
		<ai:col title="����" fieldname="NET_AGE" width="15%" />
		<ai:col title="����ʱ��" fieldname="CREATE_TIME" width="20%" />
		<ai:col title="״̬" fieldname="STATE" width="6%" />
	</ai:table>
</ai:contractframe>
  <div class="area_button">
   <ai:button text="�鿴������ϸ" id="query1" onclick="showWeaponInfo()" />&nbsp;&nbsp;
   <ai:button text="�鿴��������Ӫ���" id="query2" onclick="showRelatSaleInfo()" />
  <!--����<a href>�򿪵Ĵ��ڱ���ʹ�á�#nogo��; -->
</div>
</body>
</html>
<ai:loginuser/>
<script type="text/javascript">

var weaponSelectForm = g_FormRowSetManager.get("weaponSelectForm");
var weaponMainListTable = g_TableRowSetManager.get("weaponMainListTable");	
var weaponSelectForm1 = g_FormRowSetManager.get("weaponSelectForm1");
//var itemTypes = window.dialogArguments.itemTypes; 
//var aray=new Array();
//aray = itemTypes.split(";");
var saleType;
// var saleType=aray[0];
// var marketType=aray[1];
var orgid=g_GetUserInfo().ORG_ID;
    
function init(){
   for(var i=1;i<24;i++){
	   var num="tr"+i;
	   document.getElementById(num).style.display="none";
   }
}

function onSaleTypeChange()
{    
	    //weaponSelectForm.setColEditSts("MARKET_TYPE",false);
	    //weaponSelectForm.setColEditSts("SALE_FLAG",false);
	   //weaponSelectForm.setValue("MARKET_TYPE","");
	   //weaponSelectForm.setValue("SALE_FLAG","");	
	    saleType = weaponSelectForm.getValue("SALE_FLAG");
	  if(saleType==12){
	   init();
	   document.getElementById("tr1").style.display="block";
	   document.getElementById("tr2").style.display="block";
	   document.getElementById("tr3").style.display="block";
	   document.getElementById("tr4").style.display="block";
	   document.getElementById("tr6").style.display="block";
	   document.getElementById("tr19").style.display="block";
	   document.getElementById("tr20").style.display="block";
	   }else  if(saleType==13){
	   init();
	   document.getElementById("tr1").style.display="block";
	   document.getElementById("tr2").style.display="block";
	   document.getElementById("tr3").style.display="block";
	 	 // document.getElementById("tr4").style.display="block";
	   //document.getElementById("tr8").style.display="block";
	   //document.getElementById("tr9").style.display="block";
	   document.getElementById("tr19").style.display="block";
	   document.getElementById("tr20").style.display="block";
	   }else  if(saleType==14){
	   init();
	   document.getElementById("tr1").style.display="block";
	   document.getElementById("tr2").style.display="block";
	   document.getElementById("tr3").style.display="block";
	   document.getElementById("tr15").style.display="block";
	   document.getElementById("tr16").style.display="block";
	   document.getElementById("tr19").style.display="block";
	   document.getElementById("tr20").style.display="block";
	   }else  if(saleType==15){
	   init();
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
	   document.getElementById("tr19").style.display="block";
	   document.getElementById("tr20").style.display="block";
	   }else  if(saleType==21){
	   init();
	   document.getElementById("tr1").style.display="block";
	   document.getElementById("tr2").style.display="block";
	   document.getElementById("tr3").style.display="block";
	   document.getElementById("tr4").style.display="block";
	   document.getElementById("tr10").style.display="block";
	    document.getElementById("tr11").style.display="block";
	    document.getElementById("tr12").style.display="block";
	   document.getElementById("tr19").style.display="block";
	   document.getElementById("tr20").style.display="block";
	   }
	   else  if(saleType==22){
	   init();
	   document.getElementById("tr4").style.display="block";
	   document.getElementById("tr5").style.display="block";
	    document.getElementById("tr18").style.display="block";
	    document.getElementById("tr10").style.display="block";
	    document.getElementById("tr11").style.display="block";
	    document.getElementById("tr12").style.display="block";
	   document.getElementById("tr19").style.display="block";
	   document.getElementById("tr20").style.display="block";
	   } else  if(saleType==31){
	   init();
	   document.getElementById("tr4").style.display="block";
	   document.getElementById("tr5").style.display="block";
	   document.getElementById("tr6").style.display="block";
	   document.getElementById("tr7").style.display="block";
	   //document.getElementById("tr8").style.display="block";
	   //document.getElementById("tr9").style.display="block";
	   document.getElementById("tr15").style.display="block";
	  document.getElementById("tr16").style.display="block";
	 document.getElementById("tr21").style.display="block";
	//document.getElementById("tr22").style.display="block";
	 document.getElementById("tr23").style.display="block";
	   }else if(saleType==41){
	   init();
	  document.getElementById("tr4").style.display="block";
	   document.getElementById("tr5").style.display="block";
	   //document.getElementById("tr8").style.display="block";
	  // document.getElementById("tr9").style.display="block";
	   document.getElementById("tr13").style.display="block";
	   document.getElementById("tr15").style.display="block";
	  document.getElementById("tr16").style.display="block";
	   } else{
	   init();
	   document.getElementById("tr1").style.display="block";
	   document.getElementById("tr2").style.display="block";
	   document.getElementById("tr3").style.display="block";
	   document.getElementById("tr4").style.display="block";
	   document.getElementById("tr5").style.display="block";
	    document.getElementById("tr18").style.display="block";
	   document.getElementById("tr19").style.display="block";
	   document.getElementById("tr20").style.display="block";
	   }
 }
 
  function trim(str)
{
        return str.replace(/(^\s*)|(\s*$)/g, '');
}
 
function queryWeaponMain()
{   
  var wid = weaponSelectForm.getValue("MID");
  var wwid = weaponSelectForm.getValue("WID");
  var weaponName= weaponSelectForm.getValue("WEAPON_NAME");
  var netAge = weaponSelectForm.getValue("NET_AGE");
  var minNetAge = weaponSelectForm.getValue("MINNET_AGE");
  var maxNetAge = weaponSelectForm.getValue("MAXNET_AGE");
  var marketType = weaponSelectForm.getValue("MARKET_TYPE");
  var bLimit = weaponSelectForm1.getValue("B_LIMIT");
  var backMonth = weaponSelectForm1.getValue("BACK_MONTH");
  var lLimit = weaponSelectForm1.getValue("L_LIMIT");
  var baseMonth = weaponSelectForm1.getValue("BASE_MONTH");
  var busiType = weaponSelectForm1.getValue("BUSI_TYPE"); 
  var goodAdoptDirectory = weaponSelectForm1.getValue("GOOD_ADOPT_DIRECTORY");
  var createTime = weaponSelectForm1.getValue("CREATE_TIME");
  saleFlag = weaponSelectForm.getValue("SALE_FLAG");
  var selfBusi=weaponSelectForm1.getValue("PRESTRORE_REACH_ACCOUNT");
  var couponsValue=weaponSelectForm1.getValue("PRESTORE_FEE");
  var state=weaponSelectForm.getValue("STATE");
  var presentBusiAmount=weaponSelectForm1.getValue("PRESENT_BUSI_AMOUNT");
  var presentReachAmount=weaponSelectForm1.getValue("PRESENT_REACH_AMOUNT");
  var presentValuePermon=weaponSelectForm1.getValue("PRESENT_VALUE_PERMON");
  var presentBusi2Amount=weaponSelectForm1.getValue("PRESENT_BUSI2_AMOUNT"); 
  var presentBusi4Amount=weaponSelectForm1.getValue("PRESENT_BUSI4_AMOUNT"); 
  var openMonth=weaponSelectForm1.getValue("OPEN_MONTH"); 
  var zfqType=weaponSelectForm1.getValue("ZFQ_TYPE");  
   //alert(selfBusi+"s"+couponsValue);
   if(marketType=="sy"){marketType="";}
   if(saleFlag=="sy"){saleFlag="";}
   if(state=="SY"){state="";}
    var list = new Array();
	list.push(weaponMainListTable);
	var strUrl = _gModuleName + '/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=getSaleWeapon';
	saveRowSet(strUrl, list);
	weaponMainListTable.refresh("&wid="+wid+"&wwid="+wwid+"&netAge="+netAge+"&backMonth="+backMonth+"&weaponName="+encodeURI(trim(weaponName))+"&marketType="+marketType
								+"&bLimit="+bLimit+"&backMonth="+backMonth+"&lLimit="+lLimit+"&baseMonth="+baseMonth+"&busiType="+encodeURI(trim(busiType))
								+"&goodAdoptDirectory="+goodAdoptDirectory+"&saleFlag="+saleFlag+"&selfBusi="+selfBusi+"&couponsValue="+couponsValue
								+"&state="+state+"&presentBusiAmount="+presentBusiAmount+"&presentReachAmount="+presentReachAmount+"&presentValuePermon="+presentValuePermon
								+"&presentValuePermon="+presentValuePermon+"&presentBusi2Amount="+presentBusi2Amount+"&zfqType="+zfqType
								+"&minNetAge="+minNetAge+"&maxNetAge="+maxNetAge+"&presentBusi4Amount="+presentBusi4Amount+"&openMonth="+openMonth);
	
	}


function moreQuery(){
   window.showModalDialog("<%=request.getContextPath()%>/sale/weapon/WeaponInfo.jsp",'',"scroll:no;resizable:no;status:no;dialogHeight:450px;dialogWidth:600px");
}


function showWeaponInfo(){
	var curRow = weaponMainListTable.getRow();
	var wid = weaponMainListTable.getValue(curRow,"MID");
	var saleFale = weaponMainListTable.getValue(curRow,"SALE_FLAG");
	var state = weaponMainListTable.getValue(curRow,"STATE");
	if (state == "") return alert("��ѡ��鿴������");
	window.open("<%=request.getContextPath()%>/sale/weapon/WeaponInfo.jsp?WID="+wid+"&saleFale="+saleFale,"","height=650,width=730,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no"); 
}   	

function showRelatSaleInfo() {
	var curRow = weaponMainListTable.getRow();
	var wpId = weaponMainListTable.getValue(curRow,"WID");
	if(wpId == null || wpId == '' || wpId == 'undefined') 
		return alert("��ѡ���У�");
	window.open("<%=request.getContextPath()%>/sale/weapon/relatSale.jsp?wpId="+wpId,"","height=650,width=730,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no"); 
}

function modifyInfo(oldRow,newRow)
{
	var selRows = weaponMainListTable.getSelectedRows();
	var  wid=weaponMainListTable.getValue(selRows,"WID");
	var  saleFlag=weaponMainListTable.getValue(selRows,"SALE_FLAG");
	var  state=weaponMainListTable.getValue(selRows,"STATE");
	if(wid==""){
	  alert("��ѡ��Ҫ��ӵĶ���");
	 }else{
	 if(state=="U"||state=="W"){
	   window.returnValue=wid+","+saleFlag;
	   window.self.close();
	 }else{alert("״̬����ȷ!")}
	}
}

function selectOrgType()
{
	var url = "<%=request.getContextPath()%>/secframe/orgmodel/organize/OrgTypeTree.jsp";
	var result = window.showModalDialog(url,"org","scroll:no;resizable:no;status:no;dialogHeight:460px;dialogWidth:300px");
	if(result=='undefined'||result==null){
		result="";
	} else {
		g_FormRowSetManager.get("weaponMainSelectForm").setValue("ORG",result);	
	}
}

function onrowchange1(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	weaponMainListTable.setRowBgColor(oldIndex,"");
    }
    	weaponMainListTable.setRowBgColor(newIndex,"yellow");
}

function selectStaff()
{
	var url = "<%=request.getContextPath()%>/secframe/orgmodel/operator/StaffSelect.jsp";
	var result = window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:no;dialogHeight:600px;dialogWidth:320px");
	if(result=='undefined'||result==null){
		result="";
	} else {
		g_FormRowSetManager.get("weaponMainSelectForm").setValue("APPLICANT", result); 
	}
} 

function selectStaffid()
    {
        //var url = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_ss.jsp?org_id=10";
       // var result = window.showModalDialog(url, null, "scroll:yes;resizable:no;help:no;status:no;dialogHeight:490px;dialogWidth:560px");
        var result=openSelect.staffSelect("tsd",'10');
        if(result != null){
            var operatorId;
            var name;
            for(var i=0;i < result.elements.length;i++)
            {
                if (i == 0)
                {
                    operatorId = result.elements[i].operatorId;
                    name = result.elements[i].name;
                } else {
                    operatorId = operatorId + ";" + result.elements[i].operatorId;
                    name = name + ";" + result.elements[i].name;
                }
            }
            weaponSelectForm.setValue("STAFFID", operatorId,name); 
        }
    } 
    
function showcell(){
	 var curRow = weaponMainListTable.getRow();
	 var curCol = weaponMainListTable.getCol();
	 if(curCol==2){
	   var msg = weaponMainListTable.getValue(curRow,"WEAPON_NAME");
       var obj= new Object();
	   if(msg!=""){
        //window.alert(msg);
        //document.write(msg);
        var url="<%=request.getContextPath()%>/sale/weapon/showmsg.jsp";
        obj.name = msg;
        window.showModalDialog(url, obj, "scroll:yes;resizable:yes;help:no;status:yes;dialogHeight:200px;dialogWidth:400px;unadorned:yes");
        //window.open(url, obj, "scroll:yes;resizable:yes;help:no;status:no;dialogHeight:200px;dialogWidth:400px");
	   }
	 }
}
</script>