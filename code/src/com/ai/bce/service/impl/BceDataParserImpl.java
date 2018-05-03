package com.ai.bce.service.impl;

import java.util.Map;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.bce.ivalues.IBceData;
import com.ai.bce.ivalues.INodeData;
import com.ai.bce.ivalues.INodeXmlData;
import com.ai.bce.ivalues.ISubmitData;
import com.ai.bce.service.interfaces.IBceDataParser;
import com.ai.bce.valuebean.BceDataBean;

public class BceDataParserImpl implements IBceDataParser{

	public IBceData dataParse(ISubmitData[] submitDatas, Map sessionMap) throws Exception {
		return _parse(null,submitDatas[0], sessionMap);
/*		for (int i = 0; i < submitDatas.length; i++) {
			_parse(submitDatas[i], sessionMap);
  	}*/
	}
	
	private IBceData _parse(IBceData parent,ISubmitData submitData,Map sessionMap)throws Exception {
		if(submitData == null){
  		return null;
  	}
		IBceData bceData = new BceDataBean();
		if(parent != null){
			parent.addSubData(bceData);
		}
		INodeData[] nodeInfos = submitData.getNodeDatas();
		if(nodeInfos != null && nodeInfos.length > 0){
			for (int j = 0; j < nodeInfos.length; j++) {
				String[][] userDatas = nodeInfos[j].getUserDatas();
				INodeXmlData[] dataInfo = nodeInfos[j].getNodeXmlDatas();
				ISubmitData[] childSubmitData = nodeInfos[j].getChildSubmitData();
				
				if(userDatas != null && userDatas.length > 0){
					for(int i=0;i<userDatas.length;i++){
						bceData.addUserData(userDatas[i][0],userDatas[i][1]);
					}
				}
				if(dataInfo != null && dataInfo.length > 0){
					for(int i=0;i<dataInfo.length;i++){
						DataContainerInterface[] dcs = dataInfo[i].getDataContainers();
						if(dcs == null || dcs.length == 0){
							continue;
						}
						String name = dataInfo[i].getName();
						bceData.addNormalRowsetInfo(name, dcs);
					}
				}
        if(childSubmitData != null && childSubmitData.length > 0){
          for(int i=0;i<childSubmitData.length;i++){
						_parse(bceData,childSubmitData[i],sessionMap);
					}
				}
			}
		}
		return bceData;
	}

}
