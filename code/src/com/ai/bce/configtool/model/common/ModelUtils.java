package com.ai.bce.configtool.model.common;

import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.io.filefilter.AndFileFilter;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.OrFileFilter;
import org.apache.commons.io.filefilter.PrefixFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * ���ù���
 * @author linzhaoming
 *
 */
public class ModelUtils {
	
	/**
	 * ���� Filter
	 * @return
	 */
	public static FileFilter getServiceFileFilter(){
		IOFileFilter dirFilter = DirectoryFileFilter.INSTANCE;
		SuffixFileFilter suffixFilter= new SuffixFileFilter("SV.class");
		AndFileFilter filter = new AndFileFilter(suffixFilter, new PrefixFileFilter("I"));
		OrFileFilter orFilter = new OrFileFilter(dirFilter, filter);		
		
		return orFilter;
	}
	
	/**
	 * java�� Filter
	 */
	
	public static FileFilter getJavaFileFilter(){
		IOFileFilter dirFilter = DirectoryFileFilter.INSTANCE;
		SuffixFileFilter suffixFilter= new SuffixFileFilter(".class");
		List filterList = new ArrayList();
		filterList.add(suffixFilter);
		filterList.add(dirFilter);
		OrFileFilter orFilter = new OrFileFilter(filterList);		
		
		return orFilter;
	}
	
	/**
	 * JSP Filter
	 * @return
	 */
	public static FileFilter getJSPFileFilter(){
		IOFileFilter dirFilter = DirectoryFileFilter.INSTANCE;
		SuffixFileFilter suffixFilter= new SuffixFileFilter(".jsp");
//		AndFileFilter filter = new AndFileFilter(suffixFilter, new PrefixFileFilter(""));
		OrFileFilter orFilter = new OrFileFilter(dirFilter, suffixFilter);		
		
		return orFilter;
	}
	
	/**
	 * JSP Filter
	 * @return
	 */
	public static FileFilter getJSFileFilter(){
		IOFileFilter dirFilter = DirectoryFileFilter.INSTANCE;
		SuffixFileFilter suffixFilter= new SuffixFileFilter(".js");
//		AndFileFilter filter = new AndFileFilter(suffixFilter, new PrefixFileFilter(""));
		OrFileFilter orFilter = new OrFileFilter(dirFilter, suffixFilter);		
		
		return orFilter;
	}
	
	
	public static FileFilter getAllJSFileFilter(){
		IOFileFilter dirFilter = DirectoryFileFilter.INSTANCE;
		SuffixFileFilter suffixFilter= new SuffixFileFilter(".js");
		SuffixFileFilter suffixFilter2= new SuffixFileFilter(".jsp");
		List filterList = new ArrayList();
		filterList.add(suffixFilter);
		filterList.add(suffixFilter2);
		filterList.add(dirFilter);
//		AndFileFilter filter = new AndFileFilter(suffixFilter, new PrefixFileFilter(""));
		OrFileFilter orFilter = new OrFileFilter(filterList);		
		
		return orFilter;
	}
	
	/**
	 * WVM Filter
	 * @return
	 */
	public static FileFilter getWVMFileFilter(){
		IOFileFilter dirFilter = DirectoryFileFilter.INSTANCE;
		SuffixFileFilter suffixFilter= new SuffixFileFilter(".wvm");
//		AndFileFilter filter = new AndFileFilter(suffixFilter, new PrefixFileFilter("I"));
		OrFileFilter orFilter = new OrFileFilter(dirFilter, suffixFilter);		
		
		return orFilter;
	}
	
	/**
	 * �����Ŀ¼
	 * @param children
	 */
	public static void clearEmotyChildren(List children){
		for(int i=children.size()-1; i>=0; i--){
			ServiceModel model = (ServiceModel)children.get(i);

			if(model.isDirectory() && model.getChildren().size()==0){
				children.remove(model);
			}
		}
	}
	
	/**
	 * Ĭ��Comparator
	 * ����Ŀ¼��ǰ���ļ����ں󣬰�literal����
	 * @return
	 */
	public static Comparator getModelComparator(){
		return new Comparator() {
			public int compare(Object obj1, Object obj2) {
				ServiceModel model1 = (ServiceModel)obj1;
				ServiceModel model2 = (ServiceModel)obj2;
				if(model1.isDirectory()){
					//Ŀ¼��Ŀ¼�Ƚ�
					if(model2.isDirectory()){
						//�ļ��бȽ�
						return model1.getDisplayPath().compareTo(model2.getDisplayPath());
					}else{
						return -1;
					}
				}else{
					if(!model2.isDirectory()){
						//�ļ����Ƚ�
						return model1.getDisplayPath().compareTo(model2.getDisplayPath());
					}else{
						return 1;
					}
				}
			}
		};
	}
}
