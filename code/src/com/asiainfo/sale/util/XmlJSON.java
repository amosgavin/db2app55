package com.asiainfo.sale.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringWriter;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.validation.SchemaFactory;

import com.ai.secframe.common.bo.SysOperateLog;
import com.asiainfo.sale.activity.jsobject.Act;
import com.asiainfo.sale.activity.jsobject.ActReq;
import com.thoughtworks.xstream.XStream;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

/**
 * 
 * <p>
 * Title: JSON-XML转换工具
 * </p>
 * <p>
 * desc:
 * <p>
 * Copyright: Copyright(c)Gb 2012
 * </p>
 * 
 * @author http://www.ij2ee.com
 * @time 上午8:20:40
 * @version 1.0
 * @since
 */
public class XmlJSON {
	private static final String STR_JSON = "{\"request\":{\"orglist\":[\"999\"],\"act\":{\"region\":\"270\",\"REWARDCLASS\":\"rtChargePrepay\",\"REWARDTYPE\":\"rtPerson\",\"PRODID\":\"ACT27007052015070009\",\"PRIVRELATETYPE\":\"rltpMtx\",\"AVAILABLEDATE\":\"2015-07-20 19:18:31\",\"CREATEORGID\":\"1103\",\"UNITEORDERNO\":\"23285\",\"PRODNAME\":\"20150720\",\"ENDDATE\":\"2015-08-20 19:18:31\"},\"channellist\":[{\"OPERATION\":\"ProdOprRead\",\"REGION\":\"270\",\"CHANNELID\":\"1\"},{\"OPERATION\":\"ProdOprRec\",\"REGION\":\"270\",\"CHANNELID\":\"bsacHal\"}],\"custgroupallow\":[],\"custgroupforbid\":[]}}";

	public static String xml2JSON(String xml) {
		return new XMLSerializer().read(xml).toString();
	}

	public static String json2XML(String json) {
		JSONObject jobj = JSONObject.fromObject(json);
		String xml = new XMLSerializer().write(jobj);
		return xml;
	}

	public static void main(String[] args) {
		/*
		 * String xml = json2XML(STR_JSON); System.out.println("xml = " + xml);
		 * String json = xml2JSON(xml); System.out.println("json=" + json);
		 */
		ActReq req = new ActReq();
		req.setAct(new Act());
		XStream xs = new XStream();
		xs.autodetectAnnotations(true);
		System.out.println(xs.toXML(req));
		/*try {
			JAXBContext context = JAXBContext.newInstance(
					"com.asiainfo.sale.activity.jsobject.ActReq");
			Marshaller marshaller = context.createMarshaller();
			StringWriter writer = new StringWriter();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "GB2312");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(req, writer);
			System.out.println(writer.toString());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
