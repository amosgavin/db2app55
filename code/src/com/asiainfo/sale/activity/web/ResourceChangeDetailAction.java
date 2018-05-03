package com.asiainfo.sale.activity.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.sale.activity.bo.BOResourceChangeDetailBean;
import com.asiainfo.sale.activity.ivalues.IBOResourceChangeDetailValue;
import com.asiainfo.sale.activity.service.interfaces.IResourceChangeDetailSV;
import com.asiainfo.sale.common.dao.interfaces.IOperatorInfoDAO;

public class ResourceChangeDetailAction extends BaseAction{
	private transient static Log log = LogFactory
	.getLog(ResourceChangeDetailAction.class);
	
	public void saveResourceChangeDetailInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		CustomProperty cp = CustomProperty.getInstance();
		IBOResourceChangeDetailValue[] ResourceChangeDetailValues = null;// 前台提交的数据

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOResourceChangeDetailBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOResourceChangeDetailBean[]) {
				ResourceChangeDetailValues = (BOResourceChangeDetailBean[]) obj;
			}
		}
		IResourceChangeDetailSV resourceChangeDetailSV = (IResourceChangeDetailSV) ServiceFactory.getService(IResourceChangeDetailSV.class);
        IOperatorInfoDAO opSv = (IOperatorInfoDAO) ServiceFactory.getService(IOperatorInfoDAO.class);
		
        try {
        	if (null == ResourceChangeDetailValues || 0 == ResourceChangeDetailValues.length) {
        		cp.set("FLAG", "N");
        		cp.set("MESSAGE", "没有修改需要保存！");
        	} else if (1 == ResourceChangeDetailValues.length) {
        		IBOResourceChangeDetailValue bean = ResourceChangeDetailValues[0];

        			int ResourceDid=resourceChangeDetailSV.saveResourceChangeDetail(bean);
        			cp.set("FLAG", "Y");
        			cp.set("ResourceDid", String.valueOf(ResourceDid));
        			cp.set("MESSAGE", "操作成功！");
        		} else {
        			cp.set("FLAG", "N");
        			cp.set("MESSAGE", "操作失败！");
        		}
        } catch (Exception e) {
        	// 操作失败
        	log.error("操作出错", e);
        	cp.set("FLAG", "N");
        	cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
        } finally {
        	HttpUtil.showInfo(response, cp);
        }
        }
        }