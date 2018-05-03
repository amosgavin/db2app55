package com.asiainfo.workflow.util.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.task.ivalues.IBOVmTaskTsValue;
import com.asiainfo.task.service.interfaces.IVmTaskSV;

public class TaskSignThread extends Thread {
	
	private transient static Log log = LogFactory.getLog(TaskSignThread.class);
	private String workfId;
	private String taskTag;
	private IVmTaskSV vmTaskSV = (IVmTaskSV) ServiceFactory
	.getService(IVmTaskSV.class);
	
	public TaskSignThread(String workfId,String taskTag){
		this.workfId=workfId;
		this.taskTag=taskTag;	
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		IBOVmTaskTsValue[] signTaskValues;
		
		try {
			while(true){
				//休眠10s
				Thread.sleep(10000);
				signTaskValues =  vmTaskSV.getVmTaskTsByWFId(workfId, taskTag);
				if(signTaskValues.length>0){
					break;
				}else{
					log.info("workfId:"+workfId+",taskTag:"+taskTag+"的任务未生成,继续查询");
				}
			}	
			for(IBOVmTaskTsValue task:signTaskValues){
				  String taskStaffId= task.getTaskStaffId();
				if(taskStaffId.indexOf("111111111")>=0){
					task.setLabel("业支配置NCODE审核人审核");
					task.setTaskStaffId(taskStaffId.substring(0, taskStaffId.length()-9));
					vmTaskSV.saveVmTaskTs(task);
				}else if(taskStaffId.indexOf("222222222")>=0){
					task.setLabel("渠道中心审核分配");
					task.setTaskStaffId(taskStaffId.substring(0, taskStaffId.length()-9));
					vmTaskSV.saveVmTaskTs(task);
				}else if(taskStaffId.indexOf("333333333")>=0){
					task.setLabel("中心审核人审核");
					vmTaskSV.saveVmTaskTs(task);
				}else if(taskStaffId.indexOf("444444444")>=0){
					task.setLabel("短信渠道或电子渠道上线");
					vmTaskSV.saveVmTaskTs(task);
				}else if(taskStaffId.indexOf("555555555")>=0){
					task.setLabel("业务支撑中心配置NCODE");
					vmTaskSV.saveVmTaskTs(task);
				}
				
			}
			log.debug("业务支撑中心配置NCODE与渠道中心审核分配操作人员更改结束");
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
	
}
