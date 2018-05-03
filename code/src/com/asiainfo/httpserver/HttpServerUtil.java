package com.asiainfo.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.costWarn.job.ConnectUtil;
import com.asiainfo.httpserver.pojo.StaffInfo;
import com.asiainfo.sale.common.bo.BOWFOperatorBean;
import com.asiainfo.sale.common.dao.interfaces.IOperatorInfoDAO;
import com.asiainfo.sale.util.StringUtil;

import net.sf.json.JSONObject;

public class HttpServerUtil {

	static public JSONObject isToJson(InputStream is) {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		StringBuffer bf = new StringBuffer();
		String temp = null;
		try {
			while ((temp = br.readLine()) != null) {
				bf.append(temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return JSONObject.fromString(bf.toString());
	}

	static public String codeTranOpId(String code) throws Exception {
		ArrayList<StaffInfo> sfList = getStaffInfoByCode(code);
		if (sfList != null && sfList.size() > 0) {
			return sfList.get(0).getOpId();
		} else {
			return "";
		}
	}

	static public String getStrFromJsByKey(JSONObject js, String key) {
		return js.has(key) ? js.getString(key) : "";
	}

	static public ArrayList<StaffInfo> getStaffInfoByCode(String code) {

		String cd = "select op.operator_id,                                         "
				+ "       dep.organize_id,                                          "
				+ "       op.staff_id,                                              "
				+ "       sf.staff_name,                                            "
				+ "       org.organize_name,                                        "
				+ "       dep.organize_name                                         "
				+ "  from sechb.sec_operator op,                                    "
				+ "       sechb.sec_staff sf,                                       "
				+ "       sechb.sec_organize org,                                   "
				+ "       sechb.sec_organize dep                                    "
				+ " where     op.code = ?                                           "
				+ "       and op.staff_id = sf.staff_id                             "
				+ "       and sf.organize_id = dep.organize_id                      "
				+ "       and substr (dep.organize_id, 1, 2) = org.organize_id      ";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<StaffInfo> sfList = new ArrayList<StaffInfo>();
		try {
			conn = ConnectUtil.getConnection();
			pst = conn.prepareStatement(cd);
			pst.setString(1, code);
			rs = pst.executeQuery();
			while (rs.next()) {
				StaffInfo sf = new StaffInfo();
				sf.setOpId(rs.getString(1));
				sf.setOrgId(rs.getString(2));
				sf.setStaffId(rs.getString(3));
				sf.setStaffName(rs.getString(4));
				sf.setOrgName(rs.getString(5));
				sf.setDepName(rs.getString(6));
				sfList.add(sf);
			}
			rs.close();
			pst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return sfList;
	}

	static public ArrayList<StaffInfo> getStaffInfoByStaffName(String staffNames) {

		ArrayList<StaffInfo> sfList = new ArrayList<StaffInfo>();
		String cd = "select op.operator_id,                                         "
				+ "       dep.organize_id,                                          "
				+ "       op.staff_id,                                              "
				+ "       sf.staff_name,                                            "
				+ "       org.organize_name,                                        "
				+ "       dep.organize_name                                         "
				+ "  from sechb.sec_operator op,                                    "
				+ "       sechb.sec_staff sf,                                       "
				+ "       sechb.sec_organize org,                                   "
				+ "       sechb.sec_organize dep                                    "
				+ " where                                                           "
				+ "       op.staff_id = sf.staff_id                                 "
				+ "       and sf.organize_id = dep.organize_id                      "
				+ "       and substr (dep.organize_id, 1, 2) = org.organize_id      "
				+ "       and (";
		if (StringUtil.isBlank(staffNames.trim())) {
			return null;
		} else {
			for (String sfName : staffNames.split(";")) {
				cd += " sf.staff_name like '%" + sfName + "%' or";
			}
			cd += ")";
			String sql = cd.replace("or)", ")");
			Connection conn = null;
			Statement st = null;
			ResultSet rs = null;

			try {
				conn = ConnectUtil.getConnection();
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while (rs.next()) {
					StaffInfo sf = new StaffInfo();
					sf.setOpId(rs.getString(1));
					sf.setOrgId(rs.getString(2));
					sf.setStaffId(rs.getString(3));
					sf.setStaffName(rs.getString(4));
					sf.setOrgName(rs.getString(5));
					sf.setDepName(rs.getString(6));
					sfList.add(sf);
				}
				rs.close();
				st.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (st != null) {
						st.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return sfList;
	}

	static public ArrayList<StaffInfo> getStaffInfoByRoleId(String roleId,
			String code) {

		ArrayList<StaffInfo> sfList = getStaffInfoByCode(code);
		String orgId = "";
		if (sfList != null && sfList.size() > 0) {
			orgId = sfList.get(0).getOrgId();
		}
		IOperatorInfoDAO operatorInfoDAO = (IOperatorInfoDAO) ServiceFactory
				.getService(IOperatorInfoDAO.class);
		sfList.clear();

		try {
			if ("-2".equals(roleId)) {
				if ("maojingjing".equals(code)) {
					StaffInfo sf1 = new StaffInfo();
					sf1.setDepName("业务部");
					sf1.setOpId("20007430");
					sf1.setOrgId("100101");
					sf1.setOrgName("省业务支撑中心");
					sf1.setStaffName("张尉");
					StaffInfo sf2 = new StaffInfo();
					sf2.setDepName("业务部");
					sf2.setOpId("20004934");
					sf2.setOrgId("100101");
					sf2.setOrgName("省业务支撑中心");
					sf2.setStaffName("肖敏");
					StaffInfo sf3 = new StaffInfo();
					sf3.setDepName("业务部");
					sf3.setOpId("20004916");
					sf3.setOrgId("100101");
					sf3.setOrgName("省业务支撑中心");
					sf3.setStaffName("肖剑");
					StaffInfo sf4 = new StaffInfo();
					sf4.setDepName("业务部");
					sf4.setOpId("20004919");
					sf4.setOrgId("100101");
					sf4.setOrgName("省业务支撑中心");
					sf4.setStaffName("刘辉");
					sfList.add(sf1);
					sfList.add(sf2);
					sfList.add(sf3);
					sfList.add(sf4);
				} else if ("maojingjing".equals(code)) {
					StaffInfo sf1 = new StaffInfo();
					sf1.setDepName("电子渠道部");
					sf1.setOpId("20004938");
					sf1.setOrgId("100103");
					sf1.setOrgName("省业务支撑中心");
					sf1.setStaffName("李莹");
					StaffInfo sf2 = new StaffInfo();
					sf2.setDepName("电子渠道部");
					sf2.setOpId("20004931");
					sf2.setOrgId("100103");
					sf2.setOrgName("省业务支撑中心");
					sf2.setStaffName("张铮");
					StaffInfo sf3 = new StaffInfo();
					sf3.setDepName("电子渠道部");
					sf3.setOpId("20004946");
					sf3.setOrgId("100103");
					sf3.setOrgName("省业务支撑中心");
					sf3.setStaffName("王璨");
					StaffInfo sf4 = new StaffInfo();
					sf4.setDepName("电子渠道部");
					sf4.setOpId("20004947");
					sf4.setOrgId("100103");
					sf4.setOrgName("省业务支撑中心");
					sf4.setStaffName("张雯");
					sfList.add(sf1);
					sfList.add(sf2);
					sfList.add(sf3);
					sfList.add(sf4);
				}
			} else {

				for (BOWFOperatorBean wfOp : operatorInfoDAO.getWFOperatorInfo(
						null, roleId, orgId, 0, -1)) {
					StaffInfo sf = new StaffInfo();
					sf.setOpId(String.valueOf(wfOp.getOperatorId()));
					sf.setOrgId(wfOp.getOrganizeId());
					sf.setStaffId(String.valueOf(wfOp.getStaffId()));
					sf.setStaffName(wfOp.getStaffName());
					sf.setOrgName(wfOp.getOrganizeNameP());
					sf.setDepName(wfOp.getOrganizeName());
					sfList.add(sf);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sfList;
	}
}
