/**

@file event.java
@brief This file serves as a demonstration file for the Calculator class.
@details This file contains the implementation of the Calculator class, which provides various mathematical operations.
*/

/**

@package com.ucoruh.calculator
@brief The com.ucoruh.calculator package contains all the classes and files related to the Calculator App.
*/
package com.ucoruh.event;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
/**

@class Event
@brief This class represents a Event that performs mathematical operations.
@details The Event class provides methods to perform . It also supports logging functionality using the logger object.
@author eray.cepni
*/
public class Event {

  /**
   * @brief Logger for the Event class.
   */
  private static final Logger logger = (Logger) LoggerFactory.getLogger(Event.class);

  /**
   * @brief Calculates the sum of two integers.
   *
   * @details This function takes two integer values, `a` and `b`, and returns their sum. It also logs a message using the logger object.
   *
   * @param a The first integer value.
   * @param b The second integer value.
   * @return The sum of `a` and `b`.
   */
  public int add(int a, int b) {
    // Logging an informational message
    logger.info("Logging message");
    // Logging an error message
    logger.error("Error message");
    // Returning the sum of `a` and `b`
    return a + b;
  }
}
