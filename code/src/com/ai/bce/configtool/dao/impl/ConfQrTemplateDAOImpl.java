package com.ai.bce.configtool.dao.impl;

import java.util.Map;

import com.ai.bce.bo.BceQrTemplateEngine;
import com.ai.bce.configtool.dao.interfaces.IConfQrTemplateDAO;
import com.ai.bce.ivalues.IBceQrTemplateValue;

public class ConfQrTemplateDAOImpl implements IConfQrTemplateDAO {

	/**
	 * 
	 * @Function: ConfQrTemplateDAOImpl::queryBceQrTemplateCounts
	 * @Description: �ú����Ĺ�������
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-11 ����04:37:17 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-11     liwentao          v1.1.0               �޸�ԭ��
	 */
	public int queryBceQrTemplateCounts(String condition, Map parameter)
			throws Exception {
		return BceQrTemplateEngine.getBeansCount(condition, parameter);
	}

	/**
	 * 
	 * @Function: ConfQrTemplateDAOImpl::queryBceQrTemplateValues
	 * @Description: �ú����Ĺ�������
	 * @param condition
	 * @param parameter
	 * @param start
	 * @param end
	 * @return
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-11 ����04:37:20 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-11     liwentao          v1.1.0               �޸�ԭ��
	 */
	public IBceQrTemplateValue[] queryBceQrTemplateValues(String condition,
			Map parameter, int start, int end) throws Exception {
		return BceQrTemplateEngine.getBeans(null, condition, parameter, start, end, false);
	}

}
