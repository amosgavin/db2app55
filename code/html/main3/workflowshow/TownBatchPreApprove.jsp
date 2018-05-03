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
   image.setTransform(dojox.gfx.matrix.translate(35.0,71.0));
   var t=surface.createText({x:35.0+iconWidth/2,y:71.0+iconHeight+12,text:'开始',align:'middle'});
   t.setFill ('black');
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 5,width: 95,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(65.0,81.0));


   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(154,69.0));
   var t=surface.createText({x:154+iconWidth/2,y:69.0+iconHeight+12,text:'发起人提交申请',align:'middle'});
   if(tasktag=="t01" ||tasktag=="t02"||tasktag=="t17"||tasktag=="t18"||tasktag=="t19"||tasktag=="t20"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   var image = surface.createImage({height: 5,width: 98,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(185,81.0));
   
   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(280.0,69.0));
   var t=surface.createText({x:280+iconWidth/2,y:69.0+iconHeight+12,text:'地市(市场部)主任审批',align:'middle'});
   if(tasktag=="t01" ||tasktag=="t02"||tasktag=="t17"||tasktag=="t18"||tasktag=="t19"||tasktag=="t20"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   

   var image = surface.createImage({height: 5,width: 115,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(308,81.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
  image.setTransform(dojox.gfx.matrix.translate(420.0,68.0));
   var t=surface.createText ({x:420.0+iconWidth/2,y:68.0+iconHeight+12,text:'地市分管副总审批',align:'middle'});
   if(tasktag=="t03" ||tasktag=="t04"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont ({family:'Arial',size:12});


var image = surface.createImage({height: 5,width: 125,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(450,81.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(570.0,70.0));
   var t=surface.createText({x:570.0+iconWidth/2,y:70.0+iconHeight+12,text:'地市总经理审批',align:'middle'});
   if(tasktag=="t06" ||tasktag=="t07"||tasktag=="t08"||tasktag=="t0010"||tasktag=="sign01"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   var image = surface.createImage({height: 5,width: 155,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(600,81.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/condition.png'});
   image.setTransform(dojox.gfx.matrix.translate(750.0,70.0));
   var t=surface.createText({x:750.0+iconWidth/2,y:70.0+iconHeight+12,text:'自动判断',align:'middle'});
   if(tasktag=="t05" ||tasktag=="t09"||tasktag=="t10"||tasktag=="t11"||tasktag=="t12"||tasktag=="sign02"||tasktag=="sign03"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   var image = surface.createImage({height: 85,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow02.png'});
   image.setTransform(dojox.gfx.matrix.translate(760.0,100));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(750.0,180.0));
   var t=surface.createText({x:750.0+iconWidth/2,y:180.0+iconHeight+12,text:' 地市发起人配置',align:'middle'});
   if(tasktag=="t0001"||tasktag=="t0002"||tasktag=="t15"||tasktag=="t0014"||tasktag=="t0023"||tasktag=="t0003"||tasktag=="t0015"||tasktag=="t0004"||tasktag=="t0005"||tasktag=="t0006"||tasktag=="sign0001"||tasktag=="t0007"||tasktag=="t0011"||tasktag=="t0024"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   
      
   
   
   
   var image = surface.createImage({height: 62,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow02.png'});
   image.setTransform(dojox.gfx.matrix.translate(760.0,210));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(750.0,271.0));
   var t=surface.createText ({x:750.0+iconWidth/2,y:271.0+iconHeight+12,text:'省业支复核',align:'middle'});
   t.setFill ('black');
   t.setFont ({family:'Arial',size:12});
   //var image = surface.createImage({height: 5,width: 90,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   //image.setTransform(dojox.gfx.matrix.translate(780.0,280.0));
   
   //箭头：
   var image = surface.createImage({height: 75,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow02.png'});
   image.setTransform(dojox.gfx.matrix.translate(760.0,300));

	//图片
   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(750.0,371.0));
   var t=surface.createText ({x:750.0+iconWidth/2,y:371.0+iconHeight+12,text:'市场部',align:'middle'});
   if(tasktag=="t0008"||tasktag=="t0009"||tasktag=="13"||tasktag=="21"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont ({family:'Arial',size:12});
   
   //箭头： translate(760.0,420))  760 宽，420 高
   var image = surface.createImage({height: 85,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow02.png'});
   image.setTransform(dojox.gfx.matrix.translate(760.0,420));
   
   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/finish.png'});
   image.setTransform(dojox.gfx.matrix.translate(750.0,500.0));
   var t=surface.createText ({x:750.0+iconWidth/2,y:500.0+iconHeight+12,text:'结束',align:'middle'});
   t.setFill ('black');
   t.setFont ({family:'Arial',size:12});
   
   //var image = surface.createImage({height: 7,width: 170,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow03.png'});


//   image.setTransform(dojox.gfx.matrix.translate(154,69.0));
	///////////////////////////////////////////////////////////////////////
   var image = surface.createImage({height: 85,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow02.png'});
   image.setTransform(dojox.gfx.matrix.translate(160.0,110));
   
   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(150.0,190.0));
   var t=surface.createText({x:150.0+iconWidth/2,y:190.0+iconHeight+12,text:' 地市(集客部)主任审批',align:'middle'});
   if(tasktag=="t0001"||tasktag=="t0002"||tasktag=="t15"||tasktag=="t0014"||tasktag=="t0023"||tasktag=="t0003"||tasktag=="t0015"||tasktag=="t0004"||tasktag=="t0005"||tasktag=="t0006"||tasktag=="sign0001"||tasktag=="t0007"||tasktag=="t0011"||tasktag=="t0024"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   
   var image = surface.createImage({height: 85,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow02.png'});
   image.setTransform(dojox.gfx.matrix.translate(160.0,230));
   
   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/condition.png'});
   image.setTransform(dojox.gfx.matrix.translate(150.0,310.0));
   var t=surface.createText({x:150.0+iconWidth/2,y:310.0+iconHeight+12,text:'自动判断',align:'middle'});
   if(tasktag=="t05" ||tasktag=="t09"||tasktag=="t10"||tasktag=="t11"||tasktag=="t12"||tasktag=="sign02"||tasktag=="sign03"){
	  t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   
   
   var image = surface.createImage({height: 85,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow02.png'});
   image.setTransform(dojox.gfx.matrix.translate(160.0,350));
   
   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(150.0,430.0));
   var t=surface.createText({x:150.0+iconWidth/2,y:430.0+iconHeight+12,text:' 市场部主任会签',align:'middle'});
   if(tasktag=="t0001"||tasktag=="t0002"||tasktag=="t15"||tasktag=="t0014"||tasktag=="t0023"||tasktag=="t0003"||tasktag=="t0015"||tasktag=="t0004"||tasktag=="t0005"||tasktag=="t0006"||tasktag=="sign0001"||tasktag=="t0007"||tasktag=="t0011"||tasktag=="t0024"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   
   var image = surface.createImage({height: 85,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow02.png'});
   image.setTransform(dojox.gfx.matrix.translate(160.0,460));	
   
   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(150.0,530.0));
   var t=surface.createText({x:150.0+iconWidth/2,y:530.0+iconHeight+12,text:' 集客部主任审核会签意见',align:'middle'});
   if(tasktag=="t0001"||tasktag=="t0002"||tasktag=="t15"||tasktag=="t0014"||tasktag=="t0023"||tasktag=="t0003"||tasktag=="t0015"||tasktag=="t0004"||tasktag=="t0005"||tasktag=="t0006"||tasktag=="sign0001"||tasktag=="t0007"||tasktag=="t0011"||tasktag=="t0024"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   
   
   var image = surface.createImage({height: 5,width: 98,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(170,545.0));
   

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/condition.png'});
   image.setTransform(dojox.gfx.matrix.translate(260,535.0));
   var t=surface.createText({x:260.0+iconWidth/2,y:535.0+iconHeight+12,text:'自动判断',align:'middle'});
   if(tasktag=="t05" ||tasktag=="t09"||tasktag=="t10"||tasktag=="t11"||tasktag=="t12"||tasktag=="sign02"||tasktag=="sign03"){
	  t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   
   
   var image = surface.createImage({height: 5,width: 98,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(290,545.0));

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(380.0,530.0));
   var t=surface.createText({x:380.0+iconWidth/2,y:530.0+iconHeight+12,text:' 发起人确认',align:'middle'});
   if(tasktag=="t0001"||tasktag=="t0002"||tasktag=="t15"||tasktag=="t0014"||tasktag=="t0023"||tasktag=="t0003"||tasktag=="t0015"||tasktag=="t0004"||tasktag=="t0005"||tasktag=="t0006"||tasktag=="sign0001"||tasktag=="t0007"||tasktag=="t0011"||tasktag=="t0024"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});

   var image = surface.createImage({height: 5,width: 98,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(410,545.0));
 
   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/finish.png'});
   image.setTransform(dojox.gfx.matrix.translate(500.0,530.0));
   var t=surface.createText({x:500.0+iconWidth/2,y:530.0+iconHeight+12,text:' 结束',align:'middle'});
   if(tasktag=="t0001"||tasktag=="t0002"||tasktag=="t15"||tasktag=="t0014"||tasktag=="t0023"||tasktag=="t0003"||tasktag=="t0015"||tasktag=="t0004"||tasktag=="t0005"||tasktag=="t0006"||tasktag=="sign0001"||tasktag=="t0007"||tasktag=="t0011"||tasktag=="t0024"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   
</script>
