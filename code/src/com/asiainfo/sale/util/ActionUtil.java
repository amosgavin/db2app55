package com.asiainfo.sale.util;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.web.HttpUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * User: robai Date: 2009-4-28 Time: 13:33:57
 */
public class ActionUtil {
	private transient static Log log = LogFactory.getLog(ActionUtil.class);

	/**
	 * 根据主键生成IValue数组
	 * 
	 * @param request
	 * @param c
	 * @param objtype
	 * @return
	 * @throws Exception
	 */
	public static List getIValuesFromParamKey(HttpServletRequest request,
			Class c, ObjectType objtype) throws Exception {

		DataContainer data = (DataContainer) c.newInstance();
		String[] keyName = data.getKeyPropertyNames();
		DataContainer param = getParamsFromRequest(request);
		if (null != keyName && keyName.length > 0 && null != param
				&& null != param.getAsString(keyName[0])) {
			String keyss = param.getAsString(keyName[0]);
			String[] keys = keyss.split("\\,");
			List li = new ArrayList();
			HashMap hm = param.getProperties();
			String[] parkeys = (String[]) hm.keySet().toArray(
					new String[hm.size()]);
			for (int i = 0; i < keys.length; i++) {
				DataContainerInterface keyvalue = SessionManager
						.getObjectTypeFactory().createDCInstance(c, objtype);
				keyvalue.set(keyName[0], new Long(keys[i]));
				for (int k = 0; k < parkeys.length; k++) {
					if (!parkeys[k].equals(keyName[0])) {
						if (null != objtype.getProperty(parkeys[k])) {
							String type = objtype.getProperty(parkeys[k])
									.getDatabaseDataType();
							if ("NUMBER".equals(type)) {
								keyvalue.set(parkeys[k], new Long(hm.get(
										parkeys[k]).toString()));
							} else {
								keyvalue.set(parkeys[k], hm.get(parkeys[k])
										.toString());
							}
						}
					}
				}
				li.add(keyvalue);
			}
			return li;
		}
		return null;
	}

    /**
     * *********************************
     *
     * @param request
     * @return DataContainer
     * @desc 从request中获取URL传来的参数，加入到DataContainer
     */
    public static DataContainer getParamsFromRequest(HttpServletRequest request) throws Exception {
        try {
            Enumeration es = request.getParameterNames();
            DataContainer data = new DataContainer();
            String[] s = {"ACTION", "URL_SOURCE", "PK", "NULL", "CONDITION", "AILOGSTRING"};
            while (es.hasMoreElements()) {
                String paramName = (String) es.nextElement();
                if (StringUtil.isNotInStringArray(s, paramName))
                    data.set(paramName, HttpUtil.getAsString(request, paramName));
            }
            return data;
        } catch (Exception e) {
            log.error("获取页面HttpServletRequest中的参数错误:", e);
        }
        return null;
    }
	
}
