package com.asiainfo.charge.dao.interfaces;

import java.util.Map;

import com.asiainfo.charge.ivalues.IBOChargeApplyMainDeValue;
import com.asiainfo.charge.ivalues.IBOChargeApplyMainValue;
import com.asiainfo.charge.ivalues.IBOChargeConcessDetailInfoValue;
import com.asiainfo.charge.ivalues.IBOChargeConcessInfoValue;
import com.asiainfo.charge.ivalues.IBOChargeInfoValue;

public interface IChargeMainDAO {
	public void chargeStateToUse(String id)throws Exception, RuntimeException;
	public void chargeStateToNoUse(String id)throws Exception, RuntimeException;
	
	public String codeRepeat(String id) throws Exception, RuntimeException;
	// 根据ID查询
	public IBOChargeApplyMainValue IChargeMainshow(String id) throws Exception;
	
	
	public void delChargeMain(String id) throws Exception;
	public void delChargeDetail(String applyid) throws Exception;
	public void delChargeDetail(IBOChargeInfoValue[] IBOChargeInfoValue) throws Exception;

	public IBOChargeInfoValue[] getChargeDetailByFeeType(String mainId, String feetype, int startNum, int endNum) throws Exception;

	public int getCountByFeeType(String mainId, String feetype) throws Exception;

	// 保存住信息
	public String saveChargeMain(IBOChargeApplyMainValue chargeMainValue) throws Exception, RuntimeException;

	public void saveChargeMain(IBOChargeApplyMainValue[] chargeMainValue) throws Exception, RuntimeException;

	public IBOChargeApplyMainDeValue[] ChargeMainshow(String applyid, String feetype, String applyTime, String applyEndTime, String principle, String isSubmit,String townname,String appname, int stratnum,
			int endnum) throws Exception, RuntimeException;

	public int ChargeMainshow(String applyid, String feetype, String applyTime, String applyEndTime, String principle, String isSubmit,String townname,String appname) throws Exception, RuntimeException;

	public String cloneSaleMain (String id, String staffId, String orgId,String mid)throws Exception, RuntimeException;
	/**
	 * 
	 * @Function: com.asiainfo.charge.dao.interfaces.IChargeMainDAO.saveChargeDataConcessDetail
	 * @Description:保存资费档次类型为
	 *
	 * @param chargeConcessDetailInfoValues
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @throws RuntimeException 
	 * @throws Exception 
	 * @date:2012-7-7下午05:30:17
	 *
	 * Modification History:
	 * Date         Author      Version     Description
	 * -----------------------------------------------------------------
	 * 2012-7-7      shigm     v1.0.0
	 */
	public void saveChargeConcessDetailInfo(IBOChargeConcessDetailInfoValue[] chargeConcessDetailInfoValues) throws Exception, RuntimeException;

	/**
	 * 
	 * @Function: com.asiainfo.charge.dao.interfaces.IChargeMainDAO.queryChargeConcessDetailInfoCount
	 * @Description: 查询优惠包明细总记录   
	 *
	 * @param map
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @date:2012-7-8下午12:24:24
	 *
	 * Modification History:
	 * Date         Author      Version     Description
	 * -----------------------------------------------------------------
	 * 2012-7-8      shigm     v1.0.0
	 */
	public int queryChargeConcessDetailInfoCount(Map<Object, String> map)throws Exception, RuntimeException;
	/**
	 * 
	 * @Function: com.asiainfo.charge.dao.interfaces.IChargeMainDAO.queryChargeConcessDetailInfo
	 * @Description:查询优惠包明细信息记录   
	 *
	 * @param map
	 * @param start
	 * @param end
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @date:2012-7-8下午12:24:41
	 *
	 * Modification History:
	 * Date         Author      Version     Description
	 * -----------------------------------------------------------------
	 * 2012-7-8      shigm     v1.0.0
	 */
	public IBOChargeConcessDetailInfoValue[] queryChargeConcessDetailInfo(Map<Object, String> map, int start, int end)throws Exception, RuntimeException;
	
	/**
	 *
	 * @Function: com.asiainfo.charge.dao.interfaces.IChargeMainDAO.saveChargeConcessInfo
	 * @Description: 保存优惠包主表信息  
	 *
	 * @param chargeConcessInfoValues
	 * @throws Exception
	 * @throws RuntimeException
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @date:2012-7-8下午12:25:25
	 *
	 * Modification History:
	 * Date         Author      Version     Description
	 * -----------------------------------------------------------------
	 * 2012-7-8      shigm     v1.0.0
	 */
	public int saveChargeConcessInfo(IBOChargeConcessInfoValue[] chargeConcessInfoValues) throws Exception, RuntimeException;
	/**
	 * 
	 * @Function: com.asiainfo.charge.dao.interfaces.IChargeMainDAO.queryChargeConcessInfoCount
	 * @Description:查询优惠包主表总记录   
	 *
	 * @param map
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @date:2012-7-8下午12:25:54
	 *
	 * Modification History:
	 * Date         Author      Version     Description
	 * -----------------------------------------------------------------
	 * 2012-7-8      shigm     v1.0.0
	 */
	public int queryChargeConcessInfoCount(Map<Object, String> map)throws Exception, RuntimeException;
	/**
	 * 
	 * @Function: com.asiainfo.charge.dao.interfaces.IChargeMainDAO.queryChargeConcessInfo
	 * @Description:查询优惠包主表信息记录   
	 *
	 * @param map
	 * @param start
	 * @param end
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @date:2012-7-8下午12:26:09
	 *
	 * Modification History:
	 * Date         Author      Version     Description
	 * -----------------------------------------------------------------
	 * 2012-7-8      shigm     v1.0.0
	 */
	public IBOChargeConcessInfoValue[] queryChargeConcessInfo(Map<Object, String> map, int start, int end)throws Exception, RuntimeException;
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
	public int findChargeConcessByMid(String mid) throws Exception, RuntimeException;
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
	public  IBOChargeConcessInfoValue [] findChargeConcessByConcessId(String concessId)throws Exception, RuntimeException;
	
	public boolean haveBossId(String id)throws Exception, RuntimeException;
	//20130614一对多资费
	public IBOChargeInfoValue[] getChargeDetailByNewMainid(String mainId, int startNum, int endNum)  throws Exception;
	
	public int getChargeDetailByNewMainidCount(String mainId)  throws Exception;
}
