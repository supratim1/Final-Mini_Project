package com.pom.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fileinput;
	public static FileOutputStream fileoutput;
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String exelfile,String exelsheet) throws IOException 
	{
		fileinput = new FileInputStream(exelfile);
		workbook=new XSSFWorkbook(fileinput);
		worksheet= workbook.getSheet(exelsheet);
		int rowcount=worksheet.getLastRowNum();
		workbook.close();
		fileinput.close();
		return rowcount;		
	}

	public static int getColumnCount(String exelfile,String exelsheet,int rownum) throws IOException
	{
		fileinput=new FileInputStream(exelfile);
		workbook=new XSSFWorkbook(fileinput);
		worksheet=workbook.getSheet(exelsheet);
		row=worksheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fileinput.close();
		return cellcount;
	}


	public static String getCellData(String exelfile,String exelsheet,int rownum,int colnum) throws IOException
	{
		fileinput=new FileInputStream(exelfile);
		workbook=new XSSFWorkbook(fileinput);
		worksheet=workbook.getSheet(exelsheet);
		row=worksheet.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		
		try 
		{
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		workbook.close();
		fileinput.close();
		return data;
	}

	public static void setCellData(String exelfile,String exelsheet,int rownum,int colnum,String data) throws IOException
	{

		fileinput=new FileInputStream(exelfile);
		workbook=new XSSFWorkbook(fileinput);
		worksheet=workbook.getSheet(exelsheet);
		row=worksheet.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);

		fileoutput=new FileOutputStream(exelfile);
		workbook.write(fileoutput);		
		workbook.close();
		fileinput.close();
		fileoutput.close();
		
	}

	//For the Dataprovider concept
	public Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   

		String[][] tabArray = null;
		
		try { 

			fileinput = new FileInputStream(FilePath);
            // Access the required test data sheet
			workbook = new XSSFWorkbook(fileinput);
			worksheet = workbook.getSheet(SheetName);
			// System.out.println("Sheet 1 ,1 value :" +getCellData(FilePath,SheetName,1,1));

			int startRow = 1;
			int startCol = 0;
			int ci,cj;

			int totalRows = worksheet.getLastRowNum();
			int totalCols = getColumnCount(FilePath,SheetName,startRow);

			System.out.println("totalRows0 :"+totalRows);
			System.out.println("totalCols0 :"+totalCols);

			tabArray=new String[totalRows][totalCols];
			ci=0;
			for(int i=startRow;i<=totalRows;i++, ci++) {              
				cj=0;
				for(int j=startCol;j<totalCols;j++, cj++){
					tabArray[ci][cj] = getCellData(FilePath,SheetName,i,j);
					// System.out.println(tabArray[ci][cj]);  
				}
			}

		}catch (FileNotFoundException e){

			System.out.println("File not Found Exception");
        }
        catch (IOException e){

			System.out.println("Could not read the Excel sheet");
		}
		
		return(tabArray);
     }

}
