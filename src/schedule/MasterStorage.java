package schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.Iterator;

public class MasterStorage {

    private Map<String, ArrayList<StorageEntry>> masterStorage;


    public MasterStorage() {
        this.masterStorage = new HashMap<String, ArrayList<StorageEntry>>();
    }



    public void addYearlySchedule(String year, ArrayList<StorageEntry> storageEntries) {

        masterStorage.put(year, storageEntries);

    }





    public void printSummary() {


        for(Map.Entry<String, ArrayList<StorageEntry>> entry : masterStorage.entrySet()) {

            System.out.println("Key = " + entry.getKey());

            for(int i = 0; i < entry.getValue().size(); i++) {
                StorageEntry rotationEntry = entry.getValue().get(i);

                Rotation rotation = rotationEntry.rotation;
                System.out.println(rotation.getName());

                for(int j = 0; j < rotationEntry.blocks.size(); j++) {
                    System.out.println(rotationEntry.blocks.get(j).getBlockName());
                }
            }





        }
    }

}