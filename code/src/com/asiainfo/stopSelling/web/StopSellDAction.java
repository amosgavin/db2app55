package com.asiainfo.stopSelling.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.stopSelling.bo.BOStopSellDBean;
import com.asiainfo.stopSelling.ivalues.IBOStopSellDValue;
import com.asiainfo.stopSelling.service.interfaces.IStopSellDSV;

public class StopSellDAction extends BaseAction {

	private transient static Log log = LogFactory.getLog(StopSellDAction.class);

	public void saveStopSellDInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		IBOStopSellDValue[] stopSellDValues = null;// 前台提交的数据

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOStopSellDBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOStopSellDBean[]) {
				stopSellDValues = (BOStopSellDBean[]) obj;
			}
		}
		IStopSellDSV stopSellDSV = (IStopSellDSV) ServiceFactory
				.getService(IStopSellDSV.class);

		try {
			if (null == stopSellDValues || 0 == stopSellDValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "没有修改需要保存！");
			} else {
				if(stopSellDValues[0].isDeleted() == true){
					stopSellDValues[0].undelete();
					stopSellDValues[0].setIsDelete("1");
					}
				stopSellDSV.save(stopSellDValues);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("保存信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}

	}
}
