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
				cp.set("MAINID", String.valueOf(saleMainSV
						.saveSaleMain(saleMainValues[0])));
			} else {
				saleMainSV.saveSaleMain(saleMainValues);
			}
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
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
				cp.set("MESSAGE", "回退成功！");
			} else {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "回退失败，选中任务无法回退，请联系管理员！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "回退失败，选中任务无法回退，请联系管理员！");
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
				cp.set("MESSAGE", "导出完成！");
			} else {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "导出失败，请联系管理员！");
			}
			wb.write(outStream);
		} catch (Exception e) {
			e.printStackTrace();
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "导出失败，请联系管理员！");
		} finally {
			HttpUtil.showInfo(response, cp);
			outStream.flush();
			outStream.close();
		}
	}

	/*
	 * 回撤工单
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
				cp.set("MESSAGE", "撤销工单成功！");
				if (objecttype.subSequence(0, 6).equals("weapon")) {
					// 武器
					saleWeaponSV.changeWeaponState(objectid, "A");
				}
				if (objecttype.equals("saleCase")
						|| objecttype.equals("saleCaseT")
						|| objecttype.equals("saleCaseZQ")
						|| objecttype.equals("saleCaseI")) {
					// 营销案
					// "1"是保存状态
					saleOrderSV.changeStsTo(objectid, "1");
				}
				if (objecttype.equals("chargeCaseT")
						|| objecttype.equals("chargeCase")
						|| objecttype.equals("UniteChargeFlow")
						|| objecttype.equals("newChargeCaseT")
						|| objecttype.equals("newChargeCaseP")) {
					// 资费
					chargeMainSV.changeChargeMainState(objectid, "1");
				}
				if (objecttype.subSequence(0, 6).equals("access")) {
					// 渠道变更
					accessChangeSV.changeAccessState(objectid, "1");
				}
				if (objecttype.subSequence(0, 4).equals("busi")
						|| objecttype.subSequence(0, 7).equals("channel")
						|| objecttype.subSequence(0, 7).equals("activit")) {
					// 业务变更
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
					// 资费、营销案停售
					saleSellStSV.changeStsTo(objectid, "1");
				}
				if (objecttype.equals("complainCase")) {
					// 工单申请
					orderComplainSV.changeStateTo(objectid, "1");
				}
			} else {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "撤销工单失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "撤销工单失败！");
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
			cp.set("MESSAGE", "取WorkflowId出错！");
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
			cp.set("MESSAGE", "初始化出错！");
		} finally {
			HttpUtil.showInfo(response, cp);
		}

	}

}
