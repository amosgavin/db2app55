<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="com.asiainfo.task.web.AssignTaskAction"%>
<%@ page import="org.apache.poi.ss.usermodel.Workbook"%>
<%@ page import="org.apache.poi.xssf.usermodel.XSSFWorkbook"%>
<%@ page import="com.ai.appframe2.web.CustomProperty"%>
<%@ page import="java.io.OutputStream"%>
<%@ page import="com.asiainfo.task.service.interfaces.ICurTaskSV"%>
<%@ page import="com.ai.appframe2.service.ServiceFactory"%>
<%@ page import="com.ai.appframe2.web.HttpUtil"%>

<%
		String mid = request.getParameter("mid");
		String type = request.getParameter("type");
		CustomProperty cp = CustomProperty.getInstance();
		response.reset();
		//response.setContentType("application/msExcel");
		response.setHeader("Content-Type","application/msExcel");  
        response.setHeader("Content-Disposition", "attachment; filename=\""+"\""+type+".xls");
        
        OutputStream outStream = response.getOutputStream();
		try{
			Workbook wb = ((ICurTaskSV) ServiceFactory.getService(ICurTaskSV.class)).toExcel(mid, type);
			if(wb !=null){
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "导出完成！");
			}else{
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "导出失败，请联系管理员！");
			}
	        wb.write(outStream);
		}catch(Exception e){
			e.printStackTrace();
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "导出失败，请联系管理员！");
		}finally{
			//HttpUtil.showInfo(response, cp);
	        outStream.flush();
	        outStream.close();
     		out.clear();
	    	out = pageContext.pushBody();
		}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  </body>
</html>
