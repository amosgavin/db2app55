package com.asiainfo.sale.activity.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.activity.ivalues.*;

public class BOSaleCustGroupBean extends DataContainer implements DataContainerInterface,IBOSaleCustGroupValue{

  private static String  m_boName = "com.asiainfo.sale.activity.bo.BOSaleCustGroup";



  public final static  String S_ActiveTempletId = "ACTIVE_TEMPLET_ID";
  public final static  String S_CustGroupDesc = "CUST_GROUP_DESC";
  public final static  String S_CustGroupAccessToken = "CUST_GROUP_ACCESS_TOKEN";
  public final static  String S_CityId = "CITY_ID";
  public final static  String S_CustGroupTabName = "CUST_GROUP_TAB_NAME";
  public final static  String S_CustGroupType = "CUST_GROUP_TYPE";
  public final static  String S_CustGroupSourceId = "CUST_GROUP_SOURCE_ID";
  public final static  String S_CustGroupName = "CUST_GROUP_NAME";
  public final static  String S_CustTypeId = "CUST_TYPE_ID";
  public final static  String S_CustTypeSystem = "CUST_TYPE_SYSTEM";
  public final static  String S_CreateUserId = "CREATE_USER_ID";
  public final static  String S_CustGroupStatus = "CUST_GROUP_STATUS";
  public final static  String S_CustGroupTag = "CUST_GROUP_TAG";
  public final static  String S_SelectSql = "SELECT_SQL";
  public final static  String S_CustGroupNum = "CUST_GROUP_NUM";
  public final static  String S_CustFrequency = "CUST_FREQUENCY";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_CustBaseMonth = "CUST_BASE_MONTH";
  public final static  String S_CustGroupId = "CUST_GROUP_ID";
  public final static  String S_CustBaseDay = "CUST_BASE_DAY";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_Ext4 = "EXT4";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOSaleCustGroupBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initActiveTempletId(String value){
     this.initProperty(S_ActiveTempletId,value);
  }
  public  void setActiveTempletId(String value){
     this.set(S_ActiveTempletId,value);
  }
  public  void setActiveTempletIdNull(){
     this.set(S_ActiveTempletId,null);
  }

  public String getActiveTempletId(){
       return DataType.getAsString(this.get(S_ActiveTempletId));
  
  }
  public String getActiveTempletIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ActiveTempletId));
      }

  public void initCustGroupDesc(String value){
     this.initProperty(S_CustGroupDesc,value);
  }
  public  void setCustGroupDesc(String value){
     this.set(S_CustGroupDesc,value);
  }
  public  void setCustGroupDescNull(){
     this.set(S_CustGroupDesc,null);
  }

  public String getCustGroupDesc(){
       return DataType.getAsString(this.get(S_CustGroupDesc));
  
  }
  public String getCustGroupDescInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CustGroupDesc));
      }

  public void initCustGroupAccessToken(int value){
     this.initProperty(S_CustGroupAccessToken,new Integer(value));
  }
  public  void setCustGroupAccessToken(int value){
     this.set(S_CustGroupAccessToken,new Integer(value));
  }
  public  void setCustGroupAccessTokenNull(){
     this.set(S_CustGroupAccessToken,null);
  }

  public int getCustGroupAccessToken(){
        return DataType.getAsInt(this.get(S_CustGroupAccessToken));
  
  }
  public int getCustGroupAccessTokenInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_CustGroupAccessToken));
      }

  public void initCityId(String value){
     this.initProperty(S_CityId,value);
  }
  public  void setCityId(String value){
     this.set(S_CityId,value);
  }
  public  void setCityIdNull(){
     this.set(S_CityId,null);
  }

  public String getCityId(){
       return DataType.getAsString(this.get(S_CityId));
  
  }
  public String getCityIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CityId));
      }

  public void initCustGroupTabName(String value){
     this.initProperty(S_CustGroupTabName,value);
  }
  public  void setCustGroupTabName(String value){
     this.set(S_CustGroupTabName,value);
  }
  public  void setCustGroupTabNameNull(){
     this.set(S_CustGroupTabName,null);
  }

  public String getCustGroupTabName(){
       return DataType.getAsString(this.get(S_CustGroupTabName));
  
  }
  public String getCustGroupTabNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CustGroupTabName));
      }

  public void initCustGroupType(int value){
     this.initProperty(S_CustGroupType,new Integer(value));
  }
  public  void setCustGroupType(int value){
     this.set(S_CustGroupType,new Integer(value));
  }
  public  void setCustGroupTypeNull(){
     this.set(S_CustGroupType,null);
  }

  public int getCustGroupType(){
        return DataType.getAsInt(this.get(S_CustGroupType));
  
  }
  public int getCustGroupTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_CustGroupType));
      }

  public void initCustGroupSourceId(String value){
     this.initProperty(S_CustGroupSourceId,value);
  }
  public  void setCustGroupSourceId(String value){
     this.set(S_CustGroupSourceId,value);
  }
  public  void setCustGroupSourceIdNull(){
     this.set(S_CustGroupSourceId,null);
  }

  public String getCustGroupSourceId(){
       return DataType.getAsString(this.get(S_CustGroupSourceId));
  
  }
  public String getCustGroupSourceIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CustGroupSourceId));
      }

  public void initCustGroupName(String value){
     this.initProperty(S_CustGroupName,value);
  }
  public  void setCustGroupName(String value){
     this.set(S_CustGroupName,value);
  }
  public  void setCustGroupNameNull(){
     this.set(S_CustGroupName,null);
  }

  public String getCustGroupName(){
       return DataType.getAsString(this.get(S_CustGroupName));
  
  }
  public String getCustGroupNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CustGroupName));
      }

  public void initCustTypeId(int value){
     this.initProperty(S_CustTypeId,new Integer(value));
  }
  public  void setCustTypeId(int value){
     this.set(S_CustTypeId,new Integer(value));
  }
  public  void setCustTypeIdNull(){
     this.set(S_CustTypeId,null);
  }

  public int getCustTypeId(){
        return DataType.getAsInt(this.get(S_CustTypeId));
  
  }
  public int getCustTypeIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_CustTypeId));
      }

  public void initCustTypeSystem(String value){
     this.initProperty(S_CustTypeSystem,value);
  }
  public  void setCustTypeSystem(String value){
     this.set(S_CustTypeSystem,value);
  }
  public  void setCustTypeSystemNull(){
     this.set(S_CustTypeSystem,null);
  }

  public String getCustTypeSystem(){
       return DataType.getAsString(this.get(S_CustTypeSystem));
  
  }
  public String getCustTypeSystemInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CustTypeSystem));
      }

  public void initCreateUserId(String value){
     this.initProperty(S_CreateUserId,value);
  }
  public  void setCreateUserId(String value){
     this.set(S_CreateUserId,value);
  }
  public  void setCreateUserIdNull(){
     this.set(S_CreateUserId,null);
  }

  public String getCreateUserId(){
       return DataType.getAsString(this.get(S_CreateUserId));
  
  }
  public String getCreateUserIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CreateUserId));
      }

  public void initCustGroupStatus(int value){
     this.initProperty(S_CustGroupStatus,new Integer(value));
  }
  public  void setCustGroupStatus(int value){
     this.set(S_CustGroupStatus,new Integer(value));
  }
  public  void setCustGroupStatusNull(){
     this.set(S_CustGroupStatus,null);
  }

  public int getCustGroupStatus(){
        return DataType.getAsInt(this.get(S_CustGroupStatus));
  
  }
  public int getCustGroupStatusInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_CustGroupStatus));
      }

  public void initCustGroupTag(String value){
     this.initProperty(S_CustGroupTag,value);
  }
  public  void setCustGroupTag(String value){
     this.set(S_CustGroupTag,value);
  }
  public  void setCustGroupTagNull(){
     this.set(S_CustGroupTag,null);
  }

  public String getCustGroupTag(){
       return DataType.getAsString(this.get(S_CustGroupTag));
  
  }
  public String getCustGroupTagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CustGroupTag));
      }

  public void initSelectSql(String value){
     this.initProperty(S_SelectSql,value);
  }
  public  void setSelectSql(String value){
     this.set(S_SelectSql,value);
  }
  public  void setSelectSqlNull(){
     this.set(S_SelectSql,null);
  }

  public String getSelectSql(){
       return DataType.getAsString(this.get(S_SelectSql));
  
  }
  public String getSelectSqlInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SelectSql));
      }

  public void initCustGroupNum(int value){
     this.initProperty(S_CustGroupNum,new Integer(value));
  }
  public  void setCustGroupNum(int value){
     this.set(S_CustGroupNum,new Integer(value));
  }
  public  void setCustGroupNumNull(){
     this.set(S_CustGroupNum,null);
  }

  public int getCustGroupNum(){
        return DataType.getAsInt(this.get(S_CustGroupNum));
  
  }
  public int getCustGroupNumInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_CustGroupNum));
      }

  public void initCustFrequency(String value){
     this.initProperty(S_CustFrequency,value);
  }
  public  void setCustFrequency(String value){
     this.set(S_CustFrequency,value);
  }
  public  void setCustFrequencyNull(){
     this.set(S_CustFrequency,null);
  }

  public String getCustFrequency(){
       return DataType.getAsString(this.get(S_CustFrequency));
  
  }
  public String getCustFrequencyInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CustFrequency));
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

  public void initCustBaseMonth(String value){
     this.initProperty(S_CustBaseMonth,value);
  }
  public  void setCustBaseMonth(String value){
     this.set(S_CustBaseMonth,value);
  }
  public  void setCustBaseMonthNull(){
     this.set(S_CustBaseMonth,null);
  }

  public String getCustBaseMonth(){
       return DataType.getAsString(this.get(S_CustBaseMonth));
  
  }
  public String getCustBaseMonthInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CustBaseMonth));
      }

  public void initCustGroupId(String value){
     this.initProperty(S_CustGroupId,value);
  }
  public  void setCustGroupId(String value){
     this.set(S_CustGroupId,value);
  }
  public  void setCustGroupIdNull(){
     this.set(S_CustGroupId,null);
  }

  public String getCustGroupId(){
       return DataType.getAsString(this.get(S_CustGroupId));
  
  }
  public String getCustGroupIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CustGroupId));
      }

  public void initCustBaseDay(String value){
     this.initProperty(S_CustBaseDay,value);
  }
  public  void setCustBaseDay(String value){
     this.set(S_CustBaseDay,value);
  }
  public  void setCustBaseDayNull(){
     this.set(S_CustBaseDay,null);
  }

  public String getCustBaseDay(){
       return DataType.getAsString(this.get(S_CustBaseDay));
  
  }
  public String getCustBaseDayInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CustBaseDay));
      }

  public void initCreateDate(String value){
     this.initProperty(S_CreateDate,value);
  }
  public  void setCreateDate(String value){
     this.set(S_CreateDate,value);
  }
  public  void setCreateDateNull(){
     this.set(S_CreateDate,null);
  }

  public String getCreateDate(){
       return DataType.getAsString(this.get(S_CreateDate));
  
  }
  public String getCreateDateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CreateDate));
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


 
 }

