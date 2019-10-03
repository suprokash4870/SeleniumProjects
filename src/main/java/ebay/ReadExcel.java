package ebay;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {
    public static void main(String[] args) throws IOException {
        File src = new File("C:\\Users\\SSANYALASHOK\\Desktop\\EbayTestData.xlsx");
        try {
            FileInputStream fis = new FileInputStream(src);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet("RegData");
            int rowcount = sheet.getLastRowNum();
            System.out.println("Total number of row is " + rowcount);
            //int colcount = sheet.getRow(0).getLastCellNum();
            //System.out.println("Total number of column is "+colcount);
            for (int i = 1; i <= rowcount; i++) {
                String str = sheet.getRow(i).getCell(0).getStringCellValue();
                System.out.println("Data from Excel is " + str);
                wb.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}


