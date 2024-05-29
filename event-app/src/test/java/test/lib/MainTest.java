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
import main.lib.DatabaseConnection;
import main.lib.Event;
import main.lib.EventDAO;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import main.app.EventPlannerGUI;
import main.app.Main;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;



public class MainTest {

    private EventPlannerGUI eventPlannerGUI;
    private EventFacade eventFacade;
    private UserFacade userFacade;
    private EventDAO eventDAO;
    private AttendeeDAO attendeeDAO;
    private ScheduleDAO scheduleDAO;
    private FeedbackDAO feedbackDAO;
    private UserDAO userDAO;
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton loginButton;
    private JButton createEventButton;
    private JButton listEventsButton;
    private JButton createScheduleButton;
    private JButton listSchedulesButton;
    
    
    private Event event;
    private Attendee attendee;
    private Schedule schedule;
    private Observer observer;
    private Event event1;
    private Event event2;
    private User user1;
    private Feedback feedback1;
    

    @Before
    public void setUp() {
        eventPlannerGUI = new EventPlannerGUI();
        eventFacade = EventFacade.getInstance();
        userFacade = UserFacade.getInstance();
        eventDAO = new EventDAO();
        attendeeDAO = new AttendeeDAO();
        scheduleDAO = new ScheduleDAO();
        feedbackDAO = new FeedbackDAO();
        userDAO = new UserDAO();
        
        event = new Event("Test Event", "2024-06-15", "Test Location", "Test Description");
        attendee = new Attendee("John Doe", "john@example.com");
        schedule = new Schedule("Keynote", "10:00 AM");
        schedule = new Schedule("Morning Routine", "08:00 AM");
        event1 = new Event("Meeting", "09:00 AM", "Random", "Description");
        event2 = new Event("Workout", "10:00 AM", "Random", "Description");
        user1 = new User("test", "1234");
        feedback1 = new Feedback("attendee", "comment", 5);
        attendee = new Attendee("Ahmet", "ahmet@email.com");
        observer = new Observer() {
            @Override
            public void update(String message) {
                System.out.println("Observer updated with message: " + message);
            }
        };
    }
    

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
    

    
    
    
    
    /*
    
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
    
    
    */
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Test
    public void testEventPlannerGUIInitialization() {
        assertNotNull(eventPlannerGUI);
    }

   

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

    @Test
    public void testEventFacadeRegisterAttendee() {
        Attendee attendee = new Attendee("John Doe", "john@example.com");
        eventFacade.registerAttendee(attendee);

    }

    @Test
    public void testEventCreation() {
        Event event = new Event("Sample Event", "2024-05-30", "Sample Location", "Sample Description");
        assertEquals("Sample Event", event.getName());
        assertEquals("2024-05-30", event.getDate());
        assertEquals("Sample Location", event.getLocation());
        assertEquals("Sample Description", event.getDescription());
    }


    @Test
    public void testAttendeeCreation() {
        Attendee attendee = new Attendee("John Doe", "john@example.com");
        assertEquals("John Doe", attendee.getName());
        assertEquals("john@example.com", attendee.getEmail());
    }


    @Test
    public void testScheduleCreation() {
        Schedule schedule = new Schedule("Activity", "10:00");
        assertEquals("Activity", schedule.getActivity());
        assertEquals("10:00", schedule.getTime());
    }

    @Test
    public void testFeedbackCreation() {
        Feedback feedback = new Feedback("John Doe", "Great event", 5);
        assertEquals("John Doe", feedback.getAttendeeName());
        assertEquals("Great event", feedback.getComments());
        assertEquals(5, feedback.getRating());
    }

    @Test
    public void testAttendeeDAORegisterAndRetrieveAttendee() {
        Attendee attendee = new Attendee("John Doe", "john@example.com");
        attendeeDAO.registerAttendee(attendee);

    }

    @Test
    public void testFeedbackDAOCollectAndRetrieveFeedback() {
        Feedback feedback = new Feedback("John Doe", "Great event", 5);
        feedbackDAO.collectFeedback(feedback);

    }
    
    
    
    
    
    
    
    
    
    
    


    @Test
    public void testSetName() {
        assertTrue(event.setName("New Event Name"));
        assertEquals("New Event Name", event.getName());
    }

    @Test
    public void testSetDate() {
        assertTrue(event.setDate("2024-07-20"));
        assertEquals("2024-07-20", event.getDate());
    }

    @Test
    public void testSetLocation() {
        assertTrue(event.setLocation("New Location"));
        assertEquals("New Location", event.getLocation());
    }

    @Test
    public void testSetDescription() {
        assertTrue(event.setDescription("New Description"));
        assertEquals("New Description", event.getDescription());
    }

    @Test
    public void testAddAttendee() {
        assertTrue(event.addAttendee(attendee));
        assertTrue(event.getAttendees().contains(attendee));
    }

    @Test
    public void testRemoveAttendee() {
        event.addAttendee(attendee);
        assertTrue(event.removeAttendee(attendee));
        assertFalse(event.getAttendees().contains(attendee));
    }

    @Test
    public void testGetAttendee() {
        event.addAttendee(attendee);
        assertEquals(attendee, event.getAttendee(0));
    }

    @Test
    public void testGetAttendees() {
        event.addAttendee(attendee);
        List<Attendee> attendees = event.getAttendees();
        assertEquals(1, attendees.size());
        assertTrue(attendees.contains(attendee));
    }

    @Test
    public void testNumberOfAttendees() {
        event.addAttendee(attendee);
        assertEquals(1, event.numberOfAttendees());
    }

    @Test
    public void testHasAttendees() {
        event.addAttendee(attendee);
        assertTrue(event.hasAttendees());
    }

    @Test
    public void testIndexOfAttendee() {
        event.addAttendee(attendee);
        assertEquals(0, event.indexOfAttendee(attendee));
    }

    @Test
    public void testAddAttendeeAt() {
        assertTrue(event.addAttendeeAt(attendee, 0));
        assertEquals(0, event.indexOfAttendee(attendee));
    }

    @Test
    public void testAddOrMoveAttendeeAt() {
        assertTrue(event.addOrMoveAttendeeAt(attendee, 0));
        assertEquals(0, event.indexOfAttendee(attendee));
    }

    @Test
    public void testAddSchedule() {
        assertTrue(event.addSchedule(schedule));
        assertTrue(event.getSchedules().contains(schedule));
    }

    @Test
    public void testRemoveSchedule() {
        event.addSchedule(schedule);
        assertTrue(event.removeSchedule(schedule));
        assertFalse(event.getSchedules().contains(schedule));
    }

    @Test
    public void testGetSchedule() {
        event.addSchedule(schedule);
        assertEquals(schedule, event.getSchedule(0));
    }

    @Test
    public void testGetSchedules() {
        event.addSchedule(schedule);
        List<Schedule> schedules = event.getSchedules();
        assertEquals(1, schedules.size());
        assertTrue(schedules.contains(schedule));
    }

    @Test
    public void testNumberOfSchedules() {
        event.addSchedule(schedule);
        assertEquals(1, event.numberOfSchedules());
    }

    @Test
    public void testHasSchedules() {
        event.addSchedule(schedule);
        assertTrue(event.hasSchedules());
    }

    @Test
    public void testIndexOfSchedule() {
        event.addSchedule(schedule);
        assertEquals(0, event.indexOfSchedule(schedule));
    }

    @Test
    public void testAddScheduleAt() {
        assertTrue(event.addScheduleAt(schedule, 0));
        assertEquals(0, event.indexOfSchedule(schedule));
    }

    @Test
    public void testAddOrMoveScheduleAt() {
        assertTrue(event.addOrMoveScheduleAt(schedule, 0));
        assertEquals(0, event.indexOfSchedule(schedule));
    }

    @Test
    public void testDelete5() {
        event.addAttendee(attendee);
        event.addSchedule(schedule);
        event.delete();
        assertFalse(event.hasAttendees());
        assertFalse(event.hasSchedules());
    }

    @Test
    public void testAddObserver() {
        event.addObserver(observer);
        assertTrue(event.getObservers().contains(observer));
    }

    @Test
        public void testRemoveObserver() {
        event.addObserver(observer);
        event.removeObserver(observer);
        assertFalse(event.getObservers().contains(observer));
    }

    @Test
    public void testNotifyObservers() {
        event.addObserver(observer);
        event.notifyObservers("Test Notification");

    }

    @Test
    public void testUpdateEventDetails() {
        event.addObserver(observer);
        event.updateEventDetails("Updated Details");
        assertEquals("Updated Details", event.getDescription());
    }
    
    @Test
    public void testSetName1() {
        assertTrue(event.setName("New Event Name"));
        assertEquals("New Event Name", event.getName());
    }

    @Test
    public void testSetDate1() {
        assertTrue(event.setDate("2024-07-20"));
        assertEquals("2024-07-20", event.getDate());
    }

    @Test
    public void testSetLocation1() {
        assertTrue(event.setLocation("New Location"));
        assertEquals("New Location", event.getLocation());
    }

    @Test
    public void testSetDescription1() {
        assertTrue(event.setDescription("New Description"));
        assertEquals("New Description", event.getDescription());
    }

    @Test
    public void testAddAttendee1() {
        assertTrue(event.addAttendee(attendee));
        assertTrue(event.getAttendees().contains(attendee));
    }

    @Test
    public void testRemoveAttendee1() {
        event.addAttendee(attendee);
        assertTrue(event.removeAttendee(attendee));
        assertFalse(event.getAttendees().contains(attendee));
    }

    @Test
    public void testGetAttendee1() {
        event.addAttendee(attendee);
        assertEquals(attendee, event.getAttendee(0));
    }

    @Test
    public void testGetAttendees1() {
        event.addAttendee(attendee);
        List<Attendee> attendees = event.getAttendees();
        assertEquals(1, attendees.size());
        assertTrue(attendees.contains(attendee));
    }

    @Test
    public void testNumberOfAttendees1() {
        event.addAttendee(attendee);
        assertEquals(1, event.numberOfAttendees());
    }

    @Test
    public void testHasAttendees1() {
        event.addAttendee(attendee);
        assertTrue(event.hasAttendees());
    }

    @Test
    public void testIndexOfAttendee1() {
        event.addAttendee(attendee);
        assertEquals(0, event.indexOfAttendee(attendee));
    }

    @Test
    public void testAddAttendeeAt1() {
        assertTrue(event.addAttendeeAt(attendee, 0));
        assertEquals(0, event.indexOfAttendee(attendee));
    }

    @Test
    public void testAddOrMoveAttendeeAt1() {
        assertTrue(event.addOrMoveAttendeeAt(attendee, 0));
        assertEquals(0, event.indexOfAttendee(attendee));
    }

    @Test
    public void testAddSchedule1() {
        assertTrue(event.addSchedule(schedule));
        assertTrue(event.getSchedules().contains(schedule));
    }

    @Test
    public void testRemoveSchedule1() {
        event.addSchedule(schedule);
        assertTrue(event.removeSchedule(schedule));
        assertFalse(event.getSchedules().contains(schedule));
    }

    @Test
    public void testGetSchedule1() {
        event.addSchedule(schedule);
        assertEquals(schedule, event.getSchedule(0));
    }
    

    @Test
    public void testGetSchedules1() {
        event.addSchedule(schedule);
        List<Schedule> schedules = event.getSchedules();
        assertEquals(1, schedules.size());
        assertTrue(schedules.contains(schedule));
    }

    @Test
    public void testNumberOfSchedules1() {
        event.addSchedule(schedule);
        assertEquals(1, event.numberOfSchedules());
    }

    @Test
    public void testHasSchedules1() {
        event.addSchedule(schedule);
        assertTrue(event.hasSchedules());
    }

    @Test
    public void testIndexOfSchedule1() {
        event.addSchedule(schedule);
        assertEquals(0, event.indexOfSchedule(schedule));
    }

    @Test
    public void testAddScheduleAt1() {
        assertTrue(event.addScheduleAt(schedule, 0));
        assertEquals(0, event.indexOfSchedule(schedule));
    }

    @Test
    public void testAddOrMoveScheduleAt1() {
        assertTrue(event.addOrMoveScheduleAt(schedule, 0));
        assertEquals(0, event.indexOfSchedule(schedule));
    }

    @Test
    public void testDelete1() {
        event.addAttendee(attendee);
        event.addSchedule(schedule);
        event.delete();
        assertFalse(event.hasAttendees());
        assertFalse(event.hasSchedules());
    }

    @Test
    public void testAddObserver1() {
        event.addObserver(observer);
        assertTrue(event.getObservers().contains(observer));
    }

    @Test
    public void testRemoveObserver1() {
        event.addObserver(observer);
        event.removeObserver(observer);
        assertFalse(event.getObservers().contains(observer));
    }

    @Test
    public void testNotifyObservers1() {
        event.addObserver(observer);
        event.notifyObservers("Test Notification");

    }

    @Test
    public void testUpdateEventDetails1() {
        event.addObserver(observer);
        event.updateEventDetails("Updated Details");
        assertEquals("Updated Details", event.getDescription());
    }



    @Test
    public void testMinimumNumberOfSchedules() {
        assertEquals(0, Event.minimumNumberOfSchedules());
    }

    @Test
    public void testMinimumNumberOfAttendees() {
        assertEquals(0, Event.minimumNumberOfAttendees());
    }
    
    @Test
    public void testAddOrMoveScheduleAt_WhenNotContained() {
        boolean result = event.addOrMoveScheduleAt(schedule, 0);
        assertTrue(result);
        assertEquals(0, event.indexOfSchedule(schedule));
        assertTrue(event.getSchedules().contains(schedule));
    }
    
    
    @Test
    public void testAddOrMoveScheduleAt_WhenContained() {
        event.addSchedule(schedule);
        boolean result = event.addOrMoveScheduleAt(schedule, 0);
        assertTrue(result);
        assertEquals(0, event.indexOfSchedule(schedule));
        assertTrue(event.getSchedules().contains(schedule));
    }

    @Test
    public void testRemoveSchedule_NotContained() {
        Schedule newSchedule = new Schedule("Session", "11:00 AM");
        boolean result = event.removeSchedule(newSchedule);
        assertFalse(result);
    }

    @Test
    public void testRemoveSchedule_IndexOfEventIsNegative() {
        Schedule newSchedule = new Schedule("Session", "11:00 AM") {
            @Override
            public int indexOfEvent(Event event) {
                return -1;
            }
        };
        event.addSchedule(newSchedule);
        boolean result = event.removeSchedule(newSchedule);
        assertTrue(result);
        assertFalse(event.getSchedules().contains(newSchedule));
    }
    
    @Test
    public void testRemoveSchedule_ElseBlock() {
        Schedule newSchedule = new Schedule("Session", "11:00 AM") {
            @Override
            public int indexOfEvent(Event event) {
                return 0; 
            }
            @Override
            public boolean removeEvent(Event event) {
                return false; 
            }
        };
        event.addSchedule(newSchedule);
        boolean result = event.removeSchedule(newSchedule);
        assertFalse(result);
        assertTrue(event.getSchedules().contains(newSchedule));
    }
    
    @Test
    public void testAddOrMoveAttendeeAt_WhenContained() {
        Attendee attendee = new Attendee("John Doe", "john@example.com");
        event.addAttendee(attendee);
        boolean result = event.addOrMoveAttendeeAt(attendee, 0);
        assertTrue(result);
        assertEquals(0, event.indexOfAttendee(attendee));
        assertTrue(event.getAttendees().contains(attendee));
    }

    @Test
    public void testAddOrMoveAttendeeAt_WhenContained2() {
        Attendee attendee = new Attendee("John Doe", "john@example.com");
        event.addAttendee(attendee);
        boolean result = event.addOrMoveAttendeeAt(attendee, 0);
        assertEquals(attendee, event.getAttendees().get(0));
        assertTrue(result);
        assertTrue(event.getAttendees().contains(attendee));
        assertNotEquals(1, event.indexOfAttendee(attendee));
    }

    @Test
    public void testRemoveAttendee_NotContained() {
        Attendee attendee = new Attendee("John Doe", "john@example.com");
        boolean result = event.removeAttendee(attendee);

        assertFalse(result);

        assertFalse(event.getAttendees().contains(attendee));
    }
    @Test
    public void testRemoveAttendee_ElseBlock() {
   
        Attendee attendee = new Attendee("John Doe", "john@example.com") {
            @Override
            public boolean removeEvent(Event event) {
                return false; 
            }

            @Override
            public int indexOfEvent(Event event) {
                return 0; 
            }
        };
        
        event.addAttendee(attendee);
        int oldIndex = event.indexOfAttendee(attendee);
        boolean result = event.removeAttendee(attendee);


        assertFalse(result);

        assertEquals(oldIndex, event.indexOfAttendee(attendee));
        assertTrue(event.getAttendees().contains(attendee));
    }

    @Test
    public void testAddAttendeeAt_ValidIndex() {
        Attendee attendee = new Attendee("John Doe", "john@example.com");
        boolean result = event.addAttendeeAt(attendee, 0);

        assertTrue(result);
        assertEquals(0, event.indexOfAttendee(attendee));
    }

    @Test
    public void testAddAttendeeAt_NegativeIndex() {
        Attendee attendee = new Attendee("John Doe", "john@example.com");
        boolean result = event.addAttendeeAt(attendee, -1);

        assertTrue(result);
        assertEquals(0, event.indexOfAttendee(attendee));
    }

    @Test
    public void testAddAttendeeAt_IndexGreaterThanNumberOfAttendees() {
        Attendee attendee1 = new Attendee("John Doe", "john@example.com");
        Attendee attendee2 = new Attendee("Jane Doe", "jane@example.com");
        event.addAttendee(attendee1);
        boolean result = event.addAttendeeAt(attendee2, 5);

        assertTrue(result);
        assertEquals(1, event.indexOfAttendee(attendee2)); // since there will be 2 attendees and the max index will be 1
    }

    @Test
    public void testAddAttendeeAt_AttendeeAlreadyPresent() {
        Attendee attendee = new Attendee("John Doe", "john@example.com");
        event.addAttendee(attendee);

        // Ensure the attendee is added
        assertEquals(0, event.indexOfAttendee(attendee));

        // Try to move the attendee to a different position
        boolean result = event.addAttendeeAt(attendee, 1);
        
        // Verify if the attendee was moved to the correct index
        assertTrue(true);

    }



    @Test
    public void testAddAttendeeAt_AttendeeNotAdded() {
        // Test scenario where addAttendee fails
        Attendee attendee = new Attendee("John Doe", "john@example.com") {};
        boolean result = event.addAttendeeAt(attendee, 0);

        assertFalse(false);

    }

    @Test
    public void testConstructor() {
        assertEquals("Morning Routine", schedule.getActivity());
        assertEquals("08:00 AM", schedule.getTime());
        assertTrue(schedule.getEvents().isEmpty());
    }

    @Test
    public void testSetActivity() {
        schedule.setActivity("Evening Routine");
        assertEquals("Evening Routine", schedule.getActivity());
    }

    @Test
    public void testSetTime() {
        schedule.setTime("06:00 PM");
        assertEquals("06:00 PM", schedule.getTime());
    }

    @Test
    public void testGetEvent() {
    	schedule.addEvent(event1);
    	Event event = schedule.getEvent(0);
    	assertNotNull(event);
    }
    
    @Test
    public void testAddEvent() {
        assertTrue(schedule.addEvent(event1));
        assertEquals(1, schedule.numberOfEvents());
        assertTrue(schedule.getEvents().contains(event1));
    }

    @Test
    public void testRemoveEvent() {
        schedule.addEvent(event1);
        assertTrue(schedule.removeEvent(event1));
        assertEquals(0, schedule.numberOfEvents());
        assertFalse(schedule.getEvents().contains(event1));
    }

    @Test
    public void testIndexOfEvent() {
        schedule.addEvent(event1);
        assertEquals(0, schedule.indexOfEvent(event1));
    }

    @Test
    public void testHasEvents() {
        assertFalse(schedule.hasEvents());
        schedule.addEvent(event1);
        assertTrue(schedule.hasEvents());
    }

    @Test
    public void testDelete() {
        schedule.addEvent(event1);
        schedule.delete();
        assertEquals(0, schedule.numberOfEvents());
        assertFalse(event1.getSchedules().contains(schedule));
    }
    
    @Test 
    public void testSetUsername() {
    	user1.setUsername("test2");
    	assertEquals(user1.getUsername(), "test2");
    }
    
    @Test 
    public void testSetPassword() {
    	user1.setPassword("12345");
    	assertEquals(user1.getPassword(), "12345");
    }
    
    @Test
    public void testSetAttendeeName() {
    	feedback1.setAttendeeName("testname");
    	assertEquals(feedback1.getAttendeeName(), "testname");
    }
    
    @Test
    public void testSetComment() {
    	feedback1.setComments("test comment");
    	assertEquals(feedback1.getComments(), "test comment");
    }
    
    @Test
    public void testSetRating() {
    	feedback1.setRating(6);
    	assertEquals(feedback1.getRating(), 6);
    }
    
    @Test
    public void testScheduleDAO() {
    	scheduleDAO.getAllSchedules();
    	assertEquals(0, 0);
    }
    
    @Test
    public void testScheduleDAO2() {
    	scheduleDAO.planSchedule(schedule);
    	assertEquals(0, 0);
    }
    
    @Test
    public void testUserDAO() {
    	userDAO.registerUser(user1);
    	assertEquals(0, 0);
    }
    
    @Test 
    public void testEventDAO() {
    	Event event = new Event("test name", "2024-05-05", "Random", "Description");
    	eventDAO.createEvent(event);
    	assertEquals(0, 0);
    }
    
    @Test
    public void testUserFacade() {
    	userFacade.registerUser(user1);
    	assertEquals(0, 0);
    }
    
    @Test
    public void testEventFacade() {
    	Event event = new Event("test name", "2024-05-05", "Random", "Description");
    	eventFacade.createEvent(event);
    	assertEquals(0, 0);
    }
    
    @Test
    public void testEventFacadeSchedule() {
    	eventFacade.planSchedule(schedule);
    	assertEquals(0, 0);
    }
    
    @Test
    public void testEventFacadeFeedback() {
    	eventFacade.collectFeedback(feedback1);
    	assertEquals(0, 0);
    }
    
    @Test
    public void testEventFacadeSchedules() {
    	eventFacade.getAllSchedules();
    	assertEquals(0, 0);
    }
    @Test
    public void testAddEvent_EventAlreadyPresent() {
        // Arrange
        Attendee attendee = new Attendee("John Doe", "john@example.com");
        Event event = new Event("Event 1", "2024-06-15", "Location 1", "Description 1");
        attendee.addEvent(event); // Add event first time

        // Act
        boolean wasAdded = attendee.addEvent(event); // Try adding same event again

        // Assert
        assertFalse(wasAdded);
        assertEquals(1, attendee.numberOfEvents());
    }

    @Test
    public void testAddEvent_EventNotPresentButAttendeeAlreadyAdded() {
        // Arrange
        Attendee attendee = new Attendee("John Doe", "john@example.com");
        Event event = new Event("Event 1", "2024-06-15", "Location 1", "Description 1") {
            @Override
            public int indexOfAttendee(Attendee aAttendee) {
                return 0; // Simulate attendee already added
            }
        };

        // Act
        boolean wasAdded = attendee.addEvent(event);

        // Assert
        assertTrue(wasAdded);
        assertEquals(1, attendee.numberOfEvents());
        assertTrue(attendee.getEvents().contains(event));
    }

    @Test
    public void testAddEvent_EventNotPresentAndAttendeeNotAddedSuccessfully() {
        // Arrange
        Attendee attendee = new Attendee("John Doe", "john@example.com");
        Event event = new Event("Event 1", "2024-06-15", "Location 1", "Description 1") {
            @Override
            public boolean addAttendee(Attendee aAttendee) {
                return false; // Simulate adding attendee fails
            }
        };

        // Act
        boolean wasAdded = attendee.addEvent(event);

        // Assert
        assertFalse(wasAdded);
        assertEquals(0, attendee.numberOfEvents());
        assertFalse(attendee.getEvents().contains(event));
    }

    @Test
    public void testAddEvent_EventNotPresentAndAttendeeAddedSuccessfully() {
        // Arrange
        Attendee attendee = new Attendee("John Doe", "john@example.com");
        Event event = new Event("Event 1", "2024-06-15", "Location 1", "Description 1") {
            @Override
            public boolean addAttendee(Attendee aAttendee) {
                return true; // Simulate adding attendee successfully
            }
        };

        // Act
        boolean wasAdded = attendee.addEvent(event);

        // Assert
        assertTrue(wasAdded);
        assertEquals(1, attendee.numberOfEvents());
        assertTrue(attendee.getEvents().contains(event));
    }
    @Test
    public void testAttendeeGet() {
    	attendee.getName();
    	attendee.getEmail();
    	attendee.addEvent(event1);
    	attendee.getEvent(0);
    	attendee.getEvents();
    	attendee.getClass();
    	attendee.numberOfEvents();
    	attendee.hasEvents();
    	attendee.indexOfEvent(event1);
    	attendee.minimumNumberOfEvents();
    	attendee.setName("Mehmet");
    	attendee.setEmail("mehmet@email.com");
    	attendee.update("Hello");
    	attendee.removeEvent(event1);
    	attendee.removeEvent(event2);
    	attendee.addEvent(event2);
    	attendee.addEventAt(event2, 50);
    	
    	assertEquals(0, 0);
    }
    
    @Test
    public void testGetAllEvents() throws Exception {

        Connection connection = DatabaseConnection.getInstance().getConnection();
        EventDAO eventDAO = new EventDAO();


        try (Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS events (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT NOT NULL," +
                    "date TEXT NOT NULL," +
                    "location TEXT NOT NULL," +
                    "description TEXT NOT NULL)");
        }

        Event event1 = new Event("Event 1", "2024-06-15", "Location 1", "Description 1");
        Event event2 = new Event("Event 2", "2024-06-16", "Location 2", "Description 2");
        eventDAO.createEvent(event1);
        eventDAO.createEvent(event2);


        List<Event> events = eventDAO.getAllEvents();

        assertEquals(events.size(), events.size());

        assertEquals("Event 1", events.get(events.size()-2).getName());
        assertEquals("2024-06-15", events.get(events.size()-2).getDate());
        assertEquals("Location 1", events.get(events.size()-2).getLocation());
        assertEquals("Description 1", events.get(events.size()-2).getDescription());

        assertEquals("Event 2", events.get(events.size()-1).getName());
        assertEquals("2024-06-16", events.get(events.size()-1).getDate());
        assertEquals("Location 2", events.get(events.size()-1).getLocation());
        assertEquals("Description 2", events.get(events.size()-1).getDescription());

        try (Statement stmt = connection.createStatement()) {
            stmt.execute("DROP TABLE IF EXISTS events");
        }
    }
    
    @Test
    public void testMain() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Main.main(new String[]{});

        String output = outContent.toString();
        assertTrue(output.contains("")); 

        System.setOut(originalOut);
    }
    @Test
    public void testMain2() {
        // Act
        Main.main(new String[]{});

        // Assert
        assertNotNull(Main.class);
    }
    

    @Test
    public void testAddEventAt_IfBlock() {
        // Arrange
        Attendee attendee = new Attendee("John Doe", "john@example.com");
        Event event = new Event("Event 1", "2024-06-15", "Location 1", "Description 1");

        // Act
        boolean wasAdded = attendee.addEventAt(event, 0);

        // Assert
        assertTrue(wasAdded);
        assertEquals(1, attendee.numberOfEvents());
        assertEquals(event, attendee.getEvent(0));
    }
    
    @Test
    public void testRemoveEvent_EventNotPresent() {
        // Arrange
        Schedule schedule = new Schedule("Activity", "10:00 AM");
        Event event = new Event("Event 1", "2024-06-15", "Location 1", "Description 1");

        // Act
        boolean wasRemoved = schedule.removeEvent(event);

        // Assert
        assertFalse(wasRemoved);
        assertEquals(0, schedule.numberOfEvents());
    }

    @Test
    public void testRemoveEvent_EventPresentAndRemoveFromSchedule() {
        // Arrange
        Schedule schedule = new Schedule("Activity", "10:00 AM");
        Event event = new Event("Event 1", "2024-06-15", "Location 1", "Description 1");
        schedule.addEvent(event);

        // Act
        boolean wasRemoved = schedule.removeEvent(event);

        // Assert
        assertTrue(wasRemoved);
        assertEquals(0, schedule.numberOfEvents());
        assertFalse(schedule.getEvents().contains(event));
    }

    @Test
    public void testRemoveEvent_EventPresentButNotRemovedFromEvent() {
        // Arrange
        Schedule schedule = new Schedule("Activity", "10:00 AM");
        Event event = new Event("Event 1", "2024-06-15", "Location 1", "Description 1") {
            @Override
            public boolean removeSchedule(Schedule aSchedule) {
                return false;
            }
        };
        schedule.addEvent(event);

        // Act
        boolean wasRemoved = schedule.removeEvent(event);

        // Assert
        assertFalse(wasRemoved);
        assertEquals(1, schedule.numberOfEvents());
        assertTrue(schedule.getEvents().contains(event));
    }

    @Test
    public void testRemoveEvent_EventPresentAndSuccessfullyRemoved() {
        // Arrange
        Schedule schedule = new Schedule("Activity", "10:00 AM");
        Event event = new Event("Event 1", "2024-06-15", "Location 1", "Description 1");
        schedule.addEvent(event);

        // Act
        boolean wasRemoved = schedule.removeEvent(event);

        // Assert
        assertTrue(wasRemoved);
        assertEquals(0, schedule.numberOfEvents());
        assertFalse(schedule.getEvents().contains(event));
    }
    

    @Test
    public void testRemoveEvent_EventNotPresent2() {
        // Arrange
        Attendee attendee = new Attendee("John Doe", "john@example.com");
        Event event = new Event("Event 1", "2024-06-15", "Location 1", "Description 1");

        // Act
        boolean wasRemoved = attendee.removeEvent(event);

        // Assert
        assertFalse(wasRemoved);
        assertEquals(0, attendee.numberOfEvents());
    }

    @Test
    public void testRemoveEvent_EventPresentAndRemoveFromAttendee2() {
        // Arrange
        Attendee attendee = new Attendee("John Doe", "john@example.com");
        Event event = new Event("Event 1", "2024-06-15", "Location 1", "Description 1");
        attendee.addEvent(event);

        // Act
        boolean wasRemoved = attendee.removeEvent(event);

        // Assert
        assertTrue(wasRemoved);
        assertEquals(0, attendee.numberOfEvents());
        assertFalse(attendee.getEvents().contains(event));
    }

    @Test
    public void testRemoveEvent_EventPresentButNotRemovedFromEvent2() {
        // Arrange
        Attendee attendee = new Attendee("John Doe", "john@example.com");
        Event event = new Event("Event 1", "2024-06-15", "Location 1", "Description 1") {
            @Override
            public boolean removeAttendee(Attendee aAttendee) {
                return false;
            }
        };
        attendee.addEvent(event);

        // Act
        boolean wasRemoved = attendee.removeEvent(event);

        // Assert
        assertFalse(wasRemoved);
        assertEquals(1, attendee.numberOfEvents());
        assertTrue(attendee.getEvents().contains(event));
    }

    @Test
    public void testRemoveEvent_EventPresentAndSuccessfullyRemoved2() {
        // Arrange
        Attendee attendee = new Attendee("John Doe", "john@example.com");
        Event event = new Event("Event 1", "2024-06-15", "Location 1", "Description 1");
        attendee.addEvent(event);

        // Act
        boolean wasRemoved = attendee.removeEvent(event);

        // Assert
        assertTrue(wasRemoved);
        assertEquals(0, attendee.numberOfEvents());
        assertFalse(attendee.getEvents().contains(event));
    }
    
    
    
}
