package com.asiainfo.sale.activity.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.activity.ivalues.*;

public class BOSaleCostEffectiveBean extends DataContainer implements DataContainerInterface,IBOSaleCostEffectiveValue{

  private static String  m_boName = "com.asiainfo.sale.activity.bo.BOSaleCostEffective";



  public final static  String S_ColAlias1 = "COL_ALIAS_1";
  public final static  String S_ColAlias4 = "COL_ALIAS_4";
  public final static  String S_ColAlias13 = "COL_ALIAS_13";
  public final static  String S_ColAlias2 = "COL_ALIAS_2";
  public final static  String S_ColAlias12 = "COL_ALIAS_12";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOSaleCostEffectiveBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initColAlias1(String value){
     this.initProperty(S_ColAlias1,value);
  }
  public  void setColAlias1(String value){
     this.set(S_ColAlias1,value);
  }
  public  void setColAlias1Null(){
     this.set(S_ColAlias1,null);
  }

  public String getColAlias1(){
       return DataType.getAsString(this.get(S_ColAlias1));
  
  }
  public String getColAlias1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ColAlias1));
      }

  public void initColAlias4(String value){
     this.initProperty(S_ColAlias4,value);
  }
  public  void setColAlias4(String value){
     this.set(S_ColAlias4,value);
  }
  public  void setColAlias4Null(){
     this.set(S_ColAlias4,null);
  }

  public String getColAlias4(){
       return DataType.getAsString(this.get(S_ColAlias4));
  
  }
  public String getColAlias4InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ColAlias4));
      }

  public void initColAlias13(long value){
     this.initProperty(S_ColAlias13,new Long(value));
  }
  public  void setColAlias13(long value){
     this.set(S_ColAlias13,new Long(value));
  }
  public  void setColAlias13Null(){
     this.set(S_ColAlias13,null);
  }

  public long getColAlias13(){
        return DataType.getAsLong(this.get(S_ColAlias13));
  
  }
  public long getColAlias13InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ColAlias13));
      }

  public void initColAlias2(String value){
     this.initProperty(S_ColAlias2,value);
  }
  public  void setColAlias2(String value){
     this.set(S_ColAlias2,value);
  }
  public  void setColAlias2Null(){
     this.set(S_ColAlias2,null);
  }

  public String getColAlias2(){
       return DataType.getAsString(this.get(S_ColAlias2));
  
  }
  public String getColAlias2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ColAlias2));
      }

  public void initColAlias12(long value){
     this.initProperty(S_ColAlias12,new Long(value));
  }
  public  void setColAlias12(long value){
     this.set(S_ColAlias12,new Long(value));
  }
  public  void setColAlias12Null(){
     this.set(S_ColAlias12,null);
  }

  public long getColAlias12(){
        return DataType.getAsLong(this.get(S_ColAlias12));
  
  }
  public long getColAlias12InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ColAlias12));
      }


 
 }

