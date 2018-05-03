package com.asiainfo.charge.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.charge.bo.BOChargeApplyProdAttrBean;
import com.asiainfo.charge.bo.BOChargeApplyProdAttrExtBean;
import com.asiainfo.charge.bo.BOChargeInfoExtBean;
import com.asiainfo.charge.ivalues.IBOChargeApplyProdAttrExtValue;
import com.asiainfo.charge.ivalues.IBOChargeApplyProdAttrValue;
import com.asiainfo.charge.ivalues.IBOChargeInfoExtValue;
import com.asiainfo.charge.service.interfaces.IChargeInfoExtSV;
import com.asiainfo.charge.service.interfaces.IChargeProdAttrSV;

public class ChargeProdAttrAction extends BaseAction {

	private final static transient Log log = LogFactory
			.getLog(ChargeProdAttrAction.class);

	public void saveProdAttr(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();
		String retVal = "Y";
		String retMsg = "操作成功!";

		// String areaCode = HttpUtil.getAsString(request, "cityCode");
		String chargeId = HttpUtil.getAsString(request, "chargeId");
		boolean isTest = HttpUtil.getAsBoolean(request, "isTest");

		// add by jiangxl begin
		//String extXml = HttpUtil.getAsString(request, "extXml");
		StringBuffer  extXml =  new StringBuffer();
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(),
				new Class[] { BOChargeApplyProdAttrBean.class });

		IBOChargeApplyProdAttrValue[] prodAttrValues = null;// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOChargeApplyProdAttrBean[]) {
				prodAttrValues = (BOChargeApplyProdAttrBean[]) obj;
			}
		}
		extXml.append("<RootInfo>");
		for(int j = 0; j < prodAttrValues.length; j++){
			extXml.append(prodAttrValues[j].getExt1());
			prodAttrValues[j].setExt1("");
		}
		extXml.append("</RootInfo>");

		DataContainerList[] dcLists1 = HttpUtil.getDataContainerLists(extXml.toString(),
				new Class[] { BOChargeInfoExtBean.class });
		IBOChargeInfoExtValue[] infoExtValues = null;// 前台提交的数据
		List extList = new ArrayList();

		for (int i = 0; i < dcLists1.length; i++) {
			Object[] obj = dcLists1[i].getColDataContainerInterface(0);
			if (obj instanceof BOChargeInfoExtBean[]) {
				for(int m = 0; m < obj.length; m ++){
					extList.add(obj[m]);
				}
			}
		}
		if(extList.size()> 0){
			infoExtValues =(IBOChargeInfoExtValue[]) extList.toArray(new BOChargeInfoExtBean[extList.size()]);
		}
		

		IChargeProdAttrSV prodAttrSV = (IChargeProdAttrSV) ServiceFactory
				.getService(IChargeProdAttrSV.class);
		try {
			prodAttrSV.saveProdAttr(prodAttrValues,infoExtValues);
		} catch (Exception e) {
			log.error("保存信息失败!");
			retVal = "N";
			retMsg = "保存信息失败: " + e.getMessage();

		} finally {
			cp.set("retMsg", retMsg);
			cp.set("retVal", retVal);
			HttpUtil.showInfo(response, cp);
		}

	}

	public void delProdAttr(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();
		String retVal = "Y";
		String retMsg = "删除成功";

		try {
			DataContainerList[] dcLists = HttpUtil.getDataContainerLists(
					request.getInputStream(),
					new Class[] { BOChargeApplyProdAttrBean.class });
			if (dcLists == null || dcLists.length < 1) {
				retVal = "N";
				retMsg = "未能获取到任何要删除的数据";
				return;
			}

			IBOChargeApplyProdAttrValue[] values = null;
			for (int i = 0; i < dcLists.length; i++) {
				Object[] obj = dcLists[i].getColDataContainerInterface(0);
				if (obj instanceof BOChargeApplyProdAttrBean[]) {
					values = (BOChargeApplyProdAttrBean[]) obj;
				}
			}

			IChargeProdAttrSV prodAttrSV = (IChargeProdAttrSV) ServiceFactory
					.getService(IChargeProdAttrSV.class);

			prodAttrSV.delProdAttr(values);
			
			//add by jiangxl 删除资费扩展属性
			
			IChargeInfoExtSV extSv = (IChargeInfoExtSV)ServiceFactory.getService(IChargeInfoExtSV.class);
			List extList = new ArrayList();
			
			for (int i = 0; i < values.length; i ++){
				String applyId = values[i].getApplyId();
				IBOChargeInfoExtValue[] extValues = extSv.getChargeInfoExt(applyId, null);
				if(extValues.length > 0){
					extValues[0].delete();//置为失效
					extList.add(extValues[0]);
				}
			}
			if(extList.size()>0){
				extSv.saveChargeInfoExt((IBOChargeInfoExtValue[] )extList.toArray(new BOChargeInfoExtBean[extList.size()]));
			}
			
			
		} catch (Exception e) {
			log.error("删除信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			cp.set("retVal", retVal);
			cp.set("retMsg", retMsg);
			HttpUtil.showInfo(response, cp);
		}
	}

	public void saveProdAttrExt(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();
		String retVal = "Y";
		String retMsg = "操作成功";
		String retId = "0";

		String areaCode = HttpUtil.getAsString(request, "cityCode");
		boolean isTest = HttpUtil.getAsBoolean(request, "isTest");
		String staffId = Long.toString(ServiceManager.getUser().getID());

		try {
			DataContainerList[] dcLists = HttpUtil.getDataContainerLists(
					request.getInputStream(),
					new Class[] { BOChargeApplyProdAttrExtBean.class });
			if (null == dcLists || dcLists.length < 1) {
				retVal = "Y";
				retMsg = "操作对象为空！";
				return;
			}
			IBOChargeApplyProdAttrExtValue objProdAttrExtValue = new BOChargeApplyProdAttrExtBean();

			objProdAttrExtValue = (BOChargeApplyProdAttrExtBean) dcLists[0]
					.getColDataContainerInterface(0)[0];
			if (null == objProdAttrExtValue) {
				retVal = "N";
				retMsg = "未能获取到任何提交的数据";
				return;
			}
			IChargeProdAttrSV objProdAttrExtSV = (IChargeProdAttrSV) ServiceFactory
					.getService(IChargeProdAttrSV.class);

			// 如果是资费测试报告
			if (isTest) {
				objProdAttrExtValue.setTestPrincipal(staffId);
				// objProdAttrExtValue.setTestTime(ServiceManager.getOpDateTime());
			}
			retId = objProdAttrExtSV.saveProdAttrExt(objProdAttrExtValue);
		} catch (Exception e) {
			String reason = String.valueOf((String) e.getMessage());
			retVal = "N";
			retMsg = "保存出错" + reason;
			log.error(retMsg, e);
		} finally {
			cp.set("retId", retId);
			cp.set("retVal", retVal);
			cp.set("retMsg", retMsg);
			HttpUtil.showInfo(response, cp);

		}
	}

	

}