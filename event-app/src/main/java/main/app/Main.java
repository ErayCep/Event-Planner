/**
 * @file Main.java
 * @brief This file contains the main class of the application.
 * @details This file contains the main class of the application, which is used to start the application.
 */
/**
 * @package main.app
 * @brief The main.app package contains the main class of the application.
 */
package main.app;

import main.lib.EventFacade;

/**
 * @class Main
 * @brief The Main class is used to start the application.
 * @details The Main class is used to start the application by creating an instance of the EventPlannerGUI class.
 * @author eray.cepni,eren.sisman
 */
public class Main {
	/**
	 * @brief The main method of the application.
	 * @details The main method of the application creates an instance of the EventPlannerGUI class and calls the createAndShowGUI method.
	 * @param args
	 */
    public static void main(String[] args) {
        EventPlannerGUI gui = new EventPlannerGUI();
        gui.createAndShowGUI();
    }
}
