<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="org.apache.poi.ss.usermodel.Workbook"%>
<%@ page import="org.apache.poi.xssf.usermodel.XSSFWorkbook"%>
<%@ page import="com.ai.appframe2.web.CustomProperty"%>
<%@ page import="java.io.OutputStream"%>
<%@ page import="com.ai.appframe2.service.ServiceFactory"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>
<%@ page
	import="com.asiainfo.workflow.workflowstat.service.interfaces.IWfStateSV"%>

<%
	String regionId = request.getParameter("regionId");
	String workflowObjectType = request
			.getParameter("workflowObjectType");
	String createDateStart = request.getParameter("createDateStart");
	String createDateEnd = request.getParameter("createDateEnd");
	response.reset();
	String fileName = "workflowstatistic";

	CustomProperty cp = CustomProperty.getInstance();
	response.setHeader("Content-Type", "application/msExcel");
	response.setHeader("Content-Disposition", "attachment; filename=\""
			+ "\"" + fileName + ".xls");

	OutputStream outputStream = response.getOutputStream();

	try {
		Workbook wb = ((IWfStateSV) ServiceFactory
				.getService(IWfStateSV.class)).toExcel(regionId,
				workflowObjectType, createDateStart, createDateEnd);
		if (wb != null) {
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "导出完成！");
		} else {
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "导出失败，请联系管理员！");
		}
		wb.write(outputStream);
	} catch (Exception e) {
		e.printStackTrace();
		cp.set("FLAG", "N");
		cp.set("MESSAGE", "导出失败，请联系管理员！");
	} finally {
		outputStream.flush();
		outputStream.close();
		out.clear();
		out = pageContext.pushBody();
	}
%>