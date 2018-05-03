/***********************************************************************
 * Module:       BceProcessServiceImpl.java
 * Description:  
 * Company:      Asiainfo
 * Author:       LinHailu
 * Date:         Dec 21, 2010
 ***********************************************************************/

package com.ai.bce.service.impl;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.ai.bce.ivalues.IBceData;
import com.ai.bce.ivalues.IBceDealReturnData;
import com.ai.bce.service.interfaces.IBceDealProcessSV;
import com.ai.bce.service.interfaces.IBceDealService;
import com.ai.bce.util.LocaleResourceFactory;
import com.ai.bce.valuebean.BceDealReturnDataBean;

public class BceDealProcessSVImpl implements IBceDealProcessSV {

	public IBceDealReturnData deal(IBceData beData, long beFrameId)
			throws Exception, RemoteException {
		IBceDealReturnData returnData = new BceDealReturnDataBean();
		// 设置流程参数
		Map paramMap = new HashMap();
		paramMap.put("BCE_FRAME_ID", new Long(beFrameId));
		paramMap.put("BCE_DATA", beData);
		returnData.setWorkflowParamMap(paramMap);
		returnData.setIsSuccess("INFO");
		returnData.setSuccessMsg(LocaleResourceFactory
				.getResource("BES0000411"));
		return returnData;
	}

	public IBceDealReturnData createCustomProperty(IBceData beData,
			IBceDealReturnData data) throws Exception, RemoteException {
		String[][] msg = null;
		if (data.getProcessReturnMap() != null) {
			int length= data.getProcessReturnMap().entrySet().size();
			msg  = new String[length+2][2];
			int i = 2;
			for (Iterator iterator = data.getProcessReturnMap().entrySet()
					.iterator(); iterator.hasNext();) {
				Entry entry = (Entry) iterator.next();
				if(entry.getValue() instanceof String){
					msg[i][0]=(String) entry.getKey(); 
					msg[i][1]=(String) entry.getValue();
					i++;
				}
			}
		}
		if(msg==null)msg = new String[2][2];
		msg[0][0] = "FLAG";
		msg[0][1] = data.getIsSuccess();
		msg[1][0] = "MESSAGE";
		msg[1][1] = data.getSuccessMsg();
		data.setCustomProperty(msg);
		return data;
	}
}
