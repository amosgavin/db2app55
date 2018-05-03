package com.asiainfo.sale.activity.dao.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.asiainfo.sale.activity.bo.BOSaleResourceAllotEngine;
import com.asiainfo.sale.activity.bo.BOSaleResourceUsedEngine;
import com.asiainfo.sale.activity.dao.interfaces.ISaleResourceDAO;
import com.asiainfo.sale.activity.ivalues.IBOSaleResourceAllotValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleResourceUsedValue;
import com.asiainfo.sale.util.StringUtil;

public class SaleResourceDAOImpl implements ISaleResourceDAO {

	@Override
	public IBOSaleResourceAllotValue[] getResourceAllot(String cityId)
			throws Exception {

		String cd = " 1=1 ";
		Map<String, String> param = new HashMap<String, String>();
		if (StringUtil.isNotBlank(cityId)) {
			cd = " city_id = :cityId";
			param.put("cityId", cityId);
		}
		return BOSaleResourceAllotEngine.getBeans(cd, param);
	}

	@Override
	public void save(IBOSaleResourceAllotValue vl) throws Exception {

		if (vl != null && StringUtil.isNotBlank(vl.getCityId())) {
			IBOSaleResourceAllotValue old = getResourceAllot(vl.getCityId())[0];
			old.setPDisc(vl.getPDisc());
			old.setPTerm(vl.getPTerm());
			old.setPPoints(vl.getPPoints());
			old.setPPromt(vl.getPPromt());
			old.setLDisc(vl.getLDisc());
			old.setLTerm(vl.getLTerm());
			old.setLPoints(vl.getLPoints());
			old.setLPromt(vl.getLPromt());
			old.setThresholdV1(vl.getThresholdV1());
			old.setThresholdV2(vl.getThresholdV2());
			old.setThresholdV3(vl.getThresholdV3());
			old.setThresholdV4(vl.getThresholdV4());
			BOSaleResourceAllotEngine.save(old);
		}
	}

	@Override
	public IBOSaleResourceUsedValue[] selectResourceUsed(String cityId) throws Exception {

//		String srTable = "hbsale.priv_cost_new_201605";
		Calendar calendar = Calendar.getInstance();
		 int year = calendar.get(Calendar.YEAR);
		 int preMonth = calendar.get(Calendar.MONTH)-1;
		String srTable = "hbsale.priv_cost_new_" + year
		 + (preMonth < 10 ? "0" + preMonth : preMonth);
		String sql = "SELECT a.CITY_name,                                                                 "
				+ "       decimal((b.P_TERM/a.P_TERM)/100,6,2) p_term_used,                               "
				+ "       decimal((b.P_DISC/a.P_DISC)/100,6,2) p_disc_used,                               "
				+ "       decimal((b.p_jf/a.P_POINTS)/200,6,2) p_jf_used,                                 "
				+ "       decimal((b.p_fjf/a.P_POINTS)/200,6,2) p_fjf_used,                               "
				+ "       decimal((b.P_PROMT/a.P_PROMT)/100,6,2) p_promt_used,                            "
				+ "       decimal((b.l_TERM/a.l_TERM)/100,6,2) l_term_used,                               "
				+ "       decimal((b.l_DISC/a.l_DISC)/100,6,2) l_disc_used,                               "
				+ "       decimal((b.L_jf/a.l_POINTS)/200,6,2) l_jf_used,                                 "
				+ "       decimal((b.L_fjf/a.l_POINTS)/200,6,2) l_fjf_used,                               "
				+ "       decimal((b.l_PROMT/a.l_PROMT)/100,6,2) l_promt_used                             "
				+ " FROM hbsale.resource_allot a                                                          "
				+ "  LEFT JOIN                                                                            "
				+ "  (SELECT value (city_code, 'HB') city_code,                                           "
				+ "          sum (p_term) p_term,                                                         "
				+ "          sum (L_term) L_term,                                                         "
				+ "          sum (p_disc) p_disc,                                                         "
				+ "          sum (L_disc) L_disc,                                                         "
				+ "          sum (p_jf) p_jf,                                                             "
				+ "          sum (L_jf) L_jf,                                                             "
				+ "          sum (p_fjf) p_fjf,                                                           "
				+ "          sum (L_fjf) L_fjf,                                                           "
				+ "          sum (p_promt) p_promt,                                                       "
				+ "          sum (L_promt) L_promt                                                        "
				+ "     FROM (SELECT city_code,                                                           "
				+ "                  CASE WHEN createorg = 'HB' THEN terminal_cost_year ELSE 0 END        "
				+ "                     p_term,                                                           "
				+ "                  CASE WHEN createorg <> 'HB' THEN terminal_cost_year ELSE 0 END       "
				+ "                     L_term,                                                           "
				+ "                  CASE WHEN createorg = 'HB' THEN action_out_year ELSE 0 END           "
				+ "                     p_disc,                                                           "
				+ "                  CASE WHEN createorg <> 'HB' THEN action_out_year ELSE 0 END          "
				+ "                     L_disc,                                                           "
				+ "                  CASE WHEN createorg = 'HB' THEN jf_DZQ_COST_YEAR ELSE 0 END          "
				+ "                     p_jf,                                                             "
				+ "                  CASE WHEN createorg <> 'HB' THEN jf_DZQ_COST_YEAR ELSE 0 END         "
				+ "                     L_jf,                                                             "
				+ "                  CASE WHEN createorg = 'HB' THEN fjf_DZQ_COST_YEAR ELSE 0 END          "
				+ "                     p_fjf,                                                             "
				+ "                  CASE WHEN createorg <> 'HB' THEN fjf_DZQ_COST_YEAR ELSE 0 END         "
				+ "                     L_fjf,                                                             "
				+ "                  CASE                                                                 "
				+ "                     WHEN createorg = 'HB' THEN cxp_cost_year                          "
				+ "                     ELSE 0                                                            "
				+ "                  END                                                                  "
				+ "                     p_promt,                                                          "
				+ "                  CASE                                                                 "
				+ "                     WHEN createorg <> 'HB' THEN cxp_cost_year                         "
				+ "                     ELSE 0                                                            "
				+ "                  END                                                                  "
				+ "                     L_promt                                                           "
				+ "             FROM "
				+ srTable
				+ "            WHERE city_code IS NOT NULL AND createorg IS NOT NULL) group               "
				+ "by city_code with rollup) b                                                            "
				+ " on a.CITY_CODE=b.CITY_CODE                                                            ";
		if(cityId!=null && !"".equals(cityId)){
			sql+="where "+IBOSaleResourceAllotValue.S_CityId+"= "+cityId;
		}
		return BOSaleResourceUsedEngine.getBeansFromSql(sql, null);
	}
	
	
	public IBOSaleResourceUsedValue[] selectResourceUsed() throws Exception {

//		String srTable = "hbsale.priv_cost_new_201605";
		Calendar calendar = Calendar.getInstance();
		 int year = calendar.get(Calendar.YEAR);
		 int preMonth = calendar.get(Calendar.MONTH)-1;
		String srTable = "hbsale.priv_cost_new_" + year
		 + (preMonth < 10 ? "0" + preMonth : preMonth);
		String sql = "SELECT a.CITY_name,                                                                 "
				+ "       decimal((b.P_TERM/a.P_TERM)/100,6,2) p_term_used,                               "
				+ "       decimal((b.P_DISC/a.P_DISC)/100,6,2) p_disc_used,                               "
				+ "       decimal((b.p_jf/a.P_POINTS)/200,6,2) p_jf_used,                                 "
				+ "       decimal((b.p_fjf/a.P_POINTS)/200,6,2) p_fjf_used,                               "
				+ "       decimal((b.P_PROMT/a.P_PROMT)/100,6,2) p_promt_used,                            "
				+ "       decimal((b.l_TERM/a.l_TERM)/100,6,2) l_term_used,                               "
				+ "       decimal((b.l_DISC/a.l_DISC)/100,6,2) l_disc_used,                               "
				+ "       decimal((b.L_jf/a.l_POINTS)/200,6,2) l_jf_used,                                 "
				+ "       decimal((b.L_fjf/a.l_POINTS)/200,6,2) l_fjf_used,                               "
				+ "       decimal((b.l_PROMT/a.l_PROMT)/100,6,2) l_promt_used                             "
				+ " FROM hbsale.resource_allot a                                                          "
				+ "  LEFT JOIN                                                                            "
				+ "  (SELECT value (city_code, 'HB') city_code,                                           "
				+ "          sum (p_term) p_term,                                                         "
				+ "          sum (L_term) L_term,                                                         "
				+ "          sum (p_disc) p_disc,                                                         "
				+ "          sum (L_disc) L_disc,                                                         "
				+ "          sum (p_jf) p_jf,                                                             "
				+ "          sum (L_jf) L_jf,                                                             "
				+ "          sum (p_fjf) p_fjf,                                                           "
				+ "          sum (L_fjf) L_fjf,                                                           "
				+ "          sum (p_promt) p_promt,                                                       "
				+ "          sum (L_promt) L_promt                                                        "
				+ "     FROM (SELECT city_code,                                                           "
				+ "                  CASE WHEN createorg = 'HB' THEN terminal_cost_year ELSE 0 END        "
				+ "                     p_term,                                                           "
				+ "                  CASE WHEN createorg <> 'HB' THEN terminal_cost_year ELSE 0 END       "
				+ "                     L_term,                                                           "
				+ "                  CASE WHEN createorg = 'HB' THEN action_out_year ELSE 0 END           "
				+ "                     p_disc,                                                           "
				+ "                  CASE WHEN createorg <> 'HB' THEN action_out_year ELSE 0 END          "
				+ "                     L_disc,                                                           "
				+ "                  CASE WHEN createorg = 'HB' THEN jf_DZQ_COST_YEAR ELSE 0 END          "
				+ "                     p_jf,                                                             "
				+ "                  CASE WHEN createorg <> 'HB' THEN jf_DZQ_COST_YEAR ELSE 0 END         "
				+ "                     L_jf,                                                             "
				+ "                  CASE WHEN createorg = 'HB' THEN fjf_DZQ_COST_YEAR ELSE 0 END          "
				+ "                     p_fjf,                                                             "
				+ "                  CASE WHEN createorg <> 'HB' THEN fjf_DZQ_COST_YEAR ELSE 0 END         "
				+ "                     L_fjf,                                                             "
				+ "                  CASE                                                                 "
				+ "                     WHEN createorg = 'HB' THEN cxp_cost_year                          "
				+ "                     ELSE 0                                                            "
				+ "                  END                                                                  "
				+ "                     p_promt,                                                          "
				+ "                  CASE                                                                 "
				+ "                     WHEN createorg <> 'HB' THEN cxp_cost_year                         "
				+ "                     ELSE 0                                                            "
				+ "                  END                                                                  "
				+ "                     L_promt                                                           "
				+ "             FROM "
				+ srTable
				+ "            WHERE city_code IS NOT NULL AND createorg IS NOT NULL) group               "
				+ "by city_code with rollup) b                                                            "
				+ " on a.CITY_CODE=b.CITY_CODE                                                            ";
		return BOSaleResourceUsedEngine.getBeansFromSql(sql, null);
	}
	
	
	public IBOSaleResourceUsedValue[] selectResourceUsed2(String cityId) throws Exception {

//		String srTable = "hbsale.priv_cost_new_201605";
		Calendar calendar = Calendar.getInstance();
		 int year = calendar.get(Calendar.YEAR);
		 int preMonth = calendar.get(Calendar.MONTH)-1;
		String srTable = "hbsale.priv_cost_new_" + year
		 + (preMonth < 10 ? "0" + preMonth : preMonth);
		String sql ="select a.county_name city_name,b.*" +
				" from BT_AREA_ALL a left join (SELECT county_code,             "                              
				+"           sum (p_term) p_term_used,                                                        "  
				+"           sum (L_term) L_term_used,                                                        "  
				+"           sum (p_disc) p_disc_used,                                                        "  
				+"           sum (L_disc) L_disc_used,                                                        "  
				+"           sum (p_jf) p_jf_used,                                                            "  
				+"           sum (L_jf) L_jf_used,                                                            "  
				+"           sum (p_fjf) p_fjf_used,                                                          "  
				+"           sum (L_fjf) L_fjf_used,                                                          "  
				+"           sum (p_promt) p_promt_used,                                                      " 
				+"           sum (L_promt) L_promt_used                                                       " 
				+"      FROM (SELECT county_code,                                                        "   
				+"                   CASE WHEN createorg = 'HB' THEN terminal_cost_year ELSE 0 END       " 
				+"                      p_term,                                                          " 
				+"                   CASE WHEN createorg <> 'HB' THEN terminal_cost_year ELSE 0 END      " 
				+"                      L_term,                                                          " 
				+"                   CASE WHEN createorg = 'HB' THEN action_out_year ELSE 0 END          " 
				+"                      p_disc,                                                          " 
				+"                   CASE WHEN createorg <> 'HB' THEN action_out_year ELSE 0 END         " 
				+"                      L_disc,                                                          " 
				+"                   CASE WHEN createorg = 'HB' THEN jf_DZQ_COST_YEAR ELSE 0 END         " 
				+"                      p_jf,                                                            " 
				+"                   CASE WHEN createorg <> 'HB' THEN jf_DZQ_COST_YEAR ELSE 0 END        " 
				+"                      L_jf,                                                            " 
				+"                   CASE WHEN createorg = 'HB' THEN fjf_DZQ_COST_YEAR ELSE 0 END        "  
				+"                      p_fjf,                                                           "  
				+"                   CASE WHEN createorg <> 'HB' THEN fjf_DZQ_COST_YEAR ELSE 0 END       "  
				+"                      L_fjf,                                                           "  
				+"                   CASE                                                                " 
				+"                      WHEN createorg = 'HB' THEN cxp_cost_year                         " 
				+"                      ELSE 0                                                           " 
				+"                   END                                                                 " 
				+"                      p_promt,                                                         " 
				+"                   CASE                                                                " 
				+"                      WHEN createorg <> 'HB' THEN cxp_cost_year                        " 
				+"                      ELSE 0                                                           " 
				+"                   END                                                                 " 
				+"                      L_promt                                                          " 
				+"              FROM  " 
				+srTable                                              
				+"             WHERE county_code IS NOT NULL AND createorg IS NOT NULL) group            "   
				+" by county_code with rollup) b on a.COUNTY_CODE=b.COUNTY_CODE                          " ;
		if(cityId!=null && !"".equals(cityId)){
			sql+="where a.AREA_ID=" +cityId;
		}
		return BOSaleResourceUsedEngine.getBeansFromSql(sql, null);
	}

}
