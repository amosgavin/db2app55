package com.asiainfo.sale.tag.service.interfaces;

import com.asiainfo.sale.tag.ivalues.IBOApplyTagValue;

public interface ITagMainSV {

	public int saveTagMain(IBOApplyTagValue tagMainValues) throws Exception,
			RuntimeException;

	public IBOApplyTagValue getTagMainShowById(String id) throws Exception,
			RuntimeException;
	
	public IBOApplyTagValue[] getMainTagShowByTaskTag(String taskTag) throws Exception;
}