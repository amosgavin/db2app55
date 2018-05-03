package com.ai.secframe.sysmgr.service.impl;

import java.rmi.RemoteException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.secframe.sysmgr.dao.interfaces.ISecAuthorDAO;
import com.ai.secframe.sysmgr.dao.interfaces.ISecStationDefaultRoleDAO;
import com.ai.secframe.sysmgr.ivalues.IBOSecStationDefaultRoleValue;
import com.ai.secframe.sysmgr.ivalues.IQBOSecAuthoredRoleValue;
import com.ai.secframe.sysmgr.service.interfaces.ISecStationDefaultRoleSV;

public class SecStationDefaultRoleSVImpl  implements ISecStationDefaultRoleSV{
	private static transient Log log = LogFactory.getLog(SecStationDefaultRoleSVImpl.class);
	
	public IBOSecStationDefaultRoleValue [] queryAccountCountByDefaultId(long defId) throws Exception, RemoteException {
		ISecStationDefaultRoleDAO dao = (ISecStationDefaultRoleDAO) ServiceFactory.getService(ISecStationDefaultRoleDAO.class);
		IBOSecStationDefaultRoleValue[] values = dao.queryDefaultsByStationId(defId);
		return values;
	}

	@Override
	public IQBOSecAuthoredRoleValue[] getAuthoredRolesByOpstId(long operId, long opstId) throws Exception, RemoteException {
		ISecStationDefaultRoleDAO dao = (ISecStationDefaultRoleDAO) ServiceFactory.getService(ISecStationDefaultRoleDAO.class);
		return dao.getAuthoredRolesByOpstId(operId, opstId);
	}
	
	public void saveStationDefaultRole(IBOSecStationDefaultRoleValue[] value) throws Exception{
		ISecStationDefaultRoleDAO dao = (ISecStationDefaultRoleDAO) ServiceFactory.getService(ISecStationDefaultRoleDAO.class);
		dao.saveStationDefaultRole(value);
	}
	
	public void unAuthor(String stid,String roleid) throws Exception{
		ISecStationDefaultRoleDAO dao = (ISecStationDefaultRoleDAO) ServiceFactory.getService(ISecStationDefaultRoleDAO.class);
		dao.unAuthor(stid, roleid);
	}
	
}
