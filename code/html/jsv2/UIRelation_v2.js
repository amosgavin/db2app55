/**
	�ļ����ƣ�UIRelation.js
	����	: ǽ ��
	����ʱ��: 2002-09-25
	�ļ����ݣ�����������֮��Ĺ�ϵ
	��������

**/

/******************************************************************************
 *
 *  ����Ԫ�ع�ϵ�������,�ڶ����ڲ�����һ����������顣
 *
******************************************************************************/
function UIRelationFactory(parent,xmlNode)
{
  this.List = new Array();
  this.Parent = null;
  if (parent ) this.Parent = parent;
  if (xmlNode)
  {
    for(var i=0;i < xmlNode.childNodes.length;i++)
       this.List[this.List.length] = (new UIRelation(this,xmlNode.childNodes(i)));
  }
  this.setParent = function(parent) { this.Parent = parent;}
  this.getParent = function() { return this.Parent;}

          /*
          * �����¼�Դ���ƺ��¼����Ʋ��ҽ����ϵ����
          */
  this.findUIRelation = function(sourceName,eventName)
          {
            var result = new Array();
            for(var i=0;i<this.List.length;i++)
            {// alert(this.List[i].getSource()  +'----' + sourceName + '--' +this.List[i].getSourceEventName() +'---' + eventName);
             if (compareObjectName(this.List[i].getSource(),sourceName) && (this.List[i].getSourceEventName() == eventName))
                 result[result.length] = (this.List[i]);
            }
            return result;
          }
          /*
          * �����¼�
          */
  this.triggerEvent = function(event)
          { //alert(event.getSource().getName() +'---'+ event.getName());
            var sourceName;
            if (event.getSource().getHtmlObjectName) sourceName = event.getSource().getHtmlObjectName();
            else sourceName = event.getSource().getName();
            var relationList = this.findUIRelation(sourceName,event.getName());
            for(var i =0;i<relationList.length;i++)
              relationList[i].sendEventToTarget(event);


          }
}

/******************************************************************************
 *
 *  ����Ԫ�ع�ϵ����,�ڶ����ڲ�����һ����������顣
 *
******************************************************************************/
function UIRelation(parent,xmlNode)
{
  this.Source = null; //�¼�Դ
  this.SourceEventName = null;
  this.Target = null; //������Ŀ�����
  this.TargetEventName = null;
  this.Condition = null ;//��������
  this.Parent = null;
  if (parent ) this.Parent = parent;

  if(xmlNode)
  {  var tmpNode ;
     for(var i=0;i < xmlNode.childNodes.length;i++)
     { tmpNode = xmlNode.childNodes(i);
       if (tmpNode.nodeName == "Source")
         this.Source = tmpNode.text;
       else if (tmpNode.nodeName == "SourceEvent")
         this.SourceEventName = tmpNode.text;
       else if (tmpNode.nodeName == "Target")
         this.Target = tmpNode.text;
       else if (tmpNode.nodeName == "TargetEvent")
         this.TargetEventName = tmpNode.text;
       else if (tmpNode.nodeName == "Condition")
         this.Condition = tmpNode.text;
     }
  }
  this.setParent = function(parent) { this.Parent = parent;}
  this.getParent = function() { return this.Parent;}
  this.getSource = function() { return this.Source; }
  this.setSource = function(source) { this.Source = source; }
  this.getSourceEventName = function() { return this.SourceEventName; }
  this.setSourceEventName = function(sourceEventName) { this.SourceEventName = sourceEventName; }
  this.getTarget = function() { return this.Target; }
  this.setTarget = function(target) { this.Target = target; }
  this.getTargetEventName = function() { return this.TargetEventName; }
  this.setTargetEventName = function(targetEventName) { this.TargetEventName = targetEventName; }
  this.getCondition = function() { return this.Condition; }
  this.setCondition = function(Condition) { this.Condition = Condition; }
  this.sendEventToTarget = function(sourceEvent)
              {
                var sourceName = sourceEvent.getSource().getHtmlObjectName();
                var targetName = match(sourceName,this.getTarget());
                var SourceObj = sourceEvent.getSource();
                var TargetObj = getDataSet(this).findDataObj(targetName);
                //alert(targetName);
                if(this.getCondition())
                {  //alert(this.getCondition());
                   var b = eval(this.getCondition());
                   //alert(this.getCondition() +'---'+ b);
                   if (b==false)
                      return;
                }
                //���¼����ƣ�Դ���󣬲����б���Ϊ��������Ŀ�����receiveEvent����
                //alert(TargetObj.getHtmlObjectName());
                if (TargetObj)
                {  //alert(TargetObj.getHtmlObjectName());
                   var event = new UIEvent(this.getTargetEventName(),sourceEvent.getSource(),sourceEvent.getWindowEvent());
                   TargetObj.triggerEvent(event );
                }
              }
}

/******************************************************************************
 *
 *  ����Ԫ���¼�����,�ڶ����ڲ�����һ����������顣
 *
******************************************************************************/
function UIEvent(name,source,windowEvent)
{
   this.Name = null;    //�¼�����
   this.Source = null;  //�����¼��Ķ���
   this.WindowEvent = null; //�¼���������
   if(name)
      this.Name = name;
   if(source)
      this.Source = source;
   if(windowEvent)
      this.WindowEvent = windowEvent;

   this.getName = function() { return this.Name;}
   this.setName = function(name) { this.Name = name;}
   this.getSource = function() { return this.Source;}
   this.setSource = function(source) {  this.Source = source;}
   this.getWindowEvent = function() { return this.WindowEvent;}
   this.setWindowEvent = function(windowEvent) {  this.WindowEvent = windowEvent;}
}
