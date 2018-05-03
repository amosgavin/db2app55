package com.asiainfo.sale.activity.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.activity.ivalues.*;

public class BOChannelInfoBean extends DataContainer implements DataContainerInterface,IBOChannelInfoValue{

  private static String  m_boName = "com.asiainfo.sale.activity.bo.BOChannelInfo";



  public final static  String S_RelId = "REL_ID";
  public final static  String S_RelType = "REL_TYPE";
  public final static  String S_ChannelCode = "CHANNEL_CODE";
  public final static  String S_Operation = "OPERATION";
  public final static  String S_Id = "ID";
  public final static  String S_Region = "REGION";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOChannelInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initRelId(int value){
     this.initProperty(S_RelId,new Integer(value));
  }
  public  void setRelId(int value){
     this.set(S_RelId,new Integer(value));
  }
  public  void setRelIdNull(){
     this.set(S_RelId,null);
  }

  public int getRelId(){
        return DataType.getAsInt(this.get(S_RelId));
  
  }
  public int getRelIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_RelId));
      }

  public void initRelType(String value){
     this.initProperty(S_RelType,value);
  }
  public  void setRelType(String value){
     this.set(S_RelType,value);
  }
  public  void setRelTypeNull(){
     this.set(S_RelType,null);
  }

  public String getRelType(){
       return DataType.getAsString(this.get(S_RelType));
  
  }
  public String getRelTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RelType));
      }

  public void initChannelCode(String value){
     this.initProperty(S_ChannelCode,value);
  }
  public  void setChannelCode(String value){
     this.set(S_ChannelCode,value);
  }
  public  void setChannelCodeNull(){
     this.set(S_ChannelCode,null);
  }

  public String getChannelCode(){
       return DataType.getAsString(this.get(S_ChannelCode));
  
  }
  public String getChannelCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChannelCode));
      }

  public void initOperation(String value){
     this.initProperty(S_Operation,value);
  }
  public  void setOperation(String value){
     this.set(S_Operation,value);
  }
  public  void setOperationNull(){
     this.set(S_Operation,null);
  }

  public String getOperation(){
       return DataType.getAsString(this.get(S_Operation));
  
  }
  public String getOperationInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Operation));
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

  public void initRegion(String value){
     this.initProperty(S_Region,value);
  }
  public  void setRegion(String value){
     this.set(S_Region,value);
  }
  public  void setRegionNull(){
     this.set(S_Region,null);
  }

  public String getRegion(){
       return DataType.getAsString(this.get(S_Region));
  
  }
  public String getRegionInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Region));
      }


 
 }

