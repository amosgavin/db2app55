<%@ page contentType="text/html; charset=GBK" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>_LOGIN_OUT</title>
<script language="JavaScript" >
/**
 * ��ȡ��߼���window����
 */
function getTopWin()
{
  if (window.name == "WebFrameSet")
  {
    return window;
  }
  
  var w = window;
  if (window == window.parent)
  {
    
    if (window.opener)
    {
  w = window.opener;
  try{
    while ( w.opener!=null && (w != w.opener))
    {
      if (w.name == "WebFrameSet")
       {
         return w;
       }
      w = w.opener;
    }
  }catch(e){
    return window;
  }
  
    }
    else
    {
       return window;
    }
  }
  else
  {
     w = window.parent;
     while (w.parent && (w != w.parent))
  {
    if (w.name == "WebFrameSet")
     {
       return w;
     }
    w = w.parent;
  }
  }

  return w;
}


alert("��ǰ�û��ѳ�ʱ���߱�����Աע��������ת����¼ҳ��.�����µ�¼!")
var winObj = getTopWin();

if(winObj!=null)
{
  winObj.location="http://10.25.5.177/portal/";
}
</script>
</head>

<body>
</body>

</html>