package main.lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FeedbackDAO {
    private Connection connection;

    public FeedbackDAO() {
        connection = DatabaseConnection.getInstance().getConnection();
    }

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
