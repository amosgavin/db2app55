<%@page contentType="text/html; charset=gbk"%>
<%@ include file="/webframe/common/commonhead.jsp"%>

<%
pageContext.getRequest().setAttribute("condition","staff_id=-1");
%>
<table border="1">
  <tr>
    <th>ʵ��1</th>
    <th>ʵ��2</th>
    <th>ʵ��3</th>
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
				  	  ���ţ�<ai:dbformfield fieldname="STAFF_ID" formid="staff_form" editable="true"/><br/>
					  ���ţ�<ai:dbformfield fieldname="CODE" formid="staff_form" editable="true"/><br/>
					  ���룺<ai:dbformfield fieldname="PASSWORD" formid="staff_form"/><br/>
					  ������<ai:dbformfield fieldname="NAME" formid="staff_form"/><br/>
					  ��֯��<ai:dbformfield fieldname="ORGANIZE_ID" formid="staff_form"/><br/>
					  ���֤�ţ�<ai:dbformfield fieldname="CERTIFI_CODE" formid="staff_form" width="300"/><br/>
					  ��ͥ�绰��<ai:dbformfield fieldname="HOME_TEL" formid="staff_form" width="300"/><br/>
					  �칫�绰��<ai:dbformfield fieldname="OFFICE_TEL" formid="staff_form" width="300"/><br/>
					  ���˱�ǣ�<ai:dbformfield fieldname="CHECK_FLAG" formid="staff_form"/><br/>
					  ״̬��<ai:dbformfield fieldname="STATE" formid="staff_form"/><br/>
					  ��ע��<ai:dbformfield fieldname="REMARKS" formid="staff_form" width="300"/><br/>
				    
		</ai:dbform>
		<input type="button" value="����" onclick="save()"/>
	</td>
    <td>
    	Ա�����ţ�
		<input type="text" id="staff_code"/>

		<input type="button" value="��ѯ" onclick="query2()"/><br/>
		<ai:dbform formid="staff_form2" setname="com.asiainfo.crm.example.test.web.SETStaff"
				    conditionname="condition1" 
				    parametersname="parameters" 
				    editable="true" 
				    datamodel="com.ai.appframe2.web.datamodel.MethodModelForService"
				    implservice_name="com.asiainfo.crm.example.test.service.interfaces.IStaffSV"  
				    implservice_querymethod="queryStaffByCode(String code)"
				    initial="false">
				  	  ���ţ�<ai:dbformfield fieldname="STAFF_ID" formid="staff_form2" editable="true"/><br/>
					  ���ţ�<ai:dbformfield fieldname="CODE" formid="staff_form2" editable="true"/><br/>
					  ���룺<ai:dbformfield fieldname="PASSWORD" formid="staff_form2"/><br/>
					  ������<ai:dbformfield fieldname="NAME" formid="staff_form2"/><br/>
					  ��֯��<ai:dbformfield fieldname="ORGANIZE_ID" formid="staff_form2"/><br/>
					  ���֤�ţ�<ai:dbformfield fieldname="CERTIFI_CODE" formid="staff_form2" width="300"/><br/>
					  ��ͥ�绰��<ai:dbformfield fieldname="HOME_TEL" formid="staff_form2" width="300"/><br/>
					  �칫�绰��<ai:dbformfield fieldname="OFFICE_TEL" formid="staff_form2" width="300"/><br/>
					  ���˱�ǣ�<ai:dbformfield fieldname="CHECK_FLAG" formid="staff_form2"/><br/>
					  ״̬��<ai:dbformfield fieldname="STATE" formid="staff_form2"/><br/>
					  ��ע��<ai:dbformfield fieldname="REMARKS" formid="staff_form2" width="300"/><br/>
				    
		</ai:dbform>
		<input type="button" value="����" onclick="save2()"/>
    	<input type="button" value="ɾ��" onclick="del2()"/>
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
				  	  ���ţ�<ai:dbformfield fieldname="STAFF_ID" formid="staff_form3" editable="true"/><br/>
					  ���ţ�<ai:dbformfield fieldname="CODE" formid="staff_form3" editable="true"/><br/>
					  ���룺<ai:dbformfield fieldname="PASSWORD" formid="staff_form3"/><br/>
					  ������<ai:dbformfield fieldname="NAME" formid="staff_form3"/><br/>
					  ��֯��<ai:dbformfield fieldname="ORGANIZE_ID" formid="staff_form3"/><br/>
					  ���֤�ţ�<ai:dbformfield fieldname="CERTIFI_CODE" formid="staff_form3" width="300"/><br/>
					  ��ͥ�绰��<ai:dbformfield fieldname="HOME_TEL" formid="staff_form3" width="300"/><br/>
					  �칫�绰��<ai:dbformfield fieldname="OFFICE_TEL" formid="staff_form3" width="300"/><br/>
					  ���˱�ǣ�<ai:dbformfield fieldname="CHECK_FLAG" formid="staff_form3"/><br/>
					  ״̬��<ai:dbformfield fieldname="STATE" formid="staff_form3"/><br/>
					  ��ע��<ai:dbformfield fieldname="REMARKS" formid="staff_form3" width="300"/><br/>
				    
		</ai:dbform>
		<input type="button" value="����" onclick="save3()"/>
    </td>
  </tr>
</table>



<script type="text/javascript">
	/**
	*���tblStaff����
	*@return ���"tblStaff"������
	*/
	function getStaffRowset()
	{
		return g_FormRowSetManager.get("staff_form");
	}
	
	/**
	*��ѯԱ�����ݲ���
	*
	*/
	function query2()
	{
		var query_condition = document.getElementById("staff_code").value;
		g_FormRowSetManager.get("staff_form2").refresh("code=" + query_condition);
	}
	
	/**
	*����Ա����Ϣ����
	*
	*/
	function save()
	{
		var list = new Array();
		list.push(getStaffRowset());
		var ud = saveRowSet("<%=request.getContextPath()%>/business/com.asiainfo.crm.example.test.web.StaffAction?action=saveStaff", list);
		if (ud.getValueByName("retVal") == "Y") {
			//���table������
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
		//staff2.setStsToDel();����ɾ��
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
