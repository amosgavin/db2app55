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
		
		//�ն˲����������ǰ����û��Ԥ��ֵ��ֻ��ʾ�ն�ʹ�����������ʾʹ�ý���
		//double currentQuarterValue = ;

		if (actUsedOuts != null && actUsedOuts.length > 0) {
			//ȡǰ���ĵ���
			
			Map discMap = new HashMap();
			Map endpMap = new HashMap();
			for (IBOActualUsedSourceValue actUsed : actUsedOuts) {
				if(actUsed.getCityName() != null && !actUsed.getCityName().equals("") && !actUsed.getCityName().equals("ȫʡ")){
					
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
						cityName += "�ֹ�˾";
						sf.append("��ֹ" + month + "��" + lastDayofMonth + "�գ�" + cityName)
						.append(
								"���ۼ�ʹ���ۿ�" + feeDiscount + "��Ԫ���ѴﵽԤ��ƻ���"
										+ feeDisUsedPro + "%��").append(
								"���ۼ�ʹ���ն˲���" + endPoint + "��Ԫ���ѴﵽԤ��ƻ���"
										+ endPointPro + "%��")
										.append(
								"���л�������" + endPointSub + "Ԫ�������ע��");
					} else {
						
						sf.append("��ֹ" + month + "��" + lastDayofMonth + "�գ�ȫʡ���ۼ�")
						.append(
								"ʹ���ۿ�" + feeDiscount + "��Ԫ���ѴﵽԤ��ƻ���"
								+ feeDisUsedPro + "%�����У�ʹ�ýϿ��ǰ��λ�ֹ�˾�ֱ���" + discMap.get(dicsKey[dicsKey.length-1]) + "��" + discMap.get(dicsKey[dicsKey.length-2]) + "��" + discMap.get(dicsKey[dicsKey.length-3]))
								.append("��ʹ�ý����ĺ���λ�ֹ�˾�ֱ���" + discMap.get(dicsKey[0]) + "��" + discMap.get(dicsKey[1]) + "��" + discMap.get(dicsKey[2]))
								.append(
										"�����ۼ�ʹ���ն˲���" + endPoint + "��Ԫ���ѴﵽԤ��ƻ���"
										+ endPointPro + "%��")
										.append(
												"���л�������" + endPointSub + "Ԫ��ʹ�ýϿ��ǰ��λ�ֹ�˾�ֱ���" + endpMap.get(endpKey[endpKey.length-1]) + "��" + endpMap.get(endpKey[endpKey.length-2]) + "��" + endpMap.get(endpKey[endpKey.length-3]))
												.append("��ʹ�ý����ĺ���λ�ֹ�˾�ֱ���" + endpMap.get(endpKey[0]) + "��" + endpMap.get(endpKey[1]) + "��" + endpMap.get(endpKey[2]))
														.append("�������ע��");
					}
					String[] telphoneAndEmail = getTelphoneAndEmail(cityId);
					if (telphoneAndEmail != null && telphoneAndEmail.length > 0) {

						for (int i = 0; i < telphoneAndEmail.length; ++i) {
							//SendMessage.sendMessage(telphoneAndEmail[i]
									//.split(";")[0], sf.toString());
							//SendMailUtil ss = new SendMailUtil();
							//ss.SendMailBasicUtil(telphoneAndEmail[i].split(";")[1], "�����ۿۡ��ն˲������ۼ�ʵ��ʹ�����Ԥ��", sf.toString(), null);
						
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
			return "�人";
		case 12:
			return "��ʯ";
		case 13:
			return "����";
		case 14:
			return "�˲�";
		case 15:
			return "��ʩ";
		case 16:
			return "ʮ��";
		case 17:
			return "����";
		case 18:
			return "����";
		case 19:
			return "����";
		case 20:
			return "����";
		case 23:
			return "����";
		case 24:
			return "����";
		case 25:
			return "�Ƹ�";
		case 26:
			return "Т��";
		default:
			return "��������";
		}
	}*/
}
