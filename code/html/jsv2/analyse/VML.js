/*

  ����ͼ�����
  ���ܣ���ҳ���ṩ��DIV�л�����״ͼ����ͼ����ͼ
  ʹ�÷�����
	1��testDrawBars �滭��״ͼ
	2��testDrawPies �滭��ͼ
	3��testDrawLines �滭��ͼ
	4��testEvent ��Ӧʱ�亯������

*/

/*
  �����������ݽṹ
  x:          x����ֵ���ַ�����
  y:          y����ֵ�����֣�
  color:      ��ͼ����ʹ�ã���ʾ����ɫ���ַ�����
  serialInfo: ά��Ϣ���ַ�����
  serialNum:  ά�������֣�ϵͳʹ�ã�������д��
*/
function InputData(){
  this.x ;
  this.y ;
  this.color ;
  this.serialInfo;
  this.serialNum;
}



/*
  ����ṹ��Ϊ��ƴдVML�ַ���
  nowStr:��ǰ�ڵ��Ӧ���ַ������ַ�����
  next:��һ���ڵ㣨ChainNode���ͣ�
*/
function ChainNode(){
  this.nowStr;
  this.next;
}

ChainNode.prototype.addNode = ChainNode_addNode;
ChainNode.prototype.toString = ChainNode_toString;

/*
  ��ӽڵ�
  ���ܣ��ڶ�Ӧ����Ӧ�ַ������Ľڵ�ǰ��ӽڵ�
  addBeforeNodeString:��Ҫ���ҵĶ�Ӧ�ַ������ַ�����
  node:��Ҫ��ӵĽڵ㣨ChainNode���ͣ�
*/
function ChainNode_addNode(addBeforeNodeString,node){
  var nextNode = this;
  var currentNode = this;
  while(nextNode!=null){
    if( nextNode.nowStr==addBeforeNodeString ){
      currentNode.next = node;
      node.next.next = nextNode;
      break;
    }
    currentNode = nextNode;
    nextNode = nextNode.next;
  }
}

/*
  ����ַ���
  ���ܣ����ƴд���ַ���
*/
function ChainNode_toString(){
  var nextNode = this;
  var strArray = new Array();
  while(nextNode!=null){
    if(nextNode.nowStr!=null) strArray[strArray.length] = nextNode.nowStr;
    nextNode = nextNode.next;
  }
  return strArray.join("");
}

/*
  ��������ɫ
  ���ܣ��������������û����ɫ��Ϣ����������ɫ
*/
function addRondamColor(arrayData){
  var ColorArray = new Array();
  for(i=0;i<arrayData.length;i++){
    if(arrayData[i].color == null){
	if(ColorArray[arrayData[i].serialNum]==null){
		ColorArray[arrayData[i].serialNum] = "rgb("+ parseInt( Math.random() * 255) +"," +parseInt( Math.random() * 255) +"," +parseInt( Math.random() * 255)+")";
	}
	arrayData[i].color = ColorArray[arrayData[i].serialNum];
    }
  }
}



/*
  ����ϵͳ
  ���ܣ�����VML����ϵ
  gArrayData ��������������
  gWidth �� ���
  gHeight �� �߶�
  gColorHX �� x��ʵ����ɫ
  gColorXX �� x��������ɫ
  gFontSize �� ����ߴ�,��λpt
  gBaseX : X����ʼλ��
  gBaseY ��Y����ʼλ��
  gOriginFontX ��VML��ͼX����ʼλ��
  gOriginFontY ��VML��ͼY����ʼλ��
  gCellY ��Y�ᵥλ��ֵ
  gPercent ��ͼ����ʾ�ٷֱ�
  gShowX �� X�ᵥλ
  gShowY �� Y�ᵥλ
  gClickEventFun �� �����¼���Ӧ����
  gDblClickEventFun �� ˫���¼���Ӧ����
*/
function CoordinateSystem(gArrayData,gWidth,gHeight,gColorHX,gColorXX,gFontSize,gBaseX,gBaseY,gOriginFontX,gOriginFontY,gCellY,gPercent,gShowX,gShowY,gClickEventFun,gDblClickEventFun){
  this.arrayData = gArrayData;
  this.x_map ;
  this.vColorHX = gColorHX;  //x��ʵ����ɫ
  this.vColorXX = gColorXX;   //x��������ɫ
  this.vFontSize = gFontSize;   //��λpt
  this.maxXI ;
  this.maxYI ;
  this.vWidth = gWidth;
  this.vHeight = gHeight;
  this.zeroX = gBaseX;
  this.zeroY = gHeight - gBaseY;
  this.baseX = gBaseX;
  this.baseY = gBaseY;
  this.cellXlength ;
  this.cellYlength ;
  this.originFontX = gOriginFontX;
  this.originFontY = gOriginFontY;
  this.cellY =  gCellY ;
  this.xArray ;
  this.vPercent = gPercent;
  this.clickEventFun = gClickEventFun;
  this.dblClickEventFun  = gDblClickEventFun;

  this.showX = gShowX;
  this.showY = gShowY;
  this.serialMax = 0;

  this.defaultMaxYI = 10;
  this.defaultZeroColor = "black";

  this.beginY = 0 ;//add for support negative
  this.init();


}

CoordinateSystem.prototype.init = CoordinateSystem_Init;
CoordinateSystem.prototype.initSerialInfo = CoordinateSystem_InitSerialInfo;
CoordinateSystem.prototype.getX = CoordinateSystem_GetX;
CoordinateSystem.prototype.getY = CoordinateSystem_GetY;
CoordinateSystem.prototype.getMaxX = CoordinateSystem_GetMaxX;
CoordinateSystem.prototype.getMaxY = CoordinateSystem_GetMaxY;

CoordinateSystem.prototype.draw = CoordinateSystem_Draw;
CoordinateSystem.prototype.drawBars = CoordinateSystem_DrawBars;
CoordinateSystem.prototype.drawLines = CoordinateSystem_DrawLines;

/*
  ����ϵͳ��ʼ��
*/
function CoordinateSystem_Init(){
  this.xArray = new Array();
  var tempArray = new Array();

  var maxY = 0;
  var minY = 0;
  var tempArrayLength = 0;

  for(i=0;i<this.arrayData.length;i++){
    if(parseFloat(maxY) < this.arrayData[i].y ){
      maxY = this.arrayData[i].y  ;
    }
    if(parseFloat(minY) > this.arrayData[i].y ){//add for support negative
      minY = this.arrayData[i].y  ;
    }
    if(tempArray[this.arrayData[i].x]==null){
      this.xArray[tempArrayLength++] = this.arrayData[i].x;
      tempArray[this.arrayData[i].x] = this.arrayData[i].x ;
    }
  }

  this.maxXI = this.xArray.length + 1;

  if(minY < 0){//add for support negative

      if (this.cellY == 0) {
	this.maxYI = this.defaultMaxYI;
	var rate = maxY / (-minY);
	var max = maxY;
	if(rate<1){
	  rate = (-minY) / maxY  ;
	  max = -minY;
	}

	var positiveYI = parseInt ((this.maxYI - 1)*rate/(rate+1))   ;//��֤�����ֵ��ķ�����ʵ�ʵ��٣�����ֻҪ�����������ɣ�����parseIntȡ������С�����֣����������ټ�һ
	var tempCellY = max  / positiveYI ; //modify for support negative
	var digit = 0;
	while (tempCellY > 10) {
	  tempCellY /= 10;
	  digit++;
	}
	var longPer = 1;
	tempCellY = parseInt(tempCellY);
	for (i = 0; i < digit; i++) {
	  tempCellY *= 10;
	  longPer *= 10;
	}
	if (tempCellY * positiveYI >= max) {
	  this.cellY = tempCellY;
	}
	else {
	  this.cellY = tempCellY + longPer;
	}
	this.beginY = -(this.maxYI - 1 - positiveYI) * this.cellY;

      }
      else {

	var tempUp = maxY / this.cellY + 1;
	var tempDown = -minY / this.cellY + 1;
	var positiveYI = 0;
	var negativeYI = 0;
	if (tempUp % 1 >= 0.5) {
	  positiveYI = parseInt(tempUp);
	}
	else {
	  positiveYI = parseInt(tempUp) + 1;
	}
	if (tempDown % 1 >= 0.5) {
	  negativeYI = parseInt(tempDown);
	}
	else {
	  negativeYI = parseInt(tempDown) + 1;
	}
	this.maxYI = positiveYI + negativeYI + 1;
	this.beginY = -(this.maxYI - 1 - positiveYI) * this.cellY;
      }

  }else{
    if(this.cellY==0){
    this.maxYI = this.defaultMaxYI;
    //-----------------------------����֧��Yȡ��begin---------------------------------------------
    var tempCellY = maxY / (this.maxYI - 1);
    var digit = 0;
    while(tempCellY>10){
      tempCellY /= 10;
      digit++;
    }
    tempCellY = parseInt(tempCellY)+1;
    for(i=0;i<digit;i++){
      tempCellY *= 10;
    }
    this.cellY = tempCellY;
    //this.cellY = parseInt( maxY / (this.maxYI - 1) ) + 1;
    //-----------------------------����֧��Yȡ��end---------------------------------------------
    }else{
      this.maxYI = parseInt( maxY / this.cellY + 1 ) + 1;
    }
    this.maxYI += 1;

  }
  this.cellXlength = (this.vWidth-2*this.baseX)/this.maxXI;
  this.cellYlength = (this.vHeight-2*this.baseY)/this.maxYI;

  this.x_map = new Array(this.xArray.length);
  for(i=0;i<this.xArray.length;i++){
    this.x_map[this.xArray[i]] = this.zeroX + (i+1)*this.cellXlength ;
  }



  this.initSerialInfo();

  addRondamColor(this.arrayData);

}


/*
  ת����������XֵΪ����ϵͳVML����
  dataX �� X����ֵ���ַ�����
*/
function CoordinateSystem_GetX(dataX){
  if(this.x_map==null)alert(g_I18NMessage("appframe_core","vml_no_init"));
  if(this.x_map[dataX]==null)alert(g_I18NMessage("appframe_core","vml_no_coordinate"));
  return this.x_map[dataX];
}

/*
  ת����������YֵΪ����ϵͳVML����
  dataY �� Y����ֵ��������
*/
function CoordinateSystem_GetY(dataY){
  return this.zeroY - (dataY-this.beginY)*this.cellYlength/this.cellY;//modify for support negative
//  return this.zeroY - dataY*this.cellYlength/this.cellY;
}

/*
  ȡ������ϵ���X����
*/
function CoordinateSystem_GetMaxX(){
  return this.zeroX+this.maxXI*this.cellXlength;
}

/*
  ȡ������ϵ���Y����
*/
function CoordinateSystem_GetMaxY(){
  return this.zeroY-this.maxYI*this.cellYlength;
}

/*
  ��ʼ������ά��Ϣ
*/
function CoordinateSystem_InitSerialInfo(){
  var serial_map = new Array();
  for(i=0;i<this.arrayData.length;i++){
    if(serial_map[this.arrayData[i].serialInfo]==null){
      serial_map[this.arrayData[i].serialInfo] = this.serialMax;
      this.arrayData[i].serialNum = this.serialMax;
      this.serialMax++;
    }else{
      this.arrayData[i].serialNum = serial_map[this.arrayData[i].serialInfo];
    }
  }

}

/*
  ��������ϵ
*/
function CoordinateSystem_Draw(){

  var divB = "<DIV style='WIDTH:"+this.vPercent+";HEIGHT:"+this.vPercent+"' >";
  var divE = "</DIV>";
  var strChain ;
  var beginNode = new ChainNode();
  var endNode = new ChainNode();
  beginNode.nowStr = divB;
  beginNode.next   = endNode ;
  endNode.nowStr = divE;
  endNode.next   = null ;
  strChain = beginNode;

  var groupB = "<v:group  style='WIDTH:100%;HEIGHT:100%' coordorigin='0,0' coordsize = '"+this.vWidth+","+this.vHeight+"'  >";
  var groupE = "</v:group>";
  beginNode = new ChainNode();
  endNode = new ChainNode();
  beginNode.nowStr = groupB;
  beginNode.next   = endNode ;
  endNode.nowStr = groupE;
  endNode.next   = null ;
  strChain.addNode(divE,beginNode);

  var rectB = "<v:rect style='WIDTH: 98%; HEIGHT: 98%'  fillcolor = 'white' strokecolor = 'black'><v:shadow on = 't' type = 'single' color = 'silver' offset = '4pt,3pt'></v:shadow>" ;
  var rectE = "</v:rect>" ;
  beginNode = new ChainNode();
  endNode = new ChainNode();
  beginNode.nowStr = rectB;
  beginNode.next   = endNode ;
  endNode.nowStr = rectE;
  endNode.next   = null ;
  strChain.addNode(groupE,beginNode);

  var newYB = "<v:line style='Z-INDEX: 8; POSITION: relative' from = '"+this.zeroX+","+this.getMaxY()+"' to = '"+this.zeroX+","+this.zeroY+"' strokeweight = '1pt'><v:stroke StartArrow = 'classic'></v:stroke>";
  var newYE = "</v:line>";
  beginNode = new ChainNode();
  endNode = new ChainNode();
  beginNode.nowStr = newYB;
  beginNode.next   = endNode ;
  endNode.nowStr = newYE;
  endNode.next   = null ;
  strChain.addNode(groupE,beginNode);

  var newXB = "<v:line style='Z-INDEX: 8; POSITION: relative' from = '"+this.zeroX+","+this.zeroY+"' to = '"+this.getMaxX()+","+(this.zeroY)+"' strokeweight = '1pt'><v:stroke EndArrow = 'classic'></v:stroke>";
  var newXE = "</v:line>";
  beginNode = new ChainNode();
  endNode = new ChainNode();
  beginNode.nowStr = newXB;
  beginNode.next   = endNode ;
  endNode.nowStr = newXE;
  endNode.next   = null ;
  strChain.addNode(groupE,beginNode);


  var newZeroShapeB = "<v:shape style='position:relative;left:"+this.originFontX+";top:"+this.originFontY+";WIDTH:"+((this.beginY+"").length*this.vFontSize)+"pt;HEIGHT:"+this.vFontSize+"pt;z-index:8' fillcolor='white'><v:textbox  style=' FONT-SIZE: "+this.vFontSize+"pt;' align='center' >"+this.beginY+"</v:textbox>";
  var newZeroShapeE = "</v:shape>";
  beginNode = new ChainNode();
  endNode = new ChainNode();
  beginNode.nowStr = newZeroShapeB;
  beginNode.next   = endNode ;
  endNode.nowStr = newZeroShapeE;
  endNode.next   = null ;
  strChain.addNode(groupE,beginNode);


  for(var i=1;i<=this.maxYI;i++){
     var py=this.zeroY - i*this.cellYlength;
     var strTo=(this.zeroX+this.maxXI*this.cellXlength)+" "+py;
     if(i+1>this.maxYI){
       var newShapeB = "<v:shape style='position:relative;left:"+this.originFontX+";top:"+py+";WIDTH:"+(this.showY.length*this.vFontSize)+"pt;HEIGHT:"+this.vFontSize+"pt;z-index:8'  fillcolor='white'><v:textbox  style='font-size:"+this.vFontSize+"pt;v-text-anchor:bottom-up-baseline' align='right'>"+this.showY+"</v:textbox>";
       var newShapeE = "</v:shape>";
       beginNode = new ChainNode();
       endNode = new ChainNode();
       beginNode.nowStr = newShapeB;
       beginNode.next   = endNode ;
       endNode.nowStr = newShapeE;
       strChain.addNode(groupE,beginNode);
     }else{
       var newLineB = "<v:line from='"+this.zeroX+" "+py+"' to='"+strTo+"' style='position:relative;z-index:8'>";
       var newLineE = "</v:line>";
       if(this.beginY + i*this.cellY == 0){
	 newLineB = newLineB+"<v:stroke color='"+this.defaultZeroColor+"'/>";
       }else{
	 if((i+1)%2!=0){
	   newLineB = newLineB+"<v:stroke dashstyle='dot' color='"+this.vColorHX+"'/>";
	 }else{
	   newLineB = newLineB+"<v:stroke dashstyle='dot' color='"+this.vColorXX+"'/>";
	 }
       }
       beginNode = new ChainNode();
       endNode = new ChainNode();
       beginNode.nowStr = newLineB;
       beginNode.next   = endNode ;
       endNode.nowStr = newLineE;
       endNode.next   = null ;
       strChain.addNode(groupE,beginNode);

       var newShapeB = "<v:shape style='position:relative;left:"+this.originFontX+";top:"+py+";WIDTH:"+((( parseFloat( this.beginY ) + i*this.cellY) + "").length*this.vFontSize)+"pt;HEIGHT:"+this.vFontSize+"pt;z-index:8'  fillcolor='white'><v:textbox   style='font-size:"+this.vFontSize+"pt;v-text-anchor:bottom-up-baseline' align='right'>"+(this.beginY + i*this.cellY)+"</v:textbox>";
       var newShapeE = "</v:shape>";
       beginNode = new ChainNode();
       endNode = new ChainNode();
       beginNode.nowStr = newShapeB;
       beginNode.next   = endNode ;
       endNode.nowStr = newShapeE;
       endNode.next   = null ;
       strChain.addNode(groupE,beginNode);
     }
  }

  var i = 0;
  for(i=0;i<this.xArray.length;i++){
    var xValue = this.xArray[i];
    var px=this.zeroX + (i+1)*this.cellXlength;
    var newLineB = "<v:line from='"+px+" "+this.zeroY+"' to='"+px+" "+(this.zeroY+50)+"' style='position:relative;z-index:8'><v:stroke color='black'/>";
    var newLineE = "</v:line>";
    beginNode = new ChainNode();
    endNode = new ChainNode();
    beginNode.nowStr = newLineB;
    beginNode.next   = endNode ;
    endNode.nowStr = newLineE;
    endNode.next   = null ;
    strChain.addNode(groupE,beginNode);

    var newShapeB = "<v:shape style='position:relative;left:"+(px-100)+";top:"+(this.zeroY)+";WIDTH:"+(xValue.length*this.vFontSize)+"pt;HEIGHT:"+this.vFontSize+"pt;z-index:8'  fillcolor='white'><v:textbox  style='font-size:"+this.vFontSize+"pt;v-text-anchor:bottom-right-baseline' align='right'>"+xValue+"</v:textbox>";
    var newShapeE = "</v:shape>";
    beginNode = new ChainNode();
    endNode = new ChainNode();
    beginNode.nowStr = newShapeB;
    beginNode.next   = endNode ;
    endNode.nowStr = newShapeE;
    endNode.next   = null ;
    strChain.addNode(groupE,beginNode);


  }

  var px=this.zeroX + (i+1)*this.cellXlength  - this.cellXlength/2 ;
  var newShapeB = "<v:shape style='position:relative;left:"+(px-100)+";top:"+(this.zeroY)+";WIDTH:"+(this.showX.length*this.vFontSize)+"pt;HEIGHT:"+this.vFontSize+"pt;z-index:8'  fillcolor='white'><v:textbox   style='font-size:"+this.vFontSize+"pt;v-text-anchor:bottom-right-baseline' align='right'>"+this.showX+"</v:textbox>";
  var newShapeE = "</v:shape>";
  beginNode = new ChainNode();
  endNode = new ChainNode();
  beginNode.nowStr = newShapeB;
  beginNode.next   = endNode ;
  endNode.nowStr = newShapeE;
  endNode.next   = null ;
  strChain.addNode(groupE,beginNode);

  return strChain;
}

/*
  ����ƽ����״ͼ
  strChain �� �������
  barWidthper �� ���ӿ�ȣ��ٷֱȣ�
*/
function CoordinateSystem_DrawBars(strChain,barWidthper){
  var vBarWidthper = barWidthper / this.serialMax;
  for(i=0;i<this.arrayData.length;i++){
    var px=this.getX(this.arrayData[i].x) - (this.cellXlength*vBarWidthper*(this.serialMax/2-this.arrayData[i].serialNum));
    var py=this.getY(this.arrayData[i].y);
    var tempWidth = vBarWidthper*this.cellXlength;

      var tempZeroY = this.getY(0);//add for support negative
      if(tempZeroY < py){//add for support negative
	tempHeight = parseInt(py - tempZeroY);
	py = tempZeroY;
      }else{
	tempHeight = parseInt(tempZeroY - py); //modify for support negative
      }
//    var tempHeight = this.zeroY - py;
    var rectB = "<v:rect style='position:relative;left:"+px+";top:"+py+";WIDTH: "+tempWidth+"; HEIGHT: "+tempHeight+"'  fillcolor='"+this.arrayData[i].color+"' strokecolor = 'black' ";
    if(this.clickEventFun!=null && this.clickEventFun.length > 0){
      rectB = rectB + " onclick=\""+this.clickEventFun+"('"+this.arrayData[i].x+"','"+this.arrayData[i].y+"')\"";
    }
    if(this.dblClickEventFun!=null && this.dblClickEventFun.length > 0){
      rectB = rectB + " ondblclick=\""+this.dblClickEventFun+"('"+this.arrayData[i].x+"','"+this.arrayData[i].y+"')\"";
    }
    rectB = rectB + ">";
    var rectE = "</v:rect>";
    beginNode = new ChainNode();
    endNode = new ChainNode();
    beginNode.nowStr = rectB;
    beginNode.next   = endNode ;
    endNode.nowStr = rectE;
    endNode.next   = null ;
    strChain.addNode("</v:group>",beginNode);
  }


}

/*
  ������ͼ
  strChain �� �������
*/
function CoordinateSystem_DrawLines(strChain){
  var i = 0;
  var flagArray = new Array();
  for(j=0;j<this.serialMax;j++){
    var polyLineB = "<v:polyLine style='z-index:9' filled=f strokeweight=1.5pt ";
    var polyLineE = "</v:polyLine>";
    for(i=0;i<this.arrayData.length;i++){
      if(this.arrayData[i].serialNum==j){
	      if(flagArray[j]==null){
		flagArray[j]=j;
		polyLineB = polyLineB + "strokecolor='"+this.arrayData[i].color+"'  points='";
	      }
	var px = this.getX(this.arrayData[i].x);
	//var py=zeroY - arrayData[i].y*cellYlength/cellY;
	var py = this.getY(this.arrayData[i].y);
	polyLineB = polyLineB + px + "," + py + " " ;
      }
    }
    polyLineB = polyLineB + "'>";
    beginNode = new ChainNode();
    endNode = new ChainNode();
    beginNode.nowStr = polyLineB;
    beginNode.next   = endNode ;
    endNode.nowStr = polyLineE;
    endNode.next   = null ;
    strChain.addNode("</v:group>",beginNode);
  }

}


/*
������״ͼ
baseX,baseY    �����ͣ�ԭ����ͼ���ͼ�µľ��루0������Ĭ�ϣ��ֱ�Ϊ4%��8%��0��1֮�����ٷ�����>1�����ʵ�ʳߴ磬ͼĬ�Ͽ�߷�Ϊ5000,5000��
showX          �ַ�����x����ʾ�����굥λ
cellY          �����ͣ�y����ʾ�����֣���cellYΪ50��������������ʾ������Ϊ50��100��150......��
showY          �ַ�����y����ʾ�����굥λ
outDiv         div�����ⲿ��Ҫ��ʾͼ���ڵ�div
percent        �ַ�����ͼ�Ŵ���С�ı�����2����Ϊ"200%"��
arrayData      �������ݶ���InputData������
clickEventFun  ���ͼ�ε���Ӧ�¼���Ҫ���õĺ������ƣ�������������Ϊ(x,y)
dblClickEventFun  ˫��ͼ�ε���Ӧ�¼���Ҫ���õĺ������ƣ�������������Ϊ(x,y)
*/
function createBars(baseX,baseY,showX,cellY,showY,outDiv,percent,arrayData,clickEventFun,dblClickEventFun){
  var vColorHX = "blue";  //x��ʵ����ɫ
  var vColorXX = "red";   //x��������ɫ
  var vFontSize = 10;   //��λpt
  var vWidth = 5000;
  var vHeight = 5000;
  if(baseX==null){
    baseX = 0;
  }
  if(baseX<=0){
    baseX=0.08;
  }
  if(baseX<=1){
    baseX = baseX*vWidth;
  }
  if(baseY==null){
    baseY = 0;
  }
  if(baseY<=0){
    baseY =0.08;
  }
  if(baseY<=1){
    baseY = baseY*vHeight;
  }

  var zeroX = baseX;
  var zeroY = vHeight - baseY;
  var originFontX = 0;
  var originFontY = zeroY ;

  var barWidthper = 0.6;

  if(showX==null){
    showX = "";
  }
  if(showY==null){
    showY = "";
  }

  if(cellY==null){
    cellY = 0;
  }

  if(percent==null){
    percent = "100%";
  }
  outDiv.innerHTML = "";
  var coordinate = new CoordinateSystem(arrayData,vWidth,vHeight,vColorHX,vColorXX,vFontSize,baseX,baseY,originFontX,originFontY,cellY,percent,showX,showY,clickEventFun,dblClickEventFun);

  var strChain = coordinate.draw();
  coordinate.drawBars(strChain,barWidthper);
  //alert(strChain.toString());
  //outDiv.innerHTML = "<input type=textarea  value=" +"\""+ strChain.toString() +"\""+ "></input> " ;
  outDiv.innerHTML = strChain.toString() ;

}




/*
������ͼ������һ�飩��Ϊ�ڲ��������������ṩ
beginAngle:         ��ʼ�Ƕ�
end:                �����Ƕ�
x:                  ��ͼ�ο��������
y:                  ��ͼ�ο�Ĵ����ֵ
color:              ��ͼ�ο����ɫ
r:                  ��ͼ�İ뾶
clickEventFun:      �����ͼ�ο���Ӧ�ķ�������
vWidth:             ͼ�εĿ�
vHeight:            ͼ�εĸ�

*/
function createPie(beginAngle,endAngle,x,y,color,r,clickEventFun,dblClickEventFun,vWidth,vHeight)
{
  var fs=Math.PI*2*(beginAngle/360);
  var fe=Math.PI*2*(endAngle/360);
  var sx=parseInt(r*Math.sin(fs));
  var sy=parseInt(-r*Math.cos(fs));
  var ex=parseInt(r*Math.sin(fe));
  var ey=parseInt(-r*Math.cos(fe));
  var newPie="<v:shape  style='position:relative;z-index:8;width:"+2*r+";height:"+2*r+"' coordsize = '"+vWidth+","+vHeight+"' strokeweight='1pt' fillcolor='"+color+"' strokecolor='black' path='m0,0 l "+sx+","+sy+" ar -"+r+",-"+r+","+r+","+r+","+ex+","+ey+","+sx+","+sy+" l0,0 x e' ";
    if(clickEventFun!=null && clickEventFun.length > 0){
      newPie = newPie + " onclick=\""+clickEventFun+"('"+x+"','"+y+"') \" ";
    }
    if(dblClickEventFun!=null && dblClickEventFun.length > 0){
      newPie = newPie + " ondblclick=\""+dblClickEventFun+"('"+x+"','"+y+"') \" ";
    }
    newPie = newPie + "/>";
  return newPie;
}


/*
����������ͼ
outDiv         div�����ⲿ��Ҫ��ʾͼ���ڵ�div
percent        �ַ�����ͼ�Ŵ���С�ı�����2����Ϊ"200%"��
arrayData      �������ݶ���InputData������
clickEventFun  ���ͼ�ε���Ӧ�¼���Ҫ���õĺ������ƣ�������������Ϊ(x,y)
dblClickEventFun  ˫��ͼ�ε���Ӧ�¼���Ҫ���õĺ������ƣ�������������Ϊ(x,y)
*/
function createPies(outDiv,percent,arrayData,clickEventFun,dblClickEventFun){
  var vWidth = 5000;
  var vHeight = 5000;
  var vFontSize = 10;   //��λpt
  var r = vWidth/2*0.8;
  var rate = 0.8;
  var zeroX = vWidth/2;
  var zeroY = vHeight/2;
  if(percent==null){
    percent = "100%";
  }
  outDiv.innerHTML = "";
  for(i=0;i<arrayData.length;i++){
    arrayData[i].serialNum = i;
  }
  addRondamColor(arrayData);
  var divB = "<DIV style='WIDTH:"+percent+";HEIGHT:"+percent+"' >";
  var divE = "</DIV>";
  var groupB = "<v:group  style='WIDTH:100%;HEIGHT:100%' coordorigin='-"+zeroX+",-"+zeroY+"' coordsize = '"+vWidth+","+vHeight+"' ><v:rect style='WIDTH: 98%; HEIGHT: 98%' fillcolor='white' strokecolor='black'><v:shadow on='t' type='single' color='silver' offset='4pt,3pt'/></v:rect>";
  var groupE = "</v:group>";
  var total = 0;
  for(i=0;i<arrayData.length;i++){
    total = total + parseFloat( arrayData[i].y );
  }
  var pie = "";
  var last = 0;
  var remarks = "";
  var rects = "";

  var remarkslength = ((100 * arrayData.length) > (vWidth*rate) ? (100 * arrayData.length) : (vWidth*rate))/ arrayData.length ;
  for(i=0;i<arrayData.length;i++){
    if(arrayData[i].y!=0){
      var current = last+arrayData[i].y/total*360;
      pie = pie + createPie(last,current,arrayData[i].x,arrayData[i].y,arrayData[i].color,r,clickEventFun,dblClickEventFun,vWidth,vHeight);
      last = current;
    }
    var position_x = vWidth*(1-rate)/2 + remarkslength*i - zeroX ;
    var position_y = vHeight - vHeight*0.1 - zeroY;
    rects = rects + "<v:rect style='position:relative;left:"+position_x+";top:"+position_y+";WIDTH: "+100+"; HEIGHT: "+100+"' fillcolor='"+arrayData[i].color+"' strokecolor='black'></v:rect>";
    remarks = remarks + "<v:shape style='position:relative;left:"+position_x+";top:"+(position_y+110)+";WIDTH:"+(arrayData[i].x.length*vFontSize)+"pt;HEIGHT:"+vFontSize+"pt;z-index:8'  fillcolor='white'><v:textbox   style='font-size:"+vFontSize+"pt;v-text-anchor:bottom-top-baseline' align='right'>"+arrayData[i].x+"</v:textbox></v:shape>";
  }

  //alert(divB + groupB + pie + rects + remarks + groupE + divE);
  outDiv.innerHTML = divB + groupB + pie + rects + remarks + groupE + divE;
}


/*
���������ͼ������һ�飩��Ϊ�ڲ��������������ṩ
beginAngle:         ��ʼ�Ƕ�
end:                �����Ƕ�
x:                  ��ͼ�ο��������
y:                  ��ͼ�ο�Ĵ����ֵ
color:              ��ͼ�ο����ɫ
percent:            �ÿ���ռ����
r:                  ��ͼ�İ뾶
clickEventFun:      �����ͼ�ο���Ӧ�ķ�������
dblClickEventFun��  ˫����ͼ�ο���Ӧ�ķ�������
vWidth:             ͼ�εĿ�
vHeight:            ͼ�εĸ�
paraArray��         ��ʱ��������
*/

function createTridimensionalPie(beginAngle,endAngle,x,y,color,percent,r,clickEventFun,dblClickEventFun,vWidth,vHeight,paraArray)
{
  //var fs=Math.PI*2*(beginAngle/360);
  //var fe=Math.PI*2*(endAngle/360);
  //var sx=parseInt(r*Math.sin(fs));
  //var sy=parseInt(-r*Math.cos(fs));
  //var ex=parseInt(r*Math.sin(fe));
  //var ey=parseInt(-r*Math.cos(fe));
  //var newPie="<v:shape  style='position:relative;z-index:8;width:"+2*r+";height:"+2*r+"' coordsize = '"+vWidth+","+vHeight+"' strokeweight='1pt' fillcolor='"+color+"' strokecolor='black' path='m0,0 l "+sx+","+sy+" ar -"+r+",-"+r+","+r+","+r+","+ex+","+ey+","+sx+","+sy+" l0,0 x e' ";
  var strArray = new Array();
    //var i = parseInt( Math.random() * 100 );
    r = vHeight/2;
    k2=360*percent/2;

    k3=paraArray[0]+k2;
    k8=paraArray[3]-360*percent/2;
    if(k8<0)k8=360+k8;
    paraArray[3]= k8-360*percent/2;
    //alert(paraArray[3]);
    k3=parseInt(k3%360);
    kkk=parseInt(-11796480*percent+5898240);
    k5=3.1414926*2*k8/360;

    //��������ǩ������ֹ���ͼ�����Ƴ�ͻ
    paraArray[2] = parseInt( Math.random()*10000);

    txt_x = parseInt(vWidth/10+r-r/9+r*Math.cos(k5)*0.5);
    //alert(k5 + " txt_x :" + txt_x);
    txt_y = parseInt(vHeight/10+r-r/5-r*Math.sin(k5)*0.2);
    //alert(k5 + " txt_y :" + txt_y);


    //titlestr = "&nbsp;��&nbsp;&nbsp;�ƣ�"&stat_array(i,2)&"&#13;&#10;&nbsp;��&nbsp;&nbsp;ֵ��"&stat_array(i,1)&unit&"&#13;&#10;&nbsp;��ռ������"&pie(i)*100&"%&nbsp;&nbsp;";
    strArray[strArray.length] = " <v:shape id='cake"+  paraArray[2]+"' type='#Cake_3D' ";
    strArray[strArray.length] = " style='position:absolute;left:"+parseInt(vWidth/10)+";top:"+parseInt(vHeight/10)+";WIDTH:"+parseInt(vWidth*9/10)+";HEIGHT:"+parseInt(vHeight*9/10)+";rotation:"+k3+";z-index:"+paraArray[1]+"' adj='"+kkk+",0' fillcolor='"+color+"'";
    if(clickEventFun!=null && clickEventFun.length > 0){
      strArray[strArray.length] = " onclick=\""+clickEventFun+"('"+x+"','"+y+"') \" ";
    }
    if(dblClickEventFun!=null && dblClickEventFun.length > 0){
      strArray[strArray.length] = " ondblclick=\""+dblClickEventFun+"('"+x+"','"+y+"') \" ";
    }

    strArray[strArray.length] = " onmouseover='moveup(cake"+paraArray[2]+","+parseInt(vHeight/10)+",txt"+paraArray[2]+",\"rec"+paraArray[2]+"\")' onmouseout='movedown(cake"+paraArray[2]+","+parseInt(vHeight/10)+",txt"+paraArray[2]+",\"rec"+paraArray[2]+"\")'>";
    strArray[strArray.length] = " <v:fill opacity='60293f' color2='fill lighten(120)' o:opacity2='60293f' rotate='t' angle='-135' method='linear sigma' focus='100%' type='gradient'/>";
    strArray[strArray.length] = " <o:extrusion v:ext='view' on='t' backdepth='25' rotationangle='60' viewpoint='0,0' viewpointorigin='0,0' skewamt='0' lightposition='-50000,-50000' lightposition2='50000'/>";
    strArray[strArray.length] = " </v:shape>";
    strArray[strArray.length] = " <v:shape id='txt"+paraArray[2]+"' type='#3dtxt' style='position:absolute;left:"+txt_x+";top:"+txt_y+";z-index:20;display:none;width:50; height:18;' fillcolor='#ffffff'";
    strArray[strArray.length] = " onmouseover='ontxt(cake"+paraArray[2]+","+parseInt(vHeight/10)+",txt"+paraArray[2]+",\"rec"+paraArray[2]+"\")'>";
    strArray[strArray.length] = " <v:fill opacity='60293f' color2='fill lighten(120)' o:opacity2='60293f' rotate='t' angle='-135' method='linear sigma' focus='100%' type='gradient'/>";
    strArray[strArray.length] = " <v:textpath style='font-family:\""+g_I18NMessage("appframe_core","vml_font")+"\";v-text-kern:t' trim='t' fitpath='t' string='"+parseInt(percent*100)+"%'/>";
    strArray[strArray.length] = " <o:extrusion v:ext='view' backdepth='8pt' on='t' lightposition='0,0' lightposition2='0,0'/>";
    strArray[strArray.length] = " </v:shape>" ;

    paraArray[0]=paraArray[0]+k2*2;
    if (paraArray[0]>=360) {
      paraArray[0]=paraArray[0]-360;
    }
    if (paraArray[0]>180) {
      paraArray[1]=paraArray[1]+1;
    }else{
      paraArray[1]=paraArray[1]-1;
    }
    paraArray[2]=paraArray[2]+1;

  return strArray.join("");
}


/*
�������������ͼ
outDiv         div�����ⲿ��Ҫ��ʾͼ���ڵ�div
percent        �ַ�����ͼ�Ŵ���С�ı�����2����Ϊ"200%"��
arrayData      �������ݶ���InputData������
clickEventFun  ���ͼ�ε���Ӧ�¼���Ҫ���õĺ������ƣ�������������Ϊ(x,y)
dblClickEventFun  ˫��ͼ�ε���Ӧ�¼���Ҫ���õĺ������ƣ�������������Ϊ(x,y)
*/
function createTridimensionalPies(outDiv,percent,arrayData,clickEventFun,dblClickEventFun){
  var vWidth = 5000;
  var vHeight = 5000;

  var zh = 21600/5000;

  var vFontSize = 10;   //��λpt
  var r = vWidth*zh/2*0.6;
  var rate = 0.8;
  var zeroX = 0;
  var zeroY = 0;

  if(percent==null){
    percent = "100%";
  }

  var tempPer = parseInt( percent.substr(0,percent.length-1) );
  var gWidth =   parseInt( outDiv.style.width.substr(0,outDiv.style.width.length-2) ) * tempPer / 100 * 8 /10 ;
  var gHeight =  parseInt( outDiv.style.height.substr(0,outDiv.style.height.length-2) ) * tempPer / 100 * 8 / 10  ;

  outDiv.innerHTML = "";
  for(i=0;i<arrayData.length;i++){
    arrayData[i].serialNum = i;
  }
  addRondamColor(arrayData);
  var divB = "<DIV  style='WIDTH:"+percent+";HEIGHT:"+percent+"' >";
  var divE = "</DIV>";

  var shapeTypeCake = "<v:shapetype id='Cake_3D' coordsize='"+(vWidth*zh)+","+(vHeight*zh)+"' o:spt='95' adj='11796480,5400' path='al10800,10800@0@0@2@14,10800,10800,10800,10800@3@15xe'/>";
  var shapeTypeText = "<v:shapetype id='3dtxt' coordsize='"+(vWidth*zh)+","+(vHeight*zh)+"' o:spt='136' adj='10800' path='m@7,l@8,m@5,21600l@6,21600e'>";
  shapeTypeText = shapeTypeText + "<v:path textpathok='t' o:connecttype='custom' o:connectlocs='@9,0;@10,10800;@11,21600;@12,10800' o:connectangles='270,180,90,0'/>";
  shapeTypeText = shapeTypeText + "<v:textpath on='t' fitshape='t'/>";
  shapeTypeText = shapeTypeText + "<o:lock v:ext='edit' text='t' shapetype='t'/>";
  shapeTypeText = shapeTypeText + "</v:shapetype>  ";


  var groupB = "<v:group  style='WIDTH:98%;HEIGHT:98%' coordorigin='-"+0+",-"+0+"' coordsize = '"+(vWidth*zh)+","+(vHeight*zh)+"' ><v:rect style='WIDTH: 98%; HEIGHT: 98%' fillcolor='white' strokecolor='black'><v:shadow on='t' type='single' color='silver' offset='4pt,3pt'/></v:rect>";
  var groupE = "</v:group>";
  var total = 0;
  for(i=0;i<arrayData.length;i++){
    total = total + parseFloat( arrayData[i].y );
  }
  var pie = "";
  var last = 0;
  var remarks = "";
  var rects = "";

  var remarkslength = ((100 * arrayData.length) > (vWidth*zh*rate) ? (100 * arrayData.length) : (vWidth*zh*rate))/ arrayData.length ;

  k1=180;
  k4=10;
  k6=0;
  k7=90;
  var tempParaArray = new Array();
  tempParaArray[0] = k1;
  tempParaArray[1] = k4;
  tempParaArray[2] = k6;
  tempParaArray[3] = k7;
  for(i=0;i<arrayData.length;i++){
    if(arrayData[i].y!=0){
      per = arrayData[i].y/total;
      var current = last+per*360;
      //pie = pie + createTridimensionalPie(last,current,arrayData[i].x,arrayData[i].y,arrayData[i].color,per,r,clickEventFun,dblClickEventFun,(vWidth*zh*0.8),(vHeight*zh*0.8),tempParaArray);
      pie = pie + createTridimensionalPie(last,current,arrayData[i].x,arrayData[i].y,arrayData[i].color,per,r,clickEventFun,dblClickEventFun,gWidth,gHeight,tempParaArray);
      last = current;
    }
    var position_x = vWidth*zh*(1-rate)/2 + remarkslength*i - zeroX ;
    var position_y = vHeight*zh - vHeight*zh*0.2 - zeroY;
    rects = rects + "<v:rect style='position:relative;left:"+position_x+";top:"+position_y+";WIDTH: "+1000+"; HEIGHT: "+1000+"' fillcolor='"+arrayData[i].color+"' strokecolor='black'></v:rect>";
    remarks = remarks + "<v:shape style='position:relative;left:"+position_x+";top:"+(position_y+1100)+";WIDTH:"+(arrayData[i].x.length*vFontSize*10)+"pt;HEIGHT:"+(vFontSize*10)+"pt;z-index:8'  fillcolor='white'><v:textbox   style='font-size:"+(vFontSize)+"pt;v-text-anchor:bottom-top-baseline' align='right'>"+arrayData[i].x+"</v:textbox></v:shape>";
  }

  //alert(divB + shapeTypeCake + shapeTypeText + groupB + rects + remarks + groupE + pie + divE);
  outDiv.innerText = divB + shapeTypeCake + shapeTypeText + groupB + rects + remarks + groupE + pie + divE;
  outDiv.innerHTML = divB + shapeTypeCake + shapeTypeText + groupB + rects + remarks + groupE + pie + divE;
}


var onit=true ;
var num=0 ;
var Stop;
function moveup(iteam,top,txt,rec){
 //alert("moveup");
 temp=eval(iteam);
 tempat=eval(top);
 temptxt=eval(txt);
 //temprec=eval(rec);
 at=parseInt(temp.style.top);
  //temprec.style.display = "";
 if (num>27){
  temptxt.style.display = "";
 }
 if(at>(tempat-28)&&onit){
  num++;
  temp.style.top=at-1;
  Stop=setTimeout("moveup(temp,tempat,temptxt,'')",10);
 }else{
  return;
 }
}
function movedown(iteam,top,txt,rec){
 //alert("movedown");
 temp=eval(iteam);
 temptxt=eval(txt);
 //temprec=eval(rec);
 clearTimeout(Stop);
 temp.style.top=top;
 num=0;
 temptxt.style.display = "none";
 //temprec.style.display = "none";
}
function ontxt(iteam,top,txt,rec){
 //alert("ontxt");
 temp = eval(iteam);
 temptxt = eval(txt);
 //temprec = eval(rec)
 if (onit){
  temp.style.top = top-28;
  temptxt.style.display = "";
  //temprec.style.display = "";
 }
}
function movereset(over){
 //alert("movereset");
 if (over==1){
  onit=false;
 }else{
  onit=true;
 }
}





/*
������ͼ
baseX,baseY    �����ͣ�ԭ����ͼ���ͼ�µľ��루0������Ĭ�ϣ��ֱ�Ϊ4%��8%��0��1֮�����ٷ�����>1�����ʵ�ʳߴ磬ͼĬ�Ͽ�߷�Ϊ5000,5000��
showX          �ַ�����x����ʾ�����굥λ
cellY          �����ͣ�y����ʾ�����֣���cellYΪ50��������������ʾ������Ϊ50��100��150......��
showY          �ַ�����y����ʾ�����굥λ
outDiv         div�����ⲿ��Ҫ��ʾͼ���ڵ�div
percent        �ַ�����ͼ�Ŵ���С�ı�����2����Ϊ"200%"��
arrayData      �������ݶ���InputData������
clickEventFun  ���ͼ�ε���Ӧ�¼���Ҫ���õĺ������ƣ�������������Ϊ(x,y)
dblClickEventFun  ˫��ͼ�ε���Ӧ�¼���Ҫ���õĺ������ƣ�������������Ϊ(x,y)
*/
function createLines(baseX,baseY,showX,cellY,showY,outDiv,percent,arrayData,clickEventFun,dblClickEventFun){
  var vColorHX = "blue";  //x��ʵ����ɫ
  var vColorXX = "red";   //x��������ɫ
  var vFontSize = 10;   //��λpt
  var vWidth = 5000;
  var vHeight = 5000;
  if(baseX==null){
    baseX = 0;
  }
  if(baseX<=0){
    baseX=0.08;
  }
  if(baseX<=1){
    baseX = baseX*vWidth;
  }
  if(baseY==null){
    baseY = 0;
  }
  if(baseY<=0){
    baseY =0.08;
  }
  if(baseY<=1){
    baseY = baseY*vHeight;
  }
  var zeroX = baseX;
  var zeroY = vHeight - baseY;
  var originFontX = 0;
  var originFontY = zeroY ;

  if(showX==null){
    showX = "";
  }
  if(showY==null){
    showY = "";
  }

  if(cellY==null){
    cellY = 0;
  }

  if(percent==null){
    percent = "100%";
  }


  outDiv.innerHTML = "";

  var coordinate = new CoordinateSystem(arrayData,vWidth,vHeight,vColorHX,vColorXX,vFontSize,baseX,baseY,originFontX,originFontY,cellY,percent,showX,showY,clickEventFun,dblClickEventFun);

  var strChain = coordinate.draw();
  coordinate.drawLines(strChain)


  //alert(strChain.toString());
  outDiv.innerHTML = strChain.toString();
}






