package com.asiainfo.task.dao.interfaces;
import java.util.List;

import com.asiainfo.task.ivalues.IBOProxyPriveValue;

public interface IProxyPriveDAO {
	
	/**
	 * ˵��:���ݴ�����id����ȡ���б��������Աid
	 * proxy_staff_id:������ID
	 * **/	
    public List<String> getAuthorStaff(String proxy_staff_id) throws Exception,RuntimeException;
    
	/**
	 * ˵��:���ݱ��������Աid,��ȡ������id
	 * author_staff_id:��������ID
	 * **/	
    public List<String> getProxyStaff(String author_staff_id) throws Exception,RuntimeException;
    
}
