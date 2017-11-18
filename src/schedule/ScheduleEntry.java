package schedule;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
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
        String rotationName;
        HSSFWorkbook workBook = Spreadsheet.getWorkBook(fileName);
        HSSFSheet workSheet = workBook.getSheetAt(0);
        ScheduleEntry newEntry = null;

        int count = 0;
        for(int rowIndex = 2; rowIndex < workSheet.getLastRowNum(); rowIndex++) {
            Row row = workSheet.getRow(rowIndex);

            if(!CellUtil.getCell(row,0).getStringCellValue().equals("")) {
                rotationName = CellUtil.getCell(row, 0).getStringCellValue();
                newEntry = currentYearEntries.get(count);
                if(!rotationName.equals(newEntry.getRotationName()))
                    System.out.println("Rotation names not equal, handle this");
                count++;
            }


            
            for(int columnIndex = 1; columnIndex < row.getLastCellNum(); columnIndex++) {
                Cell currentCell = CellUtil.getCell(row, columnIndex);
               // Block block = newEntry.getBlocks().get(columnIndex - 1);
                if(currentCell.getStringCellValue().equals(""))
                    continue;
                else {
                    String residentLastName = CellUtil.getCell(row, columnIndex).getStringCellValue();
                    String yearAssigned = getYearAssigned(currentCell, workBook);
                    ResidentBlockEntry blockEntry = new ResidentBlockEntry(residentLastName, yearAssigned);
                    newEntry.getBlocks().get(columnIndex - 1).addResident(blockEntry);
                }
            }

        }




    }

    private static String getYearAssigned(Cell currentCell, HSSFWorkbook workBook) {


        HSSFCell hssfCell = (HSSFCell)currentCell;
        HSSFCellStyle cellStyle = hssfCell.getCellStyle();
        HSSFFont font = cellStyle.getFont(workBook);
        short color = font.getColor();

        switch(color) {
            case 39:         //blue
                return "CA 2";
            case 12:        //blue
                return "CA 2";
            case 17:        //green
                return "CA 3";
            case 30:        //blue
                return "CA 2";
            case 10:        //red
                return "CA 1";
            case 19:        //green
                return "CA 3";
            case 62:
                return "off cycle";
            case 32767:
                return "blank cell";
            default:
                System.out.println("Color is " + color);
                return "unknown, need to find it";

        }


    }


}
