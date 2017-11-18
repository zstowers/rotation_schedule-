package schedule;

public class ResidentBlockEntry {

    private String lastName;
    private String yearAssigned;

    public ResidentBlockEntry(String lastName, String yearAssigned) {
        this.lastName = lastName;
        this.yearAssigned = yearAssigned;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getYearAssigned() {
        return this.yearAssigned;
    }

}
