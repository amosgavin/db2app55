var gBceFrame_itemPrefix = "T_ITEM_";
var gBceFrame_pageFrameId = "";
var gBceFrame_returnPage = "";
var gBceFrame_prePage = "";
var gFrameType = "2";
var G_RTUN_QR =_gModuleName+"/bce/frame/OrderInfoConfirm.jsp";
var gPageIdList = new Array();
var STR_REGION_ID = "";
var STR_COMM_PARAM="";

function gBceFrame_setReturnPage(pUrl) {
    gBceFrame_returnPage = BCEFrame_returnPageStrDecode(pUrl);
    //alert("returnpage::::\n"+gBceFrame_returnPage);
}

function gBceFrame_setPrePage(preUrl, pReturnPage) {
    //��ȡ��һҳ��ֵ,����&&&���в��,�����һ��urlת����Ϊ��һҳ��url.
    gBceFrame_prePage = BCEFrame_getPrePageUrlStr(preUrl, "PRE_PAGE");
    if (gBceFrame_prePage.indexOf("?") > 0) {
        gBceFrame_prePage += "&RETURN_PAGE=" + pReturnPage;
    }
    else {
        gBceFrame_prePage += "?RETURN_PAGE=" + pReturnPage;
    }
    //alert("prePage::::\n"+gBceFrame_prePage);

}

function gBceFrame_goPre()
{	
    var divObj = document.all.item("SOFRAME_DIV");
    if (divObj)
    {
        var curpage = divObj.curpage;
        if (parseInt(curpage, 10) > 0)
        {
            var newPageSeq = parseInt(curpage) - 1;
            gBceFrame_linkPage(newPageSeq);
        }
        else if (curpage == "0" && gBceFrame_prePage != "") {
            window.location.href = (gBceFrame_prePage);
        }
        else {
            alert("program error.check");
        }
    }
}

function gBceFrame_goNext()
{
    var divObj = document.all.item("SOFRAME_DIV");
    if (divObj)
    {
        var curpage = divObj.curpage;
        var newPageSeq = parseInt(curpage) + 1;
        gBceFrame_linkPage(newPageSeq);
    }
}

function gBceFrame_cancel()
{
	//��ȷ��Ҫ�˳�������ҳ����?
    if (window.confirm(crm_i18n_msg("BEC0000002")))
    {
        if(gFrameType!=3){
            document.all.item("gBceFrame_nextBtn").disabled = true;
            document.all.item("gBceFrame_preBtn").disabled = true;
        }
        document.all.item("gBceFrame_saveBtn").disabled = true;
        if (gBceFrame_returnPage != "") {
            window.location.href = gBceFrame_returnPage;
        }else{
        	//���˵�����
        	//window.location.href=G_RTN_URL;
        	//�رյ�ǰ��������
        	closeThisTab();
        }
    }
}

function gBceFrame_linkPage(pageId)
{
    var divObj = document.all.item("SOFRAME_DIV");
    if (divObj)
    {
        var curpageId = divObj.curpage;
        var curPageObjs = document.getElementsByName(gBceFrame_itemPrefix + curpageId);
        var newPageId = parseInt(pageId, 10);
        //�����ǰҳ����ҳ����ͬ,return
        if (curpageId == newPageId){
            return;
        }
        if (curPageObjs != null)
        {
            //���ݱ�����Ϊ���ύ����ʱ��ֱ�ӷ���
    		if (curPageObjs[0].isgetdata == "0" )
    		{
        		//return true;
    		}

    		//�ж�ҳ������load״̬,�����û��װ��,�����Ի���,����false
    		if (curPageObjs[0].readyState != "complete")
    		{
    			// alert("��ǰҳ����δװ�����,���Ժ�");
        		alert(crm_i18n_msg("BEC0000003"));
        		return false;
    		}
    		//ҳ����У�麯��pageValidate()�ҷ���false;
    		if (gBceFrame_checkPageValid(curPageObjs[0]) == false) {
        		return false;
    		}    
        }    
        //�����ǰҳ���Ѿ������һҳ,���ٵ����һҳ,�͵���ȷ��ҳ�Ի���
        if (newPageId == parseInt(divObj.pagesize, 10)) {
        	
            if(gFrameType!=3){
               g_AIButtonManager.get("gBceFrame_nextBtn").setDisabled(true);
               g_AIButtonManager.get("gBceFrame_preBtn").setDisabled(false);
               g_AIButtonManager.get("gBceFrame_saveBtn").setDisabled(false);
            }
        }
        else {
            var newPageObjs = document.getElementsByName(gBceFrame_itemPrefix + newPageId);
            if (newPageObjs != null)
            //��ת���µ�ҳ��
            if (newPageObjs[0].pageloadtype == "2" || newPageObjs[0].src == "")
            {
                newPageObjs[0].src = newPageObjs[0].distsrc;
                //��ʾ�ȴ���
                BCEFrame_showWaitingBanner();
            }
            //��ҳ����ʾ
            newPageObjs[0].style.display = "block";
            //��ǰҳ������
            curPageObjs[0].style.display = "none";
            //������ҳ��Ϊ��ǰҳ��
            divObj.curpage = newPageId;
            //������ҳ�������ҳ��,��ҳ,�м�ҳ��ʱ�İ�ť״̬
            if (newPageId == (parseInt(divObj.pagesize, 10) - 1))
            {
                g_AIButtonManager.get("gBceFrame_preBtn").setDisabled(false);
                if (gFrameType!=3){
                	g_AIButtonManager.get("gBceFrame_nextBtn").setDisabled(true);
            		g_AIButtonManager.get("gBceFrame_saveBtn").setDisabled(false);
                }               
            }
            else if (newPageId == 0)
            {
               g_AIButtonManager.get("gBceFrame_saveBtn").setDisabled(true);
                if(gFrameType!=3){
                   g_AIButtonManager.get("gBceFrame_nextBtn").setDisabled(false);
                    if (gBceFrame_returnPage == "")
                       g_AIButtonManager.get("gBceFrame_preBtn").setDisabled(true);
                    else
                      g_AIButtonManager.get("gBceFrame_preBtn").setDisabled(false);
                }
            }
            else
            {
                if(gFrameType!=3){
                    g_AIButtonManager.get("gBceFrame_nextBtn").setDisabled(false);
                   g_AIButtonManager.get("gBceFrame_preBtn").setDisabled(false);
                }
                g_AIButtonManager.get("gBceFrame_saveBtn").setDisabled(true);
            }
            gBceFrame_setTitleFocus(pageId);
        }
    }
}

//�����򵼵�title��Ϣ.title������ֻ����ǰ��ת,һ������ǰҳ,�Ͳ��ɻ���.
function gBceFrame_setTitleFocus(index)
{
    var titleId = index;
    if(gFrameType==3)
        titleId = -1;

    bannerObj = document.all.item("SOFRAME_TITLE_BANNER");
    var titles = bannerObj.titles.split("-");

    bannerObj.initedpage = titleId;
    for (var i = 0; i < titles.length; i++)
    {
        if (i == titleId) {
            titles[parseInt(i)] = "<a href='javascript:gBceFrame_linkPage(" + i + ")' style='color:#0000f9;' >" + titles[parseInt(i)] + "</a>";
        }
        else if (i <= bannerObj.initedpage)
        {
            titles[parseInt(i)] = "<a href='javascript:gBceFrame_linkPage(" + i + ")' style='color:#0F0000;' >" + titles[parseInt(i)] + "</a>";
        }
        else
        {
            titles[i] = "<span style='color:#0F0000;' >" + titles[i] + "</span>";
        }
    }
    bannerObj.innerHTML = titles.join(">>");
}

//ȷ���ύ��ť�Ķ����¼�
function gBceFrame_save() {
//	if (window.confirm("ϵͳ���ύ��������������.��ȷ��Ҫ������?")) {
    if (window.confirm(crm_i18n_msg("BEC0000004"))) {
        var divObj = document.all.item("SOFRAME_DIV");
     
        if (divObj)
        {
        	//BCEFrame_showWaitingBanner("��������������ύ������.���Ժ�...");               
            BCEFrame_showWaitingBanner(crm_i18n_msg("BEC0000005"));               
            func = function() {
               	resu=gBceFrame_submitAllPageData();
               	if (resu==false){
               		BCEFrame_hideWaitingBanner();
               	}                   
            }
            window.setTimeout("func()", 10);
        }
    }
}

function gBceFrame_submitAllPageData()
{
    var xmlArrayList = new Array();
    var objSubmitData = new SubmitData();
    //��ص�����
    var objNodeInfoUD = objSubmitData.addNewNodeInfo(getBusiOperId(), "");
    for(var k=0;k<gPageIdList.length;k++){
        var curFrameObj = document.getElementById("ID_"+gPageIdList[k]);
        //�ж�ҳ������load״̬,�����û��װ��,�����Ի���,����false
        if (curFrameObj.readyState != "complete")
        {
        	//        	alert("��ǰҳ����δװ�����,���Ժ�");
            alert(crm_i18n_msg("BEC0000006"));
            return false;
        }

        //ҳ����У�麯��pageValidate()�ҷ���false;
        if (gBceFrame_checkPageValid(curFrameObj) == false) {
            return false;
        }
        //����һ���µ�submitData����
        //var objSubmitData = new SubmitData();
        if(k == 0){
        	//���õ�ǰҳ,��һҳ��pageid
        	objSubmitData.setCurPage(curFrameObj.busipageid);
        	//��һҳ��pageidĿǰ������Ҫ,��ʱ��-1.
        	objSubmitData.setNextPage("-1");
        }
        var objNodeInfo = objSubmitData.addNewNodeInfo(curFrameObj.id, "");     
        //��ȡ��ҳ��rowset�����������Ϣ
        var objPageSets = g_SoFrame_objPageSetsArray[curFrameObj.id];  
        if (objPageSets)
        { var isHaveValue =false;
            for (var i = 0; i < objPageSets.sets.length; i++)
            {
                var rowSetType = objPageSets.sets[i].rowSetType;
                var rowSetKey = objPageSets.sets[i].rowSetKey;
                var rowSetMethod = objPageSets.sets[i].rowSetMethod;
                var aXmlData = null;
                if (rowSetType == "1")//tableRowSet
                {
                    //alert("var obj=" + curFrameObj.id + ".g_TableRowSetManager.get('" + rowSetKey + "')");
                    eval("var obj=" + curFrameObj.id + ".g_TableRowSetManager.get('" + rowSetKey + "')");
                    eval("var xmlStr=obj." + rowSetMethod);
                    objNodeInfo.addRowsetXml(rowSetKey, "", xmlStr);
                    aXmlData = xmlStr;
                }
                else if (rowSetType == "2")//FormRowSet
                {
                    eval("var obj=" + curFrameObj.id + ".g_FormRowSetManager.get('" + rowSetKey + "')");
                    eval("var xmlStr=obj." + rowSetMethod);
                    objNodeInfo.addRowsetXml(rowSetKey, "", xmlStr);
                    aXmlData = xmlStr;
                }
                else if (rowSetType == "3")//Normal
                {
                    eval("value=" + curFrameObj.id + "." + rowSetMethod);
                    objNodeInfo.addUserData(rowSetKey, value);
                    aXmlData = value;
                }
                else if (rowSetType == "4")//getDcXmlfromMethod
                {
                    eval("var xmlStr=" + curFrameObj.id + "." + rowSetMethod);
                    objNodeInfo.addRowsetXml(rowSetKey, "", xmlStr);
                    aXmlData = xmlStr;
                }
                else if (rowSetType == "5")//�Զ��巽����ȡChildSubmitData
                {
                    eval("var xmlStr=" + curFrameObj.id + "." + rowSetMethod);
                    if(Object.prototype.toString.call(xmlStr) === '[object Array]'){ //�ж��Ƿ�������
                      for(var j = 0 ; j < xmlStr.length ;j++){
                         objNodeInfo.addSubmitDataXml(rowSetKey+"_"+j,xmlStr[j]);
                      }
                    }
                    else{
                       objNodeInfo.addSubmitDataXml(rowSetKey, xmlStr);
                    }
                    aXmlData = xmlStr;
                }
                if(aXmlData != null && aXmlData != "")isHaveValue=true;
            }
		        //��������ύֵ,����ֵΪ��,��alert��ʾ
		        if (!isHaveValue && curFrameObj.isdatamust == "1")
		        {        		
		        	//        	alert("��ǰҳ�������������޸�ֵ");
		            alert(crm_i18n_msg("BEC0000007"));
		            return false;
		        }
        }
    }
    //У���ܹ���
	if(gBceFrame_checkFrameValid() == false)
		return false;
	
	
	   //ud���ݷ������ƴ����Ϊ��ҳ��У���ʱ�� �����޸�ĳЩ���� liuke 2010-3-22
    if (typeof(getBusioperFrameId) != 'undefined' && typeof(getBusioperFrameId) == 'function' && getBusioperFrameId() != "") {
        objNodeInfoUD.addUserData("BUSIOPER_FRAME_ID", getBusioperFrameId());
    }
    if (typeof(getBusiOperId) != 'undefined' && typeof(getBusiOperId) == 'function' && getBusiOperId() != "") {
        objNodeInfoUD.addUserData("BUSIOPER_ID", getBusiOperId());
    }
    if (typeof(getCustomerId) != 'undefined' && typeof(getCustomerId) == 'function' && getCustomerId() != "") {
        objNodeInfoUD.addUserData("CUSTOMER_ID", getCustomerId());
    }
    if (typeof(getCustomerName) != 'undefined' && typeof(getCustomerName) == 'function' && getCustomerName() != "") {
        objNodeInfoUD.addUserData("CUSTOMER_NAME", getCustomerName());
    }
    if (typeof(getChannelType) != 'undefined' && typeof(getChannelType) == 'function' && getChannelType() != "") {
        objNodeInfoUD.addUserData("CHANNEL_TYPE", getChannelType());
    }
    if (typeof(getBillId) != 'undefined' && typeof(getBillId) == 'function' && getBillId() != "") {
        objNodeInfoUD.addUserData("BILL_ID", getBillId());
    }
    if (typeof(getOfferId) != 'undefined' && typeof(getOfferId) == 'function' && getOfferId() != "") {
        objNodeInfoUD.addUserData("OFFER_ID", getOfferId());
    }
    if (typeof(getOfferName) != 'undefined' && typeof(getOfferName) == 'function' && getOfferName() != "") {
        objNodeInfoUD.addUserData("OFFER_NAME", getOfferName());
    }
    if (typeof(getMainInsOfferId) != 'undefined' && typeof(getMainInsOfferId) == 'function' && getMainInsOfferId() != "") {
        objNodeInfoUD.addUserData("OFFER_INSTANCE_ID", getMainInsOfferId());
    }
    
    if (typeof(getRegionId) != 'undefined' && typeof(getRegionId) == 'function' && getRegionId() != "") {
        objNodeInfoUD.addUserData("REGION_ID", getRegionId());
    }
    //�ͻ�״̬
    if (typeof(getCustState) != 'undefined' && typeof(getCustState) == 'function' && getCustState() != "") {
        objNodeInfoUD.addUserData("CUST_STATE", getCustState());
    }
    //�ʻ�״̬
    if (typeof(getAcctState) != 'undefined' && typeof(getAcctState) == 'function' && getAcctState() != "") {
        objNodeInfoUD.addUserData("ACCT_STATE", getAcctState());
    }

    //����������
    if (typeof(getTaskId) != 'undefined' && typeof(getTaskId) == 'function' && getTaskId() != "")
        objNodeInfoUD.addUserData("TASK_ID", getTaskId());

    //Ԥ���������
    if (typeof(getPreSoId) != 'undefined' && typeof(getPreSoId) == 'function' && getPreSoId() != "")
        objNodeInfoUD.addUserData("PRE_SO_ID", getPreSoId());

    //�ĵ�ʱ���ÿͻ��������
    if (typeof(getCustOrderId) != 'undefined' && typeof(getCustOrderId) == 'function' && getCustOrderId() != "") {
        objNodeInfoUD.addUserData("CUST_ORDER_ID", getCustOrderId());
    }
    //�ĵ�ʱ���ò߻�������
    if (typeof(getOfferOrderId) != 'undefined' && typeof(getOfferOrderId) == 'function' && getOfferOrderId() != "") {
        objNodeInfoUD.addUserData("OFFER_ORDER_ID", getOfferOrderId());
    }
	
	//�û�ID
    if (typeof(getMainInsProductId) != 'undefined' && typeof(getMainInsProductId) == 'function' && getMainInsProductId() != "") {
        objNodeInfoUD.addUserData("USER_ID", getMainInsProductId());
        objNodeInfoUD.addUserData("PRODUCT_INSTANCE_ID", getMainInsProductId());
    }
    
    if (typeof(childProdBatchData) != 'undefined' && childProdBatchData != null && childProdBatchData.getBillId() != "") {
        objNodeInfoUD.addUserData("BILL_ID", childProdBatchData.getBillId());
    }
    //��������
    if (typeof(getCountyCode) != 'undefined' && typeof(getCountyCode) == 'function' && getCountyCode() != "") {
        objNodeInfoUD.addUserData("COUNTY_CODE", getCountyCode());
    }	
    
    
    //alert(objSubmitData.toXmlString());
//for test
//if(!confirm("commit?")){
  //return false;
//}
//end
	xmlArrayList.push(objSubmitData.toXmlString());
  var msg = gBceFrame_PostDataToServer(xmlArrayList);
  return msg;
}

//ȷ���ύ��ť�Ķ����¼�
function gBceFrame_saveSinglePage() {
    if (window.confirm(crm_i18n_msg("BEC0000004"))) {
        BCEFrame_showWaitingBanner(crm_i18n_msg("BEC0000005"));               
            func = function() {
               	resu=gBceFrame_submitSinglePageData();
               	if (resu==false){
               		BCEFrame_hideWaitingBanner();
               	}                   
            }
            window.setTimeout("func()", 10);
    }
}


function gBceFrame_submitSinglePageData()
{	var xmlArrayList = formateXml();
   if(xmlArrayList){
  	var msg = gBceFrame_PostDataToServer(xmlArrayList);
  }
   else{
	   return false;
   }
  return msg;
}


function gBceFrame_submitSinglePageByReturnMessage(){
  var xmlArrayList = formateXml();
   if(xmlArrayList){
  	 var pXmlString = "";
    if(xmlArrayList.length==1)
        pXmlString = xmlArrayList.toString();
    else
        pXmlString = xmlArrayList.join("|@|@|");

	if (pXmlString==""){
		//		alert("û����Ҫ��������ݣ�");
		alert(crm_i18n_msg("BEC0000008"));
		return false;
	}
	//alert("pXmlString___"+pXmlString); 
	var isConfirm="N";
   	var IS_SUCCESS;
   	var MSG;
   	var msg;
   	var myrandom=Math.random();
   	var isPrint = 'N';
   	if (typeof(getChannelType) != 'undefined' && typeof(getChannelType) == 'function' && getOfferOrderId() != "") {
   		if(getChannelType()!=""&&getChannelType()==2){
	   		isPrint = 'Y';
	   }
   	}
  	while (1==1){ //alert(STR_COMM_PARAM);
      	msg = PostInfo(_gModuleName + "/business/com.ai.bce.web.BceFrameAction?action=saveContent&IS_CONFIRM="+isConfirm
      	    +"&"+STR_REGION_ID+"&"+STR_COMM_PARAM+"&myrandom="+myrandom+"&isPrint="+isPrint, pXmlString);
  		BCEFrame_hideWaitingBanner();	
  		BCE_RETURN_MSG = msg;
  		IS_SUCCESS = msg.getValueByName("IS_SUCCESS");
      	MSG = msg.getValueByName("MESSAGE");
      	ORDER_ID = msg.getValueByName("ORDER_ID");
      	isUseGo = msg.getValueByName("isUseGo");
		if (IS_SUCCESS == "W"){
			//			if (confirm("���棺"+MSG+"��ȷ�ϼ�����")){
			var params= new Array();
			params[0]=MSG;
	      	if (confirm(crm_i18n_msg("BEC0000009",params))){
	      	  isConfirm="Y";
	      		continue;
	      	}else{
	      		return false;
	      	}
		}
		else if(IS_SUCCESS=="BCE_QR"){
			COUSTOM_ORDER_ID = msg.getValueByName("COUSTOM_ORDER_ID");
		   	var url  = G_RTUN_QR+"?COUSTOM_ORDER_ID="+COUSTOM_ORDER_ID+"&"+STR_COMM_PARAM+"&myrandom="+myrandom;
		   	//alert(url);
		   	var ret = 	window.showModalDialog(url,window,"scroll:yes;resizable:no;help:no;status:no;dialogHeight:700px;dialogWidth:800px");
		   	if(ret == 'true'){
		   		isPrint = 'Y';
		   		continue;
		   	}
		   	else{
		   		return false;
		   	}
		}
		else{
			break;
		}
	}       
    return msg;
  }
	

}

function formateXml(){
 	var xmlArrayList = new Array();
    var objSubmitData = new SubmitData();


        //ҳ����У�麯��pageValidate()�ҷ���false;
        if (gBceFrame_checkPageValid(null) == false) {
            return false;
        }
        //У���ܹ���
    	if(gBceFrame_checkFrameValid() == false)
    		return false;

        var objNodeInfo = objSubmitData.addNewNodeInfo(pageId, "");     
        //��ȡ��ҳ��rowset�����������Ϣ
        var objPageSets = g_SoFrame_objPageSetsArray[pageId];  
        if (objPageSets)
        {
            for (var i = 0; i < objPageSets.sets.length; i++)
            {
                var rowSetType = objPageSets.sets[i].rowSetType;
                var rowSetKey = objPageSets.sets[i].rowSetKey;
                var rowSetMethod = objPageSets.sets[i].rowSetMethod;
                var aXmlData = null;
                if (rowSetType == "1")//tableRowSet
                {
                    eval("var obj=g_TableRowSetManager.get('" + rowSetKey + "')");
                    eval("var xmlStr=obj." + rowSetMethod);
                    objNodeInfo.addRowsetXml(rowSetKey, "", xmlStr);
                    aXmlData = xmlStr;
                }
                else if (rowSetType == "2")//FormRowSet
                {
                    eval("var obj=g_FormRowSetManager.get('" + rowSetKey + "')");
                    eval("var xmlStr=obj." + rowSetMethod);
                    objNodeInfo.addRowsetXml(rowSetKey, "", xmlStr);
                    aXmlData = xmlStr;
                }
                else if (rowSetType == "3")//Normal
                {
                    eval("value=" + rowSetMethod);
                    objNodeInfo.addUserData(rowSetKey, value);
                    aXmlData = value;
                }
                else if (rowSetType == "4")//getDcXmlfromMethod
                {
                    eval("var xmlStr=" + rowSetMethod);
                    objNodeInfo.addRowsetXml(rowSetKey, "", xmlStr);
                    aXmlData = xmlStr;
                }
                else if (rowSetType == "5")//�Զ��巽����ȡChildSubmitData
                {
                    eval("var xmlStr=" + rowSetMethod);
                    if(Object.prototype.toString.call(xmlStr) === '[object Array]'){ //�ж��Ƿ�������
                      for(var j = 0 ; j < xmlStr.length ;j++){
                         objNodeInfo.addSubmitDataXml(rowSetKey+"_"+j,xmlStr[j]);
                      }
                    }
                    else{
                       objNodeInfo.addSubmitDataXml(rowSetKey, xmlStr);
                    }
                    aXmlData = xmlStr;
                }
            }
		        //��������ύֵ,����ֵΪ��,��alert��ʾ
		        if (aXmlData == null || aXmlData == "")
		        {        		
		            alert(crm_i18n_msg("BEC0000007"));
		            return false;
		        }
		        

		 	   //ud���ݷ������ƴ����Ϊ��ҳ��У���ʱ�� �����޸�ĳЩ���� liuke 2010-3-22
		     if (typeof(getBusioperFrameId) != 'undefined' && typeof(getBusioperFrameId) == 'function' && getBusioperFrameId() != "") {
		    	 objNodeInfo.addUserData("BUSIOPER_FRAME_ID", getBusioperFrameId());
		     }
		     if (typeof(getBusiOperId) != 'undefined' && typeof(getBusiOperId) == 'function' && getBusiOperId() != "") {
		    	 objNodeInfo.addUserData("BUSIOPER_ID", getBusiOperId());
		     }
		     if (typeof(getCustomerId) != 'undefined' && typeof(getCustomerId) == 'function' && getCustomerId() != "") {
		    	 objNodeInfo.addUserData("CUSTOMER_ID", getCustomerId());
		     }
		     if (typeof(getCustomerName) != 'undefined' && typeof(getCustomerName) == 'function' && getCustomerName() != "") {
		    	 objNodeInfo.addUserData("CUSTOMER_NAME", getCustomerName());
		     }
		     if (typeof(getChannelType) != 'undefined' && typeof(getChannelType) == 'function' && getChannelType() != "") {
		    	 objNodeInfo.addUserData("CHANNEL_TYPE", getChannelType());
		     }
		     if (typeof(getBillId) != 'undefined' && typeof(getBillId) == 'function' && getBillId() != "") {
		    	 objNodeInfo.addUserData("BILL_ID", getBillId());
		     }
		     if (typeof(getOfferId) != 'undefined' && typeof(getOfferId) == 'function' && getOfferId() != "") {
		    	 objNodeInfo.addUserData("OFFER_ID", getOfferId());
		     }
		     if (typeof(getOfferName) != 'undefined' && typeof(getOfferName) == 'function' && getOfferName() != "") {
		    	 objNodeInfo.addUserData("OFFER_NAME", getOfferName());
		     }
		     if (typeof(getMainInsOfferId) != 'undefined' && typeof(getMainInsOfferId) == 'function' && getMainInsOfferId() != "") {
		    	 objNodeInfo.addUserData("OFFER_INSTANCE_ID", getMainInsOfferId());
		     }
		     
		     if (typeof(getRegionId) != 'undefined' && typeof(getRegionId) == 'function' && getRegionId() != "") {
		    	 objNodeInfo.addUserData("REGION_ID", getRegionId());
		     }
		     //�ͻ�״̬
		     if (typeof(getCustState) != 'undefined' && typeof(getCustState) == 'function' && getCustState() != "") {
		    	 objNodeInfo.addUserData("CUST_STATE", getCustState());
		     }
		     //�ʻ�״̬
		     if (typeof(getAcctState) != 'undefined' && typeof(getAcctState) == 'function' && getAcctState() != "") {
		    	 objNodeInfo.addUserData("ACCT_STATE", getAcctState());
		     }

		     //����������
		     if (typeof(getTaskId) != 'undefined' && typeof(getTaskId) == 'function' && getTaskId() != "")
		    	 objNodeInfo.addUserData("TASK_ID", getTaskId());

		     //Ԥ���������
		     if (typeof(getPreSoId) != 'undefined' && typeof(getPreSoId) == 'function' && getPreSoId() != "")
		    	 objNodeInfo.addUserData("PRE_SO_ID", getPreSoId());

		     //�ĵ�ʱ���ÿͻ��������
		     if (typeof(getCustOrderId) != 'undefined' && typeof(getCustOrderId) == 'function' && getCustOrderId() != "") {
		    	 objNodeInfo.addUserData("CUST_ORDER_ID", getCustOrderId());
		     }
		     //�ĵ�ʱ���ò߻�������
		     if (typeof(getOfferOrderId) != 'undefined' && typeof(getOfferOrderId) == 'function' && getOfferOrderId() != "") {
		    	 objNodeInfo.addUserData("OFFER_ORDER_ID", getOfferOrderId());
		     }
		 	
		 	//�û�ID
		     if (typeof(getMainInsProductId) != 'undefined' && typeof(getMainInsProductId) == 'function' && getMainInsProductId() != "") {
		    	 objNodeInfo.addUserData("USER_ID", getMainInsProductId());
		    	 objNodeInfo.addUserData("PRODUCT_INSTANCE_ID", getMainInsProductId());
		     }
		     
		     if (typeof(childProdBatchData) != 'undefined' && childProdBatchData != null && childProdBatchData.getBillId() != "") {
		    	 objNodeInfo.addUserData("BILL_ID", childProdBatchData.getBillId());
		     }
		     //��������
		     if (typeof(getCountyCode) != 'undefined' && typeof(getCountyCode) == 'function' && getCountyCode() != "") {
		    	 objNodeInfo.addUserData("COUNTY_CODE", getCountyCode());
		     }	
		     
		     
        }
   // alert(objSubmitData.toXmlString());
//for test
//if(!confirm("commit?")){
  //return false;
//}
//end
	xmlArrayList.push(objSubmitData.toXmlString());
	return xmlArrayList;

}

function gBceFrame_PostDataToServer(xmlArrayList) {
    var pXmlString = "";
    if(xmlArrayList.length==1)
        pXmlString = xmlArrayList.toString();
    else
        pXmlString = xmlArrayList.join("|@|@|");

	if (pXmlString==""){
		//		alert("û����Ҫ��������ݣ�");
		alert(crm_i18n_msg("BEC0000008"));
		return false;
	}
	//alert("pXmlString___"+pXmlString); 
	var isConfirm="N";
   	var IS_SUCCESS;
   	var MSG;
   	var msg;
   	var myrandom=Math.random();
   	var isPrint = 'N';
   	if (typeof(getChannelType) != 'undefined' && typeof(getChannelType) == 'function' && getOfferOrderId() != "") {
   		if(getChannelType()!=""&&getChannelType()==2){
	   		isPrint = 'Y';
	   }
   	}
  	while (1==1){ //alert(STR_COMM_PARAM);
      	msg = PostInfo(_gModuleName + "/business/com.ai.bce.web.BceFrameAction?action=saveContent&IS_CONFIRM="+isConfirm
      	    +"&"+STR_REGION_ID+"&"+STR_COMM_PARAM+"&myrandom="+myrandom+"&isPrint="+isPrint, pXmlString);
  		BCEFrame_hideWaitingBanner();	
  		IS_SUCCESS = msg.getValueByName("IS_SUCCESS");
      	MSG = msg.getValueByName("MESSAGE");
      	ORDER_ID = msg.getValueByName("ORDER_ID");
      	isUseGo = msg.getValueByName("isUseGo");
		if (IS_SUCCESS == "W"){
			//			if (confirm("���棺"+MSG+"��ȷ�ϼ�����")){
			var params= new Array();
			params[0]=MSG;
	      	if (confirm(crm_i18n_msg("BEC0000009",params))){
	      	  isConfirm="Y";
	      		continue;
	      	}else{
	      		return false;
	      	}
		}else if(IS_SUCCESS=="BCE_QR"){
			COUSTOM_ORDER_ID = msg.getValueByName("COUSTOM_ORDER_ID");
		   	var url  = G_RTUN_QR+"?COUSTOM_ORDER_ID="+COUSTOM_ORDER_ID+"&"+STR_COMM_PARAM+"&myrandom="+myrandom;
		   	//alert(url);
		   	var ret = 	window.showModalDialog(url,window,"scroll:yes;resizable:no;help:no;status:no;dialogHeight:700px;dialogWidth:800px");
		   	if(ret == 'true'){
		   		isPrint = 'Y';
		   		continue;
		   	}
		   	else{
		   		return false;
		   	}
		}
		
		else{
			break;
		}
	}     
     alert(MSG);       
     if (IS_SUCCESS == "INFO")
     {
         if (gBceFrame_returnPage != "")
         {
         	if (gBceFrame_returnPage=="SELF"){
         		//����
         	}else{
         		window.location.href = gBceFrame_returnPage;  
         	}                
         }else{
        	 try{
        		 var pant = parent.getCurrentTabFocusItem("tab_desktop");
	        	 if(pant!= -1){
	        		 parent.closeTabItemByIdx("tab_desktop",pant);
	        		 return true;
	        	 }
		         if(pant==-1){
		        	 pant = parent.getCurrentTabFocusItem("tab_userview");
		         }
		         if(pant!= -1){
	        		 parent.closeTabItemByIdx("tab_userview",pant);
	        		 return true;
	        	 }
        	 }
	         catch(e){
	        	 //window.location.href=G_RTN_URL;
	         }
         	window.location.href=G_RTN_URL;
         }
         return true;
     }
     else {
         return false;
     }
}

function gBceFrame_checkFrameValid(){
	var pluginFunc = null;
    try {
    	eval("pluginFunc = frameValidatePlugIn;");
    }
    catch(e)
    {
     //   throw e;
    }
    if (pluginFunc) {
        if (pluginFunc() == false)
            return false;
    }
}

function gBceFrame_checkPageValid(framePageObj)
{
    //���Ӳ���ж�����,����ͨ��page_rule���ø÷���.
    var pluginFunc = null;
    try {
      if(framePageObj != null)
        eval("pluginFunc = " + framePageObj.id + ".pageValidatePlugIn;");
      else
        eval("pluginFunc = pageValidatePlugIn;");
    }
    catch(e)
    {
     //   throw e;
    }
    if (pluginFunc) {
        if (pluginFunc() == false)
            return false;
    }
    //page_rule��validate.
    var validFunc = null;
    var funcName = null;
    if(framePageObj != null)
      funcName = framePageObj.id + ".pageValidate";
    else
      funcName = "pageValidate";
    try {

        eval("validFunc = " + funcName + ";");

    } catch(e) {
     //   throw e;
    }
    if (validFunc) {
        if (validFunc() == false)
            return false;
    }
    return true;
}

function checkTabPageValid(tabObj)
{
    var reVal = true;
    var funcName = tabObj.id + ".pageValidate";
    try {
        eval("validFunc = " + funcName);
    } catch(e) {
        throw e;
    }
    if (validFunc) {
        reVal = validFunc();
    }

    return reVal;
}

//RowSet����
function PageRowSet()
{
    this.rowSetType = "";
    this.rowSetKey = "";
    this.rowSetMethod = "";
}

//RowSet���󼯺�
function PageRowSets()
{
    this.sets = new Array();
    PageRowSets.prototype.addPageRowSet = PageRowSets_addPageRowSet;
}

function PageRowSets_addPageRowSet(set)
{
    this.sets[this.sets.length] = set;
}


