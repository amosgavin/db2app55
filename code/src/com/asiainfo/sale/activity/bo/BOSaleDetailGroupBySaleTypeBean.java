package com.asiainfo.sale.activity.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.activity.ivalues.*;

public class BOSaleDetailGroupBySaleTypeBean extends DataContainer implements DataContainerInterface,IBOSaleDetailGroupBySaleTypeValue{

  private static String  m_boName = "com.asiainfo.sale.activity.bo.BOSaleDetailGroupBySaleType";



  public final static  String S_SaleId = "SALE_ID";
  public final static  String S_Scount = "SCOUNT";
  public final static  String S_SaleFlag = "SALE_FLAG";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOSaleDetailGroupBySaleTypeBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initSaleId(long value){
     this.initProperty(S_SaleId,new Long(value));
  }
  public  void setSaleId(long value){
     this.set(S_SaleId,new Long(value));
  }
  public  void setSaleIdNull(){
     this.set(S_SaleId,null);
  }

  public long getSaleId(){
        return DataType.getAsLong(this.get(S_SaleId));
  
  }
  public long getSaleIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SaleId));
      }

  public void initScount(long value){
     this.initProperty(S_Scount,new Long(value));
  }
  public  void setScount(long value){
     this.set(S_Scount,new Long(value));
  }
  public  void setScountNull(){
     this.set(S_Scount,null);
  }

  public long getScount(){
        return DataType.getAsLong(this.get(S_Scount));
  
  }
  public long getScountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Scount));
      }

  public void initSaleFlag(String value){
     this.initProperty(S_SaleFlag,value);
  }
  public  void setSaleFlag(String value){
     this.set(S_SaleFlag,value);
  }
  public  void setSaleFlagNull(){
     this.set(S_SaleFlag,null);
  }

  public String getSaleFlag(){
       return DataType.getAsString(this.get(S_SaleFlag));
  
  }
  public String getSaleFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleFlag));
      }


 
 }

