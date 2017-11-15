package schedule;

import java.util.ArrayList;

public class Block {

    public static final int NUMBLOCKS = 13;
    private String blockName;
    private String startDate;
    private String endDate;
    private ArrayList<Resident> residents;


    public Block(String blockName) {

        this.blockName = blockName;
        this.residents = new ArrayList<Resident>();
    }


    public static ArrayList<Block> createBlockList() {

        ArrayList<Block> blocks = new ArrayList<Block>();

        for(int i = 0; i < NUMBLOCKS; i++) {
            String blockName = "Block " + String.valueOf(i +1);
            Block newBlock = new Block(blockName);
            blocks.add(newBlock);
        }

        return blocks;

    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;

    }

    public String getBlockName() {
        return this.blockName;
    }









}