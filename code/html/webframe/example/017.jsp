<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/topopenwin.js" type="text/javascript"></script>
<title>ģ��017</title>
<!--��ť/СͼƬ������ʽģ��ҳ��˵�� -->
<!--
1����ģ�������ڸ���Ӧ��ai:button���в������Զ��尴ť��jspҳ�棻
2����ģ����ѭ�������Ϊ�ٷֱȣ��߶���������Ȼ�ſ�ԭ������Ӧ���ֱַ��������
3����ģ���ֱ���ai:contractframe���÷ָ
4��ai:contractframeʹ��ע�⣺���������100%���߶�������������Ȼ�ſ���allowcontract���ԣ��Ƿ��������� Ĭ��true��ֵ��true/false����frameclosed���ԣ���ʼ��ʱ���������Ƿ��ڹر�״̬��Ĭ��false��ֵ��true/false��
5����ťλ����ע�⣺��ѯ��ťʹ��css��class="td_button"����������ťʹ��css��class="area_button"��;���Ŷ����ť����ʱ���м����2��&nbsp;&nbsp;��
6���Զ���buttonע�������ʽ��css����д��\html\theme\��ɫĿ¼\css\other.css�У���ע����ʽ˵���������ͼƬ�����\html\theme\��ɫĿ¼\images\other\�У�
7���Զ���button��ʽԭ����ʽ��Ӧ��������Ϊ��ʼ������꾭������ɫ�����ã���������ֱ�Ϊ*/*Hover/*Disabled��ע���Сд�����磺classname="icon_bk"��css��ʽ�ֱ�Ϊ.icon_bk/.icon_bkHover/.icon_bkDisabled��
8��������ť��ο������еġ��޸ġ��������桱ʾ����
 -->
</head>

<body>
<ai:contractframe id="�Զ���buttonʾ��" contenttype="table" title="�Զ���buttonʾ��" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem/>
<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
         <tr>
           <td height="30">
           <ai:button id="" onclick="" classname="icon_bk" />&nbsp;
           <ai:button id="" onclick="" classname="icon_message" enable="false" />&nbsp;
           <ai:button id="" onclick="" classname="icon_call" enable="false" />&nbsp;
           <ai:button id="" onclick="" classname="icon_bs" />&nbsp;
           <ai:button id="" onclick="" classname="icon_edit" />&nbsp;
           <ai:button id="" onclick="" classname="icon_fk" />&nbsp;
           <ai:button id="" onclick="" classname="icon_ft" />&nbsp;
           <ai:button id="" onclick="" classname="icon_mail" />&nbsp;
           <ai:button id="" onclick="" classname="icon_newinfo" />&nbsp;
           <ai:button id="" onclick="" classname="icon_note" />&nbsp;
           <ai:button id="" onclick="" classname="icon_se" />&nbsp;
           <ai:button id="" onclick="" classname="icon_up" />&nbsp;
           <ai:button text="����" id="" onclick="" classname="icon_add" />&nbsp;
           <ai:button text="�޸�" id="" onclick="" classname="icon_modifiy" enable="false" />&nbsp;
           <ai:button text="����" id="" onclick="" classname="icon_port" />&nbsp;
           <ai:button text="������" id="" onclick="" classname="icon_finish" /></td>
		</tr>
		<tr>
			<td height="1" bgcolor="#999999"></td>
		</tr>
      </table>
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
		</tr>
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

<div class="area_button">
	<ai:button text="�޸�" id="modify" onclick="onClickModify();" />&nbsp;&nbsp;
	<ai:button text="����" id="sure" onclick="onClickSure();" enable="false"/>
</div>

	</body>
</html>
<script language="javascript">

	function onClickModify(){
		
		getModifyDistrictBt().setDisabled(true);
		getSureDistrictBt().setDisabled(false);

	}
	
	function onClickSure(){

	   	getModifyDistrictBt().setDisabled(false);
		getSureDistrictBt().setDisabled(true);
	 
	}
	
	function getModifyDistrictBt(){
		return g_AIButtonManager.get("modify");
	}
	function getSureDistrictBt(){
		return g_AIButtonManager.get("sure");
	}
	
</script>