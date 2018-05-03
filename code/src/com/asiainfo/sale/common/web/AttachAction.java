package com.asiainfo.sale.common.web;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.ai.appframe2.web.fileupload.ApacheUploadTool;
import com.asiainfo.sale.common.bo.BONewAttachBean;
import com.asiainfo.sale.common.ivalues.IBONewAttachValue;
import com.asiainfo.sale.common.service.interfaces.IAttachSV;

public class AttachAction extends BaseAction {

	private transient static Log log = LogFactory.getLog(AttachAction.class);
	private transient static IAttachSV attachSV = (IAttachSV) ServiceFactory
			.getService(IAttachSV.class);

	public void upload(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CustomProperty aCp = CustomProperty.getInstance();
		try {
			// 取回前台ActionUrl中的自定义参数
			int itemId = Integer.parseInt(request.getParameter("itemId"));
			String itemType = HttpUtil.getAsString(request, "itemType");
			String taskId = request.getParameter("taskId");
			int operatorId = (int) SessionManager.getUser().getID();
			// 取回xml数据
			Object[] objs = ApacheUploadTool.getUploadFileInfo(request);
			// save file
			List<FileItem> fileItems = (List<FileItem>) objs[0];
			String aFileNameList = "";
			String ret = "";

			if (fileItems != null && fileItems.size() > 0) {
				for (FileItem fi : fileItems) {
					String[] temp = fi.getName().replace("\\", "/").split("/");
					String fileName = temp[temp.length - 1];
					if(fileName.contains(".doc")||fileName.contains(".docx")||fileName.contains(".xls")
							||fileName.contains(".pdf")||fileName.contains(".txt")||fileName.contains("ppt")){
					ret = attachSV.saveAttach(itemId, fileName, itemType,
							operatorId, taskId, fi);
				// 设定成功返回消息
				aCp.set("FLAG", "Y");
				aCp.set("MSG", ret);
				aCp.set("FILE_NAME_LIST", aFileNameList);
				// 返回成功消息。注意：只需要CustomProperty，不要toXmlString
				ApacheUploadTool.showFileUploadMsg(response, aCp);
				} else {
					aCp.set("MSG", "失败：该文件类型不允许上传");
					ApacheUploadTool.showFileUploadMsg(response, aCp);
				}
				}
			} else {
				aCp.set("FLAG", "NULL");
				aCp.set("MSG", "失败：上传文件为空");
			}

		} catch (Exception ex) {
			// 设定失败返回消息
			aCp.set("FLAG", "N");
			aCp.set("MSG", "失败：" + ex.getMessage());
			// 返回失败消息。注意：只需要CustomProperty，不要toXmlString
			ApacheUploadTool.showFileUploadMsg(response, aCp);
			throw ex;
		}
	}

	public void deleteAttachFile(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CustomProperty cp = CustomProperty.getInstance();
		String idListStr = "0";
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BONewAttachBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}
		IBONewAttachValue[] attachFiles = null;// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BONewAttachBean[]) {
				attachFiles = (BONewAttachBean[]) obj;

				for (IBONewAttachValue attachFile : attachFiles) {

					idListStr += "," + String.valueOf(attachFile.getAttachid());
				}
			}
		}

		try {
			if (null == attachFiles || 0 == attachFiles.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {
				attachSV.deleteAttach(idListStr);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("操作失败", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void downLoadFile(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/*
		 * String idList = new String(request.getParameter("idList").getBytes(
		 * "iso-8859-1"), "gbk");
		 */
		String idList = request.getParameter("idList");
		String[] ids = (idList.trim()).split(",");
		if (ids != null && ids.length != 0) {
			for (int i = 0; i < ids.length; ++i) {
				int id = Integer.parseInt(ids[i]);
				// String fullPath = attachSV.getAttachFilePathById(id);
				String fileName = attachSV.getAttachInfoById(id).getFilename();

				// FileInputStream in = new FileInputStream(fullPath);
				InputStream ins = attachSV.getBfileById(id);

				response.reset();
				response.setContentType("application/x-msdownload");
				// response.setContentType("application/octet-stream");
				String s = "attachment;filename="
						+ URLEncoder.encode(fileName, "UTF-8");
				response.addHeader("Content-Disposition", s);

				/*
				 * ByteArrayOutputStream baos = new ByteArrayOutputStream();
				 * BufferedOutputStream bos = new BufferedOutputStream(baos);
				 * 
				 * BufferedInputStream bis = new BufferedInputStream(in); int
				 * bytesRead = 0; while ((bytesRead = bis.read()) != -1) {
				 * bos.write(bytesRead); } bos.flush(); ServletOutputStream out
				 * = response.getOutputStream(); baos.writeTo(out); out.flush();
				 * // release resource; in.close(); bis.close(); baos.close();
				 * bos.close(); out.close();
				 */
				OutputStream ous = response.getOutputStream();
				try {
					byte[] b = new byte[1024];
					int len = 0;
					while ((len = ins.read(b)) != -1) {
						ous.write(b, 0, len);
					}
				} finally {
					if (ous != null)
						ous.close();
					if (ins != null)
						ins.close();
				}
			}
		}
	}
}
