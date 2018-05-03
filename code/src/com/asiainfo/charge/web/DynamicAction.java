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
import com.asiainfo.charge.bo.BODynamicSumBean;
import com.asiainfo.charge.ivalues.IBODynamicSumValue;
import com.asiainfo.charge.service.interfaces.IDynamicSumSV;

public class DynamicAction extends BaseAction {
			private transient static Log log = LogFactory
			.getLog(DynamicAction.class);
		
		public void saveDynamicSum(HttpServletRequest request,
					HttpServletResponse response) throws Exception {
				CustomProperty cp = CustomProperty.getInstance();
				
				// ǰ̨���ݵ�XML���ݣ���̨���շ���
				DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
						.getInputStream(), new Class[] { BODynamicSumBean.class });
				
				if (dcLists.length == 0) {
					HttpUtil.showInfo(response, "��������Ϊ�գ�");
					return;
				}
				
				IBODynamicSumValue[] dynamicSumValues = null;// ǰ̨�ύ������
				
				for (int i = 0; i < dcLists.length; i++) {
					Object[] obj = dcLists[i].getColDataContainerInterface(0);
					if (obj instanceof BODynamicSumBean[]) {
						dynamicSumValues = (BODynamicSumBean[]) obj;
					}
				}
				
				IDynamicSumSV dynamicSV = (IDynamicSumSV) ServiceFactory
						.getService(IDynamicSumSV.class);
				
				try {
					if (null == dynamicSumValues || 0 == dynamicSumValues.length) {
						cp.set("FLAG", "N");
						cp.set("MESSAGE", "��������Ϊ�գ�");
					} else {
						String did=dynamicSV.saveDynamicSum(dynamicSumValues[0]);
						cp.set("MID", did);
						cp.set("FLAG", "Y");
						cp.set("MESSAGE", "�����ɹ���");
					}
				} catch (Exception e) {
					// ����ʧ��
					log.error("����Ӫ��������Ϣ����", e);
					cp.set("FLAG", "N");
					cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
				} finally {
					HttpUtil.showInfo(response, cp);
				}
				}
}
