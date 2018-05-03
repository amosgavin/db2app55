package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceFormGroupBean extends DataContainer implements DataContainerInterface,IBceFormGroupValue{

  private static String  m_boName = "com.ai.bce.bo.BceFormGroup";



  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_IsClosed = "IS_CLOSED";
  public final static  String S_Attr3 = "ATTR_3";
  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_GroupId = "GROUP_ID";
  public final static  String S_Attr4 = "ATTR_4";
  public final static  String S_FormId = "FORM_ID";
  public final static  String S_GroupStyle = "GROUP_STYLE";
  public final static  String S_Attr5 = "ATTR_5";
  public final static  String S_Attr1 = "ATTR_1";
  public final static  String S_GroupName = "GROUP_NAME";
  public final static  String S_IsAllowStract = "IS_ALLOW_STRACT";
  public final static  String S_Attr2 = "ATTR_2";
  public final static  String S_SeqNo = "SEQ_NO";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceFormGroupBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("Cannot reset ObjectType");
 }


  public void initModuleId(long value){
     this.initProperty(S_ModuleId,new Long(value));
  }
  public  void setModuleId(long value){
     this.set(S_ModuleId,new Long(value));
  }

  public  void setModuleId(Long value){
     this.set(S_ModuleId,value);
  }
  
  public  Long  getModuleIdAsLong(){
     return (Long )this.get(S_ModuleId);
  }
  
  
  public  void setModuleIdNull(){
     this.set(S_ModuleId,null);
  }

  public long getModuleId(){
        return DataType.getAsLong(this.get(S_ModuleId));
  
  }
  public long getModuleIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ModuleId));
      }

  public void initState(int value){
     this.initProperty(S_State,new Integer(value));
  }
  public  void setState(int value){
     this.set(S_State,new Integer(value));
  }

  public  void setState(Integer value){
     this.set(S_State,value);
  }
  
  public  Integer  getStateAsInteger(){
     return (Integer )this.get(S_State);
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

  public void initIsClosed(int value){
     this.initProperty(S_IsClosed,new Integer(value));
  }
  public  void setIsClosed(int value){
     this.set(S_IsClosed,new Integer(value));
  }

  public  void setIsClosed(Integer value){
     this.set(S_IsClosed,value);
  }
  
  public  Integer  getIsClosedAsInteger(){
     return (Integer )this.get(S_IsClosed);
  }
  
  
  public  void setIsClosedNull(){
     this.set(S_IsClosed,null);
  }

  public int getIsClosed(){
        return DataType.getAsInt(this.get(S_IsClosed));
  
  }
  public int getIsClosedInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IsClosed));
      }

  public void initAttr3(String value){
     this.initProperty(S_Attr3,value);
  }
  public  void setAttr3(String value){
     this.set(S_Attr3,value);
  }

  
  
  public  void setAttr3Null(){
     this.set(S_Attr3,null);
  }

  public String getAttr3(){
       return DataType.getAsString(this.get(S_Attr3));
  
  }
  public String getAttr3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Attr3));
      }

  public void initBceFrameId(long value){
     this.initProperty(S_BceFrameId,new Long(value));
  }
  public  void setBceFrameId(long value){
     this.set(S_BceFrameId,new Long(value));
  }

  public  void setBceFrameId(Long value){
     this.set(S_BceFrameId,value);
  }
  
  public  Long  getBceFrameIdAsLong(){
     return (Long )this.get(S_BceFrameId);
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

  public void initGroupId(long value){
     this.initProperty(S_GroupId,new Long(value));
  }
  public  void setGroupId(long value){
     this.set(S_GroupId,new Long(value));
  }

  public  void setGroupId(Long value){
     this.set(S_GroupId,value);
  }
  
  public  Long  getGroupIdAsLong(){
     return (Long )this.get(S_GroupId);
  }
  
  
  public  void setGroupIdNull(){
     this.set(S_GroupId,null);
  }

  public long getGroupId(){
        return DataType.getAsLong(this.get(S_GroupId));
  
  }
  public long getGroupIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_GroupId));
      }

  public void initAttr4(String value){
     this.initProperty(S_Attr4,value);
  }
  public  void setAttr4(String value){
     this.set(S_Attr4,value);
  }

  
  
  public  void setAttr4Null(){
     this.set(S_Attr4,null);
  }

  public String getAttr4(){
       return DataType.getAsString(this.get(S_Attr4));
  
  }
  public String getAttr4InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Attr4));
      }

  public void initFormId(String value){
     this.initProperty(S_FormId,value);
  }
  public  void setFormId(String value){
     this.set(S_FormId,value);
  }

  
  
  public  void setFormIdNull(){
     this.set(S_FormId,null);
  }

  public String getFormId(){
       return DataType.getAsString(this.get(S_FormId));
  
  }
  public String getFormIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FormId));
      }

  public void initGroupStyle(String value){
     this.initProperty(S_GroupStyle,value);
  }
  public  void setGroupStyle(String value){
     this.set(S_GroupStyle,value);
  }

  
  
  public  void setGroupStyleNull(){
     this.set(S_GroupStyle,null);
  }

  public String getGroupStyle(){
       return DataType.getAsString(this.get(S_GroupStyle));
  
  }
  public String getGroupStyleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_GroupStyle));
      }

  public void initAttr5(String value){
     this.initProperty(S_Attr5,value);
  }
  public  void setAttr5(String value){
     this.set(S_Attr5,value);
  }

  
  
  public  void setAttr5Null(){
     this.set(S_Attr5,null);
  }

  public String getAttr5(){
       return DataType.getAsString(this.get(S_Attr5));
  
  }
  public String getAttr5InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Attr5));
      }

  public void initAttr1(String value){
     this.initProperty(S_Attr1,value);
  }
  public  void setAttr1(String value){
     this.set(S_Attr1,value);
  }

  
  
  public  void setAttr1Null(){
     this.set(S_Attr1,null);
  }

  public String getAttr1(){
       return DataType.getAsString(this.get(S_Attr1));
  
  }
  public String getAttr1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Attr1));
      }

  public void initGroupName(String value){
     this.initProperty(S_GroupName,value);
  }
  public  void setGroupName(String value){
     this.set(S_GroupName,value);
  }

  
  
  public  void setGroupNameNull(){
     this.set(S_GroupName,null);
  }

  public String getGroupName(){
       return DataType.getAsString(this.get(S_GroupName));
  
  }
  public String getGroupNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_GroupName));
      }

  public void initIsAllowStract(int value){
     this.initProperty(S_IsAllowStract,new Integer(value));
  }
  public  void setIsAllowStract(int value){
     this.set(S_IsAllowStract,new Integer(value));
  }

  public  void setIsAllowStract(Integer value){
     this.set(S_IsAllowStract,value);
  }
  
  public  Integer  getIsAllowStractAsInteger(){
     return (Integer )this.get(S_IsAllowStract);
  }
  
  
  public  void setIsAllowStractNull(){
     this.set(S_IsAllowStract,null);
  }

  public int getIsAllowStract(){
        return DataType.getAsInt(this.get(S_IsAllowStract));
  
  }
  public int getIsAllowStractInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IsAllowStract));
      }

  public void initAttr2(String value){
     this.initProperty(S_Attr2,value);
  }
  public  void setAttr2(String value){
     this.set(S_Attr2,value);
  }

  
  
  public  void setAttr2Null(){
     this.set(S_Attr2,null);
  }

  public String getAttr2(){
       return DataType.getAsString(this.get(S_Attr2));
  
  }
  public String getAttr2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Attr2));
      }

  public void initSeqNo(int value){
     this.initProperty(S_SeqNo,new Integer(value));
  }
  public  void setSeqNo(int value){
     this.set(S_SeqNo,new Integer(value));
  }

  public  void setSeqNo(Integer value){
     this.set(S_SeqNo,value);
  }
  
  public  Integer  getSeqNoAsInteger(){
     return (Integer )this.get(S_SeqNo);
  }
  
  
  public  void setSeqNoNull(){
     this.set(S_SeqNo,null);
  }

  public int getSeqNo(){
        return DataType.getAsInt(this.get(S_SeqNo));
  
  }
  public int getSeqNoInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_SeqNo));
      }


 
 }

