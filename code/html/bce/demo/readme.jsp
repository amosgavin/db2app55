<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/bce/frame/BceFrameHead.jsp"%>
<%@page import="com.ai.appframe2.common.SessionManager"%>
<html>  
<head>
<title>readme</title>
</head>
<%SessionManager.getUser().set("REGION_ID", "571"); %>
<body>
  <TABLE border="1">
  <TR>
  	<TD align="center" width="15%">入口</TD>
  	<TD align="center" width="50%">说明</TD>
  	<TD align="center">相关配置</TD>
  </TR>
  <TR style="display:none">
  	<TD><a href="Demo_1.jsp">Demo_1</a></TD>
  	<TD>普通单页面数据集的提交，其中有两个commit方法，一个提交多个数据集进行数据保存，一个向后台提交待删除数据的主键值</TD>
  	<TD><a href="Demo_1.sql">sql</a></TD>
  </TR>
  <TR>
  	<TD><a href="<%=request.getContextPath()%>/bce/frame/SinglePageEntry.jsp?BUSIOPER_ID=10010&type=W">静态页面</a></TD>
  	<TD>单页面框架数据提交--静态页面</TD>
  	<TD>入口为：/bce/frame/SinglePageEntry.jsp?BUSIOPER_ID=10010</TD>
  </TR>
  <TR>
  	<TD><a href="<%=request.getContextPath()%>/bce/frame/SinglePageEntry.jsp?BUSIOPER_ID=10011">自动页面</a>
  	    <a href="<%=request.getContextPath()%>/bce/demo/Demo_6.jsp?BUSIOPER_ID=10012">自动页面2</a></TD>
  	<TD>单页面框架数据提交--自动页面</TD>
  	<TD>入口为：/bce/frame/SinglePageEntry.jsp?BUSIOPER_ID=10011<br><a href="Demo_4.sql">sql</a></TD>
  </TR>
  <TR>
  	<TD><a href="<%=request.getContextPath()%>/bce/frame/CommonMain.jsp?BUSIOPER_ID=10003">页面框架</a></TD>
  	<TD>页面框架数据提交</TD>
  	<TD>入口为：/bce/frame/CommonMain.jsp?BUSIOPER_ID=10003<br><a href="Demo_2.sql">sql</a></TD>
  </TR>
  <TR>
  	<TD><a href="<%=request.getContextPath()%>/crm/so/sfunc/SFuncMain.jsp?CUSTOMER_ID=2066239552&PRODUCT_INSTANCE_ID=400000000001&BUSIOPER_ID=10001&CenterType=RegionId&CenterValue=571">业务受理单点功能</a></TD>
  	<TD>业务受理单点功能</TD>
  	<TD>入口为：/crm/so/sfunc/SFuncMain.jsp<br><a href="Demo_3.sql">sql</a></TD>
  </TR>
  <TR>
  	<TD><a href="<%=request.getContextPath()%>/crm/so/rboss/SoMain.jsp?BUSIOPER_ID=800015100000&CenterType=RegionId&CenterValue=571">个人业务</a></TD>
  	<TD>个人新开户</TD>
  	<TD></TD>
  </TR>
  <TR>
  	<TD><a href="<%=request.getContextPath()%>/crm/so/bboss/CustInfo.jsp">集团业务</a></TD>
  	<TD>集团业务</TD>
  	<TD></TD>
  </TR>
  <TR>
  	<TD><a href="<%=request.getContextPath()%>/crm/so/rboss/SoMain.jsp?BUSIOPER_ID=6666666&CenterType=RegionId&CenterValue=571">营业单点测试页面</a></TD>
  	<TD>营业单点测试页面</TD>
  	<TD></TD>
  </TR>
  <TR>
  	<TD><a href="<%=request.getContextPath()%>/bce/demo/SetCacheRefresh.jsp">清除set缓存</a></TD>
  	<TD>清除set缓存</TD>
  	<TD></TD>
  </TR>
  <TR>
  		  <!--<TD><a href="<%=request.getContextPath()%>/crm/so/common/SoMain.jsp?PRODUCT_ID=800020000001&PRODUCT_NAME=语音专线业务规格&OFFER_ID=800010000007&OFFER_NAME=PBX专线接入套餐2&BUSIOPER_ID=899999999999&BUSIOPER_NAME=PBX专线接入新装&CUSTOMER_ID=710662395520&CUSTOMER_NAME=浙江省广播电视工程公司&GROUP_ID=5717165475&OFFER_INSTANCE_ID=&IS_SHOW_SHEET_BTN=N&VALID_TYPE=null&IS_BATCH=N&IS_CHILD=false&sequence=0.6064144287642748&REGION_ID=571">新产品测试</a></TD>-->
  	 <TD><a href="<%=request.getContextPath()%>/crm/so/common/SoMain.jsp?PRODUCT_ID=800020000028&PRODUCT_NAME=集团彩铃规格&OFFER_ID=800010000042&OFFER_NAME=集团彩铃套餐&BUSIOPER_ID=899999999999&BUSIOPER_NAME=集团彩铃新装&CUSTOMER_ID=710662395520&CUSTOMER_NAME=浙江省广播电视工程公司&GROUP_ID=5717165475&OFFER_INSTANCE_ID=&IS_SHOW_SHEET_BTN=N&VALID_TYPE=null&IS_BATCH=N&IS_CHILD=false&sequence=0.6128473628479503&REGION_ID=571&ADD_DEL_MEM_FLAG=true">新产品测试</a></TD> 
  	<TD>新产品测试</TD>
  	<TD></TD>
  </TR>
  <TR>
  	 	<TD><a href="<%=request.getContextPath()%>/crm/so/common/SoMain.jsp?PRODUCT_ID=800020000001&PRODUCT_NAME=语音专线业务规格&OFFER_ID=800010000007&OFFER_NAME=PBX专线接入套餐2&BUSIOPER_ID=899999999999&BUSIOPER_NAME=PBX专线接入新装&CUSTOMER_ID=710662395520&CUSTOMER_NAME=浙江省广播电视工程公司&GROUP_ID=5717165475&OFFER_INSTANCE_ID=&IS_SHOW_SHEET_BTN=N&VALID_TYPE=null&IS_BATCH=N&IS_CHILD=false&sequence=0.6064144287642748&REGION_ID=571&ADD_DEL_MEM_FLAG=true">新产品测试(PBX)</a></TD> 
  	<TD>新产品测试(PBX)</TD>
  	<TD></TD>
  </TR>
  <TR>
  <TR>
  	 	<TD><a href="<%=request.getContextPath()%>/crm/so/common/SoMain.jsp?PRODUCT_ID=6&PRODUCT_NAME=语音专线业务规格&OFFER_ID=500000100001&OFFER_NAME=VPMN套餐2&BUSIOPER_ID=899999999998&BUSIOPER_NAME=VPMN套餐&CUSTOMER_ID=710000000545&CUSTOMER_NAME=浙江省广播电视工程公司&GROUP_ID=5717165475&OFFER_INSTANCE_ID=400000000747&IS_SHOW_SHEET_BTN=N&VALID_TYPE=null&IS_BATCH=N&IS_CHILD=false&sequence=0.6064144287642748&REGION_ID=571&ADD_DEL_MEM_FLAG=true">新产品变更测试(VPMN)</a></TD> 
  	<TD>新产品变更测试(VPMN)</TD>
  	<TD></TD>
  </TR>
  <TR>
  		 <TD><a href="<%=request.getContextPath()%>/crm/so/common/SoMain.jsp?BE_FRAME_ID=99998&PRODUCT_ID=800020000028&OFFER_ID=800010000042&BUSIOPER_ID=899999999998&BUSIOPER_NAME=集团彩铃业务变更&CUSTOMER_ID=710662395520&CUSTOMER_NAME=&OFFER_INSTANCE_ID=400000001323&OFFER_INSTANCE_NAME=集团彩铃套餐&OFFER_NAME=集团彩铃套餐&PRODUCT_INSTANCE_ID=710000001883&BILL_ID=15512009359&ACCT_ID=&GRP_BILL_ID=	&VALID_TYPE=1&RETURN_PAGE=http://localhost:8111/crm/so/bboss/InstProdManager.jsp?CUSTOMER_ID$3D710662395520$26REGION_ID$3D571&IS_SHOW_SHEET_BTN=N&GROUP_ID=-1&REGION_ID=571&ADD_DEL_MEM_FLAG=true">新产品变更测试</a></TD>
  	<TD>新产品变更测试</TD>
  	<TD></TD>
  </TR>
   <TR>
  		 <TD><a href="<%=request.getContextPath()%>/crm/so/common/SoMain.jsp?BE_FRAME_ID=99998&PRODUCT_ID=800020000001&OFFER_ID=800010000007&BUSIOPER_ID=899999999998&BUSIOPER_NAME=PBX专线接入套餐变更&CUSTOMER_ID=710662395520&CUSTOMER_NAME=&OFFER_INSTANCE_ID=400000000911&OFFER_INSTANCE_NAME=PBX专线接入套餐&OFFER_NAME=PBX专线接入套餐&PRODUCT_INSTANCE_ID=710000001232&BILL_ID=15512006145&ACCT_ID=&GRP_BILL_ID=15512006145&VALID_TYPE=1&RETURN_PAGE=http://localhost:8111/crm/so/bboss/InstProdManager.jsp?CUSTOMER_ID$3D710662395520$26REGION_ID$3D571&IS_SHOW_SHEET_BTN=N&GROUP_ID=-1&REGION_ID=571&ADD_DEL_MEM_FLAG=true">新产品变更测试(PBX)</a></TD>
  	<TD>新产品变更测试(PBX)</TD>
  	<TD></TD>
  </TR>
  <TR>
   <TR>
  		 <TD><a href="<%=request.getContextPath()%>/crm/so/common/SoMain.jsp?BE_FRAME_ID=99997&PRODUCT_ID=800020000028&OFFER_ID=800010000042&BUSIOPER_ID=899999999997&BUSIOPER_NAME=集团彩铃销户&CUSTOMER_ID=710662395520&CUSTOMER_NAME=&OFFER_INSTANCE_ID=400000001323&OFFER_INSTANCE_NAME=集团彩铃套餐&OFFER_NAME=集团彩铃套餐&PRODUCT_INSTANCE_ID=710000001883&BILL_ID=15512009359&ACCT_ID=&GRP_BILL_ID=15512009359&VALID_TYPE=1&RETURN_PAGE=http://localhost:8111/crm/so/bboss/InstProdManager.jsp?CUSTOMER_ID$3D710662395520$26REGION_ID$3D571&IS_SHOW_SHEET_BTN=N&GROUP_ID=-1">新产品注销</a></TD>
  	<TD>新产品注销测试</TD>
  	<TD></TD>
  </TR>
  <TR>
  <TR>
   <TR>
  		 <TD><a href="<%=request.getContextPath()%>/crm/so/common/SoMain.jsp?BE_FRAME_ID=10000000278&PRODUCT_ID=800020000028&OFFER_ID=800010000042&BUSIOPER_ID=899999999996&BUSIOPER_NAME=集团彩铃成员添加&CUSTOMER_ID=710662395520&CUSTOMER_NAME=&OFFER_INSTANCE_ID=400000001323&OFFER_INSTANCE_NAME=集团彩铃套餐&OFFER_NAME=集团彩铃套餐&PRODUCT_INSTANCE_ID=710000001883&BILL_ID=15512009359&ACCT_ID=&GRP_BILL_ID=15512009359&VALID_TYPE=1&RETURN_PAGE=http://localhost:8111/crm/so/bboss/InstProdManager.jsp?CUSTOMER_ID$3D710662395520$26REGION_ID$3D571&IS_SHOW_SHEET_BTN=N&GROUP_ID=-1">新产品添加成员测试</a></TD>
  	<TD>新产品添加成员测试</TD>
  	<TD></TD>
  </TR>
  <TR>
  <TR>
  		 <TD><a href="<%=request.getContextPath()%>/crm/so/common/SoMain.jsp?BE_FRAME_ID=10000000279&PRODUCT_ID=800020000028&OFFER_ID=800010000042&BUSIOPER_ID=899999999995&BUSIOPER_NAME=集团彩铃成员删除&CUSTOMER_ID=710662395520&CUSTOMER_NAME=&OFFER_INSTANCE_ID=400000001323&OFFER_INSTANCE_NAME=集团彩铃套餐&OFFER_NAME=集团彩铃套餐&PRODUCT_INSTANCE_ID=710000001883&BILL_ID=15512009359&ACCT_ID=&GRP_BILL_ID=15512009359&VALID_TYPE=1&RETURN_PAGE=http://localhost:8111/crm/so/bboss/InstProdManager.jsp?CUSTOMER_ID$3D710662395520$26REGION_ID$3D571&IS_SHOW_SHEET_BTN=N&GROUP_ID=-1">新产品删除成员测试</a></TD>
  	<TD>新产品删除成员测试</TD>
  	<TD></TD>
  </TR>
  <TR>
  		 <TD><a href="<%=request.getContextPath()%>/crm/so/common/SoMain.jsp?PRODUCT_ID=1&PRODUCT_NAME=GSM产品规格&OFFER_ID=101010071303&OFFER_NAME=动感地带校园巨无霸套装&BUSIOPER_ID=900000000000&BUSIOPER_NAME=个人产品展现（测试）&CUSTOMER_ID=2066239552&CUSTOMER_NAME=Bills%20Family&OFFER_INSTANCE_ID=&IS_SHOW_SHEET_BTN=N&VALID_TYPE=null&IS_BATCH=N&IS_CHILD=false&sequence=0.6128473628479503&REGION_ID=571">新产品测试(个人)</a></TD>
  	<TD>新产品测试(个人)</TD>
  	<TD></TD>
  </TR>
   <TR>
  		 <TD><a href="<%=request.getContextPath()%>/bce/frame/bceCacheSearch.jsp">缓存查询</a></TD>
  	<TD>缓存查询</TD>
  	<TD></TD>
  </TR>
  </TABLE>
  注：可根据操作编号查询框架数据: <a href="<%=request.getContextPath()%>/bce/configtool">/bce/configtool</a>
</body>
</html>