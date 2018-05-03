package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class QModuleMenuRelateBean extends DataContainer implements DataContainerInterface,IQModuleMenuRelateValue{

  private static String  m_boName = "com.ai.bce.bo.QModuleMenuRelate";



  public final static  String S_State = "STATE";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_MenuName = "MENU_NAME";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_MenuUrl = "MENU_URL";
  public final static  String S_Ext4 = "EXT4";
  public final static  String S_MenuLevel = "MENU_LEVEL";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_PageTitle = "PAGE_TITLE";
  public final static  String S_MenuId = "MENU_ID";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_MenuIcon = "MENU_ICON";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QModuleMenuRelateBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("Cannot reset ObjectType");
 }


  public void initState(long value){
     this.initProperty(S_State,new Long(value));
  }
  public  void setState(long value){
     this.set(S_State,new Long(value));
  }

  public  void setState(Long value){
     this.set(S_State,value);
  }
  
  public  Long  getStateAsLong(){
     return (Long )this.get(S_State);
  }
  
  
  public  void setStateNull(){
     this.set(S_State,null);
  }

  public long getState(){
        return DataType.getAsLong(this.get(S_State));
  
  }
  public long getStateInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_State));
      }

  public void initExt3(String value){
     this.initProperty(S_Ext3,value);
  }
  public  void setExt3(String value){
     this.set(S_Ext3,value);
  }

  
  
  public  void setExt3Null(){
     this.set(S_Ext3,null);
  }

  public String getExt3(){
       return DataType.getAsString(this.get(S_Ext3));
  
  }
  public String getExt3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext3));
      }

  public void initMenuName(String value){
     this.initProperty(S_MenuName,value);
  }
  public  void setMenuName(String value){
     this.set(S_MenuName,value);
  }

  
  
  public  void setMenuNameNull(){
     this.set(S_MenuName,null);
  }

  public String getMenuName(){
       return DataType.getAsString(this.get(S_MenuName));
  
  }
  public String getMenuNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MenuName));
      }

  public void initExt5(String value){
     this.initProperty(S_Ext5,value);
  }
  public  void setExt5(String value){
     this.set(S_Ext5,value);
  }

  
  
  public  void setExt5Null(){
     this.set(S_Ext5,null);
  }

  public String getExt5(){
       return DataType.getAsString(this.get(S_Ext5));
  
  }
  public String getExt5InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext5));
      }

  public void initMenuUrl(String value){
     this.initProperty(S_MenuUrl,value);
  }
  public  void setMenuUrl(String value){
     this.set(S_MenuUrl,value);
  }

  
  
  public  void setMenuUrlNull(){
     this.set(S_MenuUrl,null);
  }

  public String getMenuUrl(){
       return DataType.getAsString(this.get(S_MenuUrl));
  
  }
  public String getMenuUrlInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MenuUrl));
      }

  public void initExt4(String value){
     this.initProperty(S_Ext4,value);
  }
  public  void setExt4(String value){
     this.set(S_Ext4,value);
  }

  
  
  public  void setExt4Null(){
     this.set(S_Ext4,null);
  }

  public String getExt4(){
       return DataType.getAsString(this.get(S_Ext4));
  
  }
  public String getExt4InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext4));
      }

  public void initMenuLevel(long value){
     this.initProperty(S_MenuLevel,new Long(value));
  }
  public  void setMenuLevel(long value){
     this.set(S_MenuLevel,new Long(value));
  }

  public  void setMenuLevel(Long value){
     this.set(S_MenuLevel,value);
  }
  
  public  Long  getMenuLevelAsLong(){
     return (Long )this.get(S_MenuLevel);
  }
  
  
  public  void setMenuLevelNull(){
     this.set(S_MenuLevel,null);
  }

  public long getMenuLevel(){
        return DataType.getAsLong(this.get(S_MenuLevel));
  
  }
  public long getMenuLevelInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_MenuLevel));
      }

  public void initExt2(String value){
     this.initProperty(S_Ext2,value);
  }
  public  void setExt2(String value){
     this.set(S_Ext2,value);
  }

  
  
  public  void setExt2Null(){
     this.set(S_Ext2,null);
  }

  public String getExt2(){
       return DataType.getAsString(this.get(S_Ext2));
  
  }
  public String getExt2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext2));
      }

  public void initPageTitle(String value){
     this.initProperty(S_PageTitle,value);
  }
  public  void setPageTitle(String value){
     this.set(S_PageTitle,value);
  }

  
  
  public  void setPageTitleNull(){
     this.set(S_PageTitle,null);
  }

  public String getPageTitle(){
       return DataType.getAsString(this.get(S_PageTitle));
  
  }
  public String getPageTitleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PageTitle));
      }

  public void initMenuId(long value){
     this.initProperty(S_MenuId,new Long(value));
  }
  public  void setMenuId(long value){
     this.set(S_MenuId,new Long(value));
  }

  public  void setMenuId(Long value){
     this.set(S_MenuId,value);
  }
  
  public  Long  getMenuIdAsLong(){
     return (Long )this.get(S_MenuId);
  }
  
  
  public  void setMenuIdNull(){
     this.set(S_MenuId,null);
  }

  public long getMenuId(){
        return DataType.getAsLong(this.get(S_MenuId));
  
  }
  public long getMenuIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_MenuId));
      }

  public void initExt1(String value){
     this.initProperty(S_Ext1,value);
  }
  public  void setExt1(String value){
     this.set(S_Ext1,value);
  }

  
  
  public  void setExt1Null(){
     this.set(S_Ext1,null);
  }

  public String getExt1(){
       return DataType.getAsString(this.get(S_Ext1));
  
  }
  public String getExt1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext1));
      }

  public void initMenuIcon(String value){
     this.initProperty(S_MenuIcon,value);
  }
  public  void setMenuIcon(String value){
     this.set(S_MenuIcon,value);
  }

  
  
  public  void setMenuIconNull(){
     this.set(S_MenuIcon,null);
  }

  public String getMenuIcon(){
       return DataType.getAsString(this.get(S_MenuIcon));
  
  }
  public String getMenuIconInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MenuIcon));
      }


 
 }

