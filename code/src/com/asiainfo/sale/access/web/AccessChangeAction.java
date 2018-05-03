package com.asiainfo.sale.access.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.workflow.util.TaskUtil;

import com.asiainfo.sale.access.bo.BOAccessChangeBean;
import com.asiainfo.sale.access.bo.BOAccessChangeDetailBean;
import com.asiainfo.sale.access.ivalues.IBOAccessChangeDetailValue;
import com.asiainfo.sale.access.ivalues.IBOAccessChangeValue;
import com.asiainfo.sale.access.ivalues.IBOAccessChangeDetailValue;
import com.asiainfo.sale.access.service.interfaces.IAccessChangeSV;

public class AccessChangeAction extends BaseAction {
	private transient static Log log = LogFactory
			.getLog(AccessChangeAction.class);

	public void saveAccessChangeInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		IBOAccessChangeValue[] accessChangeValue = null;// 前台提交的数据
		String applyid = request.getParameter("applyid");
		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOAccessChangeBean.class });

		if (dcLists.length == 0) {
			//HttpUtil.showInfo(response, "操作对象为空！");
			cp.set("M", "N");
			return;
		}
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOAccessChangeBean[]) {
				accessChangeValue = (BOAccessChangeBean[]) obj;
			}
		}
		IAccessChangeSV accessChangeSV = (IAccessChangeSV) ServiceFactory
				.getService(IAccessChangeSV.class);

		try {
			if (null == accessChangeValue || 0 == accessChangeValue.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else if (1 == accessChangeValue.length) {
				int accessid = accessChangeSV
						.saveAccessChange(accessChangeValue[0]);
				cp.set("accessid", String.valueOf(accessid));
				cp.set("state", String.valueOf("1"));
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("保存渠道修改主信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}

	}

	public void saveAccessChangeDetail(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		IBOAccessChangeDetailValue[] accessChangeDetailValue = null;// 前台提交的数据
		String accessid = request.getParameter("accessid");

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(),
				new Class[] { BOAccessChangeDetailBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOAccessChangeDetailBean[]) {
				accessChangeDetailValue = (BOAccessChangeDetailBean[]) obj;
			}
		}
		IAccessChangeSV accessChangeSV = (IAccessChangeSV) ServiceFactory.getService(IAccessChangeSV.class);

		try {
			if (!accessid.isEmpty()) {
				if (null == accessChangeDetailValue
						|| 0 == accessChangeDetailValue.length) {
					cp.set("FLAG", "N");
					cp.set("MESSAGE", "保存明细信息为空！");
				} else {
					accessChangeSV.saveAccessChangeDetailBatch(accessChangeDetailValue);
				}
			}
		} catch (Exception e) {
			// 操作失败
			log.error("保存渠道修改明细信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}

	}
	
	public void delAccessChangeInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();		
		String accessid = request.getParameter("accessid");
		IAccessChangeSV accessChangeSV = (IAccessChangeSV) ServiceFactory.getService(IAccessChangeSV.class);
		try {
			    accessChangeSV.delAccessChangeValue(Integer.valueOf(accessid).intValue());
				cp.set("accessid", String.valueOf(accessid));
				cp.set("state", String.valueOf("1"));
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "删除操作成功！");
		}catch (Exception e) {
			// 操作失败
			log.error("删除渠道修改信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}

	}	

}
