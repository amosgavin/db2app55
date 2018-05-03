
package com.asiainfo.bi.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.common.bo.BOBsStaticDataBean;
import com.ai.common.i18n.CrmLocaleFactory;
import com.ai.common.ivalues.IBOBsStaticDataValue;
import com.ai.common.util.StaticDataUtil;
import com.asiainfo.crm.customer.common.CmConstants;
/**   
 * Copyright: Copyright (c) 2012 Asiainfo-Linkage
 * 
 * @ClassName: SaleStaticDataUtil.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: shigm
 * @date: 2012-7-13下午04:09:51
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2012-7-13      shigm     v1.0.0
 */
public class SaleStaticDataUtil {
	private static transient Log log = LogFactory.getLog(SaleStaticDataUtil.class);
	/**
	 * 
	 * 
	 * @Function: com.asiainfo.util.SaleStaticDataUtil.getChargeFeeType
	 * @Description:
	 *
	 * @param isChoose
	 * @param isForShow
	 * @return
	 * @throws Exception
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @date:2012-7-13下午04:09:51
	 * @deprecated
	 *
	 * Modification History:
	 * Date         Author      Version     Description
	 * -----------------------------------------------------------------
	 * 2012-7-13      shigm     v1.0.0
	 */
	public static IBOBsStaticDataValue[] getChargeFeeType(boolean isChoose, String isForShow) throws Exception {
		IBOBsStaticDataValue[] staticDataValues = StaticDataUtil.getStaticData(CmConstants.CmStaticDataCodeType.ACCOUNT_PAY_METHOD);
		List feeTypes = new ArrayList();
		// 如果需要加入空白行
		if (isChoose) {
			IBOBsStaticDataValue tmp = new BOBsStaticDataBean();
			tmp.setCodeType(CmConstants.CmStaticDataCodeType.ACCOUNT_PAY_METHOD);
			tmp.setCodeName(" ");
			tmp.setCodeValue("-1");
			tmp.setSortId(-1);
			tmp.setState("U");
			feeTypes.add(tmp);
		}
		if (isForShow.equalsIgnoreCase("true")) {
			// 用权限实体判断按钮
			for (int i = 0; i < staticDataValues.length; i++) {
				// 例如：过户的时候展示 "1,5,6,9"，为开户显示
				if ("31".equals("31")) {//例子
					feeTypes.add(staticDataValues[i]);
				}
			}
			return (IBOBsStaticDataValue[]) feeTypes.toArray(new IBOBsStaticDataValue[feeTypes.size()]);
		}
		return (IBOBsStaticDataValue[]) feeTypes.toArray(new IBOBsStaticDataValue[feeTypes.size()]);
	}
	
	
	public static IBOBsStaticDataValue[] getStaticDataDs(String codeType) throws Exception {
		return getStaticDataDs(false,false, codeType);
	}
	public static IBOBsStaticDataValue[] getStaticDataDs(boolean isChoose, boolean isAll, String codeType) throws Exception {
		codeType = codeType.trim();
		if (log.isDebugEnabled()) {
			log.debug(new StringBuilder().append("get static datas,the codeType is [").append(codeType).append("]"));
		}
		// 首先从基础库的静态数据中获取
		IBOBsStaticDataValue[] values = StaticDataUtil.getStaticData(codeType);
		// 对数据根据SORT_ID字段进行排序
		if (values == null) {
			values = new IBOBsStaticDataValue[0];
		}
		Arrays.sort(values, new Comparator() {
			public int compare(Object obj1, Object obj2) {
				int sortId1 = ((IBOBsStaticDataValue) obj1).getSortId();
				int sortId2 = ((IBOBsStaticDataValue) obj2).getSortId();
				return sortId1 - sortId2;
			}
		});

		if (log.isDebugEnabled()) {
			log.debug(new StringBuilder().append("the number of getted static data is ").append(values.length));
		}
		// 需要增加" "选项
		if (isChoose) {
			if (log.isDebugEnabled()) {
				log.debug("need to add 'please choose…' item!");
			}
			int length = (values == null) ? 0 : values.length;
			IBOBsStaticDataValue[] tmp = new IBOBsStaticDataValue[length + 1];
			// 生成" "节点对象
			tmp[0] = new BOBsStaticDataBean();
			tmp[0].setCodeType(codeType);
			tmp[0].setCodeName(" ");
			tmp[0].setCodeValue("-1");
			tmp[0].setSortId(-1);
			tmp[0].setState("U");
			// 将真实的静态数据拷贝到"请选择…"节点之后
			if (length > 0) {
				System.arraycopy(values, 0, tmp, 1, length);
			}
			values = tmp;
		}
		if (isAll) {
			int length = (values == null) ? 0 : values.length;
			IBOBsStaticDataValue[] tmp = new IBOBsStaticDataValue[length + 1];
			// 生成“所有”节点
			tmp[0] = new BOBsStaticDataBean();
			tmp[0].setCodeType(codeType);
			tmp[0].setCodeName(CrmLocaleFactory.getResource("SOS0000001"));
			tmp[0].setCodeValue("-2");
			tmp[0].setSortId(-2);
			tmp[0].setState("U");
			// 将真实的静态数据拷贝到"请选择…"节点之后
			if (length > 0) {
				System.arraycopy(values, 0, tmp, 1, length);
			}
			values = tmp;
		}
		return values;
	}
	
}
