package com.ai.bce.configtool.model.clazz;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import com.ai.appframe2.common.AIException;
import com.ai.bce.bo.BOListItemBean;
import com.ai.bce.configtool.model.common.AbstractModel;

/**
 * ����
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
		if (Modifier.isPublic(method.getModifiers())) { // ֻ��public��������Ҫͳ�ƽ���
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
	 * ת��ΪBOListItem����ʽ
	 * @return
	 */
	public BOListItemBean toBOListItemBean(){
		BOListItemBean bean = null;
		//��������б�
		StringBuffer sb = new StringBuffer();
		sb.append(getAccess() + " " + method.getReturnType().getSimpleName());
		sb.append(" " + method.getName());
		sb.append(ClazzHelper.getParameterStr(getChildren()));
		
		sb.append(ClazzHelper.getExceptionsStr(method));
		try {
			bean = new BOListItemBean();
			bean.setItem1(sb.toString());			//��������		
			bean.setItem2(method.getName());		//��������
			bean.setItem3(getAccess());				//���ʿɿ��ƣ�"public"
			bean.setItem4(classModel.getClazz().getName());		//������
			bean.setItem5(method.getReturnType().getName());	//��������
			bean.setItem6(ClazzHelper.getParameterStr(getChildren()));	//�����б�
			bean.setItem7("" + getSeq());						//���
		} catch (AIException e) {
			e.printStackTrace();
		} 
		
		
				
		return bean;
	}

	public String getName() {
		return method.getName();
	}

	public String getAccess() {
		//TODO: ֮ǰ�Ѿ��������public��Ϊ���Ͻ��㣬����༸��
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