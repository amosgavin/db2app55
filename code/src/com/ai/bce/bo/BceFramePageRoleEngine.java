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

public class BceFramePageRoleEngine {

  public static BceFramePageRoleBean[] getBeans(DataContainerInterface dc) throws
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

    public static BceFramePageRoleBean getBean(long _RoleId,long _BceFrameId,long _PageFramePageId) throws Exception{
            /**new create*/
    String condition = "ROLE_ID = :S_ROLE_ID and BCE_FRAME_ID = :S_BCE_FRAME_ID and PAGE_FRAME_PAGE_ID = :S_PAGE_FRAME_PAGE_ID";
      Map map = new HashMap();
      map.put("S_ROLE_ID",new Long(_RoleId));
      map.put("S_BCE_FRAME_ID",new Long(_BceFrameId));
      map.put("S_PAGE_FRAME_PAGE_ID",new Long(_PageFramePageId));
;
      BceFramePageRoleBean[] beans = getBeans(condition,map);
      if(beans!=null && beans.length==1)
              return beans[0];
      else if(beans!=null && beans.length>1){
          //throw new Exception("[错误]根据主键查询出现一条以上记录");
    	  throw new Exception("[ERROR]More datas than one queryed by PK");
      }else{
              BceFramePageRoleBean bean = new BceFramePageRoleBean();
                            bean.setRoleId(_RoleId);
                            bean.setBceFrameId(_BceFrameId);
                            bean.setPageFramePageId(_PageFramePageId);
                            return bean;
      }
 }

  public static  BceFramePageRoleBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  BceFramePageRoleBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
    }
    return (BceFramePageRoleBean[])getBeans(cols,condition,sql.getParameters(),startNum,endNum,isShowFK);
  }




  public static  BceFramePageRoleBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  BceFramePageRoleBean[] getBeans(String[] cols,String condition,Map parameter,
           int startNum,int endNum,boolean isShowFK) throws Exception{
        Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return (BceFramePageRoleBean[])ServiceManager.getDataStore().retrieve(conn,BceFramePageRoleBean.class,BceFramePageRoleBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
        }catch(Exception e){
                throw e;
        }finally{
           if (conn != null)
              conn.close();
        }
  }

   public static  BceFramePageRoleBean[] getBeans(String[] cols,String condition,Map parameter,
          int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
          Connection conn = null;
          try {
                  conn = ServiceManager.getSession().getConnection();
                  return (BceFramePageRoleBean[])ServiceManager.getDataStore().retrieve(conn,BceFramePageRoleBean.class,BceFramePageRoleBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
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
              return ServiceManager.getDataStore().retrieveCount(conn,BceFramePageRoleBean.getObjectTypeStatic(),condition,parameter,null);
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
                return ServiceManager.getDataStore().retrieveCount(conn,BceFramePageRoleBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
        }catch(Exception e){
                throw e;
        }finally{
          if (conn != null)
              conn.close();
        }
   }

  public static void save( BceFramePageRoleBean aBean) throws Exception
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

   public static  void save( BceFramePageRoleBean[] aBeans) throws Exception{
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

   public static  void saveBatch( BceFramePageRoleBean[] aBeans) throws Exception{
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


  public static  BceFramePageRoleBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (BceFramePageRoleBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BceFramePageRoleBean.class,BceFramePageRoleBean.getObjectTypeStatic(),resultset,null,true);

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

     public static  BceFramePageRoleBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (BceFramePageRoleBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BceFramePageRoleBean.class,BceFramePageRoleBean.getObjectTypeStatic(),resultset,null,true);

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
       return ServiceManager.getIdGenerator().getNewId(BceFramePageRoleBean.getObjectTypeStatic());
   }

/*
   public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(BceFramePageRoleBean.getObjectTypeStatic());
   }
*/

   public static BceFramePageRoleBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (BceFramePageRoleBean)DataContainerFactory.wrap(source,BceFramePageRoleBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
         throw new RuntimeException(e.getCause());
       else
         throw new RuntimeException(e);
     }
   }
   public static BceFramePageRoleBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       BceFramePageRoleBean result = new BceFramePageRoleBean();
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

   public static BceFramePageRoleBean transfer(IBceFramePageRoleValue value) {
   	if(value==null)
   		return null;
	try {
		if(value instanceof BceFramePageRoleBean){
			return (BceFramePageRoleBean)value;
		}
		BceFramePageRoleBean newBean = new BceFramePageRoleBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static BceFramePageRoleBean[] transfer(IBceFramePageRoleValue[] value) {
   	if(value==null || value.length==0)
   		return null;

	try {
		if(value instanceof BceFramePageRoleBean[]){
			return (BceFramePageRoleBean[])value;
		}
		BceFramePageRoleBean[] newBeans = new BceFramePageRoleBean[value.length];
   		for(int i=0;i<newBeans.length;i++){
   			newBeans[i] = new BceFramePageRoleBean();
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
  public static void save(IBceFramePageRoleValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( IBceFramePageRoleValue[] aValues) throws Exception{
          save(transfer(aValues));
   }

   public static  void saveBatch( IBceFramePageRoleValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
