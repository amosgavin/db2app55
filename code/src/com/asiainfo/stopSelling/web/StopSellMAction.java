package com.asiainfo.stopSelling.web;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.stopSelling.bo.BOStopSellMBean;
import com.asiainfo.stopSelling.ivalues.IBOStopSellMValue;
import com.asiainfo.stopSelling.service.interfaces.IStopSellMSV;
import com.asiainfo.task.ivalues.IBOVmTaskTsValue;
import com.asiainfo.task.service.interfaces.IVmTaskSV;
import com.asiainfo.workflow.util.server.interfaces.ITaskUtilSV;

public class StopSellMAction extends BaseAction {

	private transient static Log log = LogFactory.getLog(StopSellMAction.class);

	public void saveStopSellMInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		IBOStopSellMValue[] chargeStopSellMValues = null;// ǰ̨�ύ������

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOStopSellMBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "��������Ϊ�գ�");
			return;
		}
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOStopSellMBean[]) {
				chargeStopSellMValues = (BOStopSellMBean[]) obj;
			}
		}
		IStopSellMSV chargeStopSellMSV = (IStopSellMSV) ServiceFactory
				.getService(IStopSellMSV.class);

		try {
			if (null == chargeStopSellMValues
					|| 0 == chargeStopSellMValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "û���޸���Ҫ���棡");
			} else {
				if(chargeStopSellMValues[0].isDeleted() == true)
				{
					chargeStopSellMValues[0].undelete();
					chargeStopSellMValues[0].setIsDelete("1");
				}
				int mainId = chargeStopSellMSV.save(chargeStopSellMValues);
				cp.set("MAINID", String.valueOf(mainId));
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "�����ɹ���");
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("������Ϣ����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	/**
	 * �ύ��һ�ڵ�
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void finishUserTask(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String taskId = request.getParameter("taskId");
		String wfId = request.getParameter("wfId");
		String result = request.getParameter("result");
		String nextStepStaff = request.getParameter("staffId");
		String comment = request.getParameter("comment");
		String reason = request.getParameter("reason").replace("^#", "%");
		String auditFlag = request.getParameter("auditFlag");
		String taskTag = request.getParameter("taskTag");
		String nextTaskTag = request.getParameter("nextTaskTag");

		ITaskUtilSV taskUtilSV = (ITaskUtilSV) ServiceFactory
				.getService(ITaskUtilSV.class);

		IVmTaskSV vmTaskSV = (IVmTaskSV) ServiceFactory
				.getService(IVmTaskSV.class);

		String[] rcode = null;
		try {
			if ("".equals(taskId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "��������Ϊ�գ�");
			} else {
				// �ύǰ����
				if (taskTag.contains("Sign005")) {
					IBOVmTaskTsValue curTask = vmTaskSV
							.getVmTaskTsByTaskId(taskId);
					if (curTask.getLabel().equals("����ͣ������")) {
						IBOVmTaskTsValue[] tasks = vmTaskSV.getVmTaskTsByWFId(
								wfId, taskTag);
						for (IBOVmTaskTsValue task : tasks) {
							if (task.getTaskStaffId().equals("000")) {
								task.setTaskStaffId(nextStepStaff);
								//task.setState(5);
								task.setLabel("ͣ�۴���");
								SimpleDateFormat df = new SimpleDateFormat(
										"yyyy-MM-dd HH:mm:ss");
								task.setCreateDate(Timestamp.valueOf(df
										.format(new Date())));
								vmTaskSV.saveVmTaskTs(task);
								break;
							}
						}
					}
				}
				rcode = taskUtilSV.finishUserTask(taskId, result, "",
						nextStepStaff, comment, reason, auditFlag);
				/* �ύ������
				if (nextTaskTag.contains("Sign005")) {
					IBOVmTaskTsValue[] tasks = vmTaskSV.getVmTaskTsByWFId(wfId,
							nextTaskTag);
					for (IBOVmTaskTsValue task : tasks) {
						if (task.getTaskStaffId().equals("000")) {
							task.setState(6);
							task.setLabel("ͣ�۴���");
							vmTaskSV.saveVmTaskTs(task);
						}
					}
				} */
			}
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", rcode[1]);
		} catch (Exception e) {
			// ����ʧ��
			log.error("�ύ����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "�ύʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void checkIsDispacher(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String taskId = request.getParameter("taskId");

		IVmTaskSV vmTaskSV = (IVmTaskSV) ServiceFactory
				.getService(IVmTaskSV.class);

		try {
			if ("".equals(taskId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "��������Ϊ�գ�");
			} else {
				// �ύǰ����
				IBOVmTaskTsValue curTask = vmTaskSV.getVmTaskTsByTaskId(taskId);
				if (curTask.getLabel().equals("����ͣ������")) {
					cp.set("FLAG", "Y");
				} else {
					cp.set("FLAG", "N");
				}
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("�ύ����", e);
			cp.set("FLAG", "N");
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
