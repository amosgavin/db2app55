package com.ai.bce.bo;

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

import com.ai.bce.ivalues.*;

public class BceFrameJavaRulesetRelEngine {

  public static BceFrameJavaRulesetRelBean[] getBeans(DataContainerInterface dc) throws
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

    public static BceFrameJavaRulesetRelBean getBean(long _RelateId) throws Exception{
            /**new create*/
    String condition = "RELATE_ID = :S_RELATE_ID";
      Map map = new HashMap();
      map.put("S_RELATE_ID",new Long(_RelateId));
;
      BceFrameJavaRulesetRelBean[] beans = getBeans(condition,map);
      if(beans!=null && beans.length==1)
              return beans[0];
      else if(beans!=null && beans.length>1){
          //throw new Exception("[错误]根据主键查询出现一条以上记录");
    	  throw new Exception("[ERROR]More datas than one queryed by PK");
      }else{
              BceFrameJavaRulesetRelBean bean = new BceFrameJavaRulesetRelBean();
                            bean.setRelateId(_RelateId);
                            return bean;
      }
 }

  public static  BceFrameJavaRulesetRelBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  BceFrameJavaRulesetRelBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
    }
    return (BceFrameJavaRulesetRelBean[])getBeans(cols,condition,sql.getParameters(),startNum,endNum,isShowFK);
  }




  public static  BceFrameJavaRulesetRelBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  BceFrameJavaRulesetRelBean[] getBeans(String[] cols,String condition,Map parameter,
           int startNum,int endNum,boolean isShowFK) throws Exception{
        Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return (BceFrameJavaRulesetRelBean[])ServiceManager.getDataStore().retrieve(conn,BceFrameJavaRulesetRelBean.class,BceFrameJavaRulesetRelBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
        }catch(Exception e){
                throw e;
        }finally{
           if (conn != null)
              conn.close();
        }
  }

   public static  BceFrameJavaRulesetRelBean[] getBeans(String[] cols,String condition,Map parameter,
          int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
          Connection conn = null;
          try {
                  conn = ServiceManager.getSession().getConnection();
                  return (BceFrameJavaRulesetRelBean[])ServiceManager.getDataStore().retrieve(conn,BceFrameJavaRulesetRelBean.class,BceFrameJavaRulesetRelBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
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
              return ServiceManager.getDataStore().retrieveCount(conn,BceFrameJavaRulesetRelBean.getObjectTypeStatic(),condition,parameter,null);
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
                return ServiceManager.getDataStore().retrieveCount(conn,BceFrameJavaRulesetRelBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
        }catch(Exception e){
                throw e;
        }finally{
          if (conn != null)
              conn.close();
        }
   }

  public static void save( BceFrameJavaRulesetRelBean aBean) throws Exception
  {
  	Connection conn = null;
	try {
		conn = ServiceManager.getSession().getConnection();
   		ServiceManager.getDataStore().save(conn,aBean);
   	}catch(Exception e){
		throw e;
	}finally{
		conn.close();
	}
  }

   public static  void save( BceFrameJavaRulesetRelBean[] aBeans) throws Exception{
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

   public static  void saveBatch( BceFrameJavaRulesetRelBean[] aBeans) throws Exception{
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


  public static  BceFrameJavaRulesetRelBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (BceFrameJavaRulesetRelBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BceFrameJavaRulesetRelBean.class,BceFrameJavaRulesetRelBean.getObjectTypeStatic(),resultset,null,true);

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

     public static  BceFrameJavaRulesetRelBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (BceFrameJavaRulesetRelBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BceFrameJavaRulesetRelBean.class,BceFrameJavaRulesetRelBean.getObjectTypeStatic(),resultset,null,true);

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
       return ServiceManager.getIdGenerator().getNewId(BceFrameJavaRulesetRelBean.getObjectTypeStatic());
   }

/*
   public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(BceFrameJavaRulesetRelBean.getObjectTypeStatic());
   }
*/

   public static BceFrameJavaRulesetRelBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (BceFrameJavaRulesetRelBean)DataContainerFactory.wrap(source,BceFrameJavaRulesetRelBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
         throw new RuntimeException(e.getCause());
       else
         throw new RuntimeException(e);
     }
   }
   public static BceFrameJavaRulesetRelBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       BceFrameJavaRulesetRelBean result = new BceFrameJavaRulesetRelBean();
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

   public static BceFrameJavaRulesetRelBean transfer(IBceFrameJavaRulesetRelValue value) {
   	if(value==null)
   		return null;
	try {
		if(value instanceof BceFrameJavaRulesetRelBean){
			return (BceFrameJavaRulesetRelBean)value;
		}
		BceFrameJavaRulesetRelBean newBean = new BceFrameJavaRulesetRelBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static BceFrameJavaRulesetRelBean[] transfer(IBceFrameJavaRulesetRelValue[] value) {
   	if(value==null || value.length==0)
   		return null;

	try {
		if(value instanceof BceFrameJavaRulesetRelBean[]){
			return (BceFrameJavaRulesetRelBean[])value;
		}
		BceFrameJavaRulesetRelBean[] newBeans = new BceFrameJavaRulesetRelBean[value.length];
   		for(int i=0;i<newBeans.length;i++){
   			newBeans[i] = new BceFrameJavaRulesetRelBean();
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
  public static void save(IBceFrameJavaRulesetRelValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( IBceFrameJavaRulesetRelValue[] aValues) throws Exception{
          save(transfer(aValues));
   }

   public static  void saveBatch( IBceFrameJavaRulesetRelValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
