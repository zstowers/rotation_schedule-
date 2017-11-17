package schedule;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;

import java.util.ArrayList;

public class Block {

    public static final int NUMBLOCKS = 13;
    private String blockName;
    private String startDate;
    private String endDate;
    private String year;
    private ArrayList<Resident> residents;



    public Block(String blockName, String startDate, String endDate, String year) {

        this.blockName = blockName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.year = year;
        this.residents = new ArrayList<Resident>();
    }

    public static void createBlockTableFromFile(String fileName) {

        ArrayList<Block> blockTable = new ArrayList<Block>();
        MasterDatabase masterDatabase = MasterDatabase.getInstance();

        HSSFWorkbook workBook = Spreadsheet.getWorkBook(fileName);
        HSSFSheet workSheet = workBook.getSheetAt(0);
        Row beginningRow = CellUtil.getRow(0, workSheet);

        String scheduleYear = CellUtil.getCell(beginningRow, 0).getStringCellValue();

        Row dateRow = CellUtil.getRow(1, workSheet);

        for(int i = 1; i < beginningRow.getLastCellNum(); i++) {
            String blockName = CellUtil.getCell(beginningRow, i).getStringCellValue();
            String dateRange = CellUtil.getCell(dateRow, i).getStringCellValue();
            String[] dates = dateRange.split(" - ");
            Block newBlock = new Block(blockName, dates[0], dates[1], scheduleYear );
            blockTable.add(newBlock);
        }

        masterDatabase.getBlockMap().put(scheduleYear, blockTable);
      //  return blockTable;
    }


    public String getBlockName() {
        return this.blockName;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public String getYear() {
        return this.year;
    }







}