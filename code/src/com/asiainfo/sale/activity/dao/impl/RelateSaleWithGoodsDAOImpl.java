package com.asiainfo.sale.activity.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.asiainfo.sale.activity.bo.BORelateSaleWithGoodsBean;
import com.asiainfo.sale.activity.bo.BORelateSaleWithGoodsEngine;
import com.asiainfo.sale.activity.dao.interfaces.IRelateSaleWithGoodsDAO;
import com.asiainfo.sale.tag.bo.BOHPPromationTagBean;
import com.asiainfo.sale.tag.bo.BOHPPromationTagEngine;
import com.asiainfo.sale.tag.bo.HPRowPromationTagEngine;
import com.asiainfo.sale.tag.ivalues.IBOHPPromationTagValue;
import com.asiainfo.sale.tag.ivalues.IHPRowPromationTagValue;

public class RelateSaleWithGoodsDAOImpl implements IRelateSaleWithGoodsDAO {

	@Override
	public void savaRelateSaleWithGoods(String saleItemId, String goodsTagIds,String isRows)
			throws Exception {
		if(isRows==null||isRows==""){
		String[] goodsTagIdArray = goodsTagIds.split(",");
		List<BORelateSaleWithGoodsBean> relateSaleWithGValues = new ArrayList<BORelateSaleWithGoodsBean>();
		for (String goodsTagId : goodsTagIdArray) {
			BORelateSaleWithGoodsBean relateSaleWithGValue = new BORelateSaleWithGoodsBean();
			relateSaleWithGValue.setId(BORelateSaleWithGoodsEngine.getNewId()
					.intValue());
			relateSaleWithGValue.setSaleId(Integer.parseInt(saleItemId));
			relateSaleWithGValue.setTagId(Integer.parseInt(goodsTagId));
			relateSaleWithGValue.setStsToNew();
			relateSaleWithGValues.add(relateSaleWithGValue);
		}
		BORelateSaleWithGoodsEngine
				.save((BORelateSaleWithGoodsBean[]) relateSaleWithGValues
						.toArray(new BORelateSaleWithGoodsBean[relateSaleWithGValues
								.size()]));
		}else{
			String condition ="select * from hbsale.RELATE_GOODS2SALE_T where id in ("+goodsTagIds+")";
			BORelateSaleWithGoodsBean[] relateSaleWithGValue=BORelateSaleWithGoodsEngine.getBeansFromSql(condition,null);
			for(int i=0;i<relateSaleWithGValue.length;i++){
				relateSaleWithGValue[i].setRemark2(isRows);
				BORelateSaleWithGoodsEngine.save(relateSaleWithGValue[i]);
			}
		}
		//else{
////			//为货品组的时候添加一条货品组的标识
////			BOHPPromationTagBean hpromationTagValue = new BOHPPromationTagBean();
////			hpromationTagValue.setId(BOHPPromationTagEngine.getNewId().longValue());
////			hpromationTagValue.setName("货品组"+BOHPPromationTagEngine.getNewId().longValue());
////			hpromationTagValue.setRemark(goodsTagIds);
////			hpromationTagValue.setState("0");
////			BOHPPromationTagEngine.save(hpromationTagValue);
////			//得到新的货品组的ID，并且添加到档次ID关联表
////			String goodsTagId=String.valueOf(hpromationTagValue.getId());
////			BORelateSaleWithGoodsBean relateSaleWithGValue = new BORelateSaleWithGoodsBean();
////			relateSaleWithGValue.setId(BORelateSaleWithGoodsEngine.getNewId()
////					.intValue());
////			relateSaleWithGValue.setSaleId(Integer.parseInt(saleItemId));
////			relateSaleWithGValue.setTagId(Integer.parseInt(goodsTagId));
////			relateSaleWithGValue.setRemark2("货品组合"+isRows);
////			relateSaleWithGValue.setStsToNew();
////			BORelateSaleWithGoodsEngine.save(relateSaleWithGValue);
//		}

	}

	@Override
	public void deleteRelateSaleWithGoods(String saleItemId, String goodsTagIds)
			throws Exception {

		String condition = " id in(" + goodsTagIds + ")";
		System.out.println(condition);
		BORelateSaleWithGoodsBean[] relateSaleWithGValues = BORelateSaleWithGoodsEngine
				.getBeans(condition, null);
		if (relateSaleWithGValues != null && relateSaleWithGValues.length > 0) {

			for (int i = 0; i < relateSaleWithGValues.length; ++i) {
				relateSaleWithGValues[i].delete();
			}
			BORelateSaleWithGoodsEngine.save(relateSaleWithGValues);
		}

	}

	
	public IHPRowPromationTagValue[] getRelateSaleWithGoodsValues(String saleItemId,
			String goodsTagIds,String isrows) throws Exception {
		
		String condition ="  select a.id as atid, a.sale_id,a.remark1, a.remark2, a.remark3,b.* from HBSALE.RELATE_GOODS2SALE_T a, HBSALE.SALE_HPTAG_DETAIL_T b" +
				" where b.id=a.tag_id  and a.sale_id="+saleItemId +"  order by a.remark2 desc";
		return HPRowPromationTagEngine.getBeansFromSql(condition, null);
		
			}
//	public IBOHPPromationTagValue[] getRelateSaleWithGoodsValues(
//			String saleItemId, String goodsTagIds,String isrows) throws Exception {
//		String condition ="";
//		if(isrows==null||!isrows.equals("Y")){
//			 condition = "select distinct * from hbsale.sale_hptag_detail_t where id in "
//					+ "(select tag_id from hbsale.relate_goods2sale_t where sale_id ="
//					+ saleItemId + ")";
//			if (saleItemId == null || saleItemId.equals("")) {
//				if (goodsTagIds == null || goodsTagIds.equals("")) {
//					return null;
//				}
//				
//				if(isrows==null||isrows.equals("")){
//				condition = "select distinct * from hbsale.sale_hptag_detail_t where id in ("
//						+ goodsTagIds + ")";
//				}else{
//					BOHPPromationTagBean hpromationTagValue = new BOHPPromationTagBean();
//					hpromationTagValue.setId(BOHPPromationTagEngine.getNewId().longValue());
//					hpromationTagValue.setName("货品组"+BOHPPromationTagEngine.getNewId().longValue());
//					hpromationTagValue.setRemark(isrows);
//					hpromationTagValue.setState("0");
//					BOHPPromationTagEngine.save(hpromationTagValue);
//					condition = "select distinct * from hbsale.sale_hptag_detail_t where id in ("
//						+ goodsTagIds + ") union all (select   * from HBSALE.SALE_HPTAG_DETAIL_T where remark='"+isrows+"'  fetch first 1 rows only )";
//				}
//			}
//		}else{
//			 condition = "select distinct * from hbsale.sale_hptag_detail_t where id in "
//					+ "(select tag_id from hbsale.relate_goods2sale_t where sale_id ="
//					+ saleItemId + ")";
//			if (saleItemId == null || saleItemId.equals("")) {
//				if (goodsTagIds == null || goodsTagIds.equals("")) {
//					return null;
//				}
//			BOHPPromationTagBean hpromationTagValue = new BOHPPromationTagBean();
//			hpromationTagValue.setId(BOHPPromationTagEngine.getNewId().longValue());
//			hpromationTagValue.setName("货品组"+BOHPPromationTagEngine.getNewId().longValue());
//			hpromationTagValue.setRemark(goodsTagIds);
//			hpromationTagValue.setState("0");
//			BOHPPromationTagEngine.save(hpromationTagValue);
//			condition = "select  * from hbsale.sale_hptag_detail_t where remark = '"
//				+ goodsTagIds +"'  fetch first 1 rows only ";
//		}
//		}
//		return BOHPPromationTagEngine.getBeansFromSql(condition, null);
//	}

	@Override
	public int getRelateSaleWithGoodsCount(String saleItemId, String goodsTagIds,String isrows)
			throws Exception {

		return getRelateSaleWithGoodsValues(saleItemId, goodsTagIds, isrows).length;
	}

}
