package com.asiainfo.sale.weapon.dao.impl;

import java.util.HashMap;

import com.asiainfo.sale.weapon.bo.BOSaleWeaponStaticDataEngine;
import com.asiainfo.sale.weapon.dao.interfaces.ISaleWeaponCommonDAO;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponStaticDataValue;

public class SaleWeaponCommonDAOImpl implements ISaleWeaponCommonDAO {


	public IBOSaleWeaponStaticDataValue[] getSaleWeaponStaticData(
			String codeType, String marketType) throws Exception {
		HashMap parameter = new HashMap();
		parameter.put("codeType", codeType);
		parameter.put("marketType", marketType);
		return BOSaleWeaponStaticDataEngine
				.getBeans(
						" CODE_TYPE=:codeType and MARKET_TYPE=:marketType and IS_USED = 1 order by SORT_ID ",
						parameter);
	}
}
