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
import com.ai.bce.util.BceServiceFactory;
/**
 * 
 * Copyright: Copyright (c) 2010 Asiainfo-Linkage
 * 
 * @ClassName: ConfAttrAction.java
 * @Description: 属性Action类
 *
 * @version: v1.0.0
 * @author: ZhangWenqi
 * @date: Dec 21, 2010 10:25:52 AM 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * Dec 21, 2010     ZhangWenqi           v1.0.0               修改原因
 */
public class ConfAttrAction extends BaseAction{

	private static transient Log log = LogFactory.getLog(ConfAttrAction.class);

	public void saveAttrBatch(HttpServletRequest request,HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		try{
			DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request.getInputStream(),null);
			if(dcLists != null && dcLists.length == 1){
				DataContainerInterface[] dcis = dcLists[0].getColDataContainerInterface(0);
				for(int i=0;i<dcis.length;i++){
					dcis[i].setStsToNew();
				}
			  BceServiceFactory.getBceStudioSV().commonSaveRowset(dcis);
			}
			HttpUtil.showInfo(response,cp);
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			HttpUtil.showError(response, ex.getMessage());
		}
		
	}
}
