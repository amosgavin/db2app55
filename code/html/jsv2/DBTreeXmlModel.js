function createDBTreeXmlModel(xmlStr,valueAttrName,displayTextAttrName,userObjectAttrName)
    {
		if(xmlStr!=null && xmlStr!=""){
			var xmlObject= new ActiveXObject("Msxml.DOMDocument");
            xmlObject.async = false;
            var isSuccess = xmlObject.loadXML(xmlStr);
			if (!isSuccess)
			 {
				alert(g_I18NMessage("appframe_core","treexml_menu_err"));
				return null;
			 }
            var xmlNode = xmlObject.documentElement;
			var dBTreeXmlModel= new DBTreeXmlModel(xmlNode,valueAttrName,valueAttrName,displayTextAttrName,userObjectAttrName);
			return dBTreeXmlModel;
		}
		else{
		   alert(g_I18NMessage("appframe_core","treexml_null"));
		   return null;
		}

    }

/****************************************************************************/
/*����˵����DBTreeXmlModel�ඨ�塣��DBTree����.��xml�л�ȡ���ݹ�������㡣���Ĳ�ε�ͬ��xml���Ĳ��
/*���������xmlNode         xmlDom������
            nIdAttrName			���ڵ��id���ֵ
			nValueAttrName		���ڵ��valueֵ
			nDisplayTextAttrName���ڵ����ʾֵ
/*******************************************************/

function DBTreeXmlModel(xmlNode,nIdAttrName,nValueAttrName,nTextAttrName,userObjectAttrName)
{

	this.rootNode = null;
     //Node����
	this.nodeArray=new NodeHashArray();

	this.userObjectArray = new Array();

	this.loadXmlData = loadXmlData;

    var rootId = xmlNode.attributes.getNamedItem(nIdAttrName).nodeValue;
	var rootVal = xmlNode.attributes.getNamedItem(nValueAttrName).nodeValue;
	var rootText = xmlNode.attributes.getNamedItem(nTextAttrName).nodeValue;

	this.userObjectAttrNameArray = null;
	if(userObjectAttrName.indexOf(",")){
	  this.userObjectAttrNameArray = userObjectAttrName.split(",");
	}
	else{
	  this.userObjectAttrNameArray = new Array();
	  this.userObjectAttrNameArray[userObjectAttrNameArray.length] = userObjectAttrName;
	}

	//��ȡָ������
	var userObj = new Array();
	for(var i=0;i<this.userObjectAttrNameArray.length;i++){
	  userObj[this.userObjectAttrNameArray[i]] =  xmlNode.attributes.getNamedItem(this.userObjectAttrNameArray[i]).nodeValue;

	}
	this.userObjectArray[rootVal] =userObj;


	this.rootNode = new Node(rootVal,rootText);
	this.rootNode.pkVal = rootId;

	this.nodeArray.push(this.rootNode.value,this.rootNode);

	for(var i=0;i<xmlNode.childNodes.length;i++){
      this.loadXmlData(this.rootNode,xmlNode.childNodes(i),nIdAttrName,nValueAttrName,nTextAttrName,userObjectAttrName);
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
								    textArray[textArray.length]=(node.childrenArray[j].displayText);
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
								    valueArray[valueArray.length] = node.childrenArray[j].value;
								   }
								}
								return valueArray;
							}
   this.getRowSetRow = function(id)
	                        {
                                return -1;
	                        }
   this.getUserObject = function(id,attrName)
	                        {
	                          if(id==null || id=="") return null;
							  if(attrName==null || attrName=="") return null;
							  var userObject = this.userObjectArray[id];
							  return userObject[attrName];
	                        }
  this.getAllVals = function(){
    var tmp = this.getChildrenVal(this.getRootVal());
    var result= this.getChildrenVal(this.getRootVal());
    
    while(tmp.length>0){
      var arr = this.getChildrenVal(tmp.pop());
      if(arr==null || arr.length==0)continue;
      result = result.concat(arr);
      tmp = tmp.concat(arr);
    }
    return result;
    
  }
  
  this.getAllChildrenVals = function(value){
    var tmp = this.getChildrenVal(value);
    var result= this.getChildrenVal(value);
    
    while(tmp.length>0){
      var arr = this.getChildrenVal(tmp.pop());
      if(arr==null || arr.length==0)continue;
      result = result.concat(arr);
      tmp = tmp.concat(arr);
    }
    return result;
    
  }
    /************************end of public interface****************************/

}

/****************************************************************************/
/*����˵������xml���ݹ���ΪtreeModel.���ؽ������xml����XmlSetClass
/*���������xmlStr		xml�ַ���;
            idAttrName		�����������������Ϊ���ڵ��id���ֵ
			valueAttrName     ֵ������
			textAttrName	��ʾֵ�������������������Ϊ���ڵ����ʾ�ı�
/*�������������rootNode����
/*******************************************************/

function loadXmlData(parentTreeNodeObj,nXmlNode,nIdAttrName,nValueAttrName,nTextAttrName,userObjectAttrName)
{
	var vId = nXmlNode.attributes.getNamedItem(nIdAttrName).nodeValue;
	var vVal = nXmlNode.attributes.getNamedItem(nValueAttrName).nodeValue;
	var vText = nXmlNode.attributes.getNamedItem(nTextAttrName).nodeValue;
	var userObj = new Array();
	for(var i=0;i<this.userObjectAttrNameArray.length;i++){
	  userObj[this.userObjectAttrNameArray[i]] =  nXmlNode.attributes.getNamedItem(this.userObjectAttrNameArray[i]).nodeValue;

	}
	this.userObjectArray[vVal] =userObj;
	var newNode = new Node(vVal,vText);

	parentTreeNodeObj.addChild(newNode);
    parentTreeNodeObj.pkVal = vId;

	this.nodeArray.push(newNode.value,newNode);

	for(var i=0;i<nXmlNode.childNodes.length;i++){
	   this.loadXmlData(newNode,nXmlNode.childNodes(i),nIdAttrName,nValueAttrName,nTextAttrName,userObjectAttrName);
	}








}



/*----------------------------------end dbtreeModel-------------------------------*/
