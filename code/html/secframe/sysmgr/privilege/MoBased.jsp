<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
	<head>
		<title><i18n:message key="sec.mobased.managet" res="i18n.secframe_resource"/></title>
	</head>
	<body onLoad="init()">
	
	
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1">
                    <tr>
                      <td class="tdhead"><table width="100%" border="0" cellpadding="0" cellspacing="0"  >
                          <tr>
                            <td width="40" style="height: 20px">&nbsp;&nbsp;<img src="../../images/circle.gif" width="12" height="12" /></td>
                            <td style="height: 20px"><i18n:message key="sec.mobased.select" res="i18n.secframe_resource"/></td>
                            <td align="right" style="height: 20px"></td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr>
                      <td   align="left" style="padding-left:5px;" height="160" valign="top">
					  <ai:dbtree_new id="sysdirtree" datamodel="com.ai.secframe.sysmgr.web.DBTreeModelSecMo"
					width="350" height="180" multiselect="false" ishaveline="true" onselect="refdata"/>
                      </td>
                    </tr>
                  </table></td>
      </tr>
      <tr>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1">
                    <tr>
                      <td class="tdhead"><table width="100%" border="0" cellpadding="0" cellspacing="0"  >
                          <tr>
                            <td width="40" style="height: 20px">&nbsp;&nbsp;<img src="../../images/circle.gif" width="12" height="12" /></td>
                            <td style="height: 20px"><i18n:message key="sec.mobased.attribute" res="i18n.secframe_resource"/></td>
                            <td align="right" style="height: 20px"></td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr>
                      <td   align="left" height="160" valign="top">
					  <ai:tab id="tab" getParameter="getParameter" width="380"
										height="250">
										<ai:tabitem id="staff" width="60" src="Staff.jsp" title="sec.OrgBased.operator" i18nRes="i18n.secframe_resource" />
										<ai:tabitem id="station" width="60" src="Station.jsp" title="sec.OrgBased.station" i18nRes="i18n.secframe_resource" />
										<ai:tabitem id="role" width="120" src="Role.jsp"
											title="sec.OrgBased.role" i18nRes="i18n.secframe_resource" />
									</ai:tab>
					
					</td>
                    </tr>
                  </table></td>
      </tr>
    </table>
	
	
	</body>
<script language="javascript">
var dbtree= g_DBTreeNewManager.get("sysdirtree");
var curTab = null;
var moId = null;
var operName = null;
var permId = null;
var flag = 1;
function getPermId(){
	return permId;
}
function getOperName(){
	return operName;
}
function getMoId(){
	return moId;
}
function init(){
	window.parent.curTab = "mobased";
}
function refdata(){
	var curNode = dbtree.getCurNodeInfo();
	var parentNode = dbtree.getParentNodeInfo(curNode.value);
	if(curNode.userobj=="O"){
		moId = parentNode.value;
		
		operName = curNode.text;
		//alert(moId+"|"+operName);
		permId = null;
		if(curTab == null){
			curTab = "staff";
			setTabItem("tab","staff");
		}else{
			var tab = eval("tab_"+curTab);
			if(tab.flag==undefined)
				return;
			else
				tab.init();
		}
		window.parent.refrRight(moId);
	}
}
function getParameter(itemId){
	curTab = itemId;
	window.parent.clearMOPre();
	window.parent.globalVar(itemId.toUpperCase());
	var tab = eval("tab_"+itemId);
	if(tab.flag!=null){
		tab.initPermId();
		window.parent.qryPerm(permId);
	}
}
function getCurTab(){
	return curTab;
}
</script>
</html>
