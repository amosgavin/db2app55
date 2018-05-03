package com.asiainfo.costWarn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.asiainfo.costWarn.bo.BOWarnResultEngine;
import com.asiainfo.costWarn.dao.interfaces.IWarnResultDAO;
import com.asiainfo.costWarn.ivalues.IBOWarnResultValue;
import com.asiainfo.costWarn.job.ConnectUtil;

public class WarnResultDAOImpl implements IWarnResultDAO{

	@Override
	public int count(String resource_type,String up_down,String city_code) throws Exception {
		Map<String,String> param=new HashMap<String,String>();
		return BOWarnResultEngine.getBeansCount(getConditionCount(resource_type,up_down,city_code), param);
	}

	@Override
	public IBOWarnResultValue[] select(String resource_type,String up_down,String city_code, int startNum, int endNum)
			throws Exception {
		Map<String,String> param=new HashMap<String, String>();
		param.put("resource_type", resource_type);
		param.put("up_down", up_down);
		//city_code=GetCityCode(city_code);
		param.put("city_code", city_code);
		return BOWarnResultEngine.getBeans(null,getCondition(resource_type,up_down,city_code), param,startNum,endNum,false, null);
	}
	

	private String getCondition(String resource_type,String up_down,String city_code) {
		String condition="1=1";
		if(city_code!=null&&!city_code.equals("")){
			condition = condition+" and "+IBOWarnResultValue.S_CityCode+ "='" +city_code+"'";
		}
		condition = condition +" and ("+ IBOWarnResultValue.S_IsDelete+ " != '1' or "+IBOWarnResultValue.S_IsDelete+" is null)";
		if(resource_type!=null&&!resource_type.equals("")){
		//当月终端补贴
		if(resource_type.equals("terminal_cost")&& up_down.equals("up")){
			condition=condition+" order by "+IBOWarnResultValue.S_TerminalCost;
		}
		if(resource_type.equals("terminal_cost")&& up_down.equals("down")){
			condition=condition+" order by "+IBOWarnResultValue.S_TerminalCost+" desc";
		}
		//当月折扣使用
		if(resource_type.equals("action_out")&& up_down.equals("up")){
			condition=condition+" order by "+IBOWarnResultValue.S_ActionOut;
		}
		if(resource_type.equals("action_out")&& up_down.equals("down")){
			condition=condition+" order by "+IBOWarnResultValue.S_ActionOut+" desc";
		}
		//当月促销积分
		if(resource_type.equals("promote_score")&& up_down.equals("up")){
			condition=condition+" order by "+IBOWarnResultValue.S_PromoteScore;
		}
		if(resource_type.equals("promote_score")&& up_down.equals("down")){
			condition=condition+" order by "+IBOWarnResultValue.S_PromoteScore+" desc";
		}
		//当月积分使用
		if(resource_type.equals("sale_point")&& up_down.equals("up")){
			condition=condition+" order by "+IBOWarnResultValue.S_SalePoint;
		}
		if(resource_type.equals("sale_point")&& up_down.equals("down")){
			condition=condition+" order by "+IBOWarnResultValue.S_SalePoint+" desc";
		}
		}
		return condition;
	}
	
	private String getConditionCount(String resource_type,String up_down,String city_code) {
		String condition="1=1";
		if(city_code!=null&&!city_code.equals("")){
			condition = condition+" and "+IBOWarnResultValue.S_CityCode+ "='" +city_code+"'";
		}
		condition = condition +" and ("+ IBOWarnResultValue.S_IsDelete+ " != '1' or "+IBOWarnResultValue.S_IsDelete+" is null)";
		return condition;
	}

	@Override
	public void insert(IBOWarnResultValue vls) throws Exception {
		PreparedStatement ps = null;
		Connection connection =null;
		String sql="insert into warn_result_tocrm(city_code,sale_main_code,sale_main_name,sale_active_code,sale_active_name) " +
				"values(?,?,?,?,?)";
		try{
		connection = ConnectUtil.getConnection();
		ps=connection.prepareStatement(sql);
		ps.setString(1, vls.getCityCode());
		ps.setString(2, vls.getSaleMainCode());
		ps.setString(3, vls.getSaleMainName());
		ps.setString(4, vls.getSaleActiveCode());
		ps.setString(5, vls.getSaleActiveName());
        ps.executeUpdate();
		ConnectUtil.releaseConnection(connection);
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (ps != null)
					ps.close();
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String GetCityCode(String citycode){
		if(citycode == null){
			return null;
		}
		if(citycode.equals("10")){
			citycode="HB";
		}
		if(citycode.equals("15")){
			citycode="HB.ES";
		}
		if(citycode.equals("13")){
			citycode="HB.EZ";
		}
		if(citycode.equals("25")){
			citycode="HB.HG";
		}
		if(citycode.equals("12")){
			citycode="HB.HS";
		}
		if(citycode.equals("18")){
			citycode="HB.JH";
		}
		if(citycode.equals("23")){
			citycode="HB.JM";
		}
		if(citycode.equals("20")){
			citycode="HB.JZ";
		}
		if(citycode.equals("27")){
			citycode="HB.QJ";
		}
		if(citycode.equals("16")){
			citycode="HB.SY";
		}
		if(citycode.equals("24")){
			citycode="HB.SZ";
		}
		if(citycode.equals("28")){
			citycode="HB.TM";
		}
		if(citycode.equals("11")){
			citycode="HB.WH";
		}
		if(citycode.equals("17")){
			citycode="HB.XY";
		}
		if(citycode.equals("26")){
			citycode="HB.XG";
		}
		if(citycode.equals("19")){
			citycode="HB.XN";
		}
		if(citycode.equals("14")){
			citycode="HB.YC";
		}
		
		return citycode;
		
	}
	

}
