<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
 
<html>
<head>
<title>tab5</title>

</head>

<script type="text/javascript" src="<%=request.getContextPath()%>/jsv2/topopenwin.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsv2/openwin.js"></script>
<body>
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
  <ai:button text="�ɹ�" id="query" onclick="query2()" />&nbsp;&nbsp;
  <ai:button text="��ʾ" id="query" onclick="query3()" />&nbsp;&nbsp;
  <ai:button text="����" id="query" onclick="query4()" />&nbsp;&nbsp;
  <!--����<a href>�򿪵Ĵ��ڱ���ʹ�á�#nogo��; -->
  <a href="#nogo" id="query" onClick="query3();">��DIV��ʾ����</a> 
</div>

</body>
</html>
<script language="javascript">
function query1(){
 ai.open('�򿪴���1','<%=request.getContextPath()%>/webframe/example/open02.jsp',900,500);
}

function query2(){
	ai.success('��������ɹ�','��������ɹ����Ƿ������');
}

function query3(){
	ai.word('�����ύ��ʾ','������ɹ����ύ���Ƿ������');
}

function query4(){
	ai.alert('��ʱ����','���ѳ�ʱ�������µ�¼��');
}
</script>