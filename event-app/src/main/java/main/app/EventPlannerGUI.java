package main.app;

import main.lib.EventFacade;
import main.lib.Event;
import main.lib.Attendee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventPlannerGUI {
    private EventFacade eventFacade;

    public EventPlannerGUI() {
        eventFacade = EventFacade.getInstance();
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Event Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JButton createEventButton = new JButton("Create Event");
        createEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Event event = new Event("Sample Event", "2024-05-30", "Sample Location", "Sample Description");
                eventFacade.createEvent(event);
                JOptionPane.showMessageDialog(frame, "Event Created!");
            }
        });

        JButton registerAttendeeButton = new JButton("Register Attendee");
        registerAttendeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Attendee attendee = new Attendee("John Doe", "john@example.com");
                eventFacade.registerAttendee(attendee);
                JOptionPane.showMessageDialog(frame, "Attendee Registered!");
            }
        });

        frame.getContentPane().add(createEventButton);
        frame.getContentPane().add(registerAttendeeButton);
        frame.setLayout(new java.awt.FlowLayout());
        frame.setVisible(true);
    }
}
