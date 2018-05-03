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
import com.ai.bce.bo.BcePageFramePageBean;
import com.ai.bce.util.BceServiceFactory;

public class ConfPFramePageAction extends BaseAction{
	private static transient Log log = LogFactory.getLog(ConfPFramePageAction.class);
	
	public void savePageFramePage(HttpServletRequest request,HttpServletResponse response) throws Exception{
		CustomProperty cp = CustomProperty.getInstance();
		try{
			DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request.getInputStream(),null);
			if(dcLists != null && dcLists.length == 1){
				DataContainerInterface[] dcis = dcLists[0].getColDataContainerInterface(0);
				BcePageFramePageBean pFramePage = new BcePageFramePageBean();
				pFramePage.copy(dcis[0]);
			  BceServiceFactory.getBceStudioSV().commonSaveRowset(new DataContainerInterface[]{pFramePage});
			}			
			HttpUtil.showInfo(response,cp);
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			HttpUtil.showError(response, ex.getMessage());
		}
	}
}
