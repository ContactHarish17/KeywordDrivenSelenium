package executionEngine;

import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import configs.ActionKeywords;
import configs.constants;
import utility.AbcExcelUtils;

public class DriverScriptReflection {
	
	public static ActionKeywords actionkeywords ;
	public static String sactionkeywords;
	public static Method[] method;
	public static Properties pro;
	public static String sPageobject;
	
	
	
	public static void main(String[] args) throws Exception
	{
		String sPath = constants.Path_Testdata;

    	// Here we are passing the Excel path and SheetName as arguments to connect with Excel file 
    	AbcExcelUtils.setExcelFile(sPath, constants.Sheet_TestSteps);
    	
    	String Path_OR = constants.Objectrepo_Path;
    	FileInputStream fileOR = new FileInputStream(Path_OR);
    	pro = new Properties(System.getProperties());
    	pro.load(fileOR);
    	
    	
    	for(int row=1;row<=9;row++)
    	{
    		sactionkeywords = AbcExcelUtils.getCellData(row, constants.Col_ActionKeywors);	
    		sPageobject = AbcExcelUtils.getCellData(row,constants.Col_PageObject);
    		execute_method();
    	}
		}



	private static void execute_method() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
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
