/**
 * @file UserDAO.java
 * @brief This file contains the UserDAO class and its methods.
 * @details This file contains the User class, which is used to make query in user database.
 * 
 */

/**
 * @package lib
 * @brief The lib package contains the classes responsible for controlling the application.
 */
package main.lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @class UserDAO
 * @brief The UserDAO class is used to connect to sql database.
 * @details The UserDAO class contains the attributes and methods to connect to user database.
 * @author eray.cepni,eren.sisman
 */
public class UserDAO {
	private Connection connection;
	
    public UserDAO() {
        connection = DatabaseConnection.getInstance().getConnection();
    }
    
    public void registerUser(User user) {
        String sql = "INSERT INTO users(username, password) VALUES(?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean loginUser(User user) {
    	String password = getPassword(user.getUsername());
    	if (password.equals(user.getPassword())) {
    		return true;
    	}
    	
    	return false;
    }
    
    public String getPassword(String username) {
    	String sql = "SELECT username, password FROM users WHERE username = ?";
    	try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
    		pstmt.setString(1, username);
    		ResultSet rs = pstmt.executeQuery();
    		while (rs.next()) {
    			String uUsername = rs.getString("username");
    			String uPassword = rs.getString("password");
    			if (username.equals(uUsername)) {
    				return uPassword;
    			}
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
}
