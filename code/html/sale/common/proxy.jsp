<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>湖北移动公司营销管理系统</title>
</head>
<body onload="proxy.initPage();">
<ai:contractframe id="proxy_frame1" contenttype="table" title="上级代理" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
    <ai:table
        tableid="proxy_table"
        setname="com.asiainfo.sale.common.web.SETProxyShow"
        tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
        implservice_name="com.asiainfo.sale.common.service.interfaces.IProxySV"
        implservice_querymethod="getParentProxyValue(String proxyerId)"
        implservice_countmethod="getParentProxyValueCount(String proxyerId)"
        ondbclick=""
        initial="false"  multiselect="false"
        pagesize="5" editable="false" width="100%"
        height="100" needrefresh="true">
        <ai:col title="AUTHOR_STAFF_ID" fieldname="AUTHOR_STAFF_ID" visible="false"/>
        <ai:col title="上级代理人" fieldname="AUTHOR_NAME" width="90" visible="true"/>
        <ai:col title="上级代理人机构" fieldname="AUTHOR_ORGANIZE_NAME_P" width="130" visible="true"/>
        <ai:col title="上级代理人组织" fieldname="AUTHOR_ORGANIZE_NAME" width="180" visible="true"/>
        <ai:col title="上级代理类型" fieldname="M_FLAG" width="100" visible="true"/>
        <ai:col title="上级代理时间" fieldname="PROXY_DATE" width="120" visible="true"/>
    </ai:table>
</ai:contractframe>
<ai:contractframe id="proxy_frame" contenttype="table" title="下级代理" width="100%" allowcontract="true" frameclosed="fale">
    <ai:contractitem/>
    <ai:dbform formid="proxy_form"
            setname="com.asiainfo.sale.common.web.SETProxyShow"
            conditionname="condition" parametersname="parameters"
            editable="true" initial="false"
            datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
            implservice_name="com.asiainfo.sale.common.service.interfaces.IProxySV"
            implservice_querymethod="getNextProxyValue(String proxyerId)">
            <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
            <tr>
                <td class="td_font">下级代理人：</td>
                <td><ai:dbformfield formid="proxy_form" fieldname="PROXY_NAME" width="100" editable="false"/><img id="proxy_bt_selectStaff" border="0" src="<%=request.getContextPath()%>/webframe/images/query.gif" onClick="proxy.selectStaff()" align="absmiddle" style="cursor:hand;"/><span class="font_red">*</span>
                <ai:dbformfield formid="proxy_form" fieldname="PROXY_STAFF_ID" visible="false"/></td>
            </tr>
            <tr>
                <td class="td_font">下级代理人机构：</td>
                <td><ai:dbformfield formid="proxy_form" fieldname="PROXY_ORGANIZE_NAME_P" width="150" editable="false"/>
                <td class="td_font">下级代理人组织：</td>
                <td><ai:dbformfield formid="proxy_form" fieldname="PROXY_ORGANIZE_NAME" width="150" editable="false"/></td>
            </tr>
            <tr>
                <td class="td_font">下级代理类型：</td>
                <td><ai:dbformfield formid="proxy_form" fieldname="M_FLAG" width="150" editable="true"/>
                <td class="td_font">下级代理时间：</td>
                <td><ai:dbformfield formid="proxy_form" fieldname="PROXY_DATE" width="150" editable="false"/></td>
            </tr>
            </table>
    </ai:dbform>
</ai:contractframe>
<div class="area_button">
    <ai:button text="取消代理" id="proxy_bt_delProxy" onclick="proxy.delProxy()" />&nbsp;&nbsp;<ai:button text="设置代理" id="proxy_bt_addProxy" onclick="proxy.setProxy()" />
</div>
</body>
</html>
<ai:loginuser/>
<script language="javascript" src="<%=request.getContextPath()%>/sale/common/js/openSelect.js"></script>
<script type="text/javascript">
var proxy = {};
proxy.tableRowSet = g_TableRowSetManager.get("proxy_table");
proxy.formRowSet = g_FormRowSetManager.get("proxy_form");
proxy.initPage = function() {
	var proxyerId = g_GetUserInfo().STAFF_ID;
	proxy.tableRowSet.refresh("proxyerId=" + proxyerId);
    proxy.formRowSet.refresh("proxyerId=" + proxyerId);
    
    if("" == proxy.formRowSet.getValue("PROXY_STAFF_ID")){
    	g_AIButtonManager.get("proxy_bt_delProxy").setDisabled(true);
    	proxy.formRowSet.setFocus("M_FLAG");
        proxy.formRowSet.setFocus("PROXY_STAFF_ID");
    } else {
        g_AIButtonManager.get("proxy_bt_addProxy").setDisabled(true);
        proxy.formRowSet.setEditSts(false);
        document.getElementById("proxy_bt_selectStaff").style.display = "none";
    }
}

proxy.selectStaff = function() {
    var result = openSelect.staffSelect("tsd",'10',g_GetUserInfo().ORG_ID);
    if(result != null){
        var operatorId;
        var name;
        var orgName;
        var orgNameP;
        for(var i=0;i < result.elements.length;i++)
        {
            if (i == 0)
            {
                operatorId = result.elements[i].operatorId;
                name = result.elements[i].name;
                orgName = result.elements[i].orgName;
                orgNameP = result.elements[i].orgNameP;
            } else {
                operatorId = operatorId + ";" + result.elements[i].operatorId;
                name = name + ";" + result.elements[i].name;
                orgName = orgName + ";" + result.elements[i].orgName;
                orgNameP = orgNameP + ";" + result.elements[i].orgNameP;
            }
        }
        proxy.formRowSet.setValue("PROXY_NAME", name); 
        proxy.formRowSet.setValue("PROXY_STAFF_ID", operatorId); 
        proxy.formRowSet.setValue("PROXY_ORGANIZE_NAME", orgName); 
        proxy.formRowSet.setValue("PROXY_ORGANIZE_NAME_P", orgNameP); 
    }
} 
  
proxy.setProxy = function (){
    var proxyerId = proxy.formRowSet.getValue("PROXY_STAFF_ID");
    var mFlag = proxy.formRowSet.getValue("M_FLAG");
    if (null == proxyerId || "" == proxyerId)
    {
        return alert("请选择下级代理人");
    }
    
    var strUrl = "<%=request.getContextPath()%>/business/com.asiainfo.sale.common.web.ProxyAction?action=setProxy&proxyerId="+proxyerId + "&mFlag="+mFlag;      
    
    var recode = PostInfo(strUrl);
    if ("Y" == recode.getValueByName("FLAG"))
    {
        alert("代理设置成功");
        window.location.reload();
    } else {
        alert(recode.getValueByName("MESSAGE"));
    }
}
  
proxy.delProxy = function (){
    var strUrl = "<%=request.getContextPath()%>/business/com.asiainfo.sale.common.web.ProxyAction?action=delProxy";      
    
    var recode = PostInfo(strUrl);
    if ("Y" == recode.getValueByName("FLAG"))
    {
        alert("代理取消成功");
        window.location.reload();
    } else {
        alert(recode.getValueByName("MESSAGE"));
    }
}
</script>