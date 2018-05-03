package com.ai.bce.plugin.autoTable.bo;

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

import com.ai.bce.plugin.autoTable.ivalues.*;

public class BceTagPAutotableAttrEngine {

  public static BceTagPAutotableAttrBean[] getBeans(DataContainerInterface dc) throws
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

    public static BceTagPAutotableAttrBean getBean(long _AttrId) throws Exception{
            /**new create*/
    String condition = "ATTR_ID = :S_ATTR_ID";
      Map map = new HashMap();
      map.put("S_ATTR_ID",new Long(_AttrId));
;
      BceTagPAutotableAttrBean[] beans = getBeans(condition,map);
      if(beans!=null && beans.length==1)
              return beans[0];
      else if(beans!=null && beans.length>1){
        //[错误]根据主键查询出现一条以上记录
              throw new Exception("[ERROR]More datas than one queryed by PK");
      }else{
              BceTagPAutotableAttrBean bean = new BceTagPAutotableAttrBean();
                            bean.setAttrId(_AttrId);
                            return bean;
      }
 }

  public static  BceTagPAutotableAttrBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  BceTagPAutotableAttrBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    Map param = null;
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
      param = sql.getParameters();
    }
    return (BceTagPAutotableAttrBean[])getBeans(cols,condition,param,startNum,endNum,isShowFK);
  }




  public static  BceTagPAutotableAttrBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  BceTagPAutotableAttrBean[] getBeans(String[] cols,String condition,Map parameter,
           int startNum,int endNum,boolean isShowFK) throws Exception{
        Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return (BceTagPAutotableAttrBean[])ServiceManager.getDataStore().retrieve(conn,BceTagPAutotableAttrBean.class,BceTagPAutotableAttrBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
        }catch(Exception e){
                throw e;
        }finally{
           if (conn != null)
              conn.close();
        }
  }

   public static  BceTagPAutotableAttrBean[] getBeans(String[] cols,String condition,Map parameter,
          int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
          Connection conn = null;
          try {
                  conn = ServiceManager.getSession().getConnection();
                  return (BceTagPAutotableAttrBean[])ServiceManager.getDataStore().retrieve(conn,BceTagPAutotableAttrBean.class,BceTagPAutotableAttrBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
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
              return ServiceManager.getDataStore().retrieveCount(conn,BceTagPAutotableAttrBean.getObjectTypeStatic(),condition,parameter,null);
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
                return ServiceManager.getDataStore().retrieveCount(conn,BceTagPAutotableAttrBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
        }catch(Exception e){
                throw e;
        }finally{
          if (conn != null)
              conn.close();
        }
   }

  public static void save( BceTagPAutotableAttrBean aBean) throws Exception
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

   public static  void save( BceTagPAutotableAttrBean[] aBeans) throws Exception{
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

   public static  void saveBatch( BceTagPAutotableAttrBean[] aBeans) throws Exception{
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


  public static  BceTagPAutotableAttrBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (BceTagPAutotableAttrBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BceTagPAutotableAttrBean.class,BceTagPAutotableAttrBean.getObjectTypeStatic(),resultset,null,true);

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

     public static  BceTagPAutotableAttrBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (BceTagPAutotableAttrBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BceTagPAutotableAttrBean.class,BceTagPAutotableAttrBean.getObjectTypeStatic(),resultset,null,true);

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
       return ServiceManager.getIdGenerator().getNewId(BceTagPAutotableAttrBean.getObjectTypeStatic());
   }

/*
   public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(BceTagPAutotableAttrBean.getObjectTypeStatic());
   }
*/

   public static BceTagPAutotableAttrBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (BceTagPAutotableAttrBean)DataContainerFactory.wrap(source,BceTagPAutotableAttrBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
         throw new RuntimeException(e.getCause());
       else
         throw new RuntimeException(e);
     }
   }
   public static BceTagPAutotableAttrBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       BceTagPAutotableAttrBean result = new BceTagPAutotableAttrBean();
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

   public static BceTagPAutotableAttrBean transfer(IBceTagPAutotableAttrValue value) {
   	if(value==null)
   		return null;
	try {
		if(value instanceof BceTagPAutotableAttrBean){
			return (BceTagPAutotableAttrBean)value;
		}
		BceTagPAutotableAttrBean newBean = new BceTagPAutotableAttrBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static BceTagPAutotableAttrBean[] transfer(IBceTagPAutotableAttrValue[] value) {
   	if(value==null || value.length==0)
   		return null;

	try {
		if(value instanceof BceTagPAutotableAttrBean[]){
			return (BceTagPAutotableAttrBean[])value;
		}
		BceTagPAutotableAttrBean[] newBeans = new BceTagPAutotableAttrBean[value.length];
   		for(int i=0;i<newBeans.length;i++){
   			newBeans[i] = new BceTagPAutotableAttrBean();
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
  public static void save(IBceTagPAutotableAttrValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( IBceTagPAutotableAttrValue[] aValues) throws Exception{
          save(transfer(aValues));
   }

   public static  void saveBatch( IBceTagPAutotableAttrValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
