package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

//import statements

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import configs.constants;


public class POIforgfgRead 
{
	
    XSSFCell xcells;
    DataFormatter dataFormatter = new DataFormatter();
    static XSSFSheet sheet;
    static Row row;
    
public static void main(String[] args) throws Exception
 {
	POIforgfgRead pr;
	try
	{
	String cells = getCellFroms_MultipleSheets(constants.Col_ActionKeywors);
		System.out.println(cells);
	}catch(Exception e)
	{}
	 
	  
      
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

	
	
 }    
        
             
             /*    xcells = (XSSFCell) row.getCell(3);
             if(xcells.getStringCellValue()!=null && xcells.getStringCellValue().length() !=0)
  			{
  				String cellDatas = xcells.getStringCellValue();
              	//cellDatas = xcells.getStringCellValue();
              	System.out.println("celldata is "+cellDatas);
  			} 	
            xcells = sheet.getRow(3).getCell(constants.Col_ActionKeywors); 
             if(xcells.getStringCellValue()!=null && xcells.getStringCellValue().length() !=0)
 			{
 				//String cellDatas = xcell.getStringCellValue();
             	cellDatas = xcells.getStringCellValue();
             	 System.out.println("celldata is "+cellDatas);
 			}*/
            // if(row.getCell(3).getStringCellValue()!=null && row.getCell(3).getStringCellValue().length() !=0)
            // {
            // String cellDatas = row.getCell(3).getStringCellValue();
             //}
             //System.out.println("celldata is "+cellDatas);
              //   System.out.println("Column Three values is :="+ row.getCell(3));
                // System.out.println("Column Four values is := "+row.getCell(constants.Col_ActionKeywors));
                 
          

