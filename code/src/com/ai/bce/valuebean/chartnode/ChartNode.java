package com.ai.bce.valuebean.chartnode;

import java.util.ArrayList;
import java.util.List;

/**
 * �������ε����ݽṹ�嶨����
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
	
	private String textType = "H"; //���ַ��� V ��ֱ H ˮƽ�� Ĭ��Ϊˮƽ
	
	//�ڶ���������id�γ��������
	private String secondId;
	
	private List childList;


	/**
	 * ��NODE���HTML���
	 * @param resultBuffer ���HTML����
	 * @param parentNodeId ���ڵ��HTML�ϵĽڵ�ID
	 * @param orderNum �ýڵ����ֵܽڵ��е����
	 * 
	 * @return
	 */
	public void toString(StringBuffer resultBuffer ,String parentNodeId  ,int orderNum){
		//������������
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
		
		//���û���ӽڵ㣬�򷵻�
		if(childList == null || childList.size() ==0){
			return;
		}
		
		//�����ӽڵ�HTML����
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
	
	//����ӽڵ�
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
