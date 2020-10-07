package executionEngine;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import configs.ActionKeywords;
import configs.constants;
import utility.ExcelReader;;


public class DriverScriptReflectionShiva {
	
	public static ActionKeywords actionkeywords ;
	public static String sactionkeywords;
	public static Method[] method;
	public static Properties pro;
	public static String sPageobject;
	
	public static int iTestStep;
	public static int iTestLastStep;
	public static String sTestCaseID;
	public static XSSFWorkbook xworkbook;
	public static XSSFCell xcell;
	public static XSSFSheet xsheet;
	public static int numbers=0;
				
		
	public static void main(String[] args) throws Exception 
	{
    	//ExcelReader.setExcelFile(constants.Path_Testdata);
    	
    	ExcelReader.setExcelFile(constants.Mindtree_Excel);
    	
    	//String Path_OR = constants.Objectrepo_Path;
    	String Path_OR = constants.Mindtree_Object_Path;
		FileInputStream fs = new FileInputStream(Path_OR);
		pro= new Properties(System.getProperties());
		pro.load(fs);
 
		DriverScriptReflectionShiva startEngine = new DriverScriptReflectionShiva();
		startEngine.execute_TestCaseSheet();
    }
	
	
	/*  private void execute_TestCase() throws Exception 
	  {
		  
			  int iTotalTestCases = ExcelReader.getRowCount();
		for(int iTestcase=1;iTestcase<=iTotalTestCases;iTestcase++)
		  {
				iTestStep = ExcelReader.getRowContains(sTestCaseID, constants.Col_TestCaseID);
				iTestLastStep = ExcelReader.getTestStepsCount(sTestCaseID, iTestStep);
				for (;iTestStep<=iTestLastStep;iTestStep++)
				{
		    		//sActionKeyword = ExcelUtils.getCellData(iTestStep, Constants.Col_ActionKeyword,Constants.Sheet_TestSteps);
		    		sactionkeywords = ExcelReader.getCellData_multiplesheets(iTestStep, constants.Col_ActionKeywors);
					//sPageObject = ExcelUtils.getCellData(iTestStep, Constants.Col_PageObject, Constants.Sheet_TestSteps);
		    		sPageobject = ExcelReader.getCellData_multiplesheets(iTestStep, constants.Col_PageObject);
		    		execute_Actions();
		    	}
			}
			  
	  }*/
	  
	  private void execute_TestCaseSheet() throws Exception 
	  {
		  
	  String cellData_keywords = null;
	  String cellData_PageObject=null;
		  try
			{
			FileInputStream file = new FileInputStream(new File(constants.Mindtree_Excel));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			int numberOfSheets = workbook.getNumberOfSheets();
			XSSFCell xcellskeyword;
			XSSFCell xcellspage;
			
		  
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
		            xcellspage = (XSSFCell) row.getCell(constants.Col_PageObject);
		            try
		            {
		            if(xcellspage.getStringCellValue() != null && xcellspage.getStringCellValue().length() != 0)
		            {
		            	
		            	cellData_PageObject = xcellspage.getStringCellValue();
		            }
		            }catch(Exception e) {}
		            
		          
					  sPageobject = cellData_PageObject;
					  System.out.println(sPageobject);
				
		            xcellskeyword = (XSSFCell) row.getCell(constants.Col_ActionKeywors);
		            if(xcellskeyword.getStringCellValue() != null && xcellskeyword.getStringCellValue().length() != 0)
		            {
		            	cellData_keywords = xcellskeyword.getStringCellValue();
		            	
		            }
		            sactionkeywords = cellData_keywords;
		            System.out.println(sactionkeywords);
		            
				 execute_Actions(); 
			

		        }
			 }
		     file.close();
		    
		 }catch (Exception e) {
		     e.printStackTrace();
		 }
	
		  
	  }	  
		  
		  
		/*  try
		  {
			  FileInputStream file = new FileInputStream(new File("D://KeywordDriven-Selenium//src//dataEngineDriver//DataEngines.xlsx"));
			  XSSFWorkbook workbook = new XSSFWorkbook(constants.Path_Testdata);

			   int numberOfSheets = workbook.getNumberOfSheets();

		         // Get first/desired sheet from the workbook
		        
				for (int i = 0; i < numberOfSheets; i++)
				 {
		             XSSFSheet sheet = workbook.getSheetAt(i);
		             Iterator rowIterator = sheet.iterator();

		         // Iterate through each rows one by one
		        // Iterator<Row> rowIterator = sheet.iterator();
		         while (rowIterator.hasNext())
		         {
		             Row row = (Row) rowIterator.next();

		             sactionkeywords = ExcelReader.getCellDatamultiplesheets(row, constants.Col_ActionKeywors,ExcelReader.getSheetNames());
		             System.out.println(sactionkeywords);
					    
					 
					 sPageobject = ExcelReader.getCellDatamultiplesheets(row, constants.Col_PageObject,ExcelReader.getSheetNames());
					 System.out.println(sPageobject);
					 execute_Actions(); 
		         }
				 }
			file.close();
		  }catch(Exception e)
		  {
		  }
	  }
			  
			  
			  
		/*	  
			 int sheetcount = ExcelReader.getSheetCount();
			 		for(int sheet=0;sheet<=sheetcount;sheet++)
			 			{
		
								int firstrowcount =1;// ExcelReader.getFirstrow();
								System.out.println("First row is :-" + firstrowcount);
								
								int lastrowcount = ExcelReader.getRowCounts();
								System.out.println("Last row is :-" + lastrowcount);
			
			for(;firstrowcount<=lastrowcount;firstrowcount++)
			{
				sactionkeywords = ExcelReader.getCellData_multiplesheets(firstrowcount, constants.Col_ActionKeywors,ExcelReader.getSheetNames());
			    System.out.println(sactionkeywords);
			    
			 
				sPageobject = ExcelReader.getCellData_multiplesheets(firstrowcount, constants.Col_PageObject,ExcelReader.getSheetNames());
				System.out.println(sPageobject);
				execute_Actions(); 	
			    
			}
				/*  sTestCaseID = ExcelReader.getCellData_multiplesheets(sheet, constants.Col_TestCaseID);
				  iTestStep = ExcelReader.getRowContains(sTestCaseID, constants.Col_TestCaseID);
				  iTestLastStep = ExcelReader.getTestStepsCount(sTestCaseID, iTestStep);
				  		for(;iTestStep<=iTestLastStep;iTestStep++)		  
				  			{			
			//sActionKeyword = ExcelUtils.getCellData(iTestStep, Constants.Col_ActionKeyword,Constants.Sheet_TestSteps);
				  				sactionkeywords = ExcelReader.getCellData_multiplesheets(iTestStep, constants.Col_ActionKeywors);
		    System.out.println(sactionkeywords);
			//sPageObject = ExcelUtils.getCellData(iTestStep, Constants.Col_PageObject, Constants.Sheet_TestSteps);
		    					sPageobject = ExcelReader.getCellData_multiplesheets(iTestStep, constants.Col_PageObject);
		    System.out.println(sPageobject);
		    execute_Actions();  	
				  			}
			}	
		  }catch(Exception e)
		  {
		  }  
	  }*/
	  
	  private static void execute_Actions() throws Exception 
	  {
		    actionkeywords = new ActionKeywords();
			Class actionwordspage = ActionKeywords.class;
			method = actionwordspage.getMethods();
			for(int i=0;i< method.length;i++)
			{
				if(method[i].getName().equals(sactionkeywords))
				{
					method[i].invoke(actionkeywords,sPageobject);
					break;
				}
			}
	  }
	  
	  
}		

	