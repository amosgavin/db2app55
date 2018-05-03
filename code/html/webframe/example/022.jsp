<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>模板</title>
<!--OutLook菜单窗口模板页面说明 -->
<!--
1、本模板适用于弹出OutLook菜单窗口的jsp页面；
2、本模板遵循宽度设置为百分比，高度由内容自然撑开原则以适应各种分辨率浏览；
3、查询用ai:contractframe套用；查询出的多种结果由ai:tab套用；
4、ai:contractframe使用注意：宽度请设置100%，高度由里面内容自然撑开；allowcontract属性（是否允许收缩 默认true，值：true/false）；frameclosed属性（初始化时内容区域是否处于关闭状态，默认false，值：true/false）
5、ai:tab使用注意：宽度请设置100%，高度请设置400，若有多项可酌情减少；initial属性（初始化时是否聚焦 值：true/false）；isDeletable属性（是否含关闭按钮 值：true/false）
6、按钮位置请注意：查询按钮使用css（class="td_button"）；操作按钮使用css（class="area_button"）;并排多个按钮存在时，中间请加2个&nbsp;&nbsp;；
7、ai:outlook使用说明：ai:outlook标签为最外层框，ai:outlookitem为一级菜单，下面内容为二级，可以插入内容、链接、Iframe等任何内容，具体写法请参考本模板；isshow属性（初始化时是否收起所有菜单，默认false[可不写如left.jsp]，值：true/false）
8、ai:outlook使用注意：默认高度为所在页面的最高，默认宽度为200；可以自定义高度和宽度，宽度设置必须ai:outlook和ai:outlookitem同时设置且宽度保持一致（如：width="300"）；高度仅在ai:outlook中设置（如height="500"），请勿在ai:outlookitem设置高度；
9、一级菜单样式默认title00（无图标），本模板提供其他带小图标样式从title01-title10供选用，样式写在ai:outlookitem中（如：classname="title01"）；
10、自定义样式请勿修改默认样式，请写在\html\theme\颜色目录\css\other.css中（请注明样式说明），相关图片请放在\html\theme\颜色目录\images\other\中；
 -->
</head>
<body onResize="resizewin()" style="overflow:hidden">
<div class="group">
  <div id="left1" class="left">
<ai:outlook id="left" width="200" isshow="true">
	<ai:outlookitem title="登录信息" id="" classname="title01" width="200">
		<span style="line-height:26px;">
	 	欢迎登录：<span class="font_note">张三</span>[<span class="font_blue">系统管理员</span>]<br>
		您的工号：GB09603<br>
		您的组织：产品服务组<br>
		&nbsp;&nbsp;&nbsp;您的IP：10.11.0.100
		</span>
	</ai:outlookitem>
	
	<ai:outlookitem title="个人收藏" id="" classname="title02" width="200">
		 <li><a href="#" onClick="openmain('tab2.jsp');return false;" class="li"><span class="dot"></span>我的收藏夹</a></li>
	     <li><a href="#" onClick="openmain('tab1.jsp');return false;" class="li"><span class="dot"></span>密码修改管理</a></li>
	     <li><a href="#" onClick="openmain('tab2.jsp');return false;" class="li"><span class="dot"></span>个人信息查询</a></li>
	     <li><a href="#" onClick="openmain('../myset.jsp');return false;" class="li"><span class="dot"></span>系统风格设置</a></li>
	</ai:outlookitem>

	<ai:outlookitem title="当前任务" id="" classname="title03" width="200">
		<iframe id="" src="test1.jsp" frameborder="0" width="100%" scrolling="no"></iframe>
	</ai:outlookitem>

	<ai:outlookitem title="最新公告" id="" classname="title04" width="200">
		<span style="line-height:22px;">
		测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容……
		</span>
	</ai:outlookitem>

	<ai:outlookitem title="快速查询" id="" classname="title05" width="200">
		<span style="line-height:22px;">
		测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容……
		</span>
	</ai:outlookitem>

	<ai:outlookitem title="个人设置" id="" classname="title06" width="200">
		<span style="line-height:22px;">
		测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容……
		</span>
	</ai:outlookitem>

	<ai:outlookitem title="我的工具" id="" classname="title07" width="200">
		<span style="line-height:22px;">
		测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容……
		</span>
	</ai:outlookitem>

	<ai:outlookitem title="我的来信" id="" classname="title08" width="200">
		<span style="line-height:22px;">
		测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容……
		</span>
	</ai:outlookitem>

	<ai:outlookitem title="我的回信" id="" classname="title09" width="200">
		<span style="line-height:22px;">
		测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容……
		</span>
	</ai:outlookitem>

	<ai:outlookitem title="已竣工单" id="" classname="title10" width="200">
		<span style="line-height:22px;">
		测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容……
		</span>
	</ai:outlookitem>

	<ai:outlookitem title="测试内容" id="" width="200">
		<span style="line-height:22px;">
		测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容……
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