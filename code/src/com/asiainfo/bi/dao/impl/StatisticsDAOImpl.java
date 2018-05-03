package com.asiainfo.bi.dao.impl;

import com.asiainfo.bi.bo.BOStatisticsEngine;
import com.asiainfo.bi.bo.BOTaskDurationCountEngine;
import com.asiainfo.bi.bo.BOTaskDurationEngine;
import com.asiainfo.bi.dao.interfaces.IStatisticsDAO;
import com.asiainfo.bi.ivalues.IBOStatisticsValue;
import com.asiainfo.bi.ivalues.IBOTaskDurationCountValue;
import com.asiainfo.bi.ivalues.IBOTaskDurationValue;

public class StatisticsDAOImpl implements IStatisticsDAO {

	@Override
	public IBOStatisticsValue[] getStatistics(String objectType)
			throws Exception {

		String tabName = "";
		if (objectType.equals("weapon")) {
			tabName = "view_weapon_statistics";
		} else if (objectType.equals("saleM")) {
			tabName = "view_salem_statistics";
		} else if (objectType.equals("saleD")) {
			tabName = "view_saled_statistics";
		} else if (objectType.equals("chargeM")) {
			tabName = "view_chargem_statistics";
		} else if (objectType.equals("chargeD")) {
			tabName = "view_charged_statistics";
		}
		String condition = "SELECT org_id, a1, a2, a3, a FROM (SELECT org_id, max (s1) a1, max (s2) a2, max (s3) a3, sum (s1 + s2 + s3) a  FROM "
				+ tabName
				+ " GROUP BY org_id UNION ALL SELECT 2000, sum (s1), sum (s2), sum (s3), sum (s1 + s2 + s3) FROM "
				+ tabName + ") order BY org_id";
		return BOStatisticsEngine.getBeansFromSql(condition, null);
	}

	@Deprecated
	public IBOTaskDurationValue[] getTaskDuration(String objectType)
			throws Exception {

		String condition = "";
		if (objectType.equals("sale")) {
			condition = "SELECT region_id, avg_time1, avg_time2, avg_time3, avg_time4, avg_time5 "
					+ "FROM (SELECT region_id, avg_time1, avg_time2, avg_time3, avg_time4, avg_time5 "
					+ "FROM view_duration_sale_t "
					+ "UNION ALL "
					+ "SELECT '1003', vsi.avg_time1, vsi.avg_time2, vsi.avg_time3, vsi.avg_time4, vsi.avg_time5 FROM VIEW_DURATION_SALE_I vsi "
					+ "UNION ALL SELECT '1005', vsp.avg_time1, null, vsp.avg_time2, null, null FROM VIEW_DURATION_SALE_p vsp) "
					+ "order BY INT(REGION_ID)";
		} else if (objectType.equals("charge")) {
			condition = "select s.code_id region_id,t.avg_time1,t.avg_time2,t.avg_time3,t.avg_time4,t.avg_time5 "
					+ "from (select code_id from sale_static_data where code_type ='statisticsArea' and code_id<>'2000') s "
					+ "left join (SELECT region_id, avg_time1, avg_time2, avg_time3, avg_time4, avg_time5 FROM "
					+ "(SELECT region_id, avg_time1, avg_time2, avg_time3, avg_time4, avg_time5 FROM view_duration_charge_t "
					+ "UNION ALL SELECT '1005', vcp.avg_time1, null, vcp.avg_time2, vcp.avg_time3, null FROM VIEW_DURATION_charge_p vcp)) t "
					+ "on s.code_id=t.region_id order by int(region_id)";
		}
		return BOTaskDurationEngine.getBeansFromSql(condition, null);
	}

	@Deprecated
	public IBOTaskDurationCountValue[] getTaskDurationCount(String objectType)
			throws Exception {

		String condition = "";
		if (objectType.equals("sale")) {
			condition = "SELECT region_id, nbsh, scb, hdpz, yzpz, qrsx, pass, false, total FROM HBSALE.view_workflow_circle_query "
					+ " WHERE workflow_object_type IN ('saleCaseT', 'saleCaseI') UNION ALL "
					+ " SELECT 1005, nbsh, scb, hdpz, yzpz, qrsx, pass, false, total FROM HBSALE.view_workflow_circle_query "
					+ " WHERE workflow_object_type = 'saleCase' UNION ALL "
					+ " SELECT 2000, sum (nbsh), sum (scb), sum (hdpz), sum (yzpz), sum (qrsx), sum (pass), sum (false), sum (total) FROM "
					+ " (SELECT region_id, nbsh, scb, hdpz, yzpz, qrsx, pass, false, total FROM HBSALE.view_workflow_circle_query "
					+ " WHERE workflow_object_type IN ('saleCaseT', 'saleCaseI') UNION ALL "
					+ " SELECT 1005, nbsh, scb, hdpz, yzpz, qrsx, pass, false, total FROM HBSALE.view_workflow_circle_query "
					+ " WHERE workflow_object_type = 'saleCase' ) ORDER BY region_id";
		} else if (objectType.equals("charge")) {
			condition = "SELECT region_id, nbsh, scb, hdpz, yzpz, qrsx, pass, false, total FROM HBSALE.view_workflow_circle_query "
					+ " WHERE workflow_object_type ='chargeCaseT' UNION ALL "
					+ " SELECT 1005, nbsh, scb, hdpz, yzpz, qrsx, pass, false, total FROM HBSALE.view_workflow_circle_query "
					+ " WHERE workflow_object_type = 'chargeCase' UNION ALL "
					+ " SELECT 2000, sum (nbsh), sum (scb), sum (hdpz), sum (yzpz), sum (qrsx), sum (pass), sum (false), sum (total) FROM "
					+ " (SELECT region_id, nbsh, scb, hdpz, yzpz, qrsx, pass, false, total FROM HBSALE.view_workflow_circle_query "
					+ " WHERE workflow_object_type IN ('chargeCaseT', 'chargeCaseI') UNION ALL "
					+ " SELECT 1005, nbsh, scb, hdpz, yzpz, qrsx, pass, false, total FROM HBSALE.view_workflow_circle_query "
					+ " WHERE workflow_object_type = 'chargeCase' ) ORDER BY region_id";
		}
		return BOTaskDurationCountEngine.getBeansFromSql(condition, null);
	}

	@Override
	public IBOTaskDurationValue[] getProcessNodeAvgTime(String objectType,
			String startTimeFrom, String startTimeTo) throws Exception {

		return BOTaskDurationEngine.getBeansFromSql(
				getProcessNodeAvgTimeQuerySql(objectType, startTimeFrom,
						startTimeTo), null);
	}

	private String getProcessNodeAvgTimeQuerySql(String objectType,
			String startTimeFrom, String startTimeTo) {

		StringBuffer sb = new StringBuffer();
		String startTime = "";
		String[] midConditon = {
				"select col1.region_id,avg_time1,avg_time2,avg_time3,avg_time4,avg_time5 from ",
				" union select 1003,avg_time1,avg_time2,avg_time3,avg_time4,avg_time5 from ",
				" union select 1005,avg_time1,null,avg_time2,null,null from " };
		String nodeNames[][] = { { "st1", "st2", "st3", "st4", "st5" },
				{ "si1", "si2", "si3", "si4", "si5" }, { "sp1", "sp2" } };
		if (objectType.equals("charge")) {
			String charngNodeNames[][] = {
					{ "ct1", "ct2", "ct3", "ct4", "ct5" }, {},
					{ "cp1", "cp2", "cp3" } };
			nodeNames = charngNodeNames;
			midConditon[1] = "";
			midConditon[2] = " union select 1005,avg_time1,null,avg_time2,avg_time3,null from ";
		}
		System.out.println(startTimeFrom + ":" + startTimeTo);
		if (startTimeFrom != null && !startTimeFrom.equals("")
				&& startTimeTo != null && !startTimeTo.equals("")) {
			startTime = " and create_date between  '" + startTimeFrom
					+ "' and '" + startTimeTo + "'";
		} else if (startTimeFrom != null && !startTimeFrom.equals("")) {
			startTime = " and create_date >= '" + startTimeFrom + "'";
		} else if (startTimeTo != null && !startTimeTo.equals("")) {
			startTime = " and create_date <= '" + startTimeTo + "'";
		}
		for (int i = 0; i < nodeNames.length; ++i) {
			sb.append(midConditon[i]);
			for (int j = 0; j < nodeNames[i].length; ++j) {
				String tmpCondition = "";
				if (j == 0) {
					tmpCondition = " (select region_id,dec(avg(timestampdiff(8, char ("
							+ nodeNames[i][j]
							+ " - create_date))/ 24.0),8,1) "
							+ "avg_time1 from view_process_time where "
							+ nodeNames[i][j]
							+ " is not null "
							+ startTime
							+ " group by region_id ) col1";
				} else {
					tmpCondition = " left join (select region_id,dec(avg(timestampdiff(8, char ("
							+ nodeNames[i][j]
							+ "-"
							+ nodeNames[i][j - 1]
							+ "))/ 24.0),8,1) "
							+ "avg_time"
							+ (j + 1)
							+ " from view_process_time where "
							+ nodeNames[i][j]
							+ " is not null and "
							+ nodeNames[i][j - 1]
							+ " is not null "
							+ startTime
							+ " group by region_id) col"
							+ (j + 1)
							+ " on col"
							+ (j + 1) + ".region_id=col1.region_id";
				}
				sb.append(tmpCondition);

			}
		}
		return sb.append(" order by region_id ").toString();
	}

	private String getProcessNodeTaskCountQueryTempTable(String startTimeFrom,
			String startTimeTo) {

		String createDateCondition = getCreateDateCondition(startTimeFrom,
				startTimeTo);
		//System.out.println(createDateCondition);
		String processNodeTaskCountQueryTempTable = " select region_id,workflow_object_type,sum(nbsh) nbsh,sum(scb) scb,sum(hdpz) hdpz,sum(yzpz) yzpz,sum(qrsx) qrsx,sum(pass) pass,sum(false) false, sum(nbsh)+sum(scb)+sum(hdpz)+sum(yzpz)+sum(qrsx)+sum(pass)+sum(false) total "
				+ " from( "
				+ " select (case when workflow_object_type='saleCaseI' then '1003' when workflow_object_type in ('saleCase','chargeCase') then '1005' else region_id "
				+ " end) region_id,workflow_object_type, nbsh, scb, hdpz, yzpz,qrsx, pass, false "
				+ " from( "
				+ " select a.region_id,a.workflow_object_type,count(1) nbsh,0 scb,0 hdpz,0 yzpz,0 qrsx,0 pass,0 false "
				+ " from vm_wf a,vm_task b "
				+ " where a.workflow_id=b.workflow_id "
				+ createDateCondition
				+ " and b.task_tag in('t01' ,'t02','t17','t18','t19','t20','t03' ,'t04','C001', 'C004','C003','C006','C007','C008','C009', 'C005','C010', 'sign01', 'p01','S001','PC001', 'I001','I002','I004','A01','A02') group by a.region_id,workflow_object_type "
				+ " union all "
				+ " select a.region_id,a.workflow_object_type,0 nbsh,count(1) scb,0 hdpz,0 yzpz,0 qrsx,0 pass,0 false "
				+ " from vm_wf a,vm_task b "
				+ " where a.workflow_id=b.workflow_id "
				+ createDateCondition
				+ " and b.task_tag in('w01' ,'sign01' ,'w02','t06' ,'t07' ,'t08','t0010','sign01','t05' ,'t09','t10' ,'t11','t12','sign02','sign03', 'C012','S003','C013','C014','C015','S004','C016', 'p02','p02','p03','sign02','p08','sign03','p09', 'PC002','PC003','PC004','S002', 'I005','I006','I008','I007','SI001', 'I009','I010','I011','SI002','SI003', 'I013','I012','A03' ,'A05' ,'SA01','A09' ) group by a.region_id,workflow_object_type "
				+ " union all "
				+ " select a.region_id,a.workflow_object_type,0 nbsh,0 scb,count(1) hdpz ,0 yzpz,0 qrsx,0 pass,0 false "
				+ " from vm_wf a,vm_task b "
				+ " where a.workflow_id=b.workflow_id "
				+ createDateCondition
				+ " and b.task_tag in('t0001','t0002','t15','t0014','t0023', 't0003','t0015','t0004','t0005','t0006','sign0001', 't0007','t0011','t0024''t0017','t0018','t0019','t0020', 't0015','t0021','t0022', 'C25','C26','C27','C28', 'PC008','PC010', 'I014','I015','I016','I028','I029','I030','I017','I018','I019','I031' ,'I021','I020','I032','I022','I033' ,'I035','I034','SI004' ) group by a.region_id,workflow_object_type "
				+ " union all "
				+ " select a.region_id,a.workflow_object_type,0 nbsh,0 scb,0 hdpz,count(1) yzpz,0 qrsx,0 pass,0 false "
				+ " from vm_wf a,vm_task b "
				+ " where a.workflow_id=b.workflow_id "
				+ createDateCondition
				+ " and b.task_tag in('w04' ,'w05''t0008','t0009','13','21', 'C017','C018','C032','C019','C021','C031''p04' ,'p12','p05','p06','p13','p14','p17', 'PC005','PC023', 'PC006','PC007','PC015','PC014','PC011','PC009', 'PC012','PC013','PC022', 'I023','I025','I024', 'A04' ,'A06','A07' ) group by a.region_id,workflow_object_type "
				+ " union all "
				+ " select a.region_id,a.workflow_object_type,0 nbsh,0 scb,0 hdpz,0 yzpz,count(1) qrsx ,0 pass,0 false "
				+ " from vm_wf a,vm_task b "
				+ " where a.workflow_id=b.workflow_id "
				+ createDateCondition
				+ " and b.task_tag in('t14','sign04','t0013', 'C022','S004','C023' ,'C030', 'p07','I026','SI005','I027','A08') group by a.region_id,workflow_object_type "
				+ " union all "
				+ " select a.region_id,a.workflow_object_type,0 nbsh,0 scb,0 hdpz,0 yzpz,0 qrsx,count(1) pass,0 false "
				+ " from h_vm_wf a,h_vm_task b "
				+ " where a.workflow_id=b.workflow_id "
				+ createDateCondition
				+ " and b.task_tag in('A08','I027','C030','t0013','PC022','p07','w05') group by a.region_id,workflow_object_type "
				+ " union all "
				+ " select a.region_id,a.workflow_object_type,0 nbsh,0 scb,0 hdpz,0 yzpz,0 qrsx,0 pass,count(1) false "
				+ " from h_vm_wf a,h_vm_task b "
				+ " where a.workflow_id=b.workflow_id "
				+ createDateCondition
				+ " and b.task_tag in('A02','A09','I003','PC021','p11','C029','t0012') group by a.region_id,workflow_object_type )"
				+ ") group by region_id,workflow_object_type";
		return processNodeTaskCountQueryTempTable;
	}

	private String getCreateDateCondition(String startTimeFrom,
			String startTimeTo) {

		if (startTimeFrom != null && !startTimeFrom.equals("")
				&& startTimeTo != null && !startTimeTo.equals("")) {
			return " and a.create_date between  '" + startTimeFrom + "' and '"
					+ startTimeTo + "'";
		} else if (startTimeFrom != null && !startTimeFrom.equals("")) {
			return " and a.create_date >= '" + startTimeFrom + "'";
		} else if (startTimeTo != null && !startTimeTo.equals("")) {
			return " and a.create_date <= '" + startTimeTo + "'";
		}
		return "";
	}

	@Override
	public IBOTaskDurationCountValue[] getProcessNodeTaskCount(
			String objectType, String startTimeFrom, String startTimeTo)
			throws Exception {

		String condition = "";
		String tempTable = getProcessNodeTaskCountQueryTempTable(startTimeFrom,
				startTimeTo);
		if (objectType.equals("sale")) {
			condition = "SELECT region_id, nbsh, scb, hdpz, yzpz, qrsx, pass, false, total FROM ("
					+ tempTable
					+ ") WHERE workflow_object_type IN ('saleCaseT', 'saleCaseI', 'saleCase') UNION ALL "
					+ " SELECT 2000, sum (nbsh), sum (scb), sum (hdpz), sum (yzpz), sum (qrsx), sum (pass), sum (false), sum (total) FROM "
					+ " (SELECT region_id, nbsh, scb, hdpz, yzpz, qrsx, pass, false, total FROM ("
					+ tempTable
					+ ") WHERE workflow_object_type IN ('saleCaseT', 'saleCaseI', 'saleCase') ) ORDER BY region_id";
		} else if (objectType.equals("charge")) {
			condition = "SELECT region_id, nbsh, scb, hdpz, yzpz, qrsx, pass, false, total FROM ("
					+ tempTable
					+ ") WHERE workflow_object_type IN ('chargeCaseT', 'chargeCase') UNION ALL "
					+ " SELECT 2000, sum (nbsh), sum (scb), sum (hdpz), sum (yzpz), sum (qrsx), sum (pass), sum (false), sum (total) FROM "
					+ " (SELECT region_id, nbsh, scb, hdpz, yzpz, qrsx, pass, false, total FROM ("
					+ tempTable
					+ ") WHERE workflow_object_type IN ('chargeCaseT', 'chargeCase') ) ORDER BY region_id";
		}
		return BOTaskDurationCountEngine.getBeansFromSql(condition, null);
	}
}
