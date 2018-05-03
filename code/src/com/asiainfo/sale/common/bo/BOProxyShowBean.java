package com.asiainfo.sale.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.common.ivalues.*;

public class BOProxyShowBean extends DataContainer implements DataContainerInterface,IBOProxyShowValue{

  private static String  m_boName = "com.asiainfo.sale.common.bo.BOProxyShow";



  public final static  String S_ProxyDate = "PROXY_DATE";
  public final static  String S_State = "STATE";
  public final static  String S_AuthorOrganizeNameP = "AUTHOR_ORGANIZE_NAME_P";
  public final static  String S_ModifyTime = "MODIFY_TIME";
  public final static  String S_CreateStaffId = "CREATE_STAFF_ID";
  public final static  String S_Remark = "REMARK";
  public final static  String S_ProxyStaffId = "PROXY_STAFF_ID";
  public final static  String S_MFlag = "M_FLAG";
  public final static  String S_ProxyName = "PROXY_NAME";
  public final static  String S_ProxyOrganizeName = "PROXY_ORGANIZE_NAME";
  public final static  String S_AuthorStaffId = "AUTHOR_STAFF_ID";
  public final static  String S_AuthorName = "AUTHOR_NAME";
  public final static  String S_Id = "ID";
  public final static  String S_ProxyOrganizeNameP = "PROXY_ORGANIZE_NAME_P";
  public final static  String S_AuthorOrganizeName = "AUTHOR_ORGANIZE_NAME";
  public final static  String S_ParentId = "PARENT_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOProxyShowBean() throws AIException{
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


  public void initProxyDate(Timestamp value){
     this.initProperty(S_ProxyDate,value);
  }
  public  void setProxyDate(Timestamp value){
     this.set(S_ProxyDate,value);
  }
  public  void setProxyDateNull(){
     this.set(S_ProxyDate,null);
  }

  public Timestamp getProxyDate(){
        return DataType.getAsDateTime(this.get(S_ProxyDate));
  
  }
  public Timestamp getProxyDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ProxyDate));
      }

  public void initState(String value){
     this.initProperty(S_State,value);
  }
  public  void setState(String value){
     this.set(S_State,value);
  }
  public  void setStateNull(){
     this.set(S_State,null);
  }

  public String getState(){
       return DataType.getAsString(this.get(S_State));
  
  }
  public String getStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_State));
      }

  public void initAuthorOrganizeNameP(String value){
     this.initProperty(S_AuthorOrganizeNameP,value);
  }
  public  void setAuthorOrganizeNameP(String value){
     this.set(S_AuthorOrganizeNameP,value);
  }
  public  void setAuthorOrganizeNamePNull(){
     this.set(S_AuthorOrganizeNameP,null);
  }

  public String getAuthorOrganizeNameP(){
       return DataType.getAsString(this.get(S_AuthorOrganizeNameP));
  
  }
  public String getAuthorOrganizeNamePInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AuthorOrganizeNameP));
      }

  public void initModifyTime(Timestamp value){
     this.initProperty(S_ModifyTime,value);
  }
  public  void setModifyTime(Timestamp value){
     this.set(S_ModifyTime,value);
  }
  public  void setModifyTimeNull(){
     this.set(S_ModifyTime,null);
  }

  public Timestamp getModifyTime(){
        return DataType.getAsDateTime(this.get(S_ModifyTime));
  
  }
  public Timestamp getModifyTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ModifyTime));
      }

  public void initCreateStaffId(String value){
     this.initProperty(S_CreateStaffId,value);
  }
  public  void setCreateStaffId(String value){
     this.set(S_CreateStaffId,value);
  }
  public  void setCreateStaffIdNull(){
     this.set(S_CreateStaffId,null);
  }

  public String getCreateStaffId(){
       return DataType.getAsString(this.get(S_CreateStaffId));
  
  }
  public String getCreateStaffIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CreateStaffId));
      }

  public void initRemark(String value){
     this.initProperty(S_Remark,value);
  }
  public  void setRemark(String value){
     this.set(S_Remark,value);
  }
  public  void setRemarkNull(){
     this.set(S_Remark,null);
  }

  public String getRemark(){
       return DataType.getAsString(this.get(S_Remark));
  
  }
  public String getRemarkInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark));
      }

  public void initProxyStaffId(String value){
     this.initProperty(S_ProxyStaffId,value);
  }
  public  void setProxyStaffId(String value){
     this.set(S_ProxyStaffId,value);
  }
  public  void setProxyStaffIdNull(){
     this.set(S_ProxyStaffId,null);
  }

  public String getProxyStaffId(){
       return DataType.getAsString(this.get(S_ProxyStaffId));
  
  }
  public String getProxyStaffIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProxyStaffId));
      }

  public void initMFlag(String value){
     this.initProperty(S_MFlag,value);
  }
  public  void setMFlag(String value){
     this.set(S_MFlag,value);
  }
  public  void setMFlagNull(){
     this.set(S_MFlag,null);
  }

  public String getMFlag(){
       return DataType.getAsString(this.get(S_MFlag));
  
  }
  public String getMFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MFlag));
      }

  public void initProxyName(String value){
     this.initProperty(S_ProxyName,value);
  }
  public  void setProxyName(String value){
     this.set(S_ProxyName,value);
  }
  public  void setProxyNameNull(){
     this.set(S_ProxyName,null);
  }

  public String getProxyName(){
       return DataType.getAsString(this.get(S_ProxyName));
  
  }
  public String getProxyNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProxyName));
      }

  public void initProxyOrganizeName(String value){
     this.initProperty(S_ProxyOrganizeName,value);
  }
  public  void setProxyOrganizeName(String value){
     this.set(S_ProxyOrganizeName,value);
  }
  public  void setProxyOrganizeNameNull(){
     this.set(S_ProxyOrganizeName,null);
  }

  public String getProxyOrganizeName(){
       return DataType.getAsString(this.get(S_ProxyOrganizeName));
  
  }
  public String getProxyOrganizeNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProxyOrganizeName));
      }

  public void initAuthorStaffId(String value){
     this.initProperty(S_AuthorStaffId,value);
  }
  public  void setAuthorStaffId(String value){
     this.set(S_AuthorStaffId,value);
  }
  public  void setAuthorStaffIdNull(){
     this.set(S_AuthorStaffId,null);
  }

  public String getAuthorStaffId(){
       return DataType.getAsString(this.get(S_AuthorStaffId));
  
  }
  public String getAuthorStaffIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AuthorStaffId));
      }

  public void initAuthorName(String value){
     this.initProperty(S_AuthorName,value);
  }
  public  void setAuthorName(String value){
     this.set(S_AuthorName,value);
  }
  public  void setAuthorNameNull(){
     this.set(S_AuthorName,null);
  }

  public String getAuthorName(){
       return DataType.getAsString(this.get(S_AuthorName));
  
  }
  public String getAuthorNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AuthorName));
      }

  public void initId(long value){
     this.initProperty(S_Id,new Long(value));
  }
  public  void setId(long value){
     this.set(S_Id,new Long(value));
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public long getId(){
        return DataType.getAsLong(this.get(S_Id));
  
  }
  public long getIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Id));
      }

  public void initProxyOrganizeNameP(String value){
     this.initProperty(S_ProxyOrganizeNameP,value);
  }
  public  void setProxyOrganizeNameP(String value){
     this.set(S_ProxyOrganizeNameP,value);
  }
  public  void setProxyOrganizeNamePNull(){
     this.set(S_ProxyOrganizeNameP,null);
  }

  public String getProxyOrganizeNameP(){
       return DataType.getAsString(this.get(S_ProxyOrganizeNameP));
  
  }
  public String getProxyOrganizeNamePInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProxyOrganizeNameP));
      }

  public void initAuthorOrganizeName(String value){
     this.initProperty(S_AuthorOrganizeName,value);
  }
  public  void setAuthorOrganizeName(String value){
     this.set(S_AuthorOrganizeName,value);
  }
  public  void setAuthorOrganizeNameNull(){
     this.set(S_AuthorOrganizeName,null);
  }

  public String getAuthorOrganizeName(){
       return DataType.getAsString(this.get(S_AuthorOrganizeName));
  
  }
  public String getAuthorOrganizeNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AuthorOrganizeName));
      }

  public void initParentId(long value){
     this.initProperty(S_ParentId,new Long(value));
  }
  public  void setParentId(long value){
     this.set(S_ParentId,new Long(value));
  }
  public  void setParentIdNull(){
     this.set(S_ParentId,null);
  }

  public long getParentId(){
        return DataType.getAsLong(this.get(S_ParentId));
  
  }
  public long getParentIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ParentId));
      }


 
 }

