package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import configs.constants;

public class readexcel {
	
	public static XSSFWorkbook xworkbook;
	public static XSSFCell xcell;
	public static XSSFSheet xsheet;
	
	public static String sactionwords;
	public static String sPageobjects;
	
	public static void main(String arg[]) throws IOException
	{
		readexcel re = new readexcel();
		getCellData_multiplesheets(1, 3);
		//System.out.println(data);

    	for(int row=1;row<=9;row++)
    	{
    		sactionwords = getCellData_multiplesheets(row, constants.Col_ActionKeywors);	
    		sPageobjects = getCellData_multiplesheets(row,constants.Col_PageObject);
    		System.out.println(sactionwords);
    		System.out.println(sPageobjects);
    	
	
}
	}
	
	
	//Method to read Testdata from the ExcelSheet
		public static String getCellData_multiplesheets(int row, int col) throws IOException
		{
			FileInputStream excelfile = new FileInputStream("D://KeywordDriven-Selenium//src//dataEngineDriver//DataEngines.xlsx");
			xworkbook = new XSSFWorkbook(excelfile);
			String cellData=null;
			for(int i=0;i<xworkbook.getNumberOfSheets();i++)
			{
			xsheet = xworkbook.getSheetAt(i);
			xcell = xsheet.getRow(row).getCell(col);
			System.out.println(xsheet.getSheetName());
			try
			{
				if(xcell.getStringCellValue() != null && xcell.getStringCellValue().length() !=0)
				{
					cellData = xcell.getStringCellValue();
					System.out.println(cellData);
				}
			}catch(Exception e)
			{
			
			}
		}
		return cellData;
		}
}
	


