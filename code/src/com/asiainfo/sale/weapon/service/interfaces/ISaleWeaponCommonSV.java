package com.asiainfo.sale.weapon.service.interfaces;

import java.rmi.RemoteException;

import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponStaticDataValue;

/**
 * @author zhin
 * 
 */
public interface ISaleWeaponCommonSV {
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
			String codeType, String marketType) throws Exception, RemoteException;;
}
