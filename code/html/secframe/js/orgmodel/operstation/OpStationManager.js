  	/**
  	 * 初始化
  	 */
  	function init(operId, stId, orgId, orgName)
  	{
  		// 查询操作员岗位关系
  		if(operId != 0)
  		{
	  		var dbTableOpStation = g_TableRowSetManager.get("DBTableOpStation");
			dbTableOpStation.refresh("refresh", "operId="+operId+"&stId="+stId);
			g_AIButtonManager.get("onStationBtn").setDisabled(false);
			g_AIButtonManager.get("offStationBtn").setDisabled(false);
		}
  	}
  	
	