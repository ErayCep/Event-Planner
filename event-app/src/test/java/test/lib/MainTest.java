package test.lib;

import static org.junit.Assert.*;
import org.junit.Test;

import main.app.EventPlannerGUI;
import main.lib.*;
import main.lib.Event;

import org.junit.Before;
import java.sql.Connection;
import java.util.List;
import main.app.EventPlannerGUI;
import main.lib.*;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import main.app.EventPlannerGUI;
import main.lib.*;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import main.app.EventPlannerGUI;
import main.lib.*;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import main.app.EventPlannerGUI;
import main.lib.Event;
import main.lib.EventFacade;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class MainTest {

    private EventPlannerGUI eventPlannerGUI;
    private EventFacade eventFacade;
    private UserFacade userFacade;
    private EventDAO eventDAO;
    private AttendeeDAO attendeeDAO;
    private ScheduleDAO scheduleDAO;
    private FeedbackDAO feedbackDAO;
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton loginButton;
    private JButton createEventButton;
    private JButton listEventsButton;
    private JButton createScheduleButton;
    private JButton listSchedulesButton;

    @Before
    public void setUp() {
        eventPlannerGUI = new EventPlannerGUI();
        eventFacade = EventFacade.getInstance();
        userFacade = UserFacade.getInstance();
        eventDAO = new EventDAO();
        attendeeDAO = new AttendeeDAO();
        scheduleDAO = new ScheduleDAO();
        feedbackDAO = new FeedbackDAO();
    }
    
    
    
    /*
    @Test
    public void testCreateAndShowGUILoginComponents() throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(() -> eventPlannerGUI.createAndShowGUI());

        Frame[] frames = Frame.getFrames();
        JFrame loginFrame = null;
        for (Frame frame : frames) {
            if (frame instanceof JFrame && frame.getTitle().equals("Login")) {
                loginFrame = (JFrame) frame;
                break;
            }
        }

        assertNotNull("Login frame not found", loginFrame);

        Component[] components = loginFrame.getContentPane().getComponents();
        assertTrue("Login frame components are empty", components.length > 0);

        for (Component comp : components) {
            if (comp instanceof JTextField) {
                if (((JTextField) comp).getName().equals("usernameField")) {
                    usernameField = (JTextField) comp;
                } else if (((JTextField) comp).getName().equals("passwordField")) {
                    passwordField = (JTextField) comp; 
                }
            } else if (comp instanceof JButton) {
                loginButton = (JButton) comp; 
            }
        }

        assertNotNull("Username field not found", usernameField);
        assertNotNull("Password field not found", passwordField);
        assertNotNull("Login button not found", loginButton);
    }

    
    @Test
    public void testCreateAndShowGUILoginComponents2() throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(() -> eventPlannerGUI.createAndShowGUI());

        Frame[] frames = Frame.getFrames();
        JFrame loginFrame = null;
        for (Frame frame : frames) {
            if (frame instanceof JFrame && frame.getTitle().equals("Login")) {
                loginFrame = (JFrame) frame;
                break;
            }
        }

        assertNotNull("Login frame not found", loginFrame);

        Component[] components = loginFrame.getContentPane().getComponents();
        assertTrue("Login frame components are empty", components.length > 0);

        for (Component comp : components) {
            if (comp instanceof JTextField) {
                if (((JTextField) comp).getName().equals("usernameField")) {
                    usernameField = (JTextField) comp;
                } else if (((JTextField) comp).getName().equals("passwordField")) {
                    passwordField = (JTextField) comp;
                }
            } else if (comp instanceof JButton) {
                loginButton = (JButton) comp;
            }
        }

        assertNotNull("Username field not found", usernameField);
        assertNotNull("Password field not found", passwordField);
        assertNotNull("Login button not found", loginButton);

        // Set username and password
        SwingUtilities.invokeAndWait(() -> {
            usernameField.setText("testuser");
            passwordField.setText("1234");
            loginButton.doClick(); // Simulate button click
        });

        // Verify login frame is disposed and new frame is shown
        Frame[] framesAfterLogin = Frame.getFrames();
        JFrame eventPlannerFrame = null;
        for (Frame frame : framesAfterLogin) {
            if (frame instanceof JFrame && frame.getTitle().equals("Event Planner")) {
                eventPlannerFrame = (JFrame) frame;
                break;
            }
        }

        assertNotNull("Event Planner frame not found after login", eventPlannerFrame);
    }
    
    ***************************************************************************************
    	*/
    
    
    
    
    
    
    
    @Test
    public void testCreateAndShowGUILoginComponents2() throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(() -> eventPlannerGUI.createAndShowGUI());

        Frame[] frames = Frame.getFrames();
        JFrame loginFrame = null;
        for (Frame frame : frames) {
            if (frame instanceof JFrame && frame.getTitle().equals("Login")) {
                loginFrame = (JFrame) frame;
                break;
            }
        }

        assertNotNull("Login frame not found", loginFrame);

        Component[] components = loginFrame.getContentPane().getComponents();
        assertTrue("Login frame components are empty", components.length > 0);

        for (Component comp : components) {
            if (comp instanceof JTextField) {
                if ("usernameField".equals(((JTextField) comp).getName())) {
                    usernameField = (JTextField) comp;
                } else if ("passwordField".equals(((JTextField) comp).getName())) {
                    passwordField = (JTextField) comp;
                }
            } else if (comp instanceof JButton) {
                loginButton = (JButton) comp;
            }
        }

        assertNotNull("Username field not found", usernameField);
        assertNotNull("Password field not found", passwordField);
        assertNotNull("Login button not found", loginButton);

        // Set username and password
        SwingUtilities.invokeAndWait(() -> {
            usernameField.setText("testuser");
            passwordField.setText("1234");
            loginButton.doClick(); // Simulate button click
        });

        // Verify login frame is disposed and new frame is shown
        Frame[] framesAfterLogin = Frame.getFrames();
        JFrame eventPlannerFrame = null;
        for (Frame frame : framesAfterLogin) {
            if (frame instanceof JFrame && frame.getTitle().equals("Event Planner")) {
                eventPlannerFrame = (JFrame) frame;
                break;
            }
        }

        assertNotNull("Event Planner frame not found after login", eventPlannerFrame);

        // Find List Events button
        components = eventPlannerFrame.getContentPane().getComponents();
        assertTrue("Event Planner frame components are empty", components.length > 0);

        for (Component comp : components) {
            if (comp instanceof JButton && "List Events".equals(((JButton) comp).getText())) {
                listEventsButton = (JButton) comp;
                break;
            }
        }

        assertNotNull("List Events button not found", listEventsButton);

        // Simulate list events button click
        SwingUtilities.invokeAndWait(() -> listEventsButton.doClick());

        // Access the JOptionPane components and click OK
        SwingUtilities.invokeAndWait(() -> {
            for (Window window : Window.getWindows()) {
                if (window.isActive() && window instanceof JFrame) {
                    for (Component comp : ((JFrame) window).getContentPane().getComponents()) {
                        if (comp instanceof JPanel) {
                            for (Component panelComp : ((JPanel) comp).getComponents()) {
                                if (panelComp instanceof JButton && "OK".equals(((JButton) panelComp).getText())) {
                                    ((JButton) panelComp).doClick();
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        });
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Test
    public void testEventPlannerGUIInitialization() {
        assertNotNull(eventPlannerGUI);
    }

   


    // Test DatabaseConnection
    @Test
    public void testDatabaseConnectionGetConnection() {
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        Connection connection = dbConnection.getConnection();
        assertNotNull(connection);
    }

    @Test
    public void testDatabaseConnectionSingleton() {
        DatabaseConnection dbConnection1 = DatabaseConnection.getInstance();
        DatabaseConnection dbConnection2 = DatabaseConnection.getInstance();
        assertSame(dbConnection1, dbConnection2);
    }

    // Test EventFacade
   /* @Test
    public void testEventFacadeCreateEvent() {
        Event event = new Event("Sample Event", "2024-05-30", "Sample Location", "Sample Description");
        eventFacade.createEvent(event);
        List<Event> events = eventFacade.getAllEvents();
        assertTrue(events.contains(event));
    } */

    @Test
    public void testEventFacadeRegisterAttendee() {
        Attendee attendee = new Attendee("John Doe", "john@example.com");
        eventFacade.registerAttendee(attendee);
        // Additional verification needed to check if the attendee is registered in the database
    }
/*
    @Test
    public void testEventFacadePlanSchedule() {
        Schedule schedule = new Schedule("Activity", "10:00");
        eventFacade.planSchedule(schedule);
        List<Schedule> schedules = eventFacade.getAllSchedules();
        assertTrue(schedules.contains(schedule));
    }*/

    // Test Event
    @Test
    public void testEventCreation() {
        Event event = new Event("Sample Event", "2024-05-30", "Sample Location", "Sample Description");
        assertEquals("Sample Event", event.getName());
        assertEquals("2024-05-30", event.getDate());
        assertEquals("Sample Location", event.getLocation());
        assertEquals("Sample Description", event.getDescription());
    }

    // Test Attendee
    @Test
    public void testAttendeeCreation() {
        Attendee attendee = new Attendee("John Doe", "john@example.com");
        assertEquals("John Doe", attendee.getName());
        assertEquals("john@example.com", attendee.getEmail());
    }

    // Test Schedule
    @Test
    public void testScheduleCreation() {
        Schedule schedule = new Schedule("Activity", "10:00");
        assertEquals("Activity", schedule.getActivity());
        assertEquals("10:00", schedule.getTime());
    }

    // Test Feedback
    @Test
    public void testFeedbackCreation() {
        Feedback feedback = new Feedback("John Doe", "Great event", 5);
        assertEquals("John Doe", feedback.getAttendeeName());
        assertEquals("Great event", feedback.getComments());
        assertEquals(5, feedback.getRating());
    }
/*
    // Test EventDAO
    @Test
    public void testEventDAOCreateAndRetrieveEvent() {
        Event event = new Event("Sample Event", "2024-05-30", "Sample Location", "Sample Description");
        eventDAO.createEvent(event);
        List<Event> events = eventDAO.getAllEvents();
        assertTrue(events.contains(event));
    }
*/
    // Test AttendeeDAO
    @Test
    public void testAttendeeDAORegisterAndRetrieveAttendee() {
        Attendee attendee = new Attendee("John Doe", "john@example.com");
        attendeeDAO.registerAttendee(attendee);
        // Additional verification needed to check if the attendee is registered in the database
    }
/*
    // Test ScheduleDAO
    @Test
    public void testScheduleDAOPlanAndRetrieveSchedule() {
        Schedule schedule = new Schedule("Activity", "10:00");
        scheduleDAO.planSchedule(schedule);
        List<Schedule> schedules = scheduleDAO.getAllSchedules();
        assertTrue(schedules.contains(schedule));
    }
*/
    // Test FeedbackDAO
    @Test
    public void testFeedbackDAOCollectAndRetrieveFeedback() {
        Feedback feedback = new Feedback("John Doe", "Great event", 5);
        feedbackDAO.collectFeedback(feedback);
        // Additional verification needed to check if the feedback is registered in the database
    }
}
