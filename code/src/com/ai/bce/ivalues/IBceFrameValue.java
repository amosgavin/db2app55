package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceFrameValue extends DataStructInterface{

  public final static  String S_SrcSystemType = "SRC_SYSTEM_TYPE";
  public final static  String S_BusinessId = "BUSINESS_ID";
  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_PrintTemplateId = "PRINT_TEMPLATE_ID";
  public final static  String S_EntryPageUrl = "ENTRY_PAGE_URL";
  public final static  String S_WorkflowCode = "WORKFLOW_CODE";
  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_DataParser = "DATA_PARSER";
  public final static  String S_IsLockOffer = "IS_LOCK_OFFER";
  public final static  String S_ParamData = "PARAM_DATA";
  public final static  String S_PageFrameId = "PAGE_FRAME_ID";
  public final static  String S_DealService = "DEAL_SERVICE";


public int getSrcSystemType();

public long getBusinessId();

public long getModuleId();

public int getState();

public String getRemarks();

public long getPrintTemplateId();

public String getEntryPageUrl();

public String getWorkflowCode();

public long getBceFrameId();

public String getDataParser();

public int getIsLockOffer();

public String getParamData();

public long getPageFrameId();

public String getDealService();


public  void setSrcSystemType(int value);

public  void setBusinessId(long value);

public  void setModuleId(long value);

public  void setState(int value);

public  void setRemarks(String value);

public  void setPrintTemplateId(long value);

public  void setEntryPageUrl(String value);

public  void setWorkflowCode(String value);

public  void setBceFrameId(long value);

public  void setDataParser(String value);

public  void setIsLockOffer(int value);

public  void setParamData(String value);

public  void setPageFrameId(long value);

public  void setDealService(String value);
}
