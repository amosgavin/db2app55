package com.ai.bce.util.define;

/**
 * 针对startWorkFlow 进行信息拦截定义接口
 * 
 * @ClassName: IBceDealFilterForWF.java
 * @Description:
 * @author :彭秦进
 * @date 2011-7-28
 * @email:pengqj@asiainfo-linkage.com
 */
public interface IBceDealFilterForWF {
	/**
	 * 
	 * @throws Exception
	 */
	public void WorkFlowForStart() throws Exception;

	/**
	 * 
	 * @throws Exception
	 */
	public void WorkFlowForEnd() throws Exception;

	/**
	 * 
	 * @throws Exception
	 */
	public void WorkFlowForFinal() throws Exception;

	/**
	 * 
	 * @throws Exception
	 */
	public void ProcessForStart() throws Exception;

	/**
	 * 
	 * @throws Exception
	 */
	public void ProcessForEnd() throws Exception;

	/**
	 * 
	 * @throws Exception
	 */
	public void ProcessForFinal() throws Exception;
}
