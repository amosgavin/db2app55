package com.asiainfo.sale.activity.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.activity.ivalues.*;

public class BOSaleMainShowBean extends DataContainer implements DataContainerInterface,IBOSaleMainShowValue{

  private static String  m_boName = "com.asiainfo.sale.activity.bo.BOSaleMainShow";



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

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOSaleMainShowBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initAim(String value){
     this.initProperty(S_Aim,value);
  }
  public  void setAim(String value){
     this.set(S_Aim,value);
  }
  public  void setAimNull(){
     this.set(S_Aim,null);
  }

  public String getAim(){
       return DataType.getAsString(this.get(S_Aim));
  
  }
  public String getAimInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Aim));
      }

  public void initPreIncome(long value){
     this.initProperty(S_PreIncome,new Long(value));
  }
  public  void setPreIncome(long value){
     this.set(S_PreIncome,new Long(value));
  }
  public  void setPreIncomeNull(){
     this.set(S_PreIncome,null);
  }

  public long getPreIncome(){
        return DataType.getAsLong(this.get(S_PreIncome));
  
  }
  public long getPreIncomeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PreIncome));
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

  public void initSaledemand(String value){
     this.initProperty(S_Saledemand,value);
  }
  public  void setSaledemand(String value){
     this.set(S_Saledemand,value);
  }
  public  void setSaledemandNull(){
     this.set(S_Saledemand,null);
  }

  public String getSaledemand(){
       return DataType.getAsString(this.get(S_Saledemand));
  
  }
  public String getSaledemandInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Saledemand));
      }

  public void initStateDate(Timestamp value){
     this.initProperty(S_StateDate,value);
  }
  public  void setStateDate(Timestamp value){
     this.set(S_StateDate,value);
  }
  public  void setStateDateNull(){
     this.set(S_StateDate,null);
  }

  public Timestamp getStateDate(){
        return DataType.getAsDateTime(this.get(S_StateDate));
  
  }
  public Timestamp getStateDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_StateDate));
      }

  public void initMobileCost(long value){
     this.initProperty(S_MobileCost,new Long(value));
  }
  public  void setMobileCost(long value){
     this.set(S_MobileCost,new Long(value));
  }
  public  void setMobileCostNull(){
     this.set(S_MobileCost,null);
  }

  public long getMobileCost(){
        return DataType.getAsLong(this.get(S_MobileCost));
  
  }
  public long getMobileCostInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_MobileCost));
      }

  public void initPreAddPerson(long value){
     this.initProperty(S_PreAddPerson,new Long(value));
  }
  public  void setPreAddPerson(long value){
     this.set(S_PreAddPerson,new Long(value));
  }
  public  void setPreAddPersonNull(){
     this.set(S_PreAddPerson,null);
  }

  public long getPreAddPerson(){
        return DataType.getAsLong(this.get(S_PreAddPerson));
  
  }
  public long getPreAddPersonInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PreAddPerson));
      }

  public void initSaleMainName(String value){
     this.initProperty(S_SaleMainName,value);
  }
  public  void setSaleMainName(String value){
     this.set(S_SaleMainName,value);
  }
  public  void setSaleMainNameNull(){
     this.set(S_SaleMainName,null);
  }

  public String getSaleMainName(){
       return DataType.getAsString(this.get(S_SaleMainName));
  
  }
  public String getSaleMainNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleMainName));
      }

  public void initId(String value){
     this.initProperty(S_Id,value);
  }
  public  void setId(String value){
     this.set(S_Id,value);
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public String getId(){
       return DataType.getAsString(this.get(S_Id));
  
  }
  public String getIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Id));
      }

  public void initBusinessDiscount(long value){
     this.initProperty(S_BusinessDiscount,new Long(value));
  }
  public  void setBusinessDiscount(long value){
     this.set(S_BusinessDiscount,new Long(value));
  }
  public  void setBusinessDiscountNull(){
     this.set(S_BusinessDiscount,null);
  }

  public long getBusinessDiscount(){
        return DataType.getAsLong(this.get(S_BusinessDiscount));
  
  }
  public long getBusinessDiscountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BusinessDiscount));
      }

  public void initActivityType(String value){
     this.initProperty(S_ActivityType,value);
  }
  public  void setActivityType(String value){
     this.set(S_ActivityType,value);
  }
  public  void setActivityTypeNull(){
     this.set(S_ActivityType,null);
  }

  public String getActivityType(){
       return DataType.getAsString(this.get(S_ActivityType));
  
  }
  public String getActivityTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ActivityType));
      }

  public void initCostTotal(long value){
     this.initProperty(S_CostTotal,new Long(value));
  }
  public  void setCostTotal(long value){
     this.set(S_CostTotal,new Long(value));
  }
  public  void setCostTotalNull(){
     this.set(S_CostTotal,null);
  }

  public long getCostTotal(){
        return DataType.getAsLong(this.get(S_CostTotal));
  
  }
  public long getCostTotalInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CostTotal));
      }

  public void initMobilepayCost(long value){
     this.initProperty(S_MobilepayCost,new Long(value));
  }
  public  void setMobilepayCost(long value){
     this.set(S_MobilepayCost,new Long(value));
  }
  public  void setMobilepayCostNull(){
     this.set(S_MobilepayCost,null);
  }

  public long getMobilepayCost(){
        return DataType.getAsLong(this.get(S_MobilepayCost));
  
  }
  public long getMobilepayCostInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_MobilepayCost));
      }

  public void initMarktype(String value){
     this.initProperty(S_Marktype,value);
  }
  public  void setMarktype(String value){
     this.set(S_Marktype,value);
  }
  public  void setMarktypeNull(){
     this.set(S_Marktype,null);
  }

  public String getMarktype(){
       return DataType.getAsString(this.get(S_Marktype));
  
  }
  public String getMarktypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Marktype));
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

  public void initDetailInfo(String value){
     this.initProperty(S_DetailInfo,value);
  }
  public  void setDetailInfo(String value){
     this.set(S_DetailInfo,value);
  }
  public  void setDetailInfoNull(){
     this.set(S_DetailInfo,null);
  }

  public String getDetailInfo(){
       return DataType.getAsString(this.get(S_DetailInfo));
  
  }
  public String getDetailInfoInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DetailInfo));
      }

  public void initOrganizeName(String value){
     this.initProperty(S_OrganizeName,value);
  }
  public  void setOrganizeName(String value){
     this.set(S_OrganizeName,value);
  }
  public  void setOrganizeNameNull(){
     this.set(S_OrganizeName,null);
  }

  public String getOrganizeName(){
       return DataType.getAsString(this.get(S_OrganizeName));
  
  }
  public String getOrganizeNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrganizeName));
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

  public void initBackGround(String value){
     this.initProperty(S_BackGround,value);
  }
  public  void setBackGround(String value){
     this.set(S_BackGround,value);
  }
  public  void setBackGroundNull(){
     this.set(S_BackGround,null);
  }

  public String getBackGround(){
       return DataType.getAsString(this.get(S_BackGround));
  
  }
  public String getBackGroundInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BackGround));
      }

  public void initDescription(String value){
     this.initProperty(S_Description,value);
  }
  public  void setDescription(String value){
     this.set(S_Description,value);
  }
  public  void setDescriptionNull(){
     this.set(S_Description,null);
  }

  public String getDescription(){
       return DataType.getAsString(this.get(S_Description));
  
  }
  public String getDescriptionInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Description));
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

  public void initSpecialnote(String value){
     this.initProperty(S_Specialnote,value);
  }
  public  void setSpecialnote(String value){
     this.set(S_Specialnote,value);
  }
  public  void setSpecialnoteNull(){
     this.set(S_Specialnote,null);
  }

  public String getSpecialnote(){
       return DataType.getAsString(this.get(S_Specialnote));
  
  }
  public String getSpecialnoteInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Specialnote));
      }

  public void initExearea(String value){
     this.initProperty(S_Exearea,value);
  }
  public  void setExearea(String value){
     this.set(S_Exearea,value);
  }
  public  void setExeareaNull(){
     this.set(S_Exearea,null);
  }

  public String getExearea(){
       return DataType.getAsString(this.get(S_Exearea));
  
  }
  public String getExeareaInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Exearea));
      }

  public void initSaleObject(String value){
     this.initProperty(S_SaleObject,value);
  }
  public  void setSaleObject(String value){
     this.set(S_SaleObject,value);
  }
  public  void setSaleObjectNull(){
     this.set(S_SaleObject,null);
  }

  public String getSaleObject(){
       return DataType.getAsString(this.get(S_SaleObject));
  
  }
  public String getSaleObjectInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleObject));
      }

  public void initWorkflowObjectType(String value){
     this.initProperty(S_WorkflowObjectType,value);
  }
  public  void setWorkflowObjectType(String value){
     this.set(S_WorkflowObjectType,value);
  }
  public  void setWorkflowObjectTypeNull(){
     this.set(S_WorkflowObjectType,null);
  }

  public String getWorkflowObjectType(){
       return DataType.getAsString(this.get(S_WorkflowObjectType));
  
  }
  public String getWorkflowObjectTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WorkflowObjectType));
      }

  public void initElecgoodsCost(long value){
     this.initProperty(S_ElecgoodsCost,new Long(value));
  }
  public  void setElecgoodsCost(long value){
     this.set(S_ElecgoodsCost,new Long(value));
  }
  public  void setElecgoodsCostNull(){
     this.set(S_ElecgoodsCost,null);
  }

  public long getElecgoodsCost(){
        return DataType.getAsLong(this.get(S_ElecgoodsCost));
  
  }
  public long getElecgoodsCostInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ElecgoodsCost));
      }

  public void initOrganizeNameF(String value){
     this.initProperty(S_OrganizeNameF,value);
  }
  public  void setOrganizeNameF(String value){
     this.set(S_OrganizeNameF,value);
  }
  public  void setOrganizeNameFNull(){
     this.set(S_OrganizeNameF,null);
  }

  public String getOrganizeNameF(){
       return DataType.getAsString(this.get(S_OrganizeNameF));
  
  }
  public String getOrganizeNameFInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrganizeNameF));
      }

  public void initElecpayCost(long value){
     this.initProperty(S_ElecpayCost,new Long(value));
  }
  public  void setElecpayCost(long value){
     this.set(S_ElecpayCost,new Long(value));
  }
  public  void setElecpayCostNull(){
     this.set(S_ElecpayCost,null);
  }

  public long getElecpayCost(){
        return DataType.getAsLong(this.get(S_ElecpayCost));
  
  }
  public long getElecpayCostInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ElecpayCost));
      }

  public void initPrincipal(String value){
     this.initProperty(S_Principal,value);
  }
  public  void setPrincipal(String value){
     this.set(S_Principal,value);
  }
  public  void setPrincipalNull(){
     this.set(S_Principal,null);
  }

  public String getPrincipal(){
       return DataType.getAsString(this.get(S_Principal));
  
  }
  public String getPrincipalInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Principal));
      }

  public void initPrePerson(long value){
     this.initProperty(S_PrePerson,new Long(value));
  }
  public  void setPrePerson(long value){
     this.set(S_PrePerson,new Long(value));
  }
  public  void setPrePersonNull(){
     this.set(S_PrePerson,null);
  }

  public long getPrePerson(){
        return DataType.getAsLong(this.get(S_PrePerson));
  
  }
  public long getPrePersonInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PrePerson));
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

  public void initTaskTag(String value){
     this.initProperty(S_TaskTag,value);
  }
  public  void setTaskTag(String value){
     this.set(S_TaskTag,value);
  }
  public  void setTaskTagNull(){
     this.set(S_TaskTag,null);
  }

  public String getTaskTag(){
       return DataType.getAsString(this.get(S_TaskTag));
  
  }
  public String getTaskTagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TaskTag));
      }

  public void initState(long value){
     this.initProperty(S_State,new Long(value));
  }
  public  void setState(long value){
     this.set(S_State,new Long(value));
  }
  public  void setStateNull(){
     this.set(S_State,null);
  }

  public long getState(){
        return DataType.getAsLong(this.get(S_State));
  
  }
  public long getStateInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_State));
      }

  public void initEstimateAdFee(long value){
     this.initProperty(S_EstimateAdFee,new Long(value));
  }
  public  void setEstimateAdFee(long value){
     this.set(S_EstimateAdFee,new Long(value));
  }
  public  void setEstimateAdFeeNull(){
     this.set(S_EstimateAdFee,null);
  }

  public long getEstimateAdFee(){
        return DataType.getAsLong(this.get(S_EstimateAdFee));
  
  }
  public long getEstimateAdFeeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_EstimateAdFee));
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

  public void initStatrequest(String value){
     this.initProperty(S_Statrequest,value);
  }
  public  void setStatrequest(String value){
     this.set(S_Statrequest,value);
  }
  public  void setStatrequestNull(){
     this.set(S_Statrequest,null);
  }

  public String getStatrequest(){
       return DataType.getAsString(this.get(S_Statrequest));
  
  }
  public String getStatrequestInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Statrequest));
      }

  public void initExplanation(String value){
     this.initProperty(S_Explanation,value);
  }
  public  void setExplanation(String value){
     this.set(S_Explanation,value);
  }
  public  void setExplanationNull(){
     this.set(S_Explanation,null);
  }

  public String getExplanation(){
       return DataType.getAsString(this.get(S_Explanation));
  
  }
  public String getExplanationInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Explanation));
      }

  public void initIsgroup(String value){
     this.initProperty(S_Isgroup,value);
  }
  public  void setIsgroup(String value){
     this.set(S_Isgroup,value);
  }
  public  void setIsgroupNull(){
     this.set(S_Isgroup,null);
  }

  public String getIsgroup(){
       return DataType.getAsString(this.get(S_Isgroup));
  
  }
  public String getIsgroupInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Isgroup));
      }

  public void initGroupProp(String value){
     this.initProperty(S_GroupProp,value);
  }
  public  void setGroupProp(String value){
     this.set(S_GroupProp,value);
  }
  public  void setGroupPropNull(){
     this.set(S_GroupProp,null);
  }

  public String getGroupProp(){
       return DataType.getAsString(this.get(S_GroupProp));
  
  }
  public String getGroupPropInitialValue(){
        return DataType.getAsString(this.getOldObj(S_GroupProp));
      }

  public void initFinishDate(Timestamp value){
     this.initProperty(S_FinishDate,value);
  }
  public  void setFinishDate(Timestamp value){
     this.set(S_FinishDate,value);
  }
  public  void setFinishDateNull(){
     this.set(S_FinishDate,null);
  }

  public Timestamp getFinishDate(){
        return DataType.getAsDateTime(this.get(S_FinishDate));
  
  }
  public Timestamp getFinishDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_FinishDate));
      }

  public void initActiveSaleSite(String value){
     this.initProperty(S_ActiveSaleSite,value);
  }
  public  void setActiveSaleSite(String value){
     this.set(S_ActiveSaleSite,value);
  }
  public  void setActiveSaleSiteNull(){
     this.set(S_ActiveSaleSite,null);
  }

  public String getActiveSaleSite(){
       return DataType.getAsString(this.get(S_ActiveSaleSite));
  
  }
  public String getActiveSaleSiteInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ActiveSaleSite));
      }

  public void initBeginTime(Timestamp value){
     this.initProperty(S_BeginTime,value);
  }
  public  void setBeginTime(Timestamp value){
     this.set(S_BeginTime,value);
  }
  public  void setBeginTimeNull(){
     this.set(S_BeginTime,null);
  }

  public Timestamp getBeginTime(){
        return DataType.getAsDateTime(this.get(S_BeginTime));
  
  }
  public Timestamp getBeginTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_BeginTime));
      }

  public void initContent(String value){
     this.initProperty(S_Content,value);
  }
  public  void setContent(String value){
     this.set(S_Content,value);
  }
  public  void setContentNull(){
     this.set(S_Content,null);
  }

  public String getContent(){
       return DataType.getAsString(this.get(S_Content));
  
  }
  public String getContentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Content));
      }

  public void initIsactiveSale(String value){
     this.initProperty(S_IsactiveSale,value);
  }
  public  void setIsactiveSale(String value){
     this.set(S_IsactiveSale,value);
  }
  public  void setIsactiveSaleNull(){
     this.set(S_IsactiveSale,null);
  }

  public String getIsactiveSale(){
       return DataType.getAsString(this.get(S_IsactiveSale));
  
  }
  public String getIsactiveSaleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsactiveSale));
      }

  public void initGoodsCost(long value){
     this.initProperty(S_GoodsCost,new Long(value));
  }
  public  void setGoodsCost(long value){
     this.set(S_GoodsCost,new Long(value));
  }
  public  void setGoodsCostNull(){
     this.set(S_GoodsCost,null);
  }

  public long getGoodsCost(){
        return DataType.getAsLong(this.get(S_GoodsCost));
  
  }
  public long getGoodsCostInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_GoodsCost));
      }

  public void initStaffName(String value){
     this.initProperty(S_StaffName,value);
  }
  public  void setStaffName(String value){
     this.set(S_StaffName,value);
  }
  public  void setStaffNameNull(){
     this.set(S_StaffName,null);
  }

  public String getStaffName(){
       return DataType.getAsString(this.get(S_StaffName));
  
  }
  public String getStaffNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StaffName));
      }

  public void initWorkflowId(String value){
     this.initProperty(S_WorkflowId,value);
  }
  public  void setWorkflowId(String value){
     this.set(S_WorkflowId,value);
  }
  public  void setWorkflowIdNull(){
     this.set(S_WorkflowId,null);
  }

  public String getWorkflowId(){
       return DataType.getAsString(this.get(S_WorkflowId));
  
  }
  public String getWorkflowIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WorkflowId));
      }

  public void initChannelPay(long value){
     this.initProperty(S_ChannelPay,new Long(value));
  }
  public  void setChannelPay(long value){
     this.set(S_ChannelPay,new Long(value));
  }
  public  void setChannelPayNull(){
     this.set(S_ChannelPay,null);
  }

  public long getChannelPay(){
        return DataType.getAsLong(this.get(S_ChannelPay));
  
  }
  public long getChannelPayInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ChannelPay));
      }

  public void initBusinesscheckplan(String value){
     this.initProperty(S_Businesscheckplan,value);
  }
  public  void setBusinesscheckplan(String value){
     this.set(S_Businesscheckplan,value);
  }
  public  void setBusinesscheckplanNull(){
     this.set(S_Businesscheckplan,null);
  }

  public String getBusinesscheckplan(){
       return DataType.getAsString(this.get(S_Businesscheckplan));
  
  }
  public String getBusinesscheckplanInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Businesscheckplan));
      }

  public void initPromoteDepart(String value){
     this.initProperty(S_PromoteDepart,value);
  }
  public  void setPromoteDepart(String value){
     this.set(S_PromoteDepart,value);
  }
  public  void setPromoteDepartNull(){
     this.set(S_PromoteDepart,null);
  }

  public String getPromoteDepart(){
       return DataType.getAsString(this.get(S_PromoteDepart));
  
  }
  public String getPromoteDepartInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PromoteDepart));
      }

  public void initLabel(String value){
     this.initProperty(S_Label,value);
  }
  public  void setLabel(String value){
     this.set(S_Label,value);
  }
  public  void setLabelNull(){
     this.set(S_Label,null);
  }

  public String getLabel(){
       return DataType.getAsString(this.get(S_Label));
  
  }
  public String getLabelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Label));
      }

  public void initPromoteManager(String value){
     this.initProperty(S_PromoteManager,value);
  }
  public  void setPromoteManager(String value){
     this.set(S_PromoteManager,value);
  }
  public  void setPromoteManagerNull(){
     this.set(S_PromoteManager,null);
  }

  public String getPromoteManager(){
       return DataType.getAsString(this.get(S_PromoteManager));
  
  }
  public String getPromoteManagerInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PromoteManager));
      }

  public void initSaleMainCode(String value){
     this.initProperty(S_SaleMainCode,value);
  }
  public  void setSaleMainCode(String value){
     this.set(S_SaleMainCode,value);
  }
  public  void setSaleMainCodeNull(){
     this.set(S_SaleMainCode,null);
  }

  public String getSaleMainCode(){
       return DataType.getAsString(this.get(S_SaleMainCode));
  
  }
  public String getSaleMainCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleMainCode));
      }

  public void initProrplan(String value){
     this.initProperty(S_Prorplan,value);
  }
  public  void setProrplan(String value){
     this.set(S_Prorplan,value);
  }
  public  void setProrplanNull(){
     this.set(S_Prorplan,null);
  }

  public String getProrplan(){
       return DataType.getAsString(this.get(S_Prorplan));
  
  }
  public String getProrplanInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Prorplan));
      }

  public void initFeeDiscount(long value){
     this.initProperty(S_FeeDiscount,new Long(value));
  }
  public  void setFeeDiscount(long value){
     this.set(S_FeeDiscount,new Long(value));
  }
  public  void setFeeDiscountNull(){
     this.set(S_FeeDiscount,null);
  }

  public long getFeeDiscount(){
        return DataType.getAsLong(this.get(S_FeeDiscount));
  
  }
  public long getFeeDiscountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_FeeDiscount));
      }

  public void initEndTime(Timestamp value){
     this.initProperty(S_EndTime,value);
  }
  public  void setEndTime(Timestamp value){
     this.set(S_EndTime,value);
  }
  public  void setEndTimeNull(){
     this.set(S_EndTime,null);
  }

  public Timestamp getEndTime(){
        return DataType.getAsDateTime(this.get(S_EndTime));
  
  }
  public Timestamp getEndTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_EndTime));
      }

  public void initIsSubmit(String value){
     this.initProperty(S_IsSubmit,value);
  }
  public  void setIsSubmit(String value){
     this.set(S_IsSubmit,value);
  }
  public  void setIsSubmitNull(){
     this.set(S_IsSubmit,null);
  }

  public String getIsSubmit(){
       return DataType.getAsString(this.get(S_IsSubmit));
  
  }
  public String getIsSubmitInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsSubmit));
      }

  public void initEstimateOtherFee(long value){
     this.initProperty(S_EstimateOtherFee,new Long(value));
  }
  public  void setEstimateOtherFee(long value){
     this.set(S_EstimateOtherFee,new Long(value));
  }
  public  void setEstimateOtherFeeNull(){
     this.set(S_EstimateOtherFee,null);
  }

  public long getEstimateOtherFee(){
        return DataType.getAsLong(this.get(S_EstimateOtherFee));
  
  }
  public long getEstimateOtherFeeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_EstimateOtherFee));
      }


 
 }

