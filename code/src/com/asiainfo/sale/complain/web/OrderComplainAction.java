package com.asiainfo.sale.complain.web;

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
import com.asiainfo.sale.common.dao.interfaces.IOperatorInfoDAO;
import com.asiainfo.sale.complain.bo.BOOrderComplainsBean;
import com.asiainfo.sale.complain.bo.BOOrderComplainsDetailBean;
import com.asiainfo.sale.complain.ivalues.IBOOrderComplainsDetailValue;
import com.asiainfo.sale.complain.ivalues.IBOOrderComplainsValue;
import com.asiainfo.sale.complain.service.interfaces.IOrderComplainDetailSV;
import com.asiainfo.sale.complain.service.interfaces.IOrderComplainSV;

public class OrderComplainAction extends BaseAction {

	private transient static Log log = LogFactory.getLog(BaseAction.class);

	// 保存投诉申请主表信息
	public void saveOrderComplainMainInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		IBOOrderComplainsValue[] orderComplainValues = null;
		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOOrderComplainsBean.class });
		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOOrderComplainsBean[]) {
				orderComplainValues = (BOOrderComplainsBean[]) obj;
			}
		}
		IOrderComplainSV orderComplainSV = (IOrderComplainSV) ServiceFactory
				.getService(IOrderComplainSV.class);
		IOperatorInfoDAO opSv = (IOperatorInfoDAO) ServiceFactory
				.getService(IOperatorInfoDAO.class);
		try {
			if (null == orderComplainValues || 0 == orderComplainValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "没有修改需要保存！");
			} else if (1 == orderComplainValues.length) {
				IBOOrderComplainsValue bean = orderComplainValues[0];
				if (bean != null) {
					bean.setTel(opSv.getNameById(
							String.valueOf(SessionManager.getUser().getID()))
							.getBillId());
					int complainId = orderComplainSV.saveOrderComplain(bean);
					cp.set("FLAG", "Y");
					cp.set("complainId", String.valueOf(complainId));
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

	// 保存投诉申请详细信息表
	public void saveOrderComplainDetail(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		IBOOrderComplainsDetailValue[] idetailValues = null;
		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(),
				new Class[] { BOOrderComplainsDetailBean.class });
		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOOrderComplainsDetailBean[]) {
				idetailValues = (BOOrderComplainsDetailBean[]) obj;
			}
		}
		IOrderComplainDetailSV detailSV = (IOrderComplainDetailSV) ServiceFactory
				.getService(IOrderComplainDetailSV.class);
		try {
			if (null == idetailValues || 0 == idetailValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "没有修改需要保存！");
			} else if (1 == idetailValues.length) {
				int Did = detailSV.saveOrderComplainDetail(idetailValues[0]);
				cp.set("FLAG", "Y");
				cp.set("Did", String.valueOf(Did));
				cp.set("MESSAGE", "操作成功！");
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

	// 批量删除投诉申请详细信息
	public void delOrderComplainDetail(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		IBOOrderComplainsDetailValue[] idetailValues = null;
		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(),
				new Class[] { BOOrderComplainsDetailBean.class });
		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOOrderComplainsDetailBean[]) {
				idetailValues = (BOOrderComplainsDetailBean[]) obj;
			}
		}
		IOrderComplainDetailSV detailSV = (IOrderComplainDetailSV) ServiceFactory
				.getService(IOrderComplainDetailSV.class);
		try {
			if (null == idetailValues || 0 == idetailValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "没有修改需要保存！");
			} else if (idetailValues.length > 0) {
				detailSV.delOrderComplainDetail(idetailValues);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
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

	// 删除投诉工单信息以及和该工单相关的投诉工单详细信息
	public void delComplain(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		IBOOrderComplainsValue[] iValues = null;
		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOOrderComplainsBean.class });
		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOOrderComplainsBean[]) {
				iValues = (BOOrderComplainsBean[]) obj;
			}
		}
		IOrderComplainSV iSV = (IOrderComplainSV) ServiceFactory
				.getService(IOrderComplainSV.class);
		try {
			if (null == iValues || 0 == iValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "没有修改需要保存！");
			} else if (1 == iValues.length) {
				// 删除投诉工单主表
				int complainId = iSV.saveOrderComplain(iValues[0]);
				IOrderComplainDetailSV idetailSV = (IOrderComplainDetailSV) ServiceFactory
						.getService(IOrderComplainDetailSV.class);
				// 通过complainId查询出和该工单相关联的工单详细信息
				IBOOrderComplainsDetailValue[] idetailValues = idetailSV
						.getOrderComplainDetailByPID(Integer
								.toString(complainId), -1, -1);
				// 删除和该工单相关联的工单详细信息
				idetailSV.delOrderComplainDetail(idetailValues);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
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
