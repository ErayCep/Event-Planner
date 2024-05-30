/**
 * @file ScheduleDAO.java
 * @brief This file contains the implementation of the ScheduleDAO class, which is responsible for handling the database operations related to schedules.
 * @details This file contains the methods required for planning schedules for events and retrieving schedules from the database.
 */
/**
 * @package main.lib
 * @details The package 'main.lib' contains the library files for the application.
 */
package main.lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @class ScheduleDAO
 * @brief This class is responsible for handling the database operations related to schedules.
 * @details This class contains the methods required for planning schedules for events and retrieving schedules from the database.
 * @author eray.cepni, eren.sisman
 */
public class ScheduleDAO {
	/**
     * @brief This attribute stores the connection to the database.
	 */
    private Connection connection;

	/**
	 * @brief This constructor creates a connection to the database.
	 */
    public ScheduleDAO() {
        connection = DatabaseConnection.getInstance().getConnection();
    }

	/**
	 * @brief This method plans a schedule for an event and stores it in the database.
	 * @param schedule The schedule object containing the activity and time of the event.
	 */
    public void planSchedule(Schedule schedule) {
        String sql = "INSERT INTO schedules(activity, time) VALUES(?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, schedule.getActivity());
            pstmt.setString(2, schedule.getTime());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
	/**
	 * @brief This method retrieves all schedules from the database.
	 * @return The list of schedules.
	 */
    public List<Schedule> getAllSchedules() { 
        List<Schedule> schedules = new ArrayList<>(); 
        String sql = "SELECT * FROM schedules"; 
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) { 
            ResultSet rs = pstmt.executeQuery(); 
            while (rs.next()) { 
                Schedule schedule = new Schedule(rs.getString("activity"), 
                        rs.getString("time")); 
                schedules.add(schedule);
            } 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
        return schedules; 
    } 
}
