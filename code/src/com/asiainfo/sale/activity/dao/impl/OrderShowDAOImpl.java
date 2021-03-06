package com.asiainfo.sale.activity.dao.impl;

import com.asiainfo.sale.activity.bo.BOOrderShowEngine;
import com.asiainfo.sale.activity.dao.interfaces.IOrderShowDAO;
import com.asiainfo.sale.activity.ivalues.IBOOrderShowValue;

public class OrderShowDAOImpl implements IOrderShowDAO {

	@Override
	public IBOOrderShowValue[] getSaleInfoByOrderId(String orderId)
			throws Exception {

		String cd = "WITH S                                                                                "
				+ "        AS (SELECT ROW_NUMBER () OVER (PARTITION BY sale_id ORDER BY tag_id)            "
				+ "                      tag_id1,                                                          "
				+ "                   ROW_NUMBER () OVER (PARTITION BY sale_id ORDER BY tag_id)            "
				+ "                      tag_id2,                                                          "
				+ "                   NAME,                                                                "
				+ "                   sale_id                                                              "
				+ "              FROM (SELECT sd.ID SALE_ID, tag_id, NAME                                  "
				+ "                      FROM sale_detail_t sd                                             "
				+ "                           LEFT JOIN RELATE_GOODS2SALE_T G                              "
				+ "                              ON sd.ID = g.sale_id                                      "
				+ "                           LEFT JOIN SALE_HPTAG_DETAIL_T TAG                            "
				+ "                              ON G.TAG_ID = TAG.ID) tmp),                               "
				+ "     T (sale_id, tag_id1, tag_id2, NAME)                                                "
				+ "        AS (SELECT sale_id,                                                             "
				+ "                   tag_id1,                                                             "
				+ "                   tag_id2,                                                             "
				+ "                   CAST (NAME AS VARCHAR (100))                                         "
				+ "              FROM S                                                                    "
				+ "             WHERE tag_id1 = 1 AND tag_id2 = 1                                          "
				+ "            UNION ALL                                                                   "
				+ "            SELECT t.sale_id,                                                           "
				+ "                   t.tag_id1 + 1,                                                       "
				+ "                   t.tag_id2,                                                           "
				+ "                   CAST (s.NAME || ',' || t.NAME AS VARCHAR (100))                      "
				+ "              FROM S, T                                                                 "
				+ "             WHERE s.tag_id2 = t.tag_id1 + 1 AND t.sale_id = s.sale_id)                 "
				+ "SELECT DISTINCT sale.*, NAME goods_names                                                "
				+ "  FROM T,                                                                               "
				+ "       (SELECT sd.ID level_id,                                                          "
				+ "				       sd.SALE_ID batch_id,                                                "
				+ "				       sm.sale_main_name batch_name, sm.sale_main_code,                    "
				+ "				       sd.sale_active_name level_name, sd.sale_active_code,                "
				+ "				       sd.level_code,                                                      "
				+ "				       sm.begin_time,                                                      "
				+ "				       sm.end_time,                                                        "
				+ "				       sm.exearea,                                                         "
				+ "				       sm.marktype,                                                        "
				+ "				       sd.SALE_FLAG,                                                       "
				+ "               CASE                                                                     "
				+ "                  WHEN weapon.prestore_fee IS NULL                                      "
				+ "                  THEN                                                                  "
				+ "                     '0'                                                                "
				+ "                  WHEN weapon.b_limit IS NULL AND weapon.back_month IS NULL             "
				+ "                  THEN                                                                  "
				+ "                     CHAR (weapon.prestore_fee)                                         "
				+ "                  ELSE                                                                  "
				+ "                        weapon.prestore_fee                                             "
				+ "                     || '+'                                                             "
				+ "                     || weapon.b_limit                                                  "
				+ "                     || '*'                                                             "
				+ "                     || weapon.back_month                                               "
				+ "               END                                                                      "
				+ "                  prestore_fee,                                                         "
				+ "               weapon.PRESTRORE_REACH_ACCOUNT,                                          "
				+ "                  weapon.present_busi_month                                             "
				+ "               || '*'                                                                   "
				+ "               || weapon.PRESENT_VALUE_PERMON                                           "
				+ "                  present_fee,                                                          "
				+ "               weapon.present_reach_amount,                                             "
				+ "               weapon.l_limit || '*' || weapon.base_month BASE,                         "
				+ "               CASE                                                                     "
				+ "                  WHEN PRESENT_BUSI2_AMOUNT IS NULL                                     "
				+ "                  THEN                                                                  "
				+ "                     '0'                                                                "
				+ "                  WHEN STANDBY_NUM1 IS NULL                                             "
				+ "                  THEN                                                                  "
				+ "                     CHAR (PRESENT_BUSI2_AMOUNT)                                        "
				+ "                  ELSE                                                                  "
				+ "                     REPLACE (                                                          "
				+ "                           VALUE (FIRSTCHARGE, '0')                                     "
				+ "                        || '+'                                                          "
				+ "                        || VALUE (PRESENT_BUSI2_AMOUNT, '0')                            "
				+ "                        || '*'                                                          "
				+ "                        || VALUE (STANDBY_NUM1, '0')                                    "
				+ "                        || '+'                                                          "
				+ "                        || VALUE (LASTCHARGE, '0'),                                     "
				+ "                        '--',                                                           "
				+ "                        '0')                                                            "
				+ "               END                                                                      "
				+ "                  present_tick,                                                         "
				+ "               REFERENCE_PRICE,                                                         "
				+ "                  DATA_BUSI_TYPE                                                        "
				+ "               || '('                                                                   "
				+ "               || VALUE_PERMONTH                                                        "
				+ "               || '*'                                                                   "
				+ "               || OPEN_MONTH                                                            "
				+ "               || ')',                                                                  "
				+ "               GLOBAL_SCORE,                                                            "
				+ "               level_desc                                                               "
				+ "          FROM (select * from hbsale.sale_main_t where order_id=                        "
				+ orderId
				+ ") sm                                                                                    "
				+ "               LEFT JOIN hbsale.sale_detail_t sd                                        "
				+ "                  ON CHAR (sm.ID) = CHAR (sd.sale_id)                                   "
				+ "               LEFT JOIN hbsale.sale_weapon_t weapon                                    "
				+ "                  ON CHAR (sd.weapon_id) = CHAR (weapon.ID)) sale                       "
				+ " WHERE t.tag_id1 = (SELECT MAX (tag_id1)                                                "
				+ "                      FROM S                                                            "
				+ "                     WHERE s.sale_id = t.sale_id)                                       "
				+ "       AND sale.level_ID = t.sale_id order by sale.batch_id                             ";
		return BOOrderShowEngine.getBeansFromSql(cd, null);
	}

}
