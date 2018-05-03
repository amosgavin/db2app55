package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IQPageFramePageValue extends DataStructInterface{

  public final static  String S_PageUrl = "PAGE_URL";
  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_IsDisplay = "IS_DISPLAY";
  public final static  String S_PageRulesetId = "PAGE_RULESET_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_Height = "HEIGHT";
  public final static  String S_SeqNo = "SEQ_NO";
  public final static  String S_PageTemplate = "PAGE_TEMPLATE";
  public final static  String S_IsDataMust = "IS_DATA_MUST";
  public final static  String S_PageId = "PAGE_ID";
  public final static  String S_PageFramePageId = "PAGE_FRAME_PAGE_ID";
  public final static  String S_PageTitle = "PAGE_TITLE";
  public final static  String S_PageFrameId = "PAGE_FRAME_ID";
  public final static  String S_PageLoadType = "PAGE_LOAD_TYPE";
  public final static  String S_IsGetPageData = "IS_GET_PAGE_DATA";
  public final static  String S_PageType = "PAGE_TYPE";


public String getPageUrl();

public long getModuleId();

public long getState();

public long getIsDisplay();

public long getPageRulesetId();

public String getRemarks();

public String getHeight();

public long getSeqNo();

public String getPageTemplate();

public long getIsDataMust();

public long getPageId();

public long getPageFramePageId();

public String getPageTitle();

public long getPageFrameId();

public long getPageLoadType();

public long getIsGetPageData();

public long getPageType();


public  void setPageUrl(String value);

public  void setModuleId(long value);

public  void setState(long value);

public  void setIsDisplay(long value);

public  void setPageRulesetId(long value);

public  void setRemarks(String value);

public  void setHeight(String value);

public  void setSeqNo(long value);

public  void setPageTemplate(String value);

public  void setIsDataMust(long value);

public  void setPageId(long value);

public  void setPageFramePageId(long value);

public  void setPageTitle(String value);

public  void setPageFrameId(long value);

public  void setPageLoadType(long value);

public  void setIsGetPageData(long value);

public  void setPageType(long value);
}
