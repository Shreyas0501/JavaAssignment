package assignment.controller;

public class CustomException extends RuntimeException {
  public CustomException(final String message) {
    super(message);
  }
}