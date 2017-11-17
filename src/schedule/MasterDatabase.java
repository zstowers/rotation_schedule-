package schedule;

import java.util.ArrayList;
import java.util.HashMap;

public class MasterDatabase {



    private static MasterDatabase masterDatabase = null;
    private HashMap<String, ArrayList<Block>> blockMap;
    private HashMap<String, ArrayList<Resident>> residentMap;
    private RotationSchedule rotationSchedule;
    private HashMap<String, ArrayList<ScheduleEntry>> scheduleByYearMap;



    public static MasterDatabase getInstance() {
        if(masterDatabase == null)
            masterDatabase = new MasterDatabase();
        return masterDatabase;
    }

    private MasterDatabase() {
        this.blockMap = new HashMap<String, ArrayList<Block>>();
        this.residentMap = new HashMap<String, ArrayList<Resident>>();
        this.rotationSchedule = new RotationSchedule();
        this.scheduleByYearMap = new HashMap<String, ArrayList<ScheduleEntry>>();
    }


    public void addToscheduleByYearMap(String year, ArrayList<ScheduleEntry> scheduleEntries) {
        this.scheduleByYearMap.put(year, scheduleEntries);
    }

    public HashMap<String, ArrayList<Block>> getBlockMap() {
        return this.blockMap;
    }

    public HashMap<String, ArrayList<Resident>> getResidentMap() {
        return this.residentMap;
    }

    public HashMap<String, ArrayList<ScheduleEntry>> getScheduleByYearMap() {
        return this.scheduleByYearMap;
    }

    public RotationSchedule getRotationSchedule() {
        return rotationSchedule;
    }
}
