package com.asiainfo.sale.activity.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOSaleMainShowValue extends DataStructInterface{

  public final static  String S_Aim = "AIM";
  public final static  String S_PreIncome = "PRE_INCOME";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_Saledemand = "SALEDEMAND";
  public final static  String S_StateDate = "STATE_DATE";
  public final static  String S_MobileCost = "MOBILE_COST";
  public final static  String S_PreAddPerson = "PRE_ADD_PERSON";
  public final static  String S_SaleMainName = "SALE_MAIN_NAME";
  public final static  String S_Id = "ID";
  public final static  String S_BusinessDiscount = "BUSINESS_DISCOUNT";
  public final static  String S_ActivityType = "ACTIVITY_TYPE";
  public final static  String S_CostTotal = "COST_TOTAL";
  public final static  String S_MobilepayCost = "MOBILEPAY_COST";
  public final static  String S_Marktype = "MARKTYPE";
  public final static  String S_Remark1 = "REMARK1";
  public final static  String S_DetailInfo = "DETAIL_INFO";
  public final static  String S_OrganizeName = "ORGANIZE_NAME";
  public final static  String S_Remark2 = "REMARK2";
  public final static  String S_Remark3 = "REMARK3";
  public final static  String S_Remark4 = "REMARK4";
  public final static  String S_BackGround = "BACK_GROUND";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Remark5 = "REMARK5";
  public final static  String S_Specialnote = "SPECIALNOTE";
  public final static  String S_Exearea = "EXEAREA";
  public final static  String S_SaleObject = "SALE_OBJECT";
  public final static  String S_WorkflowObjectType = "WORKFLOW_OBJECT_TYPE";
  public final static  String S_ElecgoodsCost = "ELECGOODS_COST";
  public final static  String S_OrganizeNameF = "ORGANIZE_NAME_F";
  public final static  String S_ElecpayCost = "ELECPAY_COST";
  public final static  String S_Principal = "PRINCIPAL";
  public final static  String S_PrePerson = "PRE_PERSON";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_TaskTag = "TASK_TAG";
  public final static  String S_State = "STATE";
  public final static  String S_EstimateAdFee = "ESTIMATE_AD_FEE";
  public final static  String S_ModifyTime = "MODIFY_TIME";
  public final static  String S_Statrequest = "STATREQUEST";
  public final static  String S_Explanation = "EXPLANATION";
  public final static  String S_Isgroup = "ISGROUP";
  public final static  String S_GroupProp = "GROUP_PROP";
  public final static  String S_FinishDate = "FINISH_DATE";
  public final static  String S_ActiveSaleSite = "ACTIVE_SALE_SITE";
  public final static  String S_BeginTime = "BEGIN_TIME";
  public final static  String S_Content = "CONTENT";
  public final static  String S_IsactiveSale = "ISACTIVE_SALE";
  public final static  String S_GoodsCost = "GOODS_COST";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_WorkflowId = "WORKFLOW_ID";
  public final static  String S_ChannelPay = "CHANNEL_PAY";
  public final static  String S_Businesscheckplan = "BUSINESSCHECKPLAN";
  public final static  String S_PromoteDepart = "PROMOTE_DEPART";
  public final static  String S_Label = "LABEL";
  public final static  String S_PromoteManager = "PROMOTE_MANAGER";
  public final static  String S_SaleMainCode = "SALE_MAIN_CODE";
  public final static  String S_Prorplan = "PRORPLAN";
  public final static  String S_FeeDiscount = "FEE_DISCOUNT";
  public final static  String S_EndTime = "END_TIME";
  public final static  String S_IsSubmit = "IS_SUBMIT";
  public final static  String S_EstimateOtherFee = "ESTIMATE_OTHER_FEE";


public String getAim();

public long getPreIncome();

public Timestamp getCreateTime();

public String getSaledemand();

public Timestamp getStateDate();

public long getMobileCost();

public long getPreAddPerson();

public String getSaleMainName();

public String getId();

public long getBusinessDiscount();

public String getActivityType();

public long getCostTotal();

public long getMobilepayCost();

public String getMarktype();

public String getRemark1();

public String getDetailInfo();

public String getOrganizeName();

public String getRemark2();

public String getRemark3();

public String getRemark4();

public String getBackGround();

public String getDescription();

public String getRemark5();

public String getSpecialnote();

public String getExearea();

public String getSaleObject();

public String getWorkflowObjectType();

public long getElecgoodsCost();

public String getOrganizeNameF();

public long getElecpayCost();

public String getPrincipal();

public long getPrePerson();

public Timestamp getCreateDate();

public String getTaskTag();

public long getState();

public long getEstimateAdFee();

public Timestamp getModifyTime();

public String getStatrequest();

public String getExplanation();

public String getIsgroup();

public String getGroupProp();

public Timestamp getFinishDate();

public String getActiveSaleSite();

public Timestamp getBeginTime();

public String getContent();

public String getIsactiveSale();

public long getGoodsCost();

public String getStaffName();

public String getWorkflowId();

public long getChannelPay();

public String getBusinesscheckplan();

public String getPromoteDepart();

public String getLabel();

public String getPromoteManager();

public String getSaleMainCode();

public String getProrplan();

public long getFeeDiscount();

public Timestamp getEndTime();

public String getIsSubmit();

public long getEstimateOtherFee();


public  void setAim(String value);

public  void setPreIncome(long value);

public  void setCreateTime(Timestamp value);

public  void setSaledemand(String value);

public  void setStateDate(Timestamp value);

public  void setMobileCost(long value);

public  void setPreAddPerson(long value);

public  void setSaleMainName(String value);

public  void setId(String value);

public  void setBusinessDiscount(long value);

public  void setActivityType(String value);

public  void setCostTotal(long value);

public  void setMobilepayCost(long value);

public  void setMarktype(String value);

public  void setRemark1(String value);

public  void setDetailInfo(String value);

public  void setOrganizeName(String value);

public  void setRemark2(String value);

public  void setRemark3(String value);

public  void setRemark4(String value);

public  void setBackGround(String value);

public  void setDescription(String value);

public  void setRemark5(String value);

public  void setSpecialnote(String value);

public  void setExearea(String value);

public  void setSaleObject(String value);

public  void setWorkflowObjectType(String value);

public  void setElecgoodsCost(long value);

public  void setOrganizeNameF(String value);

public  void setElecpayCost(long value);

public  void setPrincipal(String value);

public  void setPrePerson(long value);

public  void setCreateDate(Timestamp value);

public  void setTaskTag(String value);

public  void setState(long value);

public  void setEstimateAdFee(long value);

public  void setModifyTime(Timestamp value);

public  void setStatrequest(String value);

public  void setExplanation(String value);

public  void setIsgroup(String value);

public  void setGroupProp(String value);

public  void setFinishDate(Timestamp value);

public  void setActiveSaleSite(String value);

public  void setBeginTime(Timestamp value);

public  void setContent(String value);

public  void setIsactiveSale(String value);

public  void setGoodsCost(long value);

public  void setStaffName(String value);

public  void setWorkflowId(String value);

public  void setChannelPay(long value);

public  void setBusinesscheckplan(String value);

public  void setPromoteDepart(String value);

public  void setLabel(String value);

public  void setPromoteManager(String value);

public  void setSaleMainCode(String value);

public  void setProrplan(String value);

public  void setFeeDiscount(long value);

public  void setEndTime(Timestamp value);

public  void setIsSubmit(String value);

public  void setEstimateOtherFee(long value);
}
