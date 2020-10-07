package executionEngine;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.WebDriverWait;

import configs.ActionKeywords;
import configs.ExcelAction;
import configs.constants;
import utility.ExcelReader;;


public class DriverscriptEngine {
	
	public static ExcelAction excelactionkeywords ;
	public static String sactionkeywords;
	public static Method[] method;
	public static Properties pro;
	public static String sPageobject;
	public static String sArguments;
	
	public static int iTestStep;
	public static int iTestLastStep;
	public static String sTestCaseID;
	public static XSSFWorkbook xworkbook;
	public static XSSFCell xcell;
	public static XSSFSheet xsheet;
	public static int numbers=0;
	DataFormatter formatter = new DataFormatter();
	
				
		
	public static void main(String[] args) throws Exception 
	{
    	//ExcelReader.setExcelFile(constants.Path_Testdata);
    	
    	ExcelReader.setExcelFile(constants.TH_Excel);
    	
    	//String Path_OR = constants.Objectrepo_Path;
    	String Path_OR = constants.Mindtree_Object_Path;
		FileInputStream fs = new FileInputStream(Path_OR);
		pro= new Properties(System.getProperties());
		pro.load(fs);
 
		DriverscriptEngine startEngine = new DriverscriptEngine();
		startEngine.execute_TestCaseSheet();
    }
	
	
	  
	  private void execute_TestCaseSheet() throws Exception 
	  {
		  
	  String cellData_keywords = null;
	  String cellData_PageObject=null;
	  String cellData_Arguments=null;
		  try
			{
			FileInputStream file = new FileInputStream(new File(constants.TH_Excel));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			int numberOfSheets = workbook.getNumberOfSheets();
			XSSFCell xcellskeyword;
			XSSFCell xcellspage;
			XSSFCell xcellarguments;
			
		  
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
		            //getting the pageobjects values from the excel
		            xcellspage = (XSSFCell) row.getCell(constants.Col_PageObject);
		          
		            try
		            {
		            if(xcellspage.getStringCellValue() != null && xcellspage.getStringCellValue().length() != 0 )
		            {
		            	
		            	cellData_PageObject = xcellspage.getStringCellValue();
		            }
		            }catch(Exception e) {}
		            	sPageobject = cellData_PageObject;
		            	System.out.println("Page Object called :- "+sPageobject);
		            	
		          //getting the arguments passed to action keywords from excel.
		            	
		          try
				  { 
		          xcellarguments = (XSSFCell) row.getCell(constants.Col_Argument);
		          if(xcellarguments !=null)
		          { 
		          xcellarguments.setCellType(Cell.CELL_TYPE_STRING);
		          }
		          System.out.println("the Argument Cell value is :=" + xcellarguments.getStringCellValue());
			     
			      if(xcellarguments.getStringCellValue() != null && xcellarguments.getStringCellValue().length() != 0)
			      	{
				        cellData_Arguments = xcellarguments.getStringCellValue();
			        }
			      }catch(Exception e) {}
			            	sArguments = cellData_Arguments;
			            	System.out.println("Argument pased :- "+ sArguments);
			     	
		            	
		            	
				
		            // getting the action keywords from excel	
		            xcellskeyword = (XSSFCell) row.getCell(constants.Col_ActionKeywors);
		            if(xcellskeyword.getStringCellValue() != null && xcellskeyword.getStringCellValue().length() != 0)
		            {
		            	cellData_keywords = xcellskeyword.getStringCellValue();
		            	
		            }
		            sactionkeywords = cellData_keywords;
		            System.out.println("Actionkeyword called is :- "+ sactionkeywords);
		            
		                  
		            execute_Actions(); 
			

		        }
			 }
		     file.close();
		    
		 }catch (Exception e) {
		     
		 }
	
		  
	  }	  
		  
		  
			  
	  private static void execute_Actions() throws Exception 
	  {
		  try
		  {
		    excelactionkeywords = new ExcelAction();
			Class actionwordspage = ExcelAction.class;
			method = actionwordspage.getMethods();
			for(int i=0;i< method.length;i++)
			{
				if(method[i].getName().equals(sactionkeywords))
				{
					method[i].invoke(excelactionkeywords,sPageobject,sArguments);
					break;
				}
			}
		  }catch(Exception e)
		  {
			  
		  }
	  }
	  
	  
}		

	