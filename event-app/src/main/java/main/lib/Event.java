/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


/**
 * @file Event.java
 * @brief This file contains the Event class which is used to create an event object.
 * @details This class contains the attributes and methods of the Event class.
 */


/**
 * @package main.lib
 * @brief The main.lib package contains the classes for the Event app.
 */
package main.lib;

import java.util.*;


/**
 * @class Event
 * @brief The Event class is used to create an event object.
 * @details This class contains the attributes and methods of the Event class and is used to create, update, delete etc. event objects.
 * @author eray.cepni,eren.sisman
 */
public class Event
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Event Attributes
  /**
  * @brief The name of the event.
  */
  private String name;
  /**
  * @brief The date of the event.
  */
  private String date;
  /**
  * @brief The location of the event.
  */
  private String location;
  /**
  * @brief The description of the event.
  */
  private String description;

  //Event Associations
  /**
   * @brief The list of attendees of the event.
   */
  private List<Attendee> attendees;
  /**
  * @brief The list of schedules of the event.
  */
  private List<Schedule> schedules;
  /**
   * @brief The list of observers of the event.
   */
  private List<Observer> observers;
  
  
  //------------------------
  // CONSTRUCTOR
  //------------------------

	/**
	 * @brief This is the constructor of the Event class.
	 * @details This constructor creates an event object with the given parameters.
	 * @param aName        The name of the event.
	 * @param aDate        The date of the event.
	 * @param aLocation    The location of the event.
	 * @param aDescription The description of the event.
	 */
  public Event(String aName, String aDate, String aLocation, String aDescription)
  {
    name = aName;
    date = aDate;
    location = aLocation;
    description = aDescription;
    attendees = new ArrayList<Attendee>();
    schedules = new ArrayList<Schedule>();
    observers = new ArrayList<>();
  }

  //------------------------
  // INTERFACE
  //------------------------

	/**
	 * @brief This method updates the event details.
	 * @details This method updates the description of the event and notifies the observers.
	 * @param details The new description of the event.
	 * @return wasSet
	 */
  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

      /**
       * @brief This method sets the date of the event.
       * @param aDate
       * @return
       */
  public boolean setDate(String aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

	/**
	 * @brief This method sets the location of the event.
	 * @param aLocation
	 * @return wasSet, a boolean value.
	 */
  public boolean setLocation(String aLocation)
  {
    boolean wasSet = false;
    location = aLocation;
    wasSet = true;
    return wasSet;
  }

      /**
       * @brief This method sets the description of the event.
       * @param aDescription
       * @return wasset is a boolean value for the success of the operation.
       */
  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

      /**
       * @brrief This method returns the name of the event.
       * @return name, a string value.
       */
  public String getName()
  {
    return name;
  }

	/**
	 * @brief This method returns the date of the event.
	 * @return date, a string value.
	 */
  public String getDate()
  {
    return date;
  }

	/**
	 * @brief This method returns the location of the event.
	 * @return location, a string value.
	 */
  public String getLocation()
  {
    return location;
  }

	/**
	 * @brief This method returns the description of the event.
	 * @return description, a string value.
	 */
  public String getDescription()
  {
    return description;
  }
  
  /* Code from template association_GetMany */
	/**
	 * @brief This method returns the attendee at the given index.
	 * @param index
	 * @return aAttendee, an Attendee object.
	 */
  public Attendee getAttendee(int index)
  {
    Attendee aAttendee = attendees.get(index);
    return aAttendee;
  }

	/**
	 * @brief This method returns the list of attendees of the event.
	 * @return newAttendees, a list of Attendee objects.
	 */
  public List<Attendee> getAttendees()
  {
    List<Attendee> newAttendees = Collections.unmodifiableList(attendees);
    return newAttendees;
  }

	/**
	 * @brief This method returns the number of attendees of the event.
	 * @return number, an integer value.
	 */
  public int numberOfAttendees()
  {
    int number = attendees.size();
    return number;
  }

	/**
	 * @brief This method checks if the event has attendees.
	 * @return has, a boolean value for the existence of attendees.
	 */
  public boolean hasAttendees()
  {
    boolean has = attendees.size() > 0;
    return has;
  }
  
	/**
	 * @brief This method returns the index of the given attendee.
	 * @param aAttendee
	 * @return index of attendee.
	 */
  public int indexOfAttendee(Attendee aAttendee)
  {
    int index = attendees.indexOf(aAttendee);
    return index;
  }
  
  /* Code from template association_GetMany */
	/**
	 * @brief This method returns the schedule at the given index.
	 * @param index
	 * @return aSchedule, a Schedule object.
	 */
  public Schedule getSchedule(int index)
  {
    Schedule aSchedule = schedules.get(index);
    return aSchedule;
  }

	/**
	 * @brief This method returns the list of schedules of the event.
	 * @return newSchedules, a list of Schedule objects.
	 */
  public List<Schedule> getSchedules()
  {
    List<Schedule> newSchedules = Collections.unmodifiableList(schedules);
    return newSchedules;
  }

	/**
	 * @brief This method returns the number of schedules of the event.
	 * @return number, an integer value.
	 */
  public int numberOfSchedules()
  {
    int number = schedules.size();
    return number;
  }

	/**
	 * @brief This method checks if the event has schedules.
	 * @return has, a boolean value for the existence of schedules.
	 */
  public boolean hasSchedules()
  {
    boolean has = schedules.size() > 0;
    return has;
  }

	/**
	 * @brief This method returns the index of the given schedule.
	 * @param aSchedule
	 * @return index of schedule.
	 */
  public int indexOfSchedule(Schedule aSchedule)
  {
    int index = schedules.indexOf(aSchedule);
    return index;
  }
  
  /* Code from template association_MinimumNumberOfMethod */
	/**
	 * @brief This method returns the minimum number of attendees.
	 * @return 0, an integer value. for the minimum number of attendees.
	 */
  public static int minimumNumberOfAttendees()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
	/**
	 * @brief This method adds the given attendee to the list of attendees.
	 * @param aAttendee
	 * @return wasAdded, a boolean value for the success of the operation.
	 */
  public boolean addAttendee(Attendee aAttendee)
  {
	    if (attendees.contains(aAttendee)) { return false; }
	    attendees.add(aAttendee);
	    addObserver(aAttendee);
	    return true;
  }

	/**
	 * @brief This method adds the given observer to the list of observers.
	 * @param observer
	 */
  public void addObserver(Observer observer) {
	    observers.add(observer);
	  }

		/**
		 * @brief This method removes the given observer from the list of observers.
		 * @param observer
		 */
  public void removeObserver(Observer observer) {
	    observers.remove(observer);
	  }

		/**
		 * @brief This method notifies the observers with the given message.
		 * @param message
		 */
  public void notifyObservers(String message) {
	    for (Observer observer : observers) {
	      observer.update(message);
	    }
  }

	/**
	 * @brief This method returns the list of observers of the event.
	 * @return observers, a list of Observer objects.
	 */
  public List<Observer> getObservers() {
		    return observers;
		}

		/**
		 * @brief This method adds the given schedule to the list of schedules.
		 * @param aSchedule
		 * @return wasAdded, a boolean value for the success of the operation.
		 */
  public void updateEventDetails(String details) {
	    this.description = details;
	    notifyObservers("Event details updated: " + details);
	  }

  /* Code from template association_RemoveMany */
	/**
	 * @brief This method removes the given attendee from the list of attendees.
	 * @param aAttendee
	 * @return wasRemoved, a boolean value for the success of the operation.
	 */
  public boolean removeAttendee(Attendee aAttendee)
  {
    boolean wasRemoved = false;
    if (!attendees.contains(aAttendee))
    {
      return wasRemoved;
    }

    int oldIndex = attendees.indexOf(aAttendee);
    attendees.remove(oldIndex);
    if (aAttendee.indexOfEvent(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aAttendee.removeEvent(this);
      if (!wasRemoved)
      {
        attendees.add(oldIndex,aAttendee);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
	/**
	 * @brief This method adds the given attendee to the list of attendees at the
	 *        given index.
	 * @param aAttendee
	 * @param index
	 * @return wasAdded, a boolean value for the success of the operation.
	 */
  public boolean addAttendeeAt(Attendee aAttendee, int index)
  {  
    boolean wasAdded = false;
    if(addAttendee(aAttendee))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAttendees()) { index = numberOfAttendees() - 1; }
      attendees.remove(aAttendee);
      attendees.add(index, aAttendee);
      wasAdded = true;
    }
    return wasAdded;
  }

	/**
	 * @brief This method adds the given attendee to the list of attendees at the
	 *        given index.
	 * @param aAttendee
	 * @param index
	 * @return wasAdded, a boolean value for the success of the operation.
	 */
  public boolean addOrMoveAttendeeAt(Attendee aAttendee, int index)
  {
    boolean wasAdded = false;
    if(attendees.contains(aAttendee))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAttendees()) { index = numberOfAttendees() - 1; }
      attendees.remove(aAttendee);
      attendees.add(index, aAttendee);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAttendeeAt(aAttendee, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
	/**
	 * @brief This method returns the minimum number of schedules.
	 * @return 0, an integer value. for the minimum number of schedules.
	 */
  public static int minimumNumberOfSchedules()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
	/**
	 * @brief This method adds the given schedule to the list of schedules.
	 * @param aSchedule
	 * @return wasAdded, a boolean value for the success of the operation.
	 */
  public boolean addSchedule(Schedule aSchedule)
  {
    if (schedules.contains(aSchedule)) { return false; }
    schedules.add(aSchedule);
    return true;

  }

  /* Code from template association_RemoveMany */
	/**
	 * @brief This method removes the given schedule from the list of schedules.
	 * @param aSchedule
	 * @return wasRemoved, a boolean value for the success of the operation.
	 */
  public boolean removeSchedule(Schedule aSchedule)
  {
    boolean wasRemoved = false;
    if (!schedules.contains(aSchedule))
    {
      return wasRemoved;
    }

    int oldIndex = schedules.indexOf(aSchedule);
    schedules.remove(oldIndex);
    if (aSchedule.indexOfEvent(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aSchedule.removeEvent(this);
      if (!wasRemoved)
      {
        schedules.add(oldIndex,aSchedule);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
	/**
	 * @brief This method adds the given schedule to the list of schedules at the
	 *        given index.
	 * @param aSchedule
	 * @param index
	 * @return wasAdded, a boolean value for the success of the operation.
	 */
  public boolean addScheduleAt(Schedule aSchedule, int index)
  {  
    boolean wasAdded = false;
    if(addSchedule(aSchedule))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSchedules()) { index = numberOfSchedules() - 1; }
      schedules.remove(aSchedule);
      schedules.add(index, aSchedule);
      wasAdded = true;
    }
    return wasAdded;
  }

	/**
	 * @brief This method adds the given schedule to the list of schedules at the
	 *        given index.
	 * @param aSchedule
	 * @param index
	 * @return wasAdded, a boolean value for the success of the operation.
	 */
  public boolean addOrMoveScheduleAt(Schedule aSchedule, int index)
  {
    boolean wasAdded = false;
    if(schedules.contains(aSchedule))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSchedules()) { index = numberOfSchedules() - 1; }
      schedules.remove(aSchedule);
      schedules.add(index, aSchedule);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addScheduleAt(aSchedule, index);
    }
    return wasAdded;
  }
    /* Code from template association_SetOneToMany */
	/**
	 * @brief This method sets the attendees of the event.
	 * @param newAttendees
	 * @return wasSet, a boolean value for the success of the operation.
	 */
  public void delete()
  {
    ArrayList<Attendee> copyOfAttendees = new ArrayList<Attendee>(attendees);
    attendees.clear();
    for(Attendee aAttendee : copyOfAttendees)
    {
      aAttendee.removeEvent(this);
    }
    ArrayList<Schedule> copyOfSchedules = new ArrayList<Schedule>(schedules);
    schedules.clear();
    for(Schedule aSchedule : copyOfSchedules)
    {
      aSchedule.removeEvent(this);
    }
  }


}