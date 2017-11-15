package schedule;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class Spreadsheet {



    private HSSFWorkbook workbook;
    private HSSFSheet worksheet;
    private HSSFRow row;
    private HSSFCell cell;
    private File file;
    private FileInputStream inputStream;



    public Spreadsheet(String fileName) throws IOException {
        this.file = new File(fileName);
        this.inputStream = new FileInputStream(file);
        this.workbook = new HSSFWorkbook(inputStream);
    }


    public void importResidents() {

        // int numberOfSheets = workbook.getNumberOfSheets();

        for(int sheetNum = 0; sheetNum < 4; sheetNum++) {

            this.worksheet = workbook.getSheetAt(sheetNum);
            CellAddress begin = new CellAddress(2, 0);
            worksheet.setActiveCell(begin);
            int columnIndex = 0;

            String classYear = worksheet.getSheetName().substring(9);

            for (int rowIndex = 2; rowIndex < worksheet.getLastRowNum(); rowIndex++) {
                Row row = CellUtil.getRow(rowIndex, worksheet);
                Cell cell = CellUtil.getCell(row, columnIndex);
                if (cell.getStringCellValue() == "")
                    break;
                //  System.out.println(cell.getStringCellValue());
                createResident(cell.getStringCellValue(), classYear);

            }
        }

    }


    public void createResident(String residentName, String classYear) {

        String[] fullName = residentName.split(", ");
        Resident newResident = new Resident(fullName[1], fullName[0], classYear);

    }





}