package com.ai.bce.configtool.model.clazz;

import com.ai.appframe2.common.AIException;
import com.ai.bce.bo.BOListItemBean;
import com.ai.bce.configtool.model.common.AbstractModel;

/**
 * ���������쳣
 * 
 * @author linzhaoming
 * 
 */
public class ParameterModel extends AbstractModel{
	private JavaMethodModel methodModel;
	private Class clazz;

	public ParameterModel(JavaMethodModel methodModel, Class clazz) {
		super(methodModel);
		this.methodModel = methodModel;
		this.clazz = clazz;
	}
	
	public BOListItemBean toBOListItemBean(){
		BOListItemBean bean = null;
		try {
			bean = new BOListItemBean();
//		bean.setItem1("������" + i);	//����
			bean.setItem2(methodModel.getName());		//������
			bean.setItem3(clazz.getName());		//������
			bean.setItem4(clazz.getName());		//��������
			bean.setItem5("" + getSeq());		//���
		} catch (AIException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public String toString() {
		return "ParameterModel:" + clazz.getName();
	}

}