package com.asiainfo.charge.web;

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
import com.asiainfo.charge.bo.BOChargeApplyMainBean;
import com.asiainfo.charge.bo.BOChargeMainBean;
import com.asiainfo.charge.ivalues.IBOChargeApplyMainValue;
import com.asiainfo.charge.ivalues.IBOChargeInfoValue;
import com.asiainfo.charge.ivalues.IBOChargeMainValue;
import com.asiainfo.charge.service.interfaces.IChargeMainSV;
import com.asiainfo.charge.service.interfaces.IChargeNewMainSV;
import com.asiainfo.common.service.interfaces.IProductAttachCfgSV;
import com.asiainfo.sale.util.StringUtil;
import com.asiainfo.workflow.util.server.interfaces.ITaskUtilSV;

public class ChargeMainAction extends BaseAction {
	private transient static Log log = LogFactory
			.getLog(ChargeMainAction.class);

	public void saveChargeMain(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		IBOChargeApplyMainValue[] chargeMainValues = null;// 前台提交的数据
		String applyid = request.getParameter("applyid");
		if (applyid.equals("0")) {
			// 前台传递的XML数据，后台接收方法
			DataContainerList[] dcLists = HttpUtil.getDataContainerLists(
					request.getInputStream(),
					new Class[] { BOChargeApplyMainBean.class });

			if (dcLists.length == 0) {
				HttpUtil.showInfo(response, "操作对象为空！");
				return;
			}
			for (int i = 0; i < dcLists.length; i++) {
				Object[] obj = dcLists[i].getColDataContainerInterface(0);
				if (obj instanceof BOChargeApplyMainBean[]) {
					chargeMainValues = (BOChargeApplyMainBean[]) obj;
				}
			}
		}
		IChargeMainSV chargeMainSV = (IChargeMainSV) ServiceFactory
				.getService(IChargeMainSV.class);

		try {
			if (applyid.equals("0")) {
				if (null == chargeMainValues || 0 == chargeMainValues.length) {
					cp.set("FLAG", "N");
					cp.set("MESSAGE", "操作对象为空！");
				} else if (1 == chargeMainValues.length) {
					cp.set("MAINID", chargeMainSV
							.saveChargeMain(chargeMainValues[0]));
					cp.set("FLAG", "Y");
					cp.set("MESSAGE", "操作成功！");
				} else {
					chargeMainSV.saveChargeMain(chargeMainValues);
					cp.set("FLAG", "Y");
					cp.set("MESSAGE", "操作成功！");
				}
			} else {
				chargeMainSV.delChargeDetail(applyid);
				chargeMainSV.delChargeMain(applyid);
			}
		} catch (Exception e) {
			// 操作失败
			log.error("保存资费案主信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void saveChargeNewMain(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		IBOChargeMainValue chargeMainValue = null;// 前台提交的数据
		String applyid = request.getParameter("applyid");
		if (applyid.equals("0")) {
			// 前台传递的XML数据，后台接收方法
			DataContainerList[] dcLists = HttpUtil.getDataContainerLists(
					request.getInputStream(),
					new Class[] { BOChargeMainBean.class });

			if (dcLists.length == 0) {
				HttpUtil.showInfo(response, "操作对象为空！");
				return;
			}
			for (int i = 0; i < dcLists.length; i++) {
				Object[] obj = dcLists[i].getColDataContainerInterface(0);
				if (obj instanceof BOChargeMainBean[]) {
					chargeMainValue = (BOChargeMainBean) obj[0];
				}
			}
		}
		IChargeNewMainSV chargeNewMainSV = (IChargeNewMainSV) ServiceFactory
				.getService(IChargeNewMainSV.class);

		try {
			if (applyid.equals("0")) {
				if (null == chargeMainValue) {
					cp.set("FLAG", "N");
					cp.set("MESSAGE", "操作对象为空！");
				} else {
					// if(!chargeMainValue.getMainId().equals("")){
					// chargeMainValue.setStsToOld();
					// }
					cp.set("NewMainID", chargeNewMainSV
							.saveChargeNewMain(chargeMainValue));
					cp.set("FLAG", "Y");
					// cp.set("MESSAGE", "操作成功！");
				}
			} else {
				// IChargeNewMainSV.delChargeDetail(applyid);
				chargeNewMainSV.delChargeMain(applyid);
			}
		} catch (Exception e) {
			// 操作失败
			log.error("保存资费案主信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void copyChargeMain(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		String id = request.getParameter("applyid");
		String staffId = request.getParameter("staffid");
		String orgId = request.getParameter("org");
		String mid = request.getParameter("mid");
		IChargeMainSV chargeMainSV = (IChargeMainSV) ServiceFactory
				.getService(IChargeMainSV.class);
		try {
			String applyid = chargeMainSV
					.cloneSaleMain(id, staffId, orgId, mid);
			cp.set("APPLYID", applyid);
		} catch (Exception e) {
			log.error("复制资费主信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void checkChargeBossid(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		IBOChargeInfoValue[] IBOChargeInfoValues = null;

		String mainid = request.getParameter("mainid");

		IChargeMainSV chargeMainSV = (IChargeMainSV) ServiceFactory
				.getService(IChargeMainSV.class);
		try {
			IBOChargeInfoValues = chargeMainSV.getChargeDetailByNewMainid(
					mainid, -1, -1);
			for (int i = 0; i < IBOChargeInfoValues.length; i++) {
				if ("".equals(IBOChargeInfoValues[i].getInaddUserCount())
						|| IBOChargeInfoValues[i].getInaddUserCount() == null) {
					cp.set("check", "N");
					return;
				}
			}
		} catch (Exception e) {
			log.error("检查BOSSID出错", e);
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void submitElectChannAssCfg(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String mainid = request.getParameter("mainid");
		try {
			String principle = Long.toString(SessionManager.getUser().getID());
			String orgId = Long.toString(SessionManager.getUser().getOrgId());
			int newId = ((IProductAttachCfgSV) ServiceFactory
					.getService(IProductAttachCfgSV.class))
					.saveProductAttachCfg(principle, orgId, mainid, "charge",
							"1");
			if (newId != -1) {
				String[] retCode = ((ITaskUtilSV) ServiceFactory
						.getService(ITaskUtilSV.class)).createWorkflow(
						"ElectChannAssCfg", "20004933", String.valueOf(newId),
						null, null);
				if (!retCode[0].equals("0000")) {
					cp.set("MESSAGE", "创建协助流程出错！");
					cp.set("FLAG", "N");
				}
			}
		} catch (Exception e) {
			log.error("创建协助流程出错！", e);
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void checkDispachElectChann(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		IBOChargeInfoValue[] IBOChargeInfoValues = null;

		String mainid = request.getParameter("mainid");
		boolean flag = false;

		IChargeMainSV chargeMainSV = (IChargeMainSV) ServiceFactory
				.getService(IChargeMainSV.class);
		try {
			IBOChargeInfoValues = chargeMainSV.getChargeDetailByNewMainid(
					mainid, -1, -1);
			for (int i = 0; i < IBOChargeInfoValues.length; i++) {
				int sendEleChnn = IBOChargeInfoValues[i].getExt6();
				if (sendEleChnn == 1) {
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
						.saveProductAttachCfg(principle, orgId, mainid,
								"charge", "0");
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
}
