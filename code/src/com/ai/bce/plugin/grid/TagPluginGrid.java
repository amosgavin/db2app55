package com.ai.bce.plugin.grid;

import org.apache.commons.lang.StringUtils;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.bce.bo.BceViewObjectBean;
import com.ai.bce.plugin.AbstractTagPlugin;
import com.ai.bce.plugin.grid.ivalues.IBceTagPGridFieldValue;
import com.ai.bce.plugin.grid.ivalues.IBceTagPGridValue;
import com.ai.bce.plugin.grid.service.interfaces.IBceTagPGridSV;
import com.ai.bce.util.BceException;

public class TagPluginGrid extends AbstractTagPlugin{
	public IBceTagPGridSV getService(){
		return (IBceTagPGridSV)ServiceFactory.getService(IBceTagPGridSV.class);
	}
	
	private String gridManager = "";

	public String display(BceViewObjectBean viewObjectBean, int pageframeId, String template_id) throws Exception {
		long objectId = viewObjectBean.getObjectId();
		IBceTagPGridValue grid = getService().getBceTagPGrid(objectId);
		if(grid == null || grid.isNew()){
			throw new BceException("BES0000415",new Object[]{String.valueOf(objectId)});
		}
		IBceTagPGridFieldValue[] fields = getService().getBceTagPGridField(objectId);

		String gridId = grid.getGridId();
		gridManager = gridId + "Manager()";
		displayBuffer.append("<ai:table tableid=\"").append(gridId)
		  .append("\" setname=\"").append(grid.getSetName()).append("\"\r\n");
		if(StringUtils.isNotBlank(grid.getDataModel())){
			displayBuffer.append(" tablemodel=\"").append(grid.getDataModel()).append("\"\r\n");
		}
		if(StringUtils.isNotBlank(grid.getServiceName())){
			displayBuffer.append(" implservice_name=\"").append(grid.getServiceName()).append("\"\r\n");
		}
		if(StringUtils.isNotBlank(grid.getQueryMethod())){
			displayBuffer.append(" implservice_querymethod=\"").append(grid.getQueryMethod()).append("\"\r\n");
		}
		if(StringUtils.isNotBlank(grid.getCountMethod())){
			displayBuffer.append(" implservice_countmethod=\"").append(grid.getCountMethod()).append("\"\r\n");
		}
		if(StringUtils.isNotBlank(grid.getMo())){
			displayBuffer.append(" mo=\"").append(grid.getMo()).append("\" ");
		}
		if(StringUtils.isNotBlank(grid.getOperator())){
			displayBuffer.append(" operator=\"").append(grid.getOperator()).append("\"\r\n");
		}
		displayBuffer.append(" needrefresh=\"").append(grid.getNeedRefresh() == 1 ? "true":"false").append("\" ");
		displayBuffer.append(" multiselect=\"").append(grid.getMultSelect() == 1 ? "true":"false").append("\" ");
		displayBuffer.append(" footdisplay=\"").append(grid.getFootDisplay() == 1 ? "true":"false").append("\" ");
		if(grid.getPageSize() > 0){
			displayBuffer.append(" pagesize=\"").append(grid.getPageSize()).append("\"\r\n");
		}
		if(StringUtils.isNotBlank(grid.getWidth())){
			displayBuffer.append(" width=\"").append(grid.getWidth()).append("\" ");
		}
		if(StringUtils.isNotBlank(grid.getHeight())){
			displayBuffer.append(" height=\"").append(grid.getHeight()).append("\" ");
		}
		if(StringUtils.isNotBlank(grid.getRowHeight())){
			displayBuffer.append(" rowheight=\"").append(grid.getRowHeight()).append("\" ");
		}
		displayBuffer.append(" initial=\"").append(grid.getIsInitial() == 1 ? "true":"false").append("\" ");
		if(StringUtils.isNotBlank(grid.getConditionName())){
			displayBuffer.append(" conditionname=\"").append(grid.getConditionName()).append("\"\r\n");
		}
		displayBuffer.append(" editable=\"").append(grid.getEditable() == 1 ? "true":"false").append("\">\r\n");
		
		for(int i=0;i<fields.length;i++){
			displayBuffer.append("  <ai:col fieldname=\"").append(fields[i].getFieldName()).append("\" ")
			  .append("visible=\"").append(fields[i].getVisible() == 1 ? "true":"false").append("\" ")
			  .append("editable=\"").append(fields[i].getEditable() == 1 ? "true":"false").append("\" ");
			if(StringUtils.isNotBlank(fields[i].getWidth())){
				displayBuffer.append(" width=\"").append(fields[i].getWidth()).append("\" ");
			}
			if(StringUtils.isNotBlank(fields[i].getEditType())){
				displayBuffer.append(" edittype=\"").append(fields[i].getEditType()).append("\" ");
			}
			if(StringUtils.isNotBlank(fields[i].getTitleI18n())){
				displayBuffer.append(" i18nRes=\"CRM\" title=\"").append(fields[i].getTitleI18n()).append("\" ");
			}
			else if(StringUtils.isNotBlank(fields[i].getTitle())){
				displayBuffer.append(" title=\"").append(fields[i].getTitle()).append("\" ");
			}
			displayBuffer.append("/>\r\n");
		}
		
		displayBuffer.append("</ai:table>\r\n");
		
		//js
		displayBuffer.append("<script language=\"javascript\">\r\n")
    .append("function " + gridManager + "{\r\n")
    .append("  return g_TableRowSetManager.get(\""+gridId+"\");\r\n}\r\n");

		displayBuffer.append("function " + gridId + "Validate(){\r\n");
		displayBuffer.append("  return true;\r\n}\r\n");
		
		displayBuffer.append("</script>");
		return displayBuffer.toString();
	}

}
