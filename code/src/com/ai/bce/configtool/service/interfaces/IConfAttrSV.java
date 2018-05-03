package com.ai.bce.configtool.service.interfaces;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.bce.ivalues.IBceAttrValue;

public interface IConfAttrSV {
public IBceAttrValue[] getBceAttrBeans(String dataSource,String tableName) throws Exception;
public int getBceAttrBeansCount(String dataSource,String tableName);
public DataContainerInterface[] getTableNames(String dataSource, String cond) throws Exception;
public IBceAttrValue[] getBceAttrs(String attrId) throws Exception;
}
