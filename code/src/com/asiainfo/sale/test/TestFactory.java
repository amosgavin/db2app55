package com.asiainfo.sale.test;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.test.dao.interfaces.*;
import com.asiainfo.sale.test.service.interfaces.*;

/**
 * Copyright: Copyright (c) 2012 Asiainfo-Linkage
 *
 * @Description: 模块工厂,用于同一管理Service,Dao服务
 *
 * @version: v1.0.0
 * @author: yanghesi
 * @date: 2012-02-21 15:33:38
 *
 * Modification History:</br>
 * Date         Author          Version            Description</br>
 *---------------------------------------------------------</br>
 * 2012-02-21     yanghesi           v1.0.0               Auto Generated</br>
 */
public class TestFactory {

	public static ISlHolidayDAO getSlHolidayDAO() {
		return (ISlHolidayDAO) ServiceFactory.getService(ISlHolidayDAO.class);
	}

	public static ISlHolidaySV getSlHolidaySV() {
		return (ISlHolidaySV) ServiceFactory.getService(ISlHolidaySV.class);
	}

}
