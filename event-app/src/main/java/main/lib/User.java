/**
 * @file User.java
 * @brief This file contains the User class and its methods.
 * @details This file contains the User class, which is used to login and register users.
 * 
 */

/**
 * @package lib
 * @brief The lib package contains the classes responsible for controlling the application.
 */
package main.lib;


/**
 * @class User
 * @brief The User class is used to login and register users.
 * @details The User class contains the attributes and methods to create and login users.
 * @author eray.cepni,eren.sisman
 */
public class User {
    /**
     * @brief This constructor creates an user.
     * @details This constructor creates an user with the given parameters.
     * 
     * @param userName The user name of the user.
     * 
     * @param password The password of the user.
     */
	public User(String username, String password) {
		this.mUsername = username;
		this.mPassword = password;
	}
	
    /**
     * @brief This method sets the user name of the user.
     * @param username
     */
	public boolean setUsername(String username) {
		boolean wasSet = false;
		this.mUsername = username;
		wasSet = true;
		return wasSet;
	}
	
    /**
     * @brief This method sets the password of the user.
     * @param password
     */
	public boolean setPassword(String password) {
		boolean wasSet = false;
		this.mPassword = password;
		wasSet = true;
		return wasSet;
	}
	
    /**
     * @brief This method returns the user name of the user.
     * @return The user name of the user.
     */
	public String getUsername() {
		return this.mUsername;
	}

    /**
     * @brief This method returns the password of the user.
     * @return The password of the user.
     */
	public String getPassword() {
		return this.mPassword;
	}
	
	  /**
	   * @brief mUsername User name of the user.
	   */
	private String mUsername;
	  /**
	   * @brief mPassword Password of the user.
	   */
	private String mPassword;
}
