package com.asiainfo.sale.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.common.ivalues.*;

public class BOAppriseMemberBean extends DataContainer implements DataContainerInterface,IBOAppriseMemberValue{

  private static String  m_boName = "com.asiainfo.sale.common.bo.BOAppriseMember";



  public final static  String S_Remark1 = "REMARK1";
  public final static  String S_Remark2 = "REMARK2";
  public final static  String S_OperatorId = "OPERATOR_ID";
  public final static  String S_Remark3 = "REMARK3";
  public final static  String S_Remark4 = "REMARK4";
  public final static  String S_SendTime = "SEND_TIME";
  public final static  String S_IsReaded = "IS_READED";
  public final static  String S_ReadTime = "READ_TIME";
  public final static  String S_DealTime = "DEAL_TIME";
  public final static  String S_SenderInfo = "SENDER_INFO";
  public final static  String S_Content = "CONTENT";
  public final static  String S_LastOperatorId = "LAST_OPERATOR_ID";
  public final static  String S_Id = "ID";
  public final static  String S_AppriseFlag = "APPRISE_FLAG";
  public final static  String S_WorkflowId = "WORKFLOW_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOAppriseMemberBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initOperatorId(int value){
     this.initProperty(S_OperatorId,new Integer(value));
  }
  public  void setOperatorId(int value){
     this.set(S_OperatorId,new Integer(value));
  }
  public  void setOperatorIdNull(){
     this.set(S_OperatorId,null);
  }

  public int getOperatorId(){
        return DataType.getAsInt(this.get(S_OperatorId));
  
  }
  public int getOperatorIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_OperatorId));
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

  public void initRemark4(String value){
     this.initProperty(S_Remark4,value);
  }
  public  void setRemark4(String value){
     this.set(S_Remark4,value);
  }
  public  void setRemark4Null(){
     this.set(S_Remark4,null);
  }

  public String getRemark4(){
       return DataType.getAsString(this.get(S_Remark4));
  
  }
  public String getRemark4InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark4));
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

  public void initIsReaded(String value){
     this.initProperty(S_IsReaded,value);
  }
  public  void setIsReaded(String value){
     this.set(S_IsReaded,value);
  }
  public  void setIsReadedNull(){
     this.set(S_IsReaded,null);
  }

  public String getIsReaded(){
       return DataType.getAsString(this.get(S_IsReaded));
  
  }
  public String getIsReadedInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsReaded));
      }

  public void initReadTime(Timestamp value){
     this.initProperty(S_ReadTime,value);
  }
  public  void setReadTime(Timestamp value){
     this.set(S_ReadTime,value);
  }
  public  void setReadTimeNull(){
     this.set(S_ReadTime,null);
  }

  public Timestamp getReadTime(){
        return DataType.getAsDateTime(this.get(S_ReadTime));
  
  }
  public Timestamp getReadTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ReadTime));
      }

  public void initDealTime(Timestamp value){
     this.initProperty(S_DealTime,value);
  }
  public  void setDealTime(Timestamp value){
     this.set(S_DealTime,value);
  }
  public  void setDealTimeNull(){
     this.set(S_DealTime,null);
  }

  public Timestamp getDealTime(){
        return DataType.getAsDateTime(this.get(S_DealTime));
  
  }
  public Timestamp getDealTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_DealTime));
      }

  public void initSenderInfo(String value){
     this.initProperty(S_SenderInfo,value);
  }
  public  void setSenderInfo(String value){
     this.set(S_SenderInfo,value);
  }
  public  void setSenderInfoNull(){
     this.set(S_SenderInfo,null);
  }

  public String getSenderInfo(){
       return DataType.getAsString(this.get(S_SenderInfo));
  
  }
  public String getSenderInfoInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SenderInfo));
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

  public void initLastOperatorId(int value){
     this.initProperty(S_LastOperatorId,new Integer(value));
  }
  public  void setLastOperatorId(int value){
     this.set(S_LastOperatorId,new Integer(value));
  }
  public  void setLastOperatorIdNull(){
     this.set(S_LastOperatorId,null);
  }

  public int getLastOperatorId(){
        return DataType.getAsInt(this.get(S_LastOperatorId));
  
  }
  public int getLastOperatorIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_LastOperatorId));
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

  public void initAppriseFlag(String value){
     this.initProperty(S_AppriseFlag,value);
  }
  public  void setAppriseFlag(String value){
     this.set(S_AppriseFlag,value);
  }
  public  void setAppriseFlagNull(){
     this.set(S_AppriseFlag,null);
  }

  public String getAppriseFlag(){
       return DataType.getAsString(this.get(S_AppriseFlag));
  
  }
  public String getAppriseFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AppriseFlag));
      }

  public void initWorkflowId(String value){
     this.initProperty(S_WorkflowId,value);
  }
  public  void setWorkflowId(String value){
     this.set(S_WorkflowId,value);
  }
  public  void setWorkflowIdNull(){
     this.set(S_WorkflowId,null);
  }

  public String getWorkflowId(){
       return DataType.getAsString(this.get(S_WorkflowId));
  
  }
  public String getWorkflowIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WorkflowId));
      }


 
 }

