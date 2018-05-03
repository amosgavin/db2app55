<%@ page contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<%@ page import="com.ai.secframe.common.Constants"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<title><i18n:message key="sec.organize.orgchioc" res="i18n.secframe_resource"/></title>
	</head>
	<body>
	<%
	     String rootId = Constants.STR_ROOT_ID;
	%>
              <ai:contractframe id="" contenttype="table" title="sec.organize.districtchoic" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
              <ai:contractitem/>
              <table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
        			<tr>
         			  <td>
              <ai:dbtree_new id="disTree"
						datamodel="com.ai.secframe.orgmodel.web.SecDistrictTreeModel"
						multiselect="false" height="350" width="100%" ishaveline="true" ondblclick="chkCur"/>
						</td>
                  </tr>
              </table>	
              </ai:contractframe> 
            
               <div class="area_button">
				<ai:button text="sec.organize.selected" i18nRes="i18n.secframe_resource" id="affirm" onclick="affirm()"/>
				&nbsp;
				<ai:button  text="sec.organize.cancel" i18nRes="i18n.secframe_resource" id="cancel" onclick="cancel()"/>
               </div>
	</body>
</html>
<script type="text/javascript">
<!--
var rootId = "<%=rootId%>";
var curNode = null;
var disTree = g_DBTreeNewManager.get("disTree");
function affirm(){
	curNode = disTree.getCurNodeInfo();
	if(curNode == null){
		//alert("请选择区域！");
		alert(g_I18NMessage("secframe_districtselectdialog", "secframe_districtselectdialog_seldistrict"));
		return false;
	}
	var parentNode = disTree.getParentNodeInfo(curNode.value);
	if(parentNode.value==rootId){
		window.returnValue = curNode.value+"|"+curNode.text+"&"+curNode.value+"|"+curNode.text;
	} else {
		window.returnValue = parentNode.value+"|"+parentNode.text+"&"+curNode.value+"|"+curNode.text;
	}
	
	window.self.close();
}
function cancel(){	
	window.self.close();
}
function chkCur(){
	affirm();
}
//-->
</script>
