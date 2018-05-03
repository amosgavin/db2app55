package com.ai.comframe.test.zxh;

import com.asiainfo.task.dao.impl.CurTaskDAOImpl;
import com.asiainfo.task.bo.BOCurTaskBean;

public class TestCurTask {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CurTaskDAOImpl curTask = new CurTaskDAOImpl();
		BOCurTaskBean[] taskList = null;
		String roleId = "5000";
		String staffId = "123456789";
		String aa=staffId.substring(0, 2);
		
		System.out.println(aa);

	}

}
