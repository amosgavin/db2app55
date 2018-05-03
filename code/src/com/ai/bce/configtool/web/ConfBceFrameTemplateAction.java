package com.ai.bce.configtool.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.ai.bce.configtool.service.interfaces.IConfFrameSV;
public class ConfBceFrameTemplateAction extends BaseAction {

	
	 /**
	   * 
	   * @Function: BceFrameAction::configBceFrameTemplate
	   * @Description: ����������ȷ��ҳģ��
	   * @param request
	   * @param response
	   * @throws Exception
	   * @version: v1.1.0
	   * @author: Administrator
	   * @date: 2011-5-14 ����02:54:42 
	   *
	   * Modification History:
	   * Date         Author          Version            Description
	   *-------------------------------------------------------------
	   * 2011-5-14     ������          v1.1.0               �޸�ԭ��
	   */
	  public void configBceFrameTemplate(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 CustomProperty cp = CustomProperty.getInstance();
		 try{
			 
			 long bceFrameId = HttpUtil.getAsLong(request, "bceFrameId");
			 long templateId = HttpUtil.getAsLong(request, "templateId");
			 IConfFrameSV configSv =  (IConfFrameSV) ServiceFactory.getService(IConfFrameSV.class);
			 
			 boolean flag = configSv.bceFrameConfigTemplate(bceFrameId,templateId); 
			
			 if(flag){
				 cp.set("flag", "succ");
			 }else{
				 cp.set("flag", "fail");
			 }
		 }catch(Exception e){
			 cp.set("flag", "fail");
			 e.printStackTrace();
		 }finally{
			 HttpUtil.showInfo(response, cp);
		 }
		  
	  }
}
