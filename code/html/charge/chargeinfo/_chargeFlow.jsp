<%@ page contentType="text/html; charset=GBK"%>
<%@page import="com.asiainfo.workflow.util.TaskUtil"%>
<%@page import="com.ai.comframe.vm.template.*"%>
<%@page import="com.ai.comframe.config.service.interfaces.*"%>
<%@page import="com.ai.appframe2.service.*"%>

<%@page import="com.asiainfo.workflow.util.bo.BOTaskRouteBean"%>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/jquery/jquery-1.8.3.js" type="text/javascript"></script>
<%
String taskTag  = request.getParameter("taskTag");
/*
String templateCode = "template.UniteChargeFlow";
String taskTemplateId = request.getParameter("taskTemplateId");
Long taskId ;
if(taskTemplateId.equals("")||taskTemplateId.equals("null")){
	taskId  = Long.valueOf("-1");
}else{
	taskId =Long.valueOf(taskTemplateId);
}

TaskTemplate[] taskTemplates = TaskUtil.getTaskTemplates(templateCode);
TaskTemplate task = TaskUtil.getTaskTemplate(taskId,taskTemplates);
String taskTag ;
if(task!=null){
	taskTag = task.getTaskTag();
}else{
	taskTag = null;
}

System.out.println(taskTag);*/
%>
<ai:contractframe id="flowFrame" contenttype="table" title="资费流程" width="100%" allowcontract="true" frameclosed="false" >
    <ai:contractitem></ai:contractitem>
<div class="flow_step_no1 " id='step_div'></div>
</ai:contractframe>
<script type="text/javascript">
/*流程的VALUE没停，先直接JSON写死，后期再从流程节点取*/
//省公司 //
var ProvinceMenuItems = 
[
    {
        "title": "开始", 
        "value": "1",
		"children": [
		    {
	                "title": "", 
	                "value": ""
	            }
	        ]       
    }, 
    {
        "title": "省公司市场部审批", 
        "value": "2",
		"children": [
		    {
	                "title": "省公司主办人发起会签", 
	                "value": "st1-ch7-m"
	            },
		    {
	                "title": "省公司主办人审核", 
	                "value": "st3-ch2-audit"
	            },{
	                "title": "省业支可行性评估", 
	                "value": "st3-ch1-est"
	            },{
	                "title": "省公司资费委员会会签", 
	                "value": "st3-ch3-sign"
	            },{
	                "title": "省公司市场部副总审核", 
	                "value": "st3-ch5-audit"
	            },{
	                "title": "省公司主办人修改", 
	                "value": "st3-ch4-m"
	            },{
	                "title": "省公司市场部总经理审核", 
	                "value": "st3-ch6-audit"
	            }
	        ] 
    }, 
    {
        "title": "省业支配置", 
        "value": "3",
		"children": [
		   {
	                "title": "省业支分派", 
	                "value": "st4-ch1-audit"
	            },
		    {
	                "title": "省业支人员配置测试", 
	                "value": "st4-ch2-conf"
	            },
		    {
	                "title": "省业支审核配置方案", 
	                "value": "st4-ch3-conf"
	            },
		    {
	                "title": "省业人员支配置测试", 
	                "value": "st4-ch4-conf"
	            },
		    {
	                "title": "省业支审核配置方案", 
	                "value": "st4-ch6-conf"
	            },
		    {
	                "title": "省业支人员配置测试", 
	                "value": "st4-ch5-conf"
	            }
	        ] 
    }, 
    {
        "title": "地市公司测试", 
        "value": "4",
		"children": [
		    {
	                "title": "发起人发起测试", 
	                "value": "st5-ch1-m"
	            },{
	                "title": "省业支审核测试报告", 
	                "value": "st5-ch3-test"
	            },{
	                "title": "地市公司测试", 
	                "value": "st5-ch4-test"
	            },{
	                "title": "地市公司测试", 
	                "value": "st5-ch2-test"
	            },{
	                "title": "发起人资费上线观察", 
	                "value": "st6-ch2-audit"
	            }
	        ] 
    }, 
    {
        "title": "上线观察", 
        "value": "5",
		"children": [
		    {
	                "title": "发起人资费上线观察", 
	                "value": "st6-ch2-audit"
	            }
	        ] 
    }, 
    {
        "title": "结束", 
        "value": "6",
		"children": [
		    {
	                "title": "", 
	                "value": ""
	            }
	        ] 
    }
];
////////////地市////////////
var areaMenuItems=
[
    {
        "title": "开始", 
        "value": "1",
		"children": [
		    {
	                "title": "", 
	                "value": ""
	            }
	        ]       
    }, 
    {
        "title": "地市审核", 
        "value": "2",
		"children": [
	            {
	                "title": "发起人修改", 
	                "value": "st1-ch5-m"
	            }, 
	            {
	                "title": "发起人修改/结束流程", 
	                "value": "st1-ch6-m"
	            }, 
	            {
	                "title": "地市资费委员会会签", 
	                "value": "st2-ch1-sign"
	            },{
	                "title": "地市部门经理审核", 
	                "value": "st2-ch3-audit"
	            },{
	                "title": "地市副总审核", 
	                "value": "st2-ch4-audit"
	            },{
	                "title": "地市总经理审核", 
	                "value": "st2-ch6-audit"
	            }
	        ]    
    }, 
    {
        "title": "省公司市场部审批", 
        "value": "3",
		"children": [
		    {
	                "title": "省公司主办人发起会签", 
	                "value": "st1-ch7-m"
	            },
		    {
	                "title": "省公司主办人审核", 
	                "value": "st3-ch2-audit"
	            },{
	                "title": "省业支可行性评估", 
	                "value": "st3-ch1-est"
	            },{
	                "title": "省公司资费委员会会签", 
	                "value": "st3-ch3-sign"
	            },{
	                "title": "省公司市场部副总审核", 
	                "value": "st3-ch5-audit"
	            },{
	                "title": "省公司主办人修改", 
	                "value": "st3-ch4-m"
	            },{
	                "title": "省公司市场部总经理审核", 
	                "value": "st3-ch6-audit"
	            }
	        ] 
    }, 
    {
        "title": "省业支配置", 
        "value": "4",
		"children": [
		   {
	                "title": "省业支分派", 
	                "value": "st4-ch1-audit"
	            },
		    {
	                "title": "省业支人员配置测试", 
	                "value": "st4-ch2-conf"
	            },
		    {
	                "title": "省业支审核配置方案", 
	                "value": "st4-ch3-conf"
	            },
		    {
	                "title": "省业人员支配置测试", 
	                "value": "st4-ch4-conf"
	            },
		    {
	                "title": "省业支审核配置方案", 
	                "value": "st4-ch6-conf"
	            },
		    {
	                "title": "省业支人员配置测试", 
	                "value": "st4-ch5-conf"
	            }
	        ] 
    }, 
    {
        "title": "地市公司测试", 
        "value": "5",
		"children": [
		    {
	                "title": "发起人发起测试", 
	                "value": "st5-ch1-m"
	            },{
	                "title": "省业支审核测试报告", 
	                "value": "st5-ch3-test"
	            },{
	                "title": "地市公司测试", 
	                "value": "st5-ch4-test"
	            },{
	                "title": "地市公司测试", 
	                "value": "st5-ch2-test"
	            },{
	                "title": "发起人资费上线观察", 
	                "value": "st6-ch2-audit"
	            }
	        ] 
    }, 
    {
        "title": "上线观察", 
        "value": "6",
		"children": [
		    {
	                "title": "发起人资费上线观察", 
	                "value": "st6-ch2-audit"
	            }
	        ] 
    }, 
    {
        "title": "结束", 
        "value": "7",
		"children": [
		    {
	                "title": "", 
	                "value": ""
	            }
	        ] 
    }
];

 var orgId = g_GetUserInfo().ORG_ID.substr(0,2);
 if (orgId.substr(0,2) == "10") {
	 menuItems = ProvinceMenuItems;
 }else{
	 menuItems = areaMenuItems;
 }
 
var _flowStep = $("<div class=flow_step id ='flow_step'></div>");
 _flowStep.appendTo("#step_div");
var _ol = $("<ol class=cols7 id='col'></ol>");
_ol.appendTo("#flow_step");
for(var i=0;i<menuItems.length;i++){
	_ol.append("<li class=step_"+menuItems[i].value+">"+menuItems[i].value+"."+menuItems[i].title+" </li>");
}
var taskTag = "<%=taskTag%>";
for(var i=0;i<menuItems.length;i++){
	for(var j=0;j<menuItems[i].children.length;j++){
		if(taskTag!=""&&taskTag==menuItems[i].children[j].value){
			currentStep(parseInt(menuItems[i].value));
			break;
		}
	}
}

function currentStep(step)
{
	document.getElementById('step_div').className='flow_step_no'+step;
}
	/*st1-ch5-m;//发起人修改
	 * st1-ch6-m;//发起人修改/结束流程
	 * st1-ch7-m//省公司主办人发起会签
	st2-ch1-sign;//地市资费委员会会签
	st2-ch3-audit;//地市部门经理审核
	st2-ch4-audit;//地市副总审核
	st2-ch6-audit;//地市总经理审核
	st3-ch2-audit;//省公司主办人审核
	st3-ch1-est;//省业支可行性评估
	st3-ch3-sign;//省公司资费委员会会签
	st3-ch5-audit;//省公司市场部副总审核
	st3-ch4-m;//省公司主办人修改
	st3-ch6-audit;//省公司市场部总经理审核
	st4-ch1-audit;//省业支分派
	st4-ch2-conf;//省业支人员配置测试
	st4-ch3-conf;//省业支审核配置方案
	st4-ch4-conf;//省业人员支配置测试
	st4-ch6-conf;//省业支审核配置方案
	st4-ch5-conf;//省业支人员配置测试
	st5-ch1-m;//发起人发起测试
	st5-ch3-test;//省业支审核测试报告
	st5-ch4-test;//地市公司测试
	st5-ch2-test;//地市公司测试
	st6-ch2-audit;//发起人资费上线观察
	*/


</script>
