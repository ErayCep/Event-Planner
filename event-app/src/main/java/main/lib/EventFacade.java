/**
 * @file EventFacade.java
 * @brief This file contains the EventFacade class which is used to interact with the database for event related operations.
 * @details This file contains the EventFacade class which is used to interact with the database for event related operations. It contains the methods to create an event, register an attendee, plan a schedule, and collect feedback.
 */
/**
 * @package main.lib
 * @brief Package main.lib contains the classes for the event application.
 */
package main.lib;

import java.util.List;

/**
 * @class EventFacade
 * @brief The EventFacade class is used to interact with the database for event
 *        related operations.
 * @details The EventFacade class is used to interact with the database for event related operations. It contains the methods to create an event, register an attendee, plan a schedule, and collect feedback.
 * @author eray.cepni,eren.sisman
 */
public class EventFacade {
	/**
	 * @brief The instance of the EventFacade class.
	 */
    private static EventFacade instance;

	/**
	 * @brief The EventDAO object to interact with the database for event operations.
	 */
    private EventDAO eventDAO;
    /**
     * @brief The AttendeeDAO object to interact with the database for attendee
     */
    private AttendeeDAO attendeeDAO;
	/**
	 * @brief The ScheduleDAO object to interact with the database for schedule
	 */
    private ScheduleDAO scheduleDAO;
	/**
	 * @brief The FeedbackDAO object to interact with the database for feedback
	 */
    private FeedbackDAO feedbackDAO;

	/**
	 * @brief This constructor creates an EventFacade object and initializes the EventDAO, AttendeeDAO, ScheduleDAO, and FeedbackDAO objects.
	 */
    public EventFacade() {
        eventDAO = new EventDAO();
        attendeeDAO = new AttendeeDAO();
        scheduleDAO = new ScheduleDAO();
        feedbackDAO = new FeedbackDAO();
    }

	/**
	 * @brief This method returns the instance of the EventFacade class.
	 * @details This method returns the instance of the EventFacade class. If the instance is null, it creates a new instance.
	 * @return The instance of the EventFacade class.
	 */
    public static EventFacade getInstance() {
        if (instance == null) {
            instance = new EventFacade();
        }
        return instance;
    }

	/**
	 * @brief This method creates an event in the database.
	 * @details This method creates an event in the database by inserting the event's name, date, location, and description into the events table.
	 * @param event The event to be created.
	 */
    public void createEvent(Event event) {
        eventDAO.createEvent(event);
    }

	/**
	 * @brief This method registers an attendee in the database.
	 * @details This method registers an attendee in the database by inserting the attendee's name and email into the attendees table.
	 * @param attendee The attendee to be registered.
	 */
    public void registerAttendee(Attendee attendee) {
        attendeeDAO.registerAttendee(attendee);
    }

	/**
	 * @brief This method plans a schedule in the database.
	 * @details This method plans a schedule in the database by inserting the schedule's event, date, time, and location into the schedules table.
	 * @param schedule The schedule to be planned.
	 */
    public void planSchedule(Schedule schedule) {
        scheduleDAO.planSchedule(schedule);
    }

	/**
	 * @brief This method collects feedback in the database.
	 * @details This method collects feedback in the database by inserting the feedback's name, email, message, and rating into the feedbacks table.
	 * @param feedback The feedback to be collected.
	 */
    public void collectFeedback(Feedback feedback) {
        feedbackDAO.collectFeedback(feedback);
    }

	/**
	 * @brief This method returns all events from the database.
	 * @details This method returns all events from the database by querying the events table.
	 * @return The list of events.
	 */
    public List<Event> getAllEvents() { 
        return eventDAO.getAllEvents();
    }

	/**
	 * @brief This method returns all attendees from the database.
	 * @details This method returns all attendees from the database by querying the attendees table.
	 * @return The list of attendees.
	 */
    public List<Schedule> getAllSchedules() { 
        return scheduleDAO.getAllSchedules(); 
    }
}
