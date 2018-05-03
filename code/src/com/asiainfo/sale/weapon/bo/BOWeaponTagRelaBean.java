package com.asiainfo.sale.weapon.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.weapon.ivalues.*;

public class BOWeaponTagRelaBean extends DataContainer implements DataContainerInterface,IBOWeaponTagRelaValue{

  private static String  m_boName = "com.asiainfo.sale.weapon.bo.BOWeaponTagRela";



  public final static  String S_TagId = "TAG_ID";
  public final static  String S_WeaponId = "WEAPON_ID";
  public final static  String S_SaleFlag = "SALE_FLAG";
  public final static  String S_Id = "ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOWeaponTagRelaBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initTagId(String value){
     this.initProperty(S_TagId,value);
  }
  public  void setTagId(String value){
     this.set(S_TagId,value);
  }
  public  void setTagIdNull(){
     this.set(S_TagId,null);
  }

  public String getTagId(){
       return DataType.getAsString(this.get(S_TagId));
  
  }
  public String getTagIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TagId));
      }

  public void initWeaponId(String value){
     this.initProperty(S_WeaponId,value);
  }
  public  void setWeaponId(String value){
     this.set(S_WeaponId,value);
  }
  public  void setWeaponIdNull(){
     this.set(S_WeaponId,null);
  }

  public String getWeaponId(){
       return DataType.getAsString(this.get(S_WeaponId));
  
  }
  public String getWeaponIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WeaponId));
      }

  public void initSaleFlag(String value){
     this.initProperty(S_SaleFlag,value);
  }
  public  void setSaleFlag(String value){
     this.set(S_SaleFlag,value);
  }
  public  void setSaleFlagNull(){
     this.set(S_SaleFlag,null);
  }

  public String getSaleFlag(){
       return DataType.getAsString(this.get(S_SaleFlag));
  
  }
  public String getSaleFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleFlag));
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

