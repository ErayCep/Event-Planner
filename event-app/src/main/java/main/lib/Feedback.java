/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/

package main.lib;

// line 22 "../../umple-script.ump"
public class Feedback
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Feedback Attributes
  private String attendeeName;
  private String comments;
  private int rating;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Feedback(String aAttendeeName, String aComments, int aRating)
  {
    attendeeName = aAttendeeName;
    comments = aComments;
    rating = aRating;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAttendeeName(String aAttendeeName)
  {
    boolean wasSet = false;
    attendeeName = aAttendeeName;
    wasSet = true;
    return wasSet;
  }

  public boolean setComments(String aComments)
  {
    boolean wasSet = false;
    comments = aComments;
    wasSet = true;
    return wasSet;
  }

  public boolean setRating(int aRating)
  {
    boolean wasSet = false;
    rating = aRating;
    wasSet = true;
    return wasSet;
  }

  public String getAttendeeName()
  {
    return attendeeName;
  }

  public String getComments()
  {
    return comments;
  }

  public int getRating()
  {
    return rating;
  }
}