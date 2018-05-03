package com.asiainfo.sale.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.common.ivalues.*;

public class BOAnnounceInfoBean extends DataContainer implements DataContainerInterface,IBOAnnounceInfoValue{

  private static String  m_boName = "com.asiainfo.sale.common.bo.BOAnnounceInfo";



  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_CancelTime = "CANCEL_TIME";
  public final static  String S_Title = "TITLE";
  public final static  String S_Content = "CONTENT";
  public final static  String S_Id = "ID";
  public final static  String S_Principle = "PRINCIPLE";
  public final static  String S_Flag = "FLAG";
  public final static  String S_ApplyTime = "APPLY_TIME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOAnnounceInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initCreateTime(Timestamp value){
     this.initProperty(S_CreateTime,value);
  }
  public  void setCreateTime(Timestamp value){
     this.set(S_CreateTime,value);
  }
  public  void setCreateTimeNull(){
     this.set(S_CreateTime,null);
  }

  public Timestamp getCreateTime(){
        return DataType.getAsDateTime(this.get(S_CreateTime));
  
  }
  public Timestamp getCreateTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CreateTime));
      }

  public void initCancelTime(Timestamp value){
     this.initProperty(S_CancelTime,value);
  }
  public  void setCancelTime(Timestamp value){
     this.set(S_CancelTime,value);
  }
  public  void setCancelTimeNull(){
     this.set(S_CancelTime,null);
  }

  public Timestamp getCancelTime(){
        return DataType.getAsDateTime(this.get(S_CancelTime));
  
  }
  public Timestamp getCancelTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CancelTime));
      }

  public void initTitle(String value){
     this.initProperty(S_Title,value);
  }
  public  void setTitle(String value){
     this.set(S_Title,value);
  }
  public  void setTitleNull(){
     this.set(S_Title,null);
  }

  public String getTitle(){
       return DataType.getAsString(this.get(S_Title));
  
  }
  public String getTitleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Title));
      }

  public void initContent(String value){
     this.initProperty(S_Content,value);
  }
  public  void setContent(String value){
     this.set(S_Content,value);
  }
  public  void setContentNull(){
     this.set(S_Content,null);
  }

  public String getContent(){
       return DataType.getAsString(this.get(S_Content));
  
  }
  public String getContentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Content));
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

  public void initPrinciple(String value){
     this.initProperty(S_Principle,value);
  }
  public  void setPrinciple(String value){
     this.set(S_Principle,value);
  }
  public  void setPrincipleNull(){
     this.set(S_Principle,null);
  }

  public String getPrinciple(){
       return DataType.getAsString(this.get(S_Principle));
  
  }
  public String getPrincipleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Principle));
      }

  public void initFlag(String value){
     this.initProperty(S_Flag,value);
  }
  public  void setFlag(String value){
     this.set(S_Flag,value);
  }
  public  void setFlagNull(){
     this.set(S_Flag,null);
  }

  public String getFlag(){
       return DataType.getAsString(this.get(S_Flag));
  
  }
  public String getFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Flag));
      }

  public void initApplyTime(Timestamp value){
     this.initProperty(S_ApplyTime,value);
  }
  public  void setApplyTime(Timestamp value){
     this.set(S_ApplyTime,value);
  }
  public  void setApplyTimeNull(){
     this.set(S_ApplyTime,null);
  }

  public Timestamp getApplyTime(){
        return DataType.getAsDateTime(this.get(S_ApplyTime));
  
  }
  public Timestamp getApplyTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ApplyTime));
      }


 
 }

