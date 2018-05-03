package com.asiainfo.sale.common.service.interfaces;

import java.io.InputStream;

import org.apache.commons.fileupload.FileItem;

import com.asiainfo.sale.common.ivalues.IBOAttachValue;
import com.asiainfo.sale.common.ivalues.IBONewAttachValue;

public interface IAttachSV {

	public void saveAttach(IBOAttachValue attach) throws Exception;

	public IBOAttachValue getAttachById(int id) throws Exception;

	public IBOAttachValue[] getAttachByItemId(int itemId, String itemType,
			String fileName) throws Exception;

	public void deleteAttachById(int attachId) throws Exception;

	public void deleteAttachFiles(IBOAttachValue[] attachFiles)
			throws Exception;

	public String[] saveAttachInfo(int itemId, String fileName,
			String filePath, String itemType) throws Exception;

	public IBOAttachValue[] getAllAttachInfo() throws Exception;
	
	// new attach -----------------------------------------------
	public String getAttachFilePathById(int id) throws Exception;

	public String saveAttach(int itemId, String fileName, String itemType,
			int operatorId, String taskId, FileItem fi) throws Exception;

	public void deleteAttach(String idListStr) throws Exception;

	public IBONewAttachValue getAttachInfoById(int id) throws Exception;

	public InputStream getBfileById(int id) throws Exception;

	public IBONewAttachValue[] getAttachFileByItemId(int itemId,
			String itemType, int startNum, int endNum) throws Exception;

	public int getAttachFileCountByItemId(int itemId, String itemType)
			throws Exception;
}
