<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
 
<html>
<head>
<title>ģ��016</title>
<!--��ͨ����DIV���϶���͸������ʾ������ģ��ҳ��˵�� -->
<!--
1����ģ����������ͨ����DIV���϶���͸������ʾ�����ڵ�jspҳ�棻
2����ģ����ѭ�������Ϊ�ٷֱȣ��߶���������Ȼ�ſ�ԭ������Ӧ���ֱַ��������
3��ʹ����������jsv2Ŀ¼�µ�openwin.js��topopenwin.js��
4��ai.open���ô򿪴������Էֱ�Ϊ���򿪴�������������ҳ�����ơ����ڿ�ȡ����ڸ߶ȣ��磺ai.open('�򿪴���1','test1.jsp',520, 290);
5��ai.success���ô򿪡��ɹ����������Էֱ�Ϊ���򿪳ɹ������������򿪴��ں�Ҫ��д�����֣�����������50���֣����磺��ai.success('��������ɹ�','��������ɹ����Ƿ������')
6��ai.word���ô򿪡���ʾ���������Էֱ�Ϊ������ʾ�����������򿪴��ں�Ҫ��д�����֣�����������50���֣����磺ai.word('�����ύ��ʾ','������ɹ����ύ���Ƿ������')��
7��ai.alert���ô򿪡����桱�������Էֱ�Ϊ���򿪾��洰���������򿪴��ں�Ҫ��д�����֣�����������50���֣����磺ai.alert('��ʱ����','���ѳ�ʱ�������µ�¼��')��
8��ai.open���ô򿪴������Էֱ�Ϊ���򿪴�������������ҳ�����ơ����ڿ�ȡ����ڸ߶ȣ��磺ai.open('�򿪴���1','test1.jsp',520, 290);
9����ע�⣺����DIV���ڵĿ���벻Ҫ����1000px���߶��벻Ҫ����700px��
10������DIV���ڱȽϺ��ڴ棬���Ƽ��ڴ���BOSS����Ŀ��ʹ�ã�
 -->
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsv2/topopenwin.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsv2/openwin.js"></script>
<body style="overflow:hidden">
<ai:contractframe id="��ѯ����" contenttype="table" title="��ѯ����" width="100%" allowcontract="false" frameclosed="false">
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

<ai:contractframe id="�ͻ���Ϣ" contenttype="table" title="�ͻ���Ϣ" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem/>
 <ai:table setname="com.ai.frame.attach.SETSysAttach" tableid="spselect"  
        needrefresh="true" editable="ture" initial="true" multiselect="true"
          pagesize="10" width="100%" height="220" ondblink="">
          <ai:col fieldname="ATTACH_ID" width="10%"/>
       		<ai:col fieldname="BUSI_SHEET_ID" width="15%" />
       		<ai:col fieldname="BUSI_TYPE_CODE" width="15%" />
       		<ai:col fieldname="REMARKS" width="30%" />
       		<ai:col fieldname="NAME" width="30%" />
           </ai:table>
</ai:contractframe>

<div class="area_button">
  <ai:button text="����DIV����" id="query" onclick="query1()" />&nbsp;&nbsp;
  <ai:button text="tabҳ�е���DIV����" id="query" onclick="query2()"/>
  <ai:button text="�ɹ�" id="query" onclick="query3()" />&nbsp;&nbsp;
  <ai:button text="��ʾ" id="query" onclick="query4()" />&nbsp;&nbsp;
  <ai:button text="����" id="query" onclick="query5()" />&nbsp;&nbsp;
  <!--����<a href>�򿪵Ĵ��ڱ���ʹ�á�#nogo��; -->
  <a href="#nogo" id="query" onClick="query5();">��DIV��ʾ����</a> 
</div>

</body>
</html>
<script language="javascript">
function query1(){
 ai.open('�򿪴���1','<%=request.getContextPath()%>/webframe/example/open02.jsp',900, 500);
}
function query2(){
 ai.open('�򿪴���2','<%=request.getContextPath()%>/webframe/example/open03.jsp',900, 550);
}
function query3(){
	ai.success('��������ɹ�','��������ɹ����Ƿ������');
}

function query4(){
	ai.word('�����ύ��ʾ','������ɹ����ύ���Ƿ������');
}

function query5(){
	ai.alert('��ʱ����','���ѳ�ʱ�������µ�¼��');
}
	  
</script>