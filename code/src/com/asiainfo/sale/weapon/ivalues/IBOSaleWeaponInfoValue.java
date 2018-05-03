package com.asiainfo.sale.weapon.ivalues;


public interface IBOSaleWeaponInfoValue {
	public void setSaleWeaponMainDeValue(IBOSaleWeaponMainDeValue saleWeaponMainDeValue);
	
	public void setSaleDetailShowValues(IBOSaleWeaponDeValue[] saleWeaponDeValues);
	
	public IBOSaleWeaponMainDeValue getSaleMainShowValue();
	
	public IBOSaleWeaponDeValue[] gSaleDetailShowValue();
}
