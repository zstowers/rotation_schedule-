package schedule;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class ResidentDB {

    private Resident resident;
    private ArrayList<Resident> residentList;


    public static void createResidentTableFromFile(String fileName) {

        MasterDatabase masterDatabase = MasterDatabase.getInstance();
        HashMap<String, ArrayList<Resident>> residentMap = masterDatabase.getResidentMap();


        HSSFWorkbook workBook = Spreadsheet.getWorkBook(fileName);
        HSSFSheet workSheet = workBook.getSheetAt(0);
        Row beginningRow = CellUtil.getRow(0, workSheet);

        for (int sheetNum = 0; sheetNum < 4; sheetNum++) {

            ArrayList<Resident> residentTable = new ArrayList<Resident>();
            workSheet = workBook.getSheetAt(sheetNum);
            CellAddress begin = new CellAddress(2, 0);
            workSheet.setActiveCell(begin);
            int columnIndex = 0;

            String classYear = workSheet.getSheetName().substring(9);

            for (int rowIndex = 1; rowIndex < workSheet.getLastRowNum(); rowIndex++) {
                Row row = CellUtil.getRow(rowIndex, workSheet);
                Cell cell = CellUtil.getCell(row, columnIndex);
                if (!cell.getStringCellValue().equals("")) {
                    Resident resident = createNewResident(cell.getStringCellValue(), classYear);
                    residentTable.add(resident);
                }
                else
                    break;
            }

            if(residentMap.get(classYear) == null)
                residentMap.put(classYear, residentTable);
            else
                System.out.println("Are you sure you want to replace the resident table");

        }
    }


    public static Resident createNewResident(String residentName, String classYear) {
        String[] fullName = residentName.split(", ");
        Resident newResident = new Resident(fullName[1], fullName[0], classYear);
        return newResident;
    }


}