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

public class BceFrameSpecialPageEngine {

  public static BceFrameSpecialPageBean[] getBeans(DataContainerInterface dc) throws
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

    public static BceFrameSpecialPageBean getBean(long _BceFrameId,long _PageFramePageId) throws Exception{
            /**new create*/
    String condition = "BCE_FRAME_ID = :S_BCE_FRAME_ID and PAGE_FRAME_PAGE_ID = :S_PAGE_FRAME_PAGE_ID";
      Map map = new HashMap();
      map.put("S_BCE_FRAME_ID",new Long(_BceFrameId));
      map.put("S_PAGE_FRAME_PAGE_ID",new Long(_PageFramePageId));
;
      BceFrameSpecialPageBean[] beans = getBeans(condition,map);
      if(beans!=null && beans.length==1)
              return beans[0];
      else if(beans!=null && beans.length>1){
          //throw new Exception("[错误]根据主键查询出现一条以上记录");
    	  throw new Exception("[ERROR]More datas than one queryed by PK");
      }else{
              BceFrameSpecialPageBean bean = new BceFrameSpecialPageBean();
                            bean.setBceFrameId(_BceFrameId);
                            bean.setPageFramePageId(_PageFramePageId);
                            return bean;
      }
 }

  public static  BceFrameSpecialPageBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  BceFrameSpecialPageBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
    }
    return (BceFrameSpecialPageBean[])getBeans(cols,condition,sql.getParameters(),startNum,endNum,isShowFK);
  }




  public static  BceFrameSpecialPageBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  BceFrameSpecialPageBean[] getBeans(String[] cols,String condition,Map parameter,
           int startNum,int endNum,boolean isShowFK) throws Exception{
        Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return (BceFrameSpecialPageBean[])ServiceManager.getDataStore().retrieve(conn,BceFrameSpecialPageBean.class,BceFrameSpecialPageBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
        }catch(Exception e){
                throw e;
        }finally{
           if (conn != null)
              conn.close();
        }
  }

   public static  BceFrameSpecialPageBean[] getBeans(String[] cols,String condition,Map parameter,
          int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
          Connection conn = null;
          try {
                  conn = ServiceManager.getSession().getConnection();
                  return (BceFrameSpecialPageBean[])ServiceManager.getDataStore().retrieve(conn,BceFrameSpecialPageBean.class,BceFrameSpecialPageBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
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
              return ServiceManager.getDataStore().retrieveCount(conn,BceFrameSpecialPageBean.getObjectTypeStatic(),condition,parameter,null);
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
                return ServiceManager.getDataStore().retrieveCount(conn,BceFrameSpecialPageBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
        }catch(Exception e){
                throw e;
        }finally{
          if (conn != null)
              conn.close();
        }
   }

  public static void save( BceFrameSpecialPageBean aBean) throws Exception
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

   public static  void save( BceFrameSpecialPageBean[] aBeans) throws Exception{
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

   public static  void saveBatch( BceFrameSpecialPageBean[] aBeans) throws Exception{
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


  public static  BceFrameSpecialPageBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (BceFrameSpecialPageBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BceFrameSpecialPageBean.class,BceFrameSpecialPageBean.getObjectTypeStatic(),resultset,null,true);

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

     public static  BceFrameSpecialPageBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (BceFrameSpecialPageBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BceFrameSpecialPageBean.class,BceFrameSpecialPageBean.getObjectTypeStatic(),resultset,null,true);

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
       return ServiceManager.getIdGenerator().getNewId(BceFrameSpecialPageBean.getObjectTypeStatic());
   }

/*
   public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(BceFrameSpecialPageBean.getObjectTypeStatic());
   }
*/

   public static BceFrameSpecialPageBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (BceFrameSpecialPageBean)DataContainerFactory.wrap(source,BceFrameSpecialPageBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
         throw new RuntimeException(e.getCause());
       else
         throw new RuntimeException(e);
     }
   }
   public static BceFrameSpecialPageBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       BceFrameSpecialPageBean result = new BceFrameSpecialPageBean();
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

   public static BceFrameSpecialPageBean transfer(IBceFrameSpecialPageValue value) {
   	if(value==null)
   		return null;
	try {
		if(value instanceof BceFrameSpecialPageBean){
			return (BceFrameSpecialPageBean)value;
		}
		BceFrameSpecialPageBean newBean = new BceFrameSpecialPageBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static BceFrameSpecialPageBean[] transfer(IBceFrameSpecialPageValue[] value) {
   	if(value==null || value.length==0)
   		return null;

	try {
		if(value instanceof BceFrameSpecialPageBean[]){
			return (BceFrameSpecialPageBean[])value;
		}
		BceFrameSpecialPageBean[] newBeans = new BceFrameSpecialPageBean[value.length];
   		for(int i=0;i<newBeans.length;i++){
   			newBeans[i] = new BceFrameSpecialPageBean();
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
  public static void save(IBceFrameSpecialPageValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( IBceFrameSpecialPageValue[] aValues) throws Exception{
          save(transfer(aValues));
   }

   public static  void saveBatch( IBceFrameSpecialPageValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
