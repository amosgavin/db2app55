 	
 	/**
  	 * ���ݰ����͸ı�Label
  	 */
    function changeLabel(pFieldName,pOldVal,pNewVal,DBFormPK)
    {
		if(pFieldName=='BAND_TYPE')
		{
			if(pNewVal=='4' || pNewVal=='5')
			{//����
				document.getElementById("ipBeginTd").innerText=g_I18NMessage("secframe_ipmacband", "sec_ipmacband_ip_begin");
				document.getElementById("ipEndTd").innerText=g_I18NMessage("secframe_ipmacband", "sec_ipmacband_ip_end");
			} else {
				document.getElementById("ipBeginTd").innerText=g_I18NMessage("secframe_ipmacband", "sec_ipmacband_ip_address");
				document.getElementById("ipEndTd").innerText=g_I18NMessage("secframe_ipmacband", "sec_ipmacband_mac_address");
			}
		}
	}
 	/**
  	 * ��ʼ��
  	 */
  	function init(operId, stId, orgId, orgName)
  	{
  		// ��ѯ����ԱIPMAC�󶨹�ϵ
  		if(operId != 0 && operId != "")
  		{
	  		var dbTableOpIPMac = g_TableRowSetManager.get("DBTableOpIPMac");
			dbTableOpIPMac.refresh("refresh", "operId="+operId);
			var bandForm = g_FormRowSetManager.get("DBFormOpIPMac");
	  		bandForm.setValue("IP", "");
	  		bandForm.setValue("MAC", "");
	  		bandForm.setValue("BAND_TYPE", "");
	  		bandForm.setValue("OPERATOR_IPMAC_BAND_ID", "");
		}
  	}
  	/**
  	 * ����
  	 */
  	function addIPMacBand()
  	{
  		var dbTableOper = getDBTableOper();
  		var operId = dbTableOper.getValue(dbTableOper.getRow(),"OPERATOR_ID");
  		if(operId == "")
  		{
  			alert(g_I18NMessage("secframe_ipmacband", "sec_ipmacband_select_operator"));
  			return;
  		}
  		var bandForm = g_FormRowSetManager.get("DBFormOpIPMac");
  		bandForm.setColEditSts("IP", true);
  		bandForm.setColEditSts("MAC", true);
  		bandForm.setColEditSts("BAND_TYPE", true);
  		bandForm.setValue("IP", "");
  		bandForm.setValue("MAC", "");
  		bandForm.setValue("BAND_TYPE", "");
  		bandForm.setValue("OPERATOR_IPMAC_BAND_ID", "");
  		g_AIButtonManager.get("saveBtn").setDisabled(false);
  		bandForm.setFocus("IP");
  	}
  	/**
  	 * �༭
  	 */
  	function editIPMacBand()
  	{
  		var dbTableOpIPMac = g_TableRowSetManager.get("DBTableOpIPMac");
  		var curRow = dbTableOpIPMac.getRow();
  		var bandForm = g_FormRowSetManager.get("DBFormOpIPMac");
  		// ��ʼ��
  		bandForm.setValue("IP", dbTableOpIPMac.getValue(curRow, "IP"));
  		bandForm.setValue("MAC", dbTableOpIPMac.getValue(curRow, "MAC"));
  		bandForm.setValue("BAND_TYPE", dbTableOpIPMac.getValue(curRow, "BAND_TYPE"));
  		bandForm.setValue("OPERATOR_IPMAC_BAND_ID", dbTableOpIPMac.getValue(curRow, "OPERATOR_IPMAC_BAND_ID"));
		bandForm.setColEditSts("IP", true);
  		bandForm.setColEditSts("MAC", true);
  		bandForm.setColEditSts("BAND_TYPE", true);
  		g_AIButtonManager.get("saveBtn").setDisabled(false);
  	}
  	
  	/**
  	 * У��IP��ַ��MAC��ַ�ĺϷ���
  	 */
  	function checkIpMac(ip, mac, bandType)
  	{
  		var bandForm = g_FormRowSetManager.get("DBFormOpIPMac");
  		if(ip == "")
  		{	
  			alert(g_I18NMessage("secframe_ipmacband", "sec_ipmacband_ip_notnull"));
  			return 0;
  		}
  		if(!isIP(ip))
		{
			alert(g_I18NMessage("secframe_ipmacband", "sec_ipmacband_ip_illegal"));
			bandForm.setFocus("IP");
			return 0;
		}
  		if(mac == "")
  		{
  			alert(g_I18NMessage("secframe_ipmacband", "sec_ipmacband_mac_notnull"));
  			return 0;
  		}
  		if(bandType == "")
  		{
  			alert(g_I18NMessage("secframe_ipmacband", "sec_ipmacband_bandtype_notnull"));
  			return 0;
  		}
		if(bandType == 4 || bandType == 5)
  		{
  			if(!isIP(mac))
  			{
				alert(g_I18NMessage("secframe_ipmacband", "sec_ipmacband_endip_illegal"));
				bandForm.setFocus("MAC");
				return 0;
			}
		}
		else
		{
			if(!isMAC(mac))
	  		{
	  			alert(g_I18NMessage("secframe_ipmacband", "sec_ipmacband_mac_illegal"));
				bandForm.setFocus("MAC");
				return 0;
	  		}
		}
  		return 1;
  	}
  	
  	/**
	 * �ж�IP��ַ�Ƿ�Ϸ�
	 */
	function isIP(ip)
	{
		var re = /^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$/;
		if(re.test(ip))
		{
			return true;
		}
		return false;
	}
	/**
	 * �ж�MAC��ַ�Ƿ�Ϸ�
	 */
	function isMAC(mac)
	{
		var reg=/[A-Fa-f\d]{2}:[A-Fa-f\d]{2}:[A-Fa-f\d]{2}:[A-Fa-f\d]{2}:[A-Fa-f\d]{2}:[A-Fa-f\d]{2}/; 
		if(reg.test(mac))
		{
			return true;
		}
		return false;
	}
 