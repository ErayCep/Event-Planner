package main.app;

import main.lib.EventFacade;
import main.lib.UserFacade;
import main.lib.User;
import main.lib.Event;
import main.lib.Attendee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
