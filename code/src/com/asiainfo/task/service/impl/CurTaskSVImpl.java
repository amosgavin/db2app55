package com.asiainfo.task.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

import com.asiainfo.task.ivalues.IBOHistoryTaskValue;
import com.asiainfo.task.ivalues.IBOCurTaskValue;
import com.asiainfo.task.service.interfaces.ICurTaskSV;
import com.asiainfo.task.dao.interfaces.ICurTaskDAO;
import com.ai.appframe2.service.ServiceFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.ai.secframe.orgmodel.service.interfaces.ISecOrganizeSV;
import com.ai.secframe.orgmodel.service.interfaces.ISecOperatorSV;
import com.ai.secframe.orgmodel.ivalues.IBOSecOrganizeValue;
import com.ai.secframe.orgmodel.ivalues.IQBOSecOrgStaffOperValue;
import com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponMainSV;
import com.asiainfo.task.ivalues.IBOFinishTaskValue;
import com.asiainfo.sale.activity.service.interfaces.ISaleMainShowSV;
import com.asiainfo.sale.activity.ivalues.IBOSaleInfoValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleDetailShowValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleMainShowValue;
import com.ai.appframe2.common.SessionManager;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponInfoValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponDeValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponMainDeValue;


public class CurTaskSVImpl implements ICurTaskSV {
	
	//private static ConcurrentHashMap<String, String> ordIdTowfIdCache = new ConcurrentHashMap<String, String>();
	/**
	 * 说明:根据workflowId查询出所有已归档的的已完成任务数
	 * workflowId:流程ID
	 * **/
	public int getAllHistoryTaskCount(String workflowId) throws Exception,RuntimeException{
		int cnt = ((ICurTaskDAO) ServiceFactory.getService(ICurTaskDAO.class)).getAllHistoryTaskCount(workflowId);
		return cnt;
	}
	
	/*
	 * 说明：提供给知会功能，要求根据workflow_id 查询出当前和已归档的工单流程信息
	 */
	public IBOCurTaskValue[] getTaskByWorkFlowIdForQ(String recordId,String state,int startNum, int endNum){
		
		try{
			String workflowId = getWorkflowIdByrecordId(recordId, state);
			if (state.equals("2")) {
				return getAllTaskByWorkFlowId(workflowId,startNum, endNum);
			} else if (state.equals("3") || state.equals("4")) {
				return getAllHistoryTaskByWorkFlowId(workflowId,startNum, endNum);
			}
		} catch (RuntimeException e2){
			throw e2;
		} catch (Exception e1){
		}
		return null;
	}
	
	/*
	 * 说明：提供给知会功能，要求根据workflow_id 查询出当前和已归档的工单流程数
	 */
	public int getTaskByWorkFlowIdForQCnt(String recordId,String state){
		int r=0;
		try{
			String workflowId = getWorkflowIdByrecordId(recordId, state);
			if (state.equals("2")) {
				r = getAllCurTaskCount(workflowId);
			} else if (state.equals("3") || state.equals("4")) {
				r = getAllHistoryTaskCount(workflowId);
			}
		} catch (RuntimeException e2){
			throw e2;
		} catch (Exception e1){
		}
		return r;
	}
	
	
	/**
	 * 说明:根据workflowId查询出所的已完成任务任务数
	 * roleId:岗位ID
	 * staffId：员工号
	 * **/
	public int getAllCurTaskCount(String workflowId) throws Exception,RuntimeException{
		IBOCurTaskValue[] taskList = null;

		int cnt = ((ICurTaskDAO) ServiceFactory.getService(ICurTaskDAO.class)).getAllCurTaskCount(workflowId);

		return cnt;
	}
	

	/**
	 * 说明:根据岗位ID和员工号查询所有待处理工单 roleId:岗位ID staffId：员工号
	 * **/
	public IBOCurTaskValue[] getCurTask(String staffId,int startNum, int endNum) throws Exception,
			RuntimeException {
		IBOCurTaskValue[] taskList = null;
		ICurTaskDAO curTaskDAO= (ICurTaskDAO) ServiceFactory.getService(ICurTaskDAO.class);
		taskList = curTaskDAO.getCurTask(staffId,startNum,endNum);
		String proxyStaffid = curTaskDAO.getProxyStaff(staffId);
		if(proxyStaffid!="-1"){
			for(int i=0;i<taskList.length;i++){
				taskList[i].setStateName("(工单已被代理)");
				taskList[i].setState(12);				
			}
		}
		return taskList;
	}
	
	/**
	 * 说明:员工号查询待处理工单数量
	 * staffId：员工号
	 * **/
	public int getCurCount(String staffId) throws Exception,RuntimeException{
 	   int cnt = ((ICurTaskDAO) ServiceFactory.getService(ICurTaskDAO.class)).getCurCount(staffId);

       return cnt;
	}
	

	/**
	 * 说明:根据workflowId查询出所的任务 roleId:岗位ID staffId：员工号
	 * **/
	public IBOCurTaskValue[] getAllTaskByWorkFlowId(String workflowId,int startNum, int endNum)
			throws Exception, RuntimeException {
		IBOCurTaskValue[] taskList = null;
		ICurTaskDAO curTaskDAO = (ICurTaskDAO)ServiceFactory.getService(ICurTaskDAO.class);
		ISecOrganizeSV secOrganizeSV = (ISecOrganizeSV)ServiceFactory.getService(ISecOrganizeSV.class);
		ISecOperatorSV secOperatorSV = (ISecOperatorSV)ServiceFactory.getService(ISecOperatorSV.class);
		taskList = curTaskDAO.getAllTaskByWorkFlowId(workflowId, startNum,  endNum);
		
		//获取当前处理环节
		for(int i=0;i<taskList.length;i++){
			if(taskList[i].getState()==Long.valueOf(5)){
				//被代理人的姓名
				String authorName = taskList[i].getTaskStaffName();
				//获取当前环节的代理人id
				String proxyStaffid = curTaskDAO.getProxyStaff(taskList[i].getTaskStaffId());
				if(proxyStaffid!="-1"){
					//获取当前环节代理人的姓名、部门id
					String condition = IQBOSecOrgStaffOperValue.S_OperatorId+"= :operatorid ";
					HashMap<String,String> para = new HashMap<String,String>();
					para.put("operatorid", proxyStaffid);
					IQBOSecOrgStaffOperValue secOrgOp = secOperatorSV.getOperQBOByOperId(Long.valueOf(proxyStaffid));
					
					String staffName = secOrgOp.getStaffName();
					String departName = secOrgOp.getOrganizeName();
					String departId = String.valueOf(secOrgOp.getOrganizeId());
					//获取当前代理人单位名称
					IBOSecOrganizeValue organize = secOrganizeSV.getSecOrganizeById(Long.valueOf(departId.substring(0, 2)), false); 
						
				    //BOSecOrganizeEngine.getBean(Long.valueOf(departId.substring(0, 2))); 
                    String orgname = organize.getOrganizeName();
                    taskList[i].setTaskStaffName(staffName);
                    taskList[i].setCorporation(orgname);
                    taskList[i].setOrgName(departName);
                    // 任务说明信息
                    String comment = staffName+"代理了"+authorName+"的工作";
                    taskList[i].setErrorMessage(comment);
				}
			}
		}
		return taskList;
	}

	/**
	 * 说明:根据岗位ID、员工号和工单类型查询所有待处理工单 roleId:岗位ID staffId：员工号
	 * **/
	public IBOCurTaskValue[] getAllCurTaskByCaseType(String staffId,
			String caseType,int startNum, int endNum) throws Exception, RuntimeException {
		IBOCurTaskValue[] taskList = null;

		taskList = ((ICurTaskDAO) ServiceFactory.getService(ICurTaskDAO.class))
				.getAllCurTaskByCaseType(staffId, caseType, startNum, endNum);

		return taskList;
	}

	/**
	 * 说明:根据岗位ID、员工号和工单类型查询所有待处理工单 roleId:岗位ID staffId：员工号
	 * **/
	public int getCurCountByType(String staffId, String caseType) throws Exception, RuntimeException {
		int num =0;

		num = ((ICurTaskDAO) ServiceFactory.getService(ICurTaskDAO.class))
				.getCurCountByType(staffId, caseType);

		return num;
	}
	
	/**
	 * 说明:根据岗位ID、员工号、开始时间、结束时间查询所有已处理工单 roleId:岗位ID staffId：员工号 endTime:结束时间
	 * beginTime:结束时间
	 * **/
	public IBOFinishTaskValue[] getFinishTask(String staffId, String beginTime,
			String endTime,String applyname,String objectid,String corporation,String staffname,int startNum, int endNum) throws Exception, RuntimeException {
		IBOFinishTaskValue[] taskList = null;
		if(applyname != null){
			applyname = URLDecoder.decode(applyname,"utf-8");
		}
		if(corporation != null){
			corporation = URLDecoder.decode(corporation,"utf-8");
		}
		if(staffname != null){
			staffname = URLDecoder.decode(staffname,"utf-8");
		}
		taskList = ((ICurTaskDAO) ServiceFactory.getService(ICurTaskDAO.class))
				.getFinishTask(staffId, beginTime, endTime,applyname,objectid,corporation,staffname, startNum, endNum);

		return taskList;
	}

	/**
	 * 说明:根据岗位ID、员工号、开始时间、结束时间查询所有已处理工单数量
	 * roleId:岗位ID staffId：员工号 endTime:结束时间
	 * beginTime:结束时间
	 * **/
	public int getFinishTaskCount(String staffId, String beginTime,
			String endTime,String applyname,String objectid,String corporation,String staffname) throws Exception, RuntimeException {
		int taskcnt = 0;

		if(applyname != null){
			applyname = URLDecoder.decode(applyname,"utf-8");
		}
		if(corporation != null){
			corporation = URLDecoder.decode(corporation,"utf-8");
		}
		if(staffname != null){
			staffname = URLDecoder.decode(staffname,"utf-8");
		}
		taskcnt = ((ICurTaskDAO) ServiceFactory.getService(ICurTaskDAO.class))
				.getFinishTaskCount(staffId, beginTime, endTime,applyname,objectid,corporation,staffname);

		return taskcnt;
	}
	
	/**
	 * 说明:根据岗位ID、员工号、开始时间、结束时间查询所有已归档工单 roleId:岗位ID staffId：员工号 endTime:结束时间
	 * beginTime:结束时间
	 * **/
	public IBOHistoryTaskValue[] getHistoryTask(String staffId,
			String beginTime, String endTime) throws Exception,
			RuntimeException {
		IBOHistoryTaskValue[] taskList = null;

		taskList = ((ICurTaskDAO) ServiceFactory.getService(ICurTaskDAO.class))
				.getHistoryTask(staffId, beginTime, endTime);

		return taskList;
	}

	/**
	 * 说明:根据岗位ID、员工号、开始时间、结束时间工单(如果处理多个任务，则只显示一条)
	 * roleId:岗位ID
	 * staffId：员工号
	 * endTime:结束时间
	 * beginTime:结束时间
	 * **/
	public IBOFinishTaskValue[] getHistoryRecord(String staffId,
			String beginTime, String endTime,String applyname,String objectid,String corporation,String staffname,int startNum, int endNum) throws Exception,
			RuntimeException {
		IBOFinishTaskValue[] taskList = null;
		if(applyname != null){
			applyname = URLDecoder.decode(applyname,"utf-8");
		}
		if(corporation != null){
			corporation = URLDecoder.decode(corporation,"utf-8");
		}
		if(staffname != null){
			staffname = URLDecoder.decode(staffname,"utf-8");
		}
		taskList = ((ICurTaskDAO) ServiceFactory.getService(ICurTaskDAO.class))
				.getHistoryRecord(staffId, beginTime, endTime,applyname,objectid,corporation,staffname,startNum, endNum);

		return taskList;
	}

	/**
	 * 说明:根据岗位ID、员工号、开始时间、结束时间工单记录数
	 * roleId:岗位ID
	 * staffId：员工号
	 * endTime:结束时间
	 * beginTime:结束时间
	 * **/
	public int getHistoryCount(String staffId,String beginTime, String endTime,String applyname,String objectid,String corporation,String staffname) throws Exception,
			RuntimeException {
		int taskCnt = 0;
		if(applyname != null){
			applyname = URLDecoder.decode(applyname,"utf-8");
		}
		if(corporation != null){
			corporation = URLDecoder.decode(corporation,"utf-8");
		}
		if(staffname != null){
			staffname = URLDecoder.decode(staffname,"utf-8");
		}

		taskCnt = ((ICurTaskDAO) ServiceFactory.getService(ICurTaskDAO.class))
				.getHistoryTaskCount(staffId, beginTime, endTime,applyname,objectid,corporation,staffname);

		return taskCnt;
	}
	
	/**
	 * 说明:根据工单ID、工单类型查询工单审批意见 roleId:岗位ID staffId：员工号 endTime:结束时间
	 * beginTime:结束时间
	 * **/
	public IBOCurTaskValue[] getReasons(String recordId, String recordType)
			throws Exception, RuntimeException {
		IBOCurTaskValue[] taskList = null;

		taskList = ((ICurTaskDAO) ServiceFactory.getService(ICurTaskDAO.class))
				.getReasons(recordId, recordType);

		return taskList;
	}

	/**
	 * 说明:根据workflowId查询出所有已归档的的已完成任务 workflowId:流程ID
	 * **/
	public IBOCurTaskValue[] getAllHistoryTaskByWorkFlowId(String workflowId,int startNum, int endNum)
			throws Exception, RuntimeException {
		IBOCurTaskValue[] taskList = null;

		taskList = ((ICurTaskDAO) ServiceFactory.getService(ICurTaskDAO.class))
				.getAllHistoryTaskByWorkFlowId(workflowId, startNum,  endNum);

		return taskList;
	}

	/**
	 * 说明:根据路径、文件名和工单ID,导出工单信息 dir：绝对路径 fileName:文件名 mId:工单ID
	 * **/
	public Workbook toExcel(String mId, String type)
			throws Exception, RuntimeException {
		Workbook wb = null;
	    try{
			if (type.equals("saleCaseT") || type.equals("saleCase")) {
				wb = exportSaleCase(mId);
			}
			if (type.equals("weaponCase")) {
				wb = exportWeapon(mId);
			}
	    }catch(Exception e){
	    	e.printStackTrace();
	    	return null;
	    }
		return wb;
	}

	/*
	 * 说明：根据路径、文件名和工单ID,导出营销活动信息 dir：绝对路径 fileName:文件名 mId:工单ID
	 */
	public Workbook exportSaleCase(String mId)
			throws Exception, RuntimeException {
		IBOSaleInfoValue saleInfo = ((ISaleMainShowSV) ServiceFactory
				.getService(ISaleMainShowSV.class)).getSaleInfoValue(mId);
		IBOSaleMainShowValue mainValue = saleInfo.getSaleMainShowValue();
		IBOSaleDetailShowValue[] detailValue = saleInfo.gSaleDetailShowValue();
		HttpServletRequest request = SessionManager.getRequest();
		request.getRealPath("/");
		String templateFile = request.getRealPath("/") +"/template/salecase_template.xls";

		InputStream fileIn = new FileInputStream(new File(templateFile));
		Workbook wb = WorkbookFactory.create(fileIn);

		// 填充营销活动主信息
		if (mainValue != null) {
			Sheet sheetMain = wb.getSheetAt(0);
			Row row = null;
			row = sheetMain.getRow(2);
			String name = mainValue.getSaleMainName();
			row.getCell(2).setCellValue(name);
			row.getCell(6).setCellValue(mainValue.getStaffName());
			row = sheetMain.getRow(3);
			row.getCell(2).setCellValue(mainValue.getOrganizeName());
			row.getCell(6).setCellValue(mainValue.getOrganizeName());
			row = sheetMain.getRow(4);
			row.getCell(2).setCellValue(mainValue.getSaleMainCode());
			row.getCell(6).setCellValue(mainValue.getAim());
			row = sheetMain.getRow(5);
			row.getCell(2).setCellValue(mainValue.getBackGround());
			row = sheetMain.getRow(7);
			row.getCell(2).setCellValue(mainValue.getDetailInfo());
			row = sheetMain.getRow(6);
			row.getCell(2).setCellValue(mainValue.getBeginTime());
			row.getCell(6).setCellValue(mainValue.getEndTime());
			row = sheetMain.getRow(9);
			row.getCell(2).setCellValue(mainValue.getIsactiveSale());
			row.getCell(6).setCellValue(mainValue.getActiveSaleSite());
			row = sheetMain.getRow(10);
			row.getCell(2).setCellValue(mainValue.getExearea());
			row = sheetMain.getRow(14);
			row.getCell(2).setCellValue(mainValue.getPrePerson());
			row.getCell(6).setCellValue(mainValue.getPreIncome());
			row = sheetMain.getRow(16);
			row.getCell(2).setCellValue(mainValue.getCostTotal());
			row.getCell(6).setCellValue(mainValue.getElecgoodsCost());
			row = sheetMain.getRow(17);
			row.getCell(2).setCellValue(mainValue.getMobileCost());
			row.getCell(6).setCellValue(mainValue.getGoodsCost());
			row = sheetMain.getRow(18);
			row.getCell(2).setCellValue(mainValue.getElecpayCost());
			row.getCell(6).setCellValue(mainValue.getChannelPay());
			row = sheetMain.getRow(19);
			row.getCell(2).setCellValue(mainValue.getBusinessDiscount());
			row.getCell(6).setCellValue(mainValue.getMobilepayCost());
			row = sheetMain.getRow(20);
			row.getCell(2).setCellValue(mainValue.getEstimateAdFee());
			row.getCell(6).setCellValue(mainValue.getFeeDiscount());
			row = sheetMain.getRow(21);
			row.getCell(2).setCellValue(mainValue.getEstimateOtherFee());
		}

		// 填充营销活动明细信息
		int i01 = 0, i02 = 0, i03 = 0, i04 = 0, i05 = 0, i06 = 0, i07 = 0, i08 = 0, i09 = 0;
		for (int i = 0; i < detailValue.length; i++) {
			String flag = detailValue[i].getSaleFlag();
			// 送电子券
			if (flag.equals("12")) {
				setZFQ(detailValue[i], wb, i01);
				i01=i01+1;
				continue;
			}
			// 送话费
			if (flag.equals("11")) {
				setHF(detailValue[i], wb, i02);
				i02=i02+1;
				continue;
			}
			// 送货品
			if (flag.equals("13")) {
				setGoods(detailValue[i], wb, i03);
				i03=i03+1;
				continue;
			}
			// 送自有业务
			if (flag.equals("14")) {
				setSelfBus(detailValue[i], wb, i04);
				i04=i04+1;
				continue;
			}
			// 组合赠送
			if (flag.equals("15")) {
				setZHZS(detailValue[i], wb, i05);
				i05=i05+1;
				continue;
			}
			// 送终端
			if (flag.equals("21")) {
				setSZD(detailValue[i], wb, i06);
				i06=i06+1;
				continue;
			}
			// 购终端送话费
			if (flag.equals("22")) {
				setGZDSHF(detailValue[i], wb, i07);
				i07=i07+1;
				continue;
			}
			// 数据业务营销
			if (flag.equals("31")) {
				setSJYW(detailValue[i], wb, i08);
				i08=i08+1;
				continue;
			}
			// 其他
			if (flag.equals("41")) {
				setOther(detailValue[i], wb, i09);
				i09=i09+1;
				continue;
			}
		}
        //插入档次统计信息
		Sheet sheetMain = wb.getSheetAt(0);
		sheetMain.getRow(24).getCell(5).setCellValue("共"+i02+"个档次");
		sheetMain.getRow(25).getCell(5).setCellValue("共"+i01+"个档次");
		sheetMain.getRow(26).getCell(5).setCellValue("共"+i03+"个档次");
		sheetMain.getRow(27).getCell(5).setCellValue("共"+i04+"个档次");
		sheetMain.getRow(28).getCell(5).setCellValue("共"+i05+"个档次");
		sheetMain.getRow(30).getCell(5).setCellValue("共"+i06+"个档次");
		sheetMain.getRow(31).getCell(5).setCellValue("共"+i07+"个档次");
		sheetMain.getRow(33).getCell(5).setCellValue("共"+i08+"个档次");
		sheetMain.getRow(35).getCell(5).setCellValue("共"+i09+"个档次");
        //合计
		int total = i01+i02+i03+i04+i05+i06+i07+i08+i09;
		sheetMain.getRow(36).getCell(5).setCellValue("合计"+total+"个档次");
		
		return wb;
	}

	/*
	 * 说明：插入支付券活动 IBOSaleDetailShowValue：明细信息 wb:excel工作台 cnt:计数器
	 */
	public void setZFQ(IBOSaleDetailShowValue detailvalue, Workbook wb, int cnt) {
		Sheet sheet = wb.getSheetAt(1);
		Row row = sheet.createRow(4 + cnt);
		// 细分市场
		row.createCell(1).setCellValue(detailvalue.getMarketName());
		// 网龄
		row.createCell(2).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// 品牌及资费
		row.createCell(3).setCellValue(detailvalue.getBrandDesc());
		// 目标客户清单数据库编号
		row.createCell(4).setCellValue(detailvalue.getTargetListCode());
		// 其他
		row.createCell(5).setCellValue(detailvalue.getOtherUserinfo());
		// 档次说明
		row.createCell(6).setCellValue(detailvalue.getLevelDesc());
		// 办理渠道
		row.createCell(7).setCellValue(detailvalue.getOpenChannel());
		// 允许最大参与用户数
		row.createCell(8).setCellValue(detailvalue.getMaxPerson());
		// 预计用户规模(户）
		row.createCell(9).setCellValue(detailvalue.getPrePerson());
		// 客户回报率
		row.createCell(10).setCellValue(detailvalue.getBackProportion());
		// 预存/赠送比例
		row.createCell(11).setCellValue(detailvalue.getPreStoreToPresent());
		// 预计收入(元）
		row.createCell(12).setCellValue(detailvalue.getPreIncome());
		// 预计成本(元）
		row.createCell(13).setCellValue(detailvalue.getPreBaseFee());
		// 预存话费金额(元）
		row.createCell(14).setCellValue(detailvalue.getPrestoreFee());
		// 预存一次性到帐(元）
		row.createCell(15).setCellValue(detailvalue.getPrestroreReachAccount());
		// 每月返还金额(元）
		row.createCell(16).setCellValue(detailvalue.getBLimit());
		// 返还月数(月）
		row.createCell(17).setCellValue(detailvalue.getBackMonth());
		// 赠送总面额(元）
		row.createCell(18).setCellValue(detailvalue.getPresentBusi2Amount());
		// 支付券类型
		row.createCell(19).setCellValue(detailvalue.getZfqTypeName());
		// 支付券描述
		row.createCell(20).setCellValue(detailvalue.getZfqType());
		// 每月保底消费(元）
		row.createCell(21).setCellValue(detailvalue.getLLimit());
		// 保底月数(月）
		row.createCell(22).setCellValue(detailvalue.getBaseMonth());
		// 数据包总价值(元）
		row.createCell(23).setCellValue(detailvalue.getDataFee());
		// 业务类型
		row.createCell(24).setCellValue(detailvalue.getBusiType());
		// 业务描述
		row.createCell(25).setCellValue(detailvalue.getSaletypeDesOthersale());
		// 每月价值(元）
		row.createCell(26).setCellValue(detailvalue.getPresentValuePermon());
		// 开通月数(月）
		row.createCell(27).setCellValue(detailvalue.getOpenMonth());
		// 全球通积分(分)
		row.createCell(28).setCellValue(detailvalue.getGlobalScore());
		// 动感地带积分(M值)
		row.createCell(29).setCellValue(detailvalue.getDynamicScore());
		// 家庭积分(分）
		row.createCell(30).setCellValue(detailvalue.getHomeScore());
		// 其他积分(分）
		row.createCell(31).setCellValue("");
		// 互斥要求
		row.createCell(32).setCellValue(detailvalue.getExcludeDemand());
		// 宣传语
		row.createCell(33).setCellValue(detailvalue.getPublicityWord());
		// 渠道酬金政策
		row.createCell(34).setCellValue(detailvalue.getChannelPayPolicy());
		// 档次编码
		row.createCell(35).setCellValue(detailvalue.getSaleActiveCode());
	}

	/*
	 * 说明：插入话费活动 IBOSaleDetailShowValue：明细信息 wb:excel工作台 cnt:计数器
	 */
	public void setHF(IBOSaleDetailShowValue detailvalue, Workbook wb, int cnt) {
		Sheet sheet = wb.getSheetAt(2);
		Row row = sheet.createRow(4 + cnt);
		// 细分市场
		row.createCell(1).setCellValue(detailvalue.getMarketName());
		// 网龄
		row.createCell(2).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// 品牌及资费
		row.createCell(3).setCellValue(detailvalue.getBrandDesc());
		// 目标客户清单数据库编号
		row.createCell(4).setCellValue(detailvalue.getTargetListCode());
		// 其他
		row.createCell(5).setCellValue(detailvalue.getOtherUserinfo());
		// 档次说明
		row.createCell(6).setCellValue(detailvalue.getLevelDesc());
		// 办理渠道
		row.createCell(7).setCellValue(detailvalue.getOpenChannel());
		// 允许最大参与用户数
		row.createCell(8).setCellValue(detailvalue.getMaxPerson());
		// 预计用户规模(户）
		row.createCell(9).setCellValue(detailvalue.getPrePerson());
		// 客户回报率
		row.createCell(10).setCellValue(detailvalue.getBackProportion());
		// 预存/赠送比例
		row.createCell(11).setCellValue(detailvalue.getPreStoreToPresent());
		// 预计收入(元）
		row.createCell(12).setCellValue(detailvalue.getPreIncome());
		// 预计折扣
		row.createCell(13).setCellValue(detailvalue.getPreDiscount());
		// 预存话费金额(元）
		row.createCell(14).setCellValue(detailvalue.getPrestoreFee());
		// 预存一次性到帐(元）
		row.createCell(15).setCellValue(detailvalue.getPrestroreReachAccount());
		// 每月返还金额(元）
		row.createCell(16).setCellValue(detailvalue.getBLimit());
		// 返还月数(月）
		row.createCell(17).setCellValue(detailvalue.getBackMonth());
		// 赠送总面额(元）
		row.createCell(18).setCellValue(detailvalue.getPresentBusiAmount());
		// 赠送一次性到账
		row.createCell(19).setCellValue(detailvalue.getZfqTypeName());
		// 每月赠送金额
		row.createCell(20).setCellValue(detailvalue.getZfqType());
		// 赠送月数
		row.createCell(21).setCellValue(detailvalue.getZfqType());
		// 话费账户属性
		row.createCell(22).setCellValue(detailvalue.getZfqType());
		// 每月保底消费(元）
		row.createCell(23).setCellValue(detailvalue.getLLimit());
		// 保底月数(月）
		row.createCell(24).setCellValue(detailvalue.getBaseMonth());
		// 数据包总价值(元）
		row.createCell(25).setCellValue(detailvalue.getDataFee());
		// 业务类型
		row.createCell(26).setCellValue(detailvalue.getBusiType());
		// 业务描述
		row.createCell(27).setCellValue(detailvalue.getSaletypeDesOthersale());
		// 每月价值(元）
		row.createCell(28).setCellValue(detailvalue.getPresentValuePermon());
		// 开通月数(月）
		row.createCell(29).setCellValue(detailvalue.getOpenMonth());
		// 全球通积分(分)
		row.createCell(30).setCellValue(detailvalue.getGlobalScore());
		// 动感地带积分(M值)
		row.createCell(31).setCellValue(detailvalue.getDynamicScore());
		// 家庭积分(分）
		row.createCell(32).setCellValue(detailvalue.getHomeScore());
		// 其他积分(分）
		row.createCell(33).setCellValue("");
		// 互斥要求
		row.createCell(34).setCellValue(detailvalue.getExcludeDemand());
		// 宣传语
		row.createCell(35).setCellValue(detailvalue.getPublicityWord());
		// 渠道酬金政策
		row.createCell(36).setCellValue(detailvalue.getChannelPayPolicy());
		// 档次编码
		row.createCell(37).setCellValue(detailvalue.getSaleActiveCode());
	}

	/*
	 * 说明：插入送货品活动 IBOSaleDetailShowValue：明细信息 wb:excel工作台 cnt:计数器
	 */
	public void setGoods(IBOSaleDetailShowValue detailvalue, Workbook wb,
			int cnt) {
		Sheet sheet = wb.getSheetAt(3);
		Row row = sheet.createRow(4 + cnt);
		// 细分市场
		row.createCell(1).setCellValue(detailvalue.getMarketName());
		// 网龄
		row.createCell(2).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// 品牌及资费
		row.createCell(3).setCellValue(detailvalue.getBrandDesc());
		// 目标客户清单数据库编号
		row.createCell(4).setCellValue(detailvalue.getTargetListCode());
		// 其他
		row.createCell(5).setCellValue(detailvalue.getOtherUserinfo());
		// 档次说明
		row.createCell(6).setCellValue(detailvalue.getLevelDesc());
		// 办理渠道
		row.createCell(7).setCellValue(detailvalue.getOpenChannel());
		// 允许最大参与用户数
		row.createCell(8).setCellValue(detailvalue.getMaxPerson());
		// 预计用户规模(户）
		row.createCell(9).setCellValue(detailvalue.getPrePerson());
		// 客户回报率
		row.createCell(10).setCellValue(detailvalue.getBackProportion());
		// 预存/赠送比例
		row.createCell(11).setCellValue(detailvalue.getPreStoreToPresent());
		// 预计收入(元）
		row.createCell(12).setCellValue(detailvalue.getPreIncome());
		// 预计成本(元）
		row.createCell(13).setCellValue(detailvalue.getPreBaseFee());
		// 预存话费金额(元）
		row.createCell(14).setCellValue(detailvalue.getPrestoreFee());
		// 预存一次性到帐(元）
		row.createCell(15).setCellValue(detailvalue.getPrestroreReachAccount());
		// 每月返还金额(元）
		row.createCell(16).setCellValue(detailvalue.getBLimit());
		// 返还月数(月）
		row.createCell(17).setCellValue(detailvalue.getBackMonth());
		// 货品销售指导价格
		row.createCell(18).setCellValue(detailvalue.getReferencePrice());
		// 货品成本
		row.createCell(19).setCellValue(detailvalue.getGoodsCost());
		// 采购目录
		row.createCell(20).setCellValue(detailvalue.getGoodAdoptDirectory());
		// 货品描述
		row.createCell(21).setCellValue("");
		// 每月保底消费(元）
		row.createCell(22).setCellValue(detailvalue.getLLimit());
		// 保底月数(月）
		row.createCell(23).setCellValue(detailvalue.getBaseMonth());
		// 数据包总价值(元）
		row.createCell(24).setCellValue(detailvalue.getDataFee());
		// 业务类型
		row.createCell(25).setCellValue(detailvalue.getBusiType());
		// 业务描述
		row.createCell(26).setCellValue(detailvalue.getSaletypeDesOthersale());
		// 每月价值(元）
		row.createCell(27).setCellValue(detailvalue.getPresentValuePermon());
		// 开通月数(月）
		row.createCell(28).setCellValue(detailvalue.getOpenMonth());
		// 全球通积分(分)
		row.createCell(29).setCellValue(detailvalue.getGlobalScore());
		// 动感地带积分(M值)
		row.createCell(30).setCellValue(detailvalue.getDynamicScore());
		// 家庭积分(分）
		row.createCell(31).setCellValue(detailvalue.getHomeScore());
		// 其他积分(分）
		row.createCell(32).setCellValue("");
		// 互斥要求
		row.createCell(33).setCellValue(detailvalue.getExcludeDemand());
		// 宣传语
		row.createCell(34).setCellValue(detailvalue.getPublicityWord());
		// 渠道酬金政策
		row.createCell(35).setCellValue(detailvalue.getChannelPayPolicy());
		// 档次编码
		row.createCell(36).setCellValue(detailvalue.getSaleActiveCode());
	}

	/*
	 * 说明：插入送自有业务活动 IBOSaleDetailShowValue：明细信息 wb:excel工作台 cnt:计数器
	 */
	public void setSelfBus(IBOSaleDetailShowValue detailvalue, Workbook wb,
			int cnt) {
		Sheet sheet = wb.getSheetAt(4);
		Row row = sheet.createRow(4 + cnt);
		// 细分市场
		row.createCell(1).setCellValue(detailvalue.getMarketName());
		// 网龄
		row.createCell(2).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// 品牌及资费
		row.createCell(3).setCellValue(detailvalue.getBrandDesc());
		// 目标客户清单数据库编号
		row.createCell(4).setCellValue(detailvalue.getTargetListCode());
		// 其他
		row.createCell(5).setCellValue(detailvalue.getOtherUserinfo());
		// 档次说明
		row.createCell(6).setCellValue(detailvalue.getLevelDesc());
		// 办理渠道
		row.createCell(7).setCellValue(detailvalue.getOpenChannel());
		// 允许最大参与用户数
		row.createCell(8).setCellValue(detailvalue.getMaxPerson());
		// 预计用户规模(户）
		row.createCell(9).setCellValue(detailvalue.getPrePerson());
		// 客户回报率
		row.createCell(10).setCellValue(detailvalue.getBackProportion());
		// 预存/赠送比例
		row.createCell(11).setCellValue(detailvalue.getPreStoreToPresent());
		// 预计收入(元）
		row.createCell(12).setCellValue(detailvalue.getPreIncome());
		// 预计折扣
		row.createCell(13).setCellValue(detailvalue.getPreDiscount());
		// 预存话费金额(元）
		row.createCell(14).setCellValue(detailvalue.getPrestoreFee());
		// 预存一次性到帐(元）
		row.createCell(15).setCellValue(detailvalue.getPrestroreReachAccount());
		// 每月返还金额(元）
		row.createCell(16).setCellValue(detailvalue.getBLimit());
		// 返还月数(月）
		row.createCell(17).setCellValue(detailvalue.getBackMonth());
		
		// 赠送业务总价值
		row.createCell(18).setCellValue(detailvalue.getPresentBusi4Amount());
		// 业务类型
		row.createCell(19).setCellValue(detailvalue.getBusiType());
		// 业务描述
		row.createCell(20).setCellValue("");
		// 每月赠送价值
		row.createCell(21).setCellValue(detailvalue.getValuePermonth());
		// 赠送月数
		row.createCell(22).setCellValue(detailvalue.getPresentBusiMonth());
		
		// 每月保底消费(元）
		row.createCell(23).setCellValue(detailvalue.getLLimit());
		// 保底月数(月）
		row.createCell(24).setCellValue(detailvalue.getBaseMonth());
		// 数据包总价值(元）
		row.createCell(25).setCellValue(detailvalue.getDataFee());
		// 业务类型
		row.createCell(26).setCellValue(detailvalue.getBusiType());
		// 业务描述
		row.createCell(27).setCellValue(detailvalue.getSaletypeDesOthersale());
		// 每月价值(元）
		row.createCell(28).setCellValue(detailvalue.getPresentValuePermon());
		// 开通月数(月）
		row.createCell(29).setCellValue(detailvalue.getOpenMonth());
		// 全球通积分(分)
		row.createCell(30).setCellValue(detailvalue.getGlobalScore());
		// 动感地带积分(M值)
		row.createCell(31).setCellValue(detailvalue.getDynamicScore());
		// 家庭积分(分）
		row.createCell(32).setCellValue(detailvalue.getHomeScore());
		// 其他积分(分）
		row.createCell(33).setCellValue("");
		// 互斥要求
		row.createCell(34).setCellValue(detailvalue.getExcludeDemand());
		// 宣传语
		row.createCell(35).setCellValue(detailvalue.getPublicityWord());
		// 渠道酬金政策
		row.createCell(36).setCellValue(detailvalue.getChannelPayPolicy());
		// 档次编码
		row.createCell(37).setCellValue(detailvalue.getSaleActiveCode());
	}

	/*
	 * 说明：插入组合赠送活动 IBOSaleDetailShowValue：明细信息 wb:excel工作台 cnt:计数器
	 */
	public void setZHZS(IBOSaleDetailShowValue detailvalue, Workbook wb, int cnt) {
		Sheet sheet = wb.getSheetAt(5);
		Row row = sheet.createRow(4 + cnt);
		// 细分市场
		row.createCell(1).setCellValue(detailvalue.getMarketName());
		// 网龄
		row.createCell(2).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// 品牌及资费
		row.createCell(3).setCellValue(detailvalue.getBrandDesc());
		// 目标客户清单数据库编号
		row.createCell(4).setCellValue(detailvalue.getTargetListCode());
		// 其他
		row.createCell(5).setCellValue(detailvalue.getOtherUserinfo());
		// 档次说明
		row.createCell(6).setCellValue(detailvalue.getLevelDesc());
		// 办理渠道
		row.createCell(7).setCellValue(detailvalue.getOpenChannel());
		// 允许最大参与用户数
		row.createCell(8).setCellValue(detailvalue.getMaxPerson());
		// 预计用户规模(户）
		row.createCell(9).setCellValue(detailvalue.getPrePerson());
		// 客户回报率
		row.createCell(10).setCellValue(detailvalue.getBackProportion());
		// 预存/赠送比例
		row.createCell(11).setCellValue(detailvalue.getPreStoreToPresent());
		// 预计收入(元）
		row.createCell(12).setCellValue(detailvalue.getPreIncome());
		// 预计成本(元）
		row.createCell(13).setCellValue(detailvalue.getPreBaseFee());
		// 预计折扣(元）
		row.createCell(14).setCellValue(detailvalue.getPreDiscount());
		// 预存话费金额(元）
		row.createCell(15).setCellValue(detailvalue.getPrestoreFee());
		// 预存一次性到帐(元）
		row.createCell(16).setCellValue(detailvalue.getPrestroreReachAccount());
		// 每月返还金额(元）
		row.createCell(17).setCellValue(detailvalue.getBLimit());
		// 返还月数(月）
		row.createCell(18).setCellValue(detailvalue.getBackMonth());
		//（支付券类）赠送总价值(元）
		row.createCell(19).setCellValue(detailvalue.getPresentBusi2Amount());
		// 详细描述
		row.createCell(20).setCellValue("");
		// （话费类）赠送总价值(元）
		row.createCell(21).setCellValue(detailvalue.getPresentBusiAmount());
		// 详细描述
		row.createCell(22).setCellValue("");
		// 每月保底消费(元）
		row.createCell(23).setCellValue(detailvalue.getLLimit());
		// 保底月数(月）
		row.createCell(24).setCellValue(detailvalue.getBaseMonth());
		// 数据包总价值(元）
		row.createCell(25).setCellValue(detailvalue.getDataFee());
		// 业务类型
		row.createCell(26).setCellValue(detailvalue.getBusiType());
		// 业务描述
		row.createCell(27).setCellValue(detailvalue.getSaletypeDesOthersale());
		// 每月价值(元）
		row.createCell(28).setCellValue(detailvalue.getPresentValuePermon());
		// 开通月数(月）
		row.createCell(29).setCellValue(detailvalue.getOpenMonth());
		// 全球通积分(分)
		row.createCell(30).setCellValue(detailvalue.getGlobalScore());
		// 动感地带积分(M值)
		row.createCell(31).setCellValue(detailvalue.getDynamicScore());
		// 家庭积分(分）
		row.createCell(32).setCellValue(detailvalue.getHomeScore());
		// 其他积分(分）
		row.createCell(33).setCellValue("");
		// 互斥要求
		row.createCell(34).setCellValue(detailvalue.getExcludeDemand());
		// 宣传语
		row.createCell(35).setCellValue(detailvalue.getPublicityWord());
		// 渠道酬金政策
		row.createCell(36).setCellValue(detailvalue.getChannelPayPolicy());
		// 档次编码
		row.createCell(37).setCellValue(detailvalue.getSaleActiveCode());
	}

	/*
	 * 说明：插入送终端活动 IBOSaleDetailShowValue：明细信息 wb:excel工作台 cnt:计数器
	 */
	public void setSZD(IBOSaleDetailShowValue detailvalue, Workbook wb, int cnt) {
		Sheet sheet = wb.getSheetAt(6);
		Row row = sheet.createRow(4 + cnt);
		// 细分市场
		row.createCell(1).setCellValue(detailvalue.getMarketName());
		// 网龄
		row.createCell(2).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// 品牌及资费
		row.createCell(3).setCellValue(detailvalue.getBrandDesc());
		// 目标客户清单数据库编号
		row.createCell(4).setCellValue(detailvalue.getTargetListCode());
		// 其他
		row.createCell(5).setCellValue(detailvalue.getOtherUserinfo());
		// 档次说明
		row.createCell(6).setCellValue(detailvalue.getLevelDesc());
		// 办理渠道
		row.createCell(7).setCellValue(detailvalue.getOpenChannel());
		// 允许最大参与用户数
		row.createCell(8).setCellValue(detailvalue.getMaxPerson());
		// 预计用户规模(户）
		row.createCell(9).setCellValue(detailvalue.getPrePerson());
		// 客户回报率
		row.createCell(10).setCellValue(detailvalue.getBackProportion());
		// 预计收入(元）
		row.createCell(11).setCellValue(detailvalue.getPreIncome());
		// 预计成本(元）
		row.createCell(12).setCellValue(detailvalue.getPreBaseFee());

		// 合约价格
		row.createCell(13).setCellValue(detailvalue.getAgreementValue());
		
		// 预存话费金额(元）
		row.createCell(14).setCellValue(detailvalue.getPrestoreFee());
		// 预存一次性到帐(元）
		row.createCell(15).setCellValue(detailvalue.getPrestroreReachAccount());
		// 每月返还金额(元）
		row.createCell(16).setCellValue(detailvalue.getBLimit());
		// 返还月数(月）
		row.createCell(17).setCellValue(detailvalue.getBackMonth());
		// 话费账户属性
		row.createCell(18).setCellValue(detailvalue.getFeeAccountProperty());
		// 终端实际购买款
		row.createCell(19).setCellValue(detailvalue.getTermRealFee());
		// 终端类型
		row.createCell(20).setCellValue(detailvalue.getTermType());
		// 终端销售指导价格
		row.createCell(21).setCellValue(detailvalue.getTermGuideFee());
		// 终端成本结算价格
		row.createCell(22).setCellValue(detailvalue.getTermCostFee());
		// 终端型号描述
		row.createCell(23).setCellValue("");
		// 每月保底消费(元）
		row.createCell(24).setCellValue(detailvalue.getLLimit());
		// 保底月数(月）
		row.createCell(25).setCellValue(detailvalue.getBaseMonth());
		// 数据包总价值(元）
		row.createCell(26).setCellValue(detailvalue.getDataFee());
		// 业务类型
		row.createCell(27).setCellValue(detailvalue.getBusiType());
		// 业务描述
		row.createCell(28).setCellValue(detailvalue.getSaletypeDesOthersale());
		// 每月价值(元）
		row.createCell(29).setCellValue(detailvalue.getPresentValuePermon());
		// 开通月数(月）
		row.createCell(30).setCellValue(detailvalue.getOpenMonth());
		// 全球通积分(分)
		row.createCell(31).setCellValue(detailvalue.getGlobalScore());
		// 动感地带积分(M值)
		row.createCell(32).setCellValue(detailvalue.getDynamicScore());
		// 家庭积分(分）
		row.createCell(33).setCellValue(detailvalue.getHomeScore());
		// 其他积分(分）
		row.createCell(34).setCellValue("");
		// 互斥要求
		row.createCell(35).setCellValue(detailvalue.getExcludeDemand());
		// 宣传语
		row.createCell(36).setCellValue(detailvalue.getPublicityWord());
		// 渠道酬金政策
		row.createCell(37).setCellValue(detailvalue.getChannelPayPolicy());
		// 档次编码
		row.createCell(38).setCellValue(detailvalue.getSaleActiveCode());
	}

	/*
	 * 说明：插入购终端送话费 IBOSaleDetailShowValue：明细信息 wb:excel工作台 cnt:计数器
	 */
	public void setGZDSHF(IBOSaleDetailShowValue detailvalue, Workbook wb,
			int cnt) {
		Sheet sheet = wb.getSheetAt(7);
		Row row = sheet.createRow(4 + cnt);
		// 细分市场
		row.createCell(1).setCellValue(detailvalue.getMarketName());
		// 网龄
		row.createCell(2).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// 品牌及资费
		row.createCell(3).setCellValue(detailvalue.getBrandDesc());
		// 目标客户清单数据库编号
		row.createCell(4).setCellValue(detailvalue.getTargetListCode());
		// 其他
		row.createCell(5).setCellValue(detailvalue.getOtherUserinfo());
		// 档次说明
		row.createCell(6).setCellValue(detailvalue.getLevelDesc());
		// 办理渠道
		row.createCell(7).setCellValue(detailvalue.getOpenChannel());
		// 允许最大参与用户数
		row.createCell(8).setCellValue(detailvalue.getMaxPerson());
		// 预计用户规模(户）
		row.createCell(9).setCellValue(detailvalue.getPrePerson());
		// 客户回报率
		row.createCell(10).setCellValue(detailvalue.getBackProportion());
		// 预计收入(元）
		row.createCell(11).setCellValue(detailvalue.getPreIncome());
		// 预计折扣(元）
		row.createCell(12).setCellValue(detailvalue.getPreDiscount());

		// 合约价格
		row.createCell(13).setCellValue(detailvalue.getAgreementValue());

		// 终端类型
		row.createCell(14).setCellValue(detailvalue.getTermType());
		// 终端销售指导价格
		row.createCell(15).setCellValue(detailvalue.getTermGuideFee());
		// 终端成本结算价格
		row.createCell(16).setCellValue(detailvalue.getTermCostFee());
		// 终端型号描述
		row.createCell(17).setCellValue("");
		// 终端赠送话费金额
		row.createCell(18).setCellValue(detailvalue.getPresentBusiAmount());
		// 赠送一次性到账
		row.createCell(19).setCellValue(detailvalue.getPresentReachAmount());
		// 每月赠送金额
		row.createCell(20).setCellValue(detailvalue.getPresentValuePermon());
		// 赠送月数
		row.createCell(21).setCellValue(detailvalue.getPresentBusiMonth());
		// 话费账户属性
		row.createCell(22).setCellValue(detailvalue.getFeeAccountProperty());
		// 每月保底消费(元）
		row.createCell(23).setCellValue(detailvalue.getLLimit());
		// 保底月数(月）
		row.createCell(24).setCellValue(detailvalue.getBaseMonth());
		// 数据包总价值(元）
		row.createCell(25).setCellValue(detailvalue.getDataFee());
		// 业务类型
		row.createCell(26).setCellValue(detailvalue.getBusiType());
		// 业务描述
		row.createCell(27).setCellValue(detailvalue.getSaletypeDesOthersale());
		// 每月价值(元）
		row.createCell(28).setCellValue(detailvalue.getPresentValuePermon());
		// 开通月数(月）
		row.createCell(29).setCellValue(detailvalue.getOpenMonth());
		// 全球通积分(分)
		row.createCell(30).setCellValue(detailvalue.getGlobalScore());
		// 动感地带积分(M值)
		row.createCell(31).setCellValue(detailvalue.getDynamicScore());
		// 家庭积分(分）
		row.createCell(32).setCellValue(detailvalue.getHomeScore());
		// 其他积分(分）
		row.createCell(33).setCellValue("");
		// 互斥要求
		row.createCell(34).setCellValue(detailvalue.getExcludeDemand());
		// 宣传语
		row.createCell(35).setCellValue(detailvalue.getPublicityWord());
		// 渠道酬金政策
		row.createCell(36).setCellValue(detailvalue.getChannelPayPolicy());
		// 档次编码
		row.createCell(37).setCellValue(detailvalue.getSaleActiveCode());
	}

	/*
	 * 说明：插入数据业务营销活动 IBOSaleDetailShowValue：明细信息 wb:excel工作台 cnt:计数器
	 */
	public void setSJYW(IBOSaleDetailShowValue detailvalue, Workbook wb, int cnt) {
		Sheet sheet = wb.getSheetAt(8);
		Row row = sheet.createRow(4 + cnt);
		// 细分市场
		row.createCell(1).setCellValue(detailvalue.getMarketName());
		// 网龄
		row.createCell(2).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// 品牌及资费
		row.createCell(3).setCellValue(detailvalue.getBrandDesc());
		// 目标客户清单数据库编号
		row.createCell(4).setCellValue(detailvalue.getTargetListCode());
		// 其他
		row.createCell(5).setCellValue(detailvalue.getOtherUserinfo());
		// 档次说明
		row.createCell(6).setCellValue(detailvalue.getLevelDesc());
		// 办理渠道
		row.createCell(7).setCellValue(detailvalue.getOpenChannel());
		// 允许最大参与用户数
		row.createCell(8).setCellValue(detailvalue.getMaxPerson());
		// 预计用户规模(户）
		row.createCell(9).setCellValue(detailvalue.getPrePerson());
		// 客户回报率
		row.createCell(10).setCellValue(detailvalue.getBackProportion());
		// 预计收入(元）
		row.createCell(11).setCellValue(detailvalue.getPreIncome());
		// 预计成本(元）
		row.createCell(12).setCellValue(detailvalue.getPreBaseFee());
		// 预计折扣(元）
		row.createCell(13).setCellValue(detailvalue.getPreDiscount());
		// 数据包总价值(元）
		row.createCell(14).setCellValue(detailvalue.getDataFee());
		// 业务类型
		row.createCell(15).setCellValue(detailvalue.getBusiType());
		// 业务描述
		row.createCell(16).setCellValue(detailvalue.getSaletypeDesOthersale());
		// 每月价值(元）
		row.createCell(17).setCellValue(detailvalue.getPresentValuePermon());
		// 开通月数(月）
		row.createCell(18).setCellValue(detailvalue.getOpenMonth());
		//（支付券类）赠送总价值(元）
		row.createCell(19).setCellValue(detailvalue.getPresentBusi2Amount());
		// 详细描述
		row.createCell(20).setCellValue("");
		// （话费类）赠送总价值(元）
		row.createCell(21).setCellValue(detailvalue.getPresentBusiAmount());
		// 详细描述
		row.createCell(22).setCellValue("");
		// 全球通积分(分)
		row.createCell(23).setCellValue(detailvalue.getGlobalScore());
		// 动感地带积分(M值)
		row.createCell(24).setCellValue(detailvalue.getDynamicScore());
		// 家庭积分(分）
		row.createCell(25).setCellValue(detailvalue.getHomeScore());
		// 其他积分(分）
		row.createCell(26).setCellValue("");
		// 互斥要求
		row.createCell(27).setCellValue(detailvalue.getExcludeDemand());
		// 宣传语
		row.createCell(28).setCellValue(detailvalue.getPublicityWord());
		// 渠道酬金政策
		row.createCell(29).setCellValue(detailvalue.getChannelPayPolicy());
		// 档次编码
		row.createCell(30).setCellValue(detailvalue.getSaleActiveCode());
	}

	/*
	 * 说明：插入其他营销活动 IBOSaleDetailShowValue：明细信息 wb:excel工作台 cnt:计数器
	 */
	public void setOther(IBOSaleDetailShowValue detailvalue, Workbook wb,
			int cnt) {
		Sheet sheet = wb.getSheetAt(9);
		Row row = sheet.createRow(4 + cnt);
		//营销类型
		row.createCell(1).setCellValue(detailvalue.getSaleFlagName());
		//营销类型说明
		row.createCell(2).setCellValue("");
		// 细分市场
		row.createCell(3).setCellValue(detailvalue.getMarketName());
		// 网龄
		row.createCell(4).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// 品牌及资费
		row.createCell(5).setCellValue(detailvalue.getBrandDesc());
		// 目标客户清单数据库编号
		row.createCell(6).setCellValue(detailvalue.getTargetListCode());
		// 其他
		row.createCell(7).setCellValue(detailvalue.getOtherUserinfo());
		// 档次说明
		row.createCell(8).setCellValue(detailvalue.getLevelDesc());
		// 办理渠道
		row.createCell(9).setCellValue(detailvalue.getOpenChannel());
		// 允许最大参与用户数
		row.createCell(10).setCellValue(detailvalue.getMaxPerson());
		// 预计用户规模(户）
		row.createCell(11).setCellValue(detailvalue.getPrePerson());
		// 预计成本(元）
		row.createCell(12).setCellValue(detailvalue.getCostTotal());
		// 预计折扣(元）
		row.createCell(13).setCellValue(detailvalue.getPreDiscount());
		//赠送总价值(元)
		row.createCell(14).setCellValue(detailvalue.getPresentBusi5Amount()+detailvalue.getPresentBusi3Amount());
		//详细描述
		row.createCell(15).setCellValue("");
		//赠送总价值(元)
		row.createCell(16).setCellValue(detailvalue.getPresentBusiAmount()+detailvalue.getPresentBusi4Amount());
		//详细描述
		row.createCell(17).setCellValue("");
		// 数据包总价值(元）
		row.createCell(18).setCellValue(detailvalue.getDataFee());
		// 业务类型
		row.createCell(19).setCellValue(detailvalue.getBusiType());
		// 业务描述
		row.createCell(20).setCellValue(detailvalue.getSaletypeDesOthersale());
		// 每月价值(元）
		row.createCell(21).setCellValue(detailvalue.getPresentValuePermon());
		// 开通月数(月）
		row.createCell(22).setCellValue(detailvalue.getOpenMonth());
		// 全球通积分(分)
		row.createCell(23).setCellValue(detailvalue.getGlobalScore());
		// 动感地带积分(M值)
		row.createCell(24).setCellValue(detailvalue.getDynamicScore());
		// 家庭积分(分）
		row.createCell(25).setCellValue(detailvalue.getHomeScore());
		// 其他积分(分）
		row.createCell(26).setCellValue("");
		// 互斥要求
		row.createCell(27).setCellValue(detailvalue.getExcludeDemand());
		// 宣传语
		row.createCell(28).setCellValue(detailvalue.getPublicityWord());
		// 渠道酬金政策
		row.createCell(29).setCellValue(detailvalue.getChannelPayPolicy());
		// 档次编码
		row.createCell(30).setCellValue(detailvalue.getSaleActiveCode());
	}
	
	/*
	 * 说明：根据路径、文件名和工单ID,导出武器信息 
	 * mId:工单ID
	 */
	public Workbook exportWeapon(String mId)
			throws Exception, RuntimeException {
		IBOSaleWeaponInfoValue weaponInfo = ((ISaleWeaponMainSV) ServiceFactory
				.getService(ISaleWeaponMainSV.class)).getSaleWeaponInfoValue(mId);
		
		IBOSaleWeaponMainDeValue weaponMain = weaponInfo.getSaleMainShowValue();
		IBOSaleWeaponDeValue[] weaponDetail = weaponInfo.gSaleDetailShowValue();
		
		HttpServletRequest request = SessionManager.getRequest();
		request.getRealPath("/");
		String templateFile = request.getRealPath("/") +"/template/weaponcase_template.xls";
		InputStream fileIn = new FileInputStream(new File(templateFile));
		Workbook wb = WorkbookFactory.create(fileIn);

		// 填充营销活动主信息
		if (weaponMain != null) {
			Sheet sheetMain = wb.getSheetAt(0);
			Row row = null;
			row = sheetMain.getRow(2);
			row.getCell(2).setCellValue(weaponMain.getApplyName());
			row.getCell(6).setCellValue(weaponMain.getStaffName());
			row = sheetMain.getRow(3);
			row.getCell(2).setCellValue(weaponMain.getOrganizeName());
			row.getCell(6).setCellValue(weaponMain.getOrganizeName());
			row = sheetMain.getRow(4);
			row.getCell(2).setCellValue(weaponMain.getRemark());
		}

		// 填充营销活动明细信息
		int i01 = 0, i02 = 0, i03 = 0, i04 = 0, i05 = 0, i06 = 0, i07 = 0, i08 = 0, i09 = 0;
		for (int i = 0; i < weaponDetail.length; i++) {
			String flag = weaponDetail[i].getSaleFlag();
			// 送电子券
			if (flag.equals("12")) {
				setWeaponZFQ(weaponDetail[i], wb, i01);
				i01=i01+1;
				continue;
			}
			// 送话费
			if (flag.equals("11")) {
				setWeaponHF(weaponDetail[i], wb, i02);
				i02=i02+1;
				continue;
			}
			// 送货品
			if (flag.equals("13")) {
				setWeaponGoods(weaponDetail[i], wb, i03);
				i03=i03+1;
				continue;
			}
			// 送自有业务
			if (flag.equals("14")) {
				setWeaponSelfBus(weaponDetail[i], wb, i04);
				i04=i04+1;
				continue;
			}
			// 组合赠送
			if (flag.equals("15")) {
				setWeaponZHZS(weaponDetail[i], wb, i05);
				i05=i05+1;
				continue;
			}
			// 送终端
			if (flag.equals("21")) {
				setWeaponSZD(weaponDetail[i], wb, i06);
				i06=i06+1;
				continue;
			}
			// 购终端送话费
			if (flag.equals("22")) {
				setWeaponGZDSHF(weaponDetail[i], wb, i07);
				i07=i07+1;
				continue;
			}
			// 数据业务营销
			if (flag.equals("31")) {
				setWeaponSJYW(weaponDetail[i], wb, i08);
				i08=i08+1;
				continue;
			}
			// 其他
			if (flag.equals("41")) {
				setWeaponOther(weaponDetail[i], wb, i09);
				i09=i09+1;
				continue;
			}
		}
        //插入档次统计信息
		Sheet sheetMain = wb.getSheetAt(0);
		sheetMain.getRow(7).getCell(5).setCellValue("共"+i02+"个档次");
		sheetMain.getRow(8).getCell(5).setCellValue("共"+i01+"个档次");
		sheetMain.getRow(9).getCell(5).setCellValue("共"+i03+"个档次");
		sheetMain.getRow(10).getCell(5).setCellValue("共"+i04+"个档次");
		sheetMain.getRow(11).getCell(5).setCellValue("共"+i05+"个档次");
		sheetMain.getRow(13).getCell(5).setCellValue("共"+i06+"个档次");
		sheetMain.getRow(14).getCell(5).setCellValue("共"+i07+"个档次");
		sheetMain.getRow(16).getCell(5).setCellValue("共"+i08+"个档次");
		sheetMain.getRow(18).getCell(5).setCellValue("共"+i09+"个档次");
        //合计
		int total = i01+i02+i03+i04+i05+i06+i07+i08+i09;
		sheetMain.getRow(19).getCell(5).setCellValue("合计"+total+"个档次");
		
//		FileOutputStream fileOut = new FileOutputStream(dirfile);
//		wb.write(fileOut);
//		fileOut.flush();
//		fileOut.close();
		return wb;
	}
	
	/*
	 * 说明：插入支付券活动 IBOSaleDetailShowValue：明细信息 wb:excel工作台 cnt:计数器
	 */
	public void setWeaponZFQ(IBOSaleWeaponDeValue detailvalue, Workbook wb, int cnt) {
		Sheet sheet = wb.getSheetAt(1);
		Row row = sheet.createRow(4 + cnt);
		// 档次名称
		row.createCell(1).setCellValue(detailvalue.getWeaponName());
		// 细分市场
		row.createCell(2).setCellValue(detailvalue.getMarketName());
		// 网龄
		row.createCell(3).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// 预存话费金额(元）
		row.createCell(4).setCellValue(detailvalue.getPrestoreFee());
		// 预存一次性到帐(元）
		row.createCell(5).setCellValue(detailvalue.getPrestroreReachAccount());
		// 每月返还金额(元）
		row.createCell(6).setCellValue(detailvalue.getBLimit());
		// 返还月数(月）
		row.createCell(7).setCellValue(detailvalue.getBackMonth());
		// 赠送支付卷总面额(元）
		row.createCell(8).setCellValue(detailvalue.getPresentBusi2Amount());
		// 支付券类型
		row.createCell(9).setCellValue(detailvalue.getZfqName());
		// 支付券描述
		row.createCell(10).setCellValue(detailvalue.getZfqType());
		// 每月保底消费(元）
		row.createCell(11).setCellValue(detailvalue.getLLimit());
		// 保底月数(月）
		row.createCell(12).setCellValue(detailvalue.getBaseMonth());
		// 数据包总价值(元）
		row.createCell(13).setCellValue(detailvalue.getDataFee());
		// 业务类型
		row.createCell(14).setCellValue(detailvalue.getBusiType());
		// 业务描述
		row.createCell(15).setCellValue("");
		// 每月价值(元）
		row.createCell(16).setCellValue(detailvalue.getValuePermonth());
		// 开通月数(月）
		row.createCell(17).setCellValue(detailvalue.getOpenMonth());
		// 全球通积分(分)
		row.createCell(18).setCellValue(detailvalue.getGlobalScore());
		// 神州行积分
		row.createCell(19).setCellValue(detailvalue.getSzxScore());
		// 动感地带积分(M值)
		row.createCell(20).setCellValue(detailvalue.getDynamicScore());
		// 家庭积分(分）
		row.createCell(21).setCellValue(detailvalue.getHomeScore());
	}

	/*
	 * 说明：插入话费活动 IBOSaleDetailShowValue：明细信息 wb:excel工作台 cnt:计数器
	 */
	public void setWeaponHF(IBOSaleWeaponDeValue detailvalue, Workbook wb, int cnt) {
		Sheet sheet = wb.getSheetAt(2);
		Row row = sheet.createRow(4 + cnt);
		// 档次名称
		row.createCell(1).setCellValue(detailvalue.getWeaponName());
		// 细分市场
		row.createCell(2).setCellValue(detailvalue.getMarketName());
		// 网龄
		row.createCell(3).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// 预存话费金额(元）
		row.createCell(4).setCellValue(detailvalue.getPrestoreFee());
		// 预存一次性到帐(元）
		row.createCell(5).setCellValue(detailvalue.getPrestroreReachAccount());
		// 每月返还金额(元）
		row.createCell(6).setCellValue(detailvalue.getBLimit());
		// 返还月数(月）
		row.createCell(7).setCellValue(detailvalue.getBackMonth());
		// 赠送话费金额(元）
		row.createCell(8).setCellValue(detailvalue.getPresentBusiAmount());
		// 赠送一次性到账
		row.createCell(9).setCellValue(detailvalue.getPresentReachAmount());
		// 每月赠送金额
		row.createCell(10).setCellValue(detailvalue.getPresentValuePermon());
		// 赠送月数
		row.createCell(11).setCellValue(detailvalue.getPresentBusiMonth());
		// 每月保底消费(元）
		row.createCell(12).setCellValue(detailvalue.getLLimit());
		// 保底月数(月）
		row.createCell(13).setCellValue(detailvalue.getBaseMonth());
		// 数据包总价值(元）
		row.createCell(14).setCellValue(detailvalue.getDataFee());
		// 业务类型
		row.createCell(15).setCellValue(detailvalue.getBusiType());
		// 业务描述
		row.createCell(16).setCellValue("");
		// 每月价值(元）
		row.createCell(17).setCellValue(detailvalue.getValuePermonth());
		// 开通月数(月）
		row.createCell(18).setCellValue(detailvalue.getOpenMonth());
		// 全球通积分(分)
		row.createCell(19).setCellValue(detailvalue.getGlobalScore());
		// 神州行积分
		row.createCell(20).setCellValue(detailvalue.getSzxScore());
		// 动感地带积分(M值)
		row.createCell(21).setCellValue(detailvalue.getDynamicScore());
		// 家庭积分(分）
		row.createCell(22).setCellValue(detailvalue.getHomeScore());
	}

	/*
	 * 说明：插入送货品活动 IBOSaleDetailShowValue：明细信息 wb:excel工作台 cnt:计数器
	 */
	public void setWeaponGoods(IBOSaleWeaponDeValue detailvalue, Workbook wb,
			int cnt) {
		Sheet sheet = wb.getSheetAt(3);
		Row row = sheet.createRow(4 + cnt);
		// 档次名称
		row.createCell(1).setCellValue(detailvalue.getWeaponName());
		// 细分市场
		row.createCell(2).setCellValue(detailvalue.getMarketName());
		// 网龄
		row.createCell(3).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// 预存话费金额(元）
		row.createCell(4).setCellValue(detailvalue.getPrestoreFee());
		// 预存一次性到帐(元）
		row.createCell(5).setCellValue(detailvalue.getPrestroreReachAccount());
		// 每月返还金额(元）
		row.createCell(6).setCellValue(detailvalue.getBLimit());
		// 返还月数(月）
		row.createCell(7).setCellValue(detailvalue.getBackMonth());
		// 货品销售指导价格
		row.createCell(8).setCellValue(detailvalue.getReferencePrice());
		// 货品成本
		row.createCell(9).setCellValue(detailvalue.getTermCostFee());
		// 采购目录
		row.createCell(10).setCellValue(detailvalue.getGoodAdoptDirectory());
		// 货品描述
		row.createCell(11).setCellValue(detailvalue.getRemark2());
		// 每月保底消费(元）
		row.createCell(12).setCellValue(detailvalue.getLLimit());
		// 保底月数(月）
		row.createCell(13).setCellValue(detailvalue.getBaseMonth());
		// 数据包总价值(元）
		row.createCell(14).setCellValue(detailvalue.getDataFee());
		// 业务类型
		row.createCell(15).setCellValue(detailvalue.getBusiType());
		// 业务描述
		row.createCell(16).setCellValue("");
		// 每月价值(元）
		row.createCell(17).setCellValue(detailvalue.getValuePermonth());
		// 开通月数(月）
		row.createCell(18).setCellValue(detailvalue.getOpenMonth());
		// 全球通积分(分)
		row.createCell(19).setCellValue(detailvalue.getGlobalScore());
		// 神州行积分
		row.createCell(20).setCellValue(detailvalue.getSzxScore());
		// 动感地带积分(M值)
		row.createCell(21).setCellValue(detailvalue.getDynamicScore());
		// 家庭积分(分）
		row.createCell(22).setCellValue(detailvalue.getHomeScore());
	}

	/*
	 * 说明：插入送自有业务活动 IBOSaleDetailShowValue：明细信息 wb:excel工作台 cnt:计数器
	 */
	public void setWeaponSelfBus(IBOSaleWeaponDeValue detailvalue, Workbook wb,
			int cnt) {
		Sheet sheet = wb.getSheetAt(4);
		Row row = sheet.createRow(4 + cnt);
		// 档次名称
		row.createCell(1).setCellValue(detailvalue.getWeaponName());
		// 细分市场
		row.createCell(2).setCellValue(detailvalue.getMarketName());
		// 网龄
		row.createCell(3).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// 预存话费金额(元）
		row.createCell(4).setCellValue(detailvalue.getPrestoreFee());
		// 预存一次性到帐(元）
		row.createCell(5).setCellValue(detailvalue.getPrestroreReachAccount());
		// 每月返还金额(元）
		row.createCell(6).setCellValue(detailvalue.getBLimit());
		// 返还月数(月）
		row.createCell(7).setCellValue(detailvalue.getBackMonth());
		// 赠送业务总价值
		row.createCell(8).setCellValue(detailvalue.getPresentBusi4Amount());
		// 业务类型
		row.createCell(9).setCellValue(detailvalue.getBusiType());
		// 业务描述
		row.createCell(10).setCellValue(detailvalue.getRemark3());
		// 每月赠送价值
		row.createCell(11).setCellValue(detailvalue.getPresentValuePermon());
		// 赠送月数
		row.createCell(12).setCellValue(detailvalue.getPresentBusiMonth());
		// 每月保底消费(元）
		row.createCell(13).setCellValue(detailvalue.getLLimit());
		// 保底月数(月）
		row.createCell(14).setCellValue(detailvalue.getBaseMonth());
		// 数据包总价值(元）
		row.createCell(15).setCellValue(detailvalue.getDataFee());
		// 业务类型
		row.createCell(16).setCellValue(detailvalue.getBusiType());
		// 业务描述
		row.createCell(17).setCellValue("");
		// 每月价值(元）
		row.createCell(18).setCellValue(detailvalue.getValuePermonth());
		// 开通月数(月）
		row.createCell(19).setCellValue(detailvalue.getOpenMonth());
		// 全球通积分(分)
		row.createCell(20).setCellValue(detailvalue.getGlobalScore());
		// 神州行积分
		row.createCell(21).setCellValue(detailvalue.getSzxScore());
		// 动感地带积分(M值)
		row.createCell(22).setCellValue(detailvalue.getDynamicScore());
		// 家庭积分(分）
		row.createCell(23).setCellValue(detailvalue.getHomeScore());
	}

	/*
	 * 说明：插入组合赠送活动 IBOSaleDetailShowValue：明细信息 wb:excel工作台 cnt:计数器
	 */
	public void setWeaponZHZS(IBOSaleWeaponDeValue detailvalue, Workbook wb, int cnt) {
		Sheet sheet = wb.getSheetAt(5);
		Row row = sheet.createRow(4 + cnt);
		// 档次名称
		row.createCell(1).setCellValue(detailvalue.getWeaponName());
		// 细分市场
		row.createCell(2).setCellValue(detailvalue.getMarketName());
		// 网龄
		row.createCell(3).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// 预存话费金额(元）
		row.createCell(4).setCellValue(detailvalue.getPrestoreFee());
		// 预存一次性到帐(元）
		row.createCell(5).setCellValue(detailvalue.getPrestroreReachAccount());
		// 每月返还金额(元）
		row.createCell(6).setCellValue(detailvalue.getBLimit());
		// 返还月数(月）
		row.createCell(7).setCellValue(detailvalue.getBackMonth());
		// 赠送支付卷总面额(元）
		row.createCell(8).setCellValue(detailvalue.getPresentBusi2Amount());
		// 支付券类型
		row.createCell(9).setCellValue(detailvalue.getZfqName());
		// 采购目录
		row.createCell(10).setCellValue(detailvalue.getGoodAdoptDirectory());
		// 货品赠送总价值
		row.createCell(11).setCellValue(detailvalue.getPresentBusi3Amount());
		// 货品销售指导价
		row.createCell(12).setCellValue(detailvalue.getReferencePrice());
		// 赠送话费总价值
		row.createCell(13).setCellValue(detailvalue.getPresentBusiAmount());
		// 一次性到账
		row.createCell(14).setCellValue(detailvalue.getPresentReachAmount());
		// 赠送自有业务总价值
		row.createCell(15).setCellValue(detailvalue.getPresentBusi4Amount());
		// 业务类型
		row.createCell(16).setCellValue(detailvalue.getBusiType());
		// 每月保底消费(元）
		row.createCell(17).setCellValue(detailvalue.getLLimit());
		// 保底月数(月）
		row.createCell(18).setCellValue(detailvalue.getBaseMonth());
		// 数据包总价值(元）
		row.createCell(19).setCellValue(detailvalue.getDataFee());
		// 业务类型
		row.createCell(20).setCellValue(detailvalue.getBusiType());
		// 业务描述
		row.createCell(21).setCellValue("");
		// 每月价值(元）
		row.createCell(22).setCellValue(detailvalue.getValuePermonth());
		// 开通月数(月）
		row.createCell(23).setCellValue(detailvalue.getOpenMonth());
		// 全球通积分(分)
		row.createCell(24).setCellValue(detailvalue.getGlobalScore());
		// 神州行积分
		row.createCell(25).setCellValue(detailvalue.getSzxScore());
		// 动感地带积分(M值)
		row.createCell(26).setCellValue(detailvalue.getDynamicScore());
		// 家庭积分(分）
		row.createCell(27).setCellValue(detailvalue.getHomeScore());
	}

	/*
	 * 说明：插入送终端活动 IBOSaleDetailShowValue：明细信息 wb:excel工作台 cnt:计数器
	 */
	public void setWeaponSZD(IBOSaleWeaponDeValue detailvalue, Workbook wb, int cnt) {
		Sheet sheet = wb.getSheetAt(6);
		Row row = sheet.createRow(4 + cnt);
		// 档次名称
		row.createCell(1).setCellValue(detailvalue.getWeaponName());
		// 细分市场
		row.createCell(2).setCellValue(detailvalue.getMarketName());
		// 网龄
		row.createCell(3).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// 预存话费金额(元）
		row.createCell(4).setCellValue(detailvalue.getPrestoreFee());
		// 预存一次性到帐(元）
		row.createCell(5).setCellValue(detailvalue.getPrestroreReachAccount());
		// 每月返还金额(元）
		row.createCell(6).setCellValue(detailvalue.getBLimit());
		// 返还月数(月）
		row.createCell(7).setCellValue(detailvalue.getBackMonth());
		
		// 终端实际购买款
		row.createCell(8).setCellValue(detailvalue.getTermRealFee());
		// 终端类型
		row.createCell(9).setCellValue(detailvalue.getTermType());
		// 终端销售指导价格
		row.createCell(10).setCellValue(detailvalue.getTermGuideFee());
		// 终端成本结算价
		row.createCell(11).setCellValue(detailvalue.getTermCostFee());
		
		// 每月保底消费(元）
		row.createCell(12).setCellValue(detailvalue.getLLimit());
		// 保底月数(月）
		row.createCell(13).setCellValue(detailvalue.getBaseMonth());
		// 数据包总价值(元）
		row.createCell(14).setCellValue(detailvalue.getDataFee());
		// 业务类型
		row.createCell(15).setCellValue(detailvalue.getBusiType());
		// 业务描述
		row.createCell(16).setCellValue("");
		// 每月价值(元）
		row.createCell(17).setCellValue(detailvalue.getValuePermonth());
		// 开通月数(月）
		row.createCell(18).setCellValue(detailvalue.getOpenMonth());
		// 全球通积分(分)
		row.createCell(19).setCellValue(detailvalue.getGlobalScore());
		// 神州行积分
		row.createCell(20).setCellValue(detailvalue.getSzxScore());
		// 动感地带积分(M值)
		row.createCell(21).setCellValue(detailvalue.getDynamicScore());
		// 家庭积分(分）
		row.createCell(22).setCellValue(detailvalue.getHomeScore());
	}

	/*
	 * 说明：插入购终端送话费 IBOSaleDetailShowValue：明细信息 wb:excel工作台 cnt:计数器
	 */
	public void setWeaponGZDSHF(IBOSaleWeaponDeValue detailvalue, Workbook wb,
			int cnt) {
		Sheet sheet = wb.getSheetAt(7);
		Row row = sheet.createRow(4 + cnt);
		// 档次名称
		row.createCell(1).setCellValue(detailvalue.getWeaponName());
		// 细分市场
		row.createCell(2).setCellValue(detailvalue.getMarketName());
		// 网龄
		row.createCell(3).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());

		// 终端类型
		row.createCell(4).setCellValue(detailvalue.getTermType());
		// 终端销售指导价格
		row.createCell(5).setCellValue(detailvalue.getTermGuideFee());
		// 终端成本结算价
		row.createCell(6).setCellValue(detailvalue.getTermCostFee());
		// 终端型号描述
		row.createCell(7).setCellValue(detailvalue.getRemark4());
		
		// 预存一次性到帐(元）
		row.createCell(8).setCellValue(detailvalue.getPrestroreReachAccount());
		// 每月返还金额(元）
		row.createCell(9).setCellValue(detailvalue.getBLimit());
		// 返还月数(月）
		row.createCell(10).setCellValue(detailvalue.getBackMonth());
		// 话费账户属性
		row.createCell(11).setCellValue(detailvalue.getFeeAccountProperty());		
		
		// 每月保底消费(元）
		row.createCell(12).setCellValue(detailvalue.getLLimit());
		// 保底月数(月）
		row.createCell(13).setCellValue(detailvalue.getBaseMonth());
		// 数据包总价值(元）
		row.createCell(14).setCellValue(detailvalue.getDataFee());
		// 业务类型
		row.createCell(15).setCellValue(detailvalue.getBusiType());
		// 业务描述
		row.createCell(16).setCellValue("");
		// 每月价值(元）
		row.createCell(17).setCellValue(detailvalue.getValuePermonth());
		// 开通月数(月）
		row.createCell(18).setCellValue(detailvalue.getOpenMonth());
		// 全球通积分(分)
		row.createCell(19).setCellValue(detailvalue.getGlobalScore());
		// 神州行积分
		row.createCell(20).setCellValue(detailvalue.getSzxScore());
		// 动感地带积分(M值)
		row.createCell(21).setCellValue(detailvalue.getDynamicScore());
		// 家庭积分(分）
		row.createCell(22).setCellValue(detailvalue.getHomeScore());
	}

	/*
	 * 说明：插入数据业务营销活动 IBOSaleDetailShowValue：明细信息 wb:excel工作台 cnt:计数器
	 */
	public void setWeaponSJYW(IBOSaleWeaponDeValue detailvalue, Workbook wb, int cnt) {
		Sheet sheet = wb.getSheetAt(8);
		Row row = sheet.createRow(4 + cnt);
		// 档次名称
		row.createCell(1).setCellValue(detailvalue.getWeaponName());
		// 细分市场
		row.createCell(2).setCellValue(detailvalue.getMarketName());
		// 网龄
		row.createCell(3).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// 数据包总价值(元）
		row.createCell(4).setCellValue(detailvalue.getDataFee());
		// 业务类型
		row.createCell(5).setCellValue(detailvalue.getBusiType());
		// 业务描述
		row.createCell(6).setCellValue("");
		// 每月价值(元）
		row.createCell(7).setCellValue(detailvalue.getValuePermonth());
		// 开通月数(月）
		row.createCell(8).setCellValue(detailvalue.getOpenMonth());
		// 赠送支付卷总面额(元）
		row.createCell(9).setCellValue(detailvalue.getPresentBusi2Amount());
		// 支付券类型
		row.createCell(10).setCellValue(detailvalue.getZfqName());
		// 采购目录
		row.createCell(11).setCellValue(detailvalue.getGoodAdoptDirectory());
		// 货品赠送总价值
		row.createCell(12).setCellValue(detailvalue.getPresentBusi3Amount());
		// 货品销售指导价
		row.createCell(13).setCellValue(detailvalue.getReferencePrice());
		// 赠送话费总价值
		row.createCell(14).setCellValue(detailvalue.getPresentBusiAmount());
		// 一次性到账
		row.createCell(15).setCellValue(detailvalue.getPresentReachAmount());
		// 赠送自有业务总价值
		row.createCell(16).setCellValue(detailvalue.getPresentBusi4Amount());
		// 业务类型
		row.createCell(17).setCellValue(detailvalue.getBusiType());
		// 全球通积分(分)
		row.createCell(18).setCellValue(detailvalue.getGlobalScore());
		// 神州行积分
		row.createCell(19).setCellValue(detailvalue.getSzxScore());
		// 动感地带积分(M值)
		row.createCell(20).setCellValue(detailvalue.getDynamicScore());
		// 家庭积分(分）
		row.createCell(21).setCellValue(detailvalue.getHomeScore());
	}

	/*
	 * 说明：插入其他营销活动 IBOSaleDetailShowValue：明细信息 wb:excel工作台 cnt:计数器
	 */
	public void setWeaponOther(IBOSaleWeaponDeValue detailvalue, Workbook wb,
			int cnt) {
		Sheet sheet = wb.getSheetAt(9);
		Row row = sheet.createRow(4 + cnt);
		// 档次名称
		row.createCell(1).setCellValue(detailvalue.getWeaponName());
		// 细分市场
		row.createCell(2).setCellValue(detailvalue.getMarketName());
		// 网龄
		row.createCell(3).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// 赠送数字产品
		row.createCell(4).setCellValue(detailvalue.getPresentBusi5Amount());
		// 数字产品描述
		row.createCell(5).setCellValue(detailvalue.getRemark5());
		// 货品赠送总价值
		row.createCell(6).setCellValue(detailvalue.getPresentBusi3Amount());
		// 货品销售指导价
		row.createCell(7).setCellValue(detailvalue.getReferencePrice());
		// 采购目录
		row.createCell(8).setCellValue(detailvalue.getGoodAdoptDirectory());
		// 赠送话费总价值
		row.createCell(9).setCellValue(detailvalue.getPresentBusiAmount());
		// 一次性到账
		row.createCell(10).setCellValue(detailvalue.getPresentReachAmount());
		// 赠送自有业务总价值
		row.createCell(11).setCellValue(detailvalue.getPresentBusi4Amount());
		// 业务类型
		row.createCell(12).setCellValue(detailvalue.getBusiType());
		// 数据包总价值(元）
		row.createCell(13).setCellValue(detailvalue.getDataFee());
		// 业务类型
		row.createCell(14).setCellValue(detailvalue.getBusiType());
		// 业务描述
		row.createCell(15).setCellValue("");
		// 每月价值(元）
		row.createCell(16).setCellValue(detailvalue.getValuePermonth());
		// 开通月数(月）
		row.createCell(17).setCellValue(detailvalue.getOpenMonth());
		// 全球通积分(分)
		row.createCell(18).setCellValue(detailvalue.getGlobalScore());
		// 神州行积分
		row.createCell(19).setCellValue(detailvalue.getSzxScore());
		// 动感地带积分(M值)
		row.createCell(20).setCellValue(detailvalue.getDynamicScore());
		// 家庭积分(分）
		row.createCell(21).setCellValue(detailvalue.getHomeScore());
	}
	
	/*
	 * 说明：根据路径、文件名和工单ID,导出营销活动信息 dir：绝对路径 fileName:文件名 mId:工单ID
	 */
	public boolean exportWeapon(String dir, String fileName, String mId)
			throws Exception, RuntimeException {
		return true;
	}
	
	/**
	 * 说明:根据工单ID、工单状态查询工单审批意见
	 * recordId
	 * **/
	public String getWorkflowIdByrecordId(String recordId,String state) throws Exception,RuntimeException{
		//String workflowId = ordIdTowfIdCache.get(recordId);
		//if (StringUtil.isBlank(workflowId)) {
		String workflowId = ((ICurTaskDAO) ServiceFactory.getService(ICurTaskDAO.class))
			.getWorkflowIdByrecordId(recordId, state);
			//ordIdTowfIdCache.put(recordId, workflowId);
		//}
		return workflowId;
	}
}
