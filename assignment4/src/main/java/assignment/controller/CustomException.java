package assignment.controller;


/**
 * Custom exception class to handle specific error cases in the application.
 * Extends {@link RuntimeException} to allow for unchecked exceptions.
 */
public class CustomException extends RuntimeException {

  /**
   * Constructs a new CustomException with the specified detail message.
   *
   * @param message the detail message
   */
  public CustomException(final String message) {
    super(message);
  }
}