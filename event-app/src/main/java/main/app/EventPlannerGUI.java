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
	 * @brief A boolean variable to check if the user is logged in.
	 */

	/**
	 * @brief This constructor creates an EventPlannerGUI object.
	 * @details This constructor creates an EventPlannerGUI object and initializes the EventFacade and UserFacade instances.
	 */
    public EventPlannerGUI() {
        eventFacade = EventFacade.getInstance();
        userFacade = UserFacade.getInstance();

    }

	/**
	 * @brief This method creates and shows the graphical user interface of the event planner application.
	 * @details This method creates and shows the graphical user interface of the event planner application. It creates a login window where the user can enter the username and password. If the login is successful, it opens the main window of the application where the user can create events, list events, create schedules, and list schedules.
	 */
    public void createAndShowGUI() {
		JFrame frame = new JFrame("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		
		JTextField usernameField = new JTextField(20);
		usernameField.setBounds(100, 20, 165, 25);
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(10, 20, 80, 25);
		usernameField.setName("usernameField"); 
		frame.add(usernameLabel);
		
		JTextField passwordField = new JTextField(20);
		passwordField.setBounds(100, 50, 165, 25);
		JLabel passwordLabel = new JLabel("Password");
		passwordField.setBounds(10, 50, 80, 25);
		passwordField.setName("passwordField");
		frame.add(passwordLabel);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = passwordField.getText();
				User user = new User(username, password);
				boolean result = userFacade.loginUser(user);
				if (result) {
					frame.dispose();
		    		JFrame newFrame = new JFrame("Event Planner");
			        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        newFrame.setSize(400, 400);
			
			        JButton createEventButton = new JButton("Create Event");
			        createEventButton.addActionListener(new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {

			                JTextField eventNameField = new JTextField(10); 
			                eventNameField.setName("eventNameField"); 
			                JTextField eventDateField = new JTextField(10); 
			                eventDateField.setName("eventDateField"); 
			                JTextField eventLocationField = new JTextField(10); 
			                eventLocationField.setName("eventLocationField"); 
			                JTextField eventDescriptionField = new JTextField(10); 
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

			                int result = JOptionPane.showConfirmDialog(null, panel, 
			                         "Enter Event Details", JOptionPane.OK_CANCEL_OPTION); 
			                if (result == JOptionPane.OK_OPTION) {
			                    Event event = new Event(eventNameField.getText(), eventDateField.getText(), 
			                            eventLocationField.getText(), eventDescriptionField.getText()); 
			                    eventFacade.createEvent(event); 
			                    JOptionPane.showMessageDialog(frame, "Event Created!"); 
			                }

			            }
			        });
			        
			        JButton listEventsButton = new JButton("List Events"); 
			        listEventsButton.addActionListener(new ActionListener() { 
			            @Override 
			            public void actionPerformed(ActionEvent e) { 
			                List<Event> events = eventFacade.getAllEvents(); 
			                StringBuilder eventList = new StringBuilder(); 
			                for (Event event : events) { 
			                    eventList.append(event.getName()).append(", ").append(event.getDate()) 
			                             .append(", ").append(event.getLocation()).append(", ") 
			                             .append(event.getDescription()).append("\n"); 
			                } 
			                JTextArea textArea = new JTextArea(eventList.toString()); 
			                JScrollPane scrollPane = new JScrollPane(textArea);
			                textArea.setLineWrap(true); 
			                textArea.setWrapStyleWord(true); 
			                scrollPane.setPreferredSize(new java.awt.Dimension(380, 300)); 
			                JOptionPane.showMessageDialog(frame, scrollPane, "Event List", 
			                                              JOptionPane.INFORMATION_MESSAGE); 
			            } 
			        }); 

			        JButton createScheduleButton = new JButton("Create Schedule"); 
			        createScheduleButton.addActionListener(new ActionListener() { 
			            @Override 
			            public void actionPerformed(ActionEvent e) { 
			                JTextField scheduleActivityField = new JTextField(10); 
			                JTextField scheduleTimeField = new JTextField(10); 

			                JPanel panel = new JPanel(); 
			                panel.add(new JLabel("Activity:"));
			                panel.add(scheduleActivityField); 
			                panel.add(new JLabel("Time:")); 
			                panel.add(scheduleTimeField); 

			                int result = JOptionPane.showConfirmDialog(null, panel, 
			                        "Enter Schedule Details", JOptionPane.OK_CANCEL_OPTION); 
			                if (result == JOptionPane.OK_OPTION) { 
			                    Schedule schedule = new Schedule(scheduleActivityField.getText(), 
			                            scheduleTimeField.getText());
			                    eventFacade.planSchedule(schedule); 
			                    JOptionPane.showMessageDialog(frame, "Schedule Created!"); 
			                }
			            } 
			        }); 

			        JButton listSchedulesButton = new JButton("List Schedules"); 
			        listSchedulesButton.addActionListener(new ActionListener() {
			            @Override 
			            public void actionPerformed(ActionEvent e) { 
			                List<Schedule> schedules = eventFacade.getAllSchedules(); 
			                StringBuilder scheduleList = new StringBuilder(); 
			                for (Schedule schedule : schedules) { 
			                    scheduleList.append(schedule.getActivity()).append(", ") 
			                                 .append(schedule.getTime()).append("\n"); 
			                } 
			                JTextArea textArea = new JTextArea(scheduleList.toString()); 
			                JScrollPane scrollPane = new JScrollPane(textArea); 
			                textArea.setLineWrap(true); 
			                textArea.setWrapStyleWord(true); 
			                scrollPane.setPreferredSize(new java.awt.Dimension(380, 300)); 
			                JOptionPane.showMessageDialog(frame, scrollPane, "Schedule List", 
			                        JOptionPane.INFORMATION_MESSAGE); 
			            } 
			        }); 
			        newFrame.getContentPane().add(createScheduleButton); 
			        newFrame.getContentPane().add(listSchedulesButton); 
			        newFrame.getContentPane().add(createEventButton);
			        newFrame.getContentPane().add(listEventsButton); 
			        newFrame.setLayout(new java.awt.FlowLayout());
			        newFrame.setVisible(true);
				}
			}
		});
		
		
        frame.getContentPane().add(usernameField);
        frame.getContentPane().add(passwordField);
        frame.getContentPane().add(loginButton);
        frame.setLayout(new java.awt.FlowLayout());
        frame.setVisible(true);

    }
}
