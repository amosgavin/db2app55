package com.ai.comframe.test;

import com.ai.comframe.queue.QueueFrameWork;
import com.ai.comframe.vm.common.Constant;

public class StartQueue {

	public static void main(String[] args) throws Exception {
		System.setProperty(Constant.S_COMFRAME_DEV_NAME, "CM");//指定此参数可以使自己创建的流程不被别人处理。对应调度表的dev_id
		startWorkflowQueue();
	}

	/**
	 * 启动工作流队列
	 * 
	 * @throws Exception
	 */
	public static void startWorkflowQueue() throws Exception {
		// -q 队列ID -t 队列类型 -r 区域编码 -m 模 -v 模值, 如"-m","2","-v","0-1"则表示余数为0和1的全部有此队列调度
		String[] param1 = new String[] { "-q", "HB", "-t", "workflow", "-m", "1", "-v", "0","-r",""};
		String[] param2 = new String[] { "-q", "HB", "-t", "workflow", "-m", "1", "-v", "1","-r",""};
		QueueFrameWork.main(param1);
	    QueueFrameWork.main(param2);
	}

	/**
	 * 启动定时器队列
	 * 
	 * @throws Exception
	 */
	public static void startTimerQueue() throws Exception {
		// -q 队列ID -t 队列类型 -r 区域编码 -m 模 -v 模值
		String[] param = new String[] { "-q", "wps", "-t", "timer", "-m", "1", "-v", "0" ,"-r","11"};
		QueueFrameWork.main(param);
	}

	/**
	 * 启动告警队列
	 * 
	 * @throws Exception
	 */
	public static void startWarningQueue() throws Exception {
		// -q 队列ID -t 队列类型 -r 区域编码 -m 模 -v 模值
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
