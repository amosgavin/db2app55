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
import com.asiainfo.costWarn.bo.BOPreUsedSourceEngine;
import com.asiainfo.costWarn.dao.interfaces.IPreUsedSourceDAO;
import com.asiainfo.costWarn.dao.interfaces.ISendWarnLogDAO;
import com.asiainfo.costWarn.ivalues.IBOCostWarnReceiverValue;
import com.asiainfo.costWarn.ivalues.IBOPreUsedSourceValue;
import com.asiainfo.costWarn.ivalues.IBOSendWarnLogValue;
import com.asiainfo.costWarn.job.ConnectUtil;
import com.asiainfo.sendMessage.sendEMail.SendMailUtil;
import com.asiainfo.sendMessage.sendSms.SendMessage;

public class PreUsedSourceDAOImpl implements IPreUsedSourceDAO {

	@Override
	public String sendCostWarn() throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		IBOPreUsedSourceValue[] preUsedOuts = getPreUsedOutSet();
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);

		ISendWarnLogDAO logDao = ((ISendWarnLogDAO) ServiceFactory
				.getService(ISendWarnLogDAO.class));

		if (preUsedOuts != null && preUsedOuts.length > 0) {
			try {
				connection = ConnectUtil.getConnection();
				String sql = "insert into hbsale.send_warn_log (log_id,city_id,target,bill_id,email,line1_value,content) values(nextval for SEND_SMS_LOG$SEQ,?,?,?,?,?,?)";
				ps = connection.prepareStatement(sql);

				for (int i = 0; i < preUsedOuts.length; ++i) {
					IBOPreUsedSourceValue preUsed = preUsedOuts[i];
					String cityId = preUsed.getCityId();
					String cityName = preUsed.getCityName();
					// double preFeeDisc = preUsed.getPrePrefee();
					double usedFeeDiscount = preUsed.getUsedPrefee();
					double feeDisUsedPro = preUsed.getProgressPrefee();

					IBOSendWarnLogValue[] logs = logDao.getSendedWarnLog(
							(cityId), "P", null, null);
					if (logs != null && logs.length > 0) {
						if (feeDisUsedPro < 80) {
							continue;
						} else if (feeDisUsedPro >= 80 && feeDisUsedPro < 100
								&& logs[0].getLine1Value() >= 80) {
							continue;
						} else if (logs[0].getLine1Value() >= 100) {
							continue;
						}
					}

					StringBuffer sf = new StringBuffer();
					if (!Integer.valueOf(cityId).equals(10)) {
						cityName += "分公司";
					}
					sf.append("截止" + month + "月" + day + "日，").append(
							cityName + "话费折扣预计使用" + usedFeeDiscount + "万元，已达到预算值的"
									+ feeDisUsedPro + "%，");
					if (feeDisUsedPro < 80) {
						sf.append("敬请关注。");
					} else if (feeDisUsedPro < 100) {
						sf.append("请注意资源的合理使用。");
					} else if (feeDisUsedPro >= 100) {
						sf.append("已经超预算。");
					}
					String[] telphoneAndEmail = getTelphoneAndEmail(String
							.valueOf(preUsed.getCityId()));
					if (telphoneAndEmail != null && telphoneAndEmail.length > 0) {
						for (int i1 = 0; i1 < telphoneAndEmail.length; ++i1) {

							//SendMessage.sendMessage(telphoneAndEmail[i]
									//.split(";")[0], sf.toString());
							//SendMailUtil ss = new SendMailUtil();
							//ss.SendMailBasicUtil(
									//telphoneAndEmail[i].split(";")[1],
									//"营销成本预警", sf.toString(), null);

							//System.out.println(telphoneAndEmail[i1] + " " + sf);
							ps
									.setString(1, String.valueOf(preUsed
											.getCityId()));
							ps.setString(2, "P");
							ps.setString(3, telphoneAndEmail[i1].split(";")[0]);
							ps.setString(4, telphoneAndEmail[i1].split(";")[1]);
							ps.setDouble(5, feeDisUsedPro);
							ps.setString(6, sf.toString());
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
					if (rs != null)
						rs.close();
					if (ps != null)
						ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return null;
	}

	private IBOPreUsedSourceValue[] getPreUsedOutSet() throws Exception {

		String condition = " progress_prefee >= 60";
		return BOPreUsedSourceEngine.getBeans(condition, null);
	}

	private String[] getTelphoneAndEmail(String cityId) throws Exception {

		List<String> rets = new ArrayList<String>();
		String condition = " city_id=" + cityId;
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
