package com.ai.bce.plugin.autoTable.service.interfaces;

import com.ai.bce.plugin.autoTable.bo.BceTagPAutotableAttrBean;
import com.ai.bce.plugin.autoTable.bo.BceTagPAutotableBean;


public interface IBceAutoPageTagATSV {

	BceTagPAutotableBean getATableByObjId(long id) throws Exception;

	BceTagPAutotableAttrBean[] getATableAttrByTbId(long id) throws Exception;

}
