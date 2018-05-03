package com.asiainfo.sale.access.service.impl;

import java.net.URLDecoder;

import com.asiainfo.sale.access.ivalues.IBOAccessChangeDetailValue;
import com.asiainfo.sale.access.ivalues.IBOAccessChangeValue;
import com.asiainfo.sale.access.service.interfaces.IAccessChangeSV;
import com.asiainfo.sale.access.dao.interfaces.IAccessChangeDAO;
import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.access.bo.BOAccessChangeBean;
import com.asiainfo.task.dao.interfaces.ICurTaskDAO;
import com.asiainfo.task.ivalues.IBOFinishTaskValue;

public class AccessChangeSVImpl implements IAccessChangeSV {
	// ���������޸���������Ϣ
	public int saveAccessChange(IBOAccessChangeValue accessChangeValue)
			throws Exception {
		return ((IAccessChangeDAO) ServiceFactory
				.getService(IAccessChangeDAO.class))
				.saveAccessChange(accessChangeValue);
	}

	// ���������޸�������ϸ��Ϣ
	public void saveAccessChangeDetail(
			IBOAccessChangeDetailValue accessChangeDetailValue, int accessId)
			throws Exception {
		((IAccessChangeDAO) ServiceFactory.getService(IAccessChangeDAO.class))
				.saveAccessChangeDetail(accessChangeDetailValue, accessId);
	}

	// ���������޸�������ϸ��Ϣ
	public void saveAccessChangeDetailBatch(
			IBOAccessChangeDetailValue[] accessChangeDetailValues)
			throws Exception {
		((IAccessChangeDAO) ServiceFactory.getService(IAccessChangeDAO.class))
				.saveAccessChangeDetailBatch(accessChangeDetailValues);
	}

	// ��ȡ�޸���������Ϣ
	public IBOAccessChangeValue getAccessChargeById(int accessid)
			throws Exception {
		return ((IAccessChangeDAO) ServiceFactory
				.getService(IAccessChangeDAO.class))
				.getAccessChargeById(accessid);
	}

	// ��ȡ�޸�������ϸ��Ϣ
	public IBOAccessChangeDetailValue[] getAccessChargeDetailById(int accessid,int startNum, int endNum)
			throws Exception {
		return ((IAccessChangeDAO) ServiceFactory
				.getService(IAccessChangeDAO.class))
				.getAccessChargeDetailById(accessid,startNum,endNum);

	}

	// ��ȡ�޸�������ϸ��¼��
	public int getAccessChargeDetailCount(int accessid)
			throws Exception {
		return ((IAccessChangeDAO) ServiceFactory
				.getService(IAccessChangeDAO.class)).getAccessChargeDetailCount(accessid);

	}
	
	// ��ѯ�����޸���Ϣ
	public IBOAccessChangeValue[] queryAccessChangeValue(String beginTime,
			String endTime, String applyname, String objectid, String principle,String town,int startNum, int endNum)
			throws Exception {
		IBOAccessChangeValue[] accessValues = null;
		if (applyname != null) {
			applyname = URLDecoder.decode(applyname, "utf-8");
		}
		accessValues = ((IAccessChangeDAO) ServiceFactory
				.getService(IAccessChangeDAO.class)).queryAccessChangeValue(
				beginTime, endTime, applyname, objectid, principle,town,startNum, endNum);

		return accessValues;
	}

	//��ѯ�����޸���Ϣ��¼��
	public int queryAccessChangeCount(String beginTime,String endTime,String applyname,String objectid, String principle,String town)throws Exception{
		return ((IAccessChangeDAO) ServiceFactory
				.getService(IAccessChangeDAO.class)).queryAccessChangeCount(
				beginTime, endTime, applyname, objectid, principle,town);		
	}
	
	// ɾ���޸�������Ϣ
	public void delAccessChangeValue(int accessid) throws Exception {
		((IAccessChangeDAO) ServiceFactory.getService(IAccessChangeDAO.class))
				.delAccessChangeValue(accessid);
	}

	// �޸Ĺ���״̬
	public void changeAccessState(String accessid, String state)
			throws Exception {
		IBOAccessChangeValue accessChangeValue = ((IAccessChangeDAO) ServiceFactory
				.getService(IAccessChangeDAO.class))
				.getAccessChargeById(Integer.valueOf(accessid));
		accessChangeValue.setState(state);
		((IAccessChangeDAO) ServiceFactory.getService(IAccessChangeDAO.class))
				.saveAccessChange(accessChangeValue);
	}

	// �޸Ĺ���״̬Ϊͨ��
	public void changeAccessStateOk(String accessid) throws Exception {
		IBOAccessChangeValue accessChangeValue = ((IAccessChangeDAO) ServiceFactory
				.getService(IAccessChangeDAO.class))
				.getAccessChargeById(Integer.valueOf(accessid));
		accessChangeValue.setState("3");
		((IAccessChangeDAO) ServiceFactory.getService(IAccessChangeDAO.class))
				.saveAccessChange(accessChangeValue);

	}

	// �޸Ĺ���״̬Ϊ���
	public void changeAccessStateFalse(String accessid) throws Exception {
		IBOAccessChangeValue accessChangeValue = ((IAccessChangeDAO) ServiceFactory
				.getService(IAccessChangeDAO.class))
				.getAccessChargeById(Integer.valueOf(accessid));
		accessChangeValue.setState("4");
		((IAccessChangeDAO) ServiceFactory.getService(IAccessChangeDAO.class))
				.saveAccessChange(accessChangeValue);
	}

	
	// �޸Ĺ���״̬Ϊ�ύ������
	public void changeAccessStateAutid(String accessid) throws Exception {
		IBOAccessChangeValue accessChangeValue = ((IAccessChangeDAO) ServiceFactory
				.getService(IAccessChangeDAO.class))
				.getAccessChargeById(Integer.valueOf(accessid));
		accessChangeValue.setState("2");
		((IAccessChangeDAO) ServiceFactory.getService(IAccessChangeDAO.class))
				.saveAccessChange(accessChangeValue);
	}
	
}
