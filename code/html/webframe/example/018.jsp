<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/AIWaitBanner.js"></script>
<title>ģ��018</title>
<!--���صȴ�ģ��ҳ��˵�� -->
<!--
1����ģ�������ڲ�ѯʱ��ϳ��������ؽ϶����ݵ�jspҳ�棻
2����ģ����ѭ�������Ϊ�ٷֱȣ��߶���������Ȼ�ſ�ԭ������Ӧ���ֱַ��������
3����ѯ����ѯ����ֱ���ai:contractframe���÷ָ
4��ai:contractframeʹ��ע�⣺���������100%���߶�������������Ȼ�ſ���allowcontract���ԣ��Ƿ��������� Ĭ��true��ֵ��true/false����frameclosed���ԣ���ʼ��ʱ���������Ƿ��ڹر�״̬��Ĭ��false��ֵ��true/false��
5����ťλ����ע�⣺��ѯ��ťʹ��css��class="td_button"����������ťʹ��css��class="area_button"��;���Ŷ����ť����ʱ���м����2��&nbsp;&nbsp;��
6���������ݳ��ֵ�loading�ɲο�����ѯ����ť���Ч����
7��loading����ע�⣺�벻Ҫ����30���֣��硰���ڴ������Ժ�...��������3����ͳһΪ��ǵ㣨�Ǿ�ţ���
8����Ҫÿ��ҳ�涼ʹ�ü��صȴ���ֻ�м���ʱ�䳬��5��Ĳ�ʹ�ã�ʹ�ü��صȴ����������jsv2Ŀ¼�µ�AIWaitBanner.js��
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
           <td class="td_button"><ai:button text="��ѯ" id="query" onclick="query()" /></td>
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
  <ai:button text="����Excel" id="query" onclick="query()" />&nbsp;&nbsp;
  <ai:button text="���²�ѯ" id="query" onclick="query()" />&nbsp;&nbsp;
  <ai:button text="������" id="" onclick="" enable="false" />
</div>

</body>
</html>
<script language="javascript">
function queryclick(){
}

function query(){ 
 	beginAIWaitBanner("queryclick()","���ڴ������Ժ�...");
}
	  
</script>