<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%> 
<html>
<head>
<title>ģ��007</title>
<!--��ͨ��ѯ�����½ṹ����TAB����-���֣�ģ��ҳ��˵�� -->
<!--
1����ģ����������ͨ��ѯ������ѯ��Խ�����в�����jspҳ�棻
2����ģ����ѭ�������Ϊ�ٷֱȣ��߶���������Ȼ�ſ�ԭ������Ӧ���ֱַ��������
3����ѯ��ai:contractframe���ã���ѯ���Ķ��ֽ����ai:tab���ã�
4��ai:contractframeʹ��ע�⣺���������100%���߶�������������Ȼ�ſ���allowcontract���ԣ��Ƿ��������� Ĭ��true��ֵ��true/false����frameclosed���ԣ���ʼ��ʱ���������Ƿ��ڹر�״̬��Ĭ��false��ֵ��true/false��
5��ai:tabʹ��ע�⣺���������100%���߶�������400�����ж����������٣�initial���ԣ���ʼ��ʱ�Ƿ�۽� ֵ��true/false����isDeletable���ԣ��Ƿ񺬹رհ�ť ֵ��true/false��
6��Tabҳ��ǩλ�������ע�⣺����15��������3���������벻Ҫʹ����Tabҳ��ʽ�� type="v"����Ҳ��Ҫʹ�ú��رհ�ť���ԣ�isDeletable����
7����ťλ����ע�⣺��ѯ��ťʹ��css��class="td_button"����������ťʹ��css��class="area_button"��;���Ŷ����ť����ʱ���м����2��&nbsp;&nbsp;��
8������table���Ű��TABҳ�����������ã� class="area_tab"����
9��Tabҳ��ǩ���ӿɲο�011.jsp������ע�⣺��������Tabҳ��ǩ��������Tab������Ϊ100%������Ϊ98%�籾ģ�壻
 -->
</head>
<body>
<div class="area_tab">
<ai:tab id="ddd1" width="100%" height="500" type="v">
	<ai:tabitem id="dd1" title="�ͻ�Ⱥ�ͻ�Ⱥ�ͻ�Ⱥ" src="tab1.jsp" initial="true" />
	<ai:tabitem id="dd2" title="�ͻ��շ�����" src="tab2.jsp"/>
	<ai:tabitem id="dd3" title="�ͻ�Ⱥ" src="tab1.jsp"/>
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