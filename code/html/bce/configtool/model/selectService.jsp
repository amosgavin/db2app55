<% response.setHeader("Cache-Control", "no-cache"); %>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai" %>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<html>
<head>
<title>test</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script src="<%=request.getContextPath()%>/jsv2/Globe_v2.jsp"></script>
</head>
<body>
<table width="100%"  border="0" cellspacing="0" cellpadding="1">
  <tr>
    <td width="400px">
    	<table width="100%" border="1" cellpadding="0" cellspacing="1">
        <tr>
          <td align="left">
          	<ai:dbtree_new id="secfunction_tree" height="515" width="100%" 
			   datamodel="com.ai.bce.configtool.model.service.ServiceTreeModel" 
			   initial="true" ishaveline="true"
			   onselect="SecfuncInfoLoad" />
          </td>
        </tr>
      </table>
   </td>
  </tr>
</table>
</body>
<script language="javascript">
var dbtree = g_DBTreeNewManager.get("secfunction_tree");

function refreshTree(){
   var dbtree = g_DBTreeNewManager.get("secfunction_tree");
   var ud = dbtree.refresh(null,1);
}

function SecfuncInfoLoad(){

}
</script>
</html>