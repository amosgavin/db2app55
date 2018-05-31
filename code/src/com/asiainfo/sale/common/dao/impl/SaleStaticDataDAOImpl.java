package com.asiainfo.sale.common.dao.impl;

import java.net.URLDecoder;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.locale.AppframeLocaleFactory;
import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils;
import com.asiainfo.sale.common.bo.BOSaleStaticDataEngine;
import com.asiainfo.sale.common.dao.interfaces.ISaleStaticDataDAO;
import com.asiainfo.sale.common.ivalues.IBOSaleStaticDataValue;
import com.asiainfo.sale.tag.bo.BOPromationTagEngine;
import com.asiainfo.sale.tag.ivalues.IBOPromationTagValue;

public class SaleStaticDataDAOImpl
    implements ISaleStaticDataDAO{
  private static transient Map m_salestaticdata_by_codetype_and_codeid = null;
  private static transient Map m_salestaticdata_by_codetype = null;
  private static transient boolean isInitial = false;

  public SaleStaticDataDAOImpl(){
    if( SaleStaticDataDAOImpl.isInitial == false ){
      m_salestaticdata_by_codetype_and_codeid = ServiceManager.getCacheManager().getMap( "SALE_STATIC_DATE_BY_CODETYPE_AND_CODEID" );
      m_salestaticdata_by_codetype = ServiceManager.getCacheManager().getMap( "SALE_STATIC_DATE_BY_CODETYPE" );
      SaleStaticDataDAOImpl.isInitial = true;
    }
  }

  /**
   * 获取静态数据
   * 
   * @param codeType
   * @return ISysStaticDataValue[]
   * @throws Throwable
   */
  public IBOSaleStaticDataValue[] getSaleStaticData( String codeType ) throws Exception{
    HashMap parameter = new HashMap();
    IBOSaleStaticDataValue[] result = (IBOSaleStaticDataValue[]) SaleStaticDataDAOImpl.m_salestaticdata_by_codetype.get( codeType );
    if( result == null ){
      parameter.put( "codeType", codeType );
      result = BOSaleStaticDataEngine.getBeans( " CODE_TYPE=:codeType and IS_USED = 1 order by CODE_TYPE,SORT_ID,CODE_ID ", parameter );
      SaleStaticDataDAOImpl.m_salestaticdata_by_codetype.put( codeType, result );
    }
    return result;
    
  }

  public IBOSaleStaticDataValue[] getSaleStaticDatas( String codeType ,String name) throws Exception{
	    HashMap parameter = new HashMap();
	    StringBuffer condition = new StringBuffer(" 1 = 1 ");
	    if(StringUtils.isNotBlank(codeType)){
	    	condition.append(" AND " + IBOSaleStaticDataValue.S_CodeType
					+ " = :codeType");
			parameter.put("codeType", codeType);
	    }
	    if(StringUtils.isNotBlank(name)){
	    	String namea=URLDecoder.decode(name,"utf-8");
	    	condition.append(" AND " + IBOSaleStaticDataValue.S_CodeName
					+ " like :name");
			parameter.put("name", "%" + namea + "%");
	    }
		condition.append(" order by sort_id ");
	    Object[] object = new Object[] { condition.toString(), parameter };
	    IBOSaleStaticDataValue[] iob = BOSaleStaticDataEngine.getBeans(null,
				(String) object[0], (Map) object[1], -1, -1, false);
		return iob;
	  }
  
  public int queryStaticDateCount(String codeType ,String name)throws Exception{
	  return getSaleStaticDatas(codeType , name).length;
  }
  /**
   * 更加静态数据类型和编号获取数据
   * 
   * @param codeType
   * @param codeId
   * @throws Exception
   * @throws RemoteException
   * @return ISysStaticDataValue[]
   */
  public IBOSaleStaticDataValue getSaleStaticData( String codeType, String codeId ) throws Exception{

    String mapKey = codeType + "-" + codeId;
    IBOSaleStaticDataValue result = (IBOSaleStaticDataValue) SaleStaticDataDAOImpl.m_salestaticdata_by_codetype_and_codeid.get( mapKey );
    if( result == null ){
      HashMap parameter = new HashMap();
      parameter.put( "codeType", codeType );
      parameter.put( "codeId", codeId );
      IBOSaleStaticDataValue[] beans = BOSaleStaticDataEngine.getBeans(
        " CODE_TYPE=:codeType and CODE_ID = :codeId and IS_USED = 1 order by CODE_TYPE,SORT_ID,CODE_ID ",
        parameter );
      if( beans.length == 0 ){
        result = null;
      }else if( beans.length > 1 ){
        throw new Exception( AppframeLocaleFactory.getResource("i18n.secframe_resource", "salestaticdatadaoimpl.error")+"(CODE_TYPE=" + codeType + ",CODE_ID=" + codeId + ")" );
      }else{
        if( beans != null )
          result = beans[0];
      }
      if( result != null ){
        SaleStaticDataDAOImpl.m_salestaticdata_by_codetype_and_codeid.put( mapKey, result );
      }
    }
    return result;
  }

  public void initCache() throws Exception {
	  SaleStaticDataDAOImpl.m_salestaticdata_by_codetype_and_codeid = null;
	  SaleStaticDataDAOImpl.m_salestaticdata_by_codetype = null;
	  SaleStaticDataDAOImpl.isInitial = false;	
  }
}
