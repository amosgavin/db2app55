package com.asiainfo.workflow.util.web;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.charge.ivalues.IBOChargeMainValue;
import com.asiainfo.charge.service.interfaces.IChargeNewMainSV;
import com.asiainfo.sale.access.ivalues.IBOAccessChangeValue;
import com.asiainfo.sale.access.ivalues.IBOBusiChangeValue;
import com.asiainfo.sale.access.service.interfaces.IAccessChangeSV;
import com.asiainfo.sale.access.service.interfaces.IBusiChangeDetailSV;
import com.asiainfo.sale.access.service.interfaces.IBusiChangeSV;
import com.asiainfo.sale.activity.ivalues.IBOResourceChangeValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleOrderValue;
import com.asiainfo.sale.activity.service.interfaces.IResourceChangeDetailSV;
import com.asiainfo.sale.activity.service.interfaces.IResourceChangeSV;
import com.asiainfo.sale.activity.service.interfaces.ISaleOrderSV;
import com.asiainfo.sale.complain.ivalues.IBOOrderComplainsValue;
import com.asiainfo.sale.complain.service.interfaces.IOrderComplainDetailSV;
import com.asiainfo.sale.complain.service.interfaces.IOrderComplainSV;
import com.asiainfo.sale.util.StringUtil;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponValue;
import com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV;
import com.asiainfo.workflow.util.TaskUtil;
import com.asiainfo.workflow.util.server.interfaces.ITaskUtilSV;
import com.asiainfo.sale.prestore.service.interfaces.ISaleBatchPrestoreSV;
import com.asiainfo.sale.prestore.ivalues.IBOSaleBatchPrestoreValue;
import com.asiainfo.stopSelling.ivalues.IBOStopSellMValue;
import com.asiainfo.stopSelling.service.interfaces.IStopSellMSV;
import com.asiainfo.task.ivalues.IBOVmTaskTsValue;
import com.asiainfo.task.ivalues.IBOVmTaskValue;
import com.asiainfo.task.service.interfaces.IVmTaskSV;

public class TaskUtilAction extends BaseAction {
	private transient static Log log = LogFactory.getLog(TaskUtilAction.class);

	/**
	 * 提交工作流
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void createWorkflow(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String mainId = request.getParameter("mainId");

		String staffId = request.getParameter("staffId");

		String flowType = request.getParameter("flowType");

		String result = request.getParameter("result");

		ISaleOrderSV iSaleOrderSV = null;
		IBOSaleOrderValue iboSaleOrderValue = null;
		IChargeNewMainSV iChargeMainSV = null;
		IBOChargeMainValue iBOChargeMainValue = null;
		IBOAccessChangeValue iBOAccessChangeValue = null;
		IBOBusiChangeValue busiChangeValue = null;
		IAccessChangeSV iAccessChangeSV = null;
		IBusiChangeSV busiChangeSV = null;
		IBusiChangeDetailSV busiChangeDetailSV = null;
		ISaleBatchPrestoreSV ISaleBatchPrestoreSV = null;
		IBOSaleBatchPrestoreValue IBOSaleBatchPrestoreValue = null;
		IStopSellMSV stopSellMSV = null;
		IBOStopSellMValue stopSellMValue = null;

		IBOOrderComplainsValue iBOOrderComplainsValue = null;
		IOrderComplainSV iOrderComplainSV = null;
		IOrderComplainDetailSV iOrderComplainDetailSV = null;
		IBOResourceChangeValue resChangeValue=null;
		IResourceChangeSV resChangeSV=null;
		IResourceChangeDetailSV iResourceChangeDetailSV=null;

		if ("saleCase".equals(flowType) || "saleCaseT".equals(flowType)
				|| "saleCaseI".equals(flowType)
				|| "saleCaseZQ".equals(flowType)) {
			iSaleOrderSV = ((ISaleOrderSV) ServiceFactory
					.getService(ISaleOrderSV.class));
			iboSaleOrderValue = iSaleOrderSV.getSaleOrderInfo(mainId);
			if (null == iboSaleOrderValue) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
				HttpUtil.showInfo(response, cp);
				return;
			}
			if ("2".equals(iboSaleOrderValue.getState())) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "申请单已提交，不能重复提交");
				HttpUtil.showInfo(response, cp);
				return;
			}
			
		} else if ("chargeCaseT".equals(flowType)
				|| "chargeCase".equals(flowType)
				|| "newChargeCaseP".equals(flowType)
				|| "newChargeCaseT".equals(flowType)
				|| "chargeCaseZQ".equals(flowType)
				|| "UniteChargeFlow".equals(flowType)) {
			iChargeMainSV = ((IChargeNewMainSV) ServiceFactory
					.getService(IChargeNewMainSV.class));
			iBOChargeMainValue = iChargeMainSV.IChargeMainshow(mainId);
			if (null == iBOChargeMainValue) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
				HttpUtil.showInfo(response, cp);
				return;
			}
			if ("2".equals(iBOChargeMainValue.getState())) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "申请单已提交，不能重复提交");
				HttpUtil.showInfo(response, cp);
				return;
			}

			if (1 > iChargeMainSV.getApplyMainsByMainId(mainId).length) {
				// System.out.print(iChargeMainSV.getCountByFeeType(mainId,
				// null));
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "资费批次，请至少添加一个资费批次");
				HttpUtil.showInfo(response, cp);
				return;
			}

		} else if ("accessCaseT".equals(flowType)) {
			iAccessChangeSV = ((IAccessChangeSV) ServiceFactory
					.getService(IAccessChangeSV.class));
			iBOAccessChangeValue = iAccessChangeSV.getAccessChargeById(Integer
					.parseInt(mainId));
			if (null == iBOAccessChangeValue) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
				HttpUtil.showInfo(response, cp);
				return;
			}
			if ("2".equals(iBOAccessChangeValue.getState())) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "申请单已提交，不能重复提交");
				HttpUtil.showInfo(response, cp);
				return;
			}
			if (1 > iAccessChangeSV.getAccessChargeDetailCount(Integer
					.parseInt(mainId))) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "修改渠道明细，请至少添加一个渠道明细信息");
				HttpUtil.showInfo(response, cp);
				return;
			}
		} else if ("busiChangeCase".equals(flowType)
				|| "busiChangeCaseP".equals(flowType)
				|| "channelChangeCase".equals(flowType)
				|| "activityDelayCase".equals(flowType)) {
			busiChangeSV = ((IBusiChangeSV) ServiceFactory
					.getService(IBusiChangeSV.class));
			busiChangeDetailSV = ((IBusiChangeDetailSV) ServiceFactory
					.getService(IBusiChangeDetailSV.class));
			busiChangeValue = busiChangeSV.getBusiChargeById(mainId);
			if (null == busiChangeValue) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
				HttpUtil.showInfo(response, cp);
				return;
			}
			if ("2".equals(busiChangeValue.getState())) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "申请单已提交，不能重复提交");
				HttpUtil.showInfo(response, cp);
				return;
			}
			if (1 > busiChangeDetailSV.getBusiChangeDetailCountByPID(mainId,
					null)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "请至少添加一个业务变更明细信息");
				HttpUtil.showInfo(response, cp);
				return;
			}
		} else if ("prestoreCase".equals(flowType)) {
			ISaleBatchPrestoreSV = ((ISaleBatchPrestoreSV) ServiceFactory
					.getService(ISaleBatchPrestoreSV.class));
			IBOSaleBatchPrestoreValue = ISaleBatchPrestoreSV
					.getSaleMainShowById(mainId);
			if (null == IBOSaleBatchPrestoreValue) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
				HttpUtil.showInfo(response, cp);
				return;
			}
			if ("2".equals(IBOSaleBatchPrestoreValue.getIsSubmit())) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "申请单已提交，不能重复提交");
				HttpUtil.showInfo(response, cp);
				return;
			}
		} else if ("chargeSellStopCaseT".equals(flowType)
				|| "chargeSellStopCaseP".equals(flowType)
				|| "saleSellStopCaseT".equals(flowType)
				|| "saleSellStopCaseP".equals(flowType)) {
			stopSellMSV = ((IStopSellMSV) ServiceFactory
					.getService(IStopSellMSV.class));
			stopSellMValue = stopSellMSV.getStopSellMInfoById(mainId);
			if (null == stopSellMValue) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
				HttpUtil.showInfo(response, cp);
				return;
			}
			if ("2".equals(stopSellMValue.getState())) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "申请单已提交，不能重复提交");
				HttpUtil.showInfo(response, cp);
				return;
			}
		} else if ("complainCase".equals(flowType)) {
			iOrderComplainSV = (IOrderComplainSV) ServiceFactory
					.getService(IOrderComplainSV.class);
			iOrderComplainDetailSV = (IOrderComplainDetailSV) ServiceFactory
					.getService(IOrderComplainDetailSV.class);
			iBOOrderComplainsValue = iOrderComplainSV
					.getOrderComplainByID(mainId);
			if (null == iBOOrderComplainsValue) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
				HttpUtil.showInfo(response, cp);
				return;
			}
			if ("2".equals(iBOOrderComplainsValue.getState())) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "申请单已提交，不能重复提交");
				HttpUtil.showInfo(response, cp);
				return;
			}
			if (1 > iOrderComplainDetailSV
					.getOrderComplainDetailCountByPID(mainId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "请至少添加一个工单投诉信息");
				HttpUtil.showInfo(response, cp);
				return;
			}
		} else if ("resChangeCase".equals(flowType)){
			resChangeSV = ((IResourceChangeSV) ServiceFactory
					.getService(IResourceChangeSV.class));
			resChangeValue =  resChangeSV.getResourceChange(mainId);
			iResourceChangeDetailSV=(IResourceChangeDetailSV)ServiceFactory
			.getService(IResourceChangeDetailSV.class);
			if (null == resChangeValue) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
				HttpUtil.showInfo(response, cp);
				return;
			}
			if ("2".equals(resChangeValue.getState())) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "申请单已提交，不能重复提交");
				HttpUtil.showInfo(response, cp);
				return;
			}
			if (iResourceChangeDetailSV
					.getResourceChangeDetailByID(Integer.parseInt(mainId)).getResourcedId()==0)
					 {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "请至少添加一个资源借调明细信息");
				HttpUtil.showInfo(response, cp);
				return;
			}
		}

		ITaskUtilSV taskUtilSV = (ITaskUtilSV) ServiceFactory
				.getService(ITaskUtilSV.class);

		String[] rcode = null;
		try {
			if (null == mainId || "".equals(mainId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {
				rcode = taskUtilSV.createWorkflow(flowType, staffId, mainId,
						result, null);
			}
			if ("0000".equals(rcode[0])) {
				if ("saleCase".equals(flowType) || "saleCaseT".equals(flowType)
						|| "saleCaseI".equals(flowType)
						|| "saleCaseZQ".equals(flowType)) {
					
					iboSaleOrderValue.setState("2");
					iSaleOrderSV.saveSaleOrderInfo(iboSaleOrderValue);
					//所有关联武器状态修改为已提交
					iSaleOrderSV.changeWeaponStateTo(mainId, "C");
					
				} else if ("chargeCase".equals(flowType)
						|| "chargeCaseT".equals(flowType)
						|| "newChargeCaseP".equals(flowType)
						|| "newChargeCaseT".equals(flowType)
						|| "chargeCaseZQ".equals(flowType)
						|| "UniteChargeFlow".equals(flowType)) {

					iBOChargeMainValue.setState("2");
					String updateSubmitState = iChargeMainSV
							.saveChargeNewMain(iBOChargeMainValue);

					if (!StringUtil.isNotBlank(updateSubmitState)) {
						cp.set("FLAG", "N");
						cp.set("MESSAGE", "资费申请单保存提交状态失败");
					}
				} else if ("accessCaseT".equals(flowType)) {
					iBOAccessChangeValue.setState("2");
					int accessId = iAccessChangeSV
							.saveAccessChange(iBOAccessChangeValue);
					if (StringUtil.isNotBlank(String.valueOf(accessId))) {
						//
					} else {
						cp.set("FLAG", "N");
						cp.set("MESSAGE", "业务变更申请单保存提交状态失败");
					}
				} else if ("busiChangeCase".equals(flowType)
						|| "busiChangeCaseP".equals(flowType)
						|| "channelChangeCase".equals(flowType)
						|| "activityDelayCase".equals(flowType)) {
					busiChangeValue.setState("2");
					busiChangeSV.saveBusiChange(busiChangeValue);
				} else if ("prestoreCase".equals(flowType)) {
					IBOSaleBatchPrestoreValue.setIsSubmit("2");
					ISaleBatchPrestoreSV
							.saveSaleBatchPrestore(IBOSaleBatchPrestoreValue);
				} else if ("chargeSellStopCaseT".equals(flowType)
						|| "chargeSellStopCaseP".equals(flowType)
						|| "saleSellStopCaseT".equals(flowType)
						|| "saleSellStopCaseP".equals(flowType)) {
					stopSellMValue.setState("2");
					stopSellMSV
							.save(new IBOStopSellMValue[] { stopSellMValue });
				} else if ("complainCase".equals(flowType)) {
					iBOOrderComplainsValue.setState("2");
					iOrderComplainSV.saveOrderComplain(iBOOrderComplainsValue);
				} else if ("resChangeCase".equals(flowType)){
					resChangeValue.setState("2");
					resChangeSV.saveResourceChange(resChangeValue);
				}
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", rcode[1]);
			} else {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", rcode[1]);
			}
		} catch (Exception e) {
			// 操作失败
			log.error("提交审核出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "提交审核失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	/**
	 * 提交下一节点
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void finishUserTask(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String taskId = request.getParameter("taskId");
		String result = request.getParameter("result");
		String nextStepStaff = request.getParameter("staffId");
		String comment = request.getParameter("comment");
		String reason = request.getParameter("reason").replace("^#", "%");
		String auditFlag = request.getParameter("auditFlag");
		String nextTaskTag = request.getParameter("nextTaskTag");
		String taskTag = request.getParameter("taskTag");
		String workfId = request.getParameter("workfId");
		
		if(result.equals("yq")&&nextTaskTag.equals("YQ001")){
			nextStepStaff=nextStepStaff+";"+"00000000333333333;00000000444444444";
			if(nextStepStaff.indexOf("111111111")>=0){
				nextStepStaff=nextStepStaff+";00000000555555555";
			}
		}
		ITaskUtilSV taskUtilSV = (ITaskUtilSV) ServiceFactory
				.getService(ITaskUtilSV.class);
		IVmTaskSV vmTaskSV = (IVmTaskSV) ServiceFactory
		.getService(IVmTaskSV.class);
		String[] rcode = null;
		try {
			if ("".equals(taskId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {
				rcode = taskUtilSV.finishUserTask(taskId, result, "",
						nextStepStaff, comment, reason, auditFlag);
				
			}
			//业务支撑中心配置NCODE与渠道中心审核分配前审批
			if(result!=null&&nextTaskTag!=null){
				if(result.equals("yq")&&nextTaskTag.equals("YQ001")){
					Thread t = new TaskSignThread(workfId, nextTaskTag);
					t.start();
				}
			}
			
			//业务支撑中心配置NCODE与渠道中心审核分配
			if(taskTag!=null&&taskTag.equals("YQ001")){
				/*IBOVmTaskTsValue[] signTaskValues =  vmTaskSV.getVmTaskTsByWFId(workfId, taskTag);
				IBOVmTaskTsValue curTask = vmTaskSV.getVmTaskTsByTaskId(taskId);
				String curLable = curTask.getLabel();
				if(curLable.equals("业支配置NCODE审核人审核")){
					for(IBOVmTaskTsValue task:signTaskValues){
						String lable = task.getLabel();
						if(lable.equals("业务支撑中心配置NCODE")){
							task.setTaskStaffId(nextStepStaff);
							vmTaskSV.saveVmTaskTs(task);
						}
					}
				}*/
				int lableA = 0;
				int lableB = 0;
				IBOVmTaskTsValue[] signTaskValues =  vmTaskSV.getVmTaskTsByWFId(workfId, taskTag);
				IBOVmTaskTsValue curTask = vmTaskSV.getVmTaskTsByTaskId(taskId);
				String curLable = curTask.getLabel();
				
				IBOVmTaskTsValue taskC = null;//业务支撑中心配置NCOD
				IBOVmTaskTsValue taskD = null;//中心审核人审核
				IBOVmTaskTsValue taskE = null;//短渠或电渠配置上线
				for(IBOVmTaskTsValue task:signTaskValues){
					String lable = task.getLabel();
					int state = task.getState();
					if(lable.equals("业支配置NCODE审核人审核")){
						
					}else if(lable.equals("渠道中心审核分配")){
						lableA=state;
					}else if(lable.indexOf("中心审核人审核")>=0) {
						taskD=task;
					}else if(lable.equals("业务支撑中心配置NCODE")){
						lableB=state;
						taskC=task;
					}else{
						taskE=task;
					}
				}
				//配置中心审核人
				if(curLable.equals("渠道中心审核分配")){
					String nextLableCode = request.getParameter("nextLable");
					if(taskD!=null){
						if(nextLableCode.equals("A")){
							taskD.setLabel("新业务中心审核人审核");
							taskE.setLabel("新业务配置或开发本省电子渠道上线");
						}else if(nextLableCode.equals("B")){
							taskD.setLabel("业务支撑中心审核人审核");
							taskE.setLabel("业支开发配置或开发短信渠道上线");
						}else{
							taskD.setLabel("渠道中心审核人审核");
							taskE.setLabel("渠道配置一级渠道上线");
						}
						if(lableB==0||lableB==3){
							taskD.setTaskStaffId(nextStepStaff);
						}else{
							taskD.setTaskStaffId(nextStepStaff+"333333333");
						}
						vmTaskSV.saveVmTaskTs(taskD);
						vmTaskSV.saveVmTaskTs(taskE);
					}
				}else if(curLable.equals("业支配置NCODE审核人审核")){
					taskC.setTaskStaffId(nextStepStaff);
					vmTaskSV.saveVmTaskTs(taskC);
					
				}else if(curLable.indexOf("中心审核人审核")>=0){
					taskE.setTaskStaffId(nextStepStaff);
					vmTaskSV.saveVmTaskTs(taskE);
				}
				//渠道中心审核分配与业务支撑中心配置NCODE配置完成则中心审核人可以审核
				if(lableA==3&&lableB==3&&taskD.getTaskStaffId().length()>9){
					if(taskD!=null){
						String dTaskStaffid = taskD.getTaskStaffId();
						taskD.setTaskStaffId(dTaskStaffid.substring(0, dTaskStaffid.length()-9));
						vmTaskSV.saveVmTaskTs(taskD);
					}
				}
				
			}
			

			cp.set("FLAG", "Y");
			cp.set("MESSAGE", rcode[1]);
		} catch (Exception e) {
			// 操作失败
			log.error("提交出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "提交失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	/**
	 * 获取YQ当前
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void getCurVsTask (HttpServletRequest request,
	HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String taskId = request.getParameter("taskId");

		IVmTaskSV vmTaskSV = (IVmTaskSV) ServiceFactory
				.getService(IVmTaskSV.class);

		try {
			if ("".equals(taskId)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {
				// 提交前任务
				IBOVmTaskTsValue curTask = vmTaskSV.getVmTaskTsByTaskId(taskId);
				String lable = curTask.getLabel();
				if(lable.equals("业支配置NCODE审核人审核")){
					cp.set("FLAG", "Y");
					cp.set("TYPE", "A");
					cp.set("MESSAGE", lable);
				}else if(lable.equals("渠道中心审核分配")){
					cp.set("FLAG", "Y");
					cp.set("TYPE", "B");
					cp.set("MESSAGE", lable);
				}else if(lable.equals("业务支撑中心配置NCODE")){
					cp.set("FLAG", "Y");
					cp.set("TYPE", "C");
					cp.set("MESSAGE", lable);
				}else if(lable.indexOf("中心审核人审核")>=0){
					cp.set("FLAG", "Y");
					cp.set("TYPE", "D");
					cp.set("MESSAGE", lable);
				}else {
					cp.set("FLAG", "Y");
					cp.set("TYPE", "E");
					cp.set("MESSAGE", lable);
				}
			}
		} catch (Exception e) {
			// 操作失败
			log.error("提交出错", e);
			cp.set("FLAG", "N");
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
	/**
	 * 加办
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void reAuthorizeTask(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String taskId = request.getParameter("taskId");
		String reAuthorizeStaff = String.valueOf(SessionManager.getUser()
				.getID());
		String nextStaffId = request.getParameter("nextStaffId");

		ITaskUtilSV taskUtilSV = (ITaskUtilSV) ServiceFactory
				.getService(ITaskUtilSV.class);
		String[] rcode = null;
		try {
			rcode = taskUtilSV.reAuthorizeTask(taskId, reAuthorizeStaff,
					nextStaffId);
			if ("0000".equals(rcode[0])) {
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", rcode[1]);
			} else {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", rcode[1]);
			}
		} catch (Exception e) {
			// 操作失败
			log.error("加办失败！", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "加办失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void autoAuditWeaponTask(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String orderId = request.getParameter("mainId");
		String curStaff = "20005341";
		String nextStepStaff = "20004952";
		ITaskUtilSV taskUtilSV = (ITaskUtilSV) ServiceFactory
				.getService(ITaskUtilSV.class);
		ISaleWeaponSV saleWeaponSV = (ISaleWeaponSV) ServiceFactory
				.getService(ISaleWeaponSV.class);
		Map<String, String> wpIdTaskIdMap = TaskUtil
				.getCurWpTaskBySaleOrderId(orderId);
		Set<String> finishedTaskId = new HashSet<String>();
		try {
			for (Map.Entry<String, String> entry : wpIdTaskIdMap.entrySet()) {
				String tmpTaskId = entry.getValue();
				String result;
				if (tmpTaskId != null && !tmpTaskId.equals("")
						&& !finishedTaskId.contains(tmpTaskId)) {
					IBOSaleWeaponValue weapon = saleWeaponSV
							.getSaleWeaponOnlyByID(entry.getKey())[0];
					if (saleWeaponSV
							.getSpareTagDetailByWeaponId(entry.getKey()).length > 0) {
						result = "pz";
						weapon.setState("W");
					} else {
						result = "0";
						weapon.setState("U");
					}
					taskUtilSV.finishUserTask(tmpTaskId, result, curStaff,
							nextStepStaff, "", "同意", "ok");
					saleWeaponSV
							.saveSaleWeapon(new IBOSaleWeaponValue[] { weapon });
					finishedTaskId.add(tmpTaskId);
				}
			}

		} catch (Exception e) {
			// 操作失败
			log.error("自动审核武器失败！", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "自动审核武器失败" + ":" + e.getMessage());
		} finally {
			// HttpUtil.showInfo(response, cp);
		}
	}

	public void getDefaultPsByRoleAndOrg(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String roleId = request.getParameter("roleId");
		String orgId = request.getParameter("orgId");
		String[] opStaff;
		try {
			opStaff = TaskUtil.getDefaultPsByRoleAndOrg(roleId, orgId);
			if (opStaff[0] == "") {
				cp.set("FLAG", "N");
			} else {
				cp.set("FLAG", "Y");
				cp.set("opIds", opStaff[0]);
				cp.set("stNames", opStaff[1]);
			}
		} catch (Exception e) {
			// 操作失败
			log.error("获取默认人员失败！", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "获取默认人员失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
	
	public void getSignResult(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String taskId = request.getParameter("taskId");
		String signResult;
		try {
			signResult = TaskUtil.getSignResult(taskId);
			if (signResult == "") {
				cp.set("FLAG", "N");
			} else {
				cp.set("FLAG", "Y");
				cp.set("signResult",signResult);
			}
		} catch (Exception e) {
			// 操作失败
			log.error("获取会签结果失败！", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "获取会签结果失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
}
