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

public class EventPlannerGUI {
    private EventFacade eventFacade;
    private UserFacade userFacade;
    private boolean loggedIn;

    public EventPlannerGUI() {
        eventFacade = EventFacade.getInstance();
        userFacade = UserFacade.getInstance();
        loggedIn = false;
    }

    public void createAndShowGUI() {
		JFrame frame = new JFrame("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		
		JTextField usernameField = new JTextField(20);
		usernameField.setBounds(100, 20, 165, 25);
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(10, 20, 80, 25);
		frame.add(usernameLabel);
		
		JTextField passwordField = new JTextField(20);
		passwordField.setBounds(100, 50, 165, 25);
		JLabel passwordLabel = new JLabel("Password");
		passwordField.setBounds(10, 50, 80, 25);
		frame.add(passwordLabel);
		
		usernameField.addActionListener(new ActionListener() {
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
			                // Etkinlik oluşturma parametrelerini girmek için diyalog penceresi // Eklendi
			                JTextField eventNameField = new JTextField(10); // Eklendi
			                JTextField eventDateField = new JTextField(10); // Eklendi
			                JTextField eventLocationField = new JTextField(10); // Eklendi
			                JTextField eventDescriptionField = new JTextField(10); // Eklendi

			                JPanel panel = new JPanel(); // Eklendi
			                panel.add(new JLabel("Event Name:")); // Eklendi
			                panel.add(eventNameField); // Eklendi
			                panel.add(new JLabel("Event Date:")); // Eklendi
			                panel.add(eventDateField); // Eklendi
			                panel.add(new JLabel("Event Location:")); // Eklendi
			                panel.add(eventLocationField); // Eklendi
			                panel.add(new JLabel("Event Description:")); // Eklendi
			                panel.add(eventDescriptionField); // Eklendi

			                int result = JOptionPane.showConfirmDialog(null, panel, 
			                         "Enter Event Details", JOptionPane.OK_CANCEL_OPTION); // Eklendi
			                if (result == JOptionPane.OK_OPTION) {
			                    Event event = new Event(eventNameField.getText(), eventDateField.getText(), // Eklendi
			                            eventLocationField.getText(), eventDescriptionField.getText()); // Eklendi
			                    eventFacade.createEvent(event); // Eklendi
			                    JOptionPane.showMessageDialog(frame, "Event Created!"); // Eklendi
			                }

			            }
			        });

			
			        /* REGISTERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR 
			         * 
			         * ERAY
			         * ERAY
			         * 
			 
			        JButton registerAttendeeButton = new JButton("Register Attendee");
			        registerAttendeeButton.addActionListener(new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			                Attendee attendee = new Attendee("John Doe", "john@example.com");
			                eventFacade.registerAttendee(attendee);
			                JOptionPane.showMessageDialog(newFrame, "Attendee Registered!");
			            }
			        }); 
			        
						        newFrame.getContentPane().add(registerAttendeeButton);
						        
						        
			        */
			
			        
			        JButton listEventsButton = new JButton("List Events"); // Eklendi
			        listEventsButton.addActionListener(new ActionListener() { // Eklendi
			            @Override // Eklendi
			            public void actionPerformed(ActionEvent e) { // Eklendi
			                List<Event> events = eventFacade.getAllEvents(); // Eklendi
			                StringBuilder eventList = new StringBuilder(); // Eklendi
			                for (Event event : events) { // Eklendi
			                    eventList.append(event.getName()).append(", ").append(event.getDate()) // Eklendi
			                             .append(", ").append(event.getLocation()).append(", ") // Eklendi
			                             .append(event.getDescription()).append("\n"); // Eklendi
			                } // Eklendi
			                JTextArea textArea = new JTextArea(eventList.toString()); // Eklendi
			                JScrollPane scrollPane = new JScrollPane(textArea); // Eklendi
			                textArea.setLineWrap(true); // Eklendi
			                textArea.setWrapStyleWord(true); // Eklendi
			                scrollPane.setPreferredSize(new java.awt.Dimension(380, 300)); // Eklendi
			                JOptionPane.showMessageDialog(frame, scrollPane, "Event List", // Eklendi
			                                              JOptionPane.INFORMATION_MESSAGE); // Eklendi
			            } // Eklendi
			        }); // Eklendi

			        JButton createScheduleButton = new JButton("Create Schedule"); // Eklendi
			        createScheduleButton.addActionListener(new ActionListener() { // Eklendi
			            @Override // Eklendi
			            public void actionPerformed(ActionEvent e) { // Eklendi
			                JTextField scheduleActivityField = new JTextField(10); // Eklendi
			                JTextField scheduleTimeField = new JTextField(10); // Eklendi

			                JPanel panel = new JPanel(); // Eklendi
			                panel.add(new JLabel("Activity:")); // Eklendi
			                panel.add(scheduleActivityField); // Eklendi
			                panel.add(new JLabel("Time:")); // Eklendi
			                panel.add(scheduleTimeField); // Eklendi

			                int result = JOptionPane.showConfirmDialog(null, panel, // Eklendi
			                        "Enter Schedule Details", JOptionPane.OK_CANCEL_OPTION); // Eklendi
			                if (result == JOptionPane.OK_OPTION) { // Eklendi
			                    Schedule schedule = new Schedule(scheduleActivityField.getText(), // Eklendi
			                            scheduleTimeField.getText()); // Eklendi
			                    eventFacade.planSchedule(schedule); // Eklendi
			                    JOptionPane.showMessageDialog(frame, "Schedule Created!"); // Eklendi
			                } // Eklendi
			            } // Eklendi
			        }); // Eklendi

			        JButton listSchedulesButton = new JButton("List Schedules"); // Eklendi
			        listSchedulesButton.addActionListener(new ActionListener() { // Eklendi
			            @Override // Eklendi
			            public void actionPerformed(ActionEvent e) { // Eklendi
			                List<Schedule> schedules = eventFacade.getAllSchedules(); // Eklendi
			                StringBuilder scheduleList = new StringBuilder(); // Eklendi
			                for (Schedule schedule : schedules) { // Eklendi
			                    scheduleList.append(schedule.getActivity()).append(", ") // Eklendi
			                                 .append(schedule.getTime()).append("\n"); // Eklendi
			                } // Eklendi
			                JTextArea textArea = new JTextArea(scheduleList.toString()); // Eklendi
			                JScrollPane scrollPane = new JScrollPane(textArea); // Eklendi
			                textArea.setLineWrap(true); // Eklendi
			                textArea.setWrapStyleWord(true); // Eklendi
			                scrollPane.setPreferredSize(new java.awt.Dimension(380, 300)); // Eklendi
			                JOptionPane.showMessageDialog(frame, scrollPane, "Schedule List", // Eklendi
			                        JOptionPane.INFORMATION_MESSAGE); // Eklendi
			            } // Eklendi
			        }); // Eklendi
			        newFrame.getContentPane().add(createScheduleButton); // Eklendi
			        newFrame.getContentPane().add(listSchedulesButton); // Eklendi
			        newFrame.getContentPane().add(createEventButton);
			        newFrame.getContentPane().add(listEventsButton); // Eklendi
			        newFrame.setLayout(new java.awt.FlowLayout());
			        newFrame.setVisible(true);
				}
			}
		});
		
		passwordField.addActionListener(new ActionListener() {
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
			                // Etkinlik oluşturma parametrelerini girmek için diyalog penceresi // Eklendi
			                JTextField eventNameField = new JTextField(10); // Eklendi
			                JTextField eventDateField = new JTextField(10); // Eklendi
			                JTextField eventLocationField = new JTextField(10); // Eklendi
			                JTextField eventDescriptionField = new JTextField(10); // Eklendi

			                JPanel panel = new JPanel(); // Eklendi
			                panel.add(new JLabel("Event Name:")); // Eklendi
			                panel.add(eventNameField); // Eklendi
			                panel.add(new JLabel("Event Date:")); // Eklendi
			                panel.add(eventDateField); // Eklendi
			                panel.add(new JLabel("Event Location:")); // Eklendi
			                panel.add(eventLocationField); // Eklendi
			                panel.add(new JLabel("Event Description:")); // Eklendi
			                panel.add(eventDescriptionField); // Eklendi

			                int result = JOptionPane.showConfirmDialog(null, panel, 
			                         "Enter Event Details", JOptionPane.OK_CANCEL_OPTION); // Eklendi
			                if (result == JOptionPane.OK_OPTION) {
			                    Event event = new Event(eventNameField.getText(), eventDateField.getText(), // Eklendi
			                            eventLocationField.getText(), eventDescriptionField.getText()); // Eklendi
			                    eventFacade.createEvent(event); // Eklendi
			                    JOptionPane.showMessageDialog(frame, "Event Created!"); // Eklendi
			                }

			            }
			        });

			
			        /* REGISTERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR 
			         * 
			         * ERAY
			         * ERAY
			         * 
			 
			        JButton registerAttendeeButton = new JButton("Register Attendee");
			        registerAttendeeButton.addActionListener(new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			                Attendee attendee = new Attendee("John Doe", "john@example.com");
			                eventFacade.registerAttendee(attendee);
			                JOptionPane.showMessageDialog(newFrame, "Attendee Registered!");
			            }
			        }); 
			        
						        newFrame.getContentPane().add(registerAttendeeButton);
						        
						        
			        */
			
			        
			        JButton listEventsButton = new JButton("List Events"); // Eklendi
			        listEventsButton.addActionListener(new ActionListener() { // Eklendi
			            @Override // Eklendi
			            public void actionPerformed(ActionEvent e) { // Eklendi
			                List<Event> events = eventFacade.getAllEvents(); // Eklendi
			                StringBuilder eventList = new StringBuilder(); // Eklendi
			                for (Event event : events) { // Eklendi
			                    eventList.append(event.getName()).append(", ").append(event.getDate()) // Eklendi
			                             .append(", ").append(event.getLocation()).append(", ") // Eklendi
			                             .append(event.getDescription()).append("\n"); // Eklendi
			                } // Eklendi
			                JTextArea textArea = new JTextArea(eventList.toString()); // Eklendi
			                JScrollPane scrollPane = new JScrollPane(textArea); // Eklendi
			                textArea.setLineWrap(true); // Eklendi
			                textArea.setWrapStyleWord(true); // Eklendi
			                scrollPane.setPreferredSize(new java.awt.Dimension(380, 300)); // Eklendi
			                JOptionPane.showMessageDialog(frame, scrollPane, "Event List", // Eklendi
			                                              JOptionPane.INFORMATION_MESSAGE); // Eklendi
			            } // Eklendi
			        }); // Eklendi

			        JButton createScheduleButton = new JButton("Create Schedule"); // Eklendi
			        createScheduleButton.addActionListener(new ActionListener() { // Eklendi
			            @Override // Eklendi
			            public void actionPerformed(ActionEvent e) { // Eklendi
			                JTextField scheduleActivityField = new JTextField(10); // Eklendi
			                JTextField scheduleTimeField = new JTextField(10); // Eklendi

			                JPanel panel = new JPanel(); // Eklendi
			                panel.add(new JLabel("Activity:")); // Eklendi
			                panel.add(scheduleActivityField); // Eklendi
			                panel.add(new JLabel("Time:")); // Eklendi
			                panel.add(scheduleTimeField); // Eklendi

			                int result = JOptionPane.showConfirmDialog(null, panel, // Eklendi
			                        "Enter Schedule Details", JOptionPane.OK_CANCEL_OPTION); // Eklendi
			                if (result == JOptionPane.OK_OPTION) { // Eklendi
			                    Schedule schedule = new Schedule(scheduleActivityField.getText(), // Eklendi
			                            scheduleTimeField.getText()); // Eklendi
			                    eventFacade.planSchedule(schedule); // Eklendi
			                    JOptionPane.showMessageDialog(frame, "Schedule Created!"); // Eklendi
			                } // Eklendi
			            } // Eklendi
			        }); // Eklendi

			        JButton listSchedulesButton = new JButton("List Schedules"); // Eklendi
			        listSchedulesButton.addActionListener(new ActionListener() { // Eklendi
			            @Override // Eklendi
			            public void actionPerformed(ActionEvent e) { // Eklendi
			                List<Schedule> schedules = eventFacade.getAllSchedules(); // Eklendi
			                StringBuilder scheduleList = new StringBuilder(); // Eklendi
			                for (Schedule schedule : schedules) { // Eklendi
			                    scheduleList.append(schedule.getActivity()).append(", ") // Eklendi
			                                 .append(schedule.getTime()).append("\n"); // Eklendi
			                } // Eklendi
			                JTextArea textArea = new JTextArea(scheduleList.toString()); // Eklendi
			                JScrollPane scrollPane = new JScrollPane(textArea); // Eklendi
			                textArea.setLineWrap(true); // Eklendi
			                textArea.setWrapStyleWord(true); // Eklendi
			                scrollPane.setPreferredSize(new java.awt.Dimension(380, 300)); // Eklendi
			                JOptionPane.showMessageDialog(frame, scrollPane, "Schedule List", // Eklendi
			                        JOptionPane.INFORMATION_MESSAGE); // Eklendi
			            } // Eklendi
			        }); // Eklendi
			        newFrame.getContentPane().add(createScheduleButton); // Eklendi
			        newFrame.getContentPane().add(listSchedulesButton); // Eklendi

			        newFrame.getContentPane().add(createEventButton);
			        newFrame.getContentPane().add(listEventsButton); // Eklendi
			        newFrame.setLayout(new java.awt.FlowLayout());
			        newFrame.setVisible(true);
				}
			}
		});		
        frame.getContentPane().add(usernameField);
        frame.getContentPane().add(passwordField);
        frame.setLayout(new java.awt.FlowLayout());
        frame.setVisible(true);
    	
    	if (loggedIn) {
    		JFrame newFrame = new JFrame("Event Planner");
	        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        newFrame.setSize(400, 400);
	
	        JButton createEventButton = new JButton("Create Event");
	        createEventButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                Event event = new Event("Sample Event", "2024-05-30", "Sample Location", "Sample Description");
	                eventFacade.createEvent(event);
	                JOptionPane.showMessageDialog(newFrame, "Event Created!");
	            }
	        });
	
	        JButton registerAttendeeButton = new JButton("Register Attendee");
	        registerAttendeeButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                Attendee attendee = new Attendee("John Doe", "john@example.com");
	                eventFacade.registerAttendee(attendee);
	                JOptionPane.showMessageDialog(newFrame, "Attendee Registered!");
	            }
	        });
	
	        newFrame.getContentPane().add(createEventButton);
	        newFrame.getContentPane().add(registerAttendeeButton);
	        newFrame.setLayout(new java.awt.FlowLayout());
	        newFrame.setVisible(true);
    	}
    }
}
