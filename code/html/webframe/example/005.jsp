<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%> 
<html>
<head>
<title>ģ��005</title>
<!--��ͨ��ѯ�����½ṹ����TAB���ϣ�ģ��ҳ��˵�� -->
<!--
1����ģ����������ͨ��ѯ������ѯ��Խ�����в�����jspҳ�棻
2����ģ����ѭ�������Ϊ�ٷֱȣ��߶���������Ȼ�ſ�ԭ������Ӧ���ֱַ��������
3����ѯ��ai:contractframe���ã���ѯ���Ķ��ֽ����ai:tab���ã�
4��ai:contractframeʹ��ע�⣺���������100%���߶�������������Ȼ�ſ���allowcontract���ԣ��Ƿ��������� Ĭ��true��ֵ��true/false����frameclosed���ԣ���ʼ��ʱ���������Ƿ��ڹر�״̬��Ĭ��false��ֵ��true/false��
5��ai:tabʹ��ע�⣺���������100%���߶�������400�����ж����������٣�initial���ԣ���ʼ��ʱ�Ƿ�۽� ֵ��true/false����isDeletable���ԣ��Ƿ񺬹رհ�ť ֵ��true/false��
6����ťλ����ע�⣺��ѯ��ťʹ��css��class="td_button"����������ťʹ��css��class="area_button"��;���Ŷ����ť����ʱ���м����2��&nbsp;&nbsp;��
7������table���Ű��TABҳ�����������ã� class="area_tab"����
8��Tabҳ��ǩ���ӿɲο�011.jsp������ע�⣺��������Tabҳ��ǩ��������Tab������Ϊ100%������Ϊ98%�籾ģ�壻
 -->
</head>

<body>
<ai:contractframe id="��ѯ����" contenttype="table" title="��ѯ����" width="100%" allowcontract="ture" frameclosed="false">
  <ai:contractitem/>
 <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
         <tr>
           <td class="td_font">�ͻ����ƣ�</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/></td>
           <td class="td_font">��ϵ�绰��</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/></td>
           <td class="td_font">�ͻ����ԣ�</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
		</tr>
		<tr>
           <td class="td_font">��ϵ��ַ��</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/></td>
           <td class="td_font">�������룺</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/></td>
           <td class="td_font">��ע��</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
           <td class="td_button"><ai:button text="��ѯ" id="" onclick="" /></td>
		</tr>
      </table>
</ai:contractframe>

<div class="area_tab">
<ai:tab id="ddd1" width="100%" height="380" type="h">
	<ai:tabitem id="dd1" title="����ͳ�ƽ��" src="tab1.jsp" initial="true" />
	<ai:tabitem id="dd2" title="�ͻ��շ�����" src="tab2.jsp" isDeletable="true"/>
	<ai:tabitem id="dd3" title="�ͻ�Ⱥ" src="tab1.jsp" isDeletable="true"/>
	<ai:tabitem id="dd4" title="���ò�ѯ���" src="tab2.jsp" />
</ai:tab>
</div>

<div class="area_button">
  <ai:button text="������ť" id="query1" onclick="" />&nbsp;&nbsp;
  <ai:button text="�����ð�ť" id="query3" onclick="" enable="false" />
</div>
  
</body>
</html>
<script language="javascript">

</script>