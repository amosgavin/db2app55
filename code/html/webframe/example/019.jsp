<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/webframe/common/commonhead.jsp"%>
<%@ taglib uri="/WEB-INF/crossgrid.tld" prefix="crossgrid" %>
<html>
<head>
<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/PopMenu_v2.js"></script>
<title>ģ��019</title>
<!--DBGridʾ��ģ��ҳ��˵�� -->
<!--
1����ģ��������DBGrid���ǰ̨����jspҳ�棻
2����ģ����ѭ�������Ϊ�ٷֱȣ��߶���������Ȼ�ſ�ԭ������Ӧ���ֱַ��������
3����ѯ����ѯ����ֱ���ai:contractframe���÷ָ
4��ai:contractframeʹ��ע�⣺���������100%���߶�������������Ȼ�ſ���allowcontract���ԣ��Ƿ��������� Ĭ��true��ֵ��true/false����frameclosed���ԣ���ʼ��ʱ���������Ƿ��ڹر�״̬��Ĭ��false��ֵ��true/false��
5��ͬһҳ��2�鼰����ai:tableʹ��ע�⣺���������100%���߶�������120���кϼ������20=140��������������6����pagesize="5"�������ж����������٣�
6����ťλ����ע�⣺��ѯ��ťʹ��css��class="td_button"����������ťʹ��css��class="area_button"��;���Ŷ����ť����ʱ���м����2��&nbsp;&nbsp;��
7��ʹ���Ҽ��˵�������jsv2Ŀ¼�µ�PopMenu_v2.js��
 -->
 <script language="JavaScript">
var tmpGroupModel = new AIPopMenuModel();
  tmpGroupModel.addPopMenuItem("1","������",null,"rootRefresh");
  tmpGroupModel.addPopMenuItem("2","����",1,"rootRefresh");
  tmpGroupModel.addPopMenuItem("3","�޸�",1,"rootRefresh");
  tmpGroupModel.addPopMenuItem("4","ɾ��",1,"rootRefresh");
  tmpGroupModel.addPopMenuItem("1","ˢ�±��",null,"rootRefresh");
  tmpGroupModel.addPopMenuItem("1","ˢ��ҳ��",null,"rootRefresh");
  var popMenu = new AIPopMenu(tmpGroupModel);
 
  document.onclick=hide;
  function show()
  {
  popMenu.showPopMenu();
 
  }
  function hide()
  {
  popMenu.hidePopMenu();
  }

</script>
</head>

<body>
<ai:contractframe id="�ɱ༭DBGridʾ��" contenttype="table" title="�ɱ༭DBGridʾ��" width="100%" allowcontract="ture" frameclosed="false">
  <ai:contractitem/>
 <ai:table setname="com.ai.frame.attach.SETSysAttach" tableid="spselect"  
        needrefresh="true" editable="true" initial="true" multiselect="true"
          pagesize="5" width="100%" height="120" ondblink="">
       		<ai:col fieldname="BUSI_TYPE_CODE" width="30%" editable="true" />
       		<ai:col fieldname="REMARKS" width="40%" editable="true" />
       		<ai:col fieldname="NAME" width="30%" editable="true" />
           </ai:table>
</ai:contractframe>

<ai:contractframe id="�ϼ���DBGrid/���Ҽ��˵�ʾ��" contenttype="table" title="�ϼ���DBGrid/���Ҽ��˵�ʾ��" width="100%" allowcontract="ture" frameclosed="false">
  <ai:contractitem/>
 <ai:table setname="com.ai.frame.attach.SETSysAttach" tableid="spselect2"  
        needrefresh="true" editable="ture" initial="true" multiselect="true"
          pagesize="5" width="100%" height="140" ondblink="" oncontextmenu="show"
           onresize="true">
        <ai:col fieldname="ATTACH_ID" width="10%"/>
        <ai:col fieldname="BUSI_SHEET_ID" width="15%" total="true" />
        <ai:col fieldname="BUSI_TYPE_CODE" width="15%" />
        <ai:col fieldname="REMARKS" width="30%" total="true" />
        <ai:col fieldname="NAME" width="30%" />
           </ai:table>
</ai:contractframe>

<ai:contractframe id="��Ʊʹ��ͳ���б�" contenttype="table" title="��Ʊʹ��ͳ���б�" width="100%" allowcontract="true" frameclosed="false">
  <ai:contractitem/>
	<crossgrid:crossgrid id="invoceStockDetail" showtype="crossgrid" onrowselect="" oncolselect="" configname="CrossGridDataDefine"
				  datamodel="com.ai.appframe2.analyse.DemoCrossGridDatamodelImpl"
				  width="100%" height="240"  isshowselect="false">
				  <crossgrid:crossgridpivot name="bmh" area="COL" selectvalue=" " issubtotal="true"   ordertype="desc"/>
				  <crossgrid:crossgridpivot name="year" area="ROW" selectvalue=" " issubtotal="true"    ordertype="asc"/>
				  <crossgrid:crossgridpivot name="month" area="ROW" selectvalue=" " issubtotal="true"    ordertype="asc"/>
				  <crossgrid:crossgridpivot name="spbh" area="COL" selectvalue=" " issubtotal="true"    />
				  <crossgrid:crossgridpivot name="meas" area="COL" selectvalue=" " issubtotal="true"   />
	</crossgrid:crossgrid>
</ai:contractframe>

<div class="area_button">
  <ai:button text="������ť" id="query1" onclick="" />&nbsp;&nbsp;
  <ai:button text="�����ð�ť" id="query3" onclick="" enable="false" />
</div>

</body>
</html>
