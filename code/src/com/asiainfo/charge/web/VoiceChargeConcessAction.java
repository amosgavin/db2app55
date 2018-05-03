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
import com.asiainfo.charge.bo.BOChargeConcessDetailInfoBean;
import com.asiainfo.charge.bo.BOChargeConcessInfoBean;
import com.asiainfo.charge.ivalues.IBOChargeConcessInfoValue;
import com.asiainfo.charge.ivalues.IBOChargeConcessDetailInfoValue;
import com.asiainfo.charge.service.interfaces.IVoiceChargeConcessSV;

public class VoiceChargeConcessAction extends BaseAction {
	private transient static Log log = LogFactory
			.getLog(ChargeMainAction.class);

	public void saveChargeConcessMain(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOChargeConcessInfoBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}

		IBOChargeConcessInfoValue[] chargeConcessInfo = null;// 前台提交的数据
        //dcLists.length的长度都是1
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOChargeConcessInfoBean[]) {
				chargeConcessInfo = (BOChargeConcessInfoBean[]) obj;
			}
		}

		IVoiceChargeConcessSV chargeConcessSV = (IVoiceChargeConcessSV) ServiceFactory.getService(IVoiceChargeConcessSV.class);

		try {
			if (null == chargeConcessInfo || 0 == chargeConcessInfo.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else if (1 == chargeConcessInfo.length) {
				cp.set("CONCESSID", chargeConcessSV.saveChargeInfo(chargeConcessInfo[0]));
				cp.set("FLAG", "Y");
				//cp.set("MESSAGE", "操作成功！");
			} else {
				chargeConcessSV.saveChargeInfo(chargeConcessInfo);
				cp.set("FLAG", "Y");
				//cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("保存语音优惠包信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void saveChargeConcessDetail(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOChargeConcessDetailInfoBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}

		IBOChargeConcessDetailInfoValue[] chargeConcessdetail = null;// 前台提交的数据
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOChargeConcessDetailInfoBean[]) {
				chargeConcessdetail = (BOChargeConcessDetailInfoBean[]) obj;
			}
		}

		IVoiceChargeConcessSV chargeConcessSV = (IVoiceChargeConcessSV) ServiceFactory.getService(IVoiceChargeConcessSV.class);

		try {
			if (null == chargeConcessdetail || 0 == chargeConcessdetail.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {
				chargeConcessSV.saveChargeDetailInfo(chargeConcessdetail);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("保存语音优惠包明细信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
	
}
