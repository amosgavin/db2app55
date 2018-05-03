package com.asiainfo.costWarn.dao.interfaces;

import com.asiainfo.costWarn.ivalues.IBOSelectStaffValue;

public interface ISelectStaffDAO {

	public IBOSelectStaffValue[] selectstaff(String staffid, String staffname, String billid, int startNum, int endNum) throws Exception;
	
	public int countstaff(String staffid, String staffname, String billid) throws Exception;

}
