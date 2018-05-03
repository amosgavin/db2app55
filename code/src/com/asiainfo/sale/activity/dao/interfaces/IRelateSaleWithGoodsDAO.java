package com.asiainfo.sale.activity.dao.interfaces;

import com.asiainfo.sale.tag.ivalues.IBOHPPromationTagValue;
import com.asiainfo.sale.tag.ivalues.IHPRowPromationTagValue;

public interface IRelateSaleWithGoodsDAO {

	void savaRelateSaleWithGoods(String saleItemId, String goodsTagIds,String isRows)
			throws Exception;

	void deleteRelateSaleWithGoods(String saleItemId, String goodsTagIds)
			throws Exception;

	IHPRowPromationTagValue[] getRelateSaleWithGoodsValues(String saleItemId,
			String goodsTagIds,String isrows) throws Exception;

	int getRelateSaleWithGoodsCount(String saleItemId, String goodsTagIds,String isrows)
			throws Exception;
}
