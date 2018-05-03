//----------------DBTree.js------------------
/*******************************************************************************
 *�ļ����ƣ�DBTree.js
 *    ˵������DataRow���ݼ������û��ṩ��treemodel����һ�ð�Ҫ��ֲ��html���νṹ

  ������
	tree��һ��javascript���������Ҫ�����ǽ���NormalRowSet���󣬶������ݹ���������ʾ��
	Ŀǰ����ģ���ṩ�Ѿ�����Ĭ�ϵ�treemodel��
	DBTreeModel,�����ʹ�ü�ͬ����.js�ļ�,ÿ��treemodel��Ҫʵ�����½ӿں���
�ӿ�˵��:
	1.this.getRootVal = function getRootVal()
	���ظ��ڵ��ֵ
	2.this.getRootText = function getRootText()
	���ظ��ڵ����ʾ�ı�
	3.this.getChildrenCount = function getChildrenCount(id)
	���ݸ��ڵ��ֵ,���ظø��׽ڵ�ĺ��Ӹ���
	4.this.getChildrenText = function getChildrenText(id)
	���ݸ��ڵ��ֵ,���ظø��׽ڵ�ĺ����ǵ���ʾ�ı�����
	5.this.getChildrenVal = function getChildrenVal(id)
	���ݸ��ڵ��ֵ,���ظø��׽ڵ�ĺ����ǵ���ʾֵ����
	ע:getChildrenText��getChildrenVal������ͬһ������id,���ص�ֵ���ı�Ӧ�����±�ͳһ��.

	6.this.getAllVals
	7.this.getAllTexts
    �õ����нڵ��valueֵ��text����
	8.this.getAllChildrenVals(id)
	�õ�ĳ��ָ���ڵ�����к��ӵ�����
	9.this.getText(id)
	����valueֵ�����ʾdisplayText�ı�

	ע��6,7,8�ӿں������ڶ�ѡ������������ֻ�ǵ�ѡ����ʾ��ֻ��Ҫ����null���ɡ�

����˵����
1.	���� var dbTree = new DBTree(model)
	����˵����
	����1��treeModel�ࡣ
2	��ʾtree��dbTree.displayTree();
	�޲���
3.  ����������ҳ��ʱ,ʹ��div.appendChild(dbTree.getUIObject());

4	��Ҷ�ӽڵ��Ƿ���Ӧ�¼�dbTree.setFolderEvent("true")
	���������ֻҪ��Ҷ�ӽڵ���Ӧ�¼�����������Ϊ"false"���ɡ�

5	�¼�˵����
	tree.addListener(S_OnChange,obj);���Ӽ����¼�
	tree.removeListener(S_OnChange,obj);ɾ�������¼�
6
    tree.getPathFromRoot();���ش�root����ǰѡ�нڵ��path·�����顣�������ǽڵ��ֵ

	tree.getRowSetRow();ѡ�нڵ��Ӧrowset�ĵڼ��У����ѡ�еĽڵ��Ƿ�Ҷ�ӽڵ㣬ֻ�ܷ��ظýڵ��һ���ӽڵ��Ӧ����

	tree.getCurNodeValue();�õ���ǰ����ڵ��value,

	tree.getCurNodeText() ;�õ���ǰ����ڵ��text,

	tree.setCurNodeValue(pValue)  ���õ�ǰ�ڵ��valueֵ

	tree.setCurNodeText(pText)   ���õ�ǰ�ڵ��displayTextֵ

	tree.getSelectedNodesValue();��ѡ״̬�µõ�ѡ�еĽڵ��value����

	tree.getSelectedNodesText(); ��ѡ״̬�µõ�ѡ�еĽڵ��text����

	tree.clearSelectedSts() ; ��ѡ״̬����յ�ǰ�ڵ㡣��ѡ״̬�²�����յ�ǰ�ڵ㣬���������checkbox��ѡ��״̬


	tree.setFolderEvent(boolean) �����Ƿ������Ҷ�ӽڵ���Ӧ�¼�

	tree.setRootEvent(boolean) �����Ƿ�������ڵ���Ӧ�¼�

	tree.setMultiSelectFlag(boolean) ���ö�ѡ��־

	tree.setMultiRecursionFlag(boolean) ���ö�ѡ�µĵݹ��־

	this.setMultiInitDisabledArray(nValArray) ���ö�ѡ��ʼ���µ�check��disable״̬

	tree.setShowMenu(boolean,width) �Ƿ���ʾ�˵���־,����ʾ�Ļ�,widthΪ�˵��Ŀ��

  tree.reload(Module,boolean) �����أ�true��ȡ����ǰ��ѡ���ڵ㣬������չ����false��չ��

	tree.addChildTreeNode(pValue,pText,pNodeType)   �ڵ�ǰ�ڵ�������һ�����ӽڵ�pValue-�ڵ�ֵ pText-�ڵ��ı�,pNodeType-�ڵ�����."fold","leaf"

	tree.removeCurTreeNode()  �����ṹ��ɾ����ǰѡ�нڵ�.




        tree.getBrotherValues()  �õ���ǰѡ�н����ֵܽ���id������������



	tree.getParentValues()�õ���ǰѡ�нڵ㸸�ڵ��valueֵ�����ѡ��Ϊ���ڵ㣬����û��ѡ�еĽڵ㣬����null��


	[Deprecation]tree.setSelectedByValue(var id,isExpand);
	��ѡʱѡ�е�һ��value��ͬ�Ľڵ㣬��ѡʱѡ�����и���value�Ľڵ�,isExpand=trueʱչ�����ڵ㣬false��չ�����ڵ�



	[Deprecation] tree.setSelectedByName(var name,isExpand)
	��ѡʱѡ�е�һ��value��ͬ�Ľڵ㣬��ѡʱѡ�����и���value�Ľڵ�,isExpand=trueʱչ�����ڵ㣬false��չ�����ڵ�

        tree.getPrevBrotherValue() �õ���ǰѡ�нڵ㣬��ǰһ���ֵܽڵ��id,add at 2006-4-19Ϊ���ݿͷ�ϵͳ���������

        tree.getNextBrotherValue() �õ���ǰѡ�нڵ�ĺ�һ���ֵܽڵ��id,add at 2006-4-19Ϊ���ݿͷ�ϵͳ���������




 ******************************************************************************/
var g_DBTreeManager = new DBTreeManager();

function DBTreeManager(){
 this.List = new Array();
 this.push = function(dbtreeId,dbtreeObj){
      this.List[dbtreeId] = dbtreeObj;
	  return dbtreeId;
 }
 this.get = function(pk){
    return result = this.List[pk];
 }
 this.remove = function(pk){
   this.List[pk] = null;
 }
}

/*******************************************************/
/*����˵����DBTree�࣬
/*���������treeModel������Modelģ�Ͷ���
/*���������DBTree����ʵ����
/*******************************************************/

function DBTree(nTreeModel,nIsInitAll,nInitDeep)
{
	var dbTreeClass = new DBTreeClass(nTreeModel,nIsInitAll,nInitDeep);
	return dbTreeClass;
}


/**************************************** */
/*treeModel:����model                     */
/*showDeep����ʾ�Ľڵ����                */
/**************************************** */
function DBTreeClass(treeModel,nIsInitAll,nInitDeep)
{
	this.PK = null;

	this.UIObject = document.createElement("div");
	//this.UIObject.style.position="absolute";

	//obj.nodeImgObj.src = imgHEADo;
	this.curdeep =0;

    this.isInitAll = nIsInitAll;
    if(nIsInitAll==null)
		this.isInitAll = false;
    //alert("this.isIntAll="+this.isInitAll);
	this.initDeep = nInitDeep;
	if(nInitDeep==null)
       this.initDeep = 1;
	this.treeModel = treeModel;
    this.rootNode =null;

	this.selTreeNodePath="";/*��ǰѡ�еĽڵ��·���ַ���*/
	this.selPathArray=null;/*��ǰѡ�еĽڵ��·������*/

	this.curTreeNode=null;
	this.curNodeValue="";
    this.curNodeText ="";

	this.selNodesValue=null;/*��ѡ�����check�Ľڵ������value����ʾ�ı�*/
	this.selNodesText=null;

	this.isFolderFireEvent=true;/*�ж��Ƿ������ļ�����Ӧ�¼�*/
	this.isRootFireEvent=false;/*�ж��Ƿ�������ڵ���Ӧ�¼�*/
	this.isSameNodeFireEvent=false;/*�ж���ͬ�ڵ��Ƿ������ظ������¼�*/

	this.isMultiSelect=false;/*�ж��Ƿ�������ÿ���ڵ���ʾcheck�ؼ���ʾ��ѡ*/
	this.isMultiRecursion=true;/*�ж��Ƿ������ڶ�ѡʱ���еݹ�ѡ��*/


	this.MultiInitValArray = null;/*�ڶ�ѡ״̬�£��û��Խڵ����չ��ʱ�����ýڵ�checkbox��check��ʼ״̬*/
	this.MultiInitCheckBoxDisabledArray = null;/*�ڶ�ѡ״̬�£��û��Խڵ����չ��ʱ�����ýڵ�checkbox��disabled״̬*/

	this.isFolderFireEvent=true;/*�ж��Ƿ������ļ�����Ӧ�¼�*/

	this.selRowSetRow=0; /*ѡ�нڵ��Ӧrowset�ĵڼ��У����ѡ�еĽڵ��Ƿ�Ҷ�ӽڵ㣬ֻ�ܷ��ظýڵ��һ���ӽڵ��Ӧ����*/

	this.pathArray=null;


	this.isShowMenu=false /*�Ƿ���ʾ�˵��ı�־*/
	this.popMenuFuncName="";

	this.menuWidth = 100;/*�˵���Ĭ�Ͽ��*/
	this.menuItemArray=null;

	//����
	this.getDataObj = function getDataObj(){ return this};

	this.getModel=function getModel()
					{
						return this.treeModel;
					};


	this.buildTree = buildTree;
	this.displayTree=displayTree;

	this.UIObject.onmousedown = DBTreeOnClickFunc;
	this.UIObject.onclick = DBTreeCheckBoxClickFunc;

	this.isAllowDrag = false;
	this.UIObject.ondragstart = DBTreeOnDragStart;



	//�¼�����

	this.addListener = Object_addListener;
    this.removeListener =  Object_removeListener;
    this.fireListener = Object_fireListener;


	/*------------�û����Ե��õķ���-------------*/
	this.getUIObject = function()
					 {

						return this.UIObject;
					 }
	//�����Ƿ�������ק�ڵ�
	this.setAllowDragDrop = function(flag){
			      this.isAllowDrag = flag;
					}
	this.getPathFromRoot=function()//�ڵ�·�����顣
			     {
		       return this.pathArray;
			  };
    this.getRowSetRow=function()
					 {
						return this.selRowSetRow;
			     };

    this.getCurNodeValue=function()
			 {
						return this.curNodeValue;
					 };
	this.getCurNodeText =function()
			 {
						 return this.curNodeText;
					 }
        this.getPrevBrotherValue = function()
        {
          var reVal = null;
          var curId = this.getCurNodeValue();
          if(curId!=null && curId!="")
          {
            var pathArray = this.getPathFromRoot();
            if(pathArray!=null && pathArray.length>1)
            {
              var parentId = pathArray[pathArray.length-2];
              var tmpArray = this.treeModel.getChildrenVal(parentId);
              //alert(tmpArray.length);
              for(var i=0;i<tmpArray.length;i++)
              {
                if(tmpArray[i]==curId && i>0)
                {
                  reVal = tmpArray[i-1];
                  break;
                }
              }
            }
          }
          return reVal;
        }
        this.getNextBrotherValue = function()
        {
          var reVal = null;
          var curId = this.getCurNodeValue();
          if(curId!=null && curId!="")
          {
            var pathArray = this.getPathFromRoot();
            if(pathArray!=null && pathArray.length>1)
            {
              var parentId = pathArray[pathArray.length-2];
              var tmpArray = this.treeModel.getChildrenVal(parentId);
              //alert(tmpArray.length);
              for(var i=0;i<tmpArray.length;i++)
              {
                if(tmpArray[i]==curId && (i+1)<tmpArray.length)
                {
                  reVal = tmpArray[i+1];
                  break;
                }
              }
            }
          }
          return reVal;
        }

	this.getBrotherValues = function()
			 {

						var reArray = new Array();
						var curId = this.getCurNodeValue();

						if(curId!=null && curId!="")
						 {
			   var pathArray = this.getPathFromRoot();

						   if(pathArray!=null && pathArray.length>1)
							 {

							   var parentId = pathArray[pathArray.length-2];

							   var tmpArray = this.treeModel.getChildrenVal(parentId);
							   //alert(tmpArray.length);
							   for(var i=0;i<tmpArray.length;i++)
								 {
								   if(tmpArray[i]!=curId)
									 {
									   reArray[reArray.length]=tmpArray[i];
									 }
								 }

							 }
						 }
			return reArray;
			 }
	    this.getParentValues = function()
	   {
		     var curId = this.getCurNodeValue();
		var parentId = -1;
		  if(curId!=null && curId!="")
		   {
			     var pathArray = this.getPathFromRoot();
			 if(pathArray!=null && pathArray.length>2)
			      {
				 parentId = pathArray[pathArray.length-2];
			      }
			}
		return parentId;
	    }

	this.setCurNodeValue = function (pValue) // ���õ�ǰ�ڵ��valueֵ
			{
						 if(this.curTreeNode!=null && pValue!=null)
						  {
						this.curTreeNode.setTreeNodeValue(pValue);
							this.curNodeValue = pValue;
						  }
			}

	this.setCurNodeText= function(pText)//���õ�ǰ�ڵ��displayTextֵ
		       {
					   if(this.curTreeNode!=null && pText!=null)
					   {
						   this.curTreeNode.setTreeNodeText(pText);
						   this.curNodeText = pText;
					   }
			    }
    this.setSameNodeEvent=function(flag)
			{
				 this.isSameNodeFireEvent=flag;
					}
	this.setFolderEvent=function(flag)
					{
						this.isFolderFireEvent=flag;
					}
	this.setRootEvent = function(flag)
			{
				this.isRootFireEvent = flag;
			}
	this.setMultiSelectFlag =function setMultiSelectFlagFunc(flag)
					{
						if(flag)
						{
						  this.isMultiSelect = true;
						  //����������ѡ,Ĭ�ϳ�ʼ�����нڵ�
						  //this.isInitAll=true;
						}
						else
						{
						  this.isMultiSelect = false;
						}
					}

	this.setMultiRecursionFlag = function setMultiRecursionFlagFunc(flag)
					{
						if(flag)
						   {
							 this.isMultiRecursion = true;

						   }
						else
						  {
							 this.isMultiRecursion = false;
						  }
					}
    this.clearSelectedSts = function()
			{
				//����Ƕ�ѡ�����������checkbox��״̬
						if(this.isMultiSelect)
						{
			    var checkboxArray = this.getUIObject().all.tags("INPUT");
							for(var i=0;i<checkboxArray.length;i++)
								{
									if(checkboxArray.item(i).type=="checkbox" && checkboxArray.item(i).id=="DBTree_checkbox")
				       if(checkboxArray.item(i).checked)
										{
											checkboxArray.item(i).checked=false;
										}
								}

						}
						//�������е�labelΪδѡ״̬
						var labelArray =this.getUIObject().all.tags("LABEL");
					   //alert("label.length="+labelArray.length);
					    for (var i=0; i< labelArray.length; i++)
							{

								if(labelArray.item(i) && labelArray.item(i).id=="DBTree_label")
								{
									labelArray.item(i).style.backgroundColor = "transparent";
									labelArray.item(i).style.color = DBTREE_NODE_COLOR;
								}
							}
			}

	this.reload = function DBTreeReload(treeModel,nFlag) //�����أ�true��ȡ����ǰ��ѡ���ڵ㣬������չ����falseֻ��չ��
			{
			 var curNodePathArray = null;
			 if(nFlag && this.curNodeValue)
			 {
			 	 curNodePathArray = this.getPathFromRoot();
			 }
			 else
			 	{
			 		this.curTreeNode=null;
	        this.curNodeValue="";
          this.curNodeText ="";
			 		
			 	}
			 this.treeModel = treeModel;
			 var obj= this.getDataObj();
			 for(var i=0;i<obj.UIObject.children.length;i++)
						{
							obj.UIObject.removeChild(obj.UIObject.children[i]);
							//obj.removeNode(true);
						}
						obj.innerHTML="";
						var tmpObj = createDBTreeNodeClassFactory(treeModel.getRootVal(),treeModel.getRootText(),0,obj,"root");
						obj.UIObject.appendChild(tmpObj.UIObject);
			      this.rootNode = tmpObj;
						this.rootNode.isInit = true;
						this.rootNode.isExpand= true;
			      var deep =0;
						this.buildTree(this.rootNode,deep);
						//alert(this.innerHTML);
						deep =0;
						if(nFlag && this.curNodeValue && curNodePathArray!=null)
						{
							
							var divArray = this.getUIObject().all.tags("DIV");
							var tmpTreeNode = null;
							
							for(var j=1;j<=curNodePathArray.length-1;j++)
							{
								
								for(var m=0;m<divArray.length;m++)
					       {
						       
						       if(divArray.item(m).id=="DBTreeNode_"+curNodePathArray[j])
						       {
						          tmpTreeNode = g_DBTreeNodeManager.get(divArray.item(m).PK);
						          if(tmpTreeNode)
						          {
									      tmpTreeNode.setVisible(true);
												tmpTreeNode.setExpand(true);
									      tmpTreeNode.buildChildNode();
									    }
									    break; 
						       }
							   }
							
						  }
						  divArray = this.getUIObject().all.tags("DIV");
						  for(var n=0;n<divArray.length;n++)
						  {
						  	if(divArray.item(n).id == "DBTreeNode_"+this.curNodeValue)
						  	{
						  		tmpTreeNode = g_DBTreeNodeManager.get(divArray.item(n).PK);
						  		tmpTreeNode.setSelected(true);
						  	}
						  }
						}
			}
	this.refresh = function DBTreeRefresh(nParemeter){
			   this.treeModel.refreshModel(this.PK,nParemeter);
					   this.reload(this.treeModel,false);

					}
	this.getSelectedNodesValue=function()
		       {

					   var initSelArray = null;
					   //���Ƴ�ʼ�����鵹initSelArray��.ֵΪ����ֵ.
		       if(this.MultiInitValArray!=null)
					   {
			 initSelArray = new Array();
						 for(var k=0;k<this.MultiInitValArray.length;k++)
						   {
							 initSelArray[this.MultiInitValArray[k]]=this.MultiInitValArray[k];
						   }
					   }
		       //alert("initSelArray.value="+initSelArray.join());
					   var multiSelArray = new Array();
					   if(this.isMultiSelect)
						{
					    var checkboxArray = this.getUIObject().all.tags("INPUT");
							for(var i=0;i<checkboxArray.length;i++)
								{
									if(checkboxArray.item(i).type=="checkbox" && checkboxArray.item(i).id=="DBTree_checkbox")
									{


										 //���ҳ���checkboxֵ����MultiInitValArray�е�ֵ������initArray������δ��DBTree_null��
										 if(initSelArray!=null)
												{
													if(initSelArray[checkboxArray.item(i).value]!=null)
													{
														initSelArray[checkboxArray.item(i).value]="DBTree_null";
													}

												}
										if(checkboxArray.item(i).checked)
										{
											//���ڵ㲻��,��Ϊ���ڵ�Ϊ�û�ָ����ֻ����ڵ㣬�����ݿ��в�û����Ӧ�ļ�¼����.������ڵ㱻ѡ�У����������ڵ㶼��ѡ��
											//alert("this.rootNode.id="+this.rootNode.id+" item.value="+checkboxArray.item(i).value);
											if(checkboxArray.item(i).value==this.rootNode.value)
											{
												multiSelArray = this.treeModel.getAllVals();
												multiSelArray.shift();
												return multiSelArray;
											}
											else
											{

											   multiSelArray[multiSelArray.length]=checkboxArray.item(i).value;
											   //���ĳ���ڵ㱻ѡ�в���δչ�������ȡ�ýڵ����еĺ��ӽڵ��ֵ
  
                    
											  if(g_DBTreeNodeManager.get(checkboxArray.item(i).PK).isInit==false)
												{
												   //alert("get all children node value selNode.value="+checkboxArray.item(i).value);
												   var tmpArray = this.treeModel.getAllChildrenVals(checkboxArray.item(i).value);
												   for(var n=1;n<tmpArray.length;n++)
													{
													   multiSelArray[multiSelArray.length]=tmpArray[n];
													   if(initSelArray!=null)
													   {
															if(initSelArray[tmpArray[n]]!=null)
															  {
																initSelArray[tmpArray[n]]="DBTree_null";
															  }

													   }
													}

												}

											}




										}//inner if

				    };
								}
			     //��initSelArray�в�Ϊ��DBTree_null����ֵ����multiSelArray��
							if(initSelArray!=null && this.MultiInitValArray!=null)
							{
								for(var m=0;m<this.MultiInitValArray.length;m++)
								{
									if(initSelArray[this.MultiInitValArray[m]]!="DBTree_null")
									{
				       multiSelArray[multiSelArray.length]=initSelArray[this.MultiInitValArray[m]];
									}



								}
							}
							 //����ڴ�
							//initSelArray.length=0;
							initSelArray=null;

						}//end outest if

						return multiSelArray;

		       }
	this.getSelectedNodesText=function()
		       {
			      // alert("in getSelectednodestext");
					   var multiSelArray = new Array();
					   if(this.isMultiSelect)
						{

							var valArray = this.getSelectedNodesValue();
			    for(var i=0;i<valArray.length;i++)
							{
								multiSelArray[multiSelArray.length]=this.treeModel.getText(valArray[i]);
							}
						}
						return multiSelArray;

		       }
     this.setShowMenu=function(flag,showMenuFunc,hideMenuFuncName)
		       {
			      if(flag)
					   {
						  this.isShowMenu=true;
						  this.popMenuFuncName = showMenuFunc;
					      this.UIObject.oncontextmenu = DBTreeRightClickFunc;
						  if(hideMenuFuncName!=null && hideMenuFuncName!="")
						      this.UIObject.onclick = hideMenuFuncName;


		       }
					  else
					   {
						  this.isShowMenu=false;
						  this.UIObject.oncontextmenu = "";
						  this.UIObject.onclick = "";

					   }
				   }
	 this.setMultiInitValArray= function(nValArray)
		       {
			    if(nValArray == null) return;
					 if(nValArray.length==0 && this.MultiInitValArray)
						 this.MultiInitValArray.length =0;

		     this.MultiInitValArray = null;
					 this.MultiInitValArray = nValArray;
		       }
	 this.setMultiInitDisabledArray= function(nValArray)
		       {
			    if(nValArray == null) return;
				if(nValArray.length==0 && this.MultiInitCheckBoxDisabledArray)
					 this.MultiInitCheckBoxDisabledArray.length =0;


			this.MultiInitCheckBoxDisabledArray = null;
				this.MultiInitCheckBoxDisabledArray = nValArray;
		       }

	 this.setSelectedByValue=function(nVal,nIsExpand)
		      {
			      if(nVal==null || nIsExpand==null) return;
					  var divArray = this.getUIObject().all.tags("DIV");

		      for(var i=0;i<divArray.length;i++)
					  {
						     if(divArray.item(i).id=="DBTreeNode_"+nVal)
						      {
				 if(this.isMultiSelect)
						       {

									  var divObj = g_DBTreeNodeManager.get(divArray.item(i).PK);
									  divObj.setChecked("checked");
                                      divObj.isInit =true;
									  if(nIsExpand)
											{


												while(divObj && divObj.deep>=0 && divObj.treeNodeType!="root")
													{
													    //alert("divObj.id="+divObj.id+" divObj.nodeParent.isExpand="+divObj.nodeParent.isExpand);
													      divObj.setVisible(true);
													      divObj.setExpand(true);
														  divObj = divObj.nodeParent;

													}

											}


						       }
								 else
								   {
										var divObj = g_DBTreeNodeManager.get(divArray.item(i).PK);
									    divObj.setSelected(true);
										if(nIsExpand)
											{


												while(divObj && divObj.deep>=0 && divObj.treeNodeType!="root")
													{
													    //alert("divObj.id="+divObj.id+" divObj.nodeParent.isExpand="+divObj.nodeParent.isExpand);
													      divObj.setVisible(true);
													      divObj.setExpand(true);
														  divObj = divObj.nodeParent;

													}
						break;

											}



									  }
							  }
					   }
		    //���flag��false���ڵ�����
					if(!nIsExpand)
					  {
						 for(var i=0;i<this.rootNode.childrenArray.length;i++)
						  {
							 var node = this.rootNode.childrenArray[i];
							 node.setExpand(false);
						  }
					  }

		      }
     this.setSelectedByText=function(nText,nIsExpand)
		      {
			     // alert("in setselectbytext="+nIsExpand+" nText"+nText);
					  if(nText==null || nIsExpand==null) return;
					  var divArray = this.getUIObject().all.tags("DIV");
		      for(var i=0;i<divArray.length;i++)
					  {
						     if(divArray.item(i).displayText && divArray.item(i).displayText==nText)
						      {
				 if(this.isMultiSelect)
						       {
				      var divObj = g_DBTreeNodeManager.get(divArray.item(i).PK);
									  divObj.setChecked("checked");
									  if(nIsExpand)
											{

												while(divObj && divObj.deep>=0 && divObj.treeNodeType!="root")
													{
													    //alert("divObj.id="+divObj.id+" divObj.nodeParent.isExpand="+divObj.nodeParent.isExpand);
													      divObj.setVisible(true);
													      divObj.setExpand(true);
														  divObj = divObj.nodeParent;

													}

											}
						       }
								 else
								   {
										var divObj = g_DBTreeNodeManager.get(divArray.item(i).PK);
										divObj.setSelected(true);
										if(nIsExpand)
											{

												while(divObj && divObj.deep>=0 && divObj.treeNodeType!="root")
													{
													    //alert("divObj.id="+divObj.id+" divObj.nodeParent.isExpand="+divObj.nodeParent.isExpand);
													      divObj.setVisible(true);
													      divObj.setExpand(true);
														  divObj = divObj.nodeParent;

													}
						break;
											}

									  }
							  }
					   }


		      }
    //�ڵ�ǰ�ڵ�������һ�����ӽڵ�pValue-�ڵ�ֵ pText-�ڵ��ı�
    this.addChildTreeNode=function (pValue,pText,pNodeType)
		     {
			    if(this.curTreeNode!=null)
					 {
						this.curTreeNode.addChildNode(pValue,pText,pNodeType);

						//�����ӵ�treenode��Ϣ���ӵ�datamodel��
						this.treeModel.addChildNode(this.curTreeNode.value,pValue,pText);


					 }


		     }
	//ɾ����ǰѡ�еĽ��
	this.removeCurTreeNode = function ()
		      {
			     if(this.curTreeNode!=null)
					  {
					    //��dataModel�еĽ������ɾ��
						this.treeModel.delNode(this.curTreeNode.value);
						//alert("this.curTreeNode="+this.curTreeNode);
						//ɾ��ҳ��html������
						this.curTreeNode.remove();

						this.curTreeNode = null;
						this.curNodeValue = "";
						this.curNodeText = "";


					  }
		  }
    this.removeTreeNode = function(pTreeNodeValue)
				 {
					//��dataModel�еĽ������ɾ��
					this.treeModel.delNode(pTreeNodeValue);
					//�����html����ɾ��html����
		    var divArray = this.getUIObject().all.tags("DIV");
					for(var i=0;i<divArray.length;i++)
					  {
					     if(divArray.item(i).id=="DBTreeNode_"+pTreeNodeValue)
						      {
				 var divObj = g_DBTreeNodeManager.get(divArray.item(i).PK);
								 if(divObj)
								  {
									 divObj.remove();
									 if(this.curTreeNode && this.curTreeNode.PK == divObj.PK)
									  {
					this.curTreeNode = null;
								this.curNodeValue = "";
								this.curNodeText = "";
									  }
				     break;
								  }
							  }
					  }
				 }
	 /*-----------------------------

	this.rootNode = createDBTreeNodeClassFactory(this.treeModel.getRootVal(),this.treeModel.getRootText(),0,this,"root");

	this.rootNode.isInit = true;
	if(this.initDeep>0)
		this.rootNode.isExpand = true;
	this.curTreeNode = this.rootNode;
*/

	return this;
}

/*******************************************************/
/*����˵������model�ӿڵ�Ҫ��,��������ģ��
/*������������ڵ��Node����.
/*���������null
/*******************************************************/


function buildTree(nNode,deep)
{


	if(deep>=0 && deep<=this.initDeep)
	{
       nNode.setVisible(true);
	   if(this.isMultiSelect && this.MultiInitValArray!=null)
		 {

			 for(var j=0;j<this.MultiInitValArray.length;j++)
				 {
					if(nNode.value==this.MultiInitValArray[j])
					 {
						nNode.checkbox.checked =true;
						nNode.checkSts="checked";
						break;

					 }
				 }
		}
	   //��ʼ��

	   if(this.isMultiSelect && this.MultiInitCheckBoxDisabledArray!=null)
	   {

		     for(var m=0;m<this.MultiInitCheckBoxDisabledArray.length;m++)
			{
				//alert("value= "+nNode.value+","+this.MultiInitCheckBoxDisabledArray[m]);
				if(nNode.value == this.MultiInitCheckBoxDisabledArray[m])
				{
					 nNode.checkbox.disabled = true;
					 break;
				}

			}

	   }

	}
	if(deep>0 && deep<this.initDeep)
	{
		nNode.isInit = true;
		nNode.isExpand = true;
		if(nNode.isLastTreeNode)
			nNode.setTreeNodeType(nNode.treeNodeType,"bottom","open");
		else
	    nNode.setTreeNodeType(nNode.treeNodeType,"center","open");

	}
	if(this.isInitAll)
	{
		nNode.isInit = true;
	}

	var count = this.treeModel.getChildrenCount(nNode.value);
	//alert("childcount="+count);
	   if(count>0)
	{


		var childsVal = this.treeModel.getChildrenVal(nNode.value);
		var  childsText = this.treeModel.getChildrenText(nNode.value);
		deep+=1;
		var tmpNode = null;
		if(this.isInitAll)
		{
	    //nNode.setExpand(true);
			for(var i =0;i<count;i++)
			{

				//alert("in buildtree count="+this.treeModel.getChildrenCount(childsVal[i])+" childsVal[i]="+childsVal[i]);
				if(this.treeModel.getChildrenCount(childsVal[i])>0)
					tmpNode = nNode.addChildNode(childsVal[i],childsText[i],"fold");
				else
				    tmpNode = nNode.addChildNode(childsVal[i],childsText[i],"leaf");

				this.buildTree(tmpNode,deep);
			}
		}
		else
		{
	   if(deep<=this.initDeep)
			    {
				  for(var i =0;i<count;i++)
					{

						//alert("in buildtree count="+this.treeModel.getChildrenCount(childsVal[i])+" childsVal[i]="+childsVal[i]);
						if(this.treeModel.getChildrenCount(childsVal[i])>0)
							tmpNode = nNode.addChildNode(childsVal[i],childsText[i],"fold");
						else
							tmpNode = nNode.addChildNode(childsVal[i],childsText[i],"leaf");
						this.buildTree(tmpNode,deep);
					}


				}

		}

	}

}




/*******************************************************/
/*����˵���������ݼ��ϸ��������ֶηֲ���ʾ�����ع���õ�html��
/*�����������
/*�������������html�ַ���
/*******************************************************/


function displayTree()
{
	this.rootNode = createDBTreeNodeClassFactory(this.treeModel.getRootVal(),this.treeModel.getRootText(),0,this,"root");
	this.UIObject.appendChild(this.rootNode.getUIObject());
	var deep=0;
	this.rootNode.isInit = true;

	if(this.initDeep>0)
		this.rootNode.isExpand = true;

	this.buildTree(this.rootNode,deep);
	deep =0;

	this.curTreeNode = this.rootNode;



	//alert(this.innerHTML);



}






/*******************************************************/
/*����˵������ȡ��ǰ�ڵ㿪ʼ��������·�����������飬
/*���������node:��ǰ��������ڵ�,
	    isText:true��ʾ���ص����ı�displayText��·�����飬false��ʾ���ص���valueֵ��·�����顣
			isRootNode: true��ʾ���ص�����˳���ǴӸ��ڵ㵽��ǰ�ڵ㡣false��ʾ�ӵ�ǰ�ڵ㵽���ڵ������
/*�����������������
/****************************************************/

	function getNodePath(node,isText,isRootToNode)
	{
		var nodePathToRoot = new Array();

		var curObj = node;

		while(curObj!=null)
		{
	  if(isText)
			nodePathToRoot[nodePathToRoot.length]= curObj.displayText;
		  else
	    nodePathToRoot[nodePathToRoot.length]=curObj.value;
		  curObj = curObj.nodeParent;
		}
		if(isRootToNode)
		{
	  var nodePathFromRoot =nodePathToRoot.reverse();
		  return nodePathFromRoot;
		}
		else
		  return nodePathToRoot;
	}

//��������
//��ʼ��ק����
function DBTreeOnDragStart(){


}


function DBTreeOnClickFunc()
{
	var selDiv = null;
	var selObj = null;

	//�ڵ���չ�������¼�
	//alert("on click "+event.srcElement.id);

       if(event.srcElement.id=="DBTree_node")
	{
		selDiv = event.srcElement;
		//alert("selPK="+selDiv.PK);
	selObj = g_DBTreeNodeManager.get(selDiv.PK);
		if(selObj.isExpand)
		{

			selObj.setExpand(false);
		}
		else
		{
			selObj.buildChildNode();
			selObj.setExpand(true);

		}
	}//

	//���ڵ�ڵ�ѡ���¼�
	else if(event.srcElement.id=="DBTree_label" )
	{


	   selDiv = event.srcElement;
	   selObj = g_DBTreeNodeManager.get(selDiv.PK);
	   rootObj = selObj.rootNode;
	   rootObj.curNodeValue=selObj.value;
	   rootObj.curNodeText=selObj.displayText;
       rootObj.curTreeNode=selObj;
       rootObj.pathArray=getNodePath(selObj,false,true);
	   rootObj.selRowSetRow = rootObj.treeModel.getRowSetRow(selObj.value);
       selObj.buildChildNode();
	   if(rootObj.isAllowDrag && selObj.treeNodeType!="root"){
	      var e =  event.srcElement;
		  var range = document.body.createTextRange();
		  range.moveToElementText(e);
	  range.select();
	  //window.event.cancelBubble = true;
	   }
	   //alert("rootObj.selRowSetRow="+rootObj.selRowSetRow);
	   //����Ǹ��ڵ㣬���Ҳ�������ڵ㴥���¼�
		if(!rootObj.isRootFireEvent && selObj.treeNodeType=="root")
		   {
			 return;

		   }

	   ///���ýڵ���ɫ;
	   var labelArray =rootObj.getUIObject().all.tags("LABEL");//document.all.tags("LABEL");
	   //alert("label.length="+labelArray.length);
	   for (var i=0; i< labelArray.length; i++)
		{

			if(labelArray.item(i) && labelArray.item(i).id=="DBTree_label")
			{
				labelArray.item(i).style.backgroundColor = "transparent";
			    labelArray.item(i).style.color = DBTREE_NODE_COLOR;
	    }
		}
	   event.srcElement.style.backgroundColor = DBTREE_NODE_BACKGROUD_COLOR;
	   event.srcElement.style.color = DBTREE_NODE_SEL_COLOR;






	   //alert("rootObj.id"+rootObj.id);
	  }
	 //�Ҽ��¼�else if(event.button==2)
       window.event.cancelBubble = true;
       window.event.returnValue = false;


}


function DBTreeCheckBoxClickFunc()
{

   //checkbox״̬
	  if(event.srcElement.id=="DBTree_checkbox")
	  {
		var selDiv = event.srcElement;
        var selObj = g_DBTreeNodeManager.get(selDiv.PK);
        selObj.isInit =true;
		if(event.srcElement.checked)
		  {
			//alert("selObj.id="+selObj.id);
			selObj.setChecked("checked");
		  }
	   else
		  {
			selObj.setChecked("unchecked");
		  }

	  }
	 else if(event.srcElement.id=="DBTree_label" )
	 {
		  //���ڵ�ĵ���¼�
		  var selDiv = event.srcElement;
	      var selObj = g_DBTreeNodeManager.get(selDiv.PK);
	      rootObj = selObj.rootNode;
		   //����Ǹ��ڵ㣬���Ҳ�������ڵ㴥���¼�

		  if(!rootObj.isRootFireEvent && selObj.treeNodeType=="root")
		   {

			 return;

		   }

			 if(rootObj.isSameNodeFireEvent)
				{


					//����Ǹ��ڵ㣬���Ҳ�������ڵ㴥���¼�
					if(rootObj.isRootFireEvent && selObj.treeNodeType=="root")
						{
							rootObj.fireListener(S_OnChange,rootObj,window.event);

						}
					else if(selObj.treeNodeType!="root")
					   {
					//��������ļ��д����¼��ı�־Ϊtrue�����κνڵ㶼���Է����¼�������ֻ��Ҷ�ӽڵ���ܹ������¼�

							if(rootObj.isFolderFireEvent )
								{

									rootObj.fireListener(S_OnChange,rootObj,window.event);

								}
								else
								{
									if(selObj.treeNodeType!="fold")
										rootObj.fireListener(S_OnChange,rootObj,window.event);
								}
					   }
				}
			   else
				{
				   if(rootObj.selTreeNodePath!=rootObj.pathArray.join())
						{
							//����Ǹ��ڵ㣬���Ҳ�������ڵ㴥���¼�
							if(rootObj.isRootFireEvent && selObj.treeNodeType=="root")
								{
									rootObj.fireListener(S_OnChange,rootObj,window.event);

								}
			    else if(selObj.treeNodeType!="root")
							   {
									//��������ļ��д����¼��ı�־Ϊtrue�����κνڵ㶼���Է����¼�������ֻ��Ҷ�ӽڵ���ܹ������¼�
									if(rootObj.isFolderFireEvent)
										{

											rootObj.fireListener(S_OnChange,rootObj,window.event);

										}
									else
										{
											if(selObj.treeNodeType!="fold")
												rootObj.fireListener(S_OnChange,rootObj,window.event);
										}
							   }

						}

				}//end outest if-else
			rootObj.selTreeNodePath=rootObj.pathArray.join();

      
	 }
      window.event.cancelBubble = true;
      //window.event.returnValue = false;
}

//�˵���صĺ���
//�˵���صĺ���
function DBTreeRightClickFunc()
{
   if(event.srcElement.id=="DBTree_checkbox" || event.srcElement.id=="DBTree_label")
	{
	  // alert("right click ok");
	   var selDiv = event.srcElement;
	   var selObj = g_DBTreeNodeManager.get(selDiv.PK);
	   //��ȡ������
	   var rootObj = selObj.rootNode;
	   //����Ǹ��ڵ㣬���Ҳ�������ڵ㴥���¼�
	   if(!rootObj.isRootFireEvent && selObj.treeNodeType=="root")
		   {
			 return;

		   }

	   if(selObj.rootNode.isShowMenu && selObj.rootNode.popMenuFuncName!="")
		{
	  //alert(selObj.rootNode.popMenuFuncName);
		  //eval(selObj.rootNode.popMenuFuncName+"()");
		  eval(selObj.rootNode.popMenuFuncName+"('"+selObj.value+"','"+selObj.displayText+"')");

		}

	}
   window.event.returnValue = false;
   return false;
}

/*
function hideDBTreeMenu()
{
   var menuID = document.getElementById("DBTreeMenu");
   if(menuID)
	menuID.style.visibility="hidden";
}
*/

/*************************ȫ�ֺ���*********************************************/
var g_DBTreeNodeManager = new DBTreeNodeManager();

function DBTreeNodeManager()
 {
	 this.DBTreeNodeList = new Array();
	 this.MaxId = 0;
	 this.getNewPK = function()
		 {
		  this.MaxId = this.MaxId + 1;
		  //alert("GridId" + this.MaxId);
		  return "DBTreeNodePK_" + this.MaxId;
	     }
	 this.push = function(pDBTreeNode)
		 {
		  this.DBTreeNodeList[pDBTreeNode.PK] = pDBTreeNode;
	     }
	 this.get = function(pk)
		 {
		  return this.DBTreeNodeList[pk];
	     }
     this.getTreeNodeList = function()
	     {
		   return this.DBTreeNodeList;
	     }

  }

/******************************************************************************/

/*--------------------end of tree-----------------------------------------------*/


/*------------------------------------------------------------------*/
/*��ģ�ͽڵ���.��rowset����Ϊtree�Ľṹ,��DBTreeʹ��                 */
/*------------------------------------------------------------------*/
//���ڵ���
function Node(value, displayText)
{
	this.value = value;
	this.displayText = displayText;
	this.childrenArray = new Array();//�ӽڵ�����
	this.nC = 0 //child����
	this.nodeParent = null;

	this.whichRow = 0;//�ýڵ��Ӧ��RowSet�ĵڼ������ݡ�
	this.pkVal=""; //��ʾ�ڷֲ�ṹ�иýڵ�Ĳ��ֵ��
	this.parentPK="";//��ʾ�ڷֲ�ṹ�иýڵ㸸�ڵ�Ĳ��ֵ
	this.addChild = addChild;
	this.delChild = delChild;
	this.isSameChild=isSameChild;
	this.clearChild = clearChild;


	/*******************************************************/
	/*����˵��������һ���ӽڵ�
    /*���������childNode:�ڵ���
	/*�����������
	/*******************************************************/

	function addChild(childNode)
	{
		childNode.nodeParent = this;
	this.childrenArray[this.nC] = childNode;
		this.nC++;


	}


	function delChild(childNodeId)
	{

	   for(var i=0;i<this.childrenArray.length;i++)
		{
		   if(this.childrenArray[i].value == childNodeId)
			{
	      if(i<this.childrenArray.length-1 && i>0)
				{

				  var tmpNode = this.childrenArray[i];
				  this.childrenArray[i] = this.childrenArray[this.childrenArray.length-1];
				  this.childrenArray[this.childrenArray.length-1] = tmpNode;
				  this.childrenArray.pop();
				  this.nC--;
				}
	      else if(i==0)
		{
		  this.childrenArray.shift();
		  this.nC--;
				}
	      else if(i==this.childrenArray.length-1)
				{
		  this.childrenArray.pop();
				  this.nC--;
				}
	      break;
			}
		}
	}

	/*******************************************************/
	/*����˵�����ж�node���ӽڵ����Ƿ������ṩ�Ĳ����ڵ���ͬ�Ľڵ㡣
    /*���������childNode��Ҫ�ȽϵĽڵ���
	/*������������û����ͬ�ڵ㣬���أ�1�����򷵻���ͬ�ڵ����������ֵ��
	/*******************************************************/

	function isSameChild(childNode)
	{

		var val=-1;
		for (var i=(this.nC-1);i>=0; i--)
			{
				if(this.childrenArray[i].value==childNode.value)
				{
					val=i;
					break;
				}
			}
       return val;

	}

	function clearChild()
	{
		this.childrenArray.length = 0;
		this.nC = 0;
	}


}

/*---------------------end Model Node------------------------------------------------------*/




/*----------------------------DBTreeHiberarchyModel.js----------------------------------------*/
/*�ļ����ƣ�DBTreeHiberarchyModel.js
 *˵������DataRow���ݼ������û��ṩ�����������н��зֲ㹹��������һ�ð�Ҫ��ֲ������Model.��DBTree���á�
  ������
	��Model����Ҫ�����ǽ���DataRowSet����ָ�����ݼ�dataRowSet�����Ӳ�ι�ϵ�У����ڵ�ֵ�У����ڵ���ʾ�С�
	  �Ϳ��Ե���DBTree�����νṹ��ʾ��
  ʹ��˵����
	1��ֱ�ӵ��ù����ຯ��������������Ӧ��Model��
		�磺
		var model = createDBTreeHiberarchyModel("root","bofile","0",gRowSet,0,1,"0,2");
		var tree = new DBTree(model);

/****************************************************************************/


/****************************************************************************/
/*����˵��������һ��DBTreeHiberarchyModel����Ĺ����ࡣ
/*���������rootId			���ڵ��value
			rootText		���ڵ����ʾֵ
			rootVal			���ڵ�Ĳ��ֵ
			dataRowSet		���ݼ�����;
	    valueColName		������������е�Ϊ���ڵ��ֵ
			displayColName	�������������Ϊ���ڵ����ʾ�ı�
			hiberarchyCols	������ָ������Ϊ����С��ԡ�,���ָ�,����Ϊ�������,�Ӳ���У�
/*�������������DBTreeHiberarchyModel����
/*******************************************************/
function createDBTreeHiberarchyModel(rootId,rootText,dataRowSet,valueColName,displayColName,hiberarchyCols)
    {
		var pRootId = rootId;
		//var pRootPkVal=rootPkVal;
		var pRootPkVal = rootId;
		if(pRootId==null || pRootId=="")
			pRootId = rootText;
		if(pRootPkVal==null || pRootPkVal=="")
			pRootPkVal =rootText;
	//alert(pRootId+","+pRootPkVal);


		var dBTreeHiberarchyModel= new DBTreeHiberarchyModel(pRootId,rootText,pRootPkVal);
		dBTreeHiberarchyModel.loadData(dataRowSet,valueColName,displayColName,hiberarchyCols);
		return dBTreeHiberarchyModel;
    }

/****************************************************************************/
/*����˵����DBTreeHiberarchyModel�ඨ�塣��DBTree����
/*���������rootId			���ڵ��value
			rootText		���ڵ����ʾֵ
			rootPkVal		���ڵ�Ĳ��ֵ
/*�������������DBTreeHiberarchyModel����
/*******************************************************/

function DBTreeHiberarchyModel(rootId,rootText,rootPkVal)
{
	this.rootNode=new Node(rootId,rootText);


	this.rootNode.pkVal = rootId;


	this.dataRowSet = null;

	this.valueColName = null;

	this.displayColName = null;

	this.hiberarchyCols = null;

	this.loadData = loadHiberarchyModelData;

	this.nodeArray=null;
    //����һ���ڵ��ȡ���нڵ��value����text;flag =1����val���飬2������text����
	this.childArray=null;
	this.getAllChildren= function(selNode,flag)
				{
				       if(selNode!=null)
								{

								  if(flag==1)
									 this.childArray[this.childArray.length]=selNode.value;
								  else if(flag ==2)
				     this.childArray[this.childArray.length]=selNode.displayText;
								  var tmpNode = selNode;
								  for(var i=0;i<tmpNode.nC;i++)
									{
									  //alert("cursion tmpNodetmpNode.childrenArray[i]"+tmpNode.childrenArray[i].value);
									  this.getAllChildren(tmpNode.childrenArray[i],flag);

									}
								}

				}

	/********************��׼�ӿ�************************************ */
	this.getRootVal = function getRootVal(){ return this.rootNode.value;}

	this.getRootText = function getRootText(){return this.rootNode.displayText;}

	this.getText = function getText(id)
				    {
				      if(id==null || id=="") return null;
							  var node = this.nodeArray.get(id);
							  if(node!=null)
								{
								  return node.displayText;
								}
			      else
								{
								  return null;
								}
				}

	this.getChildrenCount = function getChildrenCount(id)
							{
								if(id==null || id=="") return 0;

								var node = this.nodeArray.get(id);
								//alert("in getChildrenCount,id="+id+" node="+node+" nC="+node.nC);
								if(node!=null)
								  return node.nC;
								else
								  return 0;
							}
	this.getChildrenText = function getChildrenText(id)
							{
								if(id==null || id=="") return null;
								var node = this.nodeArray.get(id);
				var textArray = new Array();
								if(node!=null)
								{
								  for(var j=0;j<node.nC;j++)
								   {
								    textArray[textArray.length]=node.childrenArray[j].displayText;
								   }
								}
								return textArray;
							}
	this.getChildrenVal = function getChildrenVal(id)
							{
								if(id==null || id=="") return null;
								var node = this.nodeArray.get(id);
				var valueArray = new Array();
								if(node!=null)
								{
								  //alert(node.value+","+node.nC);
								  for(var j=0;j<node.nC;j++)
								   {
								    valueArray[valueArray.length]=node.childrenArray[j].value;
								   }
								}
								return valueArray;
							}
    this.getAllChildrenVals = function(id)
			       {
				      if(id==null || id=="") return null;
							  var node = this.nodeArray.get(id);
							  if(node!=null)
							   {
								   this.childArray = new Array();
								   this.getAllChildren(node,1);
							   }
							  return this.childArray;
			       }
	this.getRowSetRow = function(id)
				{


							   if(id==null || id=="") return -1;
							   var node = this.nodeArray.get(id);
							   if(node!=null)
							    {
								   return node.whichRow;
								}
			       else
				{
								  return -1;
								  /*for(var i=this.dataRowSet.count();i>=0;i--)
								  {
								    if
								  }*/
								}
				}
     this.getAllVals = function()
				{

							   var node = this.nodeArray.get(this.rootNode.value);
							   if(node!=null)
							   {
								   this.childArray = new Array();
								   this.getAllChildren(node,1);
							   }
							   return this.childArray;
				    }
    this.getAllTexts = function()
				{

							   var node = this.nodeArray.get(this.rootNode.value);
							   if(node!=null)
							   {
								   this.childArray = new Array();
								   this.getAllChildren(node,2);
							   }
							   return this.childArray;
				}
    this.addChildNode = function(parentId,id,text)
			       {
				     var node = this.nodeArray.get(parentId);

							 if(node!=null && node!="null")
							   {
				  var childNode = new Node(id,text);
								  if(node.isSameChild(childNode)==-1)
								   {
									  node.addChild(childNode);
									  this.nodeArray.push(id,childNode);
									  childNode.nodeParent = node;
								   }
							   }

			       }
    this.delNode = function(pId)
			       {
							  if(pId==null || pId =="") return;
							  var node = this.nodeArray.get(pId);
							  if(node!=null)
							   {
								  var parentNode = node.nodeParent;
				  parentNode.delChild(pId);
								  this.nodeArray[pId] = null;

							   }
			       }
	this.refreshModel = function(pTreeId,parameters,qryset){
				    var  tUrl =  _gModuleName + "/dbtreerefresh?action=refresh&pk="+pTreeId;
							if(parameters)
							  tUrl = tUrl + "&" + parameters;
							var tmpstr  = "<RootInfo>"
							if(qryset != null)
								tmpstr = tmpstr + qryset.toXmlString(false);
							tmpstr = tmpstr   + "</RootInfo>";
							var dataRowSetObj = g_NormalRowSetManager.create(pTreeId+"_RowSet",tUrl);
							this.rootNode.clearChild();

							this.dataRowSet = null;

							this.loadData(dataRowSetObj,this.valueColName,this.displayColName,this.hiberarchyCols);

						}
	/************************end of public interface****************************/

}

/****************************************************************************/
/*����˵������dataRowSet���ݹ���ΪtreeModel
/*���������dataRowSet		���ݼ�����;
	    valueColName		������������е�Ϊ���ڵ��ֵ
			displayColName	�������������Ϊ���ڵ����ʾ�ı�
			hiberarchyCols	������ָ������Ϊ����С��ԡ�,���ָ���
/*�������������rootNode����
/*******************************************************/

function loadHiberarchyModelData(dataRowSet,nValueColName,nDisplayColName,hiberarchyCols)
{

	if(this.dataRowSet!=null) this.dataRowSet = null;

	this.dataRowSet = dataRowSet;

	this.valueColName = nValueColName;

	this.displayColName = nDisplayColName;

	this.hiberarchyCols = hiberarchyCols;
		//��ȡ����кŵ�����
	var valueColName = nValueColName;
	var displayColName =nDisplayColName;
	var hiberarchyArray = hiberarchyCols.split(",");

	if(hiberarchyArray==null || hiberarchyArray.length!=2)
	{
		alert("���ڵ�Ĳ���в����Ϲ淶");
		return;
	}
	 //Node����
	if(this.nodeArray!=null){
	  this.nodeArray.clear();

	}
	this.nodeArray=new NodeHashArray();

	var backupArray = new Array();



	//��nodeArray�в�����ڵ�
	this.nodeArray.push(this.rootNode.value,this.rootNode);

		//��ȡ���ݼ�������
	var rowcount = dataRowSet.count();
	//	alert("rowcount="+rowcount);
	//alert("nodeArray length="+this.nodeArray.getArray.length);

	//alert(" valueColName="+valueColName+" displayColName="+displayColName+" hiberarchyArray="+hiberarchyArray.join());
	var newNode = null;
	var parentPKVal = null;
	for(var i=0;i<rowcount;i++)
	{

		//alert("i="+i+" valueColName="+valueColName+" displayColName="+displayColName);
		//���Ϊvalue����displayTextΪnull�����������ṹ
		if(dataRowSet.getValue(i,valueColName)=="" || dataRowSet.getDisplayText(i,displayColName)=="")
				continue;
		newNode = new Node(dataRowSet.getValue(i,valueColName),dataRowSet.getDisplayText(i,displayColName));


		  //�趨��ǰ�ڵ��whichRow���ԣ�������˵��Node��Ӧ��rowset����һ��
		newNode.whichRow=i;

		  //ȡ�ýڵ���Idֵ.
		newNode.pkVal = this.value;//dataRowSet.getValue(i,hiberarchyArray[1]);



	      //ȡ�ø��ڵ�ֵ
		parentPKVal = dataRowSet.getValue(i,hiberarchyArray[0]);
		  //alert("line 11317:parentPKVal="+parentPKVal+" i="+i);
		  //������ڵ�IdΪnull,�趨���ĸ���Ϊ���ڵ�
		if(new String(parentPKVal)==null || new String(parentPKVal)=="" || new String(parentPKVal).toUpperCase()=="NULL")
		{
			//alert("line 11319:root.pkVal="+this.rootNode.pkVal);
			parentPKVal = this.rootNode.pkVal;
		}

		newNode.parentPK=parentPKVal;


		  //join the new node to nodeArray
		this.nodeArray.push(newNode.value,newNode);

		  //get the parent of the new node
		var parentNode = this.nodeArray.get(parentPKVal);
		if(parentNode!=null)
		{
			parentNode.addChild(newNode);


		}
		else
		{
			 //the node that no parent will store in the backupArray
			backupArray[backupArray.length] = newNode;

		}
	}//end of for


	//�ٴγ��Խ�backup�����е��޸��ڵ����������в塣
	//�����Ȼû�и��ף���ֱ�����øýڵ�ĸ���Ϊ���ڵ�
	for(var j=0;j<backupArray.length;j++)
	{

		var backNode = backupArray[j];
		parentNode = this.nodeArray.get(backNode.parentPK);
		if(parentNode!=null)
		{
		 parentNode.addChild(backNode);
		}
		else
		{
		  this.rootNode.addChild(backNode);
		}

	}


}

/*******************************************************/
/*����˵����node����
/****************************************************/
function NodeHashArray()
 {
	 this.nodeHashTable = new Array();
     this.push = function(pKey,pObj)
		 {
		    if(pKey==null || pObj==null)
				return;
			var key = new String(pKey);
			this.nodeHashTable[key] = pObj;
	     }
	 this.get = function(pKey)
		 {
		   if(pKey==null)
	      return null;
		   var key = new String(pKey);
		   if(this.nodeHashTable[key])
		     return this.nodeHashTable[pKey];
		   else
			 return null;
	     }
     this.getArray = function()
	     {
		   return this.nodeHashTable;
	     }
     this.clear = function()
	     {
		   this.nodeHashTable.length = 0;
		   this.nodeHashTable=new Array();

	     }

  }

/*----------------------------------end dbtreeModel-------------------------------*/
//----------------DBTreeNode.js------------------

/*******************************************************/
/*����˵��������ʾ�ڵ���
/*���������
/*���������
/****************************************************/

//ͼƬ�������ñ���
var imgHEADc =_gModuleName +"/jsv2/image/tree_pic/homepage.gif";//���ڵ�colse��ͼƬ
var imgHEADo =_gModuleName +"/jsv2/image/tree_pic/homepage.gif";//���ڵ�open��ͼƬ

var imgFoldo =_gModuleName + "/jsv2/image/tree_pic/fold_o.gif";//��֧�ڵ�open��ͼƬ
var imgFoldc =_gModuleName + "/jsv2/image/tree_pic/fold_c.gif";//��֧�ڵ�close��ͼƬ

var imgLeafc=_gModuleName + "/jsv2/image/tree_pic/leaf_c.gif";
var imgLeafo=_gModuleName + "/jsv2/image/tree_pic/leaf_o.gif";

//��ɫ��������
var DBTREE_NODE_SEL_COLOR = "#FFFFFF"; //���ڵ㱻ѡ�е���ɫ
var DBTREE_NODE_COLOR = "#000000";   //���ڵ�δѡ�е���ɫ
var DBTREE_NODE_BACKGROUD_COLOR= "#0A246A"; //���ڵ㱳��ɫ;

//�ӽڵ�����ڸ��׽ڵ��λƫ����
var OFFSET_WIDTH =18;
//�ڵ�֮��ļ��
var OFFSET_HEIGHT = 22;

function createDBTreeNodeClassFactory(nValue,nDisplayText,nDeep,nRoot,nNodeType,nDiv)
{
    var dbTreeNodeClass = new DBTreeNodeClass(nValue,nDisplayText,nDeep,nRoot,nNodeType,nDiv);
	dbTreeNodeClass.buildNode();
	return dbTreeNodeClass;
}

function DBTreeNodeClass(nValue,nDisplayText,nDeep,nRoot,nNodeType,nDiv)
{
	this.PK = g_DBTreeNodeManager.getNewPK();
    g_DBTreeNodeManager.push(this);
	if(nDiv)
		this.UIObject = nDiv;
	else
	{
		this.UIObject = document.createElement("div");

	}
	this.value = nValue;
	this.displayText = nDisplayText;

	this.UIObject.value=this.value;
	this.UIObject.displayText=this.displayText;
    this.UIObject.PK=this.PK;
	this.UIObject.id = "DBTreeNode_"+this.value;
	this.UIObject.style.display="none";
	this.UIObject.style.position = "relative";



	//this.style="position:relative;visibility:hidden";

	this.isInit = false;//�Ƿ��ʼ����־
    this.isVisible =false;
	this.isExpand=false;//�Ƿ���չ��־

	this.rootNode = nRoot;

	this.treeNodeType=nNodeType;

	this.deep = nDeep/*��ʾ�ڵ�Ĳ���*/

	this.isLastTreeNode = true //��������һ���ڵ㣬ֵΪtrue������Ϊfalse

	this.childrenArray = new Array();//��treeNode�ڵ�����
	this.nC = 0 //child����
	this.nodeParent = null;//���׽ڵ�

    this.tiaoImgObj = null;//�ڵ��������ʾ����
	this.nodeImgObj = null;//�ڵ����ʾimg����

	this.checkbox = null /*��ѡʱָ��checkbox*/
	this.checkSts ="unchecked";/*��ѡ��ĵ�ǰ״̬��������״̬:checked:ѡ��,unchecked-δѡ��,other-���ӽڵ���δѡ�еġ�*/

	this.label=null;

	this.getUIObject = getUIObjectFunc;
	this.buildNode = buildTreeNodeFunc;/*�����ݹ���Ϊdiv����ʾ����*/
	this.buildChildNode = buildChildNodeFunc;/*����ýڵ������ĺ��Ӷ���*/
	this.setTreeNodeType = setTreeNodeTypeFunc;/*���ýڵ������.�ڲ�ʹ��*/

    this.addChildNodes = addChildNodesFunc; /*����������ӽڵ�treeNode����*/
	this.addChildNode = addChildNodeFunc; /*�������ӽڵ�treeNode����*/
	this.removeChildNode = removeChildNodeFunc; /*ɾ�����ӽڵ����*/
	this.remove         = removeFunc;          /*ɾ������ڵ�*/
    this.setTreeNodeValue = setTreeNodeValueFunc; /*�������ڵ��value��displayText����*/
	this.setTreeNodeText = setTreeNodeTextFunc;   /*�������ڵ��displayText����*/

	this.setSelected = setSelectedFunc;/*����Ϊѡ��*/

	this.setChecked = setMultiCheckStsFunc;/*���ö�ѡʱcheckbox��״̬*/
	//this.setChildrenNodeVisible = setChildrenNodeVisibleFunc;
	this.setVisible =setVisibleFunc;/*���ýڵ���Ƿ����*/
	this.setExpand  =setExpandFunc;/*���ýڵ��������չ��*/

	return this;

}

function getUIObjectFunc()
{
   return this.UIObject;
}

/*
   �������ڵ�����
   pType="root","fold","leaf"�ֱ��ʾ������,�ļ�������,Ҷ������
   pPos ="center","bottom"�ֱ��ʾλ���м�Ľڵ㻹��λ��������Ľڵ�.Ŀǰֻ��fold����.
   pState="open","close" ��ʾ�ڵ�״̬�Ǵ򿪵Ļ��ǹرյ�.Ŀǰֻ��fold����������
*/
function setTreeNodeTypeFunc(pType,pPos,pState)
{

	if(pType=="")
		pType=this.treeNodeType;
	if(pType=="root")
	{
      this.treeNodeType="root";
      this.nodeImgObj.src = imgHEADc;

	}
    else if(pType == "fold")
	{
       this.treeNodeType="fold";
	   if(pState=="open")
			{
	      if(this.nodeImgObj.src != imgFoldo)
			     this.nodeImgObj.src = imgFoldo;
			}
       else
	    {
	      if(this.nodeImgObj.src != imgFoldc)
			    this.nodeImgObj.src = imgFoldc;
			}



	}
	else if(pType == "leaf")
	{

	   this.treeNodeType="leaf";
	   if(pState!=null && pState=="open")
			{

		   if(this.nodeImgObj.src != imgLeafo)
			      this.nodeImgObj.src = imgLeafo;
			}
       else
			{

		  if(this.nodeImgObj.src != imgLeafc)
			     this.nodeImgObj.src = imgLeafc;
			}




	}
}


/*����һ��������ʾ�ڵ�ķ���*/
function  buildTreeNodeFunc()
{
	var htmStrArray = new Array();
	if((this.deep)>0)
	{
	    var tiaoImgWidth = (this.deep) * OFFSET_WIDTH;
	htmStrArray[htmStrArray.length]="<table height=0 border=0 cellspacing='0' cellpadding='0'><tr style=\"height:"+OFFSET_HEIGHT+"px;\"><td style='width:"+tiaoImgWidth+"px;cursor:default' NOWRAP></td>";
		//this.UIObject.innerHTML = "<TABLE><IMG align='absmiddle' lowsrc='"+imgTIAO+"' disabled='true' style='width:"+tiaoImgWidth+"px;height:"+OFFSET_HEIGHT+"px;cursor:default'></IMG>";
	}
	if(this.deep == 0)
	   {
			this.UIObject.style.display="block";
		this.UIObject.style.position="relative";
	    htmStrArray[htmStrArray.length]="<table height=0 border=0 cellspacing='0' cellpadding='0'><tr><td nowrap></td>";

	   }


	//�ڵ�ͼƬ����
	htmStrArray[htmStrArray.length]="<td NOWRAP><input type=\"IMAGE\"  PK="+this.PK+" id = \"DBTree_node\" align=\"absmiddle\" style=\"cursor:default;width:16px;\" disabled=true/>";


    //checkbox
	if(this.rootNode.isMultiSelect)
	{
      htmStrArray[htmStrArray.length]="<input type=\"CHECKBOX\" PK="+this.PK+" id = \"DBTree_checkbox\" value="+this.value+" displayText="+this.displayText+" />";
	}

	//label
	if(this.treeNodeType!="root")
	{
      htmStrArray[htmStrArray.length]="<LABEL  PK="+this.PK+" id=\"DBTree_label\" class='p9'>"+this.displayText+"</LABEL>";
	}
	else
	{
	  htmStrArray[htmStrArray.length]="<LABEL  PK="+this.PK+" id=\"DBTree_label\" class='p9' style='font-weight:bold'>"+this.displayText+"</LABEL>";
	}


	htmStrArray[htmStrArray.length]="</td></tr></table>";
    this.UIObject.innerHTML="";
	this.UIObject.innerHTML=htmStrArray.join("");


	this.nodeImgObj = this.UIObject.all.item("DBTree_node");

    if(this.rootNode.isMultiSelect)
	{
	  this.checkbox = this.UIObject.all.item("DBTree_checkbox");
	}
	this.label = this.UIObject.all.item("DBTree_label");

	if(this.treeNodeType=="root")
	{
		this.setTreeNodeType("root","null","close");


	}
	if(this.treeNodeType=="fold")
	{
		this.setTreeNodeType("fold","bottom","close");

	}
	if(this.treeNodeType=="leaf")
	{
		this.setTreeNodeType("leaf","bottom","close");

	}




}






function buildChildNodeFunc()
{
   if(!this.isInit )
		 {

		   var childsVal = this.rootNode.treeModel.getChildrenVal(this.value);
	   var childsText = this.rootNode.treeModel.getChildrenText(this.value);
		   this.addChildNodes(childsVal,childsText);
		   this.isInit=true;
		 }
}




function removeFunc()
{
   if(this.nodeParent!=null)
	{

	   this.nodeParent.removeChildNode(this.value,this.displayText);
    }
}
//ɾ��һ�����ӽڵ�
function removeChildNodeFunc(pValue,pText)
{

   if(this.nC==0) return;

      //���ýڵ��childrenArray������ɾ��
   if(this.childrenArray[0].value == pValue && this.childrenArray[0].displayText == pText)
	{
	   //���ýڵ��Ӧ�Ķ����html��ɾ��
	   this.UIObject.removeChild(this.childrenArray[0].getUIObject());
	   this.childrenArray.shift();

	}
   else if(this.childrenArray[(this.nC-1)].value == pValue && this.childrenArray[(this.nC-1)].displayText == pText)
    {
	//���ýڵ��Ӧ�Ķ����html��ɾ��
	   this.UIObject.removeChild(this.childrenArray[this.nC-1].getUIObject());
		//���Ҫɾ���Ľڵ������һ��.ɾ����,��ǰ����Ǹ��ڵ�Ҫ��Ϊ���һ��.
	   this.childrenArray.pop();

	}
   else
	{
	for(var i=0;i<this.nC;i++)
	     {
		   if(this.childrenArray[i].value == pValue && this.childrenArray[i].displayText == pText)
			{
			     //���ýڵ��Ӧ�Ķ����html��ɾ��
			   this.UIObject.removeChild(this.childrenArray[i].getUIObject());
				//��Ҫɾ���Ľڵ㸳ֵΪ��һ���ڵ�.����һ���ڵ�ɾ��
			    this.childrenArray[i] = this.childrenArray[0];
			    this.childrenArray.shift();

			   break;
			}
		 }
	}

	 //���ӽڵ������1
   this.nC = this.nC-1;


	//���ɾ�����ӽڵ�ĸ���Ϊ0.�򸸽ڵ��ͼƬҪ�ı�ΪҶ�ӽڵ��ͼƬ
   if(this.nC==0)
	{
	   //alert("after del this.isLastTreeNode="+this.isLastTreeNode);
	   //����ýڵ�Ϊ���ڵ�.�亢�ӽڵ㼴ʹɾ����,����ͼƬ������
	   if(this.treeNodeType=="root") return;
	   this.setTreeNodeType("leaf","","open");

	}


}//end

function addChildNodesFunc(pValueArray,pTextArray)
{
   if(pValueArray==null || pTextArray==null ) return;
   if(pValueArray.length && pValueArray.length==0) return;
   if(pTextArray.length && pTextArray.length==0 ) return;
   if(pValueArray.length!=pTextArray.length)
	{
	   alert("��ȡ����Value��Text����ĳ��Ȳ�һ��");
	   return;
    }
   for(var i=0; i<pValueArray.length;i++)
	{
	   if(this.rootNode.treeModel.getChildrenCount(pValueArray[i])>0)
	      nChildNode = createDBTreeNodeClassFactory(pValueArray[i],pTextArray[i],this.deep+1,this.rootNode,"fold");
       else
	      nChildNode = createDBTreeNodeClassFactory(pValueArray[i],pTextArray[i],this.deep+1,this.rootNode,"leaf");
       nChildNode.nodeParent = this;
	   this.UIObject.appendChild(nChildNode.getUIObject());
	   this.childrenArray[this.nC++]=nChildNode;

       if(this.rootNode.isMultiSelect)
		 {

		   if(this.checkSts=="checked")
			 {
			   nChildNode.checkbox.checked =true;
			   nChildNode.checkSts="checked";
			 }
		   else
			 {
			   if(this.rootNode.MultiInitValArray!=null)
				 {
				   for(var j=0;j<this.rootNode.MultiInitValArray.length;j++)
					 {
						if(nChildNode.value==this.rootNode.MultiInitValArray[j])
						 {
							nChildNode.checkbox.checked =true;
							nChildNode.checkSts="checked";
							break;

						 }
					 }
				 }



			 }
		  if(this.rootNode.MultiInitCheckBoxDisabledArray!=null)
			   {
					  for(var m=0;m<this.rootNode.MultiInitCheckBoxDisabledArray.length;m++)
					{
						if(nChildNode.value == this.rootNode.MultiInitCheckBoxDisabledArray[m])
						{
							 nChildNode.checkbox.disabled = true;
							 break;
						}

					}

				   }
		 }


	}
	if(this.treeNodeType=="leaf" && this.nC>0)
	{
	   this.setTreeNodeType("fold","","close");
	}



}
function addChildNodeFunc(pValue,pText,pNodeType)
{
	if(pValue==null|| pText==null) return;
	if(pValue=="" || pText=="") return;
	if(pNodeType==null || pNodeType=="" ) pNodeType="leaf";
	var nChildNode = createDBTreeNodeClassFactory(pValue,pText,this.deep+1,this.rootNode,pNodeType);
	nChildNode.nodeParent = this;
	//alert("run here "+this.treeNodeType);
	if(this.treeNodeType=="leaf")
	{
		this.setTreeNodeType("fold","","close");

	}

	if(this.isExpand)
	{
		nChildNode.setVisible(this.isExpand);
	}

	//alert("IN ADDCHILD="+this.nC);
	//alert("int DBTreeNodeClass->addChildNodeFunc nChildNode.id="+nChildNode.id);
	this.UIObject.appendChild(nChildNode.getUIObject());
	this.childrenArray[this.nC++]=nChildNode;
	 return nChildNode;

}
/*�������ڵ��value����*/
function setTreeNodeValueFunc(pValue)
{
	 this.id = "DBTreeNodeClass_"+pValue;
	 this.value = pValue;
	 if(this.rootNode.isMultiSelect)
	 {
		this.checkbox.value = pValue;
	 }
    this.label.innerText=this.displayText;


}
 /*�������ڵ��displayText����*/
function setTreeNodeTextFunc(pText)
{

	this.displayText = pText;
	if(this.rootNode.isMultiSelect)
	 {
		this.checkbox.displayText=pText;

	 }
    this.label.innerText=pText;
}

function setSelectedFunc()
{

	   this.rootNode.curNodeValue=this.value;
	   this.rootNode.curNodeText=this.displayText;
       this.rootNode.curTreeNode=this;
       this.rootNode.pathArray=getNodePath(this,false,true);
	   this.rootNode.selRowSetRow = this.rootNode.treeModel.getRowSetRow(this.value);
       this.buildChildNode();
	//�������е�LABEL����ɫΪ͸��.���ñ�treeNode��labelΪѡ�е���ɫ.
	var labelArray =this.rootNode.getUIObject().all.tags("LABEL");
	for (var i=0; i< labelArray.length; i++)
		{

			if(labelArray.item(i) && labelArray.item(i).id=="DBTree_label")
			{
				labelArray.item(i).style.backgroundColor = "transparent";
			    labelArray.item(i).style.color = DBTREE_NODE_COLOR;
	    }
		}
	this.label.style.backgroundColor = DBTREE_NODE_BACKGROUD_COLOR;
	this.label.style.color = DBTREE_NODE_SEL_COLOR;
	if(this.rootNode.isSameNodeFireEvent)
				{

					//����Ǹ��ڵ㣬���Ҳ�������ڵ㴥���¼�
					if(this.rootNode.isRootFireEvent && this.treeNodeType=="root")
						{
							this.rootNode.fireListener(S_OnChange,this.rootNode,window.event);

						}
					else
					if(this.treeNodeType!="root")
					   {
					//��������ļ��д����¼��ı�־Ϊtrue�����κνڵ㶼���Է����¼�������ֻ��Ҷ�ӽڵ���ܹ������¼�
							if(this.rootNode.isFolderFireEvent )
								{

									this.rootNode.fireListener(S_OnChange,this.rootNode,window.event);

								}
								else
								{
									if(this.treeNodeType!="fold")
										this.rootNode.fireListener(S_OnChange,this.rootNode,window.event);
								}
					   }
				}
			   else
				{
				   if(this.rootNode.selTreeNodePath!=this.rootNode.pathArray.join())
						{
							//����Ǹ��ڵ㣬���Ҳ�������ڵ㴥���¼�
							if(this.rootNode.isRootFireEvent && this.treeNodeType=="root")
								{
									this.rootNode.fireListener(S_OnChange,this.rootNode,window.event);

								}
			    else
							if(this.treeNodeType!="root")
							   {
									//��������ļ��д����¼��ı�־Ϊtrue�����κνڵ㶼���Է����¼�������ֻ��Ҷ�ӽڵ���ܹ������¼�
									if(this.rootNode.isFolderFireEvent)
										{

											this.rootNode.fireListener(S_OnChange,this.rootNode,window.event);

										}
									else
										{
											if(this.treeNodeType!="fold")
												this.rootNode.fireListener(S_OnChange,this.rootNode,window.event);
										}
							   }

						}

				}//end outest if-else
		 this.rootNode.selTreeNodePath=this.rootNode.pathArray.join();



}

function setMultiCheckStsFunc(flag)// flag=checkedѡ�� flag=unchecked δѡ�� isClearFlag-����еڶ�����������ʾ�Ƿ������ǰ��checkbox��ѡ��״̬
{
  if(this.rootNode.isMultiSelect)
	{

	  if(arguments[1])
		{
		  var checkboxArray = this.rootNode.getUIObject().all.tags("INPUT");
		  for(var i=0;i<checkboxArray.length;i++)
			{
				//alert("checkboxArray.item(i).type"+checkboxArray.item(i).type)
			   if(checkboxArray.item(i).type=="checkbox" && checkboxArray.item(i).id=="DBTree_checkbox")
				 {
					if(checkboxArray.item(i).checked)
					{
						checkboxArray.item(i).checked=false;
						checkboxArray.item(i).checkSts="false";
					}
				 }
			}
		}
	  if(flag=="checked")
		{
		  //alert(" this.checkbox.checked" +this.checkbox.checked)
		  this.checkbox.checked =true;
		  this.checkSts="checked";

		  if(this.rootNode.isMultiRecursion )
			{
			  for(var i=0;i<this.nC;i++)
				{
				  this.childrenArray[i].setChecked("checked");

				}
			}
		}
	  else if(flag == "unchecked")
		{
		  this.checkbox.checked = false;
		  this.checkSts="unchecked";
		  //�丸�׽ڵ�Ҳȡ��ѡ��
		  //alert("before check this.nodeParent="+this.nodeParent.checkbox.checked);
		  var parentObj = this.nodeParent;
		  while(parentObj!=null)
			{
				//alert("before checed parent.checkbox.check="+this.nodeParent.checkbox.checked)
				parentObj.checkbox.checked=false;
				parentObj.checkSts="unchecked";
				parentObj = parentObj.nodeParent;
	    }

		  if(this.rootNode.isMultiRecursion)
			{
			  if(this.isInit==false);
			   {
				  this.buildChildNode();
			   }
			  for(var i=0;i<this.nC;i++)
				{
				  this.childrenArray[i].setChecked("unchecked");

				}
			}
		}//end of else
      /*var parentObj = this.nodeParent;
	  while(parentObj!=null)
		{
	  for(var i=0;i<parentObj.childrenArray.length;i++)
			{
			  if()
			}
		}
    */

	}
}


function setVisibleFunc(nFlag)
{
	if(nFlag)
	{
		this.UIObject.style.display="block";
		this.isVisible=true;

	}
	else
	{
		this.UIObject.style.display="none";
		this.isVisible=false;

	}
}

function setExpandFunc(nFlag)
{
	if(this.treeNodeType=="leaf" || this.treeNodeType=="root")
		return ;

	this.isExpand = nFlag
	   if(this.isExpand)
	{
	  this.buildChildNode();
	  this.setTreeNodeType("fold","","open");


	}
	else
	{
	    this.setTreeNodeType("fold","","close");
	}
	for(var i=0;i<this.childrenArray.length;i++)
		{
	   this.childrenArray[i].setVisible(this.isExpand);
		}



}



function clearPageTreeCache(){
	var formxmls = document.getElementsByTagName("xml");
	var dbtreePks = new Array();
	for (var i = 0;i < formxmls.length;i++){
		if (formxmls[i].id.indexOf("_RowSetData") > -1){
			dbtreePks.push(formxmls[i].PK);
		}
	}
	if (dbtreePks.length > 0){
	    var XMLSender = new ActiveXObject("Microsoft.XMLHTTP");
	    XMLSender.Open("POST",_gModuleName + "/dbtreerefresh?action=clearobj&pks="+dbtreePks.join(";"),true);
	    XMLSender.setRequestHeader("Content-Type","multipart/form-data");
	    XMLSender.send(null);
	}
	window.detachEvent("onunload",clearPageTreeCache);
}

if (typeof(_isClearCacheObj)!="undefined" && _isClearCacheObj == "Y"){
	window.attachEvent("onunload",clearPageTreeCache);
}



