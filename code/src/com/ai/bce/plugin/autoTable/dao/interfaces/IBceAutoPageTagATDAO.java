package com.ai.bce.plugin.autoTable.dao.interfaces;

import com.ai.bce.plugin.autoTable.bo.BceTagPAutotableAttrBean;
import com.ai.bce.plugin.autoTable.bo.BceTagPAutotableBean;

public interface IBceAutoPageTagATDAO {

	BceTagPAutotableBean getATableByObjId(long objId) throws Exception;

	BceTagPAutotableAttrBean[] getATableAttrByTbId(long id) throws Exception;

}
