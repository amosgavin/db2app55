package com.asiainfo.sale.activity.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.sale.activity.bo.BOContractBean;
import com.asiainfo.sale.activity.ivalues.IBOContractValue;
import com.asiainfo.sale.activity.service.interfaces.IContractSV;

public class SaleContractAction extends BaseAction{
	private transient static Log log = LogFactory
	.getLog(SaleContractAction.class);

	public void saveContract(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOContractBean.class });


		IBOContractValue[] ContractValues = null;// ǰ̨�ύ������

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOContractBean[]) {
				ContractValues = (BOContractBean[]) obj;
			}
		}

		IContractSV ContractSV = (IContractSV) ServiceFactory
				.getService(IContractSV.class);

		try {
			if (null == ContractValues || 0 == ContractValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "��������Ϊ�գ�");
			} else {
				String saleDetailId = ContractSV
						.saveContract(ContractValues);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("�������", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
