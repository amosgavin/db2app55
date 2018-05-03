package com.ai.appframe2.common;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.Timestamp;

public abstract interface IdGenerator
{
  public abstract BigDecimal getNewId(String paramString)
    throws Exception, RemoteException;

  public abstract long getNewId(String paramString1, String paramString2)
    throws Exception, RemoteException;

  public abstract BigDecimal getNewId(ObjectType paramObjectType)
    throws Exception, RemoteException;

  public abstract BigDecimal getNewId(Connection paramConnection, ObjectType paramObjectType)
    throws Exception, RemoteException;

  public abstract Timestamp getSysDate(ObjectType paramObjectType)
    throws Exception, RemoteException;

  public abstract Timestamp getSysDate(Connection paramConnection, ObjectType paramObjectType)
    throws Exception, RemoteException;

  public abstract Timestamp getSysDate()
    throws Exception;

  public abstract Timestamp getSysDate(String paramString)
    throws Exception;

  public abstract boolean getHisDataFlag(String paramString);

  public abstract String getHisTableName(String paramString);

  public abstract boolean getHisDoneCodeFlag(String paramString);

  public abstract BigDecimal getHisTableNewId(ObjectType paramObjectType)
    throws AIException;

  public abstract BigDecimal getHisTableNewId(String paramString)
    throws AIException;

  public abstract BigDecimal getNewId(Connection paramConnection, String paramString)
    throws Exception;

  public abstract BigDecimal getDirectNewId(Connection paramConnection, ObjectType paramObjectType)
    throws Exception;

  public abstract BigDecimal getDirectNewId(Connection paramConnection, String paramString)
    throws Exception;
}