package utility;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Vector;
 
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

 

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
 
 
public class bbb {
 
	public static XSSFSheet mySheet;
 
public static void main( String [] args ) {
 
    String fileName="D://KeywordDriven-Selenium//src//dataEngineDriver//DataEngines.xlsx";
    //Read an Excel File and Store in a Vector
    Vector dataHolder=readExcelFile(fileName);
    //Print the data read
    printCellDataToConsole(dataHolder);
}
public static Vector readExcelFile(String fileName)
{
    /** --Define a Vector
        --Holds Vectors Of Cells
     */
    Vector cellVectorHolder = new Vector();
 
    try{
    /** Creating Input Stream**/
    //InputStream myInput= ReadExcelFile.class.getResourceAsStream( fileName );
    FileInputStream myInput = new FileInputStream(fileName);
 
    /** Create a POIFSFileSystem object**/
  //  POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
 
    /** Create a workbook using the File System**/
     XSSFWorkbook myWorkBook = new XSSFWorkbook(myInput);
 
     /** Get the first sheet from workbook**/
     try
     {
     for(int i=0;i<=myWorkBook.getNumberOfSheets();i++)
     {
     mySheet = myWorkBook.getSheetAt(i);
     System.out.println(mySheet.getSheetName());
     }
     }catch(Exception e)
     {
    	 
     }
    /** We now need something to iterate through the cells.**/
      Iterator rowIter = mySheet.rowIterator();
 
      while(rowIter.hasNext()){
          XSSFRow myRow = (XSSFRow) rowIter.next();
          if (myRow.getCell(0) != null){
          Iterator cellIter = myRow.cellIterator();
          Vector cellStoreVector=new Vector();
          while(cellIter.hasNext()){
              XSSFCell myCell = (XSSFCell) cellIter.next();
              cellStoreVector.addElement(myCell);
          }
          cellVectorHolder.addElement(cellStoreVector);
          }
      }
    }catch (Exception e){e.printStackTrace(); }
    return cellVectorHolder;
}
 
private static void printCellDataToConsole(Vector dataHolder) {
 
    for (int i=0;i<dataHolder.size(); i++){
               Vector cellStoreVector=(Vector)dataHolder.elementAt(i);
        for (int j=0; j < cellStoreVector.size();j++){
            XSSFCell myCell = (XSSFCell)cellStoreVector.elementAt(j);
            String stringCellValue = myCell.toString();
            System.out.print(stringCellValue+"\t");
        }
        System.out.println();
    }
}
 
}
