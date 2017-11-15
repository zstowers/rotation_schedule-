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

    public ArrayList<Rotation> getRotations() {
        return this.rotations;
    }


}