/**
 * @file AttendeeDAO.java
 * @brief This file contains the AttendeeDAO class which is used to interact with the database for attendee related operations.
 * @details This file contains the AttendeeDAO class which is used to interact with the database for attendee related operations. It contains the method to register an attendee.
 */

/**
 * @package main.lib
 * @brief Package main.lib contains the classes for the event application.
 */
package main.lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @class AttendeeDAO
 * @brief The AttendeeDAO class is used to interact with the database for attendee related operations.
 * @details The AttendeeDAO class is used to interact with the database for attendee related operations. It contains the method to register an attendee.
 * @author eray.cepni,eren.sisman
 */
public class AttendeeDAO {
	
	/**
	 * @brief The connection to database.
	 */
    private Connection connection;

	/**
	 * @brief This constructor creates an AttendeeDAO object and initializes the database connection.
	 */
    public AttendeeDAO() {
        connection = DatabaseConnection.getInstance().getConnection();
    }

	/**
	 * @brief This method registers an attendee in the database.
	 * @details This method registers an attendee in the database by inserting the attendee's name and email into the attendees table.
	 * @param attendee The attendee to be registered.
	 */
    public void registerAttendee(Attendee attendee) {
        String sql = "INSERT INTO attendees(name, email) VALUES(?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, attendee.getName());
            pstmt.setString(2, attendee.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
