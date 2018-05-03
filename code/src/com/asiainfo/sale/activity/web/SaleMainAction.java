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

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOSaleMainBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "��������Ϊ�գ�");
			return;
		}

		IBOSaleMainValue[] saleMainValues = null;// ǰ̨�ύ������

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
				cp.set("MESSAGE", "��������Ϊ�գ�");
			} else if (1 == saleMainValues.length) {
				cp.set("MAINID", saleMainSV.saveSaleMain(saleMainValues[0]));
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "�����ɹ���");
			} else {
				saleMainSV.saveSaleMain(saleMainValues);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("����Ӫ��������Ϣ����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void delSaleMain(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		String mainId = request.getParameter("mainId");

		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOSaleMainBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "��������Ϊ�գ�");
			return;
		}

		IBOSaleMainValue[] saleMainValues = null;// ǰ̨�ύ������

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
			cp.set("MESSAGE", "ɾ���ɹ�");
		} catch (Exception e) {
			// ����ʧ��
			log.error("ɾ��Ӫ������Ϣ����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	/*
	 * public void backSubmited(HttpServletRequest request, HttpServletResponse
	 * response) throws Exception { CustomProperty cp =
	 * CustomProperty.getInstance();
	 * 
	 * // ǰ̨���ݵ�XML���ݣ���̨���շ��� String mainId = request.getParameter("mainId");
	 * String itemType = request.getParameter("itemType"); String staffId =
	 * String.valueOf(SessionManager.getUser().getID());
	 * 
	 * ISaleMainSV saleMainSV = (ISaleMainSV) ServiceFactory
	 * .getService(ISaleMainSV.class);
	 * 
	 * try { if (TaskUtil.terminateWorkflow(mainId, itemType, staffId, " ")) {
	 * 
	 * saleMainSV.changeStsTo(mainId, "1"); cp.set("FLAG", "Y");
	 * cp.set("MESSAGE", "�س��ɹ�"); } else { cp.set("FLAG", "N");
	 * cp.set("MESSAGE", "�����ѱ������ܻس�"); } } catch (Exception e) { // ����ʧ��
	 * log.error("Ӫ�����س�����", e); cp.set("FLAG", "N"); cp.set("MESSAGE", "Ӫ�����س�ʧ��"
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
	 * cp.set("MESSAGE", "��������Ϊ�գ�"); } else { UserInfoInterface userInfo =
	 * ServiceManager.getUser(); saleMainSV.cloneSaleMain(mainId,
	 * String.valueOf(userInfo .getID()), String.valueOf(userInfo.getOrgId()));
	 * cp.set("FLAG", "Y"); cp.set("MESSAGE", "�����ɹ���"); } } catch (Exception e)
	 * { // ����ʧ�� log.error("����Ӫ������Ϣ����", e); cp.set("FLAG", "N");
	 * cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage()); } finally {
	 * HttpUtil.showInfo(response, cp); } }
	 * 
	 * // �ж�Ӫ�����ĵ������Ƿ�������Ӿ� public void IsHasTicket(HttpServletRequest request,
	 * HttpServletResponse response) throws Exception {
	 * 
	 * CustomProperty cp = CustomProperty.getInstance();
	 * 
	 * String mainId = request.getParameter("mainId"); ISaleDetailSV
	 * SaleDetailSV = (ISaleDetailSV) ServiceFactory
	 * .getService(ISaleDetailSV.class); ISaleWeaponSV saleWeaponSV =
	 * (ISaleWeaponSV) ServiceFactory .getService(ISaleWeaponSV.class); try { if
	 * (null == mainId || "".equals(mainId)) { cp.set("FLAG", "N");
	 * cp.set("MESSAGE", "��������Ϊ�գ�"); } else {
	 * 
	 * IBOSaleDetailValue[] saleDetails = SaleDetailSV
	 * .getSaleDetailByMainId(mainId, 0, 500); String YoN = "no"; for
	 * (IBOSaleDetailValue saleDetail : saleDetails) { if
	 * (saleDetail.getSaleFlag().equals("12")) { YoN = "yes"; break; } else if
	 * (saleDetail.getSaleFlag().equals("31")) { IBOSaleWeaponValue[] wp =
	 * saleWeaponSV .getSaleWeaponByID(saleDetail.getWeaponId(), 0, 1); if
	 * (wp[0] != null && wp[0].getZfqType().equals("2")) { YoN = "yes"; break; }
	 * } } cp.set("YON", YoN); cp.set("FLAG", "Y"); cp.set("MESSAGE", "�����ɹ���");
	 * } } catch (Exception e) { // ����ʧ�� log.error("�ж��Ƿ�������Ӿ��쳣", e);
	 * cp.set("FLAG", "N"); cp.set("MESSAGE", "�ж��Ƿ�������Ӿ��쳣" + ":" +
	 * e.getMessage()); } finally { HttpUtil.showInfo(response, cp); } }
	 */

	// �ж�Ӫ����������/���α����Ƿ���û��д��
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
	 * cp.set("MESSAGE", "��������Ϊ�գ�"); } else {
	 * 
	 * IBOSaleMainValue saleMain = saleMainSV.getSaleMainById(mainId); if (null
	 * == saleMain.getPromoteManager() ||
	 * "".equals(saleMain.getPromoteManager())) { YoN = "yes"; } else {
	 * IBOSaleDetailValue[] saleDetails = SaleDetailSV
	 * .getSaleDetailByMainId(mainId, 0, 500); for (IBOSaleDetailValue
	 * saleDetail : saleDetails) { if (null == saleDetail.getLevelCode() ||
	 * saleDetail.getLevelCode().equals("")) { YoN = "yes"; break; } }
	 * 
	 * } cp.set("YON", YoN); cp.set("FLAG", "Y"); cp.set("MESSAGE", "�����ɹ���"); }
	 * } catch (Exception e) { // ����ʧ�� log.error("�ж�Ӫ����������/���α����Ƿ���û��д�쳣", e);
	 * cp.set("FLAG", "N"); cp.set("MESSAGE", "�ж�Ӫ����������/���α����Ƿ���û��д�쳣" + ":" +
	 * e.getMessage()); } finally { HttpUtil.showInfo(response, cp); } }
	 */
	public void saveSaleEitApprise(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String mainId = request.getParameter("mainId");
		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BoSaleEitAppriseBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "û���޸���Ҫ���棡");
			return;
		}

		IBoSaleEitAppriseValue[] SaleEitAppriseValues = null;// ǰ̨�ύ������

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
				cp.set("MESSAGE", "û���޸���Ҫ���棡");
			} else if (1 == SaleEitAppriseValues.length) {

				SaleEitAppriseValues[0].setMid(mainId);
				saleEitAppriseSV.saveSaleEitApprise(SaleEitAppriseValues[0]);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("�������ȯӪ�����浥��Ϣ����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
	
	/**
	 * ����ɰ����
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void saveSaleHbHb(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String mainId = request.getParameter("mainId");
		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOSaleHbHbBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "û���޸���Ҫ���棡");
			return;
		}

		IBOSaleHbHbValue[] saleHbHbValues = null;// ǰ̨�ύ������

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
				cp.set("MESSAGE", "û���޸���Ҫ���棡");
			} else if (1 == saleHbHbValues.length) {

				saleHbHbValues[0].setMid(mainId);
				saleHbHbSV.saveSaleHbHb(saleHbHbValues[0]);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("�������ȯӪ����Ͱ������Ϣ����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	// �ж�Ӫ�����ĵ������Ƿ�������Ӿ�
	public void hasEitInSale(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String orderId = request.getParameter("orderId");
		ISaleMainSV saleMainSV = (ISaleMainSV) ServiceFactory
				.getService(ISaleMainSV.class);
		try {
			if (null == orderId || "".equals(orderId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "��������Ϊ�գ�");
			} else {

				if (saleMainSV.hasEitInSale(orderId)) {
					// System.out.println(saleMainSV.hasEitAppriseToWrite(orderId));
					cp.set("FLAG", "Y");
				} else {
					cp.set("FLAG", "N");
				}
				cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("�ж��Ƿ��е���ȯ", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "�ж��Ƿ��е���ȯ" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	// Ӫ�����ĵ���������������Ӿ�����Ƿ���д�˵���ȯ��浥
	public void hasEitAppriseToWrite(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String orderId = request.getParameter("orderId");
		ISaleMainSV saleMainSV = (ISaleMainSV) ServiceFactory
				.getService(ISaleMainSV.class);
		try {
			if (null == orderId || "".equals(orderId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "��������Ϊ�գ�");
			} else {

				if (saleMainSV.hasEitAppriseToWrite(orderId)) {
					// System.out.println(saleMainSV.hasEitAppriseToWrite(orderId));
					cp.set("FLAG", "N");
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
	 * cp.set("MESSAGE", "�Ѵ�����ͬ��BOSS����ID"); } else if
	 * (SaleDetailSV.IsHasSameBossId(levBossid, mainId)) { cp.set("FLAG", "N");
	 * cp.set("MESSAGE", "�Ѵ�����ͬ��BOSS����ID"); } else { cp.set("FLAG", "Y");
	 * cp.set("MESSAGE", ""); } } catch (Exception e) { // ����ʧ��
	 * log.error("�ж��Ƿ������ͬ��BOSSid�쳣", e); cp.set("FLAG", "N"); cp.set("MESSAGE",
	 * "�ж��Ƿ������ͬ��BOSSid�쳣" + ":" + e.getMessage()); } finally {
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
				cp.set("MESSAGE", "��������Ϊ�գ�");
			} else {
				int cn = 0;
				IBONewAttachValue[] attachFiles = attachSV.getAttachFileByItemId(
						Integer.parseInt(orderId), "sale", 0, 100);
				for (IBONewAttachValue file : attachFiles) {
					if (file.getFilename().contains("����")) ++cn;
					if (file.getFilename().contains("����")) ++cn;
				}
				if (cn < 2) {
					cp.set("FLAG", "N");
				} else {
					cp.set("FLAG", "Y");
				}
			}
			cp.set("MESSAGE", "�����ɹ���");
		} catch (Exception e) {
			// ����ʧ��
			log.error("�ж��Ƿ���д�˲����ҵ����˷�������", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "�ж��Ƿ���д�˲����ҵ����˷���" + ":" + e.getMessage());
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
			cp.set("MESSAGE", "�����ɹ���");
			System.out.println(cp);
		} catch (Exception e) {
			// ����ʧ��
			log.error("��������", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
		return saleMainType;
	
	}
}
