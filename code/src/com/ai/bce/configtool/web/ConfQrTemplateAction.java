package com.ai.bce.configtool.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.ai.bce.bo.BceQrTemplateBean;
import com.ai.bce.configtool.service.interfaces.IConfQrTemplateSV;

public class ConfQrTemplateAction extends BaseAction {
	
	public static final transient Log log = LogFactory.getLog(ConfQrTemplateAction.class);
	
	
	/**
	 * 
	 * @Function: ConfQrTemplateAttrAction::saveQrTemplateAttr
	 * @Description: 保存新增、修改的模板信息
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-11 下午04:28:56 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-11     liwentao          v1.1.0               修改原因
	 */
	public void saveQrTemplate(HttpServletRequest request,HttpServletResponse response) throws IOException, Exception{
		CustomProperty cp = CustomProperty.getInstance();
		BceQrTemplateBean bean = null;
		
		//获取前台对象
		DataContainerList[] list = HttpUtil.getDataContainerLists(request.getInputStream(), new Class[]{BceQrTemplateBean.class});
		if(list != null && list.length>0){
			bean = (BceQrTemplateBean) (list[0].getColDataContainerInterface(0))[0];
		}else{
			return ;
		}
		IConfQrTemplateSV sv = (IConfQrTemplateSV) ServiceFactory.getService(IConfQrTemplateSV.class);
		boolean flag = false;
		if(null != bean){
			 flag = sv.saveBceQrTemplateValue(bean);
		}
		
		if(true == flag){
			cp.set("flag", "succ");
		}else{
			cp.set("flag", "fal");
		}
		HttpUtil.showInfo(response, cp);
	}
	
	/**
	 * 
	 * @Function: ConfQrTemplateAttrAction::deleteQrTemplateAttr
	 * @Description: 逻辑删除模板信息
	 * @param request
	 * @param response
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-11 下午04:29:10 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-11     liwentao          v1.1.0               修改原因
	 */
	public void deleteQrTemplate(HttpServletRequest request,HttpServletResponse response) throws Exception{
		CustomProperty cp = CustomProperty.getInstance();
		String templateId = HttpUtil.getAsString(request, "TEMPLATE_ID");
		IConfQrTemplateSV sv = (IConfQrTemplateSV) ServiceFactory.getService(IConfQrTemplateSV.class);
		boolean flag  = sv.delBceQrTempalteValue(templateId);
		
		if(true == flag){
			cp.set("flag", "succ");
		}else{
			cp.set("flag", "fal");
		}
		HttpUtil.showInfo(response, cp);
	}
}
