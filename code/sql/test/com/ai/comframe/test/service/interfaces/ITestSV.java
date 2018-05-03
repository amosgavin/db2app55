package com.ai.comframe.test.service.interfaces;

public interface ITestSV {
	
	public String autoDe(String flag) throws Exception;
	
	public void goBackTest(String wfId,String taskId) throws Exception;
	
	public void jumpToTaskTest(String wfId,String taskId) throws Exception;
	public void testFuego(int test) throws Exception;
	public void sysout(String custName) throws Exception;
	
	public String result(String rs) throws Exception;
}
