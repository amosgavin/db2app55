<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>自制武器查询</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="onSaleTypeChange()">

 <ai:contractframe id="saleWeaponMainframe" contenttype="table" title="操作人信息" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
	<ai:dbform formid="saleWeaponMainframe" 
			setname="com.asiainfo.sale.weapon.web.SETSaleWeaponMain"
			conditionname="condition" parametersname="parameters"
			onvalchange="" editable="true" initial="false"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponMainSV"
			implservice_querymethod="getSaleWeaponMainById(String id)">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<ai:dbformfield formid="saleWeaponMainframe" fieldname="WMID" visible="false"/>   
	           	<ai:dbformfield formid="saleWeaponMainframe" fieldname="WID" visible="false"/>      	
	           	<td class="td_font">当前操作人：</td>
	           	<td><ai:dbformfield formid="saleWeaponMainframe" fieldname="APPLICANT" width="150" editable="false"/>
	           	<td><ai:dbformfield formid="saleWeaponMainframe" fieldname="PRINCIPAL" width="150" visible="false"/>
	           	<td class="td_font">操作人单位：</td>
	           	<td><ai:dbformfield formid="saleWeaponMainframe" fieldname="ORG" width="130" editable="false"/>
	           		<td><ai:dbformfield formid="saleWeaponMainframe" fieldname="PROMOTE_DEPART" width="130" visible="false"/>
			</tr>
			<tr style="display:none">
	           	<td class="td_font">当前时间：</td>
	           	<td><ai:dbformfield formid="saleWeaponMainframe" fieldname="CREATE_TIME" width="150"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
  
<ai:contractframe id="weaponMainSelectframe" contenttype="table" title="武器类别查询" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	<ai:dbform formid="weaponSelectForm" 
		setname="com.asiainfo.sale.weapon.web.SETSaleWeapon"
		onvalchange="onSaleTypeChange"  editable="true" initial="false">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">工单编号：</td>
	           	<td>
	           	<ai:dbformfield formid="weaponSelectForm" fieldname="MID" width="150"/></td>
	           	<td class="td_font">武器编号：</td>
	           	<td>
	           	<ai:dbformfield formid="weaponSelectForm" fieldname="WID"  width="150"/>
	          </td>

			</tr>
			<tr>
			<td class="td_font">武器名称：</td>
			<td><ai:dbformfield formid="weaponSelectForm" fieldname="WEAPON_NAME" width="150"/></td>
			</tr>
			<tr>
	           	<td class="td_font">细分市场：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm" fieldname="MARKET_TYPE" width="150"/></td>
	           	<td class="td_font">网龄：</td>
	         	<td><ai:dbformfield formid="weaponSelectForm" fieldname="NET_AGE" width="50" visible="false"/>
	           	<ai:dbformfield formid="weaponSelectForm" fieldname="MINNET_AGE" width="70"/>至<ai:dbformfield formid="weaponSelectForm" fieldname="MAXNET_AGE" width="70" />(月)</td>
	         </tr>
	        <tr>
		    <td class="td_font">活动类别：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm" fieldname="SALE_FLAG" width="150"/></td>
	           	<td class="td_font">状态：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm" fieldname="STATE" width="150"/></td>
	           	</tr>
		</table>
	</ai:dbform>
</ai:contractframe>

<ai:contractframe id="weaponMainSelectframe1" contenttype="table" title="高级查询" width="100%" allowcontract="true" frameclosed="true">
	<ai:contractitem/>
	<ai:dbform formid="weaponSelectForm1" 
		setname="com.asiainfo.sale.weapon.web.SETSaleWeapon" initial="false">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2" id="tab">
		 <tr id="tr21" style="display:none">
	           	<td class="td_font"><b>畅享：</b></td>
			</tr>
			<tr id="tr22" style="display:none">
			 	<td class="td_font">数据包总价值：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="DATA_FEE" width="150"/></td>	
			
	           	<td class="td_font">数据业务类型：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="DATA_BUSI_TYPE"  width="150"/></td>	
	          </tr>
				<tr id="tr23" style="display:none">
	           	<td class="td_font">每月价值：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="GOOD_ADOPT_DIRECTORY" width="150"/></td>
	           	<!-- <ai:dbformfield formid="weaponSelectForm1" fieldname="VALUE_PERMONTH" width="150"/> -->	
	           	<td class="td_font">开通月数：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="OPEN_MONTH" width="150"/></td>	
			</tr>
		        <tr id="tr1">
	           	<td class="td_font"><b>预存：</b></td>
			</tr>
		    <tr id="tr2">
	           	<td class="td_font" >预存话费金额：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESTORE_FEE"  width="70"/>至<ai:dbformfield formid="weaponSelectForm1" fieldname="PRESTRORE_REACH_ACCOUNT"  width="70"/>(元)</td>
			</tr>
			  <tr id="tr3">
	           	<td class="td_font">返还额度：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="B_LIMIT"  width="150"/></td>
	           	<td class="td_font">返还月份：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="BACK_MONTH"  width="150"/></td>
			</tr>
			   <tr id="tr4">
	           	<td class="td_font"><b>赠送：</b></td>
	           	 
			</tr>
			<tr id="tr5">
	           	<td class="td_font">赠送话费金额：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI_AMOUNT" width="70"/>至<ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_REACH_AMOUNT" width="70"/>(元)</td>
			</tr>
			
			<tr id="tr6">
	           	<td class="td_font">赠送支付劵面额：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI2_AMOUNT" width="150"/>(元)</td>
	           	<td class="td_font">赠送支付类型：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="ZFQ_TYPE" width="150"/></td>
			    </tr>
			<tr id="tr7">
	           	<td class="td_font">支付类型描述：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_1" width="150"/>(元)</td>
	           	</tr>
			<tr id="tr8">
			    <td class="td_font">货品业务总价值：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI3_AMOUNT" width="150"/>(元)</td>
	           	<td class="td_font">货品采购目录：</td>
	           	<td><!--<ai:dbformfield formid="weaponSelectForm1" fieldname="GOOD_ADOPT_DIRECTORY" width="150"/>--></td>
			</tr>
			<tr id="tr9"> 	
			    <td class="td_font">货品销售指导价：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="REFERENCE_PRICE" width="150"/>(元)</td>         
	           	<td class="td_font" style="display:none">货品描述：</td>
	           	<td style="display:none"><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_2" width="150"/>(元)</td>
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
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="TERM_COST_FEE" width="150"/></td>
			</tr>
			<tr id="tr12">
	           	<td class="td_font" style="display:none">终端描述：</td>
	           	<td style="display:none"><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_4" width="150"/>(元)</td>
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
			
			<tr id="tr18">
	           	<td class="td_font">每月赠送：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_VALUE_PERMON" width="150"/>(元)</td>
	           	<td class="td_font">赠送月份：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI_MONTH" width="150"/></td>
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
			
	</table>
	</ai:dbform>
</ai:contractframe>

<div class="area_button">
	           		<ai:button id="queryWeapon" text="查询" onclick="queryWeaponMain()"/>
</div>

<ai:contractframe id="weaponListframe" contenttype="table" title="武器详情" width="100%" allowcontract="false" frameclosed="fale" >
	<ai:contractitem> 
	<ai:button id="bt_delweapon" text="删除武器"  onclick="delWeaponDetail()"/>
	<ai:button id="bt_backweapon" text="回撤武器"  onclick="backWeaponDetail()"/>
	</ai:contractitem>
 	<ai:table
		tableid="weaponMainListTable"
		setname="com.asiainfo.sale.weapon.web.SETSaleWeapon"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
		implservice_querymethod="getSaleWeapon(String mid,String wwid,String wid,String weaponName, String marketType,
			String backMonth, String baseMonth, String lLimit, String bLimit,
			String saleFlag, String presentBusiMonth, String busiType,
			String netAge, String couponsValue, String selfBusi,
			String goodAdoptDirectory,String state,String presentBusiAmount,
			String presentReachAmount,String presentValuePermon,String presentBusi2Amount,
			String zfqType,String presentBusi4Amount,String openMonth,String minNetAge,String maxNetAge,
			int $STARTROWINDEX, int $ENDROWINDEX)"
		implservice_countmethod="getCount(String mid,String wwid,String wid,String weaponName,
			String marketType, String backMonth, String baseMonth, String lLimit,
			String bLimit, String saleFlag, String presentBusiMonth, String busiType,
			String netAge, String couponsValue, String selfBusi, String goodAdoptDirectory,
			String state,String presentBusiAmount,String presentReachAmount,
			String presentValuePermon,String presentBusi2Amount,
			String zfqType,String presentBusi4Amount,String openMonth,String minNetAge,String maxNetAge)"
		  ondbclick="showWeaponInfo" onrowchange="onrowchange1" oncellchange="showcell" 
		initial="false" pagesize="9" editable="false" width="100%"
		height="200" needrefresh="true">
		<ai:col title="工单编号" fieldname="MID" width="10%" />
		<ai:col title="武器编号" fieldname="WID" width="10%"/>
		<ai:col title="武器名称" fieldname="WEAPON_NAME" width="20%" />
		<ai:col title="类型" fieldname="SALE_FLAG" width="15%" />
		<ai:col title="细分市场" fieldname="MARKET_TYPE" width="15%" />
		<ai:col title="网龄" fieldname="NET_AGE" width="15%" />
		<ai:col title="创建时间" fieldname="CREATE_TIME" width="17%" />
		<ai:col title="状态" fieldname="STATE" width="6%" />
	</ai:table>
</ai:contractframe>
  <div class="area_button">
  	<ai:button text="查看武器明细" id="query1" onclick="showWeaponInfo()" />&nbsp;&nbsp;
    <ai:button text="查看武器关联营销活动" id="query2" onclick="showRelatSaleInfo()" />
  <!--对于<a href>打开的窗口必须使用“#nogo”; -->
</div>
</body>
</html>
<ai:loginuser/>
<script type="text/javascript">

var weaponSelectForm = g_FormRowSetManager.get("weaponSelectForm");
var weaponMainListTable = g_TableRowSetManager.get("weaponMainListTable");	
var weaponSelectForm1 = g_FormRowSetManager.get("weaponSelectForm1");
var saleWeaponMainframe = g_FormRowSetManager.get("saleWeaponMainframe");
function init(){
    for(var i=1;i<24;i++){
	    var num="tr"+i;
	    document.getElementById(num).style.display="none";
    }
}

function onSaleTypeChange()
{
    saleWeaponMainframe.setValue("APPLICANT",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
    saleWeaponMainframe.setValue("PRINCIPAL",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
    saleWeaponMainframe.setValue("PROMOTE_DEPART",g_GetUserInfo().ORG_ID,g_GetUserInfo().ORG_NAME);
	saleWeaponMainframe.setValue("ORG",g_GetUserInfo().ORG_ID,g_GetUserInfo().ORG_NAME);
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
	   document.getElementById("tr4").style.display="block";
	   document.getElementById("tr8").style.display="block";
	   document.getElementById("tr9").style.display="block";
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
	   document.getElementById("tr8").style.display="block";
	   document.getElementById("tr9").style.display="block";
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
	   document.getElementById("tr8").style.display="block";
	   document.getElementById("tr9").style.display="block";
	   document.getElementById("tr15").style.display="block";
	  document.getElementById("tr16").style.display="block";
	 document.getElementById("tr21").style.display="block";
	 document.getElementById("tr22").style.display="block";
	 document.getElementById("tr23").style.display="block";
	   }else if(saleType==41){
	   init();
	  document.getElementById("tr4").style.display="block";
	   document.getElementById("tr5").style.display="block";
	   document.getElementById("tr8").style.display="block";
	   document.getElementById("tr9").style.display="block";
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
  var wwid= weaponSelectForm.getValue("WID");
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
  var saleFlag = weaponSelectForm.getValue("SALE_FLAG");
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
  
  var mid=g_GetUserInfo().STAFF_ID; 
   if(marketType=="sy"){marketType="";}
   if(saleType=="sy"){saleType="";}
   if(state=="SY"){state="";}
    var list = new Array();
	list.push(weaponMainListTable);
	var strUrl = _gModuleName + '/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=getSaleWeapon';
	saveRowSet(strUrl, list);
	weaponMainListTable.refresh("&mid="+mid+"&wid="+wid+"&wwid="+wwid+"&netAge="+netAge+"&backMonth="+backMonth+"&weaponName="+encodeURI(trim(weaponName))+"&marketType="+marketType
								+"&bLimit="+bLimit+"&backMonth="+backMonth+"&lLimit="+lLimit+"&baseMonth="+baseMonth+"&busiType="+busiType
								+"&goodAdoptDirectory="+goodAdoptDirectory+"&saleFlag="+saleType+"&selfBusi="+selfBusi+"&couponsValue="+couponsValue
								+"&state="+state+"&presentBusiAmount="+presentBusiAmount+"&presentReachAmount="+presentReachAmount+"&presentValuePermon="+presentValuePermon
								+"&presentValuePermon="+presentValuePermon+"&presentBusi2Amount="+presentBusi2Amount+"&zfqType="+zfqType+"&presentBusi4Amount="+presentBusi4Amount+"&openMonth="+openMonth
								+"&minNetAge="+minNetAge+"&maxNetAge="+maxNetAge);
	
	}


function moreQuery(){
   window.open("<%=request.getContextPath()%>/sale/weapon/WeaponInfoCommit.jsp",'',"height=490,width=860,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
}


function showWeaponInfo(oldRow,newRow){
	var curRow = weaponMainListTable.getRow();
	var wid = weaponMainListTable.getValue(curRow,"MID");
	var id = weaponMainListTable.getValue(curRow,"WID");
	var saleFale = weaponMainListTable.getValue(curRow,"SALE_FLAG");
	var state = weaponMainListTable.getValue(curRow,"STATE");
	var weaponName = weaponMainListTable.getValue(curRow,"WEAPON_NAME");				
	if(wid!=""){
		if(state=="A"){	
			window.open("<%=request.getContextPath()%>/sale/weapon/WeaponInfoCommit.jsp?WID="+wid+"&saleFale="+saleFale+"&ID="+id,"","height=650,width=730,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no"); 
		}else{
			window.open("<%=request.getContextPath()%>/sale/weapon/WeaponInfo.jsp?WID="+wid+"&saleFale="+saleFale+"&ID="+id,"","height=650,width=730,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no"); 
		}
		queryWeaponMain();
	}else{
		alert("请选择行列！");
	}
}   	

function showRelatSaleInfo() {
	var curRow = weaponMainListTable.getRow();
	var wpId = weaponMainListTable.getValue(curRow,"WID");
	if(wpId == null || wpId == '' || wpId == 'undefined') 
		return alert("请选择行！");
	window.open("<%=request.getContextPath()%>/sale/weapon/relatSale.jsp?wpId="+wpId,"","height=650,width=730,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no"); 
}

function selectOrgType(){
	var url = "<%=request.getContextPath()%>/secframe/orgmodel/organize/OrgTypeTree.jsp";
	var result = window.showModalDialog(url,"org","scroll:no;resizable:no;status:no;dialogHeight:460px;dialogWidth:300px");
	if(result=='undefined'||result==null){
		result="";
	} else {
		g_FormRowSetManager.get("weaponMainSelectForm").setValue("ORG",result);	
	}
}

function selectStaff(){
	var url = "<%=request.getContextPath()%>/secframe/orgmodel/operator/StaffSelect.jsp";
	var result = window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:no;dialogHeight:600px;dialogWidth:320px");
	if(result=='undefined'||result==null){
		result="";
	} else {
		g_FormRowSetManager.get("weaponMainSelectForm").setValue("APPLICANT", result); 
	}
} 

function delWeaponDetail(){
	if(!confirm("您确定删除选中武器！")) {
        return;
    }
	var ss = new Array();
 	ss = weaponMainListTable.getSelectedRows();
  	if (ss.length < 1) {
	    alert("请选择要删除的数据！");
	    return;
	}
	if(weaponMainListTable.getValue(g_TableRowSetManager.get("weaponMainListTable").getRow(), "STATE")=="A"){
		var delid=weaponMainListTable.getValue(g_TableRowSetManager.get("weaponMainListTable").getRow(), "MID");
		//删除武器申请主信息
		var strMainUrl=_gModuleName + '/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=saveSaleWeaponMainA&delid='+delid;
		PostInfo(strMainUrl,null);
	    for ( var i = ss.length; i > 0; i--) {
	       weaponMainListTable.deleteRow(ss[i - 1]);
	    }
	    var list = new Array();
	    list.push(weaponMainListTable);
	    var strUrl = _gModuleName + '/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=delWeaponSTageRelaS';
	    var recode = saveRowSet(strUrl, list);
	    alert("操作成功！");
	    queryWeaponMain();
	 } else {
	 	return alert("武器已进入流程，不能删除！");
	 }
}

function onrowchange1(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	weaponMainListTable.setRowBgColor(oldIndex,"");
    }
    	weaponMainListTable.setRowBgColor(newIndex,"yellow");
}


function backWeaponDetail(){
	var curRow = g_TableRowSetManager.get("weaponMainListTable").getRow();
	var mainId = g_TableRowSetManager.get("weaponMainListTable").getValue(curRow, "MID");
	var staffid=g_GetUserInfo().STAFF_ID;
	var state=g_TableRowSetManager.get("weaponMainListTable").getValue(curRow, "STATE");
	var objectType="weaponCase";
	if("C"==state){
	var strMainUrl=_gModuleName + '/business/com.asiainfo.task.web.CurTaskAction?action=terminateWorkflow&object_id='+mainId+'&staffId='+staffid+'&object_type='+objectType;
	var recode= PostInfo(strMainUrl);
	alert( recode.getValueByName("MESSAGE"));
	  //window.location.reload();
	  queryWeaponMain();
	}else{
	return alert("当前状态不能回撤！");
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