package com.ai.bce.configtool.model.clazz;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.ai.bce.bo.BOListItemBean;
import com.ai.bce.configtool.model.common.AbstractModel;

/**
 * ¿‡
 * @author linzhaoming
 *
 */
public class ClassModel extends AbstractModel{

	private Class clazz;
	
	public ClassModel(String className) {
		super(null);
		init(className);
	}
	
	public Class getClazz() {
		return clazz;
	}
	
	private void init(String className){
		try {
			clazz = Class.forName(className);
			Method[] methods = clazz.getDeclaredMethods();
			for (int i = 0; i < methods.length; i++) {
				Method method = methods[i];
				if (Modifier.isPublic(method.getModifiers())) {
					JavaMethodModel methodModel = new JavaMethodModel(this, method);
					methodModel.setSeq(i);
					this.addChild(methodModel);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	public BOListItemBean toBOListItemBean() {
		return null;
	}

	public String toString() {
		return "ClassModel:" + clazz.getName() + ", size=" + getChildren().size();
	}
}
