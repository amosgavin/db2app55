package com.asiainfo.mstrcheck.service.interfaces;

public interface ISzReportSV {

	public String getXml(String szToken)throws Exception;

	public void getToken(String orgName, String token) throws Exception;
}