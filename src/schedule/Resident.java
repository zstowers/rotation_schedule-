package schedule;

public class Resident {

    private String lastName;
    private String firstName;
    private String classYear;
    private int idNumber;


    public Resident(String firstName, String lastName, String classYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.classYear = classYear;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getClassYear() {
        return this.classYear;
    }

    public void setID(int newID) {
        this.idNumber = newID;
    }








//	public void addToDB() {
//
//	}

    public void getID() {


    }










}