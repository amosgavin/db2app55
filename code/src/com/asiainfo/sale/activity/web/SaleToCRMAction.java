package com.asiainfo.sale.activity.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.sale.activity.dao.interfaces.ISaleCustGroupDAO;
import com.asiainfo.sale.activity.ivalues.IBOSaleDetailValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleMainValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleRelatCgroupValue;
import com.asiainfo.sale.activity.service.interfaces.ICustGroupSV;
import com.asiainfo.sale.activity.service.interfaces.ISaleDetailSV;
import com.asiainfo.sale.activity.service.interfaces.ISaleOrderSV;
import com.asiainfo.sale.util.SaleToCRMClient;

public class SaleToCRMAction extends BaseAction {
	private transient static Log log = LogFactory.getLog(SaleToCRMAction.class);

	public void createOrderInCRM(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String orderId = request.getParameter("orderId");

		try {
			ISaleOrderSV saleOrderSV = (ISaleOrderSV) ServiceFactory
					.getService(ISaleOrderSV.class);
			ISaleCustGroupDAO saleCGroupSV = (ISaleCustGroupDAO) ServiceFactory
					.getService(ISaleCustGroupDAO.class);
			ISaleDetailSV saleDetailSV = (ISaleDetailSV) ServiceFactory
					.getService(ISaleDetailSV.class);
			ICustGroupSV cgSV = (ICustGroupSV) ServiceFactory
					.getService(ICustGroupSV.class);

			SaleToCRMClient client = new SaleToCRMClient();

			for (IBOSaleMainValue sm : saleOrderSV.getSaleMainByOrderId(
					orderId, 0, -1)) {
				for (IBOSaleRelatCgroupValue cg : cgSV
						.getSaleRelatCgroupByRelaId(sm.getId(), "act", 0, -1)) {
					client.dealCustomer(cg.getCgroupId(), cg.getCgroupName(),
							cg.getCgroupUsernum(), cg.getCgroupRegion(), "1");
					Thread.sleep(200);
				}
				client.createAct(sm.getId(), "PTPCEICreateAct");
				Thread.sleep(200);
				for (IBOSaleDetailValue sd : saleDetailSV
						.getSaleDetailByMainId(sm.getId(), 0, -1)) {
					for (IBOSaleRelatCgroupValue cg : cgSV
							.getSaleRelatCgroupByRelaId(sd.getId(), "lev", 0,
									-1)) {
						client.dealCustomer(cg.getCgroupId(), cg
								.getCgroupName(), cg.getCgroupUsernum(), cg
								.getCgroupRegion(), "1");
						Thread.sleep(200);
					}
					client.createLevel(sm.getId(), sd.getId(),
							"PTPCEICreateLevel");
					Thread.sleep(200);
				}
			}
			saleCGroupSV.addCGroupSchedule(orderId);
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

	public void modifyOrderInCRM(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String orderId = request.getParameter("orderId");

		try {
			ISaleOrderSV saleOrderSV = (ISaleOrderSV) ServiceFactory
					.getService(ISaleOrderSV.class);
			ISaleDetailSV saleDetailSV = (ISaleDetailSV) ServiceFactory
					.getService(ISaleDetailSV.class);
			SaleToCRMClient client = new SaleToCRMClient();

			for (IBOSaleMainValue sm : saleOrderSV.getSaleMainByOrderId(
					orderId, 0, -1)) {
				client.createAct(sm.getId(), "PTPCEIModifyAct");
				for (IBOSaleDetailValue sd : saleDetailSV
						.getSaleDetailByMainId(sm.getId(), 0, -1)) {
					client.createLevel(sm.getId(), sd.getId(),
							"PTPCEIModifyLevel");
				}
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
}
