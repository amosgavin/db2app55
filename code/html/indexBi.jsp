<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.ai.appframe2.web.BaseServer"%>
<%@ include file="/secframe/common/getMACIP.html"%>
<%@ page import="com.asiainfo.common.DES"%>
<html>
	<head>
		<title>�����ƶ���˾Ӫ������ϵͳ</title>
		<%
			String userIdLogined = (String) request.getParameter("userId");
		if(userIdLogined != null){
			userIdLogined = DES.decrypt(userIdLogined);
		}
			String ailk_autoLogin_userId = (String) request.getParameter("ailk_autoLogin_userId");

			ailk_autoLogin_userId = ailk_autoLogin_userId == null ? "": ailk_autoLogin_userId;
		%>
		<script src="<%=request.getContextPath()%>/jsv2/UserData_v2.js"></script>
		<script language="JavaScript" src="<%=request.getContextPath()%>/jsv2/Globe_v2.jsp"></script>
		<script language="JavaScript"src="<%=request.getContextPath()%>/jsv2/CommUtil.js"></script>
		
<script language="JavaScript" type="text/JavaScript">
var MACAddr;
var IPAddr;
//��֤��½�Ƿ���ȷ
var isVertifyCode = true;//�����Ƿ�����֤��У�������;
//BBOSS�ı�����11
var channel_id = "1";

function UserVerify(account, psw, vertifycode) {
	var xml = null;
	//var   WshShell   =new   ActiveXObject("WScript.Shell"); 
	//var windowsLoginName=WshShell.ExpandEnvironmentStrings("%USERNAME%");
	//var computorName=WshShell.ExpandEnvironmentStrings("%COMPUTERNAME%");
	var XMLSender = new ActiveXObject("Microsoft.XMLHTTP");
	IPAddr = '';
	var url = "<%=request.getContextPath()%>/baseserver?CHANNEL_ID="
			+ channel_id + "&EventID=1&LOGIN_USRNAME=" + account
			+ "&LOGIN_PSWD=" + psw + "&LOGIN_VERFYCODE=" + vertifycode
			+ "&IP_ADDR=" + IPAddr + "&MAC_ADDR=" + MACAddr
			+ "&windowsLoginName=&computorName=";//hxx add

	XMLSender.Open("POST", url, false);
	XMLSender.setRequestHeader("Content-Type", "text/xml; charset=UTF-8");
	XMLSender.send(xml);
	return XMLSender.responseText;
}

/**
 * �û���¼
 * @return
 */
function Login() {
	debugger;
	var blank = "                                      ";
	var acc = new String(document.all.item("UserAccount").value);
	var psw = new String(document.all.item("UserPwd").value);
	var vertifycode = "";
	if (isVertifyCode) {
		vertifycode = new String(document.all.item("UserVertifyCode").value)
	}
	if (blank.indexOf(acc) != -1 || blank.indexOf(psw) != -1) {
		alert("�û��������벻��Ϊ��");
		return;
	}
	if (isVertifyCode && blank.indexOf(vertifycode) != -1) {
		alert("�û�У���벻��Ϊ��");
		return;
	}
	var loginRe = UserVerify(acc, psw, vertifycode);

	//alert("loginRe="+loginRe);
	var xml = new ActiveXObject("Msxml.DOMDocument");
	xml.async = false;
	var bload = xml.loadXML(loginRe);
	//alert(bload);
	var xmlNode = xml.documentElement;
	var ud = createUserDataClass(xmlNode);

	if (ud == null) {
		alert('��½ʧ�ܣ�');
		return;
	}
	//alert(ud.getValueByName("LOGIN_FLAG"));
	if (ud.getValueByName("LOGIN_FLAG") == "Y") { //��¼�ɹ�
		var SUCCESS_MESSAGE = ud.getValueByName("SUCCESS_MESSAGE");
		if (SUCCESS_MESSAGE != null && SUCCESS_MESSAGE != '') {
			alert(SUCCESS_MESSAGE);
		}
		var mySrc = ud.getValueByName("MESSAGE");
		//openWin(mySrc);
		//alert(screen.width+" "+screen.height);
		<%--window.open(ud.getValueByName("MESSAGE"),
						"",
						"menubar=no,status=no,resizable=yes,scrollbars=no,toolbar=no,top=0,left=0,width=1004,height=600");
		//window.opener = null;
		--%>
		window.location.href=ud.getValueByName("MESSAGE");
		window.open('', '_parent', '');

		//window.close();

	} else if (ud.getValueByName("MESSAGE") == "CHANGE_PASS") {
		alert("ϵͳ���õ����룬�ڵ�һ��½���޸�����");
		changePassword();
		return;
	} else {//��¼ʧ��
		alert(ud.getValueByName("MESSAGE"));
		if (isVertifyCode && document.all.item("vertifyCodeImg") != null) {
			document.all.item("UserVertifyCode").value = "";
			// document.all.item("vertifyCodeImg").src="<%=request.getContextPath()%>/vertifycodeservlet";
		}
		var xStr = ud.getValueByName("MESSAGE");
		//alert(xStr);
		if (xStr == "���벻��ȷ!") {
			document.all.item("UserPwd").value = "";
			document.all.item("UserPwd").focus();
			document.all.item("UserPwd").focus();
		} else {
			document.all.item("UserAccount").value = "";
			document.all.item("UserPwd").value = "";
			document.all.item("UserAccount").focus();
			document.all.item("UserAccount").focus();
		}
	}
}
</script>
	</head>
	<body>
		<form action="#" target="_self" id="forcsp" name="forcsp"
			method="post">
			<input type="hidden" id="user_code" name="user_code" />
			<input id="user_password" type="hidden" name="user_password" />
			<input type="hidden" id="login_user" name="login_user" />
			<input id="login_password" type="hidden" name="login_password" />
		</form>

		<div id="center" style="display: none">
			<div class="main">
				<div class="word">
					�û�����
					<br>
					���룺
					<br>
					��֤�룺
				</div>
				<input type="text" id="UserAccount"
					onKeyPress="JumpByEnter(UserPwd)" value="<%=userIdLogined%>" />
				<input type="password" id="UserPwd" onKeyPress="IsEnterKeyPress()"
					value="111" />
				<input type="text" id="UserVertifyCode"
					onKeyPress="IsEnterKeyPress()" value="123" />
				<a href="#" id="Login" onClick="Login()" name="Submit"
					class="button"><img src="images/icon_05.gif" align="absmiddle"
						border="0">&nbsp;�� ¼</a>
				<a href="#" id="Reset" onClick="Reset()" name="Submit2"
					class="button"><img src="images/icon_06.gif" align="absmiddle"
						border="0">&nbsp;�� ��</a>
				<div id="chpsw">
					<img src="images/chpsw.gif" align="absmiddle">
					&nbsp;
					<a href="#" onClick="changePassword()" title="�޸ĵ�¼����">�޸�����</a>
				</div>
				<div id="favorite">
					<img src="images/icon_02.gif" align="absmiddle">
					&nbsp;
					<a
						href="javascript:window.external.addFavorite(location.href,'Ӫ���ʷѹ���ƽ̨');"
						title="��ӵ��ղؼ�">�����ղؼ�</a>
				</div>
				<div class="copyright">
					���Ŵ����Ƽ����й����ṩ����֧��
				</div>
			</div>
		</div>

	</body>
<script language="JavaScript">
var userIdLoginedObj = document.getElementById("UserAccount");
var userIdLogined;
if (userIdLoginedObj) {
	userIdLogined = userIdLoginedObj.value;
}
if (userIdLogined && userIdLogined != null && userIdLogined != 'null') {
	Login();
}

</script>
</html>
