package utility;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ReadFileExcel {

    private static final String FILE_PATH = "D://KeywordDriven-Selenium//src//dataEngineDriver//DataEngines.xlsx";

    public static void main(String args[]) {

        List studentList = getStudentsListFromExcel();

        System.out.println(studentList);
    }

    private static List getStudentsListFromExcel() {
        List studentList = new ArrayList();
        FileInputStream fis = null;
        String cellValue=null;
        
        try {
            fis = new FileInputStream(FILE_PATH);

            // Using XSSF for xlsx format, for xls use HSSF
            Workbook workbook = new XSSFWorkbook(fis);
            DataFormatter dataFormatter = new DataFormatter();

            int numberOfSheets = workbook.getNumberOfSheets();

            //looping over each workbook sheet
            for (int i = 0; i < numberOfSheets; i++) {
                Sheet sheet = workbook.getSheetAt(i);
                Iterator rowIterator = sheet.iterator();

                
                //iterating over each row
                while (rowIterator.hasNext())
                {

              //      Student student = new Student();
                    Row row = (Row) rowIterator.next();
                    Iterator cellIterator = row.cellIterator();

                    //Iterating over each cell (column wise)  in a particular row.
                    while (cellIterator.hasNext()) 
                    {
                    	Cell cell = (Cell) cellIterator.next();
                         cellValue = dataFormatter.formatCellValue(cell);
                        System.out.print(cellValue + "\n");
                    }

                        /*Cell cell = (Cell) cellIterator.next();
                        //The Cell Containing String will is name.
                        if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
                        	  System.out.println((cell.getStringCellValue());

                            //The Cell Containing numeric value will contain marks
                        } else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {

                            //Cell with index 1 contains marks in Maths
                            if (cell.getColumnIndex() == 1) {
                                System.out.println((cell.getNumericCellValue()));
                            }
                            //Cell with index 2 contains marks in Science
                            else if (cell.getColumnIndex() == 2) {
                            	  System.out.println((cell.getNumericCellValue()));
                            }
                            //Cell with index 3 contains marks in English
                            else if (cell.getColumnIndex() == 3) {
                            	  System.out.println((String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                    }*/
                    //end iterating a row, add all the elements of a row in list
                    studentList.add(cellValue);
                }
            }

            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }


}
