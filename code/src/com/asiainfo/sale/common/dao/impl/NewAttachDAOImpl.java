package com.asiainfo.sale.common.dao.impl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.fileupload.FileItem;

import com.ai.appframe2.common.ServiceManager;
import com.asiainfo.sale.common.bo.BOAttachEngine;
import com.asiainfo.sale.common.bo.BONewAttachEngine;
import com.asiainfo.sale.common.dao.interfaces.INewAttachDAO;
import com.asiainfo.sale.common.ivalues.IBONewAttachValue;

public class NewAttachDAOImpl implements INewAttachDAO {

	@Override
	public String saveAttach(int itemId, String fileName, String itemType,
			int operatorId, String taskId, FileItem fi) throws Exception {

		String ret = "";
		if (hasSameFile(itemId, itemType, fileName)) {
			ret = "请勿选择相同文件！";
		} else {

			if (fi.getSize() > (52428800 / 5)) {
				// System.out.println(fi.getSize());
				ret = "上传文件大于最大上传10M";
				return ret;
			}
			Connection conn = ServiceManager.getSession().getConnection();
			String sql = "insert into attach_file_t(id, filename, itemid, item_type, operator_id, task_id, bfile) values(?,?,?,?,?,?,?)";
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, BOAttachEngine.getNewId().intValue());
			ps.setString(2, fileName);
			ps.setInt(3, itemId);
			ps.setString(4, itemType);
			ps.setInt(5, operatorId);
			ps.setString(6, taskId);
			ps.setBinaryStream(7, fi.getInputStream(), (int) fi.getSize());
			ps.executeUpdate();
			ps.close();
			conn.close();
			ret = "上传成功！";
		}
		return ret;
	}

	private boolean hasSameFile(int itemId, String itemType, String fileName)
			throws Exception {

		String condition = IBONewAttachValue.S_Itemid + "=" + itemId;
		condition += " and " + IBONewAttachValue.S_Filename + "=\'" + fileName
				+ "\'" + " and " + IBONewAttachValue.S_Itemtype + "=\'"
				+ itemType + "\'";

		return (BONewAttachEngine.getBeans(condition, null).length > 0) ? true
				: false;
	}

	@Override
	public void deleteAttach(String idListStr) throws Exception {

		Connection conn = ServiceManager.getSession().getConnection();
		String sql = "DELETE FROM ATTACH_FILE_T WHERE ID IN (" + idListStr
				+ ")";

		Statement st = conn.createStatement();
		st.execute(sql);
		st.close();
		conn.close();
	}

	@Override
	public IBONewAttachValue getAttachInfoById(int id) throws Exception {

		return BONewAttachEngine.getBean(id);
	}

	@Override
	public InputStream getBfileById(int id) throws Exception {

		Connection conn = ServiceManager.getSession().getConnection();
		String sql = "SELECT BFILE FROM ATTACH_FILE_T WHERE ID = " + id;
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {

			InputStream re = rs.getBinaryStream("bfile");// rs.getBlob("BFILE").getBinaryStream();
			return re;
		}
		rs.close();
		st.close();
		conn.close();
		return null;
	}

	@Override
	public IBONewAttachValue[] getAttachFileByItemId(int itemId,
			String itemType, int startNum, int endNum) throws Exception {

		String condition = IBONewAttachValue.S_Itemid + "=" + itemId + " and "
				+ IBONewAttachValue.S_Itemtype + "=\'" + itemType
				+ "\' order by upload_time";
		return BONewAttachEngine.getBeans(null, condition, null, startNum,
				endNum, false);
	}

	@Override
	public int getAttachFileCountByItemId(int itemId, String itemType)
			throws Exception {

		String condition = IBONewAttachValue.S_Itemid + "=" + itemId + " and "
				+ IBONewAttachValue.S_Itemtype + "=\'" + itemType + "\'";
		return BONewAttachEngine.getBeansCount(condition, null);
	}

	@Override
	public void cloneAttachByItemIdType(String oldItemId, String newItemId,
			String itemType) throws Exception {
		
		Connection conn = ServiceManager.getSession().getConnection();
	    String sql = "insert into attach_file_t (select nextval for SALE_ATTACH_T$SEQ,filename,?,item_type,operator_id,task_id,bfile,upload_time from ATTACH_FILE_T where ITEMID=?)";
	    java.sql.PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, Integer.parseInt(newItemId));
		ps.setInt(2, Integer.parseInt(oldItemId));
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
}
