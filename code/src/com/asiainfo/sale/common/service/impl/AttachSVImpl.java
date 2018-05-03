package com.asiainfo.sale.common.service.impl;

import java.io.InputStream;

import org.apache.commons.fileupload.FileItem;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.common.dao.interfaces.IAttachDAO;
import com.asiainfo.sale.common.dao.interfaces.INewAttachDAO;
import com.asiainfo.sale.common.ivalues.IBOAttachValue;
import com.asiainfo.sale.common.ivalues.IBONewAttachValue;
import com.asiainfo.sale.common.service.interfaces.IAttachSV;

public class AttachSVImpl implements IAttachSV {

	public void deleteAttachById(int attachId) throws Exception {
		((IAttachDAO) ServiceFactory.getService(IAttachDAO.class))
				.deleteAttachById(attachId);
	}

	public IBOAttachValue[] getAttachByItemId(int itemId, String itemType,
			String fileName) throws Exception {
		return ((IAttachDAO) ServiceFactory.getService(IAttachDAO.class))
				.getAttachByItemId(itemId, itemType, fileName);
	}

	public void saveAttach(IBOAttachValue attach) throws Exception {
		((IAttachDAO) ServiceFactory.getService(IAttachDAO.class))
				.saveAttach(attach);
	}

	public String[] saveAttachInfo(int itemId, String fileName,
			String filePath, String itemType) throws Exception {
		return ((IAttachDAO) ServiceFactory.getService(IAttachDAO.class))
				.saveAttachInfo(itemId, fileName, filePath, itemType);
	}

	public void deleteAttachFiles(IBOAttachValue[] attachFiles)
			throws Exception {
		((IAttachDAO) ServiceFactory.getService(IAttachDAO.class))
				.deleteAttachFiles(attachFiles);
	}

	public String getAttachFilePathById(int id) throws Exception {

		return ((IAttachDAO) ServiceFactory.getService(IAttachDAO.class))
				.getAttachFilePathById(id);
	}

	public IBOAttachValue getAttachById(int id) throws Exception {
		return ((IAttachDAO) ServiceFactory.getService(IAttachDAO.class))
				.getAttachById(id);
	}

	@Override
	public IBOAttachValue[] getAllAttachInfo() throws Exception {

		return ((IAttachDAO) ServiceFactory.getService(IAttachDAO.class))
				.getAllAttachInfo();
	}

	// new attach -----------------------------------------------
	@Override
	public String saveAttach(int itemId, String fileName, String itemType,
			int operatorId, String taskId, FileItem fi) throws Exception {

		return ((INewAttachDAO) ServiceFactory.getService(INewAttachDAO.class))
				.saveAttach(itemId, fileName, itemType, operatorId, taskId, fi);
	}

	@Override
	public void deleteAttach(String idListStr) throws Exception {

		((INewAttachDAO) ServiceFactory.getService(INewAttachDAO.class))
				.deleteAttach(idListStr);
	}

	@Override
	public IBONewAttachValue getAttachInfoById(int id) throws Exception {

		return ((INewAttachDAO) ServiceFactory.getService(INewAttachDAO.class))
				.getAttachInfoById(id);
	}

	@Override
	public InputStream getBfileById(int id) throws Exception {

		return ((INewAttachDAO) ServiceFactory.getService(INewAttachDAO.class))
				.getBfileById(id);
	}

	@Override
	public IBONewAttachValue[] getAttachFileByItemId(int itemId,
			String itemType, int startNum, int endNum) throws Exception {

		return ((INewAttachDAO) ServiceFactory.getService(INewAttachDAO.class))
				.getAttachFileByItemId(itemId, itemType, startNum, endNum);
	}

	@Override
	public int getAttachFileCountByItemId(int itemId, String itemType)
			throws Exception {

		return ((INewAttachDAO) ServiceFactory.getService(INewAttachDAO.class))
				.getAttachFileCountByItemId(itemId, itemType);
	}

}
