package com.asiainfo.sale.activity.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.activity.ivalues.*;

public class BORelateSaleWithGoodsBean extends DataContainer implements DataContainerInterface,IBORelateSaleWithGoodsValue{

  private static String  m_boName = "com.asiainfo.sale.activity.bo.BORelateSaleWithGoods";



  public final static  String S_TagId = "TAG_ID";
  public final static  String S_Remark1 = "REMARK1";
  public final static  String S_Remark2 = "REMARK2";
  public final static  String S_Remark3 = "REMARK3";
  public final static  String S_SaleId = "SALE_ID";
  public final static  String S_Id = "ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BORelateSaleWithGoodsBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initTagId(int value){
     this.initProperty(S_TagId,new Integer(value));
  }
  public  void setTagId(int value){
     this.set(S_TagId,new Integer(value));
  }
  public  void setTagIdNull(){
     this.set(S_TagId,null);
  }

  public int getTagId(){
        return DataType.getAsInt(this.get(S_TagId));
  
  }
  public int getTagIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_TagId));
      }

  public void initRemark1(int value){
     this.initProperty(S_Remark1,new Integer(value));
  }
  public  void setRemark1(int value){
     this.set(S_Remark1,new Integer(value));
  }
  public  void setRemark1Null(){
     this.set(S_Remark1,null);
  }

  public int getRemark1(){
        return DataType.getAsInt(this.get(S_Remark1));
  
  }
  public int getRemark1InitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Remark1));
      }

  public void initRemark2(String value){
     this.initProperty(S_Remark2,value);
  }
  public  void setRemark2(String value){
     this.set(S_Remark2,value);
  }
  public  void setRemark2Null(){
     this.set(S_Remark2,null);
  }

  public String getRemark2(){
       return DataType.getAsString(this.get(S_Remark2));
  
  }
  public String getRemark2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark2));
      }

  public void initRemark3(String value){
     this.initProperty(S_Remark3,value);
  }
  public  void setRemark3(String value){
     this.set(S_Remark3,value);
  }
  public  void setRemark3Null(){
     this.set(S_Remark3,null);
  }

  public String getRemark3(){
       return DataType.getAsString(this.get(S_Remark3));
  
  }
  public String getRemark3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark3));
      }

  public void initSaleId(int value){
     this.initProperty(S_SaleId,new Integer(value));
  }
  public  void setSaleId(int value){
     this.set(S_SaleId,new Integer(value));
  }
  public  void setSaleIdNull(){
     this.set(S_SaleId,null);
  }

  public int getSaleId(){
        return DataType.getAsInt(this.get(S_SaleId));
  
  }
  public int getSaleIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_SaleId));
      }

  public void initId(int value){
     this.initProperty(S_Id,new Integer(value));
  }
  public  void setId(int value){
     this.set(S_Id,new Integer(value));
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public int getId(){
        return DataType.getAsInt(this.get(S_Id));
  
  }
  public int getIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Id));
      }


 
 }

