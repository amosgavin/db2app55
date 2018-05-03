package com.asiainfo.sale.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.ai.secframe.orgmodel.service.interfaces.ISecOrganizeSV;
import com.asiainfo.sale.common.service.interfaces.IAppriseSV;
import com.asiainfo.sale.common.service.interfaces.ISendSmsSV;
import com.asiainfo.sale.tag.web.DetailTagAction;

public class AppriseAction extends BaseAction {

	private transient static Log log = LogFactory.getLog(AppriseAction.class);

	public void saveAppriseOrg(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String workflowId = request.getParameter("workflowId");
		String orgStr = request.getParameter("orgList");

		IAppriseSV appriseSV = (IAppriseSV) ServiceFactory
				.getService(IAppriseSV.class);

		try {

			appriseSV.saveAppriseOrg(orgStr, workflowId);
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("保存出错！", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void modifyAppriseOrg(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String workflowId = request.getParameter("workflowId");
		String orgStr = request.getParameter("orgList");

		IAppriseSV appriseSV = (IAppriseSV) ServiceFactory
				.getService(IAppriseSV.class);

		try {

			appriseSV.modifyAppriseOrg(orgStr, workflowId);
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("修改出错！", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void savaApprisePrime(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String workflowId = request.getParameter("workflowId");
		int orgId = Integer.parseInt(request.getParameter("orgId"));
		String content = request.getParameter("content").replace("^#", "%");
		String senderInfo = request.getParameter("senderInfo");

		IAppriseSV appriseSV = (IAppriseSV) ServiceFactory
				.getService(IAppriseSV.class);

		try {

			appriseSV.savaApprisePrime(orgId, workflowId, content, senderInfo);
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("保存出错！", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void saveAppriseMember(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String workflowId = request.getParameter("workflowId");
		String appriseEmp = request.getParameter("appriseEmp");
		String assistEmp = request.getParameter("assistEmp");
		String publishEmp = request.getParameter("publishEmp");

		ISecOrganizeSV secSV = (ISecOrganizeSV) ServiceFactory
				.getService(ISecOrganizeSV.class);
		Long orgId = Long.valueOf(String.valueOf(
				SessionManager.getUser().getOrgId()).substring(0, 2));
		String senderInfo = secSV.getSecOrganizeById(orgId).getOrganizeName()
				+ "-" + SessionManager.getUser().getOrgName() + "-"
				+ SessionManager.getUser().getName();

		String content = request.getParameter("content").replace("^#", "%");
		int lastOperatorId = (int) SessionManager.getUser().getID();

		IAppriseSV appriseSV = (IAppriseSV) ServiceFactory
				.getService(IAppriseSV.class);

		try {
			if (null == publishEmp || publishEmp.equals("")) {

				appriseSV.saveAppriseMember(appriseEmp, assistEmp, workflowId,
						lastOperatorId, content, senderInfo);
				// 发送短信提醒
				String[] idAndType = appriseSV.getObjectTypeAndId(workflowId);
				String smsReceiver = assistEmp;
				if (appriseEmp != null && !appriseEmp.equals("")) {
					if (smsReceiver != null && !smsReceiver.equals("")) {

						smsReceiver += ";" + appriseEmp;
					} else {
						smsReceiver = appriseEmp;
					}
				}

				((ISendSmsSV) ServiceFactory.getService(ISendSmsSV.class))
						.sendSmsZH(idAndType[1], idAndType[0], String
								.valueOf(lastOperatorId), smsReceiver);
			} else {

				appriseSV.savePuplishMember(publishEmp, workflowId,
						lastOperatorId, content, senderInfo);
				// 发送短信提醒
				String[] idAndType = appriseSV.getObjectTypeAndId(workflowId);
				String smsReceiver = publishEmp;

				((ISendSmsSV) ServiceFactory.getService(ISendSmsSV.class))
						.sendSmsZH(idAndType[1], idAndType[0], String
								.valueOf(lastOperatorId), smsReceiver);
			}

			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("保存出错！", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void savePublishMember(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String workflowId = request.getParameter("workflowId");
		String publishEmp = request.getParameter("publishEmp");
		ISecOrganizeSV secSV = (ISecOrganizeSV) ServiceFactory
				.getService(ISecOrganizeSV.class);
		Long orgId = Long.valueOf(String.valueOf(
				SessionManager.getUser().getOrgId()).substring(0, 2));
		String senderInfo = secSV.getSecOrganizeById(orgId).getOrganizeName()
				+ "-" + SessionManager.getUser().getOrgName() + "-"
				+ SessionManager.getUser().getName();

		String content = request.getParameter("content").replace("^#", "%");
		int lastOperatorId = (int) SessionManager.getUser().getID();

		IAppriseSV appriseSV = (IAppriseSV) ServiceFactory
				.getService(IAppriseSV.class);

		try {
			appriseSV.savePuplishMember(publishEmp, workflowId, lastOperatorId,
					content, senderInfo);
			// 发送短信提醒
			String[] idAndType = appriseSV.getObjectTypeAndId(workflowId);
			String smsReceiver = publishEmp;

			((ISendSmsSV) ServiceFactory.getService(ISendSmsSV.class))
					.sendSmsZH(idAndType[1], idAndType[0], String
							.valueOf(lastOperatorId), smsReceiver);

			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("保存出错！", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void getAppriseOrgIds(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();
		String workflowId = request.getParameter("workflowId");
		String orgStr = "";

		IAppriseSV appriseSV = (IAppriseSV) ServiceFactory
				.getService(IAppriseSV.class);
		try {

			if (null != appriseSV.getAppriseOrg(workflowId)) {
				orgStr = appriseSV.getAppriseOrg(workflowId).getOrgStr();
			}

			cp.set("orgStr", orgStr);
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");

		} catch (Exception e) {
			// 操作失败
			log.error("操作出错！", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void changeAppriseSta(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String markedRecord = request.getParameter("markedStr");
		String operatorId = String.valueOf(SessionManager.getUser().getID());

		IAppriseSV appriseSV = (IAppriseSV) ServiceFactory
				.getService(IAppriseSV.class);
		try {
			if (markedRecord == null) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作失败");
			} else {
				appriseSV.changeAppriseSta(operatorId, markedRecord);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			}

		} catch (Exception e) {
			// 操作失败
			log.error("操作出错！", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void autoSendApprise(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String workflowId = request.getParameter("workflowId");
		// String publishEmp = request.getParameter("publishEmp");
		ISecOrganizeSV secSV = (ISecOrganizeSV) ServiceFactory
				.getService(ISecOrganizeSV.class);
		Long orgId = Long.valueOf(String.valueOf(
				SessionManager.getUser().getOrgId()).substring(0, 2));
		String senderInfo = secSV.getSecOrganizeById(orgId).getOrganizeName()
				+ "-" + SessionManager.getUser().getOrgName() + "-"
				+ SessionManager.getUser().getName();

		String content = request.getParameter("content").replace("^#", "%");
		int lastOperatorId = (int) SessionManager.getUser().getID();

		IAppriseSV appriseSV = (IAppriseSV) ServiceFactory
				.getService(IAppriseSV.class);

		try {
			String smsReceiver = appriseSV.autoSendApprise(workflowId, lastOperatorId, content,
					senderInfo);
			// 发送短信提醒
			String[] idAndType = appriseSV.getObjectTypeAndId(workflowId);

			((ISendSmsSV) ServiceFactory.getService(ISendSmsSV.class))
					.sendSmsZH(idAndType[1], idAndType[0], String
							.valueOf(lastOperatorId), smsReceiver);

			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("保存出错！", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "自动发布失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

}
