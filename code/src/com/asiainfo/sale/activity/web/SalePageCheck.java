package com.asiainfo.sale.activity.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.sale.activity.ivalues.IBOSaleMainValue;
import com.asiainfo.sale.activity.service.interfaces.ISaleMainSV;

public class SalePageCheck extends BaseAction {
	
	private transient static Log log = LogFactory.getLog(SalePageCheck.class);

	// Ӫ��������Ƿ���д�˲����ҵ����˷���
	public void checkExplantStatistic(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String mainId = request.getParameter("mainId");
		ISaleMainSV saleMainSV = (ISaleMainSV) ServiceFactory
				.getService(ISaleMainSV.class);

		try {
			if (null == mainId || "".equals(mainId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "��������Ϊ�գ�");
			} else {

				IBOSaleMainValue saleMain = saleMainSV.getSaleMainById(mainId);
				String YoN = "no";
				if(!saleMain.getBusinesscheckplan().trim().equals("")){
					YoN = "yes";
				}
				// System.out.println(YoN);
				if (YoN.equals("yes")) {
						cp.set("FLAG", "Y");
					} else {
						cp.set("FLAG", "N");
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

}
