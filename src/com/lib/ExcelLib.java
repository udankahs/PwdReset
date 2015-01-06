package com.lib;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib
{
	public static int getRowCount(String xlPath,String sheetName)
	{
		try
		{
			FileInputStream fis=new FileInputStream(xlPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s1 = wb.getSheet(sheetName);
			int rc=s1.getLastRowNum();
			return rc;
		}
		catch(Exception e)
		{
			return -1;
		}
	}
	
	public static String getCellValue(String xlPath,String sheetName,int rowNum,int cellNum)
	{
		try
		{
			FileInputStream fis=new FileInputStream(xlPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s1 = wb.getSheet(sheetName);
			String v=s1.getRow(rowNum).getCell(cellNum).getStringCellValue();
			return v;
		}
		catch(Exception e)
		{
		System.out.println(e);
			return "";
		}
	}
	
	public static void writeExcel(String output_Path,String sheetName, int roww, int coll,String Valuee)throws Exception
	{	//Excel Path
		InputStream input = new BufferedInputStream(new FileInputStream(output_Path));
		POIFSFileSystem fs = new POIFSFileSystem( input );
		//Excel Workbook 
	    HSSFWorkbook wb = new HSSFWorkbook(fs);
	    //Excel Workbook Sheet
	    HSSFSheet sheet1 = wb.getSheet(sheetName);
	    HSSFRow rowheadSearchCriteria = sheet1.createRow((short) roww);
        @SuppressWarnings("deprecation")
		HSSFCell cell_0 = rowheadSearchCriteria.createCell((short) coll);
        cell_0.setCellValue(Valuee);
	    FileOutputStream outFile =new FileOutputStream(new File(output_Path)); 
		wb.write(outFile);
		outFile.close(); 
	}
	public static int getColCount(String xlPath,String sheetName, int row)
	{
		try
		{
			FileInputStream fis=new FileInputStream(xlPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s1 = wb.getSheet(sheetName);
			int rc=s1.getRow(row).getPhysicalNumberOfCells();
			return rc;
		}
		catch(Exception e)
		{
			return -1;
		}
	}
}
