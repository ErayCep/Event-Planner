package main.lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AttendeeDAO {
    private Connection connection;

    public AttendeeDAO() {
        connection = DatabaseConnection.getInstance().getConnection();
    }

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
