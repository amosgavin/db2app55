package com.ai.bce.valuebean.chartnode;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成树形的数据结构体定义类
 * @author akuei
 *
 */
public class ChartNode {

	private String id;
	private String parentId;
	private String name;
	private String link;
	private String nodeType;
	private String state;
	private String showTip;
	
	private String textType = "H"; //文字方向， V 垂直 H 水平， 默认为水平
	
	//第二主键，与id形成联合组键
	private String secondId;
	
	private List childList;


	/**
	 * 将NODE变成HTML语句
	 * @param resultBuffer 结果HTML内容
	 * @param parentNodeId 父节点的HTML上的节点ID
	 * @param orderNum 该节点在兄弟节点中的序号
	 * 
	 * @return
	 */
	public void toString(StringBuffer resultBuffer ,String parentNodeId  ,int orderNum){
		//生成自身内容
		String selfHTMLNodeKey = parentNodeId +"_" + orderNum +"_"+ this.getId() ;
		if(this.getSecondId() != null){
			selfHTMLNodeKey = selfHTMLNodeKey +"_"+this.getSecondId();
		}
		if(this.getName() ==null){
			this.setName("");
		}
		
		resultBuffer.append("var " + selfHTMLNodeKey +" = new OrgNode(); \n");
		resultBuffer.append(selfHTMLNodeKey +".id = '" + selfHTMLNodeKey +"'; \n");
		resultBuffer.append(selfHTMLNodeKey +".Text = '" + this.getName() +"'; \n");
		resultBuffer.append(selfHTMLNodeKey +".state = '" + this.getState() +"'; \n");
		resultBuffer.append(selfHTMLNodeKey +".nodeType = '" + this.getNodeType() +"'; \n");
		resultBuffer.append(selfHTMLNodeKey +".link = '" + this.getLink() +"'; \n");

		String title = this.getShowTip();
		if(title == null || "".equals(title)){
			title = this.getName().replaceAll("<br>", "\\\\n");
		}
		resultBuffer.append(selfHTMLNodeKey +".Description = '" + title +"'; \n");
		
		if(parentNodeId != null && parentNodeId.equals("") == false){
			resultBuffer.append(parentNodeId + ".Nodes.Add(" + selfHTMLNodeKey + ");\n");
		}
		resultBuffer.append("\n");
		
		//如果没有子节点，则返回
		if(childList == null || childList.size() ==0){
			return;
		}
		
		//生成子节点HTML内容
		for(int i=0;i<childList.size();i++){
			((ChartNode)childList.get(i)).toString(resultBuffer ,selfHTMLNodeKey ,i);
		}
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	//添加子节点
	public void addChidNode(ChartNode childNode){
		if(childList == null){
			childList = new ArrayList();
		}
		
		childList.add(childNode);
	}
	

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	
	public static void main(String[] args) {
		ChartNode root = new ChartNode();
		root.setId("root");
		
		ChartNode child1 = new ChartNode();
		child1.setId("child1");
		root.addChidNode(child1);
		
		ChartNode child2 = new ChartNode();
		child2.setId("child2");
		root.addChidNode(child2);
		

		ChartNode sun = new ChartNode();
		sun.setId("sun");
		child1.addChidNode(sun);
		child2.addChidNode(sun);
		
		StringBuffer sb = new StringBuffer();
		root.toString(sb ,"" ,0);
		System.out.println(sb);
	}

	public String getSecondId() {
		return secondId;
	}

	public void setSecondId(String secondId) {
		this.secondId = secondId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getShowTip() {
		return showTip;
	}

	public void setShowTip(String showTip) {
		this.showTip = showTip;
	}

	public String getTextType() {
		return textType;
	}

	public void setTextTypeV() {
		this.textType = "V";
	}
	public void setTextTypeH() {
		this.textType = "H";
	}
}
