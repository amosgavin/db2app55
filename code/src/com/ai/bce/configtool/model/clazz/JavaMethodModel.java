package com.ai.bce.configtool.model.clazz;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import com.ai.appframe2.common.AIException;
import com.ai.bce.bo.BOListItemBean;
import com.ai.bce.configtool.model.common.AbstractModel;

/**
 * 方法
 * @author linzhaoming
 *
 */
public class JavaMethodModel extends AbstractModel{
	
	private ClassModel classModel;
	private Method method;
	private List exceptions = new ArrayList();
	
	public JavaMethodModel(ClassModel classModel, Method method){
		super(classModel);
		this.classModel = classModel;
		this.method = method;
		init(method);
	}
	
	private void init(Method method) {
		if (Modifier.isPublic(method.getModifiers())) { // 只有public方法才需要统计进来
			Class[] types = method.getParameterTypes();
			for (int i = 0; i < types.length; i++) {
				Class parameter = types[i];
				ParameterModel pModel = new ParameterModel(this, parameter);
				pModel.setSeq(i);
				this.addChild(pModel);
			}
		}
	}	
	
	/**
	 * 转换为BOListItem的形式
	 * @return
	 */
	public BOListItemBean toBOListItemBean(){
		BOListItemBean bean = null;
		//处理参数列表
		StringBuffer sb = new StringBuffer();
		sb.append(getAccess() + " " + method.getReturnType().getSimpleName());
		sb.append(" " + method.getName());
		sb.append(ClazzHelper.getParameterStr(getChildren()));
		
		sb.append(ClazzHelper.getExceptionsStr(method));
		try {
			bean = new BOListItemBean();
			bean.setItem1(sb.toString());			//方法描述		
			bean.setItem2(method.getName());		//方法名字
			bean.setItem3(getAccess());				//访问可控制，"public"
			bean.setItem4(classModel.getClazz().getName());		//类名字
			bean.setItem5(method.getReturnType().getName());	//返回类型
			bean.setItem6(ClazzHelper.getParameterStr(getChildren()));	//参数列表
			bean.setItem7("" + getSeq());						//序号
		} catch (AIException e) {
			e.printStackTrace();
		} 
		
		
				
		return bean;
	}

	public String getName() {
		return method.getName();
	}

	public String getAccess() {
		//TODO: 之前已经处理过是public，为了严谨点，处理多几种
		return "public";
	}

	public String getReturnType() {
		return method.getReturnType().getName();
	}

	public List getExceptions() {
		return exceptions;
	}

	public void setExceptions(List exceptions) {
		this.exceptions = exceptions;
	}

	public String toString() {
		return "MethodModel:" + method.getName() + ", size=" + getChildren().size();
	}

}