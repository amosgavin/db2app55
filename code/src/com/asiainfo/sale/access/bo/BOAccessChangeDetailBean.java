package com.asiainfo.sale.access.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.access.ivalues.*;

public class BOAccessChangeDetailBean extends DataContainer implements DataContainerInterface,IBOAccessChangeDetailValue{

  private static String  m_boName = "com.asiainfo.sale.access.bo.BOAccessChangeDetail";



  public final static  String S_Remark = "REMARK";
  public final static  String S_RwName = "RW_NAME";
  public final static  String S_RwId = "RW_ID";
  public final static  String S_AccessId = "ACCESS_ID";
  public final static  String S_YxPcName = "YX_PC_NAME";
  public final static  String S_YxPcCode = "YX_PC_CODE";
  public final static  String S_YxDcName = "YX_DC_NAME";
  public final static  String S_Id = "ID";
  public final static  String S_YxDcCode = "YX_DC_CODE";
  public final static  String S_ZfName = "ZF_NAME";
  public final static  String S_ZfId = "ZF_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOAccessChangeDetailBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initRwName(String value){
     this.initProperty(S_RwName,value);
  }
  public  void setRwName(String value){
     this.set(S_RwName,value);
  }
  public  void setRwNameNull(){
     this.set(S_RwName,null);
  }

  public String getRwName(){
       return DataType.getAsString(this.get(S_RwName));
  
  }
  public String getRwNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RwName));
      }

  public void initRwId(String value){
     this.initProperty(S_RwId,value);
  }
  public  void setRwId(String value){
     this.set(S_RwId,value);
  }
  public  void setRwIdNull(){
     this.set(S_RwId,null);
  }

  public String getRwId(){
       return DataType.getAsString(this.get(S_RwId));
  
  }
  public String getRwIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RwId));
      }

  public void initAccessId(long value){
     this.initProperty(S_AccessId,new Long(value));
  }
  public  void setAccessId(long value){
     this.set(S_AccessId,new Long(value));
  }
  public  void setAccessIdNull(){
     this.set(S_AccessId,null);
  }

  public long getAccessId(){
        return DataType.getAsLong(this.get(S_AccessId));
  
  }
  public long getAccessIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AccessId));
      }

  public void initYxPcName(String value){
     this.initProperty(S_YxPcName,value);
  }
  public  void setYxPcName(String value){
     this.set(S_YxPcName,value);
  }
  public  void setYxPcNameNull(){
     this.set(S_YxPcName,null);
  }

  public String getYxPcName(){
       return DataType.getAsString(this.get(S_YxPcName));
  
  }
  public String getYxPcNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_YxPcName));
      }

  public void initYxPcCode(String value){
     this.initProperty(S_YxPcCode,value);
  }
  public  void setYxPcCode(String value){
     this.set(S_YxPcCode,value);
  }
  public  void setYxPcCodeNull(){
     this.set(S_YxPcCode,null);
  }

  public String getYxPcCode(){
       return DataType.getAsString(this.get(S_YxPcCode));
  
  }
  public String getYxPcCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_YxPcCode));
      }

  public void initYxDcName(String value){
     this.initProperty(S_YxDcName,value);
  }
  public  void setYxDcName(String value){
     this.set(S_YxDcName,value);
  }
  public  void setYxDcNameNull(){
     this.set(S_YxDcName,null);
  }

  public String getYxDcName(){
       return DataType.getAsString(this.get(S_YxDcName));
  
  }
  public String getYxDcNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_YxDcName));
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

  public void initYxDcCode(String value){
     this.initProperty(S_YxDcCode,value);
  }
  public  void setYxDcCode(String value){
     this.set(S_YxDcCode,value);
  }
  public  void setYxDcCodeNull(){
     this.set(S_YxDcCode,null);
  }

  public String getYxDcCode(){
       return DataType.getAsString(this.get(S_YxDcCode));
  
  }
  public String getYxDcCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_YxDcCode));
      }

  public void initZfName(String value){
     this.initProperty(S_ZfName,value);
  }
  public  void setZfName(String value){
     this.set(S_ZfName,value);
  }
  public  void setZfNameNull(){
     this.set(S_ZfName,null);
  }

  public String getZfName(){
       return DataType.getAsString(this.get(S_ZfName));
  
  }
  public String getZfNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ZfName));
      }

  public void initZfId(String value){
     this.initProperty(S_ZfId,value);
  }
  public  void setZfId(String value){
     this.set(S_ZfId,value);
  }
  public  void setZfIdNull(){
     this.set(S_ZfId,null);
  }

  public String getZfId(){
       return DataType.getAsString(this.get(S_ZfId));
  
  }
  public String getZfIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ZfId));
      }


 
 }

