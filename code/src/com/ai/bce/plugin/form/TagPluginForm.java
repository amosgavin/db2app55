package com.ai.bce.plugin.form;

import org.apache.commons.lang.StringUtils;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.bce.bo.BceViewObjectBean;
import com.ai.bce.plugin.AbstractTagPlugin;
import com.ai.bce.plugin.form.ivalues.IBceTagPFormFieldValue;
import com.ai.bce.plugin.form.ivalues.IBceTagPFormValue;
import com.ai.bce.plugin.form.service.interfaces.IBceTagPFormSV;
import com.ai.bce.util.BceException;

public class TagPluginForm extends AbstractTagPlugin{
	public IBceTagPFormSV getService(){
		return (IBceTagPFormSV)ServiceFactory.getService(IBceTagPFormSV.class);
	}
	
	private String formManager = "";
	private String notNullFields = "";
	private StringBuffer validFunc = new StringBuffer();

	public String display(BceViewObjectBean viewObjectBean, int pageframeId, String template_id) throws Exception {
		long objectId = viewObjectBean.getObjectId();
		IBceTagPFormValue form = getService().getBceTagPForm(objectId);
		if(form == null || form.isNew()){
			throw new BceException("BES0000414",new Object[]{String.valueOf(objectId)});
		}
		IBceTagPFormFieldValue[] fields = getService().getBceTagPFormField(objectId);
		if(fields == null || fields.length == 0){
			throw new BceException("BES0000414",new Object[]{String.valueOf(objectId)});
		}
		String formId = form.getFormId();
		formManager = formId + "Manager()";
		displayBuffer.append("<ai:dbform formid=\"").append(formId)
		  .append("\" setname=\"").append(form.getSetName()).append("\"\r\n");
		if(StringUtils.isNotBlank(form.getDataModel())){
			displayBuffer.append(" datamodel=\"").append(form.getDataModel()).append("\"\r\n");
		}
		if(StringUtils.isNotBlank(form.getServiceName())){
			displayBuffer.append(" implservice_name=\"").append(form.getServiceName()).append("\"\r\n");
		}
		if(StringUtils.isNotBlank(form.getQueryMethod())){
			displayBuffer.append(" implservice_querymethod=\"").append(form.getQueryMethod()).append("\"\r\n");
		}
		if(StringUtils.isNotBlank(form.getMo())){
			displayBuffer.append(" mo=\"").append(form.getMo()).append("\" ");
		}
		if(StringUtils.isNotBlank(form.getOperator())){
			displayBuffer.append(" operator=\"").append(form.getOperator()).append("\"\r\n");
		}
		displayBuffer.append(" initial=\"").append(form.getIsInitial() == 1 ? "true":"false").append("\" ");
		if(StringUtils.isNotBlank(form.getConditionName())){
			displayBuffer.append(" conditionname=\"").append(form.getConditionName()).append("\"\r\n");
		}
		displayBuffer.append(" editable=\"").append(form.getEditable() == 1 ? "true":"false").append("\">\r\n ");
		//处理隐藏字段
		for(int i=0;i<fields.length;i++){
			if(fields[i].getVisible() == 0){
				displayBuffer.append("<ai:dbformfield fieldname=\""+fields[i].getFieldName()+"\" formid=\""+formId+"\" visible=\"false\"/>\r\n");
			}
		}
		//处理显示字段
		displayBuffer.append("<table ").append(form.getTableStyle()==null?"":form.getTableStyle()).append(">\r\n");
		int cols = form.getCols();
		int num = 0;
		for(int i=0;i<fields.length;i++){
			//字段校验
			String valid = fields[i].getValidation();
			validFunc.append(getValidateFunc(fields[i].getFieldName(),valid));
			
			if(fields[i].getVisible() == 0)
				continue;
			
			if(num%cols == 0){
				displayBuffer.append("  <tr>\r\n");
			}
			displayBuffer.append("    <td "+(form.getTitleStyle()==null?"":form.getTitleStyle())+">");
			if(StringUtils.isNotBlank(fields[i].getTitleI18n())){
				displayBuffer.append("<%=CrmLocaleFactory.getResource(\""+fields[i].getTitleI18n()+"\")%>");
			}
			else{
				displayBuffer.append(fields[i].getTitle());
			}
			displayBuffer.append("</td>\r\n");
			
			int colSpan = fields[i].getColSpan();
			displayBuffer.append("    <td "+(form.getFieldStyle()==null?"":form.getFieldStyle())+">");
			if(colSpan > 1){
				displayBuffer.append("    <td "+form.getFieldStyle()+">")
		      .append("").append("</td>\r\n");
				num = num + colSpan;
			}
			else{
				num = num + 2;
			}
			displayBuffer.append("<ai:dbformfield fieldname=\""+fields[i].getFieldName()+"\" formid=\""+formId+"\" ");
			if(StringUtils.isNotBlank(fields[i].getWidth())){
				displayBuffer.append(" width=\""+fields[i].getWidth()+"\" ");
			}
			if(StringUtils.isNotBlank(fields[i].getEditType())){
				displayBuffer.append(" edittype=\""+fields[i].getEditType()+"\" ");
			}
			displayBuffer.append(" editable=\"").append(fields[i].getEditable() == 1 ? "true":"false").append("\"/></td>\r\n");
			
			if(num%cols == 0 || num == cols - 1 || i == fields.length - 1){
				displayBuffer.append("  </tr>\r\n");
				num = 0;
			}
		}
		displayBuffer.append("</table>\r\n");
		displayBuffer.append("</ai:dbform>\r\n");
		
		//js
		displayBuffer.append("<script language=\"javascript\">\r\n")
		     .append("function " + formManager + "{\r\n")
		     .append("  return g_FormRowSetManager.get(\""+formId+"\");\r\n}\r\n");
		
		displayBuffer.append("function " + formId + "Validate(){\r\n");
		if(StringUtils.isNotBlank(notNullFields)){
			displayBuffer.append("if(g_FormFieldIsNull(" + formManager + ",\"" + notNullFields.substring(1) + "\") == true){\r\n")
			  .append("  return false;\r\n}\r\n");
		}
		if(validFunc.length() > 0){
			displayBuffer.append(validFunc.toString());
		}
		displayBuffer.append("  return true;\r\n}\r\n");
		
		displayBuffer.append("</script>");
		return displayBuffer.toString();
	}

	private String getValidateFunc(String fieldName,String validation){
		String func = "";
		if(StringUtils.isBlank(validation))
			return func;
		String[] valids = StringUtils.split(validation,",");
		for(int i=0;i<valids.length;i++){
			if("0".equals(valids[i])){
				notNullFields += ","+fieldName;
				continue;
			}
			func += "if(" + validateFuncs[Integer.parseInt(valids[i])] + "(" + formManager + ".getValue(\"" + fieldName + "\")) == false){\r\n";
			func += "  alert(\""+fieldName+" is Error!\");\r\n  return false\r\n}\r\n";
		}
		return func;
	}
	//非空，日期，日期时间，数字，身份证，手机号，固话，email，邮编
	private static String[] validateFuncs = new String[]{"","g_IsDate","g_IsDateTime","g_IsDigit","g_IDCardNumber",
			"g_IsMobileNumber","g_IsTeleNumber","g_IsEmail","g_IsPostalCode"};
}
