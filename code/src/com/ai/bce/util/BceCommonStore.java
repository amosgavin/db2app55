/**   
 * @Title: BceThreadLoal.java 
 * @Package com.ai.bce.util 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Qinjin Peng (Pengqj@asiainfo-linkage.com)   
 * @date 2011-4-14 下午09:20:25 
 * @version V1.0   
 */
package com.ai.bce.util;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.AIThreadLocal;
import com.ai.appframe2.common.SessionManager;
import com.ai.bce.util.bean.BceConfigItemBean;

/**
 * Bce 存储中心
 * 
 * @ClassName: BceCommonStore
 * @author Qinjin Peng
 * @date 2011-4-14 下午09:20:25
 * 
 */

public class BceCommonStore {

	public static transient final Log log = LogFactory
			.getLog(BceCommonStore.class);
	private static ThreadLocal local = new AIThreadLocal();
	private ConcurrentHashMap keyHash = new ConcurrentHashMap();
	private static BceCommonStore bceStore = new BceCommonStore();
	public static final String CROSS_SERVICE = "IS_CROSS_SERVICE";
	public static final String STORE_TYPE_USE_TIME_OUT = "USE_TIME";
	public static final String STORE_TYPE_USE_DATA_CHANGE = "STORE_TYPE_USE_DATA_CHANGE";

	private static ThreadLocal tk_for_bak = new AIThreadLocal();

	/**
	 * 获取信息为流程备份数据 ####次流程的节点信息请自行控制其值得判断是否是您需要的值，如果不是请自行清除处理数据
	 * 
	 * @return
	 */
	public static Object getBakForOM() {
		return tk_for_bak.get();
	}

	/**
	 * 设置流程备份信息数据 ####此处设置方式请自行清理，谢谢
	 * 
	 * @param value
	 */
	public static void setBakForOM(Object value) {
		tk_for_bak.set(value);
	}

	/**
	 * 清空相关流程备份信息数据 ####此处设置方式请自行清理，谢谢
	 * 
	 * @param value
	 */
	public static void clearBakForOM() {
		tk_for_bak.set(null);
	}

	/**
	 * <p>
	 * Title:构造函数
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	private BceCommonStore() {
	}

	/**
	 * 获取数据中心实例
	 * 
	 * @Title: _getInstance
	 * @Description: TODO
	 * @param @return
	 * @return BceStore
	 * @throws
	 */
	public static BceCommonStore _getInstance() {
		return bceStore;
	}

	private ConcurrentHashMap getKeyHash() {
		return keyHash;
	}

	/**
	 * 从BCE对象池中获取对象数据
	 * 
	 * @Title: getObjectFromStoreByKey
	 * @Description: TODO
	 * @param @param key
	 * @param @return
	 * @return Object
	 * @throws
	 */
	public static Object getObjectFromStoreByKey(String key) {
		Object object = _getInstance().getKeyHash().get(key);
		if (object == null) {
			if (log.isWarnEnabled()) {
				log.warn(LocaleResourceFactory.getResource("BES0000840",
						new String[] { key }));
			}
		}
		if (!StoreObject.class.isInstance(object)) {
			if (log.isWarnEnabled()) {
				log.warn(LocaleResourceFactory.getResource("BES0000841",
						new String[] { key }));
			}
			return null;
		}
		StoreObject storeObject = (StoreObject) object;
		return storeObject.getValue();
	}

	/**
	 * 设置数据至Bce中心
	 * 
	 * @Title: putObjectToStore
	 * @Description: TODO
	 * @param @param key
	 * @param @param value
	 * @return void
	 * @throws
	 */
	public static void putObjectToStore(String key, Object value) {
		if (log.isDebugEnabled()) {
			log.debug(LocaleResourceFactory.getResource("BES0000842",
					new Object[] { key }));
		}
		StoreObject storeObject = new StoreObject();
		storeObject.setKey(key);
		storeObject.setDate(new Date());
		storeObject.setValue(value);
		_getInstance().getKeyHash().put(key, storeObject);
	}

	/**
	 * 设置数据至ThreadLocal中数据
	 * 
	 * @Title: setThreadLocal
	 * @Description: TODO
	 * @param @param map
	 * @return void
	 * @throws
	 */
	private static void setThreadLocal(HashMap map) {
		local.set(map);
	}

	/**
	 * 从threadLocal 中获取ThreadLocal
	 * 
	 * @Title: getThreadLocal
	 * @Description: TODO
	 * @param @return
	 * @return HashMap
	 * @throws
	 */
	private static HashMap getThreadLocal() {
		return (HashMap) local.get();
	}

	/**
	 * 本方法设置对象在本线程中使用
	 * 
	 * @deprecated 此类不允许使用
	 * @Title: putSomeThingToThread
	 * @Description: TODO
	 * @param @param key
	 * @param @param value
	 * @return void
	 * @throws
	 * 
	 */
	public static void putSomeThingToThread(String key, Object value) {
		HashMap map = getThreadLocal() == null ? new HashMap()
				: getThreadLocal();
		map.put(key, value);
		setThreadLocal(map);
	}

	/**
	 * 清除线程信息数据
	 */
	public static void clearThread() {
		Map map = getThreadLocal();
		if (map != null)
			map.clear();
		setThreadLocal(null);
	}

	/**
	 * 设置数据至当前线程信息中
	 * 
	 * @Title: getSomeThingFromThread
	 * @Description: TODO
	 * @param @param key
	 * @param @return
	 * @return Object
	 * @throws
	 */
	public static Object getSomeThingFromThread(String key) {
		HashMap map = getThreadLocal();
		if (map == null) {
			if (log.isWarnEnabled()) {
				log.warn(LocaleResourceFactory.getResource("BES0000839",
						new String[] { key }));
			}
			return null;
		}
		return map.get(key);
	}

	/**
	 * 从Key中删除数据
	 * 
	 * @Title: removeObjectFromStore
	 * @Description: TODO
	 * @param @param valueOf
	 * @return void
	 * @throws
	 */
	public static void removeObjectFromStore(String key) {
		_getInstance().getKeyHash().remove(key);
	}

	/**
	 * 清除无用的数据
	 * 
	 * @throws Exception
	 */
	public static void removeAllNotUseCache() throws Exception {
		for (Iterator iterator = _getInstance().keyHash.keySet().iterator(); iterator
				.hasNext();) {
			Object key = (Object) iterator.next();
			StoreObject object = (StoreObject) _getInstance().keyHash.get(key);
			if (object == null)
				continue;
			Date date = object.getDate();
			Date now = new Date();
			Map map = (Map) BceConfigServer
					.getRegisterConfig(BceConfigServer.KEY_ROOT);
			Map itemMap = (Map) map.get("BCE_CONF_ITEM");
			BceConfigItemBean item = (BceConfigItemBean) itemMap
					.get("BCE_STORE_TYPE" + "BCE_STORE_TIMEOUT");
			if (item == null) {
				if (log.isErrorEnabled()) {
					log.error(LocaleResourceFactory.getResource("BES0000852"));
				}
				return;
			}
			long time = Long.valueOf(item.getItemValue()).longValue();

			if (now.getTime() - date.getTime() > time) {
				_getInstance().keyHash.remove(key);
			}
		}
	}

	/**
	 * 从Session 中获取数据信息 通过Key
	 * 
	 * @param key
	 * @return
	 * @throws BceException
	 */
	public static Object getObjectFromSessionByKey(String key)
			throws BceException {
		HttpSession session = SessionManager.getRequest().getSession();
		return session.getAttribute(key);
	}

	/**
	 * 将Object对像数据设置至Session
	 * 
	 * @param key
	 * @param object
	 * @throws BceException
	 */
	public static void putObjectToSession(String key, Object object)
			throws BceException {
		HttpSession session = SessionManager.getRequest().getSession();
		session.setAttribute(key, object);
	}

	/**
	 * 将Object对像数据设置至Session
	 * 
	 * @param key
	 * @param object
	 * @throws BceException
	 */
	public static void clearSessionByKey(String key) throws BceException {
		if (log.isDebugEnabled()) {
			log.debug(LocaleResourceFactory.getResource("BES0000856") + key);
		}
		HttpSession session = SessionManager.getRequest().getSession();
		session.setAttribute(key, null);
		if (log.isDebugEnabled()) {
			log.debug(LocaleResourceFactory.getResource("BES0000857") + key);
		}
	}

	public static void main(String[] args) throws Exception {
		Map map = (Map) BceConfigServer
				.getRegisterConfig(BceConfigServer.KEY_ROOT);
		System.out.println(map);
		Map itemMap = (Map) map.get("BCE_CONF_ITEM");
		System.out.println(itemMap);
		System.out.println(itemMap.get("BCE_STORE_TYPE" + "BCE_STORE_TIMEOUT"));
	}
}

class StoreObject implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * KEY
	 */
	private String key;
	/**
	 * 数据对象
	 */
	private Object value;
	/**
	 * 创建时间
	 */
	private Date date = new Date();

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	/*
	 * (非 Javadoc) <p>Title: toString</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return LocaleResourceFactory.getResource("BES0000843", new Object[] {
				key, date, value == null ? "" : value.getClass().getName() });
	}

}
