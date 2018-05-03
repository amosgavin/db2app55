package com.ai.bce.service.impl;

import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.privilege.UserInfoInterface;
import com.ai.bce.ivalues.IBceFrameJavaRulesetRelValue;
import com.ai.bce.ivalues.IBceFrameValue;
import com.ai.bce.ivalues.IBceRuleReturnData;
import com.ai.bce.ivalues.IQBceRulesetRuleValue;
import com.ai.bce.ivalues.IQPageFramePageValue;
import com.ai.bce.service.interfaces.IBceRuleEngineSV;
import com.ai.bce.util.BceException;
import com.ai.bce.util.BceSVUtil;
import com.ai.bce.util.BceServiceFactory;
import com.ai.bce.util.BceUtil;
import com.ai.bce.util.LocaleResourceFactory;
import com.ai.bce.util.ReflectUtils;
import com.ai.bce.valuebean.BceRuleReturnDataBean;

public class BceRuleEngineSVImpl implements IBceRuleEngineSV {

	private static transient Log log = LogFactory.getLog(BceRuleEngineSVImpl.class);

	/**
	 * ҵ������Ƿ���Ա�ִ��
	 * 
	 * @param conditionMap
	 *            ���ڲ�ѯ�����ܼ������Ĺ��򼯵�����Map
	 * @param paramMap
	 *            ����ִ�й���Ĳ���Map
	 * @return
	 * @throws Exception
	 */
	public IBceRuleReturnData isBusiCanDo(long bceFrameId, long businessId, Map conditionMap, Map paramMap) throws Exception {
		return this.isBusiCanDo(bceFrameId, businessId, conditionMap, paramMap, 1);
	}

	/**
	 * ҵ������Ƿ����������ִ��
	 * 
	 * @param conditionMap
	 *            ���ڲ�ѯ�����ܼ������Ĺ��򼯵�����Map
	 * @param paramMap
	 *            ����ִ�й���Ĳ���Map
	 * @return
	 * @throws Exception
	 */
	public IBceRuleReturnData isBatchBusiCanDo(long bceFrameId, long businessId, Map conditionMap, Map paramMap) throws Exception {
		return this.isBatchBusiCanDo(bceFrameId, businessId, conditionMap, paramMap, 1);
	}

	public IBceRuleReturnData isCanUsePage(long bceFrameId, long pageFramePageId, Map paramMap) throws Exception {
		IBceFrameValue bceFrameValue = BceServiceFactory.getBceFrameSV().getBceFrameValue(bceFrameId);
		IQPageFramePageValue[] pages = BceServiceFactory.getBceFrameSV().getPageFramePages(bceFrameId, bceFrameValue.getPageFrameId());
		long ruleSetId = 0L;
		// ��ȡRuleSet��Ϣ
		for (int i = 0; i < pages.length; i++) {
			IQPageFramePageValue iqPageFramePageValue = pages[i];
			if (iqPageFramePageValue.getPageFramePageId() == pageFramePageId) {
				ruleSetId = iqPageFramePageValue.getPageRulesetId();
				break;
			}
		}
		IQBceRulesetRuleValue[] rulesetRuleValues = BceServiceFactory.getBceFrameSV().getRulesByRulesetId(ruleSetId);
		IBceRuleReturnData ruleReturnData = new BceRuleReturnDataBean();
		for (int i = 0; i < rulesetRuleValues.length; i++) {
			IQBceRulesetRuleValue iqBceRulesetRuleValue = rulesetRuleValues[i];
			if (iqBceRulesetRuleValue.getRuleTriggerType() != 5)
				continue;
			IBceRuleReturnData returnData = exeRule(iqBceRulesetRuleValue.getFileName(), iqBceRulesetRuleValue.getFuncName(), iqBceRulesetRuleValue.getParamList(), iqBceRulesetRuleValue.getParamValueList(), paramMap);
			if (returnData.getResultCode() == BceUtil.JAVA_RULE_RETURN_CODE_NO) {
				ruleReturnData = returnData;
				break;
			}
			if (ruleReturnData.getRequestParameMap() == null) {
				ruleReturnData = returnData;
			} else {
				Map requestParamMap = ruleReturnData.getRequestParameMap();
				requestParamMap.putAll(returnData.getRequestParameMap());
			}
		}
		return ruleReturnData;
	}

	/**
	 * �����Ƿ���Ա��ύ
	 * 
	 * @param conditionMap
	 *            ���ڲ�ѯ�����ܼ������Ĺ��򼯵�����Map
	 * @param paramMap
	 *            ����ִ�й���Ĳ���Map
	 * @return
	 * @throws Exception
	 */
	public IBceRuleReturnData isCanSubmitOrder(long bceFrameId, long businessId, Map conditionMap, Map paramMap) throws Exception {
		return this.isCanSubmitOrder(bceFrameId, businessId, conditionMap, paramMap, 1);
	}

	/**
	 * ��������������ݽ���У�� ��ֻ��������У�鲢����������У��Ľ�������ŵ�ʧ���б��ɹ��б������б�
	 * 
	 * @param aSoRuleReturnData
	 * @param paramMap
	 * @param ruleCheckEntryType
	 * @param members
	 * @return
	 * @throws Exception
	 */
	public IBceRuleReturnData batVerifyJavaRule(long bceFrameId, long businessId, Map conditionMap, Map paramMap, long ruleCheckEntryType, DataContainerInterface[] members, IBceRuleReturnData aSoRuleReturnData) throws Exception {
		int retCode = BceUtil.JAVA_RULE_RETURN_CODE_YES;
		for (int i = 0; i < members.length; i++) {
			// ��ÿһ���������У�飬�ɹ��ķŽ��ɹ��б�ʧ�ܵķŽ�ʧ���б�����ķŽ������б�
			String[] props = members[i].getPropertyNames();
			if (props != null && props.length > 0) {
				for (int j = 0; j < props.length; j++) {
					paramMap.put(props[j], (Object) members[i].get(props[j]));
				}
			}
			aSoRuleReturnData = verifyJavaRule(bceFrameId, businessId, conditionMap, paramMap, ruleCheckEntryType, aSoRuleReturnData, 1);
			if (aSoRuleReturnData.getResultCode() == BceUtil.JAVA_RULE_RETURN_CODE_NO) {
				retCode = BceUtil.JAVA_RULE_RETURN_CODE_NO;
			}
		}
		// ����У����ֻҪ��һ��ʧ�ܵģ����������巵�ؽ��Ϊʧ�ܣ�����ɹ��б������б��ʧ���б�ֱ��ȡ����
		if (retCode == BceUtil.JAVA_RULE_RETURN_CODE_NO) {
			aSoRuleReturnData.setResultCode(retCode);
		}
		return aSoRuleReturnData;
	}

	public IBceRuleReturnData verifyJavaRule(long bceFrameId, long businessId, Map conditionMap, Map paramMap, long ruleCheckEntryType, IBceRuleReturnData ruleReturnData, int resType) throws Exception {
		ruleReturnData.setResultCode(BceUtil.JAVA_RULE_RETURN_CODE_YES);
		if (bceFrameId <= 0) {
			// ��ѯ������
			IBceFrameValue aBceFrame = BceServiceFactory.getBceFrameSV().getBceFrameValue(businessId, conditionMap);
			if (aBceFrame == null) {
				throw new BceException("BES0000418");
			} else {
				bceFrameId = aBceFrame.getBceFrameId();
			}
		}
		IBceFrameJavaRulesetRelValue[] soJavaRuleSet = BceServiceFactory.getBceFrameSV().getRegistedRuleSet(bceFrameId, ruleCheckEntryType, conditionMap);
		DataContainerInterface aDc = createDcFromMap(paramMap);
		if (soJavaRuleSet == null || soJavaRuleSet.length == 0) {
			ruleReturnData.setResultCode(BceUtil.JAVA_RULE_RETURN_CODE_YES);
			ruleReturnData.addSuccessDc(aDc);
		} else {
			for (int i = 0; i < soJavaRuleSet.length; i++) {
				ruleReturnData = this.exeJavaRuleSet(soJavaRuleSet[i], paramMap, aDc, ruleReturnData, resType);
				if (ruleReturnData.getResultCode() == BceUtil.JAVA_RULE_RETURN_CODE_NO)
					break;
			}
			if (ruleReturnData.getResultCode() == BceUtil.JAVA_RULE_RETURN_CODE_YES)
				ruleReturnData.addSuccessDc(aDc);
			else if (ruleReturnData.getResultCode() == BceUtil.JAVA_RULE_RETURN_CODE_NO)
				ruleReturnData.addFailDc(aDc);
			else
				ruleReturnData.addWarnningDc(aDc);
		}
		return ruleReturnData;
	}

	/**
	 * ���ݺ�̨���򼯶��󣬲�ѯ���еĹ��򣬲����չ������ͺ͹�������ִ�У�������ȷ�Ľ��
	 * 
	 * @param soJavaRuleSet
	 * @param ruleReturnData
	 * @param paramMap
	 * @param resType 
	 * @return
	 * @throws Exception
	 */
	private IBceRuleReturnData exeJavaRuleSet(IBceFrameJavaRulesetRelValue soJavaRuleSet, Map paramMap, DataContainerInterface aDc, IBceRuleReturnData ruleReturnData, int resType) throws Exception {
		if (soJavaRuleSet == null) {
			if (ruleReturnData.getResultCode() != BceUtil.JAVA_RULE_RETURN_CODE_WARNNING && ruleReturnData.getResultCode() != BceUtil.JAVA_RULE_RETURN_CODE_NO)
				ruleReturnData.setResultCode(BceUtil.JAVA_RULE_RETURN_CODE_YES);
			// ruleReturnData.addSuccessDc(aDc);
		} else {
			// 1 ����ȫ��ͨ�� 2 ������ͨ��
			long ruleSetType = soJavaRuleSet.getCheckType();
			exeRuleByRuleSetId(soJavaRuleSet.getRulesetId(), paramMap, aDc, ruleReturnData, resType, ruleSetType);
		}

		return ruleReturnData;
	}

	public void exeRuleByRuleSetId(long ruleSetId, Map paramMap, DataContainerInterface aDc, IBceRuleReturnData ruleReturnData, int resType, long ruleSetType) throws Exception, BceException {
		// ��ѯ���򼯹����Ĺ���
		IQBceRulesetRuleValue[] rules = BceServiceFactory.getBceFrameSV().getRulesByRulesetId(ruleSetId);
		if (rules == null || rules.length == 0) {
			if (ruleReturnData.getResultCode() != BceUtil.JAVA_RULE_RETURN_CODE_WARNNING && ruleReturnData.getResultCode() != BceUtil.JAVA_RULE_RETURN_CODE_NO)
				ruleReturnData.setResultCode(BceUtil.JAVA_RULE_RETURN_CODE_YES);
			// ruleReturnData.addSuccessDc(aDc);
		} else {
			boolean isPassRule = true;
			for (int i = 0; i < rules.length; i++) {
				if (!BceSVUtil.isUseRule(rules[i].getResType(), resType)) {
					continue;
				}
				// ����ķ������
				String className = rules[i].getFileName();
				String methodName = rules[i].getFuncName();
				String paramList = rules[i].getParamList();
				String paramValueNameList = rules[i].getParamValueList();
				// 1-���� 2-�ܾ�
				long ruleVerifyType = rules[i].getVerifyType();
				// �������
				IBceRuleReturnData retData = exeRule(className, methodName, paramList, paramValueNameList, paramMap);
				if (StringUtils.isNotBlank(retData.getMsg())) {
					if (aDc != null) {
						String dcMsg = aDc.getAsString(BceUtil.RET_DC_MSG_NAME);
						if (dcMsg == null) {
							aDc.set(BceUtil.RET_DC_MSG_NAME, retData.getMsg());
						} else {
							aDc.set(BceUtil.RET_DC_MSG_NAME, dcMsg + " " + retData.getMsg());
						}
					}
				}
				if (retData.getResultCode() == BceUtil.JAVA_RULE_RETURN_CODE_YES) {
					isPassRule = true;
				} else if (retData.getResultCode() == BceUtil.JAVA_RULE_RETURN_CODE_NO) {
					// ����
					isPassRule = false;
					if (ruleVerifyType == BceUtil.RULE_VERIFY_TYPE_WARNING) {
						ruleReturnData.setResultCode(BceUtil.JAVA_RULE_RETURN_CODE_WARNNING);
						if (StringUtils.isNotBlank(retData.getMsg())) {
							ruleReturnData.setMsg((ruleReturnData.getMsg() == null ? "" : ruleReturnData.getMsg()) + retData.getMsg() + " ");
							ruleReturnData.setKey(retData.getKey());
						}

						if (StringUtils.isNotBlank(retData.getCustomResultCode())) {
							ruleReturnData.setCustomResultCode((ruleReturnData.getCustomResultCode() == null ? "" : ruleReturnData.getCustomResultCode()) + retData.getCustomResultCode() + " ");
						}
						// �ŵ������б�
						// ruleReturnData.addWarnningDc(aDc);

					} else if (ruleVerifyType == BceUtil.RULE_VERIFY_TYPE_REJECT) {
						// ruleReturnData.addFailDc(aDc);
						if (ruleSetType == BceUtil.RULE_CHECK_TYPE_ALL) {// ����ȫ��ͨ��
							ruleReturnData.setResultCode(BceUtil.JAVA_RULE_RETURN_CODE_NO);
							if (StringUtils.isNotBlank(retData.getMsg())) {
								ruleReturnData.setMsg(retData.getMsg());
								if (retData.getKey() != null) {
									ruleReturnData.setMsgByKey(retData.getKey(), retData.getMsgParams());
								}
								ruleReturnData.setKey(retData.getKey());

							}
							if (StringUtils.isNotBlank(retData.getCustomResultCode())) {
								ruleReturnData.setCustomResultCode(retData.getCustomResultCode());
							}
							break;
						}
					} else {
						isPassRule = false;
						ruleReturnData.setResultCode(BceUtil.JAVA_RULE_RETURN_CODE_NO);
						// ruleReturnData.addFailDc(aDc);
						ruleReturnData.setMsg(LocaleResourceFactory.getResource("BES0000419") + retData.getMsg());
						ruleReturnData.setKey("BES0000419");
						if (StringUtils.isNotBlank(retData.getCustomResultCode())) {
							ruleReturnData.setCustomResultCode(retData.getCustomResultCode());
						}
						break;
					}
				}

			}
			if (isPassRule) {
				if (ruleReturnData.getResultCode() != BceUtil.JAVA_RULE_RETURN_CODE_WARNNING && ruleReturnData.getResultCode() != BceUtil.JAVA_RULE_RETURN_CODE_NO)
					ruleReturnData.setResultCode(BceUtil.JAVA_RULE_RETURN_CODE_YES);
				// ruleReturnData.addSuccessDc(aDc);
			}
		}
	}

	/**
	 * ���ݴ�����������������������б�����ȡֵ�����б�����ֵ��MAPִ�й���
	 * 
	 * @param className
	 * @param methodName
	 * @param paramList
	 * @param paramValueNameList
	 * @param paramValueMap
	 * @return
	 * @throws Exception
	 */
	protected IBceRuleReturnData exeRule(String className, String methodName, String paramList, String paramValueNameList, Map paramValueMap) throws Exception {
		IBceRuleReturnData retData = new BceRuleReturnDataBean();
		if (log.isDebugEnabled()) {
			log.debug("paramList :" + paramValueNameList);
			log.debug("debugPaaramMap:" + paramValueMap);
		}
		try {
			// Class ruleClass = getJavaClass(className);
			String[] params = StringUtils.split(paramList, ",");
			String[] argValueNames = StringUtils.split(paramValueNameList, ",");

			Class[] argsClass = new Class[params == null ? 0 : params.length];
			Object[] args = new Object[params == null ? 0 : params.length];
			for (int i = 0; i < argsClass.length; i++) {
				// �����ȷ�Ĳ�������
				argsClass[i] = getJavaClass(params[i]);
				if (log.isDebugEnabled()) {
					log.debug("Get Class Is:" + argsClass[i]);
				}
				// �����ȷ�Ĳ���ֵ
				if (String.valueOf(paramValueMap.get(argValueNames[i])).startsWith("$.")) {
					args[i] = DataType.transfer(String.valueOf(paramValueMap.get(argValueNames[i])).substring(2), argsClass[i]);
				} else if (paramValueMap.get(argValueNames[i]) != null)
					args[i] = DataType.transfer(paramValueMap.get(argValueNames[i]), argsClass[i]);
				else
					args[i] = DataType.transfer(0 + "", argsClass[i]);
				if (log.isDebugEnabled()) {
					log.debug("Get Value is :" + args[i]);
				}
			}

			if (log.isDebugEnabled()) {
				log.debug("eval Class is :" + className + ",Method is " + methodName);
			}
			// Method method = ruleClass.getMethod(methodName, argsClass);
			retData = (IBceRuleReturnData) ReflectUtils.methodInvoke(className, methodName, argsClass, args, null);

		} catch (Exception e) {
			retData.setResultCode(BceUtil.JAVA_RULE_RETURN_CODE_NO);
			// ����[exeRule]ִ�д���

			log.error(String.valueOf(e.getCause() == null ? e.getMessage() : e.getCause().getMessage()), e);
			retData.setMsgByKey("BES0000656", new Object[] { BceUtil.getFirstExceptionMsg(e) });
		}
		return retData;
	}

	/**
	 * ���ݶ������ͻ�ȡ����
	 * 
	 * @param type
	 * @return
	 */
	public static Class getJavaClass(String type) {
		if (type.endsWith("UserInfoInterface")) {
			return UserInfoInterface.class;
		}
		if (type.endsWith("HashMap"))
			return HashMap.class;
		if (type.endsWith("Map"))
			return Map.class;
		return DataType.getJavaClass(type);
	}

	/**
	 * ��HashMap�й���DataContainer
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	private DataContainerInterface createDcFromMap(Map map) throws Exception {
		DataContainerInterface aDc = new DataContainer();
		Iterator aIters = map.keySet().iterator();
		while (aIters.hasNext()) {
			String aKey = (String) aIters.next();
			Object aValue = map.get(aKey);
			aDc.set(aKey, aValue);
		}
		return aDc;
	}

	public Object exeSingleRule(String className, String methodName, String paramList, String paramValueNameList, Map paramValueMap) throws Exception {
		Class ruleClass = getJavaClass(className);
		String[] params = StringUtils.split(paramList, ",");
		String[] argValueNames = StringUtils.split(paramValueNameList, ",");
		Class[] argsClass = null;
		Object[] args = null;
		if (params != null && params.length > 0) {
			argsClass = new Class[params.length];
			args = new Object[params.length];
			for (int i = 0; i < params.length; i++) {
				// �����ȷ�Ĳ�������
				argsClass[i] = getJavaClass(params[i]);
				// �����ȷ�Ĳ���ֵ
				args[i] = DataType.transfer(paramValueMap.get(argValueNames[i]), argsClass[i]);
			}
		}
		Method method = ruleClass.getMethod(methodName, argsClass);
		return (Object) method.invoke(ruleClass.newInstance(), args);
	}

	public IBceRuleReturnData isBusiCanDo(long bceFrameId, long businessId, Map conditionMap, Map paramMap, int resType) throws Exception, RemoteException {
		IBceRuleReturnData ruleReturnData = new BceRuleReturnDataBean();
		ruleReturnData = verifyJavaRule(bceFrameId, businessId, conditionMap, paramMap, BceUtil.JAVA_RULE_SET_TYPE_NORMAL, ruleReturnData, resType);
		return ruleReturnData;
	}

	public IBceRuleReturnData isCanSubmitOrder(long bceFrameId, long businessId, Map conditionMap, Map paramMap, int resType) throws Exception, RemoteException {
		IBceRuleReturnData ruleReturnData = new BceRuleReturnDataBean();
		ruleReturnData = verifyJavaRule(bceFrameId, businessId, conditionMap, paramMap, BceUtil.JAVA_RULE_SET_TYPE_ORDER_SUBMIT, ruleReturnData, resType);
		return ruleReturnData;
	}

	public IBceRuleReturnData isBatchBusiCanDo(long bceFrameId, long businessId, Map conditionMap, Map paramMap, int resType) throws Exception, RemoteException {
		IBceRuleReturnData ruleReturnData = new BceRuleReturnDataBean();
		ruleReturnData = verifyJavaRule(bceFrameId, businessId, conditionMap, paramMap, BceUtil.JAVA_RULE_SET_FRAME_BATCH_CAN, ruleReturnData, resType);
		return ruleReturnData;
	}
}
