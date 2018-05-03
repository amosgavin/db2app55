package com.asiainfo.costWarn.service.interfaces;

import com.asiainfo.costWarn.ivalues.IBOSelectStaffValue;

public interface ISelectStaffSV {
	
    public IBOSelectStaffValue[] selectstaff(String staffid, String staffname, String billid, int startNum, int endNum) throws Exception;
	
	public int countstaff(String staffid, String staffname, String billid) throws Exception;

}
