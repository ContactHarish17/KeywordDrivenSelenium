package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import configs.constants;

public class ExcelReader {

	public static XSSFWorkbook xworkbook;
	public static XSSFCell xcell;
	public static XSSFSheet xsheet;
	public static int numbers=0;
	
	public static void setExcelFile(String path) throws IOException
	{
		FileInputStream excelfile = new FileInputStream(path);
		xworkbook = new XSSFWorkbook(excelfile);
	}
	
	
	//Method to read Testdata from the ExcelSheet
public static String getCellData_multiplesheets(int row,int col, String sheetname)
{
	       String cellData=null;
	       XSSFSheet sheets = xworkbook.getSheet(sheetname);
//	       int rows = getRowCounts();
//	       for(int i=0;i<=rows;i++)
//	       {
//	    	  //sheets = xworkbook.getSheetAt(i);
	          System.out.println("Sheet name in getCellData method is " + sheets.getSheetName());
				try
					{
						xcell = sheets.getRow(row).getCell(col);
						if(xcell.getStringCellValue()!=null && xcell.getStringCellValue().length() !=0)
						{
							//String cellDatas = xcell.getStringCellValue();
							cellData = cellToString(xcell);
						}
						
					}catch(Exception e)
						{
							//return "";
						}
	//}
			return cellData;
		
}


public static void getCellFrom_MultipleSheets(int rows, int col) throws IOException
{
	String cellDatas=null;
	try
	{
	FileInputStream file = new FileInputStream(new File("D://KeywordDriven-Selenium//src//dataEngineDriver//DataEngines.xlsx"));
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	int numberOfSheets = workbook.getNumberOfSheets();
	XSSFCell xcells;
	
	
	for (int i = 0; i < numberOfSheets; i++)
	 {
        XSSFSheet sheet = workbook.getSheetAt(i);
        Iterator rowIterator = sheet.iterator();
        while (rowIterator.hasNext())
        {
            Row row = (Row) rowIterator.next();
            if(row.getRowNum()==0)
            {
           	 continue;
            }	 
          /*  xcells = sheet.getRow(rows).getCell(col); 
            if(xcells.getStringCellValue()!=null && xcells.getStringCellValue().length() !=0)
			{
				//String cellDatas = xcell.getStringCellValue();
            	cellDatas = xcells.getStringCellValue();
            	 System.out.println("celldata is "+cellDatas);
			}*/
         
            System.out.println(row.getCell(rows));
            System.out.println(row.getCell(col));
	
        }
	 }
     file.close();
    
 }catch (Exception e) {
     e.printStackTrace();
 }
	
	
} 




public static String getCellFroms_MultipleSheets(int rows) throws IOException
{
	String cellDatas=null;
	try
	{
	FileInputStream file = new FileInputStream(new File("D://KeywordDriven-Selenium//src//dataEngineDriver//DataEngines.xlsx"));
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	int numberOfSheets = workbook.getNumberOfSheets();
	XSSFCell xcells;
	
	
	for (int i = 0; i < numberOfSheets; i++)
	 {
        XSSFSheet sheet = workbook.getSheetAt(i);
        System.out.println(sheet.getSheetName());
        Iterator rowIterator = sheet.iterator();
        while (rowIterator.hasNext())
        {
            Row row = (Row) rowIterator.next();
            System.out.println("row value is "+row.getRowNum());
            if(row.getRowNum()==0)
            {
           	 continue;
            }	 
            xcells = (XSSFCell) row.getCell(rows);
            if(xcells.getStringCellValue() != null && xcells.getStringCellValue().length()!=0)
            {
            	cellDatas = xcells.getStringCellValue();
            }
          /*  xcells = sheet.getRow(rows).getCell(col); 
            if(xcells.getStringCellValue()!=null && xcells.getStringCellValue().length() !=0)
			{
				//String cellDatas = xcell.getStringCellValue();
            	cellDatas = xcells.getStringCellValue();
            	 System.out.println("celldata is "+cellDatas);
			}*/
         
        //  System.out.println(row.getCell(rows));
          //  System.out.println(row.getCell(col));
	
        }
	 }
     file.close();
    
 }catch (Exception e) {
     e.printStackTrace();
 }
	return cellDatas;
	
} 




public static void getCell_FromMultipleSheets(int data) throws IOException
{
	String cellDatas=null;
	try
	{
	FileInputStream file = new FileInputStream(new File("D://KeywordDriven-Selenium//src//dataEngineDriver//DataEngines.xlsx"));
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	int numberOfSheets = workbook.getNumberOfSheets();
	XSSFCell xcells;
	
	
	for (int i = 0; i < numberOfSheets; i++)
	 {
        XSSFSheet sheet = workbook.getSheetAt(i);
        Iterator rowIterator = sheet.iterator();
        while (rowIterator.hasNext())
        {
            Row row = (Row) rowIterator.next();
            if(row.getRowNum()==0)
            {
           	 continue;
            }	 
          /*  xcells = sheet.getRow(rows).getCell(col); 
            if(xcells.getStringCellValue()!=null && xcells.getStringCellValue().length() !=0)
			{
				//String cellDatas = xcell.getStringCellValue();
            	cellDatas = xcells.getStringCellValue();
            	 System.out.println("celldata is "+cellDatas);
			}*/
         
            row.getCell(data);
          
	
        }
	 }
     file.close();
    
 }catch (Exception e) {
     e.printStackTrace();
 }
		
} 

public static String getCellDatamultiplesheets(Row row,int col, String sheetname)
{
	       String cellData=null;
	       XSSFSheet sheets = xworkbook.getSheet(sheetname);
//	       int rows = getRowCounts();
//	       for(int i=0;i<=rows;i++)
//	       {
//	    	  //sheets = xworkbook.getSheetAt(i);
	          System.out.println("Sheet name in getCellData method is " + sheets.getSheetName());
				try
					{
						//xcell = sheets.rowIterator().
							//	getRow(row.getCell(col);
						if(xcell.getStringCellValue()!=null && xcell.getStringCellValue().length() !=0)
						{
							//String cellDatas = xcell.getStringCellValue();
							cellData = cellToString(xcell);
						}
						
					}catch(Exception e)
						{
							//return "";
						}
	//}
			return cellData;
		
}





//This method is to get the row count used of the excel sheet
public static int getRowCounts()
{   
	int number=0;
	int numberofsheets = xworkbook.getNumberOfSheets();
	for(int i=0;i<=numberofsheets;i++)	
{
		try
		{
		XSSFSheet excelsheets = xworkbook.getSheetAt(i);
		System.out.println("Sheet name is   "+ excelsheets.getSheetName());
		number=excelsheets.getLastRowNum()-1;
		
		System.out.println("Number of row count of each sheetname:-  "+ excelsheets.getSheetName() +" is   "+ number);
		}catch(Exception e)
		{
			
		}
}
		return number;
	}

public static String getSheetNames()
{
	for(int i=0;i<xworkbook.getNumberOfSheets();i++)
	{
		xsheet = xworkbook.getSheetAt(i);
		System.out.println("Sheet Name from   "+ xsheet.getSheetName());
		
	}
	return xsheet.getSheetName();
}
	
	//Method to read Testdata from the ExcelSheet
	public static String getCellData(int row, int col, String sheetname[])
	{
		
		String cellData=null;
		for(int i=0;i<=sheetname.length;i++)
		{
		xsheet = xworkbook.getSheet(sheetname[i]);
		xcell = xsheet.getRow(row).getCell(col);
		try
		{
		if(xcell.getStringCellValue()!=null && xcell.getStringCellValue().length() !=0)
		{
			cellData = xcell.getStringCellValue();
		}
		
		}catch(Exception e)
		{
			return "";
		}	
		}
		System.out.println("the celldata are :=" + cellData);
	return cellData;
	
	}
	public static int getSheetRowCount(String Sheetname)
	{
		int rownumber = 0;
		XSSFSheet excelsheet = xworkbook.getSheet(Sheetname);
		try
		{
		rownumber =  excelsheet.getLastRowNum()-1;
		System.out.println("Number of rows of "+ xsheet.getSheetName() + "is :-" + rownumber);
		}catch(Exception e)
		{
			
		}
		 return rownumber;
	}	

	//method to read row number from the Excel
		public static int getSheetCount()
		{
			int rownumber = 0;
			int sheetcount =0;
		try
		{
			for(int i=0;i<=xworkbook.getNumberOfSheets();i++)
			{
			xsheet = xworkbook.getSheetAt(i);		
//			System.out.println("Sheet name is "+ xsheet.getSheetName());
//			rownumber =  xsheet.getLastRowNum()-1;
//			System.out.println("Number of rows of "+ xsheet.getSheetName() + "is :-" + rownumber);
			sheetcount++;
			
			}
		}	catch(Exception e)
				{
				}
			
			
			return sheetcount;
		}
		
		private static String cellToString(XSSFCell cell) {

			Object result;

			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				result = cell.getNumericCellValue();
				break;

			case Cell.CELL_TYPE_STRING:
				result = cell.getStringCellValue();
				break;

			case Cell.CELL_TYPE_BOOLEAN:
				result = cell.getBooleanCellValue();
				break;

			case Cell.CELL_TYPE_FORMULA:
				result = cell.getCellFormula();
				break;

			default:
				throw new RuntimeException("Unknown Cell Type");
			}

			return result.toString();
		}


		
		
		
		
		
	/*	public static int getRowContains(String TestcaseName, int colNum) throws Exception{
    		    int i=0;;		
    		    
    		    //String sheetname=getSheetNames();
    		    //xsheet = xworkbook.getSheet(getSheetNames());
    		 try
    		 {
    			int rowCount = ExcelReader.getRowCounts();
    			System.out.println("tow count under getRowContains method is " + rowCount);
    			for (i=0 ; i<rowCount; i++){
    			//	if  (ExcelReader.getCellData(i,colNum,SheetName).equalsIgnoreCase(sTestCaseName)){
    				if(ExcelReader.getCellData_multiplesheets(i, colNum).equalsIgnoreCase(TestcaseName))
    				{
    					break;
    				}
    			}
    		 }catch(Exception e)
    		 {
    			 
    		 }
    			return i;
    			}
		
		
		//This method is to get the count of the test steps of test case
		//This method takes three arguments (Sheet name, Test Case Id & Test case row number)
    	@SuppressWarnings("null")
		public static int getTestStepsCount(String TestcaseID, int iTestCaseStart) throws Exception{
    		int numbers=0;
    		for(int i=iTestCaseStart;i<=ExcelReader.getRowCounts();i++)
    		{
    			//if(!sTestCaseID.equals(ExcelUtils.getCellData(i, Constants.Col_TestCaseID, SheetName))){
    			if(!TestcaseID.equals(ExcelReader.getCellData_multiplesheets(i, constants.Col_TestCaseID)))
    			{
    				int number = i;
    				System.out.println("TestStepsCount are :- "+ number);
    				return number;
    			}
    		}
    		for(int k=0;k<=getSheetNames().length();k++)
    		{	
    		String sheetname[] = null;	
    		xsheet = xworkbook.getSheet(sheetname[k]);
			numbers = xsheet.getLastRowNum()+1;
    		}
    		return numbers;
    	}*/
}