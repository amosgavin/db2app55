package com.asiainfo.sale.product.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.product.ivalues.*;

public class BOSaleDetailExtQBean extends DataContainer implements DataContainerInterface,IBOSaleDetailExtQValue{

  private static String  m_boName = "com.asiainfo.sale.product.bo.BOSaleDetailExtQ";



  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_SaleActiveCode = "SALE_ACTIVE_CODE";
  public final static  String S_DetailId = "DETAIL_ID";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_SaleId = "SALE_ID";
  public final static  String S_Ext9 = "EXT9";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_Ext6 = "EXT6";
  public final static  String S_Ext7 = "EXT7";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Ext8 = "EXT8";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_Ext4 = "EXT4";
  public final static  String S_Ext31 = "EXT31";
  public final static  String S_Ext20 = "EXT20";
  public final static  String S_Ext30 = "EXT30";
  public final static  String S_ModifyTime = "MODIFY_TIME";
  public final static  String S_BossId = "BOSS_ID";
  public final static  String S_Status = "STATUS";
  public final static  String S_Market = "MARKET";
  public final static  String S_Ext19 = "EXT19";
  public final static  String S_Ext29 = "EXT29";
  public final static  String S_Ext18 = "EXT18";
  public final static  String S_Ext27 = "EXT27";
  public final static  String S_Ext17 = "EXT17";
  public final static  String S_Ext28 = "EXT28";
  public final static  String S_Ext16 = "EXT16";
  public final static  String S_Ext25 = "EXT25";
  public final static  String S_Ext15 = "EXT15";
  public final static  String S_Ext26 = "EXT26";
  public final static  String S_Ext14 = "EXT14";
  public final static  String S_Ext23 = "EXT23";
  public final static  String S_Ext13 = "EXT13";
  public final static  String S_EId = "E_ID";
  public final static  String S_Ext24 = "EXT24";
  public final static  String S_Ext12 = "EXT12";
  public final static  String S_Ext21 = "EXT21";
  public final static  String S_Ext11 = "EXT11";
  public final static  String S_Ext22 = "EXT22";
  public final static  String S_Ext10 = "EXT10";
  public final static  String S_Ext40 = "EXT40";
  public final static  String S_SaleActiveName = "SALE_ACTIVE_NAME";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_FDetailId = "F_DETAIL_ID";
  public final static  String S_LevelCode = "LEVEL_CODE";
  public final static  String S_SaleFlag = "SALE_FLAG";
  public final static  String S_Ext36 = "EXT36";
  public final static  String S_Ext37 = "EXT37";
  public final static  String S_Ext38 = "EXT38";
  public final static  String S_Ext39 = "EXT39";
  public final static  String S_Ext32 = "EXT32";
  public final static  String S_Ext33 = "EXT33";
  public final static  String S_IsSendSms = "IS_SEND_SMS";
  public final static  String S_Ext34 = "EXT34";
  public final static  String S_Ext35 = "EXT35";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOSaleDetailExtQBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initCreateTime(Timestamp value){
     this.initProperty(S_CreateTime,value);
  }
  public  void setCreateTime(Timestamp value){
     this.set(S_CreateTime,value);
  }
  public  void setCreateTimeNull(){
     this.set(S_CreateTime,null);
  }

  public Timestamp getCreateTime(){
        return DataType.getAsDateTime(this.get(S_CreateTime));
  
  }
  public Timestamp getCreateTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CreateTime));
      }

  public void initSaleActiveCode(String value){
     this.initProperty(S_SaleActiveCode,value);
  }
  public  void setSaleActiveCode(String value){
     this.set(S_SaleActiveCode,value);
  }
  public  void setSaleActiveCodeNull(){
     this.set(S_SaleActiveCode,null);
  }

  public String getSaleActiveCode(){
       return DataType.getAsString(this.get(S_SaleActiveCode));
  
  }
  public String getSaleActiveCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleActiveCode));
      }

  public void initDetailId(String value){
     this.initProperty(S_DetailId,value);
  }
  public  void setDetailId(String value){
     this.set(S_DetailId,value);
  }
  public  void setDetailIdNull(){
     this.set(S_DetailId,null);
  }

  public String getDetailId(){
       return DataType.getAsString(this.get(S_DetailId));
  
  }
  public String getDetailIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DetailId));
      }

  public void initModifyDate(Timestamp value){
     this.initProperty(S_ModifyDate,value);
  }
  public  void setModifyDate(Timestamp value){
     this.set(S_ModifyDate,value);
  }
  public  void setModifyDateNull(){
     this.set(S_ModifyDate,null);
  }

  public Timestamp getModifyDate(){
        return DataType.getAsDateTime(this.get(S_ModifyDate));
  
  }
  public Timestamp getModifyDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ModifyDate));
      }

  public void initSaleId(String value){
     this.initProperty(S_SaleId,value);
  }
  public  void setSaleId(String value){
     this.set(S_SaleId,value);
  }
  public  void setSaleIdNull(){
     this.set(S_SaleId,null);
  }

  public String getSaleId(){
       return DataType.getAsString(this.get(S_SaleId));
  
  }
  public String getSaleIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleId));
      }

  public void initExt9(String value){
     this.initProperty(S_Ext9,value);
  }
  public  void setExt9(String value){
     this.set(S_Ext9,value);
  }
  public  void setExt9Null(){
     this.set(S_Ext9,null);
  }

  public String getExt9(){
       return DataType.getAsString(this.get(S_Ext9));
  
  }
  public String getExt9InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext9));
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

  public void initExt6(String value){
     this.initProperty(S_Ext6,value);
  }
  public  void setExt6(String value){
     this.set(S_Ext6,value);
  }
  public  void setExt6Null(){
     this.set(S_Ext6,null);
  }

  public String getExt6(){
       return DataType.getAsString(this.get(S_Ext6));
  
  }
  public String getExt6InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext6));
      }

  public void initExt7(String value){
     this.initProperty(S_Ext7,value);
  }
  public  void setExt7(String value){
     this.set(S_Ext7,value);
  }
  public  void setExt7Null(){
     this.set(S_Ext7,null);
  }

  public String getExt7(){
       return DataType.getAsString(this.get(S_Ext7));
  
  }
  public String getExt7InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext7));
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

  public void initExt8(String value){
     this.initProperty(S_Ext8,value);
  }
  public  void setExt8(String value){
     this.set(S_Ext8,value);
  }
  public  void setExt8Null(){
     this.set(S_Ext8,null);
  }

  public String getExt8(){
       return DataType.getAsString(this.get(S_Ext8));
  
  }
  public String getExt8InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext8));
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

  public void initExt31(String value){
     this.initProperty(S_Ext31,value);
  }
  public  void setExt31(String value){
     this.set(S_Ext31,value);
  }
  public  void setExt31Null(){
     this.set(S_Ext31,null);
  }

  public String getExt31(){
       return DataType.getAsString(this.get(S_Ext31));
  
  }
  public String getExt31InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext31));
      }

  public void initExt20(String value){
     this.initProperty(S_Ext20,value);
  }
  public  void setExt20(String value){
     this.set(S_Ext20,value);
  }
  public  void setExt20Null(){
     this.set(S_Ext20,null);
  }

  public String getExt20(){
       return DataType.getAsString(this.get(S_Ext20));
  
  }
  public String getExt20InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext20));
      }

  public void initExt30(String value){
     this.initProperty(S_Ext30,value);
  }
  public  void setExt30(String value){
     this.set(S_Ext30,value);
  }
  public  void setExt30Null(){
     this.set(S_Ext30,null);
  }

  public String getExt30(){
       return DataType.getAsString(this.get(S_Ext30));
  
  }
  public String getExt30InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext30));
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

  public void initBossId(String value){
     this.initProperty(S_BossId,value);
  }
  public  void setBossId(String value){
     this.set(S_BossId,value);
  }
  public  void setBossIdNull(){
     this.set(S_BossId,null);
  }

  public String getBossId(){
       return DataType.getAsString(this.get(S_BossId));
  
  }
  public String getBossIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BossId));
      }

  public void initStatus(String value){
     this.initProperty(S_Status,value);
  }
  public  void setStatus(String value){
     this.set(S_Status,value);
  }
  public  void setStatusNull(){
     this.set(S_Status,null);
  }

  public String getStatus(){
       return DataType.getAsString(this.get(S_Status));
  
  }
  public String getStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Status));
      }

  public void initMarket(String value){
     this.initProperty(S_Market,value);
  }
  public  void setMarket(String value){
     this.set(S_Market,value);
  }
  public  void setMarketNull(){
     this.set(S_Market,null);
  }

  public String getMarket(){
       return DataType.getAsString(this.get(S_Market));
  
  }
  public String getMarketInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Market));
      }

  public void initExt19(String value){
     this.initProperty(S_Ext19,value);
  }
  public  void setExt19(String value){
     this.set(S_Ext19,value);
  }
  public  void setExt19Null(){
     this.set(S_Ext19,null);
  }

  public String getExt19(){
       return DataType.getAsString(this.get(S_Ext19));
  
  }
  public String getExt19InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext19));
      }

  public void initExt29(String value){
     this.initProperty(S_Ext29,value);
  }
  public  void setExt29(String value){
     this.set(S_Ext29,value);
  }
  public  void setExt29Null(){
     this.set(S_Ext29,null);
  }

  public String getExt29(){
       return DataType.getAsString(this.get(S_Ext29));
  
  }
  public String getExt29InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext29));
      }

  public void initExt18(String value){
     this.initProperty(S_Ext18,value);
  }
  public  void setExt18(String value){
     this.set(S_Ext18,value);
  }
  public  void setExt18Null(){
     this.set(S_Ext18,null);
  }

  public String getExt18(){
       return DataType.getAsString(this.get(S_Ext18));
  
  }
  public String getExt18InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext18));
      }

  public void initExt27(String value){
     this.initProperty(S_Ext27,value);
  }
  public  void setExt27(String value){
     this.set(S_Ext27,value);
  }
  public  void setExt27Null(){
     this.set(S_Ext27,null);
  }

  public String getExt27(){
       return DataType.getAsString(this.get(S_Ext27));
  
  }
  public String getExt27InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext27));
      }

  public void initExt17(String value){
     this.initProperty(S_Ext17,value);
  }
  public  void setExt17(String value){
     this.set(S_Ext17,value);
  }
  public  void setExt17Null(){
     this.set(S_Ext17,null);
  }

  public String getExt17(){
       return DataType.getAsString(this.get(S_Ext17));
  
  }
  public String getExt17InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext17));
      }

  public void initExt28(String value){
     this.initProperty(S_Ext28,value);
  }
  public  void setExt28(String value){
     this.set(S_Ext28,value);
  }
  public  void setExt28Null(){
     this.set(S_Ext28,null);
  }

  public String getExt28(){
       return DataType.getAsString(this.get(S_Ext28));
  
  }
  public String getExt28InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext28));
      }

  public void initExt16(String value){
     this.initProperty(S_Ext16,value);
  }
  public  void setExt16(String value){
     this.set(S_Ext16,value);
  }
  public  void setExt16Null(){
     this.set(S_Ext16,null);
  }

  public String getExt16(){
       return DataType.getAsString(this.get(S_Ext16));
  
  }
  public String getExt16InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext16));
      }

  public void initExt25(String value){
     this.initProperty(S_Ext25,value);
  }
  public  void setExt25(String value){
     this.set(S_Ext25,value);
  }
  public  void setExt25Null(){
     this.set(S_Ext25,null);
  }

  public String getExt25(){
       return DataType.getAsString(this.get(S_Ext25));
  
  }
  public String getExt25InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext25));
      }

  public void initExt15(String value){
     this.initProperty(S_Ext15,value);
  }
  public  void setExt15(String value){
     this.set(S_Ext15,value);
  }
  public  void setExt15Null(){
     this.set(S_Ext15,null);
  }

  public String getExt15(){
       return DataType.getAsString(this.get(S_Ext15));
  
  }
  public String getExt15InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext15));
      }

  public void initExt26(String value){
     this.initProperty(S_Ext26,value);
  }
  public  void setExt26(String value){
     this.set(S_Ext26,value);
  }
  public  void setExt26Null(){
     this.set(S_Ext26,null);
  }

  public String getExt26(){
       return DataType.getAsString(this.get(S_Ext26));
  
  }
  public String getExt26InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext26));
      }

  public void initExt14(String value){
     this.initProperty(S_Ext14,value);
  }
  public  void setExt14(String value){
     this.set(S_Ext14,value);
  }
  public  void setExt14Null(){
     this.set(S_Ext14,null);
  }

  public String getExt14(){
       return DataType.getAsString(this.get(S_Ext14));
  
  }
  public String getExt14InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext14));
      }

  public void initExt23(String value){
     this.initProperty(S_Ext23,value);
  }
  public  void setExt23(String value){
     this.set(S_Ext23,value);
  }
  public  void setExt23Null(){
     this.set(S_Ext23,null);
  }

  public String getExt23(){
       return DataType.getAsString(this.get(S_Ext23));
  
  }
  public String getExt23InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext23));
      }

  public void initExt13(String value){
     this.initProperty(S_Ext13,value);
  }
  public  void setExt13(String value){
     this.set(S_Ext13,value);
  }
  public  void setExt13Null(){
     this.set(S_Ext13,null);
  }

  public String getExt13(){
       return DataType.getAsString(this.get(S_Ext13));
  
  }
  public String getExt13InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext13));
      }

  public void initEId(long value){
     this.initProperty(S_EId,new Long(value));
  }
  public  void setEId(long value){
     this.set(S_EId,new Long(value));
  }
  public  void setEIdNull(){
     this.set(S_EId,null);
  }

  public long getEId(){
        return DataType.getAsLong(this.get(S_EId));
  
  }
  public long getEIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_EId));
      }

  public void initExt24(String value){
     this.initProperty(S_Ext24,value);
  }
  public  void setExt24(String value){
     this.set(S_Ext24,value);
  }
  public  void setExt24Null(){
     this.set(S_Ext24,null);
  }

  public String getExt24(){
       return DataType.getAsString(this.get(S_Ext24));
  
  }
  public String getExt24InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext24));
      }

  public void initExt12(String value){
     this.initProperty(S_Ext12,value);
  }
  public  void setExt12(String value){
     this.set(S_Ext12,value);
  }
  public  void setExt12Null(){
     this.set(S_Ext12,null);
  }

  public String getExt12(){
       return DataType.getAsString(this.get(S_Ext12));
  
  }
  public String getExt12InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext12));
      }

  public void initExt21(String value){
     this.initProperty(S_Ext21,value);
  }
  public  void setExt21(String value){
     this.set(S_Ext21,value);
  }
  public  void setExt21Null(){
     this.set(S_Ext21,null);
  }

  public String getExt21(){
       return DataType.getAsString(this.get(S_Ext21));
  
  }
  public String getExt21InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext21));
      }

  public void initExt11(String value){
     this.initProperty(S_Ext11,value);
  }
  public  void setExt11(String value){
     this.set(S_Ext11,value);
  }
  public  void setExt11Null(){
     this.set(S_Ext11,null);
  }

  public String getExt11(){
       return DataType.getAsString(this.get(S_Ext11));
  
  }
  public String getExt11InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext11));
      }

  public void initExt22(String value){
     this.initProperty(S_Ext22,value);
  }
  public  void setExt22(String value){
     this.set(S_Ext22,value);
  }
  public  void setExt22Null(){
     this.set(S_Ext22,null);
  }

  public String getExt22(){
       return DataType.getAsString(this.get(S_Ext22));
  
  }
  public String getExt22InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext22));
      }

  public void initExt10(String value){
     this.initProperty(S_Ext10,value);
  }
  public  void setExt10(String value){
     this.set(S_Ext10,value);
  }
  public  void setExt10Null(){
     this.set(S_Ext10,null);
  }

  public String getExt10(){
       return DataType.getAsString(this.get(S_Ext10));
  
  }
  public String getExt10InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext10));
      }

  public void initExt40(String value){
     this.initProperty(S_Ext40,value);
  }
  public  void setExt40(String value){
     this.set(S_Ext40,value);
  }
  public  void setExt40Null(){
     this.set(S_Ext40,null);
  }

  public String getExt40(){
       return DataType.getAsString(this.get(S_Ext40));
  
  }
  public String getExt40InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext40));
      }

  public void initSaleActiveName(String value){
     this.initProperty(S_SaleActiveName,value);
  }
  public  void setSaleActiveName(String value){
     this.set(S_SaleActiveName,value);
  }
  public  void setSaleActiveNameNull(){
     this.set(S_SaleActiveName,null);
  }

  public String getSaleActiveName(){
       return DataType.getAsString(this.get(S_SaleActiveName));
  
  }
  public String getSaleActiveNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleActiveName));
      }

  public void initStaffId(String value){
     this.initProperty(S_StaffId,value);
  }
  public  void setStaffId(String value){
     this.set(S_StaffId,value);
  }
  public  void setStaffIdNull(){
     this.set(S_StaffId,null);
  }

  public String getStaffId(){
       return DataType.getAsString(this.get(S_StaffId));
  
  }
  public String getStaffIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StaffId));
      }

  public void initFDetailId(String value){
     this.initProperty(S_FDetailId,value);
  }
  public  void setFDetailId(String value){
     this.set(S_FDetailId,value);
  }
  public  void setFDetailIdNull(){
     this.set(S_FDetailId,null);
  }

  public String getFDetailId(){
       return DataType.getAsString(this.get(S_FDetailId));
  
  }
  public String getFDetailIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FDetailId));
      }

  public void initLevelCode(String value){
     this.initProperty(S_LevelCode,value);
  }
  public  void setLevelCode(String value){
     this.set(S_LevelCode,value);
  }
  public  void setLevelCodeNull(){
     this.set(S_LevelCode,null);
  }

  public String getLevelCode(){
       return DataType.getAsString(this.get(S_LevelCode));
  
  }
  public String getLevelCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_LevelCode));
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

  public void initExt36(String value){
     this.initProperty(S_Ext36,value);
  }
  public  void setExt36(String value){
     this.set(S_Ext36,value);
  }
  public  void setExt36Null(){
     this.set(S_Ext36,null);
  }

  public String getExt36(){
       return DataType.getAsString(this.get(S_Ext36));
  
  }
  public String getExt36InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext36));
      }

  public void initExt37(String value){
     this.initProperty(S_Ext37,value);
  }
  public  void setExt37(String value){
     this.set(S_Ext37,value);
  }
  public  void setExt37Null(){
     this.set(S_Ext37,null);
  }

  public String getExt37(){
       return DataType.getAsString(this.get(S_Ext37));
  
  }
  public String getExt37InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext37));
      }

  public void initExt38(String value){
     this.initProperty(S_Ext38,value);
  }
  public  void setExt38(String value){
     this.set(S_Ext38,value);
  }
  public  void setExt38Null(){
     this.set(S_Ext38,null);
  }

  public String getExt38(){
       return DataType.getAsString(this.get(S_Ext38));
  
  }
  public String getExt38InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext38));
      }

  public void initExt39(String value){
     this.initProperty(S_Ext39,value);
  }
  public  void setExt39(String value){
     this.set(S_Ext39,value);
  }
  public  void setExt39Null(){
     this.set(S_Ext39,null);
  }

  public String getExt39(){
       return DataType.getAsString(this.get(S_Ext39));
  
  }
  public String getExt39InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext39));
      }

  public void initExt32(String value){
     this.initProperty(S_Ext32,value);
  }
  public  void setExt32(String value){
     this.set(S_Ext32,value);
  }
  public  void setExt32Null(){
     this.set(S_Ext32,null);
  }

  public String getExt32(){
       return DataType.getAsString(this.get(S_Ext32));
  
  }
  public String getExt32InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext32));
      }

  public void initExt33(String value){
     this.initProperty(S_Ext33,value);
  }
  public  void setExt33(String value){
     this.set(S_Ext33,value);
  }
  public  void setExt33Null(){
     this.set(S_Ext33,null);
  }

  public String getExt33(){
       return DataType.getAsString(this.get(S_Ext33));
  
  }
  public String getExt33InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext33));
      }

  public void initIsSendSms(String value){
     this.initProperty(S_IsSendSms,value);
  }
  public  void setIsSendSms(String value){
     this.set(S_IsSendSms,value);
  }
  public  void setIsSendSmsNull(){
     this.set(S_IsSendSms,null);
  }

  public String getIsSendSms(){
       return DataType.getAsString(this.get(S_IsSendSms));
  
  }
  public String getIsSendSmsInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsSendSms));
      }

  public void initExt34(String value){
     this.initProperty(S_Ext34,value);
  }
  public  void setExt34(String value){
     this.set(S_Ext34,value);
  }
  public  void setExt34Null(){
     this.set(S_Ext34,null);
  }

  public String getExt34(){
       return DataType.getAsString(this.get(S_Ext34));
  
  }
  public String getExt34InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext34));
      }

  public void initExt35(String value){
     this.initProperty(S_Ext35,value);
  }
  public  void setExt35(String value){
     this.set(S_Ext35,value);
  }
  public  void setExt35Null(){
     this.set(S_Ext35,null);
  }

  public String getExt35(){
       return DataType.getAsString(this.get(S_Ext35));
  
  }
  public String getExt35InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext35));
      }


 
 }

