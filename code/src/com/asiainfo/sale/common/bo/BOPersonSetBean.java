package com.asiainfo.sale.common.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.common.ivalues.*;

public class BOPersonSetBean extends DataContainer implements DataContainerInterface,IBOPersonSetValue{

  private static String  m_boName = "com.asiainfo.sale.common.bo.BOPersonSet";



  public final static  String S_OperatorId = "OPERATOR_ID";
  public final static  String S_SysSmsFlag = "SYS_SMS_FLAG";
  public final static  String S_Id = "ID";
  public final static  String S_ReceiveSmsFlag = "RECEIVE_SMS_FLAG";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOPersonSetBean() throws AIException{
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

  public void initSysSmsFlag(String value){
     this.initProperty(S_SysSmsFlag,value);
  }
  public  void setSysSmsFlag(String value){
     this.set(S_SysSmsFlag,value);
  }
  public  void setSysSmsFlagNull(){
     this.set(S_SysSmsFlag,null);
  }

  public String getSysSmsFlag(){
       return DataType.getAsString(this.get(S_SysSmsFlag));
  
  }
  public String getSysSmsFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SysSmsFlag));
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

  public void initReceiveSmsFlag(String value){
     this.initProperty(S_ReceiveSmsFlag,value);
  }
  public  void setReceiveSmsFlag(String value){
     this.set(S_ReceiveSmsFlag,value);
  }
  public  void setReceiveSmsFlagNull(){
     this.set(S_ReceiveSmsFlag,null);
  }

  public String getReceiveSmsFlag(){
       return DataType.getAsString(this.get(S_ReceiveSmsFlag));
  
  }
  public String getReceiveSmsFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReceiveSmsFlag));
      }


 
 }

