package assignment.controller;

/**
 * A custom runtime exception used to handle specific errors related to user validation.
 */
public class CustomException extends RuntimeException {

  /**
   * Constructs a new CustomException with the specified detail message.
   *
   * @param message the detail message.
   */
  public CustomException(final String message) {
    super(message);
  }
}