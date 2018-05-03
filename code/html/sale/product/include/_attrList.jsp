<%--
	作者：江晓莉
	日期：2013-12-10
	功能：扩展属性列表
	说明:内嵌页面

 --%>
<%@ page contentType="text/html; charset=GBK"%>
<ai:contractframe id="attrInfo" contenttype="table" title="属性信息"
	width="100%" allowcontract="true" frameclosed="false">
	<ai:contractitem>
		<ai:button id="addData" text="新增属性" onclick="_attrList.addAttr()" />
		<ai:button id="modifyData" text="删除属性" onclick="_attrList.delAttr()" />
	</ai:contractitem>
	<ai:table tableid="extAttr"
		setname="com.asiainfo.charge.web.SETProductExtDesc"
		tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
		implservice_name="com.asiainfo.common.service.interfaces.IAbstractProductExtSV"
		implservice_querymethod="getColsName(String extName,String type,String state,String is_can_moidfy,int $STARTROWINDEX,int $ENDROWINDEX )"
		implservice_countmethod="getColsNameCount(String extName,String type,String state,String is_can_moidfy)"
		initial="false" ondbclick="" onrowchange="" pagesize="20" editable=""
		width="100%" height="180" needrefresh="true" multiselect="true"
		rowsequence="true">
		<ai:col fieldname="EXT_CODE" width="25%" />
		<ai:col fieldname="EXT_NAME" width="25%" />
		<ai:col fieldname="EXT_TYPE" width="25%" />
		<ai:col fieldname="CREATE_DATE" width="25%" />
		<ai:col fieldname="IS_CAN_MODIFY" visible="false" />
		<ai:col fieldname="STAFF_ID" visible="false" />

	</ai:table>
</ai:contractframe>
<div id="addInfoDiv" style="display: none">
	<ai:contractframe id="addInfo" contenttype="table" title="新增信息"
		width="100%" allowcontract="true" frameclosed="false">
		<ai:contractitem />
		<ai:dbform formid="addAttr"
			setname="com.asiainfo.charge.web.SETProductExtDesc"
			datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			initial="false" editable="true">
			<table>
				<tr>
					<td class="td_font">
						属性名称
					</td>
					<td>
						<ai:dbformfield fieldname="EXT_NAME" formid="addAttr" />
					</td>
					<td class="td_font">
						类型
					</td>
					<td>
						<ai:dbformfield fieldname="EXT_TYPE" formid="addAttr" />
					</td>
					<td>
						<ai:button id="saveAttr" text="保存" onclick="_attrList.saveAttr()" />
					</td>
				</tr>

			</table>

		</ai:dbform>
	</ai:contractframe>
</div>

<script language="javascript" type="text/javascript">

var _attrList= {};
 
 _attrList.addForm = g_FormRowSetManager.get("addAttr");

_attrList.grid =  g_TableRowSetManager.get("extAttr");
_attrList.qryAttr = function(cond){
  cond+="&state=1";
  _attrList.grid.refresh(cond);
}

_attrList.delAttr=function(){
	var selectRows = _attrList.grid.getSelectedRows();
	
	var staffId = g_GetUserInfo().STAFF_ID;

	if(selectRows.length <= 0){
		alert("请选择要删除的属性");
		return;
	}
	var codesArray = new Array();
	var extType = _attrList.grid.getValue(selectRows[0],"EXT_TYPE");
	for(var i = 0 ; i < selectRows.length; i ++){
		var staff_id = _attrList.grid.getValue(selectRows[i],"STAFF_ID");
		var is_can_modify = _attrList.grid.getValue(selectRows[i],"IS_CAN_MODIFY");
		if(is_can_modify == "0"){
			alert("属性【"+_attrList.grid.getValue(selectRows[i],"EXT_NAME")+"】 不可删除");
			return;
		}
		if(staff_id != staffId){
			alert("您没有权限删除属性【"+_attrList.grid.getValue(selectRows[i],"EXT_NAME")+"】");
			return;
		}
		codesArray.push(_attrList.grid.getValue(selectRows[i],"EXT_CODE"));
		
	}
	var url = getUrl("delete");
	var param="&codesArray="+codesArray+"&extType="+extType;
	if(null==url||""==url){
		return;
	}
	url+=param;
	if(confirm("是否要删除选中的属性吗?")){
		var retValues = PostInfo(url,null);
		if(null != retValues){
			if(retValues.getValueByName("retVal") == "Y"){
				alert(retValues.getValueByName("retMsg"));
				qryAttr();
			}
			else{
				alert(retValues.getValueByName("retMsg"));
				return;
			}
		}
		else{
			alert("删除失败");
		}
	}
	

}

_attrList.controlType=function(){
	controlExtType();
}


_attrList.addAttr=function(){
	document.getElementById("addInfoDiv").style.display="block";
	_attrList.controlType();
	_attrList.addForm.setValue("EXT_NAME","","");
	//_attrList.addForm.setValue("EXT_TYPE","SALE","营销案档次");
}

_attrList.saveAttr=function(){
	var extName =  _attrList.addForm.getValue("EXT_NAME");
	
	var extType =  _attrList.addForm.getValue("EXT_TYPE");
	if(null == extName || "" == extName){
		alert("请填写属性名称");
		return ;
	}
	if(null == extType || "" == extType){
		alert("请选择资费类型！");
		return;
	}
	var url=getUrl("save");
	var param="&extName="+_attrList.trim(extName)+"&extType="+extType;
	if(null==url||""==url){
		return;
	}
	url+=param;
	//var url ="<%=request.getContextPath()%>/business/com.asiainfo.sale.product.web.SaleShowAction?action=saveAttr&extName="+trim(extName)+"&extType="+extType;
	var record = PostInfo(url,null);
	
	if(null != record){
		retVal = record.getValueByName("retVal");
		
		if(retVal == "Y"){
			alert(record.getValueByName("retMsg"));
			document.getElementById("addInfoDiv").style.display="none";
			qryAttr();
		}
		else{
			alert(record.getValueByName("retMsg"));
		}
	}
	else{
		alert("保存失败！");
	}
}

_attrList.trim=function (str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}




</script>
