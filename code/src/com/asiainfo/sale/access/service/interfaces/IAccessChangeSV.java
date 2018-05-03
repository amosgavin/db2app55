package com.asiainfo.sale.access.service.interfaces;

import com.asiainfo.sale.access.bo.BOAccessChangeEngine;
import com.asiainfo.sale.access.ivalues.IBOAccessChangeDetailValue;
import com.asiainfo.sale.access.ivalues.IBOAccessChangeValue;
import com.asiainfo.sale.access.bo.BOAccessChangeBean;

public interface IAccessChangeSV {
	//���������޸���������Ϣ
	public int saveAccessChange(IBOAccessChangeValue accessChangeValue)throws Exception;

	//���������޸�������ϸ��Ϣ
	public void saveAccessChangeDetail(IBOAccessChangeDetailValue accessChangeDetailValue,int accessId)throws Exception;
	
	//���������޸�������ϸ��Ϣ
	public void saveAccessChangeDetailBatch(IBOAccessChangeDetailValue[] accessChangeDetailValues)throws Exception;
	
	//��ȡ�޸���������Ϣ
	public IBOAccessChangeValue getAccessChargeById(int accessid)throws Exception;
	
	//��ȡ�޸�������ϸ��Ϣ
	public IBOAccessChangeDetailValue[] getAccessChargeDetailById(int accessid,int startNum, int endNum)throws Exception;
	
	//��ѯ�����޸���Ϣ
	public IBOAccessChangeValue[] queryAccessChangeValue(String beginTime,String endTime,String applyname,String objectid,String principle,String town,int startNum, int endNum)throws Exception;
	
	//ɾ���޸�������Ϣ
	public void delAccessChangeValue(int accessid)throws Exception;
	
	//�޸Ĺ���״̬
	public void changeAccessState(String mid,String state)throws Exception;	

	//�޸Ĺ���״̬Ϊͨ��
	public void changeAccessStateOk(String mid)throws Exception;	

	//�޸Ĺ���״̬Ϊ���
	public void changeAccessStateFalse(String mid)throws Exception;	
	
	// ��ȡ�޸�������ϸ��¼��
	public int getAccessChargeDetailCount(int accessid)throws Exception;
	
	//��ѯ�����޸���Ϣ��¼��
	public int queryAccessChangeCount(String beginTime,String endTime,String applyname,String objectid, String principle,String town)throws Exception;
	
	// �޸Ĺ���״̬Ϊ�ύ������
	public void changeAccessStateAutid(String accessid) throws Exception;
	

}	
