package com.asiainfo.bi.dao.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.asiainfo.bi.bo.BOOrderCfgTraceEngine;
import com.asiainfo.bi.dao.interfaces.IOrderCfgTraceDAO;
import com.asiainfo.bi.ivalues.IBOOrderCfgTraceValue;
import com.asiainfo.sale.util.StringUtil;

public class OrderCfgTraceDAOImpl implements IOrderCfgTraceDAO {

	@Override
	public int getOrderCfgCn(String orderType, String cfgStaff,
			String startTime, String endTime) throws Exception {

		return getOrderCfgInfo(orderType, cfgStaff, startTime, endTime, 0, -1).length;
	}

	@Override
	public IBOOrderCfgTraceValue[] getOrderCfgInfo(String orderType,
			String cfgStaff, String startTime, String endTime, int startNum,
			int endNum) throws Exception {

		return BOOrderCfgTraceEngine.getBeansFromSql(getQuerySql(orderType,
				cfgStaff, startTime, endTime, startNum, endNum), null);
	}

	private String getQuerySql(String orderType, String cfgStaff,
			String startTime, String endTime, int startNum, int endNum)
			throws UnsupportedEncodingException {

		StringBuffer bf = new StringBuffer(
				"select order_id ,order_name ,apply_staff,organize_name,pc_id, pc_name, dc_code, dc_name,cfg_staff,finish_date from (");
		if (orderType.trim().equals("charge")) {
			bf
					.append("SELECT distinct co.main_id order_id, ")
					.append("       co.REAMRK_1 order_name, ")
					.append("       sn1.STAFF_NAME apply_staff, ")
					.append("       org.ORGANIZE_NAME ORGANIZE_NAME, ")
					.append("       cm.apply_id pc_id, ")
					.append("       cm.apply_NAME pc_name, ")
					.append("       cd.INADD_USER_COUNT dc_code, ")
					.append("       cd.fee_name dc_name, ")
					.append("       sn.STAFF_NAME cfg_staff, ")
					.append("       date(vm.FINISH_DATE) FINISH_DATE,")
					.append(
							"       rownumber () OVER ( ORDER BY FINISH_DATE desc ) AS row_index ")
					.append(
							"  FROM (SELECT wf.WORKFLOW_OBJECT_ID, t.finish_staff_id, t.finish_date ")
					.append("          FROM VM_WF wf, ")
					.append(
							"               (SELECT WORKFLOW_ID, finish_staff_id, finish_date ")
					.append("                  FROM (SELECT WORKFLOW_ID, ")
					.append("                               finish_staff_id, ")
					.append("                               finish_date, ")
					.append("                               ROW_NUMBER () ")
					.append(
							"                               OVER (PARTITION BY WORKFLOW_ID ")
					.append(
							"                                     ORDER BY finish_date DESC) ")
					.append("                                  AS orderId ")
					.append("                          FROM HBSALE.VM_TASK ")
					.append(
							"                         WHERE TASK_TAG in ('PC041','PC015','C041','C031','st4-ch2-conf') AND state = '3') where orderId=1) T ")
					.append("         WHERE wf.workflow_id = t.workflow_id ")
					.append("        UNION ")
					.append(
							"        SELECT hwf.WORKFLOW_OBJECT_ID, ht.finish_staff_id, ht.finish_date ")
					.append("          FROM H_VM_WF hwf, ")
					.append(
							"               (SELECT WORKFLOW_ID, finish_staff_id, finish_date ")
					.append("                  FROM (SELECT WORKFLOW_ID, ")
					.append("                               finish_staff_id, ")
					.append("                               finish_date, ")
					.append("                               ROW_NUMBER () ")
					.append(
							"                               OVER (PARTITION BY WORKFLOW_ID ")
					.append(
							"                                     ORDER BY finish_date DESC) ")
					.append("                                  AS orderId ")
					.append("                          FROM HBSALE.H_VM_TASK ")
					.append(
							"                         WHERE TASK_TAG in ('PC041','PC015','C041','C031','st4-ch2-conf') AND state = '3') where orderId=1) ht ")
					.append(
							"         WHERE hwf.workflow_id = ht.workflow_id) vm ")
					.append("       LEFT JOIN HBSALE.charge_MAIN_T co ")
					.append("          ON vm.WORKFLOW_OBJECT_ID = co.main_ID ")
					.append("       LEFT JOIN hbsale.CHARGE_APPLY_MAIN_T cm ")
					.append("          ON co.main_ID = cm.main_id ")
					.append("       LEFT JOIN HBSALE.charge_info_t cd ")
					.append("          ON cm.apply_id = cd.apply_id ")
					.append("       LEFT JOIN sechb.sec_organize org ")
					.append(
							"          ON substr (co.org, 1, 2) = org.ORGANIZE_ID ")
					.append(
							"       LEFT JOIN (SELECT st.staff_name, op.operator_id ")
					.append(
							"                    FROM sechb.sec_staff st, sechb.sec_operator op ")
					.append(
							"                   WHERE st.staff_id = op.staff_id) sn ")
					.append("          ON vm.FINISH_STAFF_ID = sn.OPERATOR_ID ")
					.append(
							"       LEFT JOIN (SELECT st.staff_name, op.operator_id ")
					.append(
							"                    FROM sechb.sec_staff st, sechb.sec_operator op ")
					.append(
							"                   WHERE st.staff_id = op.staff_id) sn1 ")
					.append("          ON co.PRINCIPLE = sn1.OPERATOR_ID ")
					.append("  where cd.INADD_USER_COUNT is not null ");
		} else if (orderType.trim().equals("weapon")) {
			bf
					.append("SELECT DISTINCT so.order_id , ")
					.append("                so.order_name , ")
					.append("                sn1.STAFF_NAME apply_staff, ")
					.append("                org.ORGANIZE_NAME , ")
					.append("                sw.ID pc_id, ")
					.append("                sw.WEAPON_NAME pc_name, ")
					.append("                tag.TAG_CODE dc_code, ")
					.append("                tag.NAME dc_name, ")
					.append("                sn.STAFF_NAME cfg_staff, ")
					.append("                date(vm.FINISH_DATE) finish_date,")
					.append(
							"                rownumber () OVER ( ORDER BY FINISH_DATE desc ) AS row_index ")
					.append(
							"  FROM (SELECT wf.WORKFLOW_OBJECT_ID, t.finish_staff_id, t.finish_date ")
					.append("          FROM VM_WF wf, ")
					.append(
							"               (SELECT WORKFLOW_ID, finish_staff_id, finish_date ")
					.append("                  FROM (SELECT WORKFLOW_ID, ")
					.append("                               finish_staff_id, ")
					.append("                               finish_date, ")
					.append("                               ROW_NUMBER () ")
					.append(
							"                               OVER (PARTITION BY WORKFLOW_ID ")
					.append(
							"                                     ORDER BY finish_date DESC) ")
					.append("                                  AS orderId ")
					.append("                          FROM HBSALE.VM_TASK ")
					.append(
							"                         WHERE TASK_TAG = 'wp02' AND state = '3') where orderId=1) T ")
					.append("         WHERE wf.workflow_id = t.workflow_id ")
					.append("        UNION ")
					.append(
							"        SELECT hwf.WORKFLOW_OBJECT_ID, ht.finish_staff_id, ht.finish_date ")
					.append("          FROM H_VM_WF hwf, ")
					.append("               (SELECT WORKFLOW_ID, ")
					.append("				       finish_staff_id, ")
					.append("				       finish_date ")
					.append("				  FROM (SELECT WORKFLOW_ID, ")
					.append("				               finish_staff_id, ")
					.append("				               finish_date, ")
					.append("				               ROW_NUMBER () ")
					.append(
							"				                  OVER (PARTITION BY WORKFLOW_ID ORDER BY finish_date DESC)")
					.append("				                  AS orderId ")
					.append("				          FROM HBSALE.H_VM_TASK ")
					.append(
							"				         WHERE TASK_TAG = 'wp02' AND state = '3') where ")
					.append("				    orderId=1) ht ")
					.append(
							"         WHERE hwf.workflow_id = ht.workflow_id) vm ")
					.append("       LEFT JOIN HBSALE.SALE_order_T so ")
					.append("          ON vm.WORKFLOW_OBJECT_ID = so.order_ID ")
					.append("       LEFT JOIN hbsale.sale_main_t sm ")
					.append("          ON so.order_ID = sm.order_id ")
					.append("       LEFT JOIN hbsale.sale_detail_t sd ")
					.append("          ON sm.id = sd.sale_id ")
					.append("       LEFT JOIN hbsale.sale_weapon_t sw ")
					.append("          ON sd.weapon_id = sw.id ")
					.append("       LEFT JOIN hbsale.WEAPON_TAG_RELA_T wtr ")
					.append(
							"          ON sw.ID = wtr.WEAPON_ID AND wtr.SALE_FLAG = 99 ")
					.append("       LEFT JOIN HBSALE.SALE_TAG_DETAIL_T tag ")
					.append("          ON wtr.TAG_ID = tag.id ")
					.append("       LEFT JOIN sechb.sec_organize org ")
					.append(
							"          ON substr (so.org_id, 1, 2) = org.ORGANIZE_ID ")
					.append(
							"       LEFT JOIN (SELECT st.staff_name, op.operator_id ")
					.append(
							"                    FROM sechb.sec_staff st, sechb.sec_operator op ")
					.append(
							"                   WHERE st.staff_id = op.staff_id) sn ")
					.append("          ON vm.FINISH_STAFF_ID = sn.OPERATOR_ID ")
					.append(
							"       LEFT JOIN (SELECT st.staff_name, op.operator_id ")
					.append(
							"                    FROM sechb.sec_staff st, sechb.sec_operator op ")
					.append(
							"                   WHERE st.staff_id = op.staff_id) sn1 ")
					.append("          ON so.principle = sn1.OPERATOR_ID ")
					.append(" where tag.TAG_CODE is not null ");
		} else {
			return "";
		}
		//bf.append(" where 1=1 ");
		if (StringUtil.isNotBlank(cfgStaff)) {
			bf.append(" and sn1.STAFF_NAME like '%"
					+ URLDecoder.decode(cfgStaff, "utf-8") + "' ");
		}
		if (StringUtil.isNotBlank(startTime)) {
			bf.append(" and finish_date >= '" + startTime + "' ");
		}
		if (StringUtil.isNotBlank(endTime)) {
			bf.append(" and finish_date <= '" + endTime + "' ");
		}
		bf.append(") t where 1=1 ");
		if (endNum > 0) {
			bf.append(" and row_index >= " + startNum + " and row_index <=" + endNum);
		}
		bf.append(" order by t.finish_date desc ");
		return bf.toString();
	}
}
