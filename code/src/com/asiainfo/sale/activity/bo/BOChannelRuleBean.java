package com.asiainfo.sale.activity.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.activity.ivalues.*;

public class BOChannelRuleBean extends DataContainer implements DataContainerInterface,IBOChannelRuleValue{

  private static String  m_boName = "com.asiainfo.sale.activity.bo.BOChannelRule";



  public final static  String S_Remark1 = "REMARK1";
  public final static  String S_RuleId = "RULE_ID";
  public final static  String S_Remark2 = "REMARK2";
  public final static  String S_Remark3 = "REMARK3";
  public final static  String S_ChannelType = "CHANNEL_TYPE";
  public final static  String S_ConfMode = "CONF_MODE";
  public final static  String S_ChannelLevType = "CHANNEL_LEV_TYPE";
  public final static  String S_DetailId = "DETAIL_ID";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_ChannelPosType = "CHANNEL_POS_TYPE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOChannelRuleBean() throws AIException{
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

  public void initRuleId(int value){
     this.initProperty(S_RuleId,new Integer(value));
  }
  public  void setRuleId(int value){
     this.set(S_RuleId,new Integer(value));
  }
  public  void setRuleIdNull(){
     this.set(S_RuleId,null);
  }

  public int getRuleId(){
        return DataType.getAsInt(this.get(S_RuleId));
  
  }
  public int getRuleIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_RuleId));
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

  public void initChannelType(String value){
     this.initProperty(S_ChannelType,value);
  }
  public  void setChannelType(String value){
     this.set(S_ChannelType,value);
  }
  public  void setChannelTypeNull(){
     this.set(S_ChannelType,null);
  }

  public String getChannelType(){
       return DataType.getAsString(this.get(S_ChannelType));
  
  }
  public String getChannelTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChannelType));
      }

  public void initConfMode(String value){
     this.initProperty(S_ConfMode,value);
  }
  public  void setConfMode(String value){
     this.set(S_ConfMode,value);
  }
  public  void setConfModeNull(){
     this.set(S_ConfMode,null);
  }

  public String getConfMode(){
       return DataType.getAsString(this.get(S_ConfMode));
  
  }
  public String getConfModeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ConfMode));
      }

  public void initChannelLevType(String value){
     this.initProperty(S_ChannelLevType,value);
  }
  public  void setChannelLevType(String value){
     this.set(S_ChannelLevType,value);
  }
  public  void setChannelLevTypeNull(){
     this.set(S_ChannelLevType,null);
  }

  public String getChannelLevType(){
       return DataType.getAsString(this.get(S_ChannelLevType));
  
  }
  public String getChannelLevTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChannelLevType));
      }

  public void initDetailId(int value){
     this.initProperty(S_DetailId,new Integer(value));
  }
  public  void setDetailId(int value){
     this.set(S_DetailId,new Integer(value));
  }
  public  void setDetailIdNull(){
     this.set(S_DetailId,null);
  }

  public int getDetailId(){
        return DataType.getAsInt(this.get(S_DetailId));
  
  }
  public int getDetailIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_DetailId));
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

  public void initChannelPosType(String value){
     this.initProperty(S_ChannelPosType,value);
  }
  public  void setChannelPosType(String value){
     this.set(S_ChannelPosType,value);
  }
  public  void setChannelPosTypeNull(){
     this.set(S_ChannelPosType,null);
  }

  public String getChannelPosType(){
       return DataType.getAsString(this.get(S_ChannelPosType));
  
  }
  public String getChannelPosTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChannelPosType));
      }


 
 }

