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
 * 业务工具实现类
 * 
 * @since 1.0
 * @ClassName: BceSVUtil.java
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Qinjin Peng
 * @date 2011-6-18 下午07:43:03
 * @version 1.0
 */
public class BceSVUtil {
	public static transient Log log = LogFactory.getLog(BceSVUtil.class);
	public static final String REGION_ID = "REGION_ID";
	public static final String BCE_USE_SERVICE = "BCE_USE_SERVICE";
	public static final String USE_SERVICE_SPLIT = "ACTION";
	/**
	 * 规则来源信息定义值：前台
	 */
	public static final int _RES_TYPE_FORNT_ = 1;
	/**
	 * 规则来源信息定义值：后台（接口层）
	 */
	public static final int _RES_TYPE_BACK_ = 2;
	/**
	 * 规则来源信息定义值：批量层
	 */
	public static final int _RES_TYPE_BATCH_ = 3;
	/**
	 * 成员业务规则
	 */
	public static final int _RES_TYPE_MEMBER_ = 4;

	/**
	 * 提供服务
	 * 
	 * @param serviceName
	 *            服务名称
	 * @return
	 */
	public static Object getSVService(Class clazz) {
		return ReflectUtils.constructorNewInstance(clazz, new Class[] {},
				new Object[] {});
	}

	/**
	 * 提供服务
	 * 
	 * @param serviceName
	 *            服务名称
	 * @return
	 */
	public static Object getSVService(String serviceName) {
		return ReflectUtils.constructorNewInstance(serviceName, new Class[] {},
				new Object[] {});
	}

	/**
	 * 获取系统参数信息
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
	 * 获取所有系统参数信息
	 * 
	 * @return
	 */
	public static IBOBsParaDetailValue[] getAllSystemSrcType() {
		return null;
	}

	/**
	 * 设置跨中心设置：
	 * <p>
	 * 通过request 中的isCrossingRegion 参数
	 * <p>
	 * 来进行设置是否需要跨中心服务
	 * 
	 * @param request
	 * @throws Exception
	 * @author Qinjin Peng
	 * @deprecated
	 */
	public static void SetCrossing(HttpServletRequest request) throws Exception {

		// 跨中心路由数据
		boolean isCrossingRegion = HttpUtil.getAsBoolean(request,
				"isCrossingRegion");
		if (Boolean.valueOf(isCrossingRegion).booleanValue()) {
			if (log.isInfoEnabled()) {
				log.info("=============本次操将调去跨中心服务~");
			}
			// 设置跨中心服务
			SetCrossing();
		}
	}

	/**
	 * @deprecated 设置跨中心服务参数入口
	 */
	public static void SetCrossing() {
		BceCommonStore.putSomeThingToThread(ReflectUtils.BCE_IS_CROSS_SERVICE,
				ReflectUtils.BCE_CROSS_SERVICE_Y);
	}

	/**
	 * * 设置当前操作员中心
	 * <p>
	 * 如果没有设置中的话，通过此方法会设置当前操作员中心
	 * 
	 * @param isPass
	 *            此参数表示是否强制设置
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
		// 根据手机号码路由信息
		if (!CenterFactory.isSetCenterInfo()) {
			if (StringUtils.isNotBlank(billId)
					&& !StringUtils.equals("null", billId.trim())) {
				CenterFactory.setCenterInfoByTypeAndValue(CenterUtil.BILL_ID,
						billId);
			}
		}
		String regionId = (String) SessionManager.getUser().get(REGION_ID);
		if (log.isDebugEnabled()) {
			log.debug("当前采用模式是" + (isPass ? "" : "不") + "覆盖模式.");
			if (StringUtils.isBlank(regionId)) {
				log.debug("获取RegionId 为空，请注意：");
			}
			if (CenterFactory.isSetCenterInfo()) {
				log.debug("当前已经设置过中心，中心为："
						+ CenterFactory.getCenterInfo().getRegion());
			}
		}
		if (isPass
				|| (StringUtils.isNotBlank(regionId) && !CenterFactory
						.isSetCenterInfo())) {
			CenterFactory.setCenterInfoByTypeAndValue(CenterUtil.REGION_ID,
					regionId);
			if (log.isInfoEnabled()) {
				log.info("刚才给当前业务设置中心，中心为："
						+ CenterFactory.getCenterInfo().getRegion());
			}

		} else if (CenterFactory.isSetCenterInfo()
				&& (StringUtils.isNotBlank(regionId))) {
			String centerRegion = CenterFactory.getCenterInfo().getRegion();
			if (log.isInfoEnabled()) {
				log.info("当前操作员所在中心和当前业务所设置的中心数据不一致：将启动CrossService 。");
				log.info("当前设置的中心Region ID:" + centerRegion);
				log.info("当前操作员的中心Region ID:" + regionId);
			}
			if (!StringUtils.equals(centerRegion, regionId)) {
				SetCrossing();
			}
		} else {
			if (log.isInfoEnabled()) {
				log.info("当前不需要设置中心");
			}
		}

	}

	/**
	 * * 启动业务工作流： 在ReturnData 中设置设置 ParamMap参数来进行设置处理
	 * <p>
	 * 此业务工作流中可以设置相关 调此方法前，请设置相关Session信息
	 * 
	 * @param workFlowObjType
	 *            类型
	 * @param workflowCode
	 *            工作流编码
	 * @param returnData
	 *            处理对象
	 * @return returnData 增加了Pross返回值参数，可通过： returnData.ProcessReturnMap 参数进行获取
	 * @throws Exception
	 * @throws RemoteException
	 */
	public static IBceDealReturnData startWorkflow(String workFlowObjType,
			String workflowCode, IBceDealReturnData returnData)
			throws Exception, RemoteException {

		if (StringUtils.isBlank(workflowCode))
			ExceptionUtil.throwBusinessException("工作流编码不能为空~请调整后再调用~谢谢！");
		Map workflowParamMap = returnData.getWorkflowParamMap();
		if (workflowParamMap == null) {
			workflowParamMap = new HashMap();
		}
		Map returnMap = null;

		try {
			// 同步流程
			if (ComframeClient.isProcess(workflowCode)) {
				if (log.isWarnEnabled()) {
					log.warn("本次启动流程编码为：" + workflowCode
							+ "；此次为Process 流程;启动流程的参数为：" + workflowParamMap);
				}
				returnMap = ComframeClient.executeProcess(workflowCode,
						workflowParamMap);
				returnData.setProcessReturnMap(returnMap);
				// 异步流程
			} else {
				String workflowObjId = returnData.getWorkflowObjectId();
				if (log.isWarnEnabled()) {
					log.warn("本次启动流程编码为：" + workflowCode
							+ "；此次为WorkFlow 流程;workFlowObjType:"
							+ workFlowObjType + ";workflowObjId:"
							+ workflowObjId + ";启动流程的参数为：" + workflowParamMap);
				}
				ComframeClient.createWorkflow(workflowCode,
						String.valueOf(ServiceManager.getUser().getID()),
						workFlowObjType, workflowObjId, workflowParamMap,
						returnData.getWorkflowStartTime(),
						returnData.getWorkflowNotes());
			}
			if (log.isWarnEnabled()) {
				log.warn("启动流程完毕！！！！！！！！！+返回信息为："
						+ returnData.getProcessReturnMap());
			}
		} finally {

		}
		return returnData;
	}

	/**
	 * 检查Action
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
					.throwBusinessException("业务模块配置不正确：请检查DealService配置信息："
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
