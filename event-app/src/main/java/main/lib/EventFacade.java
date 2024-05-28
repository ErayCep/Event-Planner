package main.lib;

import java.util.List;

public class EventFacade {
    private static EventFacade instance;

    private EventDAO eventDAO;
    private AttendeeDAO attendeeDAO;
    private ScheduleDAO scheduleDAO;
    private FeedbackDAO feedbackDAO;

    private EventFacade() {
        eventDAO = new EventDAO();
        attendeeDAO = new AttendeeDAO();
        scheduleDAO = new ScheduleDAO();
        feedbackDAO = new FeedbackDAO();
    }

    public static EventFacade getInstance() {
        if (instance == null) {
            instance = new EventFacade();
        }
        return instance;
    }

    public void createEvent(Event event) {
        eventDAO.createEvent(event);
    }

    public void registerAttendee(Attendee attendee) {
        attendeeDAO.registerAttendee(attendee);
    }

    public void planSchedule(Schedule schedule) {
        scheduleDAO.planSchedule(schedule);
    }

    public void collectFeedback(Feedback feedback) {
        feedbackDAO.collectFeedback(feedback);
    }
    public List<Event> getAllEvents() { // Eklendi
        return eventDAO.getAllEvents(); // Eklendi
    }
    
    public List<Schedule> getAllSchedules() { // Eklendi
        return scheduleDAO.getAllSchedules(); // Eklendi
    }
}
