package com.asiainfo.sale.activity.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.asiainfo.costWarn.job.ConnectUtil;
import com.asiainfo.sale.activity.bo.BOResourceChangeDetailEngine;
import com.asiainfo.sale.activity.dao.interfaces.IResourceChangeDetailDAO;
import com.asiainfo.sale.activity.ivalues.IBOResourceChangeDetailValue;

public class ResourceChangeDetailDAOImpl implements IResourceChangeDetailDAO{

	@Override
	public IBOResourceChangeDetailValue getResourceChangeDetailByID(int resourceId)
			throws Exception {
		int resourceDid=0;
		try {
			Connection conn=ConnectUtil.getConnection();
			String sql="select RESOURCED_ID from hbsale.RESOURCE_CHANGE_DETAIL_T where RESOURCE_ID="+resourceId;
			Statement stm=conn.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()){
				resourceDid=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return BOResourceChangeDetailEngine.getBean(resourceDid);
	}

	@Override
	public int saveResourceChangeDetail(IBOResourceChangeDetailValue resourceChangeDetailValue)
			throws Exception {
		int resourceDid =Integer.valueOf(resourceChangeDetailValue.getResourcedId());
		if(resourceChangeDetailValue!=null){
			if(resourceChangeDetailValue.isNew()){
				resourceDid=BOResourceChangeDetailEngine.getNewId().intValue();
				resourceChangeDetailValue.setResourcedId(resourceDid);
				resourceChangeDetailValue.setStsToNew();
			}
			BOResourceChangeDetailEngine.save(resourceChangeDetailValue);
		}
		return resourceDid;
	}

}
