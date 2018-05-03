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
import com.asiainfo.sale.activity.bo.BOResourceChangeDetailBean;
import com.asiainfo.sale.activity.ivalues.IBOResourceChangeDetailValue;
import com.asiainfo.sale.activity.service.interfaces.IResourceChangeDetailSV;
import com.asiainfo.sale.common.dao.interfaces.IOperatorInfoDAO;

public class ResourceChangeDetailAction extends BaseAction{
	private transient static Log log = LogFactory
	.getLog(ResourceChangeDetailAction.class);
	
	public void saveResourceChangeDetailInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		CustomProperty cp = CustomProperty.getInstance();
		IBOResourceChangeDetailValue[] ResourceChangeDetailValues = null;// ǰ̨�ύ������

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOResourceChangeDetailBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "��������Ϊ�գ�");
			return;
		}
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOResourceChangeDetailBean[]) {
				ResourceChangeDetailValues = (BOResourceChangeDetailBean[]) obj;
			}
		}
		IResourceChangeDetailSV resourceChangeDetailSV = (IResourceChangeDetailSV) ServiceFactory.getService(IResourceChangeDetailSV.class);
        IOperatorInfoDAO opSv = (IOperatorInfoDAO) ServiceFactory.getService(IOperatorInfoDAO.class);
		
        try {
        	if (null == ResourceChangeDetailValues || 0 == ResourceChangeDetailValues.length) {
        		cp.set("FLAG", "N");
        		cp.set("MESSAGE", "û���޸���Ҫ���棡");
        	} else if (1 == ResourceChangeDetailValues.length) {
        		IBOResourceChangeDetailValue bean = ResourceChangeDetailValues[0];

        			int ResourceDid=resourceChangeDetailSV.saveResourceChangeDetail(bean);
        			cp.set("FLAG", "Y");
        			cp.set("ResourceDid", String.valueOf(ResourceDid));
        			cp.set("MESSAGE", "�����ɹ���");
        		} else {
        			cp.set("FLAG", "N");
        			cp.set("MESSAGE", "����ʧ�ܣ�");
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