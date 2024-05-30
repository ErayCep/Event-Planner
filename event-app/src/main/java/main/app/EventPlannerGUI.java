/**
 * @file EventPlannerGUI.java
 * @brief This file contains the EventPlannerGUI class which is used to create the graphical user interface for the event planner application.
 * @details  This file contains the EventPlannerGUI class which is used to create the graphical user interface for the event planner application. It contains the methods required for creating the GUI.
 */
/**
 * @package main.app
 * @brief The main.app package contains the main class of the application.
 */
package main.app;

import main.lib.EventFacade;
import main.lib.Schedule;
import main.lib.UserFacade;
import main.lib.User;
import main.lib.Event;
import main.lib.Attendee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @class EventPlannerGUI
 * @brief The EventPlannerGUI class is used to create the graphical user interface for the event planner application.
 * @details The EventPlannerGUI class is used to create the graphical user interface for the event planner application. It contains the methods required for creating the GUI.
 * @author eray.cepni,eren.sisman
 */
public class EventPlannerGUI {

	/**
	 * @brief The EventFacade instance.
     */
    private EventFacade eventFacade;
	/**
	 * @brief The UserFacade instance.
	 */
    private UserFacade userFacade;
    /**
     * @brief The JFrame for the main frame.
     */
    public JFrame frameMain; 
    /**
     * @brief The JTextArea for the event list.
     */
    public JTextArea textAreale; 
    /**
     * @brief The JScrollPane for the event list.
     */
    public JScrollPane scrollPanele;
	/**
	 * @brief The JPanel for the schedule panel.
	 */
    public JPanel panel ;
	/**
	 * @brief The JTextField for the schedule time.
	 */
    public JTextField scheduleTimeField ;
	/**
	 * @brief The JTextField for the schedule activity.
	 */
    public JTextField scheduleActivityField;
	/**
	 * @brief The JTextArea for the schedule list.
	 */
    public JTextArea textArea ;
	/**
	 * @brief The JScrollPane for the schedule list.
	 */
    public JScrollPane scrollPane ;
	/**
	 * @brief The JTextField for the event name.
	 */
    public JTextField eventNameField;
	/**
	 * @brief The JTextField for the event date.
	 */
    public JTextField eventDateField;
	/**
	 * @brief The JTextField for the event location.
	 */
    public JTextField eventLocationField;
	/**
	 * @brief The JTextField for the event description.
	 */
    public JTextField eventDescriptionField;
	/**
	 * @brief This constructor creates an EventPlannerGUI object.
	 * @details This constructor creates an EventPlannerGUI object and initializes the EventFacade and UserFacade instances.
	 */
    public EventPlannerGUI() {
        this(EventFacade.getInstance(), UserFacade.getInstance());
    }
/**
 * @brief This constructor creates an EventPlannerGUI object with the given EventFacade and UserFacade instances.
 * @param eventFacade
 * @param userFacade
 */
    public EventPlannerGUI(EventFacade eventFacade, UserFacade userFacade) {
        this.eventFacade = eventFacade;
        this.userFacade = userFacade;
    }

	/**
	 * @brief This method creates and shows the GUI.
	 */
    public void createAndShowGUI() {
        JFrame frame = createLoginFrame();
        frame.setVisible(true);
    }

	/**
	 * @brief This method creates the login frame.
	 * @return frame The login frame.
	 */
    public JFrame createLoginFrame() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JTextField usernameField = new JTextField(20);
        usernameField.setName("usernameField");
        JTextField passwordField = new JTextField(20);
        passwordField.setName("passwordField");

        JLabel usernameLabel = new JLabel("Username");
        JLabel passwordLabel = new JLabel("Password");

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> handleLogin(frame, usernameField, passwordField));

        frame.setLayout(new java.awt.FlowLayout());
        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);

        return frame;
    }
/**
 * @brief This method handles the login action.
 * @param frame
 * @param usernameField
 * @param passwordField
 */
    public void handleLogin(JFrame frame, JTextField usernameField, JTextField passwordField) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        User user = new User(username, password);
        boolean result = userFacade.loginUser(user);
        if (result) {
            frame.dispose();
            JFrame mainFrame = createMainFrame();
            mainFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(frame, "Login Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

	/**
	 * @brief This method creates the main frame.
	 * @return frameMain The main frame.
	 */
    public JFrame createMainFrame() {
        frameMain = new JFrame("Event Planner");
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setSize(400, 400);

        JButton createEventButton = new JButton("Create Event");
        createEventButton.addActionListener(e -> handleCreateEvent());

        JButton listEventsButton = new JButton("List Events");
        listEventsButton.addActionListener(e -> handleListEvents());

        JButton createScheduleButton = new JButton("Create Schedule");
        createScheduleButton.addActionListener(e -> handleCreateSchedule());

        JButton listSchedulesButton = new JButton("List Schedules");
        listSchedulesButton.addActionListener(e -> handleListSchedules());

        frameMain.setLayout(new java.awt.FlowLayout());
        frameMain.add(createEventButton);
        frameMain.add(listEventsButton);
        frameMain.add(createScheduleButton);
        frameMain.add(listSchedulesButton);

        return frameMain;
    }

	/**
	 * @brief This method handles the create event action.
	 */
    public void handleCreateEvent() {
        eventNameField = new JTextField(10);
        eventNameField.setName("eventNameField");
        eventDateField = new JTextField(10);
        eventDateField.setName("eventDateField");
        eventLocationField = new JTextField(10);
        eventLocationField.setName("eventLocationField");
        eventDescriptionField = new JTextField(10);
        eventDescriptionField.setName("eventDescriptionField");

        JPanel panel = new JPanel();
        panel.setName("eventPanel");
        panel.add(new JLabel("Event Name:"));
        panel.add(eventNameField);
        panel.add(new JLabel("Event Date:"));
        panel.add(eventDateField);
        panel.add(new JLabel("Event Location:"));
        panel.add(eventLocationField);
        panel.add(new JLabel("Event Description:"));
        panel.add(eventDescriptionField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Event Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            Event event = new Event(eventNameField.getText(), eventDateField.getText(), eventLocationField.getText(), eventDescriptionField.getText());
            eventFacade.createEvent(event);
            JOptionPane.showMessageDialog(null, "Event Created!");
        }
    }

	/**
	 * @brief This method handles the list events action.
	 */
    public void handleListEvents() {
        List<Event> events = eventFacade.getAllEvents();
        StringBuilder eventList = new StringBuilder();
        for (Event event : events) {
            eventList.append(event.getName()).append(", ").append(event.getDate()).append(", ").append(event.getLocation()).append(", ").append(event.getDescription()).append("\n");
        }
        textAreale = new JTextArea(eventList.toString());
        scrollPanele = new JScrollPane(textAreale);
        textAreale.setLineWrap(true);
        textAreale.setWrapStyleWord(true);
        scrollPanele.setPreferredSize(new java.awt.Dimension(380, 300));
        JOptionPane.showMessageDialog(null, scrollPanele, "Event List", JOptionPane.INFORMATION_MESSAGE);
    }    
/**
 * @brief This method handles the create schedule action.
 */
    public void handleCreateSchedule() {
        scheduleActivityField = new JTextField(10);
        scheduleTimeField = new JTextField(10);

        panel = new JPanel();
        panel.add(new JLabel("Activity:"));
        panel.add(scheduleActivityField);
        panel.add(new JLabel("Time:"));
        panel.add(scheduleTimeField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Schedule Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            Schedule schedule = new Schedule(scheduleActivityField.getText(), scheduleTimeField.getText());
            eventFacade.planSchedule(schedule);
            JOptionPane.showMessageDialog(null, "Schedule Created!");
        }
    }
/**
 * @brief This method handles the list schedules action.
 */
    public void handleListSchedules() {
        List<Schedule> schedules = eventFacade.getAllSchedules();
        StringBuilder scheduleList = new StringBuilder();
        for (Schedule schedule : schedules) {
            scheduleList.append(schedule.getActivity()).append(", ").append(schedule.getTime()).append("\n");
        }
        textArea = new JTextArea(scheduleList.toString());
        scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane.setPreferredSize(new java.awt.Dimension(380, 300));
        JOptionPane.showMessageDialog(null, scrollPane, "Schedule List", JOptionPane.INFORMATION_MESSAGE);
    }
}
