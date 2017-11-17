package schedule;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;

import java.util.ArrayList;

public class ScheduleEntry {

    private String rotationName;
    private ArrayList<Block> blocks;

    public ScheduleEntry(String rotationName, ArrayList<Block> blocks) {
        this.rotationName = rotationName;
        this.blocks = blocks;
    }

    public String getRotationName() {
        return this.rotationName;
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public static void fillBlocks(String year, String fileName) {
        MasterDatabase masterDatabase = MasterDatabase.getInstance();
        ArrayList<ScheduleEntry> currentYearEntries = masterDatabase.getScheduleByYearMap().get(year);
        String rotationName = "";
        HSSFWorkbook workBook = Spreadsheet.getWorkBook(fileName);
        HSSFSheet workSheet = workBook.getSheetAt(0);

        int count = 0;
        for(int rowIndex = 2; rowIndex < workSheet.getLastRowNum(); rowIndex++) {
            Row row = workSheet.getRow(rowIndex);

            if(!CellUtil.getCell(row,0).getStringCellValue().equals("")) {
                System.out.println(currentYearEntries.get(count).getRotationName());
                rotationName = CellUtil.getCell(row, 0).getStringCellValue();
                if(!rotationName.equals(currentYearEntries.get(count).getRotationName()))
                    System.out.println("Rotation names not equal, handle this");
                System.out.println(rotationName + ":");
                count++;
            }


            
            for(int columnIndex = 1; columnIndex < row.getLastCellNum(); columnIndex++) {
                //System.out.println(CellUtil.getCell(row, columnIndex).getStringCellValue());
                continue;
            }

        }




    }


}
