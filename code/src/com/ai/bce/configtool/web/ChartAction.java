package com.ai.bce.configtool.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.ai.bce.configtool.service.interfaces.IChartSV;
import com.ai.bce.util.LocaleResourceFactory;
public class ChartAction extends BaseAction {
/**
 * 构造用于fusionchart的xmlstr
 * @param request
 * @param response
 * @throws Exception
 */
public void getXmlStrByModuleId(HttpServletRequest request,HttpServletResponse response) throws Exception{
	CustomProperty cp = CustomProperty.getInstance();
	long moduleId = HttpUtil.getAsLong(request, "moduleId");
	IChartSV chartSV = (IChartSV) ServiceFactory.getService(IChartSV.class);
	int frameCount = chartSV.getBceFramesCountByModuleId(moduleId);
	int pageFrameCount = chartSV.getBcePageFrameCountByModuleId(moduleId);
	int pageCount = chartSV.getBcePageCountByModuleId(moduleId);
	int rulesetCount = chartSV.getBceRuleSetCountByModuleId(moduleId);
	String xmlStr="";
	if(frameCount == -1 || pageFrameCount == -1 || pageCount == -1 || rulesetCount == -1){
		cp.set("flag", "false");
	}else{ 
		xmlStr = "<chart yAxisName='"+LocaleResourceFactory.getResource("BES0000820")+"' caption='"+LocaleResourceFactory.getResource("BES0000821")+"' useRoundEdges='1' showCanvasBg='0' canvasBaseDepth='0' chartBottomMargin='0' bgColor='FFFFFF,FFFFFF' showBorder='0'>";
		xmlStr += "<set label='"+LocaleResourceFactory.getResource("BES0000584")+"' value='"+frameCount+"' /> ";
		xmlStr+="<set label='"+LocaleResourceFactory.getResource("BES0000552")+"' value='"+pageFrameCount+"'  /> "; 
		xmlStr+="<set label='"+LocaleResourceFactory.getResource("BES0000554")+"' value='"+pageCount+"' /> ";
		xmlStr+="<set label='"+LocaleResourceFactory.getResource("BES0000555")+"' value='"+rulesetCount+"' /> ";
		xmlStr+="</chart>";
	}
		cp.set("flag", "true");
		cp.set("xmlStr", xmlStr);
		HttpUtil.showInfo(response, cp);
}

}
