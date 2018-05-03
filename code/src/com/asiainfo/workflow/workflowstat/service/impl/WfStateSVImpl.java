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
	 * 根据申请地区、工单类型查询工单状态信息
	 * 
	 * @param regionId
	 *            申请地区
	 * @param workflowObjectType
	 *            工单类型
	 * @param createDateStart
	 *            创建时间起
	 * @param createDateEnd
	 *            创建时间止
	 * @param startNum
	 *            记录开始索引
	 * @param endNum
	 *            记录结束索引
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
	 * 根据申请地区、工单类型查询工单状态信息总记录数
	 * 
	 * @param regionId
	 *            申请地区
	 * @param workflowObjectType
	 *            工单类型
	 * @param createDateStart
	 *            创建时间起
	 * @param createDateEnd
	 *            创建时间止
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
	 * 根据申请地区，申请类型导出工单信息
	 * 
	 * @param regionId
	 *            申请地区ID
	 * @param workflowObjectType
	 *            工单类型
	 * @param createDateStart
	 *            创建时间起
	 * @param createDateEnd
	 *            创建时间止
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
	 * 根据申请地区，申请类型统计工单信息
	 * 
	 * @param regionId
	 *            申请地区
	 * @param workflowObjectType
	 *            申请类型
	 * @param createDateStart
	 *            创建时间起
	 * @param createDateEnd
	 *            创建时间止
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
			// 设置单元格的边框
			cellStyle.setBorderLeft(cellStyle.BORDER_THIN);
			cellStyle.setBorderBottom(cellStyle.BORDER_THIN);
			cellStyle.setBorderRight(cellStyle.BORDER_THIN);
			cellStyle.setBorderTop(cellStyle.BORDER_THIN);
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);

			cellStyle1.setBorderLeft(cellStyle.BORDER_THIN);
			cellStyle1.setBorderBottom(cellStyle.BORDER_THIN);
			cellStyle1.setBorderRight(cellStyle.BORDER_THIN);
			cellStyle1.setBorderTop(cellStyle.BORDER_THIN);
			// 设定单元格的日期格式为yyyy-mm-dd hh:mm
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

				// 设置单元格为文本格式
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
	 * 根据工单类型代码获取对应的工单类型名称
	 * 
	 * @param workflowObjectType
	 *            工单类型代码
	 * @return
	 */
	public String getWorkflowObjectTypeName(String workflowObjectType) {
		String workflowObjectTypeName = "";
		if (workflowObjectType.equals("weaponCase")) {
			workflowObjectTypeName = "武器";
		} else if (workflowObjectType.equals("saleCaseT")) {
			workflowObjectTypeName = "营销案";
		}
		return workflowObjectTypeName;
	}

	/**
	 * 根据申请地区ID获取对应申请地区名称
	 * 
	 * @param regionId
	 *            申请地区ID
	 * @return
	 */
	public String getRegionName(String regionId) {
		String regionName = "";
		switch (Integer.parseInt(regionId)) {
		case 10:
			regionName = "省公司";
			break;
		case 11:
			regionName = "武汉";
			break;
		case 12:
			regionName = "黄石";
			break;
		case 13:
			regionName = "鄂州";
			break;
		case 14:
			regionName = "宜昌";
			break;
		case 15:
			regionName = "恩施";
			break;
		case 16:
			regionName = "十堰";
			break;
		case 17:
			regionName = "襄阳";
			break;
		case 18:
			regionName = "江汉";
			break;
		case 19:
			regionName = "咸宁";
			break;
		case 20:
			regionName = "荆州";
			break;
		case 23:
			regionName = "荆门";
			break;
		case 24:
			regionName = "随州";
			break;
		case 25:
			regionName = "黄冈";
			break;
		case 26:
			regionName = "孝感";
			break;

		default:
			regionName = "";
			break;
		}

		return regionName;
	}

	/**
	 * 根据申请地区ID，申请类型统计工单信息
	 * 
	 * @param regionId
	 *            申请地区ID
	 * @param workflowObjectType
	 *            申请类型
	 * @param createDateStart
	 *            创建时间起
	 * @param createDateEnd
	 *            创建时间止
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
