package com.asiainfo.sale.weapon.dao.interfaces;

import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponStaticDataValue;

/**
 * @author zhin
 * 
 */
public interface ISaleWeaponCommonDAO {
	/**
	 * �������͡�ϸ���г���ȡ�����⾲̬����
	 * 
	 * @param code
	 *            ����
	 * @param market
	 *            ϸ���г�
	 * @return
	 */
	public IBOSaleWeaponStaticDataValue[] getSaleWeaponStaticData(
			String codeType, String marketType) throws Exception;
}
