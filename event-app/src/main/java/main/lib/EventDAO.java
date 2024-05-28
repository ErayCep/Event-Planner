package main.lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    
    public List<Event> getAllEvents() { // Eklendi
        List<Event> events = new ArrayList<>(); // Eklendi
        String sql = "SELECT * FROM events"; // Eklendi
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) { // Eklendi
            ResultSet rs = pstmt.executeQuery(); // Eklendi
            while (rs.next()) { // Eklendi
                Event event = new Event(rs.getString("name"), rs.getString("date"), // Eklendi
                        rs.getString("location"), rs.getString("description")); // Eklendi
                events.add(event); // Eklendi
            } // Eklendi
        } catch (SQLException e) { // Eklendi
            e.printStackTrace(); // Eklendi
        } // Eklendi
        return events; // Eklendi
    } // Eklendi
}
