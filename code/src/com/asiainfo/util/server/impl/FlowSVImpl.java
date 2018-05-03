package com.asiainfo.util.server.impl;

import java.util.HashMap;

import com.asiainfo.sale.common.service.interfaces.ISendSmsSV;
import com.asiainfo.util.server.interfaces.IFlowSV;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.comframe.client.ComframeClient;

public class FlowSVImpl implements IFlowSV {
	
	public String result(String rs) throws Exception {
		return rs;
	}

	//设置地市主办人staff，流程变量
	public HashMap setStaff(String workflowid,String _value) throws Exception{
		HashMap<String,String> aVars = new HashMap<String,String>();
		String inValue = _value;
		aVars.put("staff", inValue);
		
		//ComframeClient.setWorkflowVars(workflowid, aVars);
		
		return aVars;
	}
	
	//设置地市主办人staff01，流程变量
	public HashMap setStaff01(String workflowid,String _value01) throws Exception{
		HashMap<String,String> aVars = new HashMap<String,String>();
		String inValue = _value01;
		aVars.put("staff01", inValue);
		
		//ComframeClient.setWorkflowVars(workflowid, aVars);
		
		return aVars;
	}
	
	//设置省公司主办人staff02，流程变量
	public HashMap setStaff02(String workflowid,String _value02) throws Exception{
		HashMap<String,String> aVars = new HashMap<String,String>();

		String inValue = _value02;
		aVars.put("staff02", inValue);
		
		//ComframeClient.setWorkflowVars(workflowid, aVars);
		
		return aVars;
	}

	//设置省公司配置测试主办人staff03，流程变量
	public HashMap setStaff03(String workflowid,String _value03) throws Exception{
		HashMap<String,String> aVars = new HashMap<String,String>();
		String inValue = _value03;

		aVars.put("staff03", inValue);
		
		//ComframeClient.setWorkflowVars(workflowid, aVars);
		
		return aVars;
	}

	//设置省公司配置测试主办人staff04，流程变量
	public HashMap setStaff04(String workflowid,String _value04) throws Exception{
		HashMap<String,String> aVars = new HashMap<String,String>();
		String inValue = _value04;

		aVars.put("staff04", inValue);
		
		//ComframeClient.setWorkflowVars(workflowid, aVars);
		
		return aVars;
	}
	//设置省公司配置测试临时变量stafftmp，流程变量
	public HashMap setStafftmp(String workflowid,String _valuetmp) throws Exception{
		HashMap<String,String> aVars = new HashMap<String,String>();
		String inValue = _valuetmp;

		aVars.put("stafftmp", inValue);
		
		//ComframeClient.setWorkflowVars(workflowid, aVars);
		
		return aVars;
	}

	//设置省公司市场部总经理staff05，流程变量
	public HashMap setStaff05(String workflowid,String _value05) throws Exception{
		HashMap<String,String> aVars = new HashMap<String,String>();
		String inValue = _value05;

		aVars.put("staff05", inValue);
		System.out.println("=========================================================");
		System.out.println("staff05 is :"+inValue);
		System.out.println("=========================================================");
		
		//ComframeClient.setWorkflowVars(workflowid, aVars);
		
		return aVars;
	}
	
	public HashMap setStaff06(String workflowid,String _value06) throws Exception{
		HashMap<String,String> aVars = new HashMap<String,String>();
		String inValue = _value06;

		aVars.put("staff06", inValue);
		
		//ComframeClient.setWorkflowVars(workflowid, aVars);
		
		return aVars;
	}

	public HashMap setStaff07(String workflowid,String _value07) throws Exception{
		HashMap<String,String> aVars = new HashMap<String,String>();
		String inValue = _value07;

		aVars.put("staff07", inValue);
		
		//ComframeClient.setWorkflowVars(workflowid, aVars);
		
		return aVars;
	}
	
	public HashMap setStaff08(String workflowid,String _value08) throws Exception{
		HashMap<String,String> aVars = new HashMap<String,String>();
		String inValue = _value08;

		aVars.put("staff08", inValue);
		
		//ComframeClient.setWorkflowVars(workflowid, aVars);
		
		return aVars;
	}
	public HashMap setStaff09(String workflowid,String _value09) throws Exception{
		HashMap<String,String> aVars = new HashMap<String,String>();
		String inValue = _value09;

		aVars.put("staff09", inValue);
		
		//ComframeClient.setWorkflowVars(workflowid, aVars);
		
		return aVars;
	}
	public HashMap setStaff10(String workflowid,String _value10) throws Exception{
		HashMap<String,String> aVars = new HashMap<String,String>();
		String inValue = _value10;

		aVars.put("staff10", inValue);
		
		//ComframeClient.setWorkflowVars(workflowid, aVars);
		
		return aVars;
	}
	
	public HashMap setSpFinance(String workflowid) throws Exception{
		HashMap<String,String> aVars = new HashMap<String,String>();
		//庄莉
		String inValue = "20004937";

		aVars.put("treasurer", inValue);
		//ISendSmsSV iSendSmsSV = (ISendSmsSV) ServiceFactory.getService(ISendSmsSV.class);
		//iSendSmsSV.sendSms("",workflowid, "-110", "20004937");
		//ComframeClient.setWorkflowVars(workflowid, aVars);
		
		return aVars;
	}

	@Override
	public HashMap setStaff11(String workflowid, String _value11)
			throws Exception {
		HashMap<String,String> aVars = new HashMap<String,String>();
		String inValue = _value11;
		aVars.put("staff11", inValue);
		return aVars;
	}

}
