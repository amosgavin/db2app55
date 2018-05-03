package com.asiainfo.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.common.ivalues.*;

public class BOCrmAuditLogBean extends DataContainer implements DataContainerInterface,IBOCrmAuditLogValue{

  private static String  m_boName = "com.asiainfo.common.bo.BOCrmAuditLog";



  public final static  String S_BossCode = "BOSS_CODE";
  public final static  String S_Content = "CONTENT";
  public final static  String S_AuditFlag = "AUDIT_FLAG";
  public final static  String S_ModeId = "MODE_ID";
  public final static  String S_InterfaceId = "INTERFACE_ID";
  public final static  String S_AuditDate = "AUDIT_DATE";
  public final static  String S_Id = "ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOCrmAuditLogBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initBossCode(String value){
     this.initProperty(S_BossCode,value);
  }
  public  void setBossCode(String value){
     this.set(S_BossCode,value);
  }
  public  void setBossCodeNull(){
     this.set(S_BossCode,null);
  }

  public String getBossCode(){
       return DataType.getAsString(this.get(S_BossCode));
  
  }
  public String getBossCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BossCode));
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

  public void initAuditFlag(String value){
     this.initProperty(S_AuditFlag,value);
  }
  public  void setAuditFlag(String value){
     this.set(S_AuditFlag,value);
  }
  public  void setAuditFlagNull(){
     this.set(S_AuditFlag,null);
  }

  public String getAuditFlag(){
       return DataType.getAsString(this.get(S_AuditFlag));
  
  }
  public String getAuditFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AuditFlag));
      }

  public void initModeId(String value){
     this.initProperty(S_ModeId,value);
  }
  public  void setModeId(String value){
     this.set(S_ModeId,value);
  }
  public  void setModeIdNull(){
     this.set(S_ModeId,null);
  }

  public String getModeId(){
       return DataType.getAsString(this.get(S_ModeId));
  
  }
  public String getModeIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ModeId));
      }

  public void initInterfaceId(String value){
     this.initProperty(S_InterfaceId,value);
  }
  public  void setInterfaceId(String value){
     this.set(S_InterfaceId,value);
  }
  public  void setInterfaceIdNull(){
     this.set(S_InterfaceId,null);
  }

  public String getInterfaceId(){
       return DataType.getAsString(this.get(S_InterfaceId));
  
  }
  public String getInterfaceIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_InterfaceId));
      }

  public void initAuditDate(Timestamp value){
     this.initProperty(S_AuditDate,value);
  }
  public  void setAuditDate(Timestamp value){
     this.set(S_AuditDate,value);
  }
  public  void setAuditDateNull(){
     this.set(S_AuditDate,null);
  }

  public Timestamp getAuditDate(){
        return DataType.getAsDateTime(this.get(S_AuditDate));
  
  }
  public Timestamp getAuditDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_AuditDate));
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


 
 }

