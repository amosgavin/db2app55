package com.asiainfo.sale.access.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.access.dao.interfaces.IBusiChangeDetailDAO;
import com.asiainfo.sale.access.ivalues.IBOBusiChangeDetailValue;
import com.asiainfo.sale.access.ivalues.IBOSelectSaleOrChargeValue;
import com.asiainfo.sale.access.service.interfaces.IBusiChangeDetailSV;

public class BusiChangeDetailSVImpl implements IBusiChangeDetailSV {

	@Override
	public IBOBusiChangeDetailValue getBusiChangeDetailByID(String busiDId)
			throws Exception {

		return ((IBusiChangeDetailDAO) ServiceFactory
				.getService(IBusiChangeDetailDAO.class))
				.getBusiChargeDetailByID(busiDId);
	}

	@Override
	public IBOBusiChangeDetailValue[] getBusiChangeDetailByPID(String busiId,
			String busiType, int startNum, int endNum) throws Exception {

		return ((IBusiChangeDetailDAO) ServiceFactory
				.getService(IBusiChangeDetailDAO.class))
				.getBusiChargeDetailByPID(busiId, busiType, startNum, endNum);
	}

	@Override
	public int getBusiChangeDetailCountByPID(String busiId, String busiType)
			throws Exception {

		return ((IBusiChangeDetailDAO) ServiceFactory
				.getService(IBusiChangeDetailDAO.class))
				.getBusiChargeDetailCountByPID(busiId, busiType);
	}

	@Override
	public String saveBusiChangeDetail(
			IBOBusiChangeDetailValue busiChangeDetailValue) throws Exception {

		 return ((IBusiChangeDetailDAO) ServiceFactory
				.getService(IBusiChangeDetailDAO.class))
				.saveBusiChangeDetail(busiChangeDetailValue);
	}

	@Override
	public void deleteBusiChangeDetailBatch(
			IBOBusiChangeDetailValue[] busiChangeDetailValues) throws Exception {

		((IBusiChangeDetailDAO) ServiceFactory
				.getService(IBusiChangeDetailDAO.class))
				.saveBusiChangeDetailBatch(busiChangeDetailValues);
	}

	@Override
	public IBOSelectSaleOrChargeValue[] getExistInfo(String batchType,
			String orgId, String operName, String batchName, String levelName,
			int startNum, int endNum) throws Exception {

		return ((IBusiChangeDetailDAO) ServiceFactory
				.getService(IBusiChangeDetailDAO.class)).getExistInfo(
				batchType, orgId, operName, batchName, levelName, startNum,
				endNum);
	}

	@Override
	public int getExistInfoCount(String batchType, String orgId,
			String operName, String batchName, String levelName)
			throws Exception {

		return ((IBusiChangeDetailDAO) ServiceFactory
				.getService(IBusiChangeDetailDAO.class)).getExistInfoCount(
				batchType, orgId, operName, batchName, levelName);
	}

	@Override
	public boolean isExistBatchId(String batchId, String batchType)
			throws Exception {

		return ((IBusiChangeDetailDAO) ServiceFactory
				.getService(IBusiChangeDetailDAO.class)).isExistBatchId(
				batchId, batchType);
	}

}
