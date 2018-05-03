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
	 * ˵��:����workflowId��ѯ�������ѹ鵵�ĵ������������
	 * workflowId:����ID
	 * **/
	public int getAllHistoryTaskCount(String workflowId) throws Exception,RuntimeException{
		int cnt = ((ICurTaskDAO) ServiceFactory.getService(ICurTaskDAO.class)).getAllHistoryTaskCount(workflowId);
		return cnt;
	}
	
	/*
	 * ˵�����ṩ��֪�Ṧ�ܣ�Ҫ�����workflow_id ��ѯ����ǰ���ѹ鵵�Ĺ���������Ϣ
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
	 * ˵�����ṩ��֪�Ṧ�ܣ�Ҫ�����workflow_id ��ѯ����ǰ���ѹ鵵�Ĺ���������
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
	 * ˵��:����workflowId��ѯ���������������������
	 * roleId:��λID
	 * staffId��Ա����
	 * **/
	public int getAllCurTaskCount(String workflowId) throws Exception,RuntimeException{
		IBOCurTaskValue[] taskList = null;

		int cnt = ((ICurTaskDAO) ServiceFactory.getService(ICurTaskDAO.class)).getAllCurTaskCount(workflowId);

		return cnt;
	}
	

	/**
	 * ˵��:���ݸ�λID��Ա���Ų�ѯ���д������� roleId:��λID staffId��Ա����
	 * **/
	public IBOCurTaskValue[] getCurTask(String staffId,int startNum, int endNum) throws Exception,
			RuntimeException {
		IBOCurTaskValue[] taskList = null;
		ICurTaskDAO curTaskDAO= (ICurTaskDAO) ServiceFactory.getService(ICurTaskDAO.class);
		taskList = curTaskDAO.getCurTask(staffId,startNum,endNum);
		String proxyStaffid = curTaskDAO.getProxyStaff(staffId);
		if(proxyStaffid!="-1"){
			for(int i=0;i<taskList.length;i++){
				taskList[i].setStateName("(�����ѱ�����)");
				taskList[i].setState(12);				
			}
		}
		return taskList;
	}
	
	/**
	 * ˵��:Ա���Ų�ѯ������������
	 * staffId��Ա����
	 * **/
	public int getCurCount(String staffId) throws Exception,RuntimeException{
 	   int cnt = ((ICurTaskDAO) ServiceFactory.getService(ICurTaskDAO.class)).getCurCount(staffId);

       return cnt;
	}
	

	/**
	 * ˵��:����workflowId��ѯ���������� roleId:��λID staffId��Ա����
	 * **/
	public IBOCurTaskValue[] getAllTaskByWorkFlowId(String workflowId,int startNum, int endNum)
			throws Exception, RuntimeException {
		IBOCurTaskValue[] taskList = null;
		ICurTaskDAO curTaskDAO = (ICurTaskDAO)ServiceFactory.getService(ICurTaskDAO.class);
		ISecOrganizeSV secOrganizeSV = (ISecOrganizeSV)ServiceFactory.getService(ISecOrganizeSV.class);
		ISecOperatorSV secOperatorSV = (ISecOperatorSV)ServiceFactory.getService(ISecOperatorSV.class);
		taskList = curTaskDAO.getAllTaskByWorkFlowId(workflowId, startNum,  endNum);
		
		//��ȡ��ǰ������
		for(int i=0;i<taskList.length;i++){
			if(taskList[i].getState()==Long.valueOf(5)){
				//�������˵�����
				String authorName = taskList[i].getTaskStaffName();
				//��ȡ��ǰ���ڵĴ�����id
				String proxyStaffid = curTaskDAO.getProxyStaff(taskList[i].getTaskStaffId());
				if(proxyStaffid!="-1"){
					//��ȡ��ǰ���ڴ����˵�����������id
					String condition = IQBOSecOrgStaffOperValue.S_OperatorId+"= :operatorid ";
					HashMap<String,String> para = new HashMap<String,String>();
					para.put("operatorid", proxyStaffid);
					IQBOSecOrgStaffOperValue secOrgOp = secOperatorSV.getOperQBOByOperId(Long.valueOf(proxyStaffid));
					
					String staffName = secOrgOp.getStaffName();
					String departName = secOrgOp.getOrganizeName();
					String departId = String.valueOf(secOrgOp.getOrganizeId());
					//��ȡ��ǰ�����˵�λ����
					IBOSecOrganizeValue organize = secOrganizeSV.getSecOrganizeById(Long.valueOf(departId.substring(0, 2)), false); 
						
				    //BOSecOrganizeEngine.getBean(Long.valueOf(departId.substring(0, 2))); 
                    String orgname = organize.getOrganizeName();
                    taskList[i].setTaskStaffName(staffName);
                    taskList[i].setCorporation(orgname);
                    taskList[i].setOrgName(departName);
                    // ����˵����Ϣ
                    String comment = staffName+"������"+authorName+"�Ĺ���";
                    taskList[i].setErrorMessage(comment);
				}
			}
		}
		return taskList;
	}

	/**
	 * ˵��:���ݸ�λID��Ա���ź͹������Ͳ�ѯ���д������� roleId:��λID staffId��Ա����
	 * **/
	public IBOCurTaskValue[] getAllCurTaskByCaseType(String staffId,
			String caseType,int startNum, int endNum) throws Exception, RuntimeException {
		IBOCurTaskValue[] taskList = null;

		taskList = ((ICurTaskDAO) ServiceFactory.getService(ICurTaskDAO.class))
				.getAllCurTaskByCaseType(staffId, caseType, startNum, endNum);

		return taskList;
	}

	/**
	 * ˵��:���ݸ�λID��Ա���ź͹������Ͳ�ѯ���д������� roleId:��λID staffId��Ա����
	 * **/
	public int getCurCountByType(String staffId, String caseType) throws Exception, RuntimeException {
		int num =0;

		num = ((ICurTaskDAO) ServiceFactory.getService(ICurTaskDAO.class))
				.getCurCountByType(staffId, caseType);

		return num;
	}
	
	/**
	 * ˵��:���ݸ�λID��Ա���š���ʼʱ�䡢����ʱ���ѯ�����Ѵ����� roleId:��λID staffId��Ա���� endTime:����ʱ��
	 * beginTime:����ʱ��
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
	 * ˵��:���ݸ�λID��Ա���š���ʼʱ�䡢����ʱ���ѯ�����Ѵ���������
	 * roleId:��λID staffId��Ա���� endTime:����ʱ��
	 * beginTime:����ʱ��
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
	 * ˵��:���ݸ�λID��Ա���š���ʼʱ�䡢����ʱ���ѯ�����ѹ鵵���� roleId:��λID staffId��Ա���� endTime:����ʱ��
	 * beginTime:����ʱ��
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
	 * ˵��:���ݸ�λID��Ա���š���ʼʱ�䡢����ʱ�乤��(���������������ֻ��ʾһ��)
	 * roleId:��λID
	 * staffId��Ա����
	 * endTime:����ʱ��
	 * beginTime:����ʱ��
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
	 * ˵��:���ݸ�λID��Ա���š���ʼʱ�䡢����ʱ�乤����¼��
	 * roleId:��λID
	 * staffId��Ա����
	 * endTime:����ʱ��
	 * beginTime:����ʱ��
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
	 * ˵��:���ݹ���ID���������Ͳ�ѯ����������� roleId:��λID staffId��Ա���� endTime:����ʱ��
	 * beginTime:����ʱ��
	 * **/
	public IBOCurTaskValue[] getReasons(String recordId, String recordType)
			throws Exception, RuntimeException {
		IBOCurTaskValue[] taskList = null;

		taskList = ((ICurTaskDAO) ServiceFactory.getService(ICurTaskDAO.class))
				.getReasons(recordId, recordType);

		return taskList;
	}

	/**
	 * ˵��:����workflowId��ѯ�������ѹ鵵�ĵ���������� workflowId:����ID
	 * **/
	public IBOCurTaskValue[] getAllHistoryTaskByWorkFlowId(String workflowId,int startNum, int endNum)
			throws Exception, RuntimeException {
		IBOCurTaskValue[] taskList = null;

		taskList = ((ICurTaskDAO) ServiceFactory.getService(ICurTaskDAO.class))
				.getAllHistoryTaskByWorkFlowId(workflowId, startNum,  endNum);

		return taskList;
	}

	/**
	 * ˵��:����·�����ļ����͹���ID,����������Ϣ dir������·�� fileName:�ļ��� mId:����ID
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
	 * ˵��������·�����ļ����͹���ID,����Ӫ�����Ϣ dir������·�� fileName:�ļ��� mId:����ID
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

		// ���Ӫ�������Ϣ
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

		// ���Ӫ�����ϸ��Ϣ
		int i01 = 0, i02 = 0, i03 = 0, i04 = 0, i05 = 0, i06 = 0, i07 = 0, i08 = 0, i09 = 0;
		for (int i = 0; i < detailValue.length; i++) {
			String flag = detailValue[i].getSaleFlag();
			// �͵���ȯ
			if (flag.equals("12")) {
				setZFQ(detailValue[i], wb, i01);
				i01=i01+1;
				continue;
			}
			// �ͻ���
			if (flag.equals("11")) {
				setHF(detailValue[i], wb, i02);
				i02=i02+1;
				continue;
			}
			// �ͻ�Ʒ
			if (flag.equals("13")) {
				setGoods(detailValue[i], wb, i03);
				i03=i03+1;
				continue;
			}
			// ������ҵ��
			if (flag.equals("14")) {
				setSelfBus(detailValue[i], wb, i04);
				i04=i04+1;
				continue;
			}
			// �������
			if (flag.equals("15")) {
				setZHZS(detailValue[i], wb, i05);
				i05=i05+1;
				continue;
			}
			// ���ն�
			if (flag.equals("21")) {
				setSZD(detailValue[i], wb, i06);
				i06=i06+1;
				continue;
			}
			// ���ն��ͻ���
			if (flag.equals("22")) {
				setGZDSHF(detailValue[i], wb, i07);
				i07=i07+1;
				continue;
			}
			// ����ҵ��Ӫ��
			if (flag.equals("31")) {
				setSJYW(detailValue[i], wb, i08);
				i08=i08+1;
				continue;
			}
			// ����
			if (flag.equals("41")) {
				setOther(detailValue[i], wb, i09);
				i09=i09+1;
				continue;
			}
		}
        //���뵵��ͳ����Ϣ
		Sheet sheetMain = wb.getSheetAt(0);
		sheetMain.getRow(24).getCell(5).setCellValue("��"+i02+"������");
		sheetMain.getRow(25).getCell(5).setCellValue("��"+i01+"������");
		sheetMain.getRow(26).getCell(5).setCellValue("��"+i03+"������");
		sheetMain.getRow(27).getCell(5).setCellValue("��"+i04+"������");
		sheetMain.getRow(28).getCell(5).setCellValue("��"+i05+"������");
		sheetMain.getRow(30).getCell(5).setCellValue("��"+i06+"������");
		sheetMain.getRow(31).getCell(5).setCellValue("��"+i07+"������");
		sheetMain.getRow(33).getCell(5).setCellValue("��"+i08+"������");
		sheetMain.getRow(35).getCell(5).setCellValue("��"+i09+"������");
        //�ϼ�
		int total = i01+i02+i03+i04+i05+i06+i07+i08+i09;
		sheetMain.getRow(36).getCell(5).setCellValue("�ϼ�"+total+"������");
		
		return wb;
	}

	/*
	 * ˵��������֧��ȯ� IBOSaleDetailShowValue����ϸ��Ϣ wb:excel����̨ cnt:������
	 */
	public void setZFQ(IBOSaleDetailShowValue detailvalue, Workbook wb, int cnt) {
		Sheet sheet = wb.getSheetAt(1);
		Row row = sheet.createRow(4 + cnt);
		// ϸ���г�
		row.createCell(1).setCellValue(detailvalue.getMarketName());
		// ����
		row.createCell(2).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// Ʒ�Ƽ��ʷ�
		row.createCell(3).setCellValue(detailvalue.getBrandDesc());
		// Ŀ��ͻ��嵥���ݿ���
		row.createCell(4).setCellValue(detailvalue.getTargetListCode());
		// ����
		row.createCell(5).setCellValue(detailvalue.getOtherUserinfo());
		// ����˵��
		row.createCell(6).setCellValue(detailvalue.getLevelDesc());
		// ��������
		row.createCell(7).setCellValue(detailvalue.getOpenChannel());
		// �����������û���
		row.createCell(8).setCellValue(detailvalue.getMaxPerson());
		// Ԥ���û���ģ(����
		row.createCell(9).setCellValue(detailvalue.getPrePerson());
		// �ͻ��ر���
		row.createCell(10).setCellValue(detailvalue.getBackProportion());
		// Ԥ��/���ͱ���
		row.createCell(11).setCellValue(detailvalue.getPreStoreToPresent());
		// Ԥ������(Ԫ��
		row.createCell(12).setCellValue(detailvalue.getPreIncome());
		// Ԥ�Ƴɱ�(Ԫ��
		row.createCell(13).setCellValue(detailvalue.getPreBaseFee());
		// Ԥ�滰�ѽ��(Ԫ��
		row.createCell(14).setCellValue(detailvalue.getPrestoreFee());
		// Ԥ��һ���Ե���(Ԫ��
		row.createCell(15).setCellValue(detailvalue.getPrestroreReachAccount());
		// ÿ�·������(Ԫ��
		row.createCell(16).setCellValue(detailvalue.getBLimit());
		// ��������(�£�
		row.createCell(17).setCellValue(detailvalue.getBackMonth());
		// ���������(Ԫ��
		row.createCell(18).setCellValue(detailvalue.getPresentBusi2Amount());
		// ֧��ȯ����
		row.createCell(19).setCellValue(detailvalue.getZfqTypeName());
		// ֧��ȯ����
		row.createCell(20).setCellValue(detailvalue.getZfqType());
		// ÿ�±�������(Ԫ��
		row.createCell(21).setCellValue(detailvalue.getLLimit());
		// ��������(�£�
		row.createCell(22).setCellValue(detailvalue.getBaseMonth());
		// ���ݰ��ܼ�ֵ(Ԫ��
		row.createCell(23).setCellValue(detailvalue.getDataFee());
		// ҵ������
		row.createCell(24).setCellValue(detailvalue.getBusiType());
		// ҵ������
		row.createCell(25).setCellValue(detailvalue.getSaletypeDesOthersale());
		// ÿ�¼�ֵ(Ԫ��
		row.createCell(26).setCellValue(detailvalue.getPresentValuePermon());
		// ��ͨ����(�£�
		row.createCell(27).setCellValue(detailvalue.getOpenMonth());
		// ȫ��ͨ����(��)
		row.createCell(28).setCellValue(detailvalue.getGlobalScore());
		// ���еش�����(Mֵ)
		row.createCell(29).setCellValue(detailvalue.getDynamicScore());
		// ��ͥ����(�֣�
		row.createCell(30).setCellValue(detailvalue.getHomeScore());
		// ��������(�֣�
		row.createCell(31).setCellValue("");
		// ����Ҫ��
		row.createCell(32).setCellValue(detailvalue.getExcludeDemand());
		// ������
		row.createCell(33).setCellValue(detailvalue.getPublicityWord());
		// �����������
		row.createCell(34).setCellValue(detailvalue.getChannelPayPolicy());
		// ���α���
		row.createCell(35).setCellValue(detailvalue.getSaleActiveCode());
	}

	/*
	 * ˵�������뻰�ѻ IBOSaleDetailShowValue����ϸ��Ϣ wb:excel����̨ cnt:������
	 */
	public void setHF(IBOSaleDetailShowValue detailvalue, Workbook wb, int cnt) {
		Sheet sheet = wb.getSheetAt(2);
		Row row = sheet.createRow(4 + cnt);
		// ϸ���г�
		row.createCell(1).setCellValue(detailvalue.getMarketName());
		// ����
		row.createCell(2).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// Ʒ�Ƽ��ʷ�
		row.createCell(3).setCellValue(detailvalue.getBrandDesc());
		// Ŀ��ͻ��嵥���ݿ���
		row.createCell(4).setCellValue(detailvalue.getTargetListCode());
		// ����
		row.createCell(5).setCellValue(detailvalue.getOtherUserinfo());
		// ����˵��
		row.createCell(6).setCellValue(detailvalue.getLevelDesc());
		// ��������
		row.createCell(7).setCellValue(detailvalue.getOpenChannel());
		// �����������û���
		row.createCell(8).setCellValue(detailvalue.getMaxPerson());
		// Ԥ���û���ģ(����
		row.createCell(9).setCellValue(detailvalue.getPrePerson());
		// �ͻ��ر���
		row.createCell(10).setCellValue(detailvalue.getBackProportion());
		// Ԥ��/���ͱ���
		row.createCell(11).setCellValue(detailvalue.getPreStoreToPresent());
		// Ԥ������(Ԫ��
		row.createCell(12).setCellValue(detailvalue.getPreIncome());
		// Ԥ���ۿ�
		row.createCell(13).setCellValue(detailvalue.getPreDiscount());
		// Ԥ�滰�ѽ��(Ԫ��
		row.createCell(14).setCellValue(detailvalue.getPrestoreFee());
		// Ԥ��һ���Ե���(Ԫ��
		row.createCell(15).setCellValue(detailvalue.getPrestroreReachAccount());
		// ÿ�·������(Ԫ��
		row.createCell(16).setCellValue(detailvalue.getBLimit());
		// ��������(�£�
		row.createCell(17).setCellValue(detailvalue.getBackMonth());
		// ���������(Ԫ��
		row.createCell(18).setCellValue(detailvalue.getPresentBusiAmount());
		// ����һ���Ե���
		row.createCell(19).setCellValue(detailvalue.getZfqTypeName());
		// ÿ�����ͽ��
		row.createCell(20).setCellValue(detailvalue.getZfqType());
		// ��������
		row.createCell(21).setCellValue(detailvalue.getZfqType());
		// �����˻�����
		row.createCell(22).setCellValue(detailvalue.getZfqType());
		// ÿ�±�������(Ԫ��
		row.createCell(23).setCellValue(detailvalue.getLLimit());
		// ��������(�£�
		row.createCell(24).setCellValue(detailvalue.getBaseMonth());
		// ���ݰ��ܼ�ֵ(Ԫ��
		row.createCell(25).setCellValue(detailvalue.getDataFee());
		// ҵ������
		row.createCell(26).setCellValue(detailvalue.getBusiType());
		// ҵ������
		row.createCell(27).setCellValue(detailvalue.getSaletypeDesOthersale());
		// ÿ�¼�ֵ(Ԫ��
		row.createCell(28).setCellValue(detailvalue.getPresentValuePermon());
		// ��ͨ����(�£�
		row.createCell(29).setCellValue(detailvalue.getOpenMonth());
		// ȫ��ͨ����(��)
		row.createCell(30).setCellValue(detailvalue.getGlobalScore());
		// ���еش�����(Mֵ)
		row.createCell(31).setCellValue(detailvalue.getDynamicScore());
		// ��ͥ����(�֣�
		row.createCell(32).setCellValue(detailvalue.getHomeScore());
		// ��������(�֣�
		row.createCell(33).setCellValue("");
		// ����Ҫ��
		row.createCell(34).setCellValue(detailvalue.getExcludeDemand());
		// ������
		row.createCell(35).setCellValue(detailvalue.getPublicityWord());
		// �����������
		row.createCell(36).setCellValue(detailvalue.getChannelPayPolicy());
		// ���α���
		row.createCell(37).setCellValue(detailvalue.getSaleActiveCode());
	}

	/*
	 * ˵���������ͻ�Ʒ� IBOSaleDetailShowValue����ϸ��Ϣ wb:excel����̨ cnt:������
	 */
	public void setGoods(IBOSaleDetailShowValue detailvalue, Workbook wb,
			int cnt) {
		Sheet sheet = wb.getSheetAt(3);
		Row row = sheet.createRow(4 + cnt);
		// ϸ���г�
		row.createCell(1).setCellValue(detailvalue.getMarketName());
		// ����
		row.createCell(2).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// Ʒ�Ƽ��ʷ�
		row.createCell(3).setCellValue(detailvalue.getBrandDesc());
		// Ŀ��ͻ��嵥���ݿ���
		row.createCell(4).setCellValue(detailvalue.getTargetListCode());
		// ����
		row.createCell(5).setCellValue(detailvalue.getOtherUserinfo());
		// ����˵��
		row.createCell(6).setCellValue(detailvalue.getLevelDesc());
		// ��������
		row.createCell(7).setCellValue(detailvalue.getOpenChannel());
		// �����������û���
		row.createCell(8).setCellValue(detailvalue.getMaxPerson());
		// Ԥ���û���ģ(����
		row.createCell(9).setCellValue(detailvalue.getPrePerson());
		// �ͻ��ر���
		row.createCell(10).setCellValue(detailvalue.getBackProportion());
		// Ԥ��/���ͱ���
		row.createCell(11).setCellValue(detailvalue.getPreStoreToPresent());
		// Ԥ������(Ԫ��
		row.createCell(12).setCellValue(detailvalue.getPreIncome());
		// Ԥ�Ƴɱ�(Ԫ��
		row.createCell(13).setCellValue(detailvalue.getPreBaseFee());
		// Ԥ�滰�ѽ��(Ԫ��
		row.createCell(14).setCellValue(detailvalue.getPrestoreFee());
		// Ԥ��һ���Ե���(Ԫ��
		row.createCell(15).setCellValue(detailvalue.getPrestroreReachAccount());
		// ÿ�·������(Ԫ��
		row.createCell(16).setCellValue(detailvalue.getBLimit());
		// ��������(�£�
		row.createCell(17).setCellValue(detailvalue.getBackMonth());
		// ��Ʒ����ָ���۸�
		row.createCell(18).setCellValue(detailvalue.getReferencePrice());
		// ��Ʒ�ɱ�
		row.createCell(19).setCellValue(detailvalue.getGoodsCost());
		// �ɹ�Ŀ¼
		row.createCell(20).setCellValue(detailvalue.getGoodAdoptDirectory());
		// ��Ʒ����
		row.createCell(21).setCellValue("");
		// ÿ�±�������(Ԫ��
		row.createCell(22).setCellValue(detailvalue.getLLimit());
		// ��������(�£�
		row.createCell(23).setCellValue(detailvalue.getBaseMonth());
		// ���ݰ��ܼ�ֵ(Ԫ��
		row.createCell(24).setCellValue(detailvalue.getDataFee());
		// ҵ������
		row.createCell(25).setCellValue(detailvalue.getBusiType());
		// ҵ������
		row.createCell(26).setCellValue(detailvalue.getSaletypeDesOthersale());
		// ÿ�¼�ֵ(Ԫ��
		row.createCell(27).setCellValue(detailvalue.getPresentValuePermon());
		// ��ͨ����(�£�
		row.createCell(28).setCellValue(detailvalue.getOpenMonth());
		// ȫ��ͨ����(��)
		row.createCell(29).setCellValue(detailvalue.getGlobalScore());
		// ���еش�����(Mֵ)
		row.createCell(30).setCellValue(detailvalue.getDynamicScore());
		// ��ͥ����(�֣�
		row.createCell(31).setCellValue(detailvalue.getHomeScore());
		// ��������(�֣�
		row.createCell(32).setCellValue("");
		// ����Ҫ��
		row.createCell(33).setCellValue(detailvalue.getExcludeDemand());
		// ������
		row.createCell(34).setCellValue(detailvalue.getPublicityWord());
		// �����������
		row.createCell(35).setCellValue(detailvalue.getChannelPayPolicy());
		// ���α���
		row.createCell(36).setCellValue(detailvalue.getSaleActiveCode());
	}

	/*
	 * ˵��������������ҵ�� IBOSaleDetailShowValue����ϸ��Ϣ wb:excel����̨ cnt:������
	 */
	public void setSelfBus(IBOSaleDetailShowValue detailvalue, Workbook wb,
			int cnt) {
		Sheet sheet = wb.getSheetAt(4);
		Row row = sheet.createRow(4 + cnt);
		// ϸ���г�
		row.createCell(1).setCellValue(detailvalue.getMarketName());
		// ����
		row.createCell(2).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// Ʒ�Ƽ��ʷ�
		row.createCell(3).setCellValue(detailvalue.getBrandDesc());
		// Ŀ��ͻ��嵥���ݿ���
		row.createCell(4).setCellValue(detailvalue.getTargetListCode());
		// ����
		row.createCell(5).setCellValue(detailvalue.getOtherUserinfo());
		// ����˵��
		row.createCell(6).setCellValue(detailvalue.getLevelDesc());
		// ��������
		row.createCell(7).setCellValue(detailvalue.getOpenChannel());
		// �����������û���
		row.createCell(8).setCellValue(detailvalue.getMaxPerson());
		// Ԥ���û���ģ(����
		row.createCell(9).setCellValue(detailvalue.getPrePerson());
		// �ͻ��ر���
		row.createCell(10).setCellValue(detailvalue.getBackProportion());
		// Ԥ��/���ͱ���
		row.createCell(11).setCellValue(detailvalue.getPreStoreToPresent());
		// Ԥ������(Ԫ��
		row.createCell(12).setCellValue(detailvalue.getPreIncome());
		// Ԥ���ۿ�
		row.createCell(13).setCellValue(detailvalue.getPreDiscount());
		// Ԥ�滰�ѽ��(Ԫ��
		row.createCell(14).setCellValue(detailvalue.getPrestoreFee());
		// Ԥ��һ���Ե���(Ԫ��
		row.createCell(15).setCellValue(detailvalue.getPrestroreReachAccount());
		// ÿ�·������(Ԫ��
		row.createCell(16).setCellValue(detailvalue.getBLimit());
		// ��������(�£�
		row.createCell(17).setCellValue(detailvalue.getBackMonth());
		
		// ����ҵ���ܼ�ֵ
		row.createCell(18).setCellValue(detailvalue.getPresentBusi4Amount());
		// ҵ������
		row.createCell(19).setCellValue(detailvalue.getBusiType());
		// ҵ������
		row.createCell(20).setCellValue("");
		// ÿ�����ͼ�ֵ
		row.createCell(21).setCellValue(detailvalue.getValuePermonth());
		// ��������
		row.createCell(22).setCellValue(detailvalue.getPresentBusiMonth());
		
		// ÿ�±�������(Ԫ��
		row.createCell(23).setCellValue(detailvalue.getLLimit());
		// ��������(�£�
		row.createCell(24).setCellValue(detailvalue.getBaseMonth());
		// ���ݰ��ܼ�ֵ(Ԫ��
		row.createCell(25).setCellValue(detailvalue.getDataFee());
		// ҵ������
		row.createCell(26).setCellValue(detailvalue.getBusiType());
		// ҵ������
		row.createCell(27).setCellValue(detailvalue.getSaletypeDesOthersale());
		// ÿ�¼�ֵ(Ԫ��
		row.createCell(28).setCellValue(detailvalue.getPresentValuePermon());
		// ��ͨ����(�£�
		row.createCell(29).setCellValue(detailvalue.getOpenMonth());
		// ȫ��ͨ����(��)
		row.createCell(30).setCellValue(detailvalue.getGlobalScore());
		// ���еش�����(Mֵ)
		row.createCell(31).setCellValue(detailvalue.getDynamicScore());
		// ��ͥ����(�֣�
		row.createCell(32).setCellValue(detailvalue.getHomeScore());
		// ��������(�֣�
		row.createCell(33).setCellValue("");
		// ����Ҫ��
		row.createCell(34).setCellValue(detailvalue.getExcludeDemand());
		// ������
		row.createCell(35).setCellValue(detailvalue.getPublicityWord());
		// �����������
		row.createCell(36).setCellValue(detailvalue.getChannelPayPolicy());
		// ���α���
		row.createCell(37).setCellValue(detailvalue.getSaleActiveCode());
	}

	/*
	 * ˵��������������ͻ IBOSaleDetailShowValue����ϸ��Ϣ wb:excel����̨ cnt:������
	 */
	public void setZHZS(IBOSaleDetailShowValue detailvalue, Workbook wb, int cnt) {
		Sheet sheet = wb.getSheetAt(5);
		Row row = sheet.createRow(4 + cnt);
		// ϸ���г�
		row.createCell(1).setCellValue(detailvalue.getMarketName());
		// ����
		row.createCell(2).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// Ʒ�Ƽ��ʷ�
		row.createCell(3).setCellValue(detailvalue.getBrandDesc());
		// Ŀ��ͻ��嵥���ݿ���
		row.createCell(4).setCellValue(detailvalue.getTargetListCode());
		// ����
		row.createCell(5).setCellValue(detailvalue.getOtherUserinfo());
		// ����˵��
		row.createCell(6).setCellValue(detailvalue.getLevelDesc());
		// ��������
		row.createCell(7).setCellValue(detailvalue.getOpenChannel());
		// �����������û���
		row.createCell(8).setCellValue(detailvalue.getMaxPerson());
		// Ԥ���û���ģ(����
		row.createCell(9).setCellValue(detailvalue.getPrePerson());
		// �ͻ��ر���
		row.createCell(10).setCellValue(detailvalue.getBackProportion());
		// Ԥ��/���ͱ���
		row.createCell(11).setCellValue(detailvalue.getPreStoreToPresent());
		// Ԥ������(Ԫ��
		row.createCell(12).setCellValue(detailvalue.getPreIncome());
		// Ԥ�Ƴɱ�(Ԫ��
		row.createCell(13).setCellValue(detailvalue.getPreBaseFee());
		// Ԥ���ۿ�(Ԫ��
		row.createCell(14).setCellValue(detailvalue.getPreDiscount());
		// Ԥ�滰�ѽ��(Ԫ��
		row.createCell(15).setCellValue(detailvalue.getPrestoreFee());
		// Ԥ��һ���Ե���(Ԫ��
		row.createCell(16).setCellValue(detailvalue.getPrestroreReachAccount());
		// ÿ�·������(Ԫ��
		row.createCell(17).setCellValue(detailvalue.getBLimit());
		// ��������(�£�
		row.createCell(18).setCellValue(detailvalue.getBackMonth());
		//��֧��ȯ�ࣩ�����ܼ�ֵ(Ԫ��
		row.createCell(19).setCellValue(detailvalue.getPresentBusi2Amount());
		// ��ϸ����
		row.createCell(20).setCellValue("");
		// �������ࣩ�����ܼ�ֵ(Ԫ��
		row.createCell(21).setCellValue(detailvalue.getPresentBusiAmount());
		// ��ϸ����
		row.createCell(22).setCellValue("");
		// ÿ�±�������(Ԫ��
		row.createCell(23).setCellValue(detailvalue.getLLimit());
		// ��������(�£�
		row.createCell(24).setCellValue(detailvalue.getBaseMonth());
		// ���ݰ��ܼ�ֵ(Ԫ��
		row.createCell(25).setCellValue(detailvalue.getDataFee());
		// ҵ������
		row.createCell(26).setCellValue(detailvalue.getBusiType());
		// ҵ������
		row.createCell(27).setCellValue(detailvalue.getSaletypeDesOthersale());
		// ÿ�¼�ֵ(Ԫ��
		row.createCell(28).setCellValue(detailvalue.getPresentValuePermon());
		// ��ͨ����(�£�
		row.createCell(29).setCellValue(detailvalue.getOpenMonth());
		// ȫ��ͨ����(��)
		row.createCell(30).setCellValue(detailvalue.getGlobalScore());
		// ���еش�����(Mֵ)
		row.createCell(31).setCellValue(detailvalue.getDynamicScore());
		// ��ͥ����(�֣�
		row.createCell(32).setCellValue(detailvalue.getHomeScore());
		// ��������(�֣�
		row.createCell(33).setCellValue("");
		// ����Ҫ��
		row.createCell(34).setCellValue(detailvalue.getExcludeDemand());
		// ������
		row.createCell(35).setCellValue(detailvalue.getPublicityWord());
		// �����������
		row.createCell(36).setCellValue(detailvalue.getChannelPayPolicy());
		// ���α���
		row.createCell(37).setCellValue(detailvalue.getSaleActiveCode());
	}

	/*
	 * ˵�����������ն˻ IBOSaleDetailShowValue����ϸ��Ϣ wb:excel����̨ cnt:������
	 */
	public void setSZD(IBOSaleDetailShowValue detailvalue, Workbook wb, int cnt) {
		Sheet sheet = wb.getSheetAt(6);
		Row row = sheet.createRow(4 + cnt);
		// ϸ���г�
		row.createCell(1).setCellValue(detailvalue.getMarketName());
		// ����
		row.createCell(2).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// Ʒ�Ƽ��ʷ�
		row.createCell(3).setCellValue(detailvalue.getBrandDesc());
		// Ŀ��ͻ��嵥���ݿ���
		row.createCell(4).setCellValue(detailvalue.getTargetListCode());
		// ����
		row.createCell(5).setCellValue(detailvalue.getOtherUserinfo());
		// ����˵��
		row.createCell(6).setCellValue(detailvalue.getLevelDesc());
		// ��������
		row.createCell(7).setCellValue(detailvalue.getOpenChannel());
		// �����������û���
		row.createCell(8).setCellValue(detailvalue.getMaxPerson());
		// Ԥ���û���ģ(����
		row.createCell(9).setCellValue(detailvalue.getPrePerson());
		// �ͻ��ر���
		row.createCell(10).setCellValue(detailvalue.getBackProportion());
		// Ԥ������(Ԫ��
		row.createCell(11).setCellValue(detailvalue.getPreIncome());
		// Ԥ�Ƴɱ�(Ԫ��
		row.createCell(12).setCellValue(detailvalue.getPreBaseFee());

		// ��Լ�۸�
		row.createCell(13).setCellValue(detailvalue.getAgreementValue());
		
		// Ԥ�滰�ѽ��(Ԫ��
		row.createCell(14).setCellValue(detailvalue.getPrestoreFee());
		// Ԥ��һ���Ե���(Ԫ��
		row.createCell(15).setCellValue(detailvalue.getPrestroreReachAccount());
		// ÿ�·������(Ԫ��
		row.createCell(16).setCellValue(detailvalue.getBLimit());
		// ��������(�£�
		row.createCell(17).setCellValue(detailvalue.getBackMonth());
		// �����˻�����
		row.createCell(18).setCellValue(detailvalue.getFeeAccountProperty());
		// �ն�ʵ�ʹ����
		row.createCell(19).setCellValue(detailvalue.getTermRealFee());
		// �ն�����
		row.createCell(20).setCellValue(detailvalue.getTermType());
		// �ն�����ָ���۸�
		row.createCell(21).setCellValue(detailvalue.getTermGuideFee());
		// �ն˳ɱ�����۸�
		row.createCell(22).setCellValue(detailvalue.getTermCostFee());
		// �ն��ͺ�����
		row.createCell(23).setCellValue("");
		// ÿ�±�������(Ԫ��
		row.createCell(24).setCellValue(detailvalue.getLLimit());
		// ��������(�£�
		row.createCell(25).setCellValue(detailvalue.getBaseMonth());
		// ���ݰ��ܼ�ֵ(Ԫ��
		row.createCell(26).setCellValue(detailvalue.getDataFee());
		// ҵ������
		row.createCell(27).setCellValue(detailvalue.getBusiType());
		// ҵ������
		row.createCell(28).setCellValue(detailvalue.getSaletypeDesOthersale());
		// ÿ�¼�ֵ(Ԫ��
		row.createCell(29).setCellValue(detailvalue.getPresentValuePermon());
		// ��ͨ����(�£�
		row.createCell(30).setCellValue(detailvalue.getOpenMonth());
		// ȫ��ͨ����(��)
		row.createCell(31).setCellValue(detailvalue.getGlobalScore());
		// ���еش�����(Mֵ)
		row.createCell(32).setCellValue(detailvalue.getDynamicScore());
		// ��ͥ����(�֣�
		row.createCell(33).setCellValue(detailvalue.getHomeScore());
		// ��������(�֣�
		row.createCell(34).setCellValue("");
		// ����Ҫ��
		row.createCell(35).setCellValue(detailvalue.getExcludeDemand());
		// ������
		row.createCell(36).setCellValue(detailvalue.getPublicityWord());
		// �����������
		row.createCell(37).setCellValue(detailvalue.getChannelPayPolicy());
		// ���α���
		row.createCell(38).setCellValue(detailvalue.getSaleActiveCode());
	}

	/*
	 * ˵�������빺�ն��ͻ��� IBOSaleDetailShowValue����ϸ��Ϣ wb:excel����̨ cnt:������
	 */
	public void setGZDSHF(IBOSaleDetailShowValue detailvalue, Workbook wb,
			int cnt) {
		Sheet sheet = wb.getSheetAt(7);
		Row row = sheet.createRow(4 + cnt);
		// ϸ���г�
		row.createCell(1).setCellValue(detailvalue.getMarketName());
		// ����
		row.createCell(2).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// Ʒ�Ƽ��ʷ�
		row.createCell(3).setCellValue(detailvalue.getBrandDesc());
		// Ŀ��ͻ��嵥���ݿ���
		row.createCell(4).setCellValue(detailvalue.getTargetListCode());
		// ����
		row.createCell(5).setCellValue(detailvalue.getOtherUserinfo());
		// ����˵��
		row.createCell(6).setCellValue(detailvalue.getLevelDesc());
		// ��������
		row.createCell(7).setCellValue(detailvalue.getOpenChannel());
		// �����������û���
		row.createCell(8).setCellValue(detailvalue.getMaxPerson());
		// Ԥ���û���ģ(����
		row.createCell(9).setCellValue(detailvalue.getPrePerson());
		// �ͻ��ر���
		row.createCell(10).setCellValue(detailvalue.getBackProportion());
		// Ԥ������(Ԫ��
		row.createCell(11).setCellValue(detailvalue.getPreIncome());
		// Ԥ���ۿ�(Ԫ��
		row.createCell(12).setCellValue(detailvalue.getPreDiscount());

		// ��Լ�۸�
		row.createCell(13).setCellValue(detailvalue.getAgreementValue());

		// �ն�����
		row.createCell(14).setCellValue(detailvalue.getTermType());
		// �ն�����ָ���۸�
		row.createCell(15).setCellValue(detailvalue.getTermGuideFee());
		// �ն˳ɱ�����۸�
		row.createCell(16).setCellValue(detailvalue.getTermCostFee());
		// �ն��ͺ�����
		row.createCell(17).setCellValue("");
		// �ն����ͻ��ѽ��
		row.createCell(18).setCellValue(detailvalue.getPresentBusiAmount());
		// ����һ���Ե���
		row.createCell(19).setCellValue(detailvalue.getPresentReachAmount());
		// ÿ�����ͽ��
		row.createCell(20).setCellValue(detailvalue.getPresentValuePermon());
		// ��������
		row.createCell(21).setCellValue(detailvalue.getPresentBusiMonth());
		// �����˻�����
		row.createCell(22).setCellValue(detailvalue.getFeeAccountProperty());
		// ÿ�±�������(Ԫ��
		row.createCell(23).setCellValue(detailvalue.getLLimit());
		// ��������(�£�
		row.createCell(24).setCellValue(detailvalue.getBaseMonth());
		// ���ݰ��ܼ�ֵ(Ԫ��
		row.createCell(25).setCellValue(detailvalue.getDataFee());
		// ҵ������
		row.createCell(26).setCellValue(detailvalue.getBusiType());
		// ҵ������
		row.createCell(27).setCellValue(detailvalue.getSaletypeDesOthersale());
		// ÿ�¼�ֵ(Ԫ��
		row.createCell(28).setCellValue(detailvalue.getPresentValuePermon());
		// ��ͨ����(�£�
		row.createCell(29).setCellValue(detailvalue.getOpenMonth());
		// ȫ��ͨ����(��)
		row.createCell(30).setCellValue(detailvalue.getGlobalScore());
		// ���еش�����(Mֵ)
		row.createCell(31).setCellValue(detailvalue.getDynamicScore());
		// ��ͥ����(�֣�
		row.createCell(32).setCellValue(detailvalue.getHomeScore());
		// ��������(�֣�
		row.createCell(33).setCellValue("");
		// ����Ҫ��
		row.createCell(34).setCellValue(detailvalue.getExcludeDemand());
		// ������
		row.createCell(35).setCellValue(detailvalue.getPublicityWord());
		// �����������
		row.createCell(36).setCellValue(detailvalue.getChannelPayPolicy());
		// ���α���
		row.createCell(37).setCellValue(detailvalue.getSaleActiveCode());
	}

	/*
	 * ˵������������ҵ��Ӫ��� IBOSaleDetailShowValue����ϸ��Ϣ wb:excel����̨ cnt:������
	 */
	public void setSJYW(IBOSaleDetailShowValue detailvalue, Workbook wb, int cnt) {
		Sheet sheet = wb.getSheetAt(8);
		Row row = sheet.createRow(4 + cnt);
		// ϸ���г�
		row.createCell(1).setCellValue(detailvalue.getMarketName());
		// ����
		row.createCell(2).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// Ʒ�Ƽ��ʷ�
		row.createCell(3).setCellValue(detailvalue.getBrandDesc());
		// Ŀ��ͻ��嵥���ݿ���
		row.createCell(4).setCellValue(detailvalue.getTargetListCode());
		// ����
		row.createCell(5).setCellValue(detailvalue.getOtherUserinfo());
		// ����˵��
		row.createCell(6).setCellValue(detailvalue.getLevelDesc());
		// ��������
		row.createCell(7).setCellValue(detailvalue.getOpenChannel());
		// �����������û���
		row.createCell(8).setCellValue(detailvalue.getMaxPerson());
		// Ԥ���û���ģ(����
		row.createCell(9).setCellValue(detailvalue.getPrePerson());
		// �ͻ��ر���
		row.createCell(10).setCellValue(detailvalue.getBackProportion());
		// Ԥ������(Ԫ��
		row.createCell(11).setCellValue(detailvalue.getPreIncome());
		// Ԥ�Ƴɱ�(Ԫ��
		row.createCell(12).setCellValue(detailvalue.getPreBaseFee());
		// Ԥ���ۿ�(Ԫ��
		row.createCell(13).setCellValue(detailvalue.getPreDiscount());
		// ���ݰ��ܼ�ֵ(Ԫ��
		row.createCell(14).setCellValue(detailvalue.getDataFee());
		// ҵ������
		row.createCell(15).setCellValue(detailvalue.getBusiType());
		// ҵ������
		row.createCell(16).setCellValue(detailvalue.getSaletypeDesOthersale());
		// ÿ�¼�ֵ(Ԫ��
		row.createCell(17).setCellValue(detailvalue.getPresentValuePermon());
		// ��ͨ����(�£�
		row.createCell(18).setCellValue(detailvalue.getOpenMonth());
		//��֧��ȯ�ࣩ�����ܼ�ֵ(Ԫ��
		row.createCell(19).setCellValue(detailvalue.getPresentBusi2Amount());
		// ��ϸ����
		row.createCell(20).setCellValue("");
		// �������ࣩ�����ܼ�ֵ(Ԫ��
		row.createCell(21).setCellValue(detailvalue.getPresentBusiAmount());
		// ��ϸ����
		row.createCell(22).setCellValue("");
		// ȫ��ͨ����(��)
		row.createCell(23).setCellValue(detailvalue.getGlobalScore());
		// ���еش�����(Mֵ)
		row.createCell(24).setCellValue(detailvalue.getDynamicScore());
		// ��ͥ����(�֣�
		row.createCell(25).setCellValue(detailvalue.getHomeScore());
		// ��������(�֣�
		row.createCell(26).setCellValue("");
		// ����Ҫ��
		row.createCell(27).setCellValue(detailvalue.getExcludeDemand());
		// ������
		row.createCell(28).setCellValue(detailvalue.getPublicityWord());
		// �����������
		row.createCell(29).setCellValue(detailvalue.getChannelPayPolicy());
		// ���α���
		row.createCell(30).setCellValue(detailvalue.getSaleActiveCode());
	}

	/*
	 * ˵������������Ӫ��� IBOSaleDetailShowValue����ϸ��Ϣ wb:excel����̨ cnt:������
	 */
	public void setOther(IBOSaleDetailShowValue detailvalue, Workbook wb,
			int cnt) {
		Sheet sheet = wb.getSheetAt(9);
		Row row = sheet.createRow(4 + cnt);
		//Ӫ������
		row.createCell(1).setCellValue(detailvalue.getSaleFlagName());
		//Ӫ������˵��
		row.createCell(2).setCellValue("");
		// ϸ���г�
		row.createCell(3).setCellValue(detailvalue.getMarketName());
		// ����
		row.createCell(4).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// Ʒ�Ƽ��ʷ�
		row.createCell(5).setCellValue(detailvalue.getBrandDesc());
		// Ŀ��ͻ��嵥���ݿ���
		row.createCell(6).setCellValue(detailvalue.getTargetListCode());
		// ����
		row.createCell(7).setCellValue(detailvalue.getOtherUserinfo());
		// ����˵��
		row.createCell(8).setCellValue(detailvalue.getLevelDesc());
		// ��������
		row.createCell(9).setCellValue(detailvalue.getOpenChannel());
		// �����������û���
		row.createCell(10).setCellValue(detailvalue.getMaxPerson());
		// Ԥ���û���ģ(����
		row.createCell(11).setCellValue(detailvalue.getPrePerson());
		// Ԥ�Ƴɱ�(Ԫ��
		row.createCell(12).setCellValue(detailvalue.getCostTotal());
		// Ԥ���ۿ�(Ԫ��
		row.createCell(13).setCellValue(detailvalue.getPreDiscount());
		//�����ܼ�ֵ(Ԫ)
		row.createCell(14).setCellValue(detailvalue.getPresentBusi5Amount()+detailvalue.getPresentBusi3Amount());
		//��ϸ����
		row.createCell(15).setCellValue("");
		//�����ܼ�ֵ(Ԫ)
		row.createCell(16).setCellValue(detailvalue.getPresentBusiAmount()+detailvalue.getPresentBusi4Amount());
		//��ϸ����
		row.createCell(17).setCellValue("");
		// ���ݰ��ܼ�ֵ(Ԫ��
		row.createCell(18).setCellValue(detailvalue.getDataFee());
		// ҵ������
		row.createCell(19).setCellValue(detailvalue.getBusiType());
		// ҵ������
		row.createCell(20).setCellValue(detailvalue.getSaletypeDesOthersale());
		// ÿ�¼�ֵ(Ԫ��
		row.createCell(21).setCellValue(detailvalue.getPresentValuePermon());
		// ��ͨ����(�£�
		row.createCell(22).setCellValue(detailvalue.getOpenMonth());
		// ȫ��ͨ����(��)
		row.createCell(23).setCellValue(detailvalue.getGlobalScore());
		// ���еش�����(Mֵ)
		row.createCell(24).setCellValue(detailvalue.getDynamicScore());
		// ��ͥ����(�֣�
		row.createCell(25).setCellValue(detailvalue.getHomeScore());
		// ��������(�֣�
		row.createCell(26).setCellValue("");
		// ����Ҫ��
		row.createCell(27).setCellValue(detailvalue.getExcludeDemand());
		// ������
		row.createCell(28).setCellValue(detailvalue.getPublicityWord());
		// �����������
		row.createCell(29).setCellValue(detailvalue.getChannelPayPolicy());
		// ���α���
		row.createCell(30).setCellValue(detailvalue.getSaleActiveCode());
	}
	
	/*
	 * ˵��������·�����ļ����͹���ID,����������Ϣ 
	 * mId:����ID
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

		// ���Ӫ�������Ϣ
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

		// ���Ӫ�����ϸ��Ϣ
		int i01 = 0, i02 = 0, i03 = 0, i04 = 0, i05 = 0, i06 = 0, i07 = 0, i08 = 0, i09 = 0;
		for (int i = 0; i < weaponDetail.length; i++) {
			String flag = weaponDetail[i].getSaleFlag();
			// �͵���ȯ
			if (flag.equals("12")) {
				setWeaponZFQ(weaponDetail[i], wb, i01);
				i01=i01+1;
				continue;
			}
			// �ͻ���
			if (flag.equals("11")) {
				setWeaponHF(weaponDetail[i], wb, i02);
				i02=i02+1;
				continue;
			}
			// �ͻ�Ʒ
			if (flag.equals("13")) {
				setWeaponGoods(weaponDetail[i], wb, i03);
				i03=i03+1;
				continue;
			}
			// ������ҵ��
			if (flag.equals("14")) {
				setWeaponSelfBus(weaponDetail[i], wb, i04);
				i04=i04+1;
				continue;
			}
			// �������
			if (flag.equals("15")) {
				setWeaponZHZS(weaponDetail[i], wb, i05);
				i05=i05+1;
				continue;
			}
			// ���ն�
			if (flag.equals("21")) {
				setWeaponSZD(weaponDetail[i], wb, i06);
				i06=i06+1;
				continue;
			}
			// ���ն��ͻ���
			if (flag.equals("22")) {
				setWeaponGZDSHF(weaponDetail[i], wb, i07);
				i07=i07+1;
				continue;
			}
			// ����ҵ��Ӫ��
			if (flag.equals("31")) {
				setWeaponSJYW(weaponDetail[i], wb, i08);
				i08=i08+1;
				continue;
			}
			// ����
			if (flag.equals("41")) {
				setWeaponOther(weaponDetail[i], wb, i09);
				i09=i09+1;
				continue;
			}
		}
        //���뵵��ͳ����Ϣ
		Sheet sheetMain = wb.getSheetAt(0);
		sheetMain.getRow(7).getCell(5).setCellValue("��"+i02+"������");
		sheetMain.getRow(8).getCell(5).setCellValue("��"+i01+"������");
		sheetMain.getRow(9).getCell(5).setCellValue("��"+i03+"������");
		sheetMain.getRow(10).getCell(5).setCellValue("��"+i04+"������");
		sheetMain.getRow(11).getCell(5).setCellValue("��"+i05+"������");
		sheetMain.getRow(13).getCell(5).setCellValue("��"+i06+"������");
		sheetMain.getRow(14).getCell(5).setCellValue("��"+i07+"������");
		sheetMain.getRow(16).getCell(5).setCellValue("��"+i08+"������");
		sheetMain.getRow(18).getCell(5).setCellValue("��"+i09+"������");
        //�ϼ�
		int total = i01+i02+i03+i04+i05+i06+i07+i08+i09;
		sheetMain.getRow(19).getCell(5).setCellValue("�ϼ�"+total+"������");
		
//		FileOutputStream fileOut = new FileOutputStream(dirfile);
//		wb.write(fileOut);
//		fileOut.flush();
//		fileOut.close();
		return wb;
	}
	
	/*
	 * ˵��������֧��ȯ� IBOSaleDetailShowValue����ϸ��Ϣ wb:excel����̨ cnt:������
	 */
	public void setWeaponZFQ(IBOSaleWeaponDeValue detailvalue, Workbook wb, int cnt) {
		Sheet sheet = wb.getSheetAt(1);
		Row row = sheet.createRow(4 + cnt);
		// ��������
		row.createCell(1).setCellValue(detailvalue.getWeaponName());
		// ϸ���г�
		row.createCell(2).setCellValue(detailvalue.getMarketName());
		// ����
		row.createCell(3).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// Ԥ�滰�ѽ��(Ԫ��
		row.createCell(4).setCellValue(detailvalue.getPrestoreFee());
		// Ԥ��һ���Ե���(Ԫ��
		row.createCell(5).setCellValue(detailvalue.getPrestroreReachAccount());
		// ÿ�·������(Ԫ��
		row.createCell(6).setCellValue(detailvalue.getBLimit());
		// ��������(�£�
		row.createCell(7).setCellValue(detailvalue.getBackMonth());
		// ����֧���������(Ԫ��
		row.createCell(8).setCellValue(detailvalue.getPresentBusi2Amount());
		// ֧��ȯ����
		row.createCell(9).setCellValue(detailvalue.getZfqName());
		// ֧��ȯ����
		row.createCell(10).setCellValue(detailvalue.getZfqType());
		// ÿ�±�������(Ԫ��
		row.createCell(11).setCellValue(detailvalue.getLLimit());
		// ��������(�£�
		row.createCell(12).setCellValue(detailvalue.getBaseMonth());
		// ���ݰ��ܼ�ֵ(Ԫ��
		row.createCell(13).setCellValue(detailvalue.getDataFee());
		// ҵ������
		row.createCell(14).setCellValue(detailvalue.getBusiType());
		// ҵ������
		row.createCell(15).setCellValue("");
		// ÿ�¼�ֵ(Ԫ��
		row.createCell(16).setCellValue(detailvalue.getValuePermonth());
		// ��ͨ����(�£�
		row.createCell(17).setCellValue(detailvalue.getOpenMonth());
		// ȫ��ͨ����(��)
		row.createCell(18).setCellValue(detailvalue.getGlobalScore());
		// �����л���
		row.createCell(19).setCellValue(detailvalue.getSzxScore());
		// ���еش�����(Mֵ)
		row.createCell(20).setCellValue(detailvalue.getDynamicScore());
		// ��ͥ����(�֣�
		row.createCell(21).setCellValue(detailvalue.getHomeScore());
	}

	/*
	 * ˵�������뻰�ѻ IBOSaleDetailShowValue����ϸ��Ϣ wb:excel����̨ cnt:������
	 */
	public void setWeaponHF(IBOSaleWeaponDeValue detailvalue, Workbook wb, int cnt) {
		Sheet sheet = wb.getSheetAt(2);
		Row row = sheet.createRow(4 + cnt);
		// ��������
		row.createCell(1).setCellValue(detailvalue.getWeaponName());
		// ϸ���г�
		row.createCell(2).setCellValue(detailvalue.getMarketName());
		// ����
		row.createCell(3).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// Ԥ�滰�ѽ��(Ԫ��
		row.createCell(4).setCellValue(detailvalue.getPrestoreFee());
		// Ԥ��һ���Ե���(Ԫ��
		row.createCell(5).setCellValue(detailvalue.getPrestroreReachAccount());
		// ÿ�·������(Ԫ��
		row.createCell(6).setCellValue(detailvalue.getBLimit());
		// ��������(�£�
		row.createCell(7).setCellValue(detailvalue.getBackMonth());
		// ���ͻ��ѽ��(Ԫ��
		row.createCell(8).setCellValue(detailvalue.getPresentBusiAmount());
		// ����һ���Ե���
		row.createCell(9).setCellValue(detailvalue.getPresentReachAmount());
		// ÿ�����ͽ��
		row.createCell(10).setCellValue(detailvalue.getPresentValuePermon());
		// ��������
		row.createCell(11).setCellValue(detailvalue.getPresentBusiMonth());
		// ÿ�±�������(Ԫ��
		row.createCell(12).setCellValue(detailvalue.getLLimit());
		// ��������(�£�
		row.createCell(13).setCellValue(detailvalue.getBaseMonth());
		// ���ݰ��ܼ�ֵ(Ԫ��
		row.createCell(14).setCellValue(detailvalue.getDataFee());
		// ҵ������
		row.createCell(15).setCellValue(detailvalue.getBusiType());
		// ҵ������
		row.createCell(16).setCellValue("");
		// ÿ�¼�ֵ(Ԫ��
		row.createCell(17).setCellValue(detailvalue.getValuePermonth());
		// ��ͨ����(�£�
		row.createCell(18).setCellValue(detailvalue.getOpenMonth());
		// ȫ��ͨ����(��)
		row.createCell(19).setCellValue(detailvalue.getGlobalScore());
		// �����л���
		row.createCell(20).setCellValue(detailvalue.getSzxScore());
		// ���еش�����(Mֵ)
		row.createCell(21).setCellValue(detailvalue.getDynamicScore());
		// ��ͥ����(�֣�
		row.createCell(22).setCellValue(detailvalue.getHomeScore());
	}

	/*
	 * ˵���������ͻ�Ʒ� IBOSaleDetailShowValue����ϸ��Ϣ wb:excel����̨ cnt:������
	 */
	public void setWeaponGoods(IBOSaleWeaponDeValue detailvalue, Workbook wb,
			int cnt) {
		Sheet sheet = wb.getSheetAt(3);
		Row row = sheet.createRow(4 + cnt);
		// ��������
		row.createCell(1).setCellValue(detailvalue.getWeaponName());
		// ϸ���г�
		row.createCell(2).setCellValue(detailvalue.getMarketName());
		// ����
		row.createCell(3).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// Ԥ�滰�ѽ��(Ԫ��
		row.createCell(4).setCellValue(detailvalue.getPrestoreFee());
		// Ԥ��һ���Ե���(Ԫ��
		row.createCell(5).setCellValue(detailvalue.getPrestroreReachAccount());
		// ÿ�·������(Ԫ��
		row.createCell(6).setCellValue(detailvalue.getBLimit());
		// ��������(�£�
		row.createCell(7).setCellValue(detailvalue.getBackMonth());
		// ��Ʒ����ָ���۸�
		row.createCell(8).setCellValue(detailvalue.getReferencePrice());
		// ��Ʒ�ɱ�
		row.createCell(9).setCellValue(detailvalue.getTermCostFee());
		// �ɹ�Ŀ¼
		row.createCell(10).setCellValue(detailvalue.getGoodAdoptDirectory());
		// ��Ʒ����
		row.createCell(11).setCellValue(detailvalue.getRemark2());
		// ÿ�±�������(Ԫ��
		row.createCell(12).setCellValue(detailvalue.getLLimit());
		// ��������(�£�
		row.createCell(13).setCellValue(detailvalue.getBaseMonth());
		// ���ݰ��ܼ�ֵ(Ԫ��
		row.createCell(14).setCellValue(detailvalue.getDataFee());
		// ҵ������
		row.createCell(15).setCellValue(detailvalue.getBusiType());
		// ҵ������
		row.createCell(16).setCellValue("");
		// ÿ�¼�ֵ(Ԫ��
		row.createCell(17).setCellValue(detailvalue.getValuePermonth());
		// ��ͨ����(�£�
		row.createCell(18).setCellValue(detailvalue.getOpenMonth());
		// ȫ��ͨ����(��)
		row.createCell(19).setCellValue(detailvalue.getGlobalScore());
		// �����л���
		row.createCell(20).setCellValue(detailvalue.getSzxScore());
		// ���еش�����(Mֵ)
		row.createCell(21).setCellValue(detailvalue.getDynamicScore());
		// ��ͥ����(�֣�
		row.createCell(22).setCellValue(detailvalue.getHomeScore());
	}

	/*
	 * ˵��������������ҵ�� IBOSaleDetailShowValue����ϸ��Ϣ wb:excel����̨ cnt:������
	 */
	public void setWeaponSelfBus(IBOSaleWeaponDeValue detailvalue, Workbook wb,
			int cnt) {
		Sheet sheet = wb.getSheetAt(4);
		Row row = sheet.createRow(4 + cnt);
		// ��������
		row.createCell(1).setCellValue(detailvalue.getWeaponName());
		// ϸ���г�
		row.createCell(2).setCellValue(detailvalue.getMarketName());
		// ����
		row.createCell(3).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// Ԥ�滰�ѽ��(Ԫ��
		row.createCell(4).setCellValue(detailvalue.getPrestoreFee());
		// Ԥ��һ���Ե���(Ԫ��
		row.createCell(5).setCellValue(detailvalue.getPrestroreReachAccount());
		// ÿ�·������(Ԫ��
		row.createCell(6).setCellValue(detailvalue.getBLimit());
		// ��������(�£�
		row.createCell(7).setCellValue(detailvalue.getBackMonth());
		// ����ҵ���ܼ�ֵ
		row.createCell(8).setCellValue(detailvalue.getPresentBusi4Amount());
		// ҵ������
		row.createCell(9).setCellValue(detailvalue.getBusiType());
		// ҵ������
		row.createCell(10).setCellValue(detailvalue.getRemark3());
		// ÿ�����ͼ�ֵ
		row.createCell(11).setCellValue(detailvalue.getPresentValuePermon());
		// ��������
		row.createCell(12).setCellValue(detailvalue.getPresentBusiMonth());
		// ÿ�±�������(Ԫ��
		row.createCell(13).setCellValue(detailvalue.getLLimit());
		// ��������(�£�
		row.createCell(14).setCellValue(detailvalue.getBaseMonth());
		// ���ݰ��ܼ�ֵ(Ԫ��
		row.createCell(15).setCellValue(detailvalue.getDataFee());
		// ҵ������
		row.createCell(16).setCellValue(detailvalue.getBusiType());
		// ҵ������
		row.createCell(17).setCellValue("");
		// ÿ�¼�ֵ(Ԫ��
		row.createCell(18).setCellValue(detailvalue.getValuePermonth());
		// ��ͨ����(�£�
		row.createCell(19).setCellValue(detailvalue.getOpenMonth());
		// ȫ��ͨ����(��)
		row.createCell(20).setCellValue(detailvalue.getGlobalScore());
		// �����л���
		row.createCell(21).setCellValue(detailvalue.getSzxScore());
		// ���еش�����(Mֵ)
		row.createCell(22).setCellValue(detailvalue.getDynamicScore());
		// ��ͥ����(�֣�
		row.createCell(23).setCellValue(detailvalue.getHomeScore());
	}

	/*
	 * ˵��������������ͻ IBOSaleDetailShowValue����ϸ��Ϣ wb:excel����̨ cnt:������
	 */
	public void setWeaponZHZS(IBOSaleWeaponDeValue detailvalue, Workbook wb, int cnt) {
		Sheet sheet = wb.getSheetAt(5);
		Row row = sheet.createRow(4 + cnt);
		// ��������
		row.createCell(1).setCellValue(detailvalue.getWeaponName());
		// ϸ���г�
		row.createCell(2).setCellValue(detailvalue.getMarketName());
		// ����
		row.createCell(3).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// Ԥ�滰�ѽ��(Ԫ��
		row.createCell(4).setCellValue(detailvalue.getPrestoreFee());
		// Ԥ��һ���Ե���(Ԫ��
		row.createCell(5).setCellValue(detailvalue.getPrestroreReachAccount());
		// ÿ�·������(Ԫ��
		row.createCell(6).setCellValue(detailvalue.getBLimit());
		// ��������(�£�
		row.createCell(7).setCellValue(detailvalue.getBackMonth());
		// ����֧���������(Ԫ��
		row.createCell(8).setCellValue(detailvalue.getPresentBusi2Amount());
		// ֧��ȯ����
		row.createCell(9).setCellValue(detailvalue.getZfqName());
		// �ɹ�Ŀ¼
		row.createCell(10).setCellValue(detailvalue.getGoodAdoptDirectory());
		// ��Ʒ�����ܼ�ֵ
		row.createCell(11).setCellValue(detailvalue.getPresentBusi3Amount());
		// ��Ʒ����ָ����
		row.createCell(12).setCellValue(detailvalue.getReferencePrice());
		// ���ͻ����ܼ�ֵ
		row.createCell(13).setCellValue(detailvalue.getPresentBusiAmount());
		// һ���Ե���
		row.createCell(14).setCellValue(detailvalue.getPresentReachAmount());
		// ��������ҵ���ܼ�ֵ
		row.createCell(15).setCellValue(detailvalue.getPresentBusi4Amount());
		// ҵ������
		row.createCell(16).setCellValue(detailvalue.getBusiType());
		// ÿ�±�������(Ԫ��
		row.createCell(17).setCellValue(detailvalue.getLLimit());
		// ��������(�£�
		row.createCell(18).setCellValue(detailvalue.getBaseMonth());
		// ���ݰ��ܼ�ֵ(Ԫ��
		row.createCell(19).setCellValue(detailvalue.getDataFee());
		// ҵ������
		row.createCell(20).setCellValue(detailvalue.getBusiType());
		// ҵ������
		row.createCell(21).setCellValue("");
		// ÿ�¼�ֵ(Ԫ��
		row.createCell(22).setCellValue(detailvalue.getValuePermonth());
		// ��ͨ����(�£�
		row.createCell(23).setCellValue(detailvalue.getOpenMonth());
		// ȫ��ͨ����(��)
		row.createCell(24).setCellValue(detailvalue.getGlobalScore());
		// �����л���
		row.createCell(25).setCellValue(detailvalue.getSzxScore());
		// ���еش�����(Mֵ)
		row.createCell(26).setCellValue(detailvalue.getDynamicScore());
		// ��ͥ����(�֣�
		row.createCell(27).setCellValue(detailvalue.getHomeScore());
	}

	/*
	 * ˵�����������ն˻ IBOSaleDetailShowValue����ϸ��Ϣ wb:excel����̨ cnt:������
	 */
	public void setWeaponSZD(IBOSaleWeaponDeValue detailvalue, Workbook wb, int cnt) {
		Sheet sheet = wb.getSheetAt(6);
		Row row = sheet.createRow(4 + cnt);
		// ��������
		row.createCell(1).setCellValue(detailvalue.getWeaponName());
		// ϸ���г�
		row.createCell(2).setCellValue(detailvalue.getMarketName());
		// ����
		row.createCell(3).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// Ԥ�滰�ѽ��(Ԫ��
		row.createCell(4).setCellValue(detailvalue.getPrestoreFee());
		// Ԥ��һ���Ե���(Ԫ��
		row.createCell(5).setCellValue(detailvalue.getPrestroreReachAccount());
		// ÿ�·������(Ԫ��
		row.createCell(6).setCellValue(detailvalue.getBLimit());
		// ��������(�£�
		row.createCell(7).setCellValue(detailvalue.getBackMonth());
		
		// �ն�ʵ�ʹ����
		row.createCell(8).setCellValue(detailvalue.getTermRealFee());
		// �ն�����
		row.createCell(9).setCellValue(detailvalue.getTermType());
		// �ն�����ָ���۸�
		row.createCell(10).setCellValue(detailvalue.getTermGuideFee());
		// �ն˳ɱ������
		row.createCell(11).setCellValue(detailvalue.getTermCostFee());
		
		// ÿ�±�������(Ԫ��
		row.createCell(12).setCellValue(detailvalue.getLLimit());
		// ��������(�£�
		row.createCell(13).setCellValue(detailvalue.getBaseMonth());
		// ���ݰ��ܼ�ֵ(Ԫ��
		row.createCell(14).setCellValue(detailvalue.getDataFee());
		// ҵ������
		row.createCell(15).setCellValue(detailvalue.getBusiType());
		// ҵ������
		row.createCell(16).setCellValue("");
		// ÿ�¼�ֵ(Ԫ��
		row.createCell(17).setCellValue(detailvalue.getValuePermonth());
		// ��ͨ����(�£�
		row.createCell(18).setCellValue(detailvalue.getOpenMonth());
		// ȫ��ͨ����(��)
		row.createCell(19).setCellValue(detailvalue.getGlobalScore());
		// �����л���
		row.createCell(20).setCellValue(detailvalue.getSzxScore());
		// ���еش�����(Mֵ)
		row.createCell(21).setCellValue(detailvalue.getDynamicScore());
		// ��ͥ����(�֣�
		row.createCell(22).setCellValue(detailvalue.getHomeScore());
	}

	/*
	 * ˵�������빺�ն��ͻ��� IBOSaleDetailShowValue����ϸ��Ϣ wb:excel����̨ cnt:������
	 */
	public void setWeaponGZDSHF(IBOSaleWeaponDeValue detailvalue, Workbook wb,
			int cnt) {
		Sheet sheet = wb.getSheetAt(7);
		Row row = sheet.createRow(4 + cnt);
		// ��������
		row.createCell(1).setCellValue(detailvalue.getWeaponName());
		// ϸ���г�
		row.createCell(2).setCellValue(detailvalue.getMarketName());
		// ����
		row.createCell(3).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());

		// �ն�����
		row.createCell(4).setCellValue(detailvalue.getTermType());
		// �ն�����ָ���۸�
		row.createCell(5).setCellValue(detailvalue.getTermGuideFee());
		// �ն˳ɱ������
		row.createCell(6).setCellValue(detailvalue.getTermCostFee());
		// �ն��ͺ�����
		row.createCell(7).setCellValue(detailvalue.getRemark4());
		
		// Ԥ��һ���Ե���(Ԫ��
		row.createCell(8).setCellValue(detailvalue.getPrestroreReachAccount());
		// ÿ�·������(Ԫ��
		row.createCell(9).setCellValue(detailvalue.getBLimit());
		// ��������(�£�
		row.createCell(10).setCellValue(detailvalue.getBackMonth());
		// �����˻�����
		row.createCell(11).setCellValue(detailvalue.getFeeAccountProperty());		
		
		// ÿ�±�������(Ԫ��
		row.createCell(12).setCellValue(detailvalue.getLLimit());
		// ��������(�£�
		row.createCell(13).setCellValue(detailvalue.getBaseMonth());
		// ���ݰ��ܼ�ֵ(Ԫ��
		row.createCell(14).setCellValue(detailvalue.getDataFee());
		// ҵ������
		row.createCell(15).setCellValue(detailvalue.getBusiType());
		// ҵ������
		row.createCell(16).setCellValue("");
		// ÿ�¼�ֵ(Ԫ��
		row.createCell(17).setCellValue(detailvalue.getValuePermonth());
		// ��ͨ����(�£�
		row.createCell(18).setCellValue(detailvalue.getOpenMonth());
		// ȫ��ͨ����(��)
		row.createCell(19).setCellValue(detailvalue.getGlobalScore());
		// �����л���
		row.createCell(20).setCellValue(detailvalue.getSzxScore());
		// ���еش�����(Mֵ)
		row.createCell(21).setCellValue(detailvalue.getDynamicScore());
		// ��ͥ����(�֣�
		row.createCell(22).setCellValue(detailvalue.getHomeScore());
	}

	/*
	 * ˵������������ҵ��Ӫ��� IBOSaleDetailShowValue����ϸ��Ϣ wb:excel����̨ cnt:������
	 */
	public void setWeaponSJYW(IBOSaleWeaponDeValue detailvalue, Workbook wb, int cnt) {
		Sheet sheet = wb.getSheetAt(8);
		Row row = sheet.createRow(4 + cnt);
		// ��������
		row.createCell(1).setCellValue(detailvalue.getWeaponName());
		// ϸ���г�
		row.createCell(2).setCellValue(detailvalue.getMarketName());
		// ����
		row.createCell(3).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// ���ݰ��ܼ�ֵ(Ԫ��
		row.createCell(4).setCellValue(detailvalue.getDataFee());
		// ҵ������
		row.createCell(5).setCellValue(detailvalue.getBusiType());
		// ҵ������
		row.createCell(6).setCellValue("");
		// ÿ�¼�ֵ(Ԫ��
		row.createCell(7).setCellValue(detailvalue.getValuePermonth());
		// ��ͨ����(�£�
		row.createCell(8).setCellValue(detailvalue.getOpenMonth());
		// ����֧���������(Ԫ��
		row.createCell(9).setCellValue(detailvalue.getPresentBusi2Amount());
		// ֧��ȯ����
		row.createCell(10).setCellValue(detailvalue.getZfqName());
		// �ɹ�Ŀ¼
		row.createCell(11).setCellValue(detailvalue.getGoodAdoptDirectory());
		// ��Ʒ�����ܼ�ֵ
		row.createCell(12).setCellValue(detailvalue.getPresentBusi3Amount());
		// ��Ʒ����ָ����
		row.createCell(13).setCellValue(detailvalue.getReferencePrice());
		// ���ͻ����ܼ�ֵ
		row.createCell(14).setCellValue(detailvalue.getPresentBusiAmount());
		// һ���Ե���
		row.createCell(15).setCellValue(detailvalue.getPresentReachAmount());
		// ��������ҵ���ܼ�ֵ
		row.createCell(16).setCellValue(detailvalue.getPresentBusi4Amount());
		// ҵ������
		row.createCell(17).setCellValue(detailvalue.getBusiType());
		// ȫ��ͨ����(��)
		row.createCell(18).setCellValue(detailvalue.getGlobalScore());
		// �����л���
		row.createCell(19).setCellValue(detailvalue.getSzxScore());
		// ���еش�����(Mֵ)
		row.createCell(20).setCellValue(detailvalue.getDynamicScore());
		// ��ͥ����(�֣�
		row.createCell(21).setCellValue(detailvalue.getHomeScore());
	}

	/*
	 * ˵������������Ӫ��� IBOSaleDetailShowValue����ϸ��Ϣ wb:excel����̨ cnt:������
	 */
	public void setWeaponOther(IBOSaleWeaponDeValue detailvalue, Workbook wb,
			int cnt) {
		Sheet sheet = wb.getSheetAt(9);
		Row row = sheet.createRow(4 + cnt);
		// ��������
		row.createCell(1).setCellValue(detailvalue.getWeaponName());
		// ϸ���г�
		row.createCell(2).setCellValue(detailvalue.getMarketName());
		// ����
		row.createCell(3).setCellValue(detailvalue.getMinnetAge()+"-"+detailvalue.getMaxnetAge());
		// �������ֲ�Ʒ
		row.createCell(4).setCellValue(detailvalue.getPresentBusi5Amount());
		// ���ֲ�Ʒ����
		row.createCell(5).setCellValue(detailvalue.getRemark5());
		// ��Ʒ�����ܼ�ֵ
		row.createCell(6).setCellValue(detailvalue.getPresentBusi3Amount());
		// ��Ʒ����ָ����
		row.createCell(7).setCellValue(detailvalue.getReferencePrice());
		// �ɹ�Ŀ¼
		row.createCell(8).setCellValue(detailvalue.getGoodAdoptDirectory());
		// ���ͻ����ܼ�ֵ
		row.createCell(9).setCellValue(detailvalue.getPresentBusiAmount());
		// һ���Ե���
		row.createCell(10).setCellValue(detailvalue.getPresentReachAmount());
		// ��������ҵ���ܼ�ֵ
		row.createCell(11).setCellValue(detailvalue.getPresentBusi4Amount());
		// ҵ������
		row.createCell(12).setCellValue(detailvalue.getBusiType());
		// ���ݰ��ܼ�ֵ(Ԫ��
		row.createCell(13).setCellValue(detailvalue.getDataFee());
		// ҵ������
		row.createCell(14).setCellValue(detailvalue.getBusiType());
		// ҵ������
		row.createCell(15).setCellValue("");
		// ÿ�¼�ֵ(Ԫ��
		row.createCell(16).setCellValue(detailvalue.getValuePermonth());
		// ��ͨ����(�£�
		row.createCell(17).setCellValue(detailvalue.getOpenMonth());
		// ȫ��ͨ����(��)
		row.createCell(18).setCellValue(detailvalue.getGlobalScore());
		// �����л���
		row.createCell(19).setCellValue(detailvalue.getSzxScore());
		// ���еش�����(Mֵ)
		row.createCell(20).setCellValue(detailvalue.getDynamicScore());
		// ��ͥ����(�֣�
		row.createCell(21).setCellValue(detailvalue.getHomeScore());
	}
	
	/*
	 * ˵��������·�����ļ����͹���ID,����Ӫ�����Ϣ dir������·�� fileName:�ļ��� mId:����ID
	 */
	public boolean exportWeapon(String dir, String fileName, String mId)
			throws Exception, RuntimeException {
		return true;
	}
	
	/**
	 * ˵��:���ݹ���ID������״̬��ѯ�����������
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
