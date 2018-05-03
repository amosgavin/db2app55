/** 　
 *作者 ： 张华
 *时间：2007-12-20
 *功能：提供根据button的ID设置button的disabled
 *方法：
 * get(pk)：根据button的唯一标志ID获取button对象。
 * setDisabled(flag):设置按钮状态.flag的值为true/false。
**/
function AIButtonManager(){
	this.List = new Array();
 	this.push = function(aiButton){
    	this.List[aiButton.AIButtonPK] = aiButton;
    	return aiButton.AIButtonPK;
 	}
 	this.get = function(pk){
    	var result = this.List[pk];
    	if(!result){
       		result = new AIButton(pk);
    	}
    	return result;
 	}
 	this.remove = function(pk){
   		this.List[pk] = null;
 	}
}

var g_AIButtonManager = new AIButtonManager();

function AIButton(pk){
	this.AIButtonPK = pk;
	this.AIButton = document.getElementById(pk);
	this.OperatorAuthor = this.AIButton.OperatorAuthor;
	this.ParentNode = this.AIButton.parentNode;	
	g_AIButtonManager.push(this);
}
AIButton.prototype.setDisabled = AIButton_SetDisabled;
AIButton.prototype.setText = AIButton_SetText;

function AIButton_SetText(newText){
  document.getElementById(this.AIButtonPK+"_btnText").innerText = newText;
}

function AIButton_SetDisabled(flag){
	if(flag==false){
    if(this.OperatorAuthor !=null && (this.OperatorAuthor==false || this.OperatorAuthor=='false')){
      return;
    }
  }
  this.AIButton.disabled = flag;
  //modify
  var tempClass = this.AIButton.className;
  if(tempClass.indexOf("Hover") > 0){
    tempClass = tempClass.substring(0,tempClass.indexOf("Hover"));
  }
  else if(tempClass.indexOf("Disabled") > 0){
    tempClass = tempClass.substring(0,tempClass.indexOf("Disabled"));
  }
  if(flag==false)
    this.AIButton.className = tempClass;
  else
    this.AIButton.className = tempClass+"Disabled";
}

function AIButtonSetDisabled(flag){
	if(flag==false){
    	if(this.OperatorAuthor !=null && (this.OperatorAuthor==false || this.OperatorAuthor=='false')){
      		return;
    	}
    }
    this.disabled = flag;
    if(flag==false)
    	this.className = "Button";
    else
    	this.className = "ButtonDisabled";
}

/**
 *设置鼠标在button上的样式变化，
 *overObj为组件对象，classType为css样式
*/
function mouseOver(overObj, classType)
{
  if(overObj.disabled == true)
    return;
	overObj.className=classType;
}


/**
 *设置鼠标在button上的样式变化，
 *overObj为组件对象，classType为css样式
*/
function mouseOut(outObj, classType)
{
  if(outObj.disabled == true)
    return;
	outObj.className=classType;
}
