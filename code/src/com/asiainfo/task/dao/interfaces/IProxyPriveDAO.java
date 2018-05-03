package com.asiainfo.task.dao.interfaces;
import java.util.List;

import com.asiainfo.task.ivalues.IBOProxyPriveValue;

public interface IProxyPriveDAO {
	
	/**
	 * 说明:根据代理人id，获取所有被代理的人员id
	 * proxy_staff_id:代理人ID
	 * **/	
    public List<String> getAuthorStaff(String proxy_staff_id) throws Exception,RuntimeException;
    
	/**
	 * 说明:根据被代理的人员id,获取代理人id
	 * author_staff_id:被代理人ID
	 * **/	
    public List<String> getProxyStaff(String author_staff_id) throws Exception,RuntimeException;
    
}
