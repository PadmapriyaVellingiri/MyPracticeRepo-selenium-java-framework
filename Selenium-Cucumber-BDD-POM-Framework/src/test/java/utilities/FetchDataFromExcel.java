package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import Constants.ConstantsData;

public class FetchDataFromExcel {
	
	public static String getURL(int x, int y) throws IOException
	{
		FileInputStream fs = new FileInputStream(ConstantsData.EXCEL_PATH);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFCell val = sheet.getRow(x).getCell(y);
		// Handles all types (String, number, date etc.)
        DataFormatter formatter = new DataFormatter();
        String URL = formatter.formatCellValue(val);
		//String URL =  val.toString();
        workbook.close();
        fs.close();
       // return value;
		return URL;		
	}
    
    public static void writeCustomerId(String custId) {
        try {
            FileInputStream fis = new FileInputStream(ConstantsData.EXCEL_PATH);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet("CustomerData");

            int lastRow = sheet.getLastRowNum();
            sheet.createRow(lastRow + 1).createCell(0).setCellValue(custId);

            FileOutputStream fos = new FileOutputStream(ConstantsData.EXCEL_PATH);
            workbook.write(fos);

            workbook.close();
            fis.close();
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Map<String, String> getData(String sheetName, int rowNum) {

        Map<String, String> data = new HashMap<>();

        try {
            FileInputStream fis = new FileInputStream(ConstantsData.EXCEL_PATH);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            XSSFRow headerRow = sheet.getRow(0);
            XSSFRow dataRow = sheet.getRow(rowNum);

            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                String key = headerRow.getCell(i).toString();
                String value = dataRow.getCell(i).toString();
                data.put(key, value);
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
    
    public static String readCustomerID(int rowNum) {

        String custId = "";

        try {
            FileInputStream fis = new FileInputStream(ConstantsData.EXCEL_PATH);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet("CustomerData");
            int lastRowNum = sheet.getLastRowNum();  // gets last row index
            XSSFRow row = sheet.getRow(lastRowNum);
            if (row != null) {
            custId = row.getCell(0).toString();
            }
            workbook.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return custId;
    }
    
    public static Map<String, String> readAccountData() {

        Map<String, String> accountData = new HashMap<>();

        try {
            FileInputStream fis = new FileInputStream(ConstantsData.EXCEL_PATH);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheet("Testdata");

            if (sheet == null) {
                System.out.println("Account sheet not found!");
                return accountData;
            }

            // Row 0 → header, Row 1 → actual data
            XSSFRow header = sheet.getRow(0);
            XSSFRow row = sheet.getRow(1);

            for (int i = 0; i < header.getLastCellNum(); i++) {
                String key = header.getCell(i).toString();
                String value = row.getCell(i).toString();
                accountData.put(key, value);
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return accountData;
    }
    
   public static void writeAccountID(String accountID) {
	   try {
           FileInputStream fis = new FileInputStream(ConstantsData.EXCEL_PATH);
           XSSFWorkbook workbook = new XSSFWorkbook(fis);
           XSSFSheet sheet = workbook.getSheet("AccountID");

           int lastRow = sheet.getLastRowNum();
           sheet.createRow(lastRow + 1).createCell(0).setCellValue(accountID);

           FileOutputStream fos = new FileOutputStream(ConstantsData.EXCEL_PATH);
           workbook.write(fos);

           workbook.close();
           fis.close();
           fos.close();

       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   }
 