package com.asiainfo.sale.util;

import java.util.Hashtable;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ByteArrayInputStream;


/**
 * <p>FileName: StringUtil.java</p>
 * <p/>
 * <p>Title: �ַ�����������</p>
 * <p/>
 * <p>Description: ���ڶ��ַ��������滻��ת���Ȳ���</p>
 * <p/>
 * <p>CreateDate: 2009-8-19</p>
 *
 * @author <a href="mailto:njxyf007@hotmail.com">������</a>
 * @version 1.00
 */
public class StringUtil extends org.apache.commons.lang.StringUtils {

    private static final char QUOTE_ENCODE[] = "&quot;".toCharArray();
    private static final char AMP_ENCODE[] = "&amp;".toCharArray();
    private static final char LT_ENCODE[] = "&lt;".toCharArray();
    private static final char GT_ENCODE[] = "&gt;".toCharArray();
    private static final char APOS_ENCODE[] = "&apos;".toCharArray();
    private static final char BR_TAG[] = "<BR>".toCharArray();
    //private static Object initLock = new Object();

    /**
     * �ַ����滻
     *
     * @param strSrc String		Դ�ַ���
     * @param strOld String		���滻���ַ���
     * @param strNew String		���滻���ַ���
     * @return String
     */
    public static final String replace(
            String strSrc,
            String strOld,
            String strNew) {

        String szReturn = "";
        String szTemp = null;
        int iIndex = -1;
        boolean bFirst = true;

        if (strSrc == null) {
            return null;
        }
        while ((iIndex = strSrc.indexOf(strOld)) != -1) {
            szTemp = strSrc.substring(0, iIndex);
            if (bFirst) {
                szReturn = "";
                bFirst = false;
            }
            szReturn += szTemp + strNew;
            strSrc = strSrc.substring(iIndex + strOld.length());
        }
        szReturn += strSrc;
        return szReturn;
    }


    /**
     * ���ַ��е�html�������"<",">"���ɶ�Ӧ��ת���
     *
     * @param s String	�ַ���
     * @return String
     */
    public static final String escapeHTMLTags(String s) {
        if (s == null)
            return null;
        int i = 0;
        int j = 0;
        char ac[] = s.toCharArray();
        int k = ac.length;
        StringBuffer stringbuffer = new StringBuffer((int) ((double) k * 1.3D));
        for (; i < k; i++) {
            char c = ac[i];
            if (c > '>')
                continue;
            if (c == '<') {
                if (i > j)
                    stringbuffer.append(ac, j, i - j);
                j = i + 1;
                stringbuffer.append(LT_ENCODE);
                continue;
            }
            if (c != '>')
                continue;
            if (i > j)
                stringbuffer.append(ac, j, i - j);
            j = i + 1;
            stringbuffer.append(GT_ENCODE);
        }

        if (j == 0)
            return s;
        if (i > j)
            stringbuffer.append(ac, j, i - j);
        return stringbuffer.toString();
    }

    /**
     * ���ַ�����"\n","\r\n"����hmtl��ǩ
     *
     * @param s String
     * @return String
     */
    public static String convertNewlines(String s) {
        char ac[] = s.toCharArray();
        int i = 0;
        int j = ac.length;
        StringBuffer stringbuffer = new StringBuffer(j);
        for (int k = 0; k < j; k++) {
            if (ac[k] == '\n') {
                stringbuffer.append(ac, i, k - i).append(BR_TAG);
                i = k + 1;
                continue;
            } else if (ac[k] == '\r' && k < j - 1 && ac[k + 1] == '\n') {
                stringbuffer.append(ac, i, k - i).append(BR_TAG);
                i = ++k + 1;
            }
        }

        stringbuffer.append(ac, i, j - i);
        return stringbuffer.toString();
    }

    /**
     * ��Щ��Ӧ��ת����sql�ַ���
     *
     * @param s  String		Ҫת�����ַ���
     * @param s1 String		like������
     * @return String
     */
    public static String getTranslateStr(String s, String s1) {
        String s2 = "";
        if (s.indexOf(" ") > 0) {
            boolean flag = true;
            String as[] = s.split(" ");
            for (int i = 0; i < as.length; i++) {
                if (as[i].equals("AND") || as[i].equals("&")) {
                    s2 = s2 + " and ";
                    flag = true;
                    continue;
                }
                if (as[i].equals("OR") || as[i].equals("|")) {
                    s2 = s2 + " or ";
                    flag = true;
                    continue;
                }
                if (as[i].equals("NOT") || as[i].equals("!") || as[i].equals("��")) {
                    s2 = s2 + " not ";
                    flag = true;
                    continue;
                }
                if (as[i].equals("(") || as[i].equals("��") || as[i].equals("��")) {
                    s2 = s2 + " ( ";
                    flag = true;
                    continue;
                }
                if (as[i].equals(")") || as[i].equals("��") || as[i].equals("��")) {
                    s2 = s2 + " ) ";
                    flag = true;
                    continue;
                }
                if ("".equals(as[i]))
                    continue;
                if (!flag)
                    s2 = s2 + " and ";
                if (as[i].indexOf("%") > 0)
                    s2 = s2 + " " + s1 + " like '" + as[i].replaceAll("'", "''") + "' ";
                else
                    s2 = s2 + " " + s1 + " like '%" + as[i].replaceAll("'", "''") + "%' ";
                flag = false;
            }

            return s2;
        }
        if (s.indexOf("%") > 0)
            s2 = s2 + " " + s1 + " like '" + s.replaceAll("'", "''") + "' ";
        else
            s2 = s2 + " " + s1 + " like '%" + s.replaceAll("'", "''") + "%' ";
        return s2;
    }

    /**
     * ���ַ�������html����
     *
     * @param s String
     * @return String
     */
    public static String toHtmlInput(String s) {
        if (s == null) {
            return null;
        } else {
            String s1 = new String(s);
            s1 = replace(s1, "&", "&amp;");
            s1 = replace(s1, "<", "&lt;");
            s1 = replace(s1, ">", "&gt;");
            s1 = replace(s1, "\"", "&quot;");
            s1 = replace(s1, "'", "''");
            return s1;
        }
    }

    /**
     * ���ַ���ת����html�ַ���
     *
     * @param s String
     * @return String
     */
    public static String toHtml(String s) {
        if (s == null) {
            return null;
        } else {
            String s1 = new String(s);
            s1 = toHtmlInput(s1);
            s1 = replace(s1, "\r\n", "\n");
            s1 = replace(s1, "\n", "<br>\n");
            s1 = replace(s1, "\t", "    ");
            s1 = replace(s1, "  ", " &nbsp;");
            return s1;
        }
    }

    /**
     * ��string ת��Ϊint
     *
     * @param str Ҫת�����ַ���
     * @return int
     */
    private static int StringToInt(String str) {
        if (str == null) {
            return 0;
        }
        return (Integer.valueOf(str.trim())).intValue();
    }

    /**
     * ����Ҫ��ȡ���ַ����еķ�����
     *
     * @param sz_theChar   String	Ҫ��ȡ���ַ���
     * @param sz_Separator String	�ָ���
     * @return int
     *         eg:
     *         ��sz_theChar="1,2,3,4";sz_Separator=",";��ô�ͷ���4
     */
    public static int getCharTolNum(String sz_theChar, String sz_Separator) {
        return sz_theChar.split(sz_Separator).length;
    }

    /**
     * ����Ҫ��ȡ���ַ����еķ�����
     *
     * @param sz_theChar   String	Ҫ��ȡ���ַ���
     * @param sz_Separator String	�ָ���
     * @return String[]
     *         eg:
     *         ��sz_theChar="1,2,3,4";sz_Separator=",";��ô�ͷ���String[]={"1","2","3","4"}
     */
    public static String[] getSepStr(String sz_theChar, String sz_Separator) {
        return sz_theChar.split(sz_Separator);
    }

    /**
     * ����Ҫ��ȡ���ַ����еķ���
     *
     * @param sz_theChar   String	Ҫ��ȡ���ַ���
     * @param sz_Separator String	�ָ���
     * @param i_CharNum    String	Ҫȡ�õ��ַ���λ��
     * @return String
     *         eg:
     *         ��sz_theChar="1,3,2,4";sz_Separator=",";i_CharNum=2;��ô�ͷ���"3"
     */
    public static String getSeparatorChar(String sz_theChar, String sz_Separator, int i_CharNum) {
        String[] str = sz_theChar.split(sz_Separator);
        return str[i_CharNum - 1];
    }

    /**
     * ���·ݵĸ�ʽ������ת����Ӣ�ļ�ƴ
     *
     * @param i_theMonth int		���ָ�ʽ���·�
     * @return String
     */
    public static String convertMonthToChar(int i_theMonth) {
        String sz_theChar = "";
        String charMonth[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        switch (i_theMonth) {
            case 1:
                sz_theChar = charMonth[0];
                break;
            case 2:
                sz_theChar = charMonth[1];
                break;
            case 3:
                sz_theChar = charMonth[2];
                break;
            case 4:
                sz_theChar = charMonth[3];
                break;
            case 5:
                sz_theChar = charMonth[4];
                break;
            case 6:
                sz_theChar = charMonth[5];
                break;
            case 7:
                sz_theChar = charMonth[6];
                break;
            case 8:
                sz_theChar = charMonth[7];
                break;
            case 9:
                sz_theChar = charMonth[8];
                break;
            case 10:
                sz_theChar = charMonth[9];
                break;
            case 11:
                sz_theChar = charMonth[10];
                break;
            case 12:
                sz_theChar = charMonth[11];
                break;
            default:
                break;
        }
        return sz_theChar;
    }

    /**
     * ת���ַ����м�ķָ���(��Ҫ����sql�����in(xx,xx))
     *
     * @param szAllString  String    ��Ҫת�����ַ���       <p>
     * @param iFlag        int       1 ������ 0 ��������    <P>
     * @param szCharFirst  String    ���滻���ַ�           <p>
     * @param szCharSecond String    �滻Ϊ���ַ�           <P>
     * @return String                     �滻�Ժ���ַ���       <P>
     */
    public static String getRecombineStr(String szAllString, int iFlag, String szCharFirst, String szCharSecond) {
        String szReformString = "";
        // String szTempString = "" ;
        int iIndexOf = 0;
        // iFlag==1 varchar , iFlag==0 number
        // szCharFirst ��ʼ�ָ���
        // szCharSecond �����ķָ���
        if (szAllString == null || (szAllString != null && (szAllString.trim()).equals(""))) {
            return "";
        }
        /*if (iFlag=='')
        {
            iFlag = 1;
        }*/
        if (szCharFirst == null || (szCharFirst != null && (szCharFirst.trim()).equals(""))) {
            szCharFirst = ";";
        }
        if (szCharSecond == null || (szCharSecond != null && (szCharSecond.trim()).equals(""))) {
            szCharSecond = ",";
        }
        if (szAllString != null && szAllString.startsWith(";")) {
            szAllString = szAllString.substring(1);
        }
        iIndexOf = szAllString.indexOf(szCharFirst);
        if (iIndexOf == -1) {
            szReformString = szAllString;
            if (iFlag == 1) {
                szReformString = "'" + szReformString + "'";
            }
            return szReformString;
        }
        if (szAllString.endsWith(";") == false) {
            szAllString = szAllString + ";";
        }
        for (int i = 0; ; i++) {
            iIndexOf = szAllString.indexOf(szCharFirst);
            if (iIndexOf == -1) {
                break;
            }
            if (iFlag == 1) {
                szReformString = szReformString + "'" + szAllString.substring(0, iIndexOf) + "'" + "" + szCharSecond + "";
            } else {
                szReformString = szReformString + szAllString.substring(0, iIndexOf) + "" + szCharSecond + "";
            }

            szAllString = szAllString.substring((iIndexOf + 1), szAllString.length());
        }
        if (szReformString != null && szReformString.startsWith(szCharSecond)) {
            szReformString = szReformString.substring(1);
        }
        if (szReformString != null && szReformString.endsWith(szCharSecond)) {
            szReformString = szReformString.substring(0, szReformString.length() - 1);
        }
        //bug("szReformString="+szReformString) ;
        return szReformString;
    }

    /**
     * ����varchar,date(ʵ���ж�Ӧ������String)
     *
     * @param htSource Hashtable	���ݽ����
     * @param szValue  String ��ֵ����
     * @return String
     * @throws Exception
     */
    public static String getHashtableValue(Hashtable htSource, String szValue)
            throws Exception {
        if (htSource == null)
            return "";
        String szGetVal = (String) htSource.get(szValue);
        if (szGetVal == null)
            szGetVal = "";
        else
            szGetVal = szGetVal.trim();
        //new
        return szGetVal;
    }

    /**
     * ����long,int,float,double
     *
     * @param htSource Hashtable	���ݽ����
     * @param szValue  String ��ֵ����
     * @return String
     * @throws Exception
     */
    public static String getNotStrHashtableValue(Hashtable htSource, String szValue)
            throws Exception {
        if (htSource == null)
            return "0";
        String szGetVal = (String) htSource.get(szValue);
        if (szGetVal == null)
            szGetVal = "0";
        else
            szGetVal = szGetVal.trim();
        return szGetVal;
    }

    /**
     * ��ȡһ�����ȵ��ַ���
     *
     * @param str String Դ�ַ���
     * @param len int	 ����
     * @return String
     */
    public static String getSubString(String str, int len) {
        int i = str.length();
        if (i <= len) {
            return str;
        } else {
            return str.substring(0, len) + "...";
        }
    }

    /**
     * ��ȡһ�����ȵ��ַ���
     *
     * @param str String Դ�ַ���
     * @param len int	 ����
     * @return String
     */
    public static String getSubLenString(String str, int len) {
        int i = str.length();
        if (i <= len) {
            return str;
        } else {
            return str.substring(0, len) + "<br>" + getSubLenString(str.substring(len), len);
        }
    }

    /**
     * �滻ORACLE SQL�����õ�String�Ͳ����еĵ����ź�'&'����
     *
     * @param strSrc String		Դ�ַ���
     * @return String
     */
    public static final String formatOraSql(String strSrc) {
        if (strSrc == null) {
            return null;
        }
        if ("".equals(strSrc)) {
            return strSrc;
        }
        strSrc = replace(strSrc, "'", "''");
        //strSrc=replace(strSrc,"&","'||'&'||'");
        return strSrc;
    }

    /**
     * �ж��ַ����Ƿ���Դ�ַ����Ѿ�����
     *
     * @param source Դ�ַ���
     * @param curStr Ҫ�жϵ��ַ���
     * @param sep    �ָ���
     * @return boolean
     */
    public static boolean isInStr(String source, String curStr, String sep) {
        if (isNull(source)) {
            return false;
        } else {
            String[] str = source.split(sep);
            for (int i = 0; i < str.length; i++) {
                if (curStr.equals(str[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * �ж��ַ����Ƿ�Ϊ�ջ�""
     *
     * @param str
     * @return boolean
     */
    public static boolean isNull(String str) {
        if (str == null || str.trim().equals("") || str.toLowerCase().equals("null")) {
            return true;
        } else {
            return false;
        }
    }


    /*
             * ת����Сд
             */
    private String ConvertSumTotal(String sz_Number, int i_Type) {
        String sz_RtnSumTol = "";
        String sz_Temp = "";
        String charSum[] = null;

        if (sz_Number.equals("")) return sz_RtnSumTol;
        if (i_Type == 0) {
            charSum = new String[]{"��", "Ҽ", "��", "��", "��", "��", "½", "��", "��", "��", "ʰ"};
        } else if (i_Type == 1) {
            charSum = new String[]{"��", "һ", "��", "��", "��", "��", "��", "��", "��", "��", "ʮ"};
        } else {
            charSum = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ""};
        }
        for (int i = 0; i < sz_Number.length(); i++) {
            sz_Temp = sz_Number.substring(i, i + 1);
            if (!sz_Temp.equals(".")) {
                sz_RtnSumTol = sz_RtnSumTol + charSum[Integer.parseInt(sz_Temp)];
            } else {
                sz_RtnSumTol = sz_RtnSumTol + ".";
            }
        }
        return sz_RtnSumTol;
    }

    /**
     * ���ַ�������
     */
    public static String NullToBlank(String s) {
        if ((s == null) || "".equals(s) || "null".equals(s)) {
            return "";
        } else {
            return s;
        }
    }

    /**
     * ���ַ�������,���Ϊ�շ���0
     */
    public static String isZero(String s) {
        if ((s == null) || "".equals(s) || "null".equals(s)) {
            return "0";
        } else {
            return s;
        }
    }

    public static String NullBlankToNbsp(String s) {
        if (s == null) {
            return "&nbsp;";
        } else if (s.trim().equals("")) {
            return "&nbsp;";
        } else {
            return s;
        }
    }

    public static String trimNull(float num) {

        if (num == 0.0) {

            return "";
        }
        return String.valueOf(num);
    }

    public static float trimTo(String num) {

        if (num.trim().equals("")) {

            return 0;
        }
        return new Float(num).floatValue();
    }

    public static String NullToBlanPercent(String s) {
        if (s == null) {
            return "";
        } else {
            return s + "%";
        }
    }

    /**
     * ���ŷָ��ַ���
     *
     * @param str  �ַ�������
     * @param sign �ָ�����
     *             ��:str[] = {"����","����","����"}	sign=@
     * @return ����@����@����
     */
    public static String signCompartStr(String[] str, String sign) {
        String signStr = "";
        if (str.length > 0) {
            for (int i = 0; i < str.length; i++) {

                if (!(str[i].trim()).equals("")) {

                    signStr = signStr + str[i] + sign;
                }
            }

            if (signStr.length() > sign.length()) {

                signStr = signStr.substring(0, (signStr.length() - sign.length()));
            }

        }
        return signStr;
    }

    public static void main(String[] args) {
/*
			 String ss="<div style='font-size:9pt;font-family:����,Verdana,Arial;Color:#000000;'><P>\n" +
                     "<IMG src=\"http://10.96.20.250:8888/business/com.asiainfo.boss.ngcs.base.ftp.out.ActionDcmntFtp?action=doDown&amp;TYPE=IMG&amp;DOCUMENT_ID=1000000253\"></P> <P>\n" +
                     "<IMG height=18 src=\"http://10.96.20.250:8888/theme/classicalblue/images/ngcs/startmenu/icons2/pic_411.png\" width=18>\n" +
                     "<A href=\"http://10.96.20.250:8888/business/com.asiainfo.boss.ngcs.base.ftp.out.ActionDcmntFtp?action=doDown&amp;TYPE=OTHER&amp;DOCUMENT_ID=1000000254\">3���⹵ͨ��ʵ��������ܱ�11.13.xls</A></P> <P>\n" +
                     "<IMG height=18 src=\"http://10.96.20.250:8888/theme/classicalblue/images/ngcs/startmenu/icons2/pic_427.png\" width=18>\n" +
                     "<A href=\"http://10.96.20.250:8888/business/com.asiainfo.boss.ngcs.base.ftp.out.ActionDcmntFtp?action=doDown&amp;TYPE=OTHER&amp;DOCUMENT_ID=1000000255\">���б���.txt</A></P></div>";
			 String sign = "com.asiainfo.boss.ngcs.base.ftp.out.ActionDcmntFtp?action=doDown";
             Integer[] ret = indexsOf(ss,sign);
             for(int i=0;i<ret.length;i++){
			    System.out.println(ss.substring(ret[i].intValue(),ret[i].intValue()+107));
             }
*/
        try {
            String[] ss = StringUtil.filterParentCode("000,000104,000108 ,000104001,000107002,000107005,000107008,000107011,000108001,000104002 ,000107001 ,000107003 ,000107004 ,000107006 ,000107007 ,000107009 ,000107010 ,000107012 ,000104000001,000104000004,000104000007,000104000010,000104000014,000104000019,000104000022,000104000041,000104001003,000104001007,000104001010,000104001013,000104001016,000104001019,000104002001,000104002005,000104002007,000104002009,000104002011,000104002015,000104000003 ,000104000005 ,000104000006 ,000104000008 ,000104000009 ,000104000012 ,000104000013 ,000104000015 ,000104000018 ,000104000020 ,000104000021 ,000104000023 ,000104000024 ,000104000042 ,000104000043 ,000104001001 ,000104001002 ,000104001005 ,000104001006 ,000104001008 ,000104001009 ,000104001011 ,000104001012 ,000104001014 ,000104001015 ,000104001017 ,000104001018 ,000104001050 ,000104002002 ,000104002003 ,000104002006 ,000104002008 ,000104002010 ,000104002012 ,000104002013 ,000104002014 ,000104002003001,000104002006002,000104002006005,000104002007003,000104002007006,000104002007009,000104002008002,000104002009003,000104002010001,000104002010004,000104002011003,000104002012001,000104002012004,000104002013002,000104002013005,000104002014001,000104002014004,000104002014007,000104002014010,000104002014013,000104002014016,000104002014019,000104002015003,000104002015006,000104002015009,000104002015012,000104002003002 ,000104002003003 ,000104002006001 ,000104002006003 ,000104002006004 ,000104002006006 ,000104002006007 ,000104002007001 ,000104002007002 ,000104002007004 ,000104002007005 ,000104002007007 ,000104002007008 ,000104002008001 ,000104002008003 ,000104002008004 ,000104002009001 ,000104002009002 ,000104002009004 ,000104002010002 ,000104002010003 ,000104002010005 ,000104002010006 ,000104002011001 ,000104002011002 ,000104002011004 ,000104002012002 ,000104002012003 ,000104002013001 ,000104002013003 ,000104002013004 ,000104002013006 ,000104002014002 ,000104002014003 ,000104002014005 ,000104002014006 ,000104002014008 ,000104002014009 ,000104002014011 ,000104002014012 ,000104002014014 ,000104002014015 ,000104002014017 ,000104002014018 ,000104002014020 ,000104002014021 ,000104002015001 ,000104002015002 ,000104002015004 ,000104002015005 ,000104002015007 ,000104002015008 ,000104002015010 ,000104002015011");
            for (String s : ss) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * ���ַ��������ضϵ��ַ�����ʹ��ﵽ�̶��ĳ���
     *
     * @param srcStr
     * @param num
     * @param ch
     * @return
     */
    public static String lpad(String srcStr, int num, char ch) {
        String destStr = srcStr;
        if (srcStr.length() > num) {
            destStr = srcStr.substring(srcStr.length() - num);
        } else if (srcStr.length() < num) {
            StringBuffer strBuf = new StringBuffer(16);
            for (int i = 0; i < num - srcStr.length(); i++) {
                strBuf.append(ch);
            }
            destStr = strBuf.toString() + srcStr;
        }
        return destStr;
    }


    /**
     * Code shared by String and StringBuffer to do searches. The
     * source is the character array being searched, and the target
     * is the string being searched for.
     */
    public static Integer[] indexsOf(String s_source, String s_target) {

        char[] source = s_source.toCharArray();
        int sourceOffset = 0;
        int sourceCount = source.length;
        int fromIndex = 0;
        char[] target = s_target.toCharArray();
        int targetCount = target.length;
        int targetOffset = 0;


        ArrayList ret = new ArrayList();
        if (fromIndex >= sourceCount) {
            return null;
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return null;
        }

        char first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first) ;
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j] ==
                        target[k]; j++, k++)
                    ;

                if (j == end) {
                    /* Found whole string. */
                    ret.add(new Integer(i - sourceOffset));
                }
            }
        }
        if (ret.size() > 0) {
            return (Integer[]) ret.toArray(new Integer[0]);
        } else {
            return null;
        }
    }


    public static boolean isInStringArrayExist(String[] slist, String sk) throws Exception {
        if (null != slist && null != sk) {
            for (int i = 0; i < slist.length; i++) {
                if (slist[i].trim().equals(sk.trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isNotInStringArray(String[] s, String value) {
        for (int i = 0; i < s.length; i++) {
            if (value.equalsIgnoreCase(s[i])) return false;
        }
        return true;
    }

    /**
     * ��"1,3,45,123..."��ʽ���ַ���ת��Ϊlong����,�м���ֵķǷ��ַ���������
     * �������strΪnull����""�������س���Ϊ0��long����
     *
     * @param str
     * @param splitstr
     * @return
     */
    public static long[] split2longArray(String str, String splitstr) {
        if (isEmpty(str)) {
            return new long[0];
        }
        String[] items = split(str, splitstr);
        List l = new ArrayList();
        for (int i = 0; i < items.length; i++) {
            if (isNotEmpty(str)) {
                l.add(items[i]);
            }
        }
        long[] result = new long[l.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = Long.parseLong((String) l.get(i));
        }
        return result;
    }

    public static String replaceSpecialStr(String srcStr) {
        String replacedStr = srcStr;
        replacedStr = replaceChars(replacedStr, "<", " ");
        replacedStr = replaceChars(replacedStr, ">", " ");
        replacedStr = replaceChars(replacedStr, "&", " ");
        replacedStr = replaceChars(replacedStr, "'", " ");
        replacedStr = replaceChars(replacedStr, "'\"", " ");
        replacedStr = replaceChars(replacedStr, "'\\", " ");
        replacedStr = replaceChars(replacedStr, "'\n", " ");
        return replacedStr;
    }


    public static String filterExpireAttrValue(String attrValue) throws Exception {
        if (attrValue == null)
            return null;
        Timestamp sysdate = null;
        String[] itemLines = StringUtil.splitByWholeSeparator(attrValue, ";");
        StringBuffer attrSB = new StringBuffer();
        for (int i = 0; i < itemLines.length; i++) {
            String[] items = StringUtil.splitByWholeSeparator(itemLines[i], "|");
            if (items.length >= 4) {
                String replaceStr = itemLines[i];
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Timestamp endDate = new Timestamp(format.parse(items[2]).getTime());
                if (endDate.getTime() >= sysdate.getTime()) {
                    attrSB.append(itemLines[i]).append(";");
                }
            } else {
                if (!"".equals(itemLines[i]))
                    attrSB.append(itemLines[i]).append(";");
            }
        }
        String filteredStr = attrSB.toString();
        if (!"".equals(filteredStr) && filteredStr.endsWith(";"))
            filteredStr = filteredStr.substring(0, filteredStr.length() - 1);
        return filteredStr;
    }


    public static String iso2gbk(String str) {
        if (isBlank(str)) {
            return str;
        }
        try {
            String reStr = new String(str.trim().getBytes("ISO-8859-1"), "GB2312");
            return reStr.replaceAll("@~", "\\\n");
        } catch (Exception e) {
            //do nothing
        }
        return str;
    }

    public static String[] getSplitByDou(String s) {
        s = s.trim().replaceAll("��", ",");
        String[] res = s.split(",");
        if (null != res) {
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i].trim();
            }
        }
        return res;
    }

    /**
     * ת��@~
     *
     * @param
     * @return
     * @throws Exception
     * @throws RemoteException
     * @author zhanggr
     */
    public static String transferText(String text) throws Exception, RemoteException {
        if (text != null) {

            return text.replaceAll("@~", "\r\n");
        }
        return text;
    }

    public static String[] filterParentCode(String orgs) {
        String[] temp = orgs.split(",");
        return temp;

/*
        if(null != temp && temp.length>0){
            ArrayList<String> sortList = new ArrayList();
            for(String s:temp){
                if(sortList.size()==0){
                    sortList.add(s);
                    continue;
                }
                int i=0;
                for(i=0;i<sortList.size();i++){
                    if(s.length()<sortList.get(i).length()){
                        sortList.add(i,s);
                        break;
                    }
                }
                if(i==sortList.size()){
                    sortList.add(s);
                }
            }
            ArrayList<String> tempList = new ArrayList();
            boolean isin= false;
            for(String org:sortList){
                isin = false;
                for(String adds:tempList){
                    if(org.indexOf(adds)==0){
                        isin = true;
                        break;
                    }
                }
                if(!isin)
                    tempList.add(org);
            }
            return (String[])tempList.toArray(new String[0]);
        }

        return null;
*/
    }

    public static final byte[] compress(String str) {
        if (str == null)
            return null;

        byte[] compressed;
        ByteArrayOutputStream out = null;
        ZipOutputStream zout = null;

        try {
            out = new ByteArrayOutputStream();
            zout = new ZipOutputStream(out);
            zout.putNextEntry(new ZipEntry("0"));
            zout.write(str.getBytes());
            zout.closeEntry();
            compressed = out.toByteArray();
        } catch (IOException e) {
            compressed = null;
        } finally {
            if (zout != null) {
                try {
                    zout.close();
                } catch (IOException e) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }
        return compressed;
    }


    public static final String decompress(byte[] compressed) {
        if (compressed == null)
            return null;

        ByteArrayOutputStream out = null;
        ByteArrayInputStream in = null;
        ZipInputStream zin = null;
        String decompressed;
        try {
            out = new ByteArrayOutputStream();
            in = new ByteArrayInputStream(compressed);
            zin = new ZipInputStream(in);
            ZipEntry entry = zin.getNextEntry();
            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = zin.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            decompressed = out.toString();
        } catch (IOException e) {
            decompressed = null;
        } finally {
            if (zin != null) {
                try {
                    zin.close();
                } catch (IOException e) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }

        return decompressed;
    }


}

