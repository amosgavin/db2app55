<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
 
<html>
<head>
<title>ģ��015</title>
<!--��ͨ��������ģ��ҳ��˵�� -->
<!--
1����ģ����������ͨ�������ڵ�jspҳ�棻
2����ģ����ѭ�������Ϊ�ٷֱȣ��߶���������Ȼ�ſ�ԭ������Ӧ���ֱַ��������
3����������Ӧ��ʵ������Ϊ׼��ԭ���ϲ��ɹ���Ҳ��������ֹ�������������ʵ�ڹ��࣬Ҳֻ����������¹�������
4����ע�⣺�������ڵĿ���벻Ҫ����1000px���߶��벻Ҫ����700px��
 -->
</head>

<body>
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
  <ai:button text="��ť��������" id="query1" onclick="moreQuery()" />&nbsp;&nbsp;
  <!--����<a href>�򿪵Ĵ��ڱ���ʹ�á�#nogo��; -->
  <a href="#nogo" class="b" onClick="moreQuery()">�߼�����>></a>
</div>

</body>
</html>
<script language="javascript">
function moreQuery(){
   window.showModalDialog("<%=request.getContextPath()%>/webframe/example/open01.jsp",'',"scroll:no;resizable:no;status:no;dialogHeight:450px;dialogWidth:600px");
}
</script>