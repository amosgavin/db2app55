  /**
   ��
   ������ �� ����   2004/05/18

   ��
     AIPopMenu:�����˵��ؼ�

                  ���췽���� var popMenu = new AIPopMenu(pAIPopMenuModel) ����pAIPopMenuModelΪpopMenu����Model

                  ������Ա����ʹ�÷�����

                  showPopMenu() ��ʾ�˵�

                  hidePopMenu() ���ز˵�

                  reload(pModel) ���ز˵� pModel-�˵�������model;

                  setItemEnabledById(pItemIdStr,flag)   ����ĳ���˵����Ƿ���Ч,
                                                           ����;pItemIdStr �˵���Id������ж����","�ָ���
                                                                    flag       ����ֵ��true��ʾ�������ϵĲ˵�����Ч��false��������Ч.
          setItemEnabledByName(pName,flag) ����ĳ���˵����Ƿ���Ч
                                        ����;pName �˵��
                                                                    flag       ����ֵ��true��ʾ�������ϵĲ˵�����Ч��false��������Ч.

                  setItemHideById(pItemIdStr,flag)  ����ĳ���˵�����Ƿ�����״̬Ϊenable/disable
                                                                                   ����;pItemIdStr �˵���Id������ж����","�ָ���
                                                                                   flag Ϊ����ֵ��true��ʾ�������ϵĲ˵������أ�false��������ʾ.
          setItemHideByName(pItemName,flag)  ����ĳ���˵�����Ƿ�����״̬Ϊenable/disable
                                                                                   ����;pItemName �˵���Id��
                                                                                   flag Ϊ����ֵ��true��ʾ�������ϵĲ˵������أ�false��������ʾ.


                  removeItemById(pItemId)  ɾ��ĳ���˵���;
                  removeItemByName(pItemName)  ɾ��ĳ���˵���;��������

     AIPopMenuModel�������˵�������model

                  addPopMenuItem(pItemId,pItemName,pParentItemId,pFuncName) ����һ���˵���
                             ����: pItemId���˵����Ψһ��ʾ
                                           pItemName���˵�������
                                                   pParentItemId �� �˵������ڵ��ϼ��˵�������main���˵�����ֵΪnull
                                                   pFuncName - ����˵���Ҫ������js�����ĺ�������.

                  addPopMenuItemByRowSet(pRowSet,pIdCol,pNameCol,pParentIdCol,pFuncCol) ͨ��һ��NormalRowSet���Ӳ˵���
                             ����: pRowSet- NormalRowSet����
                                           pIdCol���˵����Ψһ��ʾ���ڵ�����
                                           pNameCol���˵����������ڵ�����
                                                   pParentIdCol �� �˵������ڵ��ϼ��˵������ڵ�������
                                                   pFuncCol - ����˵���Ҫ������js�����ĺ����������ڵ�����


          addSeparator(pParentId) ����һ���ָ��� ������pParentId - �˵������ڵ��ϼ��˵�������main���˵�����ֵΪnull


  ***********/









  /**********************begin AIPopMenu.js ****************************************/

  /*************************ȫ�ֺ���*********************************************/
  var g_AIPopMenuManager = new AIPopMenuManager();

  function AIPopMenuManager()
   {
           this.AIPopMenuList = new Array();
           this.MaxId = 0;
           this.getNewPK = function()
                   {
                    this.MaxId = this.MaxId + 1;

                    return "AIPopMenu_" + this.MaxId;
               }
           this.push = function(pAIPopMenu)
                   {
                    this.AIPopMenuList[pAIPopMenu.PK] = pAIPopMenu;
               }
           this.get = function(pk)
                   {
                    return this.AIPopMenuList[pk];
               }
       this.getAIPopMenuList = function()
               {
                     return this.AIPopMenuList;
               }


    }


  /*************************END OF ȫ�ֺ���*********************************************/




  function AIPopMenu(pAIPopMenuModel)
  {
     this.PK = g_AIPopMenuManager.getNewPK();
     g_AIPopMenuManager.push(this);

     this.model = pAIPopMenuModel;

     /*���������Ѿ����ɵĲ�ͬ������չ�˵�����󼶱��*/
     this.maxDivLevel =-1;

     //this.AIMenuDivArray = new Array();
     //this.clearPopMenu = AIClearPopMenuFunc;
    /*PopDiv�����Ƴ��¼����� 2006-04-21 zhanglh*/
    this.onMouseEnter="";
    this.onMouseLeave="";
  }

  AIPopMenu.prototype.showPopMenu = AIPopMenu_showMenu;
  AIPopMenu.prototype.hidePopMenu = AIPopMenu_hideMenu;
  AIPopMenu.prototype.reload = AIPopMenu_reloadPopMenu;
  AIPopMenu.prototype.setItemEnabledById = AIPopMenu_setItemEnabled;
  AIPopMenu.prototype.setItemEnabledByName = AIPopMenu_setItemEnableByName;
  AIPopMenu.prototype.setItemHideById = AIPopMenu_setItemHideById;
  AIPopMenu.prototype.setItemHideByName = AIPopMenu_setItemHideByName;

  AIPopMenu.prototype.removeItemById = AIPopMenu_removeItemById;
  AIPopMenu.prototype.removeItemByName = AIPopMenu_removeItemByName;

  AIPopMenu.prototype.removeChildItem = AIRemoveChildItemFunc;

  AIPopMenu.prototype.setOnMouseEnter=AIPopMenu_setOnMouseEnter;
  AIPopMenu.prototype.setOnMouseLeave=AIPopMenu_setOnMouseLeave;

  //�����еĲ˵��������ء�
  function AIPopMenu_hideMenu()
  {
     for(var i=0;i<=this.maxDivLevel;i++)
          {
             if(document.getElementById(this.PK+"_"+i))
                     document.getElementById(this.PK+"_"+i).style.visibility="hidden";
          }
  }



  //��ʾ��һ�������˵�
  function AIPopMenu_showMenu()
  {

    // if(this.maxDivLevel==-1)
    //   this.maxDivLevel = 0;
    if(this.maxDivLevel!=-1)
          {
            this.hidePopMenu();
          }
     var popMenuDiv = buildPopMenuDiv(this.PK+"_0",null,this,this.onMouseEnter,this.onMouseLeave);

     //��ʾ�Ҽ����˵�
     popMenuDiv.style.posLeft=document.body.scrollLeft+window.event.clientX;
     popMenuDiv.style.posTop=document.body.scrollTop+window.event.clientY;
     //alert("x="+document.body.scrollposLeft+window.event.clientX+" y="+document.body.scrollposTop+window.event.clientY);
     if(popMenuDiv.style.posLeft+popMenuDiv.offsetWidth > document.body.scrollLeft+document.body.clientWidth)
           popMenuDiv.style.posLeft=document.body.scrollLeft+document.body.clientWidth-popMenuDiv.offsetWidth;
     if(popMenuDiv.style.posLeft < 0)
                  popMenuDiv.style.posLeft=0;
     if(popMenuDiv.style.posTop+popMenuDiv.offsetHeight > document.body.scrollTop+document.body.clientHeight)
                  popMenuDiv.style.posTop=document.body.scrollTop+document.body.clientHeight-popMenuDiv.offsetHeight;
     if(popMenuDiv.style.posTop < 0)
                  popMenuDiv.style.posTop=0;
     //alert("x="+popMenuDiv.style.posLeft+" y="+popMenuDiv.style.posTop);
     popMenuDiv.style.visibility="visible";



  }

  function buildPopMenuDiv(pDivId,pParentId,pSelPopMenuObj,pOnMouseEnter,pOnMouseLeave)
  {

          var popMenuDiv = document.getElementById(pDivId);
          if(popMenuDiv)
          {
                  popMenuDiv.innerHTML="";

          }
          else
          {
         //alert("create");
             popMenuDiv = document.createElement("DIV");
             //popMenuDiv.OBJPK = pSelPopMenuObj.PK;
         popMenuDiv.id = pDivId;
         //popMenu���д�����Ԫ�ض�����isAiPopElement="true"���ԣ�
         //�Դ��������Ƿ���ͬһ��popMenu���ƶ���ꡣ
         popMenuDiv.isAiPopElement="true";
         popMenuDiv.className = "aipopmenu_backdiv";
             popMenuDiv.style.width=0;
             popMenuDiv.style.height=0;
             popMenuDiv.style.position="absolute";
             popMenuDiv.style.visibility = "visible";
             popMenuDiv.oncontextmenu = function noneRightFunc(){ window.event.returnValue=false;window.event.cancelBubble=true;};
              //����DIV����������¼���
              //����Ǳ��˵����Ӳ˵����ڲ�֮���ƶ����򲻴����¼���
             if (pOnMouseEnter!=null&&pOnMouseEnter!="")
               popMenuDiv.onmouseenter=function doOnmousEnter(){
                var fromObj=null;
                var toObj = null;
                if(window.event){
                  toObj = window.event.toElement;
                  fromObj = window.event.fromElement;
                }
                //��popMenu�ڲ��ƶ�����popMenu����ʱ�������¼�
                if (toObj!=null&&fromObj!=null
                &&toObj.isAiPopElement&&fromObj.isAiPopElement
                &&toObj.isAiPopElement=="true"&&fromObj.isAiPopElement=="true"
                ||popMenuDiv.style.visibility=="hidden"){
                }else{
                  eval(pOnMouseEnter);
                }
             };
             //����DIV������Ƴ��¼���
             if (pOnMouseLeave!=null&&pOnMouseLeave!="")
                popMenuDiv.onmouseleave=function doOnmousLeave(){
                var fromObj=null;
                var toObj = null;
                if(window.event){
                  toObj = window.event.toElement;
                  fromObj = window.event.fromElement;
                }
                //��popMenu�ڲ��ƶ�����popMenu����ʱ�������¼�
                if (toObj!=null&&fromObj!=null
                &&toObj.isAiPopElement&&fromObj.isAiPopElement
                &&toObj.isAiPopElement=="true"&&fromObj.isAiPopElement=="true"
                ||popMenuDiv.style.visibility=="hidden"){
                }else{
                  eval(pOnMouseLeave);
                }
             };

             pSelPopMenuObj.maxDivLevel+=1;

             document.body.appendChild(popMenuDiv);



      }
          if(pParentId==null)
             var menuItemArray = pSelPopMenuObj.model.getMainMenu();
          else
         var menuItemArray = pSelPopMenuObj.model.getSubMenu(pParentId);
          //alert("menuItemArray.length="+menuItemArray.length);
          var menuDivArray = new Array();
          menuDivArray[menuDivArray.length]=" <table isAiPopElement=\"true\" cellpadding=0 cellspacing=0 width='100%' oncontextmenu=\"window.event.cancelBubble=true;window.event.returnValue=null;\"> ";
      for(var i=0;i<menuItemArray.length;i++)
          {

             if(menuItemArray[i]==null)
                     continue;
              if(menuItemArray[i].level==-1)
                menuItemArray[i].level = pSelPopMenuObj.maxDivLevel;
             //�ָ���
             if(menuItemArray[i].state=="S")
                  {
                    menuDivArray[menuDivArray.length]="<tr isAiPopElement=\"true\" style='padding-posLeft:1;height: 3;' class='aipopmenu_menu' onclick='window.event.cancelBubble=true;' onmouseup='window.event.cancelBubble=true;'><td isAiPopElement=\"true\" colspan='2'><hr isAiPopElement=\"true\" class='aipopmenu_sepa'></td></tr>";
                  }
         //�˵����Ѿ�������
             else if(menuItemArray[i].state=="H")
                  {
                    continue;
                  }
         //�˵����Ѿ�����ΪDisabled
             else if(menuItemArray[i].state=="E")
                  {
                     menuDivArray[menuDivArray.length]=" <tr isAiPopElement=\"true\" PK=\""+pSelPopMenuObj.PK+"\" id=\""+menuItemArray[i].itemId+"\" level = \""+menuItemArray[i].level+"\" class='aipopmenu_menu'";
                     menuDivArray[menuDivArray.length]=" onMouseOver=\"this.className='aipopmenu_overmenu'; \"";
                     menuDivArray[menuDivArray.length]=" onMouseOut=\"this.className='aipopmenu_menu';\" ";
                     menuDivArray[menuDivArray.length]=" onmousedown=\"window.event.cancelBubble=true;window.event.returnValue=null;\"";
                     menuDivArray[menuDivArray.length]=" onmouseup=\"window.event.cancelBubble=true;window.event.returnValue=null;\"";
                     menuDivArray[menuDivArray.length]=" onclick=\"window.event.cancelBubble=true;window.event.returnValue=null;\">";
                     menuDivArray[menuDivArray.length]=" <td isAiPopElement=\"true\" nowrap class=\"aipopmenu_disablemenutext\">";
                     menuDivArray[menuDivArray.length]="&nbsp;"+menuItemArray[i].itemName+"&nbsp</td>";
                     if(menuItemArray[i].isChild)
                            menuDivArray[menuDivArray.length]="<td isAiPopElement=\"true\" class=\"aipopmenu_disablemenutext\" style='font-family: webdings; text-align: right;'>4</td>";
                     else
                            menuDivArray[menuDivArray.length]="<td isAiPopElement=\"true\"></td>";
                     menuDivArray[menuDivArray.length]="</tr>";
                  }
             else if(menuItemArray[i].state=="U")
                  {
                     menuDivArray[menuDivArray.length]=" <tr isAiPopElement=\"true\" PK=\""+pSelPopMenuObj.PK +"\" id=\""+menuItemArray[i].itemId+"\" level = \""+menuItemArray[i].level+"\" class='aipopmenu_menu'";
                     if(menuItemArray[i].isChild)
                          {
                             menuDivArray[menuDivArray.length]=" onMouseOver=\"p_AIMouseOver(this,'"+pOnMouseEnter+"','"+pOnMouseLeave+"')\"";
                             menuDivArray[menuDivArray.length]=" onMouseOut=\"p_AIMouseOut(this)\" ";
                             menuDivArray[menuDivArray.length]=" onmousedown=\"window.event.cancelBubble=true;window.event.returnValue=null;\"";
                             menuDivArray[menuDivArray.length]=" onmouseup=\"window.event.cancelBubble=true;window.event.returnValue=null;\"";
                             menuDivArray[menuDivArray.length]=" onclick=\"window.event.cancelBubble=true;\">";
                          }
                     else
                          {
                             menuDivArray[menuDivArray.length]=" onMouseOver=\"l_AIMouseOver(this);\"";
                             menuDivArray[menuDivArray.length]=" onMouseOut=\"this.className='aipopmenu_menu';\" ";
                             menuDivArray[menuDivArray.length]=" onmousedown=\"window.event.cancelBubble=true;window.event.returnValue=false;\"";
                             menuDivArray[menuDivArray.length]=" onmouseup=\"window.event.cancelBubble=true;window.event.returnValue=false;\"";
                             menuDivArray[menuDivArray.length]=" onclick=l_AIMouseClick(this)>";
                          }

                     menuDivArray[menuDivArray.length]=" <td isAiPopElement=\"true\" nowrap >";
                     menuDivArray[menuDivArray.length]="&nbsp;"+menuItemArray[i].itemName+"&nbsp;</td>";
                     if(menuItemArray[i].isChild)
                            menuDivArray[menuDivArray.length]="<td isAiPopElement=\"true\" style='font-family: webdings; text-align: right;'>4</td>";
                     else
                            menuDivArray[menuDivArray.length]="<td isAiPopElement=\"true\"></td>";
                     menuDivArray[menuDivArray.length]="</tr>";
                  }


           }//end for
     menuDivArray[menuDivArray.length]="</table>";
     popMenuDiv.innerHTML= menuDivArray.join(" ");
  //   alert(popMenuDiv.outerHTML);
     return popMenuDiv;
  }

  //���������������λ��������չ�˵��Ĳ˵����ʱ����ʾ����չ�˵�
  function p_AIMouseOver(pTrObj,pOnMouseEnter,pOnMouseLeave)
  {
          pTrObj.className = "aipopmenu_overmenu";
          var parentId = pTrObj.id;
      var divId = pTrObj.PK+"_"+(parseInt(pTrObj.level)+1);
      var menuObj = g_AIPopMenuManager.get(pTrObj.PK);
          //alert("divId="+divId+" pId="+parentId+" pTrObj.PK"+pTrObj.PK);
      //menuObj.maxDivLevel+=1;
          var popMenuDiv = buildPopMenuDiv(divId,parentId,menuObj,pOnMouseEnter,pOnMouseLeave);
          var Parent =  document.getElementById(pTrObj.PK+"_"+pTrObj.level);

          //alert(pTrObj.PK+"_"+pTrObj.level);
                  //pTrObj.parentElement.parentElement;
     //��ʾĳ���˵������չ�Ӳ˵�
      popMenuDiv.style.visibility="visible";
          popMenuDiv.style.posLeft=document.body.scrollLeft+Parent.offsetLeft+Parent.offsetWidth-4;
      if(popMenuDiv.style.posLeft+popMenuDiv.offsetWidth > document.body.scrollLeft+document.body.clientWidth)
          popMenuDiv.style.posLeft=popMenuDiv.style.posLeft-Parent.offsetWidth-popMenuDiv.offsetWidth+8;
      if(popMenuDiv.style.posLeft < 0)
          popMenuDiv.style.posLeft=document.body.scrollLeft+Parent.offsetLeft+Parent.offsetWidth;
      popMenuDiv.style.posTop=Parent.offsetTop+pTrObj.offsetTop;
      if(popMenuDiv.style.posTop+popMenuDiv.offsetHeight > document.body.scrollTop+document.body.clientHeight)
        popMenuDiv.style.posTop=document.body.scrollTop+document.body.clientHeight-popMenuDiv.offsetHeight;
      if(popMenuDiv.style.posTop < 0) popMenuDiv.style.posTop=0;


  }

  function p_AIMouseOut(pTrObj)
  {

          pTrObj.className = "aipopmenu_menu";
          /*var menuObj = g_AIPopMenuManager.get(pTrObj.PK);
    var curLevel = parseInt(pTrObj.level);

    for(var i=curLevel+1;i<=menuObj.maxDivLevel;i++)
          {
          var divId = pTrObj.PK+"_"+parseInt(i);
           //alert("divId="+divId);
          if(document.getElementById(divId))
                  {
                    document.getElementById(divId).style.visibility="hidden";
                  }
          }*/


  }

  //���ĳ���˵���û���Ӳ˵���Ҫ�����������Ӳ˵����ص�
  function l_AIMouseOver(pTrObj)
  {
    pTrObj.className='aipopmenu_overmenu';
    var parentId = pTrObj.id;
    var menuObj = g_AIPopMenuManager.get(pTrObj.PK);
    var curLevel = parseInt(pTrObj.level);
    //alert(curLevel+","+menuObj.maxDivLevel);
    for(var i=curLevel+1;i<=menuObj.maxDivLevel;i++)
          {
          var divId = pTrObj.PK+"_"+parseInt(i);
           //alert("divId="+divId);
          if(document.getElementById(divId))
                  {
                    document.getElementById(divId).style.visibility="hidden";
                  }
          }





  }

  //�˵����onclick����
  function l_AIMouseClick(pTrObj)
  {


     var menuObj = g_AIPopMenuManager.get(pTrObj.PK);

     var selMenuItem = menuObj.model.getMenuItem(pTrObj.id);
     menuObj.hidePopMenu();
    //alert("in line15359 selMenuItem.funcName="+selMenuItem.funcName);
    if(selMenuItem && selMenuItem.funcName!=null)
     {
           if(selMenuItem.funcName.indexOf("(")>0 && selMenuItem.funcName.indexOf(")")>0)
             {
             eval(selMenuItem.funcName);
             }
       else
         {
                     eval(selMenuItem.funcName+"('"+selMenuItem.itemId+"','"+selMenuItem.itemName+"')");
             }


     }

    window.event.cancelBubble=true;
    window.event.returnValue=false;



  }

  /*
    ����ĳ���˵����Ƿ���Ч
    ����;pItemIdStr �˵���Id������ж����","�ָ���
         flag Ϊ����ֵ��true��ʾ�������ϵĲ˵�����Ч��false��������Ч.
  */
  function AIPopMenu_setItemEnabled(pItemIdStr,flag)
  {
     if(this.model)
          {
             if(flag)
                this.model.setItemState(pItemIdStr,"U");
             else
            this.model.setItemState(pItemIdStr,"E");
          }
  }

  /*
    ����ĳ���˵����Ƿ���Ч
    ����;pName �˵������ơ�
         flag Ϊ����ֵ��true��ʾ�������ϵĲ˵�����Ч��false��������Ч.
  */
  function AIPopMenu_setItemEnableByName(pName,pFlag)
  {

    var selItemIdArray = this.model.getItemIdByName(pName);

    for(var i=0;i<selItemIdArray.length;i++)
          {
            //alert(selItemIdArray[i]);
            this.setItemEnabledById(selItemIdArray[i],pFlag);
          }
  }

  /*
    ����ĳ���˵�����Ƿ�����״̬Ϊenable/disable
    ����;pItemIdStr �˵���Id������ж����","�ָ���
         flag Ϊ����ֵ��true��ʾ�������ϵĲ˵������أ�false��������ʾ.
  */
  function AIPopMenu_setItemHideById(pItemIdStr,flag)
  {
      if(this.model)
          {

             if(flag)
                this.model.setItemState(pItemIdStr,"H");
             else
            this.model.setItemState(pItemIdStr,"U");
          }
  }

  function AIPopMenu_setItemHideByName(pName,pFlag)
  {
    var selItemIdArray = this.model.getItemIdByName(pName);
    for(var i=0;i<selItemIdArray.length;i++)
          {
            this.setItemHideById(selItemIdArray[i],pFlag);
          }
  }

  /*
    �������ò˵�

  */

  function AIPopMenu_reloadPopMenu(pModel)
  {
     this.model = pModel;
     for(var i=0;i<=this.maxDivLevel;i++)
          {
             if(document.getElementById(this.PK+"_"+i))
                  {
                     var divObj = document.getElementById(this.PK+"_"+i);
                     document.body.removeChild(divObj);
                  }
          }
     this.maxDivLevel = -1;
  }

  /*
     ɾ��һ���˵���
  */
  function AIPopMenu_removeItemById(pItemId)
  {
    this.model.removeItemById(pItemId);
  }

  function AIPopMenu_removeItemByName(pName,pFlag)
  {
    var selItemIdArray = this.model.getItemIdByName(pName);
    for(var i=0;i<selItemIdArray.length;i++)
          {
            this.removeItemById(selItemIdArray[i]);
          }
  }







  /*
    ��֪���ײ˵��ɾ�����ĺ��Ӳ˵���
  */

  function AIRemoveChildItemFunc(pParentItemId)
  {
    alert("no complete");
  }



















  /*
  �������˵��Ľӿڶ���
  ������pItemId �˵���ID
        pItemName �˵�����������
            pParentItemId �˵���˵���ID����������˵������˵���IDΪnull
            pFuncName ����˵�����õķ���������;"hello()";
  */
  function AIPopMenuItem(pItemId,pItemName,pParentItemId,pFuncName)
  {
    this.itemId = pItemId;
    this.itemName = pItemName;
    this.parentItemId = pParentItemId;
    this.state="U";/*'S'-��ʾ��һ���ָ���,'U'-��ʾ��ǰ��Ч,'E'-��ʾ������Ч״̬ 'H'-��������״̬*/
    this.funcName = pFuncName;
    this.level = -1;
    this.isChild = false;

  }



  /*
     �����˵�������model
     ��AIPopMenu����Ľӿڷ���Ϊ��
     this.getMainMenu(); ����ʱ�����˵��Ĳ˵������AIPopMenuItem��������

     this.getSubMenu(pParentItemId);//���ݸ����˵����õ���������չ�˵��Ĳ˵��� ����AIPopMenuItem��������

     this.getMenuItem(pItemId); //���ݲ˵���Id���õ��˵������ϸ��Ϣ������һ��AIPopMenuItem����;

     this.getItemIdByName(pName);//���ݲ˵��������ƣ��õ��˵���idֵ������һ������

     this.setItemState(pItemIdStr,state) //����ĳ������ĳЩ�˵����״̬������˵���ʱ�á�,���ָ�

     this.removeItemById(pItemId) //����ItemIdɾ��ĳ���˵���



  */

  function AIPopMenuModel()
  {

          this.menuItemArray = new Array();

          this.mainMenuItemArray = new Array();

          this.allMenuItemArray = new Array();

          this.addPopMenuItem = function(pItemId,pItemName,pParentItemId,pFuncName)
                                {

                                                            var menuItem = new  AIPopMenuItem(pItemId,pItemName,pParentItemId,pFuncName);

                                                            if(pParentItemId==null || pParentItemId=="null")
                                                            {
                                                                    menuItem.level = 0;
                                                                    this.mainMenuItemArray[this.mainMenuItemArray.length]=menuItem;
                                                                    this.allMenuItemArray[pItemId] = menuItem;
                                                            }
                                                            else
                                                            {

                                                                    this.menuItemArray[this.menuItemArray.length]=menuItem;
                                    this.allMenuItemArray[pItemId] = menuItem;
                                                                    if(this.allMenuItemArray[pParentItemId])
                                                                    {
                                       this.allMenuItemArray[pParentItemId].isChild = true;


                                                                    }
                                                            }
                                } ;
      this.addPopMenuItemByRowSet = function(pRowSet,pIdCol,pNameCol,pParentIdCol,pFuncCol)
                               {
                                       var backupArray = new Array();
                                                           for(var i=0;i<pRowSet.count();i++)
                                                           {
                                  var menuItem = new  AIPopMenuItem(pRowSet.getValue(i,pIdCol),pRowSet.getValue(i,pNameCol),pRowSet.getValue(i,pParentIdCol),pRowSet.getValue(i,pFuncCol));
                                  if(menuItem.parentItemId==null || menuItem.parentItemId=="null" || menuItem.parentItemId=="")
                                                               {
                                                                      if(menuItem.itemName=="-")
                                                                           {
                                                                                  this.addSeparator(null);
                                                                           }
                                      else
                                                                           {

                                                                        this.mainMenuItemArray[this.mainMenuItemArray.length] = menuItem;
                                                                        this.allMenuItemArray[menuItem.itemId] = menuItem;
                                                                           }

                                                               }
                                                             else
                                                               {

                                                                           if(menuItem.itemName=="-")
                                                                           {
                                                                                  this.addSeparator(menuItem.parentItemId);
                                                                           }
                                      else
                                                                           {


                                                                                    this.menuItemArray[this.menuItemArray.length] =menuItem;
                                                                                    this.allMenuItemArray[menuItem.itemId] = menuItem;
                                                                                    if(this.allMenuItemArray[menuItem.parentItemId])
                                                                                    {

                                                                                           this.allMenuItemArray[menuItem.parentItemId].isChild = true;


                                                                                    }
                                                                                    else
                                                                                    {
                                                                                           backupArray[backupArray.length] = menuItem;

                                                                                    }
                                                                           }
                                                               }
                                                           }//end for
                                                           for(var j=0;j<backupArray.length;j++)
                                                           {
                                                                   var parentId = backupArray[j].parentItemId;
                                                                   var id = backupArray[j].itemId;
                                                                   if(this.allMenuItemArray[parentId])
                                                                   {
                                                                           this.allMenuItemArray[parentId].isChild = true;


                                                                   }
                                                           }
                                                           backupArray.length = 0;
                                                           backupArray = null;


                               }
      this.addSeparator = function(pParentItemId)
                               {
                                      var menuItem = new  AIPopMenuItem(null,null,pParentItemId,null);
                                                          menuItem.state="S";
                                                          if(pParentItemId==null || pParentItemId=="null")
                                                            {

                                                                    this.mainMenuItemArray[this.mainMenuItemArray.length]=menuItem;

                                                            }
                                                            else
                                                            {
                                                                    this.menuItemArray[this.menuItemArray.length]=menuItem;
                                                                    if(this.allMenuItemArray[pParentItemId])
                                                                    {
                                       this.allMenuItemArray[pParentItemId].isChild = true;

                                                                    }
                                                            }


                               }
          this.getMainMenu = function()
                                {
                                          return this.mainMenuItemArray;
                            };
      this.getSubMenu	= function(pParentItemId)
                                {
                                      var rArray = new Array();
                                                          for(var i=0;i<this.menuItemArray.length;i++)
                                                            {
                                    if(this.menuItemArray[i] && this.menuItemArray[i].parentItemId==pParentItemId)
                                                                    {
                                                                           //alert("id="+this.menuItemArray[i].itemId+" isChild="+this.menuItemArray[i].isChild);
                                                                           rArray[rArray.length] = this.menuItemArray[i];
                                                                    }
                                                            }
                              return rArray;
                             }

          this.getMenuItem = function(pItemId)
                              {
                                     //alert("pItemId="+pItemId);
                                                     if(this.allMenuItemArray[pItemId])
                                                                  return this.allMenuItemArray[pItemId];
                                                     else
                                                             return null;
                              }
          this.setItemState = function(pItemIdStr,pState)
                                {
                                      var itemArray = pItemIdStr.split(",");
                                                          if(itemArray && itemArray.length>0)
                                                            {
                                                                  for(var i=0;i<itemArray.length;i++)
                                                                    {
                                                                      if(this.allMenuItemArray[itemArray[i]])
                                                                            this.allMenuItemArray[itemArray[i]].state = pState;
                                    }
                                                            }
                                }
      this.getItemIdByName = function(pName)
                               {
                                      if(pName==null || pName=="") return;
                                                          var reVal = new Array();
                                                          for(var i=0;i<this.mainMenuItemArray.length;i++)
                                                           {
                                                                  if(this.mainMenuItemArray[i].itemName==pName)
                                                                   {
                                                                          reVal[reVal.length] = this.mainMenuItemArray[i].itemId;
                                                                   }
                                                           }
                                                          for(var i=0;i<this.menuItemArray.length;i++)
                                                           {
                                                                  if(this.menuItemArray[i].itemName==pName)
                                                                   {
                                                                          reVal[reVal.length]=this.menuItemArray[i].itemId;
                                                                   }
                                                           }
                                                           return reVal;
                               }
      this.removeItemById = function(pItemId)
          {

                  if(this.allMenuItemArray[pItemId])
                  {
             var delObj = this.allMenuItemArray[pItemId];
                     if(parseInt(delObj.level)==0 || parseInt(delObj.level)==-1)
                          {
                delPopMenuItemInArray(this.mainMenuItemArray,pItemId);

                          }
                     else
                          {
                delPopMenuItemInArray(this.menuItemArray,pItemId);

                          }
                  }
          }
  }


  function delPopMenuItemInArray(pArray,pItemId)
  {
     for(var i=0;i<pArray.length;i++)
          {
             if(pArray[i].itemId == pItemId)
                  {
                     if(i==0) pArray.shift();
                     else if(i==pArray.length-1) pArray.pop();
                     else
                          {
                             for(m=i;m<pArray.length-1;m++)
                                  {
                                     pArray[m] = pArray[m+1];
                                  }
                 pArray.pop();
                          }
                     break;
                  }
          }
  }

  /*�����������PopMenu���¼� 2006-04-21 zhanglh*/
  function AIPopMenu_setOnMouseEnter(pOnMouseEnterFuncName){
    if (pOnMouseEnterFuncName!=null&&pOnMouseEnterFuncName!=""&&pOnMouseEnterFuncName.indexOf("(")<0){
        pOnMouseEnterFuncName+="()";
    }
    this.onMouseEnter=pOnMouseEnterFuncName;
  }

  /*����Ƴ�����PopMenu���¼� 2006-04-21 zhanglh*/
  function AIPopMenu_setOnMouseLeave(pOnMouseLeaveFuncName){
    if (pOnMouseLeaveFuncName!=null&&pOnMouseLeaveFuncName!=""&&pOnMouseLeaveFuncName.indexOf("(")<0){
        pOnMouseLeaveFuncName+="()";
    }
    this.onMouseLeave=pOnMouseLeaveFuncName;
  }








  /**********************end AIPopMenu.js ****************************************/
