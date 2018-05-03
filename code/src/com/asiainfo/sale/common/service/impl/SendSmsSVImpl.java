package com.asiainfo.sale.common.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.costWarn.job.ConnectUtil;
import com.asiainfo.sale.common.dao.interfaces.ISendSmsDAO;
import com.asiainfo.sale.common.ivalues.IBOApplyInfoValue;
import com.asiainfo.sale.common.service.interfaces.IPersonSetSV;
import com.asiainfo.sale.common.service.interfaces.ISendSMSLogSV;
import com.asiainfo.sale.common.service.interfaces.ISendSmsSV;
import com.asiainfo.sendMessage.sendSms.SendMessage;
import com.asiainfo.sendmsg.SendMessage.SendMesg;
import com.asiainfo.task.dao.interfaces.ICurTaskDAO;
import com.asiainfo.task.dao.interfaces.IProxyPriveDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SendSmsSVImpl implements ISendSmsSV
{
  private static transient Log log = LogFactory.getLog(SendSmsSVImpl.class);
  private static Statement ps = null;
  private static Connection connection =null;
  
  public static void insert(String telphone,String sms){
	  String sql="insert into pt.websendsms(tele,msg,flag) values('"+telphone+"','"+sms+"','N')";
      try {
			connection = ConnectUtil.getConnection();
			ps=connection.createStatement();
			ps.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ConnectUtil.releaseConnection(connection);
				if (ps != null)
					ps.close();
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
  }

	/**
	 * 说明：处理流程节点时发送短信 参数： task_id：任务ID send_staff_id:发送人ID next_staff_id:接收人ID
	 **/
  public void sendSms(String task_id, String send_staff_id, String next_staff_id)
  {
    if (next_staff_id.isEmpty()) {
      return;
    }
    String[] sendStaffs = send_staff_id.split(";");
    if (sendStaffs.length > 1) {
      send_staff_id = sendStaffs[0];
    }

    log.debug("####sendSms####task_id=" + task_id + "~send_staff_id=" + 
      send_staff_id + "~next_staff_id=" + next_staff_id);
    try
    {
    // 获取工单类型
      String recordType = getObjectType(task_id);

      log.debug("####sendSms####recordType=" + recordType);
   // 获取工单ID
      String recordId = getObjectId(task_id);
      log.debug("####sendSms####recordId=" + recordId);
   // 获取短信信息
      String sms = makeSms(recordType, recordId);
      log.debug("####sendSms####sms=" + sms);
   // 分解next_staff_id
      String[] nextstaffStr = next_staff_id.split(";");
   // 获取代理人
      ICurTaskDAO curTaskDAO = (ICurTaskDAO)
        ServiceFactory.getService(ICurTaskDAO.class);
   // 获取需要发短信的人员列表，设置了代理人的，只发代理人
      StringBuffer smsStaff = new StringBuffer();
   // 流程下一步操作人
      String[] nextStaff = next_staff_id.split(";");
      for (int i = 0; i < nextStaff.length; ++i) {
        String proxyStaff = curTaskDAO.getProxyStaff(nextStaff[i]);
        if (proxyStaff != "-1") {
          smsStaff.append(proxyStaff);
          smsStaff.append(";");
        } else {
          smsStaff.append(nextStaff[i]);
          smsStaff.append(";");
        }

      }
   // 解析smsStaff为数组,smsStaff都需要发送短信
      String[] sms_staffs = smsStaff.toString().split(";");
      IPersonSetSV personSetSV = (IPersonSetSV)
        ServiceFactory.getService(IPersonSetSV.class);
      for (int i = 0; i < sms_staffs.length; ++i)
      {
    	// 逻辑判断是否接收发送短信
		// if(personSetSV.isReceiveSMS(Integer.valueOf(next_staffs[i]).intValue())){
		// 获取员工手机号
        String telphone = getTelphone(sms_staffs[i]);
        log.debug("####sendSms####telphone=" + telphone);
     // 发送短信
        //SendMesg.sendmsg(telphone,sms);
        //SendMessage.sendMessage(telphone, sms);
        log.debug("####SendMessage.sendMessage####telphone=" + telphone +  "~sms" + sms);
     // 保存短信日志
        ((ISendSMSLogSV)ServiceFactory.getService(ISendSMSLogSV.class))
          .savaSendSMSLog(task_id, Integer.valueOf(send_staff_id)
          .intValue(), Integer.valueOf(sms_staffs[i])
          .intValue(), sms);
        
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  /**
	 * 说明：创建流程时发送短信 参数： objectType：工单类型 wid:工单ID send_staff_id:发送人ID
	 * next_staff_id:接收人ID
	 **/
  public void sendSms(String objectType, String wid, String send_staff_id, String next_staff_id)
    throws Exception
  {
    if (next_staff_id.isEmpty()) {
      return;
    }
    String[] sendStaffs = send_staff_id.split(";");
    if (sendStaffs.length > 1) {
      send_staff_id = sendStaffs[0];
    }

    log.debug("####sendSms####objectType=" + objectType + "~wid=" + wid + 
      "~send_staff_id=" + send_staff_id + "~next_staff_id=" + 
      next_staff_id);
 // 获取短信信息
    String sms = makeSms(objectType, wid);
    log.debug("####sendSms####sms=" + sms);
 // 分解next_staff_id
    String[] nextstaffStr = next_staff_id.split(";");
 // 获取代理人
    ICurTaskDAO curTaskDAO = (ICurTaskDAO)
      ServiceFactory.getService(ICurTaskDAO.class);
 // 获取需要发短信的人员列表，设置了代理人的，只发代理人
    StringBuffer smsStaff = new StringBuffer();
 // 流程下一步操作人
    String[] nextStaff = next_staff_id.split(";");
    for (int i = 0; i < nextStaff.length; ++i) {
      String proxyStaff = curTaskDAO.getProxyStaff(nextStaff[i]);
      if (proxyStaff != "-1") {
        smsStaff.append(proxyStaff);
        smsStaff.append(";");
      } else {
        smsStaff.append(nextStaff[i]);
        smsStaff.append(";");
      }
    }

    ISendSMSLogSV sendSMSLogSV = (ISendSMSLogSV)
      ServiceFactory.getService(ISendSMSLogSV.class);
    IPersonSetSV personSetSV = (IPersonSetSV)
      ServiceFactory.getService(IPersonSetSV.class);
 // 解析smsStaff为数组,smsStaff都需要发送短信
    String[] sms_staffs = smsStaff.toString().split(";");
    for (int i = 0; i < sms_staffs.length; ++i)
    {
    	// 逻辑判断是否发送短信
		// if(personSetSV.isReceiveSMS(Integer.valueOf(next_staffs[i]).intValue())){
      log.debug("####sendSms####personSetSV.isReceiveSMS true");
   // 获取员工手机号
      String telphone = getTelphone(sms_staffs[i]);
   // 发送短信
      //SendMesg.sendmsg(telphone,sms);
      //SendMessage.sendMessage(telphone, sms);
      log.debug("####SendMessage.sendMessage####telphone=" + telphone + 
        "~sms" + sms);
   // 保存短信日志
      sendSMSLogSV
        .savaSendSMSLog(wid, Integer.valueOf(send_staff_id)
        .intValue(), Integer.valueOf(sms_staffs[i])
        .intValue(), sms);

      log.debug("####sendSms####personSetSV.isReceiveSMS false");
    }
  }
	/**
	 * 说明：发送知会协办短信 参数： objectType：工单类型 wid:工单ID send_staff_id:发送人ID
	 * next_staff_id:接收人ID
	 **/// 获取短信信息
  public void sendSmsZH(String objectType, String wid, String send_staff_id, String next_staff_id)
    throws Exception
  {
    if (next_staff_id.isEmpty()) {
      return;
    }

    String[] sendStaffs = send_staff_id.split(";");
    if (sendStaffs.length > 1) {
      send_staff_id = sendStaffs[0];
    }
    log.debug("####sendSms####objectType=" + objectType + "~wid=" + wid + 
      "~send_staff_id=" + send_staff_id + "~next_staff_id=" + 
      next_staff_id);
 // 获取短信信息
    String sms = makeSmsZH(objectType, wid);
    log.debug("####sendSms####sms=" + sms);
 // 获取代理人
    ICurTaskDAO curTaskDAO = (ICurTaskDAO)
      ServiceFactory.getService(ICurTaskDAO.class);
 // 获取需要发短信的人员列表，设置了代理人的，只发代理人
    StringBuffer smsStaff = new StringBuffer();
 // 流程下一步操作人
    String[] nextStaff = next_staff_id.split(";");
    for (int i = 0; i < nextStaff.length; ++i) {
      String proxyStaff = curTaskDAO.getProxyStaff(nextStaff[i]);
      if (proxyStaff != "-1") {
        smsStaff.append(proxyStaff);
        smsStaff.append(";");
      } else {
        smsStaff.append(nextStaff[i]);
        smsStaff.append(";");
      }
    }

    ISendSMSLogSV sendSMSLogSV = (ISendSMSLogSV)
      ServiceFactory.getService(ISendSMSLogSV.class);
    IPersonSetSV personSetSV = (IPersonSetSV)
      ServiceFactory.getService(IPersonSetSV.class);
	// 解析smsStaff为数组,smsStaff都需要发送短信
    String[] sms_staffs = smsStaff.toString().split(";");
    for (int i = 0; i < sms_staffs.length; ++i)
    {	// 逻辑判断是否发送短信
		// if(personSetSV.isReceiveSMS(Integer.valueOf(next_staffs[i]).intValue())){
      log.debug("####sendSms####personSetSV.isReceiveSMS true");
   // 获取员工手机号
      String telphone = getTelphone(sms_staffs[i]);
   // 发送短信
      //SendMesg.sendmsg(telphone,sms);
      //SendMessage.sendMessage(telphone, sms);
      log.debug("####SendMessage.sendMessage####telphone=" + telphone + 
        "~sms" + sms);
   // 保存短信日志
      sendSMSLogSV
        .savaSendSMSLog(wid, Integer.valueOf(send_staff_id)
        .intValue(), Integer.valueOf(sms_staffs[i])
        .intValue(), sms);

      log.debug("####sendSms####personSetSV.isReceiveSMS false");
    }
  }
  
	/**
	 * 说明：发送工单审批结束短信 参数： objectType：工单类型 wid:工单ID send_staff_id:发送人ID
	 * next_staff_id:接收人ID
	 **/
  public void sendSmsOver(String objectType, String wid, String send_staff_id, String next_staff_id)
    throws Exception
  {
    if (next_staff_id.isEmpty()) {
      return;
    }
    String[] sendStaffs = send_staff_id.split(";");
    if (sendStaffs.length > 1) {
      send_staff_id = sendStaffs[0];
    }

    log.debug("####sendSms####objectType=" + objectType + "~wid=" + wid + 
      "~send_staff_id=" + send_staff_id + "~next_staff_id=" + 
      next_staff_id);
 // 获取短信信息
    String sms = makeSmsOver(objectType, wid);
    log.debug("####sendSms####sms=" + sms);
	// 获取代理人
    ICurTaskDAO curTaskDAO = (ICurTaskDAO)
      ServiceFactory.getService(ICurTaskDAO.class);
 // 获取需要发短信的人员列表，设置了代理人的，只发代理人
    StringBuffer smsStaff = new StringBuffer();
	// 流程下一步操作人
    String[] nextStaff = next_staff_id.split(";");
    for (int i = 0; i < nextStaff.length; ++i) {
      String proxyStaff = curTaskDAO.getProxyStaff(nextStaff[i]);
      if (proxyStaff != "-1") {
        smsStaff.append(proxyStaff);
        smsStaff.append(";");
      } else {
        smsStaff.append(nextStaff[i]);
        smsStaff.append(";");
      }
    }

    ISendSMSLogSV sendSMSLogSV = (ISendSMSLogSV)
      ServiceFactory.getService(ISendSMSLogSV.class);
 // 解析smsStaff为数组,smsStaff都需要发送短信
    String[] sms_staffs = smsStaff.toString().split(";");
    for (int i = 0; i < sms_staffs.length; ++i)
    {// 逻辑判断是否发送短信
		// if(personSetSV.isReceiveSMS(Integer.valueOf(next_staffs[i]).intValue())){
      log.debug("####sendSms####personSetSV.isReceiveSMS true");
   // 获取员工手机号
      String telphone = getTelphone(sms_staffs[i]);

      log.debug("####SendMessage.sendMessage####telphone=" + telphone + 
        "~sms" + sms);
   // 发送短信
     // SendMesg.sendmsg(telphone,sms);
      //SendMessage.sendMessage(telphone, sms);
   // 保存短信日志
      sendSMSLogSV
        .savaSendSMSLog(wid, Integer.valueOf(send_staff_id)
        .intValue(), Integer.valueOf(sms_staffs[i])
        .intValue(), sms);

      log.debug("####sendSms####personSetSV.isReceiveSMS false");
    }
  }
	/**
	 * 说明：组合短信 参数： record_type：工单类型 wid:工单ID
	 **/
  public String makeSms(String record_type, String wid)
    throws Exception
  {
	// 工单信息
    IBOApplyInfoValue applyinfo = getApplyName(wid);
 // 组合短信
    StringBuffer sms = new StringBuffer();
    sms.append("【资费营销案平台提醒】您有新的待办/待阅" + applyinfo.getOrgname() + "工单《");
    if(applyinfo.getApplyName().length()>9){
    sms.append(applyinfo.getApplyName().substring(0, 10)+"...");
    }else{
    	sms.append(applyinfo.getApplyName());
    }
    sms.append("》，请您通过4A系统登录本平台进行操作。");

    return sms.toString();
  }
	/**
	 * 说明：流程结束短信 参数： record_type：工单类型 wid:工单ID
	 **/
  public String makeSmsOver(String record_type, String wid)
    throws Exception
  {
		// 工单信息
    IBOApplyInfoValue applyinfo = getApplyName(wid);
	// 组合短信
    StringBuffer sms = new StringBuffer();
    sms.append("【资费营销案平台提醒】您申请的工单《");
    if(applyinfo.getApplyName().length()>9){
        sms.append(applyinfo.getApplyName().substring(0, 10)+"...");
        }else{
        	sms.append(applyinfo.getApplyName());
        }
    sms.append("》，流程已经结束，请您通过4A系统登录本平台进行查看详情。");

    return sms.toString();
  }
	/**
	 * 说明：为知会协办组合短信 参数： record_type：工单类型 wid:工单ID
	 **/
  public String makeSmsZH(String record_type, String wid)
    throws Exception
  {
	// 工单信息
    IBOApplyInfoValue applyinfo = getApplyName(wid);
 // 组合短信
    StringBuffer sms = new StringBuffer();
    sms.append("【资费营销案平台提醒】您有新的协办/知会/发布" + applyinfo.getOrgname() + 
      "工单《");
    if(applyinfo.getApplyName().length()>9){
        sms.append(applyinfo.getApplyName().substring(0, 10)+"...");
        }else{
        	sms.append(applyinfo.getApplyName());
        }
    sms.append("》，请您通过4A系统登录本平台进行操作。");

    return sms.toString();
  }
	/**
	 * 说明：获取工单申请名 参数： wid:工单ID
	 **/
  public IBOApplyInfoValue getApplyName(String wid)
    throws Exception
  {
    ISendSmsDAO sendSmsDAO = (ISendSmsDAO)
      ServiceFactory.getService(ISendSmsDAO.class);
    IBOApplyInfoValue applyInfo = sendSmsDAO.getApplyName(wid);
    return applyInfo;
  }
	/**
	 * 说明：获取工单类型 参数： task_id:工单ID
	 **/
  public String getObjectType(String task_id)
    throws Exception
  {
    ISendSmsDAO sendSmsDAO = (ISendSmsDAO)
      ServiceFactory.getService(ISendSmsDAO.class);
    String objectType = sendSmsDAO.getObjectType(task_id);
    return objectType;
  }
	/**
	 * 说明：获取工单ID 参数： task_id:任务ID
	 * */
  public String getObjectId(String task_id)
    throws Exception
  {
    ISendSmsDAO sendSmsDAO = (ISendSmsDAO)
      ServiceFactory.getService(ISendSmsDAO.class);
    String objectId = sendSmsDAO.getObjectId(task_id);
    return objectId;
  }
	/**
	 * 说明：手机号 参数： operator_id:操作员ID
	 **/
  public String getTelphone(String operator_id)
    throws Exception
  {
    ISendSmsDAO sendSmsDAO = (ISendSmsDAO)
      ServiceFactory.getService(ISendSmsDAO.class);
    String telphones = sendSmsDAO.getTelphone(operator_id);
    return telphones;
  }
	/**
	 * 说明：判断当前人员是否有代理人，如果没有则发短信，如果有，则取代理人发短信 参数： staffId:接收人ID
	 * send_staff_id：发送人ID sms:短信内容 task_id： 任务ID
	 **/
  public void sendToProxy(String send_staff_id, String staffId, IProxyPriveDAO proxyPrive, String sms, String task_id)
    throws Exception
  {
		// 取代理人
    List staffTmp = proxyPrive.getProxyStaff(staffId);
    if (staffTmp.size() > 0) {
      Iterator ite = staffTmp.iterator();
      while (ite.hasNext()) {
        sendToProxy(send_staff_id, (String)ite.next(), proxyPrive, 
          sms, task_id);
      }
    }
    else
    {// 获取员工手机号
      String telphone = getTelphone(staffId);
      log.debug("####sendSms####telphone=" + telphone);
   // 发送短信
      //SendMesg.sendmsg(telphone,sms);
      //SendMessage.sendMessage(telphone, sms);
      log.debug("####SendMessage.sendMessage####telphone=" + telphone + 
        "~sms" + sms + "sender:" + send_staff_id + "receiver:" + 
        staffId + "taskId:" + task_id);
   // 保存短信日志
      ((ISendSMSLogSV)ServiceFactory.getService(ISendSMSLogSV.class))
        .savaSendSMSLog(task_id, Integer.valueOf(send_staff_id)
        .intValue(), Integer.valueOf(staffId).intValue(), 
        sms);
    }
  }
}