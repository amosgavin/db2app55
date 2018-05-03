package com.asiainfo.charge.service.interfaces;

import com.asiainfo.charge.ivalues.IBOChargeApplyMainDeValue;
import com.asiainfo.charge.ivalues.IBOChargeApplyMainValue;
import com.asiainfo.charge.ivalues.IBOChargeConcessDetailInfoValue;
import com.asiainfo.charge.ivalues.IBOChargeConcessInfoValue;
import com.asiainfo.charge.ivalues.IBOChargeInfoValue;

public interface IChargeMainSV {
	
	public void changeChargeState(String mid,String state)throws Exception, RuntimeException;
	//��ѯ�ʷѱ����Ƿ��ظ�
	public String codeRepeat(String id)throws Exception, RuntimeException;
	//�ʷ�״̬����Ϊ����
	public void chargeStateToUse(String id)throws Exception, RuntimeException;
	//�ʷ�״̬����Ϊ���
	public void chargeStateToNoUse(String id)throws Exception, RuntimeException;
	// ����ID��ѯ
	public IBOChargeApplyMainValue IChargeMainshow(String id) throws Exception;
	public void delChargeMain(String id) throws Exception;
	//������ID�ҳ��ʷѵ��β�ɾ��
	public void delChargeDetail(String applyid) throws Exception;
	// ɾ������
	public void delChargeDetail(IBOChargeInfoValue[] IBOChargeInfoValue) throws Exception;

	// ��������ϢID���ʷ����Ͳ�ѯ�ʷ���ϸ��Ϣ
	public IBOChargeInfoValue[] getChargeDetailByFeeType(String mainId, String feetype, int $STARTROWINDEX, int $ENDROWINDEX) throws Exception;

	public int getCountByFeeType(String mainId, String feetype) throws Exception;

	// ��������Ϣ
	public String saveChargeMain(IBOChargeApplyMainValue chargeMainValue) throws Exception, RuntimeException;

	public void saveChargeMain(IBOChargeApplyMainValue[] chargeMainValue) throws Exception, RuntimeException;

	// ���ݾ�����Ϣ��ѯ����
	public IBOChargeApplyMainDeValue[] ChargeMainshow(String applyid, String feetype, String applyTime, String applyEndTime, String principle, String isSubmit,String townname,String appname, int $STARTROWINDEX,
			int $ENDROWINDEX) throws Exception, RuntimeException;

	public int ChargeMainshow(String applyid, String feetype, String applyTime, String applyEndTime, String principle, String isSubmit,String townname,String appname) throws Exception, RuntimeException;
	
	public String cloneSaleMain (String id, String staffId, String orgId,String mid)throws Exception, RuntimeException;
	/**
	 * 
	 * @Function: com.asiainfo.charge.service.interfaces.IChargeMainSV.saveChargeDataConcess
	 * @Description:�����Żݰ���ϸ��Ϣ   
	 *
	 * @param chargeConcessDetailInfoValues
	 * @throws Exception
	 * @throws RuntimeException
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @date:2012-7-7����05:27:28
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
	 * @Description:��ѯ�Żݰ���ϸ�ܼ�¼   
	 *
	 * @param concessId
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @date:2012-7-8����11:40:00
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
	 * @Description:��ѯ�Żݰ���ϸ��Ϣ��¼   
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
	 * @date:2012-7-8����11:40:13
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
	 * @Description:�����Żݰ�������Ϣ  
	 *
	 * @param chargeConcessInfoValues
	 * @throws Exception
	 * @throws RuntimeException
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @date:2012-7-8����11:51:17
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
	 * @Description:��ѯ�Żݰ������ܼ�¼   
	 *
	 * @param concessId
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @date:2012-7-8����11:52:04
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
	 * @Description:��ѯ�Żݰ�������Ϣ��¼   
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
	 * @date:2012-7-8����11:52:41
	 *
	 * Modification History:
	 * Date         Author      Version     Description
	 * -----------------------------------------------------------------
	 * 2012-7-8      shigm     v1.0.0
	 */
	public IBOChargeConcessInfoValue[] queryChargeConcessInfo(String concessId, int start, int end) throws Exception, RuntimeException;
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
	public  int findChargeConcessByMid(String mid) throws Exception, RuntimeException;
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
	public IBOChargeConcessInfoValue [] findChargeConcessByConcessId(String concessId) throws Exception, RuntimeException;
	
	public boolean haveBossId(String id)throws Exception, RuntimeException;
	
	public IBOChargeInfoValue[] getChargeDetailByNewMainid(String mainId, int startNum, int endNum)  throws Exception;
	
	public int getChargeDetailByNewMainidCount(String mainId)  throws Exception;
	
}
