package com.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtilities {

	HashMap<String, String> testvals;
	List<String> phoneItems;
	String filePath;
	String fileName;
	String sheetName;
	public ExcelUtilities(String filePath, String fileName, String sheetName) {
		this.filePath = filePath;
		this.fileName = fileName;
		this.sheetName = sheetName;
		testvals = new HashMap<String, String>();
		phoneItems = new ArrayList<String>();
		try {
			readExcelMap();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public HashMap<String, String> getTestvals() {
		return testvals;
	}
	public List<String> getPhoneItems() {
		return phoneItems;
	}
	
    public boolean readExcel(String filePath,String fileName,String sheetName) throws IOException{

    	System.out.println("filePath " + filePath);
    	System.out.println("fileName " + fileName);
    	System.out.println("sheetName "  + sheetName);
    //Create an object of File class to open xlsx file

    File file =    new File(filePath+"\\"+fileName);
    System.out.println("file " + file);

    //Create an object of FileInputStream class to read excel file

    FileInputStream inputStream = new FileInputStream(file);


    Workbook myWorkbook = null;;
    
    //Find the file extension by splitting file name in substring  and getting only extension name

    String fileExtensionName = fileName.substring(fileName.indexOf("."));

    //Check condition if the file is xlsx file

    if(fileExtensionName.equals(".xlsx")){

    //If it is xlsx file then create object of XSSFWorkbook class

    	myWorkbook = new XSSFWorkbook(inputStream);

    }

    //Check condition if the file is xls file

    else if(fileExtensionName.equals(".xls")){

        //If it is xls file then create object of HSSFWorkbook class

    	myWorkbook = new HSSFWorkbook(inputStream);

    }

    //Read sheet inside the workbook by its name

    Sheet myWorksheet = myWorkbook.getSheet(sheetName);

    //Find number of rows in excel file

    int rowCount = myWorksheet.getLastRowNum()-myWorksheet.getFirstRowNum();

    //Create a loop over all the rows of excel file to read it
    int totalcells = 0;
    
	    for (int i = 0; i < rowCount+1; i++) {
	
	        Row row = myWorksheet.getRow(i);
	
	        //Create a loop to print cell values in a row
	
	
	        for (int j = 0; j < row.getLastCellNum(); j++) {
	
	            //Print Excel data in console
	            System.out.print(row.getCell(j).getStringCellValue()+"|| ");
	
	            totalcells++;
	        }
	
	        System.out.println();
	        
	
	    }
	    if (totalcells >1) {
	    	return true;
	    }else {
	    	return false;
	    }
    	
    }
    
    public String readExcelCell(String filePath,String fileName,String sheetName, int row, int col) throws IOException{

//    	System.out.println("filePath " + filePath);
//    	System.out.println("fileName " + fileName);
//    	System.out.println("sheetName "  + sheetName);
    //Create an object of File class to open xlsx file

    File file =    new File(filePath+"\\"+fileName);
    System.out.println("file " + file);

    //Create an object of FileInputStream class to read excel file

    FileInputStream inputStream = new FileInputStream(file);


    Workbook myWorkbook = null;;
    
    //Find the file extension by splitting file name in substring  and getting only extension name

    String fileExtensionName = fileName.substring(fileName.indexOf("."));

    //Check condition if the file is xlsx file

    if(fileExtensionName.equals(".xlsx")){

    //If it is xlsx file then create object of XSSFWorkbook class

    	myWorkbook = new XSSFWorkbook(inputStream);

    }

    //Check condition if the file is xls file

    else if(fileExtensionName.equals(".xls")){

        //If it is xls file then create object of HSSFWorkbook class

    	myWorkbook = new HSSFWorkbook(inputStream);

    }

    //Read sheet inside the workbook by its name

    Sheet myWorksheet = myWorkbook.getSheet(sheetName);

    //Find number of rows in excel file

    String cellvalue = myWorksheet.getRow(row).getCell(col-1).getStringCellValue();
    System.out.println(cellvalue);
    
    return cellvalue;
    	
    }
    
    public int readExcelRowCount(String filePath,String fileName,String sheetName) throws IOException{

    File file =    new File(filePath+"\\"+fileName);


    FileInputStream inputStream = new FileInputStream(file);


    Workbook myWorkbook = null;;
    

    String fileExtensionName = fileName.substring(fileName.indexOf("."));


    if(fileExtensionName.equals(".xlsx")){

    	myWorkbook = new XSSFWorkbook(inputStream);

    }


    else if(fileExtensionName.equals(".xls")){

    	myWorkbook = new HSSFWorkbook(inputStream);

    }


    Sheet myWorksheet = myWorkbook.getSheet(sheetName);

    System.out.println(" first row = " + myWorksheet.getFirstRowNum());
    System.out.println(" last Row = " + myWorksheet.getLastRowNum());
    int rowCount = myWorksheet.getLastRowNum()- myWorksheet.getFirstRowNum();
    
    
    return rowCount;
    	
    }
    
    
//    public HashMap<String, String> readExcelMap(String filePath,String fileName,String sheetName) throws IOException {
   	public void readExcelMap() throws IOException {    	

//    	HashMap<String, String> testvals = new HashMap<String, String>();
    	File file = new File(filePath+"\\"+fileName);
    	FileInputStream fileinputstream = new FileInputStream(file);
    	Workbook myWorkBook = null;
    	
    	String fileExtn = fileName.substring(fileName.indexOf("."));
    	
    	if (fileExtn.equalsIgnoreCase(".xlsx")) {
    		myWorkBook = new XSSFWorkbook(fileinputstream);
    	}else if(fileExtn.equalsIgnoreCase(".xls")) {
    		myWorkBook = new HSSFWorkbook(fileinputstream);
    	}
    	
    	Sheet myWorkSheet = myWorkBook.getSheet(sheetName);
    	
    	int iRows = myWorkSheet.getLastRowNum();
//    	System.out.println("iRows = " + iRows);
    	
    	String key;
    	String value;
    	
    	int row;
    	for(row=0;row<=iRows;row++) {
    		key = myWorkSheet.getRow(row).getCell(0).getStringCellValue();
    		value = myWorkSheet.getRow(row).getCell(1).getStringCellValue();
    		phoneItems.add(key);
    		testvals.put(key, value);
    	}
    	
//    	return testvals;
    }
    
    
}