<%@ page import="com.ai.common.i18n.CrmLocaleFactory"%>
BODY {
font-family:Tahoma,Arial,"宋体";font-size:12px; margin: 0; background-color:#FFFFFF; overflow:auto;
SCROLLBAR-FACE-COLOR: #E7EFFF; SCROLLBAR-HIGHLIGHT-COLOR:#7FC2D3; SCROLLBAR-SHADOW-COLOR:#7FC2D3; SCROLLBAR-3DLIGHT-COLOR: #E7EFFF; SCROLLBAR-ARROW-COLOR: #023EEE; SCROLLBAR-TRACK-COLOR: #E4E6F8; SCROLLBAR-DARKSHADOW-COLOR: #E4E6F8; SCROLLBAR-BASE-COLOR: #1763BB;
}

TR {font-family:Tahoma,Arial,"宋体";FONT-SIZE: 12px;}
textarea {font-family:"Arial";font-size:12px; background-color: #FFFFFF; color:#000000;  border:1 solid #7FC2D3;}
select {font-family:"Arial";font-size:12px;background-color: #FFFFFF;color:#000000;}
.input{font-family:"Arial";font-size:12px;color:#000000; background-color: #FFFFFF; border-width:1px; border-style:solid; border-color:#78ACFF;padding-top: 2px;padding-left: 3px;height: 20px;}
.input_gray{font-family:"Arial";font-size:12px;color:#000000; background-color: #EAF2FF; border-width:1px; border-style:solid; border-color:#78ACFF;padding-top: 2px;padding-left: 3px;height: 20px;}
.btn_mouseout {background:url(<%=request.getContextPath()%>/jsv2/image/button/button_bg.gif) repeat-x 0 -2px; height:22px; color:#1E5494; padding-top: 4px; border:1px solid #8ac2d9; cursor: hand;}
.btn_mouseover {background:url(<%=request.getContextPath()%>/jsv2/image/button/button_bg.gif) repeat-x 0 -24px; height:22px; color:#3C75AD; padding-top: 4px; border:1px solid #8ac2d9; cursor: hand;}
.btn_glint {background:url(<%=request.getContextPath()%>/jsv2/image/button/button_glint_bg.gif) repeat-x; height:22px; color:#A26926; padding-top: 4px; border:1px solid #f3e155; cursor: hand;}
form {font-family:"Arial";display: inline;}

/* 主框架样式定义 */
.group{width:100%; clear:both;}
.right {float:right; clear:right; word-wrap:break-word;}
.left {float:left; word-wrap:break-word; border-right:1 solid #1676D0;}

#top{background:url(<%=request.getContextPath()%>/webframe/images/main/top_bg1.gif) top repeat-x;}
#logo{ float:left;height:59px; width:480px; background:url(<%=request.getContextPath()%>/webframe/images/main/logo_<%=CrmLocaleFactory.getCurrentLocale().toString()%>.gif) no-repeat;padding:35px 0 0 132px;color:#666666;}
#right_top{ float:right; text-align:right;padding:25px 10px 0 0;color:#1E5494;height:59px; width:370px; background:url(<%=request.getContextPath()%>/webframe/images/main/top1.gif) right;}
#checkbar{background:url(<%=request.getContextPath()%>/webframe/images/main/menu_bg03.gif) top repeat-x;height:30px;line-heigth:29px;}
#left_arrow_div{ position:absolute; top:93px; left:0;height:24px; text-align:right; padding-right:3px; }
#desktop{ width:100%; height:100%; background:#fefefe url(<%=request.getContextPath()%>/webframe/images/main/desktop_bg.jpg) bottom right no-repeat}
#menu01{background:url(<%=request.getContextPath()%>/webframe/images/main/menu_bg01.gif) repeat-x top;height:25px;padding:5px 10px 0 10px;color:#6386B0;}
#menu02{background:url(<%=request.getContextPath()%>/webframe/images/main/menu_bg02.gif) repeat-x top;height:30px;}
a.button{ background:url(<%=request.getContextPath()%>/webframe/images/main/arrow_left.gif) left top;display:block;width:14px;height:15px;border:0;}
a.button:hover{background-position:right top;}
.left_bar{float:left;}
.right_bar{float:right;}
.left_bg{background:#F0F3FA;}
.kscx{background:url(<%=request.getContextPath()%>/webframe/images/main/kscx.gif) no-repeat;width:93px;height:29px;padding:8px 0 0 30px;color:#6386b0;float:left;}
.kscx_nr{float:left;line-height:28px;padding-top:2px;width:auto;}
#down_bar{position:absolute;float:left;z-index:100;height:19px;margin-top:2px;padding:0 5px 10px 5px;line-height:30px;cursor:pointer;overflow:hidden;}
.down_bar_over{border:1 solid #8DB2E3;background-color:#F1F3FB;filter:alpha(opacity=90);}
.down_bar_out{border-top:1 solid #f2f7fa;border-left:1 solid #f2f7fa;border-right:1 solid #f2f7fa;border-bottom:1 solid #f8fcfd;}
.ggitem{height:25px;background:url(<%=request.getContextPath()%>/jsv2/image/contentframe/titleitem.gif) repeat-x;padding-left:30px;color:#666666;}
.role_vm{background:url(<%=request.getContextPath()%>/webframe/images/main/menu_bg01.gif) repeat-x top;height:25px;padding:5px 10px 0 10px;color:#6186B0;font-weight:bold;text-align:left;}
.srvpkg_vm{background-color:#F0F3FA;height:25px;padding:5px 10px 0 10px;color:#666666;text-align:left;}
.input_vm{width:150px;border:0;background-color:#ffffff;}

/*下拉文本框样式*/
.selview{position: absolute;left:175px;top:3;z-index:100;width: 100px;border-right:0;border-width:1px;border-style:solid;border-color:#78ACFF;padding-top: 2px;padding-left: 3px;height: 21px;}
.maskSpan{border:1px solid #78ACFF;position:absolute;overflow:hidden;top:3px;left:180px;height:21px;}

/*可关闭拖动层样式*/
.layer_move{border:1 solid #8DB2E3;background-color:#F1F3FB;width:300px;position:absolute;top:0px;left:0px;z-index:999;}
.layer_title{background:url(<%=request.getContextPath()%>/webframe/images/main/menu_bg01.gif) repeat-x top;height:25px;padding:6px 10px 0 10px;color:#6186B0;font-weight:bold;text-align:left;}
.layer_con{padding:5px 10px;line-height:22px;color:#666666;}
.tool_close{width:18px;height:18px;cursor:pointer;background:url(<%=request.getContextPath()%>/webframe/images/close.gif) no-repeat;margin:-22px 3px 0px 0px;background-position:0 0px;float:right;}
.tool_close:hover{background-position:-18px 0px;}

/*模板界面样式*/
.title_mb01{ background:url(<%=request.getContextPath()%>/webframe/images/main/title_mbbg01.gif);height:26px;border:1 solid #1676D0;color:#FFFFFF;font:bold;padding:5px 0 0 40px;margin:5px;}
.title_mb02{ background:url(<%=request.getContextPath()%>/webframe/images/main/title_mbbg02.gif);height:26px;border:1 solid #1676D0;color:#FFFFFF;font:bold;padding:5px 0 0 40px;margin:5px;}
.title_mb03{ background:url(<%=request.getContextPath()%>/webframe/images/main/title_mbbg03.gif);height:26px;border:1 solid #1676D0;color:#FFFFFF;font:bold;padding:5px 0 0 40px;margin:5px;}
.title_mbbg{ background:url(<%=request.getContextPath()%>/webframe/images/main/title_mbbg.gif);height:22px;}
.title_mbdh{ background:#FFFFFF;height:20px;}
.title_mbsh{ background:#F2F7FA;height:20px;}
.title_word{color:#2C6AA9;font:bold;padding-left:40px;}
.title_left{padding-left:30px;}
.dot{ background:url(<%=request.getContextPath()%>/webframe/images/main/dot.gif) no-repeat; width:12px; height:13px; border:0}

/* 页面不同文字大小的定义 */
.font18{font-family:; font-size: 18px;line-height: 140%}
.font16{font-family:;font-size: 16px;line-height: 140%}
.font14{font-family:;font-size: 14px; line-height: 140%}
.font12{font-family:;font-size: 12px; line-height: 150%}

/* 页面不同颜色字体的定义 */
.font_note {color:#FF7800;font-weight: bold;}
.font_red {	color: #FF3300;}
.font_yellow{ color:#FF8A00}
.font_grey { color: #2C59AA;}
.font_link {color:#3366CC;font-size:12px;font-weight: bold;cursor: hand;}
.font_blue {color:#346796;}
.font_green {color:#336600;}
.font_white { color:#FFFFFF}
.font_bold {font-weight: bold;}
.G-Table-NoData{ color:#FF0000}

/* 页面不同区域位置的定义 */
.area_tab{ width:100%; text-align:center; padding-top:5px;}
.td_font{ width:10%; text-align:right;white-space: nowrap;}
.td_font_vm{ width:120px; text-align:right}
.td_button{ width:10%; text-align:center}
.area_button{ width:100%; text-align:center; height:40px; padding-top:10px;}

/* 非DBGrid独立表格样式 */
.table_out{background:#F0F3FA;border:solid #8CB2E3;border-width:1 0 0 1;margin:5px 0;}
.table_head{height:22px;color:#333333;text-align:center;border:#8CB2E3 solid;border-width:0 1 1 0;background:url(<%=request.getContextPath()%>/jsv2/image/grid/title_bg.gif);display:block;}
.table_head1{height:22px;color:#333333;text-align:center;border:#8CB2E3 solid;border-width:0 0 1 0;background:url(<%=request.getContextPath()%>/jsv2/image/grid/title_bg.gif);display:block;}
.td_one{background-color:#FFFFFF;border:#8CB2E3 solid;border-width:0 1 1 0;color:#013299;padding:2px;}
.td_one1{background-color:#FFFFFF;border:#8CB2E3 solid;border-width:0 0 1 0;color:#013299;padding:2px;}
.td_two{background-color:#F3F5F8;border:#8CB2E3 solid;border-width:0 1 1 0;color:#013299;padding:2px;}
.td_two1{background-color:#F3F5F8;border:#8CB2E3 solid;border-width:0 0 1 0;color:#013299;padding:2px;}

/* 非DBGrid独立表格样式  add by taojy */
.table_vm_out{background:#F0F3FA;border:solid #8CB2E3;border-width:0 0 0 0;margin:5px 0;}
.table_vm_head{height:22px;color:#1874CD;text-align:center;border:#8CB2E3 solid;border-width:0 1 0 0;background:url(<%=request.getContextPath()%>/jsv2/image/grid/title_bg.gif);display:block;}
.table_vm_last{height:22px;color:#1874CD;text-align:center;border:#8CB2E3 solid;border-width:0 0 0 0;background:url(<%=request.getContextPath()%>/jsv2/image/grid/title_bg.gif);display:block;}
.td_vm_one{background-color:#FFFFFF;border:#8CB2E3 solid;border-width:0 0 0 0;color:#013299;padding:2px;border-bottom:1px dashed #ccc;}
.td_vm_one_user{background-color:#FFFFFF;border:#8CB2E3 solid;border-width:0 0 0 0;color:#013299;padding:2px;}
.td_vm_one_plan{background-color:#FFFFFF;border:#8CB2E3 solid;border-width:0 0 0 0;color:#013299;padding:2px;}
.table_vm_head1{background-color:#7AC2FE;border:#8CB2E3 solid;border-width:0 1 0 0;color:#013299;padding:2px;}
.table_vm_head1_last{background-color:#7AC2FE;border:#8CB2E3 solid;border-width:0 0 0 0;color:#013299;padding:2px;}
.td_vm_one1{background-color:#E0EEEE;border:#8CB2E3 solid;border-width:0 0 0 0;color:#013299;padding:2px;}

/* 公告样式 */
.notice{background:url(<%=request.getContextPath()%>/webframe/images/main/notice_bg.gif) no-repeat;}
.notice_title{margin-left:70px;padding:20px 10px;color:#4e77a9;font-size:13px;font-weight: bold;height:110px;text-align:center;}
.notice_word{padding:5px;color:#333333;line-height:20px;}
.notice_end{background:url(<%=request.getContextPath()%>/webframe/images/main/menu_bg02.gif) repeat-x top;height:30px;padding:5px 10px 0 10px;color:#6386B0;border-top:1px solid #79a8e0;}

/* 基本链接样式 */
A:link {color: #1E5494; text-decoration: none;}
A:visited {color: #1E5494; text-decoration: none}
A:active {color: #1E5494; text-decoration: none}
A:hover {color: #4A84C9; text-decoration: none}

/* 特殊链接样式 */
.a { color: #000000; text-decoration: none}
.a:active { color: #000000; text-decoration: none}
.a:link { color: #000000; text-decoration: none}
.a:visited { color: #000000; text-decoration: none}
.a:hover { color: #4171B1; text-decoration: none}
.b { color: #15428B; text-decoration: none}
.b:active { color: #15428B; text-decoration: none}
.b:link { color: #15428B; text-decoration: none}
.b:visited { color: #15428B; text-decoration: none}
.b:hover { color: #4171B1; text-decoration: none}

/*各种按钮及小图片样式*/
.dot_doc{ width:20px; height:20px; background:url(../images/dot_doc.gif) no-repeat;}
.dot_exe{ width:20px; height:20px; background:url(../images/dot_exe.gif) no-repeat;}
.dot_img{ width:20px; height:20px; background:url(../images/dot_img.gif) no-repeat;}
.dot_media{ width:20px; height:20px; background:url(../images/dot_media.gif) no-repeat;}
.dot_pdf{ width:20px; height:20px; background:url(../images/dot_pdf.gif) no-repeat;}
.dot_ppt{ width:20px; height:20px; background:url(../images/dot_ppt.gif) no-repeat;}
.dot_rar{ width:20px; height:20px; background:url(../images/dot_rar.gif) no-repeat;}
.dot_swf{ width:20px; height:20px; background:url(../images/dot_swf.gif) no-repeat;}
.dot_txt{ width:20px; height:20px; background:url(../images/dot_txt.gif) no-repeat;}
.dot_xls{ width:20px; height:20px; background:url(../images/dot_xls.gif) no-repeat;}
.dot_zip{ width:20px; height:20px; background:url(../images/dot_zip.gif) no-repeat;}

.icon_bk{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_bk.gif) no-repeat;background-position:0px 0px;height:22px;width:24px;border:0;cursor:hand;}
.icon_bkHover{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_bk.gif) no-repeat;background-position:0px -22px;height:22px;width:24px;border:0;cursor:hand;}
.icon_bkDisabled{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_bk.gif) no-repeat;background-position:0px -44px;height:22px;width:24px;border:0;cursor:hand;}
.icon_bs{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_bs.gif) no-repeat;background-position:0px 0px;height:22px;width:24px;border:0;cursor:hand;}
.icon_bsHover{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_bs.gif) no-repeat;background-position:0px -22px;height:22px;width:24px;border:0;cursor:hand;}
.icon_bsDisabled{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_bs.gif) no-repeat;background-position:0px -44px;height:22px;width:24px;border:0;cursor:hand;}
.icon_call{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_call.gif) no-repeat;background-position:0px 0px;height:22px;width:24px;border:0;cursor:hand;}
.icon_callHover{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_call.gif) no-repeat;background-position:0px -22px;height:22px;width:24px;border:0;cursor:hand;}
.icon_callDisabled{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_call.gif) no-repeat;background-position:0px -44px;height:22px;width:24px;border:0;cursor:hand;}
.icon_edit{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_edit.gif) no-repeat;background-position:0px 0px;height:22px;width:24px;border:0;cursor:hand;}
.icon_editHover{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_edit.gif) no-repeat;background-position:0px -22px;height:22px;width:24px;border:0;cursor:hand;}
.icon_editDisabled{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_edit.gif) no-repeat;background-position:0px -44px;height:22px;width:24px;border:0;cursor:hand;}
.icon_fk{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_fk.gif) no-repeat;background-position:0px 0px;height:22px;width:24px;border:0;cursor:hand;}
.icon_fkHover{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_fk.gif) no-repeat;background-position:0px -22px;height:22px;width:24px;border:0;cursor:hand;}
.icon_fkDisabled{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_fk.gif) no-repeat;background-position:0px -44px;height:22px;width:24px;border:0;cursor:hand;}
.icon_ft{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_ft.gif) no-repeat;background-position:0px 0px;height:22px;width:24px;border:0;cursor:hand;}
.icon_ftHover{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_ft.gif) no-repeat;background-position:0px -22px;height:22px;width:24px;border:0;cursor:hand;}
.icon_ftDisabled{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_ft.gif) no-repeat;background-position:0px -44px;height:22px;width:24px;border:0;cursor:hand;}
.icon_mail{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_mail.gif) no-repeat;background-position:0px 0px;height:22px;width:24px;border:0;cursor:hand;}
.icon_mailHover{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_mail.gif) no-repeat;background-position:0px -22px;height:22px;width:24px;border:0;cursor:hand;}
.icon_mailDisabled{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_mail.gif) no-repeat;background-position:0px -44px;height:22px;width:24px;border:0;cursor:hand;}
.icon_newinfo{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_newinfo.gif) no-repeat;background-position:0px 0px;height:22px;width:24px;border:0;cursor:hand;}
.icon_newinfoHover{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_newinfo.gif) no-repeat;background-position:0px -22px;height:22px;width:24px;border:0;cursor:hand;}
.icon_newinfoDisabled{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_newinfo.gif) no-repeat;background-position:0px -44px;height:22px;width:24px;border:0;cursor:hand;}
.icon_note{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_note.gif) no-repeat;background-position:0px 0px;height:22px;width:24px;border:0;cursor:hand;}
.icon_noteHover{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_note.gif) no-repeat;background-position:0px -22px;height:22px;width:24px;border:0;cursor:hand;}
.icon_noteDisabled{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_note.gif) no-repeat;background-position:0px -44px;height:22px;width:24px;border:0;cursor:hand;}
.icon_se{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_se.gif) no-repeat;background-position:0px 0px;height:22px;width:24px;border:0;cursor:hand;}
.icon_seHover{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_se.gif) no-repeat;background-position:0px -22px;height:22px;width:24px;border:0;cursor:hand;}
.icon_seDisabled{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_se.gif) no-repeat;background-position:0px -44px;height:22px;width:24px;border:0;cursor:hand;}
.icon_up{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_up.gif) no-repeat;background-position:0px 0px;height:22px;width:24px;border:0;cursor:hand;}
.icon_upHover{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_up.gif) no-repeat;background-position:0px -22px;height:22px;width:24px;border:0;cursor:hand;}
.icon_upDisabled{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_up.gif) no-repeat;background-position:0px -44px;height:22px;width:24px;border:0;cursor:hand;}
.icon_message{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_message.gif) no-repeat;background-position:0px 0px;height:22px;width:24px;border:0;cursor:hand;}
.icon_messageHover{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_message.gif) no-repeat;background-position:0px -22px;height:22px;width:24px;border:0;cursor:hand;}
.icon_messageDisabled{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_message.gif) no-repeat;background-position:0px -44px;height:22px;width:24px;border:0;cursor:hand;}

.icon_add{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_add.gif) no-repeat;background-position:0px 0px;height:22px;width:60px;border:0;cursor:hand;padding:4 0 0 26;text-align:left;}
.icon_addHover{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_add.gif) no-repeat;background-position:0px -22px;height:22px;width:60px;border:0;cursor:hand;padding:4 0 0 26;text-align:left;}
.icon_addDisabled{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_add.gif) no-repeat;background-position:0px -44px;height:22px;width:60px;border:0;cursor:hand;padding:4 0 0 26;text-align:left;}
.icon_modifiy{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_modifiy.gif) no-repeat;background-position:0px 0px;height:22px;width:60px;border:0;cursor:hand;padding:4 0 0 26;text-align:left;}
.icon_modifiyHover{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_modifiy.gif) no-repeat;background-position:0px -22px;height:22px;width:60px;border:0;cursor:hand;padding:4 0 0 26;text-align:left;}
.icon_modifiyDisabled{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_modifiy.gif) no-repeat;background-position:0px -44px;height:22px;width:60px;border:0;cursor:hand;padding:4 0 0 26;text-align:left;}
.icon_port{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_port.gif) no-repeat;background-position:0px 0px;height:22px;width:60px;border:0;cursor:hand;padding:4 0 0 26;text-align:left;}
.icon_portHover{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_port.gif) no-repeat;background-position:0px -22px;height:22px;width:60px;border:0;cursor:hand;padding:4 0 0 26;text-align:left;}
.icon_portDisabled{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_port.gif) no-repeat;background-position:0px -44px;height:22px;width:60px;border:0;cursor:hand;padding:4 0 0 26;text-align:left;}
.icon_finish{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_finish.gif) no-repeat;background-position:0px 0px;height:22px;width:80px;border:0;cursor:hand;padding:4 0 0 26;text-align:left;}
.icon_finishHover{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_finish.gif) no-repeat;background-position:0px -22px;height:22px;width:80px;border:0;cursor:hand;padding:4 0 0 26;text-align:left;}
.icon_finishDisabled{background: url(<%=request.getContextPath()%>/webframe/images/icon/icon_finish.gif) no-repeat;background-position:0px -44px;height:22px;width:80px;border:0;cursor:hand;padding:4 0 0 26;text-align:left;}