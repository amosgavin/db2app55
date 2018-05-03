<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/frame/BceFrameHead.jsp"%>

<html>  
<head>
<title></title>
</head>
<body onload="init();">
  <table width="98%" align="center" border="0" cellpadding="0" cellspacing="0"><tr><td>
<ai:table tableid="mainTable" setname="com.asiainfo.crm.bcedemo.group.web.GroupContractInfo" 
tablemodel="" 
height="150" width="700"  
onvalchange="" multiselect="false" editable="true" 
needrefresh="true" initial="false">
<ai:col fieldname="CONTRACT_ID" visible="false"/>
<ai:col fieldname="CONTRACT_NO" visible="false"/>
<ai:col fieldname="CONTRACT_NAME" visible="true"/>
<ai:col fieldname="GROUP_ID" visible="true"/>
<ai:col fieldname="MANAGER_ID" visible="true"/>

</ai:table>    
  </td></tr></table>
<div class="area_button">
  <ai:button text="新增" id="btnAdd" onclick="add()" />
  <ai:button text="test" id="btnTest"  />
  <ai:button text="事件测试" id="alertMessage" />
  <ai:button text="启动测试流程proess实例" id = "start" onclick="startProess()"/>
</div>  
</body>
</html>

<script language="javascript">
function startProess(){
	alert("D");
	var tempValue = PostInfo(_gModuleName + "/business/com.asiainfo.crm.so.web.test.TestDemoAction?action=testDemoMethod&OFFER_ID=1&OPER_TYPE=CHANGE_OFFER", "");
	
}
function init(){
    if(parent.setFrameHeight) {
    	sId = "ID_<%=HttpUtil.getAsString(request, "PAGE_FRAME_PAGE_ID")%>";
        parent.setFrameHeight(sId,document.body.scrollHeight+15);
    }
}

function getTbl(){
  return g_TableRowSetManager.get("mainTable");
}

function add(){
  getTbl().newRow(false);
}
</script>