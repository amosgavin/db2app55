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
 * DBTree��model
 * 
 * @author linzhaoming
 *
 */
public class WVMTreeModel implements DBTreeNewDataModelInterface {

	private static transient Log log = LogFactory.getLog(WVMTreeModel.class);

	/** ����classesĿ¼����ķ���ӿ� */
	private Map allServices = null;

	/**
	 * ���ظ��ڵ���Ϣ
	 */
	public AIDBTreeNodeInterface getRootNode() {
		AIDBTreeNode node = null;
		try {
			// ���ø��ڵ���Ϣ
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
	 * ��ʼ��
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
			// ѭ����ӽڵ�
			if(parentValue.equals("1")){
				ServiceModel model = WVMHandler.rootmodel;
				AIDBTreeNode node = new AIDBTreeNode();
				node.setLabel(model.getName());
				node.setValue("D");
				node.setUserObj(model.getFilePath());	//Ŀ¼
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
