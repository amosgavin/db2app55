/***********************************************************************
 * Module:       SetCacheAction.java
 * Description:  
 * Company:      Asiainfo
 * Author:       LinHailu
 * Date:         Dec 13, 2010
 ***********************************************************************/

package com.ai.bce.web;

import java.util.Map;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DBGFInterface;
import com.ai.appframe2.common.DBGridDataModelInterface;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.ai.bce.util.LocaleResourceFactory;


public class SetCacheAction extends BaseAction implements DBGridDataModelInterface{

	private static transient Log log = LogFactory.getLog(SetCacheAction.class);
			
	private static final String SET_KEY = "SET";
	public int count() throws Exception {
		return SessionManager.getCacheManager().getMap(SET_KEY).size();
	}

	public Object getGridData(int startRowIndex, int endRowIndex) throws Exception {
		Map setMap = SessionManager.getCacheManager().getMap(SET_KEY);
		Set keySet = setMap.keySet();
		DataContainerInterface[] dcs = new DataContainerInterface[keySet.size()];
		String[] keys = (String[])keySet.toArray(new String[0]);
		for(int i=0;i<keys.length;i++){
			dcs[i] = new DataContainer();
			dcs[i].set("ATTR_NAME",keys[i]);
		}
		return dcs;
	}

	public void init(ServletRequest request, DBGFInterface pInterface) throws Exception {
	}

	public void refreshSet(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			String sets = HttpUtil.getAsString(request,"SETS");
			if(StringUtils.isBlank(sets)){
				SessionManager.getCacheManager().remove(SET_KEY);
			}
			else{
				String[] setNames = StringUtils.split(sets,",");
				for(int i=0;i<setNames.length;i++){
					if(StringUtils.isNotBlank(setNames[i]))
					  SessionManager.getCacheManager().remove(SET_KEY, setNames[i]);
				}
			}
			HttpUtil.showInfo(response, LocaleResourceFactory.getResource("BES0000411"));
		}
		catch(Exception e){
			log.error(e.getMessage(),e);
			HttpUtil.showError(response,e.getMessage());
		}
	}
}
