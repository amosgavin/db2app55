package com.ai.bce.configtool.service.interfaces;

import java.rmi.RemoteException;

import com.ai.bce.ivalues.IBceButtonValue;
import com.ai.bce.ivalues.IBceFrameButtonValue;

/**
 * 
 * Copyright: Copyright (c) 2010 Asiainfo-Linkage
 * 
 * @ClassName: IConfButtonSV.java
 * @Description: 按钮服务接口
 *
 * @version: v1.0.0
 * @author: ZhangWenqi
 * @date: Dec 20, 2010 10:21:57 AM 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * Dec 20, 2010     ZhangWenqi           v1.0.0               修改原因
 */
public interface IConfButtonSV {

	/**
	 * 
	 * @Function: getBceButton
	 * @Description: 根据条件查询按钮信息
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 20, 2010 10:23:48 AM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 20, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public IBceButtonValue[] getBceButtonValues(String cond)throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getBceButton
	 * @Description: 根据条件查询按钮信息
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 20, 2010 10:22:48 AM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 20, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public IBceButtonValue[] getBceButtonValues(String cond, int startNum, int endNum)throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getBceButtonCount
	 * @Description: 根据条件查询按钮信息的数量
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 20, 2010 10:25:02 AM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 20, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public int getBceButtonCount(String cond) throws Exception, RemoteException;
	
	/**
	 * 
	 * @Function: getBceFrameButton
	 * @Description: 根据条件查询业务操作与按钮关系
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 20, 2010 4:28:35 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 20, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public IBceFrameButtonValue[] getBceFrameButton(String cond) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getBceFrameButton
	 * @Description: 根据条件查询业务操作与按钮关系
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 20, 2010 4:29:40 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 20, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public IBceFrameButtonValue[] getBceFrameButton(String cond, int startNum, int endNum) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getBceFrameButtonCount
	 * @Description: 根据条件查询业务操作与按钮关系的数量
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 20, 2010 4:30:20 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 20, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public int getBceFrameButtonCount(String cond) throws Exception, RemoteException;

	public IBceButtonValue[] getBceButtons() throws Exception;
}
