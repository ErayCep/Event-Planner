/**
 * @file EventDAO.java
 * @brief This file contains the EventDAO class which is used to interact with the database for event related operations.
 * @details This file contains the EventDAO class which is used to interact with the database for event related operations. It contains the method to create an event.
 */
/**
 * @package main.lib
 * @brief Package main.lib contains the classes for the event application.
 */
package main.lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @class EventDAO
 * @brief The EventDAO class is used to interact with the database for event related operations.
 * @details The EventDAO class is used to interact with the database for event related operations. It contains the method to create an event.
 * @author eray.cepni,eren.sisman
 */
public class EventDAO {
	/**
	 * @brief The connection to the database.
	 */
	private Connection connection;

	/**
	 * @brief This constructor creates an EventDAO object and initializes the database connection.
	 * @details database connection. This constructor creates an EventDAO object and initializes the database connection.
	 */
    public EventDAO() {
        connection = DatabaseConnection.getInstance().getConnection();
    }

	/**
	 * @brief This method creates an event in the database.
	 * @details This method creates an event in the database by inserting the event's name, date, location, and description into the events table.
	 * @param event The event to be created.
	 */
    public void createEvent(Event event) {
        String sql = "INSERT INTO events(name, date, location, description) VALUES(?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, event.getName());
            pstmt.setString(2, event.getDate());
            pstmt.setString(3, event.getLocation());
            pstmt.setString(4, event.getDescription());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
	/**
	 * @brief This method returns all events from the database.
	 * @details This method returns all events from the database by querying the events table.
	 * @return The list of events.
	 */
    public List<Event> getAllEvents() { 
        List<Event> events = new ArrayList<>(); 
        String sql = "SELECT * FROM events"; 
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) { 
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) { 
                Event event = new Event(rs.getString("name"), rs.getString("date"), 
                        rs.getString("location"), rs.getString("description"));
                events.add(event);
            } 
        } catch (SQLException e) { 
            e.printStackTrace();
        } 
        return events; 
    } 
}
