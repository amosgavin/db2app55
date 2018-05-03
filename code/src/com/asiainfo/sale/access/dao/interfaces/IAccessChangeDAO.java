package com.asiainfo.sale.access.dao.interfaces;

import com.asiainfo.sale.access.ivalues.IBOAccessChangeValue;
import com.asiainfo.sale.access.ivalues.IBOAccessChangeDetailValue;
import com.asiainfo.sale.access.bo.BOAccessChangeBean;

public interface IAccessChangeDAO {
   
	//���������޸���������Ϣ
	public int saveAccessChange(IBOAccessChangeValue accessChangeValue)throws Exception;

	//���������޸�������ϸ��Ϣ
	public void saveAccessChangeDetail(IBOAccessChangeDetailValue accessChangeDetailValue,int accessId)throws Exception;

	//���������޸�������ϸ��Ϣ
	public void saveAccessChangeDetailBatch(IBOAccessChangeDetailValue[] accessChangeDetailValues)throws Exception;
	
	//���������޸�������ϸ��Ϣ
	public void saveAccessChangeDetail(IBOAccessChangeDetailValue[] accessChangeDetailValues,int accessId)throws Exception;
	
	//��ȡ�޸���������Ϣ
	public IBOAccessChangeValue getAccessChargeById(int accessid)throws Exception;

	//��ȡ�޸�������ϸ��Ϣ
	public IBOAccessChangeDetailValue[] getAccessChargeDetailById(int accessid,int startNum, int endNum)throws Exception;
	
	//��ȡ�޸�������ϸ��Ϣ��¼��
	public int getAccessChargeDetailCount(int accessid)throws Exception;

	//��ѯ�����޸���Ϣ
	public IBOAccessChangeValue[] queryAccessChangeValue(String beginTime,String endTime,String applyname,String objectid, String principle,String town,int startNum, int endNum)throws Exception;

	//��ѯ�����޸���Ϣ��¼��
	public int queryAccessChangeCount(String beginTime,String endTime,String applyname,String objectid, String principle,String town)throws Exception;
	
	
	//ɾ���޸�������Ϣ
	public void delAccessChangeValue(int accessid)throws Exception;
	
}
