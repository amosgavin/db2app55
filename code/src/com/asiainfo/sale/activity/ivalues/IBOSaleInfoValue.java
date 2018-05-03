package com.asiainfo.sale.activity.ivalues;

public interface IBOSaleInfoValue {
	public void setSaleMainShowValue(IBOSaleMainShowValue saleMainShowValue);
	
	public void setSaleDetailShowValues(IBOSaleDetailShowValue[] saleDetailShowValues);
	
	public IBOSaleMainShowValue getSaleMainShowValue();
	
	public IBOSaleDetailShowValue[] gSaleDetailShowValue();
}
