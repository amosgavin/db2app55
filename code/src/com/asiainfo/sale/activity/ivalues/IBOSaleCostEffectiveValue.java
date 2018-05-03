package com.asiainfo.sale.activity.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOSaleCostEffectiveValue extends DataStructInterface{

  public final static  String S_ColAlias1 = "COL_ALIAS_1";
  public final static  String S_ColAlias4 = "COL_ALIAS_4";
  public final static  String S_ColAlias13 = "COL_ALIAS_13";
  public final static  String S_ColAlias2 = "COL_ALIAS_2";
  public final static  String S_ColAlias12 = "COL_ALIAS_12";


public String getColAlias1();

public String getColAlias4();

public long getColAlias13();

public String getColAlias2();

public long getColAlias12();


public  void setColAlias1(String value);

public  void setColAlias4(String value);

public  void setColAlias13(long value);

public  void setColAlias2(String value);

public  void setColAlias12(long value);
}
