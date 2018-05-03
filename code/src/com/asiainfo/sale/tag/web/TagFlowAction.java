package com.asiainfo.sale.tag.web;

import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.sale.tag.ivalues.IBOPromationTagValue;
import com.asiainfo.sale.tag.service.interfaces.ITagDetailSV;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponValue;
import com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV;
import com.asiainfo.util.agent.ClientAgent;

public class TagFlowAction extends BaseAction {

	private transient static Log log = LogFactory.getLog(TagFlowAction.class);

	public void startWorkflow(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String taskId = request.getParameter("pid");
		String staffId = String.valueOf(SessionManager.getUser().getID());
		long orgId = SessionManager.getUser().getOrgId();

		ITagDetailSV tagDetailSV = (ITagDetailSV) ServiceFactory
				.getService(ITagDetailSV.class);
		IBOPromationTagValue[] promTags = tagDetailSV.getTagDetailByMainId(
				taskId, 1, 10);

		if (null != promTags) {
			for (int i = 0; i < promTags.length; ++i) {
				IBOPromationTagValue promTag = promTags[i];
				promTag.setState("2");
			}
		}
		tagDetailSV.saveTagDetail(promTags, 0);
		ClientAgent.createWorkflow("template.SaleTagNewFlow", staffId,
				"tagCase", taskId, "", "", String.valueOf(orgId));
	}

	public void dispatchTask(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String taskId = request.getParameter("taskId");
		String staffId = String.valueOf(SessionManager.getUser().getID());
		String staffIdList = request.getParameter("staffIdList");
		System.out.println(taskId + "  " + staffId + ": " + staffIdList);
		ClientAgent.assignReason("5000", staffId, "tagCase", taskId, "", "",
				staffIdList);
	}

	public void signTask(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String taskId = request.getParameter("taskId");
		String reason = request.getParameter("reason");
		String staffId = String.valueOf(SessionManager.getUser().getID());
		System.out.println(taskId + " " + reason + " " + staffId);
		ClientAgent
				.signTask("5000", staffId, "tagCase", taskId, "", reason, "");
	}

	public void approveTask(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String taskId = request.getParameter("taskId");
		String reason = request.getParameter("reason");
		String operatorId = request.getParameter("operatorId");
		String staffId = String.valueOf(SessionManager.getUser().getID());
		String result = request.getParameter("result");

		if (result.equals("approve")) {
			ITagDetailSV tagDetailSV = (ITagDetailSV) ServiceFactory
					.getService(ITagDetailSV.class);
			IBOPromationTagValue[] promTags = tagDetailSV.getTagDetailByMainId(
					taskId, 1, 10);

			if (null != promTags) {
				for (int i = 0; i < promTags.length; ++i) {
					IBOPromationTagValue promTag = promTags[i];
					promTag.setState("1");
				}
			}
			tagDetailSV.saveTagDetail(promTags, 0);
		} else {
			ITagDetailSV tagDetailSV = (ITagDetailSV) ServiceFactory
					.getService(ITagDetailSV.class);
			IBOPromationTagValue[] promTags = tagDetailSV.getTagDetailByMainId(
					taskId, 1, 10);

			if (null != promTags) {
				for (int i = 0; i < promTags.length; ++i) {
					IBOPromationTagValue promTag = promTags[i];
					promTag.setState("3");
				}
			}
			tagDetailSV.saveTagDetail(promTags, 0);
		}
		ClientAgent.assignTask("5000", staffId, "tagCase", taskId, "", reason,
				result, operatorId);
	}

	public void afterFinishTask(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		boolean isEnd = request.getParameter("taskState").equals("taskIsEnd");
		String weaponId = request.getParameter("weaponId");

		ISaleWeaponSV saleWeaponSV = (ISaleWeaponSV) ServiceFactory
				.getService(ISaleWeaponSV.class);
		IBOSaleWeaponValue[] weapon = saleWeaponSV.getSaleWeaponByID(weaponId,
				1, 1);
		IBOSaleWeaponValue[] weapons = saleWeaponSV.getSaleWeaponOnlyByMID(weapon[0].getMid());
		if (isEnd) {
			ITagDetailSV tagDetailSV = (ITagDetailSV) ServiceFactory
					.getService(ITagDetailSV.class);
			for(int k=0;k<weapons.length;k++){
				IBOPromationTagValue[] promationTags = tagDetailSV
				.getSpareTagDetailByWeaponId(Integer.parseInt(weapons[k].getId()));
				if (weapons != null) {
					weapons[k].setState("U");
				}
			for (int i = 0; i < promationTags.length; ++i) {
				if (promationTags[i] != null) {
					if (!"8".equals(promationTags[i].getTagType())) {
						promationTags[i].setState("1");
					}
					promationTags[i].setPid(Integer.parseInt(weapons[k].getId()));
				}
			}
			tagDetailSV.saveTagDetail(promationTags, 0);
			}
			saleWeaponSV.saveSaleWeapon(weapons);
		} else {
			if (weapons != null) {
				String finishTime = request.getParameter("configTime");
				if (finishTime != null && !finishTime.equals("")) {
					Timestamp configTime = Timestamp.valueOf(finishTime);
					for(int t=0;t<weapons.length;t++){
						weapons[t].setConfigTime(configTime);
					}
					saleWeaponSV.saveSaleWeapon(weapons);
				}
			}
		}
	}

	public void afterProxyTask(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String weaponId = request.getParameter("weaponId");

		ISaleWeaponSV saleWeaponSV = (ISaleWeaponSV) ServiceFactory
				.getService(ISaleWeaponSV.class);
		IBOSaleWeaponValue[] weapons = saleWeaponSV.getSaleWeaponByID(weaponId,
				1, 1);

		if (weapons != null) {

			String finishTime = request.getParameter("configTime");
			if (finishTime != null && !finishTime.equals("")) {
				Timestamp configTime = Timestamp.valueOf(finishTime);
				weapons[0].setConfigTime(configTime);
				saleWeaponSV.saveSaleWeapon(weapons);
			}

		}
	}

	public void getWeaponTypeByWeaponId(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();
		String weaponId = request.getParameter("weaponId");

		ISaleWeaponSV saleWeaponSV = (ISaleWeaponSV) ServiceFactory
				.getService(ISaleWeaponSV.class);
		try {
			IBOSaleWeaponValue[] weapons = saleWeaponSV.getSaleWeaponByMainId(
					weaponId, 0, 1);

			if (weapons != null) {

				String weaponType = weapons[0].getSaleFlag();
				cp.set("WEAPONTYPE", weaponType);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			} 
		} catch (Exception e) {
			// 操作失败
			log.error("查询出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}

	}
}
