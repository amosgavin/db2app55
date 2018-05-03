package com.ai.bce.auto.plugin.version.hand.bo;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.Connection;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.criteria.Criteria;
import com.ai.appframe2.bo.DataContainerFactory;

import com.ai.bce.auto.plugin.version.hand.ivalues.*;

public class BceVerSyncScriptEngine {

  public static BceVerSyncScriptBean[] getBeans(DataContainerInterface dc) throws
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

    public static BceVerSyncScriptBean getBean(long _OrdId) throws Exception{
            /**new create*/
    String condition = "ORD_ID = :S_ORD_ID";
      Map map = new HashMap();
      map.put("S_ORD_ID",new Long(_OrdId));
;
      BceVerSyncScriptBean[] beans = getBeans(condition,map);
      if(beans!=null && beans.length==1)
              return beans[0];
      else if(beans!=null && beans.length>1){
        //[错误]根据主键查询出现一条以上记录
              throw new Exception("[ERROR]More datas than one queryed by PK");
      }else{
              BceVerSyncScriptBean bean = new BceVerSyncScriptBean();
                            bean.setOrdId(_OrdId);
                            return bean;
      }
 }

  public static  BceVerSyncScriptBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  BceVerSyncScriptBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    Map param = null;
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
      param = sql.getParameters();
    }
    return (BceVerSyncScriptBean[])getBeans(cols,condition,param,startNum,endNum,isShowFK);
  }




  public static  BceVerSyncScriptBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  BceVerSyncScriptBean[] getBeans(String[] cols,String condition,Map parameter,
           int startNum,int endNum,boolean isShowFK) throws Exception{
        Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return (BceVerSyncScriptBean[])ServiceManager.getDataStore().retrieve(conn,BceVerSyncScriptBean.class,BceVerSyncScriptBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
        }catch(Exception e){
                throw e;
        }finally{
           if (conn != null)
              conn.close();
        }
  }

   public static  BceVerSyncScriptBean[] getBeans(String[] cols,String condition,Map parameter,
          int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
          Connection conn = null;
          try {
                  conn = ServiceManager.getSession().getConnection();
                  return (BceVerSyncScriptBean[])ServiceManager.getDataStore().retrieve(conn,BceVerSyncScriptBean.class,BceVerSyncScriptBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
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
              return ServiceManager.getDataStore().retrieveCount(conn,BceVerSyncScriptBean.getObjectTypeStatic(),condition,parameter,null);
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
                return ServiceManager.getDataStore().retrieveCount(conn,BceVerSyncScriptBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
        }catch(Exception e){
                throw e;
        }finally{
          if (conn != null)
              conn.close();
        }
   }

  public static void save( BceVerSyncScriptBean aBean) throws Exception
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

   public static  void save( BceVerSyncScriptBean[] aBeans) throws Exception{
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

   public static  void saveBatch( BceVerSyncScriptBean[] aBeans) throws Exception{
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


  public static  BceVerSyncScriptBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (BceVerSyncScriptBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BceVerSyncScriptBean.class,BceVerSyncScriptBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
	  /**add result close*/
	  if(resultset!=null) resultset.close();
          if (conn != null)
              conn.close();
      }
   }

     public static  BceVerSyncScriptBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (BceVerSyncScriptBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BceVerSyncScriptBean.class,BceVerSyncScriptBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
	  /**add result close*/
	  if(resultset!=null) resultset.close();
          if (conn != null)
              conn.close();
      }
   }

   public static java.math.BigDecimal getNewId() throws Exception{
       return ServiceManager.getIdGenerator().getNewId(BceVerSyncScriptBean.getObjectTypeStatic());
   }

/*
   public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(BceVerSyncScriptBean.getObjectTypeStatic());
   }
*/

   public static BceVerSyncScriptBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (BceVerSyncScriptBean)DataContainerFactory.wrap(source,BceVerSyncScriptBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
         throw new RuntimeException(e.getCause());
       else
         throw new RuntimeException(e);
     }
   }
   public static BceVerSyncScriptBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       BceVerSyncScriptBean result = new BceVerSyncScriptBean();
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

   public static BceVerSyncScriptBean transfer(IBceVerSyncScriptValue value) {
   	if(value==null)
   		return null;
	try {
		if(value instanceof BceVerSyncScriptBean){
			return (BceVerSyncScriptBean)value;
		}
		BceVerSyncScriptBean newBean = new BceVerSyncScriptBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static BceVerSyncScriptBean[] transfer(IBceVerSyncScriptValue[] value) {
   	if(value==null || value.length==0)
   		return null;

	try {
		if(value instanceof BceVerSyncScriptBean[]){
			return (BceVerSyncScriptBean[])value;
		}
		BceVerSyncScriptBean[] newBeans = new BceVerSyncScriptBean[value.length];
   		for(int i=0;i<newBeans.length;i++){
   			newBeans[i] = new BceVerSyncScriptBean();
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
  public static void save(IBceVerSyncScriptValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( IBceVerSyncScriptValue[] aValues) throws Exception{
          save(transfer(aValues));
   }

   public static  void saveBatch( IBceVerSyncScriptValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
