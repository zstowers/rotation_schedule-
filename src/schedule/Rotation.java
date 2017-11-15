package schedule;

import java.util.ArrayList;

public class Rotation {

    private String rotationName;
    private int numberRequired;
    private int minNeededPerBlock;
    private int maxAllowedPerBlock;


    public Rotation(String rotationName) {

        this.rotationName = rotationName;

    }

    public String getName() {
        return this.rotationName;
    }

    public void setNumberRequired(int numberRequired) {
        this.numberRequired = numberRequired;
    }

    public void setMinNeededPerBlock(int minNeeded) {
        this.minNeededPerBlock = minNeeded;
    }

    public void setMaxAllowedPerBlock(int maxAllowed) {
        this.maxAllowedPerBlock = maxAllowed;
    }

    public int getNumberRequired() {
        return this.numberRequired;
    }

    public int getminNeeded() {
        return this.minNeededPerBlock;
    }

    public int getMaxAllowed() {
        return this.maxAllowedPerBlock;
    }



}