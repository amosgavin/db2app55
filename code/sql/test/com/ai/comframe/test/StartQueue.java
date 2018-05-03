package com.ai.comframe.test;

import com.ai.comframe.queue.QueueFrameWork;
import com.ai.comframe.vm.common.Constant;

public class StartQueue {

	public static void main(String[] args) throws Exception {
		System.setProperty(Constant.S_COMFRAME_DEV_NAME, "CM");//ָ���˲�������ʹ�Լ����������̲������˴�����Ӧ���ȱ��dev_id
		startWorkflowQueue();
	}

	/**
	 * ��������������
	 * 
	 * @throws Exception
	 */
	public static void startWorkflowQueue() throws Exception {
		// -q ����ID -t �������� -r ������� -m ģ -v ģֵ, ��"-m","2","-v","0-1"���ʾ����Ϊ0��1��ȫ���д˶��е���
		String[] param1 = new String[] { "-q", "HB", "-t", "workflow", "-m", "1", "-v", "0","-r",""};
		String[] param2 = new String[] { "-q", "HB", "-t", "workflow", "-m", "1", "-v", "1","-r",""};
		QueueFrameWork.main(param1);
	    QueueFrameWork.main(param2);
	}

	/**
	 * ������ʱ������
	 * 
	 * @throws Exception
	 */
	public static void startTimerQueue() throws Exception {
		// -q ����ID -t �������� -r ������� -m ģ -v ģֵ
		String[] param = new String[] { "-q", "wps", "-t", "timer", "-m", "1", "-v", "0" ,"-r","11"};
		QueueFrameWork.main(param);
	}

	/**
	 * �����澯����
	 * 
	 * @throws Exception
	 */
	public static void startWarningQueue() throws Exception {
		// -q ����ID -t �������� -r ������� -m ģ -v ģֵ
		String[] param = new String[] { "-q", "wps", "-t", "warning", "-m", "1", "-v", "0", "-r", "11" };
		QueueFrameWork.main(param);
	}
	public static void startScanBusi() throws Exception {
		String[] param1 = new String[] { "-q", "wps", "-t", "scanbusi", "-m", "1", "-v", "0", "-r", "11" };
		QueueFrameWork.main(param1);
		
	}
	
	public static void startScanEngine() throws Exception {

		String[] param2 = new String[] { "-q", "wps", "-t", "scanengine", "-m", "1", "-v", "0", "-r", "11" };
		QueueFrameWork.main(param2);
	}
	
}
