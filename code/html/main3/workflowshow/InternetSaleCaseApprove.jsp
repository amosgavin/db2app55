<%@ page language="java" pageEncoding="GBK"%> 
<%@ page import="java.util.*" %>
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<%
		String tasktag = request.getParameter("taskTag");
%>	
<html>
  <head>
  </head>
  <script type="text/javascript" src="<%=request.getContextPath() %>/workflow/common/dojo-release-1.7.1/dojo/dojo.js" djConfig="isDebug: true"></script>
  <body>
	<div id='container' style="height:650;width:1100"></div>
  </body>
</html>
 <script type="text/javascript" >
   dojo.require("dojox.gfx");
   dojo.require("dojox.data.dom");
   var tasktag = "<%=tasktag%>";     
   
   var surfaceHeight = document.getElementById("container").offsetHeight;
   var surfaceWidth = document.getElementById("container").offsetWidth;
   var iconHeight =32;
   var iconWidth =32;
   
   var HolderTmp = document.getElementById("container");
   var surfaceHolder = dojo.byId("container");
   var surface = dojox.gfx.createSurface(surfaceHolder, surfaceWidth, surfaceHeight);

   var image = surface.createImage({height: surfaceHeight,width: surfaceWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/bg.png'});
   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/start.png'});
   image.setTransform(dojox.gfx.matrix.translate(43.0,71.0));
   var t=surface.createText({x:43.0+iconWidth/2,y:71.0+iconHeight+12,text:'开始',align:'middle'});
   t.setFill ('black');
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 5,width: 80,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(73.0,80.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(150.0,69.0));
   var t=surface.createText({x:150.0+iconWidth/2,y:69.0+iconHeight+12,text:'发起人提交申请',align:'middle'});
   t.setFill('black');
   t.setFont({family:'Arial',size:12});
   var image = surface.createImage({height: 5,width: 100,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(177.0,80.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(270.0,69.0));
   var t=surface.createText({x:270.0+iconWidth/2,y:69.0+iconHeight+12,text:'互联网中心部门经理审批',align:'middle'});
   if(tasktag=="I001"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   var image = surface.createImage({height: 5,width: 110,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(300.0,80.0));


   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(404.0,68.0));
   var t=surface.createText ({x:404.0+iconWidth/2,y:68.0+iconHeight+12,text:'总经理(分管副总)审阅',align:'middle'});
   if(tasktag=="I002"||tasktag=="I004"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 5,width: 151,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(434.0,80.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(578.0,70.0));
   var t=surface.createText({x:578.0+iconWidth/2,y:70.0+iconHeight+12,text:'省公司主办人处理',align:'middle'});
   if(tasktag=="I005"||tasktag=="I006"||tasktag=="I008"||tasktag=="I007"||tasktag=="SI001"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   var image = surface.createImage({height: 5,width: 180,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(608.0,80.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(778.0,70.0));
   var t=surface.createText({x:778.0+iconWidth/2,y:70.0+iconHeight+12,text:'省公司市场部总经理审阅',align:'middle'});
   if(tasktag=="I009"||tasktag=="I010"||tasktag=="I011"||tasktag=="SI002"||tasktag=="SI003"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   var image = surface.createImage({height: 85,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow02.png'});
   image.setTransform(dojox.gfx.matrix.translate(790.0,100.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(778.0,180.0));
   var t=surface.createText({x:778.0+iconWidth/2,y:180.0+iconHeight+12,text:' 省公司主办人处理',align:'middle'});
   if(tasktag=="I013"||tasktag=="I012"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   var image = surface.createImage({height: 62,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow02.png'});
   image.setTransform(dojox.gfx.matrix.translate(790.0,210.0));


   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/condition.png'});
   image.setTransform(dojox.gfx.matrix.translate(778.0,271.0));
   var t=surface.createText ({x:778.0+iconWidth/2,y:271.0+iconHeight+12,text:'条件判断',align:'middle'});
   t.setFill ('black');
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 7,width: 222,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow03.png'});
   image.setTransform(dojox.gfx.matrix.translate(558.0,280.0));
   var image = surface.createImage({height: 75,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow02.png'});
   image.setTransform(dojox.gfx.matrix.translate(790.0,300.0));


   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(669.0,373.0));
   var t=surface.createText ({x:669.0+iconWidth/2,y:373.0+iconHeight+12,text:'省业支审核',align:'middle'});
   if(tasktag=="I023"||tasktag=="I025"||tasktag=="I024"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 7,width: 108,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow03.png'});
   image.setTransform(dojox.gfx.matrix.translate(568.0,383.0));


   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(778.0,373.0));
   var t=surface.createText ({x:778.0+iconWidth/2,y:373.0+iconHeight+12,text:'互联网中心配置测试',align:'middle'});
   if(tasktag=="I014"||tasktag=="I015"||tasktag=="I016"||tasktag=="I028"||tasktag=="I029"||tasktag=="I030"||tasktag=="I017"||tasktag=="I018"||tasktag=="I019"||tasktag=="I031"||tasktag=="I021"||tasktag=="I020"||tasktag=="I032"||tasktag=="I022"||tasktag=="I033"||tasktag=="I035"||tasktag=="I034"||tasktag=="SI004"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 7,width: 82,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow03.png'});
   image.setTransform(dojox.gfx.matrix.translate(700.0,383.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(538.0,373.0));
   var t=surface.createText ({x:538.0+iconWidth/2,y:373.0+iconHeight+12,text:'省公司主办人审阅',align:'middle'});
   if(tasktag=="I026"||tasktag=="SI005"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 7,width: 130,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow03.png'});
   image.setTransform(dojox.gfx.matrix.translate(414.0,383.0));


   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(384.0,373.0));
   var t=surface.createText ({x:384.0+iconWidth/2,y:373.0+iconHeight+12,text:'审批通过，返回发起人',align:'middle'});
   if(tasktag=="I027"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 73,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow04.png'});
   image.setTransform(dojox.gfx.matrix.translate(394.0,300.0));


   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(538.0,271.0));
   var t=surface.createText ({x:538.0+iconWidth/2,y:271.0+iconHeight+12,text:'审批不通过，返回发起人',align:'middle'});
   if(tasktag=="I003"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 7,width: 132,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow03.png'});
   image.setTransform(dojox.gfx.matrix.translate(410.0,281.0));


   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(384.0,271.0));
   var t=surface.createText ({x:384.0+iconWidth/2,y:271.0+iconHeight+12,text:'发起人确认',align:'middle'});
   t.setFill ('black');
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 7,width: 108,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow03.png'});
   image.setTransform(dojox.gfx.matrix.translate(280.0,281.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/finish.png'});
   image.setTransform(dojox.gfx.matrix.translate(250.0,271.0));
   var t=surface.createText ({x:250.0+iconWidth/2,y:271.0+iconHeight+12,text:'结束',align:'middle'});
   t.setFill ('black');
   t.setFont ({family:'Arial',size:12});
</script>
