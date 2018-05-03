package com.asiainfo.sale.prestore.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOSaleBatchPrestoreValue extends DataStructInterface{

  public final static  String S_OperatorId = "OPERATOR_ID";
  public final static  String S_ModifyTime = "MODIFY_TIME";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_SmsSendType = "SMS_SEND_TYPE";
  public final static  String S_AreaCode = "AREA_CODE";
  public final static  String S_SendRange = "SEND_RANGE";
  public final static  String S_FundReason = "FUND_REASON";
  public final static  String S_BossDoneCode = "BOSS_DONE_CODE";
  public final static  String S_ProvideBeginDate = "PROVIDE_BEGIN_DATE";
  public final static  String S_Id = "ID";
  public final static  String S_ApplyAmount = "APPLY_AMOUNT";
  public final static  String S_UserNumber = "USER_NUMBER";
  public final static  String S_OperType = "OPER_TYPE";
  public final static  String S_FundRange = "FUND_RANGE";
  public final static  String S_PromoteDepart = "PROMOTE_DEPART";
  public final static  String S_SmsContent = "SMS_CONTENT";
  public final static  String S_ApplyName = "APPLY_NAME";
  public final static  String S_BusiType = "BUSI_TYPE";
  public final static  String S_BusinessReview = "BUSINESS_REVIEW";
  public final static  String S_ProvideEndDate = "PROVIDE_END_DATE";
  public final static  String S_IsDelete = "IS_DELETE";
  public final static  String S_PromoteManager = "PROMOTE_MANAGER";
  public final static  String S_Principal = "PRINCIPAL";
  public final static  String S_FileName = "FILE_NAME";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_DoneTime = "DONE_TIME";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_IsSubmit = "IS_SUBMIT";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_Ext4 = "EXT4";

  public void unDelete();
public String getOperatorId();

public Timestamp getModifyTime();

public String getRemarks();

public Timestamp getCreateTime();

public String getSmsSendType();

public String getAreaCode();

public String getSendRange();

public String getFundReason();

public String getBossDoneCode();

public Timestamp getProvideBeginDate();

public String getId();

public double getApplyAmount();

public String getUserNumber();

public String getOperType();

public String getFundRange();

public String getPromoteDepart();

public String getSmsContent();

public String getApplyName();

public String getBusiType();

public String getBusinessReview();

public Timestamp getProvideEndDate();

public String getIsDelete();

public String getPromoteManager();

public String getPrincipal();

public String getFileName();

public String getExt5();

public Timestamp getDoneTime();

public String getExt1();

public String getIsSubmit();

public String getExt2();

public String getExt3();

public String getExt4();


public  void setOperatorId(String value);

public  void setModifyTime(Timestamp value);

public  void setRemarks(String value);

public  void setCreateTime(Timestamp value);

public  void setSmsSendType(String value);

public  void setAreaCode(String value);

public  void setSendRange(String value);

public  void setFundReason(String value);

public  void setBossDoneCode(String value);

public  void setProvideBeginDate(Timestamp value);

public  void setId(String value);

public  void setApplyAmount(double value);

public  void setUserNumber(String value);

public  void setOperType(String value);

public  void setFundRange(String value);

public  void setPromoteDepart(String value);

public  void setSmsContent(String value);

public  void setApplyName(String value);

public  void setBusiType(String value);

public  void setBusinessReview(String value);

public  void setProvideEndDate(Timestamp value);

public  void setIsDelete(String value);

public  void setPromoteManager(String value);

public  void setPrincipal(String value);

public  void setFileName(String value);

public  void setExt5(String value);

public  void setDoneTime(Timestamp value);

public  void setExt1(String value);

public  void setIsSubmit(String value);

public  void setExt2(String value);

public  void setExt3(String value);

public  void setExt4(String value);
}
