<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>��ʶѡ��</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body>
<table>
	<tr align = "left">
       <td id="searchName">��</td>
	        <td align = "center"><input type="text" id="fee" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"></td>
	        <td>������</td>
	        <td align = "center"><input type="text" id="month" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"></td>
	         <td>BOSS���ƣ�</td>
	        <td><input type="text" id="hpSelect"></td>
	        <td>
		<ai:button id="queryTag" text="��ѯ" onclick="queryTagbyCharge()"/></td>
	</tr>
</table>
<ai:contractframe id="tagDetailTab" contenttype="table" title="������ʶ��Ϣ" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem/>
	<ai:table setname="com.asiainfo.sale.tag.web.SETHPPromationTag"
			tableid="tagDetailTab"  editable="false"  ondbclick="getTagDetailReturn" 
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			needrefresh="true" pagesize="14" initial="false" width="100%"
			implservice_name="com.asiainfo.sale.tag.service.interfaces.ITagDetailSV"
			implservice_querymethod="queryZFQTagDetail(String charge,String tagType,String month,String orgid, int $STARTROWINDEX, int $ENDROWINDEX)"
			implservice_countmethod="getTagDetailCount(String charge,String tagType,String month,String orgid)" >
 			<ai:col  title="BOSS���" fieldname="WPID" width="10%" editable="false" visible="false"/>	
            <ai:col title="BOSS��ʶ" fieldname="TAG_CODE" width="10%" editable="false" visible="false"/>
            <ai:col title="BOSS����" fieldname="NAME" width="30%" editable="false" visible="true"/>	
            <ai:col title="ÿ�½��(Ԫ)" fieldname="CHARGE" width="10%" editable="false" visible="true" /> 
            <ai:col title="ָ����(Ԫ)" fieldname="SUMCHARGE" width="10%" editable="false" visible="" /> 
            <ai:col title="����" fieldname="CYCLE" width="10%" editable="ture" visible="true"/>	
            <ai:col title="BOSS����" fieldname="TAG_TYPE" width="" editable="false" visible="false"/>
            <ai:col title="BOSS״̬" fieldname="STATE" width="10%" editable="false" visible="true"/>	
            <ai:col title="����" fieldname="AREA" width="10%" editable="false" visible=""/>	
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
	if(tagType=="7"){//��������ΪԤ���ͻ�Ʒ
		var name = "�ܼ�ֵ";
	   	TagDetailTable.setTitle("CHARGE",name);
	   	searchName.innerText=name+"��";
	   	TagDetailTable.setTitle("CHARGE",name+"(Ԫ)");
 	}else{
	 		var name = "ÿ�½��";
	 		TagDetailTable.setColVisible("SUMCHARGE" ,false);
	 		searchName.innerText=name+"��";
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
		    alert("��ѡ��");
		    }else{
	    	 window.returnValue = cycle+","+charge+","+state+","+wtid+","+name+","+sumcharge+","+area;
		    }
		    window.self.close();
		 
	}




</script>
</body>
</html>