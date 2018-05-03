package com.ai.bce.configtool.model.wvm;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.web.tag.dbtree.AIDBTreeNode;
import com.ai.appframe2.web.tag.dbtree.AIDBTreeNodeInterface;
import com.ai.appframe2.web.tag.dbtree.DBTreeNewDataModelInterface;
import com.ai.bce.configtool.model.common.ServiceModel;

/**
 * DBTree的model
 * 
 * @author linzhaoming
 *
 */
public class WVMTreeModel implements DBTreeNewDataModelInterface {

	private static transient Log log = LogFactory.getLog(WVMTreeModel.class);

	/** 所有classes目录下面的服务接口 */
	private Map allServices = null;

	/**
	 * 加载根节点信息
	 */
	public AIDBTreeNodeInterface getRootNode() {
		AIDBTreeNode node = null;
		try {
			// 设置根节点信息
			node = new AIDBTreeNode();
			node.setValue("D");
			node.setUserObj("1");
			node.setLabel("WVM");
		} catch (Exception ex) {
			log.error(ex);
		}
		return node;
	}

	/**
	 * 初始化
	 */
	public void init(ServletRequest req) throws Exception {		
		if (allServices == null) {
			ServletContext context = SessionManager.getRequest().getSession().getServletContext();
			String dir = context.getRealPath("/WEB-INF/classes");
			File file = new File(dir);
			allServices = WVMHandler.getServiceMap(file);
		}
	}

	public void getChildren(AIDBTreeNodeInterface parentNode, int arg1) throws Exception {
		try {
			if (null == allServices || 0 == allServices.size()) {
				return;
			}
			String parentValue = parentNode.getUserObj();
			// 循环添加节点
			if(parentValue.equals("1")){
				ServiceModel model = WVMHandler.rootmodel;
				AIDBTreeNode node = new AIDBTreeNode();
				node.setLabel(model.getName());
				node.setValue("D");
				node.setUserObj(model.getFilePath());	//目录
				parentNode.addChild(node);
			}else if(allServices.containsKey(parentValue)){
				List list = (List)allServices.get(parentValue);
				for(int i=0; i<list.size(); i++){
					ServiceModel model = (ServiceModel)list.get(i);
					AIDBTreeNode node = new AIDBTreeNode();
					node.setLabel(model.getName());
					node.setUserObj(model.getFilePath());
					node.setLeaf(!model.isDirectory());
					if(model.isDirectory()){
						node.setValue("D");
					}else{
						node.setValue(model.getDisplayPath());
					}
					parentNode.addChild(node);
				}
			}
		} catch (Exception ex) {
			log.error(ex);
		}
	}
}
