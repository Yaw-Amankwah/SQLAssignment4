package SQLAssignment4;

import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;

public interface TableInterface {
    static void dropSchema (Connection connection, String dbName) throws SQLException {

        PreparedStatement psDropSchema = connection.prepareStatement("DROP SCHEMA IF EXISTS " + dbName);
        try {
            psDropSchema.executeUpdate();
            System.out.println("Schema dropped");
        }
        catch (SQLException e) {
            System.out.println("Error in dropSchema");
            System.out.println(e);
        }
    }
    static void dropTable (Connection connection, String nameTable) throws SQLException {
        PreparedStatement psDropTable = connection.prepareStatement ("DROP TABLE IF EXISTS " + nameTable);
        try {
            psDropTable.executeUpdate();
        }
        catch (SQLException e) {System.out.println(e);}
    }

    // Create a Table
    static void createTable (Connection connection, String createTable) throws SQLException {
        PreparedStatement psCreateTable = connection.prepareStatement(createTable);
        try {
            psCreateTable.executeUpdate();
            System.out.println("\nTable created successfully!");
        }
        catch (SQLException e) {System.out.println(e);}
    }

    // Set Local in file parameter for local data loading: MySQL server
    static void setLocalInFileLoading (Connection connection) throws SQLException {
        PreparedStatement psSetLocalInFileLoading = connection.prepareStatement("SET GLOBAL local_infile = 1"); //MORE STUFF TO TYPE HERE
        try {
            psSetLocalInFileLoading.executeUpdate();
            System.out.println("\nGlobal local infile set successfully");
        }
        catch (SQLException e) {System.out.println(e);} //REMOVE THIS
    }

    static ResultSet getTable(Connection connection, String nameTable) {
        ResultSet RS = null;

        return RS;

    }

    static String loadDataInFileTable(String fileName, String nameTable) {
        return "LOAD DATA LOCAL INFILE '" + fileName + "' INTO TABLE " + nameTable;

    }

    static void populateTable(Connection connection, String populateTable) throws SQLException {
        Statement statement = connection.createStatement();
        try{
            statement.executeUpdate(populateTable);
            System.out.println("\nTable populated successfully");
        }
        catch(SQLException e) {
            System.out.println("\nError in populate Table");
            System.out.println(e);
        }



    }

}
