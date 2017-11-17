package schedule;

import java.util.ArrayList;

public class RotationSchedule  {

    private ArrayList<Rotation> rotations;



    public RotationSchedule() {

        this.rotations = new ArrayList<Rotation>();
        initializeRotationList();

    }


    private void initializeRotationList() {

        for(RotationNamesEnum name: RotationNamesEnum.values()) {
            Rotation rotation = new Rotation(name.rotationName);
            rotations.add(rotation);
        }
    }

    public static void createRotationWithBlocks(String year) {

        ArrayList<Block> blockListInstance = null;
        MasterDatabase masterDatabase = MasterDatabase.getInstance();
        RotationSchedule masterRotation = masterDatabase.getRotationSchedule();
        ArrayList<Block> blocks = masterDatabase.getBlockMap().get(year);
        ArrayList<ScheduleEntry> scheduleEntries = new ArrayList<ScheduleEntry>();
        Block blockCopy = null;
        Block blockToStore = null;

        for(int i = 0; i < masterRotation.getRotations().size(); i++) {
            blockListInstance = new ArrayList<Block>();
            for (int blockNum = 0; blockNum < blocks.size(); blockNum++) {
                blockCopy = blocks.get(blockNum);
                blockToStore = new Block(blockCopy.getBlockName(), blockCopy.getStartDate(), blockCopy.getEndDate()
                                , blockCopy.getYear());
                blockListInstance.add(blockToStore);
            }

            String rotationName = masterRotation.getRotations().get(i).getName();
            ScheduleEntry newEntry = new ScheduleEntry(rotationName, blockListInstance);
            scheduleEntries.add(newEntry);
        }

        //Store the schedule entries in the db with key = year
        masterDatabase.addToscheduleByYearMap(year, scheduleEntries);
    }



    public ArrayList<Rotation> getRotations() {
        return this.rotations;
    }


}