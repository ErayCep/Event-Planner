/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/

package main.lib;
import java.util.*;

// line 17 "../../umple-script.ump"
public class Schedule
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Schedule Attributes
  private String activity;
  private String time;

  //Schedule Associations
  private List<Event> events;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Schedule(String aActivity, String aTime)
  {
    activity = aActivity;
    time = aTime;
    events = new ArrayList<Event>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setActivity(String aActivity)
  {
    boolean wasSet = false;
    activity = aActivity;
    wasSet = true;
    return wasSet;
  }

  public boolean setTime(String aTime)
  {
    boolean wasSet = false;
    time = aTime;
    wasSet = true;
    return wasSet;
  }

  public String getActivity()
  {
    return activity;
  }

  public String getTime()
  {
    return time;
  }
  /* Code from template association_GetMany */
  public Event getEvent(int index)
  {
    Event aEvent = events.get(index);
    return aEvent;
  }

  public List<Event> getEvents()
  {
    List<Event> newEvents = Collections.unmodifiableList(events);
    return newEvents;
  }

  public int numberOfEvents()
  {
    int number = events.size();
    return number;
  }

  public boolean hasEvents()
  {
    boolean has = events.size() > 0;
    return has;
  }

  public int indexOfEvent(Event aEvent)
  {
    int index = events.indexOf(aEvent);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfEvents()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
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
  /* Code from template association_AddIndexControlFunctions */
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

  public boolean addOrMoveEventAt(Event aEvent, int index)
  {
    boolean wasAdded = false;
    if(events.contains(aEvent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEvents()) { index = numberOfEvents() - 1; }
      events.remove(aEvent);
      events.add(index, aEvent);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addEventAt(aEvent, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Event> copyOfEvents = new ArrayList<Event>(events);
    events.clear();
    for(Event aEvent : copyOfEvents)
    {
      aEvent.removeSchedule(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "activity" + ":" + getActivity()+ "," +
            "time" + ":" + getTime()+ "]";
  }
}