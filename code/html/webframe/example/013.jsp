<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>ģ��013</title>
<!--TABҳ�������ӱ�ǩ��ģ��ҳ��˵�� -->
<!--
1����ģ��������TABҳ�����½ṹ����jspҳ�棻
2����ģ����ѭ�������Ϊ�ٷֱȣ��߶���������Ȼ�ſ�ԭ������Ӧ���ֱַ��������
3����ѯ����ѯ����ֱ���ai:contractframe���÷ָ
4��ai:contractframeʹ��ע�⣺���������100%���߶�������������Ȼ�ſ���allowcontract���ԣ��Ƿ��������� Ĭ��true��ֵ��true/false����frameclosed���ԣ���ʼ��ʱ���������Ƿ��ڹر�״̬��Ĭ��false��ֵ��true/false��
5����ѯ���ai:tableʹ��ע�⣺���������100%���߶�������220������������10����pagesize="10"�������ж����������٣�
6����ťλ����ע�⣺��ѯ��ťʹ��css��class="td_button"����������ťʹ��css��class="area_button"��;���Ŷ����ť����ʱ���м����2��&nbsp;&nbsp;��
7��ai:tabʹ��ע�⣺���������100%���߶�������400�����ж����������٣�initial���ԣ���ʼ��ʱ�Ƿ�۽� ֵ��true/false����isDeletable���ԣ��Ƿ񺬹رհ�ť ֵ��true/false��
8������table���Ű��TABҳ�����������ã� class="area_tab"������TAB�߶�Ϊ�ٷֱ�������κ���ʽ��
9��Tabҳ��ǩ���ӿɲο���ģ�壬����ע�⣺��������Tabҳ��ǩ��������Tab������Ϊ100%������Ϊ98%��
 -->
</head>

<body>
<div class="area_tab">
<ai:tab id="ddd1" width="100%" height="240" type="h">
	<ai:tabitem id="dd1" title="����ͳ�ƽ��" src="tab1.jsp" initial="true" />
	<ai:tabitem id="dd2" title="�ͻ��շ�����" src="tab2.jsp" isDeletable="true"/>
	<ai:tabitem id="dd3" title="�ͻ�Ⱥ" src="tab1.jsp" isDeletable="true"/>
	<ai:tabitem id="dd4" title="���ò�ѯ���" src="tab2.jsp" />
</ai:tab>
</div>

<div class="area_tab">
<ai:tab id="ddd2" width="100%" height="200" type="b">
	<ai:tabitem id="dd1" title="����ͳ�ƽ��" src="tab1.jsp" initial="true" />
	<ai:tabitem id="dd2" title="�ͻ��շ�����" src="tab2.jsp" isDeletable="true"/>
	<ai:tabitem id="dd3" title="�ͻ�Ⱥ" src="tab1.jsp" isDeletable="true"/>
	<ai:tabitem id="dd4" title="���ò�ѯ���" src="tab2.jsp" />
</ai:tab>
</div>

<div class="area_button">
  <ai:button text="��������Tabҳ��ǩ" id="query1" onclick="test()" />&nbsp;&nbsp;
  <ai:button text="��������Tabҳ��ǩ" id="query2" onclick="test1()" />&nbsp;&nbsp;
  <ai:button text="�����ð�ť" id="query3" onclick="" enable="false" />
</div>

</body>
</html>
<script language="javascript">
function test(){
openNewTabItem("ddd1","���ò�ѯ������ò�ѯ��","���ò�ѯ������ò�ѯ��","tab2.jsp","true");
}
function test1(){
openNewTabItem("ddd2","���ò�ѯ���","���ò�ѯ���","tab2.jsp","true");
}
</script>