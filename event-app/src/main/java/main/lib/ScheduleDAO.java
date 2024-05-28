package main.lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO {
    private Connection connection;

    public ScheduleDAO() {
        connection = DatabaseConnection.getInstance().getConnection();
    }

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
    
    public List<Schedule> getAllSchedules() { // Eklendi
        List<Schedule> schedules = new ArrayList<>(); // Eklendi
        String sql = "SELECT * FROM schedules"; // Eklendi
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) { // Eklendi
            ResultSet rs = pstmt.executeQuery(); // Eklendi
            while (rs.next()) { // Eklendi
                Schedule schedule = new Schedule(rs.getString("activity"), // Eklendi
                        rs.getString("time")); // Eklendi
                schedules.add(schedule); // Eklendi
            } // Eklendi
        } catch (SQLException e) { // Eklendi
            e.printStackTrace(); // Eklendi
        } // Eklendi
        return schedules; // Eklendi
    } // Eklendi
}
