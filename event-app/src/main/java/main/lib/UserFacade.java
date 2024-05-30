/**
 * @file UserFacade.java
 * @brief This file contains the UserFacade class and its methods.
 * @details This file contains the UserFacade class, which is used to login and register users.
 */
/**
 * @package main.lib
 * @brief The main.lib package contains the library files for the application.
 */
package main.lib;

/**
 * @class UserFacade
 * @brief The UserFacade class is used to login and register users.
 * @details The UserFacade class contains the attributes and methods to login and register users.
 * @author eray.cepni,eren.sisman
 */
public class UserFacade {
	/**
	 * @brief The instance of UserFacade.
	 */
	private static UserFacade instance;
	/**
	 * @brief The instance of UserDAO.
	 */
	private UserDAO userDAO;

	/**
	 * @brief This constructor creates an user facade.
	 * @details This constructor creates an user facade.
	 */
	public UserFacade() {
		userDAO = new UserDAO();
	}

	/**
	 * @brief This method logs in the user.
	 * @param user User to login
	 * @return True if login was successful, false if not
	 */
	public boolean loginUser(User user) {
		boolean result = userDAO.loginUser(user);
		return result;
	}

	/**
	 * @brief This method registers new user.
	 * @param user User to register
	 * @return True if registration was successful, false if not
	 */
	public boolean registerUser(User user) {
		userDAO.registerUser(user);
		return true;
	}
	
	/**
	 * @brief This method returns the instance of UserFacade.
	 * @return instance The instance of UserFacade.
	 */
    public static UserFacade getInstance() {
        if (instance == null) {
            instance = new UserFacade();
        }
        return instance;
    }
}
