package com.asiainfo.sale.common.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.common.ivalues.*;

public class BOAttachBean extends DataContainer implements DataContainerInterface,IBOAttachValue{

  private static String  m_boName = "com.asiainfo.sale.common.bo.BOAttach";



  public final static  String S_Filepath = "FILEPATH";
  public final static  String S_Itemid = "ITEMID";
  public final static  String S_Savename = "SAVENAME";
  public final static  String S_ItemType = "ITEM_TYPE";
  public final static  String S_Id = "ID";
  public final static  String S_Filename = "FILENAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOAttachBean() throws AIException{
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


  public void initFilepath(String value){
     this.initProperty(S_Filepath,value);
  }
  public  void setFilepath(String value){
     this.set(S_Filepath,value);
  }
  public  void setFilepathNull(){
     this.set(S_Filepath,null);
  }

  public String getFilepath(){
       return DataType.getAsString(this.get(S_Filepath));
  
  }
  public String getFilepathInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Filepath));
      }

  public void initItemid(int value){
     this.initProperty(S_Itemid,new Integer(value));
  }
  public  void setItemid(int value){
     this.set(S_Itemid,new Integer(value));
  }
  public  void setItemidNull(){
     this.set(S_Itemid,null);
  }

  public int getItemid(){
        return DataType.getAsInt(this.get(S_Itemid));
  
  }
  public int getItemidInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Itemid));
      }

  public void initSavename(String value){
     this.initProperty(S_Savename,value);
  }
  public  void setSavename(String value){
     this.set(S_Savename,value);
  }
  public  void setSavenameNull(){
     this.set(S_Savename,null);
  }

  public String getSavename(){
       return DataType.getAsString(this.get(S_Savename));
  
  }
  public String getSavenameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Savename));
      }

  public void initItemType(String value){
     this.initProperty(S_ItemType,value);
  }
  public  void setItemType(String value){
     this.set(S_ItemType,value);
  }
  public  void setItemTypeNull(){
     this.set(S_ItemType,null);
  }

  public String getItemType(){
       return DataType.getAsString(this.get(S_ItemType));
  
  }
  public String getItemTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ItemType));
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


 
 }

