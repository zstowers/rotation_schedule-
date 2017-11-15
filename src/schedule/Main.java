package schedule;

import java.io.IOException;


public class Main {

    private static final String REPORT_FILE_NAME = "C:\\Users\\zstow\\Documents\\AshlieApplication\\rotations_report.xls";
    private static final String SCHEDULE_FILE_NAME = "C:\\Users\\zstow\\Documents\\AshlieApplication\\17-18_schedule.xls";
    private static MasterStorage masterStorage;

    public static void main(String[] args) throws IOException {

        //Create the storage
        masterStorage = new MasterStorage();


        //Initialize yearly calendars
        YearlyStorage.createNewSchedule("2017", masterStorage);
        YearlyStorage.createNewSchedule("2018", masterStorage);
        YearlyStorage.createNewSchedule("2019", masterStorage);
        YearlyStorage.createNewSchedule("2020", masterStorage);



        ResidentDB residentDB = new ResidentDB();
        Spreadsheet residentSheet = new Spreadsheet(REPORT_FILE_NAME);

        //1. Import residents
        residentSheet.importResidents();
        //Store residents in DB

        //2. initialize rotation list
        RotationSchedule rotationSchedule = new RotationSchedule();
        // Store rotation list in DB

        //3. initialize yearly calendars

        //Store yearly calendars in DB

        //4. Import and parse excel

    }
}

/*
    }


	// File is < 2003 excel, work with HSSF
	//	Spreadsheet spreadsheet = new Spreadsheet("C:\\Users\\zstow\\Documents\\AshlieApplication\\files\\17-18_schedule.xls");
	//	String[] columns = spreadsheet.getColumnNames();
		/*
		MasterStorage masterStorage = new MasterStorage();
		YearlyStorage.createNewSchedule("2013", masterStorage);
		YearlyStorage.createNewSchedule("2014", masterStorage);
		YearlyStorage.createNewSchedule("2015", masterStorage);
		YearlyStorage.createNewSchedule("2016", masterStorage);
		YearlyStorage.createNewSchedule("2017", masterStorage);
		YearlyStorage.createNewSchedule("2018", masterStorage);
		YearlyStorage.createNewSchedule("2019", masterStorage);
		YearlyStorage.createNewSchedule("2020", masterStorage);

		masterStorage.printSummary();
		*/
