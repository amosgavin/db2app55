<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>ģ��014</title>
<!--TABҳ�����ҽṹ��ģ��ҳ��˵�� -->
<!--
1����ģ��������TABҳ�����ҽṹ����jspҳ�棻
2����ģ����ѭ�������Ϊ�ٷֱȣ��߶���������Ȼ�ſ�ԭ������Ӧ���ֱַ��������
3����ѯ����ѯ����ֱ���ai:contractframe���÷ָ
4��ai:contractframeʹ��ע�⣺���������100%���߶�������������Ȼ�ſ���allowcontract���ԣ��Ƿ��������� Ĭ��true��ֵ��true/false����frameclosed���ԣ���ʼ��ʱ���������Ƿ��ڹر�״̬��Ĭ��false��ֵ��true/false��
5����ѯ���ai:tableʹ��ע�⣺���������100%���߶�������220������������10����pagesize="10"�������ж����������٣�
6����ťλ����ע�⣺��ѯ��ťʹ��css��class="td_button"����������ťʹ��css��class="area_button"��;���Ŷ����ť����ʱ���м����2��&nbsp;&nbsp;��
7��ai:tabʹ��ע�⣺���������100%���߶�������400�����ж����������٣�initial���ԣ���ʼ��ʱ�Ƿ�۽� ֵ��true/false����isDeletable���ԣ��Ƿ񺬹رհ�ť ֵ��true/false��
8������table���Ű��TABҳ�����������ã� class="area_tab"����
 -->
</head>

<body>
<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
         <tr>
           <td width="220" valign="top">
<div class="area_tab">
<ai:tab id="ddd1" width="220" height="490" type="h">
	<ai:tabitem id="dd1" title="ͳ������" src="tab3.jsp" initial="true" />
	<ai:tabitem id="dd2" title="�շ�����" src="tab3.jsp" isDeletable="true"/>
</ai:tab>
</div>
</td>
<td width="10"></td>
<td valign="top" align="right">
<div class="area_tab">
<ai:tab id="ddd2" width="100%" height="330" type="h">
	<ai:tabitem id="dd1" title="����ͳ�ƽ��" src="tab1.jsp" initial="true" />
	<ai:tabitem id="dd2" title="�ͻ��շ�����" src="tab2.jsp" isDeletable="true"/>
	<ai:tabitem id="dd3" title="�ͻ�Ⱥ" src="tab1.jsp" isDeletable="true"/>
	<ai:tabitem id="dd4" title="���ò�ѯ���" src="tab2.jsp" />
</ai:tab>
</div>

<ai:contractframe id="�ͻ������޸�" contenttype="table" title="�ͻ������޸�" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem/>
<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
         <tr>
           <td class="td_font">�ͻ����ƣ�</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/></td>
           <td class="td_font">��ϵ�绰��</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/></td>
		</tr>
		<tr>
           <td class="td_font">�ͻ����ԣ�</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
           <td class="td_font">��ϵ��ַ��</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/></td>
		</tr>
		<tr>
           <td class="td_font">�������룺</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/></td>
           <td class="td_font">��ע��</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
		</tr>
      </table>
</ai:contractframe>

<div class="area_button">
  <ai:button text="������ť" id="query1" onclick="" />&nbsp;&nbsp;
  <ai:button text="�����ð�ť" id="query3" onclick="" enable="false" />
</div>
		</td>
	</tr>
</table>
</body>
</html>
<script language="javascript">

</script>