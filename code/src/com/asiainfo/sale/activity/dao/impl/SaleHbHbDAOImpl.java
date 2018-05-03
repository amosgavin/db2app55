package com.asiainfo.sale.activity.dao.impl;

import com.asiainfo.sale.activity.bo.BOSaleHbHbEngine;
import com.asiainfo.sale.activity.dao.interfaces.ISaleHbHbDAO;
import com.asiainfo.sale.activity.ivalues.IBOSaleHbHbValue;

public class SaleHbHbDAOImpl implements ISaleHbHbDAO {

	@Override
	public IBOSaleHbHbValue getSaleHbHbByMainId(String mainId) throws Exception {

		if ("-1".equals(mainId)) {
			return null;
		}
		String condition = " " + IBOSaleHbHbValue.S_Mid + "=" + mainId;
		IBOSaleHbHbValue[] SaleHbHbValues = BOSaleHbHbEngine
				.getBeans(condition, null);
		if (SaleHbHbValues != null && SaleHbHbValues.length > 0) {
			return SaleHbHbValues[0];
		} else {
			return BOSaleHbHbEngine.getBean(0);
		}
	}

	@Override
	public String saveSaleHbHb(IBOSaleHbHbValue SaleHbHbValue)
			throws Exception {

		if (SaleHbHbValue.getId() == 0) {
			SaleHbHbValue.setId(BOSaleHbHbEngine.getNewId()
					.intValue());
			SaleHbHbValue.setStsToNew();
		}
		BOSaleHbHbEngine.save(SaleHbHbValue);
		return null;
	}

	@Override
	public IBOSaleHbHbValue[] getSaleHbHbsByMainId(String mainId)
			throws Exception {
		String condition = " " + IBOSaleHbHbValue.S_Mid + "=" + mainId;
		return BOSaleHbHbEngine.getBeans(condition, null);
	}

	@Override
	public void cloneHbHbByMainId(String oldMainId, String newMainId)
			throws Exception {

		IBOSaleHbHbValue[] oldValues = getSaleHbHbsByMainId(oldMainId);
		for (IBOSaleHbHbValue eit : oldValues) {
			eit.setId(BOSaleHbHbEngine.getNewId().intValue());
			eit.setMid(newMainId);
			eit.setStsToNew();
			BOSaleHbHbEngine.save(eit);
		}
	}

}
