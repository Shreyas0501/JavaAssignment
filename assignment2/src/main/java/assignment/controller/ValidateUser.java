package assignment.controller;

import static assignment.config.Constants.MINIMUM_NUMBER_OF_COURSES;
import static assignment.config.Constants.VALID_COURSES;
import static assignment.config.SharedData.ROLL_NUMBER_TO_USER_MAP;

/**
 * Utility class for validating user details.
 * Provides static methods to validate various attributes of a user,
 * such as full name, age, roll number, address, and courses.
 */
public final class ValidateUser {

  // Private constructor to prevent instantiation
  private ValidateUser() {
    throw new UnsupportedOperationException("Utility class cannot be initialised.");
  }

  /**
   * Validates the user's full name.
   * @param fullName The user's full name.
   */
  public static void validateFullName(final String fullName) {
    if (fullName == null || fullName.isEmpty()) {
      throw new CustomException("User full name cannot be empty.");
    }
  }

  /**
   * Validates the user's age.
   * @param inputAge The user's age as a String.
   */
  public static void validateAge(final String inputAge) {
    final int age = Integer.parseInt(inputAge);
    if (age < 0) {
      throw new CustomException("Age should be a non-negative number.");
    }
  }

  /**
   * Validates the user's roll number.
   * @param rollNumber The user's roll number.
   */
  public static void validateRollNumber(final String rollNumber) {
    if (rollNumber == null || rollNumber.isEmpty()) {
      throw new CustomException("User roll number cannot be null or empty.");
    } else if (ROLL_NUMBER_TO_USER_MAP.containsKey(rollNumber)) {
      throw new CustomException("Duplicate roll number not allowed.");
    }
  }

  /**
   * Validates the user's address.
   * @param address The user's address.
   */
  public static void validateAddress(final String address) {
    if (address == null || address.isEmpty()) {
      throw new CustomException("User address cannot be null or empty.");
    }
  }

  /**
   * Validates the courses selected by the user.
   * @param courses The array of courses chosen by the user.
   */
  public static void validateCourses(final String... courses) {
    if (courses.length < MINIMUM_NUMBER_OF_COURSES) {
      throw new CustomException("At least 4 courses must be chosen.");
    }

    for (final String course : courses) {
      if (!VALID_COURSES.contains(course)) {
        throw new CustomException("Course " + course + " is invalid.");
      }
    }
  }
}
