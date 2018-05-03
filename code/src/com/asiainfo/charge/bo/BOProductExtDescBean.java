package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOProductExtDescBean extends DataContainer implements DataContainerInterface,IBOProductExtDescValue{

  private static String  m_boName = "com.asiainfo.charge.bo.BOProductExtDesc";



  public final static  String S_State = "STATE";
  public final static  String S_ExtName = "EXT_NAME";
  public final static  String S_IsCanModify = "IS_CAN_MODIFY";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_ExtCode = "EXT_CODE";
  public final static  String S_ExtType = "EXT_TYPE";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_Ext6 = "EXT6";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_Ext4 = "EXT4";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOProductExtDescBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initState(String value){
     this.initProperty(S_State,value);
  }
  public  void setState(String value){
     this.set(S_State,value);
  }
  public  void setStateNull(){
     this.set(S_State,null);
  }

  public String getState(){
       return DataType.getAsString(this.get(S_State));
  
  }
  public String getStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_State));
      }

  public void initExtName(String value){
     this.initProperty(S_ExtName,value);
  }
  public  void setExtName(String value){
     this.set(S_ExtName,value);
  }
  public  void setExtNameNull(){
     this.set(S_ExtName,null);
  }

  public String getExtName(){
       return DataType.getAsString(this.get(S_ExtName));
  
  }
  public String getExtNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExtName));
      }

  public void initIsCanModify(String value){
     this.initProperty(S_IsCanModify,value);
  }
  public  void setIsCanModify(String value){
     this.set(S_IsCanModify,value);
  }
  public  void setIsCanModifyNull(){
     this.set(S_IsCanModify,null);
  }

  public String getIsCanModify(){
       return DataType.getAsString(this.get(S_IsCanModify));
  
  }
  public String getIsCanModifyInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsCanModify));
      }

  public void initModifyDate(Timestamp value){
     this.initProperty(S_ModifyDate,value);
  }
  public  void setModifyDate(Timestamp value){
     this.set(S_ModifyDate,value);
  }
  public  void setModifyDateNull(){
     this.set(S_ModifyDate,null);
  }

  public Timestamp getModifyDate(){
        return DataType.getAsDateTime(this.get(S_ModifyDate));
  
  }
  public Timestamp getModifyDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ModifyDate));
      }

  public void initStaffId(String value){
     this.initProperty(S_StaffId,value);
  }
  public  void setStaffId(String value){
     this.set(S_StaffId,value);
  }
  public  void setStaffIdNull(){
     this.set(S_StaffId,null);
  }

  public String getStaffId(){
       return DataType.getAsString(this.get(S_StaffId));
  
  }
  public String getStaffIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StaffId));
      }

  public void initExtCode(String value){
     this.initProperty(S_ExtCode,value);
  }
  public  void setExtCode(String value){
     this.set(S_ExtCode,value);
  }
  public  void setExtCodeNull(){
     this.set(S_ExtCode,null);
  }

  public String getExtCode(){
       return DataType.getAsString(this.get(S_ExtCode));
  
  }
  public String getExtCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExtCode));
      }

  public void initExtType(String value){
     this.initProperty(S_ExtType,value);
  }
  public  void setExtType(String value){
     this.set(S_ExtType,value);
  }
  public  void setExtTypeNull(){
     this.set(S_ExtType,null);
  }

  public String getExtType(){
       return DataType.getAsString(this.get(S_ExtType));
  
  }
  public String getExtTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExtType));
      }

  public void initExt5(String value){
     this.initProperty(S_Ext5,value);
  }
  public  void setExt5(String value){
     this.set(S_Ext5,value);
  }
  public  void setExt5Null(){
     this.set(S_Ext5,null);
  }

  public String getExt5(){
       return DataType.getAsString(this.get(S_Ext5));
  
  }
  public String getExt5InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext5));
      }

  public void initExt6(Timestamp value){
     this.initProperty(S_Ext6,value);
  }
  public  void setExt6(Timestamp value){
     this.set(S_Ext6,value);
  }
  public  void setExt6Null(){
     this.set(S_Ext6,null);
  }

  public Timestamp getExt6(){
        return DataType.getAsDateTime(this.get(S_Ext6));
  
  }
  public Timestamp getExt6InitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_Ext6));
      }

  public void initCreateDate(Timestamp value){
     this.initProperty(S_CreateDate,value);
  }
  public  void setCreateDate(Timestamp value){
     this.set(S_CreateDate,value);
  }
  public  void setCreateDateNull(){
     this.set(S_CreateDate,null);
  }

  public Timestamp getCreateDate(){
        return DataType.getAsDateTime(this.get(S_CreateDate));
  
  }
  public Timestamp getCreateDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CreateDate));
      }

  public void initExt1(Timestamp value){
     this.initProperty(S_Ext1,value);
  }
  public  void setExt1(Timestamp value){
     this.set(S_Ext1,value);
  }
  public  void setExt1Null(){
     this.set(S_Ext1,null);
  }

  public Timestamp getExt1(){
        return DataType.getAsDateTime(this.get(S_Ext1));
  
  }
  public Timestamp getExt1InitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_Ext1));
      }

  public void initExt2(String value){
     this.initProperty(S_Ext2,value);
  }
  public  void setExt2(String value){
     this.set(S_Ext2,value);
  }
  public  void setExt2Null(){
     this.set(S_Ext2,null);
  }

  public String getExt2(){
       return DataType.getAsString(this.get(S_Ext2));
  
  }
  public String getExt2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext2));
      }

  public void initExt3(String value){
     this.initProperty(S_Ext3,value);
  }
  public  void setExt3(String value){
     this.set(S_Ext3,value);
  }
  public  void setExt3Null(){
     this.set(S_Ext3,null);
  }

  public String getExt3(){
       return DataType.getAsString(this.get(S_Ext3));
  
  }
  public String getExt3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext3));
      }

  public void initExt4(String value){
     this.initProperty(S_Ext4,value);
  }
  public  void setExt4(String value){
     this.set(S_Ext4,value);
  }
  public  void setExt4Null(){
     this.set(S_Ext4,null);
  }

  public String getExt4(){
       return DataType.getAsString(this.get(S_Ext4));
  
  }
  public String getExt4InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext4));
      }


 
 }

