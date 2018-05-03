<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<script src="<%=request.getContextPath()%>/jsv2/TabPage.js"></script>
<script src="<%=request.getContextPath()%>/jsv2/HtmlParameter.js"></script>
	<script type="text/javascript">
	var _descCodeToRule="";
	var _descCodeToRel="";
	var _descNameToRel="";
	function getParameter(itemId){
	var s=Math.random()*10000;
	//var a=document.all("main_tab");
	//var b=document.getElementById("main_tab").height;
	if (itemId==2){
	//alert(self.location.toString());
	
		_descCodeToRel=self.main_tab_1.queryDescCode();
		_descNameToRel=self.main_tab_1.queryDescName();
		var aUrl="desc2="+_descCodeToRel+"&descname="+_descNameToRel+"&rand="+s;
		return aUrl;
	}
	
	if (itemId==3){
		_descCodeToRule=self.main_tab_1.queryDescCode();
		var aUrl="desc="+_descCodeToRule+"&rand="+s;
		return aUrl;
		//    refreshTabItem("main_tab",itemId,null,aUrl);
		}
	}
	function switchTab1(){
		setTabItem("main_tab","1");
	}
	
	/* 也可以用window onload事件绑定事件监听函数
	function a(){
		var tem=document.getElementById("main_tab_Title_1");
		tem.onclick=function(){
		alert("a");
		}
	}
	*/
	</script>
<html>
	<head>
	</head>
	<body >
	<ai:tab id="main_tab" height="100%" width="100%"  type="H" getParameter="getParameter" >
		    <ai:tabitem id="1" src="ExceptionDescMaintain.jsp" title="comframe.html.workflow.exception.exceptionDescMaintain9" i18nRes="i18n.comframe_resource"  initial="true" ></ai:tabitem>		    
		    <ai:tabitem id="2" src="ExceptionCodeDescRelation.jsp" title="comframe.html.workflow.exception.exceptionmaintain55"  i18nRes="i18n.comframe_resource" ></ai:tabitem>	  		
		    <ai:tabitem id="3" src="ExceptionRuleMaintain.jsp" title="comframe.html.workflow.exception.exceptionmaintain56" i18nRes="i18n.comframe_resource" ></ai:tabitem>	  		
	</ai:tab>
	</body>	
</html>
