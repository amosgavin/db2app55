package com.asiainfo.sale.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOSaleStaticDataValue extends DataStructInterface{

  public final static  String S_IsUsed = "IS_USED";
  public final static  String S_SortId = "SORT_ID";
  public final static  String S_CodeNameNls = "CODE_NAME_NLS";
  public final static  String S_CodeName = "CODE_NAME";
  public final static  String S_CodeType = "CODE_TYPE";
  public final static  String S_CodeId = "CODE_ID";
  public final static  String S_ExternCode = "EXTERN_CODE";


public int getIsUsed();

public int getSortId();

public String getCodeNameNls();

public String getCodeName();

public String getCodeType();

public String getCodeId();

public String getExternCode();


public  void setIsUsed(int value);

public  void setSortId(int value);

public  void setCodeNameNls(String value);

public  void setCodeName(String value);

public  void setCodeType(String value);

public  void setCodeId(String value);

public  void setExternCode(String value);
}
