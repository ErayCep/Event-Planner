/**
 * @file DatabaseConnection.java
 * @brief This file contains the DatabaseConnection class which is used to create a connection to the database.
 * @details This file contains the DatabaseConnection class which is used to create a connection to the database. It contains the method to get the connection to the database.
 */
/**
 * @package main.lib
 * @brief Package main.lib contains the classes for the event application.
 */
package main.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @class DatabaseConnection
 * @brief The DatabaseConnection class is used to create a connection to the database.
 * @details The DatabaseConnection class is used to create a connection to the database. It contains the method to get the connection to the database.
 * @author eray.cepni,eren.sisman
 */
public class DatabaseConnection {
	
    /**
     * @brief The instance of the DatabaseConnection class.
     */
    private static DatabaseConnection instance;
	/**
	 * @brief The connection to the database.
	 */
    private Connection connection;

	/**
	 * @brief This constructor creates a DatabaseConnection object and initializes the database connection.
	 */
    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:event_planner.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	/**
	 * @brief This method returns the instance of the DatabaseConnection class.
	 * @details This method returns the instance of the DatabaseConnection class. If the instance is null, it creates a new instance.
	 * @return The instance of the DatabaseConnection class.
	 */
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

	/**
	 * @brief This method returns the connection to the database.
	 * @return The connection to the database.
	 */
    public Connection getConnection() {
        return connection;
    }
}
