/**
 * 
 */
package com.asiainfo.sale.activity.dao.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOResourceChangeDetailValue;

public interface IResourceChangeDetailDAO {


	public IBOResourceChangeDetailValue getResourceChangeDetailByID(
			int resourceId) throws Exception;

	public int saveResourceChangeDetail(IBOResourceChangeDetailValue resourceChangeDetailValue) throws Exception;

}
