package com.ai.comframe.client.agent;

import com.asiainfo.util.agent.ClientAgent;
import java.util.*;

public class testGetAllCurTaskByTag {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
	 try{	
		 list = ClientAgent.getAllCurTaskByTag("sign01", "tagCase", "5");
		 System.out.println(list.size()); 
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	}

}
