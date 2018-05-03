package com.ai.bce.configtool.service.impl;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.util.StringUtils;
import com.ai.bce.bo.BceQrAttrBean;
import com.ai.bce.bo.BceQrAttrEngine;
import com.ai.bce.configtool.dao.interfaces.IConfQrAttrDAO;
import com.ai.bce.configtool.service.interfaces.IConfQrAttrSV;
import com.ai.bce.ivalues.IBceQrAttrValue;
import com.ai.bce.util.BServiceFactory;

public class ConfQrAttrSVImpl implements IConfQrAttrSV {

	private final static Log log = LogFactory.getLog(ConfQrAttrSVImpl.class);
	
	/**
	 * 
	 * @Function: ConfQrAttrSVImpl::queryBceQrTemplateAttrCounts
	 * @Description: �ú����Ĺ�������
	 * @param templateId
	 * @return
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-11 ����04:33:24 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-11     liwentao          v1.1.0               �޸�ԭ��
	 */
	public int queryBceQrTemplateAttrCounts(String templateId)
			throws Exception {
		
		if(log.isInfoEnabled()){
			log.info("ConfQrAttrSVImpl queryBceQrTemplateAttrCounts start");
		}
		
		HashMap infomap = new HashMap();
		//ƴ�Ӳ�ѯ�������ƻ����ƣ�teamName��֧��ģ����ѯ
		StringBuffer condition = new StringBuffer("1=1");
		
		if (!StringUtils.isEmptyString(templateId)) {
			condition.append(" AND " + IBceQrAttrValue.S_TemplateId+" = :templateId");
			infomap.put("templateId", templateId);
		}
		
		
		//����״̬Ϊ1
		condition.append(" AND " + IBceQrAttrValue.S_State+" = :state");
		infomap.put("state", String.valueOf(1));
		
		IConfQrAttrDAO bceQrTemplateDao = getBceQrTemplateAttrDAO();
		
		int count = bceQrTemplateDao.queryBceQrTemplateAttrCounts(condition.toString(), infomap);
		return count;
	}

	/**
	 * 
	 * @Function: ConfQrAttrSVImpl::queryBceQrTemplateAttrValues
	 * @Description: ��ѯָ��ģ���������Ϣ����
	 * @param templateId
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-11 ����04:33:34 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-11     liwentao          v1.1.0               �޸�ԭ��
	 */
	public IBceQrAttrValue[] queryBceQrTemplateAttrValues(String templateId,int startNum,int endNum) throws Exception {
		if(log.isInfoEnabled()){
			log.info("ConfQrAttrSVImpl queryBceQrTemplateAttrValues start");
		}
		
		HashMap infomap = new HashMap();
		//ƴ�Ӳ�ѯ�������ƻ����ƣ�teamName��֧��ģ����ѯ
		StringBuffer condition = new StringBuffer("1=1");
		
		if (!StringUtils.isEmptyString(templateId)) {
			condition.append(" AND " + IBceQrAttrValue.S_TemplateId+" = :templateId");
			infomap.put("templateId", templateId);
		}
		
		//����״̬Ϊ1
		condition.append(" AND " + IBceQrAttrValue.S_State+" = :state");
		infomap.put("state", String.valueOf(1));
		condition.append(" order by "+IBceQrAttrValue.S_TemplateId+" asc");		
		IConfQrAttrDAO bceQrTemplateDao = getBceQrTemplateAttrDAO();
		
		IBceQrAttrValue[] templateArr = bceQrTemplateDao.queryBceQrTemplateAttrValues(condition.toString(), infomap, startNum, endNum);
		return templateArr;
	}
	
	
	private IConfQrAttrDAO getBceQrTemplateAttrDAO() throws Exception{
		return (IConfQrAttrDAO) BServiceFactory.getService(IConfQrAttrDAO.class);
	}

	/**
	 * 
	 * @Function: ConfQrAttrSVImpl::delBceTemplateAttr
	 * @Description: �߼�ɾ��ָ��ID��ģ��������Ϣ
	 * @param attrId
	 * @return
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-11 ����04:33:40 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-11     liwentao          v1.1.0               �޸�ԭ��
	 */
	public boolean delBceTemplateAttr(String attrId) throws Exception {
		long id = Long.valueOf(attrId).longValue();
		IBceQrAttrValue bean = BceQrAttrEngine.getBean(id);
		if(bean != null){
			bean.setState(0);
			BceQrAttrEngine.save(bean);
			return true;
		}
		
		return false;
	}


    /**
     * 
     * @Function: ConfQrAttrSVImpl::saveBceTempalteAttr
     * @Description: ����ģ����Ϣ
     * @param bean
     * @return
     * @throws Exception
     * @version: v1.1.0
     * @author: Administrator
     * @date: 2011-5-11 ����04:34:25 
     *
     * Modification History:
     * Date         Author          Version            Description
     *-------------------------------------------------------------
     * 2011-5-11     liwentao          v1.1.0               �޸�ԭ��
     */
	public boolean saveBceTempalteAttr(BceQrAttrBean bean) throws Exception {
		if(bean != null){
			if(bean.getAttrId() == 0){
				bean.setAttrId(BceQrAttrEngine.getNewId().longValue());
			}
			bean.setState(1);
			BceQrAttrEngine.save(bean);
			return true;
		}
		
		return false;
	}

}
