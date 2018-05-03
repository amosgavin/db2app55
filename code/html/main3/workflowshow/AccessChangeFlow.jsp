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
   var t=surface.createText({x:35.0+iconWidth/2,y:71.0+iconHeight+12,text:'��ʼ',align:'middle'});
   t.setFill ('black');
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 5,width: 95,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(65.0,81.0));


   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(154,69.0));
   var t=surface.createText({x:154+iconWidth/2,y:69.0+iconHeight+12,text:'�������ύ����',align:'middle'});
   t.setFill('black');
   t.setFont({family:'Arial',size:12});
   var image = surface.createImage({height: 5,width: 98,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(185,81.0));
   
   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(280.0,69.0));
   var t=surface.createText({x:280+iconWidth/2,y:69.0+iconHeight+12,text:'�����г�����������',align:'middle'});
   if(tasktag=="A01"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   var image = surface.createImage({height: 5,width: 115,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(308,81.0));
   var image = surface.createImage({height: 185,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow02.png'});
   image.setTransform(dojox.gfx.matrix.translate(290.0,100));


   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(420.0,68.0));
   var t=surface.createText ({x:420.0+iconWidth/2,y:68.0+iconHeight+12,text:'ʡ��˾�����˴���',align:'middle'});
   if(tasktag=="A03" ||tasktag=="A05" ||tasktag=="SA01"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 5,width: 125,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(450,81.0));
   var image = surface.createImage({height: 85,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow02.png'});
   image.setTransform(dojox.gfx.matrix.translate(430.0,100));


   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(570.0,70.0));
   var t=surface.createText({x:570.0+iconWidth/2,y:70.0+iconHeight+12,text:'ʡҵ֧���Ĵ���',align:'middle'});
   if(tasktag=="A04" ||tasktag=="A06"||tasktag=="A07"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   var image = surface.createImage({height: 185,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow02.png'});
   image.setTransform(dojox.gfx.matrix.translate(580.0,100));


   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(280,271.0));
   var t=surface.createText({x:280+iconWidth/2,y:271.0+iconHeight+12,text:' ����������ͨ�����ط�����',align:'middle'});
   if(tasktag=="A02"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});

   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(420.0,180.0));
   var t=surface.createText({x:420.0+iconWidth/2,y:180.0+iconHeight+12,text:' ʡ��˾������ͨ�����ط�����',align:'middle'});
   if(tasktag=="A09"){
	   t.setFill('red');
   }else{
	   t.setFill('black');
   }
   t.setFont({family:'Arial',size:12});
   var image = surface.createImage({height: 70,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow02.png'});
   image.setTransform(dojox.gfx.matrix.translate(430.0,210.0));


   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(570.0,271.0));
   var t=surface.createText ({x:570.0+iconWidth/2,y:271.0+iconHeight+12,text:'����ͨ�������ط�����',align:'middle'});
   t.setFill ('black');
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 7,width: 120,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow03.png'});
   image.setTransform(dojox.gfx.matrix.translate(305.0,280.0));
   
   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/user.png'});
   image.setTransform(dojox.gfx.matrix.translate(420.0,271.0));
   var t=surface.createText ({x:420.0+iconWidth/2,y:271.0+iconHeight+12,text:'������ȷ��',align:'middle'});
   t.setFill ('black');
   t.setFont ({family:'Arial',size:12});
   var image = surface.createImage({height: 7,width: 120,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow01.png'});
   image.setTransform(dojox.gfx.matrix.translate(305.0,280.0));
   var image = surface.createImage({height: 7,width: 120,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow03.png'});
   image.setTransform(dojox.gfx.matrix.translate(450.0,280.0));
   
   var image = surface.createImage({height: 75,width: 7,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/arrow02.png'});
   image.setTransform(dojox.gfx.matrix.translate(430.0,300.0));


   var image = surface.createImage({height: iconHeight,width: iconWidth,src: '<%=request.getContextPath() %>/workflow/images/light_icon_32/flow/task/finish.png'});
   image.setTransform(dojox.gfx.matrix.translate(420.0,373.0));
   var t=surface.createText ({x:420.0+iconWidth/2,y:373.0+iconHeight+12,text:'����',align:'middle'});
   t.setFill ('black');
   t.setFont ({family:'Arial',size:12});
</script>
