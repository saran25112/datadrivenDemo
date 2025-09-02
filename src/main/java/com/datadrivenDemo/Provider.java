package com.datadrivenDemo;

public class Provider {

	public static void main(String[] args) {
		String excelPath = "src/main/resources/login test case.xlsx";
		String sheetName = "login";
		Reader excel = new Reader(excelPath, sheetName);
		// get a single value using index number X and Y
		String value = excel.getValue(0, 0);
		System.out.println(value);

//		get a total number of rows
		int rowCount = excel.getRowCount();
//		get a total number of cell		
		int cellCount = excel.getCellCount();
		System.out.println("rowCount :" + rowCount);
		System.out.println("cellCount :" + cellCount);

//		get all the values in the Table
		String[][] getvalues = excel.getvalues();
//		print the values in array
		excel.printArray(getvalues);

	}

}
