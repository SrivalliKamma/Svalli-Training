package com.qa.hubspott.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public static String  mydatafilepath = "F:\\JavaParctice\\svalliPOMsession\\src\\main\\java\\com\\qa\\hubspott\\data\\Contacttestdata.xlsx";
	public static Workbook book;
	public static Sheet sheet;
	
	public static Object[][] gettestdata(String Sheetname) {
		
		FileInputStream file;
		try {
			file = new FileInputStream(mydatafilepath);
			book = WorkbookFactory.create(file);
			sheet = book.getSheet(Sheetname);
			
			Object data [][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i =0; i<sheet.getLastRowNum(); i++) {
				for (int j =0; j<sheet.getRow(0).getLastCellNum(); j++) {
					data [i][j] = sheet.getRow(i+1).getCell(j).toString();
				}
				
			}
			return data;
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
		
		
		
		
		
	}
		
		
	}


