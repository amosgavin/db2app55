package com.asiainfo.util.server.interfaces;

import com.ai.comframe.client.ComframeClient;

import java.util.HashMap;

public interface IFlowSV {
	//���ؽ��
	public String result(String rs) throws Exception;

	//���õ���������staff�����̱���
	public HashMap setStaff(String workflowid,String _value01) throws Exception;
	
	//���õ���������staff01�����̱���
	public HashMap setStaff01(String workflowid,String _value01) throws Exception;
	
	//����ʡ��˾������staff02�����̱���
	public HashMap setStaff02(String workflowid,String _value02) throws Exception;

	//����ʡ��˾���ò���������staff03�����̱���
	public HashMap setStaff03(String workflowid,String _value02) throws Exception;

	//����ʡ��˾���ò���������staff04�����̱���
	public HashMap setStaff04(String workflowid,String _value04) throws Exception;
	
	//����ʡ��˾���ò�����ʱ����stafftmp�����̱���
	public HashMap setStafftmp(String workflowid,String _valuetmp) throws Exception;
	
	//����ʡ��˾�г����ܾ���staff05�����̱���
	public HashMap setStaff05(String workflowid,String _value05) throws Exception;

	public HashMap setStaff06(String workflowid,String _value06) throws Exception;
	
	public HashMap setStaff07(String workflowid,String _value07) throws Exception;

	public HashMap setStaff08(String workflowid,String _value08) throws Exception;
	
	public HashMap setStaff09(String workflowid,String _value09) throws Exception;
	
	public HashMap setStaff10(String workflowid,String _value10) throws Exception;
	
	public HashMap setStaff11(String workflowid,String _value11) throws Exception;
	
	public HashMap setSpFinance(String workflowid) throws Exception;
	
}
