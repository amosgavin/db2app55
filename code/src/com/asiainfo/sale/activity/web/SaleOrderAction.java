package com.asiainfo.sale.activity.web;

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
import com.asiainfo.common.service.interfaces.IProductAttachCfgSV;
import com.asiainfo.sale.activity.bo.BOSaleOrderBean;
import com.asiainfo.sale.activity.ivalues.IBOSaleDetailValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleMainValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleOrderValue;
import com.asiainfo.sale.activity.ivalues.IBoSaleEitAppriseValue;
import com.asiainfo.sale.activity.service.interfaces.ISaleDetailSV;
import com.asiainfo.sale.activity.service.interfaces.ISaleEitAppriseSV;
import com.asiainfo.sale.activity.service.interfaces.ISaleMainSV;
import com.asiainfo.sale.activity.service.interfaces.ISaleOrderSV;
import com.asiainfo.sale.util.StringUtil;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponValue;
import com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV;
import com.asiainfo.workflow.util.TaskUtil;
import com.asiainfo.workflow.util.server.interfaces.ITaskUtilSV;

public class SaleOrderAction extends BaseAction {
	private transient static Log log = LogFactory.getLog(SaleOrderAction.class);

	public void saveSaleOrderInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOSaleOrderBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "没有修改需要保存！");
			return;
		}

		IBOSaleOrderValue[] saleOrderValues = null;// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof IBOSaleOrderValue[]) {
				saleOrderValues = (IBOSaleOrderValue[]) obj;
			}
		}

		ISaleOrderSV saleOrderSV = (ISaleOrderSV) ServiceFactory
				.getService(ISaleOrderSV.class);

		try {
			if (null == saleOrderValues || 0 == saleOrderValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "没有修改需要保存！");
			} else if (1 == saleOrderValues.length) {
				if(saleOrderValues[0].isDeleted() == true){
				saleOrderValues[0].undelete();
				saleOrderValues[0].setIsDelete("1");
				}
				cp.set("orderId", String.valueOf(saleOrderSV
						.saveSaleOrderInfo(saleOrderValues[0])));
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("保存营销活动主信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void backSubmited(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		String mainId = request.getParameter("mainId");
		String itemType = request.getParameter("itemType");
		String staffId = String.valueOf(SessionManager.getUser().getID());

		ISaleMainSV saleMainSV = (ISaleMainSV) ServiceFactory
				.getService(ISaleMainSV.class);

		try {
			if (TaskUtil.terminateWorkflow(mainId, itemType, staffId, " ")) {

				saleMainSV.changeStsTo(mainId, "1");
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "回撤成功");
			} else {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "工单已被处理不能回撤");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("营销案回撤出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "营销案回撤失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void cloneSaleOrder(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String orderId = request.getParameter("orderId");
		ISaleOrderSV saleOrderSV = (ISaleOrderSV) ServiceFactory
				.getService(ISaleOrderSV.class);

		try {
			if (null == orderId || "".equals(orderId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {
				String operatorId = String.valueOf(SessionManager.getUser()
						.getID());
				String staffName = SessionManager.getUser().getName();
				String orgId = String.valueOf(SessionManager.getUser()
						.getOrgId());
				String orgName = SessionManager.getUser().getOrgName();

				saleOrderSV.cloneSaleOrder(orderId, operatorId, staffName,
						orgId, orgName);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("复制营销案信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	// 判断营销案的批次/档次编码是否有没填写的
	public void IsHasEmptyBossid(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String orderId = request.getParameter("orderId");
		ISaleOrderSV saleOrderSV = (ISaleOrderSV) ServiceFactory
				.getService(ISaleOrderSV.class);
		String YoN = "no";

		try {
			if (null == orderId || "".equals(orderId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {

				IBOSaleMainValue[] saleMainValues = saleOrderSV
						.getSaleMainByOrderId(orderId, 0, 100);
				for (IBOSaleMainValue saleMVaue : saleMainValues) {

					if (null == saleMVaue.getPromoteManager()
							|| "".equals(saleMVaue.getPromoteManager())) {
						YoN = "yes";
						break;
					}
				}
				IBOSaleDetailValue[] saleDetailValues = saleOrderSV
						.getSaleDetailByOrderId(orderId, 0, 100);
				for (IBOSaleDetailValue saleDetValue : saleDetailValues) {

					if (null == saleDetValue.getLevelCode()
							|| "".equals(saleDetValue.getLevelCode())) {
						YoN = "yes";
						break;
					}
				}
				cp.set("YON", YoN);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("判断营销案的批次/档次编码是否有没填写异常", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "判断营销案的批次/档次编码是否有没填写异常" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	// 营销案的档次中如果包含电子卷，检查是否填写了电子券申告单
	public void checkEitACT(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String mainId = request.getParameter("mainId");
		ISaleDetailSV SaleDetailSV = (ISaleDetailSV) ServiceFactory
				.getService(ISaleDetailSV.class);

		ISaleEitAppriseSV saleEitAppriseSV = (ISaleEitAppriseSV) ServiceFactory
				.getService(ISaleEitAppriseSV.class);

		try {
			if (null == mainId || "".equals(mainId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {

				IBOSaleDetailValue[] saleDetails = SaleDetailSV
						.getSaleDetailByMainId(mainId, 0, 100);
				String YoN = "no";
				for (IBOSaleDetailValue saleDetail : saleDetails) {
					if (saleDetail.getSaleFlag().equals("12")) {
						YoN = "yes";
						break;
					}
				}
				// System.out.println(YoN);
				if (YoN.equals("yes")) {
					IBoSaleEitAppriseValue saleEitApprise = saleEitAppriseSV
							.getSaleEitAppriseByMainId(mainId, "dzj_sgd");
					if (saleEitApprise != null && saleEitApprise.getId() != 0) {
						// System.out.println(saleEitApprise.getId());
						cp.set("FLAG", "Y");
					} else {
						cp.set("FLAG", "N");
					}
				} else {
					cp.set("FLAG", "Y");
				}
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("判断是否填写了电子券申告单", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "判断是否填写了电子券申告单" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void isHasSameBossId(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String orderId = request.getParameter("orderId");
		String actBossid = request.getParameter("actBossid");
		String levBossid = request.getParameter("levBossid");
		ISaleDetailSV SaleDetailSV = (ISaleDetailSV) ServiceFactory
				.getService(ISaleDetailSV.class);
		ISaleMainSV saleMainSV = (ISaleMainSV) ServiceFactory
				.getService(ISaleMainSV.class);

		try {
			if (saleMainSV.IsHasSameBossId(actBossid, orderId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "已存在相同的BOSS批次ID");
			} else if (SaleDetailSV.IsHasSameBossId(levBossid, orderId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "已存在相同的BOSS档次ID");
			} else {
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("判断是否存在相同的BOSSid异常", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "判断是否存在相同的BOSSid异常" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}

	}

	public void isHasSpareTag(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String orderId = request.getParameter("orderId");

		ISaleWeaponSV saleWpSV = (ISaleWeaponSV) ServiceFactory
				.getService(ISaleWeaponSV.class);

		try {
			if (saleWpSV.getSpareTagCountByActivityId(orderId) > 0) {
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("判断是否存在备用标签异常", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "判断是否存在备用标签异常" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}

	}

	public void needWeaponTestAudit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String workflowId = request.getParameter("workflowId");

		ISaleWeaponSV saleWpSV = (ISaleWeaponSV) ServiceFactory
				.getService(ISaleWeaponSV.class);

		try {
			if (saleWpSV.needWeaponTestAudit(workflowId)) {
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("判断是否省业支审核武器测试异常", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "判断是否省业支审核武器测试异常" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}

	}

	public void submitElectChannAssCfg(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();
		String orderId = request.getParameter("orderId");

		try {

			String principle = Long.toString(SessionManager.getUser().getID());
			String orgId = Long.toString(SessionManager.getUser().getOrgId());
			int newId = ((IProductAttachCfgSV) ServiceFactory
					.getService(IProductAttachCfgSV.class))
					.saveProductAttachCfg(principle, orgId, orderId, "sale",
							"1");
			if (newId != -1) {
				String[] retCode = ((ITaskUtilSV) ServiceFactory
						.getService(ITaskUtilSV.class)).createWorkflow(
						"ElectChannAssCfg", "20004933", String.valueOf(newId),
						null, null);
				if (!retCode[0].equals("0000")) {
					cp.set("MESSAGE", "创建电子渠道协助流程出错");
					cp.set("FLAG", "N");
				}
			}
		} catch (Exception e) {
			log.error("创建电子渠道协助配置流程出错！", e);
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void checkDispachElectChann(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String orderId = request.getParameter("orderId");
		boolean flag = false;

		ISaleOrderSV saleOrderSV = (ISaleOrderSV) ServiceFactory
				.getService(ISaleOrderSV.class);

		ISaleWeaponSV saleWeaponSV = (ISaleWeaponSV) ServiceFactory
				.getService(ISaleWeaponSV.class);

		try {
			IBOSaleDetailValue[] saleDetailValues = saleOrderSV
					.getSaleDetailByOrderId(orderId, 0, 100);
			for (IBOSaleDetailValue saleDetValue : saleDetailValues) {
				IBOSaleWeaponValue[] wpValues = saleWeaponSV.getSaleWeaponByID(
						saleDetValue.getWeaponId(), 0, 1);
				if (wpValues != null && wpValues.length > 0) {
					if (StringUtil.isNotBlank(wpValues[0].getStandbyNum3())
							&& wpValues[0].getStandbyNum3().equals("1"))
						flag = true;
					break;
				}
			}
			if (flag) {
				String principle = Long.toString(SessionManager.getUser()
						.getID());
				String orgId = Long.toString(SessionManager.getUser()
						.getOrgId());
				int newId = ((IProductAttachCfgSV) ServiceFactory
						.getService(IProductAttachCfgSV.class))
						.saveProductAttachCfg(principle, orgId, orderId,
								"sale", "0");
				if (newId != -1) {
					String[] retCode = ((ITaskUtilSV) ServiceFactory
							.getService(ITaskUtilSV.class)).createWorkflow(
							"ElectChannCfg", "20004967", String.valueOf(newId),
							null, null);
					if (!retCode[0].equals("0000")) {
						cp.set("MESSAGE", "创建电子渠道配置流程出错");
						cp.set("FLAG", "N");
					}
				}
			}
		} catch (Exception e) {
			log.error("创建电子渠道配置流程出错！", e);
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void checkHasGroupAct(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String orderId = request.getParameter("orderId");
		String hasGroupAct = "no";

		ISaleOrderSV saleOrderSV = (ISaleOrderSV) ServiceFactory
				.getService(ISaleOrderSV.class);

		try {
			for (IBOSaleMainValue vl : saleOrderSV.getSaleMainByOrderId(
					orderId, 0, -1)) {
				if ("rtGroup".equals(vl.getSaleMainType())) {
					hasGroupAct = "yes";
					break;
				}
			}
			cp.set("hasGroupAct", hasGroupAct);
			cp.set("FLAG", "Y");
		} catch (Exception e) {
			cp.set("FLAG", "N");
			e.printStackTrace();
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
