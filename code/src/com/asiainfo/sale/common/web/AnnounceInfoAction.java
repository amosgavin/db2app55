package com.asiainfo.sale.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.sale.common.bo.BOAnnounceInfoBean;
import com.asiainfo.sale.common.ivalues.IBOAnnounceInfoValue;
import com.asiainfo.sale.common.service.interfaces.IAnnounceInfoSV;

public class AnnounceInfoAction extends BaseAction {

	private transient static Log log = LogFactory.getLog(AnnounceInfoAction.class);

	public void saveAnnounceInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOAnnounceInfoBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}

		IBOAnnounceInfoValue[] announceInfoValue = null;// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOAnnounceInfoBean[]) {
				announceInfoValue = (BOAnnounceInfoBean[]) obj;
			}
		}

		IAnnounceInfoSV announceInfoSV = (IAnnounceInfoSV) ServiceFactory.getService(IAnnounceInfoSV.class);

		try {
			if (null == announceInfoValue || 0 == announceInfoValue.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {
				String id = announceInfoSV.saveAnnounceInfo(announceInfoValue[0]);
				cp.set("id",id);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("保存发布信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void applyAnnounceInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		
		String id = request.getParameter("id");
		IAnnounceInfoSV announceInfoSV = (IAnnounceInfoSV) ServiceFactory.getService(IAnnounceInfoSV.class);

		try {
			if (id.trim().isEmpty()) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {
				announceInfoSV.applyAnnounceInfo(id);
				cp.set("","");
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("发布信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
	
	public void cancleAnnounceInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		
		String id = request.getParameter("id");
		IAnnounceInfoSV announceInfoSV = (IAnnounceInfoSV) ServiceFactory.getService(IAnnounceInfoSV.class);

		try {
			if (id.trim().isEmpty()) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {
				announceInfoSV.cancleAnnounceInfo(id);
				cp.set("","");
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("发布信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	
	public static String getCurrentAnnounceInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		
		IAnnounceInfoSV announceInfoSV = (IAnnounceInfoSV) ServiceFactory.getService(IAnnounceInfoSV.class);
		return announceInfoSV.getCurrentAnnounceInfo();
	}
	
}
