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
       <td id="searchName">：</td>
	        <td align = "center"><input type="text" id="fee" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"></td>
	        <td>月数：</td>
	        <td align = "center"><input type="text" id="month" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"></td>
	         <td>BOSS名称：</td>
	        <td><input type="text" id="hpSelect"></td>
	        <td>
		<ai:button id="queryTag" text="查询" onclick="queryTagbyCharge()"/></td>
	</tr>
</table>
<ai:contractframe id="tagDetailTab" contenttype="table" title="促销标识信息" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem/>
	<ai:table setname="com.asiainfo.sale.tag.web.SETHPPromationTag"
			tableid="tagDetailTab"  editable="false"  ondbclick="getTagDetailReturn" 
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			needrefresh="true" pagesize="14" initial="false" width="100%"
			implservice_name="com.asiainfo.sale.tag.service.interfaces.ITagDetailSV"
			implservice_querymethod="queryZFQTagDetail(String charge,String tagType,String month,String orgid, int $STARTROWINDEX, int $ENDROWINDEX)"
			implservice_countmethod="getTagDetailCount(String charge,String tagType,String month,String orgid)" >
 			<ai:col  title="BOSS编号" fieldname="WPID" width="10%" editable="false" visible="false"/>	
            <ai:col title="BOSS标识" fieldname="TAG_CODE" width="10%" editable="false" visible="false"/>
            <ai:col title="BOSS名称" fieldname="NAME" width="30%" editable="false" visible="true"/>	
            <ai:col title="每月金额(元)" fieldname="CHARGE" width="10%" editable="false" visible="true" /> 
            <ai:col title="指导价(元)" fieldname="SUMCHARGE" width="10%" editable="false" visible="" /> 
            <ai:col title="月数" fieldname="CYCLE" width="10%" editable="ture" visible="true"/>	
            <ai:col title="BOSS类型" fieldname="TAG_TYPE" width="" editable="false" visible="false"/>
            <ai:col title="BOSS状态" fieldname="STATE" width="10%" editable="false" visible="true"/>	
            <ai:col title="地市" fieldname="AREA" width="10%" editable="false" visible=""/>	
	</ai:table>
</ai:contractframe>


<script type="text/javascript">
var TagDetailTable = g_TableRowSetManager.get("tagDetailTab");
//var tagDetailForm = g_FormRowSetManager.get("tagDetailForm");	
init();
function init()
{
var TagDetailTable = g_TableRowSetManager.get("tagDetailTab");
	//var tagType=<%=request.getParameter("tagType")%>;
	var tagType='7';
	//  var org="<%=request.getParameter("orgid")%>";
	 var org="10";
	    var orgid=org.substring(0,2);
	if(tagType=="7"){//档次类型为预存送货品
		var name = "总价值";
	   	TagDetailTable.setTitle("CHARGE",name);
	   	searchName.innerText=name+"：";
	   	TagDetailTable.setTitle("CHARGE",name+"(元)");
 	}else{
	 		var name = "每月金额";
	 		TagDetailTable.setColVisible("SUMCHARGE" ,false);
	 		searchName.innerText=name+"：";
 	}
	TagDetailTable.refresh("&charge=" + "&tagType="+tagType+"&month="+"&orgid="+orgid+"&chargename=");
}

function queryTagbyCharge()
{

	var charge = document.getElementById("fee").value;
	var month =  document.getElementById("month").value;
    var TagDetailTable = g_TableRowSetManager.get("tagDetailTab");
     //var tagType=<%=request.getParameter("tagType")%>;
	var tagType='7';
	//  var org="<%=request.getParameter("orgid")%>";
	 var orgid="10";
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

function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}

function getTagDetailReturn(){
             var curRow = TagDetailTable.getRow();
		   var charge = TagDetailTable.getValue(curRow,"CHARGE");
		   var cycle = TagDetailTable.getValue(curRow,"CYCLE");
		   var state = TagDetailTable.getValue(curRow,"STATE");
		   var wtid = TagDetailTable.getValue(curRow,"WPID");
		   var name = TagDetailTable.getValue(curRow,"NAME");
		   var sumcharge = TagDetailTable.getValue(curRow,"SUMCHARGE");
		   var area = TagDetailTable.getValue(curRow,"AREA");
		   var is_sp = TagDetailTable.getValue(curRow,"IS_SP");
		    if(charge=="")
		    {
		    alert("请选择");
		    }else{
	    	 window.returnValue = cycle+","+charge+","+state+","+wtid+","+name+","+sumcharge+","+area;
		    }
		    window.self.close();
		 
	}




</script>
</body>
</html>