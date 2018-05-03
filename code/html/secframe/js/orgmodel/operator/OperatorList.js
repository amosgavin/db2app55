
	/**
	 * 获取操作员Table
	 */
	function getDBTableOper()
	{
		return g_TableRowSetManager.get("dbTableOperator");
	}
	/**
	 * 点击组织节点显示该组织所包含的操作员
	 */
	function treeNodeClick()
	{
		var orgTree = g_DBTreeNewManager.get("orgTree");
		var curNode = orgTree.getCurNodeInfo();
		var organizeId = curNode.value;
		var organizeName = curNode.text;
		var dbTableOper = getDBTableOper();
		if(organizeId == -1)
		{
			return;
		}
		dbTableOper.refresh("refresh","organizeId="+organizeId);
		// 初始化子页面状态
		init(0, -1, organizeId, organizeName);
	}
	/**
	 * 根据组织查询
	 */
	function refreshStaff()
	{	
		var orgTree = g_DBTreeNewManager.get("orgTree");
		var curNode = orgTree.getCurNodeInfo();
		var organizeId = curNode.value;
		var dbTableOper = getDBTableOper();
		dbTableOper.refresh("refresh","organizeId="+organizeId);
	}
	/**
	 * 获取当前组织编号
	 */
	function getCurrentOrgId()
	{
		var orgTree = g_DBTreeNewManager.get("orgTree"); 
		var curNode = orgTree.getCurNodeInfo();
		if(null==curNode||""==curNode) {
			return ;
		}
		return curNode.value;
	}
	/**
	 * 根据选中的操作员初始化操作员信息区
	 */
	function selectOperator(){
		var dbTableOper = getDBTableOper();
		var operId = dbTableOper.getValue(dbTableOper.getRow(),"OPERATOR_ID");
		var curOrgId = dbTableOper.getValue(dbTableOper.getRow(),"ORGANIZE_ID");
		var orgTree = g_DBTreeNewManager.get("orgTree");
		var curNode = orgTree.getCurNodeInfo();
		var organizeName = "";
		if (curNode != null) {			
			organizeName = curNode.text;
		} else {
			organizeName = dbTableOper.getValue(dbTableOper.getRow(),"ORGANIZE_NAME");
		}
		init(operId, -1, curOrgId, organizeName);
	}
	/**
	 * 查询操作员与员工信息
	 */
	function searchOperatorStaff(){
		var dbTableOper = getDBTableOper(); 
		var name = document.getElementById("name").value;
		var code = document.getElementById("code").value;
		var bill = document.getElementById("billId").value;
		
		var nameCond = "";
		var codeCond = "";
		var billCond="";
		
		var flag = false;
		
		if(name != null && name != "")
		{
			name = encodeURI(name); 
			name = encodeURI(name);
			nameCond = "name="+name;
		}
		if(code != null && code != "")
		{
			codeCond = "code="+code;
		}
		if(bill != null && bill != "")
		{
			billCond = "billId="+bill;
		}
		var cond = "";
		if(nameCond != "")
		{
			cond = cond + nameCond;
			flag = true;
		}
		
		if(codeCond != "")
		{
			if(flag)
			{
				cond = cond +"&"+ codeCond;
			}
			else 
			{
				cond = cond +  codeCond;
				flag = true;
			}
		}
		if(billCond != "")
		{
			if(flag)
			{
				cond = cond +"&"+ billCond;
			}
			else 
			{
				cond = cond +  billCond;
				flag = true;
			}
		}
		
		if(cond == "")
		{
			alert(g_I18NMessage("secframe_common", "condition_empty"));
			return ;
		}
		dbTableOper.refresh("refresh",cond);		
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
