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

public class BceTagPFormFieldEngine {

  public static BceTagPFormFieldBean[] getBeans(DataContainerInterface dc) throws
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

    public static BceTagPFormFieldBean getBean(String _FieldName,long _ObjectId) throws Exception{
            /**new create*/
    String condition = "FIELD_NAME = :S_FIELD_NAME and OBJECT_ID = :S_OBJECT_ID";
      Map map = new HashMap();
      map.put("S_FIELD_NAME",_FieldName);
      map.put("S_OBJECT_ID",new Long(_ObjectId));
;
      BceTagPFormFieldBean[] beans = getBeans(condition,map);
      if(beans!=null && beans.length==1)
              return beans[0];
      else if(beans!=null && beans.length>1){
        //[错误]根据主键查询出现一条以上记录
              throw new Exception("[ERROR]More datas than one queryed by PK");
      }else{
              BceTagPFormFieldBean bean = new BceTagPFormFieldBean();
                            bean.setFieldName(_FieldName);
                            bean.setObjectId(_ObjectId);
                            return bean;
      }
 }

  public static  BceTagPFormFieldBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  BceTagPFormFieldBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    Map param = null;
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
      param = sql.getParameters();
    }
    return (BceTagPFormFieldBean[])getBeans(cols,condition,param,startNum,endNum,isShowFK);
  }




  public static  BceTagPFormFieldBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  BceTagPFormFieldBean[] getBeans(String[] cols,String condition,Map parameter,
           int startNum,int endNum,boolean isShowFK) throws Exception{
        Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return (BceTagPFormFieldBean[])ServiceManager.getDataStore().retrieve(conn,BceTagPFormFieldBean.class,BceTagPFormFieldBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
        }catch(Exception e){
                throw e;
        }finally{
           if (conn != null)
              conn.close();
        }
  }

   public static  BceTagPFormFieldBean[] getBeans(String[] cols,String condition,Map parameter,
          int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
          Connection conn = null;
          try {
                  conn = ServiceManager.getSession().getConnection();
                  return (BceTagPFormFieldBean[])ServiceManager.getDataStore().retrieve(conn,BceTagPFormFieldBean.class,BceTagPFormFieldBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
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
              return ServiceManager.getDataStore().retrieveCount(conn,BceTagPFormFieldBean.getObjectTypeStatic(),condition,parameter,null);
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
                return ServiceManager.getDataStore().retrieveCount(conn,BceTagPFormFieldBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
        }catch(Exception e){
                throw e;
        }finally{
          if (conn != null)
              conn.close();
        }
   }

  public static void save( BceTagPFormFieldBean aBean) throws Exception
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

   public static  void save( BceTagPFormFieldBean[] aBeans) throws Exception{
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

   public static  void saveBatch( BceTagPFormFieldBean[] aBeans) throws Exception{
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


  public static  BceTagPFormFieldBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (BceTagPFormFieldBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BceTagPFormFieldBean.class,BceTagPFormFieldBean.getObjectTypeStatic(),resultset,null,true);

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

     public static  BceTagPFormFieldBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (BceTagPFormFieldBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BceTagPFormFieldBean.class,BceTagPFormFieldBean.getObjectTypeStatic(),resultset,null,true);

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
       return ServiceManager.getIdGenerator().getNewId(BceTagPFormFieldBean.getObjectTypeStatic());
   }

/*
   public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(BceTagPFormFieldBean.getObjectTypeStatic());
   }
*/

   public static BceTagPFormFieldBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (BceTagPFormFieldBean)DataContainerFactory.wrap(source,BceTagPFormFieldBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
         throw new RuntimeException(e.getCause());
       else
         throw new RuntimeException(e);
     }
   }
   public static BceTagPFormFieldBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       BceTagPFormFieldBean result = new BceTagPFormFieldBean();
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

   public static BceTagPFormFieldBean transfer(IBceTagPFormFieldValue value) {
   	if(value==null)
   		return null;
	try {
		if(value instanceof BceTagPFormFieldBean){
			return (BceTagPFormFieldBean)value;
		}
		BceTagPFormFieldBean newBean = new BceTagPFormFieldBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static BceTagPFormFieldBean[] transfer(IBceTagPFormFieldValue[] value) {
   	if(value==null || value.length==0)
   		return null;

	try {
		if(value instanceof BceTagPFormFieldBean[]){
			return (BceTagPFormFieldBean[])value;
		}
		BceTagPFormFieldBean[] newBeans = new BceTagPFormFieldBean[value.length];
   		for(int i=0;i<newBeans.length;i++){
   			newBeans[i] = new BceTagPFormFieldBean();
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
  public static void save(IBceTagPFormFieldValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( IBceTagPFormFieldValue[] aValues) throws Exception{
          save(transfer(aValues));
   }

   public static  void saveBatch( IBceTagPFormFieldValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
