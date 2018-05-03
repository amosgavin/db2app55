<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<%@ page import="com.ai.appframe2.web.datamodel.CommonTreeModel"%>
<html>
<head>
<title>tab4</title>
<!--含树结构Tab模板页面说明 -->
<!--
1、本模板适用于含树结构Tab标签页内的jsp页面；
2、本模板遵循宽度设置为百分比，高度由内容自然撑开原则以适应各种分辨率浏览；
3、按钮位置请注意：按钮使用css（class="area_button"）;并排多个按钮存在时，中间请加2个&nbsp;&nbsp;；
4、树的宽度和高度请设置100%；
5、树的操作方式请注意：若按钮可以一排排完且不显拥挤的情况下，请尽量使用下排按钮排版格式，如本模板所示；在按钮很多，按钮文字过长，请使用右键模式，请参考模板010.jsp；
 -->
</head>
<%
String rootUrl = "";
request.setAttribute(CommonTreeModel.ROOT_ID,"0");
request.setAttribute(CommonTreeModel.ROOT_NAME,"系统监控");
request.setAttribute(CommonTreeModel.ROOT_URL,rootUrl);
request.setAttribute(CommonTreeModel.TREE_TYPE_ID,"30");
%>
<body>
<table width="98%" height="100%" align="center" border="0" cellpadding="0" cellspacing="0">
		<tr>
           <td valign="top"><ai:dbtree_new id="menuTreeDiv" datamodel="com.ai.appframe2.web.datamodel.CommonTreeModel" width="100%" height="100%" ishaveline="true" isdrag="true" onselect="" onrightclick=""/></td>
		</tr>
		<tr>			
           <td class="area_button">
			<ai:button text="新增" id="" onclick="" />&nbsp;&nbsp;
			<ai:button text="修改" id="" onclick="" />&nbsp;&nbsp;
			<ai:button text="删除" id="" onclick="" />
		   </td>
		</tr>
</table>
</body>
</html>
<script language="javascript">

</script>