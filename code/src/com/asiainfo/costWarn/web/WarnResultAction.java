package com.asiainfo.costWarn.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.costWarn.bo.BOWarnResultBean;
import com.asiainfo.costWarn.dao.impl.WarnResultDAOImpl;
import com.asiainfo.costWarn.ivalues.IBOWarnResultValue;
import com.asiainfo.costWarn.service.interfaces.IWarnResultSV;

public class WarnResultAction extends BaseAction{
	private transient static Log log = LogFactory.getLog(WarnResultAction.class);
	IBOWarnResultValue[] Values =null;
	
	public void insert(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		CustomProperty cp = CustomProperty.getInstance();
		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] {BOWarnResultBean.class});
		IBOWarnResultValue[] vls =null;// 前台提交的数据
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof IBOWarnResultValue[]) {
				vls = (IBOWarnResultValue[]) obj;
			}
		}
		for(int i=0; i<vls.length; i++){
		IWarnResultSV warnresultsv =(IWarnResultSV)ServiceFactory
		.getService(IWarnResultSV.class);
		warnresultsv.insert(vls[i]);
		}
		
	}

}
