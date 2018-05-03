	
	/**
	 * ��ʼ������Ա��Ա����Ϣ
	 */
 	function init(operId, stId, orgId, orgName)
 	{
 		var dbformOperator = getDBFormOperator();
 		var dbformStaff = getDBFormStaff(); 
		if(operId == null || operId == 'null' || operId == 0 || operId=='')
		{
			dbformOperator.refresh("refreshOperator" ,"1<>1");
    		dbformOperator.setEditSts(false);
    		dbformStaff.refresh("refreshStaff", "1<>1");
    		dbformStaff.setEditSts(false);
    		document.getElementById("password2").value = "";
    		document.getElementById("orgName").value = "";
    		document.getElementById("stationId").value = 0;
    		document.getElementById("stationName").value = "";
    		buttonInit(-1);
		}
		else
		{
			dbformOperator.refresh("refreshOperator" ,"operId="+operId);
    		dbformOperator.setEditSts(true);
    		dbformOperator.setColEditSts("PASSWORD", true);
    		document.getElementById("password2").value = dbformOperator.getValue("PASSWORD");
    		document.getElementById("password2").readonly = true;
    		dbformStaff.refresh("refreshStaff" ,"staffId="+dbformOperator.getValue("STAFF_ID"));
    		document.getElementById("orgName").value = orgName;
    		dbformStaff.setEditSts(true);
    		dbformOperator.setColEditSts("CODE",true);
    		refreshBaseStation(operId);
    		buttonInit(1);
    	}			
	}
	
	/**
	 * ��ʼ����ť״̬
	 */
	 function buttonInit(flag)
	 {
	 	if(flag == -1) // ֻ���Ե��������ť
	 	{
	 		 g_AIButtonManager.get("check").setDisabled(true);
			 g_AIButtonManager.get("selectStaff").setDisabled(true);
			 g_AIButtonManager.get("selectOrgnize").setDisabled(true);
			 g_AIButtonManager.get("selectStation").setDisabled(true);
			 g_AIButtonManager.get("addOperator").setDisabled(false);
			 g_AIButtonManager.get("save").setDisabled(true);
			 g_AIButtonManager.get("reset").setDisabled(true);
			 g_AIButtonManager.get("clearAuthor").setDisabled(true);
	 	}
	 	else if(flag == 0) // ����
	 	{
		 	 g_AIButtonManager.get("check").setDisabled(false);
			 g_AIButtonManager.get("selectStaff").setDisabled(false);
			 g_AIButtonManager.get("selectOrgnize").setDisabled(false);
			 g_AIButtonManager.get("selectStation").setDisabled(false);
			 g_AIButtonManager.get("addOperator").setDisabled(true);
			 g_AIButtonManager.get("save").setDisabled(false);
			 g_AIButtonManager.get("reset").setDisabled(true);
			 g_AIButtonManager.get("clearAuthor").setDisabled(true);
		}
		else if(flag == 1)// �޸�
		{
			 g_AIButtonManager.get("check").setDisabled(true);
			 g_AIButtonManager.get("selectStaff").setDisabled(false);
			 g_AIButtonManager.get("selectOrgnize").setDisabled(false);
			 g_AIButtonManager.get("selectStation").setDisabled(false);
			 g_AIButtonManager.get("addOperator").setDisabled(true);
			 g_AIButtonManager.get("save").setDisabled(false);
			 g_AIButtonManager.get("reset").setDisabled(false);
			 g_AIButtonManager.get("clearAuthor").setDisabled(false);
		}
		else  // ȫ���һ�
		{
			 g_AIButtonManager.get("check").setDisabled(true);
			 g_AIButtonManager.get("selectStaff").setDisabled(true);
			 g_AIButtonManager.get("selectOrgnize").setDisabled(true);
			 g_AIButtonManager.get("selectStation").setDisabled(true);
			 g_AIButtonManager.get("addOperator").setDisabled(true);
			 g_AIButtonManager.get("save").setDisabled(true);
			 g_AIButtonManager.get("reset").setDisabled(true);
			 g_AIButtonManager.get("clearAuthor").setDisabled(true);
		}
	 }

	/**
	 * ��ȡDBFormOperator
	 */
	function getDBFormOperator()
	{
		return g_FormRowSetManager.get("dbformOperator");
	}
	/**
	 * ��ȡDBFormStaff
	 */
	function getDBFormStaff()
	{
		return g_FormRowSetManager.get("dbformStaff");
	}
	/**
	 * ��������Ա
	 */
	function addOperator()
	{
		 var curOrgId = getCurrentOrgId();
		 if(curOrgId==null||curOrgId==''||curOrgId==-1)
		 {
		 	alert(g_I18NMessage("secframe_operator", "sec_operator_organize_select_required"));
		 	QueryByOrg();
		 	return ;
		 }
		 // ���ð�ť״̬
		 buttonInit(0);
		 
		 // ��ȡ��ǰʱ��
		 var currentDatetime = g_FormatDate(new Date(), "yyyy-MM-dd hh:mm:ss");
		 
		 // ���ò���Ա��Ϣ�༭״̬
		 var dbformOperator = getDBFormOperator();
		 dbformOperator.setColEditSts("CODE",true);
		 dbformOperator.setColEditSts("PASSWORD",true);
		 document.getElementById("password2").readOnly = false;
		 dbformOperator.setColEditSts("STATE",true);
		 dbformOperator.setValue("STATE","1");
		 dbformOperator.setColEditSts("NOTES",true);
		 dbformOperator.setValue("LOCK_FLAG","N");
	     dbformOperator.setColEditSts("LOCK_FLAG",true);
	     dbformOperator.setValue("ALLOW_CHANGE_PASSWORD","Y");
	     dbformOperator.setColEditSts("ALLOW_CHANGE_PASSWORD",true);
	   	 dbformOperator.setValue("SECURITY_ID","1");
	     dbformOperator.setColEditSts("SECURITY_ID",true);
	     dbformOperator.setValue("PASSWORD_VALID_DATE", currentDatetime);
	     dbformOperator.setColEditSts("PASSWORD_VALID_DATE",true);
	     dbformOperator.setValue("ACCT_EFFECT_DATE", currentDatetime);
	     dbformOperator.setColEditSts("ACCT_EFFECT_DATE",true);
	     dbformOperator.setValue("ACCT_EXPIRE_DATE",addYears(currentDatetime,40));
	     dbformOperator.setColEditSts("ACCT_EXPIRE_DATE",true);
	     dbformOperator.setValue("TRY_TIMES","3");
	     dbformOperator.setColEditSts("TRY_TIMES",true);	     
	     
	     // ����Ա����Ϣ�༭״̬
	     var dbformStaff = getDBFormStaff();
	     dbformStaff.setColEditSts("STAFF_NAME", true);
	     dbformStaff.setColEditSts("BILL_ID",true);
	     dbformStaff.setColEditSts("CARD_TYPE_ID",true);
	     dbformStaff.setValue("CARD_TYPE_ID",1);
	     dbformStaff.setColEditSts("CARD_NO",true);
	     dbformStaff.setColEditSts("SHORT_NAME",true);
	     dbformStaff.setColEditSts("ENGLISH_NAME",true);
	     dbformStaff.setColEditSts("GENDER",true);
	     dbformStaff.setValue("GENDER",1);
	     dbformStaff.setColEditSts("BIRTHDAY",true);
	     dbformStaff.setColEditSts("MARRY_STATUS",true);
	     dbformStaff.setValue("MARRY_STATUS",0);
	     dbformStaff.setColEditSts("NATIONAL_TYPE",true);
	     dbformStaff.setValue("NATIONAL_TYPE",1);
	     dbformStaff.setColEditSts("EDUCATION_LEVEL",true);
	     dbformStaff.setValue("EDUCATION_LEVEL",2);
	     dbformStaff.setColEditSts("ORGANIZE_ID",true);
	     dbformStaff.setColEditSts("POLITICS_FACE",true);
	     dbformStaff.setValue("POLITICS_FACE",0);
	     dbformStaff.setColEditSts("JOB_POSITION",true);
	     dbformStaff.setColEditSts("JOB_DESC",true);
	     dbformStaff.setColEditSts("HOME_TEL",true);
	     dbformStaff.setColEditSts("OFFICE_TEL",true);
	     dbformStaff.setColEditSts("RELIGION",true);
	     dbformStaff.setValue("RELIGION",0);
	     dbformStaff.setColEditSts("FAMILY_INFO",true);	     
	     dbformStaff.setColEditSts("CHARACTER_DESC",true);
	     dbformStaff.setColEditSts("POSTCODE",true);	
	     dbformStaff.setColEditSts("EMAIL",true);	
	     dbformStaff.setColEditSts("ALARM_BILL_ID",true);	 	
	     dbformStaff.setColEditSts("CAR_NO",true);
	     dbformStaff.setColEditSts("JOB_COMPANY",true);
	     dbformStaff.setColEditSts("CONTACT_ADDRESS",true);
	     dbformStaff.setColEditSts("NOTES",true);
	     
	     // ������֯
	     if(curOrgId > 0)
	     {
	     	dbformStaff.setValue("ORGANIZE_ID", curOrgId);
	     	var orgTree = g_DBTreeNewManager.get("orgTree");
			var curNode = orgTree.getCurNodeInfo();
	     	document.getElementById("orgName").value = curNode.text;
	     }
	     document.getElementById("stationId").value="";
	}

	/**
	 * ��������
	 */
	function resetPwd()
	{
	    var dbformOperator = getDBFormOperator();
		var operId = dbformOperator.getValue("OPERATOR_ID");
		if(operId != null && operId != "")
		{
			var parameter = "&operId=" + operId;
			var msg = PostInfo(_gModuleName + "/business/com.ai.secframe.orgmodel.web.SecOperatorAction?action=resetPassword"+parameter);
			var retVal = msg.getValueByName("retVal");
			if(retVal == "0")
			{	
				var retMsg = msg.getValueByName("retMsg");
				alert(retMsg);
			}
			else
			{
				alert(g_I18NMessage("secframe_operator", "passwd_reset_ok"));
			}
		}
		else
		{
			alert(g_I18NMessage("secframe_operator", "passwd_reset_fail"));
		}
	}
	/**
	 * ���Ȩ��
	 */
	function clearAuthor()
	{
		var dbformOperator = getDBFormOperator();
		var operId = dbformOperator.getValue("OPERATOR_ID");
		if(operId != null && operId != "")
		{
			var parameter = "&operId=" + operId;
			var msg = PostInfo(_gModuleName + "/business/com.ai.secframe.orgmodel.web.SecOperatorAction?action=delAuthorByOperId"+parameter);
			var retVal = msg.getValueByName("retVal");
			if(retVal == "0")
			{	
				var retMsg = msg.getValueByName("retMsg");
				alert(retMsg);
			}
			else
			{
				alert(g_I18NMessage("secframe_operator", "author_clean_ok"));
			}
		}
		else
		{
			alert(g_I18NMessage("secframe_operator", "author_clean_fail"));
		}
	}
	/**
	 * ��֤����Ա��Ա����Ϣ�Ϸ���
	 */                   
	function verifyOperatorStaff()
    {
	     var dbformOperator = getDBFormOperator();
	     // ��֤����
		 if(dbformOperator.getValue("OPERATOR_ID")<=0 && dbformOperator.getValue("OPERATOR_ID")!=-110)// �����û�
	   	 {
    	 	var code = dbformOperator.getValue("CODE");
    	 	if(code == null || code=="")
    	 	{
    	 		alert(g_I18NMessage("secframe_operator", "code_empty"));
    	 		dbformOperator.setFocus("CODE");
    	 		return 0;
    	 	}    
    	 	var msg = PostInfo(_gModuleName + "/business/com.ai.secframe.orgmodel.web.SecOperatorAction?action=checkCode&code="+code);
	 		var result = msg.getValueByName("retVal");
	 		if(result == 0 )
	 		{
	 		    
				var retMsg = msg.getValueByName("retMsg");
	 			if(retMsg == null)
	 			{
	 				alert(g_I18NMessage("secframe_operator", "code_duplicate"));
	 			}
	 			else
	 			{
	 				alert(retMsg);
	 			}
	 			return 0;
			}  	 	
		  }
			// ��֤����
			var pwd = dbformOperator.getValue("PASSWORD") ;   
			if(pwd == null || pwd == "")
			{
				alert(g_I18NMessage("secframe_operator", "passwd_empty"));
		        dbformOperator.setFocus("PASSWORD");
			    return 0;
			}
//			if(pwd.length<6)
//		    {
	//		     alert(g_I18NMessage("secframe_operator", "passwd_length_short"));
		//	     dbformOperator.setFocus("PASSWORD");
          //     return 0;
		  	//}	
		   if(pwd != document.getElementById("password2").value )
	       {
		      alert(g_I18NMessage("secframe_operator", "passwd_confirm_fail"));
		      document.getElementById("password2").focus();
		      return 0;		   	
		   }
		   
		   
		           
		  if( dbformOperator.getValue("ACCT_EFFECT_DATE") == null ||
		       dbformOperator.getValue("ACCT_EFFECT_DATE") == "" )
      	  {
		      alert(g_I18NMessage("secframe_operator", "effect_date_empty"));
		      dbformOperator.setFocus("ACCT_EFFECT_DATE");
		      return 0;
		  }	   
		  if( dbformOperator.getValue("ACCT_EXPIRE_DATE") == null ||
		       dbformOperator.getValue("ACCT_EXPIRE_DATE") == "" )
     	  {
		      alert(g_I18NMessage("secframe_operator", "expire_date_empty"));
		      dbformOperator.setFocus("ACCT_EXPIRE_DATE");
		      return 0;
		  }	
		  if( dbformOperator.getValue("PASSWORD_VALID_DATE") == null ||
		       dbformOperator.getValue("PASSWORD_VALID_DATE") == "" )
    	  {
		      alert(g_I18NMessage("secframe_operator", "passwd_valid_date_empty"));
		      dbformOperator.setFocus("PASSWORD_VALID_DATE");
		      return 0;
		  }	          
	      if(dbformOperator.getValue("ACCT_EFFECT_DATE")!=null && dbformOperator.getValue("ACCT_EXPIRE_DATE")!=null)
	      {
			var effectDateArray = dbformOperator.getValue("ACCT_EFFECT_DATE").split("-");
			var effectDate = new Date(parseInt(effectDateArray[0],10),parseInt(effectDateArray[1]-1,10),parseInt(effectDateArray[2],10));
			var expireDateArray = dbformOperator.getValue("ACCT_EXPIRE_DATE").split("-");
			var expireDate = new Date(parseInt(expireDateArray[0],10),parseInt(expireDateArray[1]-1,10),parseInt(expireDateArray[2],10));

			if(effectDate.getTime()>=expireDate.getTime())
			{
			  alert(g_I18NMessage("secframe_operator", "expire_date_check_fail"));
			  dbformOperator.setFocus("ACCT_EXPIRE_DATE");
			  return 0;
			}
	     }	 
	     // ��֤ʧ�ܳ��Դ���
	     if(dbformOperator.getValue("TRY_TIMES") == "")
	     {
	     	alert(g_I18NMessage("secframe_operator", "try_times_empty"));
	     	dbformOperator.setFocus("TRY_TIMES");
	     	return 0;
	     }
	     else if(dbformOperator.getValue("TRY_TIMES") < 0)
	     {
	     	alert(g_I18NMessage("secframe_operator", "try_times_lesszero"));
	     	dbformOperator.setFocus("TRY_TIMES");
	     	return 0;
	     }
	     var dbformStaff = getDBFormStaff(); 		   		  	
	  	 // ��֤Ա������
	  	 if( dbformStaff.getValue("STAFF_NAME") == null ||
	  	       dbformStaff.getValue("STAFF_NAME") == "" )
	     {
	  	    alert(g_I18NMessage("secframe_operator", "staff_name_empty"));
	  	    dbformStaff.setFocus("STAFF_NAME");
	  	    return 0;
	  	 }
	     // ��֤�ֻ���
	     var phone = dbformStaff.getValue("BILL_ID");
	     if(phone == null || phone == "")
	     {
	     	alert(g_I18NMessage("secframe_operator", "billid_empty"));
	     	dbformStaff.setFocus("BILL_ID");
	     	return 0;
	     }
	     if(!g_IsMobileNumber(phone))
	     {
	     	alert(g_I18NMessage("secframe_operator", "billid_invalid"));
	       	dbformStaff.setFocus("BILL_ID");
	     	return 0;	
	     }
	     // ��֤������֯		
	     var organizeId = dbformStaff.getValue("ORGANIZE_ID");
	     if(organizeId == null || organizeId == "")
	     {
	     	alert(g_I18NMessage("secframe_operator", "organize_empty"));
	     	dbformStaff.setFocus("ORGANIZE_ID");
	     	return 0;
	     }
	     // ��֤Ĭ�ϸ�λ		
	     var stationId = document.getElementById("stationId").value;
	     if(stationId == null || stationId == "" || stationId == "null")
	     {
	     	alert(g_I18NMessage("secframe_operator", "station_empty"));
	     	document.getElementById("stationId").focus();
	     	return 0;
	     }
	     // ��֤���֤��
	     if( dbformStaff.getValue("CARD_TYPE_ID") != null &&
	  	       dbformStaff.getValue("CARD_TYPE_ID") == 1 )
	     {
	    	var cardNo = dbformStaff.getValue("CARD_NO"); 
	    	/*if(cardNo == null || cardNo == "")--2012 7.20�������֤��Ϊ�� 
	    	{
	    		alert(g_I18NMessage("secframe_operator", "idcard_empty"));
	    		dbformStaff.setFocus("CARD_NO");
	    		return 0;
	    	}*/
	    	if(g_IDCardNumber1(cardNo) == false)
	    	{
	  	    	alert(g_I18NMessage("secframe_operator", "idcard_invalid"));
	  	    	dbformStaff.setFocus("CARD_NO");
	  	    	return 0;
	  	    }
	  	 }
	     return 1;
	}
	
	//�ж��Ƿ������֤���롣��CommUtil.js��g_IDCardNumber����������ȱ�ݣ���������
	function g_IDCardNumber1(value){
	  if(value=='' || value==null)return true;
	  var length = value.length;

	  if(length ==15){
	    if(!g_IsDigit(value) || value.substring(0,1)=='-'){
	      return false;
	    }
	    return true;
	  }else if(length ==18){
		var code;
	    //ǰ17λ����������
	    for (i= 0; i < 17;  i++){
	      code = value.charCodeAt(i);
	      if(code<48 || code>57)return false;
	    }
	    //18λ���֤��������һλ���������ֻ�Ӣ����ĸ
	    code = value.charCodeAt(17);
	    if(code>=48 && code<=57 || code>=65 && code<=90 || code>=97 && code<=122){
	      return true;
	    }
	  }
	  //λ����Ϊ15����18�򷵻�
	  return false;
	}

	/**
	 * ��֤�����Ƿ�Ϸ�
	 */
	function checkCode()
	{
	    var dbformOperator = getDBFormOperator();
		var code = dbformOperator.getValue("CODE");
		if(code == null || code == "")
		{
			alert(g_I18NMessage("secframe_operator", "code_empty"));
			return;
		}
		var msg = PostInfo(_gModuleName + "/business/com.ai.secframe.orgmodel.web.SecOperatorAction?action=checkCode&code="+code);
 		var retVal = msg.getValueByName("retVal");
 		if(retVal == 0)
 		{
 			var retMsg = msg.getValueByName("retMsg");
 			if(retMsg == null)
 			{
 				alert(g_I18NMessage("secframe_operator", "code_duplicate"));
 			}
 			else
 			{
 				alert(retMsg);
 			}
 			return;
		}
		else
		{
			alert(g_I18NMessage("secframe_operator", "code_valid"));
		}
	}

    /**
     * ����Ӳ���
     * strDatetime��ʽ��2006-08-08 23:04:11
     */
    function addYears(strDatetime, iAddYears)
    {
        var year = strDatetime.substr(0,4);
        var iYear = parseInt(year) + iAddYears;
        var full = iYear + strDatetime.substr(4,strDatetime.length-1);
        return full;
    }
