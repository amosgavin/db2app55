/**
 * 
 */
package com.asiainfo.mstrcheck.web;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.mstrcheck.service.interfaces.ISzReportSV;

/**
 * @author zhangds
 * 
 */
public class SzMSTRController extends BaseAction {

	private static Logger LOG = Logger.getLogger(SzMSTRController.class);

	public String loginCheck(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String szToken = request.getParameter("szToken");
		// System.out.println(szToken);

		LOG.info("szToken=" + szToken);
		String tokenXml = ((ISzReportSV) ServiceFactory
				.getService(ISzReportSV.class)).getXml(szToken);
		
		//response.setCharacterEncoding("UTF-8");
		/*response.setContentType("text/xml; charset=utf-8");
		PrintWriter out = response.getWriter();
	    OutputFormat format = OutputFormat.createCompactFormat();
	    //È¥µôxmlÍ·
		//format.setSuppressDeclaration(true);
		//format.isPadText();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(out, format);
		writer.write(tokenXml);
		writer.flush();
		writer.close();*/
		
		OutputStream out = response.getOutputStream();
		OutputStreamWriter outwriter = new OutputStreamWriter(out,"UTF-8");
		outwriter.write(tokenXml);
		outwriter.flush();
		return tokenXml;
	}
}
