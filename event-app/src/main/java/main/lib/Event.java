/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/

package main.lib;
import java.util.*;


// line 3 "../../umple-script.ump"
public class Event
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Event Attributes
  private String name;
  private String date;
  private String location;
  private String description;

  //Event Associations
  private List<Attendee> attendees;
  private List<Schedule> schedules;
  private List<Observer> observers;
  //------------------------
  // CONSTRUCTOR
  //------------------------

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

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setDate(String aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setLocation(String aLocation)
  {
    boolean wasSet = false;
    location = aLocation;
    wasSet = true;
    return wasSet;
  }

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getDate()
  {
    return date;
  }

  public String getLocation()
  {
    return location;
  }

  public String getDescription()
  {
    return description;
  }
  /* Code from template association_GetMany */
  public Attendee getAttendee(int index)
  {
    Attendee aAttendee = attendees.get(index);
    return aAttendee;
  }

  public List<Attendee> getAttendees()
  {
    List<Attendee> newAttendees = Collections.unmodifiableList(attendees);
    return newAttendees;
  }

  public int numberOfAttendees()
  {
    int number = attendees.size();
    return number;
  }

  public boolean hasAttendees()
  {
    boolean has = attendees.size() > 0;
    return has;
  }

  public int indexOfAttendee(Attendee aAttendee)
  {
    int index = attendees.indexOf(aAttendee);
    return index;
  }
  /* Code from template association_GetMany */
  public Schedule getSchedule(int index)
  {
    Schedule aSchedule = schedules.get(index);
    return aSchedule;
  }

  public List<Schedule> getSchedules()
  {
    List<Schedule> newSchedules = Collections.unmodifiableList(schedules);
    return newSchedules;
  }

  public int numberOfSchedules()
  {
    int number = schedules.size();
    return number;
  }

  public boolean hasSchedules()
  {
    boolean has = schedules.size() > 0;
    return has;
  }

  public int indexOfSchedule(Schedule aSchedule)
  {
    int index = schedules.indexOf(aSchedule);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAttendees()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  //------------------------------------------------------asagi---
  public boolean addAttendee(Attendee aAttendee)
  {
	    if (attendees.contains(aAttendee)) { return false; }
	    attendees.add(aAttendee);
	    addObserver(aAttendee);
	    return true;
  }

  public void addObserver(Observer observer) {
	    observers.add(observer);
	  }

	  public void removeObserver(Observer observer) {
	    observers.remove(observer);
	  }

	  public void notifyObservers(String message) {
	    for (Observer observer : observers) {
	      observer.update(message);
	    }
  }
	  
  public void updateEventDetails(String details) {
	    this.description = details;
	    notifyObservers("Event details updated: " + details);
	  }
  //------------------------------------------yukari-------------------
  /* Code from template association_RemoveMany */
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
  public static int minimumNumberOfSchedules()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  //asagi-----------------------------------
  public boolean addSchedule(Schedule aSchedule)
  {
    if (schedules.contains(aSchedule)) { return false; }
    schedules.add(aSchedule);
    return true;

  }
  //-----------------------------------------yukari
  /* Code from template association_RemoveMany */
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


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "date" + ":" + getDate()+ "," +
            "location" + ":" + getLocation()+ "," +
            "description" + ":" + getDescription()+ "]";
  }
}