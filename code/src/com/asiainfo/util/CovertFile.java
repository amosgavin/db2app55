package com.asiainfo.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.poi.POITextExtractor;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

/**
 * 
 * @author lizh
 * 
 */
public class CovertFile {

	/**
	 * ��word 2003�ĵ�����ȡ���ı�
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static String extractTextFromDOC(InputStream is) throws IOException {
		WordExtractor ex = new WordExtractor(is); // is��WORD�ļ���InputStream
		return ex.getText();
	}

	/**
	 * ��word 2007�ĵ�����ȡ���ı�
	 * 
	 * @param fileName
	 * @return
	 */
	public static String extractTextFromDOC2007(String fileName) {
		try {
			OPCPackage opcPackage = POIXMLDocument.openPackage(fileName);
			POIXMLTextExtractor ex = new XWPFWordExtractor(opcPackage);
			return ex.getText();
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * ��excel 2003�ĵ�����ȡ���ı�
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static String extractTextFromXLS(InputStream is, int colNum)
			throws IOException {
		StringBuffer content = new StringBuffer();
		HSSFWorkbook workbook = new HSSFWorkbook(is); // ������Excel�������ļ�������

		for (int numSheets = 0; numSheets < workbook.getNumberOfSheets(); numSheets++) {
			if (null != workbook.getSheetAt(numSheets)) {
				HSSFSheet aSheet = workbook.getSheetAt(numSheets); // ���һ��sheet

				for (int rowNumOfSheet = 0; rowNumOfSheet <= aSheet
						.getLastRowNum(); rowNumOfSheet++) {
					HSSFRow aRow = aSheet.getRow(rowNumOfSheet); // ���һ��
					if (null != aRow) {
						if (!content.toString().equals(""))
							content.append("|");
						// for (short cellNumOfRow = 0; cellNumOfRow <=
						// aRow.getLastCellNum(); cellNumOfRow++) {
						if (colNum == 0)
							colNum = aRow.getLastCellNum();
						for (short cellNumOfRow = 0; cellNumOfRow < colNum; cellNumOfRow++) {
							HSSFCell aCell = aRow.getCell(cellNumOfRow); // �����ֵ
							if (cellNumOfRow != 0)
								content.append("-");
							if (null != aRow.getCell(cellNumOfRow)) {

								if (aCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
									content.append(aCell.getNumericCellValue());
								} else if (aCell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
									content.append(aCell.getBooleanCellValue());
								} else {
									content.append(aCell.getStringCellValue()
											.replace("-", "_"));
								}
							} else {
								content.append("��ֵ");
							}
						}
					}
				}
			}
		}
		return content.toString();
	}

	/**
	 * ��excel 2007�ĵ�����ȡ���ı�
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static String extractTextFromXLS2007(InputStream is, int colNum)
			throws Exception {
		StringBuffer content = new StringBuffer();

		// ���� XSSFWorkbook ����strPath �����ļ�·��
		XSSFWorkbook xwb = new XSSFWorkbook(is);

		// ѭ��������Sheet
		for (int numSheet = 0; numSheet < xwb.getNumberOfSheets(); numSheet++) {
			XSSFSheet xSheet = xwb.getSheetAt(numSheet);
			if (xSheet == null) {
				continue;
			}

			// ѭ����Row
			for (int rowNum = 0; rowNum <= xSheet.getLastRowNum(); rowNum++) {
				XSSFRow xRow = xSheet.getRow(rowNum);
				if (xRow == null) {
					continue;
				}
				if (!content.toString().equals(""))
					content.append("|");

				// ѭ����Cell
				if (colNum == 0)
					colNum = xRow.getLastCellNum();
				for (int cellNum = 0; cellNum < colNum; cellNum++) {
					XSSFCell xCell = xRow.getCell(cellNum);
					if (xCell == null) {
						content.append("��ֵ");
						continue;
					}
					if (cellNum != 0)
						content.append("-");
					if (xCell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
						content.append(xCell.getBooleanCellValue());
					} else if (xCell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
						content.append(xCell.getNumericCellValue());
					} else {
						content.append(xCell.getStringCellValue().replace("-",
								"_"));
					}
				}
			}
		}

		return content.toString();
	}

	/**
	 * ��excel 2007�ĵ�����ȡ���ı�
	 * 
	 * @param fileName
	 * @return
	 */
	/*
	 * public static String getXLS2007(String fileName) { String doc = ""; try {
	 * doc = extractTextFromXLS2007(fileName); return doc; } catch (Exception e)
	 * { return ""; } }
	 */

	/**
	 * ��ppt 2003��2007�ĵ�����ȡ���ı�
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getPPTX(String fileName) {
		String doc = "";
		try {
			File inputFile = new File(fileName);
			POITextExtractor extractor = ExtractorFactory
					.createExtractor(inputFile);
			doc = extractor.getText();
			return doc;
		} catch (Exception e) {
			return "";
		}
	}

	public static String getTXT(InputStream is) throws Exception {
		String doc = "";
		String encoding = "GBK";// �ַ�����(�ɽ�������������� )
		InputStreamReader read = new InputStreamReader(is, encoding);
		BufferedReader bufferedReader = new BufferedReader(read);
		String lineTXT = null;
		while ((lineTXT = bufferedReader.readLine()) != null) {
			if (!doc.equals("")) {
				doc += "|";
			}
			String[] cols = lineTXT.split("\t");
			doc += cols[0].trim() + "-" + cols[1].trim() + "-" + cols[2].trim()
					+ "-" + cols[3].trim();
		}
		read.close();
		return doc;
	}

	public static void main(String[] args) {
		try {
			// String wordFile = "D:/��ɽѪս.docx";
			// String wordText2007 =
			// CovertFile.extractTextFromDOC2007(wordFile);
			// System.out.println("wordText2007=======" + wordText2007);
			//
			// InputStream is = new FileInputStream("D:/XXX�з����ļ�����λְλ����.xls");
			// String excelText = CovertFile.extractTextFromXLS(is);
			// System.out.println("text2003==========" + excelText);

			// String excelFile = "D:/zh.xlsx";
			String excelText2007 = "";
			InputStream is = new FileInputStream(
					"C:/Users/Administrator/Desktop/test.xlsx");
			excelText2007 = CovertFile.extractTextFromXLS2007(is, 4);
			System.out.println("excelText2007==========" + excelText2007);

			// String pptFile = "D:/zz3.ppt";
			// String pptx = CovertFile.getPPTX(pptFile);
			// System.out.println("pptx==========" + pptx);
			// String txtFile = "C:/Users/Administrator/Desktop/test.txt";
			// String txt = CovertFile.getTXT(txtFile);
			// System.out.println("txt========" + txt);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
