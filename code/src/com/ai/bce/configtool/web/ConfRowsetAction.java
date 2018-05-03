/***********************************************************************
 * Module:       ConfRowsetAction.java
 * Description:  
 * Company:      Asiainfo
 * Author:       LinHailu
 * Date:         Mar 10, 2011
 ***********************************************************************/

package com.ai.bce.configtool.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.ai.bce.bo.BcePageRowsetRelBean;
import com.ai.bce.util.BceServiceFactory;

public class ConfRowsetAction extends BaseAction{
	private static transient Log log = LogFactory.getLog(ConfRowsetAction.class);

	public void savePageRowset(HttpServletRequest request,HttpServletResponse response) throws Exception{
		CustomProperty cp = CustomProperty.getInstance();
		try{
			DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request.getInputStream(),null);
			if(dcLists != null && dcLists.length == 1){
				DataContainerInterface[] dcis = dcLists[0].getColDataContainerInterface(0);
				BcePageRowsetRelBean pageRowsetRelate = new BcePageRowsetRelBean();
				pageRowsetRelate.copy(dcis[0]);
				pageRowsetRelate.setState(dcis[0].getAsInt("RELATE_STATE"));
			  BceServiceFactory.getBceStudioSV().commonSaveRowset(new DataContainerInterface[]{pageRowsetRelate});
			}			
			HttpUtil.showInfo(response,cp);
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			HttpUtil.showError(response, ex.getMessage());
		}
	}
}
