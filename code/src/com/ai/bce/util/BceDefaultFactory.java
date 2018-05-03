package com.ai.bce.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.AIThreadLocal;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.bce.auto.plugin.qr.PrintUtil;
import com.ai.bce.ivalues.IBceData;
import com.ai.bce.ivalues.IBceDealReturnData;
import com.ai.bce.ivalues.IBceFrameValue;
import com.ai.bce.service.interfaces.IBceDealService;
import com.ai.bce.util.bean.PreDealBusiPrintBean;
import com.ai.bce.valuebean.BceDealReturnDataBean;
import com.ai.omframe.order.valuebean.OrderConst;

/**
 * 
 * Bce处理处理中心
 * 
 * @ClassName: BceFactory.java
 * @Description:
 * @author :彭秦进
 * @date 2011-7-29
 * @email:pengqj@asiainfo-linkage.com
 */
public class BceDefaultFactory {
	public static transient final Log log = LogFactory.getLog(BceDefaultFactory.class);
	private static ThreadLocal local = new AIThreadLocal();

	public Object get() {
		return local.get();
	}

	public void set(Object value) {
		local.set(value);
	}

	/**
	 * 单例BCE工厂
	 */
	public static final BceDefaultFactory bceFactory = new BceDefaultFactory();

	public static BceDefaultFactory _getInstance() {
		return bceFactory;
	}

	/**
	 * 处理服务
	 * 
	 * @param beFrameId
	 * @param bceData
	 * @param is_CONFIRM
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public IBceDealReturnData dealService(long beFrameId, IBceData bceData,
			boolean is_CONFIRM, long orderId) throws Exception {
		IBceDealReturnData returnData=null;
		boolean isNotFirstUse = Boolean.valueOf(String.valueOf(get()));
		Map printDealResultInfo=null;
		PreDealBusiPrintBean preDealBusiPrintBean=null;
		if (isNotFirstUse == false) {
			// 第一次进入
			set(true);
		}
		HashMap bkObject = (HashMap) BceCommonStore.getBakForOM();
		try {
			BusiPrintInvoke busiPrintInvoke = BusiPrintInvoke._getInstance();
			
			if (log.isDebugEnabled()) {
				log.debug(LocaleResourceFactory.getException(
						"BES0000832",
						new Object[] { String.valueOf(beFrameId), bceData,
								Boolean.valueOf(is_CONFIRM),
								String.valueOf(orderId) }));
			}
			PrintUtil.putCustomOrderId(orderId);
			IBceFrameValue beFrame = BceServiceFactory.getBceFrameSV()
					.getBceFrameValue(beFrameId);
			
			//在做打印之前先做一个预先处理 主要给退订和业务变更等做数据准备
			//preDealBusiPrintBean=busiPrintInvoke.printBusiDoBefore(bceData, beFrameId);
			
			
			// 调用处理服务
			String dealServiceId = beFrame.getDealService();
			String workflowCode = beFrame.getWorkflowCode();

			if (log.isDebugEnabled()) {
				log.debug(LocaleResourceFactory.getResource(
						"BES0000833",
						new Object[] {
								String.valueOf(beFrameId),
								StringUtils.isNotBlank(dealServiceId) ? dealServiceId
										: "",
								StringUtils.isNotBlank(workflowCode) ? workflowCode
										: "" }));
			}

			// 未找到处理服务。
			if (StringUtils.isBlank(dealServiceId)) {
				log.error(LocaleResourceFactory.getResource("BES0000834",
						new Object[] { String.valueOf(beFrameId) }));
				BceException.throwException("BES0000834",
						new Object[] { String.valueOf(beFrameId) });
			}
		
			returnData = new BceDealReturnDataBean();

			IBceDealService service = (IBceDealService) ServiceFactory
					.getService(dealServiceId);
			// 业务处理
			returnData = service.deal(bceData, beFrameId);
			// 需要启动流程
			if (StringUtils.isNotBlank(returnData.getWorkflowCode())) {
				workflowCode = returnData.getWorkflowCode();
			}
			if (StringUtils.isNotBlank(workflowCode)) {
				BceSVUtil.startWorkflow(BceServiceFactory.getBceFrameSV()
						.getOrderObjectType(0, beFrameId), workflowCode,
						returnData);
			}
			// 构造返回对象
			returnData = service.createCustomProperty(bceData, returnData);
			String flagSuccess = returnData.getIsSuccess();
			if(!StringUtils.isEmpty(flagSuccess)){
				if(OrderConst.STR_YES.equals(flagSuccess)|| OrderConst.STR_YES_DESC.equals(flagSuccess)){
				//	printDealResultInfo = busiPrintInvoke.printBusiInvoke(bceData,beFrameId,preDealBusiPrintBean);
				}
			}
			
			

			
		} finally {
			// 针对
			//BceCommonStore.clearThread();
			//
			HashMap hashMap = (HashMap) BceCommonStore.getBakForOM();
			if(hashMap!=null)
				hashMap.clear();
			if (!isNotFirstUse) {
				BceCommonStore.setBakForOM(null);
				set(null);
				//设置到returnData 统一放到Action保存
				if(null!=returnData && null!=printDealResultInfo)
				{
					Map tmpInfo = returnData.getProcessReturnMap();
					if(null==tmpInfo){
						tmpInfo = new HashMap();
					}
					//tmpInfo.put("preDealBusiPrintBean", preDealBusiPrintBean);
					tmpInfo.put("printDealResultInfo", printDealResultInfo);
					returnData.setProcessReturnMap(tmpInfo);
				}
				
			} else {
				BceCommonStore.setBakForOM(bkObject);
			}
		}
		return returnData;

	}
}
