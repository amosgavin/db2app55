package com.ai.bce.configtool.dao.impl;

import java.util.Map;

import com.ai.bce.bo.BceQrAttrEngine;
import com.ai.bce.configtool.dao.interfaces.IConfQrAttrDAO;
import com.ai.bce.ivalues.IBceQrAttrValue;

public class ConfQrAttrDAOImpl implements IConfQrAttrDAO {


	/**
	 * 
	 * @Function: ConfQrAttrDAOImpl::queryBceQrTemplateAttrCounts
	 * @Description: �ú����Ĺ�������
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-11 ����04:36:46 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-11     liwentao          v1.1.0               �޸�ԭ��
	 */
	public int queryBceQrTemplateAttrCounts(String condition, Map parameter)
			throws Exception {
		return BceQrAttrEngine.getBeansCount(condition, parameter);
	}

	/**
	 * 
	 * @Function: ConfQrAttrDAOImpl::queryBceQrTemplateAttrValues
	 * @Description: �ú����Ĺ�������
	 * @param condition
	 * @param parameter
	 * @param start
	 * @param end
	 * @return
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-11 ����04:36:49 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-11     liwentao          v1.1.0               �޸�ԭ��
	 */
	public IBceQrAttrValue[] queryBceQrTemplateAttrValues(String condition,
			Map parameter, int start, int end) throws Exception {
		return BceQrAttrEngine.getBeans(null, condition, parameter, start, end, false);
	}

}
