package com.ai.bce.util;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.complex.center.CenterFactory;
import com.ai.appframe2.complex.center.CenterInfo;
import com.ai.appframe2.web.HttpUtil;
import com.ai.bce.ivalues.IBceDealReturnData;
import com.ai.bce.ivalues.IBceFrameJavaRulesetRelValue;
import com.ai.bce.ivalues.IBceFrameValue;
import com.ai.bce.ivalues.IBceRuleValue;
import com.ai.bce.ivalues.IQBceRulesetRuleValue;
import com.ai.bce.service.interfaces.IBceRuleEngineSV;
import com.ai.comframe.client.ComframeClient;
import com.ai.common.i18n.BusinessException;
import com.ai.common.util.CenterUtil;
import com.ai.common.util.ExceptionUtil;
import com.asiainfo.crm.common.ivalues.IBOBsParaDetailValue;
import com.asiainfo.openboss.obsystem.openbuffer.charHolder;

/**
 * ҵ�񹤾�ʵ����
 * 
 * @since 1.0
 * @ClassName: BceSVUtil.java
 * @Description: TODO(������һ�仰��������������)
 * @author Qinjin Peng
 * @date 2011-6-18 ����07:43:03
 * @version 1.0
 */
public class BceSVUtil {
	public static transient Log log = LogFactory.getLog(BceSVUtil.class);
	public static final String REGION_ID = "REGION_ID";
	public static final String BCE_USE_SERVICE = "BCE_USE_SERVICE";
	public static final String USE_SERVICE_SPLIT = "ACTION";
	/**
	 * ������Դ��Ϣ����ֵ��ǰ̨
	 */
	public static final int _RES_TYPE_FORNT_ = 1;
	/**
	 * ������Դ��Ϣ����ֵ����̨���ӿڲ㣩
	 */
	public static final int _RES_TYPE_BACK_ = 2;
	/**
	 * ������Դ��Ϣ����ֵ��������
	 */
	public static final int _RES_TYPE_BATCH_ = 3;
	/**
	 * ��Աҵ�����
	 */
	public static final int _RES_TYPE_MEMBER_ = 4;

	/**
	 * �ṩ����
	 * 
	 * @param serviceName
	 *            ��������
	 * @return
	 */
	public static Object getSVService(Class clazz) {
		return ReflectUtils.constructorNewInstance(clazz, new Class[] {},
				new Object[] {});
	}

	/**
	 * �ṩ����
	 * 
	 * @param serviceName
	 *            ��������
	 * @return
	 */
	public static Object getSVService(String serviceName) {
		return ReflectUtils.constructorNewInstance(serviceName, new Class[] {},
				new Object[] {});
	}

	/**
	 * ��ȡϵͳ������Ϣ
	 * 
	 * @param srcType
	 * @return
	 * @throws Exception
	 */
	public static IBOBsParaDetailValue getSystemSrcTypeById(long srcType)
			throws Exception {
		return BceUtil.getParaDetailValue("X", "BCE_SRC_OBJECT_TYPE",
				String.valueOf(srcType == 0 ? 1 : srcType));
	}

	/**
	 * ��ȡ����ϵͳ������Ϣ
	 * 
	 * @return
	 */
	public static IBOBsParaDetailValue[] getAllSystemSrcType() {
		return null;
	}

	/**
	 * ���ÿ��������ã�
	 * <p>
	 * ͨ��request �е�isCrossingRegion ����
	 * <p>
	 * �����������Ƿ���Ҫ�����ķ���
	 * 
	 * @param request
	 * @throws Exception
	 * @author Qinjin Peng
	 * @deprecated
	 */
	public static void SetCrossing(HttpServletRequest request) throws Exception {

		// ������·������
		boolean isCrossingRegion = HttpUtil.getAsBoolean(request,
				"isCrossingRegion");
		if (Boolean.valueOf(isCrossingRegion).booleanValue()) {
			if (log.isInfoEnabled()) {
				log.info("=============���βٽ���ȥ�����ķ���~");
			}
			// ���ÿ����ķ���
			SetCrossing();
		}
	}

	/**
	 * @deprecated ���ÿ����ķ���������
	 */
	public static void SetCrossing() {
		BceCommonStore.putSomeThingToThread(ReflectUtils.BCE_IS_CROSS_SERVICE,
				ReflectUtils.BCE_CROSS_SERVICE_Y);
	}

	/**
	 * * ���õ�ǰ����Ա����
	 * <p>
	 * ���û�������еĻ���ͨ���˷��������õ�ǰ����Ա����
	 * 
	 * @param isPass
	 *            �˲�����ʾ�Ƿ�ǿ������
	 * @throws Exception
	 */
	public static void setDoCenter(boolean isPass) throws Exception {

		String billId = String.valueOf(SessionManager.getUser().get(
				"BE_OP_BILLID"));
		/*
		 * if (log.isErrorEnabled()) { log.error(
		 * "==========================================================billId:" +
		 * billId); }
		 */
		// �����ֻ�����·����Ϣ
		if (!CenterFactory.isSetCenterInfo()) {
			if (StringUtils.isNotBlank(billId)
					&& !StringUtils.equals("null", billId.trim())) {
				CenterFactory.setCenterInfoByTypeAndValue(CenterUtil.BILL_ID,
						billId);
			}
		}
		String regionId = (String) SessionManager.getUser().get(REGION_ID);
		if (log.isDebugEnabled()) {
			log.debug("��ǰ����ģʽ��" + (isPass ? "" : "��") + "����ģʽ.");
			if (StringUtils.isBlank(regionId)) {
				log.debug("��ȡRegionId Ϊ�գ���ע�⣺");
			}
			if (CenterFactory.isSetCenterInfo()) {
				log.debug("��ǰ�Ѿ����ù����ģ�����Ϊ��"
						+ CenterFactory.getCenterInfo().getRegion());
			}
		}
		if (isPass
				|| (StringUtils.isNotBlank(regionId) && !CenterFactory
						.isSetCenterInfo())) {
			CenterFactory.setCenterInfoByTypeAndValue(CenterUtil.REGION_ID,
					regionId);
			if (log.isInfoEnabled()) {
				log.info("�ղŸ���ǰҵ���������ģ�����Ϊ��"
						+ CenterFactory.getCenterInfo().getRegion());
			}

		} else if (CenterFactory.isSetCenterInfo()
				&& (StringUtils.isNotBlank(regionId))) {
			String centerRegion = CenterFactory.getCenterInfo().getRegion();
			if (log.isInfoEnabled()) {
				log.info("��ǰ����Ա�������ĺ͵�ǰҵ�������õ��������ݲ�һ�£�������CrossService ��");
				log.info("��ǰ���õ�����Region ID:" + centerRegion);
				log.info("��ǰ����Ա������Region ID:" + regionId);
			}
			if (!StringUtils.equals(centerRegion, regionId)) {
				SetCrossing();
			}
		} else {
			if (log.isInfoEnabled()) {
				log.info("��ǰ����Ҫ��������");
			}
		}

	}

	/**
	 * * ����ҵ�������� ��ReturnData ���������� ParamMap�������������ô���
	 * <p>
	 * ��ҵ�������п���������� ���˷���ǰ�����������Session��Ϣ
	 * 
	 * @param workFlowObjType
	 *            ����
	 * @param workflowCode
	 *            ����������
	 * @param returnData
	 *            �������
	 * @return returnData ������Pross����ֵ��������ͨ���� returnData.ProcessReturnMap �������л�ȡ
	 * @throws Exception
	 * @throws RemoteException
	 */
	public static IBceDealReturnData startWorkflow(String workFlowObjType,
			String workflowCode, IBceDealReturnData returnData)
			throws Exception, RemoteException {

		if (StringUtils.isBlank(workflowCode))
			ExceptionUtil.throwBusinessException("���������벻��Ϊ��~��������ٵ���~лл��");
		Map workflowParamMap = returnData.getWorkflowParamMap();
		if (workflowParamMap == null) {
			workflowParamMap = new HashMap();
		}
		Map returnMap = null;

		try {
			// ͬ������
			if (ComframeClient.isProcess(workflowCode)) {
				if (log.isWarnEnabled()) {
					log.warn("�����������̱���Ϊ��" + workflowCode
							+ "���˴�ΪProcess ����;�������̵Ĳ���Ϊ��" + workflowParamMap);
				}
				returnMap = ComframeClient.executeProcess(workflowCode,
						workflowParamMap);
				returnData.setProcessReturnMap(returnMap);
				// �첽����
			} else {
				String workflowObjId = returnData.getWorkflowObjectId();
				if (log.isWarnEnabled()) {
					log.warn("�����������̱���Ϊ��" + workflowCode
							+ "���˴�ΪWorkFlow ����;workFlowObjType:"
							+ workFlowObjType + ";workflowObjId:"
							+ workflowObjId + ";�������̵Ĳ���Ϊ��" + workflowParamMap);
				}
				ComframeClient.createWorkflow(workflowCode,
						String.valueOf(ServiceManager.getUser().getID()),
						workFlowObjType, workflowObjId, workflowParamMap,
						returnData.getWorkflowStartTime(),
						returnData.getWorkflowNotes());
			}
			if (log.isWarnEnabled()) {
				log.warn("����������ϣ�����������������+������ϢΪ��"
						+ returnData.getProcessReturnMap());
			}
		} finally {

		}
		return returnData;
	}

	/**
	 * ���Action
	 * 
	 * @param dealService
	 * @return
	 * @throws BusinessException
	 */
	public static String checkAction(String dealService)
			throws BusinessException {
		String[] services = StringUtils.split(dealService, "[]");
		if (services.length == 2) {
			if (USE_SERVICE_SPLIT.equalsIgnoreCase(services[0])) {
				return services[1];
			}
			ExceptionUtil
					.throwBusinessException("ҵ��ģ�����ò���ȷ������DealService������Ϣ��"
							+ dealService);
		}
		return BceSVUtil.BCE_USE_SERVICE;
	}

	public static String getStaticRegionId() {

		if (CenterFactory.isSetCenterInfo())
			return CenterFactory.getCenterInfo().getRegion();
		else {
			return (String.valueOf(ServiceManager.getUser().get("REGION_ID")));
		}

	}

	public static boolean isUseRule(String key, int resType)
			throws BceException {
		if (key.length() < resType) {
			return false;
		}
		char keyI = key.charAt(resType - 1);
		if (keyI == '1') {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws BceException {
		System.out.println(BceSVUtil.isUseRule("101", 1));
	}

	public static boolean checkIsCrossing(long bceFrameId, Map paramMap,
			int vaType) throws Exception {
		IBceFrameJavaRulesetRelValue[] soJavaRuleSet = BceServiceFactory
				.getBceFrameSV().getRegistedRuleSet(bceFrameId, vaType,
						paramMap);
		for (int i = 0; i < soJavaRuleSet.length; i++) {
			IBceFrameJavaRulesetRelValue iBceFrameJavaRulesetRelValue = soJavaRuleSet[i];
			IQBceRulesetRuleValue[] rules = BceServiceFactory.getBceFrameSV()
					.getRulesByRulesetId(
							iBceFrameJavaRulesetRelValue.getRulesetId());
			for (int j = 0; j < rules.length; j++) {
				IQBceRulesetRuleValue reBceRulesetRuleValue = rules[j];
				IBceRuleValue bceRuleValue = BceServiceFactory.getBceFrameSV()
						.getBceRule(reBceRulesetRuleValue.getRuleId());
				if (StringUtils.equals(bceRuleValue.getCenterType(),
						ReflectUtils.BCE_IS_CROSS_SERVICE)
						&& StringUtils.equals(ReflectUtils.BCE_CROSS_SERVICE_Y,
								bceRuleValue.getCenterValueIndex())) {
					if (log.isDebugEnabled()) {
						log.debug(LocaleResourceFactory
								.getResource("BES0000848"));
					}
					// BceSVUtil.SetCrossing();
					return true;
				}
			}
		}
		return false;
	}
}
