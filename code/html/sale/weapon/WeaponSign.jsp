<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<%
   String recordId = request.getParameter("recordId");
 %>
<html>
<head>
<title>会签</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="init()">
  
    <ai:contractframe id="saleWeaponMainframe" contenttype="table" title="操作人信息" width="100%" allowcontract="true" frameclosed="fale">
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
  
  
<ai:contractframe id="weaponListframe" contenttype="table" title="武器详情" width="100%" allowcontract="false" frameclosed="fale" >
	<ai:contractitem/>
 	<ai:table
		tableid="weaponMainListTable"
		setname="com.asiainfo.sale.weapon.web.SETSaleWeapon"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV"
		implservice_querymethod="getSaleWeapon(String mid,String wwid,String wid,String weaponName, String marketType,
			String backMonth, String baseMonth, String lLimit, String bLimit,
			String presentValuePermon, String presentBusiMonth, String busiType,
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
		onrowchange="" 
		initial="false" pagesize="7" editable="false" width="100%"
		height="160" needrefresh="true">
		<ai:col title="编号" fieldname="WID" width="10%"  visible="false"/>
		<ai:col title="工单编号" fieldname="MID" width="10%"/>
		<ai:col title="武器名称" fieldname="WEAPON_NAME" width="20%" />
		<ai:col title="类型" fieldname="SALE_FLAG" width="15%" />
		<ai:col title="细分市场" fieldname="MARKET_TYPE" width="15%" />
		<ai:col title="网龄" fieldname="NET_AGE" width="15%" />
			<ai:col title="创建时间" fieldname="CREATE_TIME" width="17%" />
	</ai:table>
</ai:contractframe>

  <div class="area_button">
  <ai:button text="查看详细" id="query1" onclick="doWork('modifyInfo()')" />&nbsp;&nbsp;
  <!--对于<a href>打开的窗口必须使用“#nogo”; -->
</div>

<!--<ai:contractframe id="weaponListframe" contenttype="table" title="会签意见" width="100%" allowcontract="false" frameclosed="fale" >
	<ai:contractitem/>
 <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2" id="signTbl">
     <tr> <td class="td_font"><b>会签意见：</b></td>
          <td colspan="6"><textarea id="txtSignAdvice"  style="width=800;height=200"></textarea></td>
     </tr>
</table>
<div class="area_button">
  <ai:button text="提交" id="query1" onclick="doWork('Sign()')" />&nbsp;&nbsp;
</div>
</ai:contractframe>
 -->
 
<ai:contractframe id="wfCheckframe" contenttype="table" title="指定人信息" width="98%" allowcontract="true" frameclosed="false">
    <ai:contractitem/>
    <ai:dbform formid="wfCheckForm" 
        onvalchange="" initial="false"
        setname="com.asiainfo.sale.common.web.SETFWOperate">
        <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
            <tr style="">
                <td class="td_font"  style="display: none">会签人编号：</td>
                <td  style=""><ai:dbformfield formid="wfCheckForm" fieldname="APPLYID" visible="false"/></td>
            </tr>
            <tr id="result" >
                <td class="td_font">协办人：</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="ASSISTEMP" width="260" visible=""/>
                <img id="selectStaff1" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff('ASSISTEMP');" align="absmiddle" style="cursor:hand;"/>
                <ai:dbformfield formid="wfCheckForm" fieldname="RESULT" width="260" visible="false"/></td>
            </tr>
             <tr id="comment">
                <td class="td_font">知会人：</td>
                <td>
                <ai:dbformfield formid="wfCheckForm" fieldname="APPRISEEMP" width="260" visible=""/>
                <img id="selectStaff2" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff('APPRISEEMP');" align="absmiddle" style="cursor:hand;"/>
                <ai:dbformfield formid="wfCheckForm" fieldname="COMMENT" width="260" height="60" visible="false"/></td>
            </tr>
            <tr id="staffs" style="display:none">
                <td class="td_font" id="staffMain01">会签人：</td>
                <td id="staffMain02"><ai:dbformfield formid="wfCheckForm" fieldname="STAFFS" width="260" />
                <img id="selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="selectStaff('STAFFS');" align="absmiddle" style="cursor:hand;"/></td>
            </tr>
            <tr id="reason" style="">
                <td class="td_font">说明：</td>
                <td><ai:dbformfield formid="wfCheckForm" fieldname="REASON" width="500" height="100"/></td>
            </tr>
            <tr><td class="td_font"><ai:button text="提交" id="query1" onclick="doWork('Sign()')" />&nbsp;&nbsp;</td></tr>
        </table>
    </ai:dbform>
</ai:contractframe>
<ai:loginuser/>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js"></script>
<script type="text/javascript">
var weaponMainListTable=g_TableRowSetManager.get("weaponMainListTable");
var saleWeaponMainframe = g_FormRowSetManager.get("saleWeaponMainframe");
var _fromWfCheckFormRowSet = g_FormRowSetManager.get("wfCheckForm");
var rid = <%=recordId%>;

function init(){
    var staffId = g_GetUserInfo().STAFF_ID;
    saleWeaponMainframe.setValue("APPLICANT",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
    saleWeaponMainframe.setValue("PRINCIPAL",g_GetUserInfo().STAFF_ID,g_GetUserInfo().STAFF_NAME);
    saleWeaponMainframe.setValue("PROMOTE_DEPART",g_GetUserInfo().ORG_ID,g_GetUserInfo().ORG_NAME);
	saleWeaponMainframe.setValue("ORG",g_GetUserInfo().ORG_ID,g_GetUserInfo().ORG_NAME);
    var weaponMainListTable=g_TableRowSetManager.get("weaponMainListTable");
    var list = new Array();
	list.push(weaponMainListTable);
	var strUrl = _gModuleName + '/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=getSaleWeaponAssign&taskTag=sign01';
	saveRowSet(strUrl,list);
	if(rid==null){
	//weaponMainListTable.refresh("&taskTag=sign01");
	}else{
	weaponMainListTable.refresh("&wid="+rid+"&weaponName="+"&busiType=");
	}
	weaponMainListTable.rowSelected(0,true);
}
function showSignOrAudit(){
         var curRow = weaponMainListTable.getRow();
		var taskTag = "<%=request.getParameter("taskTag")%>";
}


function Sign(){
			var curRow = weaponMainListTable.getRow();
			var wid = weaponMainListTable.getValue(curRow,"MID");
			//var taskTag = weaponMainListTable.getValue(curRow,"TASK_TAG");
			var reason=_fromWfCheckFormRowSet.getValue("REASON");
			var workflowId = "<%=request.getParameter("workflowId")%>";
			var appriseEmp=_fromWfCheckFormRowSet.getValue("APPRISEEMP");
			var assistEmp=_fromWfCheckFormRowSet.getValue("ASSISTEMP");
			var taskTag="<%=request.getParameter("taskTag")%>";
			var taskId="<%=request.getParameter("taskId")%>";
			var taskType = "user";
			var flowType = "weaponCase";
				var mainId = wid;
			//var reason=encodeURI(rea);
			//alert(g_GetUserInfo());
			 if(reason==""){
            alert("请输入会签信息！");
            return;
            }
			if(wid!=""){	
				//知会环节
				if(assistEmp!=""||appriseEmp!=""){
				var showcondition = 'workflowId=' + workflowId + '&appriseEmp=' + appriseEmp + '&assistEmp=' + assistEmp + '&content=' +reason ;
				var strUrlzh = '<%=request.getContextPath()%>/business/com.asiainfo.sale.common.web.AppriseAction?action=saveAppriseMember&' + showcondition;
				var recode = PostInfo(strUrlzh, null);
				}
				//知会环节结束
           // var strUrl = "<%=request.getContextPath()%>/business/com.asiainfo.sale.weapon.web.SaleWeaponAction?action=SignSaleWeapon&wid="+wid+"&taskTag="+taskTag+"&reason="+reason;      
            	var strUrl = _gModuleName + '/business/com.asiainfo.workflow.util.web.TaskUtilAction?action=finishUserTask&staffId=20005232'+"&reason="+reason+"&taskId="+taskId+"&taskType="+taskType;
							
            var ud = PostInfo(strUrl,"");
           
            if(ud){
             alert(ud.getValueByName("MESSAGE"));
             window.parent.opener.location.reload();
            	window.self.close();
            }   
            }else{
            alert("请选择行列！");
            }
            init();
}


function selectStaff(showtype)
    {
       	// var url = "<%=request.getContextPath()%>/sale/common/modaldialog/StaffSelect_s.jsp?org_id=10";
        //var result = window.showModalDialog(url, null, "scroll:yes;resizable:no;help:no;status:no;dialogHeight:490px;dialogWidth:560px");
         //var result = openSelect.staffSelect("tmd",'10');
         var result = openSelect.staffSelect("tmd",'10',g_GetUserInfo().ORG_ID);
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
              _fromWfCheckFormRowSet.setValue("APPLYID", operatorId);
              if(showtype=="STAFFS"){
              _fromWfCheckFormRowSet.setValue("STAFFS", operatorId, name); 
              }else if(showtype=="APPRISEEMP"){
                _fromWfCheckFormRowSet.setValue("APPRISEEMP", operatorId, name); 
              }else if(showtype=="ASSISTEMP"){
                _fromWfCheckFormRowSet.setValue("ASSISTEMP", operatorId, name); 
              }
        }
    } 
 
function modifyInfo(oldRow,newRow){
			var curRow = weaponMainListTable.getRow();
			var wid = weaponMainListTable.getValue(curRow,"MID");
		    var saleFale = weaponMainListTable.getValue(curRow,"SALE_FLAG");		
			if(wid!=""){	
		   // window.showModalDialog("<%=request.getContextPath()%>/sale/weapon/WeaponInfo.jsp?WID="+wid+"&saleFale="+saleFale,"","dialogWidth=500px"); 
		      window.open("<%=request.getContextPath()%>/sale/weapon/WeaponInfo.jsp?WID="+wid+"&saleFale="+saleFale,"","height=650,width=700,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
            }else{
            alert("请选择行列！");
            }
		}   
</script>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<script type="text/javascript">
function doWork(fun){ 
    beginAIWaitBanner(fun,"正在处理，请稍后...");
}
</script>
  </body>
</html>
