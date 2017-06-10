/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seedsv1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Irwansyah
 */
public class ExcelData{
    
//    public void readXLSFile(String _location) throws IOException {
//        InputStream ExcelFileToRead = new FileInputStream(_location);
//        HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
//
//        HSSFSheet sheet = wb.getSheetAt(0);
//        HSSFRow row;
//        HSSFCell cell;
//
//        Iterator rows = sheet.rowIterator();
//
//        while (rows.hasNext()) {
//            row = (HSSFRow) rows.next();
//            Iterator cells = row.cellIterator();
//
//            while (cells.hasNext()) {
//                cell = (HSSFCell) cells.next();
//
//                if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
//                    System.out.print(cell.getStringCellValue() + " ");
//                } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
//                    System.out.print(cell.getNumericCellValue() + " ");
//                } else {
//                    //U Can Handel Boolean, Formula, Errors
//                }
//            }
//            System.out.println();
//        }
//
//    }
//
//    public void writeXLSFile(String _location, String _sheetName) throws IOException {
//
//        String excelFileName = _location;//name of excel file
//
//        String sheetName = _sheetName;//name of sheet
//
//        HSSFWorkbook wb = new HSSFWorkbook();
//        HSSFSheet sheet = wb.createSheet(sheetName);
//
//        //iterating r number of rows
//        for (int r = 0; r < 5; r++) {
//            HSSFRow row = sheet.createRow(r);
//
//            //iterating c number of columns
//            for (int c = 0; c < 5; c++) {
//                HSSFCell cell = row.createCell(c);
//
//                cell.setCellValue("Cell " + r + " " + c);
//            }
//        }
//        try (FileOutputStream fileOut = new FileOutputStream(excelFileName)) {
//            wb.write(fileOut);
//            fileOut.flush();
//        }
//    }

    public ArrayList<ArrayList> readXLSXFile(String _location) throws IOException {
        InputStream ExcelFileToRead = new FileInputStream(_location);
        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row;
        XSSFCell cell;

        Iterator rows = sheet.rowIterator();
        ArrayList<ArrayList> dataRows = new ArrayList<>();
        
        while (rows.hasNext()) {
            row = (XSSFRow) rows.next();
            Iterator cells = row.cellIterator();
            @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
            ArrayList<String> dataCells = new ArrayList<>();
            
            while (cells.hasNext()) {
                cell = (XSSFCell) cells.next();

                if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                    dataCells.add(cell.getStringCellValue());
                } else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
                    dataCells.add(cell.getNumericCellValue()+"");
                } else {
                    //U Can Handel Boolean, Formula, Errors
                }
            }
            dataRows.add(dataCells);
        }
        
        return dataRows;
    }

//    public void writeXLSXFile(String _location, String _sheetName) throws IOException {
//
//        String excelFileName = _location;//name of excel file
//
//        String sheetName = _sheetName;//name of sheet
//
//        XSSFWorkbook wb = new XSSFWorkbook();
//        XSSFSheet sheet = wb.createSheet(sheetName);
//
//        //iterating r number of rows
//        for (int r = 0; r < 5; r++) {
//            XSSFRow row = sheet.createRow(r);
//
//            //iterating c number of columns
//            for (int c = 0; c < 5; c++) {
//                XSSFCell cell = row.createCell(c);
//
//                cell.setCellValue("Cell " + r + " " + c);
//            }
//        }
//        try (FileOutputStream fileOut = new FileOutputStream(excelFileName)) {
//            wb.write(fileOut);
//            fileOut.flush();
//        }
//    }
}
