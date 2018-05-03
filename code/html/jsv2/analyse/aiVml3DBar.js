
/**
����3ά��״ͼ
ʹ�÷�����var aa=new VMLBar3D(pDataObj,pContainer,pCaption,pClickEvent,pDblClickEvent);
����˵����
1��pDataObj��ֵ���飬��ԱԪ��Ҳ������
   ��Ա�����˵����
   x-��������ֵ
   y-��������ֵ
   color-��ɫ���ɿգ������ϵͳ�趨���ɫ
   toolTipText-�����ͣʱ����ʾ���ݡ�
2��pContainer ͼ����ʾ��DIV����
3��pCaption   ͼ�����
4��pClickEvent ��굥���¼��������������������������Ҳ��ܴ����ţ�
5��pDblClickEvent���˫���¼��������������������������Ҳ��ܴ����ţ�
   pClickEvent��pDblClickEvent�ᴫ������������aName,aValue.����ǰ�ڵ�ĺ�������ֵ����������ֵ
6��ÿ��ͼ���ĸ�����ȱʡ8��
7��pSerialObj ���ж�������һ���������ж��������ʱʹ�á����Ͼ��ֳ�1��2��3��4�ĸ�������ʾ��
   ��������ж�����pDataObj�е�ֵ����Ϊ����������ֵ�����顣
   �����ж���ʱpSerialObj���ô�����Ϊnull��
   pSerialObj���ж���Ľṹ��
   aSerialObj.title �������顣��{"1�·�","2�·�","3�·�","4�·�"};
   aSerialObj.color ��ɫ���顣��{"#FF00FF","#0000CD","#FF00FF","#008080"},��Ϊnull����Ϊnull����ϵͳ�������ɫ���档
   aSerialObj.toolTipText ��ͣ˵����ѡ���У�N-x���Ӧ��ֵ��T-���⣬V-��ֵ��TV-����:��ֵ��NV-����:��ֵ��NT-����:���⣬NTV-����:����:��ֵ��
*/

function VMLBar3D(pDataObj,pContainer,pCaption,pClickEvent,pDblClickEvent,pLegendNo,pSerialObj){
 this.Container=pContainer;

 var divHeight=this.Container.style.height;
 var divWidth=this.Container.style.width;
 divHeight=divHeight.substring(0,divHeight.length-2);
 divWidth =divWidth.substring(0,divWidth.length-2);

 this.Width= divWidth*0.83 || "600px";
 this.Height=divHeight*0.93 || "400px";
 this.Caption = pCaption || "";
 this.backgroundColor="";
 this.Shadow=false;
 this.BorderWidth=0;
 this.BorderColor=null;
 this.all=new Array();
 this.MaxValue=0;
 this.OnCallClickEvent=pClickEvent||null;
 this.OnCallDblClickEvent=pDblClickEvent||null;

 this.IsSerial=false;
 this.SerialObj=null;

 if (pSerialObj!=null&&pSerialObj.title.length>0){
   this.IsSerial=true;
   this.SerialObj=pSerialObj;
 }

 this.startX=500;
 this.startY=2700;
 this.LegendNo=pLegendNo||8;

 this.RandColor=function(){
  return "rgb("+ parseInt( Math.random() * 255) +"," +parseInt( Math.random() * 255) +"," +parseInt( Math.random() * 255)+")";
 }

 if (!pDataObj||pDataObj.length==0){
 	return;
 }else{
   for (var i=0;i<pDataObj.length;i++){
   	var sName=pDataObj[i].x||"δ����";
   	var sValue=pDataObj[i].y;
   	var sTooltipText=pDataObj[i].toolTipText||null;
   	var sColor=pDataObj[i].color;
        if (this.IsSerial){
          this.AddSerialData(sName,sValue);
        }else{
          this.AddData(sName,sValue,sTooltipText,sColor);
        }

   }
 }
 this.VMLObject=null;
 this.Draw();
}

VMLBar3D.prototype.AddSerialData=function(sName,sValue){

 var oData=new Object();
 oData.Name=sName;
 oData.Value=sValue;
 var aSerValue=0;
 for (var i=0;i<sValue.length;i++){
    if (sValue[i]>aSerValue){
       aSerValue=sValue[i];
    }
 }
 var iCount=this.all.length;
 //��������ӵ�ֵ�����ģ�����ֵ��Ϊ���
 if (aSerValue>this.MaxValue){
     this.MaxValue=aSerValue;
 }
 this.all[iCount]=oData;

}


VMLBar3D.prototype.AddData=function(sName,sValue,sTooltipText,sColor){

 var oData=new Object();
 oData.Name=sName;
 oData.Value=sValue;
 oData.TooltipText=sTooltipText;
 oData.Color=sColor;
 var iCount=this.all.length;
 //��������ӵ�ֵ�����ģ�����ֵ��Ϊ���
 if (sValue>this.MaxValue){
     this.MaxValue=sValue;
 }
 this.all[iCount]=oData;

}


VMLBar3D.prototype.Clear=function(){
 this.all.length=0;
}

VMLBar3D.prototype.Draw=function(){
 //�����

  var o=document.createElement("v:group");
  o.style.width=this.Width;
  o.style.height=this.Height;
  o.coordsize="3600,3600";


 //���һ��������
  var vRect=document.createElement("v:rect");
  vRect.style.width="4200px";
  vRect.style.height="3200px";
  vRect.coordsize="21600,21600";
  o.appendChild(vRect);

  var vCaption=document.createElement("v:textbox");
  vCaption.style.fontSize="24px";
  vCaption.style.height="24px"
  vCaption.style.fontWeight="bold";
  vCaption.innerHTML=this.Caption;
  vCaption.style.textAlign="center";

  vRect.appendChild(vCaption);
 //���ñ߿��С
  if(this.BorderWidth){
   vRect.strokeweight=this.BorderWidth;
  }
 //���ñ߿���ɫ
  if(this.BorderColor){
   vRect.strokecolor=this.BorderColor;
  }
 //���ñ�����ɫ
  if(this.backgroundColor){
   vRect.fillcolor=this.backgroundColor;
  }
 //�����Ƿ������Ӱ
  if(this.Shadow){
   var vShadow=document.createElement("v:shadow");
   vShadow.on="t";
   vShadow.type="single";
   vShadow.color="graytext";
   vShadow.offset="6px,6px";
   vRect.appendChild(vShadow);
  }

  //���װ�
  //��
  var botPanel=document.createElement("v:PolyLine");
  var ShiftX=-200;
  var ShiftY=+300;


  //botPanel.Points="400,2400 200,2600 3800,2600 4000,2400";
  //botPanel.Points="200,2700   0,2900 3600,2900 3800,2700";
  var point1=this.startX+","+this.startY+"  ";
  var point2=eval(this.startX-200)+","+eval(this.startY+200)+"  ";
  var point3=eval(this.startX+3400)+","+eval(this.startY+200)+"  ";
  var point4=eval(this.startX+3600)+","+eval(this.startY)+"  ";
  botPanel.Points=point1+point2+point3+point4;
  botPanel.strokecolor="#0099ff";
  var botFill=document.createElement("v:fill");
  botFill.color="#00cfef";
  botFill.angle="45";
  botFill.rotate="t";
  botFill.focus="100%";
  botFill.type="gradient";
  botPanel.appendChild(botFill);
  o.appendChild(botPanel);
  //��

  var leftPanel=document.createElement("v:PolyLine");
  //leftPanel.Points="400,2400 200,2600 200,200 400,0";
  //leftPanel.Points  ="200,2700   0,2900   0,500 200,300";
  var point1=this.startX+","+this.startY+"  ";
  var point2=eval(this.startX-200)+","+eval(this.startY+200)+"  ";
  var point3=eval(this.startX-200)+","+eval(this.startY-2200)+"  ";
  var point4=eval(this.startX)+","+eval(this.startY-2400)+"  ";
  leftPanel.Points=point1+point2+point3+point4;
  leftPanel.strokecolor="#0099ff";
  var leftFill=document.createElement("v:fill");
  leftFill.color="#00cfef";
  leftFill.angle="210";
  leftFill.rotate="t";
  leftFill.focus="100%";
  leftFill.type="gradient";
  leftPanel.appendChild(leftFill);
  o.appendChild(leftPanel);

  //����
  var facePanel=document.createElement("v:PolyLine");
  //facePanel.Points="400,0    4000,0 4000,2400 400,2400 ";
  //facePanel.Points="200,300 3800,300 3800,2700 200,2700 ";
  var point1=this.startX+","+eval(this.startY-2400)+"  ";
  var point2=eval(this.startX+3600)+","+eval(this.startY-2400)+"  ";
  var point3=eval(this.startX+3600)+","+eval(this.startY)+"  ";
  var point4=eval(this.startX)+","+eval(this.startY)+"  ";
  facePanel.Points=point1+point2+point3+point4;
  facePanel.strokecolor="#0099ff";
  var faceFill=document.createElement("v:fill");
  faceFill.color="#00cfef";
  faceFill.angle="135";
  faceFill.rotate="t";
  faceFill.focus="100%";
  faceFill.type="gradient";
  facePanel.appendChild(faceFill);
  o.appendChild(facePanel);

   if (this.IsSerial){
     this.CreateBar3DSerial(o);
   }else{
    this.CreateBar3D(o);
   }
  this.VMLObject=o;
  this.Container.appendChild(o);
}

VMLBar3D.prototype.CreateBar3D=function(vGroup){

  //ͼ��
  var vTotal=0;
  var objRow=null;
  var objCell=null;

  for(i=0;i<this.all.length;i++){
   vTotal+=this.all[i].Value;
  }
  var objLegendRect=document.createElement("v:rect");
  var objLegendTable=document.createElement("table");
  objLegendTable.cellPadding=0;
  objLegendTable.cellSpacing=1;
  objLegendTable.border=0;
  objLegendTable.width="100%";
  var aLines=parseInt(this.all.length/this.LegendNo)+1;

  with(objLegendRect){
   style.left="0px";
   style.top="3300px";
   style.width="4200px";
   style.height=200*aLines;
   coordsize="21600,21600";
   fillcolor="#e6e6e6";
   strokeweight="1px";
  }
  objRow=objLegendTable.insertRow();
  objCell=objRow.insertCell();
  objCell.colSpan="2";
  //objCell.style.border="1px outset";
  objCell.style.backgroundColor="black";
  objCell.style.padding="5px";
  objCell.style.color="window";
  objCell.style.font="caption";
  objCell.innerText=g_I18NMessage("appframe_core","vm3dbar_total")+vTotal;
  objCell.rowSpan=aLines;

  var vTextbox=document.createElement("v:textbox");
  vTextbox.appendChild(objLegendTable);
  objLegendRect.appendChild(vTextbox);

  var vShadow=document.createElement("v:shadow");
  vShadow.on="t";
  vShadow.type="single";
  vShadow.color="graytext";
  vShadow.offset="2px,2px";
  objLegendRect.appendChild(vShadow);

  vGroup.appendChild(objLegendRect);

	//	�������ֵ��
	var intMax=this.MaxValue;
	//����Ԫ�ظ���
	var intTotal=this.all.length + 1;
	//ÿ�����ӵĿ��
	var intPWidth=parseInt(1800 / intTotal,10);
	//��������ļ��
	var intPad=intPWidth * 2;

	intPWidth=(intPWidth>300?300:intPWidth);

	intMax=(parseInt(intMax / Math.pow(10,(intMax+"").length - 1)) + 1) * Math.pow(10,(intMax+"").length - 1)


	//�����µı�ǩ
	for (var i=0;i<this.all.length;i++){
		var aRoundRect=document.createElement("v:RoundRect");
		var aleft=eval(this.startX +60+ parseInt(intPad * (i + 0.5),10) - parseInt((intPWidth / 2)));
		aRoundRect.style.left=aleft;
		var atop=eval(this.startY+250);
		aRoundRect.style.top=atop;

		aRoundRect.strokecolor="transparent";
		var atextbox=document.createElement("v:textbox");
		atextbox.inset="0pt,0pt,0pt,0pt";
		atextbox.style.font.size="9pt";
		atextbox.style.color="#0099ff";
		atextbox.innerHTML=this.all[i].Name;
		aRoundRect.appendChild(atextbox);
		vGroup.appendChild(aRoundRect);
	}

	//������
	for(var i=1;i<10;i++){
		var aPoly=document.createElement("v:PolyLine");
		aPoly.filled="false";
		//aPoly.Points="200,"+eval(2600 - 240 * i)+" 400,"+eval(2400 - 240 * i)+" 4000,"+eval(2400 - 240 * i);
		var point1=eval(this.startX-200)+","+eval(this.startY+200-240*i)+"  ";
		var point2=eval(this.startX)+","+eval(this.startY-240*i)+"  ";
		var point3=eval(this.startX+3600)+","+eval(this.startY-240*i)+"  ";
		aPoly.Points=point1+point2+point3;
		aPoly.strokecolor="#0099ff";
		var aStroke=document.createElement("v:stroke");
		aStroke.dashstyle="Dash";
		aPoly.appendChild(aStroke);
		vGroup.appendChild(aPoly);
	}
	//����ߵ�����
	for(var i=1;i<11;i++){
		var aRoundRect=document.createElement("v:RoundRect");
		aRoundRect.style.left=this.startX-400;
		aRoundRect.style.top=eval(this.startY+200 - 240 * i);
		aRoundRect.strokecolor="transparent";
		var atextbox=document.createElement("v:textbox");
		atextbox.inset="0pt,0pt,0pt,0pt";
		atextbox.style.font.size="9pt";
		atextbox.style.color="#0000ff";
		atextbox.innerHTML=eval(i*(intMax / 10));
		aRoundRect.appendChild(atextbox);
		vGroup.appendChild(aRoundRect);
	}



	//����״ͼ
	var curLine=1;
	for(var i=0;i<this.all.length;i++){

		var aPoly=document.createElement("v:PolyLine");
		aPoly.style.cursor="hand";

		var point1=eval(this.startX+ parseInt(intPad * (i + 0.5),10))+","+eval(this.startY)+"  ";
		var point2=eval(this.startX+ parseInt(intPad * (i + 0.5),10))+","+eval(this.startY- parseInt(this.all[i].Value/intMax * 2400,10))+"  ";
		var point3=eval(this.startX+ parseInt(intPad * (i + 0.5),10) + intPWidth)+","+eval(this.startY- parseInt(this.all[i].Value/intMax * 2400,10))+"  ";
		var point4=eval(this.startX+ parseInt(intPad * (i + 0.5),10) + intPWidth)+","+eval(this.startY)+"  ";

	    aPoly.Points=point1+point2+point3+point4;

		aPoly.strokecolor="#000000";

    	var vBar3DId=document.uniqueID;

    	aPoly.id=vBar3DId+"_valueIndex_"+i;

		var aFill=document.createElement("v:fill");
    	var vColor=this.all[i].Color||this.RandColor();

		aFill.color=vColor;
		aFill.angle="150";
		aFill.rotate="t";
		aFill.focus="100%";
		aFill.type="gradient";
		aPoly.appendChild(aFill);

		var aExtrusion=document.createElement("v:extrusion");
		//aExtrusion.v:ext="view";
		aExtrusion.on="t";
		aExtrusion.backdepth="0" ;
		aExtrusion.foredepth=eval(parseInt(intPWidth / 10));
		aPoly.appendChild(aExtrusion);

		var aToolTipText
		if (this.all[i].TooltipText){
			aPoly.title=this.all[i].TooltipText;
		}

		if (this.OnCallClickEvent){
			aPoly.onclick=this.OnCallClickEvent+"("+i+",'"+this.all[i].Name+"','"+this.all[i].Value+"')";
		}

		if (this.OnCallDblClickEvent){
			aPoly.ondblclick=this.OnCallDblClickEvent+"("+i+",'"+this.all[i].Name+"','"+this.all[i].Value+"')";
		}

		aPoly.attachEvent("onclick",this.BarClickEvent);//�����¼�
		aPoly.attachEvent("ondblclick",this.BarDblClickEvent);//˫���¼�

		//��ʼ��ͼ��
		//�������6��ͼ��������Ҫ����
		if (i>=curLine*this.LegendNo&&i<(curLine+1)*this.LegendNo){
			objRow=objLegendTable.insertRow();
			curLine++;
		}

		objRow.style.height="8px";

		var objColor=objRow.insertCell();//��ɫ���
		objColor.style.backgroundColor=vColor;
		objColor.style.width="12px";

		objColor.Bar3DElement=vBar3DId;

		objCell=objRow.insertCell();
		objCell.style.font="icon";
		objCell.style.padding="2px";
		objCell.innerText=this.all[i].Name +":"+this.all[i].Value ;

		vGroup.appendChild(aPoly);
	}
	//��ÿ������������
	for (var i=0;i<this.all.length;i++){
		var aRoundRect=document.createElement("v:RoundRect");
		aRoundRect.style.left=eval(this.startX + parseInt(intPad * (i + 0.5),10));
		aRoundRect.style.top=eval(this.startY - parseInt(this.all[i].Value/intMax * 2400 + 100));
		aRoundRect.strokeColor="transparent";
		var aTextBox=document.createElement("v:textbox");
		aTextBox.inset="0pt,0pt,0pt,0pt";
		aTextBox.style.font.size="9pt";
		aTextBox.style.color="#ff00ff";
		aTextBox.innerHTML=this.all[i].Value;
		aRoundRect.appendChild(aTextBox);
		vGroup.appendChild(aRoundRect);
	}
}


VMLBar3D.prototype.CreateBar3DSerial=function(vGroup){

  //ͼ��
  var objRow=null;
  var objCell=null;

  var objLegendRect=document.createElement("v:rect");
  var objLegendTable=document.createElement("table");
  objLegendTable.cellPadding=0;
  objLegendTable.cellSpacing=1;
  objLegendTable.border=0;
  objLegendTable.width="100%";
  var aLines=parseInt(this.all.length/this.LegendNo)+1;

  with(objLegendRect){
   style.left="0px";
   style.top="3300px";
   style.width="4200px";
   style.height=200*aLines;
   coordsize="21600,21600";
   fillcolor="#e6e6e6";
   strokeweight="1px";
  }
  objRow=objLegendTable.insertRow();

  var vTextbox=document.createElement("v:textbox");
  vTextbox.appendChild(objLegendTable);
  objLegendRect.appendChild(vTextbox);

  var vShadow=document.createElement("v:shadow");
  vShadow.on="t";
  vShadow.type="single";
  vShadow.color="graytext";
  vShadow.offset="2px,2px";
  objLegendRect.appendChild(vShadow);

  vGroup.appendChild(objLegendRect);

	//�������ֵ��
	var intMax=this.MaxValue;
	//����Ԫ�ظ���
	//var intTotal=this.all.length + 1;
        var intTotal=0;
        for (var i=0;i<this.all.length;i++){
          intTotal+=this.all[i].Value.length;
        }
        intTotal+=1;

	//ÿ�����ӵĿ��
	var intPWidth=parseInt(1800 / intTotal,10);
	//��������ļ��,��ϵ�����������ӵĿ�ȵ�2��
	var intPad=(this.SerialObj.title.length)*2*intPWidth;

	intPWidth=(intPWidth>300?300:intPWidth);
	intMax=(parseInt(intMax / Math.pow(10,(intMax+"").length - 1)) + 1) * Math.pow(10,(intMax+"").length - 1)


	//�����µı�ǩ
	for (var i=0;i<this.all.length;i++){
		var aRoundRect=document.createElement("v:RoundRect");
		var aleft=eval(this.startX +60+ parseInt(intPad * (i + 0.3),10) - parseInt((intPWidth / 2)));
		aRoundRect.style.left=aleft;
		var atop=eval(this.startY+250);
		aRoundRect.style.top=atop;

		aRoundRect.strokecolor="transparent";
		var atextbox=document.createElement("v:textbox");
		atextbox.inset="0pt,0pt,0pt,0pt";
		atextbox.style.font.size="9pt";
		atextbox.style.color="#0099ff";
		atextbox.innerHTML=this.all[i].Name;
		aRoundRect.appendChild(atextbox);
		vGroup.appendChild(aRoundRect);
	}

	//������
	for(var i=1;i<10;i++){
		var aPoly=document.createElement("v:PolyLine");
		aPoly.filled="false";
		//aPoly.Points="200,"+eval(2600 - 240 * i)+" 400,"+eval(2400 - 240 * i)+" 4000,"+eval(2400 - 240 * i);
		var point1=eval(this.startX-200)+","+eval(this.startY+200-240*i)+"  ";
		var point2=eval(this.startX)+","+eval(this.startY-240*i)+"  ";
		var point3=eval(this.startX+3600)+","+eval(this.startY-240*i)+"  ";
		aPoly.Points=point1+point2+point3;
		aPoly.strokecolor="#0099ff";
		var aStroke=document.createElement("v:stroke");
		aStroke.dashstyle="Dash";
		aPoly.appendChild(aStroke);
		vGroup.appendChild(aPoly);
	}
	//����ߵ�����
	for(var i=1;i<11;i++){
		var aRoundRect=document.createElement("v:RoundRect");
		aRoundRect.style.left=this.startX-400;
		aRoundRect.style.top=eval(this.startY+200 - 240 * i);
		aRoundRect.strokecolor="transparent";
		var atextbox=document.createElement("v:textbox");
		atextbox.inset="0pt,0pt,0pt,0pt";
		atextbox.style.font.size="9pt";
		atextbox.style.color="#0000ff";
		atextbox.innerHTML=eval(i*(intMax / 10));
		aRoundRect.appendChild(atextbox);
		vGroup.appendChild(aRoundRect);
	}



    //����״ͼ
    var curLine=1;
    //�趨��ɫ
    for (var i=0;i<this.SerialObj.title.length;i++){
      if (!this.SerialObj.color||!this.SerialObj.color[i]){
        if (!this.SerialObj.color){
          this.SerialObj.color =new Array();
        }
        this.SerialObj.color[i]=this.RandColor();
      }
    }
    for(var i=0;i<this.all.length;i++){
        //��ÿ��ϵ�н���ѭ��
        var startXPos=0;
        for (var j=0;j<this.SerialObj.title.length;j++){
          var aPoly=document.createElement("v:PolyLine");
          aPoly.style.cursor="hand";
          var aValue=0;
          if (this.all[i].Value[j]){
            aValue=this.all[i].Value[j];
          }
          var tmpNo = g_I18NMessage("appframe_core","vm3dbar_no");
          var aTitle=tmpNo;
          if (this.SerialObj.title[j]){
            aTitle=this.SerialObj.title[j];
          }
          var aName=tmpNo;
          if (this.all[i].Name){
            aName=this.all[i].Name;
          }
          var thisStartXPos;
          if (j==0){
            thisStartXPos=eval(this.startX+ parseInt(intPad * (i + 0.3),10));
            startXPos=thisStartXPos;
          }else{
            thisStartXPos=eval(startXPos+j*intPWidth);
          }
          var point1=eval(thisStartXPos)+","+eval(this.startY)+"  ";
          var point2=eval(thisStartXPos)+","+eval(this.startY- parseInt(aValue/intMax * 2400,10))+"  ";
          var point3=eval(thisStartXPos+intPWidth)+","+eval(this.startY- parseInt(aValue/intMax * 2400,10))+"  ";
          var point4=eval(thisStartXPos + intPWidth)+","+eval(this.startY)+"  ";
          aPoly.Points=point1+point2+point3+point4;
          //alert("����"+i+"����"+j+"λ�ã�"+point1);
          aPoly.strokecolor="#000000";
          var vBar3DId=document.uniqueID;
          aPoly.id=vBar3DId+"_valueIndex_"+i;
          var aFill=document.createElement("v:fill");
          var vColor=this.SerialObj.color[j];
          aFill.color=vColor;
          aFill.angle="150";
          aFill.rotate="t";
          aFill.focus="100%";
          aFill.type="gradient";
          aPoly.appendChild(aFill);
          var aExtrusion=document.createElement("v:extrusion");
          //aExtrusion.v:ext="view";
          aExtrusion.on="t";
          aExtrusion.backdepth="0" ;
          aExtrusion.foredepth=eval(parseInt(intPWidth / 10));
          aPoly.appendChild(aExtrusion);
          var aToolTipText="";

          if (this.SerialObj.toolTipText){
            //��ͣ˵����ѡ���У�N-x���Ӧ��ֵ��T-���⣬V-��ֵ��TV-����:��ֵ��NV-����:��ֵ��NT-����:���⣬NTV-����:����:��ֵ��
            //N��x���Ӧ��ֵ
            //T��Y���Ӧ�ı���
            //V��Y���ά����ֵ��
            //aSerialObj.toolTipText=null;//û��tooltiptext
            //aSerialObj.toolTipText="N";//NAME
            //aSerialObj.toolTipText="T";//title
            //aSerialObj.toolTipText="V";//value
            //aSerialObj.toolTipText="TV";//title:value
            //aSerialObj.toolTipText="NV";//NAME:value
            //aSerialObj.toolTipText="NT";//NAME:title
            //aSerialObj.toolTipText="NTV";//NAME:title:value
            if (this.SerialObj.toolTipText=="T"){
              aToolTipText=aTitle;
            }else if (this.SerialObj.toolTipText=="V"){
              aToolTipText=aValue;
            }else if (this.SerialObj.toolTipText=="TV"){
              aToolTipText=aTitle+":"+aValue;
            }else if (this.SerialObj.toolTipText=="NTV"){
              aToolTipText=aName+":"+aTitle+":"+aValue;
            }else if (this.SerialObj.toolTipText=="NV"){
              aToolTipText=aName+":"+aValue;
            }else if (this.SerialObj.toolTipText=="N"){
              aToolTipText=aName;
            }else if (this.SerialObj.toolTipText=="NT"){
              aToolTipText=aName+":"+aTitle;
            }
            aPoly.title=aToolTipText;
          }

          if (this.OnCallClickEvent){
                  aPoly.onclick=this.OnCallClickEvent+"("+i+",'"+aName+"-"+aTitle+"','"+aValue+"')";
          }
          if (this.OnCallDblClickEvent){
                  aPoly.ondblclick=this.OnCallDblClickEvent+"("+i+",'"+aName+"-"+aTitle+"','"+aValue+"')";
          }
          aPoly.attachEvent("onclick",this.BarClickEvent);//�����¼�
          aPoly.attachEvent("ondblclick",this.BarDblClickEvent);//˫���¼�
          //��ʼ��ͼ��
          //�������6��ͼ��������Ҫ����
          //ֻ�е�һ�����ݲŻ�ͼ������Ϊ���������е�ͼ����ÿ�����ݶ�һ����
          if (i==0){
              if (i>=curLine*this.LegendNo&&i<(curLine+1)*this.LegendNo){
                      objRow=objLegendTable.insertRow();
                      curLine++;
              }
              objRow.style.height="8px";
              var objColor=objRow.insertCell();//��ɫ���
              objColor.style.backgroundColor=this.SerialObj.color[j];
              objColor.style.width="12px";
              objColor.Bar3DElement=vBar3DId;

              objCell=objRow.insertCell();
              objCell.style.font="icon";
              objCell.style.padding="2px";
              objCell.innerText=aTitle;
          }
          vGroup.appendChild(aPoly);
      }
    }
    //��ÿ������������
    var startXPos=0;
    for (var i=0;i<this.all.length;i++){
        for (var j=0;j<this.SerialObj.title.length;j++){
          var aValue=this.all[i].Value[j];
          var thisStartXPos;
          if (j==0){
            thisStartXPos=eval(this.startX+ parseInt(intPad * (i + 0.3),10));
            startXPos=thisStartXPos;
          }else{
            thisStartXPos=eval(startXPos+j*intPWidth);
          }
          var aRoundRect=document.createElement("v:RoundRect");
          aRoundRect.style.left=eval(thisStartXPos);
          aRoundRect.style.top=eval(this.startY - parseInt(aValue/intMax * 2400 + 100));
          aRoundRect.strokeColor="transparent";
          var aTextBox=document.createElement("v:textbox");
          aTextBox.inset="0pt,0pt,0pt,0pt";
          aTextBox.style.font.size="9pt";
          aTextBox.style.color="#ff00ff";
          aTextBox.innerHTML=aValue;
          aRoundRect.appendChild(aTextBox);
          vGroup.appendChild(aRoundRect);
        }
    }
}


VMLBar3D.prototype.Refresh=function(){

}

VMLBar3D.prototype.Zoom=function (iValue){
 var vX=3600;
 var vY=3600;
 this.VMLObject.coordsize=parseInt(vX / iValue) +","+parseInt(vY /iValue);
}

VMLBar3D.prototype.Clear=function(){
 this.all.length=0;
}


VMLBar3D.prototype.BarClickEvent = function (){
	 var eSrc=window.event.srcElement;
	 var aFunc=eSrc.onclick;
	 try{
	 	if (aFunc){
	 		eval(aFunc);
	 	}
	 }catch(ex){
	   alert(ex.name+","+ex.message);
	 }
}

VMLBar3D.prototype.BarDblClickEvent = function (){
	 var eSrc=window.event.srcElement;
	 var aFunc=eSrc.ondblclick;
	 try{
	 	if (aFunc){
	 		eval(aFunc);
	 	}
	 }catch(ex){
	   alert(ex.name+","+ex.message);
	 }
}
