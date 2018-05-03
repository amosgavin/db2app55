package com.asiainfo.sale.common.dao.interfaces;

import com.asiainfo.sale.common.ivalues.IBOAttachValue;

public interface IAttachDAO {

	public void saveAttach(IBOAttachValue attach) throws Exception;

	public IBOAttachValue getAttachById(int id) throws Exception;

	public IBOAttachValue[] getAttachByItemId(int itemId, String itemType,
			String fileName) throws Exception;

	public void deleteAttachById(int attachId) throws Exception;

	public void deleteAttachFiles(IBOAttachValue[] attachFiles)
			throws Exception;

	public String[] saveAttachInfo(int itemId, String fileName,
			String filePath, String itemType) throws Exception;

	public String getAttachFilePathById(int id) throws Exception;
	
	public IBOAttachValue[] getAllAttachInfo() throws Exception;

}
