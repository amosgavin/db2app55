package com.asiainfo.sale.weapon.bo;

import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponDeValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponInfoValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponMainDeValue;

public class BOSaleWeaponInfoBean implements IBOSaleWeaponInfoValue{
	private IBOSaleWeaponMainDeValue saleWeaponMainDeValue;
	private IBOSaleWeaponDeValue[] saleWeaponDeValues;
	
	
	@Override
	public IBOSaleWeaponDeValue[] gSaleDetailShowValue() {
		// TODO Auto-generated method stub
		return saleWeaponDeValues;
	}

	@Override
	public IBOSaleWeaponMainDeValue getSaleMainShowValue() {
		// TODO Auto-generated method stub
		return saleWeaponMainDeValue;
	}

	@Override
	public void setSaleDetailShowValues(
			IBOSaleWeaponDeValue[] saleWeaponDeValues) {
		this.saleWeaponDeValues = saleWeaponDeValues;
		
	}

	@Override
	public void setSaleWeaponMainDeValue(
			IBOSaleWeaponMainDeValue saleWeaponMainDeValue) {
		this.saleWeaponMainDeValue = saleWeaponMainDeValue;
		
	}

}
