package schedule;

import java.util.ArrayList;


public class YearlyStorage {


    public static void createNewSchedule(String year, MasterStorage masterStorage) {

        ArrayList<StorageEntry> rotationEntries = new ArrayList<StorageEntry>();

        for(RotationNamesEnum name: RotationNamesEnum.values()) {

            Rotation rotation = new Rotation(name.rotationName);
            StorageEntry entry = new StorageEntry(rotation);
            rotationEntries.add(entry);
        }

        masterStorage.addYearlySchedule(year, rotationEntries);



    }




}