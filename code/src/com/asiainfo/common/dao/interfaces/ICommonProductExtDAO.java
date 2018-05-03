package com.asiainfo.common.dao.interfaces;

import com.asiainfo.charge.ivalues.IBOProductExtDescValue;

public interface ICommonProductExtDAO {

	IBOProductExtDescValue getExtCodeValue(String extType)throws Exception;
	
	public int getMaxExt(String extType)throws Exception;

	void saveAttr(IBOProductExtDescValue[] values)throws Exception;

	int getTypeNum(String extType)throws Exception;

	IBOProductExtDescValue[] getAttr(String codesStr, String extType,
			String staffId)throws Exception;

	IBOProductExtDescValue[] getColsName(String extName, String type,
			String state, String is_can_modify, int startIndex, int endIndex)throws Exception;
	
	public int getColsNameCount(String extName, String type, String state,
			String is_can_modify) throws Exception;

}
