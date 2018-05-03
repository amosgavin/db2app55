package com.ai.bce.create;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.bce.bo.BcePageBean;
import com.ai.bce.bo.BcePageRelConfigBean;
import com.ai.bce.bo.BceVObjectConfBean;
import com.ai.bce.bo.BceViewObjectAttrBean;
import com.ai.bce.bo.BceViewObjectBean;
import com.ai.bce.create.template.impl.TemplateStringForJs;
import com.ai.bce.plugin.AbstractTagPlugin;
import com.ai.bce.service.interfaces.IBceAutoPageSV;
import com.ai.bce.util.BceAutoPageUtil;
import com.ai.bce.util.BceException;
import com.ai.bce.util.ReflectUtils;

public class BusiServiceCreator {
	private StringBuffer genString = new StringBuffer();
	private IBceAutoPageSV iBEAutoPageSV = (IBceAutoPageSV) ServiceFactory
			.getService(IBceAutoPageSV.class);
	private static final String HTML_ROOT = "html";

	public void getTemlateString(String template_id, int pageFrameId,
			long prant_id) throws Exception {
		if (prant_id == 0)
			this.genString.delete(0, genString.length());
		addJs(template_id, pageFrameId);
		addTagTemplate(template_id, pageFrameId, prant_id);
	}

	/**
	 * 增加Tag处理
	 * 
	 * @Function: BusiServiceCreator.java
	 * @Description: 该函数的功能描述
	 * 
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 * 
	 * @version: v1.0.0
	 * @author: Qinjin Peng
	 * @date: Nov 8, 2010 6:05:40 PM
	 * 
	 */
	private void addTagTemplate(String template_id, int pageFrameId,
			long prant_id) throws Exception {
		BcePageRelConfigBean[] buConfigBeans = iBEAutoPageSV
				.getPageRelByPageFrameId(pageFrameId, prant_id, template_id);
		BceViewObjectBean viewObjectBean = iBEAutoPageSV
				.getBuViewObjectBeanByRelId(prant_id);
		// 针对插件作处理
		if (isHavePlugin(viewObjectBean)) {
			this.plgin(viewObjectBean, pageFrameId, template_id);
			return;
		}
		// 正常遍历
		for (int i = 0; i < buConfigBeans.length; i++) {
			BcePageRelConfigBean buPageRelConfigBean = buConfigBeans[i];
			BceViewObjectBean buViewObjectBean = iBEAutoPageSV
					.getBuViewObjectBeanById(buPageRelConfigBean
							.getRelateObjId());
			BceVObjectConfBean buVObjectConfBean = iBEAutoPageSV
					.getBuVObjectConfBeanByTypeName(buViewObjectBean
							.getObjTypeId());
			if (!"null".equals(buVObjectConfBean.getTypeTagValue())) {
				genString.append("<" + buVObjectConfBean.getTypeTagValue());
				BceViewObjectAttrBean[] viewObjectAttrBeans = iBEAutoPageSV
						.getBuViewObjectAttrBeanByobjID(buViewObjectBean
								.getObjectId());
				for (int j = 0; j < viewObjectAttrBeans.length; j++) {
					BceViewObjectAttrBean buViewObjectAttrBean = viewObjectAttrBeans[i];
					genString.append(" " + buViewObjectAttrBean.getAttrParam()
							+ "=\"" + buViewObjectAttrBean.getAttrValue()
							+ "\"");
				}
				if (StringUtils.isBlank(buViewObjectBean.getRemarks())
						&& iBEAutoPageSV
								.getPageRelByPageFrameId(pageFrameId,
										buPageRelConfigBean.getPageRelId(),
										template_id).length < 1) {
					genString.append("/>");
					continue;
				}
				genString.append(">\n");
				genString.append(StringUtils.isBlank(buViewObjectBean
						.getRemarks()) ? "" : buViewObjectBean.getRemarks());
				// 使用递归遍历
				getTemlateString(template_id, pageFrameId, buPageRelConfigBean
						.getPageRelId());
				genString.append("</" + buVObjectConfBean.getTypeTagValue()
						+ ">\n");
			} else {
				// 使用递归遍历
				getTemlateString(template_id, pageFrameId, buPageRelConfigBean
						.getPageRelId());
			}
		}
	}

	private void addJs(String template_id, int pageFrameId) throws Exception {
		// 针对Js做处理
		if ("js".equals(template_id)) {
			this.genString.append(getJsString(pageFrameId));
			return;
		}
	}

	/**
	 * 针对Plgin的公共处理
	 * 
	 * @Function: BusiServiceCreator.java
	 * @Description: 该函数的功能描述
	 * 
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 * 
	 * @version: v1.0.0
	 * @author: Qinjin Peng
	 * @param template_id
	 * @param pageFrameId
	 * @throws Exception
	 * @date: Nov 1, 2010 2:54:50 PM
	 * 
	 */
	private void plgin(BceViewObjectBean viewObjectBean, int pageFrameId,
			String template_id) throws Exception {
		// TODO Auto-generated method stub
		if (BceAutoPageUtil
				.getTagPluginByObjType(viewObjectBean.getObjTypeId())
				.getImplClass() == null) {
			throw new Exception("plgin impl class is null");
		}
		AbstractTagPlugin aTagPlgin = (AbstractTagPlugin) ReflectUtils
				.constructorNewInstance(BceAutoPageUtil.getTagPluginByObjType(
						viewObjectBean.getObjTypeId()).getImplClass(), null,
						null);
		this.genString.append(aTagPlgin.display(viewObjectBean, pageFrameId,
				template_id));
	}

	/**
	 * 检查当前是否使用Tag插件
	 * 
	 * @Function: BusiServiceCreator.java
	 * @Description: 该函数的功能描述
	 * 
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 * 
	 * @version: v1.0.0
	 * @author: Qinjin Peng
	 * @date: Nov 1, 2010 2:55:11 PM
	 * 
	 */
	private boolean isHavePlugin(BceViewObjectBean viewObjectBean) {
		// TODO Auto-generated method stub
		return BceAutoPageUtil.getTagPluginByObjType(viewObjectBean
				.getObjTypeId()) == null ? false : true;
	}

	/**
	 * 获取Js申请串
	 * 
	 * @Function: BusiServiceCreator.java
	 * @Description: 该函数的功能描述
	 * 
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 * 
	 * @version: v1.0.0
	 * @author: Qinjin Peng
	 * @date: Nov 1, 2010 2:55:31 PM
	 * 
	 */
	private String getJsString(long pageId) throws Exception {
		AbstractTemplateString templateString = new TemplateStringForJs();
		return templateString.dispalayString(pageId);
	}

	/**
	 * 制作文件基础类
	 * 
	 * @Function: BusiServiceCreator.java
	 * @Description: 该函数的功能描述
	 * 
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 * 
	 * @version: v1.0.0
	 * @author: Qinjin Peng
	 * @date: Nov 1, 2010 2:55:48 PM
	 * 
	 */
	public void makeFile(int pageFrameId) throws Exception {
		BcePageBean bean = iBEAutoPageSV.getBePageById(pageFrameId);
		// 功能:读取f:/aillo.txt文件的内容(一行一行读),并将其内容写入f:/jackie.txt中
		// 知识点:java读文件、写文件---<以字符流方式>

		if (bean == null)
			throw new BceException("BES0000401");
		String item = "<template name=\"";
		String item_end = "\"";
		String jsFile = "$JS_FILE";
		try {
			System.out.println("Bean="+bean);
			FileReader fr = new FileReader(HTML_ROOT+bean.getPageTemplate());

			// 创建FileReader对象，用来读取字符流
			BufferedReader br = new BufferedReader(fr); // 缓冲指定文件的输入
			FileWriter fw = new FileWriter(HTML_ROOT+bean.getPageUrl());//
			// 创建FileWriter对象，用来写入字符流
			BufferedWriter bw = new BufferedWriter(fw); // 将缓冲对文件的输出
			String myreadline; // 定义一个String类型的变量,用来每次读取一行
			boolean jsIncluded = false;
			while (br.ready()) {
				myreadline = br.readLine();// 读取一行
				if(jsIncluded == false){
					if(myreadline.indexOf(jsFile)>0){
						String file = bean.getPageUrl();
						file = file.substring(0,file.length()-4);
						myreadline = StringUtils.replace(myreadline,jsFile,file);
						jsIncluded = true;
					}
				}
				int templateIndex = myreadline.indexOf(item);
				if (templateIndex > -1) {
					myreadline = replaceTemplate(pageFrameId, item, item_end,
							myreadline, templateIndex);
					
				}
				bw.write(myreadline); // 写入文件
				bw.newLine();
			}
			bw.flush(); // 刷新该流的缓冲
			bw.close();
			br.close();
			fw.close();
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 模板替换
	 * 
	 * @Function: BusiServiceCreator.java
	 * @Description: 该函数的功能描述
	 * 
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 * 
	 * @version: v1.0.0
	 * @author: Qinjin Peng
	 * @date: Nov 1, 2010 2:56:10 PM
	 * 
	 */
	private String replaceTemplate(int pageFrameId, String item,
			String item_end, String myreadline, int templateIndex)
			throws Exception {
		String temp = myreadline.substring(templateIndex + item.length());
		String tempalteName = temp.substring(0, temp.indexOf(item_end));
		getTemlateString(tempalteName, pageFrameId, 0);
		myreadline = this.genString.toString();
		return myreadline;
	}
	
	public static void main(String[] args) throws Exception {
		BusiServiceCreator creator = new BusiServiceCreator();
		creator.makeFile(3);
	}
}
