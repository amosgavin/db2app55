<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/secframe/common/common.jsp"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<%
	String type = request.getParameter("type");
%>
<html>
	<head>
		<title>资费属性管理</title>
	</head>
	<body onload="init()">

		<ai:contractframe id="qryInfo" contenttype="table" title="查询信息"
			width="100%" allowcontract="true" frameclosed="false">
			<ai:contractitem />
			<ai:dbform formid="attrForm"
				setname="com.asiainfo.charge.web.SETProductExtDesc"
				datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				initial="false">
				<table>
					<tr>
						<td class="td_font">
							属性名称
						</td>
						<td>
							<ai:dbformfield fieldname="EXT_NAME" formid="attrForm" />
						</td>
						<td class="td_font">
							资费类型
						</td>
						<td>
							<ai:dbformfield fieldname="EXT_TYPE" formid="attrForm" />
						</td>
						<td>
							<ai:button id="qryAttr" text="查询" onclick="qryAttr()" />
						</td>
					</tr>
				</table>

			</ai:dbform>
		</ai:contractframe>
		<%@ include file="/sale/product/include/_attrList.jsp"%>
	</body>
</html>
<ai:loginuser />
<script language="javascript" type="text/javascript">
var form = g_FormRowSetManager.get("attrForm");
form.setValue("EXT_TYPE","<%=type%>");
 _attrList.addForm.removeListBoxOption("EXT_TYPE","SALE");
function init(){
  form.removeListBoxOption("EXT_TYPE","SALE");
  qryAttr();
}

function qryAttr(){
	var cond = "";
	var type = form.getValue("EXT_TYPE");
	var ext_name = encodeURI(form.getValue("EXT_NAME"));
  if(null != type && ""!= type){
  	cond+="&type="+type;
  }
  if(null != ext_name && ""!= ext_name){
  	cond+= "&extName="+ext_name;
  }
  cond+="&state=1";
  _attrList.qryAttr(cond);
 // grid.refresh(cond);
	
}

function getUrl(opType){
	var url = "";
	if("delete"==opType){
		var url ="<%=request.getContextPath()%>/business/com.asiainfo.charge.web.ChargeShowAction?"+
		"action=delAttr";
		//"action=delAttr&codesArray="+codesArray+"&extType="+extType;
	}
	else if("save"==opType){
		var url ="<%=request.getContextPath()%>/business/com.asiainfo.charge.web.ChargeShowAction?action=saveAttr";
		//&extName="+_attrList.trim(extName)+"&extType="+extType;
	}
	return url;
}

function controlExtType(){
//	_attrList.addForm.setValue("EXT_TYPE","SALE","营销案档次");
	
//	_attrList.addForm.setColEditSts("EXT_TYPE",false);
}
//新增属性
function addAttr(){
		var url = "<%=request.getContextPath()%>/charge/product/addAttr.jsp";
		var result = window.showModalDialog(url,'',"scroll:no;resizable:no;status:no;dialogHeight:200px;dialogWidth:600px");
		qryAttr();
		
	
}

//删除属性
function delAttr(){
	var selectRows = grid.getSelectedRows();
	
	var staffId = g_GetUserInfo().STAFF_ID;

	if(selectRows.length <= 0){
		alert("请选择要删除的属性");
		return;
	}
	var codesArray = new Array();
	var extType = grid.getValue(selectRows[0],"EXT_TYPE");
	for(var i = 0 ; i < selectRows.length; i ++){
		var staff_id = grid.getValue(selectRows[i],"STAFF_ID");
		var is_can_modify = grid.getValue(selectRows[i],"IS_CAN_MODIFY");
		if(is_can_modify == "0"){
			alert("属性【"+grid.getValue(selectRows[i],"EXT_NAME")+"】 不可删除");
			return;
		}
		if(staff_id != staffId){
			alert("您没有权限删除属性【"+grid.getValue(selectRows[i],"EXT_NAME")+"】");
			return;
		}
		codesArray.push(grid.getValue(selectRows[i],"EXT_CODE"));
		
	}
	var url ="<%=request.getContextPath()%>/business/com.asiainfo.charge.web.ChargeShowAction?"+
	"action=delAttr&codesArray="+codesArray+"&extType="+extType;
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
</script>