package com.asiainfo.sale.prestore.bo;

import java.util.Map;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.criteria.Criteria;
import com.ai.appframe2.bo.DataContainerFactory;

import com.asiainfo.sale.prestore.ivalues.*;

public class BOSaleBatchPrestoreHisEngine {

  public static BOSaleBatchPrestoreHisBean[] getBeans(DataContainerInterface dc) throws
      Exception {
    Map ps = dc.getProperties();
    StringBuffer buffer = new StringBuffer();
    Map pList = new HashMap();
    for (java.util.Iterator cc = ps.entrySet().iterator(); cc.hasNext(); ) {
      Map.Entry e = (Map.Entry) cc.next();
      if(buffer.length() >0)
	 buffer.append(" and ");
      buffer.append(e.getKey().toString() + " = :p_" + e.getKey().toString());
      pList.put("p_" + e.getKey().toString(),e.getValue());
    }
    Connection conn = ServiceManager.getSession().getConnection();
    try {
      return getBeans(buffer.toString(), pList);
    }finally{
      if (conn != null)
	conn.close();
    }
  }

  
  public static  BOSaleBatchPrestoreHisBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  BOSaleBatchPrestoreHisBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    Map param = null;
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
      param = sql.getParameters();
    }
    return (BOSaleBatchPrestoreHisBean[])getBeans(cols,condition,param,startNum,endNum,isShowFK);
  }




  public static  BOSaleBatchPrestoreHisBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  BOSaleBatchPrestoreHisBean[] getBeans(String[] cols,String condition,Map parameter,
	   int startNum,int endNum,boolean isShowFK) throws Exception{
	Connection conn = null;
	try {
		conn = ServiceManager.getSession().getConnection();
		return (BOSaleBatchPrestoreHisBean[])ServiceManager.getDataStore().retrieve(conn,BOSaleBatchPrestoreHisBean.class,BOSaleBatchPrestoreHisBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
	}catch(Exception e){
		throw e;
	}finally{
	   if (conn != null)
	      conn.close();
	}
  }

   public static  BOSaleBatchPrestoreHisBean[] getBeans(String[] cols,String condition,Map parameter,
	  int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
	  Connection conn = null;
	  try {
		  conn = ServiceManager.getSession().getConnection();
		  return (BOSaleBatchPrestoreHisBean[])ServiceManager.getDataStore().retrieve(conn,BOSaleBatchPrestoreHisBean.class,BOSaleBatchPrestoreHisBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
	  }catch(Exception e){
		  throw e;
	  }finally{
		if (conn != null)
		  conn.close();
	  }
   }


   public static int getBeansCount(String condition,Map parameter) throws Exception{
     Connection conn = null;
      try {
	      conn = ServiceManager.getSession().getConnection();
	      return ServiceManager.getDataStore().retrieveCount(conn,BOSaleBatchPrestoreHisBean.getObjectTypeStatic(),condition,parameter,null);
      }catch(Exception e){
	      throw e;
      }finally{
	  if (conn != null)
	      conn.close();
      }
   }

   public static int getBeansCount(String condition,Map parameter,String[] extendBOAttrs) throws Exception{
	      Connection conn = null;
	try {
		conn = ServiceManager.getSession().getConnection();
		return ServiceManager.getDataStore().retrieveCount(conn,BOSaleBatchPrestoreHisBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
	}catch(Exception e){
		throw e;
	}finally{
	  if (conn != null)
	      conn.close();
	}
   }

  public static void save( BOSaleBatchPrestoreHisBean aBean) throws Exception
  {
	  Connection conn = null;
	try {
		conn = ServiceManager.getSession().getConnection();
		   ServiceManager.getDataStore().save(conn,aBean);
	   }catch(Exception e){
		throw e;
	}finally{
	  if (conn != null)
		  conn.close();
	}
  }

   public static  void save( BOSaleBatchPrestoreHisBean[] aBeans) throws Exception{
	     Connection conn = null;
	try {
		conn = ServiceManager.getSession().getConnection();
		ServiceManager.getDataStore().save(conn,aBeans);
	}catch(Exception e){
		throw e;
	}finally{
	  if (conn != null)
	      conn.close();
	}
   }

   public static  void saveBatch( BOSaleBatchPrestoreHisBean[] aBeans) throws Exception{
	     Connection conn = null;
	try {
		conn = ServiceManager.getSession().getConnection();
		ServiceManager.getDataStore().saveBatch(conn,aBeans);
	}catch(Exception e){
		throw e;
	}finally{
	  if (conn != null)
	      conn.close();
	}
   }


  public static  BOSaleBatchPrestoreHisBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
	  conn = ServiceManager.getSession().getConnection();
	  String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
	  resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
	  return (BOSaleBatchPrestoreHisBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BOSaleBatchPrestoreHisBean.class,BOSaleBatchPrestoreHisBean.getObjectTypeStatic(),resultset,null,true);
      }catch(Exception e){
	  throw e;
      }finally{
	  if (conn != null)
	      conn.close();
      }
   }

     public static  BOSaleBatchPrestoreHisBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
	  conn = ServiceManager.getSession().getConnection();
	  resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
	  return (BOSaleBatchPrestoreHisBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BOSaleBatchPrestoreHisBean.class,BOSaleBatchPrestoreHisBean.getObjectTypeStatic(),resultset,null,true);
      }catch(Exception e){
	  throw e;
      }finally{
	  if (conn != null)
	      conn.close();
      }
   }

   public static java.math.BigDecimal getNewId() throws Exception{
       return ServiceManager.getIdGenerator().getNewId(BOSaleBatchPrestoreHisBean.getObjectTypeStatic());
   }


   public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(BOSaleBatchPrestoreHisBean.getObjectTypeStatic());
   }


   public static BOSaleBatchPrestoreHisBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (BOSaleBatchPrestoreHisBean)DataContainerFactory.wrap(source,BOSaleBatchPrestoreHisBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
	 throw new RuntimeException(e.getCause());
       else
	 throw new RuntimeException(e);
     }
   }
   public static BOSaleBatchPrestoreHisBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       BOSaleBatchPrestoreHisBean result = new BOSaleBatchPrestoreHisBean();
       DataContainerFactory.copy(source, result, colMatch);
       return result;
     }
     catch (AIException ex) {
       if(ex.getCause()!=null)
	 throw new RuntimeException(ex.getCause());
       else
	 throw new RuntimeException(ex);
     }
    }

   public static BOSaleBatchPrestoreHisBean transfer(IBOSaleBatchPrestoreHisValue value) {
	   if(value==null)
		   return null;
	try {
		if(value instanceof BOSaleBatchPrestoreHisBean){
			return (BOSaleBatchPrestoreHisBean)value;
		}
		BOSaleBatchPrestoreHisBean newBean = new BOSaleBatchPrestoreHisBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static BOSaleBatchPrestoreHisBean[] transfer(IBOSaleBatchPrestoreHisValue[] value) {
	   if(value==null || value.length==0)
		   return null;

	try {
		if(value instanceof BOSaleBatchPrestoreHisBean[]){
			return (BOSaleBatchPrestoreHisBean[])value;
		}
		BOSaleBatchPrestoreHisBean[] newBeans = new BOSaleBatchPrestoreHisBean[value.length];
		   for(int i=0;i<newBeans.length;i++){
			   newBeans[i] = new BOSaleBatchPrestoreHisBean();
			DataContainerFactory.transfer(value[i] ,newBeans[i]);
		}
		return newBeans;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }
  public static void save(IBOSaleBatchPrestoreHisValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( IBOSaleBatchPrestoreHisValue[] aValues) throws Exception{
	  save(transfer(aValues));
   }

   public static  void saveBatch( IBOSaleBatchPrestoreHisValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
