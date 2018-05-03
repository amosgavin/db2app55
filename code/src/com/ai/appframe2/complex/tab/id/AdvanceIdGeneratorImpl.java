package com.ai.appframe2.complex.tab.id;

import com.ai.appframe2.bo.ObjectTypeNull;
import com.ai.appframe2.bo.ObjectTypeSingleValue;
import com.ai.appframe2.bo.dialect.DialectFactory;
import com.ai.appframe2.bo.dialect.IDialect;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.IdGenerator;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.Session;
import com.ai.appframe2.complex.cache.CacheFactory;
import com.ai.appframe2.complex.cache.impl.BatchIdGeneratorCacheImpl;
import com.ai.appframe2.complex.cache.impl.IdGeneratorCacheImpl;
import com.ai.appframe2.complex.cache.impl.IdGeneratorWrapperCacheImpl;
import com.ai.appframe2.complex.cache.impl.SysDateCacheImpl;
import com.ai.appframe2.complex.datasource.interfaces.IDataSource;
import com.ai.appframe2.complex.self.po.IdGeneratorBean;
import com.ai.appframe2.complex.self.po.IdGeneratorWrapperBean;
import com.ai.appframe2.complex.transaction.interfaces.IMutilTransactionDatasource;
import com.ai.appframe2.complex.transaction.interfaces.ITransactionDatasource;
import com.ai.appframe2.util.locale.AppframeLocaleFactory;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class AdvanceIdGeneratorImpl
  implements IdGenerator
{
  private static transient Log log = LogFactory.getLog(AdvanceIdGeneratorImpl.class);

  private IdGeneratorBean getIdGeneratorBean(String tableName)
  {
    IdGeneratorBean rtn = null;
    try {
      rtn = (IdGeneratorBean)CacheFactory.get(IdGeneratorCacheImpl.class, tableName.toUpperCase());
    }
    catch (Exception ex) {
      throw new RuntimeException(ex);
    }
    return rtn;
  }

  private BatchSequence getBatchIdGeneratorBean(String tableName)
  {
    BatchSequence rtn = null;
    try {
      rtn = (BatchSequence)CacheFactory.get(BatchIdGeneratorCacheImpl.class, tableName.toUpperCase());
    }
    catch (Exception ex) {
      throw new RuntimeException(ex);
    }
    return rtn;
  }

  private BatchSequence getBatchSequenceInstance(String tableName)
  {
    return getBatchIdGeneratorBean(tableName.toUpperCase());
  }

  public BigDecimal getNewId(ObjectType type)
    throws AIException
  {
    if ((type instanceof ObjectTypeNull) || (type instanceof ObjectTypeSingleValue))
    {
      throw new AIException(AppframeLocaleFactory.getResource("com.ai.appframe2.complex.tab.id.undo_getNewId", new String[] { type.getFullName() }));
    }

    return getNewId(type.getMapingEnty());
  }

  public long getNewId(String dataSourceName, String tableName)
    throws AIException
  {
    BigDecimal rtn = null;

    String tmp = StringUtils.replace(StringUtils.replace(tableName, "{", ""), "}", "");

    BatchSequence objBatchSequence = getBatchSequenceInstance(tmp);
    if (objBatchSequence != null)
      try {
        rtn = BigDecimal.valueOf(objBatchSequence.getNewId(dataSourceName));
      }
      catch (Exception ex) {
        log.error(AppframeLocaleFactory.getResource("com.ai.appframe2.complex.tab.id.AdvanceIdGeneratorImpl.getsequence_failed", new String[] { tmp }), ex);
        throw new AIException(ex.getMessage());
      }
    else {
      try
      {
        rtn = getRealNewId(dataSourceName, tmp);
      }
      catch (Exception ex) {
        log.error(ex.getMessage(), ex);
        throw new AIException(ex.getMessage());
      }

    }

    long id = 0L;
    try {
      id = wrapperId(tmp, rtn.longValue());
    }
    catch (Exception ex) {
      log.error("error", ex);
      throw new AIException(ex.getMessage(), ex);
    }

    return id;
  }

  public BigDecimal getNewIdByConnection(Connection conn, String tableName)
    throws AIException
  {
    BigDecimal rtn = null;

    String tmp = StringUtils.replace(StringUtils.replace(tableName, "{", ""), "}", "").trim();

    BatchSequence objBatchSequence = getBatchSequenceInstance(tmp);
    if (objBatchSequence != null)
      try {
        rtn = BigDecimal.valueOf(objBatchSequence.getNewId(conn));
      }
      catch (Exception ex) {
        log.error(AppframeLocaleFactory.getResource("com.ai.appframe2.complex.tab.id.AdvanceIdGeneratorImpl.getsequence_failed", new String[] { tmp }), ex);
        throw new AIException(ex.getMessage());
      }
    else {
      try
      {
        rtn = getRealNewIdByConnection(conn, tmp);
      }
      catch (Exception ex) {
        log.error(ex.getMessage(), ex);
        throw new AIException(ex.getMessage());
      }

    }

    long id = 0L;
    try {
      id = wrapperId(tmp, rtn.longValue());
    }
    catch (Exception ex) {
      log.error("error", ex);
      throw new AIException(ex.getMessage(), ex);
    }

    return BigDecimal.valueOf(id);
  }

  public BigDecimal getNewId(String tableName)
    throws AIException
  {
    return new BigDecimal(getNewId((String)null, tableName));
  }

  public BigDecimal getRealNewId(String dataSource, String tableName)
    throws Exception
  {
    BigDecimal rtn = null;

    Connection conn = null;
    try
    {
      if (StringUtils.isBlank(dataSource)) {
        conn = ServiceManager.getSession().getConnection();
      }
      else {
        conn = ServiceManager.getSession().getConnection(dataSource);
      }

      rtn = getRealNewIdByConnection(conn, tableName);
    }
    catch (Exception e)
    {
    }
    finally
    {
      if (conn != null) {
        conn.close();
      }
    }

    return rtn;
  }

  public BigDecimal getRealNewIdByConnection(Connection conn, String tableName)
    throws Exception
  {
    BigDecimal rtn = null;
    try
    {
      IdGeneratorBean objIdGeneratorBean = getIdGeneratorBean(tableName);
      if ((objIdGeneratorBean == null) || (StringUtils.isBlank(objIdGeneratorBean.getSequenceName())))
      {
        throw new Exception(AppframeLocaleFactory.getResource("com.ai.appframe2.complex.tab.id.miss_sequence", new String[] { tableName }));
      }
      System.out.println(objIdGeneratorBean.getSequenceName());
      rtn = new BigDecimal(DialectFactory.getDialect().getNewId(conn, objIdGeneratorBean.getSequenceName()));
    }
    catch (Exception e) {
      throw e;
    }

    return rtn;
  }

  public boolean getHisDataFlag(String tableName)
  {
    boolean flag = false;
    IdGeneratorBean bean = getIdGeneratorBean(tableName);
    if (bean == null) {
      return false;
    }
    String his_flag = bean.getHisDataFlag();
    if ((his_flag != null) && (his_flag.equalsIgnoreCase("Y"))) {
      flag = true;
    }
    return flag;
  }

  public boolean getHisDoneCodeFlag(String tableName)
  {
    boolean flag = false;
    IdGeneratorBean bean = getIdGeneratorBean(tableName);
    if (bean == null) {
      return false;
    }

    String his_doneCode_flag = bean.getHisDonecodeFlag();
    if ((his_doneCode_flag != null) && (his_doneCode_flag.equalsIgnoreCase("Y"))) {
      flag = true;
    }
    return flag;
  }

  public String getHisTableName(String tableName)
  {
    String hisTableName = null;
    IdGeneratorBean bean = getIdGeneratorBean(tableName);
    if (bean == null) {
      return null;
    }
    hisTableName = bean.getHisTableName();
    return hisTableName;
  }

  public BigDecimal getHisTableNewId(ObjectType type)
    throws AIException
  {
    if ((type instanceof ObjectTypeNull) || (type instanceof ObjectTypeSingleValue))
    {
      throw new AIException(AppframeLocaleFactory.getResource("com.ai.appframe2.complex.tab.id.undo_getNewId", new String[] { type.getFullName() }));
    }
    return getHisTableNewId(type.getMapingEnty());
  }

  public BigDecimal getHisTableNewId(String tableName)
    throws AIException
  {
    BigDecimal rtn = null;

    String srcTableName = StringUtils.replace(StringUtils.replace(tableName, "{", ""), "}", "").trim();

    IdGeneratorBean objIdGeneratorBean = getIdGeneratorBean(srcTableName);

    String hisTableName = objIdGeneratorBean.getHisTableName();

    if (StringUtils.isBlank(hisTableName))
    {
      throw new AIException(AppframeLocaleFactory.getResource("com.ai.appframe2.complex.tab.id.miss_his_sequence", new String[] { srcTableName }));
    }

    BatchSequence objBatchSequence = getBatchSequenceInstance(hisTableName);
    if (objBatchSequence != null)
      try {
        rtn = BigDecimal.valueOf(objBatchSequence.getNewId());
      }
      catch (Exception ex) {
        log.error(ex.getMessage(), ex);
        throw new AIException(ex.getMessage());
      }
    else {
      try
      {
        rtn = getRealHisTableNewId(objIdGeneratorBean.getHisSequenceName());
      }
      catch (Exception ex) {
        log.error(ex.getMessage(), ex);
        throw new AIException(ex.getMessage());
      }

    }

    long id = 0L;
    try {
      id = wrapperHisId(srcTableName, rtn.longValue());
    }
    catch (Exception ex) {
      log.error("error", ex);
      throw new AIException(ex.getMessage(), ex);
    }

    return BigDecimal.valueOf(id);
  }

  public BigDecimal getRealHisTableNewId(String sequenceName)
    throws Exception
  {
    BigDecimal rtn = null;

    Connection conn = null;
    try {
      if (sequenceName == null)
      {
        throw new Exception(AppframeLocaleFactory.getResource("com.ai.appframe2.complex.tab.id.no_his_sequence", new String[] { sequenceName }));
      }
      conn = ServiceManager.getSession().getConnection();

      rtn = new BigDecimal(DialectFactory.getDialect().getNewId(conn, sequenceName));
    }
    catch (Exception e)
    {
    }
    finally {
      if (conn != null) {
        conn.close();
      }
    }
    return rtn;
  }

  public Timestamp getSysDate(ObjectType type)
    throws Exception
  {
    return getSysDate();
  }

  public Timestamp getSysDate()
    throws Exception
  {
    return getSysDate((String)null);
  }

  public Timestamp getSysDate(String dataSourceName)
    throws Exception
  {
    String ds = null;
    if (!StringUtils.isBlank(dataSourceName)) {
      ds = dataSourceName;
    }
    else {
      ds = (String)IDataSource.CUR_DATASOURCE.get();
      if (ds == null) {
        if (ServiceManager.getSession() instanceof ITransactionDatasource) {
          ITransactionDatasource objITransactionDatasource = (ITransactionDatasource)ServiceManager.getSession();
          ds = objITransactionDatasource.getTxDataSource();
          if (log.isInfoEnabled())
          {
            log.info(AppframeLocaleFactory.getResource("com.ai.appframe2.complex.tab.id.AdvanceIdGeneratorImpl.getdate_nods_warn1", new String[] { ds }));
          }
        }
        else if (ServiceManager.getSession() instanceof IMutilTransactionDatasource) {
          IMutilTransactionDatasource objIMutilTransactionDatasource = (IMutilTransactionDatasource)ServiceManager.getSession();
          ds = objIMutilTransactionDatasource.getCurDataSource();
          if (log.isInfoEnabled())
          {
            log.info(AppframeLocaleFactory.getResource("com.ai.appframe2.complex.tab.id.AdvanceIdGeneratorImpl.getdate_nods_warn2", new String[] { ds }));
          }

        }
        else
        {
          throw new Exception(AppframeLocaleFactory.getResource("com.ai.appframe2.complex.datasource.no_datasource"));
        }
      }

      if (ds == null)
      {
        throw new Exception(AppframeLocaleFactory.getResource("com.ai.appframe2.complex.datasource.no_datasource"));
      }
    }

    long time = 0L;
    Long diff = (Long)CacheFactory.get(SysDateCacheImpl.class, ds);
    if (diff.longValue() == -99999999L)
    {
      time = getRealSysDate(ds);
    }
    else
    {
      time = System.currentTimeMillis() + diff.longValue();
    }

    if (time == 0L)
    {
      throw new Exception(AppframeLocaleFactory.getResource("com.ai.appframe2.complex.tab.id.fail_get_time"));
    }

    return new Timestamp(time);
  }

  private long getRealSysDate(String ds)
    throws Exception
  {
    long rtn = 0L;
    Connection conn = null;
    try {
      conn = ServiceManager.getSession().getConnection(ds);
      rtn = DialectFactory.getDialect().getSysDate(conn);
    }
    catch (Exception ex)
    {
    }
    finally {
      if (conn != null) {
        conn.close();
      }
    }
    return rtn;
  }

  public BigDecimal getNewId(Connection conn, ObjectType type)
    throws Exception
  {
    return getNewIdByConnection(conn, type.getMapingEnty());
  }

  public BigDecimal getNewId(Connection conn, String tableName)
    throws Exception
  {
    return getNewIdByConnection(conn, tableName);
  }

  public Timestamp getSysDate(Connection conn, ObjectType type)
    throws Exception
  {
    return getSysDate(type);
  }

  public BigDecimal getDirectNewId(Connection conn, ObjectType type)
    throws Exception
  {
    String tableName = type.getMapingEnty();
    return getDirectNewId(conn, tableName);
  }

  public BigDecimal getDirectNewId(Connection conn, String tableName)
    throws Exception
  {
    BigDecimal rtn = null;
    try
    {
      String tmp = StringUtils.replace(StringUtils.replace(tableName, "{", ""), "}", "");

      IdGeneratorBean objIdGeneratorBean = getIdGeneratorBean(tmp);
      if ((objIdGeneratorBean == null) || (StringUtils.isBlank(objIdGeneratorBean.getSequenceName())))
      {
        throw new Exception(AppframeLocaleFactory.getResource("com.ai.appframe2.complex.tab.id.miss_sequence", new String[] { tableName }));
      }

      rtn = new BigDecimal(DialectFactory.getDialect().getNewId(conn, objIdGeneratorBean.getSequenceName()));
    }
    catch (Exception e) {
      throw e;
    }

    return rtn;
  }

  private long wrapperId(String tableName, long id)
    throws Exception
  {
    IdGeneratorWrapperBean objIdGeneratorWrapperBean = (IdGeneratorWrapperBean)CacheFactory.get(IdGeneratorWrapperCacheImpl.class, tableName);
    if (objIdGeneratorWrapperBean == null) {
      return id;
    }

    IIdGeneratorWrapper objIIdGeneratorWrapper = (IIdGeneratorWrapper)objIdGeneratorWrapperBean.getTableSeqWrapperObj();
    if (objIIdGeneratorWrapper != null) {
      return objIIdGeneratorWrapper.wrapper(id);
    }

    return id;
  }

  private long wrapperHisId(String tableName, long id)
    throws Exception
  {
    IdGeneratorWrapperBean objIdGeneratorWrapperBean = (IdGeneratorWrapperBean)CacheFactory.get(IdGeneratorWrapperCacheImpl.class, tableName);
    if (objIdGeneratorWrapperBean == null) {
      return id;
    }

    IIdGeneratorWrapper objIIdGeneratorWrapper = (IIdGeneratorWrapper)objIdGeneratorWrapperBean.getHisTableSeqWrapperObj();
    if (objIIdGeneratorWrapper != null) {
      return objIIdGeneratorWrapper.wrapper(id);
    }

    return id;
  }

  public static void main(String[] args)
    throws Exception
  {
    String a = (String)null;
    if (a == null) {
      System.out.println("kong");
    }
    else
    {
      System.out.println(a);
    }
  }
}