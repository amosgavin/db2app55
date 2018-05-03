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
			<tr><!-- �¹��ܷ� -->
			    <td class="td_font"><i18n:message key="SOS0100003" res="CRM" /><i18n:message key="SOS0000000" res="CRM" /></td> 
			    <td><ai:dbformfield fieldname="FEE" formid="dataConcessionalPkgForm" visible="true" width="150"/> <i18n:message key="SOS0100023" res="CRM" /></td>
			</tr>
				<tr><!--�ۿ۱��� -->
			    <td class="td_font"><i18n:message key="SOS0100004" res="CRM" /><i18n:message key="SOS0000000" res="CRM" /></td> 
			    <td><ai:dbformfield fieldname="DIS_RATE" formid="dataConcessionalPkgForm" visible="true" width="150"/> <i18n:message key="SOS0100024" res="CRM" /></td>
			</tr>
			<tr><!-- ��ע-->
			    <td class="td_font"><i18n:message key="SOS0100005" res="CRM" /><i18n:message key="SOS0000000" res="CRM" /></td> 
			    <td><ai:dbformfield fieldname="REMARK" formid="dataConcessionalPkgForm"    height="60" visible="true" width="70%"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>

<ai:contractframe   i18nRes="CRM" id="" contenttype="table" title="SOS0100006" width="100%" allowcontract="false" frameclosed="false">
	<ai:contractitem>
				<ai:button id="addDataConcess" text="SOS0100007" i18nRes="CRM"	onclick="addDataConcessDetail()" /><!-- ���� -->
				<ai:button id="delDataConcess" text="SOS0100008"  i18nRes="CRM"  onclick="doWork('delDataConcessDetail()')" /><!-- ɾ�� -->
				<!-- ai:button id="saveDataConcess" text="SOS0100009"	i18nRes="CRM"onclick="doWork('saveDataConcessDetail()')"   / --><!-- ���� -->
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
		<ai:col fieldname="DETAIL_TYPE" width="120"   /><!-- ҵ������ -->
		<ai:col fieldname="CNT" width="120"  /> <!-- ���� -->
		<ai:col fieldname="UNIT" width="120" /><!-- ��λ -->
		<ai:col fieldname="REMARK" width="240"	 /><!-- ��ע -->
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
//��ʼ��ҳ�溯��
function initData(){
	initChargeType();//��ʼ�����б�
}
	
	//��ȡ����form���ݼ�
	function getConcessForm(){
		return g_FormRowSetManager.get("dataConcessionalPkgForm");
	}
	//��ȡ����Table���ݼ�
	function getConcessDetailTable(){
		return  g_TableRowSetManager.get("tblNormal_dataConcessPkg");
	}
	
	//���������Żݰ� -- ����ҵ������
	function addDataConcessDetail(){
		getConcessDetailTable().newRow();
		initChargeType();//��ʼ�����б�
	}
	
	function initChargeType(){
		 var count = getConcessDetailTable().getTotalRowCount();
		 for(var i = 0 ;i<count;i++){
			  getConcessDetailTable().setValue(i,"IS_CHARGE_DATA","YHB_BUSI_TYPE_DATA","") ;
		 }
	}
	//ɾ�������Żݰ� -- ����ҵ������
	function delDataConcessDetail(){
			var selectRows  = getConcessDetailTable().getSelectedRows();
			if(selectRows.length<1){
				alert(crm_i18n_msg("SOC0100010"));//"��ѡ��Ҫɾ�������ݣ�;
				return;
			}else{
				if(confirm(crm_i18n_msg("SOC0100001",selectRows.length))){//ȷ��Ҫɾ����{0}��������
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
			var c1 = getConcessDetailTable().getDisplayText(i,"DETAIL_TYPE");//��ȡָ����Ԫ������ֵ
			var c2 = getConcessDetailTable().getValue(i,"CNT");//��ȡָ����Ԫ������ֵ
			var c3 = getConcessDetailTable().getValue(i,"UNIT");//��ȡָ����Ԫ������ֵ
			stringBuffer = stringBuffer + c1+":"+c2+" "+c3 +",";
		}
		if(""==stringBuffer) return "";
		stringBuffer = stringBuffer.substring(0,stringBuffer.lastIndexOf(","));
		//alert(stringBuffer);
		return stringBuffer;
	}
	//����ҳ����ã�����������
	
	function saveDataConcess(chargeid,applyID){
		/*alert("chargeid:"+chargeid);
		alert("applyID:"+applyID);
		alert("getSts:"+ getConcessForm().getSts());*/
		
		//�ж����ݰ��ʷ���ϸ������дҵ������;
		var count = getConcessDetailTable().getTotalRowCount();
			for(var i = 0;i<count;i++){
			var c1 = getConcessDetailTable().getDisplayText(i,"DETAIL_TYPE");//��ȡָ����Ԫ������ֵ
			var c2 = getConcessDetailTable().getValue(i,"CNT");//��ȡָ����Ԫ������ֵ
			var c3 = getConcessDetailTable().getValue(i,"UNIT");//��ȡָ����Ԫ������ֵ
			if(""==c1){
				alert(crm_i18n_msg("SOC0100011"));
				//alert("ҵ�����Ͳ�����Ϊ��,����д����!");
				return false;
			}else if(""==c2){
				alert("��������Ϊ��");
				return false;
			}else  if(""==c3){
				alert("��λ����Ϊ��");
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
		//ˢ������
		getConcessForm().refresh("concessId="+concessId);
		//������ϸ��
		saveDataConcessDetail(concessId);
		return true;
	}
	function saveDataConcessDetail(concessId){
		//alert("concessId:"+concessId);
		/*if(getConcessDetailTable().count()==0){
			alert("δ��������");
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
		initChargeType();//��ʼ�����б�
	}
	
	
function doWork(fun){ 
    beginAIWaitBanner(fun,alert(crm_i18n_msg("SOC0100003")));
}
	
</script>
