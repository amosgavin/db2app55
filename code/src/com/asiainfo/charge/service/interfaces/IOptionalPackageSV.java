package com.asiainfo.charge.service.interfaces;

import com.asiainfo.charge.ivalues.IBOOptionalPackaegValue;

public interface IOptionalPackageSV {
	public IBOOptionalPackaegValue[] getOptionalPackaegValues(String id, String name, int startNum,
			int endNum) throws Exception, RuntimeException;

	public int getCountOptionalPackaegValues(String id, String name) throws Exception, RuntimeException;
}
