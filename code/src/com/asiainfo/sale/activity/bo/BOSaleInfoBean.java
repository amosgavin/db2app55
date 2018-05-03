package com.asiainfo.sale.activity.bo;

import com.asiainfo.sale.activity.ivalues.IBOSaleDetailShowValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleInfoValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleMainShowValue;

public class BOSaleInfoBean implements IBOSaleInfoValue {
	private IBOSaleMainShowValue saleMainShowValue;
	private IBOSaleDetailShowValue[] saleDetailShowValues;

	@Override
	public IBOSaleDetailShowValue[] gSaleDetailShowValue() {
		return saleDetailShowValues;
	}

	@Override
	public IBOSaleMainShowValue getSaleMainShowValue() {
		return saleMainShowValue;
	}

	@Override
	public void setSaleDetailShowValues(IBOSaleDetailShowValue[] saleDetailShowValues) {
		this.saleDetailShowValues = saleDetailShowValues;
	}

	@Override
	public void setSaleMainShowValue(IBOSaleMainShowValue saleMainShowValue) {
		this.saleMainShowValue = saleMainShowValue;
	}

}
