package com.ai.bce.configtool.dao.interfaces;

import com.ai.bce.ivalues.IBcePageFrameValue;
import com.ai.bce.ivalues.IBcePageValue;



public interface IConfPageFrameDAO {
	 /**����ҳ���ܱ�Ż�ȡҳ��������
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
