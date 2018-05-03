package com.ai.bce.configtool.web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.ai.bce.auto.plugin.version.hand.bo.BceVerHandBean;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerHandValue;
import com.ai.bce.auto.plugin.version.hand.service.interfaces.IHandLogServiceSV;
import com.ai.bce.configtool.service.interfaces.IConfVersionSV;
import com.ai.bce.util.BceConfigServer;

public class ConfVersionAction extends BaseAction {
	
	public static final transient Log log = LogFactory.getLog(ConfVersionAction.class);
	
	public void saveVersion(HttpServletRequest request,HttpServletResponse response) throws IOException, Exception{
	CustomProperty cp = CustomProperty.getInstance();
	BceVerHandBean bean = null;
	DataContainerList[] dataContainerLists = HttpUtil.getDataContainerLists(request.getInputStream(), 
			new Class[]{BceVerHandBean.class});
	for(int i=0;i<dataContainerLists.length;i++){
		DataContainerInterface[] dataContainers = dataContainerLists[i].getColDataContainerInterface(0);
		if(dataContainers instanceof BceVerHandBean[]){
			bean = (BceVerHandBean) dataContainers[0];
		}
	}
	if(null != bean){
		IConfVersionSV sv = (IConfVersionSV) ServiceFactory.getService(IConfVersionSV.class);
		long versionId = sv.saveVerHand(bean);
		cp.set("versionId", String.valueOf(versionId));
	}
	HttpUtil.showInfo(response, cp);
}
	
	public void dispatcherUrl(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String moduleId = HttpUtil.getAsString(request, "moduleId");
		String moduleName = HttpUtil.getAsString(request, "moduleName");
		moduleName = URLEncoder.encode(moduleName, "GBK");
		long userId = SessionManager.getUser().getID();
		RequestDispatcher rd = null;
		try {
			if(BceConfigServer.isPlugUsed(BceConfigServer.KEY_LOG)){
				IConfVersionSV sv = (IConfVersionSV) ServiceFactory.getService(IConfVersionSV.class);
				IBceVerHandValue verHand = sv.getVerHands("PUBILSH_STATE = '00' and state = 1");
				if(0 != verHand.getVersionId())
					rd = request.getRequestDispatcher("/bce/configtool/version/createVerOrd.jsp?userId="+userId+"&versionId="+verHand.getVersionId()+"&moduleId="+moduleId+"&moduleName="+moduleName);
				else
					rd = request.getRequestDispatcher("/bce/configtool/version/createVersion.jsp?userId="+userId+"&moduleId="+moduleId+"&moduleName="+moduleName);
			}
			else{
				rd = request.getRequestDispatcher("/bce/configtool/main.jsp?module_id="+moduleId+"&module_name="+moduleName);
			}
			rd.forward(request, response);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}
	
	public void next(HttpServletRequest request,HttpServletResponse response) throws Exception{
		CustomProperty cp = CustomProperty.getInstance();
		String ordId = HttpUtil.getAsString(request, "ordId");
		IHandLogServiceSV sv = (IHandLogServiceSV) ServiceFactory.getService(IHandLogServiceSV.class);
		boolean flag = sv.setVerOrdSn(ordId);
		if(true == flag){
			cp.set("flag", "succ");
		}else{
			cp.set("flag", "fal");
		}
		HttpUtil.showInfo(response, cp);
	}
}
