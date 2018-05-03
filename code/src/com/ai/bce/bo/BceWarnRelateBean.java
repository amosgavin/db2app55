package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceWarnRelateBean extends DataContainer implements DataContainerInterface,IBceWarnRelateValue{

  private static String  m_boName = "com.ai.bce.bo.BceWarnRelate";



  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_BusinessId = "BUSINESS_ID";
  public final static  String S_State = "STATE";
  public final static  String S_ChangeNewValue = "CHANGE_NEW_VALUE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_ChangeName = "CHANGE_NAME";
  public final static  String S_WarnId = "WARN_ID";
  public final static  String S_RelateId = "RELATE_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceWarnRelateBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initRegionId(String value){
     this.initProperty(S_RegionId,value);
  }
  public  void setRegionId(String value){
     this.set(S_RegionId,value);
  }
  public  void setRegionIdNull(){
     this.set(S_RegionId,null);
  }

  public String getRegionId(){
       return DataType.getAsString(this.get(S_RegionId));
  
  }
  public String getRegionIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RegionId));
      }

  public void initBceFrameId(long value){
     this.initProperty(S_BceFrameId,new Long(value));
  }
  public  void setBceFrameId(long value){
     this.set(S_BceFrameId,new Long(value));
  }
  public  void setBceFrameIdNull(){
     this.set(S_BceFrameId,null);
  }

  public long getBceFrameId(){
        return DataType.getAsLong(this.get(S_BceFrameId));
  
  }
  public long getBceFrameIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BceFrameId));
      }

  public void initBusinessId(String value){
     this.initProperty(S_BusinessId,value);
  }
  public  void setBusinessId(String value){
     this.set(S_BusinessId,value);
  }
  public  void setBusinessIdNull(){
     this.set(S_BusinessId,null);
  }

  public String getBusinessId(){
       return DataType.getAsString(this.get(S_BusinessId));
  
  }
  public String getBusinessIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BusinessId));
      }

  public void initState(int value){
     this.initProperty(S_State,new Integer(value));
  }
  public  void setState(int value){
     this.set(S_State,new Integer(value));
  }
  public  void setStateNull(){
     this.set(S_State,null);
  }

  public int getState(){
        return DataType.getAsInt(this.get(S_State));
  
  }
  public int getStateInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_State));
      }

  public void initChangeNewValue(String value){
     this.initProperty(S_ChangeNewValue,value);
  }
  public  void setChangeNewValue(String value){
     this.set(S_ChangeNewValue,value);
  }
  public  void setChangeNewValueNull(){
     this.set(S_ChangeNewValue,null);
  }

  public String getChangeNewValue(){
       return DataType.getAsString(this.get(S_ChangeNewValue));
  
  }
  public String getChangeNewValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChangeNewValue));
      }

  public void initRemarks(String value){
     this.initProperty(S_Remarks,value);
  }
  public  void setRemarks(String value){
     this.set(S_Remarks,value);
  }
  public  void setRemarksNull(){
     this.set(S_Remarks,null);
  }

  public String getRemarks(){
       return DataType.getAsString(this.get(S_Remarks));
  
  }
  public String getRemarksInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remarks));
      }

  public void initChangeName(String value){
     this.initProperty(S_ChangeName,value);
  }
  public  void setChangeName(String value){
     this.set(S_ChangeName,value);
  }
  public  void setChangeNameNull(){
     this.set(S_ChangeName,null);
  }

  public String getChangeName(){
       return DataType.getAsString(this.get(S_ChangeName));
  
  }
  public String getChangeNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChangeName));
      }

  public void initWarnId(long value){
     this.initProperty(S_WarnId,new Long(value));
  }
  public  void setWarnId(long value){
     this.set(S_WarnId,new Long(value));
  }
  public  void setWarnIdNull(){
     this.set(S_WarnId,null);
  }

  public long getWarnId(){
        return DataType.getAsLong(this.get(S_WarnId));
  
  }
  public long getWarnIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WarnId));
      }

  public void initRelateId(long value){
     this.initProperty(S_RelateId,new Long(value));
  }
  public  void setRelateId(long value){
     this.set(S_RelateId,new Long(value));
  }
  public  void setRelateIdNull(){
     this.set(S_RelateId,null);
  }

  public long getRelateId(){
        return DataType.getAsLong(this.get(S_RelateId));
  
  }
  public long getRelateIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RelateId));
      }


 
 }

