package com.asiainfo.charge.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOChargeApplyProdAttrExtValue extends DataStructInterface{

  public final static  String S_IncomeShare = "INCOME_SHARE";
  public final static  String S_PreferentialConditions = "PREFERENTIAL_CONDITIONS";
  public final static  String S_State = "STATE";
  public final static  String S_ModifyTime = "MODIFY_TIME";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_IsMinimumCharge = "IS_MINIMUM_CHARGE";
  public final static  String S_MonthlyFee = "MONTHLY_FEE";
  public final static  String S_SettlementInstructions = "SETTLEMENT_INSTRUCTIONS";
  public final static  String S_ChargeProcess = "CHARGE_PROCESS";
  public final static  String S_ChargeId = "CHARGE_ID";
  public final static  String S_AreaCode = "AREA_CODE";
  public final static  String S_PreferentialRange = "PREFERENTIAL_RANGE";
  public final static  String S_ChargeRepulsion = "CHARGE_REPULSION";
  public final static  String S_OtherPreferential = "OTHER_PREFERENTIAL";
  public final static  String S_IsMonthlyRent = "IS_MONTHLY_RENT";
  public final static  String S_MinimumChargeRange = "MINIMUM_CHARGE_RANGE";
  public final static  String S_OperType = "OPER_TYPE";
  public final static  String S_TestDepart = "TEST_DEPART";
  public final static  String S_DisposableIncome = "DISPOSABLE_INCOME";
  public final static  String S_PromoteDepart = "PROMOTE_DEPART";
  public final static  String S_ApplyId = "APPLY_ID";
  public final static  String S_TestTime = "TEST_TIME";
  public final static  String S_Rounding = "ROUNDING";
  public final static  String S_ApplyName = "APPLY_NAME";
  public final static  String S_NonDisposableIncome = "NON_DISPOSABLE_INCOME";
  public final static  String S_TestResult = "TEST_RESULT";
  public final static  String S_ProductDescription = "PRODUCT_DESCRIPTION";
  public final static  String S_Principal = "PRINCIPAL";
  public final static  String S_OtherChargeRequirement = "OTHER_CHARGE_REQUIREMENT";
  public final static  String S_IsUserProcess = "IS_USER_PROCESS";
  public final static  String S_TestPrincipal = "TEST_PRINCIPAL";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_Ext6 = "EXT6";
  public final static  String S_Ext7 = "EXT7";
  public final static  String S_ReportDetails = "REPORT_DETAILS";
  public final static  String S_DoneTime = "DONE_TIME";
  public final static  String S_Ext8 = "EXT8";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_ChannelDescription = "CHANNEL_DESCRIPTION";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_Ext4 = "EXT4";


public String getIncomeShare();

public String getPreferentialConditions();

public String getState();

public Timestamp getModifyTime();

public String getRemarks();

public Timestamp getCreateTime();

public String getIsMinimumCharge();

public double getMonthlyFee();

public String getSettlementInstructions();

public String getChargeProcess();

public String getChargeId();

public String getAreaCode();

public String getPreferentialRange();

public String getChargeRepulsion();

public String getOtherPreferential();

public String getIsMonthlyRent();

public String getMinimumChargeRange();

public String getOperType();

public String getTestDepart();

public String getDisposableIncome();

public String getPromoteDepart();

public String getApplyId();

public Timestamp getTestTime();

public String getRounding();

public String getApplyName();

public String getNonDisposableIncome();

public String getTestResult();

public String getProductDescription();

public String getPrincipal();

public String getOtherChargeRequirement();

public String getIsUserProcess();

public String getTestPrincipal();

public int getExt5();

public int getExt6();

public double getExt7();

public String getReportDetails();

public Timestamp getDoneTime();

public double getExt8();

public String getExt1();

public String getChannelDescription();

public String getExt2();

public String getExt3();

public String getExt4();


public  void setIncomeShare(String value);

public  void setPreferentialConditions(String value);

public  void setState(String value);

public  void setModifyTime(Timestamp value);

public  void setRemarks(String value);

public  void setCreateTime(Timestamp value);

public  void setIsMinimumCharge(String value);

public  void setMonthlyFee(double value);

public  void setSettlementInstructions(String value);

public  void setChargeProcess(String value);

public  void setChargeId(String value);

public  void setAreaCode(String value);

public  void setPreferentialRange(String value);

public  void setChargeRepulsion(String value);

public  void setOtherPreferential(String value);

public  void setIsMonthlyRent(String value);

public  void setMinimumChargeRange(String value);

public  void setOperType(String value);

public  void setTestDepart(String value);

public  void setDisposableIncome(String value);

public  void setPromoteDepart(String value);

public  void setApplyId(String value);

public  void setTestTime(Timestamp value);

public  void setRounding(String value);

public  void setApplyName(String value);

public  void setNonDisposableIncome(String value);

public  void setTestResult(String value);

public  void setProductDescription(String value);

public  void setPrincipal(String value);

public  void setOtherChargeRequirement(String value);

public  void setIsUserProcess(String value);

public  void setTestPrincipal(String value);

public  void setExt5(int value);

public  void setExt6(int value);

public  void setExt7(double value);

public  void setReportDetails(String value);

public  void setDoneTime(Timestamp value);

public  void setExt8(double value);

public  void setExt1(String value);

public  void setChannelDescription(String value);

public  void setExt2(String value);

public  void setExt3(String value);

public  void setExt4(String value);
}
