package com.ai.bce.web;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.complex.cache.CacheFactory;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.ai.bce.auto.plugin.cache.BceServiceCache;
import com.ai.bce.auto.plugin.version.hand.service.interfaces.IHandLogServiceSV;
import com.ai.bce.service.interfaces.IBceStudioSV;
import com.ai.bce.util.BceServiceFactory;
import com.ai.bce.util.LocaleResourceFactory;
import com.ai.bce.util.ReflectUtils;

public class BceStudioAction extends BaseAction{
	private static transient Log log = LogFactory.getLog(BceStudioAction.class);

	public void commonSaveRowset(HttpServletRequest request,HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		try{
			DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request.getInputStream(),null);
			if(dcLists != null && dcLists.length == 1){
				DataContainerInterface[] dcis = dcLists[0].getColDataContainerInterface(0);
			  BceServiceFactory.getBceStudioSV().commonSaveRowset(dcis);
			}
			else if(dcLists != null && dcLists.length > 1){
				List list = new ArrayList();
				for(int i=0;i<dcLists.length;i++){
					DataContainerInterface[] dcis = dcLists[i].getColDataContainerInterface(0);
					for(int j=0;j<dcis.length;j++){
						if(dcis[j] != null)
							list.add(dcis[j]);
					}
				}
				if(list.size() > 0){
					BceServiceFactory.getBceStudioSV().commonSaveRowset((DataContainerInterface[])list.toArray(new DataContainerInterface[0]));
				}
			}
			
			HttpUtil.showInfo(response,cp);
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			HttpUtil.showError(response, ex.getMessage());
		}
		
	}
	

	/**
	 * Qinjin Peng增加为生成脚本支持
	 * 
	 * @Title:
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param
	 * @param request
	 * @param
	 * @param response
	 * @param
	 * @throws Exception
	 *             设定文件
	 * @return 返回类型
	 * @throws
	 */
	public void getExportSQL(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IHandLogServiceSV handLogServiceSV = (IHandLogServiceSV) ServiceFactory
				.getService(IHandLogServiceSV.class);
		long ordId = HttpUtil.getAsLong(request, "ORD_ID");
		int option = HttpUtil.getAsInt(request, "exportOption");
		CustomProperty cp = CustomProperty.getInstance();
		String sql = handLogServiceSV.exportSQlByOrdId(ordId,
				1 == option ? true : false);
		cp.set("sql", sql);
		cp.set("flag", "Y");
		HttpUtil.showInfo(response, cp);
	}

	/**
	 * 
	 * @Title:
	 * @Description: Qinjin Peng增加为下载文件设置
	 * @param
	 * @param request
	 * @param
	 * @param response
	 * @param
	 * @throws Exception
	 *             设定文件
	 * @return 返回类型
	 * @throws
	 */
	public void DownLoadExportSQL(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
			IHandLogServiceSV handLogServiceSV = (IHandLogServiceSV) ServiceFactory
					.getService(IHandLogServiceSV.class);
			long ordId = HttpUtil.getAsLong(request, "ORD_ID");
			int option = HttpUtil.getAsInt(request, "exportOption");
			String sql = handLogServiceSV.exportSQlByOrdId(ordId,
					1 == option ? true : false);
			//InputStream fis = new StringBufferInputStream(s);
		/*	byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();*/
			// 清空response
			response.reset();
//			response.setCharacterEncoding("GBK");
			// 设置response的Header
			response.addHeader("Content-Disposition", "filename=\"SQL"
					+ ReflectUtils.getFormatDate(new Date(),
							ReflectUtils.FORMATE_YYYYMMDDHHMMSS) + ".sql\"");
			response.addHeader(" Content-Length ", "" + sql.length());
			OutputStream toClient = new BufferedOutputStream(response
					.getOutputStream());
			response.setContentType(" application/octet-stream ");
			toClient.write(sql.getBytes());
			toClient.flush();
			toClient.close();
		
	}
	/**
	 * 获取CacheList 列表
	* @Title: getCacheList 
	* @Description: TODO  
	* @param @param request
	* @param @param response
	* @param @throws Exception    
	* @return void     
	* @throws
	 */
	public void getCacheList(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String isBce = HttpUtil.getAsString(request, "isBce");
		String listCahce = "";
		
		if("1".equals(isBce)){
			HashMap map = CacheFactory.getAll(BceServiceCache.class);
			Set key  = ((Map)map.get("BCE_SERVICE_CACHE")).keySet();
			for (Iterator iterator = key.iterator(); iterator.hasNext();) {
				String clazz = (String) iterator.next();
				listCahce= listCahce+","+clazz;
			}
		}else{
			 HashMap map = CacheFactory._getCacheInstances();
			  Set keys = map.keySet();
			  for (java.util.Iterator iter = keys.iterator(); iter.hasNext(); ) {
			    Class item = (Class) iter.next();
			    listCahce=listCahce+","+item.getName();
			  }
		}
		CustomProperty cp = CustomProperty.getInstance();
		cp.set("listCache", listCahce);
		cp.set("flag", "Y");
		HttpUtil.showInfo(response, cp);
	}
	/**
	 * 获取CacheList 列表
	* @Title: getCacheList 
	* @Description: TODO  
	* @param @param request
	* @param @param response
	* @param @throws Exception    
	* @return void     
	* @throws
	 */
	public void getCacheData(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String isBce = HttpUtil.getAsString(request, "isBce");
		String isEjb = HttpUtil.getAsString(request, "isEjb");
		String key  = HttpUtil.getAsString(request, "cacheKey");
		String Key_Value= HttpUtil.getAsString(request, "Key_Value");
		if (log.isDebugEnabled()) {
			log.debug("select For :ISBCE:"+isBce+";ISEjB:"+isEjb+";key:"+key+";Key_Value:"+Key_Value);
		}
		CustomProperty cp = CustomProperty.getInstance();
		cp.set("flag", "Y");
		IBceStudioSV bceStudioSV  = (IBceStudioSV) ServiceFactory.getService(IBceStudioSV.class);
		if("1".equals(isBce)){
			if(StringUtils.isNotBlank(key)&&StringUtils.isNotBlank(Key_Value)){
				Map cmmaps ;
				if("0".equals(isEjb))
				 cmmaps = 
					(Map) CacheFactory.get(BceServiceCache.class,
				"BCE_SERVICE_CACHE");
				else
					cmmaps = bceStudioSV.getCacheMap("BCE_SERVICE_CACHE",BceServiceCache.class.getName());
				Map cmcmp = (Map) cmmaps.get(key);
				Map li =(Map) cmcmp.get(key);
				int i = 0;
				List values = (List) li.get(String.valueOf(Key_Value));
				if(values!=null){
				for (Iterator iterator = values.iterator(); iterator.hasNext();) {
					Object object = (Object) iterator.next();
					if (DataContainer.class.isInstance(object)) {
						cp.set("data"+i,object.toString());
					}
					i++;
				}
				}
			}
		}else{
			if(StringUtils.isNotBlank(key)&&StringUtils.isNotBlank(Key_Value)){
				Class clazz = ReflectUtils.forName(key);
				Object object ;
				if("0".equals(isEjb))
					object =  CacheFactory.get(clazz,Key_Value);
				else
					object  = bceStudioSV.getCacheMap( Key_Value,key);
				cp.set("data0",object==null?"":object.toString());
			}
		}
		HttpUtil.showInfo(response, cp);
	}
}
