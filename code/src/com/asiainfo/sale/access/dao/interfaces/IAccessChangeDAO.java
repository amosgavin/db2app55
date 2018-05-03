package com.asiainfo.sale.access.dao.interfaces;

import com.asiainfo.sale.access.ivalues.IBOAccessChangeValue;
import com.asiainfo.sale.access.ivalues.IBOAccessChangeDetailValue;
import com.asiainfo.sale.access.bo.BOAccessChangeBean;

public interface IAccessChangeDAO {
   
	//保存渠道修改申请主信息
	public int saveAccessChange(IBOAccessChangeValue accessChangeValue)throws Exception;

	//保存渠道修改申请明细信息
	public void saveAccessChangeDetail(IBOAccessChangeDetailValue accessChangeDetailValue,int accessId)throws Exception;

	//保存渠道修改申请明细信息
	public void saveAccessChangeDetailBatch(IBOAccessChangeDetailValue[] accessChangeDetailValues)throws Exception;
	
	//保存渠道修改申请明细信息
	public void saveAccessChangeDetail(IBOAccessChangeDetailValue[] accessChangeDetailValues,int accessId)throws Exception;
	
	//获取修改申请主信息
	public IBOAccessChangeValue getAccessChargeById(int accessid)throws Exception;

	//获取修改申请明细信息
	public IBOAccessChangeDetailValue[] getAccessChargeDetailById(int accessid,int startNum, int endNum)throws Exception;
	
	//获取修改申请明细信息记录数
	public int getAccessChargeDetailCount(int accessid)throws Exception;

	//查询渠道修改信息
	public IBOAccessChangeValue[] queryAccessChangeValue(String beginTime,String endTime,String applyname,String objectid, String principle,String town,int startNum, int endNum)throws Exception;

	//查询渠道修改信息记录数
	public int queryAccessChangeCount(String beginTime,String endTime,String applyname,String objectid, String principle,String town)throws Exception;
	
	
	//删除修改申请信息
	public void delAccessChangeValue(int accessid)throws Exception;
	
}
