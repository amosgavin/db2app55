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

public class BceViewObjectAttrEngine {

  public static BceViewObjectAttrBean[] getBeans(DataContainerInterface dc) throws
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

    public static BceViewObjectAttrBean getBean(long _AttrId) throws Exception{
            /**new create*/
    String condition = "ATTR_ID = :S_ATTR_ID";
      Map map = new HashMap();
      map.put("S_ATTR_ID",new Long(_AttrId));
;
      BceViewObjectAttrBean[] beans = getBeans(condition,map);
      if(beans!=null && beans.length==1)
              return beans[0];
      else if(beans!=null && beans.length>1){
          //throw new Exception("[����]����������ѯ����һ�����ϼ�¼");
    	  throw new Exception("[ERROR]More datas than one queryed by PK");
      }else{
              BceViewObjectAttrBean bean = new BceViewObjectAttrBean();
                            bean.setAttrId(_AttrId);
                            return bean;
      }
 }

  public static  BceViewObjectAttrBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  BceViewObjectAttrBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
    }
    return (BceViewObjectAttrBean[])getBeans(cols,condition,sql.getParameters(),startNum,endNum,isShowFK);
  }




  public static  BceViewObjectAttrBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  BceViewObjectAttrBean[] getBeans(String[] cols,String condition,Map parameter,
           int startNum,int endNum,boolean isShowFK) throws Exception{
        Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return (BceViewObjectAttrBean[])ServiceManager.getDataStore().retrieve(conn,BceViewObjectAttrBean.class,BceViewObjectAttrBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
        }catch(Exception e){
                throw e;
        }finally{
           if (conn != null)
              conn.close();
        }
  }

   public static  BceViewObjectAttrBean[] getBeans(String[] cols,String condition,Map parameter,
          int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
          Connection conn = null;
          try {
                  conn = ServiceManager.getSession().getConnection();
                  return (BceViewObjectAttrBean[])ServiceManager.getDataStore().retrieve(conn,BceViewObjectAttrBean.class,BceViewObjectAttrBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
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
              return ServiceManager.getDataStore().retrieveCount(conn,BceViewObjectAttrBean.getObjectTypeStatic(),condition,parameter,null);
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
                return ServiceManager.getDataStore().retrieveCount(conn,BceViewObjectAttrBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
        }catch(Exception e){
                throw e;
        }finally{
          if (conn != null)
              conn.close();
        }
   }

  public static void save( BceViewObjectAttrBean aBean) throws Exception
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

   public static  void save( BceViewObjectAttrBean[] aBeans) throws Exception{
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

   public static  void saveBatch( BceViewObjectAttrBean[] aBeans) throws Exception{
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


  public static  BceViewObjectAttrBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (BceViewObjectAttrBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BceViewObjectAttrBean.class,BceViewObjectAttrBean.getObjectTypeStatic(),resultset,null,true);

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

     public static  BceViewObjectAttrBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (BceViewObjectAttrBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BceViewObjectAttrBean.class,BceViewObjectAttrBean.getObjectTypeStatic(),resultset,null,true);

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
       return ServiceManager.getIdGenerator().getNewId(BceViewObjectAttrBean.getObjectTypeStatic());
   }

/*
   public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(BceViewObjectAttrBean.getObjectTypeStatic());
   }
*/

   public static BceViewObjectAttrBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (BceViewObjectAttrBean)DataContainerFactory.wrap(source,BceViewObjectAttrBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
         throw new RuntimeException(e.getCause());
       else
         throw new RuntimeException(e);
     }
   }
   public static BceViewObjectAttrBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       BceViewObjectAttrBean result = new BceViewObjectAttrBean();
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

   public static BceViewObjectAttrBean transfer(IBceViewObjectAttrValue value) {
   	if(value==null)
   		return null;
	try {
		if(value instanceof BceViewObjectAttrBean){
			return (BceViewObjectAttrBean)value;
		}
		BceViewObjectAttrBean newBean = new BceViewObjectAttrBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static BceViewObjectAttrBean[] transfer(IBceViewObjectAttrValue[] value) {
   	if(value==null || value.length==0)
   		return null;

	try {
		if(value instanceof BceViewObjectAttrBean[]){
			return (BceViewObjectAttrBean[])value;
		}
		BceViewObjectAttrBean[] newBeans = new BceViewObjectAttrBean[value.length];
   		for(int i=0;i<newBeans.length;i++){
   			newBeans[i] = new BceViewObjectAttrBean();
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
  public static void save(IBceViewObjectAttrValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( IBceViewObjectAttrValue[] aValues) throws Exception{
          save(transfer(aValues));
   }

   public static  void saveBatch( IBceViewObjectAttrValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
