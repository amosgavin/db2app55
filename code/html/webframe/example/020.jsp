<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>ģ��020</title>
<!--ʱ�����ڿؼ�ģ��ҳ��˵�� -->
<!--
1����ģ�������ڵ���ʱ�����ڵ�jspҳ�棻
2����ģ����ѭ�������Ϊ�ٷֱȣ��߶���������Ȼ�ſ�ԭ������Ӧ���ֱַ��������
3����ѯ����ѯ����ֱ���ai:contractframe���÷ָ
4��ai:contractframeʹ��ע�⣺���������100%���߶�������������Ȼ�ſ���allowcontract���ԣ��Ƿ��������� Ĭ��true��ֵ��true/false����frameclosed���ԣ���ʼ��ʱ���������Ƿ��ڹر�״̬��Ĭ��false��ֵ��true/false��
5����ťλ����ע�⣺��ѯ��ťʹ��css��class="td_button"����������ťʹ��css��class="area_button"��;���Ŷ����ť����ʱ���м����2��&nbsp;&nbsp;��
6����ʱ����������Ӧset������<EditType>DBDateTime</EditType>������������<EditType>DBDate</EditType>��
 -->
</head>

<body>
<ai:contractframe id="�ͻ���Ϣ" contenttype="table" title="�ͻ���Ϣ" width="100%" allowcontract="false" frameclosed="false">
  <ai:contractitem/>
 <ai:dbform formid="formAttach" setname="com.ai.frame.attach.SETSysAttach" initial="false" >
    <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
        <tr>
                <td class="td_font">�ͻ����ƣ�</td>
                <td><ai:dbformfield fieldname="ATTACH_ID" formid="formAttach" visible="true" width="150"/></td>
                <td class="td_font">��ʼʱ��:<br>ʱ/��/��</td>
                <td><ai:dbformfield fieldname="DATE_TIME_CODE"  formid="formAttach" visible="true" width="150"/></td>
                <td class="td_font">����ʱ�䣺</td>
                <td><ai:dbformfield fieldname="DATE_CODE" formid="formAttach" visible="true" width="150"/></td>
           <td class="td_button"><ai:button text="��ѯ" id="" onclick="" /></td>
        </tr>
    </table>
</ai:dbform>
</ai:contractframe>

<ai:contractframe id="�ͻ���Ϣ�б�" contenttype="table" title="�ͻ���Ϣ�б�" width="100%" allowcontract="false" frameclosed="false">
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
  <ai:button text="����Excel" id="" onclick="" />&nbsp;&nbsp;
  <ai:button text="���²�ѯ" id="" onclick="" />&nbsp;&nbsp;
  <ai:button text="������" id="" onclick="" enable="false" />
</div>

</body>
</html>
<script language="javascript">

</script>