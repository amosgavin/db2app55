<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
  <head>
    <title><i18n:message key="staffselect.selstaff" res="i18n.secframe_resource"/></title>
  </head>
  <body onload="initPage()">
  <table width="98%" align="center" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="230" valign="top">
		<ai:contractframe id="contractframe2" contenttype="table" title="staffselect.staffsel" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
	         <ai:contractitem>
                <div class="t-bot-mc-button">
					<ai:button id="byorgbtn"  text="staffselect.org" i18nRes="i18n.secframe_resource"  onclick="QueryByOrg()"/>
                  	<ai:button id="bycondbtn" text="staffselect.condition" i18nRes="i18n.secframe_resource"  onclick="QueryByCond()"/>
				</div>
				</ai:contractitem>
          <div id="bycond" style="display: none;">
                  <table width="98%" align="center" border="0" cellpadding="1" cellspacing="2">
                      <tr>
                        <td class="td_font"><i18n:message key="staffselect.name" res="i18n.secframe_resource"/></td>
                        <td><input value="" type="text" id="name" class="input" style="width:150px;"/>
                        </td>
                      </tr>
                      <%--<tr>
                        <td class="td_font"><i18n:message key="staffselect.email" res="i18n.secframe_resource"/></td>
                        <td><input type="text"  value="" id="email" class="input" style="width:150px;"/>
                        </td>
                      </tr>
                      <tr>
                        <td class="td_font"><i18n:message key="staffselect.mobile" res="i18n.secframe_resource"/></td>
                        <td><input type="text"  value="" id="billId" class="input" style="width:150px;"/></td>
                      </tr>--%>
                    </table>
                  <div class="area_button">
                  <ai:button text="staffselect.search" i18nRes="i18n.secframe_resource" id="searchOperBtn" onclick="searchStaff()"/>
                  </div>
            </div>
            <div id="byorg" >
            <table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
	              <ai:dbtree_new id="orgStaffTree" datamodel="com.ai.secframe.orgmodel.web.SecOrgCodeTreeModel" 
						multiselect="false" height="450" width="100%" ishaveline="true" 
						onselect="orgTreeNodeClick"/>
								</td>
							</tr>
						</table>
			</div>
          </ai:contractframe> 
		</td>
		<td align="right" valign="top" >
			<ai:contractframe id="contractframe1" contenttype="table" title="staffselect.stafflist" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
	         <ai:contractitem/>
          	 <ai:table tableid="dbTableExistStaff"
						setname="com.asiainfo.sale.common.web.SETWFOperator"
			            tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			            implservice_name="com.asiainfo.sale.common.service.interfaces.IOperatorInfoSV"
			            implservice_querymethod="getOperatorInfo(String staffName, String orgId, int $STARTROWINDEX, int $ENDROWINDEX)"
			            implservice_countmethod="getCountByOrgId(String staffName, String orgId)"
			            ondbclick="doReturn" onrowchange="onrowchange"
						initial="false" editable="false" pagesize="50"
						width="390" height="362" needrefresh="true" footdisplay="true">
                      <ai:col fieldname="OPERATOR_ID" visible="false"/>
					  <ai:col fieldname="STAFF_ID" visible="false"/>
                      <ai:col fieldname="CODE" visible="false"/>
					  <ai:col fieldname="STAFF_NAME" width="130" visible="true"/>
		              <ai:col fieldname="ORGANIZE_NAME" width="120" visible="true"/>
                      <ai:col fieldname="ORGANIZE_NAME_P" width="120" visible="true"/>
            	</ai:table>
     		</ai:contractframe>
            <div class="area_button">
                <ai:button text="确定" id="bt_doReturn" onclick="doReturn()"/>
                <ai:button text="取消" id="bt_cancel" onclick="cancel()"/>
            </div> 
		</td>
	</tr>
</table>
  </body>
  <script type="text/javascript">
    function cancel()
	{	
		window.self.close();
	}
	
  	function getDbTableExistStaff()
	{
		return g_TableRowSetManager.get("dbTableExistStaff");
	}
  	
    function initPage(){// 显示员工列表
        var orgId = "<%=request.getParameter("orgId")%>";
        if(null != orgId && "null" != orgId && "" != orgId && undefined != orgId && "undefined" != orgId){
            getDbTableExistStaff().refresh("orgId="+orgId);
        }
    }
    
    function onrowchange(oldIndex,newIndex){
    	if(-1 != oldIndex) {
    		getDbTableExistStaff().setRowBgColor(oldIndex,"");
    	}
    	getDbTableExistStaff().setRowBgColor(newIndex,"yellow");
    }
    
	/**
	 * 点击组织节点显示该组织下的员工
	 */
	function orgTreeNodeClick(organizeId, organizeName, treeUserObj, treeNodeType)
	{
		var dbTableExistStaff = getDbTableExistStaff();
		if(organizeId == -1)
		{
			return;
		}
		// 显示员工列表
		dbTableExistStaff.refresh("orgId="+organizeId);
	}
	
	
function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g, '');
}
    /**
     * 查询操作员与员工信息
     */
    function searchStaff(){
        var dbTableStaff = getDbTableExistStaff(); 
        var name = document.getElementById("name").value;
        var roleId = "<%=request.getParameter("roleId")%>";
        var orgId = "<%=request.getParameter("orgId")%>";
        var nameCond = "";
        var roleIdCond = "";
        var orgIdCond="";
        
        var flag = false;
        if(name != null && name != "" && undefined != name && 'undefined' != name)
        {
            name = encodeURI(trim(name)); 
            nameCond = "staffName="+name;
        }
        if(roleId != null && roleId != "" && undefined != roleId && 'undefined' != roleId)
        {
            roleIdCond = "roleId="+roleId;
        }
        if(orgId != null && orgId != "" && undefined != orgId && 'undefined' != orgId)
        {
            orgIdCond = "orgId="+orgId;
        }
        var cond = "";
        if(nameCond != "")
        {
            cond = cond + nameCond;
            flag = true;
        }
        
        if(roleIdCond != "")
        {
            if(flag)
            {
                cond = cond +"&"+ roleIdCond;
            }
            else 
            {
                cond = cond +  roleIdCond;
                flag = true;
            }
        }
        if(orgIdCond != "")
        {
            if(flag)
            {
                cond = cond +"&"+ orgIdCond;
            }
            else 
            {
                cond = cond +  orgIdCond;
                flag = true;
            }
        }
        
        if(cond == "")
        {
            alert(g_I18NMessage("secframe_operator", "sec_operator_condition_empty"));
            return ;
        }
        dbTableStaff.refresh(cond);
    }
	/**
	 * 根据组织查询，灰化条件查询按钮
	 */
	function QueryByOrg()
	{
		document.getElementById("byorg").style.display="block";
		document.getElementById("bycond").style.display="none";
		g_AIButtonManager.get("byorgbtn").setDisabled(true);
		g_AIButtonManager.get("bycondbtn").setDisabled(false);
	}
	/**
	 * 根据条件查询，灰化组织查询按钮
	 */
	function QueryByCond()
	{
		document.getElementById("byorg").style.display="none";
		document.getElementById("bycond").style.display="block";
		g_AIButtonManager.get("byorgbtn").setDisabled(false);
		g_AIButtonManager.get("bycondbtn").setDisabled(true);
	}
	//g_AIButtonManager.get("byorgbtn").setDisabled(true);
	
</script>
<script type="text/javascript">
	var _sourceElementsTable = g_TableRowSetManager.get("dbTableExistStaff");

    /**
     * 选择已有的员工
     */
    function doReturn()
    {
	      var i = getDbTableExistStaff().getRow();
	      if(-1 != i)
	      {
	          var staffJSON = {"elements":[]};
	          staffJSON.elements.push({
	                                      "operatorId":_sourceElementsTable.getValue(i, "OPERATOR_ID"),
	                                      "staffId":_sourceElementsTable.getValue(i, "STAFF_ID"),
	                                      "code":_sourceElementsTable.getValue(i, "CODE"),
	                                      "name":_sourceElementsTable.getValue(i, "STAFF_NAME"),
                                          "orgName":_sourceElementsTable.getValue(i, "ORGANIZE_NAME"),
                                          "orgNameP":_sourceElementsTable.getValue(i, "ORGANIZE_NAME_P")
	                                  });
	          window.returnValue = staffJSON;
	          cancel();
	      } else {
	          alert("请选择员工");
	      }
    }
    
	function remove()
	{
	    if( _selectElementsTable.getSelectedRows()!=null&&_selectElementsTable.getSelectedRows().length>0)
	    {
	  		for(var i=0;i < _selectElementsTable.count();i++)
	  		{
			    if(_selectElementsTable.isSelected(i))
			    {
				    _selectElementsTable.deleteRow(i);
				    i--;
				}
         	}
		 }
		 else
		 {
		  alert("请选择要删除的对象！");
		  //alert(g_I18NMessage("secframe_role_exclude" , "sec_role_exclude_selexclude"));
		 }
	   
	}
	
	function add()
	{
	    if( _sourceElementsTable.getSelectedRows()!=null&&_sourceElementsTable.getSelectedRows().length>0)
	    {
		 		var selRows = _sourceElementsTable.getSelectedRows();
		  		for(var i=0;i<selRows.length;i++)
		  		{
		  			if (!isInTable(_selectElementsTable,"STAFF_ID",_sourceElementsTable.getValue(selRows[i],"STAFF_ID")))
		  			{
				  		_selectElementsTable.newRow(false);
                        _selectElementsTable.setValue(_selectElementsTable.getRow(),"CODE",_sourceElementsTable.getValue(selRows[i],"CODE"),_sourceElementsTable.getValue(selRows[i],"STAFF_ID"));
                        _selectElementsTable.setValue(_selectElementsTable.getRow(),"OPERATOR_ID",_sourceElementsTable.getValue(selRows[i],"OPERATOR_ID"),_sourceElementsTable.getValue(selRows[i],"STAFF_ID"));
					    _selectElementsTable.setValue(_selectElementsTable.getRow(),"STAFF_ID",_sourceElementsTable.getValue(selRows[i],"STAFF_ID"),_sourceElementsTable.getValue(selRows[i],"STAFF_ID"));
			            _selectElementsTable.setValue(_selectElementsTable.getRow(),"STAFF_NAME",_sourceElementsTable.getValue(selRows[i],"STAFF_NAME"),_sourceElementsTable.getValue(selRows[i],"STAFF_NAME"));	            
						_selectElementsTable.setValue(_selectElementsTable.getRow(),"ORGANIZE_NAME",_sourceElementsTable.getValue(selRows[i],"ORGANIZE_NAME"),_sourceElementsTable.getValue(selRows[i],"ORGANIZE_NAME"));
		  				
		  			}
		  		}
		  		/**
		  		for(var i=0;i < _sourceElementsTable.count();i++)
		  		{
				    if(_sourceElementsTable.isSelected(i))
				    {
					    _sourceElementsTable.deleteRow(i);
					    i--;
					}
	         	}
		  		*/
		 }
		 else
		 {
		  alert("请选择要添加的对象！");
		  //alert(g_I18NMessage("secframe_role_exclude" , "sec_role_exclude_delexclude"));
		 }
	    
	}
	
	function addThis(){
        var row =_sourceElementsTable.getRow();
		 
        if (!isInTable(_selectElementsTable,"STAFF_ID",_sourceElementsTable.getValue(row,"STAFF_ID")))
        {
	        _selectElementsTable.newRow(false);
	        _selectElementsTable.setValue(_selectElementsTable.getRow(),"CODE",_sourceElementsTable.getValue(row,"CODE"),_sourceElementsTable.getValue(row,"STAFF_ID"));
	        _selectElementsTable.setValue(_selectElementsTable.getRow(),"OPERATOR_ID",_sourceElementsTable.getValue(row,"OPERATOR_ID"),_sourceElementsTable.getValue(row,"STAFF_ID"));
	        _selectElementsTable.setValue(_selectElementsTable.getRow(),"STAFF_ID",_sourceElementsTable.getValue(row,"STAFF_ID"),_sourceElementsTable.getValue(row,"STAFF_ID"));
	        _selectElementsTable.setValue(_selectElementsTable.getRow(),"STAFF_NAME",_sourceElementsTable.getValue(row,"STAFF_NAME"),_sourceElementsTable.getValue(row,"STAFF_NAME"));                
	        _selectElementsTable.setValue(_selectElementsTable.getRow(),"ORGANIZE_NAME",_sourceElementsTable.getValue(row,"ORGANIZE_NAME"),_sourceElementsTable.getValue(row,"ORGANIZE_NAME"));
        }
	}
	
    function delThis(){
        _selectElementsTable.deleteRow(_selectElementsTable.getCurRowIndex());
    }
	
	function isInTable(selectElementsTable,itemName,value)
	{
		for(var i=0;i < selectElementsTable.count();i++)
  		{
		    if(selectElementsTable.getValue(i,itemName) == value)
		    {
			    return true;
			}
        }
	}
	
	//接收返回方法示例
	function getSelectElements()
	{
		var url = "<%=request.getContextPath()%>/secframe/orgmodel/operator/StaffSelect_s.jsp";
		var result = window.showModalDialog(url, null, "scroll:no;resizable:no;help:no;status:no;dialogHeight:490px;dialogWidth:560px");
		if(result != null){
			var value;
			var text;
	   		for(var i=0;i < result.elements.length;i++)
	  		{
	  			if (i == 0)
	  			{
		  			value = result.elements[i].value;
		  			text = result.elements[i].text;
	  			} else {
		  			value = value + "," + result.elements[i].value;
		  			text = text + "," + result.elements[i].text;
	  			}
	  		}
		  		
			alert("value=" + value);
			alert("text=" + text);
		}
	} 
  </script>
  
</html>
