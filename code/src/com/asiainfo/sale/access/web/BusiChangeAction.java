package com.asiainfo.sale.access.web;

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
import com.asiainfo.sale.access.bo.BOBusiChangeBean;
import com.asiainfo.sale.access.ivalues.IBOBusiChangeValue;
import com.asiainfo.sale.access.service.interfaces.IBusiChangeSV;
import com.asiainfo.sale.common.dao.interfaces.IOperatorInfoDAO;

public class BusiChangeAction extends BaseAction {
	private transient static Log log = LogFactory
			.getLog(BusiChangeAction.class);

	public void saveBusiChangeMainInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		IBOBusiChangeValue[] busiChangeValues = null;// 前台提交的数据

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOBusiChangeBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOBusiChangeBean[]) {
				busiChangeValues = (BOBusiChangeBean[]) obj;
			}
		}
		IBusiChangeSV busiChangeSV = (IBusiChangeSV) ServiceFactory
				.getService(IBusiChangeSV.class);
		IOperatorInfoDAO opSv = (IOperatorInfoDAO) ServiceFactory
				.getService(IOperatorInfoDAO.class);

		try {
			if (null == busiChangeValues || 0 == busiChangeValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "没有修改需要保存！");
			} else if (1 == busiChangeValues.length) {
				IBOBusiChangeValue bean = busiChangeValues[0];
				if (bean != null) {
					if(bean.isDeleted()){
						bean.unDelete();
						bean.setIsDelete("1");
					}else{
						bean.setTel(opSv.getNameById(
								String.valueOf(SessionManager.getUser().getID()))
								.getBillId());
					}
					
					int busiId = busiChangeSV.saveBusiChange(bean);
					cp.set("FLAG", "Y");
					cp.set("busiId", String.valueOf(busiId));
					cp.set("MESSAGE", "操作成功！");
				} else {
					cp.set("FLAG", "N");
					cp.set("MESSAGE", "操作失败！");
				}
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

	public void isHasTicketChange(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String busiId = request.getParameter("busiId");
		IBusiChangeSV busiChangeSV = (IBusiChangeSV) ServiceFactory
				.getService(IBusiChangeSV.class);

		try {
			if (busiChangeSV.isHasTicketChange(busiId)) {
				cp.set("HasTicket", "true");
			} else {
				cp.set("HasTicket", "false");
			}
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("操作出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}

	}
	
	public String checkdq_kf(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String busiId = request.getParameter("busiId");
		IBusiChangeSV busiChangeSV = (IBusiChangeSV) ServiceFactory
				.getService(IBusiChangeSV.class);
		
		String dq_kf=busiChangeSV.checkdq_kf(busiId);

		try {
			if ("dq".equals(dq_kf)) {
				cp.set("DQ_KF", "dq");
			} if ("kf".equals(dq_kf) ){
				cp.set("DQ_KF", "kf");				
			}
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("操作出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
		return dq_kf;
	
	}
	
	
}
