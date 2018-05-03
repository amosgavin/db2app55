package com.asiainfo.task.web;

import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.charge.service.interfaces.IChargeNewMainSV;
import com.asiainfo.common.service.interfaces.IAuditInfoShowSV;
import com.asiainfo.sale.access.service.interfaces.IAccessChangeSV;
import com.asiainfo.sale.access.service.interfaces.IBusiChangeSV;
import com.asiainfo.sale.activity.bo.BOSaleMainBean;
import com.asiainfo.sale.activity.ivalues.IBOSaleMainValue;
import com.asiainfo.sale.activity.service.interfaces.ISaleMainSV;
import com.asiainfo.sale.activity.service.interfaces.ISaleOrderSV;
import com.asiainfo.sale.complain.service.interfaces.IOrderComplainSV;
import com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV;
import com.asiainfo.util.agent.ClientAgent;
import com.asiainfo.task.service.interfaces.ICurTaskSV;
import com.asiainfo.workflow.util.TaskUtil;
import org.apache.poi.ss.usermodel.Workbook;
import com.asiainfo.sale.prestore.service.interfaces.ISaleBatchPrestoreSV;
import com.asiainfo.stopSelling.service.interfaces.IStopSellMSV;

public class CurTaskAction extends BaseAction {
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
				cp.set("MAINID", String.valueOf(saleMainSV
						.saveSaleMain(saleMainValues[0])));
			} else {
				saleMainSV.saveSaleMain(saleMainValues);
			}
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "�����ɹ���");
		} catch (Exception e) {
			// ����ʧ��
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void backTask(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String taskId = request.getParameter("taskId");
		String staffId = request.getParameter("staffId");
		CustomProperty cp = CustomProperty.getInstance();
		Boolean bt = false;
		String reason = "";
		HashMap var = new HashMap();
		try {
			bt = ClientAgent.backTask(taskId, staffId, reason, var);
			if (bt == true) {
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "���˳ɹ���");
			} else {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "����ʧ�ܣ�ѡ�������޷����ˣ�����ϵ����Ա��");
			}
		} catch (Exception e) {
			e.printStackTrace();
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ�ܣ�ѡ�������޷����ˣ�����ϵ����Ա��");
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void toExcel(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String mid = request.getParameter("mid");
		String type = request.getParameter("type");
		CustomProperty cp = CustomProperty.getInstance();
		response.reset();
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ new String("iso-8859-1") + "\"");

		OutputStream outStream = response.getOutputStream();
		try {
			Workbook wb = ((ICurTaskSV) ServiceFactory
					.getService(ICurTaskSV.class)).toExcel(mid, type);
			if (wb != null) {
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "������ɣ�");
			} else {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "����ʧ�ܣ�����ϵ����Ա��");
			}
			wb.write(outStream);
		} catch (Exception e) {
			e.printStackTrace();
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ�ܣ�����ϵ����Ա��");
		} finally {
			HttpUtil.showInfo(response, cp);
			outStream.flush();
			outStream.close();
		}
	}

	/*
	 * �س�����
	 */
	public void terminateWorkflow(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String objecttype = request.getParameter("object_type");
		String objectid = request.getParameter("object_id");
		String staffId = request.getParameter("staffId");
		CustomProperty cp = CustomProperty.getInstance();
		Boolean bt = false;
		String reason = "";
		ISaleOrderSV saleOrderSV = (ISaleOrderSV) ServiceFactory
				.getService(ISaleOrderSV.class);
		ISaleWeaponSV saleWeaponSV = (ISaleWeaponSV) ServiceFactory
				.getService(ISaleWeaponSV.class);
		IChargeNewMainSV chargeMainSV = (IChargeNewMainSV) ServiceFactory
				.getService(IChargeNewMainSV.class);
		IAccessChangeSV accessChangeSV = (IAccessChangeSV) ServiceFactory
				.getService(IAccessChangeSV.class);
		IBusiChangeSV busiChangeSV = (IBusiChangeSV) ServiceFactory
				.getService(IBusiChangeSV.class);
		ISaleBatchPrestoreSV prestoreSV = ((ISaleBatchPrestoreSV) ServiceFactory
				.getService(ISaleBatchPrestoreSV.class));
		IStopSellMSV saleSellStSV = ((IStopSellMSV) ServiceFactory
				.getService(IStopSellMSV.class));
		IOrderComplainSV orderComplainSV = (IOrderComplainSV) ServiceFactory
				.getService(IOrderComplainSV.class);
		try {
			bt = TaskUtil.terminateWorkflow(objectid, objecttype, staffId,
					reason);
			if (bt == true) {
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "���������ɹ���");
				if (objecttype.subSequence(0, 6).equals("weapon")) {
					// ����
					saleWeaponSV.changeWeaponState(objectid, "A");
				}
				if (objecttype.equals("saleCase")
						|| objecttype.equals("saleCaseT")
						|| objecttype.equals("saleCaseZQ")
						|| objecttype.equals("saleCaseI")) {
					// Ӫ����
					// "1"�Ǳ���״̬
					saleOrderSV.changeStsTo(objectid, "1");
				}
				if (objecttype.equals("chargeCaseT")
						|| objecttype.equals("chargeCase")
						|| objecttype.equals("UniteChargeFlow")
						|| objecttype.equals("newChargeCaseT")
						|| objecttype.equals("newChargeCaseP")) {
					// �ʷ�
					chargeMainSV.changeChargeMainState(objectid, "1");
				}
				if (objecttype.subSequence(0, 6).equals("access")) {
					// �������
					accessChangeSV.changeAccessState(objectid, "1");
				}
				if (objecttype.subSequence(0, 4).equals("busi")
						|| objecttype.subSequence(0, 7).equals("channel")
						|| objecttype.subSequence(0, 7).equals("activit")) {
					// ҵ����
					busiChangeSV.changeStateTo(objectid, "1");
				}
				if (objecttype.length() >= 8
						&& objecttype.subSequence(0, 8).equals("prestore")) {
					prestoreSV.updatePrestoreState(objectid, "1");
				}
				if (objecttype.equals("chargeSellStopCaseT")
						|| objecttype.equals("chargeSellStopCaseP")
						|| objecttype.equals("saleSellStopCaseT")
						|| objecttype.equals("saleSellStopCaseP")) {
					// �ʷѡ�Ӫ����ͣ��
					saleSellStSV.changeStsTo(objectid, "1");
				}
				if (objecttype.equals("complainCase")) {
					// ��������
					orderComplainSV.changeStateTo(objectid, "1");
				}
			} else {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "��������ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "��������ʧ�ܣ�");
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void getWorkflowId(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		String apply_id = request.getParameter("apply_id");
		String state = request.getParameter("state");
		try {
			String workflowId = ((ICurTaskSV) ServiceFactory
					.getService(ICurTaskSV.class)).getWorkflowIdByrecordId(
					apply_id, state);
			cp.set("workflowId", workflowId);
		} catch (Exception e) {
			e.printStackTrace();
			cp.set("MESSAGE", "ȡWorkflowId����");
		} finally {
			HttpUtil.showInfo(response, cp);
		}

	}

	public void getCurTaskTagByOrderId(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		String orderId = request.getParameter("orderId");
		try {
			String taskTag = ((IAuditInfoShowSV) ServiceFactory
					.getService(IAuditInfoShowSV.class))
					.getCurTaskTagByOrderId(orderId);
			cp.set("taskTag", taskTag);
			cp.set("FLAG", "Y");
		} catch (Exception e) {
			e.printStackTrace();
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "��ʼ������");
		} finally {
			HttpUtil.showInfo(response, cp);
		}

	}

}
