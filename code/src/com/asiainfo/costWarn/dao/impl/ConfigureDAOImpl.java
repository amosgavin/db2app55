package com.asiainfo.costWarn.dao.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils;
import com.asiainfo.costWarn.bo.BOConfigureEngine;
import com.asiainfo.costWarn.dao.interfaces.IConfigureDAO;
import com.asiainfo.costWarn.ivalues.IBOConfigureValue;


public class ConfigureDAOImpl implements IConfigureDAO{

	@Override
	public int count(String city, String staffid,
			String staffname, String bumen, String telphone) throws Exception {
		// TODO Auto-generated method stub
		Map<String,String> param=new HashMap<String, String>();
		param.put("city", city);
		param.put("staffid", staffid);
		param.put("staffname", staffname);
		param.put("bumen", bumen);
		param.put("telphone", telphone);
		return BOConfigureEngine.getBeansCount(getCondition(city, staffid,
				staffname, bumen, telphone), null);
	}

	private String getCondition(String city, String staffid, String staffname,
			String bumen, String telphone) throws Exception {
		// TODO Auto-generated method stub
		String condition="1=1";
		if(city!=null && !city.equals("")){
			condition=condition+" and "+IBOConfigureValue.S_City + "='" +city +"'";
		}
		if(staffid!=null && !staffid.equals("")){
			condition =condition+" and "+IBOConfigureValue.S_Staffid + "='" +staffid +"'";

		}
		if(staffname!=null&& !staffname.equals("")){
			condition=condition+" and "+IBOConfigureValue.S_Staffname + " like '%" + URLDecoder.decode(staffname, "utf-8") +"%'";
		}
		if(bumen!=null&& !bumen.equals("")){
			condition=condition+" and "+IBOConfigureValue.S_Bumen + " like '%" + URLDecoder.decode(bumen, "utf-8") +"%'";
		}
		if(telphone!=null&& !telphone.equals("")){
			condition=condition+" and "+IBOConfigureValue.S_Telphone + "='" +telphone +"'";
		}
		//condition = condition +" and ("+ Itext2Value.S_IsDelete+ " != '1' or "+Itext2Value.S_IsDelete+" is null)";
		return condition;
	}

	@Override
	public IBOConfigureValue[] select(String city, String staffid,
			String staffname, String bumen, String telphone, int startNum,
			int endNum) throws Exception {
		Map<String,String> param=new HashMap<String, String>();
		param.put("city", city);
		param.put("staffid", staffid);
		param.put("staffname", staffname);
		param.put("bumen", bumen);
		param.put("telphone", telphone);
		// TODO Auto-generated method stub
		return BOConfigureEngine.getBeans(null, getCondition(city, staffid,
				staffname, bumen, telphone), null, startNum, endNum, false);
	}

	@Override
	public void save(IBOConfigureValue vl) throws Exception {
		// TODO Auto-generated method stub
		BOConfigureEngine.save(vl);
		
	}

	@Override
	public void deleteconfigure(IBOConfigureValue[] values) throws Exception {
		// TODO Auto-generated method stub
		for (int i = 0; i < values.length; i++){
			values[i].delete();
		}
		BOConfigureEngine.save(values);
	}

	@Override
	public IBOConfigureValue[] getStaffid(String staffid) throws Exception {
		// TODO Auto-generated method stub
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		if (StringUtils.isNotBlank(staffid)){
			condition.append(" AND " + IBOConfigureValue.S_Staffid + " = :staffid");
			parameter.put("staffid", staffid);
		}
		
		return BOConfigureEngine.getBeans(condition.toString(), parameter);
	}

}
