package com.asiainfo.charge.dao.interfaces;

import com.asiainfo.charge.ivalues.IBOOptionalPackaegValue;

public interface IOptionalPackageDAO {
	public IBOOptionalPackaegValue[] getOptionalPackaegValues(String id, String name, int startNum,
			int endNum) throws Exception;

	public int getCountOptionalPackaegValues(String id, String name) throws Exception;
}
