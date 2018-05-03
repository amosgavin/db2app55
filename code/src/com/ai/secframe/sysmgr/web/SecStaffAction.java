package com.ai.secframe.sysmgr.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.util.locale.AppframeLocaleFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.ai.secframe.orgmodel.ivalues.IBOSecStaffValue;
import com.ai.secframe.orgmodel.service.interfaces.ISecOperatorSV;

public class SecStaffAction extends BaseAction {

	private transient static Log log = LogFactory.getLog(SecStaffAction.class);

	public void getOrgIdByOpId(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String operatorId = HttpUtil.getParameter(request, "operatorId");

		CustomProperty cp = CustomProperty.getInstance();

		String orgId = "";
		try {
			ISecOperatorSV opSv = (ISecOperatorSV) ServiceFactory
					.getService(ISecOperatorSV.class);
			IBOSecStaffValue sf = opSv.getStaffByOperId(Long
					.parseLong(operatorId));
			if (sf != null) {
				orgId = sf.getOrganizeId();
			}
			cp.set("orgId", orgId);
			cp.set("FLAG", "Y");
		} catch (Exception e) {
			cp.set("FLAG", "N");
			cp.set("retMsg", e.getMessage());
			log.error(AppframeLocaleFactory
					.getResource("i18n.secframe_resource",
							"sec.authoraction.saveAuthor.err"), e);
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
