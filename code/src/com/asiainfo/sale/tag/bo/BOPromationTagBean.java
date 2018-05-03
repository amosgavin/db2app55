package com.asiainfo.sale.tag.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.tag.ivalues.*;

public class BOPromationTagBean extends DataContainer implements DataContainerInterface,IBOPromationTagValue{

  private static String  m_boName = "com.asiainfo.sale.tag.bo.BOPromationTag";



  public final static  String S_State = "STATE";
  public final static  String S_Firstcharge = "FIRSTCHARGE";
  public final static  String S_Name = "NAME";
  public final static  String S_Area = "AREA";
  public final static  String S_IsSp = "IS_SP";
  public final static  String S_Pid = "PID";
  public final static  String S_TagCode = "TAG_CODE";
  public final static  String S_Remark = "REMARK";
  public final static  String S_Charge = "CHARGE";
  public final static  String S_StandbyNum1 = "STANDBY_NUM1";
  public final static  String S_AccountType = "ACCOUNT_TYPE";
  public final static  String S_Cycle = "CYCLE";
  public final static  String S_StandbyNum2 = "STANDBY_NUM2";
  public final static  String S_StandbyNum3 = "STANDBY_NUM3";
  public final static  String S_RemarkTag = "REMARK_TAG";
  public final static  String S_TagType = "TAG_TYPE";
  public final static  String S_AddMonthcharge = "ADD_MONTHCHARGE";
  public final static  String S_Sumcharge = "SUMCHARGE";
  public final static  String S_Lastcharge = "LASTCHARGE";
  public final static  String S_AccountRow = "ACCOUNT_ROW";
  public final static  String S_Id = "ID";
  public final static  String S_SubjectName = "SUBJECT_NAME";
  public final static  String S_ReturnType = "RETURN_TYPE";
  public final static  String S_LimType = "LIM_TYPE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOPromationTagBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //�������������������ҵ���������
   throw new AIException("Cannot reset ObjectType");
 }


  public void initState(String value){
     this.initProperty(S_State,value);
  }
  public  void setState(String value){
     this.set(S_State,value);
  }
  public  void setStateNull(){
     this.set(S_State,null);
  }

  public String getState(){
       return DataType.getAsString(this.get(S_State));
  
  }
  public String getStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_State));
      }

  public void initFirstcharge(String value){
     this.initProperty(S_Firstcharge,value);
  }
  public  void setFirstcharge(String value){
     this.set(S_Firstcharge,value);
  }
  public  void setFirstchargeNull(){
     this.set(S_Firstcharge,null);
  }

  public String getFirstcharge(){
       return DataType.getAsString(this.get(S_Firstcharge));
  
  }
  public String getFirstchargeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Firstcharge));
      }

  public void initName(String value){
     this.initProperty(S_Name,value);
  }
  public  void setName(String value){
     this.set(S_Name,value);
  }
  public  void setNameNull(){
     this.set(S_Name,null);
  }

  public String getName(){
       return DataType.getAsString(this.get(S_Name));
  
  }
  public String getNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Name));
      }

  public void initArea(String value){
     this.initProperty(S_Area,value);
  }
  public  void setArea(String value){
     this.set(S_Area,value);
  }
  public  void setAreaNull(){
     this.set(S_Area,null);
  }

  public String getArea(){
       return DataType.getAsString(this.get(S_Area));
  
  }
  public String getAreaInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Area));
      }

  public void initIsSp(String value){
     this.initProperty(S_IsSp,value);
  }
  public  void setIsSp(String value){
     this.set(S_IsSp,value);
  }
  public  void setIsSpNull(){
     this.set(S_IsSp,null);
  }

  public String getIsSp(){
       return DataType.getAsString(this.get(S_IsSp));
  
  }
  public String getIsSpInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsSp));
      }

  public void initPid(int value){
     this.initProperty(S_Pid,new Integer(value));
  }
  public  void setPid(int value){
     this.set(S_Pid,new Integer(value));
  }
  public  void setPidNull(){
     this.set(S_Pid,null);
  }

  public int getPid(){
        return DataType.getAsInt(this.get(S_Pid));
  
  }
  public int getPidInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Pid));
      }

  public void initTagCode(String value){
     this.initProperty(S_TagCode,value);
  }
  public  void setTagCode(String value){
     this.set(S_TagCode,value);
  }
  public  void setTagCodeNull(){
     this.set(S_TagCode,null);
  }

  public String getTagCode(){
       return DataType.getAsString(this.get(S_TagCode));
  
  }
  public String getTagCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TagCode));
      }

  public void initRemark(String value){
     this.initProperty(S_Remark,value);
  }
  public  void setRemark(String value){
     this.set(S_Remark,value);
  }
  public  void setRemarkNull(){
     this.set(S_Remark,null);
  }

  public String getRemark(){
       return DataType.getAsString(this.get(S_Remark));
  
  }
  public String getRemarkInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark));
      }

  public void initCharge(double value){
     this.initProperty(S_Charge,new Double(value));
  }
  public  void setCharge(double value){
     this.set(S_Charge,new Double(value));
  }
  public  void setChargeNull(){
     this.set(S_Charge,null);
  }

  public double getCharge(){
        return DataType.getAsDouble(this.get(S_Charge));
  
  }
  public double getChargeInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_Charge));
      }

  public void initStandbyNum1(String value){
     this.initProperty(S_StandbyNum1,value);
  }
  public  void setStandbyNum1(String value){
     this.set(S_StandbyNum1,value);
  }
  public  void setStandbyNum1Null(){
     this.set(S_StandbyNum1,null);
  }

  public String getStandbyNum1(){
       return DataType.getAsString(this.get(S_StandbyNum1));
  
  }
  public String getStandbyNum1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_StandbyNum1));
      }

  public void initAccountType(String value){
     this.initProperty(S_AccountType,value);
  }
  public  void setAccountType(String value){
     this.set(S_AccountType,value);
  }
  public  void setAccountTypeNull(){
     this.set(S_AccountType,null);
  }

  public String getAccountType(){
       return DataType.getAsString(this.get(S_AccountType));
  
  }
  public String getAccountTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AccountType));
      }

  public void initCycle(int value){
     this.initProperty(S_Cycle,new Integer(value));
  }
  public  void setCycle(int value){
     this.set(S_Cycle,new Integer(value));
  }
  public  void setCycleNull(){
     this.set(S_Cycle,null);
  }

  public int getCycle(){
        return DataType.getAsInt(this.get(S_Cycle));
  
  }
  public int getCycleInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Cycle));
      }

  public void initStandbyNum2(String value){
     this.initProperty(S_StandbyNum2,value);
  }
  public  void setStandbyNum2(String value){
     this.set(S_StandbyNum2,value);
  }
  public  void setStandbyNum2Null(){
     this.set(S_StandbyNum2,null);
  }

  public String getStandbyNum2(){
       return DataType.getAsString(this.get(S_StandbyNum2));
  
  }
  public String getStandbyNum2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_StandbyNum2));
      }

  public void initStandbyNum3(String value){
     this.initProperty(S_StandbyNum3,value);
  }
  public  void setStandbyNum3(String value){
     this.set(S_StandbyNum3,value);
  }
  public  void setStandbyNum3Null(){
     this.set(S_StandbyNum3,null);
  }

  public String getStandbyNum3(){
       return DataType.getAsString(this.get(S_StandbyNum3));
  
  }
  public String getStandbyNum3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_StandbyNum3));
      }

  public void initRemarkTag(String value){
     this.initProperty(S_RemarkTag,value);
  }
  public  void setRemarkTag(String value){
     this.set(S_RemarkTag,value);
  }
  public  void setRemarkTagNull(){
     this.set(S_RemarkTag,null);
  }

  public String getRemarkTag(){
       return DataType.getAsString(this.get(S_RemarkTag));
  
  }
  public String getRemarkTagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RemarkTag));
      }

  public void initTagType(String value){
     this.initProperty(S_TagType,value);
  }
  public  void setTagType(String value){
     this.set(S_TagType,value);
  }
  public  void setTagTypeNull(){
     this.set(S_TagType,null);
  }

  public String getTagType(){
       return DataType.getAsString(this.get(S_TagType));
  
  }
  public String getTagTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TagType));
      }

  public void initAddMonthcharge(String value){
     this.initProperty(S_AddMonthcharge,value);
  }
  public  void setAddMonthcharge(String value){
     this.set(S_AddMonthcharge,value);
  }
  public  void setAddMonthchargeNull(){
     this.set(S_AddMonthcharge,null);
  }

  public String getAddMonthcharge(){
       return DataType.getAsString(this.get(S_AddMonthcharge));
  
  }
  public String getAddMonthchargeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AddMonthcharge));
      }

  public void initSumcharge(double value){
     this.initProperty(S_Sumcharge,new Double(value));
  }
  public  void setSumcharge(double value){
     this.set(S_Sumcharge,new Double(value));
  }
  public  void setSumchargeNull(){
     this.set(S_Sumcharge,null);
  }

  public double getSumcharge(){
        return DataType.getAsDouble(this.get(S_Sumcharge));
  
  }
  public double getSumchargeInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_Sumcharge));
      }

  public void initLastcharge(String value){
     this.initProperty(S_Lastcharge,value);
  }
  public  void setLastcharge(String value){
     this.set(S_Lastcharge,value);
  }
  public  void setLastchargeNull(){
     this.set(S_Lastcharge,null);
  }

  public String getLastcharge(){
       return DataType.getAsString(this.get(S_Lastcharge));
  
  }
  public String getLastchargeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Lastcharge));
      }

  public void initAccountRow(String value){
     this.initProperty(S_AccountRow,value);
  }
  public  void setAccountRow(String value){
     this.set(S_AccountRow,value);
  }
  public  void setAccountRowNull(){
     this.set(S_AccountRow,null);
  }

  public String getAccountRow(){
       return DataType.getAsString(this.get(S_AccountRow));
  
  }
  public String getAccountRowInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AccountRow));
      }

  public void initId(int value){
     this.initProperty(S_Id,new Integer(value));
  }
  public  void setId(int value){
     this.set(S_Id,new Integer(value));
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public int getId(){
        return DataType.getAsInt(this.get(S_Id));
  
  }
  public int getIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Id));
      }

  public void initSubjectName(String value){
     this.initProperty(S_SubjectName,value);
  }
  public  void setSubjectName(String value){
     this.set(S_SubjectName,value);
  }
  public  void setSubjectNameNull(){
     this.set(S_SubjectName,null);
  }

  public String getSubjectName(){
       return DataType.getAsString(this.get(S_SubjectName));
  
  }
  public String getSubjectNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SubjectName));
      }

  public void initReturnType(String value){
     this.initProperty(S_ReturnType,value);
  }
  public  void setReturnType(String value){
     this.set(S_ReturnType,value);
  }
  public  void setReturnTypeNull(){
     this.set(S_ReturnType,null);
  }

  public String getReturnType(){
       return DataType.getAsString(this.get(S_ReturnType));
  
  }
  public String getReturnTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReturnType));
      }

  public void initLimType(String value){
		 this.initProperty(S_LimType,value);
	 }
	public  void setLimType(String value){
		 this.set(S_LimType,value);
	}
	public  void setLimTypeNull(){
		 this.set(S_LimType,null);
	}

	public String getLimType(){
		 return DataType.getAsString(this.get(S_LimType));
		  
	}
	public String getLimTypeInitialValue(){
		 return DataType.getAsString(this.getOldObj(S_LimType));
	}
 
 }

