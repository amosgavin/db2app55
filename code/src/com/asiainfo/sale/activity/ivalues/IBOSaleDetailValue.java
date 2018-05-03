package com.asiainfo.sale.activity.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOSaleDetailValue extends DataStructInterface{

  public final static  String S_SaletypeDesOthersale = "SALETYPE_DES_OTHERSALE";
  public final static  String S_HandleEmployeeId = "HANDLE_EMPLOYEE_ID";
  public final static  String S_PreIncome = "PRE_INCOME";
  public final static  String S_TerminalCost = "TERMINAL_COST";
  public final static  String S_BrandDesc = "BRAND_DESC";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_PreDiscount = "PRE_DISCOUNT";
  public final static  String S_SaleActiveCode = "SALE_ACTIVE_CODE";
  public final static  String S_MobileCost = "MOBILE_COST";
  public final static  String S_SaleBackground = "SALE_BACKGROUND";
  public final static  String S_PreAddPerson = "PRE_ADD_PERSON";
  public final static  String S_BackProportion = "BACK_PROPORTION";
  public final static  String S_SalePoint = "SALE_POINT";
  public final static  String S_Reserve1 = "RESERVE1";
  public final static  String S_Id = "ID";
  public final static  String S_Reserve3 = "RESERVE3";
  public final static  String S_BusinessDiscount = "BUSINESS_DISCOUNT";
  public final static  String S_OtherBusiTarget = "OTHER_BUSI_TARGET";
  public final static  String S_Reserve2 = "RESERVE2";
  public final static  String S_ChannelPayPolicy = "CHANNEL_PAY_POLICY";
  public final static  String S_PromoteScore = "PROMOTE_SCORE";
  public final static  String S_CostTotal = "COST_TOTAL";
  public final static  String S_MobilepayCost = "MOBILEPAY_COST";
  public final static  String S_CustGroupName = "CUST_GROUP_NAME";
  public final static  String S_IsContractReason = "IS_CONTRACT_REASON";
  public final static  String S_ExcludeDemand = "EXCLUDE_DEMAND";
  public final static  String S_SaleId = "SALE_ID";
  public final static  String S_CustGroupTab = "CUST_GROUP_TAB";
  public final static  String S_ElecgoodsCost = "ELECGOODS_COST";
  public final static  String S_HandleWebsiteId = "HANDLE_WEBSITE_ID";
  public final static  String S_SaleTarget = "SALE_TARGET";
  public final static  String S_ElecpayCost = "ELECPAY_COST";
  public final static  String S_SaleScope = "SALE_SCOPE";
  public final static  String S_PrePerson = "PRE_PERSON";
  public final static  String S_PreBaseFee = "PRE_BASE_FEE";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_Ext6 = "EXT6";
  public final static  String S_Ext7 = "EXT7";
  public final static  String S_Ext8 = "EXT8";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_Ext4 = "EXT4";
  public final static  String S_EstimateAdFee = "ESTIMATE_AD_FEE";
  public final static  String S_ModifyTime = "MODIFY_TIME";
  public final static  String S_PreIncome2 = "PRE_INCOME2";
  public final static  String S_CgroupBeginTime = "CGROUP_BEGIN_TIME";
  public final static  String S_LevelDesc = "LEVEL_DESC";
  public final static  String S_SaleContent = "SALE_CONTENT";
  public final static  String S_ActiveSaleSite = "ACTIVE_SALE_SITE";
  public final static  String S_Market = "MARKET";
  public final static  String S_SaletypeOthersale = "SALETYPE_OTHERSALE";
  public final static  String S_OtherUserinfo = "OTHER_USERINFO";
  public final static  String S_BeginTime = "BEGIN_TIME";
  public final static  String S_IsactiveSale = "ISACTIVE_SALE";
  public final static  String S_OpenChannel = "OPEN_CHANNEL";
  public final static  String S_WeaponId = "WEAPON_ID";
  public final static  String S_GoodsCost = "GOODS_COST";
  public final static  String S_ActionOut = "ACTION_OUT";
  public final static  String S_ChannelPay = "CHANNEL_PAY";
  public final static  String S_CgroupRegion = "CGROUP_REGION";
  public final static  String S_PublicityWord = "PUBLICITY_WORD";
  public final static  String S_SaleActiveName = "SALE_ACTIVE_NAME";
  public final static  String S_IsContract = "IS_CONTRACT";
  public final static  String S_MaxPerson = "MAX_PERSON";
  public final static  String S_CgroupEndTime = "CGROUP_END_TIME";
  public final static  String S_TargetListCode = "TARGET_LIST_CODE";
  public final static  String S_ManageCondition = "MANAGE_CONDITION";
  public final static  String S_LevelCode = "LEVEL_CODE";
  public final static  String S_SaleFlag = "SALE_FLAG";
  public final static  String S_PreStoreToPresent = "PRE_STORE_TO_PRESENT";
  public final static  String S_CustGroupId = "CUST_GROUP_ID";
  public final static  String S_EndTime = "END_TIME";
  public final static  String S_FeeDiscount = "FEE_DISCOUNT";
  public final static  String S_IsSendSms = "IS_SEND_SMS";
  public final static  String S_EstimateOtherFee = "ESTIMATE_OTHER_FEE";
  public final static  String S_HomeType = "HOME_TYPE";
  public final static  String S_IsLimitCombo = "IS_LIMIT_COMBO";
  public final static  String S_LimitAmount = "LIMIT_AMOUNT";
  public final static  String S_LimType = "LIM_TYPE";

public String getSaletypeDesOthersale();

public String getHandleEmployeeId();

public double getPreIncome();

public double getTerminalCost();

public String getBrandDesc();

public Timestamp getCreateTime();

public double getPreDiscount();

public String getSaleActiveCode();

public double getMobileCost();

public String getSaleBackground();

public int getPreAddPerson();

public double getBackProportion();

public double getSalePoint();

public double getReserve1();

public String getId();

public String getReserve3();

public double getBusinessDiscount();

public String getOtherBusiTarget();

public double getReserve2();

public String getChannelPayPolicy();

public String getPromoteScore();

public double getCostTotal();

public double getMobilepayCost();

public String getCustGroupName();

public String getIsContractReason();

public String getExcludeDemand();

public String getSaleId();

public String getCustGroupTab();

public double getElecgoodsCost();

public String getHandleWebsiteId();

public String getSaleTarget();

public double getElecpayCost();

public String getSaleScope();

public int getPrePerson();

public double getPreBaseFee();

public String getExt5();

public int getExt6();

public int getExt7();

public double getExt8();

public String getExt1();

public String getExt2();

public String getExt3();

public String getExt4();

public double getEstimateAdFee();

public Timestamp getModifyTime();

public double getPreIncome2();

public Timestamp getCgroupBeginTime();

public String getLevelDesc();

public String getSaleContent();

public String getActiveSaleSite();

public String getMarket();

public String getSaletypeOthersale();

public String getOtherUserinfo();

public Timestamp getBeginTime();

public String getIsactiveSale();

public String getOpenChannel();

public String getWeaponId();

public double getGoodsCost();

public double getActionOut();

public double getChannelPay();

public String getCgroupRegion();

public String getPublicityWord();

public String getSaleActiveName();

public String getIsContract();

public int getMaxPerson();

public Timestamp getCgroupEndTime();

public String getTargetListCode();

public String getManageCondition();

public String getLevelCode();

public String getSaleFlag();

public double getPreStoreToPresent();

public String getCustGroupId();

public Timestamp getEndTime();

public double getFeeDiscount();

public String getIsSendSms();

public double getEstimateOtherFee();

public String getHomeType();

public String getIsLimitCombo();

public double getLimitAmount();

public String getLimType();


public  void setSaletypeDesOthersale(String value);

public  void setHandleEmployeeId(String value);

public  void setPreIncome(double value);

public  void setTerminalCost(double value);

public  void setBrandDesc(String value);

public  void setCreateTime(Timestamp value);

public  void setPreDiscount(double value);

public  void setSaleActiveCode(String value);

public  void setMobileCost(double value);

public  void setSaleBackground(String value);

public  void setPreAddPerson(int value);

public  void setBackProportion(double value);

public  void setSalePoint(double value);

public  void setReserve1(double value);

public  void setId(String value);

public  void setReserve3(String value);

public  void setBusinessDiscount(double value);

public  void setOtherBusiTarget(String value);

public  void setReserve2(double value);

public  void setChannelPayPolicy(String value);

public  void setPromoteScore(String value);

public  void setCostTotal(double value);

public  void setMobilepayCost(double value);

public  void setCustGroupName(String value);

public  void setIsContractReason(String value);

public  void setExcludeDemand(String value);

public  void setSaleId(String value);

public  void setCustGroupTab(String value);

public  void setElecgoodsCost(double value);

public  void setHandleWebsiteId(String value);

public  void setSaleTarget(String value);

public  void setElecpayCost(double value);

public  void setSaleScope(String value);

public  void setPrePerson(int value);

public  void setPreBaseFee(double value);

public  void setExt5(String value);

public  void setExt6(int value);

public  void setExt7(int value);

public  void setExt8(double value);

public  void setExt1(String value);

public  void setExt2(String value);

public  void setExt3(String value);

public  void setExt4(String value);

public  void setEstimateAdFee(double value);

public  void setModifyTime(Timestamp value);

public  void setPreIncome2(double value);

public  void setCgroupBeginTime(Timestamp value);

public  void setLevelDesc(String value);

public  void setSaleContent(String value);

public  void setActiveSaleSite(String value);

public  void setMarket(String value);

public  void setSaletypeOthersale(String value);

public  void setOtherUserinfo(String value);

public  void setBeginTime(Timestamp value);

public  void setIsactiveSale(String value);

public  void setOpenChannel(String value);

public  void setWeaponId(String value);

public  void setGoodsCost(double value);

public  void setActionOut(double value);

public  void setChannelPay(double value);

public  void setCgroupRegion(String value);

public  void setPublicityWord(String value);

public  void setSaleActiveName(String value);

public  void setIsContract(String value);

public  void setMaxPerson(int value);

public  void setCgroupEndTime(Timestamp value);

public  void setTargetListCode(String value);

public  void setManageCondition(String value);

public  void setLevelCode(String value);

public  void setSaleFlag(String value);

public  void setPreStoreToPresent(double value);

public  void setCustGroupId(String value);

public  void setEndTime(Timestamp value);

public  void setFeeDiscount(double value);

public  void setIsSendSms(String value);

public  void setEstimateOtherFee(double value);

public  void setHomeType(String value);

public void setIsLimitCombo(String value);

public void setLimitAmount(double value);

public void setLimType(String value);

}
