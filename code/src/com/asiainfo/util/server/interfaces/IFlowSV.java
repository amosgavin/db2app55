package com.asiainfo.util.server.interfaces;

import com.ai.comframe.client.ComframeClient;

import java.util.HashMap;

public interface IFlowSV {
	//返回结果
	public String result(String rs) throws Exception;

	//设置地市主办人staff，流程变量
	public HashMap setStaff(String workflowid,String _value01) throws Exception;
	
	//设置地市主办人staff01，流程变量
	public HashMap setStaff01(String workflowid,String _value01) throws Exception;
	
	//设置省公司主办人staff02，流程变量
	public HashMap setStaff02(String workflowid,String _value02) throws Exception;

	//设置省公司配置测试主办人staff03，流程变量
	public HashMap setStaff03(String workflowid,String _value02) throws Exception;

	//设置省公司配置测试主办人staff04，流程变量
	public HashMap setStaff04(String workflowid,String _value04) throws Exception;
	
	//设置省公司配置测试临时变量stafftmp，流程变量
	public HashMap setStafftmp(String workflowid,String _valuetmp) throws Exception;
	
	//设置省公司市场部总经理staff05，流程变量
	public HashMap setStaff05(String workflowid,String _value05) throws Exception;

	public HashMap setStaff06(String workflowid,String _value06) throws Exception;
	
	public HashMap setStaff07(String workflowid,String _value07) throws Exception;

	public HashMap setStaff08(String workflowid,String _value08) throws Exception;
	
	public HashMap setStaff09(String workflowid,String _value09) throws Exception;
	
	public HashMap setStaff10(String workflowid,String _value10) throws Exception;
	
	public HashMap setStaff11(String workflowid,String _value11) throws Exception;
	
	public HashMap setSpFinance(String workflowid) throws Exception;
	
}
