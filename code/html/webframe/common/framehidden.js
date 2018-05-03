/**

  �ļ����ƣ�publicHiddenFrame.js

  ���ߣ�����

  ����ʱ�䣺2002-10-14

  �ļ����ݣ��ṩ������д�빫��������֡���������ж�ȡ�����ķ�����

  ������

        publicFrame_putGlobal:���ñ���

        ������

          aPageName:ҳ������

          aGlobalName:ȫ�ֱ�������

          aGlobalValue:ȫ�ֱ���ֵ

       publicFrame_getGlobal:��ȡ����

       publicFrame_getSysFunPara:��ȡϵͳ����ID�������ù���ģ��ʱָ����

       ����:

          aPageName:ҳ������

          aGlobalName:ȫ�ֱ�������

       publicFrame_clearGlobal:�������

  if (publicFrame_isDebugger)  showMessage("publicFrame.js","Start");


**/

var publicFrame_PUBLICFRAME = top.FrameHidden;

var publicFrame_isDebugger = false;

function publicFrame_getSysFunPara(aParaName)

{

   var _gMENUPARA = "menuMain.jsp";

   var re = publicFrame_getGlobal(_gMENUPARA,aParaName);

   return re;

}

function publicFrame_getCurrentMenuID(){

   var _gMENUPARA = "menuMain.jsp";

   var _gMENU_ID = "MENU_ID";

   var re = publicFrame_getGlobal(_gMENUPARA,_gMENU_ID);

   return re;

}

function publicFrame_putGlobal(aPageName,aGlobalName,aGlobalValue)

{

  if (!aPageName)

  {

    if (publicFrame_isDebugger)  showMessage("publicFrame_putGlobal()ִ��ʧ�ܣ�ԭ��","����aPageNameΪ��");

      return false;

  }

  if (!aGlobalName)

  {

    if (publicFrame_isDebugger)  showMessage("publicFrame_putGlobal()ִ��ʧ�ܣ�ԭ��","����aGlobalNameΪ��");

      return false;

  }

  var obj = publicFrame_PUBLICFRAME;

  if (!obj)

  {

    if (publicFrame_isDebugger)  showMessage("publicFrame_putGlobal()ִ��ʧ��","û���ҵ�����������֡--top.FrameHidden--");

      return false;

  }

  if (publicFrame_isDebugger)  showMessage("publicFrame_putGlobal()","�ҵ�����������֡--top.FrameHidden--");

  /**

   **obj.GlobalArray:����,Array[i]��ʾPageName��Array[i].VALUE��һ��tmpGValueArray����

     tmpGValueArray:���飬Array[i]��ʾGlobalName(ȫ�ֱ���������),Array[i].VALUE��GlobalValue(ȫ�ֱ�����ֵ)

   **/

  if (!obj.GlobalArray) //���GlobalArray�����ڣ��򴴽�

  {

    if (publicFrame_isDebugger)  showMessage("publicFrame_putGlobal()->obj.GlobalArray","obj.GlobalArrayΪ��");

    obj.GlobalArray = new Array();

    var tmpGValueArray = new Array();

    var tmpObj = new Object();

    tmpObj.NAME = aGlobalName;

    tmpObj.VALUE = aGlobalValue;

    tmpGValueArray.push(tmpObj);

    var tmpObj = new Object();

    tmpObj.NAME = aPageName;

    tmpObj.VALUE = tmpGValueArray;

    obj.GlobalArray.push(tmpObj);

    if (publicFrame_isDebugger)  showMessage("publicFrame_setGlobal->obj.GlobalArray[obj.GlobalArray.length - 1].VALUE[obj.GlobalArray[obj.GlobalArray.length - 1].VALUE.length - 1].VALUE",obj.GlobalArray[obj.GlobalArray.length - 1].VALUE[obj.GlobalArray[obj.GlobalArray.length - 1].VALUE.length - 1].VALUE);

  }

  else

  {

    var tmpPage = null;

    for (var i=0;i<obj.GlobalArray.length;i++)

    {

      if (obj.GlobalArray[i]!=null&&obj.GlobalArray[i].NAME != null && obj.GlobalArray[i].NAME.toUpperCase() == aPageName.toUpperCase())
      {

        tmpPage = obj.GlobalArray[i];

        break;

      }

    } //end for

    if (tmpPage == null)

    {

      if (publicFrame_isDebugger)  showMessage("publicFrame_putGlobal()->obj.GlobalArray","obj.GlobalArray��Ϊ�յ�û��PageName="+aPageName+"��Ӧ��Ԫ��");

      var tmpGValueArray = new Array();

      var tmpObj = new Object();

      tmpObj.NAME = aGlobalName;

      tmpObj.VALUE = aGlobalValue;

      tmpGValueArray.push(tmpObj);



      var tmpObj = new Object();

      tmpObj.NAME = aPageName;

      tmpObj.VALUE = tmpGValueArray;

      obj.GlobalArray.push(tmpObj);

      if (publicFrame_isDebugger)  showMessage("obj.GlobalArray[obj.GlobalArray.length - 1].VALUE[obj.GlobalArray[obj.GlobalArray.length - 1].VALUE.length - 1].VALUE",obj.GlobalArray[obj.GlobalArray.length - 1].VALUE[obj.GlobalArray[obj.GlobalArray.length - 1].VALUE.length - 1].VALUE);

     }

     else

     {



       var tmpGValue = tmpPage.VALUE;

       if (tmpGValue == null)

       {

       	 if (publicFrame_isDebugger)  showMessage("publicFrame_putGlobal()->obj.GlobalArray","obj.GlobalArray��Ϊ������PageName="+aPageName+"��Ӧ��Ԫ�أ�����Ԫ��VALUE����Ϊ��");

         tmpGValue = new Array();

         var tmpObj = new Object();

         tmpObj.NAME = aGlobalName;

         tmpObj.VALUE = aGlobalValue;

         tmpGValue.push(tmpObj);

         if (publicFrame_isDebugger)  showMessage("obj.GlobalArray[obj.GlobalArray.length - 1].VALUE[obj.GlobalArray[obj.GlobalArray.length - 1].VALUE.length - 1].VALUE",obj.GlobalArray[obj.GlobalArray.length - 1].VALUE[obj.GlobalArray[obj.GlobalArray.length - 1].VALUE.length - 1].VALUE);

       }

       else

       {

         var bflag = false;

       	 for (var i=0;i<tmpGValue.length;i++)

       	   if (tmpGValue[i].NAME !=null && tmpGValue[i].NAME.toUpperCase() == aGlobalName.toUpperCase())

       	   {

       	     if (publicFrame_isDebugger)  showMessage("publicFrame_putGlobal()->obj.GlobalArray","obj.GlobalArray��Ϊ������"+aPageName+"��Ӧ��Ԫ�أ����Ҹ�Ԫ����������"+aGlobalName+"Ϊ�ı���");

       	     tmpGValue[i].VALUE  = aGlobalValue;

       	     bflag = true;

       	     if (publicFrame_isDebugger)  showMessage("obj.GlobalArray[obj.GlobalArray.length - 1].VALUE[obj.GlobalArray[obj.GlobalArray.length - 1].VALUE.length - 1].VALUE",obj.GlobalArray[obj.GlobalArray.length - 1].VALUE[obj.GlobalArray[obj.GlobalArray.length - 1].VALUE.length - 1].VALUE);

       	     break;

       	   }

         if (!bflag)

         {

           if (publicFrame_isDebugger)  showMessage("publicFrame_putGlobal()->obj.GlobalArray","obj.GlobalArray��Ϊ������"+aPageName+"��Ӧ��Ԫ�أ����Ǹ�Ԫ����û������"+aGlobalName+"Ϊ�ı���");

           var tmpObj = new Object();

       	   tmpObj.NAME = aGlobalName;

       	   tmpObj.VALUE = aGlobalValue;

       	   tmpGValue.push(tmpObj);

       	   if (publicFrame_isDebugger)  showMessage("obj.GlobalArray[obj.GlobalArray.length - 1].VALUE[obj.GlobalArray[obj.GlobalArray.length - 1].VALUE.length - 1].VALUE",obj.GlobalArray[obj.GlobalArray.length - 1].VALUE[obj.GlobalArray[obj.GlobalArray.length - 1].VALUE.length - 1].VALUE);

         }

       } //end if..else tmpGValue

     } //end if..esle tmpPage

  } // end if..else obj.GlobalArray

}

function publicFrame_getGlobal(aPageName,aGlobalName)

{

  if (!aPageName)

  {

    if (publicFrame_isDebugger)  showMessage("publicFrame_getGlobal()���ؿ�ֵ��ԭ��","����aPageNameΪ��");

      return null;

  }

  if (!aGlobalName)

  {

    if (publicFrame_isDebugger)  showMessage("publicFrame_getGlobal()���ؿ�ֵ��ԭ��","����aGlobalNameΪ��");

      return null;

  }

  var obj = publicFrame_PUBLICFRAME;

  if (!obj)

  {

    if (publicFrame_isDebugger)  showMessage("publicFrame_getGlobal()���ؿ�ֵ��ԭ��","û���ҵ�����������֡--top.FrameHidden--");

      return null;

  }

  if (!obj.GlobalArray)

  {

    if (publicFrame_isDebugger)  showMessage("publicFrame_getGlobal()���ؿ�ֵ��ԭ��","�ҵ�����������֡--top.FrameHidden--,��GlobalArray����Ϊ��");

      return null;

  }

  //if (publicFrame_isDebugger)  showMessage("publicFrame_getGlobal()->obj.GlobalArray",obj.GlobalArray);

  for(var i=0;i<obj.GlobalArray.length;i++)

  {

    if (obj.GlobalArray[i]!=null&&obj.GlobalArray[i].NAME != null && obj.GlobalArray[i].NAME.toUpperCase() == aPageName.toUpperCase())

    {

      if (obj.GlobalArray[i].VALUE && obj.GlobalArray[i].VALUE != null)

      {

      	for (var j=0;j<obj.GlobalArray[i].VALUE.length;j++)

      	{

      	  if (obj.GlobalArray[i].VALUE[j].NAME != null && obj.GlobalArray[i].VALUE[j].NAME.toUpperCase() == aGlobalName.toUpperCase())

      	  {

      	    if (publicFrame_isDebugger)  showMessage("publicFrame_getGlobal()����ֵ��Ϊ��->","-)");

      	    return obj.GlobalArray[i].VALUE[j].VALUE;

      	  }

      	}

      	if (publicFrame_isDebugger)  showMessage("publicFrame_getGlobal()->���ؿ�ֵ��ԭ��","obj.GlobalArray�д���PageName="+aPageName+"��Ԫ�أ�����Ԫ����û����Ϊ"+aGlobalName+"�ı���");

      	return null;

      }

      else

      {

      	if (publicFrame_isDebugger)  showMessage("publicFrame_getGlobal()->���ؿ�ֵ��ԭ��","obj.GlobalArray�д���PageName="+aPageName+"��Ԫ�أ�����Ԫ����.VALUE����Ϊ��(��������Ϊ��)!!");

      	return null;

      }

    } //end if obj.GlobalArray[i].toUpperCase() == aPageName.toUpperCase()

  }

  if (publicFrame_isDebugger)  showMessage("publicFrame_getGlobal()->���ؿ�ֵ��ԭ��","obj.GlobalArray�в�����PageName="+aPageName+"��Ԫ��");

  return null;

}

function publicFrame_clearGlobal()

{

  var obj = publicFrame_PUBLICFRAME;

  if (!obj) return;

  obj.GlobalArray = null;

}

function publicFrame_clearPageGlobal(aPageName)

{

  var obj = publicFrame_PUBLICFRAME;

  if (!obj) return;
  if(! obj.GlobalArray) return;
  for(var i=0;i<obj.GlobalArray.length;i++)

  {
    if (obj.GlobalArray[i]!=null&&obj.GlobalArray[i].NAME != null && obj.GlobalArray[i].NAME.toUpperCase() == aPageName.toUpperCase())

    {
	obj.GlobalArray[i] = null;
    }
  }

}
