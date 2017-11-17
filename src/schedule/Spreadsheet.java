package schedule;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Spreadsheet {


    //private HSSFWorkbook workBook;
//    private HSSFSheet worksheet;
//    private HSSFRow row;
//    private HSSFCell cell;
//    public File file;
//    private FileInputStream inputStream;
//      private String fileName;

    public Spreadsheet() throws IOException {
//            this.fileName = fileName;
    }

    public static HSSFWorkbook getWorkBook(String fileName) {

        File file = new File(fileName);
        HSSFWorkbook workBook = null;

        try {
            FileInputStream inputStream = new FileInputStream(file);
            workBook = new HSSFWorkbook(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return workBook;
    }


    public void createResident(String residentName, String classYear) {

        String[] fullName = residentName.split(", ");
        Resident newResident = new Resident(fullName[1], fullName[0], classYear);

    }



}
