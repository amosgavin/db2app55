package com.asiainfo.costWarn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asiainfo.costWarn.bo.BOActualUsedSourceEngine;
import com.asiainfo.costWarn.bo.BOCostWarnReceiverEngine;
import com.asiainfo.costWarn.bo.BOCostWarnStaticDataEngine;
import com.asiainfo.costWarn.dao.interfaces.IActualUsedSourceDAO;
import com.asiainfo.costWarn.ivalues.IBOActualUsedSourceValue;
import com.asiainfo.costWarn.ivalues.IBOCostWarnReceiverValue;
import com.asiainfo.costWarn.ivalues.IBOCostWarnStaticDataValue;
import com.asiainfo.costWarn.job.ConnectUtil;
import com.asiainfo.sendMessage.sendEMail.SendMailUtil;
import com.asiainfo.sendMessage.sendSms.SendMessage;

public class ActualUsedSourceDAOImpl implements IActualUsedSourceDAO {

	@Override
	public String sendCostWarn() throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		IBOActualUsedSourceValue[] actUsedOuts = getActualUsedOutSet();
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH);
		int quarter = getQuarter(month);
		cal.set(Calendar.DAY_OF_MONTH, 0);
		int lastDayofMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		//终端补贴，如果当前季度没有预设值，只显示终端使用情况，不显示使用进度
		//double currentQuarterValue = ;

		if (actUsedOuts != null && actUsedOuts.length > 0) {
			//取前三的地市
			
			Map discMap = new HashMap();
			Map endpMap = new HashMap();
			for (IBOActualUsedSourceValue actUsed : actUsedOuts) {
				if(actUsed.getCityName() != null && !actUsed.getCityName().equals("") && !actUsed.getCityName().equals("全省")){
					
					discMap.put(new Double(actUsed.getProgressFee()), actUsed.getCityName());
					endpMap.put(new Double(actUsed.getProgressEndpoint()), actUsed.getCityName());
				}
			}
			Object[] dicsKey =  discMap.keySet().toArray();
			Object[] endpKey =  endpMap.keySet().toArray();
			Arrays.sort(dicsKey);  
			Arrays.sort(endpKey); 
			DecimalFormat format = new DecimalFormat(("#0.0"));
			//System.out.println(dicsKey.length);
			//System.out.println(dicsKey);
			try {
				connection = ConnectUtil.getConnection();
				String sql = "insert into hbsale.send_warn_log (log_id,city_id,target,bill_id,email,line1_value,line2_values,line3_value,content) values(nextval for SEND_SMS_LOG$SEQ,?,?,?,?,?,?,?,?)";
				ps = connection.prepareStatement(sql);
				// rs = ps.executeQuery();

				for (IBOActualUsedSourceValue actUsed : actUsedOuts) {
					String cityId = actUsed.getCityId();
					String cityName = actUsed.getCityName();
					//double saleBase = actUsed.getUsedSalebase();
					//double saleBasePro = actUsed.getProgressSalebase();
					String feeDiscount = format.format(Double.parseDouble(actUsed.getUsedFee()));
					String feeDisUsedPro = format.format(Double.parseDouble(actUsed.getProgressFee()));
					String endPoint = format.format(Double.parseDouble(actUsed.getUsedEndpoint()));
					String endPointPro = format.format(Double.parseDouble(actUsed.getProgressEndpoint()));
					String endPointSub = format.format(actUsed.getZdbt());
					//double jtzdUserCnt = actUsed.getJtZdUserCnt();

					StringBuffer sf = new StringBuffer();
					if (!Integer.valueOf(cityId).equals(10)) {
						cityName += "分公司";
						sf.append("截止" + month + "月" + lastDayofMonth + "日，" + cityName)
						.append(
								"年累计使用折扣" + feeDiscount + "万元，已达到预算计划的"
										+ feeDisUsedPro + "%；").append(
								"年累计使用终端补贴" + endPoint + "万元，已达到预算计划的"
										+ endPointPro + "%，")
										.append(
								"其中户均补贴" + endPointSub + "元，敬请关注。");
					} else {
						
						sf.append("截止" + month + "月" + lastDayofMonth + "日，全省年累计")
						.append(
								"使用折扣" + feeDiscount + "万元，已达到预算计划的"
								+ feeDisUsedPro + "%，其中，使用较快的前三位分公司分别是" + discMap.get(dicsKey[dicsKey.length-1]) + "、" + discMap.get(dicsKey[dicsKey.length-2]) + "、" + discMap.get(dicsKey[dicsKey.length-3]))
								.append("，使用较慢的后三位分公司分别是" + discMap.get(dicsKey[0]) + "、" + discMap.get(dicsKey[1]) + "、" + discMap.get(dicsKey[2]))
								.append(
										"；年累计使用终端补贴" + endPoint + "万元，已达到预算计划的"
										+ endPointPro + "%，")
										.append(
												"其中户均补贴" + endPointSub + "元，使用较快的前三位分公司分别是" + endpMap.get(endpKey[endpKey.length-1]) + "、" + endpMap.get(endpKey[endpKey.length-2]) + "、" + endpMap.get(endpKey[endpKey.length-3]))
												.append("，使用较慢的后三位分公司分别是" + endpMap.get(endpKey[0]) + "、" + endpMap.get(endpKey[1]) + "、" + endpMap.get(endpKey[2]))
														.append("，敬请关注。");
					}
					String[] telphoneAndEmail = getTelphoneAndEmail(cityId);
					if (telphoneAndEmail != null && telphoneAndEmail.length > 0) {

						for (int i = 0; i < telphoneAndEmail.length; ++i) {
							//SendMessage.sendMessage(telphoneAndEmail[i]
									//.split(";")[0], sf.toString());
							//SendMailUtil ss = new SendMailUtil();
							//ss.SendMailBasicUtil(telphoneAndEmail[i].split(";")[1], "话费折扣、终端补贴年累计实际使用情况预警", sf.toString(), null);
						
							//System.out.println(telphoneAndEmail[i] + " " + sf);
							ps.setString(1, cityId);
							ps.setString(2, "F");
							ps.setString(3, telphoneAndEmail[i].split(";")[0]);
							ps.setString(4, telphoneAndEmail[i].split(";")[1]);
							ps.setDouble(5, Double.parseDouble(feeDisUsedPro));
							ps.setDouble(6, 0);
							ps.setDouble(7, Double.parseDouble(endPointPro));
							ps.setString(8, sf.toString());
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

	private IBOActualUsedSourceValue[] getActualUsedOutSet() throws Exception {

		String condition = " 1=1 ";
		return BOActualUsedSourceEngine.getBeans(condition, null);
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

/*	private double getCurrentQuarterValue(int monthId) {
		
		IBOCostWarnStaticDataValue[] costWarnStaticValues = BOCostWarnStaticDataEngine.getBeans(" 1=1 ", null);
		//String condition = select 
		switch (getQuarter(monthId)) {
		case 1 : 
		}
	}*/
	
	private static int getQuarter(int monthId) {
        
        int quarter;
        switch (monthId) {
            case 1:
            case 2:
            case 3:
                quarter = 1;
                break;
            case 4:
            case 5:
            case 6:
                quarter = 2;
                break;
            case 7:
            case 8:
            case 9:
                quarter = 3;
                break;
            case 10:
            case 11:
            case 12:
                quarter = 4;
                break;
            default:
                quarter = 0;
                break;
        }
 
        return quarter;
    }
	
	/*private String cityIdTranToCityName(int cityid) {

		switch (cityid) {

		case 11:
			return "武汉";
		case 12:
			return "黄石";
		case 13:
			return "鄂州";
		case 14:
			return "宜昌";
		case 15:
			return "恩施";
		case 16:
			return "十堰";
		case 17:
			return "襄阳";
		case 18:
			return "江汉";
		case 19:
			return "咸宁";
		case 20:
			return "荆州";
		case 23:
			return "荆门";
		case 24:
			return "随州";
		case 25:
			return "黄冈";
		case 26:
			return "孝感";
		default:
			return "数据有误";
		}
	}*/
}
