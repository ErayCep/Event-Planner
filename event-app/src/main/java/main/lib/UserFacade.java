package main.lib;

public class UserFacade {
	private static UserFacade instance;
	private UserDAO userDAO;
	
	private UserFacade() {
		userDAO = new UserDAO();
	}
	
	public boolean loginUser(User user) {
		boolean result = userDAO.loginUser(user);
		return result;
	}
	
	public boolean registerUser(User user) {
		userDAO.registerUser(user);
		return true;
	}
	
    public static UserFacade getInstance() {
        if (instance == null) {
            instance = new UserFacade();
        }
        return instance;
    }
}
