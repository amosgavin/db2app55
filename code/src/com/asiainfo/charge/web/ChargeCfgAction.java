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
import com.asiainfo.charge.bo.BOBusiSurpConfBean;
import com.asiainfo.charge.bo.BOChargeCfgBean;
import com.asiainfo.charge.bo.BOChargeDevelopInfoBean;
import com.asiainfo.charge.ivalues.IBOBusiSurpConfValue;
import com.asiainfo.charge.ivalues.IBOChargeCfgValue;
import com.asiainfo.charge.ivalues.IBOChargeDevelopInfoValue;
import com.asiainfo.charge.service.interfaces.IChargeCfgSV;

public class ChargeCfgAction extends BaseAction {

	private transient static Log log = LogFactory.getLog(ChargeCfgAction.class);

	public void save(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		CustomProperty cp = CustomProperty.getInstance();
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOChargeCfgBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}
		IChargeCfgSV sv = (IChargeCfgSV) ServiceFactory
				.getService(IChargeCfgSV.class);
		IBOChargeCfgValue[] cfgs = null;
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOChargeCfgBean[]) {
				cfgs = (BOChargeCfgBean[]) obj;
			}
		}
		try {
			if (null != cfgs && cfgs.length > 0) {
				sv.save(cfgs[0]);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			} else {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
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

	public void checkCfgIsNotNull(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		String chargeId = request.getParameter("chargeId");
		IChargeCfgSV sv = (IChargeCfgSV) ServiceFactory
				.getService(IChargeCfgSV.class);
		IBOChargeCfgValue cfg = null;

		try {
			cfg = sv.getCfgInfoByChargeId(chargeId, "'C'");
			if (null != cfg) {
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			} else {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("检查出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void saveChargeDevInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(),
				new Class[] { BOChargeDevelopInfoBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}
		IChargeCfgSV sv = (IChargeCfgSV) ServiceFactory
				.getService(IChargeCfgSV.class);
		IBOChargeDevelopInfoValue[] devInfoes = null;
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOChargeDevelopInfoBean[]) {
				devInfoes = (BOChargeDevelopInfoBean[]) obj;
			}
		}
		try {
			if (null != devInfoes && devInfoes.length > 0) {
				sv.saveChargeDevInfo(devInfoes[0]);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			} else {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
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

	public void saveChargeConf(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOBusiSurpConfBean.class });

		if (dcLists.length == 0) {
			//HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}
		IChargeCfgSV sv = (IChargeCfgSV) ServiceFactory
				.getService(IChargeCfgSV.class);
		IBOBusiSurpConfValue[] cfgs = null;
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOBusiSurpConfBean[]) {
				cfgs = (BOBusiSurpConfBean[]) obj;
			}
		}
		try {
			if (null != cfgs && cfgs.length > 0) {
				sv.save(cfgs);
				cp.set("FLAG", "Y");
				//cp.set("MESSAGE", "操作成功！");
			} else {
				cp.set("FLAG", "N");
				//cp.set("MESSAGE", "操作对象为空！");
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
