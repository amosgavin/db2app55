package com.asiainfo.sale.product.services.impl;

import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.secframe.orgmodel.ivalues.IBOSecStaffValue;
import com.ai.secframe.orgmodel.service.interfaces.ISecOperatorSV;
import com.asiainfo.common.service.impl.AbstractProductExtSVImpl;
import com.asiainfo.sale.product.bo.BOSaleDetailExtBean;
import com.asiainfo.sale.product.dao.interfaces.ISaleDetailExtDAO;
import com.asiainfo.sale.product.ivalues.IBOSaleDetailExtQValue;
import com.asiainfo.sale.product.ivalues.IBOSaleDetailExtValue;
import com.asiainfo.sale.product.services.interfaces.ISaleDetailExtSV;

public class SaleDetailExtSVImpl extends AbstractProductExtSVImpl implements
		ISaleDetailExtSV {

	@Override
	public IBOSaleDetailExtQValue[] qrySaleDetailExt(String mainId,
			String detail_id, String saleFlag, String active_name,
			String market, String start_date, String end_date, String status,
			String condStr, int startIndex, int endIndex) throws Exception {
		ISaleDetailExtDAO dao = getDao();
		// return new BOSaleDetailExtQBean[0];
		IBOSaleDetailExtQValue[] values = dao.qrySaleDetailExt(mainId,
				detail_id, saleFlag, active_name, market, start_date, end_date,
				status, condStr, startIndex, endIndex);
		ISecOperatorSV staffSv = (ISecOperatorSV) ServiceFactory
				.getService(ISecOperatorSV.class);
		for (int i = 0; i < values.length; i++) {
			String staffId = values[i].getStaffId();
			if(StringUtils.isNotBlank(staffId)){
				IBOSecStaffValue staffValue = staffSv.getStaffById(Long
						.parseLong(staffId));
				values[i].setStaffId(staffValue.getStaffName());
			}

		}
		return values;

	}

	@Override
	public int qrySaleDetailExtCount(String mainId, String detail_id,
			String saleFlag, String active_name, String market,
			String start_date, String end_date, String status, String condStr)
			throws Exception {
		ISaleDetailExtDAO dao = getDao();
		// return 10;

		int count = dao.qrySaleDetailExtCount(mainId, detail_id, saleFlag,
				active_name, market, start_date, end_date, status, condStr);

		return count;
	}

	public ISaleDetailExtDAO getDao() throws Exception {

		return (ISaleDetailExtDAO) ServiceFactory
				.getService(ISaleDetailExtDAO.class);

	}

	@Override
	public void saveInitialValues(String extType, String staffId)
			throws Exception {
		ISaleDetailExtDAO dao = getDao();
		if (null != extType && "SALE".equals(extType)) {
			dao.saveInitialValues(extType, staffId);

		} else {
			return;
		}

	}

	@Override
	public void changeSts(String e_id, String status, String staffId)
			throws Exception {
		ISaleDetailExtDAO dao = getDao();
		IBOSaleDetailExtValue dataValue = dao.getDataValue(e_id);
		if (null != dataValue) {

			dataValue.setStatus(status);
			dataValue.setStaffId(staffId);
			dataValue.setModifyDate(new Timestamp(System.currentTimeMillis()));
			dao
					.saveSaleDetailExtValue(new BOSaleDetailExtBean[] { (BOSaleDetailExtBean) dataValue });
		}

	}

	@Override
	public void saveSaleDetailExtValue(IBOSaleDetailExtValue[] saveValues)
			throws Exception {
		ISaleDetailExtDAO dao = getDao();
		dao.saveSaleDetailExtValue(saveValues);

	}

	@Override
	public long getNewId() throws Exception {
		ISaleDetailExtDAO dao = getDao();
		return dao.getNewId();
	}

	@Override
	public IBOSaleDetailExtValue[] getSaleDetailExt(String detail_id,
			String status) throws Exception {
		ISaleDetailExtDAO dao = getDao();
		return dao.getSaleDetailExt(detail_id, status);

	}

}
