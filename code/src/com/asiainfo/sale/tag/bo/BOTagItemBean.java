package com.asiainfo.sale.tag.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.tag.ivalues.*;

public class BOTagItemBean extends DataContainer implements DataContainerInterface,IBOTagItemValue{

  private static String  m_boName = "com.asiainfo.sale.tag.bo.BOTagItem";



  public final static  String S_Name = "NAME";
  public final static  String S_Remark2 = "REMARK_2";
  public final static  String S_Remark1 = "REMARK_1";
  public final static  String S_ItemType = "ITEM_TYPE";
  public final static  String S_Id = "ID";
  public final static  String S_Remark = "REMARK";
  public final static  String S_ItemCode = "ITEM_CODE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOTagItemBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initName(String value){
     this.initProperty(S_Name,value);
  }
  public  void setName(String value){
     this.set(S_Name,value);
  }
  public  void setNameNull(){
     this.set(S_Name,null);
  }

  public String getName(){
       return DataType.getAsString(this.get(S_Name));
  
  }
  public String getNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Name));
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

  public void initRemark1(String value){
     this.initProperty(S_Remark1,value);
  }
  public  void setRemark1(String value){
     this.set(S_Remark1,value);
  }
  public  void setRemark1Null(){
     this.set(S_Remark1,null);
  }

  public String getRemark1(){
       return DataType.getAsString(this.get(S_Remark1));
  
  }
  public String getRemark1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark1));
      }

  public void initItemType(String value){
     this.initProperty(S_ItemType,value);
  }
  public  void setItemType(String value){
     this.set(S_ItemType,value);
  }
  public  void setItemTypeNull(){
     this.set(S_ItemType,null);
  }

  public String getItemType(){
       return DataType.getAsString(this.get(S_ItemType));
  
  }
  public String getItemTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ItemType));
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

  public void initRemark(String value){
     this.initProperty(S_Remark,value);
  }
  public  void setRemark(String value){
     this.set(S_Remark,value);
  }
  public  void setRemarkNull(){
     this.set(S_Remark,null);
  }

  public String getRemark(){
       return DataType.getAsString(this.get(S_Remark));
  
  }
  public String getRemarkInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark));
      }

  public void initItemCode(String value){
     this.initProperty(S_ItemCode,value);
  }
  public  void setItemCode(String value){
     this.set(S_ItemCode,value);
  }
  public  void setItemCodeNull(){
     this.set(S_ItemCode,null);
  }

  public String getItemCode(){
       return DataType.getAsString(this.get(S_ItemCode));
  
  }
  public String getItemCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ItemCode));
      }


 
 }

