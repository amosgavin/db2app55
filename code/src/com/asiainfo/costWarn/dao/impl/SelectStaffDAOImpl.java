package com.asiainfo.costWarn.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.asiainfo.costWarn.bo.BOSelectStaffEngine;
import com.asiainfo.costWarn.dao.interfaces.ISelectStaffDAO;
import com.asiainfo.costWarn.ivalues.IBOSelectStaffValue;

public class SelectStaffDAOImpl implements ISelectStaffDAO{

	@Override
	public int countstaff(String staffid, String staffname, String billid)
			throws Exception {
		// TODO Auto-generated method stub
		Map<String,String> param=new HashMap<String, String>();
		param.put("staffid", staffid);
		param.put("staffname", staffname);
		param.put("billid", billid);
		return BOSelectStaffEngine.getBeansCount(getCondition(staffid,
				staffname, billid), null);
	}

	@Override
	public IBOSelectStaffValue[] selectstaff(String staffid, String staffname,
			String billid, int startNum, int endNum) throws Exception {
		// TODO Auto-generated method stub
		Map<String,String> param=new HashMap<String, String>();
		param.put("staffid", staffid);
		param.put("staffname", staffname);
		param.put("billid", billid);
		return BOSelectStaffEngine.getBeans(null, getCondition(staffid,
				staffname, billid), null, startNum, endNum, false);
	}

	private String getCondition(String staffid, String staffname,
			String billid) {
		// TODO Auto-generated method stub
		String condition="1=1";
		if(staffid!=null && !staffid.equals("")){
			condition=condition+" and "+IBOSelectStaffValue.S_StaffId + "=" +staffid;
		}
		if(staffname!=null&& !staffname.equals("")){
			condition=condition+" and "+IBOSelectStaffValue.S_StaffName + "=" +staffname;
		}
		if(billid!=null&& !billid.equals("")){
			condition=condition+" and "+IBOSelectStaffValue.S_BillId + "=" +billid;
		}
		//condition = condition +" and ("+ Itext2Value.S_IsDelete+ " != '1' or "+Itext2Value.S_IsDelete+" is null)";
		return condition;
	}

}
