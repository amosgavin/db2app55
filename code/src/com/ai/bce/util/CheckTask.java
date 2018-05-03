package com.ai.bce.util;

import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CheckTask extends TimerTask {

	public static transient Log log = LogFactory.getLog(CheckTask.class);
	public static boolean isUse = false;

	public void run() {
		Thread.currentThread().setName(LocaleResourceFactory.getResource("BES0000853"));
		if (log.isInfoEnabled()) {
			log.info(LocaleResourceFactory.getResource("BES0000854"));
		}
		try {
			BceCommonStore.removeAllNotUseCache();
		} catch (Exception e) {
		}
		if (log.isInfoEnabled()) {
			log.info(LocaleResourceFactory.getResource("BES0000855"));
		}
	}

	public static void main(String[] args) {
		if(!isUse){
			if(log.isErrorEnabled()){
				log.error("[Check线程未启动：如需启动，]，请修改配置文件");
			}
		}
		if (isUse) {
			Timer timer = new Timer();
			timer.schedule(new CheckTask(),10, 60*1000);
			isUse = true;
		}
	}
}
