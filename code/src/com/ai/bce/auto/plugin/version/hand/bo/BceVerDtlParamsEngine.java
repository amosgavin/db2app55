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

public class BceVerDtlParamsEngine {

  public static BceVerDtlParamsBean[] getBeans(DataContainerInterface dc) throws
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

    public static BceVerDtlParamsBean getBean(long _DtlParamId) throws Exception{
            /**new create*/
    String condition = "DTL_PARAM_ID = :S_DTL_PARAM_ID";
      Map map = new HashMap();
      map.put("S_DTL_PARAM_ID",new Long(_DtlParamId));
;
      BceVerDtlParamsBean[] beans = getBeans(condition,map);
      if(beans!=null && beans.length==1)
              return beans[0];
      else if(beans!=null && beans.length>1){
        //[错误]根据主键查询出现一条以上记录
              throw new Exception("[ERROR]More datas than one queryed by PK");
      }else{
              BceVerDtlParamsBean bean = new BceVerDtlParamsBean();
                            bean.setDtlParamId(_DtlParamId);
                            return bean;
      }
 }

  public static  BceVerDtlParamsBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  BceVerDtlParamsBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    Map param = null;
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
      param = sql.getParameters();
    }
    return (BceVerDtlParamsBean[])getBeans(cols,condition,param,startNum,endNum,isShowFK);
  }




  public static  BceVerDtlParamsBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  BceVerDtlParamsBean[] getBeans(String[] cols,String condition,Map parameter,
           int startNum,int endNum,boolean isShowFK) throws Exception{
        Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return (BceVerDtlParamsBean[])ServiceManager.getDataStore().retrieve(conn,BceVerDtlParamsBean.class,BceVerDtlParamsBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
        }catch(Exception e){
                throw e;
        }finally{
           if (conn != null)
              conn.close();
        }
  }

   public static  BceVerDtlParamsBean[] getBeans(String[] cols,String condition,Map parameter,
          int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
          Connection conn = null;
          try {
                  conn = ServiceManager.getSession().getConnection();
                  return (BceVerDtlParamsBean[])ServiceManager.getDataStore().retrieve(conn,BceVerDtlParamsBean.class,BceVerDtlParamsBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
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
              return ServiceManager.getDataStore().retrieveCount(conn,BceVerDtlParamsBean.getObjectTypeStatic(),condition,parameter,null);
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
                return ServiceManager.getDataStore().retrieveCount(conn,BceVerDtlParamsBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
        }catch(Exception e){
                throw e;
        }finally{
          if (conn != null)
              conn.close();
        }
   }

  public static void save( BceVerDtlParamsBean aBean) throws Exception
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

   public static  void save( BceVerDtlParamsBean[] aBeans) throws Exception{
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

   public static  void saveBatch( BceVerDtlParamsBean[] aBeans) throws Exception{
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


  public static  BceVerDtlParamsBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (BceVerDtlParamsBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BceVerDtlParamsBean.class,BceVerDtlParamsBean.getObjectTypeStatic(),resultset,null,true);

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

     public static  BceVerDtlParamsBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (BceVerDtlParamsBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BceVerDtlParamsBean.class,BceVerDtlParamsBean.getObjectTypeStatic(),resultset,null,true);

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
       return ServiceManager.getIdGenerator().getNewId(BceVerDtlParamsBean.getObjectTypeStatic());
   }

/*
   public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(BceVerDtlParamsBean.getObjectTypeStatic());
   }
*/

   public static BceVerDtlParamsBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (BceVerDtlParamsBean)DataContainerFactory.wrap(source,BceVerDtlParamsBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
         throw new RuntimeException(e.getCause());
       else
         throw new RuntimeException(e);
     }
   }
   public static BceVerDtlParamsBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       BceVerDtlParamsBean result = new BceVerDtlParamsBean();
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

   public static BceVerDtlParamsBean transfer(IBceVerDtlParamsValue value) {
   	if(value==null)
   		return null;
	try {
		if(value instanceof BceVerDtlParamsBean){
			return (BceVerDtlParamsBean)value;
		}
		BceVerDtlParamsBean newBean = new BceVerDtlParamsBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static BceVerDtlParamsBean[] transfer(IBceVerDtlParamsValue[] value) {
   	if(value==null || value.length==0)
   		return null;

	try {
		if(value instanceof BceVerDtlParamsBean[]){
			return (BceVerDtlParamsBean[])value;
		}
		BceVerDtlParamsBean[] newBeans = new BceVerDtlParamsBean[value.length];
   		for(int i=0;i<newBeans.length;i++){
   			newBeans[i] = new BceVerDtlParamsBean();
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
  public static void save(IBceVerDtlParamsValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( IBceVerDtlParamsValue[] aValues) throws Exception{
          save(transfer(aValues));
   }

   public static  void saveBatch( IBceVerDtlParamsValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
