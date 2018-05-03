package com.asiainfo.charge.bo;

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

import com.asiainfo.charge.ivalues.*;

public class BOChargeApplyProdAttrExtEngine {

  public static BOChargeApplyProdAttrExtBean[] getBeans(DataContainerInterface dc) throws
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

    public static BOChargeApplyProdAttrExtBean getBean(String _ApplyId) throws Exception{
            /**new create*/
    String condition = "APPLY_ID = :S_APPLY_ID";
      Map map = new HashMap();
      map.put("S_APPLY_ID",_ApplyId);
;
      BOChargeApplyProdAttrExtBean[] beans = getBeans(condition,map);
      if(beans!=null && beans.length==1)
	      return beans[0];
      else if(beans!=null && beans.length>1){
	//[错误]根据主键查询出现一条以上记录
	      throw new Exception("[ERROR]More datas than one queryed by PK");
      }else{
	      BOChargeApplyProdAttrExtBean bean = new BOChargeApplyProdAttrExtBean();
	      	      bean.setApplyId(_ApplyId);
	      	      return bean;
      }
 }

  public static  BOChargeApplyProdAttrExtBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  BOChargeApplyProdAttrExtBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    Map param = null;
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
      param = sql.getParameters();
    }
    return (BOChargeApplyProdAttrExtBean[])getBeans(cols,condition,param,startNum,endNum,isShowFK);
  }




  public static  BOChargeApplyProdAttrExtBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  BOChargeApplyProdAttrExtBean[] getBeans(String[] cols,String condition,Map parameter,
	   int startNum,int endNum,boolean isShowFK) throws Exception{
	Connection conn = null;
	try {
		conn = ServiceManager.getSession().getConnection();
		return (BOChargeApplyProdAttrExtBean[])ServiceManager.getDataStore().retrieve(conn,BOChargeApplyProdAttrExtBean.class,BOChargeApplyProdAttrExtBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
	}catch(Exception e){
		throw e;
	}finally{
	   if (conn != null)
	      conn.close();
	}
  }

   public static  BOChargeApplyProdAttrExtBean[] getBeans(String[] cols,String condition,Map parameter,
	  int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
	  Connection conn = null;
	  try {
		  conn = ServiceManager.getSession().getConnection();
		  return (BOChargeApplyProdAttrExtBean[])ServiceManager.getDataStore().retrieve(conn,BOChargeApplyProdAttrExtBean.class,BOChargeApplyProdAttrExtBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
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
	      return ServiceManager.getDataStore().retrieveCount(conn,BOChargeApplyProdAttrExtBean.getObjectTypeStatic(),condition,parameter,null);
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
		return ServiceManager.getDataStore().retrieveCount(conn,BOChargeApplyProdAttrExtBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
	}catch(Exception e){
		throw e;
	}finally{
	  if (conn != null)
	      conn.close();
	}
   }

  public static void save( BOChargeApplyProdAttrExtBean aBean) throws Exception
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

   public static  void save( BOChargeApplyProdAttrExtBean[] aBeans) throws Exception{
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

   public static  void saveBatch( BOChargeApplyProdAttrExtBean[] aBeans) throws Exception{
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


  public static  BOChargeApplyProdAttrExtBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
	  conn = ServiceManager.getSession().getConnection();
	  String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
	  resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
	  return (BOChargeApplyProdAttrExtBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BOChargeApplyProdAttrExtBean.class,BOChargeApplyProdAttrExtBean.getObjectTypeStatic(),resultset,null,true);
      }catch(Exception e){
	  throw e;
      }finally{
	  if (conn != null)
	      conn.close();
      }
   }

     public static  BOChargeApplyProdAttrExtBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
	  conn = ServiceManager.getSession().getConnection();
	  resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
	  return (BOChargeApplyProdAttrExtBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BOChargeApplyProdAttrExtBean.class,BOChargeApplyProdAttrExtBean.getObjectTypeStatic(),resultset,null,true);
      }catch(Exception e){
	  throw e;
      }finally{
	  if (conn != null)
	      conn.close();
      }
   }

   public static java.math.BigDecimal getNewId() throws Exception{
       return ServiceManager.getIdGenerator().getNewId(BOChargeApplyProdAttrExtBean.getObjectTypeStatic());
   }


   public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(BOChargeApplyProdAttrExtBean.getObjectTypeStatic());
   }


   public static BOChargeApplyProdAttrExtBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (BOChargeApplyProdAttrExtBean)DataContainerFactory.wrap(source,BOChargeApplyProdAttrExtBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
	 throw new RuntimeException(e.getCause());
       else
	 throw new RuntimeException(e);
     }
   }
   public static BOChargeApplyProdAttrExtBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       BOChargeApplyProdAttrExtBean result = new BOChargeApplyProdAttrExtBean();
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

   public static BOChargeApplyProdAttrExtBean transfer(IBOChargeApplyProdAttrExtValue value) {
	   if(value==null)
		   return null;
	try {
		if(value instanceof BOChargeApplyProdAttrExtBean){
			return (BOChargeApplyProdAttrExtBean)value;
		}
		BOChargeApplyProdAttrExtBean newBean = new BOChargeApplyProdAttrExtBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static BOChargeApplyProdAttrExtBean[] transfer(IBOChargeApplyProdAttrExtValue[] value) {
	   if(value==null || value.length==0)
		   return null;

	try {
		if(value instanceof BOChargeApplyProdAttrExtBean[]){
			return (BOChargeApplyProdAttrExtBean[])value;
		}
		BOChargeApplyProdAttrExtBean[] newBeans = new BOChargeApplyProdAttrExtBean[value.length];
		   for(int i=0;i<newBeans.length;i++){
			   newBeans[i] = new BOChargeApplyProdAttrExtBean();
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
  public static void save(IBOChargeApplyProdAttrExtValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( IBOChargeApplyProdAttrExtValue[] aValues) throws Exception{
	  save(transfer(aValues));
   }

   public static  void saveBatch( IBOChargeApplyProdAttrExtValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
