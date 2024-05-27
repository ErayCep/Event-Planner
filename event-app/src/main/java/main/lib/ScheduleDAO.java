package main.lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
