package com.ai.bce.configtool.model.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author linzhaoming
 *
 */
public class ServiceModel {
	
	private String name;
	private String filePath;	//文件实际路径
	private String path;		//显示路径
	private boolean isDirectory;
	
	private ServiceModel parent;	
	private List children = new ArrayList();
	
	public ServiceModel(ServiceModel parent){
		this.parent = parent;
		this.children = new ArrayList();
		if(parent != null){
			parent.addChild(this);
		}
	}
	
	public void addChild(ServiceModel child){
		children.add(child);
	}
	
	public List getChildren() {
		return children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getDisplayPath() {
		return path;
	}

	public void setDisplayPath(String path) {
		this.path = path;
	}	
	
	public boolean isDirectory() {
		return isDirectory;
	}

	public void setDirectory(boolean isDirectory) {
		this.isDirectory = isDirectory;
	}
	
	public ServiceModel getParent() {
		return parent;
	}

	public boolean isLeaf(){
		return (parent != null && children.size() == 0);
	}
	
	public String toString() {
		return (isDirectory?"D":"F") + " " + path;
	}
}
