package API.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelFile {

    public static FileInputStream inputstream;
    public static XSSFWorkbook workbook;
    public static XSSFSheet excelSheet;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static String getCellValue(String filename, String sheetName, int rowNo, int cellNo)  {

        try {
            inputstream = new FileInputStream(filename);
            workbook = new XSSFWorkbook(inputstream);
            excelSheet = workbook.getSheet(sheetName);
            cell = workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);

            workbook.close();
            return cell.getStringCellValue();


        } catch (Exception e) {
            return "";
        }

    }
    public static int getColCount(String fileName, String sheetName){

        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
            XSSFSheet excelSheet = workBook.getSheet(sheetName);

            int ttlcells = excelSheet.getRow(0).getLastCellNum();

            workBook.close();
            return ttlcells;

        } catch (Exception e){
            return 0;
        }

    }


    public static int getRowCount(String fileName, String sheetName){

        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
            XSSFSheet excelSheet = workBook.getSheet(sheetName);

            int ttlRows =  excelSheet.getLastRowNum() + 1;
            workBook.close();
            return ttlRows;
        }catch (Exception e){
            return 0;

        }


    }
}
