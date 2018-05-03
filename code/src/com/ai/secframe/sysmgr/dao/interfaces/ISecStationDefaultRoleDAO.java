package com.ai.secframe.sysmgr.dao.interfaces;

import com.ai.secframe.sysmgr.ivalues.IBOSecStationDefaultRoleValue;
import com.ai.secframe.sysmgr.ivalues.IQBOSecAuthoredRoleValue;

public interface ISecStationDefaultRoleDAO {
	public IBOSecStationDefaultRoleValue[] queryDefaultsByStationId(long stId, int startNum, int endNum) throws Exception;

	public IBOSecStationDefaultRoleValue[] queryDefaultsByStationId(long stId) throws Exception;

	public int queryDefaultCountByStationId(long stId) throws Exception;

	public void saveStationDefaultRole(IBOSecStationDefaultRoleValue[] value) throws Exception;

	public IQBOSecAuthoredRoleValue[] getAuthoredRolesByOpstId(long operId, long opstId) throws Exception;

	public void unAuthor(String stid,String roleid) throws Exception;
	
}
