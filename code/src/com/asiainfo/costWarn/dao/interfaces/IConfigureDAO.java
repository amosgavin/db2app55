package com.asiainfo.costWarn.dao.interfaces;

import com.asiainfo.costWarn.ivalues.IBOConfigureValue;

public interface IConfigureDAO {

    public IBOConfigureValue[] select(String city, String staffid, String staffname, String bumen, String telphone, int startNum, int endNum) throws Exception;
	
	public int count(String city, String staffid, String staffname, String bumen, String telphone) throws Exception;

	public void save(IBOConfigureValue vl) throws Exception;

	public void deleteconfigure(IBOConfigureValue[] values) throws Exception;

	public IBOConfigureValue[] getStaffid(String staffid) throws Exception;

}
