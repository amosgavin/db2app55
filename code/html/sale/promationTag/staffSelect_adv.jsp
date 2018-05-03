<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/appframe2.tld" prefix="ai"%>
<%@ taglib uri="/WEB-INF/appframe-i18n.tld" prefix="i18n" %>
<%@ include file="/webframe/common/commonhead.jsp"%>
<html>
  <head>
    <title><i18n:message key="staffselect.selstaff" res="i18n.secframe_resource"/></title>
  </head>
  <body onload='initTree()'>
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
            <table width="99%" id="orgTree" align="center" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
	              <ai:dbtree_new id="orgStaffTree" datamodel="com.ai.secframe.orgmodel.web.SecOrgCodeTreeModel" 
						multiselect="true" height="550" width="100%" ishaveline="true" explanonselect="false"
						onselect="orgTreeNodeClick" oncheckboxclick="ckboxClick"/>
								</td>
							</tr>
						</table>
			</div>
          </ai:contractframe> 
		</td>
		<td align="right" valign="top" >
			<ai:contractframe id="contractframe1" contenttype="table" title="staffselect.stafflist" i18nRes="i18n.secframe_resource" width="100%" allowcontract="false" frameclosed="false">
	         <ai:contractitem><ai:button text="设为选中" id="cancel" onclick="add()"/></ai:contractitem>
          	 <ai:table tableid="dbTableExistStaff"
						setname="com.asiainfo.sale.common.web.SETWFOperator"
			            tablemodel="com.ai.appframe2.web.datamodel.MethodModelForService"
			            implservice_name="com.asiainfo.sale.common.service.interfaces.IOperatorInfoSV"
			            implservice_querymethod="getOperatorInfo(String staffName, String orgId, int $STARTROWINDEX, int $ENDROWINDEX)"
			            implservice_countmethod="getCountByOrgId(String staffName, String orgId)"
			            onrowselected="onSelect" onafterturnpage="resetCheck"
						initial="false" multiselect="true" editable="false" pagesize="50"
						width="390" height="262" needrefresh="true" footdisplay="true">
                      <ai:col fieldname="OPERATOR_ID" visible="false"/>
					  <ai:col fieldname="STAFF_ID" visible="false"/>
                      <ai:col fieldname="CODE" visible="false"/>
					  <ai:col fieldname="STAFF_NAME" width="130" visible="true"/>
		              <ai:col fieldname="ORGANIZE_NAME" width="120" visible="true"/>
                      <ai:col fieldname="ORGANIZE_NAME_P" width="120" visible="true"/>
            	</ai:table>
     		</ai:contractframe>
	     		<ai:contractframe id="contractframe1" contenttype="table" title="已选中的员工" width="100%" allowcontract="false" frameclosed="false">
			         <ai:contractitem>
                <ai:button text="删除" id="cancel" onclick="remove()"/></ai:contractitem>
		          	 <ai:table tableid="selectElementTable"
							setname="com.asiainfo.sale.common.web.SETWFOperator"
							initial="false" multiselect="true" editable="false"
							ondbclick="delThis"
							width="390" height="120" needrefresh="true" footdisplay="true">
                      <ai:col fieldname="OPERATOR_ID" visible="false"/>
                      <ai:col fieldname="STAFF_ID" visible="false"/>
                      <ai:col fieldname="CODE" visible="false"/>
                      <ai:col fieldname="STAFF_NAME" width="130" visible="true"/>
                      <ai:col fieldname="ORGANIZE_NAME" width="120" visible="true"/>
                      <ai:col fieldname="ORGANIZE_NAME_P" width="120" visible="true"/>
            	</ai:table> 
     		</ai:contractframe> 
			<div class="area_button">
				<ai:button text="确定" id="cancel" onclick="doReturn()"/>
				<ai:button text="orgrelat.cancel" i18nRes="i18n.secframe_resource" id="cancel" onclick="cancel()"/>
			</div>
		</td>
	</tr>
</table>
  </body>
  <script type="text/javascript">
  
  	var dbTree = g_DBTreeNewManager.get("orgStaffTree");
	var workflowId = "<%=request.getParameter("workflowId")%>";
	
	var orgIds;
	var orgStr;
	
	function initTree()
	{
		var orgInit = "<%=request.getParameter("orgInit")%>";
		if ("false" == orgInit) {
			return;
		}
		var strUrl = '<%=request.getContextPath()%>/business/com.asiainfo.sale.common.web.AppriseAction?action=getAppriseOrgIds&workflowId=' + workflowId;
    	var ret = PostInfo(strUrl, null);
    	orgStr = ret.getValueByName("orgStr");
    	if (orgStr == null || orgStr == ''){
    		return;
    	}
    	orgIds = orgStr.split(',');
		//dbTree.setCheckBoxSts(pTreeNodeVal,pFlag);
		dbTree.expandNodeByValue(10, 'true');
		for (var i = 0; i < orgIds.length; ++i){
			//dbTree.expandNodeByValue((orgIds[i], 'true');
			dbTree.expandNodeByValue((orgIds[i].toString()).substr(0,2), 'true');
			if((orgIds[i].toString()).length == 6){
				dbTree.expandNodeByValue((orgIds[i].toString()).substr(0,4), 'true');
			}
			dbTree.expandNodeByValue(orgIds[i], 'true');
		}
		for (var j = 0; j < orgIds.length; ++j){
			dbTree.setNodeChecked(orgIds[j], 'true');
		}
		disableckbox();
	}
	
	function disableckbox() 
	{ 
	  var form = document.getElementById("orgTree").getElementsByTagName("input");
      for (var i=0; i < form.length; i++) {
    	form[i].disabled=true; 
      }
      return;
     } 
	
	function dbclick()
	{
		//disableckbox();
		return;
	}
	
	function ckboxClick()
	{
		
		if (orgStr == null || orgStr == ''){
    		return;
    	}
		var checkNodes = dbTree.getCheckedNodesInfo();
		for (var i=0; i<checkNodes.length; ++i){
			var isNV = true;
			for (var j=0; j<orgIds.length; ++j){
				if (checkNodes[i].value==orgIds[j]){
					isNV = false;
				}
			}
			if (isNV){
				dbTree.setNodeChecked(checkNodes[i].value,false);
			}
		}
		disableckbox();
	}
	
    function cancel()
	{	
		window.self.close();
	}
	
  	function getDbTableExistStaff()
	{
		return g_TableRowSetManager.get("dbTableExistStaff");
	}
  	
  	var tmpOrganizeId = "";
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
		var curNode = dbTree.getCurNodeInfo();
		var isChecked = false;
		if (orgStr == null || orgStr == ''){
    		isChecked = true;
    	} else {
			for (var j = 0; j < orgIds.length; ++j){
				if (curNode.value == orgIds[j]){
					isChecked = true;
					break;
				}
			}
		}
		if (isChecked){
			// 显示员工列表
			dbTableExistStaff.refresh("orgId="+organizeId);
			resetCheck();
		} else {
			
		}
		return;
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
        if(name != null && name != "")
        {
            name = encodeURI(name); 
            nameCond = "staffName="+name;
        }
        if(roleId != null && roleId != "")
        {
            roleIdCond = "roleId="+roleId;
        }
        if(orgId != null && orgId != "")
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
	var _selectElementsTable = g_TableRowSetManager.get("selectElementTable");

    /**
     * 选择已有的员工
     */
    function doReturn()
    {
        if(_selectElementsTable.count() > 0)
        {
            var staffJSON = {"elements":[]};
            for(var i=0;i<_selectElementsTable.count();i++)
            {
                staffJSON.elements.push({
                                            "operatorId":_selectElementsTable.getValue(i, "OPERATOR_ID"),
                                            "staffId":_selectElementsTable.getValue(i, "STAFF_ID"),
                                            "code":_selectElementsTable.getValue(i, "CODE"),
                                            "name":_selectElementsTable.getValue(i, "STAFF_NAME")
                                        });
            }
            window.returnValue = staffJSON;
            window.self.close();
        }
    }
    
    var isBreak = true;
    
	function onSelect(rowIndex,isSelected)
	{
	   if(-100 == rowIndex){
		   if(isSelected){
			   add();
		   }else{
	           if(_sourceElementsTable.count() > 0)
	           {
		            for(var i=0;i<_sourceElementsTable.count();i++)
		            {
		                delThis("",_sourceElementsTable.getValue(i,"CODE"),false);
		            }
	           }
		   }
		   return;
	   }
	   if(isBreak){
		   return;
	   }
	   if(isSelected){
            addThis(rowIndex);
	   } else {
            delThis("",_sourceElementsTable.getValue(rowIndex,"CODE"),false);
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
	   resetCheck();
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
                        _selectElementsTable.setValue(_selectElementsTable.getRow(),"CODE",_sourceElementsTable.getValue(selRows[i],"CODE"),_sourceElementsTable.getValue(selRows[i],"CODE"));
                        _selectElementsTable.setValue(_selectElementsTable.getRow(),"OPERATOR_ID",_sourceElementsTable.getValue(selRows[i],"OPERATOR_ID"),_sourceElementsTable.getValue(selRows[i],"OPERATOR_ID"));
					    _selectElementsTable.setValue(_selectElementsTable.getRow(),"STAFF_ID",_sourceElementsTable.getValue(selRows[i],"STAFF_ID"),_sourceElementsTable.getValue(selRows[i],"STAFF_ID"));
			            _selectElementsTable.setValue(_selectElementsTable.getRow(),"STAFF_NAME",_sourceElementsTable.getValue(selRows[i],"STAFF_NAME"),_sourceElementsTable.getValue(selRows[i],"STAFF_NAME"));	            
						_selectElementsTable.setValue(_selectElementsTable.getRow(),"ORGANIZE_NAME",_sourceElementsTable.getValue(selRows[i],"ORGANIZE_NAME"),_sourceElementsTable.getValue(selRows[i],"ORGANIZE_NAME"));
                        _selectElementsTable.setValue(_selectElementsTable.getRow(),"ORGANIZE_NAME_P",_sourceElementsTable.getValue(selRows[i],"ORGANIZE_NAME_P"),_sourceElementsTable.getValue(selRows[i],"ORGANIZE_NAME_P"));
		  				
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
	
	function addThis(rowIndex){
        var row = rowIndex;
		if ("" == (row+"")){
			row =_sourceElementsTable.getRow();
		}
		 
        if (!isInTable(_selectElementsTable,"STAFF_ID",_sourceElementsTable.getValue(row,"STAFF_ID")))
        {
	        _selectElementsTable.newRow(false);
	        
	        //alert(row+"~"+_sourceElementsTable.getValue(row,"CODE"));
	        _selectElementsTable.setValue(_selectElementsTable.getRow(),"CODE",_sourceElementsTable.getValue(row,"CODE"),_sourceElementsTable.getValue(row,"CODE"));
	        _selectElementsTable.setValue(_selectElementsTable.getRow(),"OPERATOR_ID",_sourceElementsTable.getValue(row,"OPERATOR_ID"),_sourceElementsTable.getValue(row,"OPERATOR_ID"));
	        _selectElementsTable.setValue(_selectElementsTable.getRow(),"STAFF_ID",_sourceElementsTable.getValue(row,"STAFF_ID"),_sourceElementsTable.getValue(row,"STAFF_ID"));
	        _selectElementsTable.setValue(_selectElementsTable.getRow(),"STAFF_NAME",_sourceElementsTable.getValue(row,"STAFF_NAME"),_sourceElementsTable.getValue(row,"STAFF_NAME"));                
	        _selectElementsTable.setValue(_selectElementsTable.getRow(),"ORGANIZE_NAME",_sourceElementsTable.getValue(row,"ORGANIZE_NAME"),_sourceElementsTable.getValue(row,"ORGANIZE_NAME"));
	        _selectElementsTable.setValue(_selectElementsTable.getRow(),"ORGANIZE_NAME_P",_sourceElementsTable.getValue(row,"ORGANIZE_NAME_P"),_sourceElementsTable.getValue(row,"ORGANIZE_NAME_P"));
        }
	}
	
    function delThis(rowIndex,code,flag){
    	var row = rowIndex;
    	if ("" == (row+"")){
    		row = _selectElementsTable.getCurRowIndex();
    	} 
    	if ("" != code){
	        if(_selectElementsTable.count() > 0)
	        {
	            for(var i=0;i<_selectElementsTable.count();i++)
	            {
	                if (code == _selectElementsTable.getValue(i, "CODE")) {
	                	row = i;
	                	break;
	                }
                    row = "";
	            }
	        }
    	}
    	//alert(row+"~"+_selectElementsTable.getValue(i, "CODE"));
    	if ("" == (row+"")){
    		return;
    	}
        _selectElementsTable.deleteRow(row);
        
        if(undefined == flag||flag){
            resetCheck();
        }
    }
	
    function resetCheck(){
    	isBreak = true;
        if(_sourceElementsTable.count() > 0)
        {
            for(var i=0;i<_sourceElementsTable.count();i++)
            {
                _sourceElementsTable.rowSelected(i,false);
            }
        }
        isBreak = false;
        if(_selectElementsTable.count() > 0)
        {
            for(var i=0;i<_selectElementsTable.count();i++)
            {
                doCleck(_selectElementsTable.getValue(i, "CODE"));
            }
        }
    }
    
    function doCleck(value){
        if(_sourceElementsTable.count() > 0)
        {
            for(var i=0;i<_sourceElementsTable.count();i++)
            {
                if (value == _sourceElementsTable.getValue(i, "CODE")) {
                    _sourceElementsTable.rowSelected(i,true);
                    break;
                }
            }
        }
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
