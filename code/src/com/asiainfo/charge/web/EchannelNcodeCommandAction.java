package com.asiainfo.charge.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.charge.bo.BOEchannelNcodeCommandBean;
import com.asiainfo.charge.ivalues.IBOEchannelNcodeCommandValue;
import com.asiainfo.charge.service.interfaces.IEchannelNcodeCommandSV;

public class EchannelNcodeCommandAction extends BaseAction {

	private transient static Log log = LogFactory
			.getLog(EchannelNcodeCommandAction.class);

	public void save(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOEchannelNcodeCommandBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}

		IBOEchannelNcodeCommandValue[] EchannelNcodeCommandList = null;// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOEchannelNcodeCommandBean[]) {
				EchannelNcodeCommandList = (BOEchannelNcodeCommandBean[]) obj;
			}
		}

		IEchannelNcodeCommandSV EchannelNcodeCommandListListv = (IEchannelNcodeCommandSV) ServiceFactory
				.getService(IEchannelNcodeCommandSV.class);

		try {
			if (null == EchannelNcodeCommandList || 0 == EchannelNcodeCommandList.length) {
				cp.set("FLAG", "N");
				//cp.set("MESSAGE", "操作对象为空！");
			} else {
				EchannelNcodeCommandListListv.save(EchannelNcodeCommandList);
				cp.set("FLAG", "Y");
				//cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败 
			log.error("短厅指令与NCODE列表", e);
			cp.set("FLAG", "N");
			//cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
