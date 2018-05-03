package com.ai.bce.configtool.model.clazz;

import java.lang.reflect.Method;
import java.util.List;

import com.ai.bce.configtool.model.clazz.ParameterModel;

/**
 * 
 * @author linzhaoming
 * 2010-12-28
 *
 */
public class ClazzHelper {
	/**
	 * 获取参数描述
	 * @param list
	 * @return
	 */
	public static String getParameterStr(List list){
		StringBuffer sb = new StringBuffer();
		sb.append("(");
		for(int i=0; i<list.size(); i++){
			ParameterModel model = (ParameterModel)list.get(i);
			String pName = model.getClazz().getSimpleName();
			if(i!=0){
				sb.append(", ").append(pName).append(" arg" + i);
			}else{
				sb.append(pName).append(" arg" + i);;
			}
		}
		sb.append(")");
		return sb.toString();
	}
	
	/**
	 * 获取异常描述
	 * @param method
	 * @return
	 */
	public static String getExceptionsStr(Method method){
		StringBuffer sb = new StringBuffer();
		Class[] exceptions = method.getExceptionTypes();
		if (exceptions.length > 0) {
			sb.append(" throws "); 
			StringBuffer sbException = new StringBuffer();
			for (int i = 0; i < exceptions.length; i++) {
				Class model = (Class) exceptions[i];
				String pName = model.getSimpleName();
				if (i != 0) {
					sbException.append(", ").append(pName);
				} else {
					sbException.append(pName);
				}
			}
			sb.append(sbException);
		}
		
		return sb.toString();
	}
}
