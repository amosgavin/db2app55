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

	// ��ȡ����
	public void getMstrToken(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String orgId = String.valueOf(SessionManager.getUser().getOrgId())
				.substring(0, 2);
		String orgName = "";
		switch (Integer.parseInt(orgId)) {
		case 10:
			orgName = "ȫʡ";
			break;
		case 11:
			orgName = "�人";
			break;
		case 12:
			orgName = "��ʯ";
			break;
		case 13:
			orgName = "����";
			break;
		case 14:
			orgName = "�˲�";
			break;
		case 15:
			orgName = "��ʩ";
			break;
		case 16:
			orgName = "ʮ��";
			break;
		case 17:
			orgName = "����";
			break;
		case 18:
			orgName = "����";
			break;
		case 19:
			orgName = "����";
			break;
		case 20:
			orgName = "����";
			break;
		case 23:
			orgName = "����";
			break;
		case 24:
			orgName = "����";
			break;
		case 25:
			orgName = "�Ƹ�";
			break;
		case 26:
			orgName = "Т��";
			break;
		default:
			orgName = "δ֪";
		}
		String token = Encryption.getRandomMsgId();
		//System.out.println(token);
		try {

			((ISzReportSV) ServiceFactory.getService(ISzReportSV.class))
					.getToken(orgName, token);
			cp.set("TOKEN", token);
			cp.set("FLAG", "Y");
		} catch (Exception e) {
			// ����ʧ��
			log.error("��ȡ���Ƴ���", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
