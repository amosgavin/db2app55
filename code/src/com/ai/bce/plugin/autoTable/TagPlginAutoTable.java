package com.ai.bce.plugin.autoTable;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.bce.bo.BcePageRelConfigBean;
import com.ai.bce.bo.BceVObjectConfBean;
import com.ai.bce.bo.BceViewObjectAttrBean;
import com.ai.bce.bo.BceViewObjectBean;
import com.ai.bce.plugin.AbstractTagPlugin;
import com.ai.bce.plugin.autoTable.bo.BceTagPAutotableAttrBean;
import com.ai.bce.plugin.autoTable.bo.BceTagPAutotableBean;
import com.ai.bce.plugin.autoTable.service.interfaces.IBceAutoPageTagATSV;
import com.ai.bce.service.interfaces.IBceAutoPageSV;

/**
 * 
 * Copyright: Copyright (c) 2010 Asiainfo-Linkage
 * 
 * @ClassName: TagPlginAutoTable.java
 * @Description: 该类的功能描述
 * 
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Nov 1, 2010 2:59:59 PM
 */
public class TagPlginAutoTable extends AbstractTagPlugin {
	IBceAutoPageSV iBEAutoPageSV = (IBceAutoPageSV) ServiceFactory
			.getService(IBceAutoPageSV.class);
	IBceAutoPageTagATSV iBEAutoPageTagATSV = (IBceAutoPageTagATSV) ServiceFactory
			.getService(IBceAutoPageTagATSV.class);

	
	public String display(BceViewObjectBean viewObjectBean, int pageFrameId,
			String template_id) throws Exception {
		// TODO Auto-generated method stub
		BceTagPAutotableBean tAutotableBean = iBEAutoPageTagATSV
				.getATableByObjId(viewObjectBean.getObjectId());
		// --->table
		BceTagPAutotableAttrBean[] tagPAutotableAttrBeans = iBEAutoPageTagATSV
				.getATableAttrByTbId(tAutotableBean.getAutotableId());
		this.displayBuffer.append("<table ");
		this.displayBuffer.append(getAttrValue(tAutotableBean.getHeight(),
				"height"));
		this.displayBuffer.append(getAttrValue(tAutotableBean.getBorder(),
				"border"));
		this.displayBuffer.append(getAttrValue(tAutotableBean.getTId(), "id"));
		this.displayBuffer.append(getAttrValue(tAutotableBean.getWidth(),
				"width"));
		this.displayBuffer.append(getAttrValue(tAutotableBean.getAlign(),
				"align"));
		BceViewObjectAttrBean[] attrs = iBEAutoPageSV
				.getBuViewObjectAttrBeanByobjID(viewObjectBean.getObjectId());
		List thViewAttrs = new LinkedList();
		for (int i = 0; i < attrs.length; i++) {
		BceViewObjectAttrBean	bceViewObjectAttrBean = attrs[i];
			
			if (bceViewObjectAttrBean.getAttrParam().startsWith("TR_"))
				thViewAttrs.add(bceViewObjectAttrBean);
			else
				this.displayBuffer.append(getAttrValue(bceViewObjectAttrBean
						.getAttrValue(), bceViewObjectAttrBean.getAttrParam()));

		}
		this.displayBuffer.append(">\n");
		int dw = 0;
		for (int i = 0; i < tagPAutotableAttrBeans.length; i++) {
			// 表结束
			BceTagPAutotableAttrBean buTagPAutotableAttrBean = tagPAutotableAttrBeans[i];
			BceViewObjectAttrBean[] attres = iBEAutoPageSV
					.getBuViewObjectAttrBeanByRelConfigID(buTagPAutotableAttrBean
							.getRelConfigId());
			for (int j = 0; j < attres.length; j++) {
				BceViewObjectAttrBean objectAttrBean = attres[i];
			
				if (objectAttrBean.getAttrParam().startsWith("TR_"))
					thViewAttrs.add(objectAttrBean);
			}
			if (dw != 0 && buTagPAutotableAttrBean.getRowes() == dw + 1)
				this.displayBuffer.append("</tr>");
			// 表头
			if (i == 0 || buTagPAutotableAttrBean.getRowes() == dw + 1) {
				this.displayBuffer.append("<tr");
				for (int j = 0; j < thViewAttrs.size(); j++) {
					BceViewObjectAttrBean	AttrBean = (BceViewObjectAttrBean) thViewAttrs.get(j);
					this.displayBuffer.append(getAttrValue(AttrBean
							.getAttrValue().substring("TR_".length()), AttrBean
							.getAttrParam()));
				}
				this.displayBuffer.append(">");
				dw++;
			}
			addtdParams(buTagPAutotableAttrBean, attres);
			switch (buTagPAutotableAttrBean.getDisplayType()) {
			case 1:
				addTdTag(buTagPAutotableAttrBean, pageFrameId, template_id);
				break;
			case 2:
				this.displayBuffer.append(buTagPAutotableAttrBean
						.getDispalyColumn()
						+ ":");
				break;
			case 3:
				this.displayBuffer.append(buTagPAutotableAttrBean
						.getDispalyColumn()
						+ ":");
				break;
			default:
				break;
			}
			this.displayBuffer.append("</td>\n");
			// 添加表尾
			if (i == tagPAutotableAttrBeans.length - 1) {
				this.displayBuffer.append("</tr>");
			}
		}
		this.displayBuffer.append("</table>\n");
		return this.displayBuffer.toString();
	}

	private void addTdTag(BceTagPAutotableAttrBean buTagPAutotableAttrBean,
			int pageFrameId, String template_id) throws Exception {
		// TODO Auto-generated method stub
		BcePageRelConfigBean buPageRelConfigBean = iBEAutoPageSV
				.getBuPageRelConfigBeanById(buTagPAutotableAttrBean
						.getRelConfigId());
		BceViewObjectBean buViewObjectBean = iBEAutoPageSV
				.getBuViewObjectBeanById(buPageRelConfigBean.getRelateObjId());
		BceVObjectConfBean buVObjectConfBean = iBEAutoPageSV
				.getBuVObjectConfBeanByTypeName(buViewObjectBean.getObjTypeId());
		displayBuffer.append("<" + buVObjectConfBean.getTypeTagValue());
		BceViewObjectAttrBean[] viewObjectAttrBeans = iBEAutoPageSV
				.getBuViewObjectAttrBeanByobjID(buViewObjectBean.getObjectId());
		for (int i = 0; i < viewObjectAttrBeans.length; i++) {
			BceViewObjectAttrBean buViewObjectAttrBean = viewObjectAttrBeans[i];
			this.displayBuffer.append(getAttrValue(buViewObjectAttrBean
					.getAttrValue(), buViewObjectAttrBean.getAttrParam()));
		}
		if (StringUtils.isBlank(buViewObjectBean.getRemarks())
				&& iBEAutoPageSV.getPageRelByPageFrameId(pageFrameId,
						buPageRelConfigBean.getPageRelId(), template_id).length < 1) {
			displayBuffer.append("/>");
			return;
		}
		displayBuffer.append(">\n");
		displayBuffer
				.append(StringUtils.isBlank(buViewObjectBean.getRemarks()) ? ""
						: buViewObjectBean.getRemarks());
		displayBuffer
				.append("</" + buVObjectConfBean.getTypeTagValue() + ">\n");
	}

	private void addtdParams(BceTagPAutotableAttrBean buTagPAutotableAttrBean,
			BceViewObjectAttrBean[] attres) {
		this.displayBuffer.append("<td ");
		this.displayBuffer.append(getAttrValue(buTagPAutotableAttrBean
				.getHeight(), "height"));
		this.displayBuffer.append(getAttrValue(buTagPAutotableAttrBean
				.getAlign(), "align"));
		this.displayBuffer.append(getAttrValue(buTagPAutotableAttrBean
				.getStyle(), "style"));
		this.displayBuffer.append(getAttrValue(buTagPAutotableAttrBean
				.getWidth(), "width"));
		this.displayBuffer.append(getAttrValue(buTagPAutotableAttrBean
				.getColspan(), "clospan"));
		this.displayBuffer.append(getAttrValue(buTagPAutotableAttrBean
				.getRowspan(), "rowspan"));
		// 针对特殊增加值
		for (int i = 0; i < attres.length; i++) {
			
			BceViewObjectAttrBean viewObjectAttrBean= attres[i];
			if (!viewObjectAttrBean.getAttrParam().startsWith("TR_"))
				this.displayBuffer.append(getAttrValue(viewObjectAttrBean
						.getAttrValue(), viewObjectAttrBean.getAttrParam()));
		}
		this.displayBuffer.append(">");
	}

	private String getAttrValue(int attr, String attrNotes) {
		// TODO Auto-generated method stub
		return attr == 0 ? "" : attrNotes + "=" + attr + " ";
	}

	private String getAttrValue(String attr, String attrNotes) {
		return StringUtils.isBlank(attr) ? "" : attrNotes + "=" + attr + " ";
	}

}
