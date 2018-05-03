package com.ai.bce.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.complex.center.CenterFactory;
import com.ai.appframe2.web.HttpUtil;
import com.ai.bce.ivalues.IBceFrameValue;
import com.ai.bce.ivalues.IBcePageFrameValue;
import com.ai.bce.ivalues.IBceRowsetValue;
import com.ai.bce.ivalues.IQPageFramePageValue;
import com.ai.bce.util.BceException;
import com.ai.bce.util.BceServiceFactory;
import com.ai.bce.util.BceUtil;

public class BceMainBean {
	private static transient Log log = LogFactory.getLog(BceMainBean.class);

	public static final String PAGE_FRAME_TYPE_TAB = "1"; // tab页模式
	public static final String PAGE_FRAME_TYPE_NEXT = "2";// 上一步、下一步
	public static final String PAGE_FRAME_TYPE_ALL = "3";// 单页全部显示

	protected String strBusiOperId = null;
	protected String strBusiOperName = null;
	protected String strReturnPage = null;
	protected String strPrePage = null;
	protected IBceFrameValue soFrameValue = null;
	protected IQPageFramePageValue[] soOfferBusipageConfigs = null;
	protected String[] titles = null;
	protected String strPageFrameId = null;
	protected String strBceFrameId = null;
	protected String strPageFrameType = null;

	public void initial(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			String regionId = HttpUtil.getAsString(request, "REGION_ID");
			if (StringUtils.isEmpty(regionId)) {
				regionId = (String) SessionManager.getUser().get("REGION_ID");
			}
			CenterFactory.setCenterInfoByTypeAndValue("RegionId", regionId);

				strBusiOperId = HttpUtil.getAsString(request,
						BceUtil.BUSIOPER_ID_KEY);
				/**
				 * 中文描述
				 */
				strBusiOperName = HttpUtil.getAsString(request,BceUtil.BUSIOPER_NAME_KEY);

				strReturnPage = String.valueOf(HttpUtil.getAsString(request,"RETURN_PAGE"));
				strPrePage = String.valueOf(HttpUtil.getAsString(request, "PRE_PAGE"));
				// 如果上一页为空,则上一页的url等于返回页的url
				if (StringUtils.isBlank(strPrePage)
						&& StringUtils.isNotBlank(strReturnPage)) {
					strPrePage = strReturnPage;
				}

				soFrameValue = BceServiceFactory.getBceFrameSV().getBceFrameValue( new Long(
						strBusiOperId).longValue(),BceUtil.getMap(request));

				// 获取配置页面的信息.同时设置SO_BUSIOPERFRAME_ID,SO_FRAME_ID到sosession中
				soOfferBusipageConfigs = BceServiceFactory.getBceFrameSV().getPageFramePages(soFrameValue
						.getBceFrameId(), soFrameValue.getPageFrameId());
				if (soOfferBusipageConfigs == null
						|| soOfferBusipageConfigs.length == 0) {
					// 没有查询到本操作在受理框架包含的页面.请检查
					throw new BceException("BES0000009");
				}
				strBceFrameId = String.valueOf(soFrameValue.getBceFrameId());
				request.setAttribute(BceUtil.BCE_FRAME_ID_KEY,strBceFrameId);

				strPageFrameId = String.valueOf(soFrameValue.getPageFrameId());

				IBcePageFrameValue aSoPageFrameValue = BceServiceFactory.getBceFrameSV().getBePageFrameValue(soFrameValue.getPageFrameId());
				strPageFrameType = String.valueOf(aSoPageFrameValue.getFrameType());
				titles = new String[soOfferBusipageConfigs.length];
				for (int i = 0; i < soOfferBusipageConfigs.length; i++) {
					titles[i] = soOfferBusipageConfigs[i].getPageTitle();
				}				

		} catch (NumberFormatException e) {
			log.error(e.getMessage(),e);
			e.printStackTrace(response.getWriter());
			// 参数转化出现错误.ex:
			throw new BceException("BES0000010");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			// SoMainBean初始化错误.错误ex:
			throw new BceException("BES0000011", String
					.valueOf(e.getCause() == null ? e.getMessage() : e.getCause()
							.getMessage()));
		}
	}

	public void getSoFrameRowSet(JspWriter out) throws Exception {
//		String ROLE_MACRO_STR = "$PAGE_ROLE_ID";
		for (int i = 0; i < soOfferBusipageConfigs.length; i++) {
			IBceRowsetValue[] pageRowSets = BceServiceFactory.getBceFrameSV().getPageRowsets(soOfferBusipageConfigs[i].getPageFramePageId());

			// 查询页面关联的角色列表，以便替换rowset中的宏变量
//			IBceFramePageRoleValue[] roles= BceServiceFactory.getBceFrameSV().getBceFramePageRoles(Long.parseLong(strBceFrameId), soOfferBusipageConfigs[i].getPageFramePageId());
			if (pageRowSets != null) {
				for (int j = 0; j < pageRowSets.length; j++) {
/*					if (StringUtils.contains(pageRowSets[j].getRowsetKey(),
							ROLE_MACRO_STR)) {
						for (int j2 = 0; j2 < roles.length; j2++) {
							long rowSetId = pageRowSets[j].getRowsetId();
							long rowSetType = pageRowSets[j].getRowsetType();
							String rowSetKey = pageRowSets[j].getRowsetKey();
							rowSetKey = StringUtils.replace(rowSetKey, ROLE_MACRO_STR, String
									.valueOf(roles[j2].getRoleId()));
							String rowSetMethod = pageRowSets[j].getRowsetMethod();
							writePageJs(out, rowSetId, rowSetType, rowSetKey, rowSetMethod,
									soOfferBusipageConfigs[i].getPageFramePageId(), j+j2);
						}
					} else {
						long rowSetId = pageRowSets[j].getRowsetId();
						long rowSetType = pageRowSets[j].getRowsetType();
						String rowSetKey = pageRowSets[j].getRowsetKey();
						String rowSetMethod = pageRowSets[j].getRowsetMethod();
						writePageJs(out, rowSetId, rowSetType, rowSetKey, rowSetMethod,
								soOfferBusipageConfigs[i].getPageFramePageId(), j);
					}*/
					long rowSetId = pageRowSets[j].getRowsetId();
					long rowSetType = pageRowSets[j].getRowsetType();
					String rowSetKey = pageRowSets[j].getRowsetKey();
					String rowSetMethod = pageRowSets[j].getRowsetMethod();
					writePageJs(out, rowSetId, rowSetType, rowSetKey, rowSetMethod,
							soOfferBusipageConfigs[i].getPageFramePageId(), j);
				}
			}
		}
	}

	public static void writePageJs(JspWriter out, long rowSetId, long rowSetType,
			String rowSetKey, String rowSetMethod, long pageId, int j)
			throws Exception {
		BceFrameAction.writePageJs(out, rowSetId, rowSetType, rowSetKey, rowSetMethod, pageId, j);
	}

	/**
	 * @return the strBusiOperId
	 */
	public String getStrBusiOperId() {
		return strBusiOperId;
	}

	/**
	 * @param strBusiOperId
	 *          the strBusiOperId to set
	 */
	public void setStrBusiOperId(String strBusiOperId) {
		this.strBusiOperId = strBusiOperId;
	}

	/**
	 * @return the soOfferBusipageConfigs
	 */
	public IQPageFramePageValue[] getSoOfferBusipageConfigs() {
		return soOfferBusipageConfigs;
	}

	/**
	 * @param soOfferBusipageConfigs
	 *          the soOfferBusipageConfigs to set
	 */
	public void setSoOfferBusipageConfigs(
			IQPageFramePageValue[] soOfferBusipageConfigs) {
		this.soOfferBusipageConfigs = soOfferBusipageConfigs;
	}

	/**
	 * @return the strBusiOperName
	 */
	public String getStrBusiOperName() {
		return strBusiOperName;
	}

	/**
	 * @param strBusiOperName
	 *          the strBusiOperName to set
	 */
	public void setStrBusiOperName(String strBusiOperName) {
		this.strBusiOperName = strBusiOperName;
	}

	/**
	 * @return the strPrePage
	 */
	public String getStrPrePage() {
		return strPrePage;
	}

	/**
	 * @param strPrePage
	 *          the strPrePage to set
	 */
	public void setStrPrePage(String strPrePage) {
		this.strPrePage = strPrePage;
	}

	/**
	 * @return the strReturnPage
	 */
	public String getStrReturnPage() {
		return strReturnPage;
	}

	/**
	 * @param strReturnPage
	 *          the strReturnPage to set
	 */
	public void setStrReturnPage(String strReturnPage) {
		this.strReturnPage = strReturnPage;
	}

	/**
	 * @return the strSoPageFrameId
	 */
	public String getStrPageFrameId() {
		return strPageFrameId;
	}

	/**
	 * @param strSoPageFrameId
	 *          the strSoPageFrameId to set
	 */
	public void setStrPageFrameId(String strPageFrameId) {
		this.strPageFrameId = strPageFrameId;
	}

	/**
	 * @return the titles
	 */
	public String[] getTitles() {
		return titles;
	}

	// /**
	// * @return the isShowPreSale
	// */
	// public boolean isShowPreSale() {
	// return isShowPreSale;
	// }

	public String getStrBceFrameId() {
		return strBceFrameId;
	}

	public void setStrBceFrameId(String strSoFrameId) {
		this.strBceFrameId = strSoFrameId;
	}

	public String getStrPageFrameType() {
		return strPageFrameType;
	}

	public void setStrPageFrameType(String strPageFrameType) {
		this.strPageFrameType = strPageFrameType;
	}

	public IBceFrameValue getBceFrameValue() {
		return soFrameValue;
	}

	public void setBceFrameValue(IBceFrameValue soFrameValue) {
		this.soFrameValue = soFrameValue;
	}
	

	public String getStrCommParam() {
		String retValue = "";
		if (StringUtils.isNotBlank(strBusiOperId)) {
			retValue += "&" + BceUtil.BUSIOPER_ID_KEY + "="
					+ strBusiOperId;
		}
		if (StringUtils.isNotBlank(strBusiOperName)) {
			retValue += "&" + BceUtil.BUSIOPER_NAME_KEY + "="
					+ strBusiOperName;
		}
		if (StringUtils.isNotBlank(strBceFrameId)) {
			retValue += "&" + BceUtil.BCE_FRAME_ID_KEY + "="
					+ strBceFrameId;
		}
		if (StringUtils.isNotBlank(retValue)
				&& StringUtils.indexOf(retValue, "&") == 0) {
			retValue = StringUtils.substring(retValue, 1);
		}

		return retValue;
	}

}
