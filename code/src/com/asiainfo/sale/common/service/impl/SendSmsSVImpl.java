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
	 * ˵�����������̽ڵ�ʱ���Ͷ��� ������ task_id������ID send_staff_id:������ID next_staff_id:������ID
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
    // ��ȡ��������
      String recordType = getObjectType(task_id);

      log.debug("####sendSms####recordType=" + recordType);
   // ��ȡ����ID
      String recordId = getObjectId(task_id);
      log.debug("####sendSms####recordId=" + recordId);
   // ��ȡ������Ϣ
      String sms = makeSms(recordType, recordId);
      log.debug("####sendSms####sms=" + sms);
   // �ֽ�next_staff_id
      String[] nextstaffStr = next_staff_id.split(";");
   // ��ȡ������
      ICurTaskDAO curTaskDAO = (ICurTaskDAO)
        ServiceFactory.getService(ICurTaskDAO.class);
   // ��ȡ��Ҫ�����ŵ���Ա�б������˴����˵ģ�ֻ��������
      StringBuffer smsStaff = new StringBuffer();
   // ������һ��������
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
   // ����smsStaffΪ����,smsStaff����Ҫ���Ͷ���
      String[] sms_staffs = smsStaff.toString().split(";");
      IPersonSetSV personSetSV = (IPersonSetSV)
        ServiceFactory.getService(IPersonSetSV.class);
      for (int i = 0; i < sms_staffs.length; ++i)
      {
    	// �߼��ж��Ƿ���շ��Ͷ���
		// if(personSetSV.isReceiveSMS(Integer.valueOf(next_staffs[i]).intValue())){
		// ��ȡԱ���ֻ���
        String telphone = getTelphone(sms_staffs[i]);
        log.debug("####sendSms####telphone=" + telphone);
     // ���Ͷ���
        //SendMesg.sendmsg(telphone,sms);
        //SendMessage.sendMessage(telphone, sms);
        log.debug("####SendMessage.sendMessage####telphone=" + telphone +  "~sms" + sms);
     // ���������־
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
	 * ˵������������ʱ���Ͷ��� ������ objectType���������� wid:����ID send_staff_id:������ID
	 * next_staff_id:������ID
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
 // ��ȡ������Ϣ
    String sms = makeSms(objectType, wid);
    log.debug("####sendSms####sms=" + sms);
 // �ֽ�next_staff_id
    String[] nextstaffStr = next_staff_id.split(";");
 // ��ȡ������
    ICurTaskDAO curTaskDAO = (ICurTaskDAO)
      ServiceFactory.getService(ICurTaskDAO.class);
 // ��ȡ��Ҫ�����ŵ���Ա�б������˴����˵ģ�ֻ��������
    StringBuffer smsStaff = new StringBuffer();
 // ������һ��������
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
 // ����smsStaffΪ����,smsStaff����Ҫ���Ͷ���
    String[] sms_staffs = smsStaff.toString().split(";");
    for (int i = 0; i < sms_staffs.length; ++i)
    {
    	// �߼��ж��Ƿ��Ͷ���
		// if(personSetSV.isReceiveSMS(Integer.valueOf(next_staffs[i]).intValue())){
      log.debug("####sendSms####personSetSV.isReceiveSMS true");
   // ��ȡԱ���ֻ���
      String telphone = getTelphone(sms_staffs[i]);
   // ���Ͷ���
      //SendMesg.sendmsg(telphone,sms);
      //SendMessage.sendMessage(telphone, sms);
      log.debug("####SendMessage.sendMessage####telphone=" + telphone + 
        "~sms" + sms);
   // ���������־
      sendSMSLogSV
        .savaSendSMSLog(wid, Integer.valueOf(send_staff_id)
        .intValue(), Integer.valueOf(sms_staffs[i])
        .intValue(), sms);

      log.debug("####sendSms####personSetSV.isReceiveSMS false");
    }
  }
	/**
	 * ˵��������֪��Э����� ������ objectType���������� wid:����ID send_staff_id:������ID
	 * next_staff_id:������ID
	 **/// ��ȡ������Ϣ
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
 // ��ȡ������Ϣ
    String sms = makeSmsZH(objectType, wid);
    log.debug("####sendSms####sms=" + sms);
 // ��ȡ������
    ICurTaskDAO curTaskDAO = (ICurTaskDAO)
      ServiceFactory.getService(ICurTaskDAO.class);
 // ��ȡ��Ҫ�����ŵ���Ա�б������˴����˵ģ�ֻ��������
    StringBuffer smsStaff = new StringBuffer();
 // ������һ��������
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
	// ����smsStaffΪ����,smsStaff����Ҫ���Ͷ���
    String[] sms_staffs = smsStaff.toString().split(";");
    for (int i = 0; i < sms_staffs.length; ++i)
    {	// �߼��ж��Ƿ��Ͷ���
		// if(personSetSV.isReceiveSMS(Integer.valueOf(next_staffs[i]).intValue())){
      log.debug("####sendSms####personSetSV.isReceiveSMS true");
   // ��ȡԱ���ֻ���
      String telphone = getTelphone(sms_staffs[i]);
   // ���Ͷ���
      //SendMesg.sendmsg(telphone,sms);
      //SendMessage.sendMessage(telphone, sms);
      log.debug("####SendMessage.sendMessage####telphone=" + telphone + 
        "~sms" + sms);
   // ���������־
      sendSMSLogSV
        .savaSendSMSLog(wid, Integer.valueOf(send_staff_id)
        .intValue(), Integer.valueOf(sms_staffs[i])
        .intValue(), sms);

      log.debug("####sendSms####personSetSV.isReceiveSMS false");
    }
  }
  
	/**
	 * ˵�������͹��������������� ������ objectType���������� wid:����ID send_staff_id:������ID
	 * next_staff_id:������ID
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
 // ��ȡ������Ϣ
    String sms = makeSmsOver(objectType, wid);
    log.debug("####sendSms####sms=" + sms);
	// ��ȡ������
    ICurTaskDAO curTaskDAO = (ICurTaskDAO)
      ServiceFactory.getService(ICurTaskDAO.class);
 // ��ȡ��Ҫ�����ŵ���Ա�б������˴����˵ģ�ֻ��������
    StringBuffer smsStaff = new StringBuffer();
	// ������һ��������
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
 // ����smsStaffΪ����,smsStaff����Ҫ���Ͷ���
    String[] sms_staffs = smsStaff.toString().split(";");
    for (int i = 0; i < sms_staffs.length; ++i)
    {// �߼��ж��Ƿ��Ͷ���
		// if(personSetSV.isReceiveSMS(Integer.valueOf(next_staffs[i]).intValue())){
      log.debug("####sendSms####personSetSV.isReceiveSMS true");
   // ��ȡԱ���ֻ���
      String telphone = getTelphone(sms_staffs[i]);

      log.debug("####SendMessage.sendMessage####telphone=" + telphone + 
        "~sms" + sms);
   // ���Ͷ���
     // SendMesg.sendmsg(telphone,sms);
      //SendMessage.sendMessage(telphone, sms);
   // ���������־
      sendSMSLogSV
        .savaSendSMSLog(wid, Integer.valueOf(send_staff_id)
        .intValue(), Integer.valueOf(sms_staffs[i])
        .intValue(), sms);

      log.debug("####sendSms####personSetSV.isReceiveSMS false");
    }
  }
	/**
	 * ˵������϶��� ������ record_type���������� wid:����ID
	 **/
  public String makeSms(String record_type, String wid)
    throws Exception
  {
	// ������Ϣ
    IBOApplyInfoValue applyinfo = getApplyName(wid);
 // ��϶���
    StringBuffer sms = new StringBuffer();
    sms.append("���ʷ�Ӫ����ƽ̨���ѡ������µĴ���/����" + applyinfo.getOrgname() + "������");
    if(applyinfo.getApplyName().length()>9){
    sms.append(applyinfo.getApplyName().substring(0, 10)+"...");
    }else{
    	sms.append(applyinfo.getApplyName());
    }
    sms.append("��������ͨ��4Aϵͳ��¼��ƽ̨���в�����");

    return sms.toString();
  }
	/**
	 * ˵�������̽������� ������ record_type���������� wid:����ID
	 **/
  public String makeSmsOver(String record_type, String wid)
    throws Exception
  {
		// ������Ϣ
    IBOApplyInfoValue applyinfo = getApplyName(wid);
	// ��϶���
    StringBuffer sms = new StringBuffer();
    sms.append("���ʷ�Ӫ����ƽ̨���ѡ�������Ĺ�����");
    if(applyinfo.getApplyName().length()>9){
        sms.append(applyinfo.getApplyName().substring(0, 10)+"...");
        }else{
        	sms.append(applyinfo.getApplyName());
        }
    sms.append("���������Ѿ�����������ͨ��4Aϵͳ��¼��ƽ̨���в鿴���顣");

    return sms.toString();
  }
	/**
	 * ˵����Ϊ֪��Э����϶��� ������ record_type���������� wid:����ID
	 **/
  public String makeSmsZH(String record_type, String wid)
    throws Exception
  {
	// ������Ϣ
    IBOApplyInfoValue applyinfo = getApplyName(wid);
 // ��϶���
    StringBuffer sms = new StringBuffer();
    sms.append("���ʷ�Ӫ����ƽ̨���ѡ������µ�Э��/֪��/����" + applyinfo.getOrgname() + 
      "������");
    if(applyinfo.getApplyName().length()>9){
        sms.append(applyinfo.getApplyName().substring(0, 10)+"...");
        }else{
        	sms.append(applyinfo.getApplyName());
        }
    sms.append("��������ͨ��4Aϵͳ��¼��ƽ̨���в�����");

    return sms.toString();
  }
	/**
	 * ˵������ȡ���������� ������ wid:����ID
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
	 * ˵������ȡ�������� ������ task_id:����ID
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
	 * ˵������ȡ����ID ������ task_id:����ID
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
	 * ˵�����ֻ��� ������ operator_id:����ԱID
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
	 * ˵�����жϵ�ǰ��Ա�Ƿ��д����ˣ����û���򷢶��ţ�����У���ȡ�����˷����� ������ staffId:������ID
	 * send_staff_id��������ID sms:�������� task_id�� ����ID
	 **/
  public void sendToProxy(String send_staff_id, String staffId, IProxyPriveDAO proxyPrive, String sms, String task_id)
    throws Exception
  {
		// ȡ������
    List staffTmp = proxyPrive.getProxyStaff(staffId);
    if (staffTmp.size() > 0) {
      Iterator ite = staffTmp.iterator();
      while (ite.hasNext()) {
        sendToProxy(send_staff_id, (String)ite.next(), proxyPrive, 
          sms, task_id);
      }
    }
    else
    {// ��ȡԱ���ֻ���
      String telphone = getTelphone(staffId);
      log.debug("####sendSms####telphone=" + telphone);
   // ���Ͷ���
      //SendMesg.sendmsg(telphone,sms);
      //SendMessage.sendMessage(telphone, sms);
      log.debug("####SendMessage.sendMessage####telphone=" + telphone + 
        "~sms" + sms + "sender:" + send_staff_id + "receiver:" + 
        staffId + "taskId:" + task_id);
   // ���������־
      ((ISendSMSLogSV)ServiceFactory.getService(ISendSMSLogSV.class))
        .savaSendSMSLog(task_id, Integer.valueOf(send_staff_id)
        .intValue(), Integer.valueOf(staffId).intValue(), 
        sms);
    }
  }
}