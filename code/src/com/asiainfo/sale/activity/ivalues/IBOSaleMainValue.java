package com.asiainfo.sale.activity.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOSaleMainValue extends DataStructInterface{

  public final static  String S_Aim = "AIM";
  public final static  String S_ModifyTime = "MODIFY_TIME";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_Statrequest = "STATREQUEST";
  public final static  String S_Saledemand = "SALEDEMAND";
  public final static  String S_Explanation = "EXPLANATION";
  public final static  String S_Isgroup = "ISGROUP";
  public final static  String S_ProjecterTelnum = "PROJECTER_TELNUM";
  public final static  String S_GroupProp = "GROUP_PROP";
  public final static  String S_ActiveSaleSite = "ACTIVE_SALE_SITE";
  public final static  String S_ChannelType = "CHANNEL_TYPE";
  public final static  String S_BeginTime = "BEGIN_TIME";
  public final static  String S_SaleMainName = "SALE_MAIN_NAME";
  public final static  String S_Content = "CONTENT";
  public final static  String S_IsactiveSale = "ISACTIVE_SALE";
  public final static  String S_Id = "ID";
  public final static  String S_GradeDefaultRelation = "GRADE_DEFAULT_RELATION";
  public final static  String S_Businesscheckplan = "BUSINESSCHECKPLAN";
  public final static  String S_ActivityType = "ACTIVITY_TYPE";
  public final static  String S_PromoteDepart = "PROMOTE_DEPART";
  public final static  String S_Marktype = "MARKTYPE";
  public final static  String S_Remark1 = "REMARK1";
  public final static  String S_Remark2 = "REMARK2";
  public final static  String S_DetailInfo = "DETAIL_INFO";
  public final static  String S_Remark3 = "REMARK3";
  public final static  String S_Remark4 = "REMARK4";
  public final static  String S_Remark5 = "REMARK5";
  public final static  String S_BackGround = "BACK_GROUND";
  public final static  String S_Specialnote = "SPECIALNOTE";
  public final static  String S_Exearea = "EXEAREA";
  public final static  String S_SaleObject = "SALE_OBJECT";
  public final static  String S_PromoteManager = "PROMOTE_MANAGER";
  public final static  String S_Principal = "PRINCIPAL";
  public final static  String S_SaleMainType = "SALE_MAIN_TYPE";
  public final static  String S_Projecter = "PROJECTER";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_NeedAssignStaff = "NEED_ASSIGN_STAFF";
  public final static  String S_ExerciseType = "EXERCISE_TYPE";
  public final static  String S_SaleMainCode = "SALE_MAIN_CODE";
  public final static  String S_Prorplan = "PRORPLAN";
  public final static  String S_EndTime = "END_TIME";
  public final static  String S_IsSubmit = "IS_SUBMIT";
  public final static  String S_EChannelBear = "E_CHANNEL_BEAR";


public String getAim();

public Timestamp getModifyTime();

public Timestamp getCreateTime();

public String getStatrequest();

public String getSaledemand();

public String getExplanation();

public String getIsgroup();

public long getProjecterTelnum();

public String getGroupProp();

public String getActiveSaleSite();

public String getChannelType();

public Timestamp getBeginTime();

public String getSaleMainName();

public String getContent();

public String getIsactiveSale();

public String getId();

public String getGradeDefaultRelation();

public String getBusinesscheckplan();

public String getActivityType();

public String getPromoteDepart();

public String getMarktype();

public String getRemark1();

public String getRemark2();

public String getDetailInfo();

public String getRemark3();

public String getRemark4();

public String getRemark5();

public String getBackGround();

public String getSpecialnote();

public String getExearea();

public String getSaleObject();

public String getPromoteManager();

public String getPrincipal();

public String getSaleMainType();

public String getProjecter();

public String getOrderId();

public String getNeedAssignStaff();

public String getExerciseType();

public String getSaleMainCode();

public String getProrplan();

public Timestamp getEndTime();

public String getIsSubmit();

public String getEChannelBear();

public  void setAim(String value);

public  void setModifyTime(Timestamp value);

public  void setCreateTime(Timestamp value);

public  void setStatrequest(String value);

public  void setSaledemand(String value);

public  void setExplanation(String value);

public  void setIsgroup(String value);

public  void setProjecterTelnum(long value);

public  void setGroupProp(String value);

public  void setActiveSaleSite(String value);

public  void setChannelType(String value);

public  void setBeginTime(Timestamp value);

public  void setSaleMainName(String value);

public  void setContent(String value);

public  void setIsactiveSale(String value);

public  void setId(String value);

public  void setGradeDefaultRelation(String value);

public  void setBusinesscheckplan(String value);

public  void setActivityType(String value);

public  void setPromoteDepart(String value);

public  void setMarktype(String value);

public  void setRemark1(String value);

public  void setRemark2(String value);

public  void setDetailInfo(String value);

public  void setRemark3(String value);

public  void setRemark4(String value);

public  void setRemark5(String value);

public  void setBackGround(String value);

public  void setSpecialnote(String value);

public  void setExearea(String value);

public  void setSaleObject(String value);

public  void setPromoteManager(String value);

public  void setPrincipal(String value);

public  void setSaleMainType(String value);

public  void setProjecter(String value);

public  void setOrderId(String value);

public  void setNeedAssignStaff(String value);

public  void setExerciseType(String value);

public  void setSaleMainCode(String value);

public  void setProrplan(String value);

public  void setEndTime(Timestamp value);

public  void setIsSubmit(String value);

public  void setEChannelBear(String value);
}
