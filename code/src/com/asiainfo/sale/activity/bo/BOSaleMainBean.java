package com.asiainfo.sale.activity.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.activity.ivalues.*;

public class BOSaleMainBean extends DataContainer implements DataContainerInterface,IBOSaleMainValue{

  private static String  m_boName = "com.asiainfo.sale.activity.bo.BOSaleMain";



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

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOSaleMainBean() throws AIException{
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

  public void initProjecterTelnum(long value){
     this.initProperty(S_ProjecterTelnum,new Long(value));
  }
  public  void setProjecterTelnum(long value){
     this.set(S_ProjecterTelnum,new Long(value));
  }
  public  void setProjecterTelnumNull(){
     this.set(S_ProjecterTelnum,null);
  }

  public long getProjecterTelnum(){
        return DataType.getAsLong(this.get(S_ProjecterTelnum));
  
  }
  public long getProjecterTelnumInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ProjecterTelnum));
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

  public void initChannelType(String value){
     this.initProperty(S_ChannelType,value);
  }
  public  void setChannelType(String value){
     this.set(S_ChannelType,value);
  }
  public  void setChannelTypeNull(){
     this.set(S_ChannelType,null);
  }

  public String getChannelType(){
       return DataType.getAsString(this.get(S_ChannelType));
  
  }
  public String getChannelTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChannelType));
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

  public void initGradeDefaultRelation(String value){
     this.initProperty(S_GradeDefaultRelation,value);
  }
  public  void setGradeDefaultRelation(String value){
     this.set(S_GradeDefaultRelation,value);
  }
  public  void setGradeDefaultRelationNull(){
     this.set(S_GradeDefaultRelation,null);
  }

  public String getGradeDefaultRelation(){
       return DataType.getAsString(this.get(S_GradeDefaultRelation));
  
  }
  public String getGradeDefaultRelationInitialValue(){
        return DataType.getAsString(this.getOldObj(S_GradeDefaultRelation));
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

  public void initSaleMainType(String value){
     this.initProperty(S_SaleMainType,value);
  }
  public  void setSaleMainType(String value){
     this.set(S_SaleMainType,value);
  }
  public  void setSaleMainTypeNull(){
     this.set(S_SaleMainType,null);
  }

  public String getSaleMainType(){
       return DataType.getAsString(this.get(S_SaleMainType));
  
  }
  public String getSaleMainTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleMainType));
      }

  public void initProjecter(String value){
     this.initProperty(S_Projecter,value);
  }
  public  void setProjecter(String value){
     this.set(S_Projecter,value);
  }
  public  void setProjecterNull(){
     this.set(S_Projecter,null);
  }

  public String getProjecter(){
       return DataType.getAsString(this.get(S_Projecter));
  
  }
  public String getProjecterInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Projecter));
      }

  public void initOrderId(String value){
     this.initProperty(S_OrderId,value);
  }
  public  void setOrderId(String value){
     this.set(S_OrderId,value);
  }
  public  void setOrderIdNull(){
     this.set(S_OrderId,null);
  }

  public String getOrderId(){
       return DataType.getAsString(this.get(S_OrderId));
  
  }
  public String getOrderIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrderId));
      }

  public void initNeedAssignStaff(String value){
     this.initProperty(S_NeedAssignStaff,value);
  }
  public  void setNeedAssignStaff(String value){
     this.set(S_NeedAssignStaff,value);
  }
  public  void setNeedAssignStaffNull(){
     this.set(S_NeedAssignStaff,null);
  }

  public String getNeedAssignStaff(){
       return DataType.getAsString(this.get(S_NeedAssignStaff));
  
  }
  public String getNeedAssignStaffInitialValue(){
        return DataType.getAsString(this.getOldObj(S_NeedAssignStaff));
      }

  public void initExerciseType(String value){
     this.initProperty(S_ExerciseType,value);
  }
  public  void setExerciseType(String value){
     this.set(S_ExerciseType,value);
  }
  public  void setExerciseTypeNull(){
     this.set(S_ExerciseType,null);
  }

  public String getExerciseType(){
       return DataType.getAsString(this.get(S_ExerciseType));
  
  }
  public String getExerciseTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExerciseType));
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
      
 public void initEChannelBear(String value){
     this.initProperty(S_EChannelBear,value);
  }
  public  void setEChannelBear(String value){
     this.set(S_EChannelBear,value);
  }
  public  void setEChannelBearNull(){
     this.set(S_EChannelBear,null);
  }

  public String getEChannelBear(){
       return DataType.getAsString(this.get(S_EChannelBear));
  
  }
  public String getEChannelBearInitialValue(){
        return DataType.getAsString(this.getOldObj(S_EChannelBear));
      }
	  

 
 }

