package com.ai.bce.service.interfaces;

import java.rmi.RemoteException;
import java.util.Map;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.bce.ivalues.IBceRuleReturnData;
import com.ai.bce.util.BceException;

public interface IBceRuleEngineSV {

	/**
	 * 业务操作是否可以被执行 bceFrameId和businessId不可同时为-1，否则无法获取框架
	 * 
	 * @param conditionMap
	 *            用于查询受理框架及关联的规则集的条件Map
	 * @param paramMap
	 *            用于执行规则的参数Map
	 * @param resType
	 *            来源类型：1、后台;2、前台；3、批量
	 * @return
	 * @throws Exception
	 */
	public IBceRuleReturnData isBusiCanDo(long bceFrameId, long businessId,
			Map conditionMap, Map paramMap, int resType) throws Exception,
			RemoteException;

	/**
	 * 订单是否可以被提交 bceFrameId和businessId不可同时为-1，否则无法获取框架
	 * 
	 * @param conditionMap
	 *            用于查询受理框架及关联的规则集的条件Map
	 * @param paramMap
	 *            用于执行规则的参数Map
	 * @param resType
	 *            来源类型：1、后台;2、前台；3、批量
	 * @return
	 * @throws Exception
	 */
	public IBceRuleReturnData isCanSubmitOrder(long bceFrameId,
			long businessId, Map conditionMap, Map paramMap, int resType)
			throws Exception, RemoteException;

	/**
	 * 业务操作是否可以批量被执行
	 * 
	 * @param conditionMap
	 *            用于查询受理框架及关联的规则集的条件Map
	 * @param paramMap
	 *            用于执行规则的参数Map
	 * @param resType
	 *            来源类型：1、后台;2、前台；3、批量
	 * @return
	 * @throws Exception
	 */
	// public IBceRuleReturnData isBatchBusiCanDo(long bceFrameId,
	// long businessId, Map conditionMap, Map paramMap, int resType)
	// throws Exception, RemoteException;

	/**
	 * 业务操作是否可以被执行 bceFrameId和businessId不可同时为-1，否则无法获取框架
	 * 
	 * @param conditionMap
	 *            用于查询受理框架及关联的规则集的条件Map
	 * @param paramMap
	 *            用于执行规则的参数Map
	 * @return
	 * @throws Exception
	 */
	public IBceRuleReturnData isBusiCanDo(long bceFrameId, long businessId,
			Map conditionMap, Map paramMap) throws Exception, RemoteException;

	/**
	 * 订单是否可以被提交 bceFrameId和businessId不可同时为-1，否则无法获取框架
	 * 
	 * @param conditionMap
	 *            用于查询受理框架及关联的规则集的条件Map
	 * @param paramMap
	 *            用于执行规则的参数Map
	 * @return
	 * @throws Exception
	 */
	public IBceRuleReturnData isCanSubmitOrder(long bceFrameId,
			long businessId, Map conditionMap, Map paramMap) throws Exception,
			RemoteException;

	/**
	 * 业务操作是否可以批量被执行
	 * 
	 * @param conditionMap
	 *            用于查询受理框架及关联的规则集的条件Map
	 * @param paramMap
	 *            用于执行规则的参数Map
	 * @return
	 * @throws Exception
	 */
	public IBceRuleReturnData isBatchBusiCanDo(long bceFrameId,
			long businessId, Map conditionMap, Map paramMap) throws Exception,
			RemoteException;

	/**
	 * 对批量输入的数据进行校验 bceFrameId和businessId不可同时为-1，否则无法获取框架
	 * 将只负责批量校验并将批量数据校验的结果分类存放到失败列表、成功列表、警告列表
	 * 
	 * @param aSoRuleReturnData
	 * @param paramMap
	 * @param ruleCheckEntryType
	 * @param members
	 * @return
	 * @throws Exception
	 */
	public IBceRuleReturnData batVerifyJavaRule(long bceFrameId,
			long businessId, Map conditionMap, Map paramMap,
			long ruleCheckEntryType, DataContainerInterface[] members,
			IBceRuleReturnData aSoRuleReturnData) throws Exception;

	/**
	 * bceFrameId和businessId不可同时为-1，否则无法获取框架
	 * 
	 * @param bceFrameId
	 * @param businessId
	 * @param conditionMap
	 * @param paramMap
	 * @param ruleCheckEntryType
	 * @param ruleReturnData
	 * @return
	 * @throws Exception
	 */
	public IBceRuleReturnData verifyJavaRule(long bceFrameId, long businessId,
			Map conditionMap, Map paramMap, long ruleCheckEntryType,
			IBceRuleReturnData ruleReturnData, int resType) throws Exception;

	public Object exeSingleRule(String className, String methodName,
			String paramList, String paramValueNameList, Map paramValueMap)
			throws Exception;

	/**
	 * 当前子页面是否被授权使用
	 * 
	 * @param bceFrameId
	 * @param pageFramePageId
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public IBceRuleReturnData isCanUsePage(long bceFrameId,
			long pageFramePageId, Map paramMap) throws Exception;

	/**
	 * 此方法仅供后台进程使用
	 * 
	 * @param ruleSetId
	 * @param paramMap
	 * @param aDc
	 * @param ruleReturnData
	 * @param resType
	 * @param ruleSetType
	 * @throws Exception
	 * @throws BceException
	 */
	public void exeRuleByRuleSetId(long ruleSetId, Map paramMap,
			DataContainerInterface aDc, IBceRuleReturnData ruleReturnData,
			int resType, long ruleSetType) throws Exception, BceException;

}
