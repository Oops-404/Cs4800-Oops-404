package cs4800.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Database class
 * 
 */
public class Database {

	public static void main(String[] args) {
		
        // try connection to database
        try (Connection connect = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "Solar0221")) {

            if (connect != null) { 
                System.out.println("Connected to the database :)");
            } else {
                System.out.println("Failed to connect to the database :(");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
	}
	
}