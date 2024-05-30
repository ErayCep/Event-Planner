/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/

/**
 * @file Schedule.java
 * @brief This file contains the Schedule class which is used to create a schedule for an event.
 *@details This file contains the Schedule class which is used to create a schedule for an event. It contains the activity and time of the event and the list of events associated with the schedule.
 */

/**
 * @package main.lib
 * @brief Package main.lib contains the classes for the event application.
 */
package main.lib;
import java.util.*;

/**
 * @class Schedule
 * @brief The Schedule class is used to create a schedule for an event.
 * @details The Schedule class is used to create a schedule for an event. It contains the activity and time of the event and the list of events associated with the schedule.
 * @author eray.cepni, eren.sisman
 */
public class Schedule
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Schedule Attributes
	/**
	 * @brief The activity of the event.
	 */
  private String activity;
	/**
	 * @brief The time of the event.
	 */
  private String time;

  //Schedule Associations
	/**
	 * @brief The list of events associated with the schedule.
	 */
  private List<Event> events;

  //------------------------
  // CONSTRUCTOR
  //------------------------
   /**
    * @brief This constructor creates a schedule with the given activity and time.
    * @details This constructor creates a schedule with the given activity and time. It initializes the list of events associated with the schedule.
    * @param aActivity
    * @param aTime
    */
  public Schedule(String aActivity, String aTime)
  {
    activity = aActivity;
    time = aTime;
    events = new ArrayList<Event>();
  }

  //------------------------
  // INTERFACE
  //------------------------

	/**
	 * @brief This method sets the activity of the event.
	 * @details This method sets the activity of the event.
	 * @param aActivity The activity of the event.
	 * @return wasSet True if the activity was set, false otherwise.
	 */
  public boolean setActivity(String aActivity)
  {
    boolean wasSet = false;
    activity = aActivity;
    wasSet = true;
    return wasSet;
  }

	/**
	 * @brief This method sets the time of the event.
	 * @details This method sets the time of the event.
	 * @param aTime The time of the event.
	 * @return wasSet True if the time was set, false otherwise.
	 */
  public boolean setTime(String aTime)
  {
    boolean wasSet = false;
    time = aTime;
    wasSet = true;
    return wasSet;
  }

	/**
	 * @brief This method returns the activity of the event.
	 * @details This method returns the activity of the event.
	 * @return activity The activity of the event.
	 */
  public String getActivity()
  {
    return activity;
  }

	/**
	 * @brief This method returns the time of the event.
	 * @details This method returns the time of the event.
	 * @return time The time of the event.
	 */
  public String getTime()
  {
    return time;
  }
  /* Code from template association_GetMany */
	/**
	 * @brief This method returns the event at the given index.
	 * @details This method returns the event at the given index.
	 * @param index The index of the event.
	 * @return aEvent The event at the given index.
	 */
  public Event getEvent(int index)
  {
    Event aEvent = events.get(index);
    return aEvent;
  }

	/**
	 * @brief This method returns the list of events associated with the schedule.
	 * @details This method returns the list of events associated with the schedule.
	 * @return newEvents The list of events associated with the schedule.
	 */
  public List<Event> getEvents()
  {
    List<Event> newEvents = Collections.unmodifiableList(events);
    return newEvents;
  }

	/**
	 * @brief This method returns the number of events associated with the schedule.
	 * @details This method returns the number of events associated with the schedule.
	 * @return number The number of events associated with the schedule.
	 */
  public int numberOfEvents()
  {
    int number = events.size();
    return number;
  }

	/**
	 * @brief This method checks if the schedule has any events.
	 * @details This method checks if the schedule has any events.
	 * @return has True if the schedule has events, false otherwise.
	 */
  public boolean hasEvents()
  {
    boolean has = events.size() > 0;
    return has;
  }

	/**
	 * @brief This method returns the index of the given event.
	 * @details This method returns the index of the given event.
	 * @param aEvent The event to be found.
	 * @return index The index of the event.
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
	 * @brief This method adds the given event to the list of events associated with the schedule.
	 * @details This method adds the given event to the list of events associated with the schedule.
	 * @param aEvent The event to be added.
	 * @return wasAdded True if the event was added, false otherwise.
	 */
  public boolean addEvent(Event aEvent)
  {
    boolean wasAdded = false;
    if (events.contains(aEvent)) { return false; }
    events.add(aEvent);
    if (aEvent.indexOfSchedule(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aEvent.addSchedule(this);
      if (!wasAdded)
      {
        events.remove(aEvent);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
	/**
	 * @brief This method removes the given event from the list of events associated with the schedule.
	 * @details This method removes the given event from the list of events associated with the schedule.
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
    if (aEvent.indexOfSchedule(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aEvent.removeSchedule(this);
      if (!wasRemoved)
      {
        events.add(oldIndex,aEvent);
      }
    }
    return wasRemoved;
  }

	/**
	 * @brief This method removes all events associated with the schedule.
	 * @details This method removes all events associated with the schedule.
	 */
  public void delete()
  {
    ArrayList<Event> copyOfEvents = new ArrayList<Event>(events);
    events.clear();
    for(Event aEvent : copyOfEvents)
    {
      aEvent.removeSchedule(this);
    }
  }
}