package utility;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ReadExcelFileExample {
	
	public static final String SAMPLE_XLSX_FILE_PATH = "D://KeywordDriven-Selenium//src//dataEngineDriver//DataEngines.xlsx";
	 public static Workbook workbook;
	 public static Sheet sheet;
    public static void main(String[] args) throws Exception {

        // Creating a Workbook from an Excel file (.xls or .xlsx)
       workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
        
        
     // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

        /*
           =============================================================
           Iterating over all the sheets in the workbook (Multiple ways)
           =============================================================
        */

        // 1. You can obtain a sheetIterator and iterate over it
       
        /*
        ==================================================================
        Iterating over all the rows and columns in a Sheet (Multiple ways)
        ==================================================================
     */

     // Getting the Sheet at index zero
     int sheets = getSheetNames();

     for(int i=0;i<=sheets;i++)
     {
     // Create a DataFormatter to format and get each cell's value as String
     DataFormatter dataFormatter = new DataFormatter();

     // 1. You can obtain a rowIterator and columnIterator and iterate over them
     System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
     Iterator<Row> rowIterator = sheet.rowIterator();
     
     while (rowIterator.hasNext()) {
         Row row = rowIterator.next();

         // Now let's iterate over the columns of the current row
         Iterator<Cell> cellIterator = row.cellIterator();

         while (cellIterator.hasNext()) {
             Cell cell = cellIterator.next();
             String cellValue = dataFormatter.formatCellValue(cell);
             System.out.print(cellValue + "\t");
         }
         System.out.println();
     }
     }
    }
    
    
    public static int getSheetNames() throws Exception
    {
    	int sheetcount=0;
    Iterator<Sheet> sheetIterator = workbook.sheetIterator();
    System.out.println("Retrieving Sheets using Iterator");
    while (sheetIterator.hasNext())
    {
        Sheet sheet = sheetIterator.next();
        System.out.println("=> " + sheet.getSheetName());
        sheetcount++;
    }
	return sheetcount;
    
    } 
}
