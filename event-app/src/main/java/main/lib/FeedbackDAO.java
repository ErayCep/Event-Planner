/**
 * @file FeedbackDAO.java
 * @brief This file contains the implementation of the FeedbackDAO class, which is responsible for handling the database operations related to feedback.
 * @details This file contains the methods required for collecting feedback from the attendees and storing it in the database.
 */
/**
 * @package main.lib
 * @details The package 'main.lib' contains the library files for the application.
 */
package main.lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @class FeedbackDAO
 * @brief This class is responsible for handling the database operations related to feedback.
 * @details This class contains the methods required for collecting feedback from the attendees and storing it in the database.
 * @author eray.cepni,eren.sisman
 */
public class FeedbackDAO {
	/**
	 * @brief This attribute stores the connection to the database.
	 */
    private Connection connection;

	/**
	 * @brief This constructor creates a connection to the database.
	 */
    public FeedbackDAO() {
        connection = DatabaseConnection.getInstance().getConnection();
    }

	/**
	 * @brief This method collects the feedback from the attendees and stores it in the database.
	 * @param feedback The feedback object containing the feedback details.
	 */
    public void collectFeedback(Feedback feedback) {
        String sql = "INSERT INTO feedback(attendeeName, comments, rating) VALUES(?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, feedback.getAttendeeName());
            pstmt.setString(2, feedback.getComments());
            pstmt.setInt(3, feedback.getRating());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
