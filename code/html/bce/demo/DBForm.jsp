<%@page contentType="text/html; charset=gbk"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<%
pageContext.getRequest().setAttribute("condition","staff_id=-1");
%>
<table border="1">
  <tr>
    <th>实例1</th>
    <th>实例2</th>
    <th>实例3</th>
  </tr>
  <tr>
    <td>
		<ai:dbform formid="staff_form" 
					setname="com.asiainfo.crm.example.test.web.SETStaff"
				    conditionname="condition" 
				    parametersname="parameters" 
				    editable="true" 
				    datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				    implservice_name="com.asiainfo.crm.test.service.interfaces.IStaffSV"  
				    implservice_querymethod="queryStaffByCode(String code)"
				    initial="false">
				  	  工号：<ai:dbformfield fieldname="STAFF_ID" formid="staff_form" editable="true"/><br/>
					  工号：<ai:dbformfield fieldname="CODE" formid="staff_form" editable="true"/><br/>
					  密码：<ai:dbformfield fieldname="PASSWORD" formid="staff_form"/><br/>
					  姓名：<ai:dbformfield fieldname="NAME" formid="staff_form"/><br/>
					  组织：<ai:dbformfield fieldname="ORGANIZE_ID" formid="staff_form"/><br/>
					  身份证号：<ai:dbformfield fieldname="CERTIFI_CODE" formid="staff_form" width="300"/><br/>
					  家庭电话：<ai:dbformfield fieldname="HOME_TEL" formid="staff_form" width="300"/><br/>
					  办公电话：<ai:dbformfield fieldname="OFFICE_TEL" formid="staff_form" width="300"/><br/>
					  考核标记：<ai:dbformfield fieldname="CHECK_FLAG" formid="staff_form"/><br/>
					  状态：<ai:dbformfield fieldname="STATE" formid="staff_form"/><br/>
					  备注：<ai:dbformfield fieldname="REMARKS" formid="staff_form" width="300"/><br/>
				    
		</ai:dbform>
		<input type="button" value="保存" onclick="save()"/>
	</td>
    <td>
    	员工工号：
		<input type="text" id="staff_code"/>

		<input type="button" value="查询" onclick="query2()"/><br/>
		<ai:dbform formid="staff_form2" setname="com.asiainfo.crm.example.test.web.SETStaff"
				    conditionname="condition1" 
				    parametersname="parameters" 
				    editable="true" 
				    datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				    implservice_name="com.asiainfo.crm.example.test.service.interfaces.IStaffSV"  
				    implservice_querymethod="queryStaffByCode(String code)"
				    initial="false">
				  	  工号：<ai:dbformfield fieldname="STAFF_ID" formid="staff_form2" editable="true"/><br/>
					  工号：<ai:dbformfield fieldname="CODE" formid="staff_form2" editable="true"/><br/>
					  密码：<ai:dbformfield fieldname="PASSWORD" formid="staff_form2"/><br/>
					  姓名：<ai:dbformfield fieldname="NAME" formid="staff_form2"/><br/>
					  组织：<ai:dbformfield fieldname="ORGANIZE_ID" formid="staff_form2"/><br/>
					  身份证号：<ai:dbformfield fieldname="CERTIFI_CODE" formid="staff_form2" width="300"/><br/>
					  家庭电话：<ai:dbformfield fieldname="HOME_TEL" formid="staff_form2" width="300"/><br/>
					  办公电话：<ai:dbformfield fieldname="OFFICE_TEL" formid="staff_form2" width="300"/><br/>
					  考核标记：<ai:dbformfield fieldname="CHECK_FLAG" formid="staff_form2"/><br/>
					  状态：<ai:dbformfield fieldname="STATE" formid="staff_form2"/><br/>
					  备注：<ai:dbformfield fieldname="REMARKS" formid="staff_form2" width="300"/><br/>
				    
		</ai:dbform>
		<input type="button" value="保存" onclick="save2()"/>
    	<input type="button" value="删除" onclick="del2()"/>
    </td>
    <td>
    			<ai:dbform formid="staff_form3" setname="com.asiainfo.crm.example.test.web.SETStaff"
				    conditionname="condition1" 
				    parametersname="parameters" 
				    editable="true" 
				    datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				    implservice_name="com.asiainfo.crm.test.service.interfaces.IStaffSV"  
				    implservice_querymethod="queryStaffByCode(String code)"
				    initial="false">
				  	  工号：<ai:dbformfield fieldname="STAFF_ID" formid="staff_form3" editable="true"/><br/>
					  工号：<ai:dbformfield fieldname="CODE" formid="staff_form3" editable="true"/><br/>
					  密码：<ai:dbformfield fieldname="PASSWORD" formid="staff_form3"/><br/>
					  姓名：<ai:dbformfield fieldname="NAME" formid="staff_form3"/><br/>
					  组织：<ai:dbformfield fieldname="ORGANIZE_ID" formid="staff_form3"/><br/>
					  身份证号：<ai:dbformfield fieldname="CERTIFI_CODE" formid="staff_form3" width="300"/><br/>
					  家庭电话：<ai:dbformfield fieldname="HOME_TEL" formid="staff_form3" width="300"/><br/>
					  办公电话：<ai:dbformfield fieldname="OFFICE_TEL" formid="staff_form3" width="300"/><br/>
					  考核标记：<ai:dbformfield fieldname="CHECK_FLAG" formid="staff_form3"/><br/>
					  状态：<ai:dbformfield fieldname="STATE" formid="staff_form3"/><br/>
					  备注：<ai:dbformfield fieldname="REMARKS" formid="staff_form3" width="300"/><br/>
				    
		</ai:dbform>
		<input type="button" value="保存" onclick="save3()"/>
    </td>
  </tr>
</table>



<script type="text/javascript">
	/**
	*获得tblStaff对象
	*@return 获得"tblStaff"对象句柄
	*/
	function getStaffRowset()
	{
		return g_FormRowSetManager.get("staff_form");
	}
	
	/**
	*查询员工数据操作
	*
	*/
	function query2()
	{
		var query_condition = document.getElementById("staff_code").value;
		g_FormRowSetManager.get("staff_form2").refresh("code=" + query_condition);
	}
	
	/**
	*保存员工信息操作
	*
	*/
	function save()
	{
		var list = new Array();
		list.push(getStaffRowset());
		var ud = saveRowSet("<%=request.getContextPath()%>/business/com.asiainfo.crm.example.test.web.StaffAction?action=saveStaff", list);
		if (ud.getValueByName("retVal") == "Y") {
			//清空table中数据
			//getOrganizeRowset().clear();
			alert(ud.getValueByName("retMsg"));
		} else {
			alert(ud.getValueByName("retMsg"));
			return;
		}
	}
	
	function save2()
	{
		var list = new Array();
		list.push(g_FormRowSetManager.get("staff_form2"));
		var ud = saveRowSet("<%=request.getContextPath()%>/business/com.asiainfo.crm.example.test.web.StaffAction?action=saveStaff", list);
		if (ud.getValueByName("retVal") == "Y") {
			alert(ud.getValueByName("retMsg"));
		} else {
			alert(ud.getValueByName("retMsg"));
			return;
		}
	}
	
	function save3()
	{
		var list = new Array();
		list.push(g_FormRowSetManager.get("staff_form3"));
		var ud = saveRowSet("<%=request.getContextPath()%>/business/test.ai.appframe2.testForm.mySaveAction?action=saveStaff",list);
	}
	
	function del2()
	{
		var staff2 = g_FormRowSetManager.get("staff_form2");
		//staff2.setStsToDel();物理删除
		staff2.setValue("state","E",null);
		var list = new Array();
		list.push(staff2);
		var ud = saveRowSet("<%=request.getContextPath()%>/business/com.asiainfo.crm.example.test.web.StaffAction?action=saveStaff", list);
		if (ud.getValueByName("retVal") == "Y") {
			alert(ud.getValueByName("retMsg"));
		} else {
			alert(ud.getValueByName("retMsg"));
			return;
		}
	}
	
</script>
