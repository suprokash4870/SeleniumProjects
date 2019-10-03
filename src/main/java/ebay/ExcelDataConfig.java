package ebay;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelDataConfig {

    XSSFWorkbook wb;
    XSSFSheet sheet;

    public ExcelDataConfig(String excelPath) throws IOException {
        File src = new File(excelPath);
        try {
            FileInputStream fis = new FileInputStream(src);
             wb = new XSSFWorkbook(fis);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getData(int sheetNumber,int row,int column){

       sheet = wb.getSheetAt(sheetNumber);
       String data = sheet.getRow(row).getCell(column).getStringCellValue();

        return data;
    }

    public int getRowCount(int sheetIndex){
        int row = wb.getSheetAt(sheetIndex).getLastRowNum();
        row++;
        return row;
    }

}
