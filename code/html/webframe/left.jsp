<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>left</title>
</head>

<body>
<div id="left1">
<ai:outlook id="left" width="200">

	<ai:outlookitem title="ϵͳ�˵�" id="" classname="title00" width="200">
	   <iframe id="menuTree" src="tree.jsp" frameborder="0" width="100%" height="90%" scrolling="no"></iframe>
	</ai:outlookitem>
<!--  
	<ai:outlookitem title="��¼��Ϣ" id="" classname="title00" width="200">
		<span class="title_bg title_h">
        <span class="time">
	 	�����ǣ�<br>
        <script language=javascript>
            today=new Date();
           function initArray(){
           this.length=initArray.arguments.length
           for(var i=0;i<this.length;i++)
           this[i+1]=initArray.arguments[i] }
           var d=new initArray(
                "������",
                "����һ",
                "���ڶ�",
                "������",
                "������",
                "������",
                "������");
           document.write(
           "<font color=##000000 style='font-size:9pt;font-family: ����'> ",
           today.getYear(),"��",
           today.getMonth()+1,"��",
           today.getDate(),"��",
           d[today.getDay()+1],
           "</font>" ); 
        </script>
		</span><br>
        <span class="dlxx">
         <span class="font_red font_bold"><%=SessionManager.getUser().getName()%></span>�����ã�<br>&nbsp;&nbsp;&nbsp;��ӭ��¼XXXXXXϵͳ
        </span>
     </span>
	</ai:outlookitem>
-->	
	<%--<ai:outlookitem title="�汾˵��" id="" classname="title00" width="200">
	   <span class="title_bg">
       <span style="line-height:20px;">SecFrameͳһȨ�޹���ƽ̨��</span>
       </span>
	</ai:outlookitem>

	<ai:outlookitem title="ʹ�ð���" id="" classname="title00" width="200">
		<span class="title_bg">
        <span style="line-height:20px;"></span>
        </span>
	</ai:outlookitem>
--%></ai:outlook>
</div>
</body>
</html>

<script type="text/javascript">
function openMainFrame(url){
window.top.document.getElementById("mainFrame").src = url;
}
</script>