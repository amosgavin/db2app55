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
	// ����ID��ѯ
	public IBOChargeApplyMainValue IChargeMainshow(String id) throws Exception;
	
	
	public void delChargeMain(String id) throws Exception;
	public void delChargeDetail(String applyid) throws Exception;
	public void delChargeDetail(IBOChargeInfoValue[] IBOChargeInfoValue) throws Exception;

	public IBOChargeInfoValue[] getChargeDetailByFeeType(String mainId, String feetype, int startNum, int endNum) throws Exception;

	public int getCountByFeeType(String mainId, String feetype) throws Exception;

	// ����ס��Ϣ
	public String saveChargeMain(IBOChargeApplyMainValue chargeMainValue) throws Exception, RuntimeException;

	public void saveChargeMain(IBOChargeApplyMainValue[] chargeMainValue) throws Exception, RuntimeException;

	public IBOChargeApplyMainDeValue[] ChargeMainshow(String applyid, String feetype, String applyTime, String applyEndTime, String principle, String isSubmit,String townname,String appname, int stratnum,
			int endnum) throws Exception, RuntimeException;

	public int ChargeMainshow(String applyid, String feetype, String applyTime, String applyEndTime, String principle, String isSubmit,String townname,String appname) throws Exception, RuntimeException;

	public String cloneSaleMain (String id, String staffId, String orgId,String mid)throws Exception, RuntimeException;
	/**
	 * 
	 * @Function: com.asiainfo.charge.dao.interfaces.IChargeMainDAO.saveChargeDataConcessDetail
	 * @Description:�����ʷѵ�������Ϊ
	 *
	 * @param chargeConcessDetailInfoValues
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @throws RuntimeException 
	 * @throws Exception 
	 * @date:2012-7-7����05:30:17
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
	 * @Description: ��ѯ�Żݰ���ϸ�ܼ�¼   
	 *
	 * @param map
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @date:2012-7-8����12:24:24
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
	 * @Description:��ѯ�Żݰ���ϸ��Ϣ��¼   
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
	 * @date:2012-7-8����12:24:41
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
	 * @Description: �����Żݰ�������Ϣ  
	 *
	 * @param chargeConcessInfoValues
	 * @throws Exception
	 * @throws RuntimeException
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @date:2012-7-8����12:25:25
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
	 * @Description:��ѯ�Żݰ������ܼ�¼   
	 *
	 * @param map
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @date:2012-7-8����12:25:54
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
	 * @Description:��ѯ�Żݰ�������Ϣ��¼   
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
	 * @date:2012-7-8����12:26:09
	 *
	 * Modification History:
	 * Date         Author      Version     Description
	 * -----------------------------------------------------------------
	 * 2012-7-8      shigm     v1.0.0
	 */
	public IBOChargeConcessInfoValue[] queryChargeConcessInfo(Map<Object, String> map, int start, int end)throws Exception, RuntimeException;
	/**
	 * ����mid����chargeConcess���¼
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
	 * @date:2012-7-10����11:15:18
	 *
	 * Modification History:
	 * Date         Author      Version     Description
	 * -----------------------------------------------------------------
	 * 2012-7-10      shigm     v1.0.0
	 */
	public int findChargeConcessByMid(String mid) throws Exception, RuntimeException;
	/**
	 * ����concessId����chargeConcess�б�
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
	 * @date:2012-7-10����11:16:54
	 *
	 * Modification History:
	 * Date         Author      Version     Description
	 * -----------------------------------------------------------------
	 * 2012-7-10      shigm     v1.0.0
	 */
	public  IBOChargeConcessInfoValue [] findChargeConcessByConcessId(String concessId)throws Exception, RuntimeException;
	
	public boolean haveBossId(String id)throws Exception, RuntimeException;
	//20130614һ�Զ��ʷ�
	public IBOChargeInfoValue[] getChargeDetailByNewMainid(String mainId, int startNum, int endNum)  throws Exception;
	
	public int getChargeDetailByNewMainidCount(String mainId)  throws Exception;
}
