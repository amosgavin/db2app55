<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>left</title>
</head>

<body>
<div id="left1">
<ai:outlook id="left" width="200">

	<ai:outlookitem title="系统菜单" id="" classname="title00" width="200">
	   <iframe id="menuTree" src="tree.jsp" frameborder="0" width="100%" height="90%" scrolling="no"></iframe>
	</ai:outlookitem>
<!--  
	<ai:outlookitem title="登录信息" id="" classname="title00" width="200">
		<span class="title_bg title_h">
        <span class="time">
	 	今天是：<br>
        <script language=javascript>
            today=new Date();
           function initArray(){
           this.length=initArray.arguments.length
           for(var i=0;i<this.length;i++)
           this[i+1]=initArray.arguments[i] }
           var d=new initArray(
                "星期日",
                "星期一",
                "星期二",
                "星期三",
                "星期四",
                "星期五",
                "星期六");
           document.write(
           "<font color=##000000 style='font-size:9pt;font-family: 宋体'> ",
           today.getYear(),"年",
           today.getMonth()+1,"月",
           today.getDate(),"日",
           d[today.getDay()+1],
           "</font>" ); 
        </script>
		</span><br>
        <span class="dlxx">
         <span class="font_red font_bold"><%=SessionManager.getUser().getName()%></span>，您好！<br>&nbsp;&nbsp;&nbsp;欢迎登录XXXXXX系统
        </span>
     </span>
	</ai:outlookitem>
-->	
	<%--<ai:outlookitem title="版本说明" id="" classname="title00" width="200">
	   <span class="title_bg">
       <span style="line-height:20px;">SecFrame统一权限管理平台是</span>
       </span>
	</ai:outlookitem>

	<ai:outlookitem title="使用帮助" id="" classname="title00" width="200">
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