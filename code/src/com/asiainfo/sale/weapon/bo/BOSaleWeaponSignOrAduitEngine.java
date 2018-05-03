package com.asiainfo.sale.weapon.bo;

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

import com.asiainfo.sale.weapon.ivalues.*;

public class BOSaleWeaponSignOrAduitEngine {

  public static BOSaleWeaponSignOrAduitBean[] getBeans(DataContainerInterface dc) throws
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

  
  public static  BOSaleWeaponSignOrAduitBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  BOSaleWeaponSignOrAduitBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    Map param = null;
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
      param = sql.getParameters();
    }
    return (BOSaleWeaponSignOrAduitBean[])getBeans(cols,condition,param,startNum,endNum,isShowFK);
  }




  public static  BOSaleWeaponSignOrAduitBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  BOSaleWeaponSignOrAduitBean[] getBeans(String[] cols,String condition,Map parameter,
	   int startNum,int endNum,boolean isShowFK) throws Exception{
	Connection conn = null;
	try {
		conn = ServiceManager.getSession().getConnection();
		return (BOSaleWeaponSignOrAduitBean[])ServiceManager.getDataStore().retrieve(conn,BOSaleWeaponSignOrAduitBean.class,BOSaleWeaponSignOrAduitBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
	}catch(Exception e){
		throw e;
	}finally{
	   if (conn != null)
	      conn.close();
	}
  }

   public static  BOSaleWeaponSignOrAduitBean[] getBeans(String[] cols,String condition,Map parameter,
	  int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
	  Connection conn = null;
	  try {
		  conn = ServiceManager.getSession().getConnection();
		  return (BOSaleWeaponSignOrAduitBean[])ServiceManager.getDataStore().retrieve(conn,BOSaleWeaponSignOrAduitBean.class,BOSaleWeaponSignOrAduitBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
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
	      return ServiceManager.getDataStore().retrieveCount(conn,BOSaleWeaponSignOrAduitBean.getObjectTypeStatic(),condition,parameter,null);
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
		return ServiceManager.getDataStore().retrieveCount(conn,BOSaleWeaponSignOrAduitBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
	}catch(Exception e){
		throw e;
	}finally{
	  if (conn != null)
	      conn.close();
	}
   }

  public static void save( BOSaleWeaponSignOrAduitBean aBean) throws Exception
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

   public static  void save( BOSaleWeaponSignOrAduitBean[] aBeans) throws Exception{
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

   public static  void saveBatch( BOSaleWeaponSignOrAduitBean[] aBeans) throws Exception{
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


  public static  BOSaleWeaponSignOrAduitBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
	  conn = ServiceManager.getSession().getConnection();
	  String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
	  resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
	  return (BOSaleWeaponSignOrAduitBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BOSaleWeaponSignOrAduitBean.class,BOSaleWeaponSignOrAduitBean.getObjectTypeStatic(),resultset,null,true);
      }catch(Exception e){
	  throw e;
      }finally{
	  if (conn != null)
	      conn.close();
      }
   }

     public static  BOSaleWeaponSignOrAduitBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
	  conn = ServiceManager.getSession().getConnection();
	  resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
	  return (BOSaleWeaponSignOrAduitBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BOSaleWeaponSignOrAduitBean.class,BOSaleWeaponSignOrAduitBean.getObjectTypeStatic(),resultset,null,true);
      }catch(Exception e){
	  throw e;
      }finally{
	  if (conn != null)
	      conn.close();
      }
   }

   public static java.math.BigDecimal getNewId() throws Exception{
       return ServiceManager.getIdGenerator().getNewId(BOSaleWeaponSignOrAduitBean.getObjectTypeStatic());
   }


   public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(BOSaleWeaponSignOrAduitBean.getObjectTypeStatic());
   }


   public static BOSaleWeaponSignOrAduitBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (BOSaleWeaponSignOrAduitBean)DataContainerFactory.wrap(source,BOSaleWeaponSignOrAduitBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
	 throw new RuntimeException(e.getCause());
       else
	 throw new RuntimeException(e);
     }
   }
   public static BOSaleWeaponSignOrAduitBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       BOSaleWeaponSignOrAduitBean result = new BOSaleWeaponSignOrAduitBean();
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

   public static BOSaleWeaponSignOrAduitBean transfer(IBOSaleWeaponSignOrAduitValue value) {
	   if(value==null)
		   return null;
	try {
		if(value instanceof BOSaleWeaponSignOrAduitBean){
			return (BOSaleWeaponSignOrAduitBean)value;
		}
		BOSaleWeaponSignOrAduitBean newBean = new BOSaleWeaponSignOrAduitBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static BOSaleWeaponSignOrAduitBean[] transfer(IBOSaleWeaponSignOrAduitValue[] value) {
	   if(value==null || value.length==0)
		   return null;

	try {
		if(value instanceof BOSaleWeaponSignOrAduitBean[]){
			return (BOSaleWeaponSignOrAduitBean[])value;
		}
		BOSaleWeaponSignOrAduitBean[] newBeans = new BOSaleWeaponSignOrAduitBean[value.length];
		   for(int i=0;i<newBeans.length;i++){
			   newBeans[i] = new BOSaleWeaponSignOrAduitBean();
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
  public static void save(IBOSaleWeaponSignOrAduitValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( IBOSaleWeaponSignOrAduitValue[] aValues) throws Exception{
	  save(transfer(aValues));
   }

   public static  void saveBatch( IBOSaleWeaponSignOrAduitValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
