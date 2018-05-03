package com.asiainfo.mstrcheck.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.mstrcheck.service.interfaces.ISzReportSV;
import com.asiainfo.mstrcheck.util.Encryption;

public class MstrToken extends BaseAction {

	private transient static Log log = LogFactory.getLog(MstrToken.class);

	// 获取令牌
	public void getMstrToken(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String orgId = String.valueOf(SessionManager.getUser().getOrgId())
				.substring(0, 2);
		String orgName = "";
		switch (Integer.parseInt(orgId)) {
		case 10:
			orgName = "全省";
			break;
		case 11:
			orgName = "武汉";
			break;
		case 12:
			orgName = "黄石";
			break;
		case 13:
			orgName = "鄂州";
			break;
		case 14:
			orgName = "宜昌";
			break;
		case 15:
			orgName = "恩施";
			break;
		case 16:
			orgName = "十堰";
			break;
		case 17:
			orgName = "襄阳";
			break;
		case 18:
			orgName = "江汉";
			break;
		case 19:
			orgName = "咸宁";
			break;
		case 20:
			orgName = "荆州";
			break;
		case 23:
			orgName = "荆门";
			break;
		case 24:
			orgName = "随州";
			break;
		case 25:
			orgName = "黄冈";
			break;
		case 26:
			orgName = "孝感";
			break;
		default:
			orgName = "未知";
		}
		String token = Encryption.getRandomMsgId();
		//System.out.println(token);
		try {

			((ISzReportSV) ServiceFactory.getService(ISzReportSV.class))
					.getToken(orgName, token);
			cp.set("TOKEN", token);
			cp.set("FLAG", "Y");
		} catch (Exception e) {
			// 操作失败
			log.error("获取令牌出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
