package com.asiainfo.sale.common.dao.impl;

import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import com.ai.appframe2.util.locale.AppframeLocaleFactory;
import com.asiainfo.sale.common.bo.BOAttachBean;
import com.asiainfo.sale.common.bo.BOAttachEngine;
import com.asiainfo.sale.common.dao.interfaces.IAttachDAO;
import com.asiainfo.sale.common.ivalues.IBOAttachValue;

public class AttachDAOImpl implements IAttachDAO {

	private static String ATTACH_CONFIG = "AttachConfig.xml";
	private static String SYS_ATTACH_SAVE_TYPE = null;
	private static String SYS_ATTACH_SAVE_PATH = null;

	
	public void deleteAttachById(int attachId) throws Exception {

		IBOAttachValue attach = BOAttachEngine.getBean(attachId);
		attach.delete();
		BOAttachEngine.save(attach);
	}

	
	public IBOAttachValue[] getAttachByItemId(int itemId, String itemType, String fileName)
			throws Exception {
		String condition = IBOAttachValue.S_Itemid + "=" + itemId;
		if (itemType != null && itemType != "") {
			condition += " and " + IBOAttachValue.S_ItemType + "=\'" + itemType
					+ "\'";
		}
		if (fileName != null && fileName != "") {
			condition += " and " + IBOAttachValue.S_Filename + "=\'" + fileName
					+ "\'";
		}
		return BOAttachEngine.getBeans(condition, null);
	}

	
	public void saveAttach(IBOAttachValue attach) throws Exception {
		BOAttachEngine.save(attach);
	}

	
	public String[] saveAttachInfo(int itemId, String fileName, String filePath,
			String itemType) throws Exception {
		String[] ret = new String[2];
		if (getAttachByItemId(itemId, null, fileName).length > 0) {
			ret[1] = "请勿选择相同文件！";
		} else {
			IBOAttachValue attachFile = new BOAttachBean();
			String savaPath = getAttachSavePath();
			attachFile.setId(BOAttachEngine.getNewId().intValue());
			attachFile.setItemid(itemId);
			attachFile.setFilename(fileName);
			ret[0] = "id"+attachFile.getId() + "_" + fileName;
			attachFile.setSavename(ret[0]);
			attachFile.setFilepath(savaPath);
			attachFile.setItemType(itemType);
			attachFile.setStsToNew();
			saveAttach(attachFile);
			ret[1] = "上传成功！";
		}
		return ret;
	}

	
	public void deleteAttachFiles(IBOAttachValue[] attachFiles)
			throws Exception {
		for (int i = 0; i < attachFiles.length; i++) {
			attachFiles[i].delete();
		}
		BOAttachEngine.save(attachFiles);
	}

	private static String getAttachSavePath() throws Exception {

		SAXBuilder builder = new SAXBuilder(false);
		Document doc = null;
		try {
			doc = builder.build(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(ATTACH_CONFIG));
		} catch (Exception e) {

			String msg = AppframeLocaleFactory
					.getResource("com.ai.frame.attach.AttachManagerImpl.file_not_found");
			throw new Exception(msg);
		}
		Element root = doc.getRootElement();

		List childList = root.getChildren();
		for (int i = 0; i < childList.size(); ++i) {
			Element childItem = (Element) childList.get(i);
			String name = childItem.getAttributeValue("name");
			String value = childItem.getTextTrim();

			if ("SYS_ATTACH_SAVE_TYPE".equals(name)) {
				SYS_ATTACH_SAVE_TYPE = value;
			} else if ("SYS_ATTACH_SAVE_PATH".equals(name)) {
				SYS_ATTACH_SAVE_PATH = value;
				if ((SYS_ATTACH_SAVE_PATH != null)
						&& (!SYS_ATTACH_SAVE_PATH.equals(""))) {
					SYS_ATTACH_SAVE_PATH += "/";
				}
			}
			/*
			 * SYS_ATTACH_SAVE_PATH =
			 * SessionManager.getRequest().getRealPath("/") + "/" +
			 * SYS_ATTACH_SAVE_PATH;
			 */
		}
		return SYS_ATTACH_SAVE_PATH;
	}

	
	public String getAttachFilePathById(int id) throws Exception {

		IBOAttachValue attachFile = BOAttachEngine.getBean(id);
		if (attachFile != null) {
			return attachFile.getFilepath() + attachFile.getSavename();
		}
		return null;
	}
	
	public IBOAttachValue getAttachById(int id) throws Exception {
		return BOAttachEngine.getBean(id);
	}
	
	public IBOAttachValue[] getAllAttachInfo() throws Exception{
		
		return BOAttachEngine.getBeans(" 1=1 ", null);
	}
}
