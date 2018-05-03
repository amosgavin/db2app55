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
				//����10s
				Thread.sleep(10000);
				signTaskValues =  vmTaskSV.getVmTaskTsByWFId(workfId, taskTag);
				if(signTaskValues.length>0){
					break;
				}else{
					log.info("workfId:"+workfId+",taskTag:"+taskTag+"������δ����,������ѯ");
				}
			}	
			for(IBOVmTaskTsValue task:signTaskValues){
				  String taskStaffId= task.getTaskStaffId();
				if(taskStaffId.indexOf("111111111")>=0){
					task.setLabel("ҵ֧����NCODE��������");
					task.setTaskStaffId(taskStaffId.substring(0, taskStaffId.length()-9));
					vmTaskSV.saveVmTaskTs(task);
				}else if(taskStaffId.indexOf("222222222")>=0){
					task.setLabel("����������˷���");
					task.setTaskStaffId(taskStaffId.substring(0, taskStaffId.length()-9));
					vmTaskSV.saveVmTaskTs(task);
				}else if(taskStaffId.indexOf("333333333")>=0){
					task.setLabel("������������");
					vmTaskSV.saveVmTaskTs(task);
				}else if(taskStaffId.indexOf("444444444")>=0){
					task.setLabel("���������������������");
					vmTaskSV.saveVmTaskTs(task);
				}else if(taskStaffId.indexOf("555555555")>=0){
					task.setLabel("ҵ��֧����������NCODE");
					vmTaskSV.saveVmTaskTs(task);
				}
				
			}
			log.debug("ҵ��֧����������NCODE������������˷��������Ա���Ľ���");
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
	
}
