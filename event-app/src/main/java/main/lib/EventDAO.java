package main.lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EventDAO {
    private Connection connection;

    public EventDAO() {
        connection = DatabaseConnection.getInstance().getConnection();
    }

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
}
