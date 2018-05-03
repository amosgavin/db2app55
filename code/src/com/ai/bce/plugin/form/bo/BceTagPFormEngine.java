package com.ai.bce.plugin.form.bo;

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

import com.ai.bce.plugin.form.ivalues.*;

public class BceTagPFormEngine {

  public static BceTagPFormBean[] getBeans(DataContainerInterface dc) throws
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

    public static BceTagPFormBean getBean(long _ObjectId) throws Exception{
            /**new create*/
    String condition = "OBJECT_ID = :S_OBJECT_ID";
      Map map = new HashMap();
      map.put("S_OBJECT_ID",new Long(_ObjectId));
;
      BceTagPFormBean[] beans = getBeans(condition,map);
      if(beans!=null && beans.length==1)
              return beans[0];
      else if(beans!=null && beans.length>1){
        //[����]����������ѯ����һ�����ϼ�¼
              throw new Exception("[ERROR]More datas than one queryed by PK");
      }else{
              BceTagPFormBean bean = new BceTagPFormBean();
                            bean.setObjectId(_ObjectId);
                            return bean;
      }
 }

  public static  BceTagPFormBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  BceTagPFormBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    Map param = null;
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
      param = sql.getParameters();
    }
    return (BceTagPFormBean[])getBeans(cols,condition,param,startNum,endNum,isShowFK);
  }




  public static  BceTagPFormBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  BceTagPFormBean[] getBeans(String[] cols,String condition,Map parameter,
           int startNum,int endNum,boolean isShowFK) throws Exception{
        Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return (BceTagPFormBean[])ServiceManager.getDataStore().retrieve(conn,BceTagPFormBean.class,BceTagPFormBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
        }catch(Exception e){
                throw e;
        }finally{
           if (conn != null)
              conn.close();
        }
  }

   public static  BceTagPFormBean[] getBeans(String[] cols,String condition,Map parameter,
          int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
          Connection conn = null;
          try {
                  conn = ServiceManager.getSession().getConnection();
                  return (BceTagPFormBean[])ServiceManager.getDataStore().retrieve(conn,BceTagPFormBean.class,BceTagPFormBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
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
              return ServiceManager.getDataStore().retrieveCount(conn,BceTagPFormBean.getObjectTypeStatic(),condition,parameter,null);
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
                return ServiceManager.getDataStore().retrieveCount(conn,BceTagPFormBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
        }catch(Exception e){
                throw e;
        }finally{
          if (conn != null)
              conn.close();
        }
   }

  public static void save( BceTagPFormBean aBean) throws Exception
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

   public static  void save( BceTagPFormBean[] aBeans) throws Exception{
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

   public static  void saveBatch( BceTagPFormBean[] aBeans) throws Exception{
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


  public static  BceTagPFormBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (BceTagPFormBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BceTagPFormBean.class,BceTagPFormBean.getObjectTypeStatic(),resultset,null,true);

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

     public static  BceTagPFormBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (BceTagPFormBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BceTagPFormBean.class,BceTagPFormBean.getObjectTypeStatic(),resultset,null,true);

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
       return ServiceManager.getIdGenerator().getNewId(BceTagPFormBean.getObjectTypeStatic());
   }

/*
   public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(BceTagPFormBean.getObjectTypeStatic());
   }
*/

   public static BceTagPFormBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (BceTagPFormBean)DataContainerFactory.wrap(source,BceTagPFormBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
         throw new RuntimeException(e.getCause());
       else
         throw new RuntimeException(e);
     }
   }
   public static BceTagPFormBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       BceTagPFormBean result = new BceTagPFormBean();
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

   public static BceTagPFormBean transfer(IBceTagPFormValue value) {
   	if(value==null)
   		return null;
	try {
		if(value instanceof BceTagPFormBean){
			return (BceTagPFormBean)value;
		}
		BceTagPFormBean newBean = new BceTagPFormBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static BceTagPFormBean[] transfer(IBceTagPFormValue[] value) {
   	if(value==null || value.length==0)
   		return null;

	try {
		if(value instanceof BceTagPFormBean[]){
			return (BceTagPFormBean[])value;
		}
		BceTagPFormBean[] newBeans = new BceTagPFormBean[value.length];
   		for(int i=0;i<newBeans.length;i++){
   			newBeans[i] = new BceTagPFormBean();
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
  public static void save(IBceTagPFormValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( IBceTagPFormValue[] aValues) throws Exception{
          save(transfer(aValues));
   }

   public static  void saveBatch( IBceTagPFormValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
