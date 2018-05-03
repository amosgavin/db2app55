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
import com.asiainfo.bi.common.SaleConstants;
import com.asiainfo.charge.bo.BOChargeConcessDetailInfoBean;
import com.asiainfo.charge.bo.BOChargeConcessInfoBean;
import com.asiainfo.charge.ivalues.IBOChargeConcessDetailInfoValue;
import com.asiainfo.charge.ivalues.IBOChargeConcessInfoValue;
import com.asiainfo.charge.service.interfaces.IChargeMainSV;

public class ChargeDataConcessAction extends BaseAction {
	private transient static Log log = LogFactory.getLog(ChargeMainAction.class);

	public void saveChargeDataConcessDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String concessId = HttpUtil.getAsString(request, "concessId");
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request.getInputStream(), new Class[] { BOChargeConcessDetailInfoBean.class });

		if (dcLists.length == 0) {
			cp.set("alert", "Y");
			cp.set("MESSAGE", "无修改记录");
			HttpUtil.showInfo(response, cp);
			return;
		}

		IBOChargeConcessDetailInfoValue [] chargeConcessDetailInfoValues = null;// 前台提交的数据
			Object[] obj = dcLists[0].getColDataContainerInterface(0);
			for (int i = 0; i < obj.length; i++) {
				if (obj instanceof BOChargeConcessDetailInfoBean[]) {
					chargeConcessDetailInfoValues = (BOChargeConcessDetailInfoBean[]) obj;
					if(concessId!=null)
						chargeConcessDetailInfoValues[i].setConssid(Integer.valueOf(concessId));
				}
			}
			

		IChargeMainSV chargeMainSV = (IChargeMainSV) ServiceFactory.getService(IChargeMainSV.class);

		try {
				chargeMainSV.saveChargeConcessDetailInfo(chargeConcessDetailInfoValues);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("保存信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
	
	public void saveChargeDataConcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String chargeid = HttpUtil.getAsString(request, "chargeid");
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request.getInputStream(), new Class[] { BOChargeConcessInfoBean.class });

		if (dcLists.length == 0) {
			cp.set("alert", "Y");
			cp.set("MESSAGE", "无修改记录");
			HttpUtil.showInfo(response, cp);
			return;
		}

		IBOChargeConcessInfoValue [] chargeConcessInfoValues = new IBOChargeConcessInfoValue[0];// 前台提交的数据
		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOChargeConcessInfoBean[]) {
				chargeConcessInfoValues = (BOChargeConcessInfoBean[]) obj;
				 chargeConcessInfoValues[i].set("MID", Integer.parseInt(chargeid));
				 chargeConcessInfoValues[i].set("CHARGE_TYPE", SaleConstants.ChargeConstants.CHARGE_FEE_TYPE_DATA);
			}
		}

		IChargeMainSV chargeMainSV = (IChargeMainSV) ServiceFactory.getService(IChargeMainSV.class);
		try {
				int concessId = chargeMainSV.saveChargeConcessInfo(chargeConcessInfoValues);
				cp.set("FLAG", "Y");
				cp.set("concessId",   String.valueOf(concessId));
				cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("保存信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
	
	public void findChargeConcessByMid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mid = HttpUtil.getAsString(request, "mid");
		CustomProperty cp = CustomProperty.getInstance();

		IChargeMainSV chargeMainSV = (IChargeMainSV) ServiceFactory.getService(IChargeMainSV.class);
		try {
				int concessId = chargeMainSV.findChargeConcessByMid(mid);
				log.debug("values:"+concessId);
				cp.set("FLAG", "Y");
				cp.set("values",   String.valueOf(concessId));
				cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("保存信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}
	
}
