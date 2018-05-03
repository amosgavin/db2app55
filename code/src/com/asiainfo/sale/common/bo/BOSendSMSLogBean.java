package com.asiainfo.sale.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.common.ivalues.*;

public class BOSendSMSLogBean extends DataContainer implements DataContainerInterface,IBOSendSMSLogValue{

  private static String  m_boName = "com.asiainfo.sale.common.bo.BOSendSMSLog";



  public final static  String S_Sender = "SENDER";
  public final static  String S_Content = "CONTENT";
  public final static  String S_Receiver = "RECEIVER";
  public final static  String S_SendTime = "SEND_TIME";
  public final static  String S_Id = "ID";
  public final static  String S_TaskId = "TASK_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOSendSMSLogBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 @Override
public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initSender(int value){
     this.initProperty(S_Sender,new Integer(value));
  }
  public  void setSender(int value){
     this.set(S_Sender,new Integer(value));
  }
  public  void setSenderNull(){
     this.set(S_Sender,null);
  }

  public int getSender(){
        return DataType.getAsInt(this.get(S_Sender));
  
  }
  public int getSenderInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Sender));
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

  public void initReceiver(int value){
     this.initProperty(S_Receiver,new Integer(value));
  }
  public  void setReceiver(int value){
     this.set(S_Receiver,new Integer(value));
  }
  public  void setReceiverNull(){
     this.set(S_Receiver,null);
  }

  public int getReceiver(){
        return DataType.getAsInt(this.get(S_Receiver));
  
  }
  public int getReceiverInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Receiver));
      }

  public void initSendTime(Timestamp value){
     this.initProperty(S_SendTime,value);
  }
  public  void setSendTime(Timestamp value){
     this.set(S_SendTime,value);
  }
  public  void setSendTimeNull(){
     this.set(S_SendTime,null);
  }

  public Timestamp getSendTime(){
        return DataType.getAsDateTime(this.get(S_SendTime));
  
  }
  public Timestamp getSendTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_SendTime));
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

  public void initTaskId(String value){
     this.initProperty(S_TaskId,value);
  }
  public  void setTaskId(String value){
     this.set(S_TaskId,value);
  }
  public  void setTaskIdNull(){
     this.set(S_TaskId,null);
  }

  public String getTaskId(){
       return DataType.getAsString(this.get(S_TaskId));
  
  }
  public String getTaskIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TaskId));
      }


 
 }

