<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/frame/BceFrameHead.jsp"%>
<html>  
<head>
<title></title>
</head>
<% 
String busiId = HttpUtil.getAsString(request,com.ai.bce.util.BceUtil.BUSIOPER_ID_KEY);
%>
<body>
  <table align="center" width="100%">
	  <tr><td valign="top">
		  <ai:tab id="tab" width="100%" height="400">
				<ai:tabitem id="tab_1" src='<%=request.getContextPath()+"/bce/frame/SinglePageEntry.jsp?TYPE=A&BUSIOPER_ID="+busiId%>' title="Ò³Ãæ1" width="100%" initial="true"/>
				<ai:tabitem id="tab_2" src='<%=request.getContextPath()+"/bce/frame/SinglePageEntry.jsp?TYPE=B&BUSIOPER_ID="+busiId%>' title="Ò³Ãæ2" width="100%"/>
				<ai:tabitem id="tab_3" src='<%=request.getContextPath()+"/bce/frame/SinglePageEntry.jsp?TYPE=C&BUSIOPER_ID="+busiId%>' title="Ò³Ãæ3" width="100%"/>
			</ai:tab>
	  </td></tr>
  </table>
</body>
</html>

<script language="javascript">

</script>