<%@ page contentType="text/html; charset=GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title><i18n:message key="sec.moselect.select" res="i18n.secframe_resource"/></title>
</head>
<body>
<ai:contractframe id="" contenttype="table"
						title="sec.moselect.select" i18nRes="i18n.secframe_resource"
						width="100%" allowcontract="false" frameclosed="false">
						<ai:contractitem />
						<table width="99%" align="center" border="0" cellpadding="0"
							cellspacing="0">
							<tr>
								<td>
        <ai:dbtree_new id="sysdirtree"
							datamodel="com.ai.secframe.sysmgr.web.DBTreeModelSecMo"
							width="100%" height="360" multiselect="false" ishaveline="true"/>
								</td>
							</tr>
						</table>
					</ai:contractframe>
					
     <div class="area_button">
	 <ai:button text="sec.confirm" i18nRes="i18n.secframe_resource" id="affirm" onclick="okFunc()"/>&nbsp;&nbsp;
      <ai:button text="sec.cancel" i18nRes="i18n.secframe_resource" id="cancel" onclick="cancelFunc()"/>
    </div>
<ai:loginuser />
</body>
</html><SCRIPT LANGUAGE="JavaScript">
var dbtree= g_DBTreeNewManager.get("sysdirtree");
var oldArr = window.dialogArguments;
var moName = null;//被管对象的全名
function okFunc()
{
	var curNode = dbtree.getCurNodeInfo();
	var parentNode = dbtree.getParentNodeInfo(curNode.value);
	if(curNode==null||curNode.userobj!="O"){
		alert(g_I18NMessage("sec_moselect", "sec_moselect_select"));
	}else{
		if(chkOld(parentNode.value+","+curNode.text)){
			alert(g_I18NMessage("sec_moselect", "sec_moselect_alreadyexist"));
			return false;
		}
		window.returnValue = new MoObject(parentNode.value,curNode.text);
		top.close();
	}
}
function MoObject(moId,operName){
	this.moId = moId;
	this.operName = operName;
}
function chkOld(pValue){
	if(oldArr==null) return false;
	for(var i=0;i<oldArr.length;i++){
		if(oldArr[i]==pValue){
			return true;
		}
	}
	return false;
}
function cancelFunc()
{
  top.close();
}

</script>
