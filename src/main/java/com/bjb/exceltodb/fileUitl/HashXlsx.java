package com.bjb.exceltodb.fileUitl;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

/**
 * 约定第一行不放数据（放标题）
 * @author caozq
 *
 */
public class HashXlsx {
	XSSFWorkbook xssfWorkbook = null;
	XSSFSheet xssfSheet = null;
	public HashXlsx(String path) throws IOException {
		InputStream is = new FileInputStream(path);
		xssfWorkbook = new XSSFWorkbook(is);
		xssfSheet = xssfWorkbook.getSheetAt(0);
	}
	
	public int size() {
		return xssfSheet.getLastRowNum() + 1;
	}
	
	public XSSFCell cell(int rowIndex, int colIndex) {
		XSSFRow row = xssfSheet.getRow(rowIndex);
		if (row == null) {
			return null;
		}
		return row.getCell(colIndex);
	}
	
	public String get(int rowIndex, int colIndex) {
		XSSFCell cell = cell(rowIndex, colIndex);
		if (cell == null) {
			return "";
		}
		return getValue(cell);
	}
	
	public void set(int rowIndex, int colIndex, String val) {
		XSSFCell cell = null;
		XSSFRow row = xssfSheet.getRow(rowIndex);
		if (row == null) {
			row = xssfSheet.createRow(rowIndex);
			cell = row.createCell(colIndex);
		} else {
			cell = row.getCell(colIndex);
			if (cell == null) {
				cell = row.createCell(colIndex);
			}
		}
		cell.setCellValue(val);
	}
	
	private static String getValue(XSSFCell xssfRow) {
		if (xssfRow.getCellTypeEnum() == CellType.BOOLEAN) {
			return String.valueOf(xssfRow.getBooleanCellValue());
		} else if (xssfRow.getCellTypeEnum() == CellType.NUMERIC) {
			return String.valueOf((int)xssfRow.getNumericCellValue());
		} else {
			return String.valueOf(xssfRow.getStringCellValue());
		}
	}
	
	public void saveAs(String toPath) throws IOException {
		OutputStream os = null;
		try {
			os = new FileOutputStream(toPath);
			if (xssfWorkbook == null) {
				return;
			}
			xssfWorkbook.write(os);
		} finally {
			if (os != null) {
				try {
					os.flush();
				} catch(Exception e) {}
				try {
					os.close();
				} catch(Exception e) {}
				os = null;
			}
		}
	}
	
	public void close() {
		if (xssfWorkbook != null) {
			try {
				xssfWorkbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
