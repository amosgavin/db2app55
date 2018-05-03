<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>标识选择</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body >
<ai:contractframe id="saleWeaponMainframe" contenttype="table" title="查询条件" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem/>
	<table>
		<tr align = "left">
	        <td id="searchName">每月金额：</td>
	        <td align = "center"><input type="text" id="fee" onkeyup="if(isNaN(value))execCommand('undo')" onafterpaste="if(isNaN(value))execCommand('undo')"></td>
	        <td>月数：</td>
	        <td align = "center"><input type="text" id="month" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"></td>
	         <td>BOSS名称：</td>
	        <td><input type="text" id="hpSelect"></td>
	        <td>
			<ai:button id="queryTag" text="查询" onclick="queryTagbyCharge()"/></td>
		</tr>
	</table>
</ai:contractframe>

<ai:contractframe id="tagDetailTab" contenttype="table" title="促销标识信息(双击确认选中)" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem/>
	<ai:table setname="com.asiainfo.sale.tag.web.SETPromationTag"
			tableid="tagDetailTab"  editable="false"  ondbclick="getTagDetailReturn" 
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			needrefresh="true" pagesize="14" initial="false" width="100%"
			implservice_name="com.asiainfo.sale.tag.service.interfaces.ITagDetailSV"
			implservice_querymethod="queryTagDetail(String charge,String tagType,String month,String orgid,String chargename,String state, int $STARTROWINDEX, int $ENDROWINDEX)"
			implservice_countmethod="getTagDetailCount(String charge,String tagType,String month,String orgid,String chargename,String state)" >
            <ai:col title="BOSS编号" fieldname="WPID" width="10%" editable="false" visible="false"/>	
            <ai:col title="BOSS标识" fieldname="TAG_CODE" width="10%" editable="false" visible="true"/>
            <ai:col title="BOSS名称" fieldname="NAME" width="30%" editable="false" visible="true"/>	
            <ai:col title="积分" fieldname="ADD_MONTHCHARGE" width="10%" editable="false" visible="true" /> 
            <ai:col title="金额(元)" fieldname="CHARGE" width="10%" editable="true" visible="" /> 
            <ai:col title="月数" fieldname="CYCLE" width="10%" editable="ture" visible="true"/>	
            <ai:col title="保底类型" fieldname="LIM_TYPE" width="10%" editable="ture" visible="true"/>	
            <ai:col title="BOSS类型" fieldname="TAG_TYPE" width="" editable="false" visible="false"/>
            <ai:col title="BOSS状态" fieldname="STATE" width="10%" editable="false" visible="true"/>	
            <ai:col title="地市" fieldname="AREA" width="10%" editable="false" visible=""/>	
            <ai:col title="专款范围" fieldname="IS_SP" width="20%" editable="false" visible=""/>	
            <ai:col title="标签备注" fieldname="REMARK_TAG" width="20%" editable="false" visible="true"/>
	</ai:table>
</ai:contractframe>

<div class="area_button">
   <ai:button text="关闭" id="close" onclick="window.close();" />&nbsp;&nbsp;
</div>
<ai:loginuser />
<script type="text/javascript">
function addLoadEvent(func) {  
    var oldonload = window.onload;  
    if(typeof window.onload != "function"){  
        window.onload = func;  
    }else{  
        window.onload = function(){
            oldonload();  
            func();  
        }  
    }  
}
addLoadEvent(init);
var TagDetailTable = g_TableRowSetManager.get("tagDetailTab");
//var tagDetailForm = g_FormRowSetManager.get("tagDetailForm");	
function init(){
	var TagDetailTable = g_TableRowSetManager.get("tagDetailTab");
	var tagType=<%=request.getParameter("tagType")%>;
	  var org="<%=request.getParameter("orgid")%>";
	    var orgid=org.substring(0,2);
	if(tagType=="7"){//档次类型为预存送货品
		var name = "总价值";
	   	TagDetailTable.setTitle("CHARGE",name);
	   	searchName.innerText=name+"：";
	   	TagDetailTable.setTitle("CHARGE",name+"(元)");
 	} else if (tagType != "11") {
 		TagDetailTable.setColVisible("ADD_MONTHCHARGE",false);
 	} else{
	 	if(tagType=="6"){
	 		searchName.innerText="总金额：";
	 		TagDetailTable.setColVisible("IS_SP" ,false);
	 	}else{
	 		if(tagType!="2"&&tagType!="4"){
	 			TagDetailTable.setColVisible("IS_SP" ,false);
	 		}
	 		searchName.innerText="金额：";
	 	}
	//	TagDetailTable.setColVisible("SUMCHARGE" ,false);
 	}
	TagDetailTable.refresh("&charge=" + "&tagType="+tagType+"&month="+"&orgid="+orgid+"&chargename=");
}
function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}


function queryTagbyCharge(){
	var charge = document.getElementById("fee").value;
	var month =  document.getElementById("month").value;
	var chargename=document.getElementById("hpSelect").value;
    var TagDetailTable = g_TableRowSetManager.get("tagDetailTab");
    var tagType="<%=request.getParameter("tagType")%>";
    var org="<%=request.getParameter("orgid")%>";
    var orgid=org.substring(0,2);
    var  mon= "&charge=" + charge+"&tagType="+tagType+"&month="+month+"&orgid="+orgid+"&chargename="+encodeURI(trim(chargename));
    TagDetailTable.refresh(mon);
    
} 
function getTagDetailReturn(){
		   var tagType=<%=request.getParameter("tagType")%>;
           var curRow = TagDetailTable.getRow();
		   var charge = TagDetailTable.getValue(curRow,"CHARGE");
           if (tagType == "11") charge = TagDetailTable.getValue(curRow,"ADD_MONTHCHARGE");
		   var cycle = TagDetailTable.getValue(curRow,"CYCLE");
		   var state = TagDetailTable.getValue(curRow,"STATE");
		   var wtid = TagDetailTable.getValue(curRow,"WPID");
		   var name = TagDetailTable.getValue(curRow,"NAME");
		   var ltype = TagDetailTable.getValue(curRow,"LIM_TYPE");
		   if(ltype=="1"){
		   		ltype="套餐内";
		   }else if(ltype=="2"){
		   		ltype="套餐外";
		   	}else{
		   		ltype="";
		   	}
		   var sumcharge = "";
		   var area = TagDetailTable.getValue(curRow,"AREA");
		   var is_sp = TagDetailTable.getValue(curRow,"IS_SP");
		    if(charge=="")
		    {
		    alert("请选择");
		    }else{
	    	 window.returnValue = cycle+","+charge+","+state+","+wtid+","+name+","+sumcharge+","+area+","+is_sp+","+ltype;
		    }
		    window.self.close();
		 
	}




</script>
</body>
</html>