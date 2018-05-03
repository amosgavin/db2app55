package com.asiainfo.charge.service.interfaces;

import com.asiainfo.charge.ivalues.IBOChargeApplyMainDeValue;
import com.asiainfo.charge.ivalues.IBOChargeApplyMainValue;
import com.asiainfo.charge.ivalues.IBOChargeConcessDetailInfoValue;
import com.asiainfo.charge.ivalues.IBOChargeConcessInfoValue;
import com.asiainfo.charge.ivalues.IBOChargeInfoValue;

public interface IChargeMainSV {
	
	public void changeChargeState(String mid,String state)throws Exception, RuntimeException;
	//查询资费编码是否重复
	public String codeRepeat(String id)throws Exception, RuntimeException;
	//资费状态更改为可用
	public void chargeStateToUse(String id)throws Exception, RuntimeException;
	//资费状态更改为否决
	public void chargeStateToNoUse(String id)throws Exception, RuntimeException;
	// 根据ID查询
	public IBOChargeApplyMainValue IChargeMainshow(String id) throws Exception;
	public void delChargeMain(String id) throws Exception;
	//根据主ID找出资费档次并删除
	public void delChargeDetail(String applyid) throws Exception;
	// 删除档次
	public void delChargeDetail(IBOChargeInfoValue[] IBOChargeInfoValue) throws Exception;

	// 根据主信息ID和资费类型查询资费详细信息
	public IBOChargeInfoValue[] getChargeDetailByFeeType(String mainId, String feetype, int $STARTROWINDEX, int $ENDROWINDEX) throws Exception;

	public int getCountByFeeType(String mainId, String feetype) throws Exception;

	// 保存主信息
	public String saveChargeMain(IBOChargeApplyMainValue chargeMainValue) throws Exception, RuntimeException;

	public void saveChargeMain(IBOChargeApplyMainValue[] chargeMainValue) throws Exception, RuntimeException;

	// 根据具体信息查询武器
	public IBOChargeApplyMainDeValue[] ChargeMainshow(String applyid, String feetype, String applyTime, String applyEndTime, String principle, String isSubmit,String townname,String appname, int $STARTROWINDEX,
			int $ENDROWINDEX) throws Exception, RuntimeException;

	public int ChargeMainshow(String applyid, String feetype, String applyTime, String applyEndTime, String principle, String isSubmit,String townname,String appname) throws Exception, RuntimeException;
	
	public String cloneSaleMain (String id, String staffId, String orgId,String mid)throws Exception, RuntimeException;
	/**
	 * 
	 * @Function: com.asiainfo.charge.service.interfaces.IChargeMainSV.saveChargeDataConcess
	 * @Description:保存优惠包明细信息   
	 *
	 * @param chargeConcessDetailInfoValues
	 * @throws Exception
	 * @throws RuntimeException
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @date:2012-7-7下午05:27:28
	 *
	 * Modification History:
	 * Date         Author      Version     Description
	 * -----------------------------------------------------------------
	 * 2012-7-7      shigm     v1.0.0
	 */
	public void saveChargeConcessDetailInfo(IBOChargeConcessDetailInfoValue[] chargeConcessDetailInfoValues) throws Exception, RuntimeException;
	/**
	 * 
	 * @Function: com.asiainfo.charge.service.interfaces.IChargeMainSV.queryChargeDataConcessPkgCount
	 * @Description:查询优惠包明细总记录   
	 *
	 * @param concessId
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @date:2012-7-8上午11:40:00
	 *
	 * Modification History:
	 * Date         Author      Version     Description
	 * -----------------------------------------------------------------
	 * 2012-7-8      shigm     v1.0.0
	 */
	public int queryChargeConcessDetailInfoCountByConssId(String concessId) throws Exception, RuntimeException;
	/**
	 * 
	 * @Function: com.asiainfo.charge.service.interfaces.IChargeMainSV.queryChargeDataConcessPkg
	 * @Description:查询优惠包明细信息记录   
	 *
	 * @param concessId
	 * @param start
	 * @param end
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @date:2012-7-8上午11:40:13
	 *
	 * Modification History:
	 * Date         Author      Version     Description
	 * -----------------------------------------------------------------
	 * 2012-7-8      shigm     v1.0.0
	 */
	public IBOChargeConcessDetailInfoValue[] queryChargeConcessDetailInfoByConssId(String concessId, int start, int end) throws Exception, RuntimeException;
	
	/**
	 *  
	 * @Function: com.asiainfo.charge.service.interfaces.IChargeMainSV.saveChargeDataConcess
	 * @Description:保存优惠包主表信息  
	 *
	 * @param chargeConcessInfoValues
	 * @throws Exception
	 * @throws RuntimeException
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @date:2012-7-8上午11:51:17
	 *
	 * Modification History:
	 * Date         Author      Version     Description
	 * -----------------------------------------------------------------
	 * 2012-7-8      shigm     v1.0.0
	 */
	public int saveChargeConcessInfo(IBOChargeConcessInfoValue[] chargeConcessInfoValues) throws Exception, RuntimeException;
	/**
	 * 
	 * @Function: com.asiainfo.charge.service.interfaces.IChargeMainSV.queryChargeDataConcessPkgCount
	 * @Description:查询优惠包主表总记录   
	 *
	 * @param concessId
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @date:2012-7-8上午11:52:04
	 *
	 * Modification History:
	 * Date         Author      Version     Description
	 * -----------------------------------------------------------------
	 * 2012-7-8      shigm     v1.0.0
	 */
	public int queryChargeConcessInfoCount(String concessId) throws Exception, RuntimeException;
	/**
	 * 
	 * @Function: com.asiainfo.charge.service.interfaces.IChargeMainSV.queryChargeDataConcessPkg
	 * @Description:查询优惠包主表信息记录   
	 *
	 * @param concessId
	 * @param start
	 * @param end
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @date:2012-7-8上午11:52:41
	 *
	 * Modification History:
	 * Date         Author      Version     Description
	 * -----------------------------------------------------------------
	 * 2012-7-8      shigm     v1.0.0
	 */
	public IBOChargeConcessInfoValue[] queryChargeConcessInfo(String concessId, int start, int end) throws Exception, RuntimeException;
	/**
	 * 根据mid查找chargeConcess表记录
	 * 
	 * @Function: com.asiainfo.charge.service.interfaces.IChargeMainSV.findChargeConcessByMid
	 * @Description:
	 *
	 * @param mid
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @date:2012-7-10上午11:15:18
	 *
	 * Modification History:
	 * Date         Author      Version     Description
	 * -----------------------------------------------------------------
	 * 2012-7-10      shigm     v1.0.0
	 */
	public  int findChargeConcessByMid(String mid) throws Exception, RuntimeException;
	/**
	 * 根据concessId查找chargeConcess列表
	 * 
	 * @Function: com.asiainfo.charge.service.interfaces.IChargeMainSV.findChargeConcessByConcessId
	 * @Description:
	 *
	 * @param concessId
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @date:2012-7-10上午11:16:54
	 *
	 * Modification History:
	 * Date         Author      Version     Description
	 * -----------------------------------------------------------------
	 * 2012-7-10      shigm     v1.0.0
	 */
	public IBOChargeConcessInfoValue [] findChargeConcessByConcessId(String concessId) throws Exception, RuntimeException;
	
	public boolean haveBossId(String id)throws Exception, RuntimeException;
	
	public IBOChargeInfoValue[] getChargeDetailByNewMainid(String mainId, int startNum, int endNum)  throws Exception;
	
	public int getChargeDetailByNewMainidCount(String mainId)  throws Exception;
	
}
