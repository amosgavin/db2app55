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
<ai:contractframe id="flowFrame" contenttype="table" title="�ʷ�����" width="100%" allowcontract="true" frameclosed="false" >
    <ai:contractitem></ai:contractitem>
<div class="flow_step_no1 " id='step_div'></div>
</ai:contractframe>
<script type="text/javascript">
/*���̵�VALUEûͣ����ֱ��JSONд���������ٴ����̽ڵ�ȡ*/
//ʡ��˾ //
var ProvinceMenuItems = 
[
    {
        "title": "��ʼ", 
        "value": "1",
		"children": [
		    {
	                "title": "", 
	                "value": ""
	            }
	        ]       
    }, 
    {
        "title": "ʡ��˾�г�������", 
        "value": "2",
		"children": [
		    {
	                "title": "ʡ��˾�����˷����ǩ", 
	                "value": "st1-ch7-m"
	            },
		    {
	                "title": "ʡ��˾���������", 
	                "value": "st3-ch2-audit"
	            },{
	                "title": "ʡҵ֧����������", 
	                "value": "st3-ch1-est"
	            },{
	                "title": "ʡ��˾�ʷ�ίԱ���ǩ", 
	                "value": "st3-ch3-sign"
	            },{
	                "title": "ʡ��˾�г����������", 
	                "value": "st3-ch5-audit"
	            },{
	                "title": "ʡ��˾�������޸�", 
	                "value": "st3-ch4-m"
	            },{
	                "title": "ʡ��˾�г����ܾ������", 
	                "value": "st3-ch6-audit"
	            }
	        ] 
    }, 
    {
        "title": "ʡҵ֧����", 
        "value": "3",
		"children": [
		   {
	                "title": "ʡҵ֧����", 
	                "value": "st4-ch1-audit"
	            },
		    {
	                "title": "ʡҵ֧��Ա���ò���", 
	                "value": "st4-ch2-conf"
	            },
		    {
	                "title": "ʡҵ֧������÷���", 
	                "value": "st4-ch3-conf"
	            },
		    {
	                "title": "ʡҵ��Ա֧���ò���", 
	                "value": "st4-ch4-conf"
	            },
		    {
	                "title": "ʡҵ֧������÷���", 
	                "value": "st4-ch6-conf"
	            },
		    {
	                "title": "ʡҵ֧��Ա���ò���", 
	                "value": "st4-ch5-conf"
	            }
	        ] 
    }, 
    {
        "title": "���й�˾����", 
        "value": "4",
		"children": [
		    {
	                "title": "�����˷������", 
	                "value": "st5-ch1-m"
	            },{
	                "title": "ʡҵ֧��˲��Ա���", 
	                "value": "st5-ch3-test"
	            },{
	                "title": "���й�˾����", 
	                "value": "st5-ch4-test"
	            },{
	                "title": "���й�˾����", 
	                "value": "st5-ch2-test"
	            },{
	                "title": "�������ʷ����߹۲�", 
	                "value": "st6-ch2-audit"
	            }
	        ] 
    }, 
    {
        "title": "���߹۲�", 
        "value": "5",
		"children": [
		    {
	                "title": "�������ʷ����߹۲�", 
	                "value": "st6-ch2-audit"
	            }
	        ] 
    }, 
    {
        "title": "����", 
        "value": "6",
		"children": [
		    {
	                "title": "", 
	                "value": ""
	            }
	        ] 
    }
];
////////////����////////////
var areaMenuItems=
[
    {
        "title": "��ʼ", 
        "value": "1",
		"children": [
		    {
	                "title": "", 
	                "value": ""
	            }
	        ]       
    }, 
    {
        "title": "�������", 
        "value": "2",
		"children": [
	            {
	                "title": "�������޸�", 
	                "value": "st1-ch5-m"
	            }, 
	            {
	                "title": "�������޸�/��������", 
	                "value": "st1-ch6-m"
	            }, 
	            {
	                "title": "�����ʷ�ίԱ���ǩ", 
	                "value": "st2-ch1-sign"
	            },{
	                "title": "���в��ž������", 
	                "value": "st2-ch3-audit"
	            },{
	                "title": "���и������", 
	                "value": "st2-ch4-audit"
	            },{
	                "title": "�����ܾ������", 
	                "value": "st2-ch6-audit"
	            }
	        ]    
    }, 
    {
        "title": "ʡ��˾�г�������", 
        "value": "3",
		"children": [
		    {
	                "title": "ʡ��˾�����˷����ǩ", 
	                "value": "st1-ch7-m"
	            },
		    {
	                "title": "ʡ��˾���������", 
	                "value": "st3-ch2-audit"
	            },{
	                "title": "ʡҵ֧����������", 
	                "value": "st3-ch1-est"
	            },{
	                "title": "ʡ��˾�ʷ�ίԱ���ǩ", 
	                "value": "st3-ch3-sign"
	            },{
	                "title": "ʡ��˾�г����������", 
	                "value": "st3-ch5-audit"
	            },{
	                "title": "ʡ��˾�������޸�", 
	                "value": "st3-ch4-m"
	            },{
	                "title": "ʡ��˾�г����ܾ������", 
	                "value": "st3-ch6-audit"
	            }
	        ] 
    }, 
    {
        "title": "ʡҵ֧����", 
        "value": "4",
		"children": [
		   {
	                "title": "ʡҵ֧����", 
	                "value": "st4-ch1-audit"
	            },
		    {
	                "title": "ʡҵ֧��Ա���ò���", 
	                "value": "st4-ch2-conf"
	            },
		    {
	                "title": "ʡҵ֧������÷���", 
	                "value": "st4-ch3-conf"
	            },
		    {
	                "title": "ʡҵ��Ա֧���ò���", 
	                "value": "st4-ch4-conf"
	            },
		    {
	                "title": "ʡҵ֧������÷���", 
	                "value": "st4-ch6-conf"
	            },
		    {
	                "title": "ʡҵ֧��Ա���ò���", 
	                "value": "st4-ch5-conf"
	            }
	        ] 
    }, 
    {
        "title": "���й�˾����", 
        "value": "5",
		"children": [
		    {
	                "title": "�����˷������", 
	                "value": "st5-ch1-m"
	            },{
	                "title": "ʡҵ֧��˲��Ա���", 
	                "value": "st5-ch3-test"
	            },{
	                "title": "���й�˾����", 
	                "value": "st5-ch4-test"
	            },{
	                "title": "���й�˾����", 
	                "value": "st5-ch2-test"
	            },{
	                "title": "�������ʷ����߹۲�", 
	                "value": "st6-ch2-audit"
	            }
	        ] 
    }, 
    {
        "title": "���߹۲�", 
        "value": "6",
		"children": [
		    {
	                "title": "�������ʷ����߹۲�", 
	                "value": "st6-ch2-audit"
	            }
	        ] 
    }, 
    {
        "title": "����", 
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
	/*st1-ch5-m;//�������޸�
	 * st1-ch6-m;//�������޸�/��������
	 * st1-ch7-m//ʡ��˾�����˷����ǩ
	st2-ch1-sign;//�����ʷ�ίԱ���ǩ
	st2-ch3-audit;//���в��ž������
	st2-ch4-audit;//���и������
	st2-ch6-audit;//�����ܾ������
	st3-ch2-audit;//ʡ��˾���������
	st3-ch1-est;//ʡҵ֧����������
	st3-ch3-sign;//ʡ��˾�ʷ�ίԱ���ǩ
	st3-ch5-audit;//ʡ��˾�г����������
	st3-ch4-m;//ʡ��˾�������޸�
	st3-ch6-audit;//ʡ��˾�г����ܾ������
	st4-ch1-audit;//ʡҵ֧����
	st4-ch2-conf;//ʡҵ֧��Ա���ò���
	st4-ch3-conf;//ʡҵ֧������÷���
	st4-ch4-conf;//ʡҵ��Ա֧���ò���
	st4-ch6-conf;//ʡҵ֧������÷���
	st4-ch5-conf;//ʡҵ֧��Ա���ò���
	st5-ch1-m;//�����˷������
	st5-ch3-test;//ʡҵ֧��˲��Ա���
	st5-ch4-test;//���й�˾����
	st5-ch2-test;//���й�˾����
	st6-ch2-audit;//�������ʷ����߹۲�
	*/


</script>
