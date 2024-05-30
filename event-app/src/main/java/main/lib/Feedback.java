/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/

/**
 * @file Feedback.java
 * @brief This file contains the Feedback class which is used to create a feedback for an event.
 *@details This file contains the Feedback class which is used to create a feedback for an event. It contains the attendee name, comments, and rating of the feedback.
 */
/**
 * @package main.lib
 * @brief Package main.lib contains the classes for the event application.
 */
package main.lib;

// line 22 "../../umple-script.ump"
/**
 * @class Feedback
 * @brief The Feedback class is used to create a feedback for an event.
 * @details The Feedback class is used to create a feedback for an event. It contains the attendee name, comments, and rating of the feedback.
 * @author eray.cepni,eren.sisman
 */
public class Feedback
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Feedback Attributes
	/**
	 * @brief The name of the attendee.
	 */
  private String attendeeName;
	/**
	 * @brief The comments of the feedback.
	 */
  private String comments;
	/**
	 * @brief The rating of the feedback.
	 */
  private int rating;

  //------------------------
  // CONSTRUCTOR
  //------------------------
  /**
   * @brief This constructor creates an feedback.
   * @details This constructor creates an event with the given parameters.
   * @param aAttendeeName
   * @param aComments
   * @param aRating
   */
  public Feedback(String aAttendeeName, String aComments, int aRating)
  {
    attendeeName = aAttendeeName;
    comments = aComments;
    rating = aRating;
  }

  //------------------------
  // INTERFACE
  //------------------------

  /**
   * @brief This method sets the name of the attendee.
   * @param aAttendeeName
   * @return wasSet
   */
  public boolean setAttendeeName(String aAttendeeName)
  {
    boolean wasSet = false;
    attendeeName = aAttendeeName;
    wasSet = true;
    return wasSet;
  }

  /**
   * @brief This method sets the comments.
   * @param aComments
   * @return wasSet True if the comments was set, false otherwise.
   */
  public boolean setComments(String aComments)
  {
    boolean wasSet = false;
    comments = aComments;
    wasSet = true;
    return wasSet;
  }

  /**
   * @brief This method sets the rating for this feedback.
   * @param aRating The rating to be set.
   * @return wasSet True if the rating was set successfully.
   */
  public boolean setRating(int aRating)
  {
    boolean wasSet = false;
    rating = aRating;
    wasSet = true;
    return wasSet;
  }
  /**
   * @brief Gets the name of the attendee who provided this feedback.
   * @return attendeeName The name of the attendee.
   */
  public String getAttendeeName()
  {
    return attendeeName;
  }
  /**
   * @brief Gets the comments provided by the attendee.
   * @return comments The comments from the attendee.
   */
  public String getComments()
  {
    return comments;
  }
  /**
   * @brief Gets the rating provided by the attendee.
   * @return rating The rating given by the attendee.
   */
  public int getRating()
  {
    return rating;
  }
}