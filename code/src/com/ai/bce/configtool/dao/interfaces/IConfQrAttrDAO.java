package com.ai.bce.configtool.dao.interfaces;

import java.util.Map;

import com.ai.bce.ivalues.IBceQrAttrValue;
import com.ai.bce.ivalues.IBceQrTemplateValue;


public interface IConfQrAttrDAO {

	/**
	 * 
	 * @Function: IConfQrAttrDAO::queryBceQrTemplateAttrValues
	 * @Description: 根据条件 查询bce Template attr 信息
	 * @param condition
	 * @param parameter
	 * @param start
	 * @param end
	 * @return
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-10 下午04:21:24 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-10     Administrator          v1.1.0               修改原因
	 */
	public IBceQrAttrValue[] queryBceQrTemplateAttrValues(String condition,Map parameter,int start,int end) throws Exception;
	
	/**
	 * 
	 * @Function: IConfQrAttrDAO::queryBceQrTemplateAttrCounts
	 * @Description:  根据条件 查询bce Template attr 信息数量
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-10 下午04:23:07 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-10     Administrator          v1.1.0               修改原因
	 */
	public int queryBceQrTemplateAttrCounts(String condition,Map parameter) throws Exception;
	
}
