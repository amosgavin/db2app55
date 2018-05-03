package com.asiainfo.costWarn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.costWarn.bo.BOCostWarnReceiverEngine;
import com.asiainfo.costWarn.bo.BOSaleLevelSourceEngine;
import com.asiainfo.costWarn.dao.interfaces.ISaleLevelUsedSourceDAO;
import com.asiainfo.costWarn.dao.interfaces.ISendWarnLogDAO;
import com.asiainfo.costWarn.ivalues.IBOCostWarnReceiverValue;
import com.asiainfo.costWarn.ivalues.IBOSaleLevelSourceValue;
import com.asiainfo.costWarn.ivalues.IBOSendWarnLogValue;
import com.asiainfo.costWarn.job.ConnectUtil;
import com.asiainfo.sendMessage.sendEMail.SendMailUtil;
import com.asiainfo.sendMessage.sendSms.SendMessage;

public class SaleLevelUsedSourceDAOImpl implements ISaleLevelUsedSourceDAO {

	@Override
	public String sendCostWarn() throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		// ResultSet rs = null;
		IBOSaleLevelSourceValue[] levelUsedOuts = getSaleLevelUsedOutSet();
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;

		ISendWarnLogDAO logDao = ((ISendWarnLogDAO) ServiceFactory
				.getService(ISendWarnLogDAO.class));

		if (levelUsedOuts != null && levelUsedOuts.length > 0) {
			try {
				connection = ConnectUtil.getConnection();
				String sql = "insert into hbsale.send_warn_log (log_id,city_id,target,level_id,bill_id,email,line1_value,content) values(nextval for SEND_SMS_LOG$SEQ,?,?,?,?,?,?,?)";
				ps = connection.prepareStatement(sql);
				for (IBOSaleLevelSourceValue levelUsed : levelUsedOuts) {
					String cityId = levelUsed.getCityId();
					String cityName = levelUsed.getCityName();
					String saleName = levelUsed.getSaleName();
					String levelCode = levelUsed.getLevelCode();
					String levelName = levelUsed.getLevelName();
					long joinPerson = levelUsed.getPerson();
					// double usedInPre = levelUsed.getProSource();
					// double preTalal = levelUsed.getPreSource();
					double usePro = levelUsed.getProSource();

					IBOSendWarnLogValue[] logs = logDao.getSendedWarnLog(
							(cityId), "L", null, null);
					if (logs != null && logs.length > 0) {
						if (usePro < 80) {
							continue;
						} else if (logs[0].getLine1Value() >= 100) {
							continue;
						}
					}
					StringBuffer sf = new StringBuffer();
					if (!Integer.valueOf(cityId).equals(10)) {
						cityName += "�ֹ�˾";
					}
					sf.append("��ֹ" + month + "�£�").append(
							cityName + saleName + "Ӫ����" + levelName
									+ "�����ۼư����û�" + joinPerson + "�ˣ�").append(
							"�ѴﵽԤ��ֵ��" + usePro + "%��");
					if (usePro < 80) {
						sf.append("�����ע��");
					} else if (usePro < 100) {
						sf.append("��Դ�������꣬���������չ����ע��׷����Դ��");
					} else if (usePro >= 100) {
						sf.append("1���ϵͳ����" + saleName + "Ӫ����" + levelName)
								.append("���ν���ͣ�ۡ���������ؿھ����ͻ�ɱ��������ƹ�����");
					}

					String[] telphoneAndEmail = getTelphoneAndEmail(levelUsed
							.getCityId(), "L", levelCode, null);
					if (telphoneAndEmail != null && telphoneAndEmail.length > 0) {
						for (int i = 0; i < telphoneAndEmail.length; ++i) {

							//SendMessage.sendMessage(telphoneAndEmail[i]
									//.split(";")[0], sf.toString());
							//SendMailUtil ss = new SendMailUtil();
							//ss.SendMailBasicUtil(
									//telphoneAndEmail[i].split(";")[1],
									//"Ӫ���ɱ�Ԥ��", sf.toString(), null);

							//System.out.println(telphoneAndEmail[i] + " " + sf);
							ps.setString(1, cityId);
							ps.setString(2, "L");
							ps.setString(3, "");
							ps.setString(4, telphoneAndEmail[i].split(";")[0]);
							ps.setString(5, telphoneAndEmail[i].split(";")[1]);
							ps.setDouble(6, usePro);
							ps.setString(7, sf.toString());
							ps.addBatch();

						}
					}
				}
				ps.executeBatch();
				ConnectUtil.releaseConnection(connection);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (ps != null)
						ps.close();
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	private IBOSaleLevelSourceValue[] getSaleLevelUsedOutSet() throws Exception {

		String condition = " pro_source >= 60";
		return BOSaleLevelSourceEngine.getBeans(condition, null);
	}

	private String[] getTelphoneAndEmail(String cityId, String target,
			String levelCode, String grade) throws Exception {

		List<String> rets = new ArrayList<String>();
		Connection conn = null;
		ResultSet rs = null;
		try {

			conn = ConnectUtil.getConnection();
			rs = conn
					.createStatement()
					.executeQuery(
							"SELECT bill_id, email FROM sechb.sec_staff WHERE staff_id IN (SELECT staff_id FROM sechb.sec_operator WHERE operator_id IN (SELECT principal FROM sale_main_t WHERE id IN (SELECT sale_id FROM sale_detail_t WHERE level_code = '"
									+ levelCode + "')))");
			if (rs.next()) {
				rets.add(rs.getString("bill_id") + ";" + rs.getString("email"));
			}
			ConnectUtil.releaseConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		String condition = " city_id=" + cityId + " AND TARGET = 'L'";
		IBOCostWarnReceiverValue[] costWarnRecs = BOCostWarnReceiverEngine
				.getBeans(condition, null);
		if (costWarnRecs != null && costWarnRecs.length > 0) {
			for (IBOCostWarnReceiverValue tm : costWarnRecs) {
				rets.add(tm.getBillId() + ";" + tm.getEmail());
			}
		}
		return (String[]) rets.toArray(new String[rets.size()]);
	}
}
