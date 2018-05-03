package com.asiainfo.common.service.impl;

import java.net.URLDecoder;
import java.sql.Timestamp;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.charge.bo.BOProductExtDescBean;
import com.asiainfo.charge.dao.interfaces.IProdInfoQryDAO;
import com.asiainfo.charge.ivalues.IBOProductExtDescValue;
import com.asiainfo.common.dao.interfaces.ICommonProductExtDAO;
import com.asiainfo.common.service.interfaces.IAbstractProductExtSV;

public class AbstractProductExtSVImpl implements IAbstractProductExtSV {
	public boolean checkExceedMax(String extType) throws Exception {
		ICommonProductExtDAO dao = getDao();
		if (!"SALE".equals(extType)) {
			extType = "ALL";
		}
		int num = dao.getTypeNum(extType);
		int maxSize = dao.getMaxExt(extType);
		if (num < maxSize) {
			return false;

		}
		return true;
	}

	public void saveAttr(String extName, String extType, String staffId)
			throws Exception {
		boolean isExceed = checkExceedMax(extType);
		if (isExceed) {
			throw new Exception("新增属性数量已经达到最大，无法新增！");
		} else {
			ICommonProductExtDAO dao = getDao();
			IBOProductExtDescValue value = dao.getExtCodeValue(extType);

			Timestamp current = new Timestamp(System.currentTimeMillis());
			value.setCreateDate(current);
			value.setStaffId(staffId);
			value.setExtName(extName);
			value.setExtType(extType);
			value.setIsCanModify("1");
			value.setState("1");
			IBOProductExtDescValue[] values = new BOProductExtDescBean[1];
			values[0] = value;
			dao.saveAttr(values);

			// 插入初始值
			saveInitialValues(extType, staffId);
		}

	}

	public void delAttr(String[] codesArray, String extType, String staffId)
			throws Exception {
		ICommonProductExtDAO dao = getDao();
		StringBuffer codesStr = new StringBuffer();
		for (int i = 0; i < codesArray.length; i++) {
			codesStr.append("'").append(codesArray[i]).append("'");
			if (i != codesArray.length - 1) {
				codesStr.append(",");
			}
		}
		IBOProductExtDescValue[] values = dao.getAttr(codesStr.toString(),
				extType, staffId);
		if (values.length <= 0) {
			return;
		}
		for (int j = 0; j < values.length; j++) {

			values[j].setState("0");

		}
		dao.saveAttr(values);
	
		
	}

	public ICommonProductExtDAO getDao() throws Exception {

		return (ICommonProductExtDAO) ServiceFactory
				.getService(ICommonProductExtDAO.class);
	}

	public void saveInitialValues(String extType, String staffId)
			throws Exception {
	}

	@Override
	public IBOProductExtDescValue[] getColsName(String extName, String type,
			String state, String is_can_modify, int startIndex, int endIndex)
			throws Exception {
		ICommonProductExtDAO dao = getDao();
		if (null != extName) {
			extName = URLDecoder.decode(extName, "utf-8");
		}
		return dao.getColsName(extName, type, state, is_can_modify, startIndex,
				endIndex);
	}

	@Override
	public int getColsNameCount(String extName, String type, String state,
			String is_can_modify) throws Exception {
		ICommonProductExtDAO dao = getDao();
		if (null != extName) {
			extName = URLDecoder.decode(extName, "utf-8");
		}
		return dao.getColsNameCount(extName, type, state, is_can_modify);
	}

	@Override
	public IBOProductExtDescValue[] getExtAttrs(String privType)
			throws Exception {
		ICommonProductExtDAO dao = getDao();
		if (null == privType || "".equals(privType)) {
			return new BOProductExtDescBean[0];
		}
		return dao.getColsName("", privType, "1", "1", -1, -1);

	}

}
