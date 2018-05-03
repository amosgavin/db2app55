
	/**
	 * ��ȡ����ԱTable
	 */
	function getDBTableOper()
	{
		return g_TableRowSetManager.get("dbTableOperator");
	}
	/**
	 * �����֯�ڵ���ʾ����֯�������Ĳ���Ա
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
		// ��ʼ����ҳ��״̬
		init(0, -1, organizeId, organizeName);
	}
	/**
	 * ������֯��ѯ
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
	 * ��ȡ��ǰ��֯���
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
	 * ����ѡ�еĲ���Ա��ʼ������Ա��Ϣ��
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
	 * ��ѯ����Ա��Ա����Ϣ
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
	 * ������֯��ѯ���һ�������ѯ��ť
	 */
	function QueryByOrg()
	{
		document.getElementById("byorg").style.display="block";
		document.getElementById("bycond").style.display="none";
		g_AIButtonManager.get("byorgbtn").setDisabled(true);
		g_AIButtonManager.get("bycondbtn").setDisabled(false);
	}
	/**
	 * ����������ѯ���һ���֯��ѯ��ť
	 */
	function QueryByCond()
	{
		document.getElementById("byorg").style.display="none";
		document.getElementById("bycond").style.display="block";
		g_AIButtonManager.get("byorgbtn").setDisabled(false);
		g_AIButtonManager.get("bycondbtn").setDisabled(true);
	}
