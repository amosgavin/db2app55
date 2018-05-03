<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.asiainfo.crm.so.common.RBossConst"%>
<%@page import="com.ai.appframe2.web.HttpUtil"%>
<%@page import="com.ai.omframe.teaminvoke.ISysmgrConstant"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="SOS0100001" res="CRM" /></title>
</head>
<body onload="initData();">
<ai:contractframe i18nRes="CRM" id="" contenttype="table" title="SOS0100002" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem/>
	 <ai:dbform setname="com.asiainfo.charge.web.SETChargeConcessInfo" formid="dataConcessionalPkgForm" initial="false"
	  	 conditionname="condition" parametersname="parameters"
            onvalchange="" editable="true"  
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.charge.service.interfaces.IChargeMainSV"
            implservice_querymethod="findChargeConcessByConcessId(String concessId)"
	 >
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="1">
		<ai:dbformfield fieldname="MID" formid="dataConcessionalPkgForm" visible="false" width="150"/>
			<tr><!-- 月功能费 -->
			    <td class="td_font"><i18n:message key="SOS0100003" res="CRM" /><i18n:message key="SOS0000000" res="CRM" /></td> 
			    <td><ai:dbformfield fieldname="FEE" formid="dataConcessionalPkgForm" visible="true" width="150"/> <i18n:message key="SOS0100023" res="CRM" /></td>
			</tr>
				<tr><!--折扣比例 -->
			    <td class="td_font"><i18n:message key="SOS0100004" res="CRM" /><i18n:message key="SOS0000000" res="CRM" /></td> 
			    <td><ai:dbformfield fieldname="DIS_RATE" formid="dataConcessionalPkgForm" visible="true" width="150"/> <i18n:message key="SOS0100024" res="CRM" /></td>
			</tr>
			<tr><!-- 备注-->
			    <td class="td_font"><i18n:message key="SOS0100005" res="CRM" /><i18n:message key="SOS0000000" res="CRM" /></td> 
			    <td><ai:dbformfield fieldname="REMARK" formid="dataConcessionalPkgForm"    height="60" visible="true" width="70%"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>

<ai:contractframe   i18nRes="CRM" id="" contenttype="table" title="SOS0100006" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem>
				<ai:button id="addDataConcess" text="SOS0100007" i18nRes="CRM"	onclick="addDataConcessDetail()" /><!-- 新增 -->
				<ai:button id="delDataConcess" text="SOS0100008"  i18nRes="CRM"  onclick="doWork('delDataConcessDetail()')" /><!-- 删除 -->
				<!-- ai:button id="saveDataConcess" text="SOS0100009"	i18nRes="CRM"onclick="doWork('saveDataConcessDetail()')"   / --><!-- 保存 -->
				<!--ai:button id="saveDataConcess" text="alert"	onclick="doWork('getDataConcessDetailInfoContent()')"   /-->
	 </ai:contractitem>
	 <ai:table
	 	tableid="tblNormal_dataConcessPkg"
		setname="com.asiainfo.charge.web.SETChargeConcessDetailInfo"
		needrefresh="true" initial="false"
		height="220" width="100%" editable="true" multiselect="true"
		footdisplay="block" pagesize="10"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.charge.service.interfaces.IChargeMainSV"
		implservice_querymethod="queryChargeConcessDetailInfoByConssId(String concessId,int $STARTROWINDEX,int $ENDROWINDEX)"
		implservice_countmethod="queryChargeConcessDetailInfoCountByConssId(String concessId)" 
		>
		<!--ai:listbox id='queryType' onchange="" ds="com.asiainfo.crm.so.common.web.DSStaticData" parameters="CODE_TYPE=FEETYPE" /-->
		<ai:col fieldname="IS_CHARGE_DATA"  editable="false" visible="false" />
		<ai:col fieldname="ID"  editable="false" visible="false"/>
		<ai:col fieldname="DETAIL_TYPE" width="120"   /><!-- 业务类型 -->
		<ai:col fieldname="CNT" width="120"  /> <!-- 数量 -->
		<ai:col fieldname="UNIT" width="120" /><!-- 单位 -->
		<ai:col fieldname="REMARK" width="240"	 /><!-- 备注 -->
	</ai:table>
</ai:contractframe>
</body>
</html>
<script language="javascript">
function addLoadEvent(func) {  
    var oldonload = window.onload;  
    if(typeof window.onload != "function"){  
        window.onload = func;  
    }else{  
        window.onload = function(){  
            oldonload();  
            func();  
        }  
    }  
}
addLoadEvent(initData);
//初始化页面函数
function initData(){
	initChargeType();//初始下拉列表
}
	
	//获取条件form数据集
	function getConcessForm(){
		return g_FormRowSetManager.get("dataConcessionalPkgForm");
	}
	//获取条件Table数据集
	function getConcessDetailTable(){
		return  g_TableRowSetManager.get("tblNormal_dataConcessPkg");
	}
	
	//新增数据优惠包 -- 包含业务内容
	function addDataConcessDetail(){
		getConcessDetailTable().newRow();
		initChargeType();//初始下拉列表
	}
	
	function initChargeType(){
		 var count = getConcessDetailTable().getTotalRowCount();
		 for(var i = 0 ;i<count;i++){
			  getConcessDetailTable().setValue(i,"IS_CHARGE_DATA","YHB_BUSI_TYPE_DATA","") ;
		 }
	}
	//删除数据优惠包 -- 包含业务内容
	function delDataConcessDetail(){
			var selectRows  = getConcessDetailTable().getSelectedRows();
			if(selectRows.length<1){
				alert(crm_i18n_msg("SOC0100010"));//"请选择要删除的数据！;
				return;
			}else{
				if(confirm(crm_i18n_msg("SOC0100001",selectRows.length))){//确定要删除这{0}条数据吗？
						for(var i = selectRows.length - 1 ; i>=0 ; i--){
							getConcessDetailTable().deleteRow(selectRows[i]);
						}
						//saveDataConcessDetail();
				}
			}
	}
	var concessId = "";
	function initDataConcessDetailInfo(mid){
		var url = _gModuleName + "/business/com.asiainfo.charge.web.ChargeDataConcessAction?action=findChargeConcessByMid&mid="+mid;
				var vud = PostInfo(url);
				if(vud.getValueByName("FLAG") == "Y"){
					cid = vud.getValueByName("values");
					//alert("cid:"+cid);
					getConcessDetailTable().refresh("concessId="+cid);
					getConcessForm().refresh("concessId="+cid);
					concessId  =cid;
					return true;
				}else{
					return false;
				}
	}
	function queryDataConcessPkg(concessId){
		//var id = getConcessDetailTable().getValue("ID");
		//var concessId = "1";
		//alert("concessId:"+concessId);
		var condition = "concessId=" + concessId;
		getConcessDetailTable().refresh(condition);
	}
	
	function getDataConcessDetailInfoContent(){
		var count = getConcessDetailTable().getTotalRowCount();
		var stringBuffer ="";
		for(var i = 0;i<count;i++){
			var c1 = getConcessDetailTable().getDisplayText(i,"DETAIL_TYPE");//获取指定单元的数据值
			var c2 = getConcessDetailTable().getValue(i,"CNT");//获取指定单元的数据值
			var c3 = getConcessDetailTable().getValue(i,"UNIT");//获取指定单元的数据值
			stringBuffer = stringBuffer + c1+":"+c2+" "+c3 +",";
		}
		if(""==stringBuffer) return "";
		stringBuffer = stringBuffer.substring(0,stringBuffer.lastIndexOf(","));
		//alert(stringBuffer);
		return stringBuffer;
	}
	//给主页面调用，保存主表方法
	
	function saveDataConcess(chargeid,applyID){
		/*alert("chargeid:"+chargeid);
		alert("applyID:"+applyID);
		alert("getSts:"+ getConcessForm().getSts());*/
		
		//判断数据包资费明细必须填写业务类型;
		var count = getConcessDetailTable().getTotalRowCount();
			for(var i = 0;i<count;i++){
			var c1 = getConcessDetailTable().getDisplayText(i,"DETAIL_TYPE");//获取指定单元的数据值
			var c2 = getConcessDetailTable().getValue(i,"CNT");//获取指定单元的数据值
			var c3 = getConcessDetailTable().getValue(i,"UNIT");//获取指定单元的数据值
			if(""==c1){
				alert(crm_i18n_msg("SOC0100011"));
				//alert("业务类型不允许为空,请填写完整!");
				return false;
			}else if(""==c2){
				alert("数量不能为空");
				return false;
			}else  if(""==c3){
				alert("单位不能为空");
				return false;
			}
		}
		 if ("O" != getConcessForm().getSts())  {
			 getConcessForm().setValue("MID", chargeid,chargeid);
			var xmlbody = getConcessForm().toXmlString();
			var xml = "<RootInfo>"+xmlbody+"</RootInfo>";
			var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeDataConcessAction?action=saveChargeDataConcess&chargeid='+chargeid+'&applyID='+applyID;
			//alert(xml);
			var ud  = PostInfo(strUrl,xml);
			 concessId = ud.getValueByName("concessId");
			if(ud.getValueByName("alert")=="Y"){
				//alert(ud.getValueByName("MESSAGE"));
				return;
			}
			if(ud.getValueByName("FLAG")=="Y"){
				//getQueryTable().clear();
				//alert(ud.getValueByName("MESSAGE"));
			}else{
				alert(ud.getValueByName("MESSAGE"));
			}
			//alert(ud.getValueByName("MESSAGE"));
  		  }	
		//alert("concessId:"+concessId);
		if(concessId==0||""==concessId){
			alert(crm_i18n_msg("SOC0100002"));
			return false;
		}
		//刷新主表
		getConcessForm().refresh("concessId="+concessId);
		//保存明细表
		saveDataConcessDetail(concessId);
		return true;
	}
	function saveDataConcessDetail(concessId){
		//alert("concessId:"+concessId);
		/*if(getConcessDetailTable().count()==0){
			alert("未保存数据");
			return ;
		}*/
		var xmlbody = getConcessDetailTable().toXmlString();
		var xml = "<RootInfo>"+xmlbody+"</RootInfo>";
		var strUrl = _gModuleName + '/business/com.asiainfo.charge.web.ChargeDataConcessAction?action=saveChargeDataConcessDetail&concessId='+concessId;
		//alert(xml);
		var ud  = PostInfo(strUrl,xml);
		if(ud.getValueByName("alert")=="Y"){
			//alert(ud.getValueByName("MESSAGE"));
			return;
		}
		if(ud.getValueByName("FLAG")=="Y"){
			//alert(ud.getValueByName("MESSAGE"));
		}else{
			alert(ud.getValueByName("MESSAGE"));
		}
		//alert(ud.getValueByName("MESSAGE"));
		queryDataConcessPkg(concessId);
		initChargeType();//初始下拉列表
	}
	
	
function doWork(fun){ 
    beginAIWaitBanner(fun,alert(crm_i18n_msg("SOC0100003")));
}
	
</script>
