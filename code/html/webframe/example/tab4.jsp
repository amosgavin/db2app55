<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<%@ page import="com.ai.appframe2.web.datamodel.CommonTreeModel"%>
<html>
<head>
<title>tab4</title>
<!--�����ṹTabģ��ҳ��˵�� -->
<!--
1����ģ�������ں����ṹTab��ǩҳ�ڵ�jspҳ�棻
2����ģ����ѭ�������Ϊ�ٷֱȣ��߶���������Ȼ�ſ�ԭ������Ӧ���ֱַ��������
3����ťλ����ע�⣺��ťʹ��css��class="area_button"��;���Ŷ����ť����ʱ���м����2��&nbsp;&nbsp;��
4�����Ŀ�Ⱥ͸߶�������100%��
5�����Ĳ�����ʽ��ע�⣺����ť����һ�������Ҳ���ӵ��������£��뾡��ʹ�����Ű�ť�Ű��ʽ���籾ģ����ʾ���ڰ�ť�ܶ࣬��ť���ֹ�������ʹ���Ҽ�ģʽ����ο�ģ��010.jsp��
 -->
</head>
<%
String rootUrl = "";
request.setAttribute(CommonTreeModel.ROOT_ID,"0");
request.setAttribute(CommonTreeModel.ROOT_NAME,"ϵͳ���");
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
			<ai:button text="����" id="" onclick="" />&nbsp;&nbsp;
			<ai:button text="�޸�" id="" onclick="" />&nbsp;&nbsp;
			<ai:button text="ɾ��" id="" onclick="" />
		   </td>
		</tr>
</table>
</body>
</html>
<script language="javascript">

</script>