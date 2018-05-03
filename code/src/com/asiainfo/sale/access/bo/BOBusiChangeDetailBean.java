package com.asiainfo.sale.access.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.access.ivalues.*;

public class BOBusiChangeDetailBean extends DataContainer implements DataContainerInterface,IBOBusiChangeDetailValue{

  private static String  m_boName = "com.asiainfo.sale.access.bo.BOBusiChangeDetail";



  public final static  String S_ChannelAdd = "CHANNEL_ADD";
  public final static  String S_BrandChargeDel = "BRAND_CHARGE_DEL";
  public final static  String S_ChangeBeginTime = "CHANGE_BEGIN_TIME";
  public final static  String S_ChannelDel = "CHANNEL_DEL";
  public final static  String S_PlanOpenBrand = "PLAN_OPEN_BRAND";
  public final static  String S_ChangeEndTime = "CHANGE_END_TIME";
  public final static  String S_ActName = "ACT_NAME";
  public final static  String S_Reamrk7 = "REAMRK7";
  public final static  String S_ChangeExecChannel = "CHANGE_EXEC_CHANNEL";
  public final static  String S_PresentGoodsPrice = "PRESENT_GOODS_PRICE";
  public final static  String S_BrandChargeAdd = "BRAND_CHARGE_ADD";
  public final static  String S_PlanChargeNum = "PLAN_CHARGE_NUM";
  public final static  String S_PlanChannelNum = "PLAN_CHANNEL_NUM";
  public final static  String S_ChangeGoodsPrice = "CHANGE_GOODS_PRICE";
  public final static  String S_Remark1 = "REMARK1";
  public final static  String S_LevName = "LEV_NAME";
  public final static  String S_Remark2 = "REMARK2";
  public final static  String S_Remark3 = "REMARK3";
  public final static  String S_Remark4 = "REMARK4";
  public final static  String S_Remark5 = "REMARK5";
  public final static  String S_Remark6 = "REMARK6";
  public final static  String S_ChangeType = "CHANGE_TYPE";
  public final static  String S_ChangeObject = "CHANGE_OBJECT";
  public final static  String S_BusidId = "BUSID_ID";
  public final static  String S_PlanEndTime = "PLAN_END_TIME";
  public final static  String S_PresentGoodsName = "PRESENT_GOODS_NAME";
  public final static  String S_JobnumDel = "JOBNUM_DEL";
  public final static  String S_LevCode = "LEV_CODE";
  public final static  String S_Channel = "CHANNEL";
  public final static  String S_PlanBeginTime = "PLAN_BEGIN_TIME";
  public final static  String S_AppendBase = "APPEND_BASE";
  public final static  String S_ChangeOpenBrand = "CHANGE_OPEN_BRAND";
  public final static  String S_JobnumAdd = "JOBNUM_ADD";
  public final static  String S_PlanJobnum = "PLAN_JOBNUM";
  public final static  String S_PlanBase = "PLAN_BASE";
  public final static  String S_HasTicket = "HAS_TICKET";
  public final static  String S_TicketSum = "TICKET_SUM";
  public final static  String S_DqKf = "DQ_KF";
  public final static  String S_SaleChargeOrder = "SALE_CHARGE_ORDER";
  public final static  String S_ChangeGoodsName = "CHANGE_GOODS_NAME";
  public final static  String S_OaOrder = "OA_ORDER";
  public final static  String S_PlanExecChannel = "PLAN_EXEC_CHANNEL";
  public final static  String S_ActCode = "ACT_CODE";
  public final static  String S_PlanTicketSum = "PLAN_TICKET_SUM";
  public final static  String S_BusiId = "BUSI_ID";
  public final static  String S_IsEnd = "IS_END";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOBusiChangeDetailBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initChannelAdd(int value){
     this.initProperty(S_ChannelAdd,new Integer(value));
  }
  public  void setChannelAdd(int value){
     this.set(S_ChannelAdd,new Integer(value));
  }
  public  void setChannelAddNull(){
     this.set(S_ChannelAdd,null);
  }

  public int getChannelAdd(){
        return DataType.getAsInt(this.get(S_ChannelAdd));
  
  }
  public int getChannelAddInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ChannelAdd));
      }

  public void initBrandChargeDel(int value){
     this.initProperty(S_BrandChargeDel,new Integer(value));
  }
  public  void setBrandChargeDel(int value){
     this.set(S_BrandChargeDel,new Integer(value));
  }
  public  void setBrandChargeDelNull(){
     this.set(S_BrandChargeDel,null);
  }

  public int getBrandChargeDel(){
        return DataType.getAsInt(this.get(S_BrandChargeDel));
  
  }
  public int getBrandChargeDelInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_BrandChargeDel));
      }

  public void initChangeBeginTime(Timestamp value){
     this.initProperty(S_ChangeBeginTime,value);
  }
  public  void setChangeBeginTime(Timestamp value){
     this.set(S_ChangeBeginTime,value);
  }
  public  void setChangeBeginTimeNull(){
     this.set(S_ChangeBeginTime,null);
  }

  public Timestamp getChangeBeginTime(){
        return DataType.getAsDateTime(this.get(S_ChangeBeginTime));
  
  }
  public Timestamp getChangeBeginTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ChangeBeginTime));
      }

  public void initChannelDel(int value){
     this.initProperty(S_ChannelDel,new Integer(value));
  }
  public  void setChannelDel(int value){
     this.set(S_ChannelDel,new Integer(value));
  }
  public  void setChannelDelNull(){
     this.set(S_ChannelDel,null);
  }

  public int getChannelDel(){
        return DataType.getAsInt(this.get(S_ChannelDel));
  
  }
  public int getChannelDelInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ChannelDel));
      }

  public void initPlanOpenBrand(String value){
     this.initProperty(S_PlanOpenBrand,value);
  }
  public  void setPlanOpenBrand(String value){
     this.set(S_PlanOpenBrand,value);
  }
  public  void setPlanOpenBrandNull(){
     this.set(S_PlanOpenBrand,null);
  }

  public String getPlanOpenBrand(){
       return DataType.getAsString(this.get(S_PlanOpenBrand));
  
  }
  public String getPlanOpenBrandInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PlanOpenBrand));
      }

  public void initChangeEndTime(Timestamp value){
     this.initProperty(S_ChangeEndTime,value);
  }
  public  void setChangeEndTime(Timestamp value){
     this.set(S_ChangeEndTime,value);
  }
  public  void setChangeEndTimeNull(){
     this.set(S_ChangeEndTime,null);
  }

  public Timestamp getChangeEndTime(){
        return DataType.getAsDateTime(this.get(S_ChangeEndTime));
  
  }
  public Timestamp getChangeEndTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ChangeEndTime));
      }

  public void initActName(String value){
     this.initProperty(S_ActName,value);
  }
  public  void setActName(String value){
     this.set(S_ActName,value);
  }
  public  void setActNameNull(){
     this.set(S_ActName,null);
  }

  public String getActName(){
       return DataType.getAsString(this.get(S_ActName));
  
  }
  public String getActNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ActName));
      }

  public void initReamrk7(String value){
     this.initProperty(S_Reamrk7,value);
  }
  public  void setReamrk7(String value){
     this.set(S_Reamrk7,value);
  }
  public  void setReamrk7Null(){
     this.set(S_Reamrk7,null);
  }

  public String getReamrk7(){
       return DataType.getAsString(this.get(S_Reamrk7));
  
  }
  public String getReamrk7InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Reamrk7));
      }

  public void initChangeExecChannel(String value){
     this.initProperty(S_ChangeExecChannel,value);
  }
  public  void setChangeExecChannel(String value){
     this.set(S_ChangeExecChannel,value);
  }
  public  void setChangeExecChannelNull(){
     this.set(S_ChangeExecChannel,null);
  }

  public String getChangeExecChannel(){
       return DataType.getAsString(this.get(S_ChangeExecChannel));
  
  }
  public String getChangeExecChannelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChangeExecChannel));
      }

  public void initPresentGoodsPrice(double value){
     this.initProperty(S_PresentGoodsPrice,new Double(value));
  }
  public  void setPresentGoodsPrice(double value){
     this.set(S_PresentGoodsPrice,new Double(value));
  }
  public  void setPresentGoodsPriceNull(){
     this.set(S_PresentGoodsPrice,null);
  }

  public double getPresentGoodsPrice(){
        return DataType.getAsDouble(this.get(S_PresentGoodsPrice));
  
  }
  public double getPresentGoodsPriceInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PresentGoodsPrice));
      }

  public void initBrandChargeAdd(int value){
     this.initProperty(S_BrandChargeAdd,new Integer(value));
  }
  public  void setBrandChargeAdd(int value){
     this.set(S_BrandChargeAdd,new Integer(value));
  }
  public  void setBrandChargeAddNull(){
     this.set(S_BrandChargeAdd,null);
  }

  public int getBrandChargeAdd(){
        return DataType.getAsInt(this.get(S_BrandChargeAdd));
  
  }
  public int getBrandChargeAddInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_BrandChargeAdd));
      }

  public void initPlanChargeNum(int value){
     this.initProperty(S_PlanChargeNum,new Integer(value));
  }
  public  void setPlanChargeNum(int value){
     this.set(S_PlanChargeNum,new Integer(value));
  }
  public  void setPlanChargeNumNull(){
     this.set(S_PlanChargeNum,null);
  }

  public int getPlanChargeNum(){
        return DataType.getAsInt(this.get(S_PlanChargeNum));
  
  }
  public int getPlanChargeNumInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_PlanChargeNum));
      }

  public void initPlanChannelNum(int value){
     this.initProperty(S_PlanChannelNum,new Integer(value));
  }
  public  void setPlanChannelNum(int value){
     this.set(S_PlanChannelNum,new Integer(value));
  }
  public  void setPlanChannelNumNull(){
     this.set(S_PlanChannelNum,null);
  }

  public int getPlanChannelNum(){
        return DataType.getAsInt(this.get(S_PlanChannelNum));
  
  }
  public int getPlanChannelNumInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_PlanChannelNum));
      }

  public void initChangeGoodsPrice(double value){
     this.initProperty(S_ChangeGoodsPrice,new Double(value));
  }
  public  void setChangeGoodsPrice(double value){
     this.set(S_ChangeGoodsPrice,new Double(value));
  }
  public  void setChangeGoodsPriceNull(){
     this.set(S_ChangeGoodsPrice,null);
  }

  public double getChangeGoodsPrice(){
        return DataType.getAsDouble(this.get(S_ChangeGoodsPrice));
  
  }
  public double getChangeGoodsPriceInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_ChangeGoodsPrice));
      }

  public void initRemark1(String value){
     this.initProperty(S_Remark1,value);
  }
  public  void setRemark1(String value){
     this.set(S_Remark1,value);
  }
  public  void setRemark1Null(){
     this.set(S_Remark1,null);
  }

  public String getRemark1(){
       return DataType.getAsString(this.get(S_Remark1));
  
  }
  public String getRemark1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark1));
      }

  public void initLevName(String value){
     this.initProperty(S_LevName,value);
  }
  public  void setLevName(String value){
     this.set(S_LevName,value);
  }
  public  void setLevNameNull(){
     this.set(S_LevName,null);
  }

  public String getLevName(){
       return DataType.getAsString(this.get(S_LevName));
  
  }
  public String getLevNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_LevName));
      }

  public void initRemark2(String value){
     this.initProperty(S_Remark2,value);
  }
  public  void setRemark2(String value){
     this.set(S_Remark2,value);
  }
  public  void setRemark2Null(){
     this.set(S_Remark2,null);
  }

  public String getRemark2(){
       return DataType.getAsString(this.get(S_Remark2));
  
  }
  public String getRemark2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark2));
      }

  public void initRemark3(String value){
     this.initProperty(S_Remark3,value);
  }
  public  void setRemark3(String value){
     this.set(S_Remark3,value);
  }
  public  void setRemark3Null(){
     this.set(S_Remark3,null);
  }

  public String getRemark3(){
       return DataType.getAsString(this.get(S_Remark3));
  
  }
  public String getRemark3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark3));
      }

  public void initRemark4(String value){
     this.initProperty(S_Remark4,value);
  }
  public  void setRemark4(String value){
     this.set(S_Remark4,value);
  }
  public  void setRemark4Null(){
     this.set(S_Remark4,null);
  }

  public String getRemark4(){
       return DataType.getAsString(this.get(S_Remark4));
  
  }
  public String getRemark4InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark4));
      }

  public void initRemark5(String value){
     this.initProperty(S_Remark5,value);
  }
  public  void setRemark5(String value){
     this.set(S_Remark5,value);
  }
  public  void setRemark5Null(){
     this.set(S_Remark5,null);
  }

  public String getRemark5(){
       return DataType.getAsString(this.get(S_Remark5));
  
  }
  public String getRemark5InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark5));
      }

  public void initRemark6(String value){
     this.initProperty(S_Remark6,value);
  }
  public  void setRemark6(String value){
     this.set(S_Remark6,value);
  }
  public  void setRemark6Null(){
     this.set(S_Remark6,null);
  }

  public String getRemark6(){
       return DataType.getAsString(this.get(S_Remark6));
  
  }
  public String getRemark6InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark6));
      }

  public void initChangeType(String value){
     this.initProperty(S_ChangeType,value);
  }
  public  void setChangeType(String value){
     this.set(S_ChangeType,value);
  }
  public  void setChangeTypeNull(){
     this.set(S_ChangeType,null);
  }

  public String getChangeType(){
       return DataType.getAsString(this.get(S_ChangeType));
  
  }
  public String getChangeTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChangeType));
      }

  public void initChangeObject(String value){
     this.initProperty(S_ChangeObject,value);
  }
  public  void setChangeObject(String value){
     this.set(S_ChangeObject,value);
  }
  public  void setChangeObjectNull(){
     this.set(S_ChangeObject,null);
  }

  public String getChangeObject(){
       return DataType.getAsString(this.get(S_ChangeObject));
  
  }
  public String getChangeObjectInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChangeObject));
      }

  public void initBusidId(int value){
     this.initProperty(S_BusidId,new Integer(value));
  }
  public  void setBusidId(int value){
     this.set(S_BusidId,new Integer(value));
  }
  public  void setBusidIdNull(){
     this.set(S_BusidId,null);
  }

  public int getBusidId(){
        return DataType.getAsInt(this.get(S_BusidId));
  
  }
  public int getBusidIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_BusidId));
      }

  public void initPlanEndTime(Timestamp value){
     this.initProperty(S_PlanEndTime,value);
  }
  public  void setPlanEndTime(Timestamp value){
     this.set(S_PlanEndTime,value);
  }
  public  void setPlanEndTimeNull(){
     this.set(S_PlanEndTime,null);
  }

  public Timestamp getPlanEndTime(){
        return DataType.getAsDateTime(this.get(S_PlanEndTime));
  
  }
  public Timestamp getPlanEndTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_PlanEndTime));
      }

  public void initPresentGoodsName(String value){
     this.initProperty(S_PresentGoodsName,value);
  }
  public  void setPresentGoodsName(String value){
     this.set(S_PresentGoodsName,value);
  }
  public  void setPresentGoodsNameNull(){
     this.set(S_PresentGoodsName,null);
  }

  public String getPresentGoodsName(){
       return DataType.getAsString(this.get(S_PresentGoodsName));
  
  }
  public String getPresentGoodsNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PresentGoodsName));
      }

  public void initJobnumDel(int value){
     this.initProperty(S_JobnumDel,new Integer(value));
  }
  public  void setJobnumDel(int value){
     this.set(S_JobnumDel,new Integer(value));
  }
  public  void setJobnumDelNull(){
     this.set(S_JobnumDel,null);
  }

  public int getJobnumDel(){
        return DataType.getAsInt(this.get(S_JobnumDel));
  
  }
  public int getJobnumDelInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_JobnumDel));
      }

  public void initLevCode(String value){
     this.initProperty(S_LevCode,value);
  }
  public  void setLevCode(String value){
     this.set(S_LevCode,value);
  }
  public  void setLevCodeNull(){
     this.set(S_LevCode,null);
  }

  public String getLevCode(){
       return DataType.getAsString(this.get(S_LevCode));
  
  }
  public String getLevCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_LevCode));
      }

  public void initChannel(String value){
     this.initProperty(S_Channel,value);
  }
  public  void setChannel(String value){
     this.set(S_Channel,value);
  }
  public  void setChannelNull(){
     this.set(S_Channel,null);
  }

  public String getChannel(){
       return DataType.getAsString(this.get(S_Channel));
  
  }
  public String getChannelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Channel));
      }

  public void initPlanBeginTime(Timestamp value){
     this.initProperty(S_PlanBeginTime,value);
  }
  public  void setPlanBeginTime(Timestamp value){
     this.set(S_PlanBeginTime,value);
  }
  public  void setPlanBeginTimeNull(){
     this.set(S_PlanBeginTime,null);
  }

  public Timestamp getPlanBeginTime(){
        return DataType.getAsDateTime(this.get(S_PlanBeginTime));
  
  }
  public Timestamp getPlanBeginTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_PlanBeginTime));
      }

  public void initAppendBase(double value){
     this.initProperty(S_AppendBase,new Double(value));
  }
  public  void setAppendBase(double value){
     this.set(S_AppendBase,new Double(value));
  }
  public  void setAppendBaseNull(){
     this.set(S_AppendBase,null);
  }

  public double getAppendBase(){
        return DataType.getAsDouble(this.get(S_AppendBase));
  
  }
  public double getAppendBaseInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_AppendBase));
      }

  public void initChangeOpenBrand(String value){
     this.initProperty(S_ChangeOpenBrand,value);
  }
  public  void setChangeOpenBrand(String value){
     this.set(S_ChangeOpenBrand,value);
  }
  public  void setChangeOpenBrandNull(){
     this.set(S_ChangeOpenBrand,null);
  }

  public String getChangeOpenBrand(){
       return DataType.getAsString(this.get(S_ChangeOpenBrand));
  
  }
  public String getChangeOpenBrandInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChangeOpenBrand));
      }

  public void initJobnumAdd(int value){
     this.initProperty(S_JobnumAdd,new Integer(value));
  }
  public  void setJobnumAdd(int value){
     this.set(S_JobnumAdd,new Integer(value));
  }
  public  void setJobnumAddNull(){
     this.set(S_JobnumAdd,null);
  }

  public int getJobnumAdd(){
        return DataType.getAsInt(this.get(S_JobnumAdd));
  
  }
  public int getJobnumAddInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_JobnumAdd));
      }

  public void initPlanJobnum(int value){
     this.initProperty(S_PlanJobnum,new Integer(value));
  }
  public  void setPlanJobnum(int value){
     this.set(S_PlanJobnum,new Integer(value));
  }
  public  void setPlanJobnumNull(){
     this.set(S_PlanJobnum,null);
  }

  public int getPlanJobnum(){
        return DataType.getAsInt(this.get(S_PlanJobnum));
  
  }
  public int getPlanJobnumInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_PlanJobnum));
      }

  public void initPlanBase(double value){
     this.initProperty(S_PlanBase,new Double(value));
  }
  public  void setPlanBase(double value){
     this.set(S_PlanBase,new Double(value));
  }
  public  void setPlanBaseNull(){
     this.set(S_PlanBase,null);
  }

  public double getPlanBase(){
        return DataType.getAsDouble(this.get(S_PlanBase));
  
  }
  public double getPlanBaseInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PlanBase));
      }

  public void initHasTicket(String value){
     this.initProperty(S_HasTicket,value);
  }
  public  void setHasTicket(String value){
     this.set(S_HasTicket,value);
  }
  public  void setHasTicketNull(){
     this.set(S_HasTicket,null);
  }

  public String getHasTicket(){
       return DataType.getAsString(this.get(S_HasTicket));
  
  }
  public String getHasTicketInitialValue(){
        return DataType.getAsString(this.getOldObj(S_HasTicket));
      }

  public void initTicketSum(double value){
     this.initProperty(S_TicketSum,new Double(value));
  }
  public  void setTicketSum(double value){
     this.set(S_TicketSum,new Double(value));
  }
  public  void setTicketSumNull(){
     this.set(S_TicketSum,null);
  }

  public double getTicketSum(){
        return DataType.getAsDouble(this.get(S_TicketSum));
  
  }
  public double getTicketSumInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_TicketSum));
      }

  public void initDqKf(String value){
     this.initProperty(S_DqKf,value);
  }
  public  void setDqKf(String value){
     this.set(S_DqKf,value);
  }
  public  void setDqKfNull(){
     this.set(S_DqKf,null);
  }

  public String getDqKf(){
       return DataType.getAsString(this.get(S_DqKf));
  
  }
  public String getDqKfInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DqKf));
      }

  public void initSaleChargeOrder(String value){
     this.initProperty(S_SaleChargeOrder,value);
  }
  public  void setSaleChargeOrder(String value){
     this.set(S_SaleChargeOrder,value);
  }
  public  void setSaleChargeOrderNull(){
     this.set(S_SaleChargeOrder,null);
  }

  public String getSaleChargeOrder(){
       return DataType.getAsString(this.get(S_SaleChargeOrder));
  
  }
  public String getSaleChargeOrderInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleChargeOrder));
      }

  public void initChangeGoodsName(String value){
     this.initProperty(S_ChangeGoodsName,value);
  }
  public  void setChangeGoodsName(String value){
     this.set(S_ChangeGoodsName,value);
  }
  public  void setChangeGoodsNameNull(){
     this.set(S_ChangeGoodsName,null);
  }

  public String getChangeGoodsName(){
       return DataType.getAsString(this.get(S_ChangeGoodsName));
  
  }
  public String getChangeGoodsNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChangeGoodsName));
      }

  public void initOaOrder(String value){
     this.initProperty(S_OaOrder,value);
  }
  public  void setOaOrder(String value){
     this.set(S_OaOrder,value);
  }
  public  void setOaOrderNull(){
     this.set(S_OaOrder,null);
  }

  public String getOaOrder(){
       return DataType.getAsString(this.get(S_OaOrder));
  
  }
  public String getOaOrderInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OaOrder));
      }

  public void initPlanExecChannel(String value){
     this.initProperty(S_PlanExecChannel,value);
  }
  public  void setPlanExecChannel(String value){
     this.set(S_PlanExecChannel,value);
  }
  public  void setPlanExecChannelNull(){
     this.set(S_PlanExecChannel,null);
  }

  public String getPlanExecChannel(){
       return DataType.getAsString(this.get(S_PlanExecChannel));
  
  }
  public String getPlanExecChannelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PlanExecChannel));
      }

  public void initActCode(String value){
     this.initProperty(S_ActCode,value);
  }
  public  void setActCode(String value){
     this.set(S_ActCode,value);
  }
  public  void setActCodeNull(){
     this.set(S_ActCode,null);
  }

  public String getActCode(){
       return DataType.getAsString(this.get(S_ActCode));
  
  }
  public String getActCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ActCode));
      }

  public void initPlanTicketSum(double value){
     this.initProperty(S_PlanTicketSum,new Double(value));
  }
  public  void setPlanTicketSum(double value){
     this.set(S_PlanTicketSum,new Double(value));
  }
  public  void setPlanTicketSumNull(){
     this.set(S_PlanTicketSum,null);
  }

  public double getPlanTicketSum(){
        return DataType.getAsDouble(this.get(S_PlanTicketSum));
  
  }
  public double getPlanTicketSumInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PlanTicketSum));
      }

  public void initBusiId(int value){
     this.initProperty(S_BusiId,new Integer(value));
  }
  public  void setBusiId(int value){
     this.set(S_BusiId,new Integer(value));
  }
  public  void setBusiIdNull(){
     this.set(S_BusiId,null);
  }

  public int getBusiId(){
        return DataType.getAsInt(this.get(S_BusiId));
  
  }
  public int getBusiIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_BusiId));
      }

  public void initIsEnd(String value){
     this.initProperty(S_IsEnd,value);
  }
  public  void setIsEnd(String value){
     this.set(S_IsEnd,value);
  }
  public  void setIsEndNull(){
     this.set(S_IsEnd,null);
  }

  public String getIsEnd(){
       return DataType.getAsString(this.get(S_IsEnd));
  
  }
  public String getIsEndInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsEnd));
      }


 
 }

