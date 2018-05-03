/*jadclipse*/// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.

package com.ai.bce.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.AIConfigManager;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.complex.util.RuntimeServerUtil;
import com.ai.appframe2.privilege.LoginException;
import com.ai.appframe2.privilege.UserInfoInterface;
import com.ai.appframe2.privilege.UserManagerFactory;
import com.ai.appframe2.util.locale.AppframeLocaleFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.WebEvent;

// Referenced classes of package com.ai.appframe2.web:
//            WebEvent, HttpUtil, CustomProperty

public class Login extends HttpServlet
{

    public Login()
    {
        objWebEvent = new ThreadLocal();
    }

//    public static String getMainHTML()
//    {
//        try
//        {
//            return UserManagerFactory.getUserManager().getMainWebPageUrl();
//        }
//        catch(Exception ex)
//        {
//            log.error(AppframeLocaleFactory.getResource("com.ai.appframe2.web.BaseServer.cannot_get_mainpage"), ex);
//        }
//        return "";
//    }

//    public static String getLogoutHTML()
//    {
//        return (new StringBuilder()).append(SessionManager.getContextName()).append(SessionManager.getLoginOutWebPageUrl()).toString();
//    }
//
//    public static String getLoginHTML()
//    {
//        return (new StringBuilder()).append(SessionManager.getContextName()).append(SessionManager.getLoginInWebPageUrl()).toString();
//    }

//    public String getBaseURL(HttpServletRequest aRequest)
//    {
//        StringBuilder sRe = new StringBuilder("");
//        sRe.append("http://").append(aRequest.getServerName()).append(":").append(aRequest.getServerPort()).append(aRequest.getContextPath());
//        return sRe.toString();
//    }

    public void init(ServletConfig config)
        throws ServletException
    {
        super.init(config);
        aRealPath = config.getServletContext().getRealPath("/");
        USER_CHECK_FLAG = getUserCheckFlagFromConfig();
        try
        {
            String s = AIConfigManager.getConfigItem("CHANNEL_ID");
            if(s != null && s.length() > 0)
                CHANNEL_ID = Long.parseLong(s);
            else
                CHANNEL_ID = -1L;
        }
        catch(Exception ex)
        {
            log.error(ex.getMessage(), ex);
            CHANNEL_ID = -1L;
        }
    }

    public String getRealPath()
    {
        return aRealPath;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        SessionManager.setContextName(request.getContextPath());
        SessionManager.setRequest(request);
        try
        {
            objWebEvent.set(new WebEvent(request));
            String webEventID = getWebEvent().getEventID();
            if("1".equals(webEventID))
                processLogin(request, response);
            else
            if("2".equals(webEventID))
                processLogout(request, response);
            else
            if("3".equals(webEventID))
                processLoginNoCertify(request, response);
            else
            if("4".equals(webEventID))
                processLoginSession(request, response);
        }
        catch(Throwable e)
        {
            e.printStackTrace();
        }
    }

    public static void processLogin(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        String logUsr = String.valueOf(HttpUtil.getParameter(request, "LOGIN_USRNAME"));
        String logPass = String.valueOf(HttpUtil.getParameter(request, "LOGIN_PSWD"));
        String verifyCode = String.valueOf(HttpUtil.getParameter(request, "LOGIN_VERFYCODE"));
        long channelId = CHANNEL_ID;
        String s = HttpUtil.getParameter(request, "CHANNEL_ID");
        if(!StringUtils.isBlank(s))
            channelId = Long.parseLong(s);
        CustomProperty cp = CustomProperty.getInstance();
        cp.clear();
        try
        {
            String session_vertify_code = (String)request.getSession().getAttribute("VERTIFY_CODE_ATTR");
            if(session_vertify_code != null && !verifyCode.equals(session_vertify_code))
                throw new LoginException(15);
            int curTime = UserManagerFactory.getUserManager().getFaultTime(request.getSession().getId());
            UserInfoInterface user = UserManagerFactory.getUserManager().loginIn(logUsr, logPass, channelId, curTime, request);
            if(user == null)
                throw new LoginException(2);
            UserManagerFactory.getUserManager().setLogined(user);
            UserManagerFactory.getUserManager().clearFaultTime(request.getSession().getId());
            user.setIP(getIpAddr(request));
            user.setSessionID(request.getSession().getId());
            request.getSession().setAttribute("USERINFO_ATTR", user.getSerialID());
            try
            {
                Cookie c = new Cookie("USERINFO_ATTR", user.getSerialID());
                c.setMaxAge(-1);
                response.addCookie(c);
            }
            catch(Exception e)
            {
                log.error(AppframeLocaleFactory.getResource("com.ai.appframe2.web.BaseServer.set_cookie_error"), e);
            }
            if(!StringUtils.isBlank(RuntimeServerUtil.getServerName()))
                try
                {
                    Cookie c = new Cookie("_BelongedSrvId", RuntimeServerUtil.getServerName());
                    c.setMaxAge(-1);
                    response.addCookie(c);
                }
                catch(Exception e)
                {
                    log.error(AppframeLocaleFactory.getResource("com.ai.appframe2.web.BaseServer.set_cookie_error"), e);
                }
            user.setDomainId(channelId);
            SessionManager.setUser(user);
            String login_success_msg = (String)request.getAttribute("MESSAGE");
            if(login_success_msg != null)
                cp.set("SUCCESS_MESSAGE", login_success_msg);
            cp.set("LOGIN_FLAG", "Y");
            cp.set("MESSAGE", request.getContextPath()+"/bce/configtool/index.jsp");
        }
        catch(LoginException ex)
        {
            UserManagerFactory.getUserManager().addFaultTime(request.getSession().getId());
            cp.set("LOGIN_FLAG", "N");
            cp.set("MESSAGE", ex.getErrorInfo());
        }
        catch(AIException aiex)
        {
            UserManagerFactory.getUserManager().addFaultTime(request.getSession().getId());
            cp.set("LOGIN_FLAG", "N");
            cp.set("MESSAGE", aiex.getMessage());
        }
        catch(Exception ex1)
        {
            log.error(AppframeLocaleFactory.getResource("com.ai.appframe2.web.BaseServer.login_error"), ex1);
            cp.set("LOGIN_FLAG", "N");
            cp.set("MESSAGE", LoginException.getUserLoginChnInfo(6));
        }
        finally
        {
            response.setContentType(HttpUtil.getXmlContentType());
            response.getWriter().write(HttpUtil.getXmlDeclare());
            response.getWriter().write(cp.toXmlString());
        }
    }

    public void processLogout(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        UserInfoInterface user = getCurUser(request);
        if(user != null)
            try
            {
                UserManagerFactory.getUserManager().loginOut(user);
                clearSession(request, response);
            }
            catch(LoginException ex)
            {
                response.getWriter().write("<LOGIN_OUT>LOGINOUT</LOGIN_OUT>");
            }
        else
            response.getWriter().write("<LOGIN_OUT>LOGINOUT</LOGIN_OUT>");
        request.getSession().invalidate();
    }

    public WebEvent getWebEvent()
    {
        try
        {
            return (WebEvent)objWebEvent.get();
        }
        catch(Exception ex)
        {
            return null;
        }
    }

    private void clearSession(HttpServletRequest nRequest, HttpServletResponse nResponse)
        throws Exception
    {
        nRequest.getSession().removeAttribute("USERINFO_ATTR");
        nResponse.getWriter().write("<LOGIN_OUT>LOGINOUT</LOGIN_OUT>");
    }

    public static boolean getUserCheckFlagFromConfig()
    {
        String flag = "Y";
        try
        {
            flag = AIConfigManager.getConfigItem("IS_LOGIN_CHECK_FLAG");
            if(StringUtils.isNotEmpty(flag) && flag.equalsIgnoreCase("N"))
                return false;
        }
        catch(Exception ex)
        {
            return true;
        }
        return true;
    }

    private void processLoginNoCertify(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        String logUsr = HttpUtil.getParameter(request, "LOGIN_USRNAME");
        String logPass = HttpUtil.getParameter(request, "LOGIN_PSWD");
        String channelId = HttpUtil.getParameter(request, "CHANNEL_ID");
        try
        {
            if(StringUtils.isBlank(channelId))
                channelId = "-1";
            UserInfoInterface user = UserManagerFactory.getUserManager().loginInNoCertify(logUsr, logPass, (new Long(channelId)).longValue(), 1, request);
            if(user == null)
                throw new LoginException(2);
            UserManagerFactory.getUserManager().setLogined(user);
            UserManagerFactory.getUserManager().clearFaultTime(request.getSession().getId());
            user.setIP(getIpAddr(request));
            user.setSessionID(request.getSession().getId());
            request.getSession().setAttribute("USERINFO_ATTR", user.getSerialID());
            if(StringUtils.isNotBlank(channelId))
                user.setDomainId(Long.parseLong(channelId));
            SessionManager.setUser(user);
            log.info(AppframeLocaleFactory.getResource("com.ai.appframe2.web.BaseServer.login_certify_error"));
        }
        catch(Exception ex1)
        {
            log.error(AppframeLocaleFactory.getResource("com.ai.appframe2.web.BaseServer.login_error"), ex1);
        }
    }

    public void processLoginSession(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        response.setContentType(HttpUtil.getHtmlContentType());
        response.getWriter().write(request.getSession().getId());
    }

    public static UserInfoInterface getCurUser(HttpServletRequest request)
        throws Exception
    {
        UserInfoInterface curUser = null;
        try
        {
            String userSerialID = null;
            HttpSession session = request.getSession(false);
            if(session != null)
                userSerialID = (String)session.getAttribute("USERINFO_ATTR");
            if(StringUtils.isBlank(userSerialID))
                try
                {
                    Cookie cookies[] = request.getCookies();
                    if(cookies.length == 0)
                    {
                        log.info(AppframeLocaleFactory.getResource("com.ai.appframe2.web.BaseServer.support_error"));
                    } else
                    {
                        for(int i = 0; i < cookies.length; i++)
                            if(cookies[i].getName().equals("USERINFO_ATTR"))
                                userSerialID = cookies[i].getValue();

                    }
                }
                catch(Exception e)
                {
                    log.error(AppframeLocaleFactory.getResource("com.ai.appframe2.web.BaseServer.get_cookie_error"), e);
                }
            if(StringUtils.isNotBlank(userSerialID) && UserManagerFactory.getUserManager().getLogedUsersBySerialID(userSerialID) != null)
                curUser = UserManagerFactory.getUserManager().getLogedUsersBySerialID(userSerialID);
        }
        catch(Exception e)
        {
            log.error(e.getMessage(), e);
        }
        return curUser;
    }

    public static void processLogin(HttpServletRequest request, UserInfoInterface user)
        throws Exception
    {
        UserManagerFactory.getUserManager().setLogined(user);
        user.setIP(getIpAddr(request));
        user.setSessionID(request.getSession().getId());
        request.getSession().setAttribute("USERINFO_ATTR", user.getSerialID());
        SessionManager.setUser(user);
    }

    public static String getIpAddr(HttpServletRequest request)
    {
        String ip = null;
        Enumeration enu = request.getHeaderNames();
        do
        {
            if(!enu.hasMoreElements())
                break;
            String name = (String)enu.nextElement();
            if(name.equalsIgnoreCase("X-Forwarded-For"))
                ip = request.getHeader(name);
            else
            if(name.equalsIgnoreCase("Proxy-Client-IP"))
                ip = request.getHeader(name);
            else
            if(name.equalsIgnoreCase("WL-Proxy-Client-IP"))
                ip = request.getHeader(name);
        } while(ip == null || ip.length() == 0);
        if(ip == null || ip.length() == 0)
            ip = request.getRemoteAddr();
        return ip;
    }

    private static final long serialVersionUID = 1L;
    private static transient Log log = LogFactory.getLog(Login.class);
    public static final String WBS_USER_ATTR = "USERINFO_ATTR";
    public static final String WBS_VERTIFY_CODE_ATTR = "VERTIFY_CODE_ATTR";
    public static final String WBS_GET_SYSDATE = "GETSYSDATE";
    public static final String WBS_LOGINOUT_FLAG = "<LOGIN_OUT>LOGINOUT</LOGIN_OUT>";
    public static final String WBS_LOGIN_FLAG = "LOGIN_FLAG";
    public static final String WBS_LOGIN_MESSAGE = "MESSAGE";
    public static final String WBS_LOGIN_EVENT = "1";
    public static final String WBS_LOGINOUT_EVENT = "2";
    public static final String WBS_LOGIN_NOCERTIFY_EVENT = "3";
    public static final String WBS_LOGIN_SESSION_ID_EVENT = "4";
    public static boolean USER_CHECK_FLAG = false;
    public static long CHANNEL_ID = -1L;
    protected ThreadLocal objWebEvent;
    private static String aRealPath = null;

}


/*
	DECOMPILATION REPORT

	Decompiled from: D:\workspace\bce\lib\appframe\appframe.jar
	Total time: 234 ms
	Jad reported messages/errors:
Overlapped try statements detected. Not all exception handlers will be resolved in the method processLogin
Couldn't resolve all exception handlers in method processLogin
Couldn't resolve all exception handlers in method getUserCheckFlagFromConfig
	Exit status: 0
	Caught exceptions:
*/