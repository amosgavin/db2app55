package com.asiainfo.costWarn.job;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ConnectUtil {

	public static Context ctx = null;
	public static Map map = new HashMap();
	
	public static Connection getConnection() {
		try {
			return getDataSource("jdbc/WEBDB").getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Connection getConnection(String jndi) {
		try {
			return getDataSource(jndi).getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static DataSource getDataSource(String jndiname) {
		try {
			if (ctx == null)
				ctx = new InitialContext();

			if (map.containsKey(jndiname)) {
				return (DataSource) map.get(jndiname);
			} else {
				DataSource ds = (DataSource) ctx.lookup("java:comp/env/" + jndiname);
				map.put(jndiname, ds);
				return ds;
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void releaseConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
