package ebay;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class WriteToExcel {
    public static void main(String[] args) throws IOException {
        File src = new File("C:\\Users\\SSANYALASHOK\\Desktop\\EbayTestData.xlsx");
        try {
            FileInputStream fis = new FileInputStream(src);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet("RegData");
            sheet.getRow(0).createCell(4).setCellValue("Pass/Fail");
            FileOutputStream fos = new FileOutputStream(src);
            wb.write(fos);
            wb.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

