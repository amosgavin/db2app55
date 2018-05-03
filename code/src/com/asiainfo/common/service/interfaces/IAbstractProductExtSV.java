package com.asiainfo.common.service.interfaces;

import com.asiainfo.charge.ivalues.IBOProductExtDescValue;

public interface IAbstractProductExtSV {
	

	public void saveAttr(String extName, String extType, String staffId)
			throws Exception;
	
	public void delAttr(String[] codesArray, String extType, String staffId)
	throws Exception;
	
	public  void saveInitialValues(String extType, String staffId)
	throws Exception;
	
	public IBOProductExtDescValue[] getColsName(String extName, String type,
			String state, String is_can_modify, int startIndex, int endIndex)
			throws Exception;
	
	public int getColsNameCount(String extName, String type, String state,
			String is_can_modify) throws Exception;
	
	
	public IBOProductExtDescValue[] getExtAttrs(String privType)
	throws Exception;
	
	

}
