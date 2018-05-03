package com.ai.bce.plugin.autoTable.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.plugin.autoTable.ivalues.*;

public class BceTagPAutotableBean extends DataContainer implements DataContainerInterface,IBceTagPAutotableValue{

  private static String  m_boName = "com.ai.bce.plugin.autoTable.bo.BceTagPAutotable";



  public final static  String S_State = "STATE";
  public final static  String S_AutotableId = "AUTOTABLE_ID";
  public final static  String S_Height = "HEIGHT";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_ObjectId = "OBJECT_ID";
  public final static  String S_Name = "NAME";
  public final static  String S_Align = "ALIGN";
  public final static  String S_Width = "WIDTH";
  public final static  String S_Border = "BORDER";
  public final static  String S_TId = "T_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceTagPAutotableBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //Cannot reset ObjectType
   throw new AIException("Cannot reset ObjectType");
 }


  public void initState(int value){
     this.initProperty(S_State,new Integer(value));
  }
  public  void setState(int value){
     this.set(S_State,new Integer(value));
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

  public void initAutotableId(long value){
     this.initProperty(S_AutotableId,new Long(value));
  }
  public  void setAutotableId(long value){
     this.set(S_AutotableId,new Long(value));
  }
  public  void setAutotableIdNull(){
     this.set(S_AutotableId,null);
  }

  public long getAutotableId(){
        return DataType.getAsLong(this.get(S_AutotableId));
  
  }
  public long getAutotableIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AutotableId));
      }

  public void initHeight(String value){
     this.initProperty(S_Height,value);
  }
  public  void setHeight(String value){
     this.set(S_Height,value);
  }
  public  void setHeightNull(){
     this.set(S_Height,null);
  }

  public String getHeight(){
       return DataType.getAsString(this.get(S_Height));
  
  }
  public String getHeightInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Height));
      }

  public void initRemarks(String value){
     this.initProperty(S_Remarks,value);
  }
  public  void setRemarks(String value){
     this.set(S_Remarks,value);
  }
  public  void setRemarksNull(){
     this.set(S_Remarks,null);
  }

  public String getRemarks(){
       return DataType.getAsString(this.get(S_Remarks));
  
  }
  public String getRemarksInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remarks));
      }

  public void initObjectId(long value){
     this.initProperty(S_ObjectId,new Long(value));
  }
  public  void setObjectId(long value){
     this.set(S_ObjectId,new Long(value));
  }
  public  void setObjectIdNull(){
     this.set(S_ObjectId,null);
  }

  public long getObjectId(){
        return DataType.getAsLong(this.get(S_ObjectId));
  
  }
  public long getObjectIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ObjectId));
      }

  public void initName(String value){
     this.initProperty(S_Name,value);
  }
  public  void setName(String value){
     this.set(S_Name,value);
  }
  public  void setNameNull(){
     this.set(S_Name,null);
  }

  public String getName(){
       return DataType.getAsString(this.get(S_Name));
  
  }
  public String getNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Name));
      }

  public void initAlign(String value){
     this.initProperty(S_Align,value);
  }
  public  void setAlign(String value){
     this.set(S_Align,value);
  }
  public  void setAlignNull(){
     this.set(S_Align,null);
  }

  public String getAlign(){
       return DataType.getAsString(this.get(S_Align));
  
  }
  public String getAlignInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Align));
      }

  public void initWidth(String value){
     this.initProperty(S_Width,value);
  }
  public  void setWidth(String value){
     this.set(S_Width,value);
  }
  public  void setWidthNull(){
     this.set(S_Width,null);
  }

  public String getWidth(){
       return DataType.getAsString(this.get(S_Width));
  
  }
  public String getWidthInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Width));
      }

  public void initBorder(String value){
     this.initProperty(S_Border,value);
  }
  public  void setBorder(String value){
     this.set(S_Border,value);
  }
  public  void setBorderNull(){
     this.set(S_Border,null);
  }

  public String getBorder(){
       return DataType.getAsString(this.get(S_Border));
  
  }
  public String getBorderInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Border));
      }

  public void initTId(String value){
     this.initProperty(S_TId,value);
  }
  public  void setTId(String value){
     this.set(S_TId,value);
  }
  public  void setTIdNull(){
     this.set(S_TId,null);
  }

  public String getTId(){
       return DataType.getAsString(this.get(S_TId));
  
  }
  public String getTIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TId));
      }


 
 }

