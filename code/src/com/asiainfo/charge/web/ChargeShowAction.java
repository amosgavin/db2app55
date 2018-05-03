package com.asiainfo.charge.web;

import java.net.URLDecoder;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.charge.bo.BOGprsProductInfoBean;
import com.asiainfo.charge.bo.BOProductExtBean;
import com.asiainfo.charge.bo.BOProductExtEngine;
import com.asiainfo.charge.bo.BOProductInfoBean;
import com.asiainfo.charge.ivalues.IBOProductExtValue;
import com.asiainfo.charge.service.interfaces.IProdInfoQrySV;
import com.asiainfo.common.service.interfaces.IAbstractProductExtSV;

public class ChargeShowAction extends BaseAction {

	/**
	 * 获得服务
	 * 
	 * @return
	 * @throws Exception
	 */
	public IProdInfoQrySV getService() throws Exception {
		return (IProdInfoQrySV) ServiceFactory.getService(IProdInfoQrySV.class);
	}

	/**
	 * 新增属性
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void saveAttr(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		IProdInfoQrySV sv = getService();
		String extName = request.getParameter("extName");
		String extType = HttpUtil.getAsString(request, "extType");
		String retVal = "";
		String retMsg = "";
		try {
			long staffId = SessionManager.getUser().getID();
			sv.saveAttr(extName, extType, String.valueOf(staffId));
			retVal = "Y";
			retMsg = "保存成功";

		} catch (Exception e) {
			cp.set("retVal", "N");
			cp.set("retMsg", "操作失败" + ":" + e.getMessage());
		} finally {
			cp.set("retVal", retVal);
			cp.set("retMsg", retMsg);
			HttpUtil.showInfo(response, cp);
		}

	}

	/**
	 * 删除属性
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void delAttr(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		String codes = HttpUtil.getAsString(request, "codesArray");
		String[] codesArray = codes.split(",");
		String extType = HttpUtil.getAsString(request, "extType");
		String retVal = "Y";
		String retMsg = "删除成功";
		IAbstractProductExtSV sv = (IAbstractProductExtSV)ServiceFactory.getService(IAbstractProductExtSV.class);
		String staffId = String.valueOf(SessionManager.getUser().getID());
		try {
			sv.delAttr(codesArray, extType, staffId);
		} catch (Exception e) {
			cp.set("retVal", "N");
			cp.set("retMsg", "操作失败" + ":" + e.getMessage());
		} finally {
			cp.set("retVal", retVal);
			cp.set("retMsg", retMsg);
			HttpUtil.showInfo(response, cp);
		}
	}

	/**
	 * 保存修改后的资费数据
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void saveData(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		String privId = HttpUtil.getAsString(request, "privId");
		String attrId = HttpUtil.getAsString(request, "attrId");
		if (null == attrId || "".equals(attrId)) {
			attrId = "";
		}
		String extType = HttpUtil.getAsString(request, "extType");
		String retVal = "";
		String retMsg = "";
		DataContainerList[] dcLists;
		if (!"GPRS".equals(extType)) {
			dcLists = (DataContainerList[]) HttpUtil.getDataContainerLists(
					request.getInputStream(),
					new Class[] { BOProductInfoBean.class });
		} else {
			dcLists = (DataContainerList[]) HttpUtil.getDataContainerLists(
					request.getInputStream(),
					new Class[] { BOGprsProductInfoBean.class });
		}
		DataContainerInterface[] dcs = dcLists[0]
				.getColDataContainerInterface(0);
		try {
			IProdInfoQrySV sv = getService();
			String staffId = String.valueOf(SessionManager.getUser().getID());
			sv.changeSts(privId, attrId, "0", extType, staffId);
			IBOProductExtValue[] saveValues = new BOProductExtBean[dcs.length];
			String[] properties = new BOProductExtBean().getPropertyNames();
			for (int i = 0; i < dcs.length; i++) {
				IBOProductExtValue value = new BOProductExtBean();
				value.setStaffId(staffId);
				value.setState("1");
				value.setCreateDate(new Timestamp(System.currentTimeMillis()));
				value.setEAttrId(attrId);
				value.setEPrivid(privId);
				value.setExtType(extType);
				for (int j = 0; j < properties.length; j++) {
					String propertyName = properties[j];

					if (propertyName.substring(0, 3).equals("EXT")) {
						if ("1".equals(dcs[i].get(propertyName))) {
							value.set(propertyName, dcs[i].get(propertyName));
						}
					}
				}
				saveValues[i] = value;
			}
			sv.saveProductExtValue(saveValues);
			retVal = "Y";
			retMsg = "保存成功";
		} catch (Exception e) {
			cp.set("retVal", "N");
			cp.set("retMsg", "操作失败" + ":" + e.getMessage());
		} finally {
			cp.set("retVal", retVal);
			cp.set("retMsg", retMsg);
			HttpUtil.showInfo(response, cp);
		}
	}

}
