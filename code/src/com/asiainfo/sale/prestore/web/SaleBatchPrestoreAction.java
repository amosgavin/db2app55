package com.asiainfo.sale.prestore.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.privilege.UserInfoInterface;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;

import com.asiainfo.sale.prestore.bo.BOSaleBatchPrestoreBean;
import com.asiainfo.sale.prestore.ivalues.IBOSaleBatchPrestoreValue;
import com.asiainfo.sale.prestore.service.interfaces.ISaleBatchPrestoreSV;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponValue;
import com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV;
import com.asiainfo.workflow.util.TaskUtil;


public class SaleBatchPrestoreAction extends BaseAction {
	private transient static Log log = LogFactory.getLog(SaleBatchPrestoreAction.class);

	
	public void saveSaleBatchPrestore(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		String retVal = "Y";
		String retMsg = "�����ɹ�";
		String retId = "0";		
		String areaCode = HttpUtil.getAsString(request, "citycode");

		try {
			DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request.getInputStream(), new Class[] { BOSaleBatchPrestoreBean.class });
			if (null == dcLists || dcLists.length < 1){
				retVal = "N";
				retMsg = "��������Ϊ�գ�";
				return;
			}
			IBOSaleBatchPrestoreValue objValue = new BOSaleBatchPrestoreBean();
			
			objValue = (BOSaleBatchPrestoreBean)dcLists[0].getColDataContainerInterface(0)[0];
			if(null == objValue){
				retVal = "N";
				retMsg = "δ�ܻ�ȡ���κ��ύ������";
				return;
			}
			ISaleBatchPrestoreSV objSV = (ISaleBatchPrestoreSV) ServiceFactory.getService(ISaleBatchPrestoreSV.class);		
			objValue.setAreaCode(areaCode);
			retId = objSV.saveSaleBatchPrestore(objValue);
		} catch (Exception e) {
			String reason = String.valueOf((String)e.getMessage());
			retVal = "N";
			retMsg="��������Ԥ����浥����"+reason;
			log.error(retMsg, e);
		} finally {
			cp.set("retId", retId);
			cp.set("retVal", retVal);
			cp.set("retMsg", retMsg);
			HttpUtil.showInfo(response, cp);
			
		}
	}
	
	public void delSaleBatchPrestore(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		String applyId = request.getParameter("applyId");


		ISaleBatchPrestoreSV objSV = (ISaleBatchPrestoreSV) ServiceFactory.getService(ISaleBatchPrestoreSV.class);		

		try {
			objSV.delSaleBatchPrestoreById(applyId);
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "ɾ���ɹ�");
		} catch (Exception e) {
			// ����ʧ��
			log.error("ɾ������Ԥ����Ϣ����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	
	public void deletePrestoreInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		CustomProperty cp = CustomProperty.getInstance();
		String retVal = "Y";
		String retMsg = "ɾ���ɹ�";

		try {
			DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request.getInputStream(), new Class[] { BOSaleBatchPrestoreBean.class });
			if (dcLists == null || dcLists.length<1){
				retVal = "N";
				retMsg = "δ�ܻ�ȡ���κ�Ҫɾ��������";
				return;
			}

			IBOSaleBatchPrestoreValue[] values = null;
			for (int i = 0; i < dcLists.length; i++) {
				Object[] obj = dcLists[i].getColDataContainerInterface(0);
				if (obj instanceof BOSaleBatchPrestoreBean[]) {
					values = (BOSaleBatchPrestoreBean[]) obj;
				}
			}
			ISaleBatchPrestoreSV objSV = (ISaleBatchPrestoreSV) ServiceFactory.getService(ISaleBatchPrestoreSV.class);		

			objSV.deletePrestoreInfo(values);
		} catch (Exception e) {
			log.error("ɾ������Ԥ����Ϣ����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			cp.set("retVal", retVal);
			cp.set("retMsg", retMsg);
			HttpUtil.showInfo(response, cp);
		}	
	}	
	
	
	
}
