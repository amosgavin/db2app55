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

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOSaleOrderBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "û���޸���Ҫ���棡");
			return;
		}

		IBOSaleOrderValue[] saleOrderValues = null;// ǰ̨�ύ������

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
				cp.set("MESSAGE", "û���޸���Ҫ���棡");
			} else if (1 == saleOrderValues.length) {
				if(saleOrderValues[0].isDeleted() == true){
				saleOrderValues[0].undelete();
				saleOrderValues[0].setIsDelete("1");
				}
				cp.set("orderId", String.valueOf(saleOrderSV
						.saveSaleOrderInfo(saleOrderValues[0])));
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("����Ӫ�������Ϣ����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void backSubmited(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		String mainId = request.getParameter("mainId");
		String itemType = request.getParameter("itemType");
		String staffId = String.valueOf(SessionManager.getUser().getID());

		ISaleMainSV saleMainSV = (ISaleMainSV) ServiceFactory
				.getService(ISaleMainSV.class);

		try {
			if (TaskUtil.terminateWorkflow(mainId, itemType, staffId, " ")) {

				saleMainSV.changeStsTo(mainId, "1");
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "�س��ɹ�");
			} else {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "�����ѱ������ܻس�");
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("Ӫ�����س�����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "Ӫ�����س�ʧ��" + ":" + e.getMessage());
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
				cp.set("MESSAGE", "��������Ϊ�գ�");
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
				cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("����Ӫ������Ϣ����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	// �ж�Ӫ����������/���α����Ƿ���û��д��
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
				cp.set("MESSAGE", "��������Ϊ�գ�");
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
				cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("�ж�Ӫ����������/���α����Ƿ���û��д�쳣", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "�ж�Ӫ����������/���α����Ƿ���û��д�쳣" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	// Ӫ�����ĵ���������������Ӿ�����Ƿ���д�˵���ȯ��浥
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
				cp.set("MESSAGE", "��������Ϊ�գ�");
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
				cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("�ж��Ƿ���д�˵���ȯ��浥", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "�ж��Ƿ���д�˵���ȯ��浥" + ":" + e.getMessage());
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
				cp.set("MESSAGE", "�Ѵ�����ͬ��BOSS����ID");
			} else if (SaleDetailSV.IsHasSameBossId(levBossid, orderId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "�Ѵ�����ͬ��BOSS����ID");
			} else {
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "");
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("�ж��Ƿ������ͬ��BOSSid�쳣", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "�ж��Ƿ������ͬ��BOSSid�쳣" + ":" + e.getMessage());
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
			// ����ʧ��
			log.error("�ж��Ƿ���ڱ��ñ�ǩ�쳣", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "�ж��Ƿ���ڱ��ñ�ǩ�쳣" + ":" + e.getMessage());
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
			// ����ʧ��
			log.error("�ж��Ƿ�ʡҵ֧������������쳣", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "�ж��Ƿ�ʡҵ֧������������쳣" + ":" + e.getMessage());
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
					cp.set("MESSAGE", "������������Э�����̳���");
					cp.set("FLAG", "N");
				}
			}
		} catch (Exception e) {
			log.error("������������Э���������̳���", e);
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
						cp.set("MESSAGE", "�������������������̳���");
						cp.set("FLAG", "N");
					}
				}
			}
		} catch (Exception e) {
			log.error("�������������������̳���", e);
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
