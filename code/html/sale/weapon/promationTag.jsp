<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>标识选择</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body>
<table>
	<tr align = "left">
        <td>货品价值:</td>
        <td align = "center"><input type="text" id="fee" />
		<ai:button id="queryTag" text="搜索" onclick="queryTagbyCharge()"/></td>
	</tr>
</table>
<ai:contractframe id="tagDetailTab" contenttype="table" title="促销标识信息" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem/>
	<ai:table setname="com.asiainfo.sale.tag.web.SETPromationTag"
			tableid="tagDetailTab"  editable="false"  ondbclick="getTagDetailReturn" 
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			needrefresh="true" pagesize="14" initial="false" width="100%"
			implservice_name="com.asiainfo.sale.tag.service.interfaces.ITagDetailSV"
			implservice_querymethod="queryTagDetail(String charge,String tagType,String month,String orgid, int $STARTROWINDEX, int $ENDROWINDEX)"
			implservice_countmethod="getTagDetailCount(String charge,String tagType,String month,String orgid)" >
            <ai:col  title="BOSS编号" fieldname="ID" width="200" editable="false" visible="true"/>	
            <ai:col title="BOSS标识" fieldname="TAG_CODE" width="200" editable="false" visible="true"/>
            <ai:col title="BOSS名称" fieldname="NAME" width="200" editable="false" visible="true"/>	
            <ai:col title="货品价值" fieldname="CHARGE" width="200" editable="false" visible="true" /> 
            <ai:col title="货品指导价" fieldname="SUMCHARGE" width="200" editable="false" visible="true"/>	
            <ai:col title="BOSS类型" fieldname="TAG_TYPE" width="200" editable="false" visible="false"/>
            <ai:col title="BOSS状态" fieldname="STATE" width="200" editable="false" visible="true"/>	
	</ai:table>
</ai:contractframe>


<script type="text/javascript">
var TagDetailTable = g_TableRowSetManager.get("tagDetailTab");
//var tagDetailForm = g_FormRowSetManager.get("tagDetailForm");	
init();
function init()
{
var TagDetailTable = g_TableRowSetManager.get("tagDetailTab");

  var tagType=<%=request.getParameter("tagType")%>;
  TagDetailTable.refresh("&tagType="+tagType);
}

function queryTagbyCharge()
{

	var charge = document.getElementById("fee").value;
	var month =  document.getElementById("month").value;
    var TagDetailTable = g_TableRowSetManager.get("tagDetailTab");
      var tagType=<%=request.getParameter("tagType")%>;
      var orgid=<%=request.getParameter("orgid")%>;
      if(charge==""&&month==""){
        TagDetailTable.refresh("&tagType="+tagType+"&orgid="+orgid);
      }
    else if(charge==""&&month!=""){
    TagDetailTable.refresh("&tagType="+tagType+"&month="+month+"&orgid="+orgid);
    }else if(month==""&&charge!=""){
	var  mon= "&charge=" + charge+"&tagType="+tagType+"&orgid="+orgid;
    TagDetailTable.refresh(mon);
    }
    else{
    var  mon= "&charge=" + charge+"&tagType="+tagType+"&month="+month+"&orgid="+orgid;
    TagDetailTable.refresh(mon);
    }
} 
function getTagDetailReturn(){
           var curRow = TagDetailTable.getRow();
		   var charge = TagDetailTable.getValue(curRow,"CHARGE");
		   var sumcharge = TagDetailTable.getValue(curRow,"SUMCHARGE");
		   var state = TagDetailTable.getValue(curRow,"STATE");
		   var wtid = TagDetailTable.getValue(curRow,"ID");
		   var name = TagDetailTable.getValue(curRow,"NAME");
		    if(charge=="")
		    {
		    alert("请选择");
		    }else{
	    	 window.returnValue = sumcharge+","+charge+","+state+","+wtid+","+name;
		    }
		    window.self.close();
		 
	}




</script>
</body>
</html>