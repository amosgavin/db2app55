package com.asiainfo.sale.activity.dao.impl;

import com.asiainfo.sale.activity.bo.BOUsedQueryEngine;
import com.asiainfo.sale.activity.dao.interfaces.IUsedQueryDAO;
import com.asiainfo.sale.activity.ivalues.IBOUsedQueryValue;

public class UsedQueryDAOImpl implements IUsedQueryDAO{

	@Override
	public int queryUsedCount(String cityCode, String resourcetype,
			String createorg, String datetime) throws Exception {
		return 0;
	}

	@Override
	public IBOUsedQueryValue[] queryUsedValue(String cityCode,
			String resourcetype, String createorg, String datetime, int startNum, int endNum)
			throws Exception {
		String srTable ="";
		String sql="";
		if(!datetime.equals("") && datetime!=null){
			 srTable = "hbsale.priv_cost_new_"+ datetime;
		}
		if(!resourcetype.equals("all")){
		if(cityCode.equals("HB")){
			if(createorg.equals("HB")){
				 sql="SELECT CITY_CODE,PRIVSETID_NAME,CREATEORG,user_num,TERMINAL_COST_YEAR,ACTION_OUT_YEAR," +
						"jf_DZQ_COST_YEAR,fjf_DZQ_COST_YEAR,CXP_COST_YEAR," +
						"TERMINAL_COST_YEAR/ (select sum(TERMINAL_COST_YEAR) from " +srTable+ " where CREATEORG='HB')*100 " +
						"TERMINAL_COST_YEAR_per," +
						"ACTION_OUT_YEAR/ (select sum(ACTION_OUT_YEAR) from " +srTable+ " where CREATEORG='HB')*100 " +
						"ACTION_OUT_YEAR_per," +
						"jf_DZQ_COST_YEAR" +
						"/ (select sum(jf_DZQ_COST_YEAR) from " +srTable+ " where CREATEORG='HB')*100 " +
						"jf_DZQ_COST_YEAR_per," +
						"fjf_DZQ_COST_YEAR" +
						"/ (select sum(fjf_DZQ_COST_YEAR) from " +srTable+ " where CREATEORG='HB')*100 " +
						"fjf_DZQ_COST_YEAR_per," +
						"CXP_COST_YEAR" +
						"/ (select sum(CXP_COST_YEAR) from " +srTable+ " where CREATEORG='HB')*100 " +
						"CXP_COST_YEAR_per FROM " +
						srTable +
						" where CREATEORG ='HB' order by " +
						resourcetype +
						" desc fetch  first 10 rows only";
			}else{
				sql="SELECT CITY_CODE,PRIVSETID_NAME,CREATEORG,user_num,TERMINAL_COST_YEAR," +
				"ACTION_OUT_YEAR,jf_DZQ_COST_YEAR,fjf_DZQ_COST_YEAR,value(CXP_COST_YEAR,0) CXP_COST_YEAR," +
				"case (select sum(TERMINAL_COST_YEAR) from " +srTable+ " where CREATEORG = '"+ createorg +"') when 0 then 0 else " +
				"TERMINAL_COST_YEAR/ (select sum(TERMINAL_COST_YEAR) from " +srTable+ " where CREATEORG = '"+ createorg +"')*100 end " +
				"TERMINAL_COST_YEAR_per," +
				"case (select sum(ACTION_OUT_YEAR) from " +srTable+ " where CREATEORG = '"+ createorg +"') when 0 then 0 else " +
				"ACTION_OUT_YEAR/ (select sum(ACTION_OUT_YEAR) from " +srTable+ " where CREATEORG = '"+ createorg +"')*100 end " +
				"ACTION_OUT_YEAR_per," +
				"case (select sum(jf_DZQ_COST_YEAR) from " +srTable+ " where CREATEORG = '"+ createorg +"') when 0 then 0 else " +
				"jf_DZQ_COST_YEAR/ (select sum(jf_DZQ_COST_YEAR) from " +srTable+ " where CREATEORG = '"+ createorg +"')*100 end "  +
				"jf_DZQ_COST_YEAR_per," +
				"case (select sum(fjf_DZQ_COST_YEAR) from " +srTable+ " where CREATEORG = '"+ createorg +"') when 0 then 0 else " +
				"fjf_DZQ_COST_YEAR/ (select sum(fjf_DZQ_COST_YEAR) from " +srTable+ " where CREATEORG = '"+ createorg +"')*100 end " +
				"fjf_DZQ_COST_YEAR_per," +
				"case (select sum(CXP_COST_YEAR) from " +srTable+ " where CREATEORG = '"+ createorg +"') when 0 then 0 else " +
				"CXP_COST_YEAR/ (select sum(CXP_COST_YEAR) from " +srTable+ " where CREATEORG = '"+ createorg +"')*100 end " +
				"CXP_COST_YEAR_per FROM " +
				srTable +
				" where CREATEORG =  '"+ createorg +"' order by " +
				resourcetype+
				" desc fetch  first 10 rows only";
			}
		}else if(!cityCode.equals("HB")){
			 if(createorg.equals("HB")){
				sql="SELECT a.CITY_CODE,PRIVSETID_NAME,CREATEORG,user_num,TERMINAL_COST_YEAR," +
						"ACTION_OUT_YEAR,jf_DZQ_COST_YEAR,fjf_DZQ_COST_YEAR,CXP_COST_YEAR," +
						"CASE b.p_term WHEN 0 THEN 0 ELSE " +
						"TERMINAL_COST_YEAR / (b.p_term*100) END TERMINAL_COST_YEAR_per," +
						"CASE b.P_DISC WHEN 0 THEN 0 ELSE " +
						"ACTION_OUT_YEAR / (b.P_DISC*100) END ACTION_OUT_YEAR_per," +
						"CASE b.P_JF WHEN 0 THEN 0 ELSE " +
						"jf_DZQ_COST_YEAR / (b.P_JF*100) END jf_DZQ_COST_YEAR_per," +
						"CASE b.P_FJF WHEN 0 THEN 0 ELSE " +
						"fjf_DZQ_COST_YEAR / (b.P_FJF*100) END fjf_DZQ_COST_YEAR_per," +
						"CASE b.p_promt WHEN 0 THEN 0 ELSE " +
						"CXP_COST_YEAR / (b.p_promt*100) END CXP_COST_YEAR_per" +
						" FROM " +srTable+ " a LEFT JOIN (" +
						"SELECT value (city_code, 'HB') city_code," +
						"sum (p_term) p_term,sum (L_term) L_term,sum (p_disc) p_disc,sum (L_disc) L_disc,sum (p_jf) p_jf," +
						"sum (L_jf) L_jf,sum (p_fjf) p_fjf,sum (L_fjf) L_fjf,sum (p_promt) p_promt,sum (L_promt) L_promt" +
						" FROM (SELECT city_code," +
						"CASE WHEN createorg = 'HB' THEN terminal_cost_year ELSE 0 END p_term," +
						"CASE WHEN createorg <> 'HB' THEN terminal_cost_year ELSE 0 END L_term," +
						"CASE WHEN createorg = 'HB' THEN action_out_year ELSE 0 END p_disc," +
						"CASE WHEN createorg <> 'HB' THEN action_out_year ELSE 0 END L_disc," +
						"CASE WHEN createorg = 'HB' THEN jf_DZQ_COST_YEAR ELSE 0 END p_jf," +
						"CASE WHEN createorg <> 'HB' THEN jf_DZQ_COST_YEAR ELSE 0 END L_jf," +
						"CASE WHEN createorg = 'HB' THEN fjf_DZQ_COST_YEAR ELSE 0 END p_fjf," +
						"CASE WHEN createorg <> 'HB' THEN fjf_DZQ_COST_YEAR ELSE 0 END L_fjf," +
						"CASE WHEN createorg = 'HB' THEN cxp_cost_year ELSE 0 END p_promt," +
						"CASE WHEN createorg <> 'HB' THEN cxp_cost_year ELSE 0 END L_promt FROM  " +
						srTable+
						" WHERE city_code IS NOT NULL AND createorg IS NOT NULL ) group" +
						" by city_code with rollup" +
						") b on a.CITY_CODE=b.CITY_CODE WHERE a.CITY_CODE='"+cityCode+ "' AND a.CREATEORG='"+createorg+ "' ORDER BY " +
						resourcetype +
				        " DESC fetch  first 10 rows only";
			 }else{
				 sql="SELECT a.CITY_CODE,PRIVSETID_NAME,CREATEORG,user_num,TERMINAL_COST_YEAR," +
					"ACTION_OUT_YEAR,jf_DZQ_COST_YEAR,fjf_DZQ_COST_YEAR,CXP_COST_YEAR," +
					"CASE b.L_term WHEN 0 THEN 0 ELSE " +
					"TERMINAL_COST_YEAR / (b.L_term*100) END TERMINAL_COST_YEAR_per," +
					"CASE b.L_DISC WHEN 0 THEN 0 ELSE " +
					"ACTION_OUT_YEAR / (b.L_DISC*100) END ACTION_OUT_YEAR_per," +
					"CASE b.L_JF WHEN 0 THEN 0 ELSE " +
					"jf_DZQ_COST_YEAR / (b.L_JF*100) END jf_DZQ_COST_YEAR_per," +
					"CASE b.L_FJF WHEN 0 THEN 0 ELSE " +
					"fjf_DZQ_COST_YEAR / (b.L_FJF*100) END fjf_DZQ_COST_YEAR_per," +
					"CASE b.L_promt WHEN 0 THEN 0 ELSE " +
					"CXP_COST_YEAR / (b.L_promt*100) END CXP_COST_YEAR_per" +
					" FROM " +srTable+ " a LEFT JOIN (" +
					"SELECT value (city_code, 'HB') city_code," +
					"sum (p_term) p_term,sum (L_term) L_term,sum (p_disc) p_disc,sum (L_disc) L_disc,sum (p_jf) p_jf," +
					"sum (L_jf) L_jf,sum (p_fjf) p_fjf,sum (L_fjf) L_fjf,sum (p_promt) p_promt,sum (L_promt) L_promt" +
					" FROM (SELECT city_code," +
					"CASE WHEN createorg = 'HB' THEN terminal_cost_year ELSE 0 END p_term," +
					"CASE WHEN createorg <> 'HB' THEN terminal_cost_year ELSE 0 END L_term," +
					"CASE WHEN createorg = 'HB' THEN action_out_year ELSE 0 END p_disc," +
					"CASE WHEN createorg <> 'HB' THEN action_out_year ELSE 0 END L_disc," +
					"CASE WHEN createorg = 'HB' THEN jf_DZQ_COST_YEAR ELSE 0 END p_jf," +
					"CASE WHEN createorg <> 'HB' THEN jf_DZQ_COST_YEAR ELSE 0 END L_jf," +
					"CASE WHEN createorg = 'HB' THEN fjf_DZQ_COST_YEAR ELSE 0 END p_fjf," +
					"CASE WHEN createorg <> 'HB' THEN fjf_DZQ_COST_YEAR ELSE 0 END L_fjf," +
					"CASE WHEN createorg = 'HB' THEN cxp_cost_year ELSE 0 END p_promt," +
					"CASE WHEN createorg <> 'HB' THEN cxp_cost_year ELSE 0 END L_promt FROM  " +
					srTable+
					" WHERE city_code IS NOT NULL AND createorg IS NOT NULL ) group" +
					" by city_code with rollup" +
					") b on a.CITY_CODE=b.CITY_CODE WHERE a.CITY_CODE='"+cityCode+ "' AND a.CREATEORG='"+createorg+ "' ORDER BY " +
					resourcetype +
			        " DESC fetch  first 10 rows only";
			 }
		}
		}else if(resourcetype.equals("all")){
			if(cityCode.equals("HB")){
				if(createorg.equals("HB")){
			sql="SELECT CITY_CODE,PRIVSETID_NAME,CREATEORG,user_num,TERMINAL_COST_YEAR,ACTION_OUT_YEAR," +
			"jf_DZQ_COST_YEAR,fjf_DZQ_COST_YEAR,CXP_COST_YEAR," +
			"TERMINAL_COST_YEAR/ (select sum(TERMINAL_COST_YEAR) from " +srTable+ " where CREATEORG='HB')*100 " +
			"TERMINAL_COST_YEAR_per," +
			"ACTION_OUT_YEAR/ (select sum(ACTION_OUT_YEAR) from " +srTable+ " where CREATEORG='HB')*100 " +
			"ACTION_OUT_YEAR_per," +
			"jf_DZQ_COST_YEAR" +
			"/ (select sum(jf_DZQ_COST_YEAR) from " +srTable+ " where CREATEORG='HB')*100 " +
			"jf_DZQ_COST_YEAR_per," +
			"fjf_DZQ_COST_YEAR" +
			"/ (select sum(fjf_DZQ_COST_YEAR) from " +srTable+ " where CREATEORG='HB')*100 " +
			"fjf_DZQ_COST_YEAR_per," +
			"CXP_COST_YEAR" +
			"/ (select sum(CXP_COST_YEAR) from " +srTable+ " where CREATEORG='HB')*100 " +
			"CXP_COST_YEAR_per FROM " +
			srTable +
			" where CREATEORG ='HB' order by " +
			"(value(terminal_cost_year,0)+value(action_out_year,0)+value(jf_dzq_cost_year,0)+value(fjf_dzq_cost_year,0)+value(cxp_cost_year,0))"+
			" desc fetch  first 10 rows only";
				}else if(!createorg.equals("HB")){
					sql="SELECT CITY_CODE,PRIVSETID_NAME,CREATEORG,user_num,TERMINAL_COST_YEAR," +
					"ACTION_OUT_YEAR,jf_DZQ_COST_YEAR,fjf_DZQ_COST_YEAR,CXP_COST_YEAR," +
					"case (select sum(TERMINAL_COST_YEAR) from " +srTable+ " where CREATEORG = '"+ createorg +"') when 0 then 0 else " +
					"TERMINAL_COST_YEAR/ (select sum(TERMINAL_COST_YEAR) from " +srTable+ " where CREATEORG = '"+ createorg +"')*100 end " +
					"TERMINAL_COST_YEAR_per," +
					"case (select sum(ACTION_OUT_YEAR) from " +srTable+ " where CREATEORG = '"+ createorg +"') when 0 then 0 else " +
					"ACTION_OUT_YEAR/ (select sum(ACTION_OUT_YEAR) from " +srTable+ " where CREATEORG = '"+ createorg +"')*100 end " +
					"ACTION_OUT_YEAR_per," +
					"case (select sum(jf_DZQ_COST_YEAR) from " +srTable+ " where CREATEORG = '"+ createorg +"') when 0 then 0 else " +
					"jf_DZQ_COST_YEAR/ (select sum(jf_DZQ_COST_YEAR) from " +srTable+ " where CREATEORG = '"+ createorg +"')*100 end "  +
					"jf_DZQ_COST_YEAR_per," +
					"case (select sum(fjf_DZQ_COST_YEAR) from " +srTable+ " where CREATEORG = '"+ createorg +"') when 0 then 0 else " +
					"fjf_DZQ_COST_YEAR/ (select sum(fjf_DZQ_COST_YEAR) from " +srTable+ " where CREATEORG = '"+ createorg +"')*100 end " +
					"fjf_DZQ_COST_YEAR_per," +
					"case (select sum(CXP_COST_YEAR) from " +srTable+ " where CREATEORG = '"+ createorg +"') when 0 then 0 else " +
					"CXP_COST_YEAR/ (select sum(CXP_COST_YEAR) from " +srTable+ " where CREATEORG = '"+ createorg +"')*100 end " +
					"CXP_COST_YEAR_per FROM " +
					srTable +
					" where CREATEORG =  '"+ createorg +"' order by " +
					"(value(terminal_cost_year,0)+value(action_out_year,0)+value(jf_dzq_cost_year,0)+value(fjf_dzq_cost_year,0)+value(cxp_cost_year,0))"+
					" desc fetch  first 10 rows only";
				}
			}else if(!cityCode.equals("HB")){
				if(createorg.equals("HB")){
					sql="SELECT a.CITY_CODE,PRIVSETID_NAME,CREATEORG,user_num,TERMINAL_COST_YEAR," +
					"ACTION_OUT_YEAR,jf_DZQ_COST_YEAR,fjf_DZQ_COST_YEAR,CXP_COST_YEAR," +
					"CASE b.p_term WHEN 0 THEN 0 ELSE " +
					"TERMINAL_COST_YEAR / (b.p_term*100) END TERMINAL_COST_YEAR_per," +
					"CASE b.P_DISC WHEN 0 THEN 0 ELSE " +
					"ACTION_OUT_YEAR / (b.P_DISC*100) END ACTION_OUT_YEAR_per," +
					"CASE b.P_JF WHEN 0 THEN 0 ELSE " +
					"jf_DZQ_COST_YEAR / (b.P_JF*100) END jf_DZQ_COST_YEAR_per," +
					"CASE b.P_FJF WHEN 0 THEN 0 ELSE " +
					"fjf_DZQ_COST_YEAR / (b.P_FJF*100) END fjf_DZQ_COST_YEAR_per," +
					"CASE b.p_promt WHEN 0 THEN 0 ELSE " +
					"CXP_COST_YEAR / (b.p_promt*100) END CXP_COST_YEAR_per" +
					" FROM " +srTable+ " a LEFT JOIN (" +
					"SELECT value (city_code, 'HB') city_code," +
					"sum (p_term) p_term,sum (L_term) L_term,sum (p_disc) p_disc,sum (L_disc) L_disc,sum (p_jf) p_jf," +
					"sum (L_jf) L_jf,sum (p_fjf) p_fjf,sum (L_fjf) L_fjf,sum (p_promt) p_promt,sum (L_promt) L_promt" +
					" FROM (SELECT city_code," +
					"CASE WHEN createorg = 'HB' THEN terminal_cost_year ELSE 0 END p_term," +
					"CASE WHEN createorg <> 'HB' THEN terminal_cost_year ELSE 0 END L_term," +
					"CASE WHEN createorg = 'HB' THEN action_out_year ELSE 0 END p_disc," +
					"CASE WHEN createorg <> 'HB' THEN action_out_year ELSE 0 END L_disc," +
					"CASE WHEN createorg = 'HB' THEN jf_DZQ_COST_YEAR ELSE 0 END p_jf," +
					"CASE WHEN createorg <> 'HB' THEN jf_DZQ_COST_YEAR ELSE 0 END L_jf," +
					"CASE WHEN createorg = 'HB' THEN fjf_DZQ_COST_YEAR ELSE 0 END p_fjf," +
					"CASE WHEN createorg <> 'HB' THEN fjf_DZQ_COST_YEAR ELSE 0 END L_fjf," +
					"CASE WHEN createorg = 'HB' THEN cxp_cost_year ELSE 0 END p_promt," +
					"CASE WHEN createorg <> 'HB' THEN cxp_cost_year ELSE 0 END L_promt FROM  " +
					srTable+
					" WHERE city_code IS NOT NULL AND createorg IS NOT NULL ) group" +
					" by city_code with rollup" +
					") b on a.CITY_CODE=b.CITY_CODE WHERE a.CITY_CODE='"+cityCode+ "' AND a.CREATEORG='"+createorg+ "' ORDER BY " +
					"(value(terminal_cost_year,0)+value(action_out_year,0)+value(jf_dzq_cost_year,0)+value(fjf_dzq_cost_year,0)+value(cxp_cost_year,0))"+
			        " DESC fetch  first 10 rows only";
				}else if(!createorg.equals("HB")){
					sql="SELECT a.CITY_CODE,PRIVSETID_NAME,CREATEORG,user_num,TERMINAL_COST_YEAR," +
					"ACTION_OUT_YEAR,jf_DZQ_COST_YEAR,fjf_DZQ_COST_YEAR,CXP_COST_YEAR," +
					"CASE b.L_term WHEN 0 THEN 0 ELSE " +
					"TERMINAL_COST_YEAR / (b.L_term*100) END TERMINAL_COST_YEAR_per," +
					"CASE b.L_DISC WHEN 0 THEN 0 ELSE " +
					"ACTION_OUT_YEAR / (b.L_DISC*100) END ACTION_OUT_YEAR_per," +
					"CASE b.L_JF WHEN 0 THEN 0 ELSE " +
					"jf_DZQ_COST_YEAR / (b.L_JF*100) END jf_DZQ_COST_YEAR_per," +
					"CASE b.L_FJF WHEN 0 THEN 0 ELSE " +
					"fjf_DZQ_COST_YEAR / (b.L_FJF*100) END fjf_DZQ_COST_YEAR_per," +
					"CASE b.L_promt WHEN 0 THEN 0 ELSE " +
					"CXP_COST_YEAR / (b.L_promt*100) END CXP_COST_YEAR_per" +
					" FROM " +srTable+ " a LEFT JOIN (" +
					"SELECT value (city_code, 'HB') city_code," +
					"sum (p_term) p_term,sum (L_term) L_term,sum (p_disc) p_disc,sum (L_disc) L_disc,sum (p_jf) p_jf," +
					"sum (L_jf) L_jf,sum (p_fjf) p_fjf,sum (L_fjf) L_fjf,sum (p_promt) p_promt,sum (L_promt) L_promt" +
					" FROM (SELECT city_code," +
					"CASE WHEN createorg = 'HB' THEN terminal_cost_year ELSE 0 END p_term," +
					"CASE WHEN createorg <> 'HB' THEN terminal_cost_year ELSE 0 END L_term," +
					"CASE WHEN createorg = 'HB' THEN action_out_year ELSE 0 END p_disc," +
					"CASE WHEN createorg <> 'HB' THEN action_out_year ELSE 0 END L_disc," +
					"CASE WHEN createorg = 'HB' THEN jf_DZQ_COST_YEAR ELSE 0 END p_jf," +
					"CASE WHEN createorg <> 'HB' THEN jf_DZQ_COST_YEAR ELSE 0 END L_jf," +
					"CASE WHEN createorg = 'HB' THEN fjf_DZQ_COST_YEAR ELSE 0 END p_fjf," +
					"CASE WHEN createorg <> 'HB' THEN fjf_DZQ_COST_YEAR ELSE 0 END L_fjf," +
					"CASE WHEN createorg = 'HB' THEN cxp_cost_year ELSE 0 END p_promt," +
					"CASE WHEN createorg <> 'HB' THEN cxp_cost_year ELSE 0 END L_promt FROM  " +
					srTable+
					" WHERE city_code IS NOT NULL AND createorg IS NOT NULL ) group" +
					" by city_code with rollup" +
					") b on a.CITY_CODE=b.CITY_CODE WHERE a.CITY_CODE='"+cityCode+ "' AND a.CREATEORG='"+createorg+ "' ORDER BY " +
					"(value(terminal_cost_year,0)+value(action_out_year,0)+value(jf_dzq_cost_year,0)+value(fjf_dzq_cost_year,0)+value(cxp_cost_year,0))"+
			        " DESC fetch  first 10 rows only";
				}
			}
		}
		return BOUsedQueryEngine.getBeansFromSql(sql, null);
	}

}
