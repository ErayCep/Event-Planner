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
    
    
    
    
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    @Test
    public void testEventPlannerGUIInitialization() {
        assertNotNull(eventPlannerGUI);
    }

   

    // Test EventPlannerGUI
    @Test
    public void testCreateAndShowGUI() {
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
