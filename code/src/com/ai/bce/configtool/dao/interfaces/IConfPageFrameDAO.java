package com.ai.bce.configtool.dao.interfaces;

import com.ai.bce.ivalues.IBcePageFrameValue;
import com.ai.bce.ivalues.IBcePageValue;



public interface IConfPageFrameDAO {
	 /**根据页面框架编号获取页面框架数据
     * @param pPageFrameId
     * @return
     * @throws Exception
     */
    public IBcePageFrameValue getBcePageFrameValue(long pPageFrameId) throws Exception;
    public IBcePageFrameValue[] getPageFrameValues(String cond, int startIndex,
			int endIndex) throws Exception;
    public int getPageFrameValuesCount(String cond) throws Exception;
    public IBcePageValue[] getBcePageValuesByBcePageFrameId(String bcePageFrameId) throws Exception;
    public int getBcePageFrameCountByModuleId(long moduleId) throws Exception;
}
