package com.asiainfo.sale.common.dao.impl;

import java.sql.Timestamp;
import java.util.HashMap;

import com.asiainfo.sale.common.bo.BOAnnounceInfoEngine;
import com.asiainfo.sale.common.ivalues.IBOAnnounceInfoValue;
import com.asiainfo.sale.common.bo.BOAnnounceInfoBean;
import com.asiainfo.sale.common.dao.interfaces.IAnnounceInfoDAO;

public class AnnounceInfoDAOImpl implements IAnnounceInfoDAO {
	
	public String saveAnnounceInfo(IBOAnnounceInfoValue announceInfoValue)throws Exception{
		String id = "";
		Timestamp tamp = new Timestamp(System.currentTimeMillis());
		if(announceInfoValue.isNew()&&0>=announceInfoValue.getId()){
			announceInfoValue.setId(BOAnnounceInfoEngine.getNewId().intValue());
			announceInfoValue.setFlag("1");
		}
		announceInfoValue.setCreateTime(tamp);
		BOAnnounceInfoEngine.save(announceInfoValue);
		return String.valueOf(announceInfoValue.getId()); 
	}

	public IBOAnnounceInfoValue[] getAnnounceInfos(String title,String apply_time,String create_time,String flag)throws Exception{
		StringBuffer condition = new StringBuffer();
		condition.append(" 1=1 ");
		HashMap<String,String> parameter = new HashMap<String,String>();
        if(!title.trim().isEmpty()){
        	condition.append(" and TITLE like '%"+title+"%'");
        }
        if(!apply_time.trim().isEmpty()){
        	condition.append(" and create_time >=:btime");
        	parameter.put("btime", apply_time);
        }
        if(!create_time.trim().isEmpty()){
        	condition.append(" and create_time <=:etime");
        	parameter.put("etime", create_time);
        }
        if(!flag.trim().isEmpty()){
        	condition.append(" and flag =:aflag");
        	parameter.put("aflag", flag);
        }
		return BOAnnounceInfoEngine.getBeans(condition.toString() + " order by create_time desc ", parameter);
	}
	
	public IBOAnnounceInfoValue getAnnounceInfoById(String id)throws Exception{
		return BOAnnounceInfoEngine.getBean(Integer.valueOf(id).intValue());
	}
	
	public void applyAnnounceInfo(String id)throws Exception{
		//首先将当前发布的公告信息，取消公告，系统中每次只有一条发布信息
		StringBuffer condition = new StringBuffer();
		HashMap<String,String> parameter = new HashMap<String,String>();
		Timestamp tamp = new Timestamp(System.currentTimeMillis());
		condition.append(" 1=1 and flag = '2' ");
		BOAnnounceInfoBean announceInfoTmp = null;
		BOAnnounceInfoBean[]  announceInfos = BOAnnounceInfoEngine.getBeans(condition.toString(), parameter);
		if(announceInfos.length>0){
			announceInfoTmp = announceInfos[0];
			announceInfoTmp.setFlag("3");
			announceInfoTmp.setCancelTime(tamp);
		}
		if(announceInfoTmp != null){
			BOAnnounceInfoEngine.save(announceInfoTmp);
		}
	
		BOAnnounceInfoBean announceInfoBean = BOAnnounceInfoEngine.getBean(Integer.valueOf(id).intValue());
		announceInfoBean.setFlag("2");
		announceInfoBean.setApplyTime(tamp);
		BOAnnounceInfoEngine.save(announceInfoBean);
	}

	public void cancleAnnounceInfo(String id)throws Exception{
		Timestamp tamp = new Timestamp(System.currentTimeMillis());
		BOAnnounceInfoBean announceInfoBean = BOAnnounceInfoEngine.getBean(Integer.valueOf(id).intValue());
		announceInfoBean.setFlag("3");
		announceInfoBean.setCancelTime(tamp);
		BOAnnounceInfoEngine.save(announceInfoBean);
	}
	
	public String getCurrentAnnounceInfo()throws Exception{
		StringBuffer condition = new StringBuffer();
		HashMap<String,String> parameter = new HashMap<String,String>();
		Timestamp tamp = new Timestamp(System.currentTimeMillis());
		condition.append(" 1=1 and flag = '2' ");
		BOAnnounceInfoBean announceInfoTmp = null;
		BOAnnounceInfoBean[]  announceInfos = BOAnnounceInfoEngine.getBeans(condition.toString(), parameter);
		if(announceInfos.length>0){
			announceInfoTmp = announceInfos[0];
		}else{
			return "";
		}
		String content = announceInfoTmp.getContent();
		return content;
	}
	
}
