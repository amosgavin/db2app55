<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>��ʶѡ��</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body >
<ai:contractframe id="saleWeaponMainframe" contenttype="table" title="��ѯ����" width="100%" allowcontract="true" frameclosed="fale">
	<ai:contractitem/>
	<table>
		<tr align = "left">
	        <td id="searchName">ÿ�½�</td>
	        <td align = "center"><input type="text" id="fee" onkeyup="if(isNaN(value))execCommand('undo')" onafterpaste="if(isNaN(value))execCommand('undo')"></td>
	        <td>������</td>
	        <td align = "center"><input type="text" id="month" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"></td>
	         <td>BOSS���ƣ�</td>
	        <td><input type="text" id="hpSelect"></td>
	        <td>
			<ai:button id="queryTag" text="��ѯ" onclick="queryTagbyCharge()"/></td>
		</tr>
	</table>
</ai:contractframe>

<ai:contractframe id="tagDetailTab" contenttype="table" title="������ʶ��Ϣ(˫��ȷ��ѡ��)" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem/>
	<ai:table setname="com.asiainfo.sale.tag.web.SETPromationTag"
			tableid="tagDetailTab"  editable="false"  ondbclick="getTagDetailReturn" 
			tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			needrefresh="true" pagesize="14" initial="false" width="100%"
			implservice_name="com.asiainfo.sale.tag.service.interfaces.ITagDetailSV"
			implservice_querymethod="queryTagDetail(String charge,String tagType,String month,String orgid,String chargename,String state, int $STARTROWINDEX, int $ENDROWINDEX)"
			implservice_countmethod="getTagDetailCount(String charge,String tagType,String month,String orgid,String chargename,String state)" >
            <ai:col  title="BOSS���" fieldname="WPID" width="10%" editable="false" visible="false"/>	
            <ai:col title="BOSS��ʶ" fieldname="TAG_CODE" width="10%" editable="false" visible="true"/>
            <ai:col title="BOSS����" fieldname="NAME" width="30%" editable="false" visible="true"/>
            <ai:col title="��������" fieldname="RETURN_TYPE" width="10%" editable="true" visible="" /> 
            <ai:col title="����ȯ�ܽ��" fieldname="ADD_MONTHCHARGE" width="10%" editable="true" visible="" /> 
            <ai:col title="�״η���" fieldname="FIRSTCHARGE" width="12%" editable="true" visible="" /> 
            <ai:col title="ĩ�η���" fieldname="LASTCHARGE" width="12%" editable="true" visible="" /> 	
            <ai:col title="ÿ�½��" fieldname="CHARGE" width="15%" editable="true" visible="" /> 
            <ai:col title="ÿ������ֵ" fieldname="SUMCHARGE" width="15%" editable="true" visible="" /> 
            <ai:col title="����" fieldname="CYCLE" width="10%" editable="ture" visible="true"/>	
            <ai:col title="BOSS����" fieldname="TAG_TYPE" width="" editable="false" visible="false"/>
            <ai:col title="BOSS״̬" fieldname="STATE" width="10%" editable="false" visible="true"/>	
            <ai:col title="����" fieldname="AREA" width="10%" editable="false" visible=""/>	
	</ai:table>
</ai:contractframe>

<div class="area_button">
   <ai:button text="�ر�" id="close" onclick="window.close();" />&nbsp;&nbsp;
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
           var curRow = TagDetailTable.getRow();
		   var charge = TagDetailTable.getValue(curRow,"CHARGE");
		   var cycle = TagDetailTable.getValue(curRow,"CYCLE");
		   var state = TagDetailTable.getValue(curRow,"STATE");
		   var wtid = TagDetailTable.getValue(curRow,"WPID");
		   var name = TagDetailTable.getValue(curRow,"NAME");
		   var sumcharge =TagDetailTable.getValue(curRow,"SUMCHARGE");;
		   var area = TagDetailTable.getValue(curRow,"AREA");
		   var return_type = TagDetailTable.getValue(curRow,"RETURN_TYPE");
		   var add_mon = TagDetailTable.getValue(curRow,"ADD_MONTHCHARGE");
		   var first_charge = TagDetailTable.getValue(curRow,"FIRSTCHARGE");
		   var last_charge = TagDetailTable.getValue(curRow,"LASTCHARGE");
		  // var last_charge = TagDetailTable.getValue(curRow,"LASTCHARGE");
		   
		    if(charge=="")
		    {
		    alert("��ѡ��");
		    }else{
	    	 window.returnValue = cycle+","+charge+","+state+","+wtid+","+name+",,"+area+","+sumcharge+","+return_type+","+add_mon+","+first_charge+","+last_charge;
		    }
		    window.self.close();
		 
	}




</script>
</body>
</html>