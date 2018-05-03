package com.asiainfo.mstrcheck.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.jfree.util.Log;
import com.ai.appframe2.common.ServiceManager;
import com.asiainfo.mstrcheck.dao.interfaces.ISzReportDAO;
import com.asiainfo.mstrcheck.util.Encryption;

public class SzReportDAOImpl implements ISzReportDAO {

	public String getXml(String szToken) {

		//System.out.println(szToken);
		StringBuffer stringBuffer = new StringBuffer();
		if (szToken != null && !"".equals(szToken)) {
			try {
				String querySql = "select token,mstr_user from hbsale.mstr_token_info a,mstr.MSTR_USERS b where a.cityname=b.note and token='"
						+ szToken + "'";
				//System.out.println(querySql);

				Connection conn = ServiceManager.getSession().getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(querySql);
				String[] str = new String[2];
				if (rs.next()) {
					str[0] = rs.getString("token");
					str[1] = rs.getString("mstr_user");
				}
				rs.close();
				st.close();
				conn.close();

				if (str != null && str.length > 0) {
					String oldToken = str[0];
					String szUser = str[1];
					Log.debug(szUser);
					if (szUser != null && oldToken != null) {
						String s = Encryption.encrypt(szUser);
						String s1 = Encryption.decrypt(s);
						stringBuffer.append("<?xml version=\"1.0\"?>\r\n");
						stringBuffer.append("<return_code>\r\n");
						stringBuffer.append("<pass userid=\"").append(
								Encryption.encrypt(szUser)).append("\" />\r\n");
						stringBuffer.append("</return_code>\r\n");
					} else {
						stringBuffer.append("<?xml version=\"1.0\"?>\r\n");
						stringBuffer.append("<return_code>\r\n");
						stringBuffer
								.append("<fail msg=\"Cannot validate the token, the token may be invalid or expired.\" />");
						stringBuffer.append("</return_code>\r\n");
					}
				}
			} catch (Exception e) {
				Log.error(e.getMessage());
			}
		}
		//System.out.println(stringBuffer);
		return stringBuffer.toString();
	}

	public void getToken(String orgName, String token) throws Exception{
		
			Connection conn = ServiceManager.getSession().getConnection();
			String sql = "insert into hbsale.mstr_token_info(id,cityname,token) values(hbsale.MSTR_TOKEN_INFO$SEQ.nextval,'"
					+ orgName + "','" + token + "')";
			conn.createStatement().execute(sql);
			// ResultSet rs = st.executeQuery(sql);
			// conn.close();
	}
}