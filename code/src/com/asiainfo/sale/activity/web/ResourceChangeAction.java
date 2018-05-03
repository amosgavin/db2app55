package com.asiainfo.sale.activity.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.sale.access.web.BusiChangeAction;
import com.asiainfo.sale.activity.bo.BOResourceChangeBean;
import com.asiainfo.sale.activity.ivalues.IBOResourceChangeValue;
import com.asiainfo.sale.activity.service.interfaces.IResourceChangeSV;
import com.asiainfo.sale.common.dao.interfaces.IOperatorInfoDAO;

public class ResourceChangeAction extends BaseAction{
	private transient static Log log = LogFactory
	.getLog(ResourceChangeAction.class);

public void saveResourceChangeMainInfo(HttpServletRequest request,
	HttpServletResponse response) throws Exception {
CustomProperty cp = CustomProperty.getInstance();
IBOResourceChangeValue[] ResourceChangeValues = null;// ǰ̨�ύ������

// ǰ̨���ݵ�XML���ݣ���̨���շ���
DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
		.getInputStream(), new Class[] { BOResourceChangeBean.class });

if (dcLists.length == 0) {
	HttpUtil.showInfo(response, "��������Ϊ�գ�");
	return;
}
for (int i = 0; i < dcLists.length; i++) {
	Object[] obj = dcLists[i].getColDataContainerInterface(0);
	if (obj instanceof BOResourceChangeBean[]) {
		ResourceChangeValues = (BOResourceChangeBean[]) obj;
	}
}
IResourceChangeSV resourceChangeSV = (IResourceChangeSV) ServiceFactory
		.getService(IResourceChangeSV.class);
IOperatorInfoDAO opSv = (IOperatorInfoDAO) ServiceFactory
		.getService(IOperatorInfoDAO.class);

try {
	if (null == ResourceChangeValues || 0 == ResourceChangeValues.length) {
		cp.set("FLAG", "N");
		cp.set("MESSAGE", "û���޸���Ҫ���棡");
	} else if (1 == ResourceChangeValues.length) {
		    IBOResourceChangeValue bean = ResourceChangeValues[0];
		    if (bean != null) {
				if(bean.isDeleted()){
					bean.setIsDelete("1");
				}else{
					bean.setTel(opSv.getNameById(
							String.valueOf(SessionManager.getUser().getID()))
							.getBillId());
				}
			int ResourceId=resourceChangeSV.saveResourceChange(bean);
			cp.set("FLAG", "Y");
			cp.set("ResourceId", String.valueOf(ResourceId));
			cp.set("MESSAGE", "�����ɹ���");
		} else {
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ�ܣ�");
		}
		}
} catch (Exception e) {
	// ����ʧ��
	log.error("��������", e);
	cp.set("FLAG", "N");
	cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
} finally {
	HttpUtil.showInfo(response, cp);
}
}
}

