package com.ai.secframe.sysmgr.web;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.util.locale.AppframeLocaleFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.ai.common.util.TimeUtil;
import com.ai.secframe.orgmodel.ivalues.IBOSecOpStationValue;
import com.ai.secframe.orgmodel.ivalues.IBOSecOperatorValue;
import com.ai.secframe.orgmodel.service.interfaces.ISecOpStationSV;
import com.ai.secframe.orgmodel.service.interfaces.ISecOperatorSV;
import com.ai.secframe.sysmgr.bo.BOSecStationDefaultRoleBean;
import com.ai.secframe.sysmgr.bo.QBOSecAuthorableRoleBean;
import com.ai.secframe.sysmgr.ivalues.IBOSecStationDefaultRoleValue;
import com.ai.secframe.sysmgr.ivalues.IQBOSecAuthorableRoleValue;
import com.ai.secframe.sysmgr.ivalues.IQBOSecAuthoredRoleValue;
import com.ai.secframe.sysmgr.service.interfaces.ISecAuthorSV;
import com.ai.secframe.sysmgr.service.interfaces.ISecStationDefaultRoleSV;
import com.ai.secframe.sysmgr.service.interfaces.ISecStationDefaultRoleSV;

public class SecAuthorAction4Default extends BaseAction {

	private transient static Log log = LogFactory.getLog(SecAuthorAction4Default.class);

	public void getOpStationId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String code = HttpUtil.getParameter(request, "code");
		String stId = HttpUtil.getParameter(request, "stId");
		log.debug("code:" + code);
		log.debug("stId:" + stId);
		String retVal = "1";
		CustomProperty cp = CustomProperty.getInstance();
		try {
			if (code != null && !("").equals(code) && code.length() > 0) {
				ISecOperatorSV opSv = (ISecOperatorSV) ServiceFactory.getService(ISecOperatorSV.class);
				IBOSecOperatorValue value = opSv.getOperatorByCode(code);
				log.debug("value:" + value);
				if (value != null) {
					long operatorId = value.getOperatorId();
					ISecOpStationSV opStationSv = (ISecOpStationSV) ServiceFactory.getService(ISecOpStationSV.class);
					IBOSecOpStationValue[] opSValue = opStationSv.getOpStationByOperId(operatorId);
					if (opSValue != null && opSValue.length > 0) {
						saveAuthor4Default(opSValue, stId);
					}
				}
			}
		} catch (Exception e) {
			retVal = "0";
			cp.set("retMsg", e.getMessage());
			log.error(AppframeLocaleFactory.getResource("i18n.secframe_resource", "sec.authoraction.saveAuthor.err"), e);
		} finally {
			cp.set("retVal", retVal);
			HttpUtil.showInfo(response, cp);
		}
	}

	public void saveAuthor4Default(IBOSecOpStationValue[] values, String stId) throws Exception {
		if (values == null) {
			log.debug("无初始默认岗位对应角色");
			return ;
		}
		try {
			String[] opstIdStrs = new String[values.length];
			for (int i = 0; i < values.length; i++) {
				long v = values[i].getOpStationId();
				opstIdStrs[i] = String.valueOf(v);
			}
			long[] opstIds = null;
			if (opstIdStrs != null && opstIdStrs.length > 0) {
				opstIds = new long[opstIdStrs.length];
				for (int i = 0; i < opstIdStrs.length; i++) {
					if (StringUtils.isNotBlank(opstIdStrs[i])) {
						opstIds[i] = Long.parseLong(opstIdStrs[i].trim());
					}
				}
				IQBOSecAuthorableRoleValue[] roleValues = null;
				QBOSecAuthorableRoleBean b = new QBOSecAuthorableRoleBean();
				roleValues = new QBOSecAuthorableRoleBean[] { b };
				for (int i = 0; i < roleValues.length; i++) {
					//IBOBsStaticDataValue[] staticDataValues = StaticDataUtil.getStaticData(stId);
					ISecStationDefaultRoleSV desv = (ISecStationDefaultRoleSV) ServiceFactory.getService(ISecStationDefaultRoleSV.class);
					IBOSecStationDefaultRoleValue[]  staticDataValues = desv.queryAccountCountByDefaultId(new Long(stId));
					for (int j = 0; j < staticDataValues.length; j++) {
						// 填充授权数据
						roleValues[i].setRoleId(new Long(staticDataValues[j].getRoleId()));
						roleValues[i].setNotes("-1");
						roleValues[i].setState(1L);
						roleValues[i].setAuthorValidDate(TimeUtil.getCurrentDayStartDate(new Date()));
						roleValues[i].setAuthorExpireDate(TimeUtil.getMaxExpire());
						roleValues[i].setDomainId(1L);
						roleValues[i].setAuthorType("A");
						if (opstIds != null && roleValues != null && roleValues.length > 0) {
							// 保存授权信息
							ISecAuthorSV sv = (ISecAuthorSV) ServiceFactory.getService(ISecAuthorSV.class);
							sv.saveBatchAuthorities(SessionManager.getUser().getID(), opstIds, roleValues);
						}
					}
				}
			}
		} catch (Exception e) {
			log.error(AppframeLocaleFactory.getResource("i18n.secframe_resource", "sec.authoraction.saveAuthor.err"), e);
		}
	}
	
	/**
	 * 
	 * 
	 * @Function: com.ai.secframe.sysmgr.web.SecAuthorAction4Default.refreshDefaultsRoles
	 * @Description:查询岗位默认的角色
	 *
	 * @param request
	 * @return
	 * @throws Exception
	 *
	 * @version:v1.0.0
	 * @author:shigm
	 * @date:2012-7-20下午04:09:09
	 *
	 * Modification History:
	 * Date         Author      Version     Description
	 * -----------------------------------------------------------------
	 * 2012-7-20      shigm     v1.0.0
	 */
	public DataContainerInterface[] refreshDefaultsRoles(HttpServletRequest request) throws Exception {
		String operIdStr = HttpUtil.getParameter(request, "operId");
		String opstIdStr = HttpUtil.getParameter(request, "stId");
		if (StringUtils.isNotBlank(operIdStr) && StringUtils.isNotBlank(opstIdStr)) {
			IQBOSecAuthoredRoleValue[] values = null;
			try {
				ISecStationDefaultRoleSV sv = (ISecStationDefaultRoleSV) ServiceFactory.getService(ISecStationDefaultRoleSV.class);
				values = sv.getAuthoredRolesByOpstId(Long.parseLong(operIdStr), Long.parseLong(opstIdStr));
			} catch (Exception e) {
				log.error(AppframeLocaleFactory.getResource("i18n.secframe_resource", "sec.authoraction.refreshAuthoredRoles.err"), e);
			}
			if (values != null && values.length > 0) {
				return (DataContainerInterface[]) values;
			}
		}
		return null;
	}
	
	public void saveAuthor(HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    String retVal = "1";
    CustomProperty cp = CustomProperty.getInstance();
    try
    {
      String opstIdStr = HttpUtil.getParameter(request, "stId");
	  log.debug("默认角色的岗位id" + opstIdStr);
      DataContainerList[] dcList = HttpUtil.getDataContainerLists(request.getInputStream(), new Class[] { QBOSecAuthorableRoleBean.class });

      if ((StringUtils.isNotBlank(opstIdStr)) && (dcList != null) && (dcList.length > 0))
      {
        String[] opstIdStrs = opstIdStr.split(",");
        String[] opstIds = null;
        if ((opstIdStrs != null) && (opstIdStrs.length > 0))
        {
          opstIds = new String[opstIdStrs.length];
          for (int i = 0; i < opstIdStrs.length; ++i)
          {
            if (StringUtils.isNotBlank(opstIdStrs[i]))
            {
              opstIds[i] = opstIdStrs[i].trim();
            }
          }
        }

        IQBOSecAuthorableRoleValue[] roleValues = null;
        for (int i = 0; i < dcList.length; ++i)
        {
          Object[] objArray = dcList[i].getColDataContainerInterface(0);
          if (objArray instanceof IQBOSecAuthorableRoleValue[])
          {
            roleValues = (IQBOSecAuthorableRoleValue[])(IQBOSecAuthorableRoleValue[])objArray;
          }
        }

        ISecStationDefaultRoleSV sv = (ISecStationDefaultRoleSV)ServiceFactory.getService(ISecStationDefaultRoleSV.class);
        ArrayList<BOSecStationDefaultRoleBean> value = new ArrayList<BOSecStationDefaultRoleBean>();
        for(int i=0;i<opstIds.length;i++){
        	for(int j=0;j<roleValues.length;j++){
        		BOSecStationDefaultRoleBean rolebean = new BOSecStationDefaultRoleBean();
        		rolebean.setStationId(opstIds[i]);
        		rolebean.setRoleId(String.valueOf(roleValues[j].getRoleId()));
        		rolebean.setState("1");
        		value.add(rolebean);
        	}
        }
        if (value.size()>0){
      	  log.debug("默认角色的岗位id，共授予" + value.size()+"个角色!");
           BOSecStationDefaultRoleBean[] defaultrole = new BOSecStationDefaultRoleBean[value.size()];
           value.toArray(defaultrole);
           sv.saveStationDefaultRole(defaultrole);
        }
      }
    }
    catch (Exception e)
    {
      retVal = "0";
      cp.set("retMsg", e.getMessage());
      log.error(AppframeLocaleFactory.getResource("i18n.secframe_resource", "sec.authoraction.saveAuthor.err"), e);
    }
    finally
    {
      cp.set("retVal", retVal);
      HttpUtil.showInfo(response, cp);
    }
  }

	public void unAuthor(HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    String retVal = "1";
    CustomProperty cp = CustomProperty.getInstance();
    try
    {
      String stid = HttpUtil.getParameter(request, "stid");
      String roleid = HttpUtil.getParameter(request, "roleid");
      ISecStationDefaultRoleSV sv = (ISecStationDefaultRoleSV)ServiceFactory.getService(ISecStationDefaultRoleSV.class);
      sv.unAuthor(stid, roleid);
    }
    catch (Exception e)
    {
      retVal = "0";
      cp.set("retMsg", e.getMessage());
      log.error(AppframeLocaleFactory.getResource("i18n.secframe_resource", "sec.authoraction.saveAuthor.err"), e);
    }
    finally
    {
      cp.set("retVal", retVal);
      HttpUtil.showInfo(response, cp);
    }
  }
	
}
