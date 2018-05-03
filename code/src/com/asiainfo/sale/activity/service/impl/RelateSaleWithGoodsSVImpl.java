package com.asiainfo.sale.activity.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.activity.dao.interfaces.IRelateSaleWithGoodsDAO;
import com.asiainfo.sale.activity.service.interfaces.IRelateSaleWithGoodsSV;
import com.asiainfo.sale.tag.ivalues.IBOHPPromationTagValue;
import com.asiainfo.sale.tag.ivalues.IHPRowPromationTagValue;

public class RelateSaleWithGoodsSVImpl implements IRelateSaleWithGoodsSV {

	@Override
	public void deleteRelateSaleWithGoods(String saleItemId, String goodsTagIds)
			throws Exception {

		((IRelateSaleWithGoodsDAO) ServiceFactory
				.getService(IRelateSaleWithGoodsDAO.class))
				.deleteRelateSaleWithGoods(saleItemId, goodsTagIds);
	}

	@Override
	public IHPRowPromationTagValue[] getRelateSaleWithGoodsValues(
			String saleItemId, String goodsTagIds,String isrows) throws Exception {

		return ((IRelateSaleWithGoodsDAO) ServiceFactory
				.getService(IRelateSaleWithGoodsDAO.class))
				.getRelateSaleWithGoodsValues(saleItemId, goodsTagIds, isrows);
	}

	@Override
	public void savaRelateSaleWithGoods(String saleItemId, String goodsTagIds,String isrows)
			throws Exception {

		((IRelateSaleWithGoodsDAO) ServiceFactory
				.getService(IRelateSaleWithGoodsDAO.class))
				.savaRelateSaleWithGoods(saleItemId, goodsTagIds,isrows);
	}

	@Override
	public int getRelateSaleWithGoodsCount(String saleItemId, String goodsTagIds,String isrows)
			throws Exception {

		return ((IRelateSaleWithGoodsDAO) ServiceFactory
				.getService(IRelateSaleWithGoodsDAO.class))
				.getRelateSaleWithGoodsCount(saleItemId, goodsTagIds, isrows);
	}

}
