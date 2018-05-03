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
		String retMsg = "�����ɹ�!";

		// String areaCode = HttpUtil.getAsString(request, "cityCode");
		String chargeId = HttpUtil.getAsString(request, "chargeId");
		boolean isTest = HttpUtil.getAsBoolean(request, "isTest");

		// add by jiangxl begin
		//String extXml = HttpUtil.getAsString(request, "extXml");
		StringBuffer  extXml =  new StringBuffer();
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(),
				new Class[] { BOChargeApplyProdAttrBean.class });

		IBOChargeApplyProdAttrValue[] prodAttrValues = null;// ǰ̨�ύ������

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
		IBOChargeInfoExtValue[] infoExtValues = null;// ǰ̨�ύ������
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
			log.error("������Ϣʧ��!");
			retVal = "N";
			retMsg = "������Ϣʧ��: " + e.getMessage();

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
		String retMsg = "ɾ���ɹ�";

		try {
			DataContainerList[] dcLists = HttpUtil.getDataContainerLists(
					request.getInputStream(),
					new Class[] { BOChargeApplyProdAttrBean.class });
			if (dcLists == null || dcLists.length < 1) {
				retVal = "N";
				retMsg = "δ�ܻ�ȡ���κ�Ҫɾ��������";
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
			
			//add by jiangxl ɾ���ʷ���չ����
			
			IChargeInfoExtSV extSv = (IChargeInfoExtSV)ServiceFactory.getService(IChargeInfoExtSV.class);
			List extList = new ArrayList();
			
			for (int i = 0; i < values.length; i ++){
				String applyId = values[i].getApplyId();
				IBOChargeInfoExtValue[] extValues = extSv.getChargeInfoExt(applyId, null);
				if(extValues.length > 0){
					extValues[0].delete();//��ΪʧЧ
					extList.add(extValues[0]);
				}
			}
			if(extList.size()>0){
				extSv.saveChargeInfoExt((IBOChargeInfoExtValue[] )extList.toArray(new BOChargeInfoExtBean[extList.size()]));
			}
			
			
		} catch (Exception e) {
			log.error("ɾ����Ϣ����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
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
		String retMsg = "�����ɹ�";
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
				retMsg = "��������Ϊ�գ�";
				return;
			}
			IBOChargeApplyProdAttrExtValue objProdAttrExtValue = new BOChargeApplyProdAttrExtBean();

			objProdAttrExtValue = (BOChargeApplyProdAttrExtBean) dcLists[0]
					.getColDataContainerInterface(0)[0];
			if (null == objProdAttrExtValue) {
				retVal = "N";
				retMsg = "δ�ܻ�ȡ���κ��ύ������";
				return;
			}
			IChargeProdAttrSV objProdAttrExtSV = (IChargeProdAttrSV) ServiceFactory
					.getService(IChargeProdAttrSV.class);

			// ������ʷѲ��Ա���
			if (isTest) {
				objProdAttrExtValue.setTestPrincipal(staffId);
				// objProdAttrExtValue.setTestTime(ServiceManager.getOpDateTime());
			}
			retId = objProdAttrExtSV.saveProdAttrExt(objProdAttrExtValue);
		} catch (Exception e) {
			String reason = String.valueOf((String) e.getMessage());
			retVal = "N";
			retMsg = "�������" + reason;
			log.error(retMsg, e);
		} finally {
			cp.set("retId", retId);
			cp.set("retVal", retVal);
			cp.set("retMsg", retMsg);
			HttpUtil.showInfo(response, cp);

		}
	}

	

}