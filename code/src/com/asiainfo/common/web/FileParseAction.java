package com.asiainfo.common.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.action.BaseAction;
import com.ai.appframe2.web.fileupload.ApacheUploadTool;
import com.asiainfo.util.CovertFile;

/**
 * Ŀǰ֧��txt��xls��xlsx
 * 
 * @author Administrator
 * 
 */
public class FileParseAction extends BaseAction {

	private transient static Log log = LogFactory.getLog(FileParseAction.class);

	public void parseFile(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();

		int colNum = 0;
		if (!request.getParameter("colNum").equals(""))
			colNum = Integer.parseInt(request.getParameter("colNum"));
		String confs = "";
		String type = request.getParameter("type");
		try {
			// ȡ��xml����
			Object[] objs = ApacheUploadTool.getUploadFileInfo(request);
			// save file
			List<FileItem> fileItems = (List<FileItem>) objs[0];

			if (fileItems != null && fileItems.size() > 0) {
				for (FileItem fi : fileItems) {
					if (fi.getSize() > (52428800 / 10)) {
						cp.set("FLAG", "N");
						cp.set("MESSAGE", "�ϴ��ļ�����(>5M)��");
						break;
					} else {

						String fileName = fi.getName();
						String fileSuffix = fileName.substring(fileName
								.lastIndexOf("."));
						if (fileSuffix.equals(".txt")) {
							confs = CovertFile.getTXT(fi.getInputStream());
						} else if (fileSuffix.equals(".xls")) {
							confs = CovertFile.extractTextFromXLS(fi
									.getInputStream(), colNum);
						} else if (fileSuffix.equals(".xlsx")) {
							confs = CovertFile.extractTextFromXLS2007(fi
									.getInputStream(), colNum);
						}
						cp.set("TYPE", type);
						cp.set("FLAG", "Y");
						cp.set("confs", confs.replace("'", ""));
						cp.set("MESSAGE", "�����ɹ���");
					}
				}
			}

		} catch (Exception e) {
			// ����ʧ��
			log.error("�����ļ�����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "�����ļ�����" + ":" + e.getMessage());
		} finally {
			ApacheUploadTool.showFileUploadMsg(response, cp);
		}
	}
}
