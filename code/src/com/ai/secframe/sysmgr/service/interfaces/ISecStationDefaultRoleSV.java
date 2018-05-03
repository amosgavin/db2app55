package com.ai.secframe.sysmgr.service.interfaces;

import java.rmi.RemoteException;

import com.ai.secframe.sysmgr.ivalues.IBOSecStationDefaultRoleValue;
import com.ai.secframe.sysmgr.ivalues.IQBOSecAuthoredRoleValue;

public interface ISecStationDefaultRoleSV {
	public IBOSecStationDefaultRoleValue [] queryAccountCountByDefaultId(long defId) throws Exception, RemoteException;
	public IQBOSecAuthoredRoleValue[] getAuthoredRolesByOpstId(long operId, long opstId) throws Exception, RemoteException;
	public void saveStationDefaultRole(IBOSecStationDefaultRoleValue[] value) throws Exception;
	public void unAuthor(String stid,String roleid) throws Exception;
}
