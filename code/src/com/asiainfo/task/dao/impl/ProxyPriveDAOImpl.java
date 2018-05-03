package com.asiainfo.task.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;

import com.asiainfo.task.ivalues.IBOProxyPriveValue;
import com.asiainfo.task.dao.interfaces.IProxyPriveDAO;
import com.asiainfo.task.bo.BOProxyPriveEngine;

public class ProxyPriveDAOImpl implements IProxyPriveDAO{

	/**
	 * 说明:根据代理人id，获取所有被代理的人员id
	 * proxy_staff_id:代理人ID
	 * **/	
    public List<String> getAuthorStaff(String proxy_staff_id) throws Exception,RuntimeException{
    	IBOProxyPriveValue[] proxyStaff;
		ArrayList<String> authorStaff= new ArrayList<String>();

		String condition = IBOProxyPriveValue.S_State+"=:state and "+IBOProxyPriveValue.S_ProxyStaffId +"=:staffId ";
		HashMap<String,String> parameter = new HashMap<String,String>();
		parameter.put("staffId", proxy_staff_id);
		parameter.put("state", "1");

		proxyStaff = BOProxyPriveEngine.getBeans(condition, parameter);
        
		String authorId;
		for(int i=0;i<proxyStaff.length;i++){
			authorId = proxyStaff[i].getAuthorStaffId();
			authorStaff.add(authorId);
		}
    	return authorStaff;
    }

	/**
	 * 说明:根据被代理的人员id,获取代理人id
	 * author_staff_id:被代理人ID
	 * **/	
    public List<String> getProxyStaff(String author_staff_id) throws Exception,RuntimeException{
    	IBOProxyPriveValue[] proxyStaff;
		ArrayList<String> authorStaff= new ArrayList<String>();

		String condition = IBOProxyPriveValue.S_State+"=:state and "+IBOProxyPriveValue.S_AuthorStaffId+"=:staffId ";
		HashMap<String,String> parameter = new HashMap<String,String>();
		parameter.put("staffId", author_staff_id);
		parameter.put("state", "1");

		proxyStaff = BOProxyPriveEngine.getBeans(condition, parameter);
        
		String proxyId;
		for(int i=0;i<proxyStaff.length;i++){
			proxyId = proxyStaff[i].getProxyStaffId();
			authorStaff.add(proxyId);
		}
    	return authorStaff;
    }
    
}
