<%@ page language="java" pageEncoding="GBK"%> 
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
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
   var image = surface.createImage({height: 5,width: 98,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(72.0,81.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(165.0,69.0));
   var t=surface.createText({x:165.0+iconWidth/2,y:69.0+iconHeight+12,text:'发起人提交申请',align:'middle'});
   t.setFill('black');
   t.setFont({family:'Arial',size:12});
   var image = surface.createImage({height: 5,width: 98,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(190.0,81.0));
   
   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(280.0,69.0));
   var t=surface.createText({x:270.0+iconWidth/2,y:69.0+iconHeight+12,text:'营销案会签',align:'middle'});
   if(tasktag=="sign01"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   var image = surface.createImage({height: 5,width: 105,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(305.0,81.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(404.0,69.0));
   var t=surface.createText ({x:404.0+iconWidth/2,y:68.0+iconHeight+12,text:'发起人修改编辑',align:'middle'});
   if(tasktag=="p01"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 5,width: 123,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(430.0,81.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(548.0,69.0));
   var t=surface.createText({x:548.0+iconWidth/2,y:69.0+iconHeight+12,text:'市场部总经理审核',align:'middle'});
   if(tasktag=="p02"||tasktag=="p02"||tasktag=="p03"||tasktag=="sign02"||tasktag=="p08"||tasktag=="sign03"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   var image = surface.createImage({height: 5,width: 110,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(575.0,81.0));
   var image = surface.createImage({height: 85,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow02.png'});
   image.setTransform(dojox.gfx.matrix.translate(560.0,100.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(678.0,70.0));
   var t=surface.createText({x:678.0+iconWidth/2,y:70.0+iconHeight+12,text:'主办人发起配置',align:'middle'});
   if(tasktag=="p09"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   var image = surface.createImage({height: 85,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow02.png'});
   image.setTransform(dojox.gfx.matrix.translate(690.0,100.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(678.0,180.0));
   var t=surface.createText({x:678.0+iconWidth/2,y:180.0+iconHeight+12,text:' 省业支配置测试',align:'middle'});
   if(tasktag=="p04"||tasktag=="p12"||tasktag=="p05"||tasktag=="p06"||tasktag=="p13"||tasktag=="p14"||tasktag=="p17"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   var image = surface.createImage({height: 65,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow02.png'});
   image.setTransform(dojox.gfx.matrix.translate(690.0,210.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/condition.png'});
   image.setTransform(dojox.gfx.matrix.translate(678.0,271.0));
   var t=surface.createText ({x:678.0+iconWidth/2,y:271.0+iconHeight+12,text:'条件判断',align:'middle'});
   t.setFill ('black');
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 5,width: 100,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(708,280.0));
   var image = surface.createImage({height: 9,width: 250,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow03.png'});
   image.setTransform(dojox.gfx.matrix.translate(430,280.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(800.0,270.0));
   var t=surface.createText ({x:800.0+iconWidth/2,y:270.0+iconHeight+12,text:'互联网中心处理',align:'middle'});
   if(tasktag=="p16"||tasktag=="p19"||tasktag=="p18"||tasktag=="p21"||tasktag=="p20"||tasktag=="p22"||tasktag=="p23"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 75,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow04.png'});
   image.setTransform(dojox.gfx.matrix.translate(810.0,195.0));
   var image = surface.createImage({height: 9,width: 110,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow03.png'});
   image.setTransform(dojox.gfx.matrix.translate(705.0,190.0));

   
   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(404.0,271.0));
   var t=surface.createText ({x:404.0+iconWidth/2,y:271.0+iconHeight+12,text:'营销案通过，返回发起人',align:'middle'});
   if(tasktag=="p07"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 70,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow04.png'});
   image.setTransform(dojox.gfx.matrix.translate(414,205.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(548.0,180.0));
   var t=surface.createText ({x:548.0+iconWidth/2,y:180.0+iconHeight+12,text:'审批不通过，返回发起人',align:'middle'});
   if(tasktag=="p11"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 9,width: 125,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow03.png'});
   image.setTransform(dojox.gfx.matrix.translate(428.0,190.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(404.0,180.0));
   var t=surface.createText ({x:404.0+iconWidth/2,y:180.0+iconHeight+12,text:'发起人确认',align:'middle'});
   t.setFill ('black');
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 9,width: 98,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow03.png'});
   image.setTransform(dojox.gfx.matrix.translate(310,190.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/finish.png'});
   image.setTransform(dojox.gfx.matrix.translate(280.0,180.0));
   var t=surface.createText ({x:280.0+iconWidth/2,y:180.0+iconHeight+12,text:'结束',align:'middle'});
   t.setFill ('black');
   t.setFont ({family:'Arial',size:12});


</script>
