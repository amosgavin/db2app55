package com.ai.comframe.test;

import com.ai.appframe2.complex.center.CenterFactory;
import com.ai.appframe2.complex.center.CenterInfo;
import com.ai.comframe.client.ComframeClient;
import com.ai.comframe.vm.common.Constant;

public class DropWorkFlow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 String[] wid = new String[]{
				 
				 "HB^571^000000000000000248",
				 "HB^571^000000000000000249",
				 "HB^571^000000000000000250",
				 "HB^571^000000000000000251",
				 "HB^571^000000000000000252",
				 "HB^571^000000000000000253",
				 "HB^571^000000000000000254",
				 "HB^571^000000000000000255",
				 "HB^571^000000000000000256"}; 
		try {
			for(int i=0;i<wid.length;i++){
				ComframeClient.dropWorkflow(wid[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

