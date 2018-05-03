package com.asiainfo.sale.activity.dao.impl;

import com.asiainfo.sale.activity.bo.BoSaleEitAppriseEngine;
import com.asiainfo.sale.activity.dao.interfaces.ISaleEitAppriseDAO;
import com.asiainfo.sale.activity.ivalues.IBoSaleEitAppriseValue;

public class SaleEitAppriseDAOImpl implements ISaleEitAppriseDAO {

	@Override
	public IBoSaleEitAppriseValue getSaleEitAppriseByMainId(String mainId,
			String appriseType) throws Exception {

		if ("-1".equals(mainId)) {
			return null;
		}
		String condition = " " + IBoSaleEitAppriseValue.S_Mid + "=" + mainId
				+ " AND " + IBoSaleEitAppriseValue.S_Remark2 + "='"
				+ appriseType + "'";
		IBoSaleEitAppriseValue[] SaleEitAppriseValues = BoSaleEitAppriseEngine
				.getBeans(condition, null);
		if (SaleEitAppriseValues != null && SaleEitAppriseValues.length > 0) {
			return SaleEitAppriseValues[0];
		} else {
			return BoSaleEitAppriseEngine.getBean(0);
		}
	}

	@Override
	public String saveSaleEitApprise(IBoSaleEitAppriseValue SaleEitAppriseValue)
			throws Exception {

		if (SaleEitAppriseValue.getId() == 0) {
			SaleEitAppriseValue.setId(BoSaleEitAppriseEngine.getNewId()
					.intValue());
			SaleEitAppriseValue.setStsToNew();
		}
		BoSaleEitAppriseEngine.save(SaleEitAppriseValue);
		return null;
	}

	@Override
	public IBoSaleEitAppriseValue[] getSaleEitApprisesByMainId(String mainId)
			throws Exception {
		String condition = " " + IBoSaleEitAppriseValue.S_Mid + "=" + mainId;
		return BoSaleEitAppriseEngine.getBeans(condition, null);
	}

	@Override
	public void cloneEitAppriseByMainId(String oldMainId, String newMainId)
			throws Exception {

		IBoSaleEitAppriseValue[] oldValues = getSaleEitApprisesByMainId(oldMainId);
		for (IBoSaleEitAppriseValue eit : oldValues) {
			eit.setId(BoSaleEitAppriseEngine.getNewId().intValue());
			eit.setMid(newMainId);
			eit.setStsToNew();
			BoSaleEitAppriseEngine.save(eit);
		}
	}

}
