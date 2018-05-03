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
   var image = surface.createImage({height: 5,width: 95,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(73.0,81.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(165.0,69.0));
   var t=surface.createText({x:165.0+iconWidth/2,y:69.0+iconHeight+12,text:'发起人提交申请',align:'middle'});
   t.setFill('black');
   t.setFont({family:'Arial',size:12});
   var image = surface.createImage({height: 5,width: 85,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(190,81.0));
   
   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(265.0,69.0));
   var t=surface.createText({x:265.0+iconWidth/2,y:69.0+iconHeight+12,text:'资费委员会会签',align:'middle'});
   if(tasktag=="S001"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   var image = surface.createImage({height: 5,width: 95,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(290,81.0));
   
   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(380.0,69.0));
   var t=surface.createText({x:380+iconWidth/2,y:69.0+iconHeight+12,text:'发起人修改并提交营销案',align:'middle'});
   if(tasktag=="PC001"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   var image = surface.createImage({height: 5,width: 118,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(405,81.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(520.0,69.0));
   var t=surface.createText ({x:520+iconWidth/2,y:69.0+iconHeight+12,text:'市场(集客)部总经理审核',align:'middle'});
   if(tasktag=="PC002"||tasktag=="PC003"||tasktag=="PC004"||tasktag=="S002"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 5,width: 118,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(545,81.0));
   var image = surface.createImage({height: 80,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow02.png'});
   image.setTransform(dojox.gfx.matrix.translate(530.0,100.0));


   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(658.0,69.0));
   var t=surface.createText({x:658+iconWidth/2,y:69.0+iconHeight+12,text:'发起人发起配置流程',align:'middle'});
   if(tasktag=="PC005"||tasktag=="PC023"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   var image = surface.createImage({height: 5,width: 100,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(683,81.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(778.0,69.0));
   var t=surface.createText({x:778.0+iconWidth/2,y:69.0+iconHeight+12,text:'省业支中心配置',align:'middle'});
   if(tasktag=="PC006"||tasktag=="PC007"||tasktag=="PC015"||tasktag=="PC014"||tasktag=="PC011"||tasktag=="PC009"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   var image = surface.createImage({height: 80,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow02.png'});
   image.setTransform(dojox.gfx.matrix.translate(788,100.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(778.0,180.0));
   var t=surface.createText({x:778.0+iconWidth/2,y:180.0+iconHeight+12,text:'地市测试',align:'middle'});
   if(tasktag=="PC008"||tasktag=="PC010"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   var image = surface.createImage({height: 65,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow02.png'});
   image.setTransform(dojox.gfx.matrix.translate(788,210.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(778.0,271.0));
   var t=surface.createText ({x:778.0+iconWidth/2,y:271.0+iconHeight+12,text:'测试通过，返回发起人',align:'middle'});
   if(tasktag=="PC012"||tasktag=="PC013"||tasktag=="PC022"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 7,width: 235,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow03.png'});
   image.setTransform(dojox.gfx.matrix.translate(550,285.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(520.0,180.0));
   var t=surface.createText ({x:520.0+iconWidth/2,y:180.0+iconHeight+12,text:'审批不通过，返回发起人',align:'middle'});
   if(tasktag=="PC021"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 65,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow02.png'});
   image.setTransform(dojox.gfx.matrix.translate(530,210.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(520.0,271.0));
   var t=surface.createText ({x:520.0+iconWidth/2,y:271.0+iconHeight+12,text:'发起人确认',align:'middle'});
   t.setFill ('black');
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 7,width: 158,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow03.png'});
   image.setTransform(dojox.gfx.matrix.translate(365,285.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/finish.png'});
   image.setTransform(dojox.gfx.matrix.translate(340,271.0));
   var t=surface.createText ({x:340.0+iconWidth/2,y:271.0+iconHeight+12,text:'结束',align:'middle'});
   t.setFill ('black');
   t.setFont ({family:'Arial',size:12});

</script>

   

   


   



