package com.ai.comframe.test;

import com.ai.appframe2.web.BaseServer;

import com.ai.appframe2.complex.secframe.CenterUserManagerImpl;
import com.ai.appframe2.complex.secframe.CenterUserManagerImpl;
import com.ai.secframe.common.service.impl.SecLoginSVImpl;
import com.ai.secframe.common.util.SecframePropertisInfo;
import com.ai.secframe.orgmodel.bussiness.interfaces.IPassword;

public class password {
	
	public static void main(String[] args)throws Exception{
	      IPassword ipass = (IPassword)Class.forName(SecframePropertisInfo.PASSWORD_IMPL).newInstance();
	      String p = ipass.getPassword("111");
		  System.out.println(p);
		
	}

}
