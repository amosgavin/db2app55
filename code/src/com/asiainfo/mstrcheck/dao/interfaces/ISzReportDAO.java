package com.asiainfo.mstrcheck.dao.interfaces;


public interface ISzReportDAO {

	public String getXml(String szToken)throws Exception;

	public void getToken(String orgName, String token) throws Exception;
}