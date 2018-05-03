/***********************************************************************
 * Module:       BceAutoSetAction.java
 * Description:  
 * Company:      Asiainfo
 * Author:       LinHailu
 * Date:         Nov 18, 2010
 ***********************************************************************/

package com.ai.bce.web;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ListDataSourceInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.listdatasource.CashedObject;
import com.ai.appframe2.listdatasource.CashedObjectFactory;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.set.FieldTypeSetXml.Field;
import com.ai.appframe2.set.FieldTypeSetXml.FieldList;
import com.ai.appframe2.set.FieldTypeSetXml.ListDataSource;
import com.ai.comframe.vm.processflow.ProcessInstance;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.ai.appframe2.web.tag.AutoSet;
import com.ai.appframe2.web.tag.DBFormElementFactory;
import com.ai.bce.ivalues.IQBceBusinessAttrValue;
import com.ai.bce.util.BceException;
import com.ai.bce.util.BceSVUtil;
import com.ai.bce.util.BceServiceFactory;
import com.ai.bce.util.BceUtil;
import com.ai.common.util.TimeUtil;

public class BceAutoSetAction extends BaseAction {
	public AutoSet getBceAttrAutoForm() throws Exception {
		HttpServletRequest req = SessionManager.getRequest();
		long bceFrameId = HttpUtil.getAsLong(req, BceUtil.BCE_FRAME_ID_KEY);
		String formId = HttpUtil.getAsString(req, BceUtil.AREA_ID);

		IQBceBusinessAttrValue[] attrs = BceServiceFactory.getBceFrameSV()
				.getQBceBusinessAttrs(bceFrameId, formId);
		if (attrs == null || attrs.length == 0) {
			throw new BceException("BES0000404",
					new String[] { String.valueOf(bceFrameId) });
		}

		String setName = "BceSet" + bceFrameId + formId
				+ BceSVUtil.getStaticRegionId();
		AutoSet autoSet = new AutoSet(setName);

		List hideFieldList = null;
		for (int i = 0; i < attrs.length; i++) {
			hideFieldList = addAttrFieldToAutoSet(autoSet, attrs[i], req,
					hideFieldList);
		}

		req.setAttribute("BUSI_ATTRS", attrs);
		req.setAttribute(BceUtil.HIDE_FIELD_LIST, hideFieldList);
		return autoSet;
	}

	public AutoSet getBceAttrGrid() throws Exception {
		HttpServletRequest req = SessionManager.getRequest();
		long bceFrameId = HttpUtil.getAsLong(req, BceUtil.BCE_FRAME_ID_KEY);
		String formId = HttpUtil.getAsString(req, BceUtil.AREA_ID);

		IQBceBusinessAttrValue[] attrs = BceServiceFactory.getBceFrameSV()
				.getQBceBusinessAttrs(bceFrameId, formId);
		if (attrs == null || attrs.length == 0) {
			throw new BceException("BES0000404",
					new String[] { String.valueOf(bceFrameId) });
		}

		String setName = "BceSet" + bceFrameId + formId;
		AutoSet autoSet = new AutoSet(setName);

		List hideFieldList = null;
		for (int i = 0; i < attrs.length; i++) {
			hideFieldList = addAttrFieldToAutoSet(autoSet, attrs[i], req,
					hideFieldList);
		}

		FieldList fieldList = autoSet.getFieldList();
		int count = fieldList.getFieldCount();
		for (int i = 0; i < count; i++) {
			Field field = fieldList.getField(i);
			for (int k = 0; k < attrs.length; k++) {
				if (field.getIDText().equals(attrs[k].getAttrCode())) {
					if (StringUtils.isNotBlank(attrs[k].getFieldWidth())) {
						field.setFieldWidth(attrs[k].getFieldWidth());
					}
					if (attrs[k].getSeqNo() != 0) {
						field.setDisplaySeq(String.valueOf(attrs[k].getSeqNo()));
					}
					break;
				}
			}
			// 这样设置的隐藏字段不在页面生成，改在BceDBGridImpl设置
			/*
			 * if(hideFieldList != null &&
			 * hideFieldList.contains(field.getIDText())){ //
			 * field.setGridVisible("false"); //设置无用 field.setDisplaySeq("-1");
			 * }
			 */
		}
		return autoSet;
	}

	private String getSetKey(String setName) {
		String key = setName;
		Locale locale = ServiceManager.getLocale();
		if (key != null && locale != null) {
			key = key + "_" + locale.toString();
		}
		return key;
	}

	public List addAttrFieldToAutoSet(AutoSet pAutoSet,
			IQBceBusinessAttrValue pBaseAttrValue, HttpServletRequest pReq,
			List hideFieldList) throws Exception {
		String pEditType = pBaseAttrValue.getEditType() + "";
		String defaultValue = pBaseAttrValue.getDefaultValue();
		String displayText = defaultValue;
		String valueClass = pBaseAttrValue.getValueClass();
		String pFieldName = pBaseAttrValue.getAttrCode();
		String pTitle = pBaseAttrValue.getAttrName();
		boolean nullable = pBaseAttrValue.getIsNullable() == 1 ? true : false;
		boolean editable = pBaseAttrValue.getIsEditable() == 1 ? true : false;
		boolean visible = pBaseAttrValue.getIsVisible() == 1 ? true : false;

		boolean clearCache = false;
		// 处理defaultValue
		if (BceUtil.ATTR_DEFAULT_SYSDATE.equalsIgnoreCase(defaultValue)) {
			defaultValue = TimeUtil.getYYYY_MM_DD(TimeUtil
					.getPrimaryDataSourceSysDate());
			displayText = defaultValue;
			clearCache = true;
		} else if (BceUtil.ATTR_DEFAULT_SYSDATETIME
				.equalsIgnoreCase(defaultValue)) {
			Timestamp sysdate = TimeUtil.getPrimaryDataSourceSysDate();
			DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			defaultValue = dateformat.format(sysdate);
			displayText = defaultValue;
			clearCache = true;
		} else if (StringUtils.isNotBlank(valueClass)) {
			Map paramMap = BceUtil.getMap(pReq);
			ProcessInstance servObj = (ProcessInstance) ServiceFactory
					.getSeviceOfLocal(valueClass);
			paramMap = servObj.execute(paramMap);
			defaultValue = (String) paramMap
					.get(BceUtil.AUTO_CREATE_ATTR_RETURN_ID_KEY);
			displayText = (String) paramMap
					.get(BceUtil.AUTO_CREATE_ATTR_RETURN_DISP_TEXT_KEY);
			if (StringUtils.isBlank(displayText)) {
				displayText = defaultValue;
			}
			clearCache = true;
		}
		if (clearCache == true) {
			SessionManager.getCacheManager().remove("SET",
					getSetKey(pAutoSet.getName()));
		}

		if (visible == false) {
			if (hideFieldList == null) {
				hideFieldList = new ArrayList();
			}
			hideFieldList.add(pFieldName);
		}

		// 此设置在底层未能使用
		long pFieldWidth = 100;
		if (StringUtils.isNotBlank(pBaseAttrValue.getFieldWidth())
				&& StringUtils.isNumeric(pBaseAttrValue.getFieldWidth())) {
			pFieldWidth = Long.parseLong(pBaseAttrValue.getFieldWidth());
		}
		long pFieldHeight = 20;

		int attrLength = 255;
		if (pBaseAttrValue.getMaxLength() > 0) {
			try {
				attrLength = (int) pBaseAttrValue.getMaxLength();
				if (attrLength < 1) {
					attrLength = 255;
				}
			} catch (Throwable e) {
				attrLength = 255;
			}
		}

		String dataType = DataType.DATATYPE_STRING;
		if (StringUtils.isNotBlank(pBaseAttrValue.getFieldType())
				&& pBaseAttrValue.getFieldType().indexOf("NUMBER") == 0) {
			if (pBaseAttrValue.getFieldType().indexOf(",") > 0)
				dataType = DataType.DATATYPE_DOUBLE;
			else if (attrLength <= 6)
				dataType = DataType.DATATYPE_INTEGER;
			else
				dataType = DataType.DATATYPE_LONG;
		}

		// 显示标签
		if (BceUtil.ATTR_EDIT_TYPE_LABEL.equals(pEditType)
				|| DBFormElementFactory.DBLABLE.equals(pEditType)) {
			pAutoSet.addOneField(pFieldName, pFieldName, pTitle, pFieldName,
					"", dataType, attrLength, 0, false,
					DBFormElementFactory.DBLABLE, "", "", false, nullable,
					null, defaultValue, displayText, "", pFieldWidth,
					pFieldHeight);
		}
		// 密码输入框
		else if (BceUtil.ATTR_EDIT_TYPE_PASSWORD.equals(pEditType)
				|| DBFormElementFactory.DBPASSWORD.equals(pEditType)) {
			pAutoSet.addOneField(pFieldName, pFieldName, pTitle, pFieldName,
					"", dataType, attrLength, 0, editable,
					DBFormElementFactory.DBPASSWORD, "", "", false, nullable,
					null, defaultValue, displayText, "", pFieldWidth,
					pFieldHeight);
		}
		// 单行编辑框
		else if (BceUtil.ATTR_EDIT_TYPE_EDIT.equals(pEditType)
				|| DBFormElementFactory.DBEDIT.equals(pEditType)) {
			pAutoSet.addOneField(pFieldName, pFieldName, pTitle, pFieldName,
					"DisplayText", dataType, attrLength, 0, editable,
					DBFormElementFactory.DBEDIT, "", "", false, nullable, null,
					defaultValue, displayText, "", pFieldWidth, pFieldHeight);

		}
		// 下拉列表框
		else if (BceUtil.ATTR_EDIT_TYPE_LIST.equals(pEditType)
				|| DBFormElementFactory.DBLISTBOX.equals(pEditType)
				|| BceUtil.ATTR_EDIT_TYPE_EDITABLELIST.equals(pEditType)) {
			String isEditListBox = "";
			if (BceUtil.ATTR_EDIT_TYPE_EDITABLELIST.equals(pEditType)) {
				isEditListBox = "true";
			}
			String dsName = pBaseAttrValue.getResSrc();
			// 参数格式:name=value&name2=value2
			String dsParam = pBaseAttrValue.getResParam();

			if (StringUtils.isNotBlank(dsName)) {
				ListDataSource aListDataSource;
				if (StringUtils.isNotBlank(dsParam)
						&& dsParam.indexOf("{F}") > 0) {
					aListDataSource = AutoSet.createListDataSource(dsName,
							true, false, null);
				} else {
					aListDataSource = AutoSet.createListDataSource(dsName,
							false, false, null);
				}
				HashMap paraMap = new HashMap();
				if (StringUtils.isNotBlank(dsParam)) {
					String MACRO_REQUEST = "$REQUEST";
					String[] paramArray = StringUtils.split(dsParam, "&");

					// // 解析dsParam,如果里面有服务参数(${}),调用他们
					// dsParam = parseServiceInAttrInterfaceConfigValue(pReq,
					// dsParam);
					// 解析参数
					for (int i = 0; i < paramArray.length; i++) {
						String[] nameAndValue = StringUtils.split(
								paramArray[i], "=");
						if (nameAndValue.length == 2) {
							String paramValue = nameAndValue[1];
							if (StringUtils.contains(nameAndValue[1],
									MACRO_REQUEST)) {
								String[] AryValue = StringUtils.split(
										nameAndValue[1], ".");
								if (AryValue.length < 2) {
									// 下拉数据源实参格式定义错误！应定义为如$REQUEST.CUSTOMER_ID。
									throw new BceException("BES0000408");
								}
								paramValue = (String) pReq
										.getParameter(AryValue[1]);
								if (StringUtils.isBlank(paramValue)) {
									paramValue = (String) pReq
											.getAttribute(AryValue[1]);
								}
							}

							String paramName = nameAndValue[0].trim();
							if ((StringUtils.isNotBlank(paramName))
									&& paramName.startsWith("{F}")) {
								AutoSet.addListDataSourceParameter(
										aListDataSource,
										paramName.substring(3), "Field",
										paramValue);
							} else {
								AutoSet.addListDataSourceParameter(
										aListDataSource, paramName, "Const",
										paramValue);
							}
							paraMap.put(paramName.trim(), paramValue.trim());

						}
					}
				}
				String displayVal = "";
				// 如果需要获取值,并且默认值不为空.则查询下拉数据,将默认值转换为文本显示.
				if (StringUtils.isNotBlank(defaultValue)) {
					// 需要获取显示属性.查询ds数据,获取显示属性
					Object valObj = SessionManager.getListSrcFactory()
							.getDataSourceObject(dsName, paraMap);
					ListDataSourceInterface datasrc = SessionManager
							.getListSrcFactory().getListDataSource(dsName);
					CashedObject cashedObject = CashedObjectFactory
							.getInstance(valObj, datasrc.getValueAttr(),
									datasrc.getTextAttr(0));
					displayVal = (String) cashedObject
							.getTextById(defaultValue);
				}
				pAutoSet.addOneField(pFieldName, pFieldName, pTitle,
						pFieldName, "", dataType, attrLength, 0, editable,
						DBFormElementFactory.DBLISTBOX, "", "", false,
						nullable, aListDataSource, defaultValue, displayVal,
						isEditListBox, pFieldWidth, pFieldHeight);
			}
		}
		// 对话框输入编辑方式
		else if (BceUtil.ATTR_EDIT_TYPE_OPEN_WIN.equals(pEditType)
				|| DBFormElementFactory.DBOPENWIN.equals(pEditType)) {
			pAutoSet.addOneField(pFieldName, pFieldName, pTitle, pFieldName,
					"DisplayText", dataType, attrLength, 0, editable,
					DBFormElementFactory.DBOPENWIN, "", "", false, nullable,
					null, defaultValue, displayText, pBaseAttrValue.getResSrc()
							+ "|||" + pBaseAttrValue.getResParam(),
					pFieldWidth, pFieldHeight);
		}
		// 调用类和方法从后台获取值的编辑方式
		else if (BceUtil.ATTR_EDIT_TYPE_CLASS_VALUE.equals(pEditType)) {
			if (StringUtils.isBlank(valueClass)) {
				// "字段" + pFieldName + "没有定义接口类"
				throw new BceException("BES0000005",
						new String[] { pFieldName });
			}

			pAutoSet.addOneField(pFieldName, pFieldName, pTitle, pFieldName,
					"", dataType, attrLength, 0, false,
					DBFormElementFactory.DBLABLE, "", "", false, nullable,
					null, defaultValue, displayText, "", pFieldWidth,
					pFieldHeight);
		}
		// 隐藏类型的编辑方式
		else if (BceUtil.ATTR_EDIT_TYPE_HIDE.equals(pEditType)) {
			// 隐藏类型的field字段,在request.attri中的HideFieldNameList进行记录
			if (hideFieldList == null) {
				hideFieldList = new ArrayList();
			}
			hideFieldList.add(pFieldName);
			pAutoSet.addOneField(pFieldName, pFieldName, pTitle, pFieldName,
					"", dataType, attrLength, 0, false,
					DBFormElementFactory.DBEDIT, "", "", false, nullable, null,
					defaultValue, displayText, "", pFieldWidth, pFieldHeight);
		}
		// checkbox多选框类型
		else if (BceUtil.ATTR_EDIT_TYPE_CHECKBOX.equals(pEditType)) {

			pAutoSet.addOneField(pFieldName, pFieldName, pTitle, pFieldName,
					"", dataType, 20, 0, editable,
					DBFormElementFactory.DBCHECKBOX, BceUtil.STR_YES,
					BceUtil.STR_NO, false, nullable, null, defaultValue,
					displayText, "", pFieldWidth, pFieldHeight);

		} else if (BceUtil.ATTR_EDIT_TYPE_TEXT_AREA.equals(pEditType)) {

			pAutoSet.addOneField(pFieldName, pFieldName, pTitle, pFieldName,
					"", dataType, attrLength, 0, editable,
					DBFormElementFactory.DBTEXTAREA, "", "", false, nullable,
					null, defaultValue, displayText, "", pFieldWidth,
					pFieldHeight);

		} else if (BceUtil.ATTR_EDIT_TYPE_DATETIME.equals(pEditType)) {

			pAutoSet.addOneField(pFieldName, pFieldName, pTitle, pFieldName,
					"", dataType, attrLength, 0, editable,
					DBFormElementFactory.DBDATETIME, "", "", false, nullable,
					null, defaultValue, displayText, "", pFieldWidth,
					pFieldHeight);

		} else if (BceUtil.ATTR_EDIT_TYPE_DATE.equals(pEditType)) {

			pAutoSet.addOneField(pFieldName, pFieldName, pTitle, pFieldName,
					"", dataType, attrLength, 0, editable,
					DBFormElementFactory.DBDATE, "", "", false, nullable, null,
					defaultValue, displayText, "", pFieldWidth, pFieldHeight);

		} else if (BceUtil.ATTR_EDIT_TYPE_UPLOADFILE.equals(pEditType)) {
			// 设置文件上传类型
			pAutoSet.addOneField(pFieldName, pFieldName, pTitle, pFieldName,
					"", dataType, attrLength, 0, editable,
					DBFormElementFactory.DBFILE, "", "", false, nullable, null,
					defaultValue, displayText,
					pBaseAttrValue.getResSrc() == null ? "com.ai.bce.ftpCode"
							: pBaseAttrValue.getResSrc(), pFieldWidth,
					pFieldHeight);

		} else if (BceUtil.ATTR_EDIT_TYPE_EDITABLELIST.equals(pEditType)) {

			throw new Exception("----------------------------------------");

		}// DBHtml
		else if (BceUtil.ATTR_EDIT_TYPE_DBHtml.equals(pEditType)
				|| DBFormElementFactory.DBHtml.equals(pEditType)) {
				pAutoSet.addOneField(pFieldName, pFieldName, pTitle, pFieldName,
				"", dataType, attrLength, 0, editable,
				DBFormElementFactory.DBHtml, "", "", false, nullable,
				null, defaultValue, displayText, "", pFieldWidth,
				pFieldHeight);
				}
		
		else {
			// "不支持的编辑方式.editType=" + pEditType
			throw new BceException("BES0000406", new String[] { pEditType });
		}
		return hideFieldList;
	}
}
