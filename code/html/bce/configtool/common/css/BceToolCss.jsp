/*-----------��ʽ�޸ļ�¼��by hequ 2009-10-26��ƽ̨���������ʽ��---------------------*/

/*-----------ҳ�������ʽ-----------*/
BODY {font-family:Arial,"����";font-size:12px; margin: 0;padding:0; background-color:#FFFFFF; overflow:auto;SCROLLBAR-FACE-COLOR:#E4EFF1;SCROLLBAR-HIGHLIGHT-COLOR:#8CB2E3;SCROLLBAR-SHADOW-COLOR:#8CB2E3;SCROLLBAR-3DLIGHT-COLOR:#F8F9FD;SCROLLBAR-ARROW-COLOR:#8CB2E3;SCROLLBAR-TRACK-COLOR:#F8F9FD;SCROLLBAR-DARKSHADOW-COLOR:#F8F9FD;}
tr,td {font-family:Arial,"����";FONT-SIZE: 12px}
textarea {font-size:12px; background-color: #FFFFFF; color:#000000;  border:1 solid #7FC2D3;}
select {font-size:12px;background-color: #FFFFFF;color:#000000;}
.input{font-size:12px;color:#000000; background-color: #FFFFFF; border-width:1px; border-style:solid; border-color:#7FC2D3;padding-top: 2px;padding-left: 3px;height: 20px;}
form {display: inline;}
.G-Table-NoData{ color:#FF0000}

/*-----------ҳ�治ͬ����λ�õĶ���-----------*/
.area_tab{ width:100%; text-align:center; padding-top:5px;}
.td_font{ width:150px; text-align:right}
.td_button{ width:10%; text-align:center}
.area_button{ width:100%; text-align:center; height:35px; padding-top:3px;}

/*-----------ҳ���л���������ʽ�Ķ���-----------*/
A:link {COLOR: #202020; TEXT-DECORATION: none}
A:visited {COLOR: #202020; TEXT-DECORATION: none}
a:active {COLOR: #202020; text-decoration: none}
A:hover {COLOR: #346796; TEXT-DECORATION: none}

/*-----------AIButton��ʽ-----------*/
/*������ť*/
.AIButton .AIBtnLeft {background:url(<%=request.getContextPath()%>/jsv2/image/button/button_left.gif) repeat-x 0 0; width:10px; height:22px; vertical-align:bottom;}
.AIButton .AIBtnCenter {background:url(<%=request.getContextPath()%>/jsv2/image/button/button_bg.gif) repeat-x 0 0; height:22px; color:#1E5494; padding-top: 4px; vertical-align:bottom;}
.AIButton .AIBtnRight {background:url(<%=request.getContextPath()%>/jsv2/image/button/button_right.gif) repeat-x 0 0; width:10px; height:22px; vertical-align:bottom;}
.AIButton .AIBtnText {font-size:12px;}
/*��껬��*/
.AIButtonHover .AIBtnLeft {background:url(<%=request.getContextPath()%>/jsv2/image/button/button_left.gif) repeat-x 0 -22px; width:10px; height:22px; vertical-align:bottom;}
.AIButtonHover .AIBtnCenter {background:url(<%=request.getContextPath()%>/jsv2/image/button/button_bg.gif) repeat-x 0 -22px; height:22px; color:#3C75AD; padding-top: 4px; vertical-align:bottom;}
.AIButtonHover .AIBtnRight {background:url(<%=request.getContextPath()%>/jsv2/image/button/button_right.gif) repeat-x 0 -22px; width:10px; height:22px; vertical-align:bottom;}
.AIButtonHover .AIBtnText {font-size:12px;}
/*�����ð�ť*/
.AIButtonDisabled .AIBtnLeft {background:url(<%=request.getContextPath()%>/jsv2/image/button/button_left.gif) repeat-x 0 -44px; width:10px; height:22px; vertical-align:bottom;}
.AIButtonDisabled .AIBtnCenter {background:url(<%=request.getContextPath()%>/jsv2/image/button/button_bg.gif) repeat-x 0 -44px; height:22px; color:#666666; padding-top: 4px; vertical-align:bottom;}
.AIButtonDisabled .AIBtnRight {background:url(<%=request.getContextPath()%>/jsv2/image/button/button_right.gif) repeat-x 0 -44px; width:10px; height:22px; vertical-align:bottom;}
.AIButtonDisabled .AIBtnText {font-size:12px;}

/*-----------CrossGrid��ʽ-----------*/
/*���̶���ͷ̧ͷ������ʽ*/
.CrossGridRowHead_Name{BACKGROUND-COLOR: #ffdddd;}
/*���̶���ͷ��ֵ������ʽ*/
.CrossGridRowHead_Value{BACKGROUND-COLOR: #efe1ff;}
/*���̶���ͷ����ʽ*/
.CrossGridColHead{BACKGROUND-COLOR: #ecffec;}
/* ����������ʽ*/
.CrossGrid_Data{BACKGROUND-COLOR: #FFFFFF;}
/* ѡ����/����ʽ*/
.CrossGrid_Row{BACKGROUND-COLOR: #c4ccff;}

/*-----------DBGrid ��ʽ-----------*/
.td_hover{background-color:#E5EFF8;color:#013299;}
.title_hover{height:22px;color:#333333;text-align:center;border:#8CB2E3 solid;border-width:0 1 1 0;background:url(<%=request.getContextPath()%>/jsv2/image/grid/title_hover.gif);display:block;}
/*�����������ʽ*/
.G-TableOuterDiv{background:#F0F3FA; border:1px solid #8CB2E3;border-width:1 1 0 1;margin:0 10px;}
.G-TableHead{height:22px;color:#333333;TABLE-LAYOUT: fixed;border-COLLAPSE: collapse;background:url(<%=request.getContextPath()%>/jsv2/image/grid/title_bg.gif);display:block;}
/*�������������ʽ*/
.G-TableBody{border:#8CB2E3;background-color:#E1EDFA;}
/*����������ʽ*/
.G-TableFoot{background:url(<%=request.getContextPath()%>/jsv2/image/grid/bottom_bg.gif);border:1 solid #8CB2E3;height:27px;margin:0 10px;}
/*���ͷ������ʽ*/
.GH-Head{height:20px;color:#333333;text-align:center;border:#8CB2E3 solid;border-width:0 1 0 0;background:#F8F9FD;}
/*���ͷTR��ʽ*/
.GH-TR{} 
/*���ͷTD��ʽ*/
.GH-TD{height:22px;color:#333333;text-align:center;border:#8CB2E3 solid;border-width:0 1 1 0;background:url(<%=request.getContextPath()%>/jsv2/image/grid/title_bg.gif);display:block;}
/*�ϼ�����ʽ*/
.GD-Total-TR{border:#8CB2E3 solid;border-width:0 1 1 0;color:#013299;}
/*�ϼ��е�Ԫ����ʽ*/
.GD-Total-TD{border:#8CB2E3 solid;border-width:0 1 1 0;color:#013299;}  
/*��������ж�ѡ��Ԫ����ʽ*/
.GD-S{width:24px;border:#8CB2E3 solid;border-width:0 1 1 0;display:block;}
/*���ͷ��ѡ��Ԫ����ʽ*/
.GH-S{height:20px;width:24px;color:#000000;border:#8CB2E3 solid;border-width:0 1 1 0;TABLE-LAYOUT: fixed;border-COLLAPSE: collapse;background-color:#E4EFF1;display:block;}
/*���ͷ�Ķ�ѡCheckbox��ʽ*/
.GH-S-C{border:0;width:24px;}
/*��������еĶ�ѡCheckbox��ʽ*/
.GD-S-C{border:0;}
/*���ͷ�����*/
.GH-Seq{height:20px;width:30px;color:#333333;text-align:center;border:#8CB2E3 solid;border-width:0 1 1 0;TABLE-LAYOUT: fixed;border-COLLAPSE: collapse;background:url(<%=request.getContextPath()%>/jsv2/image/grid/title_bg.gif);display:block;}
/*������ݵ����*/
.GD-Seq{text-align:center;border:#8CB2E3 solid;border-width:0 1 1 0;display:block;}
/*��������ʽ*/
.GD-One{background-color:#F3F5F8;border:#8CB2E3 solid;border-width:1 1 1 0;color:#013299;}
/*ż������ʽ*/
.GD-Two{background-color:#FFFFFF;border:#8CB2E3 solid;border-width:1 1 1 0;color:#013299;}
/*�����������TD��ʽ*/
.GD-TD{background-color: ;border:#8CB2E3 solid;border-width:0 1 1 0;word-break:break-all;}
/*ѡ������ʽ*/
.GD-SelectRow{}
/*��ǰ����ʽ*/
.GD-CurrentRow{background-color:#E6FFFF;color:#013299;}
/*��ǰ��Ԫ����ʽ*/
.GD-CurrentCell{background-color:#FFF475;border:#8CB2E3 solid;border-width:0 1 1 0;word-break:break-all;color:#013299;}
/*DBGrid��������ʽ*/
.G-ScrollBar{overflow:auto;SCROLLBAR-FACE-COLOR:#E4EFF1;SCROLLBAR-HIGHLIGHT-COLOR:#8CB2E3;SCROLLBAR-SHADOW-COLOR:#8CB2E3;SCROLLBAR-3DLIGHT-COLOR:#F8F9FD;SCROLLBAR-ARROW-COLOR:#8CB2E3;SCROLLBAR-TRACK-COLOR:#F8F9FD;SCROLLBAR-DARKSHADOW-COLOR:#F8F9FD;}
/*̧ͷ����������ʽ*/
.GH-SORT-ASC{float:right;width:13px;height:14px;background:url(<%=request.getContextPath()%>/jsv2/image/grid/sort_u.gif);background-repeat:no-repeat;}
/*̧ͷ����������ʽ*/
.GH-SORT-DESC{float:right;width:13px;height:14px;background:url(<%=request.getContextPath()%>/jsv2/image/grid/sort_d.gif);background-repeat:no-repeat;}
.GH-SORT{float:right;width:13px;height:14px;background-repeat:no-repeat;}
.TABLE_TREE_BUTTON{width:16;height:16;font-size: 12px;border-RIGHT: #2C59AA 1px solid; PADDING-RIGHT: 2px; border-TOP: #2C59AA 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#C3DAF5); border-LEFT: #2C59AA 1px solid; CURSOR: hand; COLOR: black; PADDING-TOP: 2px; border-BOTTOM: #2C59AA 1px solid}
input.table-page{border:1px solid #8A8A8A;width:2em;height:1.2em;text-align:center;font-size:9pt;position:relative;top:-1px;padding-top:0;}
#page-first{width:16px;background:url(<%=request.getContextPath()%>/jsv2/image/grid/button_begin.gif) no-repeat left 1px;}
#page-prev{width:16px;background:url(<%=request.getContextPath()%>/jsv2/image/grid/button_prv.gif) no-repeat left 1px;}
#page-next{width:16px;background:url(<%=request.getContextPath()%>/jsv2/image/grid/button_next.gif) no-repeat left 1px;}
#page-last{width:16px;background:url(<%=request.getContextPath()%>/jsv2/image/grid/button_end.gif) no-repeat left 1px;}
#page-go{width:15px;background:url(<%=request.getContextPath()%>/jsv2/image/grid/button_go.gif) no-repeat left top;}

/*-----------TAB��ʽ-----------*/
/*���ఴť*/
.tab_moreButton{background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/more_tab.gif) left top  no-repeat;width:14px;height:25px;cursor:hand;margin-left:-1px;}
.tab_moreButton_hover{background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/more_tab.gif) left top  no-repeat;background-position:-13px 0px;width:14px;height:25px;cursor:hand;margin-left:-1px;}
.tab_b_moreButton{background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/more_b_tab.gif) left bottom  no-repeat;width:14px;height:26px;cursor:hand;margin-left:-1px;}
.tab_b_moreButton_hover{background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/more_b_tab.gif) left bottom  no-repeat;width:14px;height:26px;cursor:hand;margin-left:-1px;}
.tab_vv_moreButton{background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/more_v_tab.gif) top right no-repeat;width:25px;height:14px;cursor:hand;margin-top:-2px;}
.tab_vv_moreButton_hover{background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/more_v_tab.gif) top right no-repeat;width:25px;height:14px;cursor:hand;margin-top:-2px;}

/*�����˵�*/
.tab_pop_table{height:22px;background-color: #D6E1F8; border: 1 solid #1D82DE;width:100px;filter:alpha(opacity=90);padding:0 5px 0 5px;}
.tab_pop_menu{height:22px;padding:0 5px 0 5px;}
.tab_pop_menuover{height:22px;background:url(<%=request.getContextPath()%>/jsv2/image/popmenu/overmenu_bg.gif) repeat-x;color:#666666;cursor:pointer;padding:0 5px 0 5px;}

/*���Ҽ��*/
.scrollDiv{width:41px;}
.scrollDiv_vv{height:41px;width:25px;}

/*�رհ�ť��ʽ*/
.TAB_ITEM_CLOSE_BUTTON{width:11px;height:13px;cursor:hand;float:right;background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/close.gif) no-repeat;background-position:0px -26px;margin:4px 0 0 1px;}
.TAB_ITEM_CLOSE_BUTTON_CURRENT{width:11px;height:13px;cursor:hand;float:right;background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/close.gif) no-repeat;background-position:0px -13px;margin:4px 0 0 1px;}
.TAB_ITEM_CLOSE_BUTTON_HOVER{width:11px;height:13px;cursor:hand;float:right;background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/close.gif) no-repeat;background-position:0px 0px;margin:4px 0 0 1px;}

/*Tab_h��ʽ*/
/*��߹�����ť��ʽ*/
.TAB_H_SCROLLLEFTBUTTON{background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/button_prv.gif) left top  no-repeat;width:14px;height:25px;cursor:hand;}
.TAB_H_SCROLLLEFTBUTTON_HOVER{background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/button_prv.gif) left top  no-repeat;background-position:-13px 0px;width:14px;height:25px;cursor:hand;}
/*�ұ߹�����ť��ʽ*/
.TAB_H_SCROLLRIGHTBUTTON{background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/button_next.gif) left top  no-repeat;width:14px;height:25px;cursor:hand;margin-left:-1px;}
.TAB_H_SCROLLRIGHTBUTTON_HOVER{background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/button_next.gif) left top  no-repeat;background-position:-13px 0px;width:14px;height:25px;cursor:hand;margin-left:-1px;}
/*�����ǩ��ʽ*/
.TAB_H_ITEM_STYLE{background: url(<%=request.getContextPath()%>/jsv2/image/tabPage/item_bg.gif) repeat-x bottom; width:100%; height:24px;padding-left:9px;}
/*TITLE��ʽ����ߵ�ͼƬ*/
.TAB_H_TITLE_STYLE{padding-left:10px;color:#15428B;float:left;height:25px;z-index:100;margin:0 1px 0 1px;background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/tagleft1.gif) left bottom  no-repeat;}
/*TITLE��ʽ���ұߵ�ͼƬ*/
.TAB_H_TITLE_STYLE span{padding-right:10px;float:right;height:25px;background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/tagright1.gif) right bottom  no-repeat;}
/*�۽���ǰTITLE��ʽ����ߵ�ͼƬ*/
.TAB_H_TITLE_STYLE_CURRENT{padding-left:10px;color:#15428B;float:left;height:25px;z-index:100;margin:0 1px 0 1px;background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/tagleft2.gif) left bottom  no-repeat;}
/*�۽���ǰTITLE��ʽ���ұߵ�ͼƬ*/
.TAB_H_TITLE_STYLE_CURRENT span{padding-right:10px;float:right;height:25px;background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/tagright2.gif) right bottom  no-repeat;}
/*��괥��TITLE��ʽ����ߵ�ͼƬ*/
.TAB_H_TITLE_STYLE_HOVER{padding-left:10px;color:#000000;float:left;height:25px;z-index:100;margin:0 1px 0 1px;background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/tagleft3.gif) left bottom  no-repeat;}
/*��괥��TITLE��ʽ���ұߵ�ͼƬ*/
.TAB_H_TITLE_STYLE_HOVER span{padding-right:10px;float:right;height:25px;background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/tagright3.gif) right bottom  no-repeat;}
/*TITLE��������ʽ*/
.TAB_H_TITLE_FONT_STYLE{color:#32659A;text-align:center;cursor: hand;padding-top:6px;}
/*���岿�ֵ���ʽ*/
.TAB_H_MAIN_TAB {background:#FFFFFF;}

/*Tab_b��ʽ*/
/*��߹�����ť��ʽ*/
.TAB_B_SCROLLLEFTBUTTON{background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/button_b_prv.gif) left bottom  no-repeat;width:14px;height:26px;cursor:hand;}
.TAB_B_SCROLLLEFTBUTTON_HOVER{background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/button_b_prv.gif) left bottom  no-repeat;width:14px;height:26px;cursor:hand;}
/*�ұ߹�����ť��ʽ*/
.TAB_B_SCROLLRIGHTBUTTON{background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/button_b_next.gif) left bottom  no-repeat;width:14px;height:26px;cursor:hand;margin-left:-1px;}
.TAB_B_SCROLLRIGHTBUTTON_HOVER{background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/button_b_next.gif) left bottom  no-repeat;width:14px;height:26px;cursor:hand;margin-left:-1px;}
/*�����ǩ��ʽ*/
.TAB_B_ITEM_STYLE{background: url(<%=request.getContextPath()%>/jsv2/image/tabPage/item_bg_b.gif) repeat-x top; width:100%; height:25px;}
/*TITLE��ʽ����ߵ�ͼƬ*/
.TAB_B_TITLE_STYLE{padding-left:10px;color:#15428B;float:left;height:24px;z-index:100;margin:0 1px 0 1px;border: 1 solid #4682B4;background-color:#D6E1F8;}
/*TITLE��ʽ���ұߵ�ͼƬ*/
.TAB_B_TITLE_STYLE span{padding-right:10px;float:right;height:24px;}
/*�۽���ǰTITLE��ʽ����ߵ�ͼƬ*/
.TAB_B_TITLE_STYLE_CURRENT{padding-left:10px;color:#15428B;float:left;height:25px;z-index:100;margin:0 1px 0 1px;border: 1 solid #4682B4;border-width:0 1 1 1;background-color:#FFFFFF;}
/*�۽���ǰTITLE��ʽ���ұߵ�ͼƬ*/
.TAB_B_TITLE_STYLE_CURRENT span{padding-right:10px;float:right;height:25px;}
/*��괥��TITLE��ʽ����ߵ�ͼƬ*/
.TAB_B_TITLE_STYLE_HOVER{padding-left:10px;color:#000000;float:left;height:24px;z-index:100;margin:0 1px 0 1px;border: 1 solid #4682B4;background-color:#D6E1F8;}
/*��괥��TITLE��ʽ���ұߵ�ͼƬ*/
.TAB_B_TITLE_STYLE_HOVER span{padding-right:10px;float:right;height:24px;}
/*title��������ʽ*/
.TAB_B_TITLE_FONT_STYLE{color:#000000;text-align:center;cursor: hand;padding-top:6px;}
/*���岿����ʽ*/
.TAB_B_MAIN_TAB {background:#FFFFFF;}

/*tab_v��ʽ*/
/*�����ǩ��ʽ*/
.TAB_V_ITEM_STYLE{background: url(<%=request.getContextPath()%>/jsv2/image/tabPage/item_bg_v.gif) repeat-y right;height:100%;padding:5px 0 5px 0;}
/*TITLE��ʽ����ߵ�ͼƬ*/
.TAB_V_TITLE_STYLE{padding-left:10px;height:25px;color:#15428B;z-index:100;width:100%;margin-top:1px;margin-right:-1px;border: 1 solid #4682B4;background-color:#D6E1F8;}
/*TITLE��ʽ���ұߵ�ͼƬ*/
.TAB_V_TITLE_STYLE span{padding-right:10px;margin-top:1px;margin-right:-1px;width:100%;}
/*�۽���ǰTITLE��ʽ����ߵ�ͼƬ*/
.TAB_V_TITLE_STYLE_CURRENT{padding-left:10px;height:25px;color:#15428B;z-index:100;width:100%;margin-top:1px;border: 1 solid #4682B4;border-width:1 0 1 1;background-color:#FFFFFF;}
/*�۽���ǰTITLE��ʽ���ұߵ�ͼƬ*/
.TAB_V_TITLE_STYLE_CURRENT span{padding-right:10px;margin-top:1px;width:100%;}
/*��괥��TITLE��ʽ����ߵ�ͼƬ*/
.TAB_V_TITLE_STYLE_HOVER{padding-left:10px;height:25px;color:#15428B;z-index:100;width:100%;margin-top:1px;margin-right:-1px;border: 1 solid #4682B4;background-color:#D6E1F8;}
/*��괥��TITLE��ʽ���ұߵ�ͼƬ*/
.TAB_V_TITLE_STYLE_HOVER span{padding-right:10px;margin-top:1px;margin-right:-1px;width:100%;}
/*title��������ʽ*/
.TAB_V_TITLE_FONT_STYLE{color:#000000;cursor: hand;white-space:nowrap;height:25px;}
/*���岿����ʽ*/
.TAB_V_MAIN_TAB {border:solid #4682B4;border-width:1 1 1 0;background:#FFFFFF;}

/*tab_vv��ʽ*/
/*���������ť��ʽ*/
.TAB_VV_SCROLLLEFTBUTTON{background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/button_up.gif) right  no-repeat;width:25px;height:14px;cursor:hand;}
.TAB_VV_SCROLLLEFTBUTTON_HOVER{background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/button_up.gif) right  no-repeat;width:25px;height:14px;cursor:hand;}
/*���������ť��ʽ*/
.TAB_VV_SCROLLRIGHTBUTTON{background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/button_down.gif) right  no-repeat;width:25px;height:14px;cursor:hand;margin-top:-2px;}
.TAB_VV_SCROLLRIGHTBUTTON_HOVER{background:url(<%=request.getContextPath()%>/jsv2/image/tabPage/button_down.gif) right  no-repeat;width:25px;height:14px;cursor:hand;margin-top:-2px;}
/*�����ǩ��ʽ*/
.TAB_VV_ITEM_STYLE{background: url(<%=request.getContextPath()%>/jsv2/image/tabPage/item_bg_v.gif) repeat-y right; width:26px; height:100%;}
/*TITLE��ʽ����ߵ�ͼƬ*/
.TAB_VV_TITLE_STYLE{padding-top:10px;color:#15428B;width:25px;z-index:100;margin-top:1px;margin-right:-1px;border: 1 solid #4682B4;background-color:#D6E1F8;}
/*TITLE��ʽ���ұߵ�ͼƬ*/
.TAB_VV_TITLE_STYLE span{padding-bottom:5px;width:25px;margin-top:1px;margin-right:-1px;}
/*�۽���ǰTITLE��ʽ����ߵ�ͼƬ*/
.TAB_VV_TITLE_STYLE_CURRENT{padding-top:10px;color:#15428B;width:26px;z-index:100;margin-top:1px;border: 1 solid #4682B4;border-width:1 0 1 1;background-color:#FFFFFF;}
/*�۽���ǰTITLE��ʽ���ұߵ�ͼƬ*/
.TAB_VV_TITLE_STYLE_CURRENT span{padding-bottom:5px;width:26px;margin-top:1px;}
/*��괥��TITLE��ʽ����ߵ�ͼƬ*/
.TAB_VV_TITLE_STYLE_HOVER{padding-top:10px;color:#15428B;width:25px;z-index:100;margin-top:1px;margin-right:-1px;border: 1 solid #4682B4;background-color:#D6E1F8;}
/*��괥��TITLE��ʽ���ұߵ�ͼƬ*/
.TAB_VV_TITLE_STYLE_HOVER span{padding-bottom:5px;width:25px;margin-top:1px;margin-right:-1px;}
/*title��������ʽ*/
.TAB_VV_TITLE_FONT_STYLE{color:#000000;cursor: hand;word-wrap:break-word;width:10px;text-align:center;padding-left:4px;}
/*���岿����ʽ*/
.TAB_VV_MAIN_TAB {border:solid #4682B4;border-width:1 1 1 0;background:#FFFFFF;}

/*-----------TAB��ʽ end-----------*/

/*-----------DBForm.css-----------/
.DBForm_tdDis{height:20;border:1 solid #B1BAC2;background-color:#E7F4FE;padding:5 0 0 5;}
.DBForm_tdTit{padding-left:30;}


/*-----------DBDate.css-----------*/
/* ���Ƶ�Ԫ����ʾ��ʽ */
.DBDate-CalHead {cursor:default; text-align:center; font:bold 12px arial; color:white;}
.DBDate-CalCell {cursor:hand; text-align:center;}
.DBDate-CellAnchor {text-decoration:none; font:12px arial;}
/* ����������ʾ��ʽ*/
.DBDate-WeekHead {cursor:default; font:12px arial; text-align:center; color:#ddddea;}
.DBDate-WeekCol {cursor:default; font:bold 12px arial; text-align:center; color:gray; background-color:#ddddea;}
/* �·ݵ��� */
.DBDate-MonthNav {vertical-align:middle; height:22; width:18; font:12px fixedsys; color:black;}
/* ���� */
.DBDate-CalHead {cursor:default; text-align:center; font:bold 12px arial; color:white;}
.DBDate-CalCell {cursor:hand; text-align:center;}
.DBDate-CellAnchor {text-decoration:none; font:12px arial;}
/* ����������ʾ��ʽ*/
.DBDate-WeekHead {cursor:default; font:12px arial; text-align:center; color:#ddddea;}
.DBDate-WeekCol {cursor:default; font:bold 12px arial; text-align:center; color:gray; background-color:#ddddea;}
/* �·ݵ��� */
.DBDate-MonthNav {vertical-align:middle; height:22; width:18; font:12px fixedsys; color:black;}
/* ���� */
.DBDate-CalTop {text-align:center;}
.DBDate-CalMiddle {}
.DBDate-CalBottom {text-align:center;}
/* ���� */
.DBDate-CalTitle {vertical-align:middle; font:12px arial; color:black;}
/* ������ʾ */
.DBDate-Today {text-decoration:none; font:bold 12px sans-serif; color:black;}
A.DBDate-Today:hover {color:yellow}
A.DBDate-Today:active {color:red}
/* ���� */
.DBDate-CalTitle {vertical-align:middle; font:12px arial; color:black;}
/* ������ʾ */
.DBDate-Today {text-decoration:none; font:bold 12px sans-serif; color:black;}
A.DBDate-Today:hover {color:yellow}
A.DBDate-Today:active {color:red}

/*-----------DBCombobox.css-----------*/
.combo-hilite {cursor:hand;background:#EAF2FF;border:1px solid #78ACFF;color:#000000;font-size:12px;}
.combo-item {cursor:hand;background:#FFFFFF;border:1px solid #FFFFFF;color:#000000;font-size:12px;}
.combo-input {border: 1px solid #78ACFF !important;}
.combo-list-width {width:133px}
.combo-list {border:1px solid #000000;width:150px;}

/*-----------PopMenu�����˵����-----------*/
.aipopmenu_backdiv{background:#E4EBF9;border:1 solid #99BBE8;padding:1px;filter:alpha(opacity=90);}
.aipopmenu_menu{padding-left:16px;height:22px;}
.aipopmenu_overmenu{padding-left:16px;height:22px;background:url(<%=request.getContextPath()%>/jsv2/image/popmenu/overmenu_bg.gif) repeat-x;color:#666666;cursor:pointer;}
.aipopmenu_sepa{width:100%;border:1px solid #f0f0f0}
.aipopmenu_disablemenutext{color:#c0c0c0;}

/*-----------AIDBForm��ص�CSS-----------*/
.dbform_disable_style {background-color: #DDECFF;BORDER:1px solid #7FC2D3;BORDER-COLLAPSE: collapse}
.dbform_inputfield_style{BORDER:1px solid #7FC2D3;BORDER-COLLAPSE: collapse}
.dbform_lable_style{background-color: #DDECFF;BORDER:1px solid #7FC2D3;}
.dbform_password_style{BORDER:1px solid #7FC2D3;BORDER-COLLAPSE: collapse}
.dbform_checkbox_style{border:0}
.dbform_textarea_style{BORDER:1px solid #7FC2D3;BORDER-COLLAPSE: collapse}

/*-----------DBLink css-----------*/
.dbform_dblink_style{}

/*-----------DBOpenWin Css-----------*/
.dbform_dbopenwin_editor_style{BORDER:1px solid #7FC2D3;BORDER-COLLAPSE: collapse}
.dbform_dbopenwind_btn_style{font-size:7pt bold; background-color: #C4CCFF;BORDER:1px solid #7FC2D3;}

 /*-----------DBFile Css-----------*/
.dbform_dbfile_btn_style{font-size:7pt bold; background-color: #C4CCFF;BORDER:1px solid #7FC2D3;}
/*dblist���*/
.dbform_listbox_input_style{BORDER:1px solid #7FC2D3;BORDER-COLLAPSE: collapse}
.dbform_listbox_list_style{BORDER:1px solid #7FC2D3;BORDER-COLLAPSE: collapse;}
.dbform_listbox_input_disable_style{background-color: #DDECFF;BORDER:1px solid #7FC2D3;BORDER-COLLAPSE: collapse;}
.selectspan{height:20px;border:1px solid #D1E4EC;}
/**dbdate,dbdatetime��ص���ʽ**/
.dbform_dbdate_span_style{font-family: "Arial";BORDER:1px solid #7FC2D3;BORDER-COLLAPSE: collapse}
/*dbdate�������ʽ*/
.dbform_dbdate_input_style{font-family: "Arial";BORDER:1px solid #7FC2D3;BORDER-COLLAPSE: collapse}
/*dbdate��ť��ʽ*/
.dbform_dbdate_btn_style{background-image: url(<%=request.getContextPath()%>/jsv2/image/button/calendar.gif);width:20px;height:20px;border: none;cursor:hand;}
/*dbspan��ʽ*/
.dbform_dbspan_style{}
/*dbhtml�����*/
.dbform_dbhtml_style{}
.DBForm_Layout_Table{}
.DBForm_Layout_Tr{}
.DBForm_Layout_Title_Head{}
.DBForm_Layout_Title_Td{}
.DBForm_Layout_Data_Td{}

/*-----------AIWait��ʽ-----------*/
/*AIWait��������ʽ*/
.AIAPPFRAME_WAIT_MAIN_CSS{position:absolute; z-index:500; left:0; top:0; width:90%; height:98%; clip:rect(0,100%,100%,0); background-color:transparent; layer-background-color:white;visibility:hidden}
.AIAPPFRAME_WAIT_DIV_CSS{background:url(<%=request.getContextPath()%>/jsv2/image/aiwait/load_bg.gif) no-repeat;width:280px;height:80px;color:#2F5188;}
.AIAPPFRAME_WAIT_LOAD_CSS{background:url(<%=request.getContextPath()%>/jsv2/image/aiwait/loading.gif) no-repeat;width:32px;height:32px;}

/*-----------�ļ��ϴ���������ʽ-----------*/
.AIAPPFRAME_UPLOAD_MAIN_CSS{position:absolute; z-index:500; left:0; top:0; width:100%; height:98%; clip:rect(0,100%,100%,0); background-color:transparent; layer-background-color:white;visibility:hidden}
.AIAPPFRAME_UPLOAD_DIV_CSS{background:url(<%=request.getContextPath()%>/jsv2/image/aiwait/load_bg.gif) no-repeat;width:280px;height:80px;color:#2F5188;}
.AIAPPFRAME_UPLOAD_LOAD_CSS{background:url(<%=request.getContextPath()%>/jsv2/image/aiwait/loading.gif) no-repeat;width:32px;height:32px;}
.prog-border{height:15px;width:380px;background:#fff;border:1px solid #000;margin:0;padding: 0;}
.prog-bar{height:11px;margin:2px;padding:0px;background:#00ff00;}

/*-----------DBTreeNew��ص�css��ʽ-----------*/
/*���ڵ���ͼƬ����ʽ*/
.T-Img{cursor:hand;}
/*���ڵ��е����ֶ�ѡ״̬ʱ,checkbox����ʽ*/
.T-Checkbox{cursor:hand;}
/*���ı���ǩ����ʽ*/
.T-Label{cursor:hand;font-family: "����", "Arial", "Verdana"; font-size: 12px;}

/*-----------DBListBox��ص�css��ʽ-----------*/
/*��������������µ�CSS��ʽ*/
.DBListBox_normal_style{BORDER: 1px solid #7FC2D3;BORDER-COLLAPSE: collapse;}
/*�����򲻿��õ�����µ�CSS��ʽ*/
.DBListBox_disabled_style{background-color: #DDECFF;BORDER: 1px solid #7FC2D3;BORDER-COLLAPSE: collapse;}

/*-----------AIContentFrame��ص�css��ʽ-----------*/
.AIContentFrame_head_bg{height:20px;background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/title_bg1.gif);}
.AIContentFrame_head_left{width:40px;height:20px;background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/title_left1.gif);background-repeat:no-repeat}
.AIContentFrame_head_right{width:20px;height:20px;background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/title_right1.gif);background-repeat:no-repeat}
.AIContentFrame_main{border:1 solid #D2DFE7;background-color:#FFFFFF;padding-bottom:5px;}

/*-----------AIContractFrame���ڲ�����ʽ-----------*/
.AIContractFrame{text-align:center}
.AIContract{ width:100%;margin:0 10px;}
.line_start{padding:2px}
.line_end{padding:3px}
.t-bot-ml{background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/m-l.gif) no-repeat;padding-left:5px;overflow:hidden;zoom:1;}
.t-bot-mc{background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/m-c.gif) repeat-x; padding-right:5px; height:5px;}
.t-bot-mt{}
.t-bot-mm{background:#FFFFFF url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/m-m.gif) no-repeat left top;height:70px;padding:5px 5px 5px 50px;border:1 solid #bed6e0;border-width:0 1 0 1;}
.t-bot-mr{background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/m-r.gif) no-repeat right top;padding-right:5px;overflow:hidden;}
.t-bot-bl{background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/b-l.gif) no-repeat;height:8px;padding-left:5px;overflow:hidden;zoom:1;}
.t-bot-bc{background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/b-c.gif) repeat-x; height:8px;overflow:hidden;}
.t-bot-br{background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/b-r.gif) no-repeat right;height:8px;padding-right:5px;overflow:hidden;}
.t-bot-mc-right{}
.t-bot-mc-word{color:#567BA5;width:80%;text-align:center;}
.t-bot-mc-left{color:#567BA5;width:80%;text-align:left;}
.t-bot-mc-button{width:20%;text-align:right; white-space: nowrap; word-break: keep-all;}
.t-tool-up{width:15px;height:15px;float:right;cursor:pointer;background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/tool-up.gif) no-repeat;margin:5px 5px 0 5px;background-position:0 0px;}
.t-tool-up:hover{background-position:-15px 0px;}
.t-tool-down{width:15px;height:15px;float:right;cursor:pointer;background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/tool-down.gif) no-repeat;margin:5px 5px 0 5px;background-position:0 0px;}
.t-tool-down:hover{background-position:-15px 0px;}

/*-----------outlook�˵���ʽ-----------*/
.title00{height:24px;cursor:pointer;background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/tb-title.gif) repeat-x bottom;;text-align:center; padding-top:6px;text-decoration:none;}
.title00:hover{background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/tb-title.gif) repeat-x bottom;}
.title01{height:27px;cursor:pointer;background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/title01.gif) no-repeat; padding:5px 0 0 65px;text-decoration:none;color:#666666;}
.title01:hover{background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/title01.gif) repeat-x bottom;}
.title02{height:27px;cursor:pointer;background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/title02.gif) no-repeat; padding:5px 0 0 65px;text-decoration:none;color:#666666;}
.title02:hover{background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/title02.gif) no-repeat;}
.title03{height:27px;cursor:pointer;background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/title03.gif) no-repeat; padding:5px 0 0 65px;text-decoration:none;color:#666666;}
.title03:hover{background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/title03.gif) no-repeat;}
.title04{height:27px;cursor:pointer;background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/title04.gif) no-repeat; padding:5px 0 0 65px;text-decoration:none;color:#666666;}
.title04:hover{background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/title04.gif) no-repeat;}
.title05{height:24px;cursor:pointer;background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/tb-title.gif) repeat-x bottom;;text-align:center; padding-top:6px;text-decoration:none;}
.title05:hover{background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/tb-title.gif) repeat-x bottom;}
.title06{height:24px;cursor:pointer;background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/tb-title.gif) repeat-x bottom;;text-align:center; padding-top:6px;text-decoration:none;}
.title06:hover{background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/tb-title.gif) repeat-x bottom;}
.title07{height:24px;cursor:pointer;background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/tb-title.gif) repeat-x bottom;;text-align:center; padding-top:6px;text-decoration:none;}
.title07:hover{background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/tb-title.gif) repeat-x bottom;}
.title08{height:24px;cursor:pointer;background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/tb-title.gif) repeat-x bottom;;text-align:center; padding-top:6px;text-decoration:none;}
.title08:hover{background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/tb-title.gif) repeat-x bottom;}
.title09{height:24px;cursor:pointer;background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/tb-title.gif) repeat-x bottom;;text-align:center; padding-top:6px;text-decoration:none;}
.title09:hover{background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/tb-title.gif) repeat-x bottom;}
.title10{height:24px;cursor:pointer;background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/tb-title.gif) repeat-x bottom;;text-align:center; padding-top:6px;text-decoration:none;}
.title10:hover{background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/tb-title.gif) repeat-x bottom;}

.content{ height:100%;overflow:auto;padding:0px;margin:0px;}
a.li {display:block; height:20px;padding-left:10px;text-decoration: none;padding-top:3px;}
a.li:hover {background:url(<%=request.getContextPath()%>/bce/configtool/common/css/image/contentframe/tab_hoverbg.gif) repeat-x;height:20px;}
