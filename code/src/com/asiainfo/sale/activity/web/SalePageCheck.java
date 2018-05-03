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

	// 营销案检查是否填写了财务和业务稽核方案
	public void checkExplantStatistic(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String mainId = request.getParameter("mainId");
		ISaleMainSV saleMainSV = (ISaleMainSV) ServiceFactory
				.getService(ISaleMainSV.class);

		try {
			if (null == mainId || "".equals(mainId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
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
				cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("判断是否填写了财务和业务稽核方案出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "判断是否填写了财务和业务稽核方案" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

}
