<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>����/�׿��������ģ��</title>
<!--����/�׿��������ģ��ҳ��˵�� -->
<!--
1����ģ�������ڸ��ֱ���/�׿������jspҳ�棻
2����ģ����ѭ�������Ϊ�ٷֱȣ��߶���������Ȼ�ſ�ԭ������Ӧ���ֱַ��������
3��ai:contentframeʹ��ע�⣺���������100%���߶�������������Ȼ�ſ���
4��ai:contractframeʹ��ע�⣺���������100%���߶�������������Ȼ�ſ���allowcontract���ԣ��Ƿ���������Ĭ��true��ֵ��true/false����frameclosed���ԣ���ʼ��ʱ���������Ƿ��ڹر�״̬��Ĭ��false��ֵ��true/false����
5����ťλ����ע�⣺��ѯ��ťʹ��css��class="td_button"����������ťʹ��css��class="area_button"��;���Ŷ����ť����ʱ���м����2��&nbsp;&nbsp;��
 -->
</head>

<body>
<ai:contentframe id="�ͻ���Ϣ1" title="�ͻ���Ϣ1" width="99%" contenttype="table">
	 <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
         <tr>
           <td class="td_font">�ͻ����ƣ�</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/><span class="font_red">*</span></td>
           <td class="td_font">��ϵ�绰��</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/><span class="font_red">*</span></td>
           <td class="td_font">�ͻ����ԣ�</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
		</tr>
		<tr>
           <td class="td_font">��ϵ��ַ��</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/><span class="font_red">*</span></td>
           <td class="td_font">�������룺</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/></td>
           <td class="td_font">��ע��</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
		</tr>
      </table>
</ai:contentframe>

<ai:contractframe id="�ͻ���Ϣ2" title="�ͻ���Ϣ2" width="100%" contenttype="table" allowcontract="true" frameclosed="false">
  <ai:contractitem/>
	 <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
         <tr>
           <td class="td_font">�ͻ����ƣ�</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:130"/><img id="" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif"  alt="ѡ��ͻ�" onClick="sel_org();" align="absmiddle" style="cursor:hand;"/></td>
           <td class="td_font">��ϵ�绰��</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/></td>
           <td class="td_font">�ͻ����ԣ�</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:130"/><img id="" border="0" src="<%=request.getContextPath()%>/webframe/images/add.gif"  alt="���ӿͻ�����" onClick="sel_org();" align="absmiddle" style="cursor:hand;"/></td>
		</tr>
		<tr>
           <td class="td_font">��ϵ��ַ��</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/></td>
           <td class="td_font">�������룺</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:130"/><img id="" border="0" src="<%=request.getContextPath()%>/webframe/images/refresh.gif"  alt="ˢ�±���" onClick="sel_org();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span></td>
           <td class="td_font">��ע��</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
		</tr>
      </table>
</ai:contractframe>

<ai:contractframe id="�ͻ���Ϣ3" title="�ͻ���Ϣ3" width="100%" contenttype="table" allowcontract="true" frameclosed="false">
	<ai:contractitem>
	<div class="t-bot-mc-word"><span class="font_red">ע��</span>�����������Ϣ����ʾ�����ѯ��Ϣ</div>
    <div class="t-bot-mc-button">
           <ai:button text="+������Ϣ" id="btnMore" onclick="moreQueryCondition();" />&nbsp;&nbsp;
           <ai:button text="��ѯ" id="" onclick="" />&nbsp;&nbsp;
		   <ai:button text="����" id="" onclick="" />
	</div>
	</ai:contractitem>
	 <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
         <tr>
           <td class="td_font">�ͻ����ƣ�</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:130"/><img id="" border="0" src="<%=request.getContextPath()%>/webframe/images/check.gif"  alt="ѡ����֯" onClick="sel_org();" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span></td>
           <td class="td_font">��ϵ�绰��</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/></td>
           <td class="td_font">�ͻ����ԣ�</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
		</tr>
		<tr>
           <td class="td_font">��ϵ��ַ��</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/></td>
           <td class="td_font">�������룺</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:130"/><img id="" border="0" src="<%=request.getContextPath()%>/webframe/images/clean.gif"  alt="�������" onClick="sel_org();" align="absmiddle" style="cursor:hand;"/></td>
           <td class="td_font">��ע��</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
		</tr>
      </table>  
      <!-- ���صĸ����ѯ���� -->
      <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2" id="moreQueryCondition" style="display:none">
         <tr>
           <td class="td_font">�ͻ�����1��</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/><span class="font_red">*</span></td>
           <td class="td_font">��ϵ�绰1��</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/></td>
           <td class="td_font">�ͻ�����1��</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
		</tr>
		<tr>
           <td class="td_font">��ϵ��ַ1��</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:150"/></td>
           <td class="td_font">��������1��</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:150"/></td>
           <td class="td_font">��ע1��</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:150"/></td>
		</tr>
      </table>    
</ai:contractframe>

<ai:contractframe id="�ͻ���Ϣ4" title="�ͻ���Ϣ4" width="100%" contenttype="table" allowcontract="true" frameclosed="true">
	<ai:contractitem>
	<div class="t-bot-mc-left">�����ײͣ�<span class="font_red">99Ԫ����</span>&nbsp;&nbsp;Ԥ�ɣ�<span class="font_red">200Ԫ</span>&nbsp;&nbsp;�߽ɣ�<span class="font_red">��</span></div>
    <div class="t-bot-mc-button">
			<ai:button text="����" id="" onclick="" classname="icon_add" />
	        <ai:button text="�޸�" id="" onclick="" classname="icon_modifiy" />
	        <ai:button text="����" id="" onclick="" classname="icon_port" />
	        <ai:button text="������" id="" onclick="" classname="icon_finish" />
	</div>
	</ai:contractitem>
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
      </table>      
</ai:contractframe>

<ai:contractframe id="�ͻ���Ϣ5" title="�ͻ���Ϣ5" width="100%" contenttype="table" allowcontract="true" frameclosed="false">
	<ai:contractitem>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
         <tr height="22">
           <td><img src="<%=request.getContextPath()%>/webframe/images/icon_add.gif" align="absmiddle">&nbsp;<a href="#nogo" class="a">����</a>&nbsp;&nbsp;
           <img src="<%=request.getContextPath()%>/webframe/images/icon_modifiy.gif" align="absmiddle">&nbsp;<a href="#nogo" class="a">�޸�</a>&nbsp;&nbsp;
           <img src="<%=request.getContextPath()%>/webframe/images/icon_port.gif" align="absmiddle">&nbsp;<a href="#nogo" class="a">����</a>&nbsp;&nbsp;
           <img src="<%=request.getContextPath()%>/webframe/images/icon_finish.gif" align="absmiddle">&nbsp;<a href="#nogo" class="a">������</a></td>
           <td class="t-bot-mc-button"><a href="#nogo" class="b" onClick="moreQuery()">�߼�����>></a>&nbsp;&nbsp;</td>
		</tr>
      </table>
	</ai:contractitem>
	 <ai:table setname="com.ai.frame.attach.SETSysAttach" tableid="spselect"  
        needrefresh="true" editable="ture" initial="true" multiselect="true"
          pagesize="5" width="100%" height="120" ondblink="" onlyquery="true">
          <ai:col fieldname="ATTACH_ID" width="10%"/>
       		<ai:col fieldname="BUSI_SHEET_ID" width="15%" />
       		<ai:col fieldname="BUSI_TYPE_CODE" width="15%" />
       		<ai:col fieldname="REMARKS" width="30%" />
       		<ai:col fieldname="NAME" width="30%" />
           </ai:table>     
</ai:contractframe>

</body>
</html>
<script language="javascript">
/*��ʾ�����ز�ѯ����*/
var flag = false;
function moreQueryCondition(){		
		if(!flag){
			document.getElementById("moreQueryCondition").style.display="block";
			g_AIButtonManager.get("btnMore").setText("-������Ϣ");
			flag = true;
		}else{
			document.getElementById("moreQueryCondition").style.display="none";
			g_AIButtonManager.get("btnMore").setText("+������Ϣ");
			flag = false;
		}		
}

function moreQuery(){
   window.showModalDialog("<%=request.getContextPath()%>/webframe/example/open01.jsp",'',"scroll:no;resizable:no;status:no;dialogHeight:450px;dialogWidth:600px");
}
</script>