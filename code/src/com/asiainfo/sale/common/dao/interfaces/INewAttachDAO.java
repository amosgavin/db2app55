package com.asiainfo.sale.common.dao.interfaces;

import java.io.InputStream;

import org.apache.commons.fileupload.FileItem;

import com.asiainfo.sale.common.ivalues.IBONewAttachValue;

public interface INewAttachDAO {

	public String saveAttach(int itemId, String fileName, String itemType,
			int operatorId, String taskId, FileItem fi) throws Exception;

	public void deleteAttach(String idListStr) throws Exception;

	public IBONewAttachValue getAttachInfoById(int id) throws Exception;

	public InputStream getBfileById(int id) throws Exception;

	public IBONewAttachValue[] getAttachFileByItemId(int itemId,
			String itemType, int startNum, int endNum) throws Exception;

	public int getAttachFileCountByItemId(int itemId, String itemType)
			throws Exception;
	
	public void cloneAttachByItemIdType(String oldItemId, String newItemId,
			String itemType) throws Exception;
}
