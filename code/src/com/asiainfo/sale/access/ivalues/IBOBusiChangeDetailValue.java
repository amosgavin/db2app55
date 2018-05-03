package com.asiainfo.sale.access.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOBusiChangeDetailValue extends DataStructInterface{

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


public int getChannelAdd();

public int getBrandChargeDel();

public Timestamp getChangeBeginTime();

public int getChannelDel();

public String getPlanOpenBrand();

public Timestamp getChangeEndTime();

public String getActName();

public String getReamrk7();

public String getChangeExecChannel();

public double getPresentGoodsPrice();

public int getBrandChargeAdd();

public int getPlanChargeNum();

public int getPlanChannelNum();

public double getChangeGoodsPrice();

public String getRemark1();

public String getLevName();

public String getRemark2();

public String getRemark3();

public String getRemark4();

public String getRemark5();

public String getRemark6();

public String getChangeType();

public String getChangeObject();

public int getBusidId();

public Timestamp getPlanEndTime();

public String getPresentGoodsName();

public int getJobnumDel();

public String getLevCode();

public String getChannel();

public Timestamp getPlanBeginTime();

public double getAppendBase();

public String getChangeOpenBrand();

public int getJobnumAdd();

public int getPlanJobnum();

public double getPlanBase();

public String getHasTicket();

public double getTicketSum();

public String getDqKf();

public String getSaleChargeOrder();

public String getChangeGoodsName();

public String getOaOrder();

public String getPlanExecChannel();

public String getActCode();

public double getPlanTicketSum();

public int getBusiId();

public String getIsEnd();


public  void setChannelAdd(int value);

public  void setBrandChargeDel(int value);

public  void setChangeBeginTime(Timestamp value);

public  void setChannelDel(int value);

public  void setPlanOpenBrand(String value);

public  void setChangeEndTime(Timestamp value);

public  void setActName(String value);

public  void setReamrk7(String value);

public  void setChangeExecChannel(String value);

public  void setPresentGoodsPrice(double value);

public  void setBrandChargeAdd(int value);

public  void setPlanChargeNum(int value);

public  void setPlanChannelNum(int value);

public  void setChangeGoodsPrice(double value);

public  void setRemark1(String value);

public  void setLevName(String value);

public  void setRemark2(String value);

public  void setRemark3(String value);

public  void setRemark4(String value);

public  void setRemark5(String value);

public  void setRemark6(String value);

public  void setChangeType(String value);

public  void setChangeObject(String value);

public  void setBusidId(int value);

public  void setPlanEndTime(Timestamp value);

public  void setPresentGoodsName(String value);

public  void setJobnumDel(int value);

public  void setLevCode(String value);

public  void setChannel(String value);

public  void setPlanBeginTime(Timestamp value);

public  void setAppendBase(double value);

public  void setChangeOpenBrand(String value);

public  void setJobnumAdd(int value);

public  void setPlanJobnum(int value);

public  void setPlanBase(double value);

public  void setHasTicket(String value);

public  void setTicketSum(double value);

public  void setDqKf(String value);

public  void setSaleChargeOrder(String value);

public  void setChangeGoodsName(String value);

public  void setOaOrder(String value);

public  void setPlanExecChannel(String value);

public  void setActCode(String value);

public  void setPlanTicketSum(double value);

public  void setBusiId(int value);

public  void setIsEnd(String value);
}
