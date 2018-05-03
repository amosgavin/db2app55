<%@ page language="java" pageEncoding="GBK"%> 
<%@ include file="/workflow/common/WorkflowHead.jsp"%>
<%
	String workflow_id =request.getParameter("workflow_id");
  	String template_id = request.getParameter("template_id");
  	String task_tag = request.getParameter("task_tag");
  	String regionID = request.getParameter("regionID");
  	String sdate	= request.getParameter("sdate");
  	if(regionID==null||regionID.length()==0){
  		regionID="";
  	}
  %>
<html>
  <head>
    <title><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.GoBackTask18"></i18n:message></title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body onload="init()" scroll="yes">
    <div id="instDiv" align="center" style="display: none;">
    <ai:contractframe  width="100%"  title="comframe.html.workflow.SvgView35" id="comframe.html.workflow.SvgView35" i18nRes="i18n.comframe_resource">
     <ai:contractitem></ai:contractitem>
           <ai:table tableid="workflowTable" setname="com.ai.comframe.config.set.SETVmWF"
                    tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
                    implservice_name="com.ai.comframe.config.service.interfaces.IWorkflowConsoleSV"
                    implservice_querymethod="queryHisChildWorkflow(String taskId,int $STARTROWINDEX,int $ENDROWINDEX,String sdate)"
                    implservice_countmethod="queryHisChildWorkflowCount(String taskId,String sdate)"
					onlyquery="true" width="100%" height="80" pagesize="5" onrowchange="showChildSVG" ondbclick="showChildSVG"
					needrefresh="true" multiselect="false" initial="false" editable="false" >
          		<ai:col fieldname="WORKFLOW_ID" width="100" visible="true" />
				<ai:col fieldname="LABEL" width="120" visible="true" />
				<ai:col fieldname="TEMPLATE_TAG" width="165" visible="true" />
				<ai:col fieldname="WORKfLOW_OBJECT_ID" width="100" visible="true" />
				<ai:col fieldname="WORKFLOW_OBJECT_TYPE" width="100" visible="true" />
				<ai:col fieldname="QUEUE_ID" width="100" visible="true" />
				<ai:col fieldname="STATE" width="100" visible="true" />
				<ai:col fieldname="CREATE_DATE" width="150" visible="true" />
				<ai:col fieldname="STATE_DATE" width="150" visible="true" />
				<ai:col fieldname="CURRENT_TASK_ID" width="165" visible="true" />
				<ai:col fieldname="CREATE_STAFF_ID" width="165" visible="true" />
				<ai:col fieldname="VARS" width="200" visible="false" />
				<ai:col fieldname="ERROR_MESSAGE" width="165" visible="false" />
				<ai:col fieldname="ENGINE_WORKFLOW_ID" width="165" visible="true" />
				<ai:col fieldname="ENGINE_TYPE" width="165" visible="true" />
	      		<ai:col fieldname="PARENT_TASK_ID" width="100" visible="true" />
        </ai:table>
   </ai:contractframe>
    </div>    
  	<div id="btnDiv1" align="right" style="display:none" > 
  	<ai:button i18nRes="i18n.comframe_resource" text="comframe.html.workflow.GoBackTask34" onclick="goBack()"/></div> 
  	<div style="width:100%;height:80%; position:relative;">	
	  	<div id="graphDiv" style="position: absolute;"></div>
	  	<div id="graphDiv1"  style="position: absolute;"></div>
	</div>
	  	<div id="btnDiv2" align="right" style="display:none" >
  	<ai:button i18nRes="i18n.comframe_resource"  text="comframe.html.workflow.GoBackTask34" onclick="goBack()"/></div>  	
  	
  	<ai:contractframe width="100%" height="100%" i18nRes="i18n.comframe_resource" title="comframe.html.workflow.SvgView84" id="comframe.html.workflow.SvgView72FRAM" frameclosed="true">
  	<ai:contractitem>
  		<div class="t-bot-mc-word"><span class="font_red"><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.Alarm87"></i18n:message></span><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.SvgView85"/></div>
  	</ai:contractitem>
  	<table id="tblInfo" width="98%" cellspacing="2" cellpadding="1" border="0" >
  	<tr>
  	<TD> 
    <b>1.<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.SvgView74"></i18n:message></b><br>        
    <i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.SvgView75_1"></i18n:message> 
    <a href="SVGView.exe" ><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.SvgView75_2"></i18n:message></a><br>       
     <i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.SvgView76"></i18n:message>.</TD></TR>
    <TR><TD> 
    <b>2.<i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.SvgView78"></i18n:message></b><br>        
	    <i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.SvgView79_1"></i18n:message> 
	    <a href="ARIALUNI.TTF" ><i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.SvgView79_2"></i18n:message></a><br>        
	    <i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.SvgView80"></i18n:message>。<br>        
	    <i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.SvgView81"></i18n:message>。<br>        
	    <i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.SvgView82"></i18n:message>。<br>        
	    <i18n:message res="i18n.comframe_resource"  key="comframe.html.workflow.SvgView83"></i18n:message>。<br>    
	    </TD></TR>
  	</table>
  	</ai:contractframe>
  </body>
</html>
<script type="text/javascript">
function getTbl(){
  return g_TableRowSetManager.get("workflowTable");
}

function init(){
	var workflow_id="<%=workflow_id %>";
	var template_id = "<%=template_id%>";
	var task_tag = "<%=task_tag%>";
  var url = "<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?";
  if(isBlank(workflow_id) == false){
    url += "action=hisworkflowInst2Svg&workflow_id=" + workflow_id+getCenterStr('<%=regionID%>');
  }
  else{
    url += "action=template2Svg&template_id=" + template_id + "&task_tag="+task_tag;
  }
  showSVG(url);
}

function onSvgClick(taskTemplateId,taskLabel,taskId,childCode,taskType,state,taskTag){
 	var workflow_id="<%=workflow_id%>";
	var template_id = "<%=template_id%>";
	if(isBlank(childCode) == false){
		
	  //流程实例
	  if(isBlank(workflow_id) == false && isBlank(taskId) == false){
		  var isProcessUrl = "<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?"
	            + "action=isProcess&workflowCode="+childCode+getCenterStr('<%=regionID%>')+"&sdate=<%=sdate%>";
	        var result = PostInfo(isProcessUrl);
	        if("Y"==result.getValueByName("FLAG")){
		        //不能查询Process的实例化流程图！
	            //alert(g_I18NMessage("comframe_resources","comframe_html_workflow_svgview_cannotviewinschat"));
	            return;
	        }
	    //查询出全部子流程
		  getTbl().refresh("taskId="+taskId+"&sdate=<%=sdate%>");
		  if(getTbl().count() > 1){
	    	document.all.instDiv.style.display = "block";
		  	document.all.tblInfo.style.display = "none";
		  	document.all.btnDiv1.style.display = "block";
		  	//document.all("graphDiv").innerHTML ="";
		  	//document.all("graphDiv1").innerHTML
		  	showSVG("");
		    return;
		  }
		  else{
		    //如果只有一个子流程实例则直接显示
		    document.all.instDiv.style.display = "none";
			  document.all.tblInfo.style.display = "none";
			  document.all.btnDiv1.style.display = "none";
			  document.all.btnDiv2.style.display = "block";
			  //var workflowId = getTbl().getValue(0,"TASK_ID");
			  var workflowId = getTbl().getValue(0,"WORKFLOW_ID");
  			var url = "<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?"
		            + "action=hisworkflowInst2Svg&workflow_id="+workflowId+getCenterStr('<%=regionID%>')+"&sdate=<%=sdate%>";
			  showSVG(url);
			  return;
		  }
		}
		//流程模板，尚未执行到该子流程节点，该子流程节点未创建出子流程
//		else{
		  document.all.instDiv.style.display = "none";
		  document.all.tblInfo.style.display = "none";
		  document.all.btnDiv1.style.display = "none";
		  document.all.btnDiv2.style.display = "block";
		  
		  var url = "<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?"
		      + "action=template2Svg&template_id=-1&task_tag="+childCode+getCenterStr('<%=regionID%>');
		  showSVG(url);
//		}
	}
}

function showParentSVG(parentWorkflowId){
  var url = "<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?"
		      + "action=hisworkflowInst2Svg&workflow_id="+parentWorkflowId+getCenterStr('<%=regionID%>')+"&sdate=<%=sdate%>";
	showSVG(url);
}

function showChildSVG(){
  var rowIndex = getTbl().getRow();
  var workflowId = getTbl().getValue(rowIndex,"TASK_ID");
  var url = "<%=request.getContextPath()%>/business/com.ai.comframe.config.action.WorkflowAction?"
		      + "action=hisworkflowInst2Svg&workflow_id="+workflowId+getCenterStr('<%=regionID%>')+"&sdate=<%=sdate%>";
	showSVG(url);
}
var currdiv="currdiv";
var oldleft="20px";
function showSVG(url){
	var s = "<object type='image/svg+xml' width='650' height='500'>"
                          + "<param name='src' value='" + url + "'/>"
                          + "</object>";
                    
	if(currdiv=="currdiv"){	
		document.all("graphDiv").style.left=oldleft;	
		document.all("graphDiv").innerHTML ="";		
		document.all("graphDiv").innerHTML = s;
		document.all("graphDiv1").style.left=-10000;
		currdiv="currdiv1";
	}else{
		document.all("graphDiv1").style.left=oldleft;
  		document.all("graphDiv1").innerHTML ="";
		document.all("graphDiv1").innerHTML = s;
		document.all("graphDiv").style.left=-10000;

		currdiv="currdiv";
	}
}

function goBack(){
  location.reload();
}


</script>
