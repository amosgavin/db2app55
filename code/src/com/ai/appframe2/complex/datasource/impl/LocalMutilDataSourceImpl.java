package com.ai.appframe2.complex.datasource.impl;

import com.ai.appframe2.complex.datasource.interfaces.IDataSource;
import com.ai.appframe2.util.locale.AppframeLocaleFactory;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LocalMutilDataSourceImpl extends AbstractLocalDataSourceImpl
  implements IDataSource
{
  private static transient Log log = LogFactory.getLog(LocalMutilDataSourceImpl.class);

  public LocalMutilDataSourceImpl()
    throws Exception
  {
  }

  public DataSource getDataSource(String ds)
    throws Exception
  {
    return (DataSource)DATASOURCE_MAP.get(ds.trim());
  }

  public Connection getConnectionFromDataSource(String ds)
    throws Exception
  {
    Connection rtn = null;
    try {
      DataSource objDataSource = (DataSource)DATASOURCE_MAP.get(ds.trim());
      if (objDataSource == null) {
        if (URL_MAP.containsKey(ds))
        {
          log.error(AppframeLocaleFactory.getResource("com.ai.appframe2.complex.datasource.impl.getConnByds_error", new String[] { ds }));
        }
        else
        {
          log.error(AppframeLocaleFactory.getResource("com.ai.appframe2.complex.datasource.impl.getConnByds_failed", new String[] { ds }));
        }
      }
      rtn = objDataSource.getConnection();
      rtn.setAutoCommit(false);
    }
    catch (Exception ex) {
      log.error(AppframeLocaleFactory.getResource("com.ai.appframe2.complex.datasource.impl.getConnByds_failed", new String[] { ds }), ex);
      throw ex;
    }

    if (log.isDebugEnabled()) {
      try
      {
        DatabaseMetaData dmd = rtn.getMetaData();
        if (dmd.getDatabaseProductName().toUpperCase().indexOf("ORACLE") != -1)
          printPhysicalConnectionInfo(rtn, ds);
      }
      catch (Exception ex)
      {
        log.error(AppframeLocaleFactory.getResource("com.ai.appframe2.complex.datasource.impl.print_physical"), ex);
      }
    }

    return rtn;
  }

  public String getPrimaryDataSource()
    throws Exception
  {
    if (primaryDataSource == null)
    {
      throw new Exception(AppframeLocaleFactory.getResource("com.ai.appframe2.complex.datasource.miss_base_dsname"));
    }
    return primaryDataSource;
  }

  private void printPhysicalConnectionInfo(Connection conn, String ds)
    throws Exception
  {
    PreparedStatement ptmt = null;
    ResultSet rs = null;
    try {
      ptmt = conn.prepareStatement("SELECT to_number(substr(dbms_session.unique_session_id,1,4),'xxxx') FROM dual");
      rs = ptmt.executeQuery();
      while (rs.next())
      {
        log.debug(AppframeLocaleFactory.getResource("com.ai.appframe2.complex.datasource.impl.ds_sid_error", new String[] { ds, rs.getString(1) }));
      }
    }
    catch (Exception ex)
    {
    }
    finally {
      if (rs != null) {
        rs.close();
      }
      if (ptmt != null)
        ptmt.close();
    }
  }
}