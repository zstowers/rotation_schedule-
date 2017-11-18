package schedule;

import java.util.ArrayList;
import java.util.HashMap;

public class Utilities {

    public static void printYearlySchedule(String year, MasterDatabase masterDatabase) {
        HashMap<String, ArrayList<ScheduleEntry>> entries = masterDatabase.getScheduleByYearMap();

        ArrayList<ScheduleEntry> scheduleEntries = entries.get(year);
        ResidentBlockEntry resident = null;
        String residentName;
        String yearAssigned;

        for (int i = 0; i < scheduleEntries.size(); i++) {
            ScheduleEntry individualEntry = scheduleEntries.get(i);
            System.out.println(individualEntry.getRotationName());
            for (int blockNum = 0; blockNum < individualEntry.getBlocks().size(); blockNum++) {
                Block currentBlock = individualEntry.getBlocks().get(blockNum);
                System.out.println("\t" + currentBlock.getBlockName());
                for (int currentBlockIndex = 0; currentBlockIndex < currentBlock.getResidentEntry().size(); currentBlockIndex++) {
                    resident = currentBlock.getResidentEntry().get(currentBlockIndex);
                    residentName = resident.getLastName();
                    yearAssigned = resident.getYearAssigned();
                    System.out.println("\t\t" + residentName + "\t\t" + yearAssigned);

                }
            }
        }
    }

}
