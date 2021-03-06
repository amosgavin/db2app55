package com.asiainfo.sale.weapon.dao.interfaces;

import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponStaticDataValue;

/**
 * @author zhin
 * 
 */
public interface ISaleWeaponCommonDAO {
	/**
	 * 根据类型、细分市场获取武器库静态数据
	 * 
	 * @param code
	 *            类型
	 * @param market
	 *            细分市场
	 * @return
	 */
	public IBOSaleWeaponStaticDataValue[] getSaleWeaponStaticData(
			String codeType, String marketType) throws Exception;
}
