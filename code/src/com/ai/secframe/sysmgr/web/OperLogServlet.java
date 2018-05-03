package com.ai.secframe.sysmgr.web;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.web.HttpUtil;
import com.asiainfo.costWarn.job.ConnectUtil;

/**
 * 
 * @author:shigm
 * @date : 2013-11-6
 */

public class OperLogServlet extends HttpServlet {

	private static final long serialVersionUID = -2077523176373954611L;
	private transient static Log log = LogFactory.getLog(OperLogServlet.class);

	public OperLogServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		log.debug("destroy");
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("doGet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		request.setCharacterEncoding("gbk");
		
		log.debug("doPost");
		long orgIdL = SessionManager.getUser().getOrgId();
		String   orgId ;
		String temOrgId = String.valueOf(orgIdL);
		if("10".equals(temOrgId.substring(0,2))){
			orgId = "0";
		}else{
			orgId = temOrgId.substring(0,2);
		}
		String code = SessionManager.getUser().getCode();
		String userIp = SessionManager.getUser().getIP();
 
		
		String host = request.getRemoteAddr();
		int port = request.getServerPort();
		
		String menuName =  URLDecoder.decode(request.getParameter("menuName"),"utf-8");
		String menuUri = request.getParameter("menuUri");
		String menuMid = request.getParameter("menuMid");
		 
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = ConnectUtil.getConnection("jdbc/WEBDB");
			String sql = "insert into pt.visitlist(loginname,area_id,track_mid,track,ipaddr,uri,app_serv) values (?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, code);
			ps.setString(2,orgId);
			ps.setString(3, menuMid);
			ps.setString(4, menuName.trim());
			ps.setString(5, userIp);
			ps.setString(6, menuUri.trim());
			ps.setString(7,host+":"+port );
			ps.executeUpdate();
			ConnectUtil.releaseConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void init() throws ServletException {
	}

}
