package com.ai.bce.configtool.service.impl;

import java.rmi.RemoteException;

import com.ai.bce.bo.BceFrameBean;
import com.ai.bce.bo.BceFrameEngine;
import com.ai.bce.bo.BceFrameJavaRulesetRelEngine;
import com.ai.bce.bo.BcePageEngine;
import com.ai.bce.bo.BcePageRowsetRelEngine;
import com.ai.bce.bo.BceRowsetEngine;
import com.ai.bce.bo.BceRuleEngine;
import com.ai.bce.bo.BceRulesetEngine;
import com.ai.bce.bo.BceRulesetRuleEngine;
import com.ai.bce.bo.BceSimpleFuncEngine;
import com.ai.bce.bo.BceSimpleFuncFieldMappingEngine;
import com.ai.bce.configtool.dao.interfaces.IConfFrameDAO;
import com.ai.bce.configtool.service.interfaces.IConfFrameSV;
import com.ai.bce.ivalues.IBceFrameConfigTemplateValue;
import com.ai.bce.ivalues.IBceFrameJavaRulesetRelValue;
import com.ai.bce.ivalues.IBceFrameValue;
import com.ai.bce.ivalues.IBcePageRowsetRelValue;
import com.ai.bce.ivalues.IBceRowsetValue;
import com.ai.bce.ivalues.IBceRuleValue;
import com.ai.bce.ivalues.IBceRulesetRuleValue;
import com.ai.bce.ivalues.IBceRulesetValue;
import com.ai.bce.ivalues.IBceSimpleFuncFieldMappingValue;
import com.ai.bce.ivalues.IBceSimpleFuncValue;
import com.ai.bce.util.BServiceFactory;

public class ConfFrameSVImpl implements IConfFrameSV{
	
	 public IBceFrameValue getBceFrameValueByBceFrameId(String bceFrameId) throws RemoteException,Exception {
		if(null != bceFrameId&& !"".equals(bceFrameId)){
			long frameId = Long.parseLong(bceFrameId);
			IConfFrameDAO bceFrameDao = (IConfFrameDAO) BServiceFactory.getService(IConfFrameDAO.class);
			return bceFrameDao.getBceFrameValueByBceFrameId(frameId);
		}
		    return null;
		}

	public IBceFrameValue[] getBceFrameValues(String cond,int startIndex,int endIndex)throws Exception{
		IConfFrameDAO bceFrameDao = (IConfFrameDAO) BServiceFactory.getService(IConfFrameDAO.class);
		return bceFrameDao.getBceFrameValues(cond, startIndex, endIndex);
	}
	
	public int getBceFrameValuesCount(String cond) throws Exception {
		IConfFrameDAO bceFrameDao = (IConfFrameDAO) BServiceFactory.getService(IConfFrameDAO.class);
		return bceFrameDao.getBceFrameValuesCount(cond);
	}
	
	public IBcePageRowsetRelValue[] getPageRowsetRelValues(String cond)throws Exception{
		return BcePageRowsetRelEngine.getBeans(cond,null);
	}
	
	public IBceRowsetValue[] getRowsetValues(String cond)throws Exception{
		return BceRowsetEngine.getBeans(cond,null);
	}
	
	public IBceRuleValue[] getBceRuleValues(String cond)throws Exception{
		return BceRuleEngine.getBeans(cond,null);
	}
	
	public IBceRulesetValue[] getBceRulesetValues(String cond)throws Exception{
		return BceRulesetEngine.getBeans(cond,null);
	}
	
	public IBceRulesetRuleValue[] getBceRulesetRuleValues(String cond)throws Exception{
		return BceRulesetRuleEngine.getBeans(cond,null);
	}
	
	public IBceFrameJavaRulesetRelValue[] getFrameJavaRulesetRelValues(String cond)throws Exception{
		return BceFrameJavaRulesetRelEngine.getBeans(cond,null);
	}
	
	public IBceSimpleFuncValue[] getSFuncValues(String cond)throws Exception{
		return BceSimpleFuncEngine.getBeans(cond,null);
	}
	
	public IBceSimpleFuncFieldMappingValue[] getSFuncFMappingValues(String cond)throws Exception{
		return BceSimpleFuncFieldMappingEngine.getBeans(cond,null);
	}

	/**
	 * 
	 * @Function: ConfFrameSVImpl::getBceFrameConfigTemplateValues
	 * @Description: 该函数的功能描述
	 * @param cond
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-14 下午02:18:32 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-14     Administrator          v1.1.0               修改原因
	 */
	public IBceFrameConfigTemplateValue[] getBceFrameConfigTemplateValues(String cond,
			int startIndex, int endIndex) throws Exception {
		IConfFrameDAO bceFrameDao = (IConfFrameDAO) BServiceFactory.getService(IConfFrameDAO.class);
		return bceFrameDao.getBceFrameConfigTemplateValues(cond, startIndex, endIndex);
	}
	
	/**
	 * 
	 * @Function: ConfFrameSVImpl::getBceFrameConfigTemplateValuesCount
	 * @Description: 该函数的功能描述
	 * @param cond
	 * @return
	 * @throws Exception
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-14 下午02:18:30 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-14     Administrator          v1.1.0               修改原因
	 */
	public int getBceFrameConfigTemplateValuesCount(String cond)
			throws Exception {
		IConfFrameDAO bceFrameDao = (IConfFrameDAO) BServiceFactory.getService(IConfFrameDAO.class);
		return bceFrameDao.getBceFrameConfigTemplateValuesCount(cond);
	}

	/**
	 * 
	 * @Function: ConfFrameSVImpl::bceFrameConfigTemplate
	 * @Description: 配置受理框架确认页模板
	 * @param bceFrameId
	 * @param templateId
	 * @return
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-14 下午03:01:26 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-14     liwentao          v1.1.0               修改原因
	 */
	public boolean bceFrameConfigTemplate(long bceFrameId, long templateId)throws Exception {
	 try{
		BceFrameBean  bean = new BceFrameBean();
		bean.setBceFrameId(bceFrameId);
		bean.setStsToOld();
		bean.setPrintTemplateId(templateId);
		BceFrameEngine.save(bean);
		return true;
	 }catch(Exception e){
		    e.printStackTrace();
			return false;
		}
		
	}
}
