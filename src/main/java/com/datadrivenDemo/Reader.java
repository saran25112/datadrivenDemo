package com.datadrivenDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Reader {
	public XSSFWorkbook workbook;
	public FileInputStream fileInputStream;
	public XSSFSheet sheet;
	public File file;
	public XSSFRow row;
	public XSSFCell cell;

	public Reader(String exalPath, String sheetName) {
		file = new File(exalPath);
		try {
			fileInputStream = new FileInputStream(file);

			workbook = new XSSFWorkbook(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = workbook.getSheet(sheetName);
	}
	
	public String getValue(int rowNum,int cellNum) {
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		DataFormatter dataFormatter = new DataFormatter();
		String formatCellValue = dataFormatter.formatCellValue(cell);
		return formatCellValue;
	}
	public int getRowCount() {
		return sheet.getLastRowNum()+1;
	}
	public int getCellCount() {
		row = sheet.getRow(0);
		return row.getLastCellNum();
	}
	public String[][] getvalues() {
		int rowCount = getRowCount();
		int cellCount = getCellCount();
		String[][] array = new String[rowCount][cellCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				array [i][j] =getValue(i, j);
			}
		}
		return array;
	}
	public void printArray(String[][] array) {
		for (String[] strings : array) {
			for (String strings2 : strings) {
				System.out.print(strings2+"|");
			}
			System.out.println("");
		}
		
	}
	
}
