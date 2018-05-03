<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@include file="/webframe/common/commonhead.jsp"%>
<html>
<head>
<title>������ʶ����</title>
<script language="javascript" src="<%=request.getContextPath()%>/jsv2/Calendar.jsp" type="text/javascript"></script>
</head>
<body onload="initPage()">


<ai:contractframe id="applyTagTab" contenttype="table" title="����Ӵ�����ʶ" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem>
	<ai:button id="deleteDetailTag" text="ɾ ��" onclick="deleteSelected()"/>
	</ai:contractitem>
	<ai:table setname="com.asiainfo.sale.tag.web.SETPromationTag"
			  tableid="applyTagTab" editable="false" width="100%" height = "250"
			  needrefresh="true" initial="false" multiselect="true" pagesize="12" ondbclick="updateSelected"
			  tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			  implservice_name="com.asiainfo.sale.tag.service.interfaces.ITagDetailSV"
			  implservice_querymethod="getTagDetailByMainId(String pid, int $STARTROWINDEX, int $ENDROWINDEX)"
			  implservice_countmethod="countTagDetailByMainId(String pid)"			  
			  >
			  <ai:col fieldname="WPID" width="6%" editable="false" visible="" />
	        	<ai:col fieldname="TAG_TYPE" width="10%" editable="false" visible="true" />
				<ai:col fieldname="NAME" width="10%" editable="false" visible="true" /> 
				<ai:col fieldname="ADD_MONTHCHARGE" title="�ܽ��" width="8%" editable="false" visible="true" />
				<ai:col fieldname="FIRSTCHARGE" title="�״ε���"  width="7%" editable="false" visible="true"/> 
				<ai:col fieldname="LASTCHARGE"  title="ĩ�ε���" width="7%" editable="false" visible="true"/> 
				<ai:col  fieldname="CHARGE" title="ÿ�½��" width="7%" visible="true"/>
				<ai:col title="ÿ������ֵ" fieldname="SUMCHARGE" width="8%" editable="false" />
				<ai:col fieldname="CYCLE"  width="7%" editable="false" visible="true"/> 
				<ai:col title="��������" fieldname="RETURN_TYPE" width="10%" editable="false" visible="true"/>
				<ai:col title="ר�Χ" fieldname="IS_SP" width="10%" editable="false" visible="true"/>
				<ai:col fieldname="AREA" width="7%" editable="false" visible="true"/>
				<ai:col fieldname="STATE" width="7%" editable="false" visible="true"/>
	</ai:table>
	
</ai:contractframe>	

<ai:contractframe id="writeTagInfoframe" contenttype="table" title="��д������ʶ�굥" width="100%" allowcontract="true" frameclosed="false" >
	<ai:contractitem/>
	<ai:dbform formid="tagDetailForm" initial="false"
			setname="com.asiainfo.sale.tag.web.SETPromationTag" 
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			 implservice_name="com.asiainfo.sale.tag.service.interfaces.ITagDetailSV"
			  implservice_querymethod="getTagDetailById(int id)"	
			onvalchange="onTagTypeChange"
		    editable="true">
		<table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
	           	<tr>
	           		<td class="td_font">��ʶ���ͣ�</td>
	           		<td><ai:dbformfield formid="tagDetailForm" fieldname="TAG_TYPE" width="150"/><span class="font_red">*</span></td>
	           		<td class="td_font">��ʶ���ƣ�</td>
	           		<td><ai:dbformfield formid="tagDetailForm" fieldname="NAME" width="150"/><span class="font_red">*</span></td>
	           	</tr>
	           	<tr id="dzqtype" display="none">
	           		<td class="td_font">�ܽ�</td>
	           		<td><ai:dbformfield formid="tagDetailForm" fieldname="ADD_MONTHCHARGE" width="150"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font" id="month">�������ԣ�</td>
	           		<td id="month2"><ai:dbformfield formid="tagDetailForm" fieldname="RETURN_TYPE" width="150"/><span class="font_red">*</span>
	           		</td>
	           	</tr>
	           	 <tr id="dzqtype1" display="none">
	           		<td class="td_font">�״η�����</td>
	           		<td><ai:dbformfield formid="tagDetailForm" fieldname="FIRSTCHARGE" width="150"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font" id="month">ĩ�η�����</td>
	           		<td id="month2"><ai:dbformfield formid="tagDetailForm" fieldname="LASTCHARGE" width="150"/><span class="font_red">*</span>
	           		</td>
	           	</tr>
	            <tr id="dzqtype2" display="block">
	           		<td class="td_font" id="bscharge">��ʶ��</td>
	           		<td id="bscharge1"><ai:dbformfield formid="tagDetailForm" fieldname="CHARGE" width="150"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font" id="month1">����(��)��</td>
	           		<td id="month2"><ai:dbformfield formid="tagDetailForm" fieldname="CYCLE" width="150"/><span class="font_red">*</span>
	           		</td>
	           	</tr>
	           	<tr id="lim_type" display="none">
	           		<td class="td_font" >�������ͣ�</td>
	           		<td ><ai:dbformfield formid="tagDetailForm" fieldname="LIM_TYPE" width="150"/><span class="font_red">*</span>
	           		</td>
	           		<td></td>
	           		<td></td>
	           	</tr>
	           	<tr  id="hpzdj">
	           		<td class="td_font">ÿ������ֵ��</td>
	           		<td><ai:dbformfield formid="tagDetailForm" fieldname="SUMCHARGE" width="150"/><span class="font_red">*</span>
	           		</td>
	           	</tr>
	           	 <tr>
	           		<td class="td_font">��ʶ״̬��</td>
	           		<td><ai:dbformfield formid="tagDetailForm" fieldname="STATE" width="150"/><span class="font_red">*</span>
	           		</td>
	           		<td class="td_font">����</td>
	           		<td><ai:dbformfield formid="tagDetailForm" fieldname="AREA" width="150"/><span class="font_red">*</span>
	           		</td>
	           	</tr>
	           	 	 <tr id="bssx">
	           		<td class="td_font">ר�Χ��</td>
	           		<td><ai:dbformfield formid="tagDetailForm" fieldname="IS_SP" width="300"/>
	           		<img id="selectOrgTypeZSZK" border="0"
								src="<%=request.getContextPath()%>/webframe/images/query.gif"
								alt="" onClick="zkfwConditionz()" align="absmiddle"
								style="cursor: hand;" />
	           		</td>
	           		<td>
						<ai:dbformfield formid="tagDetailForm" fieldname="REMARK" width="150" visible="false"/>
	           		</td>
	           	</tr>
	           	<tr>
	           		<td class="td_font">��ʶ��ע��</td>
	           		<td><ai:dbformfield formid="tagDetailForm" fieldname="REMARK_TAG" width="300"/>
	           		</td>
	           	</tr>
		</table>
		<table align = "center">
			<tr>
				<td><ai:button id="newTag" text="���" onclick="clearDetailTag()"/></td>
				<td><ai:button id="newTag" text="���/����" onclick="saveDetailTag()"/></td>
			</tr>
		</table>
	</ai:dbform>
</ai:contractframe>
<ai:loginuser />
<script type="text/javascript">
var tagDetailForm = g_FormRowSetManager.get("tagDetailForm");	
var TagDetailTable = g_TableRowSetManager.get("applyTagTab");
var addid="";

function initPage(){
	tagDetailForm.setValue("TAG_TYPE","1");
	tagDetailForm.setValue("STATE","99");
	tagDetailForm.setValue("RETURN_TYPE","1");
	tagDetailForm.setValue("AREA","10");
	tagDetailForm.setValue("LIM_TYPE","");
	tagDetailForm.setValue("IS_SP","0");
	tagDetailForm.setColEditSts("STATE",false);
	tagDetailForm.setColEditSts("IS_SP",false);
	document.getElementById("dzqtype2").style.display="block";
	document.getElementById("lim_type").style.display="block";
}


function clearDetailTag(){
	tagDetailForm.newRow();
	initPage();
}


function saveDetailTag()
{
	var tagname=tagDetailForm.getValue("NAME");
	var tagtype=tagDetailForm.getValue("TAG_TYPE");	
	var rtype=tagDetailForm.getValue("RETURN_TYPE");
	var charge = tagDetailForm.getValue("CHARGE");
	var cycle = tagDetailForm.getValue("CYCLE");
	var suncharge = tagDetailForm.getValue("SUMCHARGE");
	var area = tagDetailForm.getValue("AREA");
	var firch = tagDetailForm.getValue("FIRSTCHARGE");
	var latch = tagDetailForm.getValue("LASTCHARGE");
	var issp = tagDetailForm.getValue("IS_SP");
	var addmon = tagDetailForm.getValue("ADD_MONTHCHARGE");
	var lim_type = tagDetailForm.getValue("LIM_TYPE");
	tagDetailForm.setValue("REMARK","��"+g_GetUserInfo().STAFF_NAME+"("+g_GetUserInfo().STAFF_ID+")"+"���");
	if(tagname==""){
		return alert("����д��ʶ������Ϣ!");
	}
	if(charge == "" && tagtype != "6" && tagtype != "11"&&tagtype != "9"){
		return alert("����д��ʶ������Ϣ!");
	}else if(charge==""&&(tagtype=="6"||tagtype=="9")){
		if(addmon==""){
			if(tagtype=="6"){
				return alert("����д����ȯ�ܽ��!");
			}else{
				return alert("����д�Ͱ�����ܽ��!");
			}
				
		}	
		if(rtype=="1"){
			tagDetailForm.setValue("CHARGE",addmon);
			tagDetailForm.setValue("FIRSTCHARGE","--");
			tagDetailForm.setValue("LASTCHARGE","--");
			tagDetailForm.setValue("cycle","1");
			tagDetailForm.setValue("SUMCHARGE","0");
		}
		if(rtype=="2"){
			if(cycle==""){
				return alert("����д����!");
			}
			var charge=addmon/cycle;
			tagDetailForm.setValue("FIRSTCHARGE","--");
			tagDetailForm.setValue("LASTCHARGE","--");
			tagDetailForm.setValue("CHARGE",charge);
			tagDetailForm.setValue("SUMCHARGE","0");
		}
		if(rtype=="4"){
			if(cycle==""){
				return alert("����д����!");
			}
			var charge=(addmon-firch-latch)/cycle;
			tagDetailForm.setValue("CHARGE",charge);
			tagDetailForm.setValue("SUMCHARGE","0");
		}
		if(rtype=="3"){
			tagDetailForm.setValue("FIRSTCHARGE","--");
			tagDetailForm.setValue("LASTCHARGE","--");
			tagDetailForm.setValue("CHARGE","0");
		}
	} else if(charge!=""){
		if(rtype=="3"){
			tagDetailForm.setValue("FIRSTCHARGE","--");
			tagDetailForm.setValue("LASTCHARGE","--");
			tagDetailForm.setValue("CHARGE","0");
		}else{
			tagDetailForm.setValue("FIRSTCHARGE","--");
			tagDetailForm.setValue("LASTCHARGE","--");
			tagDetailForm.setValue("ADD_MONTHCHARGE",charge*cycle);
			tagDetailForm.setValue("SUMCHARGE","0");
		}
	}
	if(tagtype != "6" && tagtype != "7" && tagtype != "11"&&tagtype != "9"){
		if(cycle==""){
			return alert("����д����!");
		}
	}
	if(tagtype=="1"&&lim_type==""){
			return alert("��ѡ�񱣵�����");
		}

	var tagCheckUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.tag.web.DetailTagAction?action=isHaveTag&pid=0'+"&tagtype="+tagtype+
																														 "&charge="+charge+"&cycle="+cycle+"&suncharge="+suncharge+
																														 "&area="+area+"&issp="+issp+"&tagname="+trim(tagname);
	var recode1 = PostInfo(tagCheckUrl, null);
	if (recode1.getValueByName("ISHAVETAG") == 'Y') {
		if(!confirm("�Ѵ�����ͬ��ǩ,��ȷ��Ҫ��ӣ�")){
		        return;
		}
	}

	var list = new Array();
	list.push(tagDetailForm);
	var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.tag.web.DetailTagAction?action=saveDetailTag&pid=0';
	var recode = saveRowSet(strUrl, list);
	if(addid==""){
		addid=recode.getValueByName("ADDID");
	}else{
		addid=addid+","+recode.getValueByName("ADDID");
	}
	if ("Y" == recode.getValueByName("FLAG") )
	{
		TagDetailTable.refresh("pid=" + addid);
		tagDetailForm.newRow();
		initPage();
	}
	if(tagDetailForm.getSts()!='O'){
		tagDetailForm.setStsToNew();
	}
}


function onTagTypeChange(pFieldName,pOldVal,pOldText,pNewVal,pNewText){   
    if(pFieldName=="TAG_TYPE"||pFieldName=="RETURN_TYPE"){
    	showPagAnt();
    }
}

function showPagAnt(){

    var tagType=tagDetailForm.getValue("TAG_TYPE");
    var rtype=tagDetailForm.getValue("RETURN_TYPE");
    document.getElementById("hpzdj").style.display="none";
	document.getElementById("month1").style.display="block";
	document.getElementById("month2").style.display="block";
	//tagDetailForm.setValue("CHARGE","");
	tagDetailForm.setColEditSts("CHARGE",true);
	tagDetailForm.setValue("STATE","99");
	//tagDetailForm.setValue("LIM_TYPE","");
	//tagDetailForm.setValue("CYCLE","");
	//TagDetailTable.setColVisible("SUMCHARGE" ,false);
	TagDetailTable.setTitle("CHARGE","ÿ�½��");
	//tagDetailForm.setValue("IS_SP","");
	document.getElementById("bssx").style.display="none";
	document.getElementById("dzqtype").style.display="none";
	document.getElementById("dzqtype1").style.display="none";
	document.getElementById("dzqtype2").style.display="block";
	document.getElementById("hpzdj").style.display="none";
	document.getElementById("lim_type").style.display="none";
			
    if(tagType=="7"){
		var name = "�ܼ�ֵ";
		TagDetailTable.setTitle("CHARGE",name+"(Ԫ)");
		TagDetailTable.setColVisible("SUMCHARGE" ,true);
		tagDetailForm.setValue("STATE","1");
		tagDetailForm.setValue("CYCLE","1");
		tagDetailForm.setValue("LIM_TYPE","");
		document.getElementById("bscharge").innerHTML="��Ʒ�ܼ�ֵ��";
		document.getElementById("month1").style.display="none";
		document.getElementById("month2").style.display="none";
		document.getElementById("hpzdj").style.display="block";
	 }else if (tagType=="1"){
	 	document.getElementById("bscharge").innerHTML="ÿ�±��׶�ȣ�";
	 	document.getElementById("lim_type").style.display="block";
	 }else if (tagType=="2"){
	 	document.getElementById("bscharge").innerHTML="ÿ�����Ͷ�ȣ�";
	 	document.getElementById("bssx").style.display="block";
	 	tagDetailForm.refreshListBox("IS_SP","codeType=acctypez",true);
	 	tagDetailForm.setValue("IS_SP","2");
	 	tagDetailForm.setValue("LIM_TYPE","");
	 }else if (tagType=="3"){
	 	document.getElementById("bscharge").innerHTML="ÿ�¼�ֵ��";
	 	tagDetailForm.setValue("LIM_TYPE","");
	 }else if (tagType=="4"){
	 	document.getElementById("bscharge").innerHTML="ÿ�·�����ȣ�";
	 	document.getElementById("bssx").style.display="block";
	 	tagDetailForm.refreshListBox("IS_SP","codeType=acctypey",true);
	 	tagDetailForm.setValue("IS_SP","1");
	 	tagDetailForm.setValue("LIM_TYPE","");
	 }else if (tagType=="5"){
	 	document.getElementById("bscharge").innerHTML="ÿ�¼�ֵ��";
	 	tagDetailForm.setValue("CHARGE","0");
	 	tagDetailForm.setColEditSts("CHARGE",false);
	 	tagDetailForm.setValue("LIM_TYPE","");
	 }else if (tagType=="6"||tagType=="9"){
 		document.getElementById("bscharge").innerHTML="ÿ�½�";
 		tagDetailForm.setValue("LIM_TYPE","");
 		//tagDetailForm.setValue("CYCLE","1");
 		//	document.getElementById("month1").style.display="none";
		//document.getElementById("month2").style.display="none";
		if(rtype=="1"){
			document.getElementById("dzqtype1").style.display="none";
			document.getElementById("dzqtype2").style.display="none";
		}else if(rtype=="2"){
			document.getElementById("dzqtype2").style.display="block";
			document.getElementById("bscharge").style.display="none";
			document.getElementById("bscharge1").style.display="none";
		}else if(rtype=="3"){
			document.getElementById("bscharge").style.display="none";
			document.getElementById("bscharge1").style.display="none";
			document.getElementById("dzqtype2").style.display="block";
			document.getElementById("hpzdj").style.display="block";
		}else{
			document.getElementById("dzqtype1").style.display="block";
			document.getElementById("dzqtype2").style.display="block";
			document.getElementById("bscharge").style.display="none";
			document.getElementById("bscharge1").style.display="none";
		}
		document.getElementById("dzqtype").style.display="block";
	 } else if (tagType == "11") {
		 document.getElementById("dzqtype").style.display="block";
		 document.getElementById("dzqtype2").style.display="none";
	 }
    
}

function deleteSelected()
{
	var _tableTagApplyRowSet = g_TableRowSetManager.get("applyTagTab");
	var delRows = _tableTagApplyRowSet.getSelectedRows();
	var delRowCount = delRows.length;
	if (delRowCount == 0) {
		alert("����ѡ��Ҫɾ������");
		return;
	}
	while (delRowCount > 0) {
		delRowCount--;
		_tableTagApplyRowSet.deleteRow(delRows[delRowCount]);
	}
	var list = new Array();
	list.push(_tableTagApplyRowSet);
	var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.tag.web.DetailTagAction?action=deleteDetailTag';
	var ud = saveRowSet(strUrl, list);
	if (ud.getValueByName("FLAG") == "Y") {
		_tableTagApplyRowSet.refresh("pid=" + pid);
	} else {
		alert(ud.getValueByName("MESSAGE"));
		return;
	}
}
function updateSelected(){
var _tableTagApplyRowSet = g_TableRowSetManager.get("applyTagTab");
var updateRows = _tableTagApplyRowSet.getCurRowIndex();
uid = _tableTagApplyRowSet.getValue(updateRows, "WPID");
tagDetailForm.refresh("id=" + uid);
showPagAnt();
}


function updateSelectedOld(){
	var _tableTagApplyRowSet = g_TableRowSetManager.get("applyTagTab");
	var updateRows = _tableTagApplyRowSet.getSelectedRows();
	uid = _tableTagApplyRowSet.getValue(updateRows, "WPID");
	if(updateRows == "" ||updateRows==null ){
	return alert("��ѡ����Ҫ�޸ĵ���!");
	}
 	window.showModalDialog("<%=request.getContextPath()%>/sale/promationTag/updateTag.jsp?id="+uid,"", "scroll:yes;resizable:no;help:no;status:yes;dialogHeight:300px;dialogWidth:700px"); 
 	_tableTagApplyRowSet.refresh("pid=" + addid);
}


function zkfwConditionz(){
var tagtype=tagDetailForm.getValue("TAG_TYPE");
if(tagtype=="2"){
	var codeType="acctypez";
}
if(tagtype=="4"){
	var codeType="acctypey";
}
	var returnzk= window.showModalDialog("<%=request.getContextPath()%>/sale/promationTag/SalestaticDate.jsp?codeType='"+codeType+"'","","dialogWidth=500px");
	if(returnzk!=undefined){
	tagDetailForm.setValue("IS_SP",returnzk);
	}
}

function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}
</script>
</body>
</html>