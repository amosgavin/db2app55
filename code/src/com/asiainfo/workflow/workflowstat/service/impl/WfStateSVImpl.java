package com.asiainfo.workflow.workflowstat.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.workflow.workflowstat.dao.interfaces.IWfStateDAO;
import com.asiainfo.workflow.workflowstat.ivalues.IBOWorkflowStatValue;
import com.asiainfo.workflow.workflowstat.service.interfaces.IWfStateSV;

public class WfStateSVImpl implements IWfStateSV {

	/**
	 * ��������������������Ͳ�ѯ����״̬��Ϣ
	 * 
	 * @param regionId
	 *            �������
	 * @param workflowObjectType
	 *            ��������
	 * @param createDateStart
	 *            ����ʱ����
	 * @param createDateEnd
	 *            ����ʱ��ֹ
	 * @param startNum
	 *            ��¼��ʼ����
	 * @param endNum
	 *            ��¼��������
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOWorkflowStatValue[] getWfState(String regionId,
			String workflowObjectType, String createDateStart,
			String createDateEnd, int startNum, int endNum) throws Exception,
			RuntimeException {
		IBOWorkflowStatValue[] workflowStateList = null;

		workflowStateList = ((IWfStateDAO) ServiceFactory
				.getService(IWfStateDAO.class)).getWfState(regionId,
				workflowObjectType, createDateStart, createDateEnd, startNum,
				endNum);

		return workflowStateList;
	}

	/**
	 * ��������������������Ͳ�ѯ����״̬��Ϣ�ܼ�¼��
	 * 
	 * @param regionId
	 *            �������
	 * @param workflowObjectType
	 *            ��������
	 * @param createDateStart
	 *            ����ʱ����
	 * @param createDateEnd
	 *            ����ʱ��ֹ
	 * 
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getWfCount(String regionId, String workflowObjectType,
			String createDateStart, String createDateEnd) throws Exception,
			RuntimeException {
		IWfStateDAO wfStateDAO = (IWfStateDAO) ServiceFactory
				.getService(IWfStateDAO.class);
		return wfStateDAO.getWfCount(regionId, workflowObjectType,
				createDateStart, createDateEnd);
	}

	/**
	 * ��������������������͵���������Ϣ
	 * 
	 * @param regionId
	 *            �������ID
	 * @param workflowObjectType
	 *            ��������
	 * @param createDateStart
	 *            ����ʱ����
	 * @param createDateEnd
	 *            ����ʱ��ֹ
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public Workbook toExcel(String regionId, String workflowObjectType,
			String createDateStart, String createDateEnd) throws Exception,
			RuntimeException {
		Workbook wb = null;
		try {
			wb = workflowStatistic(regionId, workflowObjectType,
					createDateStart, createDateEnd);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return wb;
	}

	/**
	 * ���������������������ͳ�ƹ�����Ϣ
	 * 
	 * @param regionId
	 *            �������
	 * @param workflowObjectType
	 *            ��������
	 * @param createDateStart
	 *            ����ʱ����
	 * @param createDateEnd
	 *            ����ʱ��ֹ
	 * @return
	 */
	public Workbook workflowStatistic(String regionId,
			String workflowObjectType, String createDateStart,
			String createDateEnd) throws Exception, RuntimeException {
		IBOWorkflowStatValue[] wfStatList = ((IWfStateSV) ServiceFactory
				.getService(IWfStateSV.class)).getWfState(regionId,
				workflowObjectType, createDateStart, createDateEnd);
		HttpServletRequest request = SessionManager.getRequest();

		String templateFile = request.getRealPath("/")
				+ "/template/workflowstatistic_template.xls";

		InputStream fileIn = new FileInputStream(new File(templateFile));
		HSSFWorkbook wb = new HSSFWorkbook(fileIn);

		if (wfStatList.length != 0) {
			HSSFSheet sheetMain = wb.getSheetAt(0);
			HSSFRow row = null;
			HSSFCellStyle cellStyle = wb.createCellStyle();
			HSSFCellStyle cellStyle1 = wb.createCellStyle();
			// ���õ�Ԫ��ı߿�
			cellStyle.setBorderLeft(cellStyle.BORDER_THIN);
			cellStyle.setBorderBottom(cellStyle.BORDER_THIN);
			cellStyle.setBorderRight(cellStyle.BORDER_THIN);
			cellStyle.setBorderTop(cellStyle.BORDER_THIN);
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);

			cellStyle1.setBorderLeft(cellStyle.BORDER_THIN);
			cellStyle1.setBorderBottom(cellStyle.BORDER_THIN);
			cellStyle1.setBorderRight(cellStyle.BORDER_THIN);
			cellStyle1.setBorderTop(cellStyle.BORDER_THIN);
			// �趨��Ԫ������ڸ�ʽΪyyyy-mm-dd hh:mm
			HSSFDataFormat dataformat = wb.createDataFormat();
			cellStyle1.setDataFormat(dataformat
					.getFormat("yyyy-mm-dd hh:mm:ss"));
			cellStyle1.setAlignment(HSSFCellStyle.ALIGN_LEFT);

			for (int i = 0; i < wfStatList.length; i++) {
				row = sheetMain.createRow(i + 2);

				HSSFCell cell0 = row.createCell(0);
				cell0.setCellValue(wfStatList[i].getStaffName());
				cell0.setCellStyle(cellStyle);
				sheetMain.autoSizeColumn(0);

				HSSFCell cell1 = row.createCell(1);
				String regionName = getRegionName(wfStatList[i].getRegionId());
				cell1.setCellValue(regionName);
				cell1.setCellStyle(cellStyle);
				sheetMain.autoSizeColumn(1);

				HSSFCell cell2 = row.createCell(2);
				String workflowObjectTypeName = getWorkflowObjectTypeName(wfStatList[i]
						.getWorkflowObjectType());
				cell2.setCellValue(workflowObjectTypeName);
				cell2.setCellStyle(cellStyle);
				sheetMain.autoSizeColumn(2);

				HSSFCell cell3 = row.createCell(3);
				cell3.setCellValue(wfStatList[i].getWorkflowObjectId());
				cell3.setCellStyle(cellStyle);
				sheetMain.autoSizeColumn(3);

				HSSFCell cell4 = row.createCell(4);
				cell4.setCellValue(wfStatList[i].getCreateDate());
				cell4.setCellStyle(cellStyle1);
				sheetMain.autoSizeColumn(4);

				// ���õ�Ԫ��Ϊ�ı���ʽ
				// cellStyle.setDataFormat(dataformat.getFormat("@"));

				HSSFCell cell5 = row.createCell(5);
				cell5.setCellValue(wfStatList[i].getLabel());
				cell5.setCellStyle(cellStyle);
				sheetMain.autoSizeColumn(5);
			}
		}

		return wb;
	}

	/**
	 * ���ݹ������ʹ����ȡ��Ӧ�Ĺ�����������
	 * 
	 * @param workflowObjectType
	 *            �������ʹ���
	 * @return
	 */
	public String getWorkflowObjectTypeName(String workflowObjectType) {
		String workflowObjectTypeName = "";
		if (workflowObjectType.equals("weaponCase")) {
			workflowObjectTypeName = "����";
		} else if (workflowObjectType.equals("saleCaseT")) {
			workflowObjectTypeName = "Ӫ����";
		}
		return workflowObjectTypeName;
	}

	/**
	 * �����������ID��ȡ��Ӧ�����������
	 * 
	 * @param regionId
	 *            �������ID
	 * @return
	 */
	public String getRegionName(String regionId) {
		String regionName = "";
		switch (Integer.parseInt(regionId)) {
		case 10:
			regionName = "ʡ��˾";
			break;
		case 11:
			regionName = "�人";
			break;
		case 12:
			regionName = "��ʯ";
			break;
		case 13:
			regionName = "����";
			break;
		case 14:
			regionName = "�˲�";
			break;
		case 15:
			regionName = "��ʩ";
			break;
		case 16:
			regionName = "ʮ��";
			break;
		case 17:
			regionName = "����";
			break;
		case 18:
			regionName = "����";
			break;
		case 19:
			regionName = "����";
			break;
		case 20:
			regionName = "����";
			break;
		case 23:
			regionName = "����";
			break;
		case 24:
			regionName = "����";
			break;
		case 25:
			regionName = "�Ƹ�";
			break;
		case 26:
			regionName = "Т��";
			break;

		default:
			regionName = "";
			break;
		}

		return regionName;
	}

	/**
	 * �����������ID����������ͳ�ƹ�����Ϣ
	 * 
	 * @param regionId
	 *            �������ID
	 * @param workflowObjectType
	 *            ��������
	 * @param createDateStart
	 *            ����ʱ����
	 * @param createDateEnd
	 *            ����ʱ��ֹ
	 * @return
	 * @throws Exception
	 */
	public IBOWorkflowStatValue[] getWfState(String regionId,
			String workflowObjectType, String createDateStart,
			String createDateEnd) throws Exception {
		IBOWorkflowStatValue[] workflowStateList = null;

		workflowStateList = ((IWfStateDAO) ServiceFactory
				.getService(IWfStateDAO.class)).getWfState(regionId,
				workflowObjectType, createDateStart, createDateEnd);

		return workflowStateList;
	}

}
