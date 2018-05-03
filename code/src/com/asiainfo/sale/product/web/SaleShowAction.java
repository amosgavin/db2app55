package com.asiainfo.sale.product.web;

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
import com.asiainfo.sale.product.bo.BOSaleDetailExtBean;
import com.asiainfo.sale.product.bo.BOSaleDetailExtEngine;
import com.asiainfo.sale.product.bo.BOSaleDetailExtQBean;
import com.asiainfo.sale.product.ivalues.IBOSaleDetailExtValue;
import com.asiainfo.sale.product.services.interfaces.ISaleDetailExtSV;

public class SaleShowAction extends BaseAction {

	public void delAttr(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		String codes = HttpUtil.getAsString(request, "codesArray");
		String[] codesArray = codes.split(",");
		String extType = HttpUtil.getAsString(request, "extType");
		String retVal = "Y";
		String retMsg = "删除成功";
		ISaleDetailExtSV sv = getSv();
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

	public void saveAttr(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		ISaleDetailExtSV sv = getSv();
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

	public void saveData(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		String e_id = HttpUtil.getAsString(request, "e_id");
		String detail_id = HttpUtil.getAsString(request, "detail_id");
		String retVal = "";
		String retMsg = "";
		DataContainerList[] dcLists;
		
		dcLists = (DataContainerList[]) HttpUtil.getDataContainerLists(
					request.getInputStream(),
					new Class[] { BOSaleDetailExtQBean.class });
		DataContainerInterface[] dcs = dcLists[0]
				.getColDataContainerInterface(0);
		try {
			ISaleDetailExtSV sv = getSv();
			String staffId = String.valueOf(SessionManager.getUser().getID());
			sv.changeSts(e_id, "0", staffId);
			IBOSaleDetailExtValue[] saveValues = new BOSaleDetailExtBean[dcs.length];
			String[] properties = new BOSaleDetailExtBean().getPropertyNames();
			for (int i = 0; i < dcs.length; i++) {
				IBOSaleDetailExtValue value = new BOSaleDetailExtBean();
				value.setStaffId(staffId);
				value.setStatus("1");
				value.setCreateDate(new Timestamp(System.currentTimeMillis()));
				value.setFDetailId(detail_id);
				value.setEId(sv.getNewId());
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
			sv.saveSaleDetailExtValue(saveValues);
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

	ISaleDetailExtSV getSv() throws Exception {
		return (ISaleDetailExtSV) ServiceFactory
				.getService(ISaleDetailExtSV.class);
	}

}
