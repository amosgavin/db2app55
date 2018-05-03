package com.ai.secframe.sysmgr.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.secframe.common.util.SecframeUtil;
import com.ai.secframe.sysmgr.bo.BOSecStationDefaultRoleEngine;
import com.ai.secframe.sysmgr.bo.QBOSecAuthoredRoleEngine;
import com.ai.secframe.sysmgr.dao.interfaces.ISecStationDefaultRoleDAO;
import com.ai.secframe.sysmgr.ivalues.IBOSecStationDefaultRoleValue;
import com.ai.secframe.sysmgr.ivalues.IQBOSecAuthoredRoleValue;
import com.asiainfo.charge.bo.BOChargeConcessInfoEngine;

public class SecStationDefaultRoleDAOImpl implements ISecStationDefaultRoleDAO {
	private static transient Log log = LogFactory.getLog(SecStationDefaultRoleDAOImpl.class);

	public IBOSecStationDefaultRoleValue[] queryDefaultsByStationId(long stId, int startNum, int endNum) throws Exception {
		StringBuilder condition = new StringBuilder();
		HashMap paraMap = new HashMap();
		condition.append(" and ");
		condition.append(IBOSecStationDefaultRoleValue.S_StationId).append("  = :stId ");
		IBOSecStationDefaultRoleValue[] accountValues = BOSecStationDefaultRoleEngine.getBeans(null, condition.toString(), paraMap, startNum, endNum, false);
		return accountValues;
	}

	public IBOSecStationDefaultRoleValue[] queryDefaultsByStationId(long stId) throws Exception {
		StringBuilder condition = new StringBuilder(" 1 = 1 ");
		HashMap paraMap = new HashMap();
		condition.append(" and ");
		condition.append(IBOSecStationDefaultRoleValue.S_StationId).append("  = :stId ");
		paraMap.put("stId", stId);
		IBOSecStationDefaultRoleValue[] accountValues = BOSecStationDefaultRoleEngine.getBeans(condition.toString(), paraMap);
		return accountValues;
	}

	public int queryDefaultCountByStationId(long stId) throws Exception {
		StringBuilder condition = new StringBuilder(" 1 = 1 ");
		HashMap paraMap = new HashMap();
		condition.append(IBOSecStationDefaultRoleValue.S_StationId).append("  = :stId ");
		paraMap.put("stId", stId);
		int count = BOSecStationDefaultRoleEngine.getBeansCount(condition.toString(), paraMap);
		return count;
	}

	public void saveStationDefaultRole(IBOSecStationDefaultRoleValue[] value) throws Exception {
		IBOSecStationDefaultRoleValue[] beans = BOSecStationDefaultRoleEngine.transfer(value);
		for (int i = 0; i < beans.length; i++) {
			if (beans[i].isNew()) {
				if (0 == beans[i].getDefaultId()) {
					beans[i].setDefaultId((BOSecStationDefaultRoleEngine.getNewId().intValue()));
					beans[i].setStsToNew();
				}
			} else if (beans[i].isModified()) {
				log.debug("modify");
			} else if (beans[i].isDeleted()) {
				log.debug("Deleted");
			}
		}
		BOSecStationDefaultRoleEngine.saveBatch(beans);

	}

	public IQBOSecAuthoredRoleValue[] getAuthoredRolesByOpstId(long operId, long opstId) throws Exception {
		Map map = new HashMap();
		map.put("stationId", opstId);
		StringBuilder querySb = new StringBuilder();
		querySb.append("SELECT a.station_id,");
		querySb.append("       a.role_id,");
		querySb.append("       a.default_id,");
		querySb.append("       b.role_id,");
		querySb.append("       b.role_name,");
		querySb.append("       b.region_code,");
		querySb.append("       b.role_type");
		querySb.append("  FROM sec_station_default_role a, sec_role b");
		querySb.append(" WHERE a.state = 1");
		querySb.append("   AND b.state = 1");
		querySb.append("   AND a.role_id = b.role_id");
		querySb.append("   AND a.station_id = :stationId");
		return QBOSecAuthoredRoleEngine.getBeansFromSql(querySb.toString(), map);
	}
	
	public void unAuthor(String stid,String roleid) throws Exception{
		StringBuilder condition = new StringBuilder();
		HashMap paraMap = new HashMap();
		condition.append("1=1 and ");
		condition.append(IBOSecStationDefaultRoleValue.S_StationId+" = :stid and ");
		condition.append(IBOSecStationDefaultRoleValue.S_RoleId+" = :roleid ");
		paraMap.put("stid", stid);
		paraMap.put("roleid", roleid);
		
		IBOSecStationDefaultRoleValue[] accountValues = BOSecStationDefaultRoleEngine.getBeans(condition.toString(), paraMap);
		for(int i=0; i<accountValues.length;i++){
			BOSecStationDefaultRoleEngine.save(accountValues[i]);
		}
	}
	
}
