package schedule;

import java.io.IOException;
import java.util.ArrayList;


public class Main {

    private static final String REPORT_FILE_NAME = "C:\\Users\\zstow\\Documents\\AshlieApplication\\rotations_report.xls";
    private static final String SCHEDULE_FILE_NAME = "C:\\Users\\zstow\\Documents\\AshlieApplication\\17-18_schedule.xls";
    private static MasterDatabase masterDatabase;
    private static ArrayList<Block> blocks;
    private static String year = "2017-2018";


    public static void main(String[] args) throws IOException {

        //Create the storage
        masterDatabase = MasterDatabase.getInstance();





        // Import residents and store residents in DB
        //Creates hashmap entries of all residents in the excel file.  Key is class year and value is arraylist
        //of residents
        Resident.createResidentTableFromFile(REPORT_FILE_NAME);


        // Import and parse excel rotation schedule file
        //Creates a new hashmap entry of a block table with a key = year and value = arraylist of blocks
        //Use the year, block names, and dates to create instances of a block for each rotation
        Block.createBlockTableFromFile(SCHEDULE_FILE_NAME);


        //Initializes a yearly schedule.  Key is year and value is an ArrayList of Schedule Entries.
        // Schedule entry contains the rotation name as well as an ArrayList consisting of each block for
        // that yar
        RotationSchedule.createRotationWithBlocks(year);


        //Parse the rest of the excel file
        ScheduleEntry.fillBlocks(year,SCHEDULE_FILE_NAME);








    }
}

/*
    }


	// File is < 2003 excel, work with HSSF
	//	Spreadsheet spreadsheet = new Spreadsheet("C:\\Users\\zstow\\Documents\\AshlieApplication\\files\\17-18_schedule.xls");
	//	String[] columns = spreadsheet.getColumnNames();
		/*

		*/
