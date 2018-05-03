package com.ai.bce.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.complex.cache.CacheFactory;
import com.ai.appframe2.web.HttpUtil;
import com.ai.bce.util.bean.BceConfigItemBean;
import com.asiainfo.crm.common.cache.BsParaDetailCacheImpl;
import com.asiainfo.crm.common.ivalues.IBOBsParaDetailValue;

public class BceUtil {
	public static transient final Log log = LogFactory.getLog(BceUtil.class);
	public static int STATE_NOMAL = 1;

	public static final String BCE_COSTOMER_ORDER_CACHE_KEY = "BCE_COSTOMER_ORDER_CACHE_KEY";
	public static final String BCE_COSTOMER_TRANSATION_RADOM = "BCE_COSTOMER_TRANSATION_RADOM";
	public static final long OPTION_TYPE_MUST_SELECT = 0;
	public static final long OPTION_TYPE_CAN_EDIT_DEFAULT_SELECT = 1;
	public static final long OPTION_TYPE_CAN_EDIT_NOT_SELECT = 2;
	public static final String BUSIOPER_ID_KEY = "BUSIOPER_ID";

	// 属性是否可见
	public static final int ATTR_VISIBLE_TRUE = 1;
	public static final int ATTR_VISIBLE_FALSE = 0;

	public static final String BUSIOPER_NAME_KEY = "BUSIOPER_NAME";

	public static final String BCE_FRAME_ID_KEY = "BCE_FRAME_ID";

	public static final String PAGE_FRAME_PAGE_ID_KEY = "PAGE_FRAME_PAGE_ID";

	public static final String RET_DC_MSG_NAME = "MSG";
	public static final String JAVA_RULE_RETURN_KEY = "JAVA_RULE_RETURN_KEY";
	public static final int JAVA_RULE_RETURN_CODE_YES = 1;// 允许
	public static final int JAVA_RULE_RETURN_CODE_WARNNING = 2;// 允许，但有警告
	public static final int JAVA_RULE_RETURN_CODE_NO = 3;// 不允许

	public static final int RULE_VERIFY_TYPE_WARNING = 1; // 警告
	public static final int RULE_VERIFY_TYPE_REJECT = 2; // 拒绝

	public static final int RULE_CHECK_TYPE_ALL = 1; // 必须全部通过
	public static final int RULE_CHECK_TYPE_PART = 2; // 允许部分通过

	public static final int BE_DEAL_TYPE_SERVICE = 1;
	public static final int BE_DEAL_TYPE_WORKFLOW = 2;

	public static final int RULE_TYPE_JS = 1;
	public static final int RULE_TYPE_JAVA = 2;

	// JAVA_RULE_SET_TYPE
	public static final int JAVA_RULE_SET_TYPE_NORMAL = 1;// 是否可执行此类业务
	public static final int JAVA_RULE_SET_TYPE_ORDER_SUBMIT = 10;// 提交类规则
	public static final int RULE_SET_TYPE_FRAME_JS = 99; // 框架前台校验规则
	public static final int JAVA_RULE_SET_FRAME_BATCH_CAN = 7; // 批量规则

	public static final String STR_NO = "N";// 否
	public static final String STR_NO_DESC = LocaleResourceFactory
			.getResource("BES0000002");// 否
	public static final String STR_YES = "Y";// 是
	public static final String STR_YES_DESC = LocaleResourceFactory
			.getResource("BES0000001");// 是
	public static final String STR_WARNNING = "W";// 警告

	public static final String ATTR_EDIT_TYPE_LABEL = "1";// 显示标签
	public static final String ATTR_EDIT_TYPE_EDIT = "2";// 单行编辑框
	public static final String ATTR_EDIT_TYPE_LIST = "3";// 下拉列表框
	public static final String ATTR_EDIT_TYPE_CHECKBOX = "4";// 多选框
	public static final String ATTR_EDIT_TYPE_RADIO = "5";// 单选框
	public static final String ATTR_EDIT_TYPE_DATETIME = "6";// 日期，时分秒
	public static final String ATTR_EDIT_TYPE_UPLOADFILE = "7"; // 文件（此时参数要记一下上传路径）
	public static final String ATTR_EDIT_TYPE_TABLE = "8";// 多维表单(包涵一维(多项))
	public static final String ATTR_EDIT_TYPE_RESOURCELIST = "9";// 资源选号List
	public static final String ATTR_EDIT_TYPE_HIDE = "10";// 隐藏
	public static final String ATTR_EDIT_TYPE_CLASS_VALUE = "11";// 调用类和方法从后台获取值的编辑方式。类getInterfaceValue,方法getInterfaceParam
	public static final String ATTR_EDIT_TYPE_HIDE_CLASS_VALUE = "12";// 隐藏，但从后台获取值的编辑方式。
	public static final String ATTR_EDIT_TYPE_OPEN_WIN = "13";// 对话框输入编辑方式。对话框url在getInterfaceValue，对话框显示参数getInterfaceParam
	public static final String ATTR_EDIT_TYPE_TEXT_AREA = "14";// TextArea
	public static final String ATTR_EDIT_TYPE_PASSWORD = "15";// 密码框
	public static final String ATTR_EDIT_TYPE_DATE = "16";// 日期
	public static final String ATTR_EDIT_TYPE_EDITABLELIST = "32";// 可编辑的下拉列表框
	public static final String ATTR_EDIT_TYPE_DBHtml = "17";//DBHtml 
	
	public static final String HIDE_FIELD_LIST = "hideFieldList";
	public static final String AREA_ID = "AREA_ID";

	public static final String ATTR_DEFAULT_SYSDATE = "$sysdate";
	public static final String ATTR_DEFAULT_SYSDATETIME = "$sysdatetime";
	// 自动生成属性的返回结果码
	// id
	public static final String AUTO_CREATE_ATTR_RETURN_ID_KEY = "AUTO_CREATE_ATTR_RETURN_ID_KEY";
	// 显示属性
	public static final String AUTO_CREATE_ATTR_RETURN_DISP_TEXT_KEY = "AUTO_CREATE_ATTR_RETURN_DISP_TEXT_KEY";
	// 批量属性
	public static final int ATTR_MULTI_FLAG_TRUE = 1;
	public static final int ATTR_MULTI_FLAG_FALSE = 0;

	public static Map getMap(HttpServletRequest request) throws Exception {
		Map paramMap = new HashMap();
		Enumeration aEnum = request.getParameterNames();
		while (aEnum.hasMoreElements()) {
			String key = (String) aEnum.nextElement();
			Object value = (Object) HttpUtil.getObject(request, key);
			paramMap.put(key, value);
		}
		aEnum = request.getAttributeNames();
		while (aEnum.hasMoreElements()) {
			String key = (String) aEnum.nextElement();
			Object value = (Object) HttpUtil.getObject(request, key);
			paramMap.put(key, value);
		}
		return paramMap;
	}

	public static String getFirstExceptionMsg(Exception e) {
		int aLength = 200;
		String retValue = "";
		String aMsg = ExceptionUtils.getFullStackTrace(ExceptionUtils
				.getRootCause(new Exception(e)));
		int aFirstLineEnd = StringUtils.indexOf(aMsg, ":");
		aMsg = StringUtils.left(aMsg, aFirstLineEnd);
		if (StringUtils.isNotBlank(aMsg)) {
			if (aMsg.length() > aLength) {
				retValue = StringUtils.left(aMsg, aLength) + "......";
			} else {
				retValue = aMsg;
			}
		}
		retValue = StringUtils.replace(retValue, "\r", "");
		retValue = StringUtils.replace(retValue, "\n", " ");
		return retValue;
	}

	public static Object transfer(Object value, String type) {
		Class tmpClass = getNumberClass(type);
		if (tmpClass != null && value instanceof Number) {
			return transfer((Number) value, tmpClass);
		}
		return value;
	}

	public static Object transfer(Number value, Class type) {
		int type1 = getSeq(value.getClass());
		int type2 = getSeq(type);
		if (type1 == type2) {
			return value;
		}
		if (type1 < type2) {
			if (type2 == 1)
				return new Byte(value.byteValue());
			if (type2 == 2)
				return new Short(value.shortValue());
			if (type2 == 3)
				return new Integer(value.intValue());
			if (type2 == 4)
				return new Long(value.longValue());
			if (type2 == 5)
				return new Float(value.floatValue());
			if (type2 == 6)
				return new Double(value.doubleValue());
		}
		throw new RuntimeException(value.getClass().getName()
				+ " cannot transfer to " + type.getName());
	}

	public static int getSeq(Class aClass) {
		if (aClass == Byte.class || aClass == byte.class)
			return 1;
		if (aClass == Short.class || aClass == byte.class)
			return 2;
		if (aClass == Integer.class || aClass == int.class)
			return 3;
		if (aClass == Long.class || aClass == long.class)
			return 4;
		if (aClass == Float.class || aClass == float.class)
			return 5;
		if (aClass == Double.class || aClass == double.class)
			return 6;
		return -1;
	}

	public static Class getNumberClass(String type) {
		if (type.equals("short") || type.equals("Short"))
			return Short.class;
		if (type.equals("int") || type.equals("Integer"))
			return Integer.class;
		if (type.equals("long") || type.equals("Long"))
			return Long.class;
		if (type.equals("double") || type.equals("Double"))
			return Double.class;
		if (type.equals("float") || type.equals("Float"))
			return Float.class;
		if (type.equals("byte") || type.equals("Byte"))
			return Byte.class;
		return null;
	}

	/**
	 * 本方法提供给业务使用规则表达式进行获取数据的通用方法
	 * 
	 * 
	 * @Title: evalExpr
	 * @Description: TODO
	 * @param @param expr 规则表达式内容,如需传输ClassName：Method 则传${ClassName:Method}$
	 * @param @param map 参数内容Map数据
	 * @param @return
	 * @param @throws Exception
	 * @return Object 返回执行的结果
	 * @throws
	 */
	public static Object evalExpr(String expr, Map map) throws Exception {
		Object object = null;
		try {
			if (expr.startsWith("${") && expr.endsWith("}$")) {
				String[] cm = StringUtils.split(expr, "${}:");
				if (cm.length != 2) {
					BceException.throwException("BES0000844",
							new Object[] { expr });
				}
				if (log.isDebugEnabled()) {
					// log.debug(LocaleResourceFactory.getResource(""));
				}
				object = ReflectUtils.methodInvoke(cm[0], cm[1],
						new Class[] { Map.class }, new Object[] { map }, null);
			} else {
				object = ReflectUtils.evaluateExpr(expr, map);
			}

		} catch (Exception e) {
			// TODO: handle exception
			log.error("Evel:" + expr, e);
			throw e;
		}
		return object;
	}

	public static Timestamp getTimestampByDate(Date date) {
		return new Timestamp(date.getTime());
	}

	/*
	 * public static void main(String[] args) throws Exception { Map map = new
	 * HashMap(); // Map key = new HashMap();
	 * 
	 * map.put("tg", 1L); map.put("tf", "wwe"); map.put("kk", "q1311"); //
	 * System
	 * .out.println(evalExpr("tg.get(\"key\")!=null?tg.get(\"key\"):\"000\""
	 * ,map)); // System.out.println(evalExpr("[ 1, 2, \"three\" ]", map)); //
	 * System.out.println(evalExpr("\"Hello\"", map)); //
	 * System.out.println(ReflectUtils.evaluateExpr("{ab=\"ab\";tg.key+ab}", //
	 * map)); System.out .println(ReflectUtils .evaluateExpr(
	 * "{if((tg=='1' and tf =='wwe') or kk =='qwe' ){true;}else {false;}}",
	 * map));
	 * 
	 * }
	 */

	/**
	 * 获取静态参数数据
	 * 
	 * @param regionId
	 * @param paraType
	 * @param paraCode
	 * @return
	 * @throws Exception
	 */
	public static IBOBsParaDetailValue getParaDetailValue(String regionId,
			String paraType, String paraCode) throws Exception {
		IBOBsParaDetailValue retValue = null;
		if (StringUtils.isNotBlank(regionId)
				&& StringUtils.isNotBlank(paraType)
				&& StringUtils.isNotBlank(paraCode)) {
			String cacheKey = regionId + "_" + paraCode + "_" + paraType;
			retValue = (IBOBsParaDetailValue) CacheFactory.get(
					BsParaDetailCacheImpl.class, cacheKey);
		}
		return retValue;
	}

	/**
	 * 生成32位唯一Key
	 * 
	 * @return
	 */
	public static String getUniKey() {
		UUID uuid = UUID.randomUUID();
		String s_uuid = uuid.toString();
		s_uuid = StringUtils.replace(s_uuid, "-", "");
		return s_uuid;
	}

	/**
	 * 创建 文件 按照 文件名,文件
	 * 
	 * @param fileName
	 *            文件路径（全路径）
	 * @param fileContent
	 *            文件内容
	 * @param fileType
	 *            文件类型
	 * @return
	 * @throws BceException
	 */
	public static boolean writeFile(String fileName, String fileContent,
			String fileType) throws BceException {
		try {
			BufferedWriter rw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(fileName)));
			rw.write(fileContent);
			rw.close();
			return true;
		} catch (Exception e) {
			log.error("Create File Error", e);
			BceException.throwException("Create File Error ", new String[] {},
					e);
			return false;
		}

	}

	public static String encodeUrlQueryString(HttpServletRequest request)
			throws UnsupportedEncodingException {
		String urlString = request.getQueryString();
		String result = new String(
				((String) urlString).getBytes(HttpUtil.CHARSET_ISO8859),
				HttpUtil.getEncoding());
		return result;
	}

	public static HashMap generationMap(String equalStr) throws BceException {
		HashMap hashMap = new HashMap();
		String[] params = StringUtils.split(equalStr, "&@~\r\n");
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				String keyValue = params[i];
				String[] kvs = StringUtils.split(keyValue, "=");
				if (kvs.length != 2) {
					throw new BceException("BES0000413",
							"key1=value1&key2=value2");
				}
				hashMap.put(kvs[0], kvs[1]);
			}
		}
		return hashMap;
	}

	/**
	 * 判断当前项目是否是开发模式
	 * 
	 * @return
	 * @throws Exception
	 */
	public static boolean getIsDebug() throws Exception {
		Map map = (Map) BceConfigServer
				.getRegisterConfig(BceConfigServer.KEY_ROOT);
		Map itemMap = (Map) map.get("BCE_CONF_ITEM");
		BceConfigItemBean item = (BceConfigItemBean) itemMap
				.get("BCE_STATIC_DEBUG" + "BCE_STATIC_DEBUG");
		return item == null ? false : Boolean.valueOf(item.getItemValue()
				.trim());
	}

	public static void main(String[] args) throws Exception {
		System.out.println(BceUtil.getIsDebug());
	}

}
