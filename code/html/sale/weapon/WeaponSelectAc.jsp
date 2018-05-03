<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>武器查询</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="onSaleTypeChange()">
<ai:contractframe id="weaponMainSelectframe" contenttype="table" title="武器类别查询" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	<ai:dbform formid="weaponSelectForm" 
		setname="com.asiainfo.sale.weapon.web.SETSaleWeapon"
		onvalchange=""  editable="true" initial="false">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
			<tr>
	           	<td class="td_font">工单编号：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm" fieldname="WID" visible="false"/>
	           	<ai:dbformfield formid="weaponSelectForm" fieldname="MID" /></td>
	           	<td class="td_font">名称：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm" fieldname="WEAPON_NAME"/></td>

			</tr>
			<tr>
	           	<td class="td_font" style="display:none;">细分市场：</td>
	           	<td style="display:none;"><ai:dbformfield formid="weaponSelectForm" fieldname="MARKET_TYPE"/></td>
	           	<td class="td_font">网龄：</td>
			    <td><ai:dbformfield formid="weaponSelectForm" fieldname="NET_AGE" width="50" visible="false"/>
	           	<ai:dbformfield formid="weaponSelectForm" fieldname="MINNET_AGE" width="50"/>至<ai:dbformfield formid="weaponSelectForm" fieldname="MAXNET_AGE" width="50"/>(月)</td>
	          </tr>
	        <tr>
		    <td class="td_font">活动类别：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm" fieldname="SALE_FLAG"/></td>
	           	<td class="td_font">状态：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm" fieldname="STATE"/></td>
	           	</tr>
		</table>
	</ai:dbform>
</ai:contractframe>

<ai:contractframe id="weaponMainSelectframe1" contenttype="table" title="高级查询" width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem/>
	<ai:dbform formid="weaponSelectForm1" 
		setname="com.asiainfo.sale.weapon.web.SETSaleWeapon" initial="false">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2" id="tab">
		 <tr id="tr21" style="display:none">
	           	<td class="td_font"><b>数据包：</b></td>
			</tr>
			<tr id="tr22" style="display:none">
			 	<td class="td_font">数据包总价值：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="DATA_FEE"/></td>	
			
	           	<td class="td_font">数据业务类型：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="DATA_BUSI_TYPE"/></td>	
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
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESTORE_FEE"/>至
	           	<ai:dbformfield formid="weaponSelectForm1" fieldname="PRESTRORE_REACH_ACCOUNT"/>(元)</td>
			</tr>
			  <tr id="tr3">
	           	<td class="td_font">返还额度：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="B_LIMIT"/></td>
	           	<td class="td_font">返还月份：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="BACK_MONTH"/></td>
			</tr>
			   <tr id="tr4">
	           	<td class="td_font"><b>赠送：</b></td>
	           	 
			</tr>
			<tr id="tr5">
	           	<td class="td_font">赠送话费金额：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI_AMOUNT"/>至
	           	<ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_REACH_AMOUNT"/>(元）</td>
			</tr>
			
			<tr id="tr6">
	           	<td class="td_font">赠送支付劵面额：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI2_AMOUNT"/>(元）</td>
	           	<td class="td_font">赠送支付类型：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="ZFQ_TYPE"/></td>
			    </tr>
			<tr id="tr7">
	           	<td class="td_font">支付类型描述：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_1"/>(元）</td>
	           	</tr>
			<tr id="tr8">
			    <td class="td_font">货品业务总价值：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI3_AMOUNT"/>(元）</td>
	           	<td class="td_font">货品采购目录：</td>
	           	<td><!--<ai:dbformfield formid="weaponSelectForm1" fieldname="GOOD_ADOPT_DIRECTORY"/>--></td>
			</tr>
			<tr id="tr9"> 	
			    <td class="td_font">货品销售指导价：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="REFERENCE_PRICE"/>(元）</td>         
	           	<td class="td_font" style="display:none">货品描述：</td>
	           	<td style="display:none"><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_2"/>(元）</td>
	           	</tr>
			<tr id="tr10">
	           	<td class="td_font">终端实际购买款：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="TERM_REAL_FEE"/>(元）</td>
	           	<td class="td_font">终端类型：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="TERM_TYPE"/></td>
			</tr>
			<tr id="tr11">
	           	<td class="td_font">终端销售指导价：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="TERM_GUIDE_FEE"/>(元）</td>
	           	<td class="td_font">终端成本结算价：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="TERM_COST_FEE"/></td>
			</tr>
			<tr id="tr12">
	           	<td class="td_font" style="display:none">终端描述：</td>
	           	<td style="display:none"><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_4"/>(元）</td>
	           	</tr>
			<tr id="tr13">
	           	<td class="td_font">数字产品总价格：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI5_AMOUNT"/>(元）</td>
	 		</tr>
	 		<tr id="tr14">
	           	<td class="td_font">数字产品描述：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_5"/>(元）</td>
	 		</tr>
	 		<tr id="tr15">	
		 	   <td class="td_font"><b>赠送自有业务：</b></td>
	       </tr>
	 		<tr id="tr16">
	           <td class="td_font">自有业务总价值：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI4_AMOUNT"/>(元）</td>
	           	<td class="td_font">业务类型：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="BUSI_TYPE"/></td>
			</tr>
			<tr id="tr17">
	           	<td class="td_font">自有业务描述：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="REMARK_3"/>(元）</td>
	           	</tr>
			
			<tr id="tr18">
	           	<td class="td_font">每月赠送：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_VALUE_PERMON"/>(元）</td>
	           	<td class="td_font">赠送月份：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="PRESENT_BUSI_MONTH"/></td>
			</tr>
			<tr id="tr19">
	           	<td class="td_font"><b>保底：</b></td>
	           	
			</tr>
			<tr id="tr20">
	           	<td class="td_font">保底额度：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="L_LIMIT"/></td>
	           	<td class="td_font">保底月数：</td>
	           	<td><ai:dbformfield formid="weaponSelectForm1" fieldname="BASE_MONTH"/></td>
			</tr>
			
	</table>
	</ai:dbform>
</ai:contractframe>

<div class="area_button">
	           		<ai:button id="queryWeapon" text="查询" onclick="queryWeaponMain()"/>
</div>

<ai:contractframe id="weaponListframe" contenttype="table" title="武器详情" width="100%" allowcontract="false" frameclosed="fale" >
	<ai:contractitem/>
 	<ai:table
		tableid="weaponMainListTable"
		setname="com.asiainfo.sale.weapon.web.SETSaleWeapon"
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
		  ondbclick="showInfo"  onrowchange="onrowchange1" oncellchange="showcell" 
		initial="false" pagesize="7" editable="false" width="100%"
		height="160" needrefresh="true">
		<ai:col title="编号" fieldname="WID" width="10%" visible=""/>
		<ai:col title="工单编号" fieldname="MID" width="10%" />
		<ai:col title="武器名称" fieldname="WEAPON_NAME" width="20%" />
		<ai:col title="类型" fieldname="SALE_FLAG" width="15%" />
		<ai:col title="细分市场" fieldname="MARKET_TYPE" width="15%" />
		<ai:col title="网龄" fieldname="NET_AGE" width="15%" />
		<ai:col title="创建时间" fieldname="CREATE_TIME" width="20%" />
		<ai:col title="状态" fieldname="STATE" width="6%" />
		<ai:col title="" fieldname="REMARK_4" width="6%" visible="false"/>
	</ai:table>
</ai:contractframe>

  <div class="area_button">
  <ai:button text="确定选择该武器" id="query1" onclick="modifyInfo()" />&nbsp;&nbsp;
  <!--对于<a href>打开的窗口必须使用“#nogo”; -->
    <ai:button text="查看详细" id="query1" onclick="showInfo()" />&nbsp;&nbsp;
</div>
</body>
</html>
<ai:loginuser/>
<script type="text/javascript">

   var weaponSelectForm = g_FormRowSetManager.get("weaponSelectForm");
   var weaponMainListTable = g_TableRowSetManager.get("weaponMainListTable");	
   var weaponSelectForm1 = g_FormRowSetManager.get("weaponSelectForm1");
    var itemTypes = window.dialogArguments.itemTypes; 
	var aray=new Array();
	aray = itemTypes.split(";");
    var saleType=aray[0];
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
	    weaponSelectForm.setColEditSts("MARKET_TYPE",false);
	    weaponSelectForm.setColEditSts("SALE_FLAG",false);
	    weaponSelectForm.setValue("MARKET_TYPE","");
	    weaponSelectForm.setValue("SALE_FLAG",saleType);	
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
	  // document.getElementById("tr8").style.display="block";
	  // document.getElementById("tr9").style.display="block";
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
	  // document.getElementById("tr8").style.display="block";
	  // document.getElementById("tr9").style.display="block";
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
	  // document.getElementById("tr8").style.display="block";
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
	  // document.getElementById("tr8").style.display="block";
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
   if(saleType=="sy"){saleType="";}
   if(state=="SY"){state="";}
    var list = new Array();
	list.push(weaponMainListTable);
	var strUrl = _gModuleName + '/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=getSaleWeapon';
	saveRowSet(strUrl, list);
	weaponMainListTable.refresh("&wid="+wid+"&netAge="+netAge+"&backMonth="+backMonth+"&weaponName="+encodeURI(trim(weaponName))+"&marketType="+marketType
								+"&bLimit="+bLimit+"&backMonth="+backMonth+"&lLimit="+lLimit+"&baseMonth="+baseMonth+"&busiType="+busiType
								+"&goodAdoptDirectory="+goodAdoptDirectory+"&saleFlag="+saleFlag+"&selfBusi="+selfBusi+"&couponsValue="+couponsValue
								+"&state="+state+"&presentBusiAmount="+presentBusiAmount+"&presentReachAmount="+presentReachAmount+"&presentValuePermon="+presentValuePermon
								+"&presentValuePermon="+presentValuePermon+"&presentBusi2Amount="+presentBusi2Amount+"&zfqType="+zfqType+"&presentBusi4Amount="+presentBusi4Amount+"&openMonth="+openMonth
								+"&minNetAge="+minNetAge+"&maxNetAge="+maxNetAge);
	
	}


function moreQuery(){
   window.showModalDialog("<%=request.getContextPath()%>/sale/weapon/WeaponInfo.jsp",'',"scroll:no;resizable:no;status:no;dialogHeight:450px;dialogWidth:600px");
}


function showInfo(){
			var curRow = weaponMainListTable.getRow();
			var wid = weaponMainListTable.getValue(curRow,"MID");
		   var saleFale = weaponMainListTable.getValue(curRow,"SALE_FLAG");		
		    var state = weaponMainListTable.getValue(curRow,"STATE");	
			  if(state=="P"){
		    window.showModalDialog("<%=request.getContextPath()%>/sale/weapon/WeaponInfoCommit.jsp?WID="+wid+"&saleFale="+saleFale+"&state="+state,"","dialogWidth=500px"); 
		       }		
			else if(wid!=""){
		    window.open("<%=request.getContextPath()%>/sale/weapon/WeaponInfo.jsp?WID="+wid+"&saleFale="+saleFale,"","height=650,width=730,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no"); 
            }else{
            alert("请选择行列！");
            }
		}   	

function modifyInfo(oldRow,newRow)
	{
		var selRows = weaponMainListTable.getSelectedRows();
		var  wid=weaponMainListTable.getValue(selRows,"WID");
		var  saleFlag=weaponMainListTable.getValue(selRows,"SALE_FLAG");
		var  state=weaponMainListTable.getValue(selRows,"STATE");
		var  city=weaponMainListTable.getValue(selRows,"REMARK_4");
		//alert(g_GetUserInfo().ORG_ID.substr(0,2));
		//alert("city:"+city);
		if(city!="10"){
		 if(g_GetUserInfo().ORG_ID.substr(0,2)!=city){
		 if(g_GetUserInfo().ORG_ID.substr(0,2)=='18'||g_GetUserInfo().ORG_ID.substr(0,2)=='27'||g_GetUserInfo().ORG_ID.substr(0,2)=='28'){
		  if(city!='18'&&city!='27'&&city!='28'){
		  	 return alert("您选择的地市与您所在的地市不一致!请选择其他武器或者申请武器!");
		  }
		 }
		 }
		}
		if(wid==""){
		  alert("请选择要添加的对象！");
		 }else{
		 if(state=="U"||state=="W"||state=="C"||state=="A"){
		   window.returnValue=wid+","+saleFlag;
		   window.self.close();
		 }else{alert("武器不可用!")}
		}
	}




function showWeaponInfo()
{
	var curRow = g_TableRowSetManager.get("weaponMainListTable").getRow();
	var mainId = g_TableRowSetManager.get("weaponMainListTable").getValue(curRow, "ID");
	g_FormRowSetManager.get("weaponInfoForm").refresh("&mainId=" + mainId);
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

function onrowchange1(oldIndex,newIndex){
    if(-1 != oldIndex) {
    	weaponMainListTable.setRowBgColor(oldIndex,"");
    }
    	weaponMainListTable.setRowBgColor(newIndex,"yellow");
}

function showcell(){
	 var curRow = weaponMainListTable.getRow();
	 var curCol = weaponMainListTable.getCol();
	 if(curCol==1){
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