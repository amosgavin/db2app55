package com.asiainfo.sale.activity.dao.impl;


import com.asiainfo.sale.activity.bo.BOSaleCostEffectiveEngine;
import com.asiainfo.sale.activity.dao.interfaces.ISaleCostEffectiveDAO;
import com.asiainfo.sale.activity.ivalues.IBOSaleCostEffectiveValue;

public class SaleCostEffectiveDAOImpl implements ISaleCostEffectiveDAO{

	@Override
	public int querySaleCostEffectiveCount(String cityCode, String activityType,String datetime)
			throws Exception {
		return 0;
	}

	@Override
	public IBOSaleCostEffectiveValue[] querySaleCostEffectiveValue(
			String cityCode, String activityType, String datetime, int startNum, int endNum)
			throws Exception {
		String sqlTemp="";
		if(cityCode!=null && !cityCode.equals("")&&!cityCode.equals("HB")){
			sqlTemp="and city_code='"+cityCode+"'";
		}
		String activityTypeName=toName(Integer.parseInt(activityType));
		if(cityCode!=null && !cityCode.equals("")){
			sqlTemp+="and fee_type='"+activityTypeName+"'";
		}
		if(datetime!=null && !datetime.equals("")){
			sqlTemp+="and time_id='"+datetime+"'";
		}
		String sql="select fee_name  col_alias_1 " +
				",createorg_name  col_alias_2 " +
				",fee_type        col_alias_4 " +
				",decimal(sum(zy_total_fee),20,3)/bind_cycle/(case when sum(user_num) = 0 then null else sum(user_num) end)/ ((case when sum(ARPU)=0 then null else sum(arpu) end )/sum(user_num))  col_alias_12" +
				",decimal(sum(n_arpu - p_arpu),20,3)/(case when sum(zy_total_fee) = 0 then null  else sum(zy_total_fee) end) /bind_cycle col_alias_13" +
				" from priv_cost_eva where 1=1 " +
				sqlTemp +
				" group by PRIVSETID,fee_name,createorg_name,if_terminal,fee_type,bind_cycle" +
				" order by (case when col_alias_12 is null then 0 else col_alias_12 end)  desc fetch first 10 rows only " +
				"with ur";
		return BOSaleCostEffectiveEngine.getBeansFromSql(sql, null);
	}

	private String toName(int activityType) {
		String activityTypeName="";
		switch(activityType){
		case 1:activityTypeName="�ն�";break;
		case 2:activityTypeName="����";break;
		case 3:activityTypeName="����";break;
		case 4:activityTypeName="������";break;
		case 5:activityTypeName="��ͥ";break;
		case 6:activityTypeName="��Ϣ��";break;
		case 7:activityTypeName="����ҵ��";break;
		case 0:activityTypeName="����";break;
		}
		return activityTypeName;
	}

}
