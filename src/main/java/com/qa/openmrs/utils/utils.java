package com.qa.openmrs.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utils {

	public static int IMPLICIT_WAIT=30;
	public static int PAGE_LOAD_TIMEOUT=30;
	public static String excelpath=System.getProperty("user.dir")+"\\src\\main\\java\\com"
			                           + "\\qa\\openmrs\\testdata\\OpenMRS_TestData.xlsx";
	
	public  static Object[][] getexceldata() {
		File src = new File(excelpath);
		Object[][] data = null;

		try {
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis); 
			XSSFSheet sheet=wb.getSheet("RegisterPatient");

			int row=sheet.getLastRowNum();
			int col = sheet.getRow(0).getLastCellNum();

			data = new Object [row][col];

			for (int j = 0; j < row ; j++) {
				for (int k = 0; k < col ; k++) {

					data[j][k] = sheet.getRow(j+1).getCell(k).toString();
					//System.out.println(data[j][k]);
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}
	
	public  static Object[][] getNameexceldata() {
		File src = new File(excelpath);
		Object[][] data = null;

		try {
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis); 
			XSSFSheet sheet=wb.getSheet("RegisterPatient");

			int row=sheet.getLastRowNum();
			//int col = sheet.getRow(0).getLastCellNum();
			
			int col =3;
			data = new Object [row][col];

			for (int j = 0; j < row ; j++) {
				for (int k = 0; k < 3 ; k++) {

					data[j][k] = sheet.getRow(j+1).getCell(k).toString();
					//System.out.println(data[j][k]);
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}
}
