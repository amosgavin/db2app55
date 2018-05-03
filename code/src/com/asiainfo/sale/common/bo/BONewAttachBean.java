package com.asiainfo.sale.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.common.ivalues.*;

public class BONewAttachBean extends DataContainer implements DataContainerInterface,IBONewAttachValue{

  private static String  m_boName = "com.asiainfo.sale.common.bo.BONewAttach";



  public final static  String S_Staffname = "STAFFNAME";
  public final static  String S_OrganizeName = "ORGANIZE_NAME";
  public final static  String S_Itemid = "ITEMID";
  public final static  String S_Label = "LABEL";
  public final static  String S_UploadTime = "UPLOAD_TIME";
  public final static  String S_Filename = "FILENAME";
  public final static  String S_Attachid = "ATTACHID";
  public final static  String S_Depart = "DEPART";
  public final static  String S_Itemtype = "ITEMTYPE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BONewAttachBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initStaffname(String value){
     this.initProperty(S_Staffname,value);
  }
  public  void setStaffname(String value){
     this.set(S_Staffname,value);
  }
  public  void setStaffnameNull(){
     this.set(S_Staffname,null);
  }

  public String getStaffname(){
       return DataType.getAsString(this.get(S_Staffname));
  
  }
  public String getStaffnameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Staffname));
      }

  public void initOrganizeName(String value){
     this.initProperty(S_OrganizeName,value);
  }
  public  void setOrganizeName(String value){
     this.set(S_OrganizeName,value);
  }
  public  void setOrganizeNameNull(){
     this.set(S_OrganizeName,null);
  }

  public String getOrganizeName(){
       return DataType.getAsString(this.get(S_OrganizeName));
  
  }
  public String getOrganizeNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrganizeName));
      }

  public void initItemid(long value){
     this.initProperty(S_Itemid,new Long(value));
  }
  public  void setItemid(long value){
     this.set(S_Itemid,new Long(value));
  }
  public  void setItemidNull(){
     this.set(S_Itemid,null);
  }

  public long getItemid(){
        return DataType.getAsLong(this.get(S_Itemid));
  
  }
  public long getItemidInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Itemid));
      }

  public void initLabel(String value){
     this.initProperty(S_Label,value);
  }
  public  void setLabel(String value){
     this.set(S_Label,value);
  }
  public  void setLabelNull(){
     this.set(S_Label,null);
  }

  public String getLabel(){
       return DataType.getAsString(this.get(S_Label));
  
  }
  public String getLabelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Label));
      }

  public void initUploadTime(Timestamp value){
     this.initProperty(S_UploadTime,value);
  }
  public  void setUploadTime(Timestamp value){
     this.set(S_UploadTime,value);
  }
  public  void setUploadTimeNull(){
     this.set(S_UploadTime,null);
  }

  public Timestamp getUploadTime(){
        return DataType.getAsDateTime(this.get(S_UploadTime));
  
  }
  public Timestamp getUploadTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_UploadTime));
      }

  public void initFilename(String value){
     this.initProperty(S_Filename,value);
  }
  public  void setFilename(String value){
     this.set(S_Filename,value);
  }
  public  void setFilenameNull(){
     this.set(S_Filename,null);
  }

  public String getFilename(){
       return DataType.getAsString(this.get(S_Filename));
  
  }
  public String getFilenameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Filename));
      }

  public void initAttachid(long value){
     this.initProperty(S_Attachid,new Long(value));
  }
  public  void setAttachid(long value){
     this.set(S_Attachid,new Long(value));
  }
  public  void setAttachidNull(){
     this.set(S_Attachid,null);
  }

  public long getAttachid(){
        return DataType.getAsLong(this.get(S_Attachid));
  
  }
  public long getAttachidInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Attachid));
      }

  public void initDepart(String value){
     this.initProperty(S_Depart,value);
  }
  public  void setDepart(String value){
     this.set(S_Depart,value);
  }
  public  void setDepartNull(){
     this.set(S_Depart,null);
  }

  public String getDepart(){
       return DataType.getAsString(this.get(S_Depart));
  
  }
  public String getDepartInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Depart));
      }

  public void initItemtype(String value){
     this.initProperty(S_Itemtype,value);
  }
  public  void setItemtype(String value){
     this.set(S_Itemtype,value);
  }
  public  void setItemtypeNull(){
     this.set(S_Itemtype,null);
  }

  public String getItemtype(){
       return DataType.getAsString(this.get(S_Itemtype));
  
  }
  public String getItemtypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Itemtype));
      }


 
 }

