<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
 
<html>
<head>
<title>����ҳ��1</title>
<!--�����Ĵ���ģ��ҳ��˵�� -->
<!--
1����ģ��Ϊʹ�õ���DIV���϶���͸�����������ص�jspҳ�棻
2����ģ����ѭ�������Ϊ�ٷֱȣ��߶���������Ȼ�ſ�ԭ������Ӧ���ֱַ��������
 -->
</head>

<body>
<ai:contractframe id="�ͻ���Ϣ" contenttype="table" title="�ͻ���Ϣ" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem/>
 <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
         <tr>
           <td class="td_font">�ͻ����ƣ�</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:120"/></td>
           <td class="td_font">��ϵ�绰��</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:120"/></td>
		</tr>
		<tr>
           <td class="td_font">�ͻ����ԣ�</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:120"/></td>
           <td class="td_font">��ϵ��ַ��</td>
           <td><input type="text" class="input"  id="txtAccountName" style="width:120"/></td>
		</tr>
		<tr>
           <td class="td_font">�������룺</td>
           <td><input type="text" class="input" id="txtAccountCode" style="width:120"/></td>
           <td class="td_font">��ע��</td>
           <td><input type="text" class="input" id="txtKeyNum" style="width:120"/></td>
           <td class="td_button"><ai:button text="��ѯ" id="" onclick="" /></td>
		</tr>
      </table>
</ai:contractframe>

<ai:contractframe id="�ͻ���Ϣ�б�" contenttype="table" title="�ͻ���Ϣ�б�" width="100%" allowcontract="true" frameclosed="false">
  <ai:contractitem/>
<ai:table setname="com.ai.frame.attach.SETSysAttach" tableid="spselect"  
        needrefresh="true" editable="ture" initial="true" multiselect="true"
          pagesize="6" width="100%" height="140" ondblink="">
          <ai:col fieldname="ATTACH_ID" width="15%"/>
       		<ai:col fieldname="BUSI_SHEET_ID" width="15%" />
       		<ai:col fieldname="BUSI_TYPE_CODE" width="30%" />
       		<ai:col fieldname="NAME" width="40%" />
           </ai:table>
</ai:contractframe>

<div class="area_button">
  <ai:button text="ȷ��" id="" onclick="" />&nbsp;&nbsp;
  <ai:button text="�ر�" id="" onclick="" /> 
</div>

</body>
</html>
<script language="javascript">

</script>