  	/**
  	 * ��ʼ��
  	 */
  	function init(operId, stId, orgId, orgName)
  	{
  		// ��ѯ����Ա��λ��ϵ
  		if(operId != 0)
  		{
	  		var dbTableOpStation = g_TableRowSetManager.get("DBTableOpStation");
			dbTableOpStation.refresh("refresh", "operId="+operId+"&stId="+stId);
			g_AIButtonManager.get("onStationBtn").setDisabled(false);
			g_AIButtonManager.get("offStationBtn").setDisabled(false);
		}
  	}
  	
	