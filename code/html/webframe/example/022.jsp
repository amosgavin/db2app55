<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>ģ��</title>
<!--OutLook�˵�����ģ��ҳ��˵�� -->
<!--
1����ģ�������ڵ���OutLook�˵����ڵ�jspҳ�棻
2����ģ����ѭ�������Ϊ�ٷֱȣ��߶���������Ȼ�ſ�ԭ������Ӧ���ֱַ��������
3����ѯ��ai:contractframe���ã���ѯ���Ķ��ֽ����ai:tab���ã�
4��ai:contractframeʹ��ע�⣺���������100%���߶�������������Ȼ�ſ���allowcontract���ԣ��Ƿ��������� Ĭ��true��ֵ��true/false����frameclosed���ԣ���ʼ��ʱ���������Ƿ��ڹر�״̬��Ĭ��false��ֵ��true/false��
5��ai:tabʹ��ע�⣺���������100%���߶�������400�����ж����������٣�initial���ԣ���ʼ��ʱ�Ƿ�۽� ֵ��true/false����isDeletable���ԣ��Ƿ񺬹رհ�ť ֵ��true/false��
6����ťλ����ע�⣺��ѯ��ťʹ��css��class="td_button"����������ťʹ��css��class="area_button"��;���Ŷ����ť����ʱ���м����2��&nbsp;&nbsp;��
7��ai:outlookʹ��˵����ai:outlook��ǩΪ������ai:outlookitemΪһ���˵�����������Ϊ���������Բ������ݡ����ӡ�Iframe���κ����ݣ�����д����ο���ģ�壻isshow���ԣ���ʼ��ʱ�Ƿ��������в˵���Ĭ��false[�ɲ�д��left.jsp]��ֵ��true/false��
8��ai:outlookʹ��ע�⣺Ĭ�ϸ߶�Ϊ����ҳ�����ߣ�Ĭ�Ͽ��Ϊ200�������Զ���߶ȺͿ�ȣ�������ñ���ai:outlook��ai:outlookitemͬʱ�����ҿ�ȱ���һ�£��磺width="300"�����߶Ƚ���ai:outlook�����ã���height="500"����������ai:outlookitem���ø߶ȣ�
9��һ���˵���ʽĬ��title00����ͼ�꣩����ģ���ṩ������Сͼ����ʽ��title01-title10��ѡ�ã���ʽд��ai:outlookitem�У��磺classname="title01"����
10���Զ�����ʽ�����޸�Ĭ����ʽ����д��\html\theme\��ɫĿ¼\css\other.css�У���ע����ʽ˵���������ͼƬ�����\html\theme\��ɫĿ¼\images\other\�У�
 -->
</head>
<body onResize="resizewin()" style="overflow:hidden">
<div class="group">
  <div id="left1" class="left">
<ai:outlook id="left" width="200" isshow="true">
	<ai:outlookitem title="��¼��Ϣ" id="" classname="title01" width="200">
		<span style="line-height:26px;">
	 	��ӭ��¼��<span class="font_note">����</span>[<span class="font_blue">ϵͳ����Ա</span>]<br>
		���Ĺ��ţ�GB09603<br>
		������֯����Ʒ������<br>
		&nbsp;&nbsp;&nbsp;����IP��10.11.0.100
		</span>
	</ai:outlookitem>
	
	<ai:outlookitem title="�����ղ�" id="" classname="title02" width="200">
		 <li><a href="#" onClick="openmain('tab2.jsp');return false;" class="li"><span class="dot"></span>�ҵ��ղؼ�</a></li>
	     <li><a href="#" onClick="openmain('tab1.jsp');return false;" class="li"><span class="dot"></span>�����޸Ĺ���</a></li>
	     <li><a href="#" onClick="openmain('tab2.jsp');return false;" class="li"><span class="dot"></span>������Ϣ��ѯ</a></li>
	     <li><a href="#" onClick="openmain('../myset.jsp');return false;" class="li"><span class="dot"></span>ϵͳ�������</a></li>
	</ai:outlookitem>

	<ai:outlookitem title="��ǰ����" id="" classname="title03" width="200">
		<iframe id="" src="test1.jsp" frameborder="0" width="100%" scrolling="no"></iframe>
	</ai:outlookitem>

	<ai:outlookitem title="���¹���" id="" classname="title04" width="200">
		<span style="line-height:22px;">
		�������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݡ���
		</span>
	</ai:outlookitem>

	<ai:outlookitem title="���ٲ�ѯ" id="" classname="title05" width="200">
		<span style="line-height:22px;">
		�������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݡ���
		</span>
	</ai:outlookitem>

	<ai:outlookitem title="��������" id="" classname="title06" width="200">
		<span style="line-height:22px;">
		�������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݡ���
		</span>
	</ai:outlookitem>

	<ai:outlookitem title="�ҵĹ���" id="" classname="title07" width="200">
		<span style="line-height:22px;">
		�������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݡ���
		</span>
	</ai:outlookitem>

	<ai:outlookitem title="�ҵ�����" id="" classname="title08" width="200">
		<span style="line-height:22px;">
		�������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݡ���
		</span>
	</ai:outlookitem>

	<ai:outlookitem title="�ҵĻ���" id="" classname="title09" width="200">
		<span style="line-height:22px;">
		�������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݡ���
		</span>
	</ai:outlookitem>

	<ai:outlookitem title="�ѿ�����" id="" classname="title10" width="200">
		<span style="line-height:22px;">
		�������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݡ���
		</span>
	</ai:outlookitem>

	<ai:outlookitem title="��������" id="" width="200">
		<span style="line-height:22px;">
		�������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݲ������ݡ���
		</span>
	</ai:outlookitem>
</ai:outlook>
  </div>
  <div class="right"><iframe id="main" src="tab1.jsp" frameborder="0" width="100%" scrolling="auto"></iframe></div>
</div>


</body>
</html>

<script type="text/javascript">
var gSize=true;
function resizewin(){
	if(gSize)
   		document.all.main.height = document.all.left1.style.height = (document.documentElement.clientHeight|document.body.clientHeight);
	gSize=!gSize;
}
resizewin();

function openmain(url){
window.document.getElementById("main").src = url;
}
</script>