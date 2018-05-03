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
	// 保存渠道修改申请主信息
	public int saveAccessChange(IBOAccessChangeValue accessChangeValue)
			throws Exception {
		return ((IAccessChangeDAO) ServiceFactory
				.getService(IAccessChangeDAO.class))
				.saveAccessChange(accessChangeValue);
	}

	// 保存渠道修改申请明细信息
	public void saveAccessChangeDetail(
			IBOAccessChangeDetailValue accessChangeDetailValue, int accessId)
			throws Exception {
		((IAccessChangeDAO) ServiceFactory.getService(IAccessChangeDAO.class))
				.saveAccessChangeDetail(accessChangeDetailValue, accessId);
	}

	// 保存渠道修改申请明细信息
	public void saveAccessChangeDetailBatch(
			IBOAccessChangeDetailValue[] accessChangeDetailValues)
			throws Exception {
		((IAccessChangeDAO) ServiceFactory.getService(IAccessChangeDAO.class))
				.saveAccessChangeDetailBatch(accessChangeDetailValues);
	}

	// 获取修改申请主信息
	public IBOAccessChangeValue getAccessChargeById(int accessid)
			throws Exception {
		return ((IAccessChangeDAO) ServiceFactory
				.getService(IAccessChangeDAO.class))
				.getAccessChargeById(accessid);
	}

	// 获取修改申请明细信息
	public IBOAccessChangeDetailValue[] getAccessChargeDetailById(int accessid,int startNum, int endNum)
			throws Exception {
		return ((IAccessChangeDAO) ServiceFactory
				.getService(IAccessChangeDAO.class))
				.getAccessChargeDetailById(accessid,startNum,endNum);

	}

	// 获取修改申请明细记录数
	public int getAccessChargeDetailCount(int accessid)
			throws Exception {
		return ((IAccessChangeDAO) ServiceFactory
				.getService(IAccessChangeDAO.class)).getAccessChargeDetailCount(accessid);

	}
	
	// 查询渠道修改信息
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

	//查询渠道修改信息记录数
	public int queryAccessChangeCount(String beginTime,String endTime,String applyname,String objectid, String principle,String town)throws Exception{
		return ((IAccessChangeDAO) ServiceFactory
				.getService(IAccessChangeDAO.class)).queryAccessChangeCount(
				beginTime, endTime, applyname, objectid, principle,town);		
	}
	
	// 删除修改申请信息
	public void delAccessChangeValue(int accessid) throws Exception {
		((IAccessChangeDAO) ServiceFactory.getService(IAccessChangeDAO.class))
				.delAccessChangeValue(accessid);
	}

	// 修改工单状态
	public void changeAccessState(String accessid, String state)
			throws Exception {
		IBOAccessChangeValue accessChangeValue = ((IAccessChangeDAO) ServiceFactory
				.getService(IAccessChangeDAO.class))
				.getAccessChargeById(Integer.valueOf(accessid));
		accessChangeValue.setState(state);
		((IAccessChangeDAO) ServiceFactory.getService(IAccessChangeDAO.class))
				.saveAccessChange(accessChangeValue);
	}

	// 修改工单状态为通过
	public void changeAccessStateOk(String accessid) throws Exception {
		IBOAccessChangeValue accessChangeValue = ((IAccessChangeDAO) ServiceFactory
				.getService(IAccessChangeDAO.class))
				.getAccessChargeById(Integer.valueOf(accessid));
		accessChangeValue.setState("3");
		((IAccessChangeDAO) ServiceFactory.getService(IAccessChangeDAO.class))
				.saveAccessChange(accessChangeValue);

	}

	// 修改工单状态为否决
	public void changeAccessStateFalse(String accessid) throws Exception {
		IBOAccessChangeValue accessChangeValue = ((IAccessChangeDAO) ServiceFactory
				.getService(IAccessChangeDAO.class))
				.getAccessChargeById(Integer.valueOf(accessid));
		accessChangeValue.setState("4");
		((IAccessChangeDAO) ServiceFactory.getService(IAccessChangeDAO.class))
				.saveAccessChange(accessChangeValue);
	}

	
	// 修改工单状态为提交待审批
	public void changeAccessStateAutid(String accessid) throws Exception {
		IBOAccessChangeValue accessChangeValue = ((IAccessChangeDAO) ServiceFactory
				.getService(IAccessChangeDAO.class))
				.getAccessChargeById(Integer.valueOf(accessid));
		accessChangeValue.setState("2");
		((IAccessChangeDAO) ServiceFactory.getService(IAccessChangeDAO.class))
				.saveAccessChange(accessChangeValue);
	}
	
}
