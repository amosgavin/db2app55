package com.asiainfo.charge.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.charge.bo.BOChargeApplyMainBean;
import com.asiainfo.charge.bo.BOChargeInfoBean;
import com.asiainfo.charge.ivalues.IBOChargeInfoValue;
import com.asiainfo.charge.service.interfaces.IChargeMainDeSV;
import com.asiainfo.charge.service.interfaces.IChargeMainSV;
import com.asiainfo.sale.activity.web.SaleMainAction;

public class ChargeMainDeAction extends BaseAction{
	private transient static Log log = LogFactory.getLog(ChargeMainDeAction.class);
	
	public void saveChargeMainDe(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// ǰ̨���ݵ�XML���ݣ���̨���շ���
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOChargeInfoBean.class });
		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "��������Ϊ�գ�");
			return;
		}

		IBOChargeInfoValue[] chargeMainDeValues = null;// ǰ̨�ύ������

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOChargeInfoBean[]) {
				chargeMainDeValues = (BOChargeInfoBean[]) obj;
			}
		}

		IChargeMainDeSV chargeMainDeSV = (IChargeMainDeSV) ServiceFactory.getService(IChargeMainDeSV.class);

		try {
			if(null == chargeMainDeValues || 0 == chargeMainDeValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "��������Ϊ�գ�");
			} else {
				String applyID="";
				String chargeid="";
					if(chargeMainDeValues.length==1){
						 applyID=chargeMainDeSV.saveChargeMainDe(chargeMainDeValues[0]);
						 chargeid=chargeMainDeValues[0].getMid();
					}else{
								for(int i=0;i<chargeMainDeValues.length;i++){
								chargeMainDeSV.saveChargeMainDe(chargeMainDeValues[i]);
						
						}
					}
				cp.set("FLAG", "Y");
				//cp.set("MESSAGE", "�����ɹ���");
				cp.set("applyID",applyID);
				cp.set("chargeid",chargeid);
			}
		} catch (Exception e) {
			// ����ʧ��
			log.error("����Ӫ��������Ϣ����", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
	
	
	public void isHaveYes(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		String zfbm=request.getParameter("zfbm");
		IChargeMainSV chargeMainSV = (IChargeMainSV) ServiceFactory
		.getService(IChargeMainSV.class);
		try{
		String numzfbmS=chargeMainSV.codeRepeat(zfbm);
		cp.set("SEQ", numzfbmS);
		}catch(Exception e){
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		}finally{
			HttpUtil.showInfo(response, cp);
		}
	}
	
	
	public void haveBossId(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();
		String bossId=request.getParameter("BossId");
		IChargeMainSV chargeMainSV = (IChargeMainSV) ServiceFactory
		.getService(IChargeMainSV.class);
		try{
		if(!chargeMainSV.haveBossId(bossId)){
			cp.set("BOSS", "YES");
		}else{
		cp.set("BOSS", "NO");
		}
		}catch(Exception e){
			cp.set("MESSAGE", "����ʧ��" + ":" + e.getMessage());
		}finally{
			HttpUtil.showInfo(response, cp);
		}
	}
}
