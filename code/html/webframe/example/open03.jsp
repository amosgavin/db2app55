<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
 
<html>
<head>
<title>����ҳ��5</title>
<!--������DIV����ģ��ҳ��˵�� -->
<!--
1����ģ��Ϊʹ�õ���DIV���϶���͸�����������ص�jspҳ�棻
2����ģ����ѭ�������Ϊ�ٷֱȣ��߶���������Ȼ�ſ�ԭ������Ӧ���ֱַ��������
3��ʹ����������jsv2Ŀ¼�µ�openwin.js��topopenwin.js��
4���رռ�ˢ��/�����ϲ����ķ����ɲο�script�е�д����
5�������ѵ�����DIV���ڣ������ٵ�������DIV���ڣ���ʾ/�ɹ�/���洰�ڽ�Ϊ���ڹرն�����
 -->
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsv2/topopenwin.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsv2/openwin.js"></script>
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

<div class="area_tab">
<ai:tab id="ddd2" width="100%" height="360" type="h">
	<ai:tabitem id="dd1" title="����ͳ�ƽ��" src="tab5.jsp" initial="true" />
	<ai:tabitem id="dd2" title="�ͻ��շ�����" src="tab2.jsp" isDeletable="true"/>
	<ai:tabitem id="dd3" title="�ͻ�Ⱥ" src="tab2.jsp" isDeletable="true"/>
	<ai:tabitem id="dd4" title="���ò�ѯ���" src="tab2.jsp" />
</ai:tab>
</div>

<div class="area_button">
  <ai:button text="ȷ��" id="" onclick="query()" />&nbsp;&nbsp;
  <ai:button text="�ɹ�" id="query" onclick="query2()" />&nbsp;&nbsp;
  <ai:button text="��ʾ" id="query" onclick="query3()" />&nbsp;&nbsp;
  <ai:button text="����" id="query" onclick="query4()" />&nbsp;&nbsp;
  <ai:button text="�ر�" id="" onclick="closeme()" />&nbsp;&nbsp;
  <!--����<a href>�򿪵Ĵ��ڱ���ʹ�á�#nogo��; -->
   <a href="#nogo" id="query" onClick="query5();">��DIV����</a> 
</div>

</body>
</html>
<script language="javascript">
function query2(){
	ai.success('��������ɹ�','��������ɹ����Ƿ������');
}

function query3(){
	ai.word('�����ύ��ʾ','������ɹ����ύ���Ƿ������');
}

function query4(){
	ai.alert('��ʱ����','���ѳ�ʱ�������µ�¼��');
}

function query5(){
 ai.open('�򿪴���1','<%=request.getContextPath()%>/webframe/example/open02.jsp',900, 500);
}

/*��������DIV���ڹرշ���*/
function closeme(){
  ai.closePopup();
}
 
/*����DIV����ˢ�²��رշ���*/
 function query(){
 //parentWinΪ����������һ��
	var parentWin = ai.getOpener();
	if(parentWin != null)
		//Ϊ��һ������һ��table parentWin.addTable();
		//�����������ϼ�����  parentWin.test(param);
   //ˢ����һ��
   parentWin.location.reload();		

	//�رմ���
	ai.closePopup();
} 
</script>