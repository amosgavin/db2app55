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
  	<TD align="center" width="15%">���</TD>
  	<TD align="center" width="50%">˵��</TD>
  	<TD align="center">�������</TD>
  </TR>
  <TR style="display:none">
  	<TD><a href="Demo_1.jsp">Demo_1</a></TD>
  	<TD>��ͨ��ҳ�����ݼ����ύ������������commit������һ���ύ������ݼ��������ݱ��棬һ�����̨�ύ��ɾ�����ݵ�����ֵ</TD>
  	<TD><a href="Demo_1.sql">sql</a></TD>
  </TR>
  <TR>
  	<TD><a href="<%=request.getContextPath()%>/bce/frame/SinglePageEntry.jsp?BUSIOPER_ID=10010&type=W">��̬ҳ��</a></TD>
  	<TD>��ҳ���������ύ--��̬ҳ��</TD>
  	<TD>���Ϊ��/bce/frame/SinglePageEntry.jsp?BUSIOPER_ID=10010</TD>
  </TR>
  <TR>
  	<TD><a href="<%=request.getContextPath()%>/bce/frame/SinglePageEntry.jsp?BUSIOPER_ID=10011">�Զ�ҳ��</a>
  	    <a href="<%=request.getContextPath()%>/bce/demo/Demo_6.jsp?BUSIOPER_ID=10012">�Զ�ҳ��2</a></TD>
  	<TD>��ҳ���������ύ--�Զ�ҳ��</TD>
  	<TD>���Ϊ��/bce/frame/SinglePageEntry.jsp?BUSIOPER_ID=10011<br><a href="Demo_4.sql">sql</a></TD>
  </TR>
  <TR>
  	<TD><a href="<%=request.getContextPath()%>/bce/frame/CommonMain.jsp?BUSIOPER_ID=10003">ҳ����</a></TD>
  	<TD>ҳ���������ύ</TD>
  	<TD>���Ϊ��/bce/frame/CommonMain.jsp?BUSIOPER_ID=10003<br><a href="Demo_2.sql">sql</a></TD>
  </TR>
  <TR>
  	<TD><a href="<%=request.getContextPath()%>/crm/so/sfunc/SFuncMain.jsp?CUSTOMER_ID=2066239552&PRODUCT_INSTANCE_ID=400000000001&BUSIOPER_ID=10001&CenterType=RegionId&CenterValue=571">ҵ�������㹦��</a></TD>
  	<TD>ҵ�������㹦��</TD>
  	<TD>���Ϊ��/crm/so/sfunc/SFuncMain.jsp<br><a href="Demo_3.sql">sql</a></TD>
  </TR>
  <TR>
  	<TD><a href="<%=request.getContextPath()%>/crm/so/rboss/SoMain.jsp?BUSIOPER_ID=800015100000&CenterType=RegionId&CenterValue=571">����ҵ��</a></TD>
  	<TD>�����¿���</TD>
  	<TD></TD>
  </TR>
  <TR>
  	<TD><a href="<%=request.getContextPath()%>/crm/so/bboss/CustInfo.jsp">����ҵ��</a></TD>
  	<TD>����ҵ��</TD>
  	<TD></TD>
  </TR>
  <TR>
  	<TD><a href="<%=request.getContextPath()%>/crm/so/rboss/SoMain.jsp?BUSIOPER_ID=6666666&CenterType=RegionId&CenterValue=571">Ӫҵ�������ҳ��</a></TD>
  	<TD>Ӫҵ�������ҳ��</TD>
  	<TD></TD>
  </TR>
  <TR>
  	<TD><a href="<%=request.getContextPath()%>/bce/demo/SetCacheRefresh.jsp">���set����</a></TD>
  	<TD>���set����</TD>
  	<TD></TD>
  </TR>
  <TR>
  		  <!--<TD><a href="<%=request.getContextPath()%>/crm/so/common/SoMain.jsp?PRODUCT_ID=800020000001&PRODUCT_NAME=����ר��ҵ����&OFFER_ID=800010000007&OFFER_NAME=PBXר�߽����ײ�2&BUSIOPER_ID=899999999999&BUSIOPER_NAME=PBXר�߽�����װ&CUSTOMER_ID=710662395520&CUSTOMER_NAME=�㽭ʡ�㲥���ӹ��̹�˾&GROUP_ID=5717165475&OFFER_INSTANCE_ID=&IS_SHOW_SHEET_BTN=N&VALID_TYPE=null&IS_BATCH=N&IS_CHILD=false&sequence=0.6064144287642748&REGION_ID=571">�²�Ʒ����</a></TD>-->
  	 <TD><a href="<%=request.getContextPath()%>/crm/so/common/SoMain.jsp?PRODUCT_ID=800020000028&PRODUCT_NAME=���Ų�����&OFFER_ID=800010000042&OFFER_NAME=���Ų����ײ�&BUSIOPER_ID=899999999999&BUSIOPER_NAME=���Ų�����װ&CUSTOMER_ID=710662395520&CUSTOMER_NAME=�㽭ʡ�㲥���ӹ��̹�˾&GROUP_ID=5717165475&OFFER_INSTANCE_ID=&IS_SHOW_SHEET_BTN=N&VALID_TYPE=null&IS_BATCH=N&IS_CHILD=false&sequence=0.6128473628479503&REGION_ID=571&ADD_DEL_MEM_FLAG=true">�²�Ʒ����</a></TD> 
  	<TD>�²�Ʒ����</TD>
  	<TD></TD>
  </TR>
  <TR>
  	 	<TD><a href="<%=request.getContextPath()%>/crm/so/common/SoMain.jsp?PRODUCT_ID=800020000001&PRODUCT_NAME=����ר��ҵ����&OFFER_ID=800010000007&OFFER_NAME=PBXר�߽����ײ�2&BUSIOPER_ID=899999999999&BUSIOPER_NAME=PBXר�߽�����װ&CUSTOMER_ID=710662395520&CUSTOMER_NAME=�㽭ʡ�㲥���ӹ��̹�˾&GROUP_ID=5717165475&OFFER_INSTANCE_ID=&IS_SHOW_SHEET_BTN=N&VALID_TYPE=null&IS_BATCH=N&IS_CHILD=false&sequence=0.6064144287642748&REGION_ID=571&ADD_DEL_MEM_FLAG=true">�²�Ʒ����(PBX)</a></TD> 
  	<TD>�²�Ʒ����(PBX)</TD>
  	<TD></TD>
  </TR>
  <TR>
  <TR>
  	 	<TD><a href="<%=request.getContextPath()%>/crm/so/common/SoMain.jsp?PRODUCT_ID=6&PRODUCT_NAME=����ר��ҵ����&OFFER_ID=500000100001&OFFER_NAME=VPMN�ײ�2&BUSIOPER_ID=899999999998&BUSIOPER_NAME=VPMN�ײ�&CUSTOMER_ID=710000000545&CUSTOMER_NAME=�㽭ʡ�㲥���ӹ��̹�˾&GROUP_ID=5717165475&OFFER_INSTANCE_ID=400000000747&IS_SHOW_SHEET_BTN=N&VALID_TYPE=null&IS_BATCH=N&IS_CHILD=false&sequence=0.6064144287642748&REGION_ID=571&ADD_DEL_MEM_FLAG=true">�²�Ʒ�������(VPMN)</a></TD> 
  	<TD>�²�Ʒ�������(VPMN)</TD>
  	<TD></TD>
  </TR>
  <TR>
  		 <TD><a href="<%=request.getContextPath()%>/crm/so/common/SoMain.jsp?BE_FRAME_ID=99998&PRODUCT_ID=800020000028&OFFER_ID=800010000042&BUSIOPER_ID=899999999998&BUSIOPER_NAME=���Ų���ҵ����&CUSTOMER_ID=710662395520&CUSTOMER_NAME=&OFFER_INSTANCE_ID=400000001323&OFFER_INSTANCE_NAME=���Ų����ײ�&OFFER_NAME=���Ų����ײ�&PRODUCT_INSTANCE_ID=710000001883&BILL_ID=15512009359&ACCT_ID=&GRP_BILL_ID=	&VALID_TYPE=1&RETURN_PAGE=http://localhost:8111/crm/so/bboss/InstProdManager.jsp?CUSTOMER_ID$3D710662395520$26REGION_ID$3D571&IS_SHOW_SHEET_BTN=N&GROUP_ID=-1&REGION_ID=571&ADD_DEL_MEM_FLAG=true">�²�Ʒ�������</a></TD>
  	<TD>�²�Ʒ�������</TD>
  	<TD></TD>
  </TR>
   <TR>
  		 <TD><a href="<%=request.getContextPath()%>/crm/so/common/SoMain.jsp?BE_FRAME_ID=99998&PRODUCT_ID=800020000001&OFFER_ID=800010000007&BUSIOPER_ID=899999999998&BUSIOPER_NAME=PBXר�߽����ײͱ��&CUSTOMER_ID=710662395520&CUSTOMER_NAME=&OFFER_INSTANCE_ID=400000000911&OFFER_INSTANCE_NAME=PBXר�߽����ײ�&OFFER_NAME=PBXר�߽����ײ�&PRODUCT_INSTANCE_ID=710000001232&BILL_ID=15512006145&ACCT_ID=&GRP_BILL_ID=15512006145&VALID_TYPE=1&RETURN_PAGE=http://localhost:8111/crm/so/bboss/InstProdManager.jsp?CUSTOMER_ID$3D710662395520$26REGION_ID$3D571&IS_SHOW_SHEET_BTN=N&GROUP_ID=-1&REGION_ID=571&ADD_DEL_MEM_FLAG=true">�²�Ʒ�������(PBX)</a></TD>
  	<TD>�²�Ʒ�������(PBX)</TD>
  	<TD></TD>
  </TR>
  <TR>
   <TR>
  		 <TD><a href="<%=request.getContextPath()%>/crm/so/common/SoMain.jsp?BE_FRAME_ID=99997&PRODUCT_ID=800020000028&OFFER_ID=800010000042&BUSIOPER_ID=899999999997&BUSIOPER_NAME=���Ų�������&CUSTOMER_ID=710662395520&CUSTOMER_NAME=&OFFER_INSTANCE_ID=400000001323&OFFER_INSTANCE_NAME=���Ų����ײ�&OFFER_NAME=���Ų����ײ�&PRODUCT_INSTANCE_ID=710000001883&BILL_ID=15512009359&ACCT_ID=&GRP_BILL_ID=15512009359&VALID_TYPE=1&RETURN_PAGE=http://localhost:8111/crm/so/bboss/InstProdManager.jsp?CUSTOMER_ID$3D710662395520$26REGION_ID$3D571&IS_SHOW_SHEET_BTN=N&GROUP_ID=-1">�²�Ʒע��</a></TD>
  	<TD>�²�Ʒע������</TD>
  	<TD></TD>
  </TR>
  <TR>
  <TR>
   <TR>
  		 <TD><a href="<%=request.getContextPath()%>/crm/so/common/SoMain.jsp?BE_FRAME_ID=10000000278&PRODUCT_ID=800020000028&OFFER_ID=800010000042&BUSIOPER_ID=899999999996&BUSIOPER_NAME=���Ų����Ա���&CUSTOMER_ID=710662395520&CUSTOMER_NAME=&OFFER_INSTANCE_ID=400000001323&OFFER_INSTANCE_NAME=���Ų����ײ�&OFFER_NAME=���Ų����ײ�&PRODUCT_INSTANCE_ID=710000001883&BILL_ID=15512009359&ACCT_ID=&GRP_BILL_ID=15512009359&VALID_TYPE=1&RETURN_PAGE=http://localhost:8111/crm/so/bboss/InstProdManager.jsp?CUSTOMER_ID$3D710662395520$26REGION_ID$3D571&IS_SHOW_SHEET_BTN=N&GROUP_ID=-1">�²�Ʒ��ӳ�Ա����</a></TD>
  	<TD>�²�Ʒ��ӳ�Ա����</TD>
  	<TD></TD>
  </TR>
  <TR>
  <TR>
  		 <TD><a href="<%=request.getContextPath()%>/crm/so/common/SoMain.jsp?BE_FRAME_ID=10000000279&PRODUCT_ID=800020000028&OFFER_ID=800010000042&BUSIOPER_ID=899999999995&BUSIOPER_NAME=���Ų����Աɾ��&CUSTOMER_ID=710662395520&CUSTOMER_NAME=&OFFER_INSTANCE_ID=400000001323&OFFER_INSTANCE_NAME=���Ų����ײ�&OFFER_NAME=���Ų����ײ�&PRODUCT_INSTANCE_ID=710000001883&BILL_ID=15512009359&ACCT_ID=&GRP_BILL_ID=15512009359&VALID_TYPE=1&RETURN_PAGE=http://localhost:8111/crm/so/bboss/InstProdManager.jsp?CUSTOMER_ID$3D710662395520$26REGION_ID$3D571&IS_SHOW_SHEET_BTN=N&GROUP_ID=-1">�²�Ʒɾ����Ա����</a></TD>
  	<TD>�²�Ʒɾ����Ա����</TD>
  	<TD></TD>
  </TR>
  <TR>
  		 <TD><a href="<%=request.getContextPath()%>/crm/so/common/SoMain.jsp?PRODUCT_ID=1&PRODUCT_NAME=GSM��Ʒ���&OFFER_ID=101010071303&OFFER_NAME=���еش�У԰���ް���װ&BUSIOPER_ID=900000000000&BUSIOPER_NAME=���˲�Ʒչ�֣����ԣ�&CUSTOMER_ID=2066239552&CUSTOMER_NAME=Bills%20Family&OFFER_INSTANCE_ID=&IS_SHOW_SHEET_BTN=N&VALID_TYPE=null&IS_BATCH=N&IS_CHILD=false&sequence=0.6128473628479503&REGION_ID=571">�²�Ʒ����(����)</a></TD>
  	<TD>�²�Ʒ����(����)</TD>
  	<TD></TD>
  </TR>
   <TR>
  		 <TD><a href="<%=request.getContextPath()%>/bce/frame/bceCacheSearch.jsp">�����ѯ</a></TD>
  	<TD>�����ѯ</TD>
  	<TD></TD>
  </TR>
  </TABLE>
  ע���ɸ��ݲ�����Ų�ѯ�������: <a href="<%=request.getContextPath()%>/bce/configtool">/bce/configtool</a>
</body>
</html>