package schedule;

import java.sql.*;

public class DBConnect {

    private static DBConnect dbConnect = null;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public static DBConnect getInstance() {
        if(dbConnect == null)
            dbConnect = new DBConnect();
        return dbConnect;
    }

    public DBConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/resident_application", "root", "");
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }


    public void getResidents() {
        try {
            String query = "select * from residents";
            resultSet = statement.executeQuery(query);
            System.out.println("Records from database");
            while(resultSet.next()) {
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                System.out.println(lastName + ", " + firstName);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void addResident(Resident resident) {
        try {
            String query = "INSERT INTO residents(last_name, first_name, class_year)"
                    + " values (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, resident.getLastName());
            preparedStatement.setString(2, resident.getFirstName());
            preparedStatement.setString(3, resident.getClassYear());
            preparedStatement.execute();
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void addBlock(Block block) {
        try {
            String query = "INSERT INTO blocks(block_name, start_date, end_date, year)"
                    + " values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, block.getBlockName());
            preparedStatement.setString(2, block.getStartDate());
            preparedStatement.setString(3, block.getEndDate());
            preparedStatement.setString(4, block.getYear());
            preparedStatement.execute();
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void addRotation(Rotation rotation) {
        try {
            String query = "INSERT INTO rotations(rotation_name, maximum) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, rotation.getName());
            preparedStatement.setInt(2, rotation.getMaxAllowed());
            preparedStatement.execute();
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void addEntry(ScheduleEntry scheduleEntry) {

    }



}
