package com.asiainfo.bi.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.bi.service.interfaces.IStatisticsSV;
import com.asiainfo.sale.activity.web.SaleDetailAction;

public class StatisticsAction extends BaseAction{

	private transient static Log log = LogFactory.getLog(SaleDetailAction.class);

	public void getStatistics(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		
		String objectType = request.getParameter("objectType");
		IStatisticsSV statisticsSV = (IStatisticsSV) ServiceFactory.getService(IStatisticsSV.class);

		try {
			statisticsSV.getStatistics(objectType);
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("查询统计信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
