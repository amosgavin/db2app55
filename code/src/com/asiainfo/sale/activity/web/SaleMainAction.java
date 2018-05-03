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
import com.asiainfo.sale.activity.bo.BOSaleHbHbBean;
import com.asiainfo.sale.activity.bo.BOSaleMainBean;
import com.asiainfo.sale.activity.bo.BoSaleEitAppriseBean;
import com.asiainfo.sale.activity.ivalues.IBOSaleHbHbValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleMainValue;
import com.asiainfo.sale.activity.ivalues.IBoSaleEitAppriseValue;
import com.asiainfo.sale.activity.service.interfaces.ISaleEitAppriseSV;
import com.asiainfo.sale.activity.service.interfaces.ISaleHbHbSV;
import com.asiainfo.sale.activity.service.interfaces.ISaleMainSV;
import com.asiainfo.sale.common.ivalues.IBONewAttachValue;
import com.asiainfo.sale.common.service.interfaces.IAttachSV;

public class SaleMainAction extends BaseAction {
	private transient static Log log = LogFactory.getLog(SaleMainAction.class);

	public void saveSaleMain(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOSaleMainBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}

		IBOSaleMainValue[] saleMainValues = null;// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOSaleMainBean[]) {
				saleMainValues = (BOSaleMainBean[]) obj;
			}
		}

		ISaleMainSV saleMainSV = (ISaleMainSV) ServiceFactory
				.getService(ISaleMainSV.class);

		try {
			if (null == saleMainValues || 0 == saleMainValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else if (1 == saleMainValues.length) {
				cp.set("MAINID", saleMainSV.saveSaleMain(saleMainValues[0]));
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			} else {
				saleMainSV.saveSaleMain(saleMainValues);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("保存营销案主信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void delSaleMain(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		String mainId = request.getParameter("mainId");

		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOSaleMainBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}

		IBOSaleMainValue[] saleMainValues = null;// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOSaleMainBean[]) {
				saleMainValues = (BOSaleMainBean[]) obj;
			}
		}
		ISaleMainSV saleMainSV = (ISaleMainSV) ServiceFactory
				.getService(ISaleMainSV.class);

		try {
			if (mainId == null || mainId.equals("")) {
				saleMainSV.delSaleMain(saleMainValues);
			} else {
				saleMainSV.deleteSaleMainByMainId(mainId);
			}

			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "删除成功");
		} catch (Exception e) {
			// 操作失败
			log.error("删除营销案信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	/*
	 * public void backSubmited(HttpServletRequest request, HttpServletResponse
	 * response) throws Exception { CustomProperty cp =
	 * CustomProperty.getInstance();
	 * 
	 * // 前台传递的XML数据，后台接收方法 String mainId = request.getParameter("mainId");
	 * String itemType = request.getParameter("itemType"); String staffId =
	 * String.valueOf(SessionManager.getUser().getID());
	 * 
	 * ISaleMainSV saleMainSV = (ISaleMainSV) ServiceFactory
	 * .getService(ISaleMainSV.class);
	 * 
	 * try { if (TaskUtil.terminateWorkflow(mainId, itemType, staffId, " ")) {
	 * 
	 * saleMainSV.changeStsTo(mainId, "1"); cp.set("FLAG", "Y");
	 * cp.set("MESSAGE", "回撤成功"); } else { cp.set("FLAG", "N");
	 * cp.set("MESSAGE", "工单已被处理不能回撤"); } } catch (Exception e) { // 操作失败
	 * log.error("营销案回撤出错", e); cp.set("FLAG", "N"); cp.set("MESSAGE", "营销案回撤失败"
	 * + ":" + e.getMessage()); } finally { HttpUtil.showInfo(response, cp); } }
	 * 
	 * public void cloneSaleMain(HttpServletRequest request, HttpServletResponse
	 * response) throws Exception { CustomProperty cp =
	 * CustomProperty.getInstance();
	 * 
	 * String mainId = request.getParameter("mainId");
	 * 
	 * ISaleMainSV saleMainSV = (ISaleMainSV) ServiceFactory
	 * .getService(ISaleMainSV.class);
	 * 
	 * try { if (null == mainId || "".equals(mainId)) { cp.set("FLAG", "N");
	 * cp.set("MESSAGE", "操作对象为空！"); } else { UserInfoInterface userInfo =
	 * ServiceManager.getUser(); saleMainSV.cloneSaleMain(mainId,
	 * String.valueOf(userInfo .getID()), String.valueOf(userInfo.getOrgId()));
	 * cp.set("FLAG", "Y"); cp.set("MESSAGE", "操作成功！"); } } catch (Exception e)
	 * { // 操作失败 log.error("复制营销案信息出错", e); cp.set("FLAG", "N");
	 * cp.set("MESSAGE", "操作失败" + ":" + e.getMessage()); } finally {
	 * HttpUtil.showInfo(response, cp); } }
	 * 
	 * // 判断营销案的档次中是否包含电子卷 public void IsHasTicket(HttpServletRequest request,
	 * HttpServletResponse response) throws Exception {
	 * 
	 * CustomProperty cp = CustomProperty.getInstance();
	 * 
	 * String mainId = request.getParameter("mainId"); ISaleDetailSV
	 * SaleDetailSV = (ISaleDetailSV) ServiceFactory
	 * .getService(ISaleDetailSV.class); ISaleWeaponSV saleWeaponSV =
	 * (ISaleWeaponSV) ServiceFactory .getService(ISaleWeaponSV.class); try { if
	 * (null == mainId || "".equals(mainId)) { cp.set("FLAG", "N");
	 * cp.set("MESSAGE", "操作对象为空！"); } else {
	 * 
	 * IBOSaleDetailValue[] saleDetails = SaleDetailSV
	 * .getSaleDetailByMainId(mainId, 0, 500); String YoN = "no"; for
	 * (IBOSaleDetailValue saleDetail : saleDetails) { if
	 * (saleDetail.getSaleFlag().equals("12")) { YoN = "yes"; break; } else if
	 * (saleDetail.getSaleFlag().equals("31")) { IBOSaleWeaponValue[] wp =
	 * saleWeaponSV .getSaleWeaponByID(saleDetail.getWeaponId(), 0, 1); if
	 * (wp[0] != null && wp[0].getZfqType().equals("2")) { YoN = "yes"; break; }
	 * } } cp.set("YON", YoN); cp.set("FLAG", "Y"); cp.set("MESSAGE", "操作成功！");
	 * } } catch (Exception e) { // 操作失败 log.error("判断是否包含电子卷异常", e);
	 * cp.set("FLAG", "N"); cp.set("MESSAGE", "判断是否包含电子卷异常" + ":" +
	 * e.getMessage()); } finally { HttpUtil.showInfo(response, cp); } }
	 */

	// 判断营销案的批次/档次编码是否有没填写的
	/*
	 * public void IsHasEmptyBossid(HttpServletRequest request,
	 * HttpServletResponse response) throws Exception {
	 * 
	 * CustomProperty cp = CustomProperty.getInstance();
	 * 
	 * String mainId = request.getParameter("mainId"); ISaleDetailSV
	 * SaleDetailSV = (ISaleDetailSV) ServiceFactory
	 * .getService(ISaleDetailSV.class); ISaleMainSV saleMainSV = (ISaleMainSV)
	 * ServiceFactory .getService(ISaleMainSV.class); String YoN = "no";
	 * 
	 * try { if (null == mainId || "".equals(mainId)) { cp.set("FLAG", "N");
	 * cp.set("MESSAGE", "操作对象为空！"); } else {
	 * 
	 * IBOSaleMainValue saleMain = saleMainSV.getSaleMainById(mainId); if (null
	 * == saleMain.getPromoteManager() ||
	 * "".equals(saleMain.getPromoteManager())) { YoN = "yes"; } else {
	 * IBOSaleDetailValue[] saleDetails = SaleDetailSV
	 * .getSaleDetailByMainId(mainId, 0, 500); for (IBOSaleDetailValue
	 * saleDetail : saleDetails) { if (null == saleDetail.getLevelCode() ||
	 * saleDetail.getLevelCode().equals("")) { YoN = "yes"; break; } }
	 * 
	 * } cp.set("YON", YoN); cp.set("FLAG", "Y"); cp.set("MESSAGE", "操作成功！"); }
	 * } catch (Exception e) { // 操作失败 log.error("判断营销案的批次/档次编码是否有没填写异常", e);
	 * cp.set("FLAG", "N"); cp.set("MESSAGE", "判断营销案的批次/档次编码是否有没填写异常" + ":" +
	 * e.getMessage()); } finally { HttpUtil.showInfo(response, cp); } }
	 */
	public void saveSaleEitApprise(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String mainId = request.getParameter("mainId");
		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BoSaleEitAppriseBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "没有修改需要保存！");
			return;
		}

		IBoSaleEitAppriseValue[] SaleEitAppriseValues = null;// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BoSaleEitAppriseBean[]) {
				SaleEitAppriseValues = (BoSaleEitAppriseBean[]) obj;
			}
		}
		ISaleEitAppriseSV saleEitAppriseSV = (ISaleEitAppriseSV) ServiceFactory
				.getService(ISaleEitAppriseSV.class);

		try {
			if (null == mainId || "null".equals(mainId) || "".equals(mainId)
					|| null == SaleEitAppriseValues
					|| 0 == SaleEitAppriseValues.length) {

				cp.set("FLAG", "N");
				cp.set("MESSAGE", "没有修改需要保存！");
			} else if (1 == SaleEitAppriseValues.length) {

				SaleEitAppriseValues[0].setMid(mainId);
				saleEitAppriseSV.saveSaleEitApprise(SaleEitAppriseValues[0]);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("保存电子券营销活动申告单信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
	
	/**
	 * 保存荷包红包
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void saveSaleHbHb(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String mainId = request.getParameter("mainId");
		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOSaleHbHbBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "没有修改需要保存！");
			return;
		}

		IBOSaleHbHbValue[] saleHbHbValues = null;// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOSaleHbHbBean[]) {
				saleHbHbValues = (BOSaleHbHbBean[]) obj;
			}
		}
		ISaleHbHbSV saleHbHbSV = (ISaleHbHbSV) ServiceFactory
				.getService(ISaleHbHbSV.class);

		try {
			if (null == mainId || "null".equals(mainId) || "".equals(mainId)
					|| null == saleHbHbValues
					|| 0 == saleHbHbValues.length) {

				cp.set("FLAG", "N");
				cp.set("MESSAGE", "没有修改需要保存！");
			} else if (1 == saleHbHbValues.length) {

				saleHbHbValues[0].setMid(mainId);
				saleHbHbSV.saveSaleHbHb(saleHbHbValues[0]);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("保存电子券营销活动和包红包信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	// 判断营销案的档次中是否包含电子卷
	public void hasEitInSale(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String orderId = request.getParameter("orderId");
		ISaleMainSV saleMainSV = (ISaleMainSV) ServiceFactory
				.getService(ISaleMainSV.class);
		try {
			if (null == orderId || "".equals(orderId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {

				if (saleMainSV.hasEitInSale(orderId)) {
					// System.out.println(saleMainSV.hasEitAppriseToWrite(orderId));
					cp.set("FLAG", "Y");
				} else {
					cp.set("FLAG", "N");
				}
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("判断是否含有电子券", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "判断是否含有电子券" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	// 营销案的档次中如果包含电子卷，检查是否填写了电子券申告单
	public void hasEitAppriseToWrite(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String orderId = request.getParameter("orderId");
		ISaleMainSV saleMainSV = (ISaleMainSV) ServiceFactory
				.getService(ISaleMainSV.class);
		try {
			if (null == orderId || "".equals(orderId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {

				if (saleMainSV.hasEitAppriseToWrite(orderId)) {
					// System.out.println(saleMainSV.hasEitAppriseToWrite(orderId));
					cp.set("FLAG", "N");
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

	/*
	 * public void isHasSameBossId(HttpServletRequest request,
	 * HttpServletResponse response) throws Exception {
	 * 
	 * CustomProperty cp = CustomProperty.getInstance();
	 * 
	 * String mainId = request.getParameter("mainId"); String actBossid =
	 * request.getParameter("actBossid"); String levBossid =
	 * request.getParameter("levBossid"); ISaleDetailSV SaleDetailSV =
	 * (ISaleDetailSV) ServiceFactory .getService(ISaleDetailSV.class);
	 * ISaleMainSV saleMainSV = (ISaleMainSV) ServiceFactory
	 * .getService(ISaleMainSV.class);
	 * 
	 * try { if (saleMainSV.IsHasSameBossId(actBossid)) { cp.set("FLAG", "N");
	 * cp.set("MESSAGE", "已存在相同的BOSS批次ID"); } else if
	 * (SaleDetailSV.IsHasSameBossId(levBossid, mainId)) { cp.set("FLAG", "N");
	 * cp.set("MESSAGE", "已存在相同的BOSS档次ID"); } else { cp.set("FLAG", "Y");
	 * cp.set("MESSAGE", ""); } } catch (Exception e) { // 操作失败
	 * log.error("判断是否存在相同的BOSSid异常", e); cp.set("FLAG", "N"); cp.set("MESSAGE",
	 * "判断是否存在相同的BOSSid异常" + ":" + e.getMessage()); } finally {
	 * HttpUtil.showInfo(response, cp); }
	 * 
	 * }
	 */

	public void checkFinalServiceItem(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String orderId = request.getParameter("orderId");
		IAttachSV attachSV = (IAttachSV) ServiceFactory
				.getService(IAttachSV.class);

		try {
			if (null == orderId || "".equals(orderId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {
				int cn = 0;
				IBONewAttachValue[] attachFiles = attachSV.getAttachFileByItemId(
						Integer.parseInt(orderId), "sale", 0, 100);
				for (IBONewAttachValue file : attachFiles) {
					if (file.getFilename().contains("服务")) ++cn;
					if (file.getFilename().contains("稽核")) ++cn;
				}
				if (cn < 2) {
					cp.set("FLAG", "N");
				} else {
					cp.set("FLAG", "Y");
				}
			}
			cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("判断是否填写了财务和业务稽核方案出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "判断是否填写了财务和业务稽核方案" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
	
	public String checksalemaintype(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String orderId = request.getParameter("orderId");
		ISaleMainSV saleMainSV = (ISaleMainSV) ServiceFactory
		.getService(ISaleMainSV.class);
		
		String saleMainType=saleMainSV.checksalemaintype(orderId);
		try {
			if ("rtGroup".equals(saleMainType)) {
				cp.set("SALE_MAIN_TYPE", "rtGroup");
			} if ("rtPerson".equals(saleMainType) ){
				cp.set("SALE_MAIN_TYPE", "rtPerson");				
			}
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");
			System.out.println(cp);
		} catch (Exception e) {
			// 操作失败
			log.error("操作出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
		return saleMainType;
	
	}
}
