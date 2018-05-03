package com.asiainfo.sale.common.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.common.ivalues.*;

public class BOApprisePrimeBean extends DataContainer implements DataContainerInterface,IBOApprisePrimeValue{

  private static String  m_boName = "com.asiainfo.sale.common.bo.BOApprisePrime";



  public final static  String S_Content = "CONTENT";
  public final static  String S_SenderId = "SENDER_ID";
  public final static  String S_Id = "ID";
  public final static  String S_WorkflowId = "WORKFLOW_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOApprisePrimeBean() throws AIException{
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

  public void initSenderId(int value){
     this.initProperty(S_SenderId,new Integer(value));
  }
  public  void setSenderId(int value){
     this.set(S_SenderId,new Integer(value));
  }
  public  void setSenderIdNull(){
     this.set(S_SenderId,null);
  }

  public int getSenderId(){
        return DataType.getAsInt(this.get(S_SenderId));
  
  }
  public int getSenderIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_SenderId));
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

  public void initWorkflowId(int value){
     this.initProperty(S_WorkflowId,new Integer(value));
  }
  public  void setWorkflowId(int value){
     this.set(S_WorkflowId,new Integer(value));
  }
  public  void setWorkflowIdNull(){
     this.set(S_WorkflowId,null);
  }

  public int getWorkflowId(){
        return DataType.getAsInt(this.get(S_WorkflowId));
  
  }
  public int getWorkflowIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_WorkflowId));
      }


 
 }

