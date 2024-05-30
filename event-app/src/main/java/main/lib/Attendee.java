/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/
/**
 * @file Attendee.java
 * @brief This file contains the Attendee class which is used to create an attendee for an event.
 *@details This file contains the Attendee class which is used to create an attendee for an event. It contains the name and email of the attendee and the list of events associated with the attendee.
 */
/**
 * @package main.lib
 * @brief Package main.lib contains the classes for the event application.
 */
package main.lib;
import java.util.*;

// line 12 "../../umple-script.ump"
/**
 * @class Attendee
 * @brief The Attendee class is used to create an attendee for an event.
 * @details The Attendee class is used to create an attendee for an event. It contains the name and email of the attendee and the list of events associated with the attendee.
 * @author eray.cepni,eren.sisman
 */
public class Attendee implements Observer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Attendee Attributes
	/**
	 * @brief The name of the attendee.
	 */
  private String name;
	/**
	 * @brief The email of the attendee.
	 */
  private String email;

  //Attendee Associations
	/**
	 * @brief The list of events associated with the attendee.
	 */
  private List<Event> events;

  //------------------------
  // CONSTRUCTOR
  //------------------------
	/**
	 * @brief This constructor creates an attendee with the given name and email.
	 * @details This constructor creates an attendee with the given name and email. It initializes the list of events associated with the attendee.
	 * @param aName
	 * @param aEmail
	 */
  public Attendee(String aName, String aEmail)
  {
    name = aName;
    email = aEmail;
    events = new ArrayList<Event>();
  }

  //------------------------
  // INTERFACE
  //------------------------
	/**
	 * @brief This method updates the attendee with the given message.
	 * @details This method updates the attendee with the given message.
	 * @param message
	 */
  @Override
  public void update(String message) {
      System.out.println("Notification to " + name + ": " + message);
  }

	/**
	 * @brief This method sets the name of the attendee.
	 * @details This method sets the name of the attendee.
	 * @param aName The name of the attendee.
	 * @return wasSet True if the name was set, false otherwise.
	 */
  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

	/**
	 * @brief This method sets the email of the attendee.
	 * @details This method sets the email of the attendee.
	 * @param aEmail The email of the attendee.
	 * @return wasSet True if the email was set, false otherwise.
	 */
  public boolean setEmail(String aEmail)
  {
    boolean wasSet = false;
    email = aEmail;
    wasSet = true;
    return wasSet;
  }

	/**
	 * @brief This method gets the name of the attendee.
	 * @details This method gets the name of the attendee.
	 * @return name The name of the attendee.
	 */
  public String getName()
  {
    return name;
  }

	/**
	 * @brief This method gets the email of the attendee.
	 * @details This method gets the email of the attendee.
	 * @return email The email of the attendee.
	 */
  public String getEmail()
  {
    return email;
  }
  /* Code from template association_GetMany */
	/**
	 * @brief This method gets the event at the given index.
	 * @details This method gets the event at the given index.
	 * @param index The index of the event.
	 * @return aEvent The event at the given index.
	 */
  public Event getEvent(int index)
  {
    Event aEvent = events.get(index);
    return aEvent;
  }

	/**
	 * @brief This method returns the list of events associated with the attendee.
	 * @details This method returns the list of events associated with the attendee.
	 * @return newEvents The list of events associated with the attendee.
	 */
  public List<Event> getEvents()
  {
    List<Event> newEvents = Collections.unmodifiableList(events);
    return newEvents;
  }

	/**
	 * @brief This method returns the number of events associated with the attendee.
	 * @details This method returns the number of events associated with the attendee.
	 * @return number The number of events associated with the attendee.
	 */
  public int numberOfEvents()
  {
    int number = events.size();
    return number;
  }

	/**
	 * @brief This method checks if the attendee has events.
	 * @details This method checks if the attendee has events.
	 * @return has True if the attendee has events, false otherwise.
	 */
  public boolean hasEvents()
  {
    boolean has = events.size() > 0;
    return has;
  }

	/**
	 * @brief This method returns the index of the given event.
	 * @details This method returns the index of the given event.
	 * @param aEvent The event to find the index of.
	 * @return index The index of the given event.
	 */
  public int indexOfEvent(Event aEvent)
  {
    int index = events.indexOf(aEvent);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
	/**
	 * @brief This method returns the minimum number of events.
	 * @details This method returns the minimum number of events.
	 * @return 0 The minimum number of events.
	 */
  public static int minimumNumberOfEvents()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
	/**
	 * @brief This method adds an event to the list of events associated with the attendee.
	 * @details This method adds an event to the list of events associated with the attendee.
	 * @param aEvent The event to be added.
	 * @return wasAdded True if the event was added, false otherwise.
	 */
  public boolean addEvent(Event aEvent)
  {
    boolean wasAdded = false;
    if (events.contains(aEvent)) { return false; }
    events.add(aEvent);
    if (aEvent.indexOfAttendee(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aEvent.addAttendee(this);
      if (!wasAdded)
      {
        events.remove(aEvent);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
	/**
	 * @brief This method removes the given event from the list of events associated with the attendee.
	 * @details This method removes the given event from the list of events associated with the attendee.
	 * @param aEvent The event to be removed.
	 * @return wasRemoved True if the event was removed, false otherwise.
	 */
  public boolean removeEvent(Event aEvent)
  {
    boolean wasRemoved = false;
    if (!events.contains(aEvent))
    {
      return wasRemoved;
    }

    int oldIndex = events.indexOf(aEvent);
    events.remove(oldIndex);
    if (aEvent.indexOfAttendee(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aEvent.removeAttendee(this);
      if (!wasRemoved)
      {
        events.add(oldIndex,aEvent);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
	/**
	 * @brief This method adds the given event to the list of events associated with
	 *        the attendee at the given index.
	 * @details This method adds the given event to the list of events associated
	 *          with the attendee at the given index.
	 * @param aEvent The event to be added.
	 * @param index  The index to add the event at.
	 * @return wasAdded True if the event was added, false otherwise.
	 */
  public boolean addEventAt(Event aEvent, int index)
  {  
    boolean wasAdded = false;
    if(addEvent(aEvent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEvents()) { index = numberOfEvents() - 1; }
      events.remove(aEvent);
      events.add(index, aEvent);
      wasAdded = true;
    }
    return wasAdded;
  }

}