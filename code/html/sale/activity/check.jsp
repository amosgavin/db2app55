<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>���</title>
</head>
<body>
<ai:tab id="activityTab" width="100%" type="h" height="100%">
   <ai:tabitem id="activity_1" title="" src="" />
   <ai:tabitem id="activity_2" title="" src=""/>
   <ai:tabitem id="activity_3" title="" src=""/>
   <ai:tabitem id="activity_4" title="" src=""/>
</ai:tab>
</body>

<script type="text/javascript">
var orderId = "<%=request.getParameter("recordId")%>";
var templateCode = "<%=request.getParameter("templateCode")%>";
if ("null" == templateCode || "" == templateCode){
    templateCode = "<%=request.getParameter("templateCode")%>";
}
var taskTag = "<%=request.getParameter("taskTag")%>";
var taskId = "<%=request.getParameter("taskId")%>";
var recordType = "<%=request.getParameter("recordType")%>";
var taskTemplateId = "<%=request.getParameter("taskTemplateId")%>";
var workflowId = "<%=request.getParameter("workflowId")%>";

resetTabitem(orderId,templateCode,taskTag,taskId,taskTemplateId,workflowId,recordType);
function resetTabitem(orderId,templateCode,taskTag,taskId,taskTemplateId,workflowId,recordType) {
    isNew = false;
    /*
     * if ("" == orderId || "null" == orderId || undefined == orderId){
        refreshTabItem("activityTab","activity_2","Ӫ�����Ҫ��Ϣ","check_main.jsp");
        refreshTabItem("activityTab","activity_3","������Ϣ ","check_detail.jsp");
        refreshTabItem("activityTab","activity_4","���������Ϣ","check_explan.jsp");
        refreshTabItem("activityTab","activity_1","�����Ҫ��Ϣ","check_overview.jsp");
    } else {
        refreshTabItem("activityTab","activity_2","Ӫ�����Ҫ��Ϣ","check_main.jsp?orderId=" + orderId);
        refreshTabItem("activityTab","activity_3","������Ϣ ","check_detail.jsp?orderId=" + orderId);
        refreshTabItem("activityTab","activity_4","���������Ϣ ","check_explan.jsp?orderId=" + orderId+ "&taskId=" + taskId);
        refreshTabItem("activityTab","activity_1","�����Ҫ��Ϣ","check_overview.jsp?orderId=" + orderId
                                                                    + "&templateCode=" + templateCode
                                                                    + "&taskTag=" + taskTag
                                                                    + "&taskId=" + taskId
                                                                    + "&recordType=" + recordType
                                                                    + "&taskTemplateId=" + taskTemplateId
                                                                    + "&workflowId=" + workflowId);
    }
    */
    if ("t08" == taskTag || "t07" == taskTag || "p01" == taskTag || "p12" == taskTag || "p102" == taskTag
    	|| "p21" == taskTag || "t0011" == taskTag || "t0015" == taskTag || "I007" == taskTag 
    	|| "I008" == taskTag || "zqs0005" == taskTag || "zqs0004" == taskTag || "t2004" == taskTag
    	|| "zqs0011" == taskTag || "zqs0010" == taskTag){
    	
	    refreshTabItem("activityTab","activity_1","��һ����Ӫ�����Ҫ��Ϣ��","new_main.jsp?orderId=" + orderId + "&editable=true");
    	refreshTabItem("activityTab","activity_2","�ڶ�����������Ϣ��","new_detail.jsp?orderId=" + orderId + "&editable=true");
	    refreshTabItem("activityTab","activity_3","�����������������Ϣ ��","new_explan.jsp?orderId=" + orderId+ "&taskId=" + taskId + "&editable=true");
	    refreshTabItem("activityTab","activity_4","���Ĳ���ȷ�ϼ��ύ��","check_overview.jsp?orderId=" + orderId 
	                                                                + "&editable=true"
                                                                    + "&templateCode=" + templateCode
                                                                    + "&taskTag=" + taskTag
                                                                    + "&taskId=" + taskId
                                                                    + "&recordType=" + recordType
                                                                    + "&taskTemplateId=" + taskTemplateId
                                                                    + "&workflowId=" + workflowId);
    } else {
    	if ("" == orderId || "null" == orderId || undefined == orderId){
    		orderId = "";
    	}
    	refreshTabItem("activityTab","activity_2","Ӫ�����Ҫ��Ϣ","new_main.jsp?orderId=" + orderId + "&taskTag=" + taskTag + "&editable=false");
        refreshTabItem("activityTab","activity_3","������Ϣ ","new_detail.jsp?orderId=" + orderId + "&editable=false");
        refreshTabItem("activityTab","activity_4","���������Ϣ ","new_explan.jsp?orderId=" + orderId+ "&taskId=" + taskId + "&editable=false");
        refreshTabItem("activityTab","activity_1","�����Ҫ��Ϣ","check_overview.jsp?orderId=" + orderId + "&editable=false"
                                                                    + "&templateCode=" + templateCode
                                                                    + "&taskTag=" + taskTag
                                                                    + "&taskId=" + taskId
                                                                    + "&recordType=" + recordType
                                                                    + "&taskTemplateId=" + taskTemplateId
                                                                    + "&workflowId=" + workflowId);
    }
    //isNew = false;
}
</script>
</html>